package com.laboratorios.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor extends Empleado {
	private ArrayList<String> cursos;

	public Profesor(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaCargo,
			double sueldo, ArrayList<String> cursos) {
		super(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo);
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Profesor, " + super.toString() + ", cursos: " + cursos.toString();
	}

	public ArrayList<String> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<String> cursos) {
		this.cursos = cursos;
	}

}
