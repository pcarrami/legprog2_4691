package com.edu.cibertec.matricula.dao;

import java.util.List;

public interface GenericoDao<T, K> {
	
	//Metodos CRUD
	public boolean agregar(T o) throws Exception;
	public boolean modificar(T o) throws Exception;
	public boolean eliminar(K id) throws Exception;
	public List<T> listar() throws Exception;
	public T obtenerByPK(K id) throws Exception;
}
