package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.TipoDeAtraccion;
import persistence.TipoDeAtraccionDAO;
import persistence.common.ConnectionProvider;
import persistence.common.MissingDataException;

public class TipoDeAtraccionDAOImpl implements TipoDeAtraccionDAO {

	public int insert(TipoDeAtraccion tipo) {
		try {
			String sql = "INSERT INTO tiposDeAtraccion (tipo) VALUES (?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tipo.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(TipoDeAtraccion tipo) {
		try {
			String sql = "UPDATE TIPOSDEATRACCION SET TIPO = ? WHERE ID = ?";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tipo.getNombre());
			statement.setInt(2, tipo.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(TipoDeAtraccion tipo) {
		try {
			String sql = "DELETE FROM TIPOSDEATRACCION WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tipo.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private TipoDeAtraccion toTipoDeAtraccion(ResultSet resultados) throws SQLException {

		return new TipoDeAtraccion(resultados.getInt(1), resultados.getString(2));
	}

	public TipoDeAtraccion find(Integer id) {
		try {

			String sql = "SELECT * FROM TIPOSDEATRACCION WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			TipoDeAtraccion tipoDeAtraccion = null;
			
			if (resultados.next()) {
				tipoDeAtraccion = toTipoDeAtraccion(resultados);
			}

			return tipoDeAtraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public TipoDeAtraccion findByName(String nombre) {
		try {

			String sql = "SELECT * FROM TIPOSDEATRACCION WHERE TIPO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();
			TipoDeAtraccion tipoDeAtraccion = null;
			
			if (resultados.next()) {
				tipoDeAtraccion = toTipoDeAtraccion(resultados);
			}

			return tipoDeAtraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Integer getID(TipoDeAtraccion tipo) {
		try {
			String sql = "SELECT ID FROM TIPOSDEATRACCION WHERE TIPO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tipo.getNombre());
			ResultSet resultados = statement.executeQuery();

			int id = -1;

			if (resultados.next()) {
				id = resultados.getInt(1);
			}

			return id;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM TIPOSDEATRACCION";
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

	public List<TipoDeAtraccion> findAll() {
		try {
			String sql = "SELECT * FROM TIPOSDEATRACCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<TipoDeAtraccion> tipos = new LinkedList<TipoDeAtraccion>();
			while (resultados.next()) {
				tipos.add(toTipoDeAtraccion(resultados));
			}
			return tipos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}