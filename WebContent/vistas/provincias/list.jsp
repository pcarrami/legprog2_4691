<%@page import="com.edu.cibertec.matricula.entidades.Provincia"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../../templates/arriba.jsp" %>
<div class="container-fluid">
	<header>
		<label>PROVINCIAS</label>
	</header>
		<%
			String valor = String.valueOf(request.getAttribute("valor"));
		%>
		<h2 class="text-center">Lista de Provincias</h2>
		<div class="navbar">
			<a class="btn btn-outline-success" href="./provincias?accion=add">+ Nuevo</a>
			
			<form class="form-inline" action="./provincias" method="post">
				<input class="form-control" type="search" name="txt_buscar" value="<%=valor%>">
				<input class="btn btn-outline-success" type="submit" name="accion" value="Buscar">
			</form>
			
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">NOMBRE</th>
					<th class="text-center">DEPARTAMENTO</th>
					<th class="text-center">ACCIONES</th>
				</tr>
			</thead>
			<%
				ArrayList<Provincia> lista = (ArrayList<Provincia>) request.getAttribute("lista");
			
			%>
			<tbody>
			<% if(lista !=null) 
				for(Provincia items : lista){
				
			%>
				<tr>
					<td class="text-center"><%=items.getId_prov() %></td>
					<td class="text-center"><%=items.getNombre() %></td>
					<td class="text-center"><%=items.getDes_id_depa() %></td>
					<td class="text-center">
						<a class="btn btn-outline-warning" href="./provincias?accion=edit&p_id_prov=<%=items.getId_prov()%>">Editar</a>
						<a class="btn btn-outline-danger" href="./provincias?accion=delete&p_id_prov=<%=items.getId_prov()%>">Eliminar</a>
					</td>
				</tr>
			
			<%
				}
			
			%>

			</tbody>
		
		</table>
</div>
<%@ include file="../../templates/abajo.jsp" %>
