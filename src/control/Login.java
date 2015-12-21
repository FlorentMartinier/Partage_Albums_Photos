package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AppUser;
import dao.DAOFactory;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedPage = "/Albums";
		String password = request.getAttribute("password").toString();
		String login = request.getAttribute("login").toString();

		AppUser u = DAOFactory.getInstance().getAppUserDao().read(login);
		//System.out.println(u.getLogin() + "   " + u.getPassword());
		 System.out.println(u);

		if (u != null && u.getPassword().equals(password)) {
			System.out.println("authentification success");
			request.getSession().setAttribute("connectedUser", u);
			//requestedPage = request.getAttribute("requestedPage").toString();
		} else {
			request.setAttribute("loginError", true);
		}
		request.getRequestDispatcher(requestedPage).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
