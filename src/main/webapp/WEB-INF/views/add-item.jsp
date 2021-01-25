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
		Your New Action Item: 
		<form action="/add-item.do" method="post">
			<!-- The request is GET if is not specified -->
			<fieldSet class="form-group">
				<label>Description</label>
				<input class="form-control" type="text" name="item"/> <br/>
			</fieldSet>
			<fieldSet class="form-group">
				<label>Category</label>
				<input class="form-control" type="text" name="category" /> <br/>
			</fieldSet>
			
			<input class="btn btn-success" type="submit" value="Add"/>
			<!-- put the text into a variable "item" an send in in a request-->
		</form>
	</div>
	
<!-- FOOTER -->
	<footer class="footer">
		<p>Footer content</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>