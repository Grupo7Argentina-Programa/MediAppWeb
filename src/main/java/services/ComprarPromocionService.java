package services;

import java.util.HashMap;
import java.util.Map;

import model.Promocion;
import model.Usuario;
import persistence.PromocionDAO;
import persistence.UserDAO;
import persistence.common.DAOFactory;

public class ComprarPromocionService {

	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();

	public Map<String, String> comprar(Integer usuarioId, Integer promocionId) {
		Map<String, String> errors = new HashMap<String, String>();
		
		Usuario usuario = userDAO.find(usuarioId);
		Promocion promocion = promocionDAO.find(promocionId);
		
		if (!promocion.hayCupo(1)) {
			errors.put("atraccion", "No hay cupo disponible");
		}
		if (!usuario.puedeComprar(promocion)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if (!usuario.puedeAsistir(promocion)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			usuario.aceptarPromocion(promocion);

			promocionDAO.update(promocion);
			userDAO.update(usuario);
		}

		return errors;

	}

}
