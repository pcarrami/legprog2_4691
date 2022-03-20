function eliminarDepartamento(id_depa){
	
	/*var mensaje;
	mensaje = confirm("\u00bfDeseas eliminar el registro?");
	
	alert(mensaje);
	
	if(mensaje){
			swal("Sistema de Matricula", "Se elimino el registro");
	}else{
		swal("Sistema de Matricula", "Cancelo la operación");
	}*/
	
	
	swal({
		title: "Sistema de Matricula",
		text: "\u00bfDeseas eliminar el registro?",
		icon: "warning",
		buttons: true,
		buttons: ["Cancelar", "Eliminar"]
	}).then((value) =>{
		if(value==true){
			$.ajax({
				url: './departamentos',
				type: 'GET',
				data: 'accion=delete&p_id_depa='+id_depa,
				success:function(data){
					mostrarDepartamentos();
					swal("Sistema de Matricula", "Se elimino el registro correctamente", "success");
				},
				error:function(data,xml){
					swal("Sistema de Matricula", "No se pudo realizar la operación", "error");
				}
			});		
		}else{
			swal("Sistema de Matricula", "Cancelo la operación", "error");
		}
	});
}


function mostrarDepartamentos(){
	$.ajax({
		url: './departamentos',
		type: 'GET',
		data: 'accion=listar',
		success:function(data){
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
	});
}

function mostrarAddDepartamento(){
	$.ajax({
		url: './departamentos',
		type: 'GET',
		data: 'accion=add',
		success:function(data){
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
	});
}

function mostrarEditDepartamento(id_depa){
	$.ajax({
		url: './departamentos',
		type: 'GET',
		data: 'accion=edit&p_id_depa='+id_depa,
		success:function(data){
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
	});
}

function addDepartamento(){
	var formData ={
		accion : $('#accion').val(),
		txt_id_depa : $('#txt_id_depa').val(),
		txt_nombre : $('#txt_nombre').val()
	};
	
	$.ajax({
		url: './departamentos',
		type: 'POST',
		data: formData,
		success:function(data){
			swal("Sistema de Matricula", "Se agrego el registro correctamente", "success");
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
	});
}

function editDepartamento(){
	var formData ={
		accion : $('#accion').val(),
		txt_id_depa : $('#txt_id_depa').val(),
		txt_nombre : $('#txt_nombre').val()
	};
	
	$.ajax({
		url: './departamentos',
		type: 'POST',
		data: formData,
		success:function(data){
			swal("Sistema de Matricula", "Se actualizo el registro correctamente", "success");
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
	});
}

function buscarDepartamentos(){
	var formData ={
		accion : $('#accion').val(),
		txt_buscar : $('#txt_buscar').val()
	};
	
	$.ajax({
		url: './departamentos',
		type: 'POST',
		data: formData,
		success:function(data){
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
	});
}








