<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Edit Student</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>

    <div class="container">

        <h1 class="p-3"> Edit Student </h1>


        <form:form action="/editSaveStudent" method="post" modelAttribute="student">
			<form:input path="id" type="hidden"/>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="name">Student Name</label>
					<div class="col-md-6">
						<form:input type="text" path="name" id="name"
									class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="age">Age</label>
					<div class="col-md-6">
						<form:input type="text" path="age" id="age"
									class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="course">Course</label>
					<div class="col-md-6">
						<form:select type="select" path="course" id="course"
									 class="form-control select-sm" required="required">
							<option value="Course" id="course">Select</option>
							<option value="Java" id="course">Java</option>
							<option value="Python" id="course">Python</option>
						</form:select>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="gender">Gender</label>
					<div class="col-md-6">
						<form:radiobutton path="gender" id="gender" value="Male" /> Male
						<span>&nbsp;</span>
						<form:radiobutton path="gender" id="gender" value="Female" /> Female

					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="date">Date Of Birth</label>
					<div class="col-md-6">
						<form:input type="date" path="date" id="date"
									class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="address">Address</label>
					<div class="col-md-6">
						<form:textarea type="textarea" path="address" id="address"
									   class="form-control input-sm" value="Type here" />
					</div>
				</div>
			</div>

			<div class="row p-2">
				<div class="col-md-2">
					<button type="submit" value="Register" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
				</div>
			</div>

        </form:form>

    </div>



</body>

</html>