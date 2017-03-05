<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action='/WANG_ZHENG/SendMailServlet'>
<table  cellspacing=5 border=1>
    <tr>	<td>From</td>	<td><%= (java.lang.String)session.getAttribute("login") %></td>   </tr> 
    <tr>	<td>To</td>	<td><input type=TEXT name=to size=25></td>   </tr>
    <tr>	<td>Suject</td>	<td><input type=TEXT name=subject size=25></td>   </tr>
    <tr>	<td>Message</td>	<td><textarea name=message rows="10" cols="30"></textarea></td>   </tr>
</table>
    <input type="submit" value="Valider">
</form>
<a href="http://localhost:8080/WANG_ZHENG/aurevoir.jsp">se deconnecter</a>
</body>
</html>