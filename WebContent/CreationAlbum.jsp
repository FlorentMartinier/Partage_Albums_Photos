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
</head>
<body>
	<form method="post" action="CreationAlbum" enctype="multipart/form-data">
		<input type="text" name="nomAlbum"/>
		<input type="text" name="nomCreateur"/>
		<input type="textarea" name="descriptionAlbum"/>
		<input type="file" name="photos" accept=".jpg,.jpeg,.png" multiple/>
		<input type="submit" text="Envoyer"/>
	</form>
</body>
</html>
</jsp:root>