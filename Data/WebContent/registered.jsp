<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered</title>
</head>
<body>
<% int chk=(int) request.getAttribute("chk");
	out.print(chk+" record have been added.");
%>
</body>
</html>