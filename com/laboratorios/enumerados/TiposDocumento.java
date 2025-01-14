package com.laboratorios.enumerados;

public enum TiposDocumento {
	DNI("Documento Nacional de Identidad"), PAS("Pasaporte"), LE("Libreta de enrolamineto"), CI("Cedula de Identidad");

	private String descripcion;

	private TiposDocumento(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
