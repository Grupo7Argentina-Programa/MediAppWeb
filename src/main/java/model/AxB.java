package model;

import java.util.ArrayList;

public class AxB extends Promocion {

	public AxB(Integer id, String nombreDePromo, Atraccion a, Atraccion b, Atraccion c, Atraccion d)  {

			this.id = id;
			this.nombre = nombreDePromo;
			this.tiposDeAtracciones = a.getTipo();
			this.costo = a.getCosto() + b.getCosto() + c.getCosto();
			this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario() + c.getTiempoNecesario()
					+ d.getTiempoNecesario();
			this.atraccion1 = a;
			this.atraccion2 = b;
			this.atraccion3 = c;
			this.atraccion4 = d;
			this.cantidadDeAtracciones = 4;
			this.descuento = 0;
	}

	public AxB(Integer id, String nombreDePromo, Atraccion a, Atraccion b, Atraccion c) {

			this.id = id;
			this.nombre = nombreDePromo;
			this.tiposDeAtracciones = a.getTipo();
			this.costo = a.getCosto() + b.getCosto();
			this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario() + c.getTiempoNecesario();
			this.atraccion1 = a;
			this.atraccion2 = b;
			this.atraccion3 = c;
			this.cantidadDeAtracciones = 3;
			this.descuento = 0;
	}
	
	public AxB(String nombreDePromo, Atraccion a, Atraccion b, Atraccion c, Atraccion d) {

			this.nombre = nombreDePromo;
			this.tiposDeAtracciones = a.getTipo();
			this.costo = a.getCosto() + b.getCosto() + c.getCosto();
			this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario() + c.getTiempoNecesario()
					+ d.getTiempoNecesario();
			this.atraccion1 = a;
			this.atraccion2 = b;
			this.atraccion3 = c;
			this.atraccion4 = d;
			this.cantidadDeAtracciones = 4;
			this.descuento = 0;
	}

	public AxB(String nombreDePromo, Atraccion a, Atraccion b, Atraccion c){

			this.nombre = nombreDePromo;
			this.tiposDeAtracciones = a.getTipo();
			this.costo = a.getCosto() + b.getCosto();
			this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario() + c.getTiempoNecesario();
			this.atraccion1 = a;
			this.atraccion2 = b;
			this.atraccion3 = c;
			this.cantidadDeAtracciones = 3;
			this.descuento = 0;
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