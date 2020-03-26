package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingUtilities;

import aplicacion.Aplicacion;
import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.usuarios.Alumno;
import interfaces.SapereAude;
import interfaces.alumno.AEntrada;
import interfaces.alumno.Feedback;
import interfaces.profesor.PEntrada;

/**
 * Esta clase implementa el controlador asociado al panel de feedback sobre un ejercicio
 * @author Andres y Francisco
 */
public class CFeedback implements ActionListener {
	/** Jpanel al que vamos a dar funcionalidad */
	private Feedback feedback;
	
	/** Instancia de la aplicacion */
	private Aplicacion app = null;
	
	/** Ejercicio del que se da el feedback */
	@SuppressWarnings("unused")
	private Ejercicio ejercicio = null;
	
	/** Ejercicio de alumno correspondiente */
	@SuppressWarnings("unused")
	private EjercicioAlumno ejerAlum = null;
	
	
	/**
	 * Constructor de la clase
	 * @param feedback
	 * @param ae
	 */
	public CFeedback (Feedback feedback, EjercicioAlumno ea) {
		this.feedback = feedback;
		this.ejerAlum = ea;
		this.ejercicio = ea.getEjercicio();
		try {
			app = Aplicacion.getInstance();
		} catch (IOException e) {
			System.out.println("Error al obtener la instancia de la aplicacion");
			e.printStackTrace();
		}
		
		if(app.getUsuarioAct() instanceof Alumno){
			feedback.getTableDatos().setValueAt(((Alumno)app.getUsuarioAct()).getNombre(), 0, 0);
			feedback.getTableDatos().setValueAt("Alumno", 0, 1);
		} else {
			feedback.getTableDatos().setValueAt("Profesorado", 0, 0);
			feedback.getTableDatos().setValueAt("Profesor", 0, 1);
		}
	}
	
	
	/**
	 * Funcion que es llamada cada vez que se interacciona con un componente
	 * seleccionable del panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Salir de la muestra de ejercicio
		if (e.getSource().equals(feedback.getSalir())) {
			SwingUtilities.getWindowAncestor(feedback).setVisible(false);
			
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
		
		//Cierre sesion
		else if (e.getSource().equals(feedback.getLogout())) {
			try {
				app.guardarDatos();
			} catch (IOException e1) {
				System.out.println("Error guardando el sistema");
				e1.printStackTrace();
			}

			SwingUtilities.getWindowAncestor(feedback).setVisible(false);
			System.exit(1);
		}
	}
	
	public Feedback getFeedback() {
		return this.feedback;
	}
}
