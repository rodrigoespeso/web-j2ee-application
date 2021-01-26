<!-- HEADER -->
<%@include file ="../common/header.jspf"%>

<!-- NAVIGATION BAR -->
<%@include file ="../common/navigation.jspf"%>
	
<!-- BODY (already open tag) -->
<div class="container">
	Your New Action Item:
	<form action="/add-item.do" method="post">
		<!-- The request to perform is GET if is not specified -->
		<!-- Put the text into a item" and "category" variables and send them in a request-->
		<fieldSet class="form-group">
			<label>Description</label> <input class="form-control" type="text"
				name="item" /> <br />
		</fieldSet>
		<fieldSet class="form-group">
			<label>Category</label> <input class="form-control" type="text"
				name="category" /> <br />
		</fieldSet>

		<input class="btn btn-success" type="submit" value="Add" />
	</form>
</div>

<!-- FOOTER -->
<%@include file="../common/footer.jspf"%>