
<%@page import="myStructmaven.RegisterBean.bean"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="myStructmaven.model.user"%>
<%@page import="java.util.List"%>
<%@page import="myStructmaven.DAO.daoOperations"%>
<%@page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



			<a href="views/addStudent.jsp"><button class="button-report"
					type="button">Resgister</button></a>
	<h2>STRUTS CRUD</h2>


	<div style="margin-top: 40px;">



		<table>
			<thead>
				<tr style="background-color: #E0E0E1;">
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Action</th>
				</tr>
			</thead>


			<%
			List<bean> myList = daoOperations.listUser();
			for (bean users : myList) {
			%>

			<tr>
				<td><%=users.getId()%></td>
				<td><%=users.getName()%></td>
				<td><%=users.getEmail()%></td>
				<td><%=users.getPassword()%></td>

				<td>

							
						<!-- going to update.jsp page inside views folder -->	
				<a href="views/updateStudent.jsp?id=<%= users.getId()%>">
						<button class="button-update">Update</button>
						<!-- going to deleteStudent action inside struts.xml -->
				</a> <a href="deleteStudent?id=<%= users.getId()%>">
						<button class="button-delete">Delete</button>
				</a>


				</td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
     <br>
   

</body>
</html>