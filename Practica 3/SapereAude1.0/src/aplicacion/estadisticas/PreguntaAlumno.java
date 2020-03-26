package aplicacion.estadisticas;

import java.io.Serializable;
import java.util.ArrayList;

import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import aplicacion.recursos.ejercicios.TipoRespuesta;

public class PreguntaAlumno implements Serializable {
	
	/** Indica la correccion de la pregunta del alumno */
	private boolean correccion;
	
	/** Indica si la pregunta ha sido contestada o no por un alumno */
	private boolean contestada;
	
	/** Opcion seleccionada por el alumno en la pregunta */
	private ArrayList<Opcion> contestacion = new ArrayList<Opcion>();
	
	/** Pregunta original a la que contesta un alumno */
	private Pregunta preguntaOriginal;

	/**
	 * Constructor de la clase 
	 * @param contestacion
	 */
	public PreguntaAlumno(Opcion contestacion, Pregunta pregunta) {
		if (contestacion == null) {
			this.correccion = false;
			this.contestada = false;
			this.contestacion = null;
			this.preguntaOriginal = pregunta;
			return;
		}
		this.contestada = true;
		anyadirContestacion(contestacion);
		this.preguntaOriginal = pregunta;
		this.correccion = esCorrecta();
	}
	
	/**
	 * Constructor para preguntas en blanco
	 * @param pregunta
	 */
	public PreguntaAlumno(Pregunta pregunta) {
		this.correccion = false;
		this.contestada = false;
		this.contestacion = null;
		this.preguntaOriginal = pregunta;
		return;
	}
	
	/**
	 * Constructor de la clase si la pregunta ha recibido mas de una contestacion (solo respuesta multiple)
	 * @param contestacion
	 */
	public PreguntaAlumno(ArrayList<Opcion> contestacion, Pregunta pregunta) {
		this.contestada = true;
		for (Opcion op : contestacion) {
			anyadirContestacion(op);
		}
		this.preguntaOriginal = pregunta;
		this.correccion = esCorrecta();
	}
	
	public Pregunta getPreguntaOriginal() {
		return this.preguntaOriginal;
	}
	
	/**
	 * Comprueba si la respuesta dada por el alumno coincide con la real o no
	 * @return
	 */
	public boolean esCorrecta() {
		if (contestada == false) {
			return false;
		}
		if (preguntaOriginal.getTipoRespuesta().equals(TipoRespuesta.SIMPLE) || 
				preguntaOriginal.getTipoRespuesta().equals(TipoRespuesta.UNICA)) {
			if(preguntaOriginal.getOpcionCorrecta().equals(contestacion.get(0))) {
				return true;
			}
			return false;
		}
		else if (preguntaOriginal.getTipoRespuesta().equals(TipoRespuesta.ABIERTA)) {
			for (Opcion op : preguntaOriginal.getOpcionesCorrecta()) {
				if (contestacion.get(0).getTexto().equals(op.getTexto())) {
					return true;
				}
			}
			return false;
		}
		else if (preguntaOriginal.getTipoRespuesta().equals(TipoRespuesta.MULTIPLE)) {
			for (Opcion opOriginal : preguntaOriginal.getOpcionesCorrecta()) {
				if (contestacion.contains(opOriginal) == false) {
					return false;
				}
			}
			for (Opcion op : contestacion) {
				if (preguntaOriginal.getOpcionesCorrecta().contains(op) == false) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Anyade una contestacion a las posibles que tiene una pregunta de alumno 
	 * @param contestacion
	 * @return indica la correccion de la adicion
	 */
	private boolean anyadirContestacion(Opcion opcion) {
		return this.contestacion.add(opcion);
	}
	
	/**
	 * Devuelve la nota que ha tenido un alumno en esta pregunta
	 * @return nota
	 */
	public double obtenerNota() {
		if (contestada == false) {
			return 0;
		}
		else if (this.esCorrecta()) {
			return preguntaOriginal.getPeso();
		}
		return (-1) * preguntaOriginal.getPenalizacion();
	}
	
	public void contarRespuestas(EjercicioAlumno ejerAlum) {
		if (contestada == false) {
			ejerAlum.blanco();
		}
		else if (this.esCorrecta()) {
			ejerAlum.acierto();
		}
		else {
			ejerAlum.fallos();
		}
		
	}
	
	

}
