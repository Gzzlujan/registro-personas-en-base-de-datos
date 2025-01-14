package com.laboratorios.comparador;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

import com.laboratorios.entidades.Persona;

public class OrdenEdad implements Comparator<Persona> {
	private LocalDate fechaActual = LocalDate.now();

	@Override
	public int compare(Persona o1, Persona o2) {
		int edad1 = Period.between(o1.getFechaNacimiento(), fechaActual).getYears();
		int edad2 = Period.between(o2.getFechaNacimiento(), fechaActual).getYears();
		return (edad1 > edad2) ? edad1 : edad2;
	}

}
