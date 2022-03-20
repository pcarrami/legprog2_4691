package com.edu.cibertec.matricula.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.edu.cibertec.matricula.entidades.Tutor;

public class TutorDao implements ITutorDao{
	
	//variables
	
	private Connection cn;
	private CallableStatement cs;
	private ResultSet rs;
	private Tutor obj;
	private ArrayList<Tutor> lista;
	
	
	//pre compilados SQL (procedimientos almacenados)
	final String GETALL = "call pa_listar_tutores()";
	final String INSERT = "call pa_insertar_tutor(?,?,?,?,?,?,?)";
	final String UPDATE = "call pa_modificar_tutor(?,?,?,?,?,?,?,?)";
	final String DELETE = "call pa_eliminar_tutor(?)";
	final String GETBYID = "call pa_get_tutor(?)"; 
	final String SEARCH = "call pa_buscar_tutores(?)";
	final String FILTROS = "call pa_filtros_tutores(?,?,?)";
	
	public TutorDao(Connection cn) {
		this.cn = cn;
	}

	@Override
	public boolean agregar(Tutor o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(INSERT);
			int i = 1;
			cs.setString(i++, o.getDni());
			cs.setString(i++, o.getNombre());
			cs.setString(i++, o.getPapellido());
			cs.setString(i++, o.getSapellido());
			cs.setDate(i++, Date.valueOf(o.getFnacimiento()));
			cs.setString(i++, o.getTelefono());
			cs.setInt(i++, o.getId_prov());
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
	public boolean modificar(Tutor o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(UPDATE);
			int i = 1;
			cs.setString(i++, o.getDni());
			cs.setString(i++, o.getNombre());
			cs.setString(i++, o.getPapellido());
			cs.setString(i++, o.getSapellido());
			cs.setDate(i++, Date.valueOf(o.getFnacimiento()));
			cs.setString(i++, o.getTelefono());
			cs.setInt(i++, o.getId_prov());
			cs.setInt(i++, o.getId_tutor());
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
	public List<Tutor> listar() throws Exception {
		lista = new ArrayList<Tutor>();
		try {
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			while(rs.next()) {
				obj = new Tutor(
							rs.getInt("id_tutor"),
							rs.getString("dni"),
							rs.getString("nombre"),
							rs.getString("papellido"),
							rs.getString("sapellido"),
							rs.getDate("fnacimiento").toLocalDate(),
							rs.getString("telefono"),
							rs.getInt("id_prov"),
							rs.getString("des_id_prov")
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
	public Tutor obtenerByPK(Integer id) throws Exception {
		try {
			cs = cn.prepareCall(GETBYID);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			if(rs.next()) {
				obj = new Tutor(
						rs.getInt("id_tutor"),
						rs.getString("dni"),
						rs.getString("nombre"),
						rs.getString("papellido"),
						rs.getString("sapellido"),
						rs.getDate("fnacimiento").toLocalDate(),
						rs.getString("telefono"),
						rs.getInt("id_prov"),
						rs.getString("des_id_prov")
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
	public List<Tutor> buscar(String valor) throws Exception {
		lista = new ArrayList<Tutor>();
		try {
			cs = cn.prepareCall(SEARCH);
			int i=1;
			cs.setString(i++, valor);
			rs = cs.executeQuery();
			while(rs.next()) {
				obj = new Tutor(
						rs.getInt("id_tutor"),
						rs.getString("dni"),
						rs.getString("nombre"),
						rs.getString("papellido"),
						rs.getString("sapellido"),
						rs.getDate("fnacimiento").toLocalDate(),
						rs.getString("telefono"),
						rs.getInt("id_prov"),
						rs.getString("des_id_prov")
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

	@Override
	public List<Tutor> filtrar(LocalDate fini, LocalDate ffin, String nombre) throws Exception {
		lista = new ArrayList<Tutor>();
		try {
			cs = cn.prepareCall(FILTROS);
			int i=1;
			cs.setDate(i++, Date.valueOf(fini));
			cs.setDate(i++, Date.valueOf(ffin));
			cs.setString(i++, nombre);
			rs = cs.executeQuery();
			while(rs.next()) {
				obj = new Tutor(
						rs.getInt("id_tutor"),
						rs.getString("dni"),
						rs.getString("nombre"),
						rs.getString("papellido"),
						rs.getString("sapellido"),
						rs.getDate("fnacimiento").toLocalDate(),
						rs.getString("telefono"),
						rs.getInt("id_prov"),
						rs.getString("des_id_prov")
						);
				lista.add(obj);
			}
		} catch (Exception e) {
			throw new Exception("Error en SQL - FILTROS: " + e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(cs!=null) cs.close();
			} catch (Exception e2) {
				throw new Exception("Error en SQL - FILTROS: " + e2.getMessage());
			}
		}
		
		return lista;
	}

}
