<%@page import="com.edu.cibertec.matricula.entidades.Tutor"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="../../templates/arriba.jsp" %>
<div class="container-fluid">
	<header>
		<label>TUTORES</label>
	</header>
		<%
			String valor = String.valueOf(request.getAttribute("valor"));
		%>
		<h2 class="text-center">Lista de Tutores</h2>
		<div class="navbar">
			<a class="btn btn-outline-success" href="./tutores?accion=add">+ Nuevo</a>
			
			<form class="form-inline" action="./tutores" method="post">
				<input class="form-control" type="search" name="txt_buscar" value="<%=valor%>">
				<input class="btn btn-outline-success" type="submit" name="accion" value="Buscar">
				<a class="btn btn-outline-success" href="./tutores?accion=report" target="_blank">Reporte</a>
			</form>
			
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">DNI</th>
					<th class="text-center">NOMBRE</th>
					<th class="text-center">APE. PATERNO</th>
					<th class="text-center">APE. MATERNO</th>
					<th class="text-center">FEC. NACIMIENTO</th>
					<th class="text-center">TELEFONO</th>
					<th class="text-center">PROVINCIA</th>
					<th class="text-center">ACCIONES</th>
				</tr>
			</thead>
			<%
				ArrayList<Tutor> lista = (ArrayList<Tutor>) request.getAttribute("lista");
			
			%>
			<tbody>
			<% if(lista !=null) 
				for(Tutor items : lista){
				
			%>
				<tr>
					<td class="text-center"><%=items.getId_tutor() %></td>
					<td class="text-center"><%=items.getDni() %></td>
					<td class="text-center"><%=items.getNombre() %></td>
					<td class="text-center"><%=items.getPapellido() %></td>
					<td class="text-center"><%=items.getSapellido() %></td>
					<td class="text-center"><%=items.getFnacimiento() %></td>
					<td class="text-center"><%=items.getTelefono() %></td>
					<td class="text-center"><%=items.getDes_id_prov() %></td>
					<td class="text-center">
						<a class="btn btn-outline-warning" href="./tutores?accion=edit&p_id_tutor=<%=items.getId_tutor()%>">Editar</a>
						<a class="btn btn-outline-danger" href="./tutores?accion=delete&p_id_tutor=<%=items.getId_tutor()%>">Eliminar</a>
					</td>
				</tr>
			
			<%
				}
			
			%>

			</tbody>
		
		</table>
</div>

<%@ include file="../../templates/abajo.jsp" %>