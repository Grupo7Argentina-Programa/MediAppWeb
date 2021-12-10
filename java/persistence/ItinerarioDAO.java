package persistence;

import java.util.Set;

import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import persistence.common.GenericDAO;

public interface ItinerarioDAO extends GenericDAO<Itinerario>{

	public abstract Itinerario findByUser(String name);
	
	public abstract Set<Itinerario> findItinerarios();

	public abstract int insertPromo(Itinerario itinerario, Promocion nueva);

	public abstract int insertAtraccion(Itinerario itinerario, Atraccion nueva);
	
}
