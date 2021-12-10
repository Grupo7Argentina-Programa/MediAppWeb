package controller.usuario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoDeAtraccion;
import model.Usuario;
import services.TiposDeAtraccionService;
import services.UsuarioService;

@WebServlet("/edit-usuario.do")
public class EditarUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -5208044589853752386L;
	private UsuarioService usuarioService;
	private TiposDeAtraccionService tipoDeAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.tipoDeAtraccionService = new TiposDeAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));

		Usuario usuario = usuarioService.find(id);
		req.setAttribute("usuario", usuario);
		
		List<TipoDeAtraccion> tiposDeAtraccion = tipoDeAtraccionService.list();
		req.setAttribute("tiposDeAtraccion", tiposDeAtraccion);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/edit-usuario.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(req.getParameter("tipo").toUpperCase());

		Usuario usuario = usuarioService.update(id, nombre, presupuesto, tiempoDisponible, tipo);
		if (usuario.isValid()) {
			req.setAttribute("flash", "Usuario actualizado con éxito");
			resp.sendRedirect("listado-usuarios.do");
		} else {
			req.setAttribute("usuario", usuario);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/edit-usuario.jsp");
			dispatcher.forward(req, resp);
		}

	}
}
