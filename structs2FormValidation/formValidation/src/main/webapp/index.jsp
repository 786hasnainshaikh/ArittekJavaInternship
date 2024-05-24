<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>form validation</title>
<s:head/>
</head>
<body>
     <s:form action="processForm" method="post">
     <s:textfield label="Enter username" name="userName"></s:textfield>
     <s:textfield label="Enter password" name="password"></s:textfield>
     <s:submit></s:submit>
    </s:form>
</body>
</html>