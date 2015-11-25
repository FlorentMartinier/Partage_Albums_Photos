package controller;

import java.io.*;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.istack.logging.Logger;
import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import dao.AlbumDao;
import dao.DAOFactory;
import dao.UtilisateurDao;

/**
 * Servlet implementation class CreationAlbum
 */
@WebServlet("/CreationAlbum")
public class CreationAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreationAlbum() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
		Album a;

		AlbumDao bd = DAOFactory.getInstance().getAlbumDao();
		Map<String, String[]> parameter = request.getParameterMap();

		String nomAlbum = parameter.get("nomAlbum")[0];
		String descriptionAlbum = parameter.get("descriptionAlbum")[0];
		String createur = parameter.get("nomCreateur")[0];

		ServletFileUpload upload = new ServletFileUpload();

		// upload de photos :
		List<FileItem> photos = null;
		try {
			photos = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		if (!photos.isEmpty()) {
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
					photos.add((FileItem) uploadedFile);

				}
			}
			// TODO : changer createur en utilisateur courant
			a = new Album(createur, photos, nomAlbum,
					new java.util.Date(), descriptionAlbum);
		} else {
			a = new Album(createur, nomAlbum, new java.util.Date(),
					descriptionAlbum);
		}
		bd.create(a);
		response.sendRedirect("/NavigationAlbum.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
