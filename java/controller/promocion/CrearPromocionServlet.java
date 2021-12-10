package controller.promocion;

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
import model.Promocion;
import services.AtraccionService;
import services.PromocionService;

@WebServlet("/alta-promocion.do")
public class CrearPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 4536151054255336101L;
	private PromocionService promocionService;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Atraccion> atracciones = atraccionService.list();
		req.setAttribute("atracciones", atracciones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alta-promocion.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tipoDePromocion = req.getParameter("tipoDePromocion");
		String nombre = req.getParameter("nombre");
		Integer costo = this.parseInt(req.getParameter("costo"));
		Integer descuento = this.parseInt(req.getParameter("descuento"));
		Atraccion atraccion1 = atraccionService.findByName(req.getParameter("atraccion1"));
		Atraccion atraccion2 = atraccionService.findByName(req.getParameter("atraccion2"));
		Atraccion atraccion3 = atraccionService.findByName(req.getParameter("atraccion3"));
		Atraccion atraccion4 = atraccionService.findByName(req.getParameter("atraccion4"));

		Promocion promocion = promocionService.crear(tipoDePromocion, nombre, costo, descuento, atraccion1, atraccion2,
				atraccion3, atraccion4);
		if (promocion.isValid()) {
			req.setAttribute("flash", "La promoción fue creada con éxito");
			resp.sendRedirect("listado-promociones.do");
		} else {
			req.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alta-promocion.do");
			dispatcher.forward(req, resp);
		}

	}

	private Integer parseInt(String s) {
		Integer value;
		if (s.length() == 0) {
			value = 0; // obviously not a string
		} else {
			try {
				value = Integer.valueOf(s);
			} catch (NumberFormatException e) {
				value = 0;
			}
		}
		return value;
	}
}
