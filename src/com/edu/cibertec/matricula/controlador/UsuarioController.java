package com.edu.cibertec.matricula.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.cibertec.matricula.entidades.Usuario;
import com.edu.cibertec.matricula.servicio.UsuarioService;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet(name="usuarioController", urlPatterns= {"/usuarios"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_listar = "./vistas/usuarios/list.jsp";
	final String url_add = "./vistas/usuarios/add.jsp";
	final String url_edit = "./vistas/usuarios/edit.jsp";
	UsuarioService service = null;
	List<Usuario> lista =  null;
	Usuario obj = null;
	Integer id_usuario;
	String login = null;
	String password = null;
	String nombre =  null;
	String valor = "";
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String accion = request.getParameter("accion");
		
		HttpSession session = request.getSession(true);
		
		try {
			service = new UsuarioService();
			if(accion.equalsIgnoreCase("listar")) {
//				acceso = url_listar;
//				service = new UsuarioService();
//				lista = service.listar();
//				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("add")) {
//				acceso= url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
//				id_depa = Integer.parseInt(request.getParameter("txt_id_depa"));
//				nombre = request.getParameter("txt_nombre");
//				service = new UsuarioService();
//				service.agregar(new Usuario(id_depa, nombre));
//				
//				acceso = url_listar;
//				lista = service.listar();
//				request.setAttribute("lista", lista);
				
			}else if(accion.equalsIgnoreCase("delete")) {
//				id_depa = Integer.parseInt(request.getParameter("p_id_depa"));
//				service = new UsuarioService();
//				service.eliminar(id_depa);
//				
//				acceso = url_listar;
//				lista = service.listar();
//				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("edit")) {
//				id_depa = Integer.parseInt(request.getParameter("p_id_depa"));
//				service = new UsuarioService();
//				obj = service.obtenerByPK(id_depa);
//				
//				request.setAttribute("obj", obj);
//				acceso = url_edit;
				
			}else if(accion.equalsIgnoreCase("actualizar")) {
//				id_depa = Integer.parseInt(request.getParameter("txt_id_depa"));
//				nombre = request.getParameter("txt_nombre");
//				service = new UsuarioService();
//				service.modificar(new Usuario(id_depa, nombre));
//				
//				acceso = url_listar;
//				lista = service.listar();
//				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("buscar")) {
//				valor = request.getParameter("txt_buscar");
//				acceso = url_listar;
//				service = new UsuarioService();
//				lista = service.buscar(valor);
//				request.setAttribute("lista", lista);
			}else if(accion.equalsIgnoreCase("login")) {
				login = request.getParameter("txt_usuario");
				password = request.getParameter("txt_password");
				
				obj = new Usuario();
				obj.setLogin(login);
				obj.setPassword(password);
				
				obj = service.validarUsuario(obj);
				
				if(obj!=null) {
					session.setAttribute("usuario", obj);
					acceso ="index.jsp";
				}else {
					session.invalidate();
					acceso="login.jsp";
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("valor", valor);
		
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
	}

}
