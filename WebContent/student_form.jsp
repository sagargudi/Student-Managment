<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	
	<link rel="stylesheet",href="Student Managemnet/WebContent/style.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-dark"
			style="background color: #9744be">
			<div>
				<label>Student Management</label>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class=nav-link>Student</a></li>
			</ul>
		</nav>
	</header>

	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test='${student!= null}'>
					<form action="update" method="post">
				</c:if>
				<c:if test='${student == null}'>
					<form action="insert" method="post">
				</c:if>

				<caption>

					<c:if test='${student != null}'>
						<h2>Edit Student</h2>
					</c:if>


					<c:if test='${student == null}'>
						<h2>Add New Student</h2>
					</c:if>



				</caption>

				<c:if test='${student != null}'>
					<input type="hidden" name="usn" value='${student.usn}' />
				</c:if>

				<fieldset class="form-group">
					<label>Student Name</label> <input type="text"
						value='${student.sname}' class="form-control" name="sname"
						required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Student Email</label> <input type="text"
						value='${student.email}' class="form-control" name="email">

				</fieldset>

				<fieldset class="form-group">
					<label>Student address</label> <input type="text"
						value='${student.address}' class="form-control" name="address">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>

</body>
</html>