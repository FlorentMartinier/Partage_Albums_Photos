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

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/CreationCompte")
public class CreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Map<String, String[]> attributs = request.getParameterMap();
			String nom = attributs.get("nom")[0];
			String prenom = attributs.get("prenom")[0];
			String login = attributs.get("login")[0];
			String password = attributs.get("password")[0];
			AppUserDao dao = DAOFactory.getInstance().getAppUserDao();
			if (dao.read(login) == null) {
				AppUser u = new AppUser(nom, prenom, login, password);
				dao.create(u);
				System.out.println(u);
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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
