package services;

import java.util.List;
import model.TipoDeAtraccion;
import persistence.TipoDeAtraccionDAO;
import persistence.common.DAOFactory;

public class TiposDeAtraccionService {

	public List<TipoDeAtraccion> list() {
		return DAOFactory.getTipoDeAtraccionDAO().findAll();
	}

	public TipoDeAtraccion crear(Integer id, String nombre) {

		TipoDeAtraccion tipo = new TipoDeAtraccion(id, nombre);
		TipoDeAtraccionDAO tipoDeAtraccionDAO = DAOFactory.getTipoDeAtraccionDAO();
		tipoDeAtraccionDAO.insert(tipo);
		return tipo;
	}

	public TipoDeAtraccion crear(String nombre) {

		TipoDeAtraccion tipo = new TipoDeAtraccion(nombre);
		TipoDeAtraccionDAO tipoDeAtraccionDAO = DAOFactory.getTipoDeAtraccionDAO();
		tipoDeAtraccionDAO.insert(tipo);
		return tipo;
	}

	public TipoDeAtraccion update(Integer id, String nombre) {

		TipoDeAtraccionDAO tipoDeAtraccionDAO = DAOFactory.getTipoDeAtraccionDAO();
		TipoDeAtraccion tipoDeAtraccion = tipoDeAtraccionDAO.find(id);

		tipoDeAtraccion.setNombre(nombre);

		if (tipoDeAtraccion.isValid()) {
			tipoDeAtraccionDAO.update(tipoDeAtraccion); // XXX: si nodevuelve "1", es que hubo más errores
		}
		return tipoDeAtraccion;
	}

	public void delete(Integer id) {
		TipoDeAtraccion tipoDeAtraccion = new TipoDeAtraccion(-1, "");

		TipoDeAtraccionDAO tipoDeAtraccionDAO = DAOFactory.getTipoDeAtraccionDAO();
		tipoDeAtraccion = tipoDeAtraccionDAO.find(id);
		tipoDeAtraccionDAO.delete(tipoDeAtraccion);
	}

	public TipoDeAtraccion find(String nombre) {
		TipoDeAtraccionDAO tipoDeAtraccionDAO = DAOFactory.getTipoDeAtraccionDAO();
		return tipoDeAtraccionDAO.findByName(nombre);
	}

	public TipoDeAtraccion find(Integer id) {
		TipoDeAtraccionDAO tipoDeAtraccionDAO = DAOFactory.getTipoDeAtraccionDAO();
		return tipoDeAtraccionDAO.find(id);
	}

}
