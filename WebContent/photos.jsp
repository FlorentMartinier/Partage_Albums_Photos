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
		<link rel="stylesheet" type="text/css" href="./styles/photos.css"></link>
		<link rel="stylesheet" type="text/css" href="./styles/modal.css"></link>
		<title>Photos</title>
	</head>
	<body>
		<header>
			<p>Partage de photos en ligne</p>
		</header>
		<h1>Vos photos :</h1>
		<c:if test='${connectedUser.getLogin()==owner}'>
			<form id="different">
				<a href="#oModal"><input type="button" name="ajouter" value="Ajouter une photo" id="bouton"/></a>
			</form>
		</c:if>
		<div id="oModal" class="cModal">
 			<div>
 				<form id="different">
 					<a href="#fermer" title="Fermer la fenêtre" class="droite"><input type="button" value="x" id="bouton"/></a>
 				</form>
					<form method="post" action="AjoutPhoto" enctype="multipart/form-data">
						<h1>Ajouter une photo</h1>
						<label for="nom">Nom : </label>
						<input type="text" name="nomPhoto" /><br/>
						
						<label for="description">Description : </label>
						<input type="text-field" name="description" /><br/>
							
						<label for="lieu">Lieu : </label>
						<input type="text" name="lieu" /><br/>
							
						<input type="hidden" name="album-nom" value="${Album.nom}" />
						<input type="hidden" name="album-id" value="${Album.id}" />
						
						<label for="photo">Votre photo :</label>
						<input type="file" name="file" accept=".jpg" /><br/>
						
						<input type="submit" value="confirmer" name="confirmer" />
					</form>
			</div>
		</div>
		<c:forEach var="photo" items="${listPhotos}">
			<div id="ligne">
				<img src="GetPhoto?nom-photo=${photo}" /><br/>
				<c:if test='${connectedUser.getLogin()==owner}'>
					<form action="SupprimerPhoto" id="different">
						<input type="hidden" name="photoNom" value="${photo}" />
						<input type="hidden" name="albumNom" value="${Album.nom}" />
						<input type="hidden" name="album-id" value="${Album.id}" />
						<input type="submit" name="supprimer" value="supprimer la photo" id="bouton" />
					</form>
				</c:if>
			</div>
		</c:forEach>
	</body>
</html>
</jsp:root>