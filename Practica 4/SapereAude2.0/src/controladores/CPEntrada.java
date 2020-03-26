package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import interfaces.SapereAude;
import interfaces.alumno.AApuntes;
import interfaces.alumno.EntradaEjercicio;
import interfaces.profesor.PCreacion;
import interfaces.profesor.PEntrada;
import interfaces.profesor.PEstadisticas;

/**
 * Esta clase implementa el controlador del panel de entrada para los profesores
 * @author Andres y Francisco
 */
public class CPEntrada implements ActionListener, ListSelectionListener {
	
	/** Jpanel al que vamos a dar funcionalidad */
	private static PEntrada pe;
	
	/** Instancia de la aplicacion */
	private Aplicacion app = Aplicacion.getInstance();
	
	/** Flag para indicar cuando el menu esta ocupado o no */
	private boolean flagLibre = true;
	
	/** Entero que indidica la fila de la tabla (de atencion de solicitudes) seleccionada */
	private int seleccionFila = -1;
	
	/** Entero que indidica la fila de la tabla (listado de alumnos) seleccionada */
	private int seleccionAlumno = -1;
	
	/** Entero que indica la fila seleccionada en el listado de asignaturas */
	@SuppressWarnings("unused")
	private int numAsig;
	
	/** Flag para evitar dobles detecciones del table selection listener */
	private boolean flag = false;
	
	/** Lista de matriculas pendientes de atencion que facilita este proceso */
	private ArrayList<Matricula> matriculas;
	
	/** Lista de alumnos matriculados ene una asignatura que facilita la implementacion */
	private ArrayList<Alumno> alumnos;
	
