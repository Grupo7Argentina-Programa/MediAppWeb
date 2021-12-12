package controller.tipoDeAtraccion;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoDeAtraccion;
import services.TiposDeAtraccionService;

@WebServlet("/edit-tipo-atraccion.do")
public class EditarTipoDeAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 5307883558170134976L;
	private TiposDeAtraccionService tipoDeAtraccionService;


	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoDeAtraccionService = new TiposDeAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		
		TipoDeAtraccion tipo = tipoDeAtraccionService.find(id);
		req.setAttribute("tipoDeAtraccion", tipo);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/edit-tipo-atraccion.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");

		TipoDeAtraccion tipoDeAtraccion = tipoDeAtraccionService.update(id, nombre);
		if (tipoDeAtraccion.isValid()) {
			req.setAttribute("flash", "El tipo de atracción fue actualizado con éxito");
			resp.sendRedirect("listado-tipos.do");
		} else {
			req.setAttribute("tipo", tipoDeAtraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/edit-tipo-atraccion.do");
			dispatcher.forward(req, resp);
		}

	}
}
