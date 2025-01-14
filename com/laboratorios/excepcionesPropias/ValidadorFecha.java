package com.laboratorios.excepcionesPropias;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidadorFecha {
	private DateTimeFormatter formatoFecha;

	public ValidadorFecha(String formato) {
		this.formatoFecha = DateTimeFormatter.ofPattern(formato);
	}

	public LocalDate ValidarFecha(String fecha) throws FechaInvalidaException {
		try {
			LocalDate fechaConvertida = LocalDate.parse(fecha, formatoFecha);
			return fechaConvertida;
		} catch (DateTimeParseException e) {
			throw new FechaInvalidaException("Fecha ingresada es invalida");
		}
	}
}
