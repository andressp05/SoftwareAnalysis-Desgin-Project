/**
 * Fichero Opcion.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion.recursos.ejercicios;

import java.io.Serializable;

public class Opcion implements Serializable {
	
	/** Numero que identifica la opcion */
	private int numero; 
	
	/** Texto asociado a la opcion */
	private String texto;
	
	/** Indicador se si la respuesta es correcta o no */
	private boolean correccion;

	/**
	 * Constrcutor de la clase
	 * @param numero
	 * @param texto
	 * @param correccion
	 */
	public Opcion(int numero, String texto, boolean correccion) {
		this.numero = numero;
		this.texto = texto;
		this.correccion = correccion;
	}
	
	

	@Override
	public String toString() {
		return numero + ". " + texto + " " + correccion + "\n";
	}



	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isCorreccion() {
		return correccion;
	}

	public void setCorreccion(boolean correccion) {
		this.correccion = correccion;
	}

	public boolean getCorreccion() {
		return this.correccion;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof Opcion) {
			Opcion op = (Opcion) o;
			if ( (this.numero == op.numero) && (this.correccion == op.correccion) && (this.texto.equals(op.texto)) ) {
				return true;
			}
		}
		return false;
	}
	
}
