<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
<form action="controller/register" method="post">
<table>
<tr>
	<th> Fields </th>
	<th> Data </th>
</tr>
<tr>
	<td> username: </td>
	<td> <input type="text" name="username"></td>
</tr>
<tr>
	<td> password: </td>
	<td> <input type="password" name="password"></td>
</tr>
<tr>
	<td> first name: </td>
	<td> <input type="text" name="fname"></td>
</tr>
<tr>
	<td> last name: </td>
	<td> <input type="text" name="lname"></td>
</tr>
<tr>
	<td> contact: </td>
	<td> <input type="text" name="contact"></td>
</tr>
<tr>
	<td> email id: </td>
	<td> <input type="text" name="email"></td>
</tr>
<tr>
	<td colspan=2> <button type="submit">submit</button></td>
</tr>
<tr>
	<td colspan=2> <button type="reset">reset</button></td>
</tr>
</table>
</form>
</body>
</html>