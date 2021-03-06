package control;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Album;
import model.AppUser;

import dao.AlbumDao;
import dao.DAOFactory;

@WebServlet("/CreationAlbum")
public class CreationAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreationAlbum() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> parameter = request.getParameterMap();

		String nomAlbum = parameter.get("nomAlbum")[0];
		String descriptionAlbum = parameter.get("descriptionAlbum")[0];
		AppUser u = (AppUser) request.getSession().getAttribute("connectedUser");

		AlbumDao dao = DAOFactory.getInstance().getAlbumDao();
		Path p = Paths.get("/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums/" + u.getLogin().toString() + "/" + nomAlbum);
		Album a= new Album(nomAlbum, u, descriptionAlbum, p);
		dao.create(a);
		File f = new File(p.toAbsolutePath().toString());
		System.out.println(p.toAbsolutePath().toString());
		boolean success = f.mkdirs();

		if (!success) {
			response.sendError(999, "pas d'album a cette adresse");
		} else {
			System.out.println("c'est gagné !");
			request.getSession().setAttribute("path", p);
		}
		request.getRequestDispatcher("/Albums").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
