package control;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Album;
import model.AppUser;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import dao.AlbumDao;
import dao.AppUserDao;
import dao.DAOFactory;

/**
 * Servlet implementation class CreationAlbum
 */
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
		Album a= new Album(nomAlbum, u, descriptionAlbum);
		dao.create(a);
		Path p = Paths.get("/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums/" + u.getLogin().toString() + "/" + nomAlbum);
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
