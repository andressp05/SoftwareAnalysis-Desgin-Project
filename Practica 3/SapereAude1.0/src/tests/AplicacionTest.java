package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;

import aplicacion.Aplicacion;
import aplicacion.Asignatura;
import aplicacion.EstadoMatricula;
import aplicacion.usuarios.Alumno;
import aplicacion.usuarios.Profesor;

public class AplicacionTest {

	private static Aplicacion app;
	private static Asignatura a;
	private static Asignatura a1;
	private static Asignatura a2;
	private static Alumno al;
	private static Alumno al1;
	private static Alumno al2;
	private static Profesor p1;
	private static Profesor p2;
	
	
	@BeforeClass
	public static void SetUp() {

		app = Aplicacion.getInstance();
		a = new Asignatura("Matematicas", "temario de bachillerato");
		a1 = new Asignatura("Padsof", "Proyecto de Analisis y Disenyo de Software");
		a2 = new Asignatura("Adsof", "Analisis y Disenyo de Software");
		al = new Alumno("1234", "0258", "Paco.Vicente@esdu.es", "Paco", "Vicente");
		al1 = new Alumno("3636", "perry2", "yo.sinapellidos@uam.es", "Emilina", "Costo");
		al2 = new Alumno("666", "elClubdelHerrete", "tu.conapellidos@uam.es", "Yudrigo", "Hongpool");
		p1 = new Profesor("3333","a2de", "soy.profe1@uam.es");
		p2 = new Profesor("1111","9876", "soy.profe2@uam.es");

		
		app.anyadirAlumno(al); //Anyadimos un alumno de prueba a la aplicacion
		app.anyadirAsignatura(a); //Anyadimos una aplicacion de prueba a la aplicacion
	}
	
	@Test
	public void testAnyadirAsignatura() {
		assertTrue(app.getAsignaturas().size() == 1); //Aplicacion sin asignaturas
		app.anyadirAsignatura(a1); //Anyadimos una asignatura
		assertTrue(app.getAsignaturas().get(1).equals(a1)); // Se anyade correctamente
		app.anyadirAsignatura(a2);
		assertTrue(app.getAsignaturas().get(2).equals(a2)); // De nuevo se comporta de forma correcta
	}

	@Test
	public void testAnyadirAlumno() {
		assertTrue(app.getAlumnos().size() == 1); //Aplicacion con un unico alumno
		app.anyadirAlumno(al1); //Anyadimos una alumno
		assertTrue(app.getAlumnos().get(1).equals(al1)); // Se anyade correctamente
		app.anyadirAlumno(al2);
		assertTrue(app.getAlumnos().get(2).equals(al2)); // De nuevo se comporta de forma correcta
	}
	
	@Test
	public void testAnyadirProfesor() {
		app.anyadirProfesor(p2); //Lo anyade
		assertTrue(app.getProfesor().equals(p2));
		app.anyadirProfesor(p1);
		assertFalse(app.getProfesor().equals(p1)); //Una vez anyadido no permite su modificacion
	}
	
	@Test
	public void testIdentificarse() {
		app.anyadirProfesor(p2);
		assertTrue(app.getAlumnos().get(0) == al); //El alumno paco esta en la aplicacion
		assertTrue(app.identificarse("1234", "0258"));
		assertTrue(app.getUsuarioAct().equals(al)); //Paco se ha identificado como el usuario actual
		assertTrue(app.identificarse("1111", "9876"));
	}
	
	@Test
	public void testCargarUsuarios() throws IOException {
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		app.cargarUsuarios("fichero.txt"); //Realizamos la lectura
		
		for (Alumno alum : app.getAlumnos()) { //Probamos algunos ejemplos del fichero
			if (alum.getContrasenya().equals("er.Carrera@ar")) {
				flag1 = true;
			}
			if (alum.getCorreo().equals("Roberto.Paz@aadu.es")) {
				flag2 = true;
			}
			if (alum.getNuma().equals("2525")) {
				flag3 = true;
			}
			if (alum.getNombre().equals("Luis")) { //No se debe introducir por tener un correo incorrecto
				flag4 = true;
			}
		}
		
		assertTrue(flag1);
		assertTrue(flag2);
		assertTrue(flag3);
		assertFalse(flag4);
	}
	
	@Test
	public void testSolicitarInscripcion() {
		app.setUsuarioAct(al);
		assertTrue(app.solicitarInscripcion(a)); //El usuario al solicita inscribirse a la asignatura a
		assertTrue(al.getMatriculas().get(0).getAsignatura().equals(a));
		assertTrue(al.getMatriculas().get(0).getEstado().equals(EstadoMatricula.PENDIENTE));
		assertTrue(a.getAlumnado().get(0).getAlumno().equals(al));
	}
	
	
}