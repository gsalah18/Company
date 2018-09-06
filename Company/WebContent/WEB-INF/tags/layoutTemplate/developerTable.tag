<%@ attribute name="developers" required="true" rtexprvalue="true"
	type="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="form-group">
		<label for="developerSeachText">Search Text Field</label> <input
			type="text" id="developerSeachText" class="form-control"
			placeholder="Type to Search">
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Tasks</th>
			</tr>
		</thead>

		<tbody id="developerTable">
			<c:forEach var="user" items="${developers}">
				<tr>
					<th scope="row">${user.id}</th>
					<td>${user.name}</td>
					<td><a href="tasks?user_id=${user.id}&user_type=Developer"><button
								class="btn btn-primary">Show Tasks</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>