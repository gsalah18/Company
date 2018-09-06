<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/customTags/getTaskFunc.tld" prefix="tldFunctions"%>
<%@ taglib tagdir="/WEB-INF/tags/layoutTemplate" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<c:set var="task" scope="page" value="${tldFunctions:getTask(param.taskId)}" />
	<script type="text/javascript" src="js/assignTask.js"></script>
<title>${ task.name }</title>
</head>
<body>
	
	<script type="text/javascript" src="js/changeState.js"></script>
	<layout:header backgroundColor="#000" />


	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<h2>${ task.name }</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-8 offset-md-2">
				<p>
					<strong>Task Description</strong> : ${ task.desc }
				</p>
			</div>
		</div>

		<!-- Selected Configuration -->
		<c:choose>
			<c:when test="${task.state == 'Done' }">
				<c:set var="doneSelected" scope="page" value="selected" />
			</c:when>
			<c:otherwise>
				<c:set var="inProgressSelected" scope="page" value="selected" />
			</c:otherwise>
		</c:choose>


		<!-- End -->
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<h4>Task State : ${task.state }</h4>
				<c:if test="${sessionScope.userType == 'Developer'}">
					<form action="state" method="post" id="stateForm">
						<div class="form-group">
							<label for="stateSelect">Change Task State : </label> <select
								name="state" class="form-control">
								<option value="0" ${inProgressSelected }>In Progress</option>
								<option value="1" ${doneSelected}>Done</option>
							</select>
						</div>
						<input type="hidden" value="${ task.id }" name="taskId">

						<button type="submit" class="btn btn-primary">Change
							State</button>

					</form>
				</c:if>
				
			</div>
		</div>
		<c:if test="${sessionScope.userType == 'Developer'}">
			
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<form method="POST" action="assigntask" id="assignTaskForm">
						<div class="form-group">
							<select name="receiverId" class="form-control">
								<c:forEach var="user" items="${ tldFunctions: getUsers()}">
									<option  value="${ user.id }"> ${ user.name } , ${ user.type }</option>
								</c:forEach>
							</select>
						</div>
						<input type="hidden" value="${ task.id }" name="taskId">
						<button class="btn btn-primary" type="submit">Assign Task</button>					
					</form>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>