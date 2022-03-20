<%@page import="com.edu.cibertec.matricula.entidades.Departamento"%>
<%@page import="java.util.ArrayList"%>


	<header>
		<label>DEPARTAMENTOS</label>
	</header>
		<%
			String valor = String.valueOf(request.getAttribute("valor"));
		%>
		<h2 class="text-center">Lista de Departamentos ${usuario.login }</h2>
		<div class="navbar">
			<a class="btn btn-outline-success" href="javascript:;" onclick="mostrarAddDepartamento();">+ Nuevo</a>
			
			<form class="form-inline" action="#" >
				<input class="form-control" type="search" name="txt_buscar" id="txt_buscar" value="<%=valor%>">
				<input class="btn btn-outline-success" type="button" onclick="buscarDepartamentos();" id="accion" name="accion" value="Buscar">
				<a class="btn btn-outline-success" href="./departamentos?accion=report" target="_blank">Reporte</a>
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
						<a class="btn btn-outline-warning" href="javascript:;" onclick="mostrarEditDepartamento(<%=items.getId_depa()%>);">Editar</a>
						<%-- <a data-toggle="modal" data-target="#eliminarModal<%=items.getId_depa()%>" class="btn btn-outline-danger" href="#">Eliminar</a>--%>
						<a class="btn btn-outline-danger" href="javascript:;" onclick="eliminarDepartamento(<%=items.getId_depa()%>);">Eliminar</a>
					</td>
				</tr>
				
				<!-- Modal -->
				<%-- 
				<div class="modal fade" id="eliminarModal<%=items.getId_depa()%>" tabindex="-1" aria-labelledby="eliminarModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="eliminarModalLabel">Sistema de Matricula</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        ¿Desea eliminar el registro?
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
				        <a class="btn btn-primary" href="./departamentos?accion=delete&p_id_depa=<%=items.getId_depa()%>">Si</a>
				      </div>
				    </div>
				  </div>
				</div> 
			  --%>
			<%
				}
			
			%>

			</tbody>
		
		</table>

