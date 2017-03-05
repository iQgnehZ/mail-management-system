<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  cellspacing=5 border=1>
    <tr>	<td>Login</td>	 <td><%= (java.lang.String)session.getAttribute("login") %></td> </tr> 
    <tr>	<td>Mot de passe</td> <td><%= (java.lang.String)session.getAttribute("password") %></td>   </tr>
</table>
<a href="http://localhost:8080/WANG_ZHENG/sendMail.jsp" type="button">Envoi d'un message</a>
<br>
<a href="http://localhost:8080/WANG_ZHENG/ReceiveMessageServlet">Réception des messages </a>
<br>
<a href="http://localhost:8080/WANG_ZHENG/DeleteMessageServlet">Suppression des messages</a>
<br>
<a href="http://localhost:8080/WANG_ZHENG/aurevoir.jsp">se deconnecter</a>
</body>
</html>