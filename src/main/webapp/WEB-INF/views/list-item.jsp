<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Todos Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
	.footer {
		position: absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background-color: #f5f5f5;
	}
</style>
</head>

<body>

<!-- NAVIGATION BAR -->
	<nav class="navbar navbar-default">
		<a href="/" class="navbar-brand">Brand</a>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="/list-item.do">Items</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout.do">Logout</a></li>
		</ul>
	</nav>
	
<!-- BODY -->
	<div class="container">
		<H1>Welcome ${user}</H1>
		
	 	<p>Your Items are:</p>

		<table class="table table-striped">
			<thead>
				<th>Description</th>
				<th>Category</th>
				<th>Actions</th>
			</thead>
			<tbody>
			<c:forEach items="${items}" var="item">
				<!-- 'c' is the reference to use JSTL core library -->
				<tr>
					<td>${item.name}</td>
					<td>${item.category}</td>
					<td>&nbsp;&nbsp;<a class="btn btn-danger" href="/delete-item.do?item=${item.name}&category=${item.category}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<!-- Old version. Ordered List -->
<!-- 		<p>Your Items are:</p> -->
<!-- 		<ol> -->
<%-- 			<c:forEach items="${items}" var="item"> --%>
<!-- 				'c' is the reference to use JSTL core library -->
<%-- 				<li> ${item.name}&nbsp;${item.category}&nbsp;<a href="/delete-item.do?item=${item.name}&category=${item.category}">Delete</a> --%>
<%-- 			</c:forEach> --%>
<!-- 		</ol> -->
			<!-- Link to add-todo page -->
			<a class="btn btn-success" href="/add-item.do">Add new item</a>
		 
	</div>
	
<!-- FOOTER -->
	<footer class="footer">
		<p>Footer content</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>