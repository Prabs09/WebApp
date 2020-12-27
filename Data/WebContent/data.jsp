<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
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
	<td> ${userdata.getFirstname()}  </td>
	<td> ${userdata.getLastname() } </td>
	<td> ${userdata.getContact() }</td>
	<td> ${userdata.getEmail() }</td>
</tr>
</table>
</body>
</html>