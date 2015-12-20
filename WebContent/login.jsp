<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
			xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Connexion</title>
</head>
<body>

<c:if test="${requestScope['loginError'] eq true}">
	<p>
		Login et/ou mot de passe incorrects. Veuillez ressayer.
	</p>
</c:if>
<form action="${pageContext.servletContext.contextPath}/Login">

<label for="login">Login : </label> 
<input id="login" name="login" type="text"/>
<br/>
<label for="password">Mot de passe : </label>
<input id="password" name="password" type="password"/>


<br/>
<input type="submit" value="OK"/>

</form>

</body>
</html>
</jsp:root>