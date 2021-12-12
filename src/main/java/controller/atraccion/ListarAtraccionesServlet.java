package controller.atraccion;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/atracciones.do")
public class ListarAtraccionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -9191928759998728209L;
	private AtraccionService atraccionService;


	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Atraccion> atracciones = atraccionService.list();	
		req.setAttribute("atracciones", atracciones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/atracciones.jsp");
		dispatcher.forward(req, resp);
	}
}
