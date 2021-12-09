package services;

import java.util.HashMap;
import java.util.Map;
import model.Atraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.UserDAO;
import persistence.common.DAOFactory;

public class ComprarAtraccionService {

	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();

	public Map<String, String> comprar(Integer usuarioId, Integer atraccionId) {
		Map<String, String> errors = new HashMap<String, String>();
		
		Usuario usuario = userDAO.find(usuarioId);
		Atraccion atraccion = atraccionDAO.find(atraccionId);
		
		if (!atraccion.hayCupo(1)) {
			errors.put("atraccion", "No hay cupo disponible");
		}
		if (!usuario.puedeComprar(atraccion)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if (!usuario.puedeAsistir(atraccion)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			usuario.aceptarAtraccion(atraccion);

			atraccionDAO.update(atraccion);
			userDAO.update(usuario);
		}

		return errors;

	}

}
