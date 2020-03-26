package interfaces.alumno;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controladores.CAEntrada;

/**
 * Esta clase se encarga de llevar a cabo la interfaz asociada al panel de entrada de los alumnos,
 * donde se mostrara un listado de las asignaturas en las que se encuentran matriculados asi como
 * una serie de funcionalidades basicas
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class AEntrada extends JPanel {
	
	/* Componentes del panel */
	 private DefaultTableModel notas, datos;
	 private JTable tabledatos, jnotas;
	 @SuppressWarnings("rawtypes")
	 private DefaultListModel asignaturas, disp;
	 @SuppressWarnings("rawtypes")
	 private JList listsubjects, ldisp;
	 private JScrollPane scroll;
	 private JScrollPane contenidosscroll, dispscroll, notascroll;
	 private JLabel info, subjects, nombreAsignatura, nombreAsignatura2, disponibles,notatotal;
	 private JButton solicitar, logout, consultanotas, atras, atras2, abrir;
	 private DefaultMutableTreeNode root;
	 private DefaultTreeModel arbol;
	 private JTree jarbol;
	 private SpringLayout aentrada;
	 
	 /**
	  * Constructor de la clase
	  */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public AEntrada() {
		 aentrada = new SpringLayout(); 
		 this.setLayout(aentrada);

		 /* Inicializacion de los diversos componentes del panel */
		 String[] titulos = {"Nombre", "Rol"};
		 Object[][] filas = {
				 {"" , "Alumno"},
				};
		 
		 String[] cabeceras = {"ejercicio","nota","ponderacion"};
		 Object[][] elementos = {
				 {"Ejercicio 1" , new Double(9), new Double(20)},
				 {"Ejercicio 2" , new Double(7.5), new Double(20)},
				 {"Ejercicio 3" , new Double(9.5), new Double(60)},
				};
		 
		 info = new JLabel("Datos del usuario");
		 
		 datos = new DefaultTableModel(filas,titulos){
				@Override
				 public boolean isCellEditable(int row, int col){
					 return false;
				 }
			 }; 
		 tabledatos = new JTable(datos){
				@Override
				 public boolean isCellEditable(int row, int col){
					 return false;
				 }
			 }; 
		 notas = new DefaultTableModel(elementos,cabeceras){
				@Override
				 public boolean isCellEditable(int row, int col){
					 return false;
				 }
			 }; 
		 jnotas = new JTable(notas){
				@Override
				 public boolean isCellEditable(int row, int col){
					 return false;
				 }
			 }; 
		 notascroll = new JScrollPane(jnotas);
		 notascroll.setPreferredSize(new Dimension(300,250));
		 
		 subjects = new JLabel("Asignaturas");
		 
		 asignaturas = new DefaultListModel();
		 listsubjects = new JList(asignaturas);
		 scroll = new JScrollPane(listsubjects);
		 scroll.setPreferredSize(new Dimension(300,200));
		 
		 disp = new DefaultListModel();
		 ldisp = new JList(disp);
		 dispscroll = new JScrollPane(ldisp);
		 dispscroll.setPreferredSize(new Dimension(300,300));
		 
		 solicitar = new JButton("Solicitud Inscripcion Asignatura");
		 solicitar.setPreferredSize(new Dimension(300,20));
		 consultanotas = new JButton("Consulta Notas");
		 consultanotas.setPreferredSize(new Dimension(300,20));
		 atras = new JButton("Atras");
		 
		 atras.setPreferredSize(new Dimension(300,20));
		 logout = new JButton("Cerrar Sesion");
		 
		 nombreAsignatura = new JLabel("");
		 disponibles = new JLabel("Asignaturas Disponibles");
		 nombreAsignatura2 = new JLabel("");
		 notatotal = new JLabel("Nota Total: 9/10");
		 
		 atras2 = new JButton("Atras");
		 abrir = new JButton("Abrir Recurso");
		 
		 root =  new DefaultMutableTreeNode("Contenidos");
		 arbol =  new DefaultTreeModel(root);
		 jarbol =  new JTree(arbol);
		 contenidosscroll = new JScrollPane(jarbol);
		 
		 contenidosscroll.setPreferredSize(new Dimension(415, 300));
		 
		 /* Restricciones del layout */		 
		 aentrada.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.WEST, this);
		 aentrada.putConstraint(SpringLayout.NORTH, info, 10, SpringLayout.NORTH, this);
		 aentrada.putConstraint(SpringLayout.WEST, tabledatos, 0, SpringLayout.WEST, info);
		 aentrada.putConstraint(SpringLayout.NORTH, tabledatos, 10, SpringLayout.SOUTH, info);
		 aentrada.putConstraint(SpringLayout.WEST, subjects, 0, SpringLayout.WEST, info);
		 aentrada.putConstraint(SpringLayout.NORTH, subjects, 20, SpringLayout.SOUTH, tabledatos);
		 aentrada.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, info);
		 aentrada.putConstraint(SpringLayout.NORTH, scroll, 10, SpringLayout.SOUTH, subjects);
		 aentrada.putConstraint(SpringLayout.WEST, solicitar, 0, SpringLayout.WEST, info);
		 aentrada.putConstraint(SpringLayout.NORTH, solicitar, 20, SpringLayout.SOUTH, scroll);
		 aentrada.putConstraint(SpringLayout.WEST, consultanotas, 0, SpringLayout.WEST, info);
		 aentrada.putConstraint(SpringLayout.NORTH, consultanotas, 10, SpringLayout.SOUTH, solicitar);
		 aentrada.putConstraint(SpringLayout.EAST, logout, -10, SpringLayout.EAST, this);
		 aentrada.putConstraint(SpringLayout.NORTH, logout, 10, SpringLayout.NORTH, this);
		 aentrada.putConstraint(SpringLayout.NORTH, contenidosscroll, 10, SpringLayout.SOUTH, nombreAsignatura);
		 aentrada.putConstraint(SpringLayout.WEST, contenidosscroll, 40, SpringLayout.EAST, scroll);
		 aentrada.putConstraint(SpringLayout.WEST, nombreAsignatura2, 40, SpringLayout.EAST, scroll);
		 aentrada.putConstraint(SpringLayout.NORTH, nombreAsignatura2, 0, SpringLayout.NORTH, subjects);
		 aentrada.putConstraint(SpringLayout.NORTH, notascroll, 10, SpringLayout.SOUTH, nombreAsignatura2);
		 aentrada.putConstraint(SpringLayout.WEST, notascroll, 40, SpringLayout.EAST, scroll);
		 aentrada.putConstraint(SpringLayout.NORTH, notatotal, 10, SpringLayout.SOUTH, notascroll);
		 aentrada.putConstraint(SpringLayout.WEST, notatotal, 0, SpringLayout.WEST, notascroll);

		 /* Adicion de ciertos componentes al panel */
		 this.add(info);
		 this.add(subjects);
		 this.add(tabledatos);
		 this.add(scroll);
		 this.add(solicitar);
		 this.add(logout);
		 this.setPreferredSize(new Dimension(250,250));
		 this.setVisible(true);
	 }
	 
	 /* Funciones para organizar la disposicion de algunos componentes con respecto a este panel */
	 
	 public void colocarDisponibles() {
		 aentrada.putConstraint(SpringLayout.WEST, disponibles, 40, SpringLayout.EAST, scroll);
		 aentrada.putConstraint(SpringLayout.NORTH, disponibles, 0, SpringLayout.NORTH, subjects);
	 }
	 
	 public void colocarDispScroll() {
		 aentrada.putConstraint(SpringLayout.NORTH, dispscroll, 10, SpringLayout.SOUTH, disponibles);
		 aentrada.putConstraint(SpringLayout.WEST, dispscroll, 40, SpringLayout.EAST, scroll);
	 }
	 
	 public void colocarAtras() {
		 aentrada.putConstraint(SpringLayout.WEST, atras, 0, SpringLayout.WEST, info);
		 aentrada.putConstraint(SpringLayout.NORTH, atras, 10, SpringLayout.SOUTH, solicitar);
	 }
	 
	 /* Atras de contenidos*/
	 public void colocarAtras2() {
		 aentrada.putConstraint(SpringLayout.WEST, atras2, 0, SpringLayout.WEST, contenidosscroll);
		 aentrada.putConstraint(SpringLayout.NORTH, atras2, 10, SpringLayout.SOUTH, contenidosscroll);
	 }
	 
	 public void colocarAbrir() {
		 aentrada.putConstraint(SpringLayout.EAST, abrir, 0, SpringLayout.EAST, contenidosscroll);
		 aentrada.putConstraint(SpringLayout.NORTH, abrir, 0, SpringLayout.NORTH, atras2);
	 }
	 
	 public void colocarNombreAsignatura() {
		 aentrada.putConstraint(SpringLayout.WEST, nombreAsignatura, 40, SpringLayout.EAST, scroll);
		 aentrada.putConstraint(SpringLayout.NORTH, nombreAsignatura, 0, SpringLayout.NORTH, subjects);
	}
		
	public void colocarContenidosscroll() {
		aentrada.putConstraint(SpringLayout.NORTH, contenidosscroll, 10, SpringLayout.SOUTH, nombreAsignatura);
		 aentrada.putConstraint(SpringLayout.WEST, contenidosscroll, 40, SpringLayout.EAST, scroll);
	}
	 
	 
	 /* Setters de los diversos action listeners a utilizar en este panel */
	 
	 public void setControladorSolicitar(ActionListener c) {
		 solicitar.addActionListener(c);
	 }
	 
	 public void setControladorAtras(ActionListener c) {
		 atras.addActionListener(c);
	 }
	 
	 public void setControladorAtras2(ActionListener c) {
		 atras2.addActionListener(c);
	 }
	 
	 public void setControladorAbrir(ActionListener c) {
		 abrir.addActionListener(c);
	 }
	 
	 public void setControladorLogout(ActionListener c) {
		logout.addActionListener(c);	
	 }
	 
	 public void setControladorLDisp(CAEntrada c) {
		 ldisp.addListSelectionListener(c);
	 }
	 
	 public void setControladorAsignaturas(ListSelectionListener c) {
		 listsubjects.addListSelectionListener(c);
	 }
	 
	 
	 
	 
	 /* Getters y setters de diversos componentes que conforman el panel */
	 
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 private JList setListSubjects() {
		 return new JList(asignaturas);
	 }
	 
	 public JScrollPane setScroll() {
		 return new JScrollPane(setListSubjects());
	 }
	 
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	private JList setLdisp() {
		 return new JList(disp);
	 }
	 
	 public JScrollPane setDispscroll() {
		 return new JScrollPane(setLdisp());
	 }
	 
	 public DefaultTableModel getDatos() {
		 return this.datos;
	 }
	 
	 public JLabel getInfo() {
		 return this.info;
	 }
	 
	 public JTable getTableDatos() {
		 return this.tabledatos;
	 }
	 
	 public JTable setTableDatos(DefaultTableModel datos){
		 return new JTable(datos);
	 }
	 
	 @SuppressWarnings("rawtypes")
	 public JList getListSubjects() {
		 return this.listsubjects;
	 }
	 
	 public JScrollPane getScroll() {
		 return this.scroll;
	 }
	 
	 @SuppressWarnings("rawtypes")
	 public DefaultListModel getAsignaturas() {
		 return this.asignaturas;
	 }
	 
	 
	 public JButton getSolicitar() {
		 return this.solicitar;
	 }
	 
	 public JLabel getDisponibles() {
		 return this.disponibles;
	 }
	 
	 @SuppressWarnings("rawtypes")
	public DefaultListModel getDisp() {
		 return this.disp;
	 }
	 
	 @SuppressWarnings("rawtypes")
	public JList getLdisp() {
		 return this.ldisp;
	 }
	 
	 public JScrollPane getDispscroll() {
		 return this.dispscroll;
	 }
	 
	 
	 public JButton getAtras() {
		 return this.atras;
	 }
	 
	 public JButton getAtras2() {
		 return this.atras2;
	 }
	 
	 public JButton getAbrir() {
		 return this.abrir;
	 }
	 
	 public JLabel getNombreAsignatura() {
		return nombreAsignatura;
	}

	public JScrollPane getContenidosscroll() {
		return contenidosscroll;
	}
	
	public DefaultTreeModel getArbol() {
		return arbol;
	}
	
	public JTree getJarbol() {
		return this.jarbol;
	}
	
	public DefaultMutableTreeNode getRoot() {
		return root;
	}
	 
	 public Object getLogout() {
			return this.logout;
	}

	public void crearNodoRaiz(DefaultMutableTreeNode raiz) {
		root =  raiz;
		arbol =  new DefaultTreeModel(raiz);
		jarbol =  new JTree(arbol);
		contenidosscroll = new JScrollPane(jarbol);
		contenidosscroll.setPreferredSize(new Dimension(415,300));
	}

	

	 
	 
}
