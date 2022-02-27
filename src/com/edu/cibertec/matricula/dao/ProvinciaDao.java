package com.edu.cibertec.matricula.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.cibertec.matricula.entidades.Provincia;

public class ProvinciaDao implements IProvinciaDao{
	
	//variables
	
	private Connection cn;
	private CallableStatement cs;
	private ResultSet rs;
	private Provincia obj;
	private ArrayList<Provincia> lista;
	
	
	//pre compilados SQL (procedimientos almacenados)
	final String GETALL = "call pa_listar_provincias()";
	final String INSERT = "call pa_insertar_provincia(?,?)";
	final String UPDATE = "call pa_modificar_provincia(?,?,?)";
	final String DELETE = "call pa_eliminar_provincia(?)";
	final String GETBYID = "call pa_get_provincia(?)"; 
	final String SEARCH = "call pa_buscar_provincias(?)";
	
	public ProvinciaDao(Connection cn) {
		this.cn = cn;
	}

	@Override
	public boolean agregar(Provincia o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(INSERT);
			int i = 1;
			cs.setString(i++, o.getNombre());
			cs.setInt(i++, o.getId_depa());
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
	public boolean modificar(Provincia o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(UPDATE);
			int i = 1;
			cs.setString(i++, o.getNombre());
			cs.setInt(i++, o.getId_depa());
			cs.setInt(i++, o.getId_prov());
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
	public List<Provincia> listar() throws Exception {
		lista = new ArrayList<Provincia>();
		try {
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			while(rs.next()) {
				obj = new Provincia(
							rs.getInt("id_prov"),
							rs.getString("nombre"),
							rs.getInt("id_depa"),
							rs.getString("des_id_depa")
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
	public Provincia obtenerByPK(Integer id) throws Exception {
		try {
			cs = cn.prepareCall(GETBYID);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			if(rs.next()) {
				obj = new Provincia(
							rs.getInt("id_prov"),
							rs.getString("nombre"),
							rs.getInt("id_depa")
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
	public List<Provincia> buscar(String valor) throws Exception {
		lista = new ArrayList<Provincia>();
		try {
			cs = cn.prepareCall(SEARCH);
			int i=1;
			cs.setString(i++, valor);
			rs = cs.executeQuery();
			while(rs.next()) {
				obj = new Provincia(
							rs.getInt("id_prov"),
							rs.getString("nombre"),
							rs.getInt("id_depa"),
							rs.getString("des_id_depa")
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
