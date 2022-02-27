package com.edu.cibertec.matricula.dao;

public interface IDaoManager {
	IDepartamentoDao getDepartamentoDao();
	ICarreraDao getCarreraDao();
	IProvinciaDao getProvinciaDao();
	ITutorDao getTutorDao();
	IUsuarioDao getUsuarioDao();
}
