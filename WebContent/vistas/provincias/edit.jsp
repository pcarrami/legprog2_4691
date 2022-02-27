<%@page import="com.edu.cibertec.matricula.entidades.Departamento"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.cibertec.matricula.entidades.Provincia"%>
<%@ include file="../../templates/arriba.jsp" %>
	<div class="container-fluid">
		<header>
			<label>PROVINCIAS</label>
		</header>

			<h2 class="text-center">MODIFICAR PROVINCIA</h2>
			
			<%
				Provincia obj = (Provincia) request.getAttribute("obj");
				List<Departamento> lstDepartamentos =  (List<Departamento>) request.getAttribute("lstDepartamentos"); 
			%>
		<div class="col-lg-6">
			<form action="./provincias" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_prov" value="<%=obj.getId_prov()%>" readonly="readonly"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre" value="<%=obj.getNombre()%>"><br>
				DEPARTAMENTOS:
				<select class="form-control" name="cb_id_depa">
					<%
						if(lstDepartamentos != null)
							for(Departamento items: lstDepartamentos){ %>
								<option value="<%=items.getId_depa()%>"  <%if(items.getId_depa()==obj.getId_depa()){ %>selected<% } %>  > <%=items.getNombre() %></option>
					<%	
						}
					%>
					
					
				</select><br>
				<input class="btn btn-primary" type="submit" name="accion" value="Actualizar"><br>
			
			</form>
		</div>
	
	</div>
<%@ include file="../../templates/abajo.jsp" %>
