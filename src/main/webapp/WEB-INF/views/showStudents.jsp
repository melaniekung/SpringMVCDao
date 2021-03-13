<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Students</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<h1>Student List</h1>
		<hr />
		<c:if test="${message != null }">
			<div class="alert alert-success" role="alert">${message }</div>
		</c:if>
		<table class="table table-striped table-bordered">
			<tr>
				<td>Student Id</td>
				<td>Student Name</td>
				<td>Student Email</td>
				<td>Delete</td>
			</tr>
			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id }</td>
					<td>${student.name }</td>
					<td>${student.email }</td>
					<td><A HREF="/DAO-mku-03/deleteStudent/?id=${student.id }">Delete</A></td>
				</tr>
			</c:forEach>
		</table>
		<h3>Create Student</h3>
		<form:form action="/DAO-mku-03/createStudent/"
			cssClass="form-horizontal" method="post" modelAttribute="student">
			<div class="form-group">
				<label for="name" class="col-md-3 control-label">Name</label>
				<div class="col-md-9">
					<form:input path="name" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-md-3 control-label">Email</label>
				<div class="col-md-9">
					<form:input path="email" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btn-primary">Submit</form:button>
				</div>
			</div>
		</form:form>

		<h3>Edit Student</h3>
		<form:form
			action="/DAO-mku-03/editStudent/"
			cssClass="form-horizontal" method="post" modelAttribute="student">
			<div class="form-group">
				<label for="id" class="col-md-3 control-label">Id</label>
				<div class="col-md-9">
					<form:input path="id" cssClass="form-control"/>
				</div>
				<label for="name" class="col-md-3 control-label">Name</label>
				<div class="col-md-9">
					<form:input path="name" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-md-3 control-label">Email</label>
				<div class="col-md-9">
					<form:input path="email" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btn-primary">Submit</form:button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>