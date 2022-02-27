package com.edu.cibertec.matricula.entidades;

public class Usuario {
	private Integer id_usuario;
	private String login;
	private String password;
	private String nombre;
	
	public Usuario() {
	}

	public Usuario(Integer id_usuario, String login, String password, String nombre) {
		this.id_usuario = id_usuario;
		this.login = login;
		this.password = password;
		this.nombre = nombre;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
