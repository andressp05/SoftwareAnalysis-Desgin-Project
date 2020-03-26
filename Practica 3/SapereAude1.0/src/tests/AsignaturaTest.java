package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import aplicacion.Aplicacion;
import aplicacion.Asignatura;
import aplicacion.Matricula;
import aplicacion.recursos.Tema;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.usuarios.Alumno;
import aplicacion.usuarios.Profesor;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class AsignaturaTest {

	private static Asignatura a1;
	private static Asignatura a2;
	private static Matricula m1;
	private static Matricula m2;
	private static Alumno al1;
	private static Alumno al2;
	private static Profesor p1;
	private static Tema t1;
	private static Tema t2;
	private static Tema t3;
	private static Tema t4;
	private static Tema t21;
	private static Ejercicio e1;
	private static Ejercicio e2;
	
	
	@BeforeClass
	public static void SetUp() {
		a1 = new Asignatura("Padsof", "Proyecto de Analisis y Disenyo de Software");
		a2 = new Asignatura("Adsof", "Analisis y Disenyo de Software");
		t1 = new Tema("Captura de Requisitos",a1);
		t2 = new Tema("Diagrama de Clases", a1);
		t3 = new Tema("Codificacion", a1);
		t4 = new Tema("Interfaz", a1);	
		t21 = new Tema("Matriz de Trazabilidad", a1);
		e1 = new Ejercicio(true, "JUnit", LocalDate.now().minusDays(5), LocalDate.now().plusDays(5), 20.0, true, "tema dificil", 5.2, a1);
		e2 = new Ejercicio(true, "Whitebox", LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), 20.0, true, "pruebas de caja blanca", 2.0, a1);
		al1 = new Alumno("3636", "perry2", "yo.sinapellidos@uam.es", "Emilina", "Costo");
		al2 = new Alumno("666", "elClubdelHerrete", "tu.conapellidos@uam.es", "Yudrigo", "Hongpool");
		p1 = new Profesor("3333","a2de", "soy.profe@uam.es");
		m1 = new Matricula(al1, a1);
		m2 = new Matricula(al2, a1);
	}
	
	@Test
	public void testAnyadirTema() {
		a1.anyadirTema(t1);
		assertTrue(a1.getTemas().contains(t1));
		a1.anyadirTema(t3);
		assertTrue(a1.getTemas().contains(t3));
		
		a1.eliminarTema(t1);
		assertTrue(a1.eliminarTema(t3));
		assertFalse(a1.getTemas().contains(t3));
	}

	@Test
	public void testEliminarTema() {
		a1.anyadirTema(t3);
		a1.anyadirTema(t4);
		t4.anyadirRecurso(t21);
		
		assertTrue(a1.eliminarTema(t3));
		assertFalse(a1.getTemas().contains(t3));
		a1.eliminarTema(t4);
		assertTrue(a1.getTemas().contains(t4));
		t4.eliminarRecurso(t21);
		a1.eliminarTema(t4);
		assertFalse(a1.getTemas().contains(t4));	
	}
	
	@Test
	public void testAnyadirAlumno(){
		a1.anyadirAlumno(m1);
		assertTrue(a1.getAlumnado().contains(m1));
		assertFalse(a1.getAlumnado().contains(m2));
		a2.anyadirAlumno(m1);
		assertFalse(a2.getAlumnado().contains(m1));
		a1.anyadirAlumno(m2);
		assertTrue(a1.getAlumnado().contains(m2));
		
		a1.eliminarAlumno(m1);
		a1.eliminarAlumno(m2);
	}
	
	@Test
	public void testEliminarAlumno(){
		a1.anyadirAlumno(m1);
		a1.anyadirAlumno(m2);
		
		a1.eliminarAlumno(m1);
		assertFalse(a1.getAlumnado().contains(m1));
		assertTrue(a1.getAlumnado().contains(m2));
		a1.eliminarAlumno(m2);
		assertFalse(a1.getAlumnado().contains(m2));
	}
	
	@Test
	public void testExpulsar() throws InvalidEmailAddressException, FailedInternetConnectionException{
		a1.anyadirAlumno(m2);
		al2.anyadirMatricula(m2);
		Aplicacion.getInstance().setUsuarioAct(al1);//Alumno trata de expulsar
		Aplicacion.getInstance().atenderInscripcion(m2, true);
		assertFalse(a1.expulsar(m2.getAlumno()));
		
		Aplicacion.getInstance().setUsuarioAct(p1);//Profe expulsa
		Aplicacion.getInstance().atenderInscripcion(m2, true);
		assertTrue(a1.expulsar(m2.getAlumno()));
		
		Aplicacion.getInstance().setUsuarioAct(p1);//Profe expulsa mal alumno pendiente
		Aplicacion.getInstance().atenderInscripcion(m2, false);
		assertFalse(a1.expulsar(m2.getAlumno()));
		
		a1.eliminarAlumno(m2);
		al2.eliminarMatricula(m2);
	}
	
	@Test
	public void testReadmitir() throws InvalidEmailAddressException, FailedInternetConnectionException{
		a1.anyadirAlumno(m2);
		al2.anyadirMatricula(m2);
		Aplicacion.getInstance().setUsuarioAct(p1);
		Aplicacion.getInstance().atenderInscripcion(m2, true);
		assertFalse(a1.readmitir(m2.getAlumno()));//Estado Cursando
		assertTrue(a1.expulsar(m2.getAlumno()));
		
		Aplicacion.getInstance().setUsuarioAct(al1);//Alumno readmite
		assertFalse(a1.readmitir(m2.getAlumno()));
		
		Aplicacion.getInstance().setUsuarioAct(p1);//Profe readmite
		assertTrue(a1.readmitir(m2.getAlumno()));
		
		Aplicacion.getInstance().atenderInscripcion(m2, false);
		assertFalse(a1.expulsar(m2.getAlumno()));
		
		al2.eliminarMatricula(m2);
		a1.eliminarAlumno(m2);
	}
	
	@Test
	public void testEjercicioPerteneceAsignatura(){
		a1.anyadirTema(t1);
		a1.anyadirTema(t2);
		t1.anyadirRecurso(e1);
		assertTrue(a1.ejercicioPerteneceAsignatura(e1));
		assertFalse(a1.ejercicioPerteneceAsignatura(e2));
		
		t2.anyadirRecurso(t21);
		t21.anyadirRecurso(e2);
		assertTrue(a1.ejercicioPerteneceAsignatura(e2));	
	}
	
	@After
	public void TearDowntestEjercicioPerteneceAsignatura(){
		t21.eliminarRecurso(e2);
		t2.eliminarRecurso(t21);
		a1.eliminarTema(t2);
		a1.eliminarTema(t1);
	}
	
	@Test
	public void testPonderacionTotal(){
		a1.anyadirTema(t1);
		t1.anyadirRecurso(e1);
		a1.anyadirTema(t2);
		t2.anyadirRecurso(t21);
		t21.anyadirRecurso(e2);
		
		assertEquals(4f,a1.ponderacionTotal(), 40);
		t1.eliminarRecurso(e1);
		assertEquals(4f,a1.ponderacionTotal(), 20);
		
	}
	
	@After
	public void TearDowntestPonderacionTotal() throws InvalidEmailAddressException, FailedInternetConnectionException{
		e2.setFechaFin(LocalDate.now().plusDays(2));
		t21.eliminarRecurso(e2);
		t2.eliminarRecurso(t21);
		a1.eliminarTema(t2);
		a1.eliminarTema(t1);
	}
	
	
}
