package tests.usuariosTests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import aplicacion.Asignatura;
import aplicacion.EstadoMatricula;
import aplicacion.Matricula;
import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.usuarios.Alumno;


public class AlumnoTest {

	private static Alumno a1;
	private static Alumno a2;
	private static Asignatura as1;
	private static Asignatura as2;
	private static Matricula m1;
	private static Matricula m12;
	private static Matricula m2;
	private static Ejercicio e1;
	private static EjercicioAlumno ea1;
	
	@BeforeClass
	public static void SetUp(){
		a1 = new Alumno("4511", "Pacma", "pac.vicent@aaduu.uam.es", "Paco", "Vicente");
		a2 = new Alumno("3636", "man23", "&res.salas@esdu.uam.es", "Andres", "Salas");
		as1 = new Asignatura("Padsoft", "programa en java");
		as2 = new Asignatura("Adsoft", "conceptos de java");
		m1 = new Matricula(a1,as1);
		m12 = new Matricula(a1,as2);
		m2 = new Matricula(a2,as1);
		e1 = new Ejercicio(true, "JUnit", LocalDate.now().minusDays(5), LocalDate.now().plusDays(5), 20.0, true, "tema difícil", 5.2, as1);
		ea1 = new EjercicioAlumno(e1, LocalDate.now());
	}
	
	@Test
	public void testAnyadirMatricula() {
		a1.anyadirMatricula(m1);
		assertTrue(a1.getMatriculas().contains(m1));
		assertFalse(a1.getMatriculas().contains(m12));
		
		a1.anyadirMatricula(m12);
		assertTrue(a1.getMatriculas().contains(m12));
		
		a2.anyadirMatricula(m1);
		assertFalse(a2.getMatriculas().contains(m1));
		assertFalse(a2.getMatriculas().contains(m2));
		assertFalse(a2.getMatriculas().contains(m12));
		assertFalse(a2.getMatriculas().contains(m1));
		
		a1.eliminarMatricula(m1);
		a1.eliminarMatricula(m12);
	}
	
	@Test
	public void testEliminarMatricula() {
		a1.anyadirMatricula(m1);
		a1.anyadirMatricula(m12);
		a2.anyadirMatricula(m2);
		a1.eliminarMatricula(m1);
		assertFalse(a1.getMatriculas().contains(m1));
		assertTrue(a1.getMatriculas().contains(m12));
		a1.eliminarMatricula(m12);
		a2.eliminarMatricula(m2);
	}
	
	@Test
	public void testAlumnoMatriculado() {
		a1.anyadirMatricula(m1);
		a2.anyadirMatricula(m1);
		assertTrue(a1.alumnoMatriculado(as1));
		assertFalse(a2.alumnoMatriculado(as1));
		a1.eliminarMatricula(m1);
	}
	
	@Test
	public void testAlumnoCursando(){
		a1.anyadirMatricula(m1);
		m1.setEstado(EstadoMatricula.CURSANDO);
		assertTrue(a1.alumnoCursando(as1));
		
		a2.anyadirMatricula(m2);
		assertFalse(a2.alumnoCursando(as1));
		
		a1.eliminarMatricula(m1);
		a2.eliminarMatricula(m2);
	}
	
	@Test
	public void testAnyadirEjercicioAlumno(){
		a1.anyadirEjercicioAlumno(ea1);
		assertTrue(a1.getEjercicioAlumno().contains(ea1));
		a1.eliminarEjercicioAlumno(ea1);
	}
	
	@Test
	public void testEliminarEjercicioAlumno(){
		a1.anyadirEjercicioAlumno(ea1);
		a1.eliminarEjercicioAlumno(ea1);
		assertFalse(a1.getEjercicioAlumno().contains(ea1));
	}
	
}