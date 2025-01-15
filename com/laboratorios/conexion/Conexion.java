package com.laboratorios.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Conexion {
static Connection conexion = null;
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/laboratorios", "root", "");
			System.out.println("Conexion exitosa con la base de datos");
		} catch(Exception e) {
			System.out.println("No se pudo conectar con la base de datos");
			e.printStackTrace();
		}
		return conexion;
	}
}
