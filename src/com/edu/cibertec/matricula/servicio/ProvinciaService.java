package com.edu.cibertec.matricula.servicio;

import java.util.List;

import com.edu.cibertec.matricula.dao.DaoManager;
import com.edu.cibertec.matricula.dao.IProvinciaDao;
import com.edu.cibertec.matricula.entidades.Provincia;

public class ProvinciaService {

	DaoManager factory = DaoManager.getInstancia();
	IProvinciaDao dao = factory.getProvinciaDao();
	
	public List<Provincia> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Provincia o) throws Exception {
		return dao.agregar(o);
	}
	
	public boolean modificar(Provincia o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
	
	public Provincia obtenerByPK(Integer id) throws Exception {
		return dao.obtenerByPK(id);
	}
	
	public List<Provincia> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
}
