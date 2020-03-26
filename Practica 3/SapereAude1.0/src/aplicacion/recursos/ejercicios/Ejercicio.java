/**
 * Fichero Ejercicio.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion.recursos.ejercicios;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import aplicacion.Aplicacion;
import aplicacion.Asignatura;
import aplicacion.Matricula;
import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.recursos.Recurso;
import aplicacion.usuarios.Alumno;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Esta clase se encarga de inplementar la funcionalidad asociada a los 
 * objetos de tipo ejercicio. Es heredera de recurso, se encuentra dentro
 * de un tema y esta formado por una serie de preguntas.
 * @author Andres y Francisco
 */
public class Ejercicio extends Recurso implements Serializable {
	
	/** Fecha inicial para la activacion del ejercicio */
	private LocalDate fechaIni;
	
	/** Fecha final para la activacion del ejercicio */
	private LocalDate fechaFin;
	
	/** Ponderacion del ejercicio respecto a la nota del curso */
	private double ponderacion;
	
	/** Aleatoriedad en el orden de las preguntas del ejercicio */
	private boolean aleatoriedad;
	
	/** Comentarios previos del ejercicio */
	private String comentarios;
	
	/** Nota por defecto para las preguntas del ejercicio */
	private double notaXdefecto;
	
	/** Lista de las preguntas en las que consiste el ejercicio */
	private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
	
	/** Contador para asignar identificadores a las preguntas */
	private int cont;
	
	/** Nota media obtenida entre todos los alumnos que han realizado el ejercicio */
	private double notaMedia;
	
	/** Porcentaje de respuestas acertadas de todos los alumnos que han realizado este ejercicio */
	private double pAciertos;
	
	/** Porcentaje de respuestas falladas de todos los alumnos que han realizado este ejercicio */
	private double pFallos;
	
	/** Porcentaje de respuestas en blanco de todos los alumnos que han realizado este ejercicio */
	private double pBlancos;
	
	
	/**
	 * Constructor de la clase
	 * @param visibilidad
	 * @param titulo
	 * @param fechaInicio
	 * @param fechaFin
	 * @param ponderacion
	 * @param aleatorio
	 * @param comentarios
	 * @param notaXdefecto
	 * @param asig
	 */
	public Ejercicio(boolean visibilidad, String titulo, LocalDate fechaInicio, LocalDate fechaFin, Double ponderacion, boolean aleatorio,
			String comentarios, double notaXdefecto, Asignatura asig) {
		super(titulo, visibilidad, asig);
		if (fechaInicio.isAfter(fechaFin)) {
			return;
		}
		this.fechaIni = fechaInicio;
		this.fechaFin = fechaFin;
		this.ponderacion = ponderacion;
		this.aleatoriedad = aleatorio;
		this.comentarios = comentarios;
		this.notaXdefecto = notaXdefecto;
		this.preguntas = new ArrayList<Pregunta>();
		this.cont = 1;
		this.notaMedia = -1;
		this.pAciertos = -1;
		this.pFallos = -1;
		this.pBlancos = -1;
	}
	
