package com.edu.cibertec.matricula.dao;

import java.time.LocalDate;
import java.util.List;

import com.edu.cibertec.matricula.entidades.Tutor;

public interface ITutorDao extends GenericoDao<Tutor, Integer>{
	public List<Tutor> buscar(String valor) throws Exception;
	public List<Tutor> filtrar(LocalDate fini, LocalDate ffin, String nombre) throws Exception;
}
