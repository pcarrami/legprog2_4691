<%@page import="com.edu.cibertec.matricula.entidades.Departamento"%>
		<header>
			<label>DEPARTAMENTOS</label>
		</header>
		
			<h2 class="text-center">MODIFICAR DEPARTAMENTO</h2>
			
			<%
				Departamento obj = (Departamento) request.getAttribute("obj");
			%>
		<div class="col-lg-6">
			<form action="#">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_depa" id="txt_id_depa" value="<%=obj.getId_depa()%>" readonly="readonly"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre" id="txt_nombre" value="<%=obj.getNombre()%>"><br>
				
				<input class="btn btn-primary" type="button" name="accion" id="accion" onclick="editDepartamento();" value="Actualizar">
				<a class="btn btn-danger" href="javascript:;" onclick="mostrarDepartamentos();">Regresar</a>
			</form>
		</div>