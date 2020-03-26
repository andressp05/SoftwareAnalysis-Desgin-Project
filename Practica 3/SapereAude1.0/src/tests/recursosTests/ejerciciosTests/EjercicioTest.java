package tests.recursosTests.ejerciciosTests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import aplicacion.Aplicacion;
import aplicacion.Asignatura;
import aplicacion.EstadoMatricula;
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

public class EjercicioTest {

	private static Aplicacion app;
	private static Asignatura asig;
	private static Ejercicio e1;
	private static Ejercicio e2;
	private static Ejercicio e3;
	private static Ejercicio e4;
	private static Ejercicio e5;
	private static Ejercicio ejer1;
	private static Pregunta p1;
	private static Pregunta p2;
	private static Pregunta p3;
	private static Pregunta p4;
	private static Pregunta p5;
	private static Alumno al;
	private static Matricula mat;
	private static Tema tema;
	
	@BeforeClass
	public static void SetUp(){
		app = Aplicacion.getInstance();
		asig = new Asignatura("Fisica", "temario de bachillerato");
		al = new Alumno("9876", "1997", "Andres.Salas@esdu.es", "Andres", "Salas");
		tema = new Tema("tema1", asig);
		
		mat = new Matricula(al, asig); //Matricula entre al y asig
		mat.setEstado(EstadoMatricula.CURSANDO);
		asig.anyadirAlumno(mat);
		al.anyadirMatricula(mat);
		asig.anyadirTema(tema); //anyadimos tema a asig
		
		app.anyadirAlumno(al);
		app.anyadirAsignatura(asig);
		
		e1 = new Ejercicio(true, "Conceptos Basicos", LocalDate.now().minusDays(5), LocalDate.now().plusDays(5), 20.0, true, "la cultura general de nuestros padres", 5.2, asig);
		e2 = new Ejercicio(true, "Matematicas", LocalDate.now(), LocalDate.now().plusDays(10), 20.0, true, "hay miedo a las mates eh", 5, asig); 
		e3 = new Ejercicio(true, "Quimica", LocalDate.now(), LocalDate.now().plusDays(10), 20.0, true, "hay miedo a Laura eh", 5, asig); 
		e4 = new Ejercicio(true, "ejericcio4", LocalDate.now().minusDays(5), LocalDate.now().plusDays(5), 20.0, false, "Esto es un comentario", 5, asig);
		e5 = new Ejercicio(true, "ejericcio5", LocalDate.now().minusDays(2), LocalDate.now().plusDays(5), 20.0, false, "Esto es otro comentario", 5, asig);
		ejer1 = new Ejercicio(true, "ejer1", LocalDate.now().minusDays(2), LocalDate.now().plusDays(5), 20.0, false, "comentario", 5, asig);
		p1 = new Pregunta(1, 20.0, "¿Cuanto es 2+3?", false, 5.0, TipoRespuesta.UNICA);
		p2 = new Pregunta(2, 20.0, "El rio Guadalquivir pasa por Sevilla", false, 0.0, TipoRespuesta.SIMPLE);
		p3 = new Pregunta(1, 20.0, "¿Voy a aprobar Padsof?", false, 5.0, TipoRespuesta.UNICA);
		
		p4 = new Pregunta(1, 20.0, "1 + 1 = 5", false, 0.0, TipoRespuesta.SIMPLE);
		p4.anyadirOpcionSimple(false);
		p5 = new Pregunta(2, 20.0, "2 * 3 = ?", false, 0.0, TipoRespuesta.ABIERTA);
		p5.anyadirOpcion("5", true);
		p5.anyadirOpcion("Cinco", true);
		p5.anyadirOpcion("cinco", true);
		p5.anyadirOpcion("CINCO", true);
		
		tema.anyadirRecurso(e4); //anyadimos el ejercicio e4 a tema
		tema.anyadirRecurso(e5); //anyadimos el ejercicio e2 a tema
		tema.anyadirRecurso(ejer1);
		
		ejer1.anyadirPregunta(p4);
		ejer1.anyadirPregunta(p5);
	}
	
	
	@Test
	public void testSetFechaIni() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertFalse(e1.setFechaIni(LocalDate.now().plusDays(10)));
		assertTrue(e1.setFechaIni(LocalDate.now().plusDays(3)));
		e1.setFechaIni(LocalDate.now().minusDays(5));
	}
	
	@Test
	public void testSetFechaFin() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertFalse(e1.setFechaFin(LocalDate.now().minusDays(6)));
		assertTrue(e1.setFechaFin(LocalDate.now().minusDays(3)));
		e1.setFechaFin(LocalDate.now().plusDays(5));
	}
	
	@Test
	public void testAnyadirPregunta() {
		e1.anyadirPregunta(p1);
		e1.anyadirPregunta(p2);
		assertTrue(e1.getPreguntas().contains(p1));
		assertTrue(e1.getPreguntas().contains(p2));
		
		
		e2.anyadirPregunta(p1);
		assertTrue(e2.getPreguntas().contains(p1));
		assertFalse(e2.getPreguntas().contains(p2));
		
		e1.eliminarPregunta(p1);
		e1.eliminarPregunta(p2);
		e2.eliminarPregunta(p1);	
	}
	
	@Test
	public void testAnyadirPregunta2() {
		e3.anyadirPregunta(20.0, "¿Voy a aprobar Padsof?", false, 5.0, TipoRespuesta.UNICA);
		assertEquals(e3.getPreguntas().get(0), p3);
	}
	
	@Test
	public void testEliminarPregunta() {
		e1.anyadirPregunta(p1);
		e1.anyadirPregunta(p2);
		e1.eliminarPregunta(p1);
		assertFalse(e1.getPreguntas().contains(p1));
		assertTrue(e1.getPreguntas().contains(p2));
		e1.eliminarPregunta(p2);
		assertFalse(e1.getPreguntas().contains(p2));
		
		
		e2.anyadirPregunta(p1);
		e2.eliminarPregunta(p1);
		assertFalse(e2.getPreguntas().contains(p1));		
	}
	
	@Test
	public void testFechaEnRango() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertTrue(e1.fechaEnRango(LocalDate.now()));//En rango
		assertTrue(e2.fechaEnRango(LocalDate.now()));//Empieza hoy
		e1.setFechaIni(LocalDate.now().plusDays(1));//Empieza mañana
		assertFalse(e1.fechaEnRango(LocalDate.now()));
		e2.setFechaIni(LocalDate.now().minusDays(21));
		e2.setFechaFin(LocalDate.now().minusDays(20));//Termino hace mucho
		assertFalse(e2.fechaEnRango(LocalDate.now()));
		
		e1.setFechaIni(LocalDate.now().minusDays(5));
		e2.setFechaFin(LocalDate.now().plusDays(10));
		e2.setFechaIni(LocalDate.now());
	}
	
	@Test
	public void testAumentarCont() {
		e1.aumentarCont();
		assertEquals(e1.getCont(), 2);
		e1.decrementarCont();
	}
	
	@Test
	public void testDecrementarCont() {
		e1.decrementarCont();
		assertEquals(e1.getCont(), 0);
		e1.aumentarCont();
	}
	
	@Test
	public void testEjercicioComenzado() {
		assertFalse(e4.ejercicioComenzado()); //Nadie ha realizado el ejercicio
		app.setUsuarioAct(al); //El alumno se identifica para poder comenzar un ejercicio
		asig.comenzarEjercicio(e4);
		assertTrue(e4.ejercicioComenzado()); //El ejercicio ya ha sido comenzado
	}

	@Test
	public void testIsModificable() throws InvalidEmailAddressException, FailedInternetConnectionException {
		e5.setFechaIni(LocalDate.now().plusDays(3)); //si fecha inicio posterior a la actual siempre true
		assertTrue(e5.isModificable());
		
		e5.setFechaIni(LocalDate.now()); //Su fecha de inicio ha llegado y no ha sido realizado por ningun alumno
		assertTrue(e5.isModificable());
		
		app.setUsuarioAct(al); //El alumno se identifica para poder comenzar un ejercicio
		asig.comenzarEjercicio(e5); //Comenzamos el ejercicio2 de forma que ya no sea modificable
		assertFalse(e5.isModificable());
	}
	
	@Test
	public void getNotaTotal() {
		assertTrue(e1.getNotaTotal() == 0); //Ejercicio sin preguntas
		e1.anyadirPregunta(p1); //Anyadimos 3 preguntas (cada una ponderando 20) a ej
		e1.anyadirPregunta(p2);
		e1.anyadirPregunta(p3);
		assertTrue(e1.getNotaTotal() == 60); //La nota total suma 60
		e1.eliminarPregunta(p1);
		e1.eliminarPregunta(p2);
		e1.eliminarPregunta(p3);
	}
	
	@Test
	public void testCalcularNotaMedia() {
		assertTrue(e1.getNotaMedia() == -1); //Ejercicio sin contestaciones
		
		app.setUsuarioAct(al); //El alumno se identifica para poder realizar los ejercicios
		asig.comenzarEjercicio(ejer1);
		EjercicioAlumno ejerAlum1 = al.getEjercicioAlumno().get(0);
		
		ejerAlum1.responderPregunta(p4.getOpcionNum(2), p4); //Acierta la pregunta 1 (p4) del ejercicio ejer1

		ejerAlum1.responderPregunta(new Opcion(0, "cuatro", true), p5); //Falla la segunda pregunta (p5) del ejercicio ejer1

		assert(ejer1.calcularNotaMedia() == 5);
		
	}


}
