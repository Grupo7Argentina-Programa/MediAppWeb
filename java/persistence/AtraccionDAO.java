package persistence;

import model.Atraccion;
import persistence.common.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {

	public abstract Atraccion findByName(String name);

	public abstract Atraccion find(Integer id);

}