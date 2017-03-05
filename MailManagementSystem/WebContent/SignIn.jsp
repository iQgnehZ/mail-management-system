<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignIn</title>
</head>
<body>
<form method="post" action="/WANG_ZHENG/register">
<table  cellspacing=5 border=1>
    <tr>	<td>Login</td>	<td><input type=TEXT name=login size=25></td>   </tr> 
    <tr>	<td>Mot de passe</td>	<td><input type=PASSWORD name=password size=25></td>   </tr>
    <tr>	<td>Mot de passe</td>	<td><input type=PASSWORD name=confirmedPassword size=25></td>   </tr>
</table>
    <input type="submit" value="Valider">
</form>
</body>
</html>