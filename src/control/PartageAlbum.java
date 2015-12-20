package control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.DAOFactory;
import model.Album;
import model.AppUser;

@WebServlet("/PartageAlbum")
public class PartageAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PartageAlbum() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String[]> parameter = request.getParameterMap();
		String userId = parameter.get("nom-cible")[0];
		String albumId = parameter.get("album")[0];
		DAO daoAlbum = DAOFactory.getInstance().getAlbumDao();
		DAO daoAppUser = DAOFactory.getInstance().getAppUserDao();

		try {
			Album album = (Album) daoAlbum.read(albumId);
			AppUser user = (AppUser) daoAppUser.read(userId);
			user.getMyAlbums().add(album);
			daoAppUser.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}