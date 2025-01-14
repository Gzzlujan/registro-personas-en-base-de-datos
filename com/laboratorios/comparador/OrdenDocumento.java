package com.laboratorios.comparador;

import java.util.Comparator;

import com.laboratorios.entidades.Persona;

public class OrdenDocumento implements Comparator<Persona> {

	@Override
	public int compare(Persona persona1, Persona persona2) {
		int tipo = persona1.getDocumento().getTipo().toString().compareTo(persona2.getDocumento().getTipo().toString());
		/*
		 * si los documentos son iguales compara los numeros, de lo contrario los
		 * ordenara por la cadena de caracteres del tipo
		 */
		if (tipo == 0) {
			return persona1.getDocumento().getNumero() - persona2.getDocumento().getNumero();
		}
		return tipo;
	}

}
