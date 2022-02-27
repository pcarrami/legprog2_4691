package com.edu.cibertec.matricula.entidades;

import java.time.LocalDate;

public class Tutor {
	private Integer id_tutor;
	private String dni;
	private String nombre;
	private String papellido;
	private String sapellido;
	private LocalDate fnacimiento;
	private String telefono;
	private Integer id_prov;
	private String des_id_prov;
	
	public Tutor() {
	}

	public Tutor(Integer id_tutor, String dni, String nombre, String papellido, String sapellido, LocalDate fnacimiento,
			String telefono, Integer id_prov) {
		this.id_tutor = id_tutor;
		this.dni = dni;
		this.nombre = nombre;
		this.papellido = papellido;
		this.sapellido = sapellido;
		this.fnacimiento = fnacimiento;
		this.telefono = telefono;
		this.id_prov = id_prov;
	}

	public Tutor(Integer id_tutor, String dni, String nombre, String papellido, String sapellido, LocalDate fnacimiento,
			String telefono, Integer id_prov, String des_id_prov) {
		super();
		this.id_tutor = id_tutor;
		this.dni = dni;
		this.nombre = nombre;
		this.papellido = papellido;
		this.sapellido = sapellido;
		this.fnacimiento = fnacimiento;
		this.telefono = telefono;
		this.id_prov = id_prov;
		this.des_id_prov = des_id_prov;
	}

	public Integer getId_tutor() {
		return id_tutor;
	}

	public void setId_tutor(Integer id_tutor) {
		this.id_tutor = id_tutor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPapellido() {
		return papellido;
	}

	public void setPapellido(String papellido) {
		this.papellido = papellido;
	}

	public String getSapellido() {
		return sapellido;
	}

	public void setSapellido(String sapellido) {
		this.sapellido = sapellido;
	}

	public LocalDate getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getId_prov() {
		return id_prov;
	}

	public void setId_prov(Integer id_prov) {
		this.id_prov = id_prov;
	}

	public String getDes_id_prov() {
		return des_id_prov;
	}

	public void setDes_id_prov(String des_id_prov) {
		this.des_id_prov = des_id_prov;
	}
	
}
