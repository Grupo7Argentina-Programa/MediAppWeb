package model;

public class Porcentual extends Promocion {

	public Porcentual(String nombreDePromo, int porcentajeDeDescuento, Atraccion a, Atraccion b) {
		boolean tiposDistintos = a.getTipo() != b.getTipo();

		try {
			if (nombreDePromo == "") {
				throw new NombreInvalido();
			}

			if (tiposDistintos) {
				throw new TipoDeAtraccionDistinta();
			}

			this.nombreDePromocion = nombreDePromo;
			this.tiposDeAtracciones = a.getTipo();
			this.costo = a.getCosto() + b.getCosto();
			this.descuento = this.costo * porcentajeDeDescuento / 100;
			this.costo -= this.descuento;
			this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario();
			this.atraccion1 = a;
			this.atraccion2 = b;
			this.cantidadDeAtracciones = 2;
			
		} catch (NombreInvalido e) {
			System.err.println("El nombre no es válido");
		} catch (TipoDeAtraccionDistinta e) {
			System.err.println("Las atracciones deben ser del mismo tipo");
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
