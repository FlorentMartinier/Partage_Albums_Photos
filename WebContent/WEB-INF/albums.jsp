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
		<header>
			<link rel="stylesheet" type="text/css" href="styles/main.css"></link>
			<link rel="stylesheet" type="text/css" href="styles/albums.css"></link>
			<p>Partage de photos en ligne</p>
		</header>
		<h1>Vos albums</h1>
		<a href="creation-album.jsp">Ajouter un album</a>
			<c:forEach var="album" items="${listAlbums}">
					<a href="Photos?album=${album.id}">
						<div id="elementAlbum">
							<h2><c:out value="${album.nom }"/></h2>
								
							<c:if test='${album.getOwner().getLogin() != connectedUser.getLogin()}'>
								<p>Appartient a : <c:out value="${album.getOwner().getLogin()}"/> </p>
							</c:if>
							
							<c:if test='${album.getOwner().getLogin() == connectedUser.getLogin()}'>
								<form action="SupprimerAlbum" id="different">
									<input type="hidden" name="albumNom" value="${album.nom}" />
									<input type="submit" name="supprimer" value="supprimer album" id="bouton"/>
								</form>
								<form id="different">
									<a href="#oModal"><input type="button" name="partager" value="partager" id="bouton"/></a>
								</form>
							</c:if>
						</div>
					</a>
					
					<div id="oModal" class="cModal">
  						<div>
  							<form id="different">
  								<a href="#fermer" title="Fermer la fenêtre" class="droite"><input type="button" value="x" id="bouton"/></a>
  							</form>
  							<section>
									<form action="PartageAlbum">
										<h1>Partage</h1>
										<label for="nom">A qui : 
										<input type="text" name="nom-cible"/></label><br/>
										<input type="hidden" name="album" value="${album.id}" />
										<input type="submit" text="Envoyer" id="submit"/>
									</form>
							</section>													
						</div>
					</div>
			</c:forEach>
	</body>
</html>
</jsp:root>