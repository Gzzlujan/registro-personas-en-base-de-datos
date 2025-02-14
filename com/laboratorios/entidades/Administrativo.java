package com.laboratorios.entidades;

import java.time.LocalDate;

public class Administrativo extends Empleado {

	public Administrativo(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaCargo,
			double sueldo) {
		super(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo);
	}

	@Override
	public String toString() {
		return "Administrativo, " + super.toString();
	}

}
