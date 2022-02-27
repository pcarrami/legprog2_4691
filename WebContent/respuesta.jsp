<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INICIO</title>
<%--configuración Font Awesome (iconos) --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<%--configuración boostrap (estilos) --%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >

<link rel="stylesheet" href="./css/style.css" type="text/css">
</head>
<body>

<header>
	<label>RESPUESTA</label>
</header>
<% String mensaje = String.valueOf(request.getAttribute("mensaje")); %>

<h2>Mensaje: <%=mensaje%></h2>

</body>
</html>