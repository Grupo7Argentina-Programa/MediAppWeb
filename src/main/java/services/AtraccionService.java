package services;

import java.util.List;
import model.Atraccion;
import model.TipoDeAtraccion;
import persistence.AtraccionDAO;
import persistence.common.DAOFactory;

public class AtraccionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion crear(Integer id, String nombre, Integer costo, Double tiempo, Integer cupo, TipoDeAtraccion tipo,
			String descripcion) {

		Atraccion atraccion = new Atraccion(id, nombre, costo, tiempo, cupo, tipo, descripcion);
		if (atraccion.isValid()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			atraccionDAO.insert(atraccion);
		}
		return atraccion;
	}

	public Atraccion crear(String nombre, Integer costo, Double tiempo, Integer cupo, TipoDeAtraccion tipo,
			String descripcion) {

		Atraccion atraccion = new Atraccion(-1, nombre, costo, tiempo, cupo, tipo, descripcion);

		if (atraccion.isValid()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			atraccionDAO.insert(atraccion);
		}
		return atraccion;
	}

	public Atraccion update(Integer id, String nombre, Integer costo, Double duracion, Integer cupo,
			TipoDeAtraccion tipo, String descripcion) {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.find(id);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setTiempoNecesario(duracion);
		atraccion.setCupo(cupo);
		atraccion.setTipo(tipo);
		atraccion.setDescripcion(descripcion);

		if (atraccion.isValid()) {
			atraccionDAO.update(atraccion);
		}
		return atraccion;
	}

	public void delete(Integer id) {
		Atraccion atraccion = new Atraccion(-1, "", 0, 0.0, 0, null, "");
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();

		atraccion = atraccionDAO.find(id);

		atraccionDAO.delete(atraccion);
	}

	public Atraccion find(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.find(id);
	}

	public Atraccion findByName(String nombre) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.findByName(nombre);
	}

}
