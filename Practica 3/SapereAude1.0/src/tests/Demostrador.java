package tests;

import java.io.IOException;
import java.time.LocalDate;

import aplicacion.*;
import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.estadisticas.PreguntaAlumno;
import aplicacion.recursos.Apuntes;
import aplicacion.recursos.Tema;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import aplicacion.recursos.ejercicios.TipoRespuesta;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class Demostrador {
	
	public static void main(String[] args) throws IOException, InvalidEmailAddressException, FailedInternetConnectionException, ClassNotFoundException {
		Aplicacion app = Aplicacion.getInstance();  //Creacion de la aplicacion
		Asignatura asig1 = new Asignatura("Dibujo", "pinta y colorea");  //Cracion de una asignaura
		Tema tema1 = new Tema("tema1", asig1);  //Creacion de un tema
		Tema tema2 = new Tema("tema2", asig1);  //Creacion de otro tema
		Tema tema2_1 = new Tema("tema2.1", asig1);  //Creacion de un subtema de tema2
		Ejercicio ejercicio1 = new Ejercicio("ejercicio1", LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), 30.0, false, "Las preguntas restan", 1.0, asig1);
		Ejercicio ejercicio2 = new Ejercicio("ejercicio2", LocalDate.now(), LocalDate.now().plusDays(2), 30.0, false, "Las preguntas restan", 1.0, asig1);
		Ejercicio ejercicio3 = new Ejercicio("ejercicio3", LocalDate.now(), LocalDate.now().plusDays(5), 30.0, false, "Las preguntas restan", 1.0, asig1);
		Pregunta pregunta1 = new Pregunta(1, 10, "Cuanto es 2 + 3?", false, 0, TipoRespuesta.UNICA);
		Pregunta pregunta2 = new Pregunta(2, 20, "Para cuales de los siguientes valores de x se cumple |x| < 5?", false, 0, TipoRespuesta.MULTIPLE);
		Pregunta pregunta3 = new Pregunta(1, 50, "El teorema de Stokes concierne a la geometria diferencial.", false, 25, TipoRespuesta.SIMPLE);
		Pregunta pregunta4 = new Pregunta(2, 50, "Un tipo de requisito no funcional es...", false, 0, TipoRespuesta.ABIERTA);
		
		Apuntes apuntes1 = new Apuntes("apuntes1", true, "El teorema de Fermat no es mas que un caso particular del de Euler", asig1);
		Apuntes apuntes2 = new Apuntes("apuntes2", true, "America fue descubierta en 1492", asig1);
		
		app.cargarUsuarios("fichero.txt");
		app.anyadirAsignatura(asig1); //Adicion de una asignatura
		
		app.identificarse("0000", "1234");
		app.solicitarInscripcion(asig1); //Un profesor no puede realizar esta accion
		
		app.identificarse("1297", "Coero"); //Nos identificamos como Ana
		app.solicitarInscripcion(asig1);    //Solicitamos la inscripcion en asig1
		app.atenderInscripcion(asig1.getAlumnado().get(0), true); //Un alumno no puede realizar esta accion
		//Se debe haber mandado un correo informativo a la direccion de Ana
		
		app.identificarse("0000", "1234"); //Nos identificamos como profesor
		app.atenderInscripcion(asig1.getAlumnado().get(0), true); //Aceptamos a ana
		asig1.expulsar(asig1.getAlumnado().get(0).getAlumno()); //La expulsamos
		asig1.readmitir(asig1.getAlumnado().get(0).getAlumno()); //La readmitimos
		
		app.identificarse("1258", "anuel.Bl"); 
		app.solicitarInscripcion(asig1); //Manuel solicita la inscripciona asig1
		
		app.identificarse("1289", "JoA");
		app.solicitarInscripcion(asig1); //Jorge solicita la inscripciona asig1
		
		app.identificarse("2514", "rme.Mora"); // solicita la inscripciona asig1
		app.solicitarInscripcion(asig1);
		
		app.identificarse("0000", "1234");
		app.atenderInscripcion(asig1.getAlumnado().get(1), true); //MANUEL aceptado
		asig1.expulsar(asig1.getAlumnado().get(1).getAlumno()); //MAnuel expulsado
		app.atenderInscripcion(asig1.getAlumnado().get(2), false); //Jorge rechazado
		app.atenderInscripcion(asig1.getAlumnado().get(2), true); //Carmen aceptada
		asig1.expulsar(asig1.getAlumnado().get(2).getAlumno()); //Carmen expulsada
		asig1.readmitir(asig1.getAlumnado().get(2).getAlumno());
		
		
		asig1.anyadirTema(tema1); //Adicion de un tema a asig1
		asig1.anyadirTema(tema2); //Adicion de otro tema a asig1
		asig1.eliminarTema(tema1); //Eliminacion del primer tema de asig1

		System.out.println(app);
		System.out.println(asig1);
		
		tema2.anyadirRecurso(apuntes1); //anyadimos apuntes1 a tema2
		tema2.anyadirRecurso(tema2_1); //anyadimos el subtema tema2_1 a tema2
		
		tema2_1.anyadirRecurso(apuntes2); //anyadimos apuntes2 al subtema tema2_1
		tema2.anyadirRecurso(ejercicio1); //anyadimos ejercicio1 a tema2
		tema2_1.anyadirRecurso(ejercicio2); //anyadimos ejercicio2 al subtema tema2_1
		
		System.out.println(tema2);
		System.out.println(tema2_1);
		
		ejercicio1.anyadirPregunta(pregunta1); //Anyadimos la primera pregunta de ejercicio1
		pregunta1.anyadirOpcion("2", false);  //Distintas opciones posibles
		pregunta1.anyadirOpcion("3", false);
		pregunta1.anyadirOpcion("4", false);
		pregunta1.anyadirOpcion("5", true);
		pregunta1.anyadirOpcion("1", false);
		
		ejercicio1.anyadirPregunta(pregunta2); //Anyadimos la segunda pregunta de ejercicio1
		pregunta2.anyadirOpcion("2", true);  //Distintas opciones posibles
		pregunta2.anyadirOpcion("-3", true);
		pregunta2.anyadirOpcion("-1", true);
		pregunta2.anyadirOpcion("7", false);
		pregunta2.anyadirOpcion("-9", false);
		
		ejercicio2.anyadirPregunta(pregunta3); //Anyadimos la primera pregunta de ejercicio2
		pregunta3.anyadirOpcionSimple(true); //Unico formato de opciones posible
		
		ejercicio2.anyadirPregunta(pregunta4); //Anyadimos la segunda pregunta de ejercicio2
		pregunta4.anyadirOpcion("seguridad", true);  //Distintas opciones validas
		pregunta4.anyadirOpcion("rendimiento", true);
		pregunta4.anyadirOpcion("eficiencia", true);
		pregunta4.anyadirOpcion("mantenibilidad", true);
		
		ejercicio3.anyadirPregunta(pregunta3); //Anyadimos la primera pregunta de ejercicio2
		ejercicio3.anyadirPregunta(pregunta4); //Anyadimos la segunda pregunta de ejercicio2
		
		tema2.eliminarRecurso(tema2_1); //No se puede porque tema2 tiene recursos dentro
		
		tema2_1.eliminarRecurso(apuntes2);  //eliminarmos los recursos contenidos en tema2
		tema2_1.eliminarRecurso(ejercicio2);
		
		tema2.eliminarRecurso(ejercicio1); //No se puede porque ya ha finalizado
		
		tema2.eliminarRecurso(tema2_1); //Ahora si se elimina el subtema tema2_1
		
		System.out.println(tema2);
		System.out.println(tema2_1);
		
		app.identificarse("1297", "Coero"); //Nos identificamos como Ana
		tema2.anyadirRecurso(tema2_1); //volvemos a anyadir el subtema tema2_1 con el ejercicio3
		tema2_1.anyadirRecurso(ejercicio3);
		
		System.out.println(tema2);
		System.out.println(tema2_1);
		
		if (asig1.comenzarEjercicio(ejercicio3)) { //Ana empieza el ejercicio3
			EjercicioAlumno ejerAlum = app.getAlumnos().get(2).getEjercicioAlumno().get(0);
		
			ejerAlum.responderPregunta(pregunta3.getOpcionNum(1), pregunta3); //Ana escoge la opcion 1 (si) de la pregunta3
			ejerAlum.responderPregunta(new Opcion(0, "rendimiento", true), pregunta4); //Ana responde "rendimiento" a la pregunta 4
		
			for (PreguntaAlumno pregAlum : ejerAlum.getPreguntasAlumno()) {
				if (pregAlum.esCorrecta()) {
					System.out.println("Pregunta " + pregAlum.getPreguntaOriginal().getNumero() + " correcta");
				}
				else {
					System.out.println("Pregunta " + pregAlum.getPreguntaOriginal().getNumero() + " incorrecta");
				}
			}
			
			System.out.println("Nota: " + ejerAlum.getNota()); //Calculamos la nota que ha obtenido
			
		}
		app.identificarse("1258", "anuel.Bl");
		asig1.comenzarEjercicio(ejercicio3); //Manuel empieza el ejercicio3 pero falla porque no esta matriculado en la asignatura
		
		app.identificarse("2514", "rme.Mora");
		if (asig1.comenzarEjercicio(ejercicio3)) {
			EjercicioAlumno ejerAlum2 = app.getAlumnos().get(5).getEjercicioAlumno().get(0);
			
			ejerAlum2.responderPregunta(null, pregunta3); //Carmen no escoge opcion alguna de la pregunta3
										
			ejerAlum2.responderPregunta(new Opcion(0, "no lo se", true), pregunta4); //Carmen responde "no lo se" a la pregunta 4
										
			for (PreguntaAlumno pregAlum2 : ejerAlum2.getPreguntasAlumno()) {
				if (pregAlum2.esCorrecta()) {
					System.out.println("Pregunta " + pregAlum2.getPreguntaOriginal().getNumero() + " correcta");
				}
				else {
					System.out.println("Pregunta " + pregAlum2.getPreguntaOriginal().getNumero() + " incorrecta");
				}
			}
			System.out.println("Nota: " + ejerAlum2.getNota()); //Calculamos la nota que ha obtenido
		}
		
		app.cerrarSesion(); //Cerramos sesion guardando los recursos de la aplicacion
		app = Aplicacion.cargarDatos(); //Cargamos los datos almacenados de la aplicacion
		
		//Obtenemos la nota media de Carmen en la asignatura asig1
		asig1 = app.getAsignaturas().get(0); //Debemos acceder a los recursos desde la instacncia de aplicacion a partir de ahora debido a la carga realizada
		tema2_1 = (Tema) app.getAsignaturas().get(0).getTemas().get(0).getRecursos().get(2);
		ejercicio3 = (Ejercicio) tema2_1.getRecursos().get(0);
		System.out.println("Media de Carmen en asig1: " + app.getAlumnos().get(5).getMatriculaAsignatura(asig1).getNotaMedia());
		System.out.println("Media de Ana en asig1: " + app.getAlumnos().get(2).getMatriculaAsignatura(asig1).getNotaMedia());

		//Obtenemos la nota media de todos los alumno que han realizado el ejercicio3
		System.out.println("Media ejercicio3: " + ejercicio3.getNotaMedia());
		
		System.out.println("Ejercicio3: aciertos[" + ejercicio3.getpAciertos() + "] fallos[" + ejercicio3.getpFallos() + "] enBlanco[" + ejercicio3.getpBlancos() + "]");
		
		app.cerrarSesion();
	}
	
	
	

}
