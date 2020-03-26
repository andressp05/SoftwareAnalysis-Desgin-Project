package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import aplicacion.Aplicacion;
import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.recursos.Recurso;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.usuarios.Alumno;
import interfaces.SapereAude;
import interfaces.alumno.AEntrada;
import interfaces.alumno.Contestar;
import interfaces.alumno.EntradaEjercicio;
import interfaces.alumno.Feedback;
import interfaces.profesor.PEntrada;

/**
 * Esta clase implementa el controlador asociado al panel de entrada a un ejercicio
 * @author Andres y Francisco
 */
public class CEntradaEjercicio implements ActionListener {
	/** Jpanel al que vamos a dar funcionalidad */
	private EntradaEjercicio ee;
	
	/** Instancia de la aplicacion */
	private Aplicacion app = null;
	
	/** Ejercicio a realizar */
	private Ejercicio ejercicio = null;
	/**
	 * Constructor de la clase
	 * @param e
	 * @param ejercicio
	 */
	public CEntradaEjercicio(EntradaEjercicio ee, Recurso ejercicio) {
		String str;
		this.ee = ee;
		this.ejercicio = (Ejercicio) ejercicio;
		try {
			app = Aplicacion.getInstance();
		} catch (IOException e) {
			System.out.println("Error al obtener la instancia de la aplicacion");
			e.printStackTrace();
		}
		
		if(app.getUsuarioAct() instanceof Alumno){
			ee.getTableDatos().setValueAt(((Alumno)app.getUsuarioAct()).getNombre(), 0, 0);
			ee.getTableDatos().setValueAt("Alumno", 0, 1);
		} else {
			ee.getTableDatos().setValueAt("Profesorado", 0, 0);
			ee.getTableDatos().setValueAt("Profesor", 0, 1);
		}
		
		if (this.ejercicio.fechaEnRango(LocalDate.now())) {
			str = "activo";
		} else {
			str = "cerrado";
		}
		ee.getEstado().setText("Estado: " + str);
		ee.getContenido().setText(this.ejercicio.getComentarios() + "\n\nFecha de inicio: " + this.ejercicio.getFechaIni() + "\nFecha de cierre: " + this.ejercicio.getFechaFin() );
	}
	
	
	/**
	 * Funcion que es llamada cada vez que se interacciona con un componente
	 * seleccionable del panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Salir de la muestra de ejercicio
		if (e.getSource().equals(ee.getSalir())) {
			SwingUtilities.getWindowAncestor(ee).setVisible(false);
			
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
		
		//Comenzar Ejercicio
		else if (e.getSource().equals(ee.getComenzar())) {
			if (app.getUsuarioAct() instanceof Alumno) {//Alumno
				if (ejercicio.fechaEnRango(LocalDate.now()) && ejercicio.isContestado() == false) {
					Contestar contestar = new Contestar(ejercicio);
					CContestar ccontestar = new CContestar(contestar, ejercicio); 
				
					SwingUtilities.getWindowAncestor(ee).setVisible(false);
				
					SapereAude.getInstance().setContentPane(contestar);
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800, 600);
			
					//Controladores
					contestar.setControladorDescartar(ccontestar);
					contestar.setControladorEnviar(ccontestar);
					contestar.setControladorLogout(ccontestar);
				}
				else if (ejercicio.getFechaFin().isBefore(LocalDate.now())) {
					EjercicioAlumno ea = ((Alumno)app.getUsuarioAct()).getEjercicioAlumnoPorEjercicio(ejercicio);
					if (ea == null) {
						System.out.println("Error buscando el ejercicio alumno");
					}
					Feedback feedback = new Feedback(ea);
					CFeedback cfeedback = new CFeedback(feedback, ea); 
				
					SwingUtilities.getWindowAncestor(ee).setVisible(false);
				
					SapereAude.getInstance().setContentPane(feedback);
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800, 600);
			
					//Controladores
					feedback.setControladorSalir(cfeedback);
					feedback.setControladorLogout(cfeedback);
				} else {
					JOptionPane.showMessageDialog(null, "No puedes realizar el ejercicio ni comprobar tus resultados debido a la fecha actual o porque ya lo has realizado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {//Profesor accede siempre
				Contestar contestar = new Contestar(ejercicio);
				CContestar ccontestar = new CContestar(contestar, ejercicio); 
			
				SwingUtilities.getWindowAncestor(ee).setVisible(false);
			
				SapereAude.getInstance().setContentPane(contestar);
				SapereAude.getInstance().setVisible(true);
				SapereAude.getInstance().setSize(800, 600);
		
				//Controladores
				contestar.setControladorDescartar(ccontestar);
				contestar.setControladorEnviar(ccontestar);
				contestar.setControladorLogout(ccontestar);
			}
			
		}
		//Cierre sesion
		else if (e.getSource().equals(ee.getLogout())) {
			try {
				app.guardarDatos();
			} catch (IOException e1) {
				System.out.println("Error guardando el sistema");
				e1.printStackTrace();
			}

			SwingUtilities.getWindowAncestor(ee).setVisible(false);
			System.exit(1);
		}
	}
	
	public EntradaEjercicio getEntradaEjercicio() {
		return this.ee;
	}
}
