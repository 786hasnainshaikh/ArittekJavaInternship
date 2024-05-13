<%@page import="myStructmaven.model.user"%>
<%@page import="myStructmaven.DAO.daoOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <!-- getting single user to set values in form and then user can set as per requirement -->
     <%
      int id = Integer.parseInt( request.getParameter("id"));
     user sinUser = daoOperations.getSingleStudent(id);
     %>
     


   <h1>Update Student</h1>

     <form action="updateData" method="get">
       <label>Enter name</label> <input name="name" value="<%= sinUser.getName() %>">
       <br>
       <label>Enter name</label> <input name="email" value="<%= sinUser.getEmail() %>">
       <br>
       <label>Enter name</label> <input name="password" value="<%= sinUser.getPassword() %>">
       
      <input name="id" value="<%= sinUser.getId() %>" type="hidden">
        <button type="submit">Update</button>
     </form>
     
</body>
</html>