package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import aplicacion.Aplicacion;
import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import aplicacion.recursos.ejercicios.TipoRespuesta;
import aplicacion.usuarios.Alumno;
import aplicacion.usuarios.Profesor;
import interfaces.SapereAude;
import interfaces.alumno.AEntrada;
import interfaces.alumno.Contestar;
import interfaces.profesor.PEntrada;

/**
 * Esta clase implementa el controlador asociado al panel de contestar ejercicios
 * @author Andres y Francisco
 */
public class CContestar implements ActionListener {
	/** Jpanel al que vamos a dar funcionalidad */
	private Contestar contestar;
	
	/** Instancia de la aplicacion */
	private Aplicacion app = null;
	
	/** Ejercicio a contestar */
	private Ejercicio ejercicio = null;
	
	/** Ejercicio alumno generado */
	private EjercicioAlumno ejerAlum = null;
	/**
	 * Constructor de la clase
	 * @param ae
	 */
	public CContestar(Contestar contestar, Ejercicio ejercicio) {
		this.contestar = contestar;
		this.ejercicio = ejercicio;
		try {
			app = Aplicacion.getInstance();
		} catch (IOException e) {
			System.out.println("Error al obtener la instancia de la aplicacion");
			e.printStackTrace();
		}
		
		try {
			ejerAlum = new EjercicioAlumno(ejercicio, LocalDate.now());
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		}
		
		if(app.getUsuarioAct() instanceof Alumno){
			contestar.getTableDatos().setValueAt(((Alumno)app.getUsuarioAct()).getNombre(), 0, 0);
			contestar.getTableDatos().setValueAt("Alumno", 0, 1);
		} else {
			contestar.getTableDatos().setValueAt("Profesorado", 0, 0);
			contestar.getTableDatos().setValueAt("Profesor", 0, 1);
		}
	}
	
	
	/**
	 * Funcion que es llamada cada vez que se interacciona con un componente
	 * seleccionable del panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Salir de la muestra de ejercicio
		if (e.getSource().equals(contestar.getDescartar())) {
			SwingUtilities.getWindowAncestor(contestar).setVisible(false);
			
			// Alumno
			if(app.getUsuarioAct() instanceof Alumno){
				AEntrada ae = new AEntrada();
				CAEntrada caentrada;
				try {
					caentrada = new CAEntrada(ae);
					SapereAude.getInstance().setContentPane(caentrada.getAEntrada());
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800,600);
				
					//Llamamos a los controladores necesarios del nuevo panel
					ae.setControladorSolicitar(caentrada);
					ae.setControladorAtras(caentrada);
					ae.setControladorAtras2(caentrada);
					ae.setControladorLDisp(caentrada);
					ae.setControladorAsignaturas(caentrada);
					ae.setControladorLogout(caentrada);
					ae.setControladorAbrir(caentrada);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {//Profe
				PEntrada pe = new PEntrada();
				CPEntrada cpentrada;
				try {
					cpentrada = new CPEntrada(pe);
					SapereAude.getInstance().setContentPane(CPEntrada.getPEntrada());
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800,600);
				
					//Llamamos a los controladores necesarios del nuevo panel
					pe.setControladorAtender(cpentrada);
					pe.setControladorCrear(cpentrada);
					pe.setControladorAtras(cpentrada);
					pe.setControladorGuardarAsignatura(cpentrada);
					pe.setControladorAtras2(cpentrada);
					pe.setControladorAceptar(cpentrada);
					pe.setControladorDenegar(cpentrada);
					pe.setControladorAsignaturas(cpentrada);
					pe.setControladorLogout(cpentrada);
					pe.setControladorAnyadir(cpentrada);
					pe.setControladorModificar(cpentrada);
					pe.setControladorEliminar(cpentrada);
					pe.setControladorVisibilidad(cpentrada);
					pe.setControladorAtras3(cpentrada);
					pe.setControladorAtras4(cpentrada);
					pe.setControladorListado(cpentrada);
					pe.setControladorExpulsar(cpentrada);
					pe.setControladorReadmitir(cpentrada);
					pe.setControladorAbrir(cpentrada);
					pe.setControladorNotas(cpentrada);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		//Enviar Ejercicio
		else if (e.getSource().equals(contestar.getEnviar())) {
			System.out.println("Enviar");
			//Logueado como profesor
			if (app.getUsuarioAct() instanceof Profesor) {
				
				PEntrada pe = new PEntrada();
				CPEntrada cpentrada;
				try {
					cpentrada = new CPEntrada(pe);
					SapereAude.getInstance().setContentPane(CPEntrada.getPEntrada());
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800,600);
				
					//Llamamos a los controladores necesarios del nuevo panel
					pe.setControladorAtender(cpentrada);
					pe.setControladorCrear(cpentrada);
					pe.setControladorAtras(cpentrada);
					pe.setControladorGuardarAsignatura(cpentrada);
					pe.setControladorAtras2(cpentrada);
					pe.setControladorAceptar(cpentrada);
					pe.setControladorDenegar(cpentrada);
					pe.setControladorAsignaturas(cpentrada);
					pe.setControladorLogout(cpentrada);
					pe.setControladorAnyadir(cpentrada);
					pe.setControladorModificar(cpentrada);
					pe.setControladorEliminar(cpentrada);
					pe.setControladorVisibilidad(cpentrada);
					pe.setControladorAtras3(cpentrada);
					pe.setControladorAtras4(cpentrada);
					pe.setControladorListado(cpentrada);
					pe.setControladorExpulsar(cpentrada);
					pe.setControladorReadmitir(cpentrada);
					pe.setControladorAbrir(cpentrada);
					pe.setControladorNotas(cpentrada);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			//Logueado como alumno
			else {
				int i = 0, cont = 0, cont1 = 0, cont2 = 0, cont3 = 0;
				for (Pregunta p: ejercicio.getPreguntas()) {
					boolean flag = false;
					System.out.println("Una pregunta " + i);
					//Respuesta multiple
					if (p.getTipoRespuesta().equals(TipoRespuesta.MULTIPLE)) {
						System.out.println("es multiple ");
						ArrayList<Opcion> opciones = new ArrayList<Opcion>();
						int k = 0;
						for (Opcion op: p.getOpciones()) {
							System.out.println(k + " (iter)");
							if (contestar.getMultiples().get(cont3).get(k).isSelected()) {
								opciones.add(op);
								System.out.println(op.getTexto());
								flag = true;
							}
							k++;
						}
						if (flag) {
							ejerAlum.responderPreguntaMultiple(opciones, p);
						}
						cont3++;
					}
					//Respuesta simple
					else if (p.getTipoRespuesta().equals(TipoRespuesta.SIMPLE)) {
						System.out.println("es simple");
						Opcion op;
						
						if (contestar.getSi().get(cont).isSelected()) {
							op = p.getOpciones().get(0);
							ejerAlum.responderPregunta(op, p);
						}
						else if (contestar.getNo().get(cont).isSelected()) {
							op = p.getOpciones().get(1);
							ejerAlum.responderPregunta(op, p);
						}
						else {
							System.out.println("No contestada");
						}
						cont++;
					}
					//Unica
					else if (p.getTipoRespuesta().equals(TipoRespuesta.UNICA)) {
						System.out.println("UNICAAAA");
						int j = 0;
						for (Opcion op: p.getOpciones()) {
							System.out.println(j + " (iter)");
							if (contestar.getUnicos().get(cont1).get(j).isSelected()) {
								ejerAlum.responderPregunta(op, p);
								System.out.println(op.getTexto());
								break;
							}
							j++;
						}
						cont1++;
					}
					//Abierta
					else {
						System.out.println("Abierta");
						for (Opcion op: p.getOpciones()) {
							if (op.getTexto().equals(contestar.getAbiertas().get(cont2).getText())) {
								ejerAlum.responderPregunta(op, p);
								System.out.println(op.getTexto());
								break;
							}
							else if (contestar.getAbiertas().get(cont2).getText().equals("")) {
								System.out.println("En blanco");
							} else {
								ejerAlum.responderPregunta(new Opcion(-1, "", true), p);
							}
						}
						cont2++;
					}
					i++;
				}
				ejercicio.getFechaFin().minusDays(5);
				AEntrada ae = new AEntrada();
				CAEntrada caentrada;
				try {
					caentrada = new CAEntrada(ae);
					SapereAude.getInstance().setContentPane(caentrada.getAEntrada());
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800,600);
				
					//Llamamos a los controladores necesarios del nuevo panel
					ae.setControladorSolicitar(caentrada);
					ae.setControladorAtras(caentrada);
					ae.setControladorAtras2(caentrada);
					ae.setControladorLDisp(caentrada);
					ae.setControladorAsignaturas(caentrada);
					ae.setControladorLogout(caentrada);
					ae.setControladorAbrir(caentrada);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}
			
		//Cierre sesion
		else if (e.getSource().equals(contestar.getLogout())) {
			System.out.println("Ciao");
			
			try {
				app.guardarDatos();
			} catch (IOException e1) {
				System.out.println("Error guardando el sistema");
				e1.printStackTrace();
			}

			SwingUtilities.getWindowAncestor(contestar).setVisible(false);
			System.exit(1);
		}
	}
	
	public Contestar getContestar() {
		return this.contestar;
	}
}