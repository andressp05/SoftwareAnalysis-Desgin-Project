/**
 * Fichero Asignatura.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.recursos.Tema;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.usuarios.Alumno;
import aplicacion.usuarios.Profesor;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Esta clase es la encargada de implementar cada una de las asignaturas de las que se compondra nuestra 
 * aplicacion. Esta formada por diversos recursos y tiene ciertos alumnos matriculados en ella.
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class Asignatura implements Serializable {
	
	/** Nombre de la asignatura */
	private String nombre;

	/** Descripcion de la asignatura */
	private String descripcion;

	/** Tema raiz de la asignatura */
	private Tema contenidos;

	/** Matriculas asociadas a la asignatura */
	private ArrayList<Matricula> alumnado;

	
	/**
	 * Constructor principal de la clase. En la practica no se utiliza porque al crear una clase de este tipo
	 * no contaremos con todos los campos necesarios para completar su estructura.
	 * @param nombre
	 * @param desc
	 */
	public Asignatura(String nombre, String desc){
		this.nombre = nombre;
		this.descripcion = desc;
		this.contenidos = new Tema("Contenidos", this);
		this.alumnado = new ArrayList<Matricula>();
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public ArrayList<Matricula> getAlumnado() {
		return this.alumnado;
	}
	
	public Tema getContenidos() {
		return this.contenidos;
	}
	
	/**
	 * Anyade una nueva matricula a la asignatura
	 * @param alumno : matricula a anyadir
	 * @return Correccion de la adicion
	 */
	public boolean anyadirAlumno(Matricula alumno) {
		if (alumno.getAsignatura().equals(this) == false) {
			return false;
		}
		return alumnado.add(alumno);
	}
	
	/**
	 * Elimina una matricula de la asignatura
	 * @param alumno : matricula a eliminar
	 * @return correccion de la aliminacion
	 */
	public boolean eliminarAlumno(Matricula alumno) {
		return alumnado.remove(alumno);
	}
	
	/**
	 * Permite a un profesor poner a un alumno de la asignatura en estado de expulsado
	 * @param alumno : alumno a expulsar
	 * @return correccion de la expulsion
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 * @throws IOException 
	 */
	public boolean expulsar(Alumno alumno) throws InvalidEmailAddressException, FailedInternetConnectionException, IOException {
		if (Aplicacion.getInstance().getUsuarioAct() instanceof Profesor) { 
			
			/*Comprobamos que el alumno este cursando la asignatura*/
			for (Matricula m : alumno.getMatriculas()) {
				if (m.getAsignatura().equals(this) && m.getEstado().equals(EstadoMatricula.CURSANDO)) {
					m.setEstado(EstadoMatricula.EXPULSADO);
					String mensaje = "Has sido expulsado de la asignatura " + this.getNombre();
					EmailSystem.send(alumno.getCorreo(), "Expulsion", mensaje, true);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Permite a un profesor readmitir a un alumno expulsado de la asignatura
	 * @param alumno : alumno a readmitir
	 * @return Correccion de la readmision
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 * @throws IOException 
	 */
	public boolean readmitir(Alumno alumno) throws InvalidEmailAddressException, FailedInternetConnectionException, IOException {
		if (Aplicacion.getInstance().getUsuarioAct() instanceof Profesor) { 
			
			/*Comprobamos que el alumno este expulsado de la asignatura*/
			for (Matricula m : alumno.getMatriculas()) {
				if (m.getAsignatura().equals(this) && m.getEstado().equals(EstadoMatricula.EXPULSADO)) {
					m.setEstado(EstadoMatricula.CURSANDO);
					String mensaje = "Has sido readmitido en la asignatura " + this.getNombre();
					EmailSystem.send(alumno.getCorreo(), "Readmision", mensaje, true);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Realiza las acciones previas necesarias para que un alumno realice un ejercicio
	 * @param ejercicio : ejercicio a realizar
	 * @return correccion de la accion
	 * @throws IOException 
	 */
	public boolean comenzarEjercicio(Ejercicio ejercicio) throws IOException {
		if (Aplicacion.getInstance().getUsuarioAct() instanceof Alumno) {
			Alumno al = (Alumno) Aplicacion.getInstance().getUsuarioAct();
			
			if (al.alumnoCursando(this) && this.ejercicioPerteneceAsignatura(ejercicio) && ejercicio.fechaEnRango(LocalDate.now())) {
				EjercicioAlumno ejAlum = new EjercicioAlumno(ejercicio, LocalDate.now());
				System.out.println("Entramos aquiiii");
				al.anyadirEjercicioAlumno(ejAlum);
				return true;
			}
			
		}
		System.out.println("No entramos ahi");
		return false;
		
		
	}
	
	/**
	 * Comprueba si un ejercicio pertenece a la asignatura
	 * @param ejercicio : ejercicio a buscar
	 * @return resultado de la busqueda
	 */
	public boolean ejercicioPerteneceAsignatura(Ejercicio ejercicio) {
		if (contenidos.ejercicioPerteneceTema(ejercicio)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Obtiene la suma de las ponderaciones de todos los ejercicios de esta asignatura
	 * @return ponderacion total
	 */
	public double ponderacionTotal() {
		double suma = 0;

		suma += contenidos.ponderacionParcialTema();
		
		return suma;
		
	}
	
	
	@Override
	public String toString() {
		String str = "";
		str = str.concat("Nombre: " + nombre + "\n");
		str = str.concat("Desc: " + descripcion + "\n");
		
		str = str.concat("\nAlumnado: ");
		for (Matricula mat : alumnado) {
			if (mat.getEstado().equals(EstadoMatricula.CURSANDO) ) {
				str = str.concat(mat.getAlumno().getNombre() + ", ");
			}
			else if (mat.getEstado().equals(EstadoMatricula.EXPULSADO) ) {
				str = str.concat(mat.getAlumno().getNombre() + " (expulsado), ");
			}
			else if (mat.getEstado().equals(EstadoMatricula.PENDIENTE) ) {
				str = str.concat(mat.getAlumno().getNombre() + " (pendiente), ");
			}
		}
		return str;
	}


	
	
}