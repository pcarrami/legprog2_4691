package com.edu.cibertec.matricula.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.cibertec.matricula.entidades.Carrera;

public class CarreraDao implements ICarreraDao{
	
	//variables
	
	private Connection cn;
	private CallableStatement cs;
	private ResultSet rs;
	private Carrera obj;
	private ArrayList<Carrera> lista;
	
	
	//pre compilados SQL (procedimientos almacenados)
	final String GETALL = "call pa_listar_carreras()";
	final String INSERT = "call pa_insertar_carrera(?)";
	final String UPDATE = "call pa_modificar_carrera(?,?)";
	final String DELETE = "call pa_eliminar_carrera(?)";
	final String GETBYID = "call pa_get_carrera(?)"; 
	final String SEARCH = "call pa_buscar_carreras(?)";
	
	public CarreraDao(Connection cn) {
		this.cn = cn;
	}

	@Override
	public boolean agregar(Carrera o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(INSERT);
			int i = 1;
			cs.setString(i++, o.getNombre());
			c = cs.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error en SQL - INSERT: " + e.getMessage());
		}finally {
			try {
				//if(rs!=null) rs.close();
				if(cs!=null) cs.close();
			} catch (Exception e2) {
				throw new Exception("Error en SQL - INSERT: " + e2.getMessage());
			}
		}
		return c>0;
	}

	@Override
	public boolean modificar(Carrera o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(UPDATE);
			int i = 1;
			cs.setString(i++, o.getNombre());
			cs.setInt(i++, o.getId_carrera());
			c = cs.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error en SQL - UPDATE: " + e.getMessage());
		}finally {
			try {
				//if(rs!=null) rs.close();
				if(cs!=null) cs.close();
			} catch (Exception e2) {
				throw new Exception("Error en SQL - UPDATE: " + e2.getMessage());
			}
		}
		return c>0;
	}

	@Override
	public boolean eliminar(Integer id) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(DELETE);
			int i = 1;
			cs.setInt(i++, id);
			c = cs.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error en SQL - DELETE: " + e.getMessage());
		}finally {
			try {
				//if(rs!=null) rs.close();
				if(cs!=null) cs.close();
			} catch (Exception e2) {
				throw new Exception("Error en SQL - DELETE: " + e2.getMessage());
			}
		}
		return c>0;
	}

	@Override
	public List<Carrera> listar() throws Exception {
		lista = new ArrayList<Carrera>();
		try {
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			while(rs.next()) {
				obj = new Carrera(
							rs.getInt("id_carrera"),
							rs.getString("nombre")
						);
				lista.add(obj);
			}
		} catch (Exception e) {
			throw new Exception("Error en SQL: " + e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(cs!=null) cs.close();
			} catch (Exception e2) {
				throw new Exception("Error en SQL: " + e2.getMessage());
			}
		}
		
		return lista;
	}

	@Override
	public Carrera obtenerByPK(Integer id) throws Exception {
		try {
			cs = cn.prepareCall(GETBYID);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			if(rs.next()) {
				obj = new Carrera(
							rs.getInt("id_carrera"),
							rs.getString("nombre")
						);
			}
		} catch (Exception e) {
			throw new Exception("Error en SQL: " + e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(cs!=null) cs.close();
			} catch (Exception e2) {
				throw new Exception("Error en SQL: " + e2.getMessage());
			}
		}
		
		return obj;
	}

	@Override
	public List<Carrera> buscar(String valor) throws Exception {
		lista = new ArrayList<Carrera>();
		try {
			cs = cn.prepareCall(SEARCH);
			int i=1;
			cs.setString(i++, valor);
			rs = cs.executeQuery();
			while(rs.next()) {
				obj = new Carrera(
							rs.getInt("id_carrera"),
							rs.getString("nombre")
						);
				lista.add(obj);
			}
		} catch (Exception e) {
			throw new Exception("Error en SQL - SEARCH: " + e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(cs!=null) cs.close();
			} catch (Exception e2) {
				throw new Exception("Error en SQL - SEARCH: " + e2.getMessage());
			}
		}
		
		return lista;
	}

}
