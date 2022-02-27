package com.edu.cibertec.matricula.dao;

import java.util.List;

import com.edu.cibertec.matricula.entidades.Usuario;

public interface IUsuarioDao extends GenericoDao<Usuario, Integer>{
	public List<Usuario> buscar(String valor) throws Exception;
	public Usuario validarUsuario(Usuario o) throws Exception;
}
