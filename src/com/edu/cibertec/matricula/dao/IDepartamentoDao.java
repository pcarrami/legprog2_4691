package com.edu.cibertec.matricula.dao;

import java.util.List;

import com.edu.cibertec.matricula.entidades.Departamento;

public interface IDepartamentoDao extends GenericoDao<Departamento, Integer>{
	public List<Departamento> buscar(String valor) throws Exception;
}
