<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- It must to include the dependency for JSTL -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Default: HTML 5 -->
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<title>Todo Page</title>
</head>
<body>
	<p>Welcome ${user}!</p>
	<p>Your TODOs are:</p>
	<ol>
		<c:forEach items="${todos}" var="todo">
			<!-- 'c' is the reference to use JSTL core library -->
			<li>${todo.name}&nbsp; &nbsp; <a
				href="\delete-todo.do?todo=${todo.name}">Delete</a></li>
		</c:forEach>
	</ol>
	<form action="/todo.do" method="post">
	<!-- The request is GET if is not specified -->
		<input type="text" name="todo" /><input type="submit" value="Add" />
		<!-- put the text into a variable "todo" an send in in a request-->
	</form>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>