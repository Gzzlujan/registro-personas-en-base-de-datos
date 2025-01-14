package com.laboratorios.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import com.laboratorios.comparador.OrdenEdad;
import com.laboratorios.entidades.Administrativo;
import com.laboratorios.entidades.Alumno;
import com.laboratorios.entidades.Director;
import com.laboratorios.entidades.Documento;
import com.laboratorios.entidades.Persona;
import com.laboratorios.entidades.Profesor;
import com.laboratorios.enumerados.TiposDocumento;
import com.laboratorios.excepcionesPropias.AgregarCurso;
import com.laboratorios.excepcionesPropias.CursoInexistenteException;
import com.laboratorios.excepcionesPropias.FechaInvalidaException;
import com.laboratorios.excepcionesPropias.TipoDocumentoInvalidoException;
import com.laboratorios.excepcionesPropias.ValidadorFecha;
import com.laboratorios.excepcionesPropias.ValidarTipoDocumento;
import com.laboratorios.interfaces.Cursos;

public class App implements Cursos{

	public static void main(String[] args) throws CursoInexistenteException {
		ValidadorFecha validadorFecha = new ValidadorFecha("dd/MM/yyyy");
		ValidarTipoDocumento validadorDoc = new ValidarTipoDocumento();
		Set<Persona> personas = new HashSet<>();
		Set<Persona> listaPersonas = new TreeSet<>(new OrdenEdad());
		ArrayList<String> cursos = new ArrayList<>();
		
		int cantidadPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas que desea cargar: "));
		String input;
		Persona persona = null;
		
		for(int i=0; i<cantidadPersonas; i++) {
			int tipoPersona = Integer.parseInt(JOptionPane.showInputDialog("Que tipo de persona desea cargar: " + "\n" +
		"1- Alumno" + "\n" + "2- Profesor" + "\n" + "3- Administrativo" + "\n " + "4- Director"));
			String nombre = JOptionPane.showInputDialog("Ingresa el nombre: ");
			String apellido = JOptionPane.showInputDialog("Ingresa el apellido: ");
			TiposDocumento tipoDocumento;
			while(true) {
				input = JOptionPane.showInputDialog("Ingresa el tipo de documento: ");
				try {
					tipoDocumento = validadorDoc.validarDocumento(input);
					break;
				} catch (TipoDocumentoInvalidoException e) {
					e.printStackTrace();
				}
			}
			Integer numeroDocumento = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de documento:"));
			LocalDate fechaNacimiento;
			while(true) {
				input = JOptionPane.showInputDialog("Ingresa la fecha de nacimiento: ");
				try {
					fechaNacimiento = validadorFecha.ValidarFecha(input);
					break;
				} catch (FechaInvalidaException e) {
					e.printStackTrace();
				}
			}
			switch(tipoPersona) {
			case 1: 
				cursos = AgregarCurso.agregar(Cursos.getCursos());
				LocalDate fechaIngreso;
				while(true) {
					input = JOptionPane.showInputDialog("Ingresa la fecha de ingrso: ");
					try {
						fechaIngreso = validadorFecha.ValidarFecha(input);
						break;
					} catch (FechaInvalidaException e) {
						e.printStackTrace();
					}
				}
				
				persona = new Alumno(nombre, apellido, new Documento(tipoDocumento, numeroDocumento), fechaNacimiento, cursos, fechaIngreso);
				break;
			case 2:
				LocalDate fechaCargo;
				while(true) {
					input = JOptionPane.showInputDialog("Ingresa la fecha de inicio del cargo: ");
					try {
						fechaCargo = validadorFecha.ValidarFecha(input);
						break;
					} catch (FechaInvalidaException e) {
						e.printStackTrace();
					}
				}
				double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo: "));
				cursos = AgregarCurso.agregar(Cursos.getCursos());
				persona = new Profesor(nombre, apellido, new Documento(tipoDocumento, numeroDocumento), fechaNacimiento, fechaCargo, sueldo, cursos);
				break;
			case 3:
				while(true) {
					input = JOptionPane.showInputDialog("Ingresa la fecha de inicio del cargo: ");
					try {
						fechaCargo = validadorFecha.ValidarFecha(input);
						break;
					} catch (FechaInvalidaException e) {
						e.printStackTrace();
					}
				}
				sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo: "));
				persona = new Administrativo(nombre, apellido, new Documento(tipoDocumento, numeroDocumento), fechaNacimiento, fechaCargo, sueldo);
				break;
			case 4: 
				while(true) {
					input = JOptionPane.showInputDialog("Ingresa la fecha de inicio del cargo: ");
					try {
						fechaCargo = validadorFecha.ValidarFecha(input);
						break;
					} catch (FechaInvalidaException e) {
						e.printStackTrace();
					}
				}
				sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo: "));
				String carrera = JOptionPane.showInputDialog("Ingrese la carrera: ");
				persona = new Director(nombre, apellido, new Documento(tipoDocumento, numeroDocumento), fechaNacimiento, fechaCargo, sueldo, carrera);
			}
			
			personas.add(persona);
		}
		
		listaPersonas.addAll(personas);
		
		for(Persona personaAux : listaPersonas) {
			System.out.println(personaAux.toString());
		}

	}

}
