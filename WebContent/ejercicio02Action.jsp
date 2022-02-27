<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EJERCICIO 02</title>

<%--configuración Font Awesome (iconos) --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<%--configuración boostrap (estilos) --%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >

<link rel="stylesheet" href="./css/style.css" type="text/css">

</head>
<body>

<%
	int codigo = Integer.parseInt(request.getParameter("txt_codigo"));
	String mensaje = "";
	
	if(codigo== 1234){
		mensaje = "Bienvenido GRUPO SISTEMAS";
	}else if(codigo ==  4321){
		mensaje = "Bienvenido GRUPO ADMINISTRACION";
	}else{
		mensaje = "CODIGO INCORRECTO";
	}
	
	request.setAttribute("mensaje", mensaje);
	pageContext.forward("respuesta.jsp");

%>


</body>
</html>