package controller.promocion;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PromocionService;

@WebServlet("/delete-promocion.do")
public class BorrarPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 8861614635946028632L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		
		promocionService.delete(id);
		req.setAttribute("flash", "Promoción borrada con éxito");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado-promociones.do");
		dispatcher.forward(req, resp);
	}
}
