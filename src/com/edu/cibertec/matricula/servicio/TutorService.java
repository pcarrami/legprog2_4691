package com.edu.cibertec.matricula.servicio;

import java.util.List;

import com.edu.cibertec.matricula.dao.DaoManager;
import com.edu.cibertec.matricula.dao.ITutorDao;
import com.edu.cibertec.matricula.entidades.Tutor;

public class TutorService {

	DaoManager factory = DaoManager.getInstancia();
	ITutorDao dao = factory.getTutorDao();
	
	public List<Tutor> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Tutor o) throws Exception {
		return dao.agregar(o);
	}
	
	public boolean modificar(Tutor o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
	
	public Tutor obtenerByPK(Integer id) throws Exception {
		return dao.obtenerByPK(id);
	}
	
	public List<Tutor> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
}
