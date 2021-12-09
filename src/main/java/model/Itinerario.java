package model;

import java.util.Objects;

import persistence.ItinerarioDAO;
import persistence.common.DAOFactory;

import java.util.ArrayList;

public class Itinerario {

	private ArrayList<Promocion> promocionesAceptadas = new ArrayList<Promocion>();
	private ArrayList<Atraccion> atraccionesAceptadas = new ArrayList<Atraccion>();
	private int dineroGastado = 0;
	private double tiempoRequeridoTotal = 0.0;
	private Usuario usuario;
	private ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();

	public Itinerario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Itinerario() {
	}

	public void agregarPromocionComprada(Promocion nueva) {
		this.promocionesAceptadas.add(nueva);
		this.dineroGastado += nueva.getCosto();
		this.tiempoRequeridoTotal += nueva.getTiempoNecesario();
		itinerarioDAO.insertPromo(this, nueva);
		switch (nueva.cantidadDeAtracciones) {
		case 2:
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion1);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion2);
			break;
		case 3:
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion1);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion2);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion3);
			break;
		case 4:
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion1);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion2);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion3);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion4);
			break;
		}
	}

	public void agregarPromocionLeida(Promocion nueva) {
		this.promocionesAceptadas.add(nueva);
		this.dineroGastado += nueva.getCosto();
		this.tiempoRequeridoTotal += nueva.getTiempoNecesario();
		switch (nueva.cantidadDeAtracciones) {
		case 2:
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion1);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion2);
			break;
		case 3:
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion1);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion2);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion3);
			break;
		case 4:
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion1);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion2);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion3);
			this.agregarAtraccionCompradaPorPromo(nueva.atraccion4);
			break;
		}
	}

	public void agregarAtraccionCompradaPorPromo(Atraccion atraccion) {
		atraccionesAceptadas.add(atraccion);
	}

	public void agregarAtraccion(Atraccion atraccion) {
		atraccionesAceptadas.add(atraccion);
		this.dineroGastado += atraccion.getCosto();
		this.tiempoRequeridoTotal += atraccion.getTiempoNecesario();
		itinerarioDAO.insertAtraccion(this, atraccion);
	}

	public void agregarAtraccionLeida(Atraccion nueva) {
		atraccionesAceptadas.add(nueva);
		this.dineroGastado += nueva.getCosto();
		this.tiempoRequeridoTotal += nueva.getTiempoNecesario();
	}

	public ArrayList<Promocion> getPromocionesAceptadas() {
		return promocionesAceptadas;
	}

	public ArrayList<Atraccion> getAtraccionesAceptadas() {
		return atraccionesAceptadas;
	}

	public double getTiempoTotal() {
		return tiempoRequeridoTotal;
	}

	@Override
	public String toString() {
		return "ITINERARIO" + "\n" + "--------------------"
				+ (atraccionesAceptadas != null ? atraccionesAceptadas + "" : "")
				+ (dineroGastado == 0 && tiempoRequeridoTotal == 0 ? "Parece que no hay nada por aquí...\n" : "")
				+ "\nCosto total: " + dineroGastado + " monedas" + "\nTiempo requerido total: " + tiempoRequeridoTotal
				+ " horas \n" + "-------------------- \n";
	}

	public int getDineroDelItinerario() {
		return dineroGastado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atraccionesAceptadas, dineroGastado, itinerarioDAO, promocionesAceptadas,
				tiempoRequeridoTotal, usuario.getNombre());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itinerario other = (Itinerario) obj;
		return Objects.equals(atraccionesAceptadas, other.atraccionesAceptadas) && dineroGastado == other.dineroGastado
				&& Objects.equals(itinerarioDAO, other.itinerarioDAO)
				&& Objects.equals(promocionesAceptadas, other.promocionesAceptadas)
				&& Double.doubleToLongBits(tiempoRequeridoTotal) == Double.doubleToLongBits(other.tiempoRequeridoTotal)
				&& Objects.equals(usuario.getNombre(), other.usuario.getNombre());
	}

	public void agregarMostrable(Mostrable mostrable) {
		// Ac� agregamos lo que obtenemos de la base de datos
		if (mostrable.getClass() == Atraccion.class) {
			this.agregarAtraccionLeida((Atraccion) mostrable);
		} else {
			this.agregarPromocionLeida((Promocion) mostrable);
		}
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}