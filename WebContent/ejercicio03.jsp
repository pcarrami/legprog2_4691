<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EJERCICIO 03</title>

<%--configuración Font Awesome (iconos) --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<%--configuración boostrap (estilos) --%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >

<link rel="stylesheet" href="./css/style.css" type="text/css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

<script type="text/javascript" src="./js/tutores.js"></script>

</head>
<body>

<header>
	<label>EJERCICIO 03</label>
</header>

<div class="container">
	<div id="divRegistro" class="col-lg-4 offset-lg-4">
		<h2 class="text-center">Registro de Tutor</h2>
		<form id="frmRegistro" action="./tutores" method="post">
			<div class="form-group">
				<label for="txt_dni">DNI:</label><br>
				<input class="form-control" type="text" id="txt_dni" name="txt_dni" >
			</div>
			<div class="form-group">
				<label for="txt_nombre">NOMBRE:</label><br>
				<input class="form-control" type="text" id="txt_nombre" name="txt_nombre" >
			</div>
			<div class="form-group">
				<label for="txt_ape_paterno">APELLIDO PATERNO:</label><br>
				<input class="form-control" type="text" id="txt_ape_paterno" name="txt_ape_paterno" >
			</div>
			<div class="form-group">
				<label for="txt_ape_materno">APELLIDO MATERNO:</label><br>
				<input class="form-control" type="text" id="txt_ape_materno" name="txt_ape_materno" >
			</div>
			<div class="form-group">
				<input class="btn btn-outline-primary" type="submit" id="btn_procesar" name="btn_procesar" value="Procesar">
			</div>
		</form>
	</div>
</div>



</body>
</html>