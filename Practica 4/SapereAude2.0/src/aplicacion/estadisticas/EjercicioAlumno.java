package aplicacion.estadisticas;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import aplicacion.Aplicacion;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import aplicacion.recursos.ejercicios.TipoRespuesta;
import aplicacion.usuarios.Alumno;

@SuppressWarnings("serial")
public class EjercicioAlumno implements Serializable {
	
	/** Nota total obtenida en el ejercicio */
	private double nota;
	
	/** Alumno que ha realizado el ejercicio */
	private Alumno alumno;
	
	/** Preguntas del ejercicio respondidas por el alumno */
	private ArrayList<PreguntaAlumno> preguntasAlumno;
	
	/** Ejercicio realizado por el alumno */
	private Ejercicio ejercicio;
	
	/** Fecha de realizacion del ejercicio por el alumno */
	@SuppressWarnings("unused")
	private LocalDate fecha;
	
	/** numero de preguntas acertadas del ejercicio realizado por el alumno */
	private int nAciertos;
	
	/** numero de preguntas falladas del ejercicio realizado por el alumno */
	private int nFallos;
	
	/** numero de preguntas sin contestar del ejercicio realizado por el alumno */
	private int nBlancos;
	
	
	/**
	 * Constructor de la clase
	 * @param ejercicio
	 * @param fecha
	 * @throws IOException 
	 */
	public EjercicioAlumno(Ejercicio ejercicio, LocalDate fecha) throws IOException {
		if (Aplicacion.getInstance().getUsuarioAct() instanceof Alumno) {
			Alumno al = (Alumno) Aplicacion.getInstance().getUsuarioAct();
			this.nota = -1;
			this.alumno = al;
			this.alumno.anyadirEjercicioAlumno(this);
			this.preguntasAlumno = new ArrayList<PreguntaAlumno>();
			this.ejercicio = ejercicio;
			this.fecha = fecha;
			this.nAciertos = -1;
			this.nFallos = -1;
			this.nBlancos = -1;
			this.ejercicio = ejercicio;
		}
	}
	
	public Ejercicio getEjercicio() {
		return ejercicio;
	}
	
	public ArrayList<PreguntaAlumno> getPreguntasAlumno() {
		return preguntasAlumno;
	}
	
	public double getNota() {
		if (this.nota == -1) {
			calcularNota();
		}
		return this.nota;
	}
	
	public int getnAciertos() {
		if (nAciertos == -1) {
			this.calcularNumeroRespuestas();
		}
		return nAciertos;
	}

	public int getnFallos() {
		if (nFallos == -1) {
			this.calcularNumeroRespuestas();
		}
		return nFallos;
	}

	public int getnBlancos() {
		if (nBlancos == -1) {
			this.calcularNumeroRespuestas();
		}
		return nBlancos;
	}
	
	/**
	 * Aumenta el contador de respuetas en blanco
	 */
	public void blanco() {
		nBlancos++;
	}

	/**
	 * Aumenta el contador de respuetas acertadas
	 */
	public void acierto() {
		nAciertos++;		
	}

	/**
	 * Aumenta el contador de respuetas falladas
	 */
	public void fallos() {
		nFallos++;		
	}

	/**
	 * Anyade una pregunta contestada por el alumno
	 * @return correccion de la adicion
	 */
	public boolean anyadirPreguntaAlumno(PreguntaAlumno preguntaAlumno) {
		return preguntasAlumno.add(preguntaAlumno);
	}
	
	/**
	 * Elimina una pregunta contestada por el alumno
	 * @return correccion de la eliminacion
	 */
	public boolean eliminarEjercicioAlumno(PreguntaAlumno preguntaAlumno) {
		return preguntasAlumno.remove(preguntaAlumno);
	}
	
	/**
	 * Realiza las acciones necesarias para responder una pregunta
	 * @param opcion : opcion respondida
	 * @param pregunta : pregunta respondida
	 * @return Correccion de esta accion
	 */
	public boolean responderPregunta(Opcion opcion, Pregunta pregunta) {
		if (pregunta.getTipoRespuesta().equals(TipoRespuesta.MULTIPLE)) {
			return false;
		}
		return anyadirPreguntaAlumno(new PreguntaAlumno(opcion, pregunta));
	}
	
	/**
	 * Realiza las acciones necesarias para responder una pregunta de respuesta multiple
	 * @param opciones : opciones respondidas
	 * @param pregunta : pregunta respondida
	 * @return Correccion de esta accion
	 */
	public boolean responderPreguntaMultiple(ArrayList<Opcion> opciones, Pregunta pregunta) {
		if (pregunta.getTipoRespuesta().equals(TipoRespuesta.MULTIPLE)) {
			return anyadirPreguntaAlumno(new PreguntaAlumno(opciones, pregunta));
		}
		return false;
	}
	
	/**
	 * Calcula la nota obtenida en el ejercicio
	 * @return nota sobre 10 (con un minimo de 0; es decir si la nota real es negativa, queda reflejado un 0)
	 */
	public double calcularNota() {
		double notaParcial = 0;
		for (PreguntaAlumno pregAlum : preguntasAlumno) {
			notaParcial += pregAlum.obtenerNota();
		}
		notaParcial = notaParcial / ejercicio.getNotaTotal();
		this.nota = 10 * notaParcial;
		if (this.nota < 0) {
			this.nota = 0;
		}
		return this.nota;
	}
	
	/**
	 * Calcula el numero de respuestas acertadas, falladas y dejadas en blanco
	 */
	public void calcularNumeroRespuestas() {
		if ( (nAciertos != -1) || (nBlancos != -1) || (nFallos != -1) ) {
			return;
		}
		nAciertos = 0;
		nFallos = 0;
		nBlancos = 0;
		for (PreguntaAlumno pregAlum : preguntasAlumno) {
			pregAlum.contarRespuestas(this);
		}
	}
	
	/**
	 * Devuelve la pregunta de alumno  de este ejercicio alumno cuya pregunta original se indica
	 * @param p : pregunta original
	 * @return Pregunta de alumno buscada, null si no se encuentra
	 */
	public PreguntaAlumno getPreguntaAlumnoPorPregunta(Pregunta p) {
		for (PreguntaAlumno pa: preguntasAlumno) {
			if (pa.getPreguntaOriginal().equals(p)) {
				return pa;
			}
		}
		return null;
	}
	
}