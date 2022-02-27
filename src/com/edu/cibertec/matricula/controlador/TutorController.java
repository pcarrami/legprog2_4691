package com.edu.cibertec.matricula.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.cibertec.matricula.entidades.Tutor;
import com.edu.cibertec.matricula.servicio.ProvinciaService;
import com.edu.cibertec.matricula.servicio.TutorService;

/**
 * Servlet implementation class TutorController
 */
@WebServlet(name="tutorController", urlPatterns= {"/tutores"})
public class TutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_listar = "./vistas/tutores/list.jsp";
	final String url_add = "./vistas/tutores/add.jsp";
	final String url_edit = "./vistas/tutores/edit.jsp";
	TutorService service = null;
	List<Tutor> lista =  null;
	Tutor obj = null;
	Integer id_tutor;
	String dni, nombre, papellido, sapellido, telefono;
	LocalDate fnacimiento;
	Integer id_prov;
	String valor = "";
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String accion = request.getParameter("accion");
		try {
			if(accion.equalsIgnoreCase("listar")) {
				acceso = url_listar;
				service = new TutorService();
				lista = service.listar();
				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("add")) {
				acceso= url_add;
				request.setAttribute("lstProvincias", new ProvinciaService().listar());
				
			}else if(accion.equalsIgnoreCase("agregar")) {
				id_tutor = Integer.parseInt(request.getParameter("txt_id_tutor"));
				dni = request.getParameter("txt_dni");
				nombre = request.getParameter("txt_nombre");
				papellido = request.getParameter("txt_papellido");
				sapellido = request.getParameter("txt_sapellido");
				//fnacimiento
				String fecha = request.getParameter("txt_fnacimiento");
				String[] campos = fecha.split("-");
				int anio, mes , dia;  //yyyy-mm-dd
				anio = Integer.parseInt(campos[0]);
				mes = Integer.parseInt(campos[1]);
				dia = Integer.parseInt(campos[2]);
				
				fnacimiento = LocalDate.of(anio, mes, dia);
				
				telefono = request.getParameter("txt_telefono");
				id_prov = Integer.parseInt(request.getParameter("cb_id_prov"));
				service = new TutorService();
				service.agregar(new Tutor(id_tutor, dni, nombre, papellido, sapellido, 
						fnacimiento, telefono, id_prov));
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("delete")) {
				id_tutor = Integer.parseInt(request.getParameter("p_id_tutor"));
				service = new TutorService();
				service.eliminar(id_tutor);
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("edit")) {
				id_tutor = Integer.parseInt(request.getParameter("p_id_tutor"));
				service = new TutorService();
				obj = service.obtenerByPK(id_tutor);
				
				request.setAttribute("obj", obj);
				request.setAttribute("lstProvincias", new ProvinciaService().listar());
				acceso = url_edit;
				
			}else if(accion.equalsIgnoreCase("actualizar")) {
				id_tutor = Integer.parseInt(request.getParameter("txt_id_tutor"));
				dni = request.getParameter("txt_dni");
				nombre = request.getParameter("txt_nombre");
				papellido = request.getParameter("txt_papellido");
				sapellido = request.getParameter("txt_sapellido");
				//fnacimiento
				String fecha = request.getParameter("txt_fnacimiento");
				String[] campos = fecha.split("-");
				int anio, mes , dia;  //yyyy-mm-dd
				anio = Integer.parseInt(campos[0]);
				mes = Integer.parseInt(campos[1]);
				dia = Integer.parseInt(campos[2]);
				
				fnacimiento = LocalDate.of(anio, mes, dia);
				
				telefono = request.getParameter("txt_telefono");
				id_prov = Integer.parseInt(request.getParameter("cb_id_prov"));
				service = new TutorService();
				service.modificar(new Tutor(id_tutor, dni, nombre, papellido, sapellido, 
						fnacimiento, telefono, id_prov));
				
				acceso = url_listar;
				lista = service.listar();
				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("buscar")) {
				valor = request.getParameter("txt_buscar");
				acceso = url_listar;
				service = new TutorService();
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
