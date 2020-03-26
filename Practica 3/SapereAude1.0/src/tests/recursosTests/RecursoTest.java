package tests.recursosTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import aplicacion.Asignatura;
import aplicacion.recursos.Tema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class RecursoTest {

	private static Asignatura a;
	private static Tema t1;
	
	@BeforeClass
	public static void SetUp(){
		a = new Asignatura("Fisica", "temario de bachillerato");
		t1 = new Tema("Maquetas", a);
	}
	
	@Test
	public void testOcultar() throws InvalidEmailAddressException, FailedInternetConnectionException {
		t1.ocultar();
		assertFalse(t1.isVisible());
	}
	
	@Test
	public void testRevelar() throws InvalidEmailAddressException, FailedInternetConnectionException {
		t1.revelar();
		assertTrue(t1.isVisible());
	}
	
}


