package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.AlbumDao;
import dao.DAOFactory;
import model.Album;
import model.AppUser;
import model.Photo;

@WebServlet("/AjoutPhoto")
public class AjoutPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// location to store file uploaded
	private static final String UPLOAD_DIRECTORY = "/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums/";

	public AjoutPhoto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String nomPhoto="";
		String description="";
		String lieu="";
		File file = null;
		
		AppUser u =(AppUser)request.getSession().getAttribute("connectedUser");
		Path p = Paths.get(UPLOAD_DIRECTORY+u.getLogin());

		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println("rien à uploader");
			return;
		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			for (FileItem item : items){
				if (item.getFieldName().equals("nomPhoto")){
					nomPhoto = item.getString();
				}
				if (item.getFieldName().equals("description")){
					description = item.getString();
				}
				if (item.getFieldName().equals("lieu")){
					lieu = item.getString();
				}
				if (!item.isFormField()){
					File uploadDir = new File(p.toAbsolutePath().toString());
					file = File.createTempFile("img", ".jpg", uploadDir);
					file.renameTo(new File(file.getPath()+File.separator+"banane"));
					item.write(file);
					
					out.println("photo sauvee");
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Path chemin = Paths.get(p.toString()+nomPhoto);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
