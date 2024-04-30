<%@page import="com.crudDemo.entities.book"%>
<%@page import="java.util.List"%>
<%@page import="com.crudDemo.DAO.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="container">
		<div class="row">
			<div class="col-md-12 mt-5">

				<div class="card">
					<div class="card-body">
						<h1 class="text-center">Book Management System</h1>
				
						<table class="table">
							<thead class="thead-light">
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Book Name</th>
									<th scope="col">author</th>
									<th scope="col">location</th>
									
								</tr>
							</thead>

							<tbody>

                 <!-- java code start -->
						<% List<book> list=  Dao.showAllBooks(); 
						  
						for(book items: list){ %>
							
							<tr>
									<th scope="row"> <%= items.getBookId() %> </th>
									<td> <%= items.getBookName() %> </td>
									<td> <%=items.getAuthor() %> </td>
									<td> <%=items.getLocation() %> </td>
					

									<td>
									
									<a href="edit.jsp?id=<%=items.getBookId()%>" > eidt </a>
									<a href="delete?id=<%=items.getBookId()%>" >delete</a>
											
							    	</td>
								</tr>
						<%}
						%>
			
							</tbody>

						</table>

						<div class="text-center mt-5">
							<a class="btn btn-outline-success" href="addBook.jsp">Add
								Student</a>
						</div>

					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>