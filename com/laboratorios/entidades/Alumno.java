package com.laboratorios.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona {
	private ArrayList<String> cursos;
	private LocalDate fechaIngreso;
	
	public Alumno(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, ArrayList<String> cursos, LocalDate fechaIngreso) {
		super(nombre, apellido, documento, fechaNacimiento);
		this.cursos = cursos;
		this.fechaIngreso = fechaIngreso;
	}
	
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}



	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Alumno, " + super.toString() + ", cursos: " + cursos.toString() + ", fecha de ingreso: " + fechaIngreso;
	}

	public ArrayList<String> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<String> cursos) {
		this.cursos = cursos;
	}


}