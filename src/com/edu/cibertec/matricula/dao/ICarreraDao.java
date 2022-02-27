package com.edu.cibertec.matricula.dao;

import java.util.List;

import com.edu.cibertec.matricula.entidades.Carrera;

public interface ICarreraDao extends GenericoDao<Carrera, Integer>{
	public List<Carrera> buscar(String valor) throws Exception;
}
