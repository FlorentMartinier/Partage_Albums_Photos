package control;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlbumDao;
import dao.DAO;
import dao.DAOFactory;
import model.Album;
import model.AppUser;

/**
 * Servlet implementation class Photos
 */
@WebServlet("/Photos")
public class Photos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Photos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("album");
		AlbumDao dao = DAOFactory.getInstance().getAlbumDao();
		Album album = dao.read(Integer.parseInt(id));
		String owner = album.getOwner().getLogin();
		String nomAlbum = album.getNom();
		
		String userName = ((AppUser) request.getSession().getAttribute("connectedUser")).getLogin();
		
		//get all photo from album
		File folder = new File("/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums/" + owner + "/" + nomAlbum);
		File[] photosArr = folder.listFiles();
		List<File> photos = Arrays.asList(photosArr);
		request.setAttribute("listPhotos", photos);
		request.setAttribute("Album", album);
		request.setAttribute("owner", owner);
		request.getRequestDispatcher("photos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
