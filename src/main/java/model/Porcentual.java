package model;

public class Porcentual extends Promocion {

	public Porcentual(Integer id, String nombreDePromo, int porcentajeDeDescuento, Atraccion a, Atraccion b) {

		try {
			if (nombreDePromo == "") {
				throw new NombreInvalido();
			}

			this.id = id;
			this.nombre = nombreDePromo;
			this.tiposDeAtracciones = a.getTipo();
			this.costo = a.getCosto() + b.getCosto();
			this.descuento = this.costo * porcentajeDeDescuento / 100;
			this.costo -= this.descuento;
			this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario();
			this.atraccion1 = a;
			this.atraccion2 = b;
			this.cantidadDeAtracciones = 2;
			atracciones.add(a);
			atracciones.add(b);

		} catch (NombreInvalido e) {
			System.err.println("El nombre no es válido");
		}
	}

	public Porcentual(String nombreDePromo, int porcentajeDeDescuento, Atraccion a, Atraccion b) {

		try {
			if (nombreDePromo == "") {
				throw new NombreInvalido();
			}

			this.nombre = nombreDePromo;
			this.tiposDeAtracciones = a.getTipo();
			this.costo = a.getCosto() + b.getCosto();
			this.descuento = this.costo * porcentajeDeDescuento / 100;
			this.costo -= this.descuento;
			this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario();
			this.atraccion1 = a;
			this.atraccion2 = b;
			this.cantidadDeAtracciones = 2;
			atracciones.add(a);
			atracciones.add(b);

		} catch (NombreInvalido e) {
			System.err.println("El nombre no es válido");
		}
	}

	@Override
	public void aceptoMostrable(Usuario comprador) {
		comprador.aceptarPromocion(this);
		this.atraccion1.compradaPorPromocion();
		this.atraccion2.compradaPorPromocion();
		promocionDAO.update(this);
	}

	@Override
	public Integer getCupo() {
		return (atraccion1.getCupo() < atraccion2.getCupo() ? atraccion1.getCupo() : atraccion2.getCupo());
	}
}
