package controller.session;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import model.Usuario;
import services.AtraccionService;
import services.LoginService;
import services.PromocionService;

@WebServlet("/login.dol")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -8992760235223363330L;
	private LoginService loginService;
	private PromocionService promocionService;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
		promocionService = new PromocionService();
		atraccionService = new AtraccionService();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Usuario usuario = loginService.login(username, password);
		

		if (!usuario.isNull()) {
			req.getSession().setAttribute("usuario", usuario);

			List<Atraccion> atracciones = atraccionService.list();	
			req.getSession().setAttribute("atracciones", atracciones);
				
			List<Promocion> promociones = promocionService.list();	
			req.getSession().setAttribute("promociones", promociones);
					
			resp.sendRedirect("index.jsp");
		} else {
			req.setAttribute("flash", "Nombre de usuario incorrecto");

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
