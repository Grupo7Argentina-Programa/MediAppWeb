package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Absoluta;
import model.Atraccion;
import model.AxB;
import model.NombreInvalido;
import model.Porcentual;
import model.Promocion;
import model.TiempoInvalido;
import model.TipoDeAtraccionDistinta;
import model.ValorInvalido;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.common.ConnectionProvider;
import persistence.common.DAOFactory;
import persistence.common.MissingDataException;

public class PromocionDAOImpl implements PromocionDAO {

	@Override
	public List<Promocion> findAll() {
		try {
			String sql = "SELECT * FROM PROMOCIONES";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Promocion> promociones = new LinkedList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados));
			}

			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromocion(ResultSet resultados)
			throws SQLException, NombreInvalido, ValorInvalido, TiempoInvalido, TipoDeAtraccionDistinta {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Promocion promo = null;
		Atraccion atraccion1 = atraccionDAO.findByName(resultados.getString(6));
		Atraccion atraccion2 = atraccionDAO.findByName(resultados.getString(7));
		Atraccion atraccion3 = atraccionDAO.findByName(resultados.getString(8));
		Atraccion atraccion4 = atraccionDAO.findByName(resultados.getString(9));

		switch (resultados.getString("tipoDePromocion")) {
		case "Porcentual":
			promo = new Porcentual(resultados.getString(2), resultados.getInt(4), atraccion1, atraccion2);
			break;
		case "AxB":
			if (resultados.getString(9) != null)
				promo = new AxB(resultados.getString(2), atraccion1, atraccion2, atraccion3, atraccion4);
			else
				promo = new AxB(resultados.getString(2), atraccion1, atraccion2, atraccion3);
			break;
		case "Absoluta":
			promo = new Absoluta(resultados.getString(2), resultados.getInt(3), atraccion1, atraccion2);
			break;
		}
		return promo;
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM PROMOCIONES";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Promocion promocion) {
		try {
			String sql = "INSERT INTO PROMOCIONES (NOMBRE, COSTO, DESCUENTO, DURACION, ATRACCION1, ATRACCION2, ATRACCION3, ATRACCION4, TIPODEATRACCION, TIPODEPROMOCION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promocion.getNombre());
			statement.setInt(2, promocion.getCosto());
			statement.setInt(3, promocion.getDescuento());
			statement.setDouble(4, promocion.getTiempoNecesario());
			statement.setString(5, promocion.getAtraccion1().getNombre());
			statement.setString(6, promocion.getAtraccion2().getNombre());
			statement.setString(7,(promocion.getAtraccion3() == null) ? null : promocion.getAtraccion3().getNombre());
			statement.setString(8,(promocion.getAtraccion4() == null) ? null : promocion.getAtraccion4().getNombre());
			statement.setString(9, promocion.getTipo().name().toLowerCase());
			statement.setString(10, promocion.getTipoDePromocion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Promocion promocion) {
		// Creer�a que no hay que actualizar nada
		return 0;
	}

	@Override
	public int delete(Promocion promocion) {
		try {
			String sql = "DELETE FROM PROMOCIONES WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promocion.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Promocion findByName(String name) {
		try {
			String sql = "SELECT * FROM PROMOCIONES WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;

			if (resultados.next()) {
				promocion = toPromocion(resultados);
			}

			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int getIDByPromocion(Promocion promo) {
		//TODO Testear m�todo
		try {
			String sql = "SELECT ID FROM PROMOCIONES WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promo.getNombre());
			ResultSet resultados = statement.executeQuery();

			int id = 0;

			if (resultados.next()) {
				id = resultados.getInt(1);
			}

			return id;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
