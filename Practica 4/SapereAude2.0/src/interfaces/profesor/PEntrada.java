package interfaces.profesor;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import controladores.CPEntrada;


/**
 * Esta clase es la encargada de construir la interfaz que representa el panel de entrada
 * de un profesor, donde se muestran un listado de las asignaturas existentes junto con
 * algunas funcionalidades basicas
 * @author Andres y Francisco
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class PEntrada extends JPanel {
     /* Listado de componentes del panel */
	 private DefaultTableModel alumnos, students;
	 private JTable tabledatos, jalumnos, jstudents;	 
	 private DefaultListModel asignaturas,disp;
	 private JList listsubjects,ldisp;
	 private JScrollPane scroll;
	 private JScrollPane contenidosscroll, dispscroll, alumnoscroll, studentscroll;
	 @SuppressWarnings("unused")
	private JLabel info, subjects,nombreAsignatura, nombreAsigCrear, desc, disponibles, notatotal;
	 private JButton crear, atender, listado, logout, atras, atras2, atras3, abrir, anyadir, modificar, eliminar, visibilidad, guardarAsignatura, aceptar, denegar;
	 private JButton expulsar, readmitir, atras4;
	 private DefaultMutableTreeNode root;
	 private DefaultTreeModel arbol;
	 private JTree jarbol;
	 private JTextField nombreAsigCrear2; 
	 private JTextArea desc2;
	 private ListSelectionModel cellSelectionModel;
	 private ListSelectionModel cellSelectionModel2;
	 private JButton notas;
	 
	 private SpringLayout pentrada;
	 
	 /**
	  * Constructor de la clase
	  */
	 @SuppressWarnings("unchecked")
	public PEntrada() {
		 pentrada = new SpringLayout(); 
		 this.setLayout(pentrada);

		 /* Inicializacion de los diversos componentes del panel */
		 String[] titulos = {"Nombre", "Rol"};
		 Object[][] filas = {
				 {"Profesorado" , "Profesor"},
				};
		 
		 String[] cabeceras = {"usuario","asignatura"};
		 Object[][] elementos = {};
		 
		 String[] cabeceras2 = {"Estado", "Numa", "Nombre", "Nota"};
		 Object[][] elementos2 = {};
		 
		 info = new JLabel("Datos del usuario");
		 
		 
		 tabledatos = new JTable(filas,titulos){
				@Override
				 public boolean isCellEditable(int row, int col){
					 return false;
				 }
			 }; 
		 tabledatos.setPreferredSize(new Dimension(250,16));
		 alumnos = new DefaultTableModel(elementos, cabeceras) {
			@Override
			 public boolean isCellEditable(int row, int col){
				 return false;
			 }
		 }; 
		 jalumnos = new JTable(alumnos);
		 jalumnos.setAutoCreateRowSorter(true);
		 alumnoscroll = new JScrollPane(jalumnos);
		 alumnoscroll.setPreferredSize(new Dimension(300,250));
		 
		 subjects = new JLabel("Asignaturas");
		 
		 asignaturas = new DefaultListModel();
		 listsubjects = new JList(asignaturas);
		 scroll = new JScrollPane(listsubjects);
		 scroll.setPreferredSize(new Dimension(300,200));
		 
		 disp = new DefaultListModel();
		 ldisp = new JList(disp);
		 dispscroll = new JScrollPane(ldisp);
		 dispscroll.setPreferredSize(new Dimension(300,300));
		 
		 crear = new JButton("Creacion Asignatura");
		 crear.setPreferredSize(new Dimension(300,20));
		 atender = new JButton("Atender Inscripcion Asignaturas");
		 atender.setPreferredSize(new Dimension(300,20));
		 atras = new JButton("Atras");
		 atras2 = new JButton("Atras");
		 atras3 = new JButton("Atras");
		 abrir = new JButton("Abrir Recurso");
		 logout = new JButton("Cerrar Sesion");
		 anyadir = new JButton("Anyadir");
		 visibilidad = new JButton("Visibilidad");
		 modificar = new JButton("Modificar");
		 eliminar = new JButton("Eliminar");
		 listado = new JButton("Listado Alumnos");
		 guardarAsignatura = new JButton("Guardar Asignatura");
		 aceptar = new JButton("Aceptar");
		 denegar = new JButton("Denegar");
		 
		 nombreAsignatura = new JLabel("");
		 disponibles = new JLabel("Asignaturas Disponibles");
		 nombreAsigCrear = new JLabel("Nombre Asignatura");
		 desc = new JLabel("Descripcion");
		 notatotal = new JLabel("Nota Total: 9/10");
		 
		 nombreAsigCrear2 = new JTextField(20);
		 desc2 = new JTextArea(15,30);
		 
		 /* Boton Listado Alumnos */
		 students = new DefaultTableModel(elementos2,cabeceras2){
				@Override
				 public boolean isCellEditable(int row, int col){
					 return false;
				 }
			 }; 
		 jstudents = new JTable(students);
		 jstudents.setAutoCreateRowSorter(true);
		 studentscroll = new JScrollPane(jstudents);
		 studentscroll.setPreferredSize(new Dimension(300,250));
		 expulsar = new JButton("Expulsar");
		 readmitir = new JButton("Readmitir");
		 atras4 = new JButton("Atras");
		 
		 notas = new JButton("Consultar notas");		 

		 /* Restricciones del layout */		 
		 pentrada.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.WEST, this);
		 pentrada.putConstraint(SpringLayout.NORTH, info, 10, SpringLayout.NORTH, this);
		 pentrada.putConstraint(SpringLayout.WEST, tabledatos, 0, SpringLayout.WEST, info);
		 pentrada.putConstraint(SpringLayout.NORTH, tabledatos, 10, SpringLayout.SOUTH, info);
		 pentrada.putConstraint(SpringLayout.WEST, subjects, 0, SpringLayout.WEST, info);
		 pentrada.putConstraint(SpringLayout.NORTH, subjects, 20, SpringLayout.SOUTH, tabledatos);
		 pentrada.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, info);
		 pentrada.putConstraint(SpringLayout.NORTH, scroll, 10, SpringLayout.SOUTH, subjects);
		 pentrada.putConstraint(SpringLayout.WEST, crear, 0, SpringLayout.WEST, info);
		 pentrada.putConstraint(SpringLayout.NORTH, crear, 20, SpringLayout.SOUTH, scroll);
		 pentrada.putConstraint(SpringLayout.WEST, atender, 0, SpringLayout.WEST, info);
		 pentrada.putConstraint(SpringLayout.NORTH, atender, 10, SpringLayout.SOUTH, crear);
		 pentrada.putConstraint(SpringLayout.EAST, logout, -10, SpringLayout.EAST, this);
		 pentrada.putConstraint(SpringLayout.NORTH, logout, 10, SpringLayout.NORTH, this);
		 	 
		 /* Adicion de ciertos componentes al panel */
		 this.add(info);
		 this.add(subjects);
		 this.add(tabledatos);
		 this.add(scroll);
		 this.add(crear);
		 this.add(atender);
		 this.add(logout);
		 
		 this.setPreferredSize(new Dimension(250,250));
		 this.setVisible(true);

	 }
	 
	 /* Funciones para organizar la disposicion de algunos componentes con respecto a este panel */
	public void colocarNombreAsigCrear() {
		pentrada.putConstraint(SpringLayout.NORTH, nombreAsigCrear, 0, SpringLayout.NORTH, subjects);
		pentrada.putConstraint(SpringLayout.WEST, nombreAsigCrear, 40, SpringLayout.EAST, scroll);
	}
	 
    public void colocarNombreAsigCrear2() {
		pentrada.putConstraint(SpringLayout.NORTH, nombreAsigCrear2, 0, SpringLayout.NORTH, nombreAsigCrear);
		pentrada.putConstraint(SpringLayout.WEST, nombreAsigCrear2, 10, SpringLayout.EAST, nombreAsigCrear);
	}
	 
	public void colocarDesc() {
		pentrada.putConstraint(SpringLayout.NORTH, desc, 10, SpringLayout.SOUTH, nombreAsigCrear);
		pentrada.putConstraint(SpringLayout.WEST, desc, 0, SpringLayout.WEST, nombreAsigCrear);
	}
	 
	public void colocarDesc2() {
		pentrada.putConstraint(SpringLayout.NORTH, desc2, 0, SpringLayout.NORTH, desc);
		pentrada.putConstraint(SpringLayout.WEST, desc2, 10, SpringLayout.EAST, desc);
    }
	 
	public void colocarAtras() {
		pentrada.putConstraint(SpringLayout.NORTH, atras, 10, SpringLayout.SOUTH, desc2);
		pentrada.putConstraint(SpringLayout.WEST, atras, 0, SpringLayout.EAST, desc);
	}
	 
	public void colocarGuardarAsignatura() {
		pentrada.putConstraint(SpringLayout.NORTH, guardarAsignatura, 0, SpringLayout.NORTH, atras);
		pentrada.putConstraint(SpringLayout.WEST, guardarAsignatura, 15, SpringLayout.EAST, atras);
	}
	 
	public void colocarAlumnosScroll() {
		pentrada.putConstraint(SpringLayout.NORTH, alumnoscroll, 0, SpringLayout.NORTH, scroll);
		pentrada.putConstraint(SpringLayout.WEST, alumnoscroll, 40, SpringLayout.EAST, scroll);
	}
	 
	public void colocarAtras2() {
		pentrada.putConstraint(SpringLayout.NORTH, atras2, 10, SpringLayout.SOUTH, alumnoscroll);
		pentrada.putConstraint(SpringLayout.WEST, atras2, 0, SpringLayout.WEST, alumnoscroll);
	}
	 
	public void colocarAceptar() {
		pentrada.putConstraint(SpringLayout.NORTH, aceptar, 0, SpringLayout.NORTH, atras2);
		pentrada.putConstraint(SpringLayout.WEST, aceptar, 15, SpringLayout.EAST, atras2);
	}
	 
	public void colocarDenegar() {
		pentrada.putConstraint(SpringLayout.NORTH, denegar, 0, SpringLayout.NORTH, atras2);
		pentrada.putConstraint(SpringLayout.WEST, denegar, 15, SpringLayout.EAST, aceptar);
	}

	public void colocarNombreAsignatura() {
		pentrada.putConstraint(SpringLayout.WEST, nombreAsignatura, 40, SpringLayout.EAST, scroll);
		pentrada.putConstraint(SpringLayout.NORTH, nombreAsignatura, 0, SpringLayout.NORTH, subjects);
	}
	
	public void colocarContenidosscroll() {
		pentrada.putConstraint(SpringLayout.NORTH, contenidosscroll, 10, SpringLayout.SOUTH, nombreAsignatura);
		pentrada.putConstraint(SpringLayout.WEST, contenidosscroll, 40, SpringLayout.EAST, scroll);
	}
	
	public void colocarAnyadir() {
		pentrada.putConstraint(SpringLayout.NORTH, anyadir, 10, SpringLayout.SOUTH, contenidosscroll);
		pentrada.putConstraint(SpringLayout.WEST, anyadir, 0, SpringLayout.WEST, contenidosscroll);
	}
	
	public void colocarModificar() {
		pentrada.putConstraint(SpringLayout.NORTH, modificar, 0, SpringLayout.NORTH, anyadir);
		pentrada.putConstraint(SpringLayout.WEST, modificar, 10, SpringLayout.EAST, anyadir);
	}
	
	public void colocarEliminar() {
		pentrada.putConstraint(SpringLayout.NORTH, eliminar, 0, SpringLayout.NORTH, anyadir);
		pentrada.putConstraint(SpringLayout.WEST, eliminar, 10, SpringLayout.EAST, modificar);
	}
	
	public void colocarVisibilidad() {
		pentrada.putConstraint(SpringLayout.NORTH, visibilidad, 0, SpringLayout.NORTH, anyadir);
		pentrada.putConstraint(SpringLayout.WEST, visibilidad, 10, SpringLayout.EAST, eliminar);
	}
	
	public void colocarListado() {
		pentrada.putConstraint(SpringLayout.WEST, listado, 0, SpringLayout.WEST, anyadir);
		pentrada.putConstraint(SpringLayout.NORTH, listado, 10, SpringLayout.SOUTH, anyadir);
	}
	
	
	public void colocarNotas() {
		pentrada.putConstraint(SpringLayout.NORTH, notas, 0, SpringLayout.NORTH, listado);
		pentrada.putConstraint(SpringLayout.WEST, notas, 10, SpringLayout.EAST, abrir);
	}
	public void colocarAtras3() {
		pentrada.putConstraint(SpringLayout.NORTH, atras3, 10, SpringLayout.SOUTH, abrir);
		pentrada.putConstraint(SpringLayout.WEST, atras3, 0, SpringLayout.WEST, listado);
	}
	
	public void colocarAbrir() {
		pentrada.putConstraint(SpringLayout.NORTH, abrir, 0, SpringLayout.NORTH, listado);
		pentrada.putConstraint(SpringLayout.WEST, abrir, 10, SpringLayout.EAST, listado);
	}
	
	public void colocarStudentsScroll(){
		pentrada.putConstraint(SpringLayout.WEST, studentscroll, 0, SpringLayout.WEST, nombreAsignatura);
		pentrada.putConstraint(SpringLayout.NORTH, studentscroll, 10, SpringLayout.SOUTH, nombreAsignatura); 
	}
	public void colocarExpulsar(){
		pentrada.putConstraint(SpringLayout.WEST, expulsar, 0, SpringLayout.WEST, nombreAsignatura);
		pentrada.putConstraint(SpringLayout.NORTH, expulsar, 10, SpringLayout.SOUTH, studentscroll);
	}
	public void colocarReadmitir(){
		pentrada.putConstraint(SpringLayout.WEST, readmitir, 10, SpringLayout.EAST, expulsar);
		pentrada.putConstraint(SpringLayout.NORTH, readmitir, 10, SpringLayout.SOUTH, studentscroll); 
	}
	public void colocarAtras4(){
		pentrada.putConstraint(SpringLayout.WEST, atras4, 10, SpringLayout.EAST, readmitir);
		pentrada.putConstraint(SpringLayout.NORTH, atras4, 10, SpringLayout.SOUTH, studentscroll);
	}

	
	
	 
	 /* Setters de los diversos action listeners a utilizar en este panel */
	 
	 public void setControladorCrear(ActionListener c) {
		 crear.addActionListener(c);
	 }
	 
	 public void setControladorAtender(ActionListener c) {
		 atender.addActionListener(c);
	 }
	 
	 public void setControladorAtras(ActionListener c) {
		 atras.addActionListener(c);
	 }
	 
	 public void setControladorAtras2(ActionListener c) {
		 atras2.addActionListener(c);
	 }
	 
	 public void setControladorGuardarAsignatura(ActionListener c) {
		 guardarAsignatura.addActionListener(c);
	 }
	  
	 public void setControladorLogout(ActionListener c) {
		 logout.addActionListener(c);
	 }
	 
	 public void setControladorAceptar(ActionListener c) {
		aceptar.addActionListener(c);
	}

	public void setControladorDenegar(ActionListener c) {
		denegar.addActionListener(c);
	}
	
	 public void setControladorAsignaturas(ListSelectionListener c) {
		 listsubjects.addListSelectionListener(c);
	 }
	 
	 public void setControladorAnyadir(ActionListener c) {
		 anyadir.addActionListener(c);
	 }
	 
	 public void setControladorModificar(ActionListener c) {
		 modificar.addActionListener(c);
	 }
	 
	 public void setControladorEliminar(ActionListener c) {
		 eliminar.addActionListener(c);
	 }
	 
	 public void setControladorVisibilidad(ActionListener c) {
		 visibilidad.addActionListener(c);
	 }
	 
	 public void setControladorAtras3(ActionListener c) {
		 atras3.addActionListener(c);
	 }
	 
	 public void setControladorAbrir(ActionListener c) {
		 abrir.addActionListener(c);
	 }
	 
	 public void setControladorAtras4(ActionListener c) {
		 atras4.addActionListener(c);
	 }
	 
	 public void setControladorListado(ActionListener c) {
		 listado.addActionListener(c);
	 }
	 
	 public void setControladorExpulsar(ActionListener c) {
		 expulsar.addActionListener(c);
	 }
	 
	 public void setControladorReadmitir(ActionListener c) {
		 readmitir.addActionListener(c);
	 }
	 
	 public void setControladorNotas(ActionListener c){
		 notas.addActionListener(c);
	 }
	 
	 
	
	/* Getters de diversos componentes que conforman el panel */
	 
	public DefaultListModel getAsignaturas() {
		return this.asignaturas;
	}
	 
	public JList getListsubjects() {
		return this.listsubjects;
	}
	 
	public JScrollPane getScroll() {
		return this.scroll;
	}
	 
	@SuppressWarnings("unchecked")
	public JList setListsubjects() {
		return new JList(asignaturas);
	}
	 
	public JScrollPane setScroll(){
		return new JScrollPane(setListsubjects());
	}
	 
	public JButton getAtender() {
		return this.atender;
	}
	 
	public JButton getAceptar() {
		return this.aceptar;
	}
	 
	public JButton getDenegar() {
		return this.denegar;
	}
	 
	public DefaultTableModel getAlumnos() {
		return this.alumnos;
	}
	 
	public JTable getJalumnos() {
		return this.jalumnos;
	}
	 
	public JScrollPane getAlumnoscroll() {
		return this.alumnoscroll;
	}
	 
	public JTable setJalumnos() {
		return new JTable(alumnos);
	}
	 
	public JScrollPane setAlumnoscroll() {
		return new JScrollPane(setJalumnos());
	}
	
	public JButton getCrear(){
		return this.crear;
	}
	 
	public JLabel getNombreAsigCrear() {
		return this.nombreAsigCrear;
	}
	 
	public JTextField getNombreAsigCrear2() {
		return this.nombreAsigCrear2;
	}
	 
	public JLabel getDesc() {
		return this.desc;
	}
	 
	public JTextArea getDesc2() { 
		return this.desc2;
	}
	 
	public JButton getAtras() {
		return this.atras;
	}
	 
	public JButton getAtras2() {
		return this.atras2;
	}
	 
	public JButton getGuardarAsignatura() {
		return this.guardarAsignatura;
	}

	public JButton getLogout() {
		return this.logout;
	}

	public JLabel getNombreAsignatura() {
		return nombreAsignatura;
	}

	public JScrollPane getContenidosscroll() {
		return contenidosscroll;
	}

	public JButton getAnyadir() {
		return anyadir;
	}
	
	public JButton getEliminar() {
		return eliminar;
	}

	public JButton getModificar() {
		return modificar;
	}

	public JButton getVisibilidad() {
		return visibilidad;
	}
	
	public JButton getNotas() {
		return notas;
	}
	
	public JButton getAtras3() {
		return atras3;
	}
	
	public JButton getAbrir() {
		return abrir;
	}

	public DefaultTreeModel getArbol() {
		return arbol;
	}

	public MutableTreeNode getRoot() {
		return root;
	}
	
	public JButton getListado() {
		return listado;
	}
	
	public JTable getJstudents() {
		return jstudents;
	}

	public JScrollPane getStudentsScroll() {
		return this.studentscroll;
	}
	
	public JButton getExpulsar() {
		return this.expulsar;
	}
	
	public JButton getReadmitir() {
		return this.readmitir;
	}
	
	public JButton getAtras4() {
		return this.atras4;
	}
	
	public ListSelectionModel getCellSelectionModel() {
		return this.cellSelectionModel;
	}
	
	public ListSelectionModel getCellSelectionModel2() {
		return this.cellSelectionModel2;
	}
	
	public DefaultTableModel getStudents() {
		return students;
	}
	
	public JTree getJarbol() {
		return jarbol;
	}
	
	/**
	 * Forma la tabla que muestra las solicitudes pendientes a un profesor mediante una serie de
	 * restricciones y la pertienente inclusion del action listener que detecte su seleccion
	 * @param modelo : tabla dinamica
	 * @param c : table selection listener
	 */
	public void setTablaPendientes(DefaultTableModel modelo, CPEntrada c) {
		alumnos = modelo;
		jalumnos = new JTable(modelo);
		jalumnos.setCellSelectionEnabled(true);
		this.cellSelectionModel = jalumnos.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(c);
		jalumnos.setAutoCreateRowSorter(true);
		alumnoscroll = new JScrollPane(jalumnos);
	}
	
	/**
	 * Forma la tabla que muestra el listado de alumnos matriculados en una asignatura mediante
	 * una serie de restricciones y la pertienente inclusion del action listener que detecte su seleccion
	 * @param modelo : tabla dinamica
	 * @param c : table selection listener
	 */
	public void setTablaPendientes2(DefaultTableModel modelo, CPEntrada c) {
		students = modelo;
		jstudents = new JTable(modelo);
		jstudents.setCellSelectionEnabled(true);
		this.cellSelectionModel2 = jstudents.getSelectionModel();
		cellSelectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel2.addListSelectionListener(c);
		jalumnos.setAutoCreateRowSorter(true);
		studentscroll = new JScrollPane(jstudents);
	}

	/**
	 * Funcion auxiliar para crear el primer nodo del arbol de asignaturas
	 * @param raiz : nodo principal
	 */
	public void crearNodoRaiz(DefaultMutableTreeNode raiz) {
		root =  raiz;
		arbol =  new DefaultTreeModel(raiz);
		jarbol =  new JTree(arbol);
		contenidosscroll = new JScrollPane(jarbol);
		contenidosscroll.setPreferredSize(new Dimension(415,300));
	}

	
	 
}