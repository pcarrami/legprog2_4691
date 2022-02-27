package com.edu.cibertec.matricula.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.cibertec.matricula.entidades.Carrera;
import com.edu.cibertec.matricula.servicio.CarreraService;

/**
 * Servlet implementation class CarreraController
 */
@WebServlet(name="carreraController", urlPatterns= {"/carreras"})
public class CarreraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_listar = "./vistas/carreras/list.jsp";
	final String url_add = "./vistas/carreras/add.jsp";
	final String url_edit = "./vistas/carreras/edit.jsp";
	CarreraService service = null;
	List<Carrera> lista =  null;
	Carrera obj = null;
	Integer id_carrera;
	String nombre;
	String valor = "";
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String accion = request.getParameter("accion");
		try {
			if(accion.equalsIgnoreCase("listar")) {
				acceso = url_listar;
				service = new CarreraService();
				lista = service.listar();
				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("add")) {
				acceso= url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
				id_carrera = Integer.parseInt(request.getParameter("txt_id_carrera"));
				nombre = request.getParameter("txt_nombre");
				service = new CarreraService();
				service.agregar(new Carrera(id_carrera, nombre));
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("delete")) {
				id_carrera = Integer.parseInt(request.getParameter("p_id_carrera"));
				service = new CarreraService();
				service.eliminar(id_carrera);
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("edit")) {
				id_carrera = Integer.parseInt(request.getParameter("p_id_carrera"));
				service = new CarreraService();
				obj = service.obtenerByPK(id_carrera);
				
				request.setAttribute("obj", obj);
				acceso = url_edit;
				
			}else if(accion.equalsIgnoreCase("actualizar")) {
				id_carrera = Integer.parseInt(request.getParameter("txt_id_carrera"));
				nombre = request.getParameter("txt_nombre");
				service = new CarreraService();
				service.modificar(new Carrera(id_carrera, nombre));
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("buscar")) {
				valor = request.getParameter("txt_buscar");
				acceso = url_listar;
				service = new CarreraService();
				lista = service.buscar(valor);
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
