package controller.tipoDeAtraccion;

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

@WebServlet("/alta-tipo-atraccion.do")
public class CrearTipoDeAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 5307883558170134976L;
	private TiposDeAtraccionService tipoDeAtraccionService;


	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoDeAtraccionService = new TiposDeAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<TipoDeAtraccion> tiposDeAtraccion = tipoDeAtraccionService.list();
		req.setAttribute("tiposDeAtraccion", tiposDeAtraccion);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alta-tipo-atraccion.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");

		TipoDeAtraccion tipoDeAtraccion = tipoDeAtraccionService.crear(nombre);
		if (tipoDeAtraccion.isValid()) {
			req.setAttribute("flash", "El tipo de atracción fue creada con éxito");
			resp.sendRedirect("listado-tipos.do");
		} else {
			req.setAttribute("tipo", tipoDeAtraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/alta-tipo-atraccion.do");
			dispatcher.forward(req, resp);
		}

	}
}
