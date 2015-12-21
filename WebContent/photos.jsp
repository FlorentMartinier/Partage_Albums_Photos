<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
			xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
		<jsp:useBean id="listPhotos" type="java.util.List&lt;java.io.File&gt;" scope="request"/>
		<jsp:useBean id="Album" type="model.Album" scope="request"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Photos</title>
</head>
<body>
<a href="nav-albums.jsp">Ajouter une photo</a>
<form method="post" action="AjoutPhoto" enctype="multipart/form-data">
		<label for="nom">Nom : </label>
		<input type="text" name="nomPhoto" /><br/>
		
		
		<label for="description">Description : </label>
		<input type="text-field" name="description" /><br/>
		
		<label for="lieu">Lieu : </label>
		<input type="text" name="lieu" /><br/>
		
		<input type="hidden" name="album-nom" value="${Album.nom}" />
		
		<label for="photo">Votre photo :</label>
		<input type="file" name="file" accept=".jpg" /><br/>
		
		<input type="submit" value="confirmer" name="confirmer" />
	</form>
<ul>
<c:forEach var="photo" items="${listPhotos}">
		 <img src="GetPhoto?nom-photo=${photo}" />
</c:forEach>
</ul>
</body>
</html>
</jsp:root>