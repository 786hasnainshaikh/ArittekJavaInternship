<%@page import="com.actions.Model.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <!-- if session object is null redirect it to index page -->
       <%
      user user=  (user) session.getAttribute("loggedIn");
      if (user == null){
    	  response.sendRedirect("index.jsp");
      } 
    
     %>   
      
    <h1>welcome page</h1>
     <h2>Welcome, <s:property  value="username"/>  !</h2>
     <a href="logout">logout</a>
</body>
</html>