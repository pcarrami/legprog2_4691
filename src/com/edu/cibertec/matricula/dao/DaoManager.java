package com.edu.cibertec.matricula.dao;

import java.sql.Connection;

import com.edu.cibertec.matricula.cnx.Conexion;

public class DaoManager implements IDaoManager{

	//Inicio - Singlenton
	private static final DaoManager instancia = new DaoManager();
	private Connection cn;
	
	private DaoManager() {
		cn = new Conexion().getConn();
	}
	
	public static DaoManager getInstancia() {
		return instancia;
	}
	
	//Fin - Singlenton
	
	//Inicio - Factory
	private IDepartamentoDao departamentoDao = null;
	private ICarreraDao carreraDao = null;
	private IProvinciaDao provinciaDao = null;
	private ITutorDao tutorDao = null;
	private IUsuarioDao usuarioDao = null;
	
	
	@Override
	public IDepartamentoDao getDepartamentoDao() {
		if(departamentoDao == null) {
			departamentoDao = new DepartamentoDao(cn);
		}
		return departamentoDao;
	}

	@Override
	public ICarreraDao getCarreraDao() {
		if(carreraDao == null) {
			carreraDao = new CarreraDao(cn);
		}
		return carreraDao;
	}

	@Override
	public IProvinciaDao getProvinciaDao() {
		if(provinciaDao == null) {
			provinciaDao = new ProvinciaDao(cn);
		}
		return provinciaDao;
	}

	@Override
	public ITutorDao getTutorDao() {
		if(tutorDao == null) {
			tutorDao = new TutorDao(cn);
		}
		return tutorDao;
	}

	@Override
	public IUsuarioDao getUsuarioDao() {
		if(usuarioDao == null) {
			usuarioDao = new UsuarioDao(cn);
		}
		return usuarioDao;
	}

	//Fin - Factory
}
