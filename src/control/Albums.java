package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AppUser;

/**
 * Servlet implementation class Albums
 */
@WebServlet("/Albums")
public class Albums extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Albums() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * List the albums created by connected user
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppUser u =  (AppUser) request.getSession().getAttribute("connectedUser");
		request.setAttribute("listAlbums", u.getMyAlbums());
		System.out.println(u.getMyAlbums().toString());
		request.getRequestDispatcher("WEB-INF/albums.jsp").forward(request, response);
	}

	/**
	 * Add an album for connected user
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/* DELETE AND PUT(update) methods are not desirable here */
}
