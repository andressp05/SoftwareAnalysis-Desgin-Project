package tests.recursosTests.ejerciciosTests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import aplicacion.recursos.ejercicios.TipoRespuesta;

public class PreguntaTest {

	private static Pregunta p1;
	private static Pregunta p2;
	private static Pregunta p3;
	private static Pregunta p4;
	private static Pregunta p5;
	private static Pregunta p6;
	private static Pregunta p7;
	private static Opcion p5a;
	private static Opcion p6a;
	private static Opcion p6b;
	private static Opcion p7a;
	private static Opcion p7b;
	
	
	@BeforeClass
	public static void SetUp(){
		p1 = new Pregunta(1,20.0,"¿Cuánto es 2+3?", false, 5.0, TipoRespuesta.UNICA);
		p2 = new Pregunta(2,20.0,"El río Guadalquivir pasa por Sevilla", false, 0.0, TipoRespuesta.SIMPLE);
		p3 = new Pregunta(3,20.0,"Elementos de la tabla periódica", false, 10.0, TipoRespuesta.MULTIPLE);
		p4 = new Pregunta(4,20.0,"___ descubrió América en 1492", false, 5.0, TipoRespuesta.ABIERTA);
		p5 = new Pregunta(5,20.0,"¿Cuánto es 2*3?", false, 5.0, TipoRespuesta.UNICA);
		p6 = new Pregunta(6,20.0,"Señala los requisitos funcionales", false, 5.0, TipoRespuesta.MULTIPLE);
		p7 = new Pregunta(7,20.0,"¿Cuánto es 3-2?", false, 5.0, TipoRespuesta.UNICA);
		p5a = new Opcion(1,"2", false);
		p6a = new Opcion(1, "Mantenibilidad", true);
		p6b = new Opcion(2, "Portabilidad", true);
		p7a = new Opcion(1,"2", false);
		p7b = new Opcion(2,"1", true);

	}
	
	@Test
	public void testAnyadirOpcion() {
		//RespuestaSimple
		assertTrue(p1.anyadirOpcion("2", false)); 
		assertTrue(p1.anyadirOpcion("4", false));
		assertTrue(p1.anyadirOpcion("5", true));
		assertFalse(p1.anyadirOpcion("cinco", true));//No dos trues
		assertTrue(p1.anyadirOpcion("6", false));
		assertFalse(p1.anyadirOpcion("93", false));//No más de cuatro
		
		assertFalse(p2.anyadirOpcion("Si",false)); //Error hay otro metodo para simples
		
		assertTrue(p3.anyadirOpcion("Cadmio", true));
		assertTrue(p3.anyadirOpcion("Pacquio", false));
		assertTrue(p3.anyadirOpcion("Rubidio", true));
		assertTrue(p3.anyadirOpcion("Eustaquio", false));
		assertFalse(p3.anyadirOpcion("Helio", true)); //No más de cuatro
		
		assertTrue(p4.anyadirOpcion("Cristobal Colon", true));
		assertFalse(p4.anyadirOpcion("Cristobal Colon", false)); //Error no false en abierta
		assertTrue(p4.anyadirOpcion("Colon", true));
		assertTrue(p4.anyadirOpcion("Cristobal", true));		
	}
	
	@Test
	public void testAnyadirOpcionSimple() {
		assertTrue(p2.anyadirOpcionSimple(true));
		assertFalse(p2.anyadirOpcionSimple(false));
	}
	
	@Before
	public void SetUpGetOpcionNum() {
		p5.anyadirOpcion("2", false);
		p5.anyadirOpcion("4", false);
		p5.anyadirOpcion("6", true);
	}
	@Test
	public void testGetOpcionNum() {
		assertSame(p5.getOpcionNum(1).getNumero(),p5a.getNumero());
		assertSame(p5.getOpcionNum(1).getTexto(),p5a.getTexto());
		assertSame(p5.getOpcionNum(1).getCorreccion(),p5a.getCorreccion());
	}
	
	@Before
	public void SetUpGetOpcionCorrecta() {
		p7.anyadirOpcion("2", false);
		p7.anyadirOpcion("1", true);
	}
	
	@Test
	public void testGetOpcionCorrecta() {
		assertEquals(p7.getOpcionCorrecta(),p7b);
		assertNotSame(p7.getOpcionCorrecta(),p7a);
	}
	
	@Before
	public void SetUpGetOpcionesCorrectas(){
		p6.anyadirOpcion("Mantenibilidad", true);
		p6.anyadirOpcion("Portabilidad", true);
		p6.anyadirOpcion("Cascada", false);
	}
	
	@Test
	public void testGetOpcionesCorrectas() {
		assertTrue(p6.getOpcionesCorrecta().contains(p6a));
		assertTrue(p6.getOpcionesCorrecta().contains(p6b));
	}

}