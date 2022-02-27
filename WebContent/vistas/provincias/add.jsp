<%@page import="com.edu.cibertec.matricula.entidades.Departamento"%>
<%@page import="java.util.List"%>
<%@ include file="../../templates/arriba.jsp" %>


	<div class="container-fluid">
		<header>
			<label>PROVINCIAS</label>
		</header>
		
			<h2 class="text-center">AGREGAR PROVINCIA</h2>
			
			<% List<Departamento> lstDepartamentos =  (List<Departamento>) request.getAttribute("lstDepartamentos"); %>
		<div class="col-lg-6">
			<form action="./provincias" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_prov"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre"><br>
				DEPARTAMENTOS:
				<select class="form-control" name="cb_id_depa">
					<%
						if(lstDepartamentos != null)
							for(Departamento items: lstDepartamentos){ %>
								<option value="<%=items.getId_depa()%>"> <%=items.getNombre() %></option>
					<%	
						}
					%>
					
					
				</select><br>
				
				<input class="btn btn-primary" type="submit" name="accion" value="Agregar"><br>
			
			</form>
		</div>
	
	</div>
<%@ include file="../../templates/abajo.jsp" %>
