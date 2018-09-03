<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layoutTemplate" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Developers</title>
</head>
<body>
	<layout:header backgroundColor="#0080ff"/>
	<div class="container" style="padding: 20px">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<h1>Developers</h1>
			</div>
		</div>
		
		<div class="row" style="padding-top: 20px">
			<div class="col-md-8 offset-md-2">
				<table class="table">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Tasks</th>
					</tr>
					
					<c:forEach var="user" items="${developers}">
						<tr>
							<th scope="row">${user.id}</th>
							<td>${user.name}</td>
							<td><a href="tasks?user_id=${user.id}"><button class="btn btn-primary">Show Tasks</button></a></td>
							
						</tr>
					</c:forEach>
				</table>
			</div>
		</div> 
	</div>
</body>
</html>