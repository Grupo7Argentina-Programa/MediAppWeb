package services;

import java.util.List;

import model.Atraccion;
import model.NombreInvalido;
import model.TiempoInvalido;
import model.TipoDeAtraccion;
import model.ValorInvalido;
import persistence.AtraccionDAO;
import persistence.common.DAOFactory;

public class AtraccionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion crear(String nombre, Integer costo, Double tiempo, Integer cupo, TipoDeAtraccion tipo)
			throws ValorInvalido, NombreInvalido, TiempoInvalido {

		Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo, tipo);

		return atraccion;
	}

	public Atraccion update(String nombre, Integer costo, Double duracion, Integer cupo) {

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = attractionDAO.findByName(nombre);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setDuracion(duracion);
		atraccion.setCupo(cupo);

		/*
		 * if (attraction.isValid()) { attractionDAO.update(attraction); // XXX: si no
		 * devuelve "1", es que hubo más errores }
		 */
		return atraccion;
	}

	public void delete(Integer id) throws ValorInvalido, NombreInvalido, TiempoInvalido {
		Atraccion atraccion = new Atraccion(null, null, null, null, null);

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		attractionDAO.delete(atraccion);
	}

	public Atraccion find(String nombre) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.findByName(nombre);
	}

}
