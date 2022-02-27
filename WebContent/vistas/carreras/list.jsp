<%@page import="com.edu.cibertec.matricula.entidades.Carrera"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../../templates/arriba.jsp" %>
<div class="container-fluid">
		<header>
			<label>CARRERAS</label>
		</header>
		<%
			String valor = String.valueOf(request.getAttribute("valor"));
		%>
		<h2 class="text-center">Lista de Carreras</h2>
		<div class="navbar">
			<a class="btn btn-outline-success" href="./carreras?accion=add">+ Nuevo</a>
			
			<form class="form-inline" action="./carreras" method="post">
				<input class="form-control" type="search" name="txt_buscar" value="<%=valor%>">
				<input class="btn btn-outline-success" type="submit" name="accion" value="Buscar">
			</form>
			
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">NOMBRE</th>
					<th class="text-center">ACCIONES</th>
				</tr>
			</thead>
			<%
				ArrayList<Carrera> lista = (ArrayList<Carrera>) request.getAttribute("lista");
			
			%>
			<tbody>
			<% if(lista !=null) 
				for(Carrera items : lista){
				
			%>
				<tr>
					<td class="text-center"><%=items.getId_carrera() %></td>
					<td class="text-center"><%=items.getNombre() %></td>
					<td class="text-center">
						<a class="btn btn-outline-warning" href="./carreras?accion=edit&p_id_carrera=<%=items.getId_carrera()%>">Editar</a>
						<a class="btn btn-outline-danger" href="./carreras?accion=delete&p_id_carrera=<%=items.getId_carrera()%>">Eliminar</a>
					</td>
				</tr>
			
			<%
				}
			
			%>

			</tbody>
		
		</table>
</div>
<%@ include file="../../templates/abajo.jsp" %>