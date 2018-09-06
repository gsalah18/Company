<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layoutTemplate" prefix="layout" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team Leader Home</title>
</head>
<body>
	<layout:header backgroundColor="#009900"/>
	
	<div class="container">
		<div class="row" style="padding: 20px">
			<div class="col-md-5">
				<h3>Task</h3>
				<layout:taskTable tasks="${ tasks }" userType="Team Leader"/>
			</div>
			<div class="col-md-5 offset-md-2">
				<h3>Developers</h3>
				<layout:developerTable developers="${ developers }"/>
			</div>
		</div>
	</div>
</body>
</html>