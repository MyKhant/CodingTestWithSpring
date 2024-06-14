<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Student List</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>

</head>
<body>

<div class="container">

    <h1 class="p-3"> Student List</h1>

    <form:form>

        <table class="table table-bordered">
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Course</th>
                <th>Gender</th>
                <th>Birth Date</th>
                <th>Address</th>
                <th>Edit</th>
                <th>Delete</th>
                <th>Print</th>
            </tr>

            <c:forEach var="student" items="${list}">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.course}</td>
                    <td>${student.gender}</td>
                    <td>${student.date}</td>
                    <td>${student.address}</td>
                    <td><button type="button" class="btn btn-primary">
                        <a href="/editStudent/${student.id}">Edit</a>
                    </button></td>
                    <td><button type="button" class="btn btn-danger">
                        <a href="/deleteStudent/${student.id}">Delete</a>
                    </button></td>
                    <td><button type="button" class="btn btn-success">
                        <a href="/report/pdf">Print</a>
                    </button></td>
                </tr>

            </c:forEach>

        </table>

    </form:form>

    <button type="button" class="btn btn-primary btn-block">
        <a href="/addStudent">Add New Student</a>
    </button>

</div>



</body>

</html>