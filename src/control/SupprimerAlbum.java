package control;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AppUser;

@WebServlet("/SupprimerAlbum")
public class SupprimerAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupprimerAlbum() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomAlbum = request.getParameter("albumNom");
		AppUser u =(AppUser)request.getSession().getAttribute("connectedUser");
		String chemin = "/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums";
		chemin = chemin + File.separator+ u.getLogin() +File.separator + nomAlbum;
		File monAlbum = new File(chemin);
		System.out.println(monAlbum.isDirectory());
		System.out.println(new File("/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums").isDirectory());
		if (monAlbum.isDirectory()) {
			System.out.println("c'est un repertoire");
			File []listPhotos = monAlbum.listFiles();
			System.out.println(listPhotos.length);
			for (int i = 0; i < listPhotos.length; i++) {
				listPhotos[i].delete();
			}
		}
		monAlbum.delete();
		System.out.println("l'album est supprimé avec succès");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
