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
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="j_Login">
    	<input type="text" name="username"/>
    	<input type="password" name= "password"/>
    	<input type="submit" text="Envoyer"/>
	</form>
	<a href="CreationCompte.jsp">Pas de compte? Faite en un ici.</a>
</body>
</html>
</jsp:root>