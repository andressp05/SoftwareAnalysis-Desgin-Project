package tests.recursosTests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import aplicacion.Asignatura;
import aplicacion.recursos.Apuntes;
import aplicacion.recursos.Tema;
import aplicacion.recursos.ejercicios.Ejercicio;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class TemaTest {

	private static Asignatura a1;
	private static Tema at1;
	private static Tema at2;
	private static Tema at21;
	private static Tema at211;
	private static Ejercicio ae2;
	private static Ejercicio ae1;
	private static Ejercicio ae211;
	private static Apuntes aa21;
	
	@BeforeClass
	public static void SetUp(){
		a1 = new Asignatura("Proyecto de Analisis y Disenyo de Software", "proyecto de Java");
		at1 = new Tema("Maquetas", a1);
		at2 = new Tema("Diagramas de Clases", a1);
		at21 = new Tema("Diagramas de Estado", a1);
		at211 = new Tema("Matriz de Trazabilidad", a1);
		ae2 = new Ejercicio(true, "JUnit", LocalDate.now().minusDays(5), LocalDate.now().plusDays(5), 20.0, true, "tema dificil", 5.2, a1);
		ae1 = new Ejercicio(true, "Whitebox", LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), 20.0, true, "pruebas de caja blanca", 2.0, a1);
		ae211 = new Ejercicio(true, "Blackbox", LocalDate.now().minusDays(10), LocalDate.now().plusDays(10), 20.0, true, "pruebas de caja negra", 4.5, a1);
		aa21 = new Apuntes("ejemplo", "ilustra el funcionamiento de los diagramas de estado", a1);
	}
	
	@Test
	public void testAnyadirRecurso() {
		at1.anyadirRecurso(ae1);
		assertTrue(at1.getRecursos().contains(ae1));
		
		at2.anyadirRecurso(at21);
		assertTrue(at2.getRecursos().contains(at21));
		at21.anyadirRecurso(aa21);
		assertTrue(at21.getRecursos().contains(aa21));
		
		at2.anyadirRecurso(ae2);
		assertTrue(at2.getRecursos().contains(ae2));
		assertFalse(at2.getRecursos().contains(ae1));
		

		at1.eliminarRecurso(ae1);
		at21.eliminarRecurso(aa21);
		at2.eliminarRecurso(at21);
		at2.eliminarRecurso(ae2);
	}
	
	@Test
	public void testEliminarRecurso() throws InvalidEmailAddressException, FailedInternetConnectionException {
		at1.anyadirRecurso(ae1);
		at1.eliminarRecurso(ae1);
		//assertTrue(at1.getRecursos().contains(ae1));
		ae1.setFechaFin(LocalDate.now().plusDays(2));
		at1.eliminarRecurso(ae1);
		assertFalse(at1.getRecursos().contains(ae1));
		
		
		at2.anyadirRecurso(at21);
		assertFalse(at1.getRecursos().contains(ae1));
		at2.eliminarRecurso(at21);
		assertFalse(at2.getRecursos().contains(at21));
		
		at2.anyadirRecurso(at21);
		at21.anyadirRecurso(aa21);
		at2.eliminarRecurso(at21);
		assertTrue(at2.getRecursos().contains(at21));
		at21.eliminarRecurso(aa21);
		at2.eliminarRecurso(at21);
		assertFalse(at2.getRecursos().contains(at21));
		
		at2.anyadirRecurso(ae2);
		at2.eliminarRecurso(ae2);
		assertFalse(at2.getRecursos().contains(ae2));
	}
	
	@Test
	public void testEjercicioPerteneceTema(){
		at2.anyadirRecurso(at21);
		at21.anyadirRecurso(at211);
		at211.anyadirRecurso(ae211);
		assertTrue(at2.ejercicioPerteneceTema(ae211));
		
		at1.anyadirRecurso(ae2);
		assertTrue(at1.ejercicioPerteneceTema(ae2));
		assertFalse(at1.ejercicioPerteneceTema(ae211));
		
		at2.eliminarRecurso(at21);
		at1.eliminarRecurso(ae2);
	}
	
	@After
	public void tearDownTestPonderacionParcialTema() throws InvalidEmailAddressException, FailedInternetConnectionException{
		at211.eliminarRecurso(ae211);
		at21.eliminarRecurso(at211);
		ae1.setFechaFin(LocalDate.now().plusDays(2));
		at21.eliminarRecurso(ae1);
		ae1.setFechaFin(LocalDate.now().minusDays(2));
		at2.eliminarRecurso(at21);
		at1.eliminarRecurso(aa21);
	}
	
	@Test
	public void testPonderacionParcialTema(){
		at1.anyadirRecurso(aa21);
		assertTrue(at1.ponderacionParcialTema() == 0);
		
		at2.anyadirRecurso(at21);
		at21.anyadirRecurso(at211);
		at21.anyadirRecurso(ae1);
		at211.anyadirRecurso(ae211);
		assertTrue(at2.ponderacionParcialTema() == 40);
		assertTrue(at21.ponderacionParcialTema() == 40);
		assertTrue(at211.ponderacionParcialTema() == 20);
	}
	
}