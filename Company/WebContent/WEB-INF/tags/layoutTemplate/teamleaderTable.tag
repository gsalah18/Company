<%@ attribute name="teamLeaders" required="true" rtexprvalue="true" type="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<div class="form-group">
		<label for="teamLeaderSeachText">Search Text Field</label> <input type="text"
			id="teamLeaderSeachText" class="form-control" placeholder="Type to Search">
	</div>
	<table class="table" >
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Tasks</th>
				<th scope="col">Developers</th>
			</tr>
		</thead>

		<tbody id="teamLeaderTable">
			<c:forEach var="teamLeader" items="${teamLeaders}">
				<tr>
					<th scope="row">${teamLeader.id}</th>
					<td>${teamLeader.name}</td>
					<td><a href="tasks?user_id=${teamLeader.id}&user_type=Team Leader"><button
								class="btn btn-primary">Show Tasks</button></a></td>
					<td><a href="developers?user_id=${teamLeader.id}"><button
								class="btn btn-primary">Show Developers</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
