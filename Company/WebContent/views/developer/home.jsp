<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layoutTemplate" prefix="layout" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Developer Home</title>
</head>
<body>
	<layout:header backgroundColor="#ff4d94"/>
	<div class="container">
		<div class="row" style="padding: 20px">
			<div class="col-md-4 offset-md-1">
				<h3>Team Leader : ${ teamLeader }</h3>
			</div>
		</div>
	
		<div class="row" style="padding: 20px">
			<div class="col-md-8 offset-md-2">
				<h3>Tasks</h3>
				<layout:taskTable tasks="${ tasks }" userType="Developer" ></layout:taskTable>
			</div>
		</div>
	</div>
</body>
</html>