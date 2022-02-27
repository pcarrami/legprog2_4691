package com.edu.cibertec.matricula.dao;

import java.util.List;

import com.edu.cibertec.matricula.entidades.Provincia;

public interface IProvinciaDao extends GenericoDao<Provincia, Integer>{
	public List<Provincia> buscar(String valor) throws Exception;
}
