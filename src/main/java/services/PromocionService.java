package services;

import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.AxB;
import model.Absoluta;
import model.Porcentual;
import persistence.PromocionDAO;
import persistence.common.DAOFactory;

public class PromocionService {

	public List<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();
	}

	public Promocion crear(String tipoDePromocion, String nombre, Integer costo, Integer descuento,
			Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion3, Atraccion atraccion4) {

		Promocion promocion = null;

		switch (tipoDePromocion) {
		case "AxB":
			if (atraccion4 == null) {
				promocion = new AxB(nombre, atraccion1, atraccion2, atraccion3);
			}
			if (atraccion4 != null) {
				promocion = new AxB(nombre, atraccion1, atraccion2, atraccion3, atraccion4);
			}
			break;
		case "Absoluta":
			promocion = new Absoluta(nombre, costo, atraccion1, atraccion2);
			break;
		case "Porcentual":
			promocion = new Porcentual(nombre, descuento, atraccion1, atraccion2);
			break;
		}

		if (promocion.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promocion);
		}
		return promocion;
	}

	public Promocion update(Integer id, String tipoDePromocion, String nombre, Integer costo, Integer descuento,
			Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion3, Atraccion atraccion4) {

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Promocion promocion = promocionDAO.find(id);

		promocion.setNombre(nombre);
		promocion.setCosto(costo);
		promocion.setDescuento(descuento);
		promocion.setAtraccion1(atraccion1);
		promocion.setAtraccion2(atraccion2);
		promocion.setAtraccion3(atraccion3);
		promocion.setAtraccion4(atraccion4);

		if (promocion.isValid()) {
			promocionDAO.update(promocion);
		}
		return promocion;
	}

	public void delete(Integer id) {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();

		Promocion promocion = promocionDAO.find(id);
		promocionDAO.delete(promocion);
	}

	public Promocion find(Integer id) {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		return promocionDAO.find(id);
	}

}
