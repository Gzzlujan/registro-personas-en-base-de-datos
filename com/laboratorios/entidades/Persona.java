package com.laboratorios.entidades;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private Documento documento;
	private LocalDate fechaNacimiento;

	public Persona(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona nombre: " + nombre + ", apellido: " + apellido + ", documento: " + documento
				+ ", fechaNacimiento: " + fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(documento);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Persona other = (Persona) obj;
	    return Objects.equals(documento, other.documento);
	}


}
