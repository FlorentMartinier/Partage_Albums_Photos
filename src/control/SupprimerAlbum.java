package control;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlbumDao;
import dao.DAOFactory;
import model.AppUser;

@WebServlet("/SupprimerAlbum")
public class SupprimerAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupprimerAlbum() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AlbumDao dao = DAOFactory.getInstance().getAlbumDao();

		String nomAlbum = request.getParameter("albumNom");
		String id = request.getParameter("idAlbum");
		AppUser u =(AppUser)request.getSession().getAttribute("connectedUser");
		String chemin = "/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums";
		chemin = chemin + File.separator+ u.getLogin() +File.separator + nomAlbum;
		File monAlbum = new File(chemin);
		if (monAlbum.isDirectory()) {
			File []listPhotos = monAlbum.listFiles();
			for (int i = 0; i < listPhotos.length; i++) {
				listPhotos[i].delete();
			}
		}
		monAlbum.delete();
		dao.delete(dao.read(Integer.parseInt(id)));
		System.out.println("l'album est supprimé avec succès");
		
		request.getRequestDispatcher("/Albums").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
