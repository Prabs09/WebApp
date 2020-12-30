<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
 th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
table {
align: center;
border: 1px;
margin-left: auto;
margin-right: auto;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">This is the welcome page</h2>
<% String st=(String) session.getAttribute("error");
	if(st!=null)
	{
	out.print(st);
	session.removeAttribute("error");
	}
%>
<form action="<%=request.getContextPath() %>/login" method="post">
<table>
<tr>
	<th bgcolor="red" align="Right"> Data </th>
	<th bgcolor="yellow" align="Left"> Web  </th>
</tr>
<tr>
	<td> Username: </td>
	<td> <input type="text" name="user"></td>
</tr>
<tr>
	<td> Password: </td>
	<td> <input type="password" name="pass"></td>
</tr>
<tr>
	<td colspan="2" align="Right"> <button type="submit" value="submit">submit</button></td>
</tr>
<tr>
	<td colspan="2" align="Right"> <button type="reset" value="reset">clear</button></td>
</tr>
</table>
</form>
<form action="register.jsp" method="post">
<button type="submit" value="submit">Register</button>
</form>
</body>
</html>