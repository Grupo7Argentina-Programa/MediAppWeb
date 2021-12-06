package model;

public class Absoluta extends Promocion {

	public Absoluta(String nombreDePromo, int costo, Atraccion a, Atraccion b)
			throws NombreInvalido, TipoDeAtraccionDistinta {

		boolean tiposDistintos = a.getTipo() != b.getTipo();

		if (nombreDePromo == "")
			throw new NombreInvalido();
		if (tiposDistintos)
			throw new TipoDeAtraccionDistinta();
		this.nombreDePromocion = nombreDePromo;
		this.tiposDeAtracciones = a.getTipo();
		this.costo = costo;
		this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario();
		this.atraccion1 = a;
		this.atraccion2 = b;
		this.cantidadDeAtracciones = 2;
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