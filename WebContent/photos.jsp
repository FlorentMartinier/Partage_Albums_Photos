<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
			xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="true"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
		<jsp:useBean id="listPhotos" type="java.util.List&lt;model.Photo&gt;" scope="request"/>
		<jsp:useBean id="Album" type="model.Album" scope="request"/>
		<jsp:useBean id="connectedUser" type="model.AppUser" scope="session" />
		<jsp:useBean id="owner" type="java.lang.String" scope="request" />
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel="stylesheet" type="text/css" href="./styles/main.css"></link>
		<title>Photos</title>
	</head>
	<body>
		<header>
			<p>Partage de photos en ligne</p>
		</header>
		<h1>Vos photos :</h1>
		<div id="oModal" class="cModal">
 			<div>
 				<form id="different">
 					<a href="#fermer" title="Fermer la fenêtre" class="droite"><input type="button" value="x" id="bouton"/></a>
 				</form>
				<c:if test='${connectedUser.getLogin()==owner}'>
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
				</c:if>
			</div>
		</div>
		<c:forEach var="photo" items="${listPhotos}">
				<li><img src="GetPhoto?nom-photo=${photo}" /></li>
				<br/>
				<c:if test='${connectedUser.getLogin()==owner}'>
					<form action="SupprimerPhoto">
						<input type="hidden" name="photoNom" value="${photo}" />
						<input type="hidden" name="albumNom" value="${Album.nom}" />
						<input type="submit" name="supprimer" value="supprimer la photo" />
					</form>
				</c:if>
		</c:forEach>
	</body>
</html>
</jsp:root>