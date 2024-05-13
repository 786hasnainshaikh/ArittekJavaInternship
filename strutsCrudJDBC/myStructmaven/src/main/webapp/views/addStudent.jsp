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
   <h1>add student</h1>
   <s:form action="register" method="get">
         <s:textfield label="Enter name"  name="name"> </s:textfield>
         <br>
         <s:textfield label="Enter email " name="email"></s:textfield>
         <br>
         <s:textfield label="Enter password" name="password"></s:textfield>
         <br>
         <s:submit value="sumit"></s:submit>
         
     </s:form>
</body>
</html>