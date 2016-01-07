package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppUserDao;
import dao.DAOFactory;
import model.AppUser;

@WebServlet("/Albums")
public class Albums extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Albums() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppUser u =  (AppUser) request.getSession().getAttribute("connectedUser");
		AppUserDao dao = DAOFactory.getInstance().getAppUserDao();
		u = dao.read(u.getLogin());
		request.setAttribute("listAlbums", u.getMyAlbums());
		System.out.println(u.getMyAlbums().toString());
		request.getRequestDispatcher("WEB-INF/albums.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
