<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>

<h3>Menu Principal</h3>

<br>

<a href="${pageContext.request.contextPath}/api/crear">Crear cliente</a>

<br><br>

<a href="${pageContext.request.contextPath}/api/clientes">Obtener lista de clientes</a>

<br><br>

<a href="${pageContext.request.contextPath}/api/clientes/1">Obtener cliente por id </a> <sub>(Agregar al final de la URL /{id}. Siendo {id} es el numero del id que queres retornar)</sub>

</body>
</html>