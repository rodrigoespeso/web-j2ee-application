<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> <!-- Default: HTML 5 -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Login Servlet from JSP</title>
</head>
<%
/*
 * This is a scriplet. The code is hide in the html response.
 * Scriplets are BAD practice
 */
System.out.println("Scriplet working...");
%>
<body>
<%
Date date = new Date();
%>
<div> Current date is <%=date %></div> <!-- Scriplet expression. Bad practice too. --> 
<br/>
Servlet showing a JSP. <br/>
<!-- My name is ${name} and my password is ${password} --> <!-- Expression language: to  dynamically get content from requests, sessions, etc.-->
<form action="/login.do" method="post"> <!-- 'action' specify who handle this form: a post request -->
<p><font color = "red">${errorMessage}</font></p> <!-- If errorMessage variable is not informed, do not print nothing :) -->
User: <input type="text" name="user"/><br/>
Password: <input type="password" name="password"/><br/>
<input type="submit" value="Login"/>
</form>
</body>
</html>