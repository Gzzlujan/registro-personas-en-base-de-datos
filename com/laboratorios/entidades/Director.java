package com.laboratorios.entidades;

import java.time.LocalDate;

public class Director extends Empleado {
	private String carrera;

	public Director(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaCargo,
			double sueldo, String carrera) {
		super(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo);
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Director, " + super.toString() + ", carrera: " + carrera + "]";
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


}