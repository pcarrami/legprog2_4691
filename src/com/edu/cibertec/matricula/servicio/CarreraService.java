package com.edu.cibertec.matricula.servicio;

import java.util.List;

import com.edu.cibertec.matricula.dao.DaoManager;
import com.edu.cibertec.matricula.dao.ICarreraDao;
import com.edu.cibertec.matricula.entidades.Carrera;

public class CarreraService {

	DaoManager factory = DaoManager.getInstancia();
	ICarreraDao dao = factory.getCarreraDao();
	
	public List<Carrera> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Carrera o) throws Exception {
		return dao.agregar(o);
	}
	
	public boolean modificar(Carrera o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
	
	public Carrera obtenerByPK(Integer id) throws Exception {
		return dao.obtenerByPK(id);
	}
	
	public List<Carrera> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
}
