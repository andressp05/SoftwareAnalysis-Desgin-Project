/**
 * Fichero Recurso.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion.recursos;

import java.io.Serializable;

import aplicacion.Asignatura;
import aplicacion.Matricula;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Esta clase abstracta permite generalizar el comportamiento de los distintos
 * recursos pertenecientes a cada asignatura. Son ejercicios, apuntes o temas,
 * que comparten los campos de visibilidad y titulo.
 * @author Andres y Francisco
 */
public abstract class Recurso implements Serializable {
	
	/** Titulo del recurso */
	protected String titulo;
	
	/** Visibilidad que presenta el recurso */
	protected boolean visibilidad;
	
	/** Asignatura a la que pertenece el recurso*/
	protected Asignatura asignatura;
	
	
	/**
	 * Constructor de la clase
	 * @param titulo
	 * @param visibilidad
	 * @param asignatura
	 */
	public Recurso(String titulo, boolean visibilidad, Asignatura asignatura) {
		this.titulo = titulo;
		this.visibilidad = visibilidad;
		this.asignatura = asignatura;
	}

	/**
	 * Constructor de la clase con la visibilidad por defecto (visible)
	 * @param titulo
	 */
	public Recurso(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public boolean isVisible() {
		return visibilidad;
	}

	/**
	 * Oculta el recurso
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public void ocultar() throws InvalidEmailAddressException, FailedInternetConnectionException {
		String mensaje = "";
		for (Matricula mat : asignatura.getAlumnado()) {
			mensaje = "El recurso " + titulo + " de la asignatura " + asignatura.getNombre() + " ha sido ocultado";
			EmailSystem.send(mat.getAlumno().getCorreo(), "Recurso ocultado", mensaje, true);
		}
		visibilidad = false;
	}
	
	/**
	 * Revela el recurso
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public void revelar() throws InvalidEmailAddressException, FailedInternetConnectionException {
		String mensaje = "";
		for (Matricula mat : asignatura.getAlumnado()) {
			mensaje = "El recurso " + titulo + " de la asignatura " + asignatura.getNombre() + " ahora es visible";
			EmailSystem.send(mat.getAlumno().getCorreo(), "Recurso revelado", mensaje, true);
		}
		visibilidad = true;
	}
	
	
}
