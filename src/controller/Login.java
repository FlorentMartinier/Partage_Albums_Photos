package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.UtilisateurDao;
import model.Utilisateur;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDao bd = DAOFactory.getInstance().getUtilisateurDao();
		Map<String, String[]> parameter = request.getParameterMap();
		String username = parameter.get("username")[0];
		String password = parameter.get("password")[0];
		
		Utilisateur ut = bd.read(username);
		if(ut!=null && ut.getPassword() == password) {
			request.getSession().setAttribute("connectedUser", ut); //TODO
			response.sendRedirect("/NavigationAlbum.jsp");
		} else {
			response.sendRedirect("/Login.jsp");
			//TODO ajouter msg erreur
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
