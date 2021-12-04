package services;

import model.Usuario;
import model.nullObjects.NullUsuario;
import persistence.UserDAO;
import persistence.common.DAOFactory;

public class LoginService {

	public Usuario login(String username, String password) {
		UserDAO userDAO = DAOFactory.getUserDAO();
    	Usuario usuario = userDAO.findByUsername(username);
    	
    	//if (usuario.isNull() || !usuario.checkPassword(password)) {
    		//usuario = NullUsuario.build();
    	//}
    	return usuario;
	}
	
}
