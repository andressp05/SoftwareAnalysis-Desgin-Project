/**
 * Fichero Profesor.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion.usuarios;

import java.io.Serializable;

/**
 * Esta clase es la encargada de implemetar la funcionalidad asociada al tipo
 * de usuario profesor, el cual apenas añade detalles especificos pues tan solo
 * habra un unico objeto de esta clase.. 
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class Profesor extends Usuario implements Serializable {

	/**
	 * Constructor de la clase
	 * @param numa
	 * @param contrasenya
	 * @param correo
	 */
	public Profesor(String numa, String contrasenya, String correo) {
		super(numa, contrasenya, correo);
	}
	
}
