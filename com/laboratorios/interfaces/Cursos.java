package com.laboratorios.interfaces;

import java.util.HashMap;
import java.util.Map;

public interface Cursos {
	public static Map<Integer, String> getCursos() {
		Map<Integer, String> cursos = new HashMap<Integer, String>();
		Integer id = 1;
		cursos.put(id++, "Arte");
		cursos.put(id++, "Fisica");
		cursos.put(id++, "Historia");
		cursos.put(id++, "Algebra");
		cursos.put(id++, "Quimica");
		cursos.put(id++, "Biologia");
		cursos.put(id++, "Matematica");
		return cursos;

	}
	
}
