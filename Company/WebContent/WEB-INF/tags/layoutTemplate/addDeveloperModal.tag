<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="modal" id="addDeveloperModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Developer</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<form id="addDeveloperFrom" method="post" action="adddeveloper">
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
							<label for="teamLeader">Team Leader</label> <select
								id="teamLeader" class="form-control" name="teamLeader">
								<c:forEach var="user" items="${users}">
									<option value="${user.id}">${user.name}</option>
								</c:forEach>
							</select>
						</div>

					</div>


					<div class="modal-footer">
						<button type="submit" class="btn btn-primary"
							onclick="addDeveloper()">Add</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
