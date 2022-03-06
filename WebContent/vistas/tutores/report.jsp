<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="net.sf.jasperreports.engine.data.JRBeanCollectionDataSource"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.io.File"%>
<%@page import="com.edu.cibertec.matricula.entidades.Tutor"%>
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
	ArrayList<Tutor> lista = (ArrayList<Tutor>)request.getAttribute("lista");

	File jasper = new File(application.getRealPath("reportes/rpt_tutores_g2.jasper"));
	
	Map<String,Object> parametros = new HashMap<String, Object>();
	parametros.put("empresa", "CIBERTEC SAC");
	parametros.put("CNTutores", new JRBeanCollectionDataSource(lista));
	
	
	byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), parametros, 
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