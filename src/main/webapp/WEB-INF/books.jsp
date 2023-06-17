<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1 class="text-primary">Welcome, ${userSession.name}</h1>
		<p> Books from everyone's shelves</p>
		<div class="d-flex justify-content-between">
		<a href="/saveBook" class="btn btn-success">+ add a to my shell</a>
		<a href="/" class="btn btn-danger"> Log Out </a>
		</div>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th> ID </th>
					<th> Title </th>
					<th> Author Name </th>
					<th> Posted By </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
				<tr>
					<td> ${book.id}</td>
					<td> <a href="book/${book.id}">  ${book.title} </a></td>
					<td> ${book.autor}</td>
					<td> ${book.user.name} </td>
				</tr>
				</c:forEach>
				
			</tbody>		
		</table>
	</div>
</body>
</html>