/**
 * Fichero Pregunta.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion.recursos.ejercicios;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Pregunta implements Serializable {
	
	/** Numero que identifica la pregunta */
	private int numero;
	
	/** Peso de la pregunta sobre el total de la puntuacion */
	private double peso;
	
	/** Enunciado de la pregunta */
	private String enunciado;
	
	/** Indicador de la aleatoriedad en el orden de las respuestas de la pregunta */
	private boolean aleatoriedad;
	
	/** Penalizaion que supone contestar erroneamente a la pregunta */
	private double penalizacion;
	
	/** Distintas opciones para la respuesta a una pregunta */
	private ArrayList<Opcion> opciones;
	
	/** Tipo de respuesta que presenta la pregunta */
	private TipoRespuesta tipoRespuesta;
	
	/** Contador para asignar identificadores a cada opcion */
	private int cont;
	
	/** Contador para saber el numero de opciones correctas de la pregunta */
	private int contCorr;

	
	/**
	 * Constructor de la clase
	 * @param numero : num
	 * @param peso : peso
	 * @param enunciado : enunciado
	 * @param penalizacion : penalizacion
	 */
	public Pregunta(int numero, double peso, String enunciado, double penalizacion, TipoRespuesta tipoRespuesta) {
		this.numero = numero;
		this.peso = peso;
		this.enunciado = enunciado;
		this.aleatoriedad = false;
		this.penalizacion = penalizacion;
		this.opciones = new ArrayList<Opcion>();
		this.tipoRespuesta = tipoRespuesta;
		this.cont = 1;
		this.contCorr = 0;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public boolean isAleatoreo() {
		return aleatoriedad;
	}

	public void setAleatoriedad(boolean aleatoriedad) {
		this.aleatoriedad = aleatoriedad;
	}

	public double getPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(double penalizacion) {
		this.penalizacion = penalizacion;
	}
	
	public TipoRespuesta getTipoRespuesta() {
		return this.tipoRespuesta;
	}

	/**
	 * ANyade una opcion
	 * @param texto : texto
	 * @param correccion : corr
	 * @return
	 */
	public boolean anyadirOpcion(String texto, boolean correccion) {
		if (tipoRespuesta.equals(TipoRespuesta.SIMPLE)) {
			return false;
		}
		else if (tipoRespuesta.equals(TipoRespuesta.ABIERTA)) {
			if (correccion == false) {
				return false;
			}
		}
		else if (cont > 4) {
			return false;
		}
		else if (tipoRespuesta.equals(TipoRespuesta.UNICA) && correccion) {
			if (contCorr >= 1) {
				return false;
			}
		}
		Opcion op = new Opcion(cont, texto, correccion);
		cont++;
		if (correccion) {
			contCorr++;
		}
		return opciones.add(op);
	}
	
	/**
	 * Anyade una opcion de tipo simple
	 * @param correccion true para si verdadero, false para no verdadero
	 * @return correccion de la accion
	 */
	public boolean anyadirOpcionSimple(boolean correccion) {
		if (cont > 2) {
			return false;
		}
		Opcion si = new Opcion(1, "Si", correccion);
		Opcion no = new Opcion(2, "No", !correccion);
		cont = 5;
		return (opciones.add(si) && opciones.add(no)) ;
	}
	
	/**
	 * Devuelve la opcion indicada de la pregunta
	 * @param n numero de la opcion
	 * @return opcion a devolver
	 */
	public Opcion getOpcionNum(int n) {
		for (Opcion o : opciones) {
			if (o.getNumero() == n) {
				return o;
			}
		}
		return null;
	}
	
	/**
	 * Devuelve la opcion correcta de una pregunta
	 * @return opcion correcta
	 */
	public Opcion getOpcionCorrecta() {
		for (Opcion o : opciones) {
			if (o.getCorreccion()) {
				return o;
			}
		}
		return null;
	}
	
	/**
	 * Devuelve las opciones correctas de una pregunta de tipo Multiple
	 * @return
	 */
	public ArrayList<Opcion> getOpcionesCorrecta() {
		ArrayList<Opcion> correctas = new ArrayList<Opcion>();
		for (Opcion o : opciones) {
			if (o.getCorreccion()) {
				correctas.add(o);
			}
		}
		return correctas;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof Pregunta) {
			Pregunta p = (Pregunta) o;
			if ( (this.numero == p.numero) && (this.peso == p.peso) && (this.enunciado.equals(p.enunciado))
					&&  (this.aleatoriedad == p.aleatoriedad) && (this.penalizacion == p.penalizacion) && (this.opciones.equals(p.opciones)) 
					&&  (this.tipoRespuesta.equals(p.tipoRespuesta)) && (this.cont == p.cont) && (this.contCorr == p.contCorr) ) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "\nPregunta " + numero + " " + enunciado + " \n" + opciones
				+ " " + tipoRespuesta + " Penalizacion:" + penalizacion
				+ " Peso:" + peso;
	}

	public ArrayList<Opcion> getOpciones() {
		return opciones;
	}

}
