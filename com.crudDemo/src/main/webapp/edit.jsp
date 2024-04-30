<%@page import="com.crudDemo.entities.book"%>
<%@page import="com.crudDemo.DAO.Dao"%>
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


<%
   String id= request.getParameter("id");
   int intId=Integer.parseInt(id);
   
   book sinBook= Dao.getBookById(intId);

%>


	<form action="editBook" method="post">
	
	<h2>Edit Student</h2>
		<div class="form-group">
			<label for="exampleInputEmail1">Book Name</label> <input
				type="text" class="form-control" 
				aria-describedby="emailHelp" name="name"   value="  <%=sinBook.getBookName()%>  "> 
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Author</label> <input
				type="text" class="form-control"  name="author" value=" <%=sinBook.getAuthor() %> ">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">location</label> <input
				type="text" class="form-control" 
				name="location" value=" <%= sinBook.getLocation() %> "
				>
		</div>
		
		<input type="hidden" name="id"  value="<%= sinBook.getBookId()%>"> 
		
		<button type="submit" class="btn btn-primary">Update book</button>
	</form>



</body>
</html>