package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import aplicacion.Aplicacion;
import aplicacion.Asignatura;
import aplicacion.Matricula;
import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.recursos.Tema;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import aplicacion.recursos.ejercicios.TipoRespuesta;
import aplicacion.usuarios.Alumno;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class MatriculaTest {

	private static Aplicacion app;
	private static Asignatura a1;
	private static Matricula m1;
	private static Alumno al1;
	private static Tema t1;
	private static Ejercicio e1;
	private static Ejercicio e2;
	private static Pregunta p1;
	private static Pregunta p2;
	private static Pregunta p3;
	private static Pregunta p4;
	
	@BeforeClass
	public static void SetUp(){
		app = Aplicacion.getInstance();
		a1 = new Asignatura("Padsof", "Proyecto de Analisis y Disenyo de Software");
		al1 = new Alumno("2514", "rme.Mora", "Carmen.Mora@esdu.es", "Carmen", "Mora");
		m1 = new Matricula(al1, a1);
		t1 = new Tema("Captura de Requisitos", a1);
		e1 = new Ejercicio(true, "JUnit", LocalDate.now().minusDays(5), LocalDate.now().plusDays(2), 30.0, false, "tema dificil", 1.0, a1);
		e2 = new Ejercicio(true, "Whitebox", LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), 30.0, false, "pruebas de caja blanca", 1.0 , a1);
		p1 = new Pregunta(1, 50, "El teorema de Stokes concierne a la geometria diferencial.", false, 25, TipoRespuesta.SIMPLE);
		p2 = new Pregunta(2, 50, "Un tipo de requisito no funcional es...", false, 0, TipoRespuesta.ABIERTA);
		p3 = new Pregunta(1, 10, "Cuanto es 2 + 3?", false, 0, TipoRespuesta.UNICA);
		p4 = new Pregunta(2, 20, "Para cuales de los siguientes valores de x se cumple |x| < 5?", false, 0, TipoRespuesta.MULTIPLE);
	}
	
	@Test
	public void testCalcularNotaMedia() throws IOException, InvalidEmailAddressException, FailedInternetConnectionException {
		assertTrue(m1.calcularNotaMedia() == 0);
		app.cargarUsuarios("fichero.txt");
		app.anyadirAsignatura(a1); 
		app.identificarse("2514", "rme.Mora"); // solicita la inscripcion a a1
		app.solicitarInscripcion(a1);
		app.identificarse("0000", "1234");
		app.atenderInscripcion(a1.getAlumnado().get(0), true);
		Matricula m = a1.getAlumnado().get(0);
		
		a1.anyadirTema(t1);
		t1.anyadirRecurso(e1); //anyadimos ejercicio1 a tema2
		t1.anyadirRecurso(e2);
		
		e1.anyadirPregunta(p1); //Anyadimos la primera pregunta de ejercicio1
		p1.anyadirOpcionSimple(true);
		
		e1.anyadirPregunta(p2);
		p2.anyadirOpcion("seguridad", true);  //Distintas opciones validas
		p2.anyadirOpcion("rendimiento", true);
		p2.anyadirOpcion("eficiencia", true);
		p2.anyadirOpcion("mantenibilidad", true);
		
		e2.anyadirPregunta(p3); //Anyadimos la primera pregunta de ejercicio1
		p3.anyadirOpcion("2", false);  //Distintas opciones posibles
		p3.anyadirOpcion("3", false);
		p3.anyadirOpcion("4", false);
		p3.anyadirOpcion("5", true);
		p3.anyadirOpcion("1", false);
		
		e2.anyadirPregunta(p4); //Anyadimos la segunda pregunta de ejercicio1
		p4.anyadirOpcion("2", true);  //Distintas opciones posibles
		p4.anyadirOpcion("-3", true);
		p4.anyadirOpcion("-1", true);
		p4.anyadirOpcion("7", false);
		p4.anyadirOpcion("-9", false);
		
		app.identificarse("2514", "rme.Mora");
		
		Alumno a = app.getAlumnos().get(5);
		
		a1.comenzarEjercicio(e1);
		EjercicioAlumno ejerAlum = a.getEjercicioAlumno().get(0);
		
		ejerAlum.responderPregunta(p1.getOpcionNum(1), p1);
		ejerAlum.responderPregunta(new Opcion(0, "seguridad", true), p2);
		
		assertTrue(m.getNotaMedia() == 5);
	}


}

