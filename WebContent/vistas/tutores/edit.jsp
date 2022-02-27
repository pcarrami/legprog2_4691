<%@page import="com.edu.cibertec.matricula.entidades.Provincia"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.cibertec.matricula.entidades.Tutor"%>

<%@ include file="../../templates/arriba.jsp" %>

	<div class="container-fluid">
		<header>
			<label>TUTORES</label>
		</header>

			<h2 class="text-center">MODIFICAR TUTOR</h2>
			
			<%
				Tutor obj = (Tutor) request.getAttribute("obj");
				List<Provincia> lstProvincias =  (List<Provincia>) request.getAttribute("lstProvincias"); 
			%>
		<div class="col-lg-6">
			<form action="./tutores" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_tutor" value="<%=obj.getId_tutor()%>"><br>
				DNI: <br>
				<input class="form-control" type="text" name="txt_dni" value="<%=obj.getDni()%>"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre" value="<%=obj.getNombre()%>"><br>
				APE. PATERNO: <br>
				<input class="form-control" type="text" name="txt_papellido" value="<%=obj.getPapellido()%>"><br>
				APE. MATERNO: <br>
				<input class="form-control" type="text" name="txt_sapellido" value="<%=obj.getSapellido()%>"><br>
				FECHA NACIMIENTO: <br>
				<input class="form-control" type="text" id="txt_fnacimiento" name="txt_fnacimiento" value="<%=obj.getFnacimiento()%>"><br>
				TELEFONO: <br>
				<input class="form-control" type="text" name="txt_telefono" value="<%=obj.getTelefono()%>"><br>
				PROVINCIAS:
				<select class="form-control" name="cb_id_prov">
					<%
						if(lstProvincias != null)
							for(Provincia items: lstProvincias){ 
					%>
								<option value="<%=items.getId_prov()%>" <%if(items.getId_prov()==obj.getId_prov()){ %>selected<% } %>> <%=items.getNombre() %></option>
					<%	
						}
					%>
					
					
				</select><br>
				
				<input class="btn btn-primary" type="submit" name="accion" value="Actualizar"><br>
			
			</form>
			
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