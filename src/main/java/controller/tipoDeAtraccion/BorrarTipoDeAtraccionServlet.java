package controller.tipoDeAtraccion;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.TiposDeAtraccionService;

@WebServlet("/delete-tipo-atraccion.do")
public class BorrarTipoDeAtraccionServlet extends HttpServlet implements Servlet {

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
		
		tipoDeAtraccionService.delete(id);
		req.setAttribute("flash", "Tipo de atracción borrada con éxito");		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado-tipos.do");
		dispatcher.forward(req, resp);
	}
}
