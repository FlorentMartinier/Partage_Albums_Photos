<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Ajoutez des photos</title>
</head>
<body>
	<form method="post" action="Ajouter" enctype="multipart/form-data">
		<input type="text" name="nomPhoto" /> 
		<input type="textarea" name="descriptionPhoto" />
		<input type="text" name="lieu" />
		<input type="file" name="photos" accept=".jpg,.jpeg,.png" multiple />
		<input type="submit" text="Envoyer" />
	</form>
</body>
	</html>
</jsp:root>