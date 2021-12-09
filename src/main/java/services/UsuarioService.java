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

	public Usuario crear(Integer id, String nombre, Integer presupuesto, Double tiempo, TipoDeAtraccion tipo,
			boolean admin) {

		Usuario usuario = new Usuario(id, nombre, presupuesto, tiempo, tipo, admin);

		return usuario;
	}

	public Usuario update(Integer id, String nombre, Integer presupuesto, Double tiempoDisponible,
			TipoDeAtraccion tipo) {

		UserDAO userDAO = DAOFactory.getUserDAO();
		Usuario usuario = userDAO.find(id);

		usuario.setNombre(nombre);
		usuario.setPresupuesto(presupuesto);
		usuario.setTiempoDisponible(tiempoDisponible);
		usuario.setAtraccionFavorita(tipo);

		if (usuario.isValid()) {
			userDAO.update(usuario); // XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}

	public void delete(Integer id) throws ValorInvalido, NombreInvalido, TiempoInvalido {
		Usuario usuario = new Usuario(-1, "", 0, 0, null, false);

		UserDAO userDAO = DAOFactory.getUserDAO();
		userDAO.delete(usuario);
	}

	public Usuario find(Integer id) {
		UserDAO userDAO = DAOFactory.getUserDAO();
		return userDAO.find(id);
	}

}
