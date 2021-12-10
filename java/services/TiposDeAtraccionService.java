package services;

import java.util.List;
import model.Atraccion;
import model.NombreInvalido;
import model.TiempoInvalido;
import model.TipoDeAtraccion;
import model.ValorInvalido;
import persistence.AtraccionDAO;
import persistence.TipoDeAtraccionDAO;
import persistence.common.DAOFactory;

public class TiposDeAtraccionService {

	public List<TipoDeAtraccion> list() {
		return DAOFactory.getTipoDeAtraccionDAO().findAll();
	}

	public TipoDeAtraccion crear(Integer id, String nombre) {
		//No funciona
		TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(nombre);
		TipoDeAtraccionDAO tipoDeAtraccionDAO = DAOFactory.getTipoDeAtraccionDAO();
		tipoDeAtraccionDAO.insert(tipo);
		return tipo;
	}
	
	public Atraccion crear(String nombre, Integer costo, Double tiempo, Integer cupo, TipoDeAtraccion tipo,
			String descripcion) {
		Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo, tipo, descripcion);
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.insert(atraccion);
		return atraccion;
	}

	public Atraccion update(String nombre, Integer costo, Double duracion, Integer cupo) {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.findByName(nombre);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setTiempoNecesario(duracion);
		atraccion.setCupo(cupo);

		/*
		 * if (attraction.isValid()) { attractionDAO.update(attraction); // XXX: si no
		 * devuelve "1", es que hubo más errores }
		 */
		return atraccion;
	}

	public void delete(Integer id) throws ValorInvalido, NombreInvalido, TiempoInvalido {
		Atraccion atraccion = new Atraccion(null, null, null, null, null, null, null);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.delete(atraccion);
	}

	public Atraccion find(String nombre) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.findByName(nombre);
	}

	

}
