<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> <!-- Default: HTML 5 -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<p>Welcome ${user}!</p>
<p>Your TODOs are:</p>
<p>${todos}</p>
</body>
</html>

<!-- Valid user -> Welcome -->
<!-- Invalid user -> login.jsp -->