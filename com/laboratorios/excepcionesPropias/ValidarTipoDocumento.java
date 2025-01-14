package com.laboratorios.excepcionesPropias;

import com.laboratorios.enumerados.TiposDocumento;

public class ValidarTipoDocumento {
	private TiposDocumento tipo;

	public TiposDocumento validarDocumento(String inputTipo) throws TipoDocumentoInvalidoException {
		try {
			return tipo = TiposDocumento.valueOf(inputTipo.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new TipoDocumentoInvalidoException("Tipo de documento ingresado no valido.");
		}

	}
}
