<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.File"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ 
	 String[] dir = new java.io.File("/home/florent/workspace/ProjetAlbumsFac/WebContent/WEB-INF/albums").list( );
	 
	    for (int i=0; i=dir.length+1; i++) {
	    	String s = dir[i];
	  %>
	    	<img src=<%@ s; %> />
	    <%@ }%>
	<form method="post" action="AjoutPhoto" enctype="multipart/form-data">
		<label for="nom">Nom : </label>
		<input type="text" name="nomPhoto"><br/>
		
		
		<label for="description">Description : </label>
		<input type="text-field" name="description"><br/>
		
		<label for="lieu">Lieu : </label>
		<input type="text" name="lieu"><br/>
		
		<label for="photo">Votre photo :</label>
		<input type="file" name="file" accept=".jpg" /><br/>
		
		<input type="submit" value="confirmer" name="confirmer">
	</form>
</body>
</html>