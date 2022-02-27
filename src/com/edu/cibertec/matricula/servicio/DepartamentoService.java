package com.edu.cibertec.matricula.servicio;

import java.util.List;

import com.edu.cibertec.matricula.dao.DaoManager;
import com.edu.cibertec.matricula.dao.IDepartamentoDao;
import com.edu.cibertec.matricula.entidades.Departamento;

public class DepartamentoService {

	DaoManager factory = DaoManager.getInstancia();
	IDepartamentoDao dao = factory.getDepartamentoDao();
	
	public List<Departamento> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Departamento o) throws Exception {
		return dao.agregar(o);
	}
	
	public boolean modificar(Departamento o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
	
	public Departamento obtenerByPK(Integer id) throws Exception {
		return dao.obtenerByPK(id);
	}
	
	public List<Departamento> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
}
