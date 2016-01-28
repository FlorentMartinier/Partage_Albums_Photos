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
		<jsp:useBean id="connectedUser" type="model.AppUser" scope="session" />
	<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
			<title>Modification du compte</title>
		</head>
		<body>
			<header>
				<link rel="stylesheet" type="text/css" href="styles/main.css"></link>
				<link rel="stylesheet" type="text/css" href="styles/albums.css"></link>
				<link rel="stylesheet" type="text/css" href="styles/modal.css"></link>
				<p>Partage de photos en ligne</p>
			</header>
			
			<nav>
				<ul>
					<li><a href="Albums">Accueil</a></li>
					<li><a href="mon-compte.jsp">Mon compte</a></li>
					<li><a href="Deconnexion">Déconnexion</a></li>
				</ul>
			</nav>
			
			<form action="ModifierCompte?login=${connectedUser.getLogin()}">
				<p>Prenom : <input name="prenom" value="${connectedUser.getPrenom()}" type="text"/></p>
				<p>Nom : <input name="nom" value="${connectedUser.getNom()}" type="text"/></p>				
				<p>Login : <input name="login" value="${connectedUser.getLogin()}" type="text"/></p>
				<input type="submit" name="valider" value="Valider" id="bouton" />
			</form>
		</body>
	</html>
</jsp:root>