<%@ include file="../../templates/arriba.jsp" %>

	<div class="container-fluid">
		<header>
			<label>FILTROS: TUTORES</label>
		</header>
		<form action="./tutores" method="post" target="_blank">
			<br>
			<div class="row">
			    <div class="col-sm">
			      Fecha Ini.: <br>
			      <input class="form-control" type="text" name="txt_fini" id="txt_fini" readonly><br>
			    </div>
			    <div class="col-sm">
			      Fecha Fin: <br>
			      <input class="form-control" type="text" name="txt_ffin" id="txt_ffin" readonly><br>
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-sm">
			      Nombre Tutor: <br>
			      <input class="form-control" type="text" name="txt_nombre"><br>
			    </div>
			    <div class="col-sm">
			      <br>
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-sm">
			      <input class="btn btn-primary" type="submit" name="accion" value="Generar">
			    </div>
			    <div class="col-sm">
			      <br>
			    </div>
			  </div>
		  </form>
	
	</div>
	
	<script type="text/javascript">
	
	$("#txt_fini").datepicker({
		language: "es",
		todayBtn: "linked",
		clearBtn: true,
		format: "yyyy-mm-dd"
	});
	$("#txt_ffin").datepicker({
		language: "es",
		todayBtn: "linked",
		clearBtn: true,
		format: "yyyy-mm-dd"
	});
	
	</script>
<%@ include file="../../templates/abajo.jsp" %>