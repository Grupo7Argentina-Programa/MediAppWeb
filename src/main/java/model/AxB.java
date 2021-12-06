package model;

import java.util.ArrayList;

public class AxB extends Promocion {

	public AxB(String nombreDePromo, Atraccion a, Atraccion b, Atraccion c, Atraccion d) throws NombreInvalido, TipoDeAtraccionDistinta {

		boolean tiposDistintos = a.getTipo() != b.getTipo()
				|| b.getTipo() != c.getTipo() || c.getTipo() != d.getTipo();


			if (nombreDePromo == "") {
				throw new NombreInvalido();
			}

			if (tiposDistintos) {
				throw new TipoDeAtraccionDistinta();
			}

			this.nombreDePromocion = nombreDePromo;
			this.tiposDeAtracciones = a.getTipo();
			this.costo = a.getCosto() + b.getCosto() + c.getCosto();
			this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario() + c.getTiempoNecesario()
					+ d.getTiempoNecesario();
			this.atraccion1 = a;
			this.atraccion2 = b;
			this.atraccion3 = c;
			this.atraccion4 = d;
			this.cantidadDeAtracciones = 4;
	}

	public AxB(String nombreDePromo, Atraccion a, Atraccion b, Atraccion c) throws NombreInvalido, TipoDeAtraccionDistinta {
		boolean tiposDistintos = a.getTipo() != b.getTipo()
				|| b.getTipo() != c.getTipo();

			if (nombreDePromo == "") {
				throw new NombreInvalido();
			}

			if (tiposDistintos) {
				throw new TipoDeAtraccionDistinta();
			}

			this.nombreDePromocion = nombreDePromo;
			this.tiposDeAtracciones = a.getTipo();
			this.costo = a.getCosto() + b.getCosto();
			this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario() + c.getTiempoNecesario();
			this.atraccion1 = a;
			this.atraccion2 = b;
			this.atraccion3 = c;
			this.cantidadDeAtracciones = 3;

	}

	@Override
	public void aceptoMostrable(Usuario comprador) {
		comprador.aceptarPromocion(this);
		promocionDAO.update(this);
	}
	
	@Override
	public Integer getCupo() {
		ArrayList<Integer> cupos = new ArrayList<Integer>();
		cupos.add(atraccion1.getCupo());
		cupos.add(atraccion2.getCupo());
		cupos.add(atraccion3.getCupo());
		if (atraccion4 != null)
			cupos.add(atraccion4.getCupo());
		cupos.sort(null);
		return cupos.get(0);
	}
}