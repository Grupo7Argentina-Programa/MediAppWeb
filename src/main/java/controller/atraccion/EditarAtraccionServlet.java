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
import model.TipoDeAtraccion;
import services.AtraccionService;
import services.TiposDeAtraccionService;

@WebServlet("/edit-atraccion.do")
public class EditarAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1374524501304967427L;
	private AtraccionService atraccionService;
	private TiposDeAtraccionService tipoDeAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.tipoDeAtraccionService = new TiposDeAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion atraccion = atraccionService.find(id);
		req.setAttribute("atraccion", atraccion);
		
		List<TipoDeAtraccion> tiposDeAtraccion = tipoDeAtraccionService.list();
		req.setAttribute("tiposDeAtraccion", tiposDeAtraccion);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/edit-atraccion.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		Double tiempoRequerido = Double.parseDouble(req.getParameter("tiempoRequerido"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(req.getParameter("tipo").toUpperCase());
		String descripcion = req.getParameter("descripcion");

		Atraccion atraccion = atraccionService.update(id, nombre, costo, tiempoRequerido, cupo, tipo, descripcion);
		if (atraccion.isValid()) {
			req.setAttribute("flash", "La atracción fue actualizada con éxito");
			resp.sendRedirect("listado-atracciones.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/edit-atraccion.jsp");
			dispatcher.forward(req, resp);
		}

	}
}
