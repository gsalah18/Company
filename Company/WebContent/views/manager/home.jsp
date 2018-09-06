<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layoutTemplate" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Home</title>
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
				<layout:teamleaderTable teamLeaders="${teamLeaders}"/>
			</div>

		</div>
	</div>




	<layout:addTeamLeaderModal />
	<layout:addDeveloperModal teamLeaders="${teamLeaders}"/>
</body>
</html>