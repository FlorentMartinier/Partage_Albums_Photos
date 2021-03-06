package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.AppUser;

@WebServlet("/AjoutPhoto")
public class AjoutPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums/";

	public AjoutPhoto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String nomPhoto="";
		File file = null;
		String album = "";
		String id = "";
		AppUser u =(AppUser)request.getSession().getAttribute("connectedUser");
		

		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println("rien à uploader");
			return;
		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			System.out.println(items);
			for (FileItem item : items){
				if (item.getFieldName().equals("nomPhoto")){
					nomPhoto = item.getString();
				}
				if (item.getFieldName().equals("album-nom")){
					album = item.getString();
				}
				if (item.getFieldName().equals("album-id")){
					id = item.getString();
					request.setAttribute("album", id);
				}
				
				if (!item.isFormField()){
					Path p = Paths.get(UPLOAD_DIRECTORY+u.getLogin()+File.separator+album.toString());
					File uploadDir = new File(p.toAbsolutePath().toString());
					file = File.createTempFile(nomPhoto, ".jpg", uploadDir);
					file.renameTo(new File(p.toString()));
					item.write(file);
					request.getRequestDispatcher("/Photos").forward(request, response);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
