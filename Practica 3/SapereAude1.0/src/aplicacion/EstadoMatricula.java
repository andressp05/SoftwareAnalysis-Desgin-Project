/**
 * Fichero EstadoMatricula.java en el cual se implementa la enumeracion homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 14/3/2017
 */
package aplicacion;

import java.io.Serializable;

/**
 * Esta enumeracion se encarga de indicar los posibles estados en los que
 * se puede encontrar un alumno con respecto a una determinada asignatura
 * @author Andres y Francisco
 */
public enum EstadoMatricula implements Serializable {
	CURSANDO, EXPULSADO, PENDIENTE;
}
