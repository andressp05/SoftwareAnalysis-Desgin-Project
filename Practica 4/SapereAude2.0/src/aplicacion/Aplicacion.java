/**
 * Fichero Aplicacion.java en el cual se implementa la clase homonima.
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/3/2017
 */
package aplicacion;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import aplicacion.usuarios.Alumno;
import aplicacion.usuarios.Profesor;
import aplicacion.usuarios.Usuario;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase superior dentro de la jerarquia de nuestra apliacacion. Se encuentra formada
 * por una serie de usuarios y almacena las distintas asignaturas creadas. Recoge un
 * importante numero de funciones basicas. Presenta estructura de singleton.
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class Aplicacion implements Serializable {
	
	/** Instancia de la clase */
	private static Aplicacion INSTANCE;
	
	/** Asignaturas existentes en la aplicacion */
	private ArrayList<Asignatura> asignaturas;
	
	/** Alumnos registrados en la aplicacion */
	private ArrayList<Alumno> alumnos;
	
	/** Profesor registrado en la aplicacion. Es una cuenta unica para todos los profesores */
	private Profesor profesor;
	
	/** Usuario que se encuentra actualmente conectado a la apliacion */
	private Usuario usuarioAct;
	
	
	/**
	 * Constructor de la clase
	 * @throws IOException 
	 */
	private Aplicacion() {
		this.asignaturas = new ArrayList<Asignatura>();
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = null;
		this.usuarioAct = null;
		
		try {
			this.cargarUsuarios("fichero.txt");
		} catch (IOException e) {
			System.out.println("No se han podido cargar los datos del fichero de usuarios");
		}
	}
	
	/**
	 * Obtiene la instancia a aplicacion permitiendo disenyar la clase como un singleton
	 * @return la aplicacion
	 * @throws IOException 
	 */
	public static Aplicacion getInstance() throws IOException {
		if (INSTANCE != null) {
			return INSTANCE;
		}
		
		try {
			INSTANCE = cargarDatos();
			return INSTANCE;
		} catch( IOException | ClassNotFoundException ex){
			
		}
		
		INSTANCE = new Aplicacion();
		return INSTANCE;
		
	}
	
	public Usuario getUsuarioAct() {
		return this.usuarioAct;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}

	public void setUsuarioAct(Usuario usuarioAct) {
		this.usuarioAct = usuarioAct;
	}

	public ArrayList<Alumno> getAlumnos() {
		return this.alumnos;
	}
	
	public ArrayList<Asignatura> getAsignaturas() {
		return this.asignaturas;
	}
 
	/**
	 * Permite anyadir una nueva asignatura al sistema
	 * @param asignatura : asignatura ya creada a anyadir
	 * @return si se ha anyadido correctamente
	 */
	public boolean anyadirAsignatura(Asignatura asignatura) {
		return asignaturas.add(asignatura);
	}
	
	/**
	 * Permite anyadir un nuevo alumno al sistema
	 * @param alumno : alumno ya creado a anyadir
	 * @return si se ha anyadido correctamente
	 */
	public boolean anyadirAlumno(Alumno alumno) {
		return this.alumnos.add(alumno);
	}
	
	/**
	 * Permite anyadir el profesor asociado al sistema. Si ya exitiera uno
	 * no se hace nada
	 * @param profesor : profesor ya creado a anyadir
	 * @return si se ha anyadido correctmante o no
	 */
	public boolean anyadirProfesor(Profesor profesor) {
		if (this.profesor == null) {
			this.profesor = profesor;
			return true;
		}
		return false;
	}
	
	/**
	 * Comprueba si los datos de acceso de un usuario que desea acceder a la 
	 * aplicacion son correctos y determina el tipo de usuario.
	 * @param nick : nombre de acceso del usuario
	 * @param contrasenya : contrasenya de acceso del usuario
	 * @return resultado de la identificacion
	 */
	public boolean identificarse(String nick, String contrasenya) {
		if ( (this.profesor.getNuma().equals(nick)) &&  /* Profesor */
			 (profesor.getContrasenya().equals(contrasenya)) ) { 
			setUsuarioAct(profesor);
			return true;
		}
		else {  /* Alumno */
			for (Alumno alum : alumnos) {
				if ( (alum.getNuma().equals(nick)) &&  
				     (alum.getContrasenya().equals(contrasenya)) ) {
					setUsuarioAct(alum);
					System.out.println(alum.getNombre() + " se idenfifica.");
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * Carga los distintos usuarios del sistema a partir de un fichero para los alumno
	 * y crea un profesor por defecto.
	 * @param fichero : fichero de datos de alumnos
	 * @return indica si la carga se ha realizado sin problema o no
	 * @throws IOException
	 */
	public boolean cargarUsuarios(String fichero) throws IOException {
		BufferedReader buffer = new BufferedReader( new InputStreamReader( new FileInputStream(fichero) ) );
		boolean flagFirstLine = false;
		String linea;
		
		while ((linea = buffer.readLine()) != null) {
			if (linea.length() == 0) {
				break;
			}
			if (flagFirstLine) { /* Alumnos */
				String toks[] = linea.split(";");
				
				String nombre = toks[0];
				String apellido = toks[1];
				String correo = toks[2];
				
				//Comprobacion correo
				if (EmailSystem.isValidEmailAddr(correo) == false) {	
					System.out.println("Error en la direccion de correo");
				} else {
				
					String numa = toks[3];
					String contrasenya = toks[4];
				
					Alumno alumno = new Alumno(numa, contrasenya, correo, nombre, apellido);
					if (anyadirAlumno(alumno) == false) {
						buffer.close();
						return false;
					}
				}
			} else { /* Profesor */
				String toks1[] = linea.split(";");
				String numa1 = toks1[0];
				String contrasenya1 = toks1[1];
				String correo1 = toks1[2];
				if (anyadirProfesor(new Profesor(numa1, contrasenya1, correo1)) == false) {
					buffer.close();
					return false;
				} 
				flagFirstLine = true;
			}
			
		}
		buffer.close();
		return true;
	}
	
	/**
	 * Permite a un alumno solicitar su matriculacion en una asignatura.
	 * @param asig : asignatura que solicita
	 * @return Indica si la solicitud se ha realizado sin problema 
	 */
	public boolean solicitarInscripcion(Asignatura asig) {
		if (getUsuarioAct() instanceof Alumno) {
			Alumno alumno = (Alumno) getUsuarioAct();
			
			/*Comprobamos que el alumno no este ya matriculado en la asignatura*/
			if (alumno.alumnoMatriculado(asig)) {
				return false;
			}
			
			Matricula mat = new Matricula(alumno, asig);
			asig.anyadirAlumno(mat);
			alumno.anyadirMatricula(mat);
			System.out.println(alumno.getNombre() + " ha solicitado");
			return true;
		}
		return false;
	}
	
	/**
	 * Permite a un profesor validar o denergar una solicitud
	 * @param mat : matricula a atender
	 * @param aceptado : true para aceptar, false para denegar
	 * @return indica si la correccino se ha realizado sin problema
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public boolean atenderInscripcion(Matricula mat, boolean aceptado) throws InvalidEmailAddressException, FailedInternetConnectionException {
		String mensaje = "";
		if (getUsuarioAct() instanceof Profesor) {
			if (aceptado) { /* aceptar */
				mat.setEstado(EstadoMatricula.CURSANDO);
				mensaje = "tu solicitud a la asignatura " + mat.getAsignatura().getNombre() + " ha sido aceptada";
				EmailSystem.send(mat.getAlumno().getCorreo(), "Solicitud de matriculacion", mensaje, true);
			} 
			else { /* denegar */
				mat.getAlumno().eliminarMatricula(mat);
				mat.getAsignatura().eliminarAlumno(mat);
				mensaje = "tu solicitud a la asignatura " + mat.getAsignatura().getNombre() + " ha sido denegada";
				EmailSystem.send(mat.getAlumno().getCorreo(), "Solicitud de matriculacion", mensaje, true);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Permite guardar todos los datos de la aplicacion en un fichero tipo objectdata
	 * @throws IOException
	 */
	public void guardarDatos() throws IOException {
		ObjectOutputStream salida = new ObjectOutputStream( new FileOutputStream("aplicacion.objectData") );
		salida.writeObject(this);
		salida.close();
		return;
	}
	
	/**
	 * Permite cargar los datos a partir de un fichero de tipo objectdata
	 * @return aplicacion cargada
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Aplicacion cargarDatos() throws IOException, ClassNotFoundException {
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("aplicacion.objectData"));
		Aplicacion app = (Aplicacion) entrada.readObject();
		entrada.close();
		INSTANCE = app;
		
		return app;
	}
	
	/**
	 * Permite cerrar la sesion de un usuario. Realiza un guardado de datos
	 * @throws IOException
	 */
	public void cerrarSesion() throws IOException {
		guardarDatos();
		usuarioAct = null;
		INSTANCE = null;
	}
	
	
	@Override
	public String toString() {
		String str = "Aplicacion:\n";
		if (getUsuarioAct() != null) {
			str = str.concat("->usuarioAct: " + getUsuarioAct().getNuma() + "\n");
		}
		if (profesor != null) {
			str = str.concat("->profesor: " + profesor.getNuma() + "\n");
		}
		str = str.concat("->asignaturas: \n");
		for (Asignatura a : asignaturas) {
			str = str.concat("\t" + a.getNombre() + "\n");
		}
		str = str.concat("Alumnos: \n");
		for (Alumno al : alumnos) {
			str = str.concat("\t" + al.getNombre() + "\n");
		}
		return str;
	}

	public Asignatura getAsignaturasPorNombre(String nombre) {
		for (Asignatura asig: this.getAsignaturas()) {
			if (asig.getNombre().equals(nombre)) {
				return asig;
			}
		}
		return null;
	}
	
	
}
