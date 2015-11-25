package controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;
import model.Photo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.AlbumDao;
import dao.DAOFactory;
import dao.PhotoDAO;

@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ajouter() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
		PhotoDAO bd = DAOFactory.getInstance().getPhotoDao();

		Photo p;
		Map<String, String[]> parameter = request.getParameterMap();
		String nomPhoto = parameter.get("nomPhoto")[0];
		String descriptionPhoto = parameter.get("descriptionPhoto")[0];
		String lieu = parameter.get("lieu")[0];

		ServletFileUpload upload = new ServletFileUpload();

		// upload de photos :
		List<FileItem> photos = null;
		try {
			photos = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		Iterator<FileItem> iter = photos.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();

			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString();
			} else {
				String fieldName = item.getFieldName();
				String fileName = item.getName();
				String contentType = item.getContentType();
				boolean isInMemory = item.isInMemory();
				long sizeInBytes = item.getSize();

				// Process a file upload
				File uploadedFile = new File(fileName);
				try {
					item.write(uploadedFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// TODO : changer createur en utilisateur courant
				p = new Photo(createur, nomPhoto, new java.util.Date(),
						descriptionPhoto, lieu);
				bd.create(p);
				photos.add((FileItem) uploadedFile);

			}
		}
		response.sendRedirect("/NavigationPhoto.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
