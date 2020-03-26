/**
 * Fichero Matricula.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion;

import java.io.Serializable;

import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.usuarios.Alumno;

/**
 * Esta clase matricula se encarga de relacionar a cada alumno con las asignaturas
 * con las que este interactua e induca su estado (pendiente, aceptado, cursando).
 * @author Andres y Francisco
 */
public class Matricula implements Serializable {
	
	/** Estado en el que se encuentra el alumno matriculado */
	private EstadoMatricula estado;
	
	/** Alumno asociado a la matricula */
	private Alumno alumno;
	
	/** Asignatura correspondiente a la matricula */
	private Asignatura asignatura;
	
	/** Nota media del alumno en la asignatura en la que esta matriculado */
	private double notaMedia;

	/**
	 * Constructor de la clase, estado por defecto como pendiente
	 * @param alumno
	 * @param asignatura
	 */
	public Matricula(Alumno alumno, Asignatura asignatura) {
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.estado = EstadoMatricula.PENDIENTE;
		this.notaMedia = -1;
	}

	public Alumno getAlumno() {
		return alumno;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	
	public void setEstado(EstadoMatricula estado) {
		this.estado = estado;
	}

	public EstadoMatricula getEstado() {
		return estado;
	}
	
	public double getNotaMedia() {
		if (notaMedia == -1) {
			notaMedia = calcularNotaMedia();
		}
		return notaMedia;
	}
	
	/**
	 * Calcula la nota media del alumno matriculado en la asignatura, teniendo en cuenta 
	 * todos los ejercicios de esta asignatura
	 * @return nota media sobre 10
	 */
	public double calcularNotaMedia() {
		double suma = 0;
		boolean flag = true;
		for (EjercicioAlumno ejerAlum : alumno.getEjercicioAlumno()) {
			if (asignatura.ejercicioPerteneceAsignatura(ejerAlum.getEjercicio())) {
				suma += ( ejerAlum.getNota() * ejerAlum.getEjercicio().getPonderacion() );
				flag = false;
			}
		}
		if (flag || (asignatura.ponderacionTotal() == 0) ) {
			return 0;
		}
		return suma / asignatura.ponderacionTotal();
	}
	
	
}
