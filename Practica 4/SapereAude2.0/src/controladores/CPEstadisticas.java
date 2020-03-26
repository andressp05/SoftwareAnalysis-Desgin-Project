package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import aplicacion.Aplicacion;
import aplicacion.Asignatura;
import aplicacion.Matricula;
import interfaces.SapereAude;
import interfaces.profesor.PEntrada;
import interfaces.profesor.PEstadisticas;

/**
 * Esta clase  implementa el controlador de estaddisticas
 * @author Andres y Francisco
 */
public class CPEstadisticas implements ActionListener, ListSelectionListener {
	
	/** Jpanel al que vamos a dar funcionalidad */
	private PEstadisticas pe;
	
	/** Instancia de la aplicacion */
	private Aplicacion app = null;
	
	/** Flag para indicar cuando el menu esta ocupado o no */
	@SuppressWarnings("unused")
	private boolean flagLibre = true;
	
	/** Entero que indidica la fila de la tabla (de atencion de solicitudes) seleccionada */
	@SuppressWarnings("unused")
	private int seleccionFila = -1;
	
	/** Entero que indica la fila seleccionada en el listado de asignaturas */
	@SuppressWarnings("unused")
	private int numAsig;
	
	/** Flag para evitar dobles detecciones del table selection listener */
	@SuppressWarnings("unused")
	private boolean flag = false;
	
	/** Lista de matriculas pendientes de atencion que facilita este proceso */
	private ArrayList<Matricula> matriculas;
	
	/** Asignatura seleccionada en el listado de asignaturas */
	@SuppressWarnings("unused")
	private Asignatura asig;
	
	/**
	 * Constructor de la clase
	 * @param pe : jpanel pertinente
	 * @param asig : asignatura
	 * @throws IOException
	 */
	public CPEstadisticas(PEstadisticas pe, Asignatura asig) throws IOException {
		this.asig = asig;
		try {
			app = Aplicacion.getInstance();
			this.pe = pe;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Funcion que es llamada cada vez que se interacciona con un componente
	 * seleccionable del panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Salir
		if (e.getSource().equals(pe.getAtras1())) {
			SwingUtilities.getWindowAncestor(pe).setVisible(false);
			PEntrada pe = new PEntrada();
			CPEntrada cpentrada;
			try {
				cpentrada = new CPEntrada(pe);
				
				SapereAude.getInstance().setContentPane(CPEntrada.getPEntrada());
				SapereAude.getInstance().setVisible(true);
				SapereAude.getInstance().setSize(800, 600);
				
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
		
		//Atras para Pregunta
		else if (e.getSource().equals(pe.getAtras2())) {
			pe.remove(pe.getNombreEjercicio());
			pe.remove(pe.getJSEjercicio());
			pe.remove(pe.getAtras2());
			
			eliminarTabla();
			pe.updateUI();
		}
				
		//Cierre sesion
		else if (e.getSource().equals(pe.getLogout())) {
			try {
				app.guardarDatos();
			} catch (IOException e1) {
				System.out.println("Error guardando el sistema");
				e1.printStackTrace();
			}
			SwingUtilities.getWindowAncestor(pe).setVisible(false);
			System.exit(1);
		}
	}
	
	public PEstadisticas getPEstadisticas(){
		return this.pe;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
	}
	/**
	 * Elimina la tabla correspondiente a las solicitudes (matriculas) pendientes
	 */
	private void eliminarTabla() {
		DefaultTableModel modelo = pe.getDEjercicio();
		int nFilas = modelo.getRowCount();
		for (int i = nFilas; i > 0; i--) {
			modelo.removeRow(i-1);
			matriculas.remove(i-1);
		}
	}

}