package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppUserDao;
import dao.DAOFactory;
import model.AppUser;

@WebServlet("/ModifierCompte")
public class ModifierCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifierCompte() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getAttribute("login").toString();
		String newLogin = request.getParameter("login");
		String newPrenom = request.getParameter("prenom");
		String newNom = request.getParameter("nom");
		
		AppUserDao dao = DAOFactory.getInstance().getAppUserDao();
		AppUser u = dao.read(login);
		
		u.setLogin(newLogin);
		u.setNom(newNom);
		u.setPrenom(newPrenom);
		request.getRequestDispatcher("mon-compte.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
