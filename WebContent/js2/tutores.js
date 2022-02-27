$(document).ready(function(){
	$("#frmRegistro").validate({
		
		rules:{
			txt_dni : {
				required : true,
				number: true,
				minlength: 8
			}
		},
		messages:{
			txt_dni:{
				required :  "Por favor, ingrese su DNI",
				number: "Por favor, ingrese un valor num\u00E9rico",
				minlength: "El DNI debe tener al menos 8 caracteres"
			}
		},
		errorElement : 'span'
		
	});
});
