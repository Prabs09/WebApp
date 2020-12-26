<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="com.Data.beans.UserBean" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your data</title>
</head>
<body>
<table>
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Contact </th>
	<th>Email</th>
</tr>
<tr>
	<td><%= user.getFirstname() %></td>
	<td><%= user.getLastname() %></td>
	<td><%= user.getContact() %></td>
	<td><%= user.getEmail() %></td>
</tr>
</table>
</body>
</html>