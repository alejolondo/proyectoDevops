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
		<h1 class="text-primary"> ${book.title} </h1>
		<a href="/books"> back to the shelves</a>
		
		<p> <span class="text-success"> ${book.user.name} </span>  read <span class="text-primary"> ${book.title}</span> by <span class="text-danger">  ${book.autor} </span>   </p>
		
		<hr>
		<p> ${book.thoughts} </p>
		
		<div class="d-flex justify-content-between">
		<a href="/book/edit/${book.id }" class="btn btn-warning">Edit</a>
	<form action="/book/delete/${book.id }" method="post">
					 			<input type="hidden" name="_method" value="Delete">
					 			<input type="submit" value="Borar" class="btn btn-danger">
	</form>
		</div> 
		
	</div>
	
	
</body>
</html>