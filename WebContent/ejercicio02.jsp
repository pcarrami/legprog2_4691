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

<header>
	<label>EJERCICIO 02</label>
</header>

<div class="container">
	<form name="frmAcceso" action="./ejercicio02Action.jsp" method="post">
		<table>
			<tr>
				<th colspan="2">Control de Acceso</th>
			</tr>
			<tr>
				<td>Ingrese código: </td>
				<td><input class="form-control" type="text" name="txt_codigo"></td>
			</tr>
			<tr>
			</tr>
				<td colspan="2" align="center">
					<input class="btn btn-outline-primary" name="btn_procesar" type="submit" value="Procesar">
				</td>
			</tr>
		</table>
	</form>
	
</div>



</body>
</html>