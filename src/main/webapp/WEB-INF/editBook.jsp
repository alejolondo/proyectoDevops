<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
      
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
   <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books Share</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1>Change your Entry</h1>
		<a href="/books"> back to the shelves</a>
		
		<form:form action="/book/edit/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="PUT">
					<div class="form-group">
						<form:label path="title">Title:</form:label>
						<form:input path="title" class="form-control" />
						<form:errors path="title" class="text-danger"/>
					</div>
					
					<div class="form-group">
						<form:label path="autor">Author:</form:label>
						<form:input path="autor" class="form-control" />
						<form:errors path="autor" class="text-danger"/>
					</div>
					
					<div class="form-group">
						<form:label path="thoughts">My thoughts:</form:label>
						<form:input path="thoughts" class="form-control" />
						<form:errors path="thoughts" class="text-danger"/>
					</div>
					
					<input type="submit" class="btn btn-info" value="Submit">
				</form:form>
	</div>
</body>
</html>