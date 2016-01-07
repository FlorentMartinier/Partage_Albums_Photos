package control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppUserDao;
import dao.DAOFactory;
import model.AppUser;

@WebServlet("/CreationCompte")
public class CreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreationCompte() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Map<String, String[]> parameter = request.getParameterMap();
			String nom = parameter.get("nom")[0];
			String prenom = parameter.get("prenom")[0];
			String login = parameter.get("login")[0];
			String password = parameter.get("password")[0];
			AppUserDao dao = DAOFactory.getInstance().getAppUserDao();
			if (dao.read(login) == null) {
				AppUser u = new AppUser(login, password, nom, prenom);
				dao.create(u);
				System.out.println("AppUser entry created: " + (dao.read(u.getLogin()) != null));
				System.out.println("login: " + u.getLogin() + " password: " + u.getPassword());
				
				request.setAttribute("login", login);
				request.setAttribute("password", password);
				getServletContext().getRequestDispatcher("/Login").forward(request, response);
			} else {
				request.getSession().setAttribute("login-taken-error", true);
				response.sendRedirect("creation-compte.jsp");
			}
			
		} catch (NullPointerException e) {
			response.sendError(405, "MISSING PARAMETERS");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