	/** Asignatura seleccionada en el listado de asignaturas */
	private Asignatura asigActual;
	
	
	/**
	 * Constructor de la clase
	 * @param pe : jpanel pertinente
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public CPEntrada(PEntrada pe) throws IOException {
		
		CPEntrada.pe = pe;
		this.seleccionFila = -1;
		this.seleccionAlumno = -1;
		matriculas = new ArrayList<Matricula>();
		alumnos = new ArrayList<Alumno>();
		
		//Lista todas las asignaturas creadas
		for (Asignatura asig: app.getAsignaturas()) {
			CPEntrada.pe.getAsignaturas().addElement(asig.getNombre());
		}
		
		CPEntrada.pe.setScroll();
	}
	
	/**
	 * Funcion que es llamada cada vez que se interacciona con un componente
	 * seleccionable del panel
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		CPCreacion cpc;
		CApuntes ca;
		CEntradaEjercicio cee;
		CPEstadisticas cpe;
		
		//Seleccion creacion
		if (e.getSource().equals(pe.getCrear()) && flagLibre) {
			
			pe.colocarNombreAsigCrear();
			pe.colocarNombreAsigCrear2();
			pe.colocarDesc();
			pe.colocarDesc2();
			pe.colocarAtras();
			pe.colocarGuardarAsignatura();
			
			pe.add(pe.getNombreAsigCrear());
			pe.add(pe.getNombreAsigCrear2());
			
			pe.add(pe.getDesc());
			pe.add(pe.getDesc2());
			pe.add(pe.getAtras());
			pe.add(pe.getGuardarAsignatura());
			pe.setVisible(true);
			pe.updateUI();
			
			flagLibre = false;
		}
		
		//Seleccion atencion
		else if (e.getSource().equals(pe.getAtender()) && flagLibre) {
			formarTabla();
			
			pe.colocarAlumnosScroll();
			pe.colocarAtras2();
			pe.colocarAceptar();
			pe.colocarDenegar();
			
			pe.add(pe.getAlumnoscroll());
			pe.add(pe.getAceptar());
			pe.add(pe.getDenegar());
			pe.add(pe.getAtras2());
			pe.setVisible(true);
			pe.updateUI();
		
			flagLibre = false;
		}
		
		//Atras para la creacion
		else if (e.getSource().equals(pe.getAtras())) {
			pe.remove(pe.getAtras());
			pe.remove(pe.getNombreAsigCrear());
			pe.remove(pe.getNombreAsigCrear2());
			pe.remove(pe.getDesc());
			pe.remove(pe.getDesc2());
			pe.remove(pe.getGuardarAsignatura());
			pe.getNombreAsigCrear2().setText("");
			pe.getDesc2().setText("");
			pe.updateUI();
			
			flagLibre = true;
		}
		
		//Atras para la atencion
		else if (e.getSource().equals(pe.getAtras2())) {
			pe.remove(pe.getAlumnoscroll());
			pe.remove(pe.getAceptar());
			pe.remove(pe.getDenegar());
			pe.remove(pe.getAtras2());
			
			eliminarTabla();
			pe.updateUI();
			
			flagLibre = true;
		}
		
		//Atras para los contenidos
		else if (e.getSource().equals(pe.getAtras3())) {
			pe.getListsubjects().clearSelection();
			
			pe.remove(pe.getNombreAsignatura());
			pe.remove(pe.getContenidosscroll());
			pe.remove(pe.getAnyadir());
			pe.remove(pe.getEliminar());
			pe.remove(pe.getModificar());
			pe.remove(pe.getVisibilidad());
			pe.remove(pe.getListado());
			pe.remove(pe.getNotas());
			pe.remove(pe.getAtras3());
			pe.remove(pe.getAbrir());
			pe.updateUI();
					
			flagLibre = true;
		}
		
		//Atras para el listado
		else if(e.getSource().equals(pe.getAtras4())) {
			pe.remove(pe.getStudentsScroll());
			pe.remove(pe.getExpulsar());
			pe.remove(pe.getReadmitir());
			pe.remove(pe.getAtras4());
					
			pe.colocarContenidosscroll();
			pe.colocarAnyadir();
			pe.colocarEliminar();
			pe.colocarModificar();
			pe.colocarVisibilidad();
			pe.colocarNotas();
			pe.colocarAtras3();
			pe.colocarAbrir();
			pe.colocarListado();
					
			pe.add(pe.getContenidosscroll());
			pe.add(pe.getAnyadir());
			pe.add(pe.getEliminar());
			pe.add(pe.getModificar());
			pe.add(pe.getVisibilidad());
			pe.add(pe.getNotas());
			pe.add(pe.getAtras3());
			pe.add(pe.getAbrir());
			pe.add(pe.getListado());
					
			eliminarTablaListado();
			pe.updateUI();
			seleccionAlumno = -1;
		}
		
		//Guardado de la creacion
		else if (e.getSource().equals(pe.getGuardarAsignatura())) {
			if (app.getAsignaturasPorNombre(pe.getNombreAsigCrear2().getText()) == null) { 
				Asignatura nuevaAsig = new Asignatura(pe.getNombreAsigCrear2().getText(),pe.getDesc2().getText());
				app.anyadirAsignatura(nuevaAsig);
				pe.getAsignaturas().addElement(nuevaAsig.getNombre());
				pe.setScroll();
			}
			
			pe.remove(pe.getAlumnoscroll());
			pe.remove(pe.getAceptar());
			pe.remove(pe.getDenegar());
			pe.remove(pe.getAtras());
			pe.remove(pe.getNombreAsigCrear());
			pe.remove(pe.getNombreAsigCrear2());
			pe.remove(pe.getDesc());
			pe.remove(pe.getDesc2());
			pe.remove(pe.getGuardarAsignatura());
			pe.getNombreAsigCrear2().setText("");
			pe.getDesc2().setText("");
			pe.updateUI();
			
			flagLibre = true;
		}
		
		//Aceptacion atencion
		else if (e.getSource().equals(pe.getAceptar())) {
			try {
				app.atenderInscripcion(matriculas.get(seleccionFila), true);
			} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
				System.out.println("Error notificando");
				e1.printStackTrace();
			}
			
			
			pe.remove(pe.getAlumnoscroll());
			pe.remove(pe.getAceptar());
			pe.remove(pe.getDenegar());
			pe.remove(pe.getAtras2());
			
			eliminarTabla();
			pe.updateUI();
			
			flagLibre = true;
		}
		
		//Denegacion atencion
		else if (e.getSource().equals(pe.getDenegar())) {
			try {
				app.atenderInscripcion(matriculas.get(seleccionFila), false);
			} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
				System.out.println("Error notificando");
				e1.printStackTrace();
			}
			
			pe.remove(pe.getAlumnoscroll());
			pe.remove(pe.getAceptar());
			pe.remove(pe.getDenegar());
			pe.remove(pe.getAtras2());
			
			eliminarTabla();
			pe.updateUI();
			
			flagLibre = true;	
		}
		
		//Adicion recurso
		else if (e.getSource().equals(pe.getAnyadir())) {
			/* Abrir panel creacion */
			if(pe.getJarbol().getLastSelectedPathComponent() != null && ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent()).getUserObject() instanceof Tema) {
				PCreacion pc = new PCreacion();
				cpc = new CPCreacion(pc, ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent()).getUserObject());
				
				SwingUtilities.getWindowAncestor(pe).setVisible(false);
				
				SapereAude.getInstance().setContentPane(cpc.getPCreacion());
				SapereAude.getInstance().setVisible(true);
				SapereAude.getInstance().setSize(800, 600);
				
				pc.setControladorJTipo(cpc);
				pc.setControladorTTipo(cpc);
				pc.setControladorAtras1(cpc);
				pc.setControladorAtras2(cpc);
				pc.setControladorAtras3(cpc);
				pc.setControladorGuardar1(cpc);
				pc.setControladorGuardar2(cpc);
				pc.setControladorLogout(cpc);
				pc.setControladorFinalizar(cpc);
				pc.setControladorAnyadires(cpc);
				pc.setControladorAnyadiroc(cpc);
				pc.setControladorAnyadirof(cpc);
				
			} else {
				JOptionPane.showMessageDialog(null, "No puedes anyadir recurso, selecciona un tema", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		//Modificacion recurso
		else if (e.getSource().equals(pe.getModificar())) {
			/* Abrir panel modificacion */
			if(pe.getJarbol().getLastSelectedPathComponent() != null && ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent()).getUserObject() instanceof Tema) {
				JOptionPane.showMessageDialog(null, "No puedes modificar un tema, elimina y crealo", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(pe.getJarbol().getLastSelectedPathComponent() != null && ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent()).getUserObject() instanceof Apuntes) {
				JOptionPane.showMessageDialog(null, "No puedes modificar apuntes, eliminalo y crea uno nuevo", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No puedes modificar", "Error", JOptionPane.ERROR_MESSAGE);
				pe.getListsubjects().clearSelection();
				
				pe.remove(pe.getNombreAsignatura());
				pe.remove(pe.getContenidosscroll());
				pe.remove(pe.getAnyadir());
				pe.remove(pe.getEliminar());
				pe.remove(pe.getModificar());
				pe.remove(pe.getVisibilidad());
				pe.remove(pe.getListado());
				pe.remove(pe.getNotas());
				pe.remove(pe.getAtras3());
				pe.remove(pe.getAbrir());
				pe.updateUI();
						
				flagLibre = true;
			}
		}
		
		
		//Eliminacion recurso
		else if (e.getSource().equals(pe.getEliminar())) {
			DefaultMutableTreeNode nodo = ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent());
			
			if(pe.getJarbol().getLastSelectedPathComponent() != null){
				
				Recurso recur = (Recurso)(nodo.getUserObject());
			
				if (nodo.equals(pe.getRoot()) == false) {
				
					DefaultMutableTreeNode padre = (DefaultMutableTreeNode)nodo.getParent();
					Tema temaPadre = (Tema)padre.getUserObject();
				
					if(temaPadre.eliminarRecurso(recur) == false){
						if(recur instanceof Tema) {
							JOptionPane.showMessageDialog(null, "Error, no puedes eliminar un Tema con recursos dentro", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Error, no es posible eliminar este ejercicio", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						pe.getListsubjects().clearSelection();
				
						pe.remove(pe.getNombreAsignatura());
						pe.remove(pe.getContenidosscroll());
						pe.remove(pe.getAnyadir());
						pe.remove(pe.getEliminar());
						pe.remove(pe.getModificar());
						pe.remove(pe.getVisibilidad());
						pe.remove(pe.getListado());
						pe.remove(pe.getNotas());
						pe.remove(pe.getAtras3());
						pe.remove(pe.getAbrir());
						pe.updateUI();
						
						flagLibre = true;
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No se permite eliminar el tema raiz", "Eliminacion contenidos", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Error, selecciona un recurso", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//Visibilidad recurso
		else if (e.getSource().equals(pe.getVisibilidad())) {
			DefaultMutableTreeNode nodo = ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent());
			if(pe.getJarbol().getLastSelectedPathComponent() != null) {
				Recurso recur = (Recurso)(nodo.getUserObject());
			
				if(pe.getJarbol().getLastSelectedPathComponent() != null && nodo.equals(pe.getRoot()) == false) {
					recur.switchVisiblidad();
					if (recur.getVisibilidad()) {
						JOptionPane.showMessageDialog(null, "Ha puesto el recurso seleccionado como visible", "Cambio visualizacion", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Ha ocultado el recurso seleccionado", "Cambio visualizacion", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			
			}else {
				JOptionPane.showMessageDialog(null, "Error, selecciona un recurso", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//Listado alumnos
		else if (e.getSource().equals(pe.getListado())) {
			flagLibre = false;
			
			formarTablaListado();
			//CODE
			
			pe.remove(pe.getContenidosscroll());
			pe.remove(pe.getAnyadir());
			pe.remove(pe.getEliminar());
			pe.remove(pe.getModificar());
			pe.remove(pe.getVisibilidad());
			pe.remove(pe.getNotas());
			pe.remove(pe.getAtras3());
			pe.remove(pe.getAbrir());
			pe.remove(pe.getListado());
			
			pe.colocarStudentsScroll();
			pe.colocarExpulsar();
			pe.colocarReadmitir();
			pe.colocarAtras4();
			
			pe.add(pe.getStudentsScroll());
			pe.add(pe.getExpulsar());
			pe.add(pe.getReadmitir());
			pe.add(pe.getAtras4());
			pe.updateUI();
		}
		
		//Notas
		else if (e.getSource().equals(pe.getNotas())) {
			PEstadisticas pes = new PEstadisticas();
			try {
				cpe = new CPEstadisticas(pes,asigActual);

				SwingUtilities.getWindowAncestor(pe).setVisible(false);
				SapereAude.getInstance().setContentPane(cpe.getPEstadisticas());
				SapereAude.getInstance().setVisible(true);
				SapereAude.getInstance().setSize(800, 600);
			
				pes.setControladorAtras(cpe);
				pes.setControladorAtras2(cpe);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//Abrir recurso
		else if(e.getSource().equals(pe.getAbrir())) {
			
			if(pe.getJarbol().getLastSelectedPathComponent() != null) {
				Recurso rec = (Recurso) ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent()).getUserObject();
			
				/* Abrir panel visualizacion */
				if(pe.getJarbol().getLastSelectedPathComponent() != null && ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent()).getUserObject() instanceof Apuntes) {
					AApuntes aa = new AApuntes();
					ca = new CApuntes(aa, ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent()).getUserObject());
				
					SwingUtilities.getWindowAncestor(pe).setVisible(false);
				
					SapereAude.getInstance().setContentPane(ca.getAApuntes());
					SapereAude.getInstance().setVisible(true);
					SapereAude.getInstance().setSize(800, 600);
				
					aa.setControladorSalir(ca);
					aa.setControladorLogout(ca);
				}	
				else if (pe.getJarbol().getLastSelectedPathComponent() != null && ((DefaultMutableTreeNode)pe.getJarbol().getLastSelectedPathComponent()).getUserObject() instanceof Ejercicio) {
					EntradaEjercicio ee = new EntradaEjercicio();
					cee = new CEntradaEjercicio(ee, rec);
				
					SwingUtilities.getWindowAncestor(pe).setVisible(false);
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
		
		//Expulsion
		else if (e.getSource().equals(pe.getExpulsar())) {
			if (seleccionAlumno != -1) {
				if (alumnos.get(seleccionAlumno).getMatriculaAsignatura(asigActual).getEstado().equals(EstadoMatricula.EXPULSADO)) {
					JOptionPane.showMessageDialog(null, "El alumno ya esta expulsado", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					alumnos.get(seleccionAlumno).getMatriculaAsignatura(asigActual).setEstado(EstadoMatricula.EXPULSADO);
					pe.remove(pe.getStudentsScroll());
					pe.remove(pe.getExpulsar());
					pe.remove(pe.getReadmitir());
					pe.remove(pe.getAtras4());
							
					pe.colocarContenidosscroll();
					pe.colocarAnyadir();
					pe.colocarEliminar();
					pe.colocarModificar();
					pe.colocarVisibilidad();
					pe.colocarNotas();
					pe.colocarAtras3();
					pe.colocarAbrir();
					pe.colocarListado();
							
					pe.add(pe.getContenidosscroll());
					pe.add(pe.getAnyadir());
					pe.add(pe.getEliminar());
					pe.add(pe.getModificar());
					pe.add(pe.getVisibilidad());
					pe.add(pe.getNotas());
					pe.add(pe.getAtras3());
					pe.add(pe.getAbrir());
					pe.add(pe.getListado());
							
					eliminarTablaListado();
					pe.updateUI();
				}
				pe.getJstudents().clearSelection();
				seleccionAlumno = -1;
			}
			
			
		}
		
		//Readmision
		else if (e.getSource().equals(pe.getReadmitir())) {
			if (seleccionAlumno != -1) {
				if (alumnos.get(seleccionAlumno).getMatriculaAsignatura(asigActual).getEstado().equals(EstadoMatricula.CURSANDO)) {
					JOptionPane.showMessageDialog(null, "El alumno ya esta cursando la asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					alumnos.get(seleccionAlumno).getMatriculaAsignatura(asigActual).setEstado(EstadoMatricula.CURSANDO);
					pe.remove(pe.getStudentsScroll());
					pe.remove(pe.getExpulsar());
					pe.remove(pe.getReadmitir());
					pe.remove(pe.getAtras4());
							
					pe.colocarContenidosscroll();
					pe.colocarAnyadir();
					pe.colocarEliminar();
					pe.colocarModificar();
					pe.colocarVisibilidad();
					pe.colocarNotas();
					pe.colocarAtras3();
					pe.colocarAbrir();
					pe.colocarListado();
							
					pe.add(pe.getContenidosscroll());
					pe.add(pe.getAnyadir());
					pe.add(pe.getEliminar());
					pe.add(pe.getModificar());
					pe.add(pe.getVisibilidad());
					pe.add(pe.getNotas());
					pe.add(pe.getAtras3());
					pe.add(pe.getAbrir());
					pe.add(pe.getListado());
							
					eliminarTablaListado();
					pe.updateUI();
				}
				pe.getJstudents().clearSelection();
				seleccionAlumno = -1;
			}
			
			
		}
		
		//Cierre sesion
		else if (e.getSource().equals(pe.getLogout())) {
			try {
				app.guardarDatos();
			} catch (IOException e1) {
				System.out.println("Error guardando el sistema");
				e1.printStackTrace();
			}
			//SapereAude.getInstance().close();
			SwingUtilities.getWindowAncestor(pe).setVisible(false);
			System.exit(1);
		}
	}
	
	public static PEntrada getPEntrada() {
		return CPEntrada.pe;
	}
	
	/**
	 * Forma la tabla correspondiente a las solicitudes (matriculas) pendientes
	 */
	private void formarTabla() {
		DefaultTableModel modelo = pe.getAlumnos();
		int cont = 0;
		
		for (Alumno alum: app.getAlumnos()) {
			for (Matricula mat: alum.getMatriculas()) {
				if (mat.getEstado().equals(EstadoMatricula.PENDIENTE)) {
					
					Object[] fila = {"", ""};
					modelo.addRow(fila);
					modelo.setValueAt(alum.getNuma(), cont, 0);
					modelo.setValueAt(mat.getAsignatura().getNombre(), cont, 1);
					matriculas.add(mat);
					
					pe.setTablaPendientes(modelo, this);
					cont++;
				}
			}
		}
	}
	
	/**
	 * Elimina la tabla correspondiente a las solicitudes (matriculas) pendientes
	 */
	private void eliminarTabla() {
		DefaultTableModel modelo = pe.getAlumnos();
		int nFilas = modelo.getRowCount();
		for (int i = nFilas; i > 0; i--) {
			modelo.removeRow(i-1);
			matriculas.remove(i-1);
		}
	}
	
	/**
	 * Forma la tabla correspondiente al listado de alumnos matriculados
	 */
	private void formarTablaListado() {
		DefaultTableModel modelo = pe.getStudents();
		int cont = 0;
		
		for (Matricula m: asigActual.getAlumnado()) {
			Alumno alum = m.getAlumno();
			
			if (m.getEstado().equals(EstadoMatricula.PENDIENTE) == false) {
				alumnos.add(alum);	
				
				Object[] fila = {"", "", "", ""};
				modelo.addRow(fila);
				modelo.setValueAt(m.getEstado(), cont, 0);
				modelo.setValueAt(alum.getNuma(), cont, 1);
				modelo.setValueAt(alum.getNombre(), cont, 2);
				modelo.setValueAt(m.getNotaMedia(), cont, 3);
					
				pe.setTablaPendientes2(modelo, this);
				cont++;
			}
		}
	}
	
	/**
	 * Elimina la tabla correspondiente al listado de alumnos matriculados
	 */
	private void eliminarTablaListado() {
		DefaultTableModel modelo = pe.getStudents();
		int nFilas = modelo.getRowCount();
		for (int i = nFilas; i > 0; i--) {
			modelo.removeRow(i-1);
			alumnos.remove(i-1);
		}
	}

	/**
	 * Funcion que responde a los estimulos que emite la tabla de asignaturas cuando
	 * es seleccionada en su jpanel guardando el indice de la fila seleccionada
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (flag) {
			
			//Seleccion en solicitudes
			if (e.getSource().equals(pe.getCellSelectionModel())) {
				seleccionFila = pe.getJalumnos().getSelectedRow();
				System.out.println("Seleccion FTW --- " + seleccionFila);
				
			}
			
			//Seleccion de asignatura
			else if (e.getSource().equals(pe.getListsubjects()) && flagLibre) {
				flagLibre = false;
				
				numAsig = pe.getListsubjects().getSelectedIndex();
				asigActual = app.getAsignaturasPorNombre((String)pe.getListsubjects().getSelectedValue());
				
				pe.getNombreAsignatura().setText(asigActual.getNombre());
				DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(asigActual.getContenidos());

				pe.crearNodoRaiz(nodo);
				
				anyadirNodoPrincipal(nodo);
				
				pe.colocarNombreAsignatura();
				pe.colocarContenidosscroll();
				pe.colocarAnyadir();
				pe.colocarModificar();
				pe.colocarEliminar();
				pe.colocarVisibilidad();
				pe.colocarNotas();
				pe.colocarAtras3();
				pe.colocarAbrir();
				pe.colocarListado();
				
				pe.add(pe.getNombreAsignatura());
				pe.add(pe.getContenidosscroll());
				pe.add(pe.getAnyadir());
				pe.add(pe.getModificar());
				pe.add(pe.getEliminar());
				pe.add(pe.getVisibilidad());
				pe.add(pe.getNotas());
				pe.add(pe.getAtras3());
				pe.add(pe.getAbrir());
				pe.add(pe.getListado());
				pe.setVisible(true);
				pe.updateUI();
			}
			
			//Seleccion de alumnos matriculados
			else if (e.getSource().equals(pe.getCellSelectionModel2())) {
				seleccionAlumno = pe.getJstudents().getSelectedRow();
				
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
	private void anyadirNodoPrincipal(DefaultMutableTreeNode raiz) {
		int indice = 0;
		for (Recurso r: asigActual.getContenidos().getRecursos()) {
				DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(r);
				if (r instanceof Tema) {
					anyadirNodosRec((Tema) r, nodo);
				}

				pe.getArbol().insertNodeInto(nodo, raiz, indice);
				indice++;
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
				DefaultMutableTreeNode nuevoNodo = new DefaultMutableTreeNode(r);
				if (r instanceof Tema) { //Nuevo subtema
					anyadirNodosRec((Tema) r, nuevoNodo);
				}
			
				pe.getArbol().insertNodeInto(nuevoNodo, nodo, i);
				i++;
		}		
	}
}