<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Ajoutez un Album</title>
		<link rel="stylesheet" type="text/css" href="./styles/main.css"></link>
	</head>
	<body>
		<header>
			<p>Partage de photos en ligne</p>
		</header>
		<form action="CreationAlbum">
			<h1>Creez votre album</h1>
			<label for="nom">Nom : 
			<input type="text" name="nomAlbum"/></label><br/>
			
			<label for="description">Description :
			<input type="textarea" name="descriptionAlbum"/></label><br/>
			
			<input type="submit" text="Envoyer" id="submit"/>
		</form>
	</body>
</html>
</jsp:root>