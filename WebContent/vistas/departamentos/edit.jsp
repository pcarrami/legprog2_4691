<%@page import="com.edu.cibertec.matricula.entidades.Departamento"%>
<%@ include file="../../templates/arriba.jsp" %>
	<div class="container-fluid">
		<header>
			<label>DEPARTAMENTOS</label>
		</header>
		
			<h2 class="text-center">MODIFICAR DEPARTAMENTO</h2>
			
			<%
				Departamento obj = (Departamento) request.getAttribute("obj");
			%>
		<div class="col-lg-6">
			<form action="./departamentos" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_depa" value="<%=obj.getId_depa()%>" readonly="readonly"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre" value="<%=obj.getNombre()%>"><br>
				
				<input class="btn btn-primary" type="submit" name="accion" value="Actualizar"><br>
			
			</form>
		</div>
	
	</div>
<%@ include file="../../templates/abajo.jsp" %>