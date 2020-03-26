/**
 * Fichero Usuario.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion.usuarios;

import java.io.Serializable;

/**
 * Clase abstracta que representa a los distintos usurarios que van a poder
 * acceder a nuestra apliacacion. Estos son alumnos y profesores, los cuales
 * comparten un conjunto de atributos aqui plasmados. 
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public abstract class Usuario implements Serializable {
	
	/** Numero de acceso de un usuario */
	protected String numa;
	
	/** Contrasenya de acceso de un usuario */
	protected String contrasenya;
	
	/** Direccion de correo electronico de un usuario */
	protected String correo;

	
	/**
	 * Constructor de la clase 
	 * @param numa
	 * @param contrasenya
	 * @param correo
	 */
	public Usuario(String numa, String contrasenya, String correo) {
		this.numa = numa;
		this.contrasenya = contrasenya;
		this.correo = correo;
	}
	
	public String getNuma() {
		return numa;
	}
	
	public String getContrasenya() {
		return contrasenya;
	}
	
}