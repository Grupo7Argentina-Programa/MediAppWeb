package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import persistence.AtraccionDAO;
import persistence.common.DAOFactory;

public class Atraccion implements Mostrable, Comparable<Atraccion> {

	private int id;
	private String nombre;
	private Integer costo;
	private Double tiempoNecesario;
	private int cupo;
	private TipoDeAtraccion tipo;
	private String descripcion;
	private AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
	private Map<String, String> errors;

	public Atraccion(Integer id, String nombre, Integer costo, Double tiempoNecesario, Integer cupo, TipoDeAtraccion tipo, String descripcion) {

		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoNecesario = tiempoNecesario;
		this.cupo = cupo;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public Atraccion(String nombre, Integer costo, Double tiempoNecesario, Integer cupo, TipoDeAtraccion tipo,
			String descripcion) {

		this.nombre = nombre;
		this.costo = costo;
		this.tiempoNecesario = tiempoNecesario;
		this.cupo = cupo;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCosto() {
		return costo;
	}

	public Double getTiempoNecesario() {
		return tiempoNecesario;
	}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "\n" + nombre + "\n Costo: " + costo + "\n Tiempo promedio requerido: " + tiempoNecesario + "\n Cupos: "
				+ cupo + "\n Tipo de atracción: " + tipo + "\n ------------------------";
	}

	public boolean estaEnItinerario(Itinerario itinerario) {
		return itinerario.getAtraccionesAceptadas().contains(this);
	}

	public void aceptoMostrable(Usuario comprador) {
		atraccionDAO.update(this);
		comprador.aceptarAtraccion(this);
	}

	public void compradaPorPromocion() {
		this.cupo -= 1;
		atraccionDAO.update(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return id == other.id && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Atraccion otraAtraccion) {
		int comparacionPorCosto = this.costo.compareTo(otraAtraccion.getCosto());

		if (comparacionPorCosto != 0)
			return comparacionPorCosto;

		return this.tiempoNecesario.compareTo(otraAtraccion.tiempoNecesario);
	}

	@Override
	public Integer getCupo() {
		return this.cupo;
	}

	public void comprada() {
		this.cupo -= 1;
		atraccionDAO.update(this);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public void setTiempoNecesario(Double tiempoNecesario) {
		this.tiempoNecesario = tiempoNecesario;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public boolean isValid() {
		this.validate();
		return errors.isEmpty();
	}

	private void validate() {
		
		errors = new HashMap<String, String>();
		if (this.costo <= 0) {
			errors.put("costo", "Debe ser positivo");
		}
		if (this.tiempoNecesario <= 0) {
			errors.put("tiempoRequerido", "Debe ser positivo");
		}
		if (this.cupo <= 0) {
			errors.put("cupo", "Debe ser positivo");
		}

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTipo(TipoDeAtraccion tipo) {
		this.tipo = tipo;		
	}

	public boolean hayCupo(Integer i) {
		return this.cupo >= i;
	}
}
