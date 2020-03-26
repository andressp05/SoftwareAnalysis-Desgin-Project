package controladores;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import aplicacion.Aplicacion;
import aplicacion.Asignatura;
import aplicacion.EstadoMatricula;
import aplicacion.Matricula;
import aplicacion.recursos.Apuntes;
import aplicacion.recursos.Recurso;
import aplicacion.recursos.Tema;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.usuarios.Alumno;
import interfaces.SapereAude;
import interfaces.alumno.AApuntes;
import interfaces.alumno.AEntrada;
import interfaces.alumno.EntradaEjercicio;

/**
 * Esta clase implementa el controlador asociado al panel de entrada para
 * los alumnos
 * @author Andres y Francisco
 */
public class CAEntrada implements ActionListener, ListSelectionListener {
	
	/** Jpanel al que vamos a dar funcionalidad */
	private AEntrada ae;
	
	/** Instancia de la aplicacion */
	private Aplicacion app = Aplicacion.getInstance();
	
	/** Flag para indicar cuando el menu esta ocupado o no */
	private boolean flagLibre = true;
	
	/** Entero que indidica la fila de la lista (de seleccion de asignaturas) seleccionada */
	private static int indice = -1;
	
	/** Flag para evitar dobles detecciones del list selection listener */
	private boolean flag = true; 
	
	/** Variable que coordina la seleccion de la lista de asignaturas */
	private boolean seleccionando = false;
	
	/** Entero que indica la fila seleccionada en el listado de asignaturas */
	@SuppressWarnings("unused")
	private int numAsig;

	/** Asignatura seleccionada en el listado de asignaturas */
	private Asignatura asigActual; 
	
	/**
	 * Constructor de la clase
	 * @param ae : jpanel pertinente
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public CAEntrada(AEntrada ae) throws IOException {
		Asignatura asig;
		
		indice = -1;
		this.flagLibre = true;
		this.seleccionando = false;
		this.ae = ae;
		this.ae.getDatos().setValueAt(((Alumno) (app.getUsuarioAct())).getNombre(), 0, 0);
		this.ae.setTableDatos(ae.getDatos());
		this.ae.getTableDatos().setPreferredSize(new Dimension(300,16));
		
		for (Matricula m: ((Alumno) (app.getUsuarioAct())).getMatriculas()) {
			asig = m.getAsignatura();
			if (m.getEstado().equals(EstadoMatricula.CURSANDO)) {
				this.ae.getAsignaturas().addElement(asig.getNombre());
			}
		}
		this.ae.setScroll();
	}
	
	/**
	 * Funcion que es llamada cada vez que se interacciona con un componente
	 * seleccionable del panel
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		CApuntes ca;
		CEntradaEjercicio cee;
		
		//Solicita inscripcion
		if (e.getSource().equals(ae.getSolicitar()) && flagLibre) {

			for (Asignatura asig: app.getAsignaturas()) {
				if (((Alumno) (app.getUsuarioAct())).getMatriculaAsignatura(asig) == null) {
					//Anyadimos a la lista las asignaturas correspondientes
					this.ae.getDisp().addElement(asig.getNombre());
				}
			}
			
			ae.setDispscroll();
			ae.colocarDisponibles();
			ae.colocarDispScroll();
			ae.colocarAtras();
			
			ae.add(ae.getDisponibles());
			ae.add(ae.getDispscroll());
			ae.add(ae.getAtras());
			
			ae.setVisible(true);
			ae.updateUI();
			
			flagLibre = false;
			seleccionando = true;
		}
		
		
		//Atras de inscripcion
		else if (e.getSource().equals(ae.getAtras())) {
			seleccionando = false;
			for (Asignatura asig: app.getAsignaturas()) {
				if (((Alumno) (app.getUsuarioAct())).getMatriculaAsignatura(asig) == null) {
					this.ae.getDisp().removeElement(asig.getNombre());
				}
			}
			
			ae.remove(ae.getDisponibles());
			ae.remove(ae.getDispscroll());
			ae.remove(ae.getAtras());
			
			ae.updateUI();
			
			flagLibre = true;
		}
		
		//Atras de la seleccion de asignatura
		else if (e.getSource().equals(ae.getAtras2())) {
			ae.getListSubjects().clearSelection();
			
			ae.remove(ae.getNombreAsignatura());
			ae.remove(ae.getContenidosscroll());
			ae.remove(ae.getAtras2());
			ae.remove(ae.getAbrir());
			
			ae.updateUI();
			
			flagLibre = true;
		}
		
		//Abrir recurso
		else if(e.getSource().equals(ae.getAbrir())) {
			if(ae.getJarbol().getLastSelectedPathComponent() != null) {
				Recurso rec = (Recurso) ((DefaultMutableTreeNode)ae.getJarbol().getLastSelectedPathComponent()).getUserObject();
			
				/* Abrir panel visualizacion */
				if(ae.getJarbol().getLastSelectedPathComponent() != null && rec instanceof Apuntes) {
					AApuntes aa = new AApuntes();
					ca = new CApuntes(aa, rec);
						
					SwingUtilities.getWindowAncestor(ae).setVisible(false);
						
					SapereAude.getInstance().setContentPane(ca.getAApuntes());
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800, 600);
						
