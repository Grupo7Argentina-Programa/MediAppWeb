package persistence;

import model.Usuario;
import persistence.common.GenericDAO;

public interface UserDAO extends GenericDAO<Usuario> {

	public abstract Usuario findByUsername(String username);
	public abstract int getID(String username);
	public abstract Usuario find(Integer id);	
}