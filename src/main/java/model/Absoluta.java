package model;

public class Absoluta extends Promocion {

	public Absoluta(Integer id, String nombreDePromo, int costo, Atraccion a, Atraccion b)
			throws NombreInvalido {

		if (nombreDePromo == "")
			throw new NombreInvalido();
		
		this.id = id;
		this.nombre = nombreDePromo;
		this.tiposDeAtracciones = a.getTipo();
		this.costo = costo;
		this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario();
		this.atraccion1 = a;
		this.atraccion2 = b;
		this.cantidadDeAtracciones = 2;
		this.descuento = 0;
		atracciones.add(a);
		atracciones.add(b);
	}
	
	public Absoluta(String nombreDePromo, int costo, Atraccion a, Atraccion b)  {
		
		this.nombre = nombreDePromo;
		this.tiposDeAtracciones = a.getTipo();
		this.costo = costo;
		this.tiempoNecesario = a.getTiempoNecesario() + b.getTiempoNecesario();
		this.atraccion1 = a;
		this.atraccion2 = b;
		this.cantidadDeAtracciones = 2;
		this.descuento = 0;
		atracciones.add(a);
		atracciones.add(b);
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