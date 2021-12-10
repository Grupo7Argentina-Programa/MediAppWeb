package controller.usuario;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UsuarioService;

@WebServlet("/delete-usuario.do")
public class BorrarUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8234900658282073784L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		
		usuarioService.delete(id);
		req.setAttribute("flash", "Usuario borrado con éxito");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado-usuarios.do");
		dispatcher.forward(req, resp);
	}
}
