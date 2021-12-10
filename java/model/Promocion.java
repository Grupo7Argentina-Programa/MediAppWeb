package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import persistence.PromocionDAO;
import persistence.common.DAOFactory;

public abstract class Promocion implements Mostrable, Comparable<Promocion> {

	protected Integer id;
	protected TipoDeAtraccion tiposDeAtracciones;
	protected Integer costo;
	protected Integer descuento;
	protected Double tiempoNecesario;
	protected String nombre;
	protected Atraccion atraccion1;
	protected Atraccion atraccion2;
	protected Atraccion atraccion3;
	protected Atraccion atraccion4;
	protected Integer cantidadDeAtracciones;
	protected PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	private Map<String, String> errors;

	public Integer getCosto() {
		return this.costo;
	}

	public TipoDeAtraccion getTipo() {
		return this.tiposDeAtracciones;
	}

	public Double getTiempoNecesario() {
		return this.tiempoNecesario;
	}

	public int getCantidadDeAtracciones() {
		return this.cantidadDeAtracciones;
	}

	public boolean estaEnItinerario(Itinerario itinerario) {
		return itinerario.getPromocionesAceptadas().contains(this)
				|| itinerario.getAtraccionesAceptadas().contains(atraccion1)
				|| itinerario.getAtraccionesAceptadas().contains(atraccion2)
				|| itinerario.getAtraccionesAceptadas().contains(atraccion3)
				|| itinerario.getAtraccionesAceptadas().contains(atraccion4);
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int compareTo(Promocion otraPromocion) {
		OrdenadorDeMostrables ordenador = new OrdenadorDeMostrables();
		return ordenador.compare(this, otraPromocion);
	}

	@Override
	public String toString() {
		return "\n" + "PROMOCION " + (nombre != null ? nombre + "" : "") + (costo != null ? "\n Costo: " + costo : "")
				+ "\n Tiempo necesario: " + tiempoNecesario + "\n Atracciones que incluye: "
				+ (atraccion1 != null ? atraccion1.getNombre() + "" : "")
				+ (atraccion2 != null ? ", " + atraccion2.getNombre() : "\n")
				+ (atraccion3 != null ? ", " + atraccion3.getNombre() : "\n")
				+ (atraccion4 != null ? ", " + atraccion4.getNombre() : "\n") + "------------------------ \n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(atraccion1, atraccion2, atraccion3, atraccion4, cantidadDeAtracciones, costo, descuento,
				nombre, tiempoNecesario, tiposDeAtracciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(atraccion1, other.atraccion1) && Objects.equals(atraccion2, other.atraccion2)
				&& Objects.equals(atraccion3, other.atraccion3) && Objects.equals(atraccion4, other.atraccion4)
				&& cantidadDeAtracciones == other.cantidadDeAtracciones && Objects.equals(costo, other.costo)
				&& descuento == other.descuento && Objects.equals(nombre, other.nombre)
				&& Objects.equals(tiempoNecesario, other.tiempoNecesario)
				&& tiposDeAtracciones == other.tiposDeAtracciones;
	}

	public int getDescuento() {
		return this.descuento;
	}

	public String getTipoDePromocion() {
		return this.getClass().getSimpleName();
	}

	public Atraccion getAtraccion1() {
		return atraccion1;
	}

	public Atraccion getAtraccion2() {
		return atraccion2;
	}

	public Atraccion getAtraccion3() {
		return atraccion3;
	}

	public Atraccion getAtraccion4() {
		return atraccion4;
	}

	public String getNombreDePromocion() {
		return nombre;
	}

	public void setNombre(String nombreDePromocion) {
		this.nombre = nombreDePromocion;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public void setTiempoNecesario(Double tiempoNecesario) {
		this.tiempoNecesario = tiempoNecesario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isValid() {
		this.validate();
		return errors.isEmpty();
	}

	private void validate() {
		errors = new HashMap<String, String>();

		if (this.costo < 0) {
			errors.put("costo", "Debe ser positivo");
		}
		if (this.descuento < 0) {
			errors.put("descuento realizado", "Debe ser positivo");
		}
		if (this.atraccion1.getTipo() != this.atraccion2.getTipo()) {
			errors.put("tipo de atraccion", "Debe ser el mismo");
		}

	}

	public void setAtraccion1(Atraccion atraccion1) {
		this.atraccion1 = atraccion1;
	}

	public void setAtraccion2(Atraccion atraccion2) {
		this.atraccion2 = atraccion2;
	}

	public void setAtraccion3(Atraccion atraccion3) {
		this.atraccion3 = atraccion3;
	}

	public void setAtraccion4(Atraccion atraccion4) {
		this.atraccion4 = atraccion4;
	}

	public boolean hayCupo(Integer i) {
		return this.atraccion1.getCupo() >= i && 
				this.atraccion2.getCupo() >= i &&
				this.atraccion3 != null	? this.atraccion3.getCupo() >= i : true &&
				this.atraccion4 != null ? this.atraccion4.getCupo() >= i : true;
	}

}
