<%@ include file="../../templates/arriba.jsp" %>

	<div class="container-fluid">
		<header>
			<label>DEPARTAMENTOS</label>
		</header>
	

			<h2 class="text-center">AGREGAR DEPARTAMENTO</h2>
		<div class="col-lg-6">
			<form action="./departamentos" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_depa"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre"><br>
				
				<input class="btn btn-primary" type="submit" name="accion" value="Agregar"><br>
			
			</form>
		</div>
	
	</div>

<%@ include file="../../templates/abajo.jsp" %>