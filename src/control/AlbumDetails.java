package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlbumDetails
 */
@WebServlet("/AlbumDetails") 
public class AlbumDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Lists the details of an album ...
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("coucou");
		System.out.println(request.getAttribute("idAlbum"));
	}

	
	
}
