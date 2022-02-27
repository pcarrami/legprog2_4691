package com.edu.cibertec.matricula.dao;

import java.util.List;

import com.edu.cibertec.matricula.entidades.Tutor;

public interface ITutorDao extends GenericoDao<Tutor, Integer>{
	public List<Tutor> buscar(String valor) throws Exception;
}