	/**
	 * Constructor de la clase con visibilidad por defecto
	 * @param fechaInicio
	 * @param fechaFin
	 * @param ponderacion
	 * @param aleatorio
	 * @param comentarios
	 * @param notaXdefecto
	 * @param asig
	 */
	public Ejercicio(String titulo, LocalDate fechaInicio, LocalDate fechaFin, Double ponderacion, boolean aleatorio,
			String comentarios, double notaXdefecto, Asignatura asig) {
		super(titulo, true, asig);
		if (fechaInicio.isAfter(fechaFin)) {
			return;
		}
		this.fechaIni = fechaInicio;
		this.fechaFin = fechaFin;
		this.ponderacion = ponderacion;
		this.aleatoriedad = aleatorio;
		this.comentarios = comentarios;
		this.notaXdefecto = notaXdefecto;
		this.preguntas = new ArrayList<Pregunta>();
		this.cont = 1;
		this.notaMedia = -1;
		this.pAciertos = -1;
		this.pFallos = -1;
		this.pBlancos = -1;
	}

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public boolean setFechaIni(LocalDate fechaInicio) throws InvalidEmailAddressException, FailedInternetConnectionException {
		if (fechaInicio.isAfter(this.fechaFin)) {
			return false;
		}
		String mensaje = "";
		for (Matricula mat : asignatura.getAlumnado()) {
			mensaje = "El ejercicio " + titulo + " de la asignatura " + asignatura.getNombre() + " ha visto modificada su fecha de inicio.";
			EmailSystem.send(mat.getAlumno().getCorreo(), "Ejercicio modificado", mensaje, true);
		}
		this.fechaIni = fechaInicio;
		return true;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public boolean setFechaFin(LocalDate fechaFin) throws InvalidEmailAddressException, FailedInternetConnectionException {
		if (fechaFin.isBefore(this.fechaIni)) {
			return false;
		}
		String mensaje = "";
		for (Matricula mat : asignatura.getAlumnado()) {
			mensaje = "El ejercicio " + titulo + " de la asignatura " + asignatura.getNombre() + " ha visto modificada su fecha final.";
			EmailSystem.send(mat.getAlumno().getCorreo(), "Ejercicio modificado", mensaje, true);
		}
		this.fechaFin = fechaFin;
		return true;
	}

	public Double getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Double ponderacion) {
		this.ponderacion = ponderacion;
	}

	public boolean isAleatorio() {
		return aleatoriedad;
	}

