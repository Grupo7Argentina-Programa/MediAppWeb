package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UserDAO;
import persistence.common.DAOFactory;
import utils.Crypt;

public class Usuario implements Comparable<Usuario> {

	private int id;
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoDeAtraccion atraccionFavorita;
	private Itinerario itinerario;
	private UserDAO userDAO = DAOFactory.getUserDAO();
	private ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
	private PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	private String password;
	private boolean admin;
	private Map<String, String> errors;

	public Usuario(int id, String nombre, int presupuesto, double tiempoDisponible, TipoDeAtraccion atraccionFavorita,
			boolean admin) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
		this.itinerario = new Itinerario(this);
		this.admin = admin;
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

	public int getId() {
		return id;
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

	public boolean puedeComprar(Mostrable mostrable) {
		return (this.presupuesto >= mostrable.getCosto());
	}

	public boolean puedeAsistir(Mostrable mostrable) {
		return (this.tiempoDisponible >= mostrable.getTiempoNecesario());
	}

	public boolean enItinerario(Mostrable mostrable) {
						
		return (this.itinerario.getAtraccionesAceptadas().contains(mostrable)
				|| this.itinerario.getPromocionesAceptadas().contains(mostrable));
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public void setAtraccionFavorita(TipoDeAtraccion atraccionFavorita) {
		this.atraccionFavorita = atraccionFavorita;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isValid() {
		this.validate();
		return errors.isEmpty();
	}

	private void validate() {

		errors = new HashMap<String, String>();
		if (this.presupuesto < 0) {
			errors.put("presupuesto", "Debe ser positivo");
		}
		if (this.tiempoDisponible < 0) {
			errors.put("tiempoDisponible", "Debe ser positivo");
		}
	}
}
