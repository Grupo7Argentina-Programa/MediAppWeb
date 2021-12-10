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
import model.TipoDeAtraccion;
import services.TiposDeAtraccionService;

@WebServlet("/listado-tipos.do")
public class ListarTiposDeAtraccionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1281627507863514485L;
	private TiposDeAtraccionService tiposDeAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tiposDeAtraccionService = new TiposDeAtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TipoDeAtraccion> tiposDeAtraccion = tiposDeAtraccionService.list();	
		req.setAttribute("tiposDeAtraccion", tiposDeAtraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado-tipos.jsp");
		dispatcher.forward(req, resp);
	}
}