					aa.setControladorSalir(ca);
					aa.setControladorLogout(ca);
				}	
				else if (ae.getJarbol().getLastSelectedPathComponent() != null && rec instanceof Ejercicio) {
					EntradaEjercicio ee = new EntradaEjercicio();
					cee = new CEntradaEjercicio(ee, rec);
					
					SwingUtilities.getWindowAncestor(ae).setVisible(false);
					SapereAude.getInstance().setContentPane(cee.getEntradaEjercicio());
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800, 600);
				
					ee.setControladorLogout(cee);
					ee.setControladorComenzar(cee);
					ee.setControladorSalir(cee);
				
				} else {
					JOptionPane.showMessageDialog(null, "No has seleccionado ni apuntes ni ejercicio", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
			JOptionPane.showMessageDialog(null, "Error, selecciona un recurso", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
			
		
		//Cierre sesion
		else if (e.getSource().equals(ae.getLogout())) {
			try {
				app.guardarDatos();
			} catch (IOException e1) {
				System.out.println("Error guardando el sistema");
				e1.printStackTrace();
			}
			SwingUtilities.getWindowAncestor(ae).setVisible(false);
			System.exit(1);
		}
		
	}
	
	public AEntrada getAEntrada(){
		return this.ae;
	}
	
	/**
	 * Funcion que responde a los estimulos que emite la lista de asignaturas cuando
	 * es seleccionada en su jpanel guardando el indice de la fila seleccionada y 
	 * realiazando la solicitud de la asignatura elegida.
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (flag) {
			//Seleccion en la tabla de solicitudes
			if (e.getSource().equals(ae.getLdisp()) && seleccionando) {
				System.out.print("selecciona asig");
				
				seleccionando = false;
				String nombre;
				indice = ae.getLdisp().getSelectedIndex();
		
				if (indice != -1) {
					nombre = (String) this.ae.getDisp().getElementAt(indice);
					Asignatura asig = app.getAsignaturasPorNombre(nombre);
					app.solicitarInscripcion(asig);
					this.ae.getDisp().removeElement(asig.getNombre());
				}
		
				for (Asignatura a: app.getAsignaturas()) {
					if (((Alumno) (app.getUsuarioAct())).getMatriculaAsignatura(a) == null) {
						this.ae.getDisp().removeElement(a.getNombre());
					}
				}
		
				ae.remove(ae.getDisponibles());
				ae.remove(ae.getDispscroll());
				ae.remove(ae.getAtras());
				ae.setVisible(true);
				ae.updateUI();
				
				flagLibre = true;
			
			}
			//Seleccion en el listado de asignaturas
			else if (e.getSource().equals(ae.getListSubjects()) && flagLibre) {
				flagLibre = false;
				
				numAsig = ae.getListSubjects().getSelectedIndex();
				asigActual = app.getAsignaturasPorNombre((String)ae.getListSubjects().getSelectedValue());
				
				ae.getNombreAsignatura().setText(asigActual.getNombre());
				DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(asigActual.getContenidos());
				
				ae.crearNodoRaiz(nodo);
				anyadirNodoPrincipal();
				
				ae.colocarNombreAsignatura();
				ae.colocarContenidosscroll();
				ae.colocarAtras2();
				ae.colocarAbrir();
				
				ae.add(ae.getNombreAsignatura());
				ae.add(ae.getContenidosscroll());
				ae.add(ae.getAtras2());
				ae.add(ae.getAbrir());
				
				ae.setVisible(true);
				ae.updateUI();
			}
			flag = false;
		}
		else {
			flag = true;
		}
	}
	
	
	/**
	 * Funcion que anyade los temas superiores que forman una asignatura y llama a otra
	 * recursiva capa rellenarlos adecuadamente
	 */
	private void anyadirNodoPrincipal() {
		int indice = 0;
		for (Recurso r: asigActual.getContenidos().getRecursos()) {
			if (r.getVisibilidad()) {
				DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(r);
				if (r instanceof Tema) {
					anyadirNodosRec((Tema) r, nodo);
				}
				ae.getArbol().insertNodeInto(nodo, ae.getRoot(), indice);
				indice++;
			}
		}
	}

	/**
	 * Funcion que anyade los componenetes (recursos) por los que esta formado un tema a este
	 * de modo recursivo
	 * @param t : tema
	 * @param nodo : nodo del tema
	 */
	private void anyadirNodosRec(Tema t, DefaultMutableTreeNode nodo) {
		if (t == null || nodo == null) {
			return;
		}
		int i = 0;
		for (Recurso r: t.getRecursos()) {
			if (r.getVisibilidad()) {
				DefaultMutableTreeNode nuevoNodo = new DefaultMutableTreeNode(r);
				if (r instanceof Tema) { //Nuevo subtema
					anyadirNodosRec((Tema) r, nuevoNodo);
				}
			
				ae.getArbol().insertNodeInto(nuevoNodo, nodo, i);
				i++;
			}
		}		
	}
	
}