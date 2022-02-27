<%@page import="com.edu.cibertec.matricula.entidades.Provincia"%>
<%@page import="java.util.List"%>
<%@ include file="../../templates/arriba.jsp" %>


	<div class="container-fluid">
		<header>
			<label>TUTORES</label>
		</header>
		
			<h2 class="text-center">AGREGAR TUTOR</h2>
			
			<% List<Provincia> lstProvincias =  (List<Provincia>) request.getAttribute("lstProvincias"); %>
		<div class="col-lg-6">
			<form action="./tutores" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_tutor"><br>
				DNI: <br>
				<input class="form-control" type="text" name="txt_dni"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre"><br>
				APE. PATERNO: <br>
				<input class="form-control" type="text" name="txt_papellido"><br>
				APE. MATERNO: <br>
				<input class="form-control" type="text" name="txt_sapellido"><br>
				FECHA NACIMIENTO: <br>
				<input class="form-control" type="text" name="txt_fnacimiento" id="txt_fnacimiento" readonly><br>
				TELEFONO: <br>
				<input class="form-control" type="text" name="txt_telefono"><br>
				PROVINCIAS:
				<select class="form-control" name="cb_id_prov">
					<%
						if(lstProvincias != null)
							for(Provincia items: lstProvincias){ %>
								<option value="<%=items.getId_prov()%>"> <%=items.getNombre() %></option>
					<%	
						}
					%>
					
					
				</select><br>
				
				<input class="btn btn-primary" type="submit" name="accion" value="Agregar"><br>
			
			</form>
		</div>
	
	</div>
	
	<script type="text/javascript">
	
	$("#txt_fnacimiento").datepicker({
		language: "es",
		todayBtn: "linked",
		clearBtn: true,
		format: "yyyy-mm-dd"
	});
	
	</script>

<%@ include file="../../templates/abajo.jsp" %>