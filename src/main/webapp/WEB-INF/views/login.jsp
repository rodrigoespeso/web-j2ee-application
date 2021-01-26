<!-- HEADER -->
<%@include file ="../common/header.jspf"%>

<!-- NAVIGATION BAR -->
<%@include file ="../common/navigation.jspf"%>

<!-- BODY (already open tag) -->
<div class="container">
	<form action="/login.do" method="post">
		<!-- 'action' specify who handle this form: a post request -->
		<p>
			<!-- If "errorMessage" variable is not informed do not print nothing -->
			<font color="red">${errorMessage}</font>
		</p>
		User: <input type="text" name="user" />
		Password: <input type="password" name="password" />
		<input type="submit" value="Login" />
	</form>
</div>

<!-- FOOTER -->
<%@include file="../common/footer.jspf"%>

