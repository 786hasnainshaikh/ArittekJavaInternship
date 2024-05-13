<%@page import="java.sql.Connection"%>
<%@page import="com.actions.connection.DAOconnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<h2>login page</h2>
    <s:form action="login" method="get">
     <s:textfield label="Enter username" name="username"></s:textfield>
     <s:textfield label="Enter password" name="password"></s:textfield>
     <s:submit></s:submit>
    </s:form>
</body>
</html>