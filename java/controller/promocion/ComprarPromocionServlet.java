package controller.promocion;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.common.DAOFactory;
import services.ComprarPromocionService;

@WebServlet("/comprar-promocion.do")
public class ComprarPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 9193843377822485460L;
	private ComprarPromocionService comprarPromocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarPromocionService = new ComprarPromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer promocionId = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

		Map<String, String> errors = comprarPromocionService.comprar(usuario.getId(), promocionId);

		Usuario usuario2 = DAOFactory.getUserDAO().find(usuario.getId());
		req.getSession().setAttribute("usuario", usuario2);

		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por tu compra!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user.jsp");
		dispatcher.forward(req, resp);
	}
}
