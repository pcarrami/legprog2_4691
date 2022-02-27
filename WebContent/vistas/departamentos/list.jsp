<%@page import="com.edu.cibertec.matricula.entidades.Departamento"%>
<%@page import="java.util.ArrayList"%>



<%@ include file="../../templates/arriba.jsp" %>
<div class="container-fluid">
	<header>
		<label>DEPARTAMENTOS</label>
	</header>
		<%
			String valor = String.valueOf(request.getAttribute("valor"));
		%>
		<h2 class="text-center">Lista de Departamentos ${usuario.login }</h2>
		<div class="navbar">
			<a class="btn btn-outline-success" href="./departamentos?accion=add">+ Nuevo</a>
			
			<form class="form-inline" action="./departamentos" method="post">
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
				ArrayList<Departamento> lista = (ArrayList<Departamento>) request.getAttribute("lista");
			
			%>
			<tbody>
			<% if(lista !=null) 
				for(Departamento items : lista){
				
			%>
				<tr>
					<td class="text-center"><%=items.getId_depa() %></td>
					<td class="text-center"><%=items.getNombre() %></td>
					<td class="text-center">
						<a class="btn btn-outline-warning" href="./departamentos?accion=edit&p_id_depa=<%=items.getId_depa()%>">Editar</a>
						<a class="btn btn-outline-danger" href="./departamentos?accion=delete&p_id_depa=<%=items.getId_depa()%>">Eliminar</a>
					</td>
				</tr>
			
			<%
				}
			
			%>

			</tbody>
		
		</table>
</div>
<%@ include file="../../templates/abajo.jsp" %>
