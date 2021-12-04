package services;

import java.util.List;
import model.NombreInvalido;
import model.TiempoInvalido;
import model.TipoDeAtraccion;
import model.Usuario;
import model.ValorInvalido;
import persistence.UserDAO;
import persistence.common.DAOFactory;

public class UsuarioService {

	public List<Usuario> list() {
		return DAOFactory.getUserDAO().findAll();
	}

	public Usuario crear(String nombre, Integer presupuesto, Double tiempo, TipoDeAtraccion tipo) {

		Usuario usuario = new Usuario(nombre, presupuesto, tiempo, tipo);

		return usuario;
	}

	public Usuario update(String nombre, Integer costo, Double duracion, Integer cupo) {

		UserDAO userDAO = DAOFactory.getUserDAO();
		Usuario usuario = userDAO.findByUsername(nombre);

		/* usuario.setNombre(nombre);
		usuario.setCosto(costo);
		usuario.setDuracion(duracion);
		usuario.setCupo(cupo);
*/
		/*
		 * if (attraction.isValid()) { attractionDAO.update(attraction); // XXX: si no
		 * devuelve "1", es que hubo más errores }
		 */
		return usuario;
	}

	public void delete(Integer id) throws ValorInvalido, NombreInvalido, TiempoInvalido {
		Usuario usuario = new Usuario("", 0, 0, null);

		UserDAO userDAO = DAOFactory.getUserDAO();
		userDAO.delete(usuario);
	}

	public Usuario find(String nombre) {
		UserDAO userDAO = DAOFactory.getUserDAO();
		return userDAO.findByUsername(nombre);
	}

}
