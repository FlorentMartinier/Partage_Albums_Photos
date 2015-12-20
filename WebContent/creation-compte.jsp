<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CreationCompte">
	<label for="prenom">Prenom : </label>
	<input id="prenom" name="prenom" type="text" required/>
	<br/>
	<label for="nom">Nom : </label>
	<input id="nom" name="nom" type="text" required/>
	<br/>
	<label for="login">Login : </label>
	<input id="login" name="login" type="text" required/>
	<% if(session.getAttribute("login-taken-error")!=null){
		%> <lablel>Ce compte éxiste déja</lablel> <%
		session.removeAttribute("login-taken-error");
	} else {}%>
	
	
	<br/>
	<label for="password">Mot de passe : </label>
	<input id="password" name="password" type="password" required/>
	<br/>
	<input type="submit" value="OK"/>
</form>
</body>
</html>