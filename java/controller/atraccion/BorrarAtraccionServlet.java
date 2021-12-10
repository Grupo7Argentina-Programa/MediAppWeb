package controller.atraccion;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;

@WebServlet("/delete-atraccion.do")
public class BorrarAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 9193843377822485460L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));

		atraccionService.delete(id);
		req.setAttribute("flash", "Atracción borrada con éxito");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado-atracciones.do");
		dispatcher.forward(req, resp);
	}
}
