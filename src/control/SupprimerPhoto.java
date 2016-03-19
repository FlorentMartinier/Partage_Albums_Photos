package control;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SupprimerPhoto")
public class SupprimerPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SupprimerPhoto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomPhoto = request.getParameter("photoNom");
		String idAlbum = request.getParameter("album-id");
		String chemin = nomPhoto;
		File maPhoto = new File(chemin);
		maPhoto.delete();
		System.out.println("la photo est supprimée avec succès");
		request.setAttribute("album", idAlbum);
		request.getRequestDispatcher("/Photos").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
