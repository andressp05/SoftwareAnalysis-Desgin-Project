package tests.estadisticasTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import aplicacion.estadisticas.PreguntaAlumno;
import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import aplicacion.recursos.ejercicios.TipoRespuesta;

public class PreguntaAlumnoTest {

	private static Opcion p1o1;
	private static Opcion p1o3;
	private static Opcion p3o1;
	private static Opcion p3o2;
	private static Opcion p3o3;
	private static Opcion p4o1;
	private static Opcion p4o2;
	private static Pregunta p1;
	private static Pregunta p2;
	private static Pregunta p3;
	private static Pregunta p4;
	private static PreguntaAlumno pa1a;
	private static PreguntaAlumno pa1b;
	private static PreguntaAlumno pa2a;
	private static PreguntaAlumno pa2b;
	private static PreguntaAlumno pa3a;
	private static PreguntaAlumno pa3b;
	private static PreguntaAlumno pa3c;
	private static PreguntaAlumno pa4a;
	private static PreguntaAlumno pa4b;
	private static PreguntaAlumno pa4c;
	private static ArrayList<Opcion> opcionesa;
	private static ArrayList<Opcion> opcionesb;
	private static ArrayList<Opcion> opcionesc;
	
	
	
	
	@BeforeClass
	public static void SetUp(){
		p1o1 = new Opcion(1, "2", false);
		p1o3 = new Opcion(3, "5", true);
		p1 = new Pregunta(1,20.0,"Cuanto es 2+3?", false, 5.0, TipoRespuesta.UNICA);
		p1.anyadirOpcion("2", false);
		p1.anyadirOpcion("4", false);
		p1.anyadirOpcion("5", true);
		p1.anyadirOpcion("6", false);
		pa1a = new PreguntaAlumno(p1o1, p1);
		pa1b = new PreguntaAlumno(p1o3, p1);
		
		p2 = new Pregunta(2,20.0,"El rio Guadalquivir pasa por Sevilla", false, 5.0, TipoRespuesta.SIMPLE);
		p2.anyadirOpcionSimple(true);
		pa2a = new PreguntaAlumno(p2.getOpcionNum(1),p2);
		pa2b = new PreguntaAlumno(p2.getOpcionNum(2), p2);
		
		p3o1 = new Opcion(1,"Cadmio", true);
		p3o2 = new Opcion(2,"Pacquio", false);
		p3o3 = new Opcion(3,"Rubidio", true);
		p3 = new Pregunta(3,20.0,"Elementos de la tabla periodica", false, 10.0, TipoRespuesta.MULTIPLE);
		p3.anyadirOpcion("Cadmio", true);
		p3.anyadirOpcion("Pacquio",false);
		p3.anyadirOpcion("Rubidio",true);
		p3.anyadirOpcion("Eustaquio",false);
		opcionesa = new ArrayList<>();
		opcionesb = new ArrayList<>();
		opcionesc = new ArrayList<>();
		
		opcionesa.add(p3o1);
		opcionesa.add(p3o2);
		opcionesa.add(p3o3);
		
		opcionesb.add(p3o3);
		opcionesb.add(p3o1);
		
		opcionesc.add(p3o3);
		
		pa3a = new PreguntaAlumno(opcionesa, p3);
		pa3b = new PreguntaAlumno(opcionesb, p3);
		pa3c = new PreguntaAlumno(opcionesc, p3);
		
		p4o1 = new Opcion(4, "colon", true);
		p4o2 = new Opcion(2, "Nunyez de Balboa", true);
		p4 = new Pregunta(4, 20.0, "Quien descubrio America?", false, 2.0, TipoRespuesta.ABIERTA);
		p4.anyadirOpcion("Cristobal Colon", true);
		p4.anyadirOpcion("Colon", true);
		p4.anyadirOpcion("cristobal colon", true);
		p4.anyadirOpcion("colon", true);
		
		pa4a = new PreguntaAlumno(p4o1, p4);
		pa4b = new PreguntaAlumno(p4o2, p4);
		pa4c = new PreguntaAlumno(p4);		
	}
	
	@Test
	public void testEsCorrecta() {
		assertFalse(pa1a.esCorrecta());//Respuesta Incorrecta Unica
		assertTrue(pa1b.esCorrecta());//Respuesta Correcta Unica
		assertTrue(pa2a.esCorrecta());//Respuesta Correcta Simple
		assertFalse(pa2b.esCorrecta());//Respuesta Incorrecta Falsa
		assertFalse(pa3a.esCorrecta());//Respuesta Incorrecta Multiple Sobran
		assertTrue(pa3b.esCorrecta());//Respuesta Correcta Multiple
		assertFalse(pa3c.esCorrecta());//Respuesta Incorrecta Multiple Faltan
		assertTrue(pa4a.esCorrecta());//Respuesta Correcta Abierta
		assertFalse(pa4b.esCorrecta());//Respuesta Incorrecta Abierta
	}
	
	@Test
	public void testObtenerNota(){
		assertTrue(pa4a.obtenerNota() == 20); //Correcta
		assertTrue(pa4b.obtenerNota() == (-2)); //Erronea
		assertTrue(pa4c.obtenerNota() == 0); //En blanco
	}
}
