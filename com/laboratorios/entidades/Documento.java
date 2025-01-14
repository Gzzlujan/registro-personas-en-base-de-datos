package com.laboratorios.entidades;

import java.util.Objects;

import com.laboratorios.enumerados.TiposDocumento;

public final class Documento {
	private TiposDocumento tipo;
	private Integer numero;

	public Documento(TiposDocumento tipo, Integer numero) {
		super();
		this.tipo = tipo;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Documento de tipo: " + tipo.getDescripcion() + ", numero: " + numero + "]";
	}

	public TiposDocumento getTipo() {
		return tipo;
	}

	public void setTipo(TiposDocumento tipo) {
		this.tipo = tipo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override public int hashCode() { 
		return Objects.hash(numero, tipo); 
		}
	
	@Override 
	public boolean equals(Object obj) { 
		if (this == obj) { 
			return true; 
			} 
		if (obj == null || getClass() != obj.getClass()) { 
			return false; 
			} 
		Documento other = (Documento) obj; 
		return Objects.equals(numero, other.numero) && tipo == other.tipo;
	}
	
	

}