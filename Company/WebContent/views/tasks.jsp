<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layoutTemplate" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Tasks</title>
</head>
<body>
	<layout:header backgroundColor="#0080ff" />
	<div class="container" style="padding: 20px">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<h1>${userType} Tasks</h1>
			</div>
		</div>
		<div class="row" style="padding-top: 20px">
			<div class="col-md-2 offset-md-1">
				<c:if
					test="${(sessionScope.userType eq 'Manager' && requestScope.userType eq 'Team Leader')
					|| (sessionScope.userType eq 'Team Leader' && requestScope.userType eq 'Developer')
				}">
					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#addTaskModal">Add Task</button>
				</c:if>

			</div>
			<div class="col-md-8">
				<layout:taskTable tasks="${tasks}" userType="${ requestScope.userType }"/>
			</div>
		</div>
	</div>

	<layout:addTaskModal userId="${ userId }" />
</body>
</html>