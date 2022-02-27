package com.edu.cibertec.matricula.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.cibertec.matricula.entidades.Provincia;
import com.edu.cibertec.matricula.servicio.DepartamentoService;
import com.edu.cibertec.matricula.servicio.ProvinciaService;

/**
 * Servlet implementation class ProvinciaController
 */
@WebServlet(name="provinciaController", urlPatterns= {"/provincias"})
public class ProvinciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_listar = "./vistas/provincias/list.jsp";
	final String url_add = "./vistas/provincias/add.jsp";
	final String url_edit = "./vistas/provincias/edit.jsp";
	ProvinciaService service = null;
	List<Provincia> lista =  null;
	Provincia obj = null;
	Integer id_prov;
	Integer id_depa;
	String nombre;
	String valor = "";
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String accion = request.getParameter("accion");
		try {
			if(accion.equalsIgnoreCase("listar")) {
				acceso = url_listar;
				service = new ProvinciaService();
				lista = service.listar();
				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("add")) {
				acceso= url_add;
				request.setAttribute("lstDepartamentos", new DepartamentoService().listar());
				
			}else if(accion.equalsIgnoreCase("agregar")) {
				id_prov = Integer.parseInt(request.getParameter("txt_id_prov"));
				nombre = request.getParameter("txt_nombre");
				id_depa = Integer.parseInt(request.getParameter("cb_id_depa"));
				service = new ProvinciaService();
				service.agregar(new Provincia(id_prov, nombre, id_depa));
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("delete")) {
				id_prov = Integer.parseInt(request.getParameter("p_id_prov"));
				service = new ProvinciaService();
				service.eliminar(id_prov);
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("edit")) {
				id_prov = Integer.parseInt(request.getParameter("p_id_prov"));
				service = new ProvinciaService();
				obj = service.obtenerByPK(id_prov);
				
				request.setAttribute("obj", obj);
				request.setAttribute("lstDepartamentos", new DepartamentoService().listar());
				acceso = url_edit;
				
			}else if(accion.equalsIgnoreCase("actualizar")) {
				id_prov = Integer.parseInt(request.getParameter("txt_id_prov"));
				nombre = request.getParameter("txt_nombre");
				id_depa = Integer.parseInt(request.getParameter("cb_id_depa"));
				service = new ProvinciaService();
				service.modificar(new Provincia(id_prov, nombre, id_depa));
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("buscar")) {
				valor = request.getParameter("txt_buscar");
				acceso = url_listar;
				service = new ProvinciaService();
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
