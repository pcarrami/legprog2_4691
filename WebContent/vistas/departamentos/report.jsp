<%@page import="net.sf.jasperreports.engine.data.JRBeanCollectionDataSource"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.io.File"%>
<%@page import="com.edu.cibertec.matricula.entidades.Departamento"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	ArrayList<Departamento> lista = (ArrayList<Departamento>)request.getAttribute("lista");

	File jasper = new File(application.getRealPath("reportes/rpt_departamentos_g2.jasper"));
	
	byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, 
			new JRBeanCollectionDataSource(lista));
	
	
	response.setContentType("application/pdf");
	response.setContentLength(bytes.length);
	
	ServletOutputStream output = response.getOutputStream();
	output.write(bytes,0,bytes.length);
	output.flush();
	output.close();

%>

</body>
</html>