<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
			xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0"
			>
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="true"
		import="model.AppUser"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
		<jsp:useBean id="listAlbums" type="java.util.List&lt;model.Album&gt;" scope="request"/>
		<jsp:useBean id="connectedUser" type="model.AppUser" scope="session" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Albums</title>
</head>
<body>
	<a href="creation-album.jsp">Ajouter un album</a>
	<ul>
		<c:forEach var="album" items="${listAlbums}">
			<li>
				 <ul><a href="Photos?album=${album.id}"><c:out value="${album.nom }"/></a></ul> 		
				
				<c:if test='${album.getOwner().getLogin() == connectedUser.getLogin()}'>
					<form action="SupprimerAlbum">
						<input type="hidden" name="albumNom" value="${album.nom}" />
						<input type="submit" name="supprimer" value="supprimer album" />
					</form>
					<form action="PartageAlbum">
						<h4>Partage</h4>
						<label for="nom">A qui : </label>
						<input type="text" name="nom-cible"/><br/>
						<input type="hidden" name="album" value="${album.id}" />
						<input type="submit" text="Envoyer"/>
					</form>
				</c:if>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
</jsp:root>