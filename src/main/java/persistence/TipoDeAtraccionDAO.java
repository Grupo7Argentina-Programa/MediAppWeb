package persistence;

import model.TipoDeAtraccion;
import persistence.common.GenericDAO;

public interface TipoDeAtraccionDAO extends GenericDAO<TipoDeAtraccion> {

	public abstract TipoDeAtraccion find(Integer id);

	public abstract TipoDeAtraccion findByName(String string);
}