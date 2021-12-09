package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.TipoDeAtraccion;
import model.NombreInvalido;
import model.TiempoInvalido;
import model.Usuario;
import model.ValorInvalido;
import persistence.UserDAO;
import persistence.common.ConnectionProvider;
import persistence.common.MissingDataException;

public class UserDAOImpl implements UserDAO {

	public int insert(Usuario user) {
		try {
			String sql = "INSERT INTO USUARIOS (NOMBRE, DINERO, TIEMPO, ATRACCIONFAVORITA) VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getNombre());
			statement.setInt(2, user.getPresupuesto());
			statement.setDouble(3, user.getTiempoDisponible());
			statement.setString(4, user.getAtraccionFavorita().name().toLowerCase());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Usuario user) {
		try {
			String sql = "UPDATE USUARIOS SET DINERO = ?, TIEMPO = ? WHERE NOMBRE = ?";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(3, user.getNombre());
			statement.setInt(1, user.getPresupuesto());
			statement.setDouble(2, user.getTiempoDisponible());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Usuario user) {
		try {
			String sql = "DELETE FROM USUARIOS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario find(Integer id) {
		try {

			String sql = "SELECT * FROM USUARIOS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario user = null;

			if (resultados.next()) {
				user = toUser(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	public Usuario findByUsername(String username) {
		try {

			String sql = "SELECT * FROM USUARIOS WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultados = statement.executeQuery();

			Usuario user = null;

			if (resultados.next()) {
				user = toUser(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int getID(String username) {
		// TODO Testear m�todo
		try {
			String sql = "SELECT ID FROM USUARIOS WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
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

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM USUARIOS";
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

	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM USUARIOS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUser(resultados));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUser(ResultSet resultados) throws SQLException, NombreInvalido, ValorInvalido, TiempoInvalido {
		return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getDouble(4),
				TipoDeAtraccion.valueOf(resultados.getString(5).toUpperCase()), (resultados.getInt(6) == 1) ? true : false);
	}

}