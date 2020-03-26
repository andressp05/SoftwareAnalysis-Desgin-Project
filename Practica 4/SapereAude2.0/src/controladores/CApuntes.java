package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingUtilities;

import aplicacion.Aplicacion;
import aplicacion.recursos.Apuntes;
import aplicacion.usuarios.Alumno;
import aplicacion.usuarios.Profesor;
import interfaces.SapereAude;
import interfaces.alumno.AApuntes;
import interfaces.alumno.AEntrada;
import interfaces.profesor.PEntrada;

/**
 * Esta clase implementa el controlador asociado al panel de apuntes
 * @author Andres y Francisco
 */
public class CApuntes implements ActionListener{
	/** Jpanel al que vamos a dar funcionalidad */
	private AApuntes aa;
	
	/** Instancia de la aplicacion */
	private Aplicacion app = null;
	
	/** Panel de entrada para los alumnos */
	private AEntrada ae = null;
	
	/** apuntes del controlador */
	private Apuntes apuntes = null;
	/**
	 * Constructor de la clase
	 * @param ae : ae
	 * @param apuntes : apuntes
	 */
	public CApuntes(AApuntes aa, Object apuntes) {
		this.aa = aa;
		this.apuntes = (Apuntes) apuntes;
		try {
			app = Aplicacion.getInstance();
		} catch (IOException e) {
			System.out.println("Error al obtener la instancia de la aplicacion");
			e.printStackTrace();
		}
		
		if (app.getUsuarioAct() instanceof Profesor) {
			aa.getTableDatos().setValueAt("Profesorado", 0, 0);
			aa.getTableDatos().setValueAt("Profesor", 0, 1);
		}
		else {
			aa.getTableDatos().setValueAt(((Alumno)app.getUsuarioAct()).getNombre(), 0, 0);
			aa.getTableDatos().setValueAt("Alumno", 0, 1);
		}
		aa.getTitulo().setText(this.apuntes.toString());
		aa.getContenido().setText(this.apuntes.getContenido());
	}
	
	
	
	
	/**
	 * Funcion que es llamada cada vez que se interacciona con un componente
	 * seleccionable del panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Salir de la muestra de apuntes
		if(e.getSource().equals(aa.getSalir())) {
			SwingUtilities.getWindowAncestor(aa).setVisible(false);
			
			if (app.getUsuarioAct() instanceof Profesor) {
				CPEntrada cpentrada;
				PEntrada pe = new PEntrada();
				try {
					cpentrada = new CPEntrada(pe);
					SapereAude.getInstance().setContentPane(CPEntrada.getPEntrada());
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800, 600);
					
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
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else {
				ae = new AEntrada();
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
		else if (e.getSource().equals(aa.getLogout())) {
			try {
				app.guardarDatos();
			} catch (IOException e1) {
				System.out.println("Error guardando el sistema");
				e1.printStackTrace();
			}
			SwingUtilities.getWindowAncestor(aa).setVisible(false);
			System.exit(1);
		}
	}
	
	public AApuntes getAApuntes() {
		return this.aa;
	}
}
