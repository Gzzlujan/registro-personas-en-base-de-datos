package com.laboratorios.excepcionesPropias;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

import com.laboratorios.interfaces.Cursos;

public class AgregarCurso implements Cursos {
	static public String cursoExistente(Map<Integer, String> cursos, String curso) throws CursoInexistenteException {
		if (cursos.containsValue(curso)) {
			return curso;
		} else {
			throw new CursoInexistenteException("Este curso no esta registrado en el sistema");
		}
	}
	
	static public ArrayList<String> agregar(Map<Integer, String> cursosExisistentes){
		ArrayList<String> cursos = new ArrayList<String>();
		char continuar = 'S';
		
		while (continuar == 'S') {
			String curso = JOptionPane.showInputDialog("Ingresa el nombre del curso:");
			try {
				cursos.add(cursoExistente(cursosExisistentes, curso));
			} catch (CursoInexistenteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			continuar = JOptionPane.showInputDialog("¿Desea agregar otro curso? s/n").toUpperCase().charAt(0);
		}
		return cursos;
		
	}

}
