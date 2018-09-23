<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World Form</title>
</head>
<body>

Ingresa tu nombre:
<form action="processForm" method=GET>
	<input type="text" name="clienteNameFieldForm">
	<input type="submit"/>
</form>

Ingresa tu mensaje:
<form action="processFormUpperCase" method=GET>
	<input type="text" name="clienteNameFieldForm">
	<input type="submit"/>
</form>

Ingresa tu mensaje:
<form:form action="processFormInstanciarClienteUpperCase" modelAttribute="cliente">
	<form:input path="primerNombre"/>
	<input type="submit"/>
</form:form>

</body>
</html>