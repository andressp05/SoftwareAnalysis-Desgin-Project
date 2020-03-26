/**
 * Fichero Alumno.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion.usuarios;

import java.io.Serializable;
import java.util.ArrayList;

import aplicacion.Asignatura;
import aplicacion.EstadoMatricula;
import aplicacion.Matricula;
import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.recursos.ejercicios.Ejercicio;

/**
 * Esta clase es la encargada de implemetar la funcionalidad asociada al tipo
 * de usuario alumno, que tiene una serie de atributos especificos adicionales
 * respecto a la clase de la que hereda. 
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class Alumno extends Usuario implements Serializable {
	
	/** Nopmbre del alumno */
	private String nombre;
	
	/** Apellidos de alumno */
	@SuppressWarnings("unused")
	private String apellido;
	
	/** Matriculas asociadas al alumno */
	private ArrayList<Matricula> matriculas;
	
	/** Ejercicios realizados por el alumno */
	private ArrayList<EjercicioAlumno> ejercicios;
	
	/**
	 * Constructor de la clase
	 * @param numa
	 * @param contrasenya
	 * @param correo
	 * @param nombre
	 * @param apellido
	 */
	public Alumno(String numa, String contrasenya, String correo, String nombre, String apellido) {
		super(numa, contrasenya, correo);
		this.nombre = nombre;
		this.apellido = apellido;
		this.matriculas = new ArrayList<Matricula>();
		this.ejercicios = new ArrayList<EjercicioAlumno>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public ArrayList<EjercicioAlumno> getEjercicioAlumno() {
		return ejercicios;
	}
	
	/**
	 * Anyade matricula a este alumno
	 * @param matricula
	 * @return correccion de la accion
	 */
	public boolean anyadirMatricula(Matricula matricula) {
		if (matricula.getAlumno().equals(this) == false) {
			return false;
		}
		return matriculas.add(matricula);
	}
	
	 /**
	  * Elimina matricula de este alumno
	  * @param matricula
	  * @return  correccion de la accion
	  */
	public boolean eliminarMatricula(Matricula matricula) {
		return matriculas.remove(matricula);
	}
	
	/**
	 * Comprueba si un alumno esta matriculado en cierta asignatura
	 * @param asig
	 * @return Si esta matriculado o no
	 */
	public boolean alumnoMatriculado(Asignatura asig) {
		for (Matricula m : this.getMatriculas()) {
			if (m.getAsignatura().equals(asig)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Comprueba si un alumno esta matriculado y cursando una cierta asignatura
	 * @param asig
	 * @return Si la esta cursando o no
	 */
	public boolean alumnoCursando(Asignatura asig) {
		for (Matricula m : this.getMatriculas()) {
			if (m.getAsignatura().equals(asig) && m.getEstado().equals(EstadoMatricula.CURSANDO)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Anyade un ejercicio al alumno
	 * @param ejAlum
	 * @return  correccion de la accion
	 */
	public boolean anyadirEjercicioAlumno(EjercicioAlumno ejAlum) {
		return ejercicios.add(ejAlum);
	}
	
	/**
	 * Elimina un ejercicio del alumno
	 * @param ejAlum
	 * @return  correccion de la accion
	 */
	public boolean eliminarEjercicioAlumno(EjercicioAlumno ejAlum) {
		return ejercicios.remove(ejAlum);
	}
	
	/**
	 * Nos da la matricula entre un alumno alumno y cuerta asignatura
	 * @param asig
	 * @return la matricula
	 */
	public Matricula getMatriculaAsignatura(Asignatura asig) {
		for (Matricula m : matriculas) {
			if (m.getAsignatura().equals(asig)) {
				return m;
			}
		}
		return null;
	}

	public EjercicioAlumno getEjercicioAlumnoPorEjercicio(Ejercicio e) {
		for (EjercicioAlumno ea: ejercicios) {
			if (ea.getEjercicio().equals(e)) {
				return ea;
			}
		}
		return null;
	}
	
	
	

	
}

