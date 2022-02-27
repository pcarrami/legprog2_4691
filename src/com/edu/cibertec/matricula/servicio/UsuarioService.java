package com.edu.cibertec.matricula.servicio;

import java.util.List;

import com.edu.cibertec.matricula.dao.DaoManager;
import com.edu.cibertec.matricula.dao.IUsuarioDao;
import com.edu.cibertec.matricula.entidades.Usuario;

public class UsuarioService {

	DaoManager factory = DaoManager.getInstancia();
	IUsuarioDao dao = factory.getUsuarioDao();
	
	public List<Usuario> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Usuario o) throws Exception {
		return dao.agregar(o);
	}
	
	public boolean modificar(Usuario o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
	
	public Usuario obtenerByPK(Integer id) throws Exception {
		return dao.obtenerByPK(id);
	}
	
	public List<Usuario> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
	
	public Usuario validarUsuario(Usuario o) throws Exception {
		return dao.validarUsuario(o);
	}
}
