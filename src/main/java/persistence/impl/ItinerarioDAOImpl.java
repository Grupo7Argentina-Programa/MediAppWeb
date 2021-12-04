package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Atraccion;
import model.Itinerario;
import model.Mostrable;
import model.Promocion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UserDAO;
import persistence.common.ConnectionProvider;
import persistence.common.DAOFactory;
import persistence.common.MissingDataException;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	private UserDAO userDAO = DAOFactory.getUserDAO();
	private PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	private AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();

	public Set<Itinerario> findItinerarios() {

		try {
			String sql = "SELECT usuarios.nombre AS 'usuario', itinerarios.nombreDeAtraccion AS 'mostrable'\r\n"
					+ "FROM itinerarios\r\n" + "JOIN usuarios ON usuarios.id = itinerarios.id_usuario\r\n"
					+ "WHERE itinerarios.nombreDeAtraccion IS NOT NULL \r\n" + "UNION\r\n"
					+ "SELECT usuarios.nombre AS 'usuario' , promociones.nombre AS 'mostrable'\r\n"
					+ "FROM itinerarios\r\n" + "JOIN promociones ON promociones.id = itinerarios.id_promocion\r\n"
					+ "JOIN usuarios ON usuarios.id = itinerarios.id_usuario\r\n"
					+ "WHERE itinerarios.id_promocion IS NOT NULL\r\n";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			Set<Itinerario> itinerarios = new HashSet<Itinerario>();
			List<Usuario> listaDeUsuarios = userDAO.findAll();

			while (resultados.next()) {
				for (Usuario usuario : listaDeUsuarios) {
					if (usuario.getNombre().equals(resultados.getString(1))) {
						Atraccion atraccion = atraccionDAO.findByName(resultados.getString(2));
						Promocion promocion = promocionDAO.findByName(resultados.getString(2));
						Mostrable mostrable = (atraccion == null ? promocion : atraccion);
						usuario.getItinerario().agregarMostrable(mostrable);
					}
					itinerarios.add(usuario.getItinerario());
				}
			}
			return itinerarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Itinerario findByUser(String name) {
		try {
			String sql = "SELECT usuarios.nombre AS 'usuario', itinerarios.nombreDeAtraccion AS 'mostrable'\r\n"
					+ "FROM itinerarios\r\n" + "JOIN usuarios ON usuarios.id = itinerarios.id_usuario\r\n"
					+ "WHERE itinerarios.nombreDeAtraccion IS NOT NULL AND usuario = ? \r\n" + "UNION\r\n"
					+ "SELECT usuarios.nombre AS 'usuario' , promociones.nombre AS 'mostrable'\r\n"
					+ "FROM itinerarios\r\n" + "JOIN promociones ON promociones.id = itinerarios.id_promocion\r\n"
					+ "JOIN usuarios ON usuarios.id = itinerarios.id_usuario\r\n"
					+ "WHERE itinerarios.id_promocion IS NOT NULL AND usuario = ?\r\n";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, name);
			ResultSet resultados = statement.executeQuery();
			
			return toItinerario(resultados);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Itinerario toItinerario (ResultSet resultados) throws SQLException {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Itinerario itinerario = new Itinerario();

		while (resultados.next()) {
			Atraccion atraccion = atraccionDAO.findByName(resultados.getString(2));
			Promocion promocion = promocionDAO.findByName(resultados.getString(2));
			
			Mostrable mostrable = (atraccion == null ? promocion : atraccion);
			itinerario.agregarMostrable(mostrable);
		}
		return itinerario;
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT (1) as 'total'\r\n" + "FROM (SELECT DISTINCT(usuarios.nombre) AS 'usuario'\r\n"
					+ "FROM itinerarios\r\n" + "JOIN usuarios ON usuarios.id = itinerarios.id_usuario\r\n"
					+ "GROUP BY usuarios.nombre)";
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
	public int insert(Itinerario itinerario) {
		try {
			String sql = "INSERT OR IGNORE INTO ITINERARIOS (ID_USUARIO, NOMBREDEATRACCION) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			Usuario usuario = itinerario.getUsuario();
			int rows = 0;
			for (Atraccion atraccion : itinerario.getAtraccionesAceptadas()) {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userDAO.getID(usuario.getNombre()));
				statement.setString(2, atraccion.getNombre());
				rows += statement.executeUpdate();
			}

			sql = "INSERT OR IGNORE INTO ITINERARIOS (ID_USUARIO, ID_PROMOCION) VALUES (?, ?)";

			for (Promocion promocion : itinerario.getPromocionesAceptadas()) {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userDAO.getID(usuario.getNombre()));
				statement.setInt(2, promocionDAO.getIDByPromocion(promocion));
				rows += statement.executeUpdate();
			}

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Itinerario itinerario) {
		try {
			String sql = "UPDATE ITINERARIOS SET NOMBREDEATRACCION = ? WHERE ID_USUARIO = ?";

			Connection conn = ConnectionProvider.getConnection();
			int rows = 0;
			Usuario usuario = itinerario.getUsuario();

			for (Atraccion atraccion : itinerario.getAtraccionesAceptadas()) {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(2, userDAO.getID(usuario.getNombre()));
				statement.setString(1, atraccion.getNombre());
				rows += statement.executeUpdate();
			}

			sql = "UPDATE ITINERARIOS SET ID_PROMOCION = ? WHERE ID_USUARIO = ?";

			for (Promocion promocion : itinerario.getPromocionesAceptadas()) {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(2, userDAO.getID(usuario.getNombre()));
				statement.setInt(1, promocionDAO.getIDByPromocion(promocion));
				rows += statement.executeUpdate();
			}
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Itinerario itinerario) {

		try {
			String sql = "DELETE FROM ITINERARIOS WHERE ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userDAO.getID(itinerario.getUsuario().getNombre()));
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insertPromo(Itinerario itinerario, Promocion nueva) {
		try {
			String sql = "INSERT OR IGNORE INTO ITINERARIOS (ID_USUARIO, ID_PROMOCION) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();


			int rows = 0;
			for (Promocion promocion : itinerario.getPromocionesAceptadas()) {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userDAO.getID(itinerario.getUsuario().getNombre()));
				statement.setInt(2, promocionDAO.getIDByPromocion(promocion));
				rows = statement.executeUpdate();
			}
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insertAtraccion(Itinerario itinerario, Atraccion nueva) {
		try {
			String sql = "INSERT OR IGNORE INTO ITINERARIOS (ID_USUARIO, NOMBREDEATRACCION) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			
			int rows = 0;
			for (Atraccion atraccion : itinerario.getAtraccionesAceptadas()) {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userDAO.getID(itinerario.getUsuario().getNombre()));
				statement.setString(2, atraccion.getNombre());
				rows += statement.executeUpdate();
			}
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Itinerario> findAll() {
		return null;
	}

}
