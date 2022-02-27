<%@page import="com.edu.cibertec.matricula.entidades.Carrera"%>


<%@ include file="../../templates/arriba.jsp" %>
	<div class="container-fluid">
		<header>
			<label>CARRERAS</label>
		</header>
		
			<h2 class="text-center">MODIFICAR CARRERA</h2>
			
			<%
				Carrera obj = (Carrera) request.getAttribute("obj");
			%>
		<div class="col-lg-6">
			<form action="./carreras" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_carrera" value="<%=obj.getId_carrera()%>" readonly="readonly"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre" value="<%=obj.getNombre()%>"><br>
				
				<input class="btn btn-primary" type="submit" name="accion" value="Actualizar"><br>
			
			</form>
		</div>
	
	</div>
<%@ include file="../../templates/abajo.jsp" %>
