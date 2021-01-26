<!-- HEADER -->
<%@include file ="../common/header.jspf"%>

<!-- NAVIGATION BAR -->
<%@include file ="../common/navigation.jspf"%>

<!-- BODY (already open tag) -->
<div class="container">
	<H1>Welcome ${user}</H1>

	<p>Your Items are:</p>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Description</th>
				<th>Category</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
				<!-- 'c' is the reference to use JSTL core library -->
				<tr>
					<td>${item.name}</td>
					<td>${item.category}</td>
					<td>&nbsp;&nbsp;<a class="btn btn-danger"
						href="/delete-item.do?item=${item.name}&category=${item.category}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- Previous version. Ordered List -->
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
<%@include file="../common/footer.jspf"%>
	
	
