package controller.atraccion;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/atraccion.do")
public class ListarAtraccionesServlet3 extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -9191928759998728209L;
	private AtraccionService atraccionService;


	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion atraccion = atraccionService.find(id);
		req.setAttribute("atraccion", atraccion);


		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/atraccion.jsp");
		dispatcher.forward(req, resp);
	}
}
