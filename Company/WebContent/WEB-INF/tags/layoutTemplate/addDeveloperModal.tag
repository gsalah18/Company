<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="teamLeaders" required="true" rtexprvalue="true" type="java.util.ArrayList"%>
<body>
	<div class="modal" id="addDeveloperModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Developer</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<form id="addDeveloperForm" method="post" action="adduser" name="addDeveloperForm">
					<div class="modal-body">

						<div class="form-group">
							<label for="for">Name</label> <input name="name" id="name"
								class="form-control" type="text" placeholder="Enter The Name">
						</div>

						<div class="form-group">
							<label for="password">Password</label> <input name="password"
								id="password" class="form-control" type="password"
								placeholder="Enter The Password">
						</div>
						
						<div class="form-group">
							<label for="manager">Team Leader</label> <select
								id="manager" class="form-control" name="manager">
								<c:forEach var="teamLeader" items="${teamLeaders}">
									<option value="${teamLeader.id}">${teamLeader.name}</option>
								</c:forEach>
							</select>
						</div>
						<input type="hidden" name="type"  value="2">

					</div>


					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Add</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal"
							id="developerModalClose">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