	public void setAleatoriedad(boolean aleatorio) {
		this.aleatoriedad = aleatorio;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public double getNotaXdefecto() {
		return notaXdefecto;
	}

	public void setNotaXdefecto(double notaXdefecto) {
		this.notaXdefecto = notaXdefecto;
	}
	
	public ArrayList<Pregunta> getPreguntas() {
		return this.preguntas;
	}
	
	public int getCont() {
		return this.cont;
	}
	
	public double getNotaMedia() {
		if (notaMedia == -1) {
			notaMedia = calcularNotaMedia();
		}	
		return notaMedia;
	}
	
	public double getpAciertos() {
		if (pAciertos == -1) {
			setPorcentajes();
		}
		return pAciertos;
	}

	public double getpFallos() {
		if (pFallos == -1) {
			setPorcentajes();
		}
		return pFallos;
	}

	public double getpBlancos() {
		if (pBlancos == -1) {
			setPorcentajes();
		}
		return pBlancos;
	}
	
	public Asignatura getAsignatura() {
		return this.asignatura;
	}
	
	/**
	 * Oculta el recurso
	 */
	public void ocultar() {
		visibilidad = false;
	}
	
	/**
	 * Revela el recurso
	 */
	public void revelar() {
		visibilidad = true;
	}

	/**
	 * Anyade y crea una pregunta al ejercicio
	 * @param peso : campo de la pregunta a crear
	 * @param enunciado : campo de la pregunta a crear
	 * @param aleatoriedad : campo de la pregunta a crear
	 * @param penalizacion : campo de la pregunta a crear
	 * @param tipoRespuesta : campo de la pregunta a crear
	 * @return correccion de la adicion
	 */
	public boolean anyadirPregunta(double peso, String enunciado, boolean aleatoriedad, double penalizacion, TipoRespuesta tipoRespuesta) {
		Pregunta pregunta = new Pregunta(cont, peso, enunciado, aleatoriedad, penalizacion, tipoRespuesta);
		aumentarCont();
		return preguntas.add(pregunta);
	}
	
	/**
	 * Anyade una pregunta ya creada al ejercicio
	 * @param pregunta
	 * @return correcion de la adicion
	 */
	public boolean anyadirPregunta(Pregunta pregunta) {
		if (this.isModificable()) {
			aumentarCont();
			return preguntas.add(pregunta);
		}
		return false;
	}
	
	/**
	 * Elimina una pregunta del ejercicio
	 * @param pregunta : pregunta a eliminar
	 * @return correccion de la eliminacion
	 */
	public boolean eliminarPregunta(Pregunta pregunta) {
		decrementarCont();
		return preguntas.remove(pregunta);
	}
	
	/**
	 * Comprueba si durante una fecha dada el ejercicio se encuentra activo  
	 * @param fecha
	 * @return true si esta activo o false si no lo esta
	 */
	public boolean fechaEnRango(LocalDate fecha) {
		if ( ( (fecha.isAfter(fechaIni)) || (fecha.isEqual(fechaIni)) ) && ( fecha.isBefore(fechaFin) ) ) {
			return true;
		}
		return false;
	}
	
	 /**
	  * Aumenta el contador para asignar identificadores a las preguntas
	  */
	public void aumentarCont() {
		cont++;
	}
	
	/**
	  * Decrementa el contador para asignar identificadores a las preguntas
	  */
	public void decrementarCont() {
		cont--;
	}

	/**
	 * Indica si el ejercicio ha sido realizado ya por algun alumno
	 * @return
	 */
	public boolean ejercicioComenzado() {
		for (Matricula mat : asignatura.getAlumnado()) {
			Alumno al = mat.getAlumno();
			for (EjercicioAlumno ejerAlum : al.getEjercicioAlumno()) {
				if (this.equals(ejerAlum.getEjercicio())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Indica si el ejercicio se puede alterar; esto es cuando el ejercicio no ha sido
	 * realizado por algun alumno o su fecha de inicio aun no ha llegado
	 * @return true si es modificable o false si no lo es
	 */
	public boolean isModificable() {
		if (LocalDate.now().isBefore(this.fechaIni)) {
			return true;
		}
		if (ejercicioComenzado()) {
			return false;
		}
		return true;
	}

	/**
	 * Devuelve la nota maxima posible del ejercicio
	 * @return nota
	 */
	public double getNotaTotal() {
		double nota = 0;
		for (Pregunta preg : preguntas) {
			nota += preg.getPeso();
		}
		return nota;
	}
	
	/**
	 * Calcula la nota media de todos los alumnos que han realizado este ejercicio
	 * @return nota media sobre 10
	 */
	public double calcularNotaMedia() {
		double suma = 0;
		int cont = 0;
		
		for (Alumno alum : Aplicacion.getInstance().getAlumnos()) {
			for (EjercicioAlumno ejerAlum : alum.getEjercicioAlumno()) {
				if (ejerAlum.getEjercicio().equals(this)) {
					suma += ejerAlum.getNota();
					cont++;
				}
			}
		}
		if (cont == 0) {
			return -1;
		}
		return suma / cont;
	}
	
	
	public void setPorcentajes() {
		int sumaA = 0, sumaF = 0, sumaB = 0;
		int total = 0;
		
		for (Alumno alum : Aplicacion.getInstance().getAlumnos()) {
			for (EjercicioAlumno ejerAlum : alum.getEjercicioAlumno()) {
				if (ejerAlum.getEjercicio().equals(this)) {
					ejerAlum.calcularNumeroRespuestas();
					
					sumaA += ejerAlum.getnAciertos();
					sumaF += ejerAlum.getnFallos();
					sumaB += ejerAlum.getnBlancos();
				}
			}
		}
		total = sumaA + sumaF + sumaB;
		if (total == 0) {
			pAciertos = 0;
			pFallos = 0;
			pBlancos = 0;
			return;
		}
		
		pAciertos = ((double)sumaA / (double)total) * 100;
		pFallos = ((double)sumaF / (double)total) * 100;
		pBlancos = ((double)sumaB / (double)total) * 100;
		
		return;
	}
	
	
	@Override
	public String toString() {
		return this.getTitulo() + " " + fechaIni + " " + fechaFin + " Porcentaje: " + ponderacion + "\nComentarios: " + comentarios + ": \n" + preguntas ;
	}
	
	
}
