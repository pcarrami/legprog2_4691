package com.edu.cibertec.matricula.cnx;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private static String url ="jdbc:mysql://localhost:3306/cibertec";
	//private static String url ="jdbc:mysql://cibertec.cepy5qnydcf5.us-east-1.rds.amazonaws.com/cibertec";
	private static String user ="root";
	private static String pass = "123456";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	Connection conn =  null;
	
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("Error driver: " + e.getMessage());
		}
	}
	
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("Error en cnx: " + e.getMessage());
		}
		return conn;
	}
	
}
