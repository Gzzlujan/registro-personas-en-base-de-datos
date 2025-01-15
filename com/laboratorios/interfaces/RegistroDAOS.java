package com.laboratorios.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.laboratorios.conexion.Conexion;
import com.laboratorios.entidades.Administrativo;
import com.laboratorios.entidades.Alumno;
import com.laboratorios.entidades.Director;
import com.laboratorios.entidades.Persona;
import com.laboratorios.entidades.Profesor;

public interface RegistroDAOS {
	public static void insertar(Persona p) {
		Connection conexion = null;
		PreparedStatement ps = null;
		try {
			conexion = Conexion.conectar();
			String sql;
			if(p instanceof Alumno) {
				Alumno alumno = (Alumno) p;
				sql = "INSERT INTO ALUMNO (NOMBRE, APELLIDO, TIPO, NUMDOC, FECHANACIMIENTO, CURSOS, FECHAINGRESO) VALUES " +
											"(?, ?, ?, ?, ?, ?, ?)";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, alumno.getNombre());
				ps.setString(2, alumno.getApellido());
				ps.setString(3, alumno.getDocumento().getTipo().getDescripcion());
				ps.setInt(4, alumno.getDocumento().getNumero());
				ps.setDate(5, java.sql.Date.valueOf(alumno.getFechaNacimiento()));
				ps.setString(6, String.join(", ", alumno.getCursos().toString()));
				ps.setDate(7, java.sql.Date.valueOf(alumno.getFechaIngreso()));
			}
			
			if(p instanceof Profesor) {
				Profesor profesor = (Profesor) p;
				sql = "INSERT INTO PROFESOR (NOMBRE, APELLIDO, TIPO, NUMDOC, FECHANACIMIENTO, FECHACARGO, SUELDO, CURSOS) VALUES " +
						"(?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, profesor.getNombre());
				ps.setString(2, profesor.getApellido());
				ps.setString(3, profesor.getDocumento().getTipo().getDescripcion());
				ps.setInt(4, profesor.getDocumento().getNumero());
				ps.setDate(5, java.sql.Date.valueOf(profesor.getFechaNacimiento()));
				ps.setDate(6, java.sql.Date.valueOf(profesor.getFechaCargo()));
				ps.setDouble(7, profesor.getSueldo());
				ps.setString(8, String.join(", ", profesor.getCursos().toString()));
			}
			
			if(p instanceof Administrativo) {
				Administrativo administrativo = (Administrativo) p;
				sql = "INSERT INTO ADMINISTRATIVO (NOMBRE, APELLIDO, TIPO, NUMDOC, FECHANACIMIENTO, FECHACARGO, SUELDO) VALUES " +
						"(?, ?, ?, ?, ?, ?, ?)";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, administrativo.getNombre());
				ps.setString(2, administrativo.getApellido());
				ps.setString(3, administrativo.getDocumento().getTipo().getDescripcion());
				ps.setInt(4, administrativo.getDocumento().getNumero());
				ps.setDate(5, java.sql.Date.valueOf(administrativo.getFechaNacimiento()));
				ps.setDate(6, java.sql.Date.valueOf(administrativo.getFechaCargo()));
				ps.setDouble(7, administrativo.getSueldo());
			}
			
			if(p instanceof Director) {
				Director director = (Director) p;
				sql = "INSERT INTO DIRECTOR (NOMBRE, APELLIDO, TIPO, NUMDOC, FECHANACIMIENTO, FECHACARGO, SUELDO, CARRERA) VALUES " +
						"(?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, director.getNombre());
				ps.setString(2, director.getApellido());
				ps.setString(3, director.getDocumento().getTipo().getDescripcion());
				ps.setInt(4, director.getDocumento().getNumero());
				ps.setDate(5, java.sql.Date.valueOf(director.getFechaNacimiento()));
				ps.setDate(6, java.sql.Date.valueOf(director.getFechaCargo()));
				ps.setDouble(7, director.getSueldo());
				ps.setString(8, director.getCarrera());
			}
			
			if(ps != null) ps.execute();
			
		}  catch (Exception e) {
			System.out.println("No se completo el metodo Insertar()");
			e.printStackTrace();
		} finally {
				try {
					if(ps != null)ps.close();
					if(conexion != null) conexion.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

}
