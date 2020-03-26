/**
 * Fichero Apuntes.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion.recursos;

import java.io.Serializable;

import aplicacion.Asignatura;

/**
 * Esta es una clase hija de recurso la cual lleva asociada la implementacion
 * de los apuntes que simplementente tienen que almacenar su contenido.
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class Apuntes extends Recurso implements Serializable {
	
	/** Contenido de los apuntes */
	private String contenido;

	/**
	 * Constructor de la clase
	 * @param titulo
	 * @param visibilidad
	 * @param contenido
	 * @param asig
	 */
	public Apuntes(String titulo, boolean visibilidad, String contenido, Asignatura asig) {
		super(titulo, visibilidad, asig);
		this.contenido = contenido;
	}
	
	/**
	 * Constructor con visibilidad por defecto
	 * @param titulo
	 * @param contenido
	 */
	public Apuntes(String titulo, String contenido, Asignatura asignatura) {
		super(titulo, true, asignatura);
		this.contenido = contenido;
	}
	
	public String getContenido() {
		return contenido;
	}

	@Override
	public boolean esEliminable() {
		return true;
	}

	@Override
	public String toString() {
		return "Apuntes: " + titulo ;
	}
	
	

	
}
