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
	<label>MENU</label>
</header>
<h2><a href="./ejercicio01.jsp">Ejercicio 01</a></h2>
<h2><a href="./ejercicio02.jsp">Ejercicio 02</a></h2>
<h2><a href="./ejercicio03.jsp">Ejercicio 03</a></h2>

<h2><a href="./departamentos?accion=listar">Ir a Departamentos</a></h2>
<h2><a href="./carreras?accion=listar">Ir a Carreras</a></h2>
<h2><a href="./provincias?accion=listar">Ir a Provincias</a></h2>
<h2><a href="./tutores?accion=listar">Ir a Tutores</a></h2>

</body>
</html>