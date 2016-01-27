package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AppUser;
import dao.AppUserDao;
import dao.DAOFactory;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedPage = "/Albums";
		String password = request.getAttribute("password").toString();
		String login = request.getAttribute("login").toString();
		
		AppUserDao dao = DAOFactory.getInstance().getAppUserDao();
		AppUser u = dao.read(login);
		System.out.println(u);

		if (u != null && u.getPassword().equals(password)) {
			System.out.println("authentification success");
			request.getSession().setAttribute("connectedUser", u);
		} else {
			request.setAttribute("loginError", true);
		}
		request.getRequestDispatcher(requestedPage).forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
