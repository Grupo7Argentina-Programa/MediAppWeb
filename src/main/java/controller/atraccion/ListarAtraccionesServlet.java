package controller.atraccion;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoDeAtraccion;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/listado-atracciones")
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
		//List<Atraccion> atracciones = atraccionService.list();
		
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		Atraccion mordor = new Atraccion("Mordor", 25, (double) 3, 4, TipoDeAtraccion.AVENTURA);
		Atraccion moria = new Atraccion("Moria", 10, (double) 2, 6, TipoDeAtraccion.AVENTURA);
		Atraccion bosqueNegro = new Atraccion("Bosque Negro", 3, (double) 4, 12, TipoDeAtraccion.AVENTURA);
		Atraccion lothlorien = new Atraccion("Lothlóiren", 35, (double) 1, 30, TipoDeAtraccion.DEGUSTACION);
		atracciones.add(lothlorien);
		atracciones.add(bosqueNegro);
		atracciones.add(moria);
		atracciones.add(mordor);		
		
		req.setAttribute("atracciones", atracciones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("listado-atracciones.jsp");
		dispatcher.forward(req, resp);
	}
}
