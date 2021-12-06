package model;

import java.util.Objects;

import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UserDAO;
import persistence.common.DAOFactory;
import utils.Crypt;

public class Usuario implements Comparable<Usuario> {

	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoDeAtraccion atraccionFavorita;
	private Itinerario itinerario;
	private UserDAO userDAO = DAOFactory.getUserDAO();
	private ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
	private PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	private String password;
	

	public Usuario(String nombre, int presupuesto, double tiempoDisponible, TipoDeAtraccion atraccionFavorita) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
		this.itinerario = new Itinerario(this);
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public TipoDeAtraccion getAtraccionFavorita() {
		return atraccionFavorita;
	}

	public Itinerario getItinerario() {
		this.itinerario = itinerarioDAO.findByUser(this.getNombre());
		this.itinerario.setUsuario(this);
		return this.itinerario;
	}

	public void aceptarPromocion(Promocion promo) {
		if (this.presupuesto >= promo.getCosto()) {
			itinerario.agregarPromocionComprada(promo);
			this.presupuesto -= promo.getCosto();
			this.tiempoDisponible -= promo.getTiempoNecesario();
			promocionDAO.update(promo);
			userDAO.update(this);
		}
	}

	public void aceptarAtraccion(Atraccion atraccion) {
		if (this.presupuesto >= atraccion.getCosto()) {
			itinerario.agregarAtraccion(atraccion);
			this.presupuesto -= atraccion.getCosto();
			this.tiempoDisponible -= atraccion.getTiempoNecesario();
			atraccion.comprada();
			userDAO.update(this);
		}
	}

	public int compareTo(Usuario otroUsuario) {
		return this.nombre.compareTo(otroUsuario.nombre);
	}

	@Override
	public String toString() {
		return (nombre != null ? nombre + ", " : "") + "Presupuesto: " + presupuesto + " monedas. Tiempo disponible: "
				+ tiempoDisponible + " horas.\n";
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}
	
	public boolean isNull() {
		return false;
	}
	
	public boolean checkPassword(String password) {
		// this.password en realidad es el hash del password
		return Crypt.match(password, this.password);
	}
	
	public boolean puedeComprar(Atraccion atraccion) {
		return (atraccion.getCupo() >=1 && this.presupuesto >= atraccion.getCosto() && this.tiempoDisponible >= atraccion.getTiempoNecesario());
	}

}
