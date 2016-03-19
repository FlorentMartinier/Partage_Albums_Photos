package control;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlbumDao;
import dao.DAOFactory;
import model.Album;

@WebServlet("/Photos")
public class Photos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Photos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("album");
		if (id == null) {
			id = (String) request.getAttribute("album");
		}
		AlbumDao dao = DAOFactory.getInstance().getAlbumDao();
		Album album = dao.read(Integer.parseInt(id));
		String owner = album.getOwner().getLogin();
		String nomAlbum = album.getNom();

		// get all photo from album
		File folder = new File(
				"/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums/" + owner + "/" + nomAlbum);
		File[] photosArr = folder.listFiles();
		List<File> photos = Arrays.asList(photosArr);
		request.setAttribute("listPhotos", photos);
		request.setAttribute("Album", album);
		request.setAttribute("owner", owner);
		request.getRequestDispatcher("photos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
