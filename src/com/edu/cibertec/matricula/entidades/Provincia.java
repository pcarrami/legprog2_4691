package com.edu.cibertec.matricula.entidades;

public class Provincia {
	private Integer id_prov;
	private String nombre;
	private Integer id_depa;
	private String des_id_depa;
	
	public Provincia() {
	}

	public Provincia(Integer id_prov, String nombre, Integer id_depa) {
		this.id_prov = id_prov;
		this.nombre = nombre;
		this.id_depa = id_depa;
	}

	public Provincia(Integer id_prov, String nombre, Integer id_depa, String des_id_depa) {
		this.id_prov = id_prov;
		this.nombre = nombre;
		this.id_depa = id_depa;
		this.des_id_depa = des_id_depa;
	}

	public Integer getId_prov() {
		return id_prov;
	}

	public void setId_prov(Integer id_prov) {
		this.id_prov = id_prov;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_depa() {
		return id_depa;
	}

	public void setId_depa(Integer id_depa) {
		this.id_depa = id_depa;
	}

	public String getDes_id_depa() {
		return des_id_depa;
	}

	public void setDes_id_depa(String des_id_depa) {
		this.des_id_depa = des_id_depa;
	}
	
}
