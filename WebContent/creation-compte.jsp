<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="./styles/main.css"></link>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creation compte</title>
	</head>
	<body>
		<header>
			<p>Partage de photos en ligne</p>
		</header>
		<form action="CreationCompte">
			<h1>Créez votre compte</h1>
			
			<label for="prenom">Prenom : 
			<input id="prenom" name="prenom" type="text" required/></label><br/>
			
			<label for="nom">Nom :
			<input id="nom" name="nom" type="text" required/></label><br/>
			
			<label for="login">Login :
			<input id="login" name="login" type="text" required/>
			<% if(session.getAttribute("login-taken-error")!=null){
				%> <lablel>Ce compte éxiste déja</lablel> <%
				session.removeAttribute("login-taken-error");
			} else {}%>
			
			</label><br/>
			<label for="password">Mot de passe :			
			<input id="password" name="password" type="password" required/></label><br/>
			<input type="submit" value="Valider" id="submit"/>
		</form>
	</body>
</html>