/**
 * Fichero Tema.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion.recursos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import aplicacion.Asignatura;
import aplicacion.recursos.ejercicios.Ejercicio;

/**
 * Esta clase es una de las herederas de recurso y se encarga de organizar
 * el resto de recursos pertenecientes a la misma asignatura que el tema.
 * @author Andres y Francisco
 */
public class Tema extends Recurso implements Serializable {
	
	/** Lista de recursos pertenecientes al tema, podiendo ser tanto ejerercicios o apuntes como subtemas. */
	private ArrayList<Recurso> recursos = null;
	
	
	/**
	 * Constructor de la clase con visibilidad por defecto
	 * @param titulo
	 */
	public Tema(String titulo, Asignatura asig) {
		super(titulo, true, asig);
		recursos = new ArrayList<Recurso>();
	}
	
	/**
	 * Constructor de la clase
	 * @param titulo
	 * @param visibilidad
	 */
	public Tema(String titulo, boolean visibilidad, Asignatura asig) {
		super(titulo, visibilidad, asig);
		recursos = new ArrayList<Recurso>();
	}
	
	public ArrayList<Recurso> getRecursos() {
		return this.recursos;
	}
	
	/**
	 * Anyade un recurso nuevo al tema
	 * @param recurso : recurso a anyadir
	 * @return correccion de la adicion
	 */
	public boolean anyadirRecurso(Recurso recurso) {
		return recursos.add(recurso);
	}
	
	/**
	 * Elimina un recurso del tema. Comprueba para ejercicios que sean eliminable 
	 * y para temas que estos se encuentren vacios
	 * @param recurso : recurso a anyadir
	 * @return correccion de la eliminacion
	 */
	public boolean eliminarRecurso(Recurso recurso) {
		if (recurso instanceof Ejercicio) {
			Ejercicio ej = (Ejercicio) recurso;
			/*No se puede borrar un ejercicio que haya sido realizado por algun alumno o ya haya finalizado*/
			if ( ej.getFechaFin().isBefore(LocalDate.now()) || ej.ejercicioComenzado() ) {
				return false;
			}
		}
		else if (recurso instanceof Tema) {
			/*No se puede borrar un tema que contiene algun recurso*/
			Tema t = (Tema) recurso;
			if (t.recursos.size() > 0) {
				return false;
			}
		}
		
		return recursos.remove(recurso);
	}
	
	/**
	 * Comprueba si un ejercicio esta dentro de un tema o en alguno de sus subtemas recursivamente
	 * @param ejercicio : ejercicio a buscar
	 * @return resultado de la busqueda
	 */
	public boolean ejercicioPerteneceTema(Ejercicio ejercicio) {
		boolean flag = false;
		if (recursos.size() == 0 || recursos == null) {
			return false;
		}
		if (recursos.contains(ejercicio)) {
			return true;
		}
		for (Recurso r : recursos) {
			if (r instanceof Tema) {
				Tema t = (Tema) r;
				if (t.ejercicioPerteneceTema(ejercicio)) {
					flag = true;
				}
			}
		}
		return flag;
	}
	
	/**
	 * Calcula la suma de las ponderaciones de los distintos ejercicios que hay en un tema
	 * y en sus subtemas de forma recursiva
	 * @return suma parcial
	 */
	public double ponderacionParcialTema() {
		double sumaParcial = 0;
		if (recursos.size() == 0 || recursos == null) {
			return 0;
		}
		for (Recurso r : recursos) {
			if (r instanceof Tema) {
				Tema t = (Tema) r;
				sumaParcial += t.ponderacionParcialTema();
			}
			else if (r instanceof Ejercicio) {
				Ejercicio e = (Ejercicio) r;
				sumaParcial += e.getPonderacion();
			}
		}
		return sumaParcial;
	}
	
	
	@Override
	public String toString() {
		String str = this.getTitulo() + ":\n\t";
		for (Recurso r : recursos) {
			str = str.concat(r.getTitulo() + ", ");
		}
		return str;
	}

	
	
}

