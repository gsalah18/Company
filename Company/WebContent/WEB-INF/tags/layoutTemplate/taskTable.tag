<%@ attribute name="tasks" required="true" rtexprvalue="true"
	type="java.util.ArrayList"%>.
<%@ attribute name="userType" required="true" rtexprvalue="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<div class="form-group">
		<label for="taskSeachText">Search Text Field</label> <input
			type="text" id="taskSeachText" class="form-control"
			placeholder="Type to Search">
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Deadline</th>
				<th scope="col">Details</th>
			</tr>
		</thead>
		<tbody id="taskTable">
			<c:forEach var="task" items="${tasks}">
				<tr>
					<th scope="row">${task.id}</th>
					<td>${task.name}</td>
					<td>${task.deadline}</td>
					
					<c:if test="${sessionScope.userType == 'Team Leader' }">
						<c:set scope="page" value="teamleadertask" var="url"></c:set>
					</c:if>
					
					<c:if test="${sessionScope.userType == 'Developer' }">
						<c:set scope="page" value="developertask" var="url"></c:set>
					</c:if>
					
					<td><a href="${ url }?taskId=${ task.id }"><button class="btn btn-primary"				
					>Details</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
