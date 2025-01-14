package com.laboratorios.excepcionesPropias;

public class CursoInexistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CursoInexistenteException(String mensaje) {
		super(mensaje);
	}
}
