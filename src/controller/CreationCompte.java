package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.UtilisateurDao;
import model.Utilisateur;

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/j_CreationCompte")
public class CreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCompte() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDao bd = DAOFactory.getInstance().getUtilisateurDao();
		Map<String, String[]> parameter = request.getParameterMap();
		String username = parameter.get("username")[0];
		String mail = parameter.get("e-mail")[0];
		String password = parameter.get("password")[0];
		
		 if(bd.read(username) != null){	//on vérifie si le nom existe déja dans la base
			 //TODO on renvois a la page de création ave une erreur affiher
			 
		 } else {
			 //on creer et sauvegarde le compte
			 Utilisateur ut = new Utilisateur(username, mail, password);
			 bd.create(ut);
			//TODO on renvois vers la page principale
			response.sendRedirect("/NavigationAlbum.jsp");
		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
