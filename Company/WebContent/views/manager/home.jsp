<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layoutTemplate" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style type="text/css">
a:link {
	color: black
}

li {
	text-align: center;
}
</style>


</head>
<body>
	<layout:header backgroundColor="#000" />
	
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<h1>Team Leader</h1>
			</div>
		</div>
		<div class="row" style="padding-top: 20px">
			<div class="col-md-2 ">
				<div class="row" style="padding-top: 20px">
					<button type="button" class="btn btn-primary btn-lg"
						data-toggle="modal" data-target="#addTeamLeaderModal">Add
						Team Leader</button>

				</div>
				<div class="row" style="padding-top: 20px">
					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#addDeveloperModal">Add Developer</button>
				</div>
			</div>

			<div class="col-md-8 offset-md-2">
				<div class="form-group">
					<label for="seachText">Search Text Field</label> <input type="text"
						id="searchText" class="form-control" placeholder="Type to Search">
				</div>
				<table class="table" id="myTable">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Name</th>
							<th scope="col">Tasks</th>
							<th scope="col">Developers</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<th scope="row">${user.id}</th>
								<td>${user.name}</td>
								<td><a href="tasks?user_id=${user.id}"><button
											class="btn btn-primary">Show Tasks</button></a></td>
								<td><a href="developers?user_id=${user.id}"><button
											class="btn btn-primary">Show Developers</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>




	<layout:addTeamLeaderModal />
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
						<button type="submit" class="btn btn-primary">Add</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal"
							id="developerModalClose">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>