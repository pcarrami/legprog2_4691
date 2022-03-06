package com.edu.cibertec.matricula.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.cibertec.matricula.entidades.Departamento;
import com.edu.cibertec.matricula.servicio.DepartamentoService;

/**
 * Servlet implementation class DepartamentoController
 */
@WebServlet(name="departamentoController", urlPatterns= {"/departamentos"})
public class DepartamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_listar = "./vistas/departamentos/list.jsp";
	final String url_add = "./vistas/departamentos/add.jsp";
	final String url_edit = "./vistas/departamentos/edit.jsp";
	final String url_report = "./vistas/departamentos/report.jsp";
	DepartamentoService service = null;
	List<Departamento> lista =  null;
	Departamento obj = null;
	Integer id_depa;
	String nombre;
	String valor = "";
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String accion = request.getParameter("accion");
		try {
			if(accion.equalsIgnoreCase("listar")) {
				acceso = url_listar;
				service = new DepartamentoService();
				lista = service.listar();
				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("add")) {
				acceso= url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
				id_depa = Integer.parseInt(request.getParameter("txt_id_depa"));
				nombre = request.getParameter("txt_nombre");
				service = new DepartamentoService();
				service.agregar(new Departamento(id_depa, nombre));
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("delete")) {
				id_depa = Integer.parseInt(request.getParameter("p_id_depa"));
				service = new DepartamentoService();
				service.eliminar(id_depa);
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("edit")) {
				id_depa = Integer.parseInt(request.getParameter("p_id_depa"));
				service = new DepartamentoService();
				obj = service.obtenerByPK(id_depa);
				
				request.setAttribute("obj", obj);
				acceso = url_edit;
				
			}else if(accion.equalsIgnoreCase("actualizar")) {
				id_depa = Integer.parseInt(request.getParameter("txt_id_depa"));
				nombre = request.getParameter("txt_nombre");
				service = new DepartamentoService();
				service.modificar(new Departamento(id_depa, nombre));
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("buscar")) {
				valor = request.getParameter("txt_buscar");
				acceso = url_listar;
				service = new DepartamentoService();
				lista = service.buscar(valor);
				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("report")) {
				acceso = url_report;
				service = new DepartamentoService();
				lista = service.listar();
				request.setAttribute("lista", lista);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("valor", valor);
		
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
	}

}
