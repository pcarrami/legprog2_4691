<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EJERCICIO 01</title>

<%--configuración Font Awesome (iconos) --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<%--configuración boostrap (estilos) --%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >

<link rel="stylesheet" href="./css/style.css" type="text/css">

</head>
<body>

<header>
	<label>EJERCICIO 01</label>
</header>

<div class="container">
	<%
		String txt ="";
		int n = 10;
		
		for(int i=1; i<=n; i++){
			int num = (int) (Math.random()*21);
			txt +=num + " ";
			for(int j=1; j<=num;j++){
				txt +="*";
			}
			txt +="<br>";
		}
	
	%>
	
	<%=txt%>
	
	<a class="btn btn-outline-dark" href="./index.jsp">Regresar</a>
</div>



</body>
</html>