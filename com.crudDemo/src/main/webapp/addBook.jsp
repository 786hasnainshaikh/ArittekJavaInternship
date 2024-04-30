<%@page import="java.sql.Connection"%>
<%@page import="com.crudDemo.connections.connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page isELIgnored="false" %>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>


	<form action="addBook" method="get">
	
	<h2>Book Details</h2>
	
		<div class="form-group">
			<label for="exampleInputEmail1">Book Name</label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" name="name"> 
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Author</label> <input
				type="text" class="form-control" id="exampleInputPassword1" name="author">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">location</label> <input
				type="text" class="form-control" id="exampleInputPassword1"
				name="location"
				>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>



</body>
</html>