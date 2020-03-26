package interfaces.profesor;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import controladores.CPEntrada;


/**
 * Esta clase es la encargada de construir la interfaz que muestras las estadisticas generales
 * @author Andres y Francisco
 */
@SuppressWarnings({ "serial" })
public class PEstadisticas extends JPanel {
     /* Listado de componentes del panel */
	 private DefaultTableModel dgeneral, dejercicio;
	 private JTable jtgeneral, jtejercicio, jtdatos;	 
	 private JScrollPane jsgeneral, jsejercicio;
	 private JLabel nombreAsignatura, nombreEjercicio, info;
	 private JButton atras1, atras2, logout;
	 private ListSelectionModel cellSelectionModel;
	 
	 private SpringLayout pestadisticas;
	 
	 /**
	  * Constructor de la clase
	  */
	 public PEstadisticas() {
		 pestadisticas = new SpringLayout(); 
		 this.setLayout(pestadisticas);

		 /* Inicializacion de los diversos componentes del panel */
		 String[] cabeceras1 = {"Nombre", "Rol"};
		 Object[][] elementos1 = {
				 {"Profesorado" , "Profesor"},
				};
		 
		 String[] cabeceras2 = {"Ejercicio","Bien", "Mal", "SC", "Nota Media"};
		 Object[][] elementos2 = {
				 {"Ejercicio 1","5","10","10", "3"},
				 {"Ejercicio 2","15","20","10", "4"},
				 {"Ejercicio 3","25","30","10", "5"},
				 {"Ejercicio 4","35","40","10", "6"},
				 {"Ejercicio 5","45","50","10", "7"},
		 };
		 
		 String[] cabeceras3 = {"Pregunta","Bien", "Mal", "SC"};
		 Object[][] elementos3 = {
				 {"Pregunta 1","5","10","10"},
				 {"Pregunta 2","15","20","10"},
				 {"Pregunta 3","25","30","10"},
				 {"Pregunta 4","35","40","10"},
				 {"Pregunta 5","45","50","10"},
		 };
		 
		 jtdatos = new JTable(elementos1,cabeceras1);
		 jtdatos.setPreferredSize(new Dimension(250,16));
		 
		 dgeneral = new DefaultTableModel(elementos2, cabeceras2);
		 jtgeneral = new JTable(dgeneral);
		 jtgeneral.setAutoCreateRowSorter(true);
		 jsgeneral = new JScrollPane(jtgeneral);
		 jsgeneral.setPreferredSize(new Dimension(400,250));
		 
		 dejercicio = new DefaultTableModel(elementos3, cabeceras3);
		 jtejercicio = new JTable(dejercicio);
		 jtejercicio.setAutoCreateRowSorter(true);
		 jsejercicio = new JScrollPane(jtejercicio);
		 jsejercicio.setPreferredSize(new Dimension(350,250));
		 
		 info = new JLabel("Datos del usuario");
		 nombreAsignatura = new JLabel("Lengua");
		 nombreEjercicio = new JLabel("Ejercicio 1");
		 
		 atras1 = new JButton("Salir");
		 atras2 = new JButton("Atras");
		 logout = new JButton("Cerrar Sesion");
		 
		 /* Restricciones del layout */		 
		 pestadisticas.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.WEST, this);
		 pestadisticas.putConstraint(SpringLayout.NORTH, info, 10, SpringLayout.NORTH, this);
		 pestadisticas.putConstraint(SpringLayout.WEST, jtdatos, 0, SpringLayout.WEST, info);
		 pestadisticas.putConstraint(SpringLayout.NORTH, jtdatos, 10, SpringLayout.SOUTH, info);
		 pestadisticas.putConstraint(SpringLayout.WEST, nombreAsignatura, 0, SpringLayout.WEST, info);
		 pestadisticas.putConstraint(SpringLayout.NORTH, nombreAsignatura, 20, SpringLayout.SOUTH, jtdatos);
		 pestadisticas.putConstraint(SpringLayout.WEST, jsgeneral, 0, SpringLayout.WEST, info);
		 pestadisticas.putConstraint(SpringLayout.NORTH, jsgeneral, 10, SpringLayout.SOUTH, nombreAsignatura);
		 pestadisticas.putConstraint(SpringLayout.NORTH, jsgeneral, 10, SpringLayout.SOUTH, nombreAsignatura);
		 pestadisticas.putConstraint(SpringLayout.WEST, atras1, 0, SpringLayout.WEST, info);
		 pestadisticas.putConstraint(SpringLayout.NORTH, atras1, 10, SpringLayout.SOUTH, jsgeneral);
		 pestadisticas.putConstraint(SpringLayout.EAST, logout, -10, SpringLayout.EAST, this);
		 pestadisticas.putConstraint(SpringLayout.NORTH, logout, 10, SpringLayout.NORTH, this);
		 		 
		 /* Adicion de ciertos componentes al panel */
		 this.add(info);
		 this.add(jtdatos);
		 this.add(nombreAsignatura);
		 this.add(jsgeneral);
		 this.add(atras1);
		 this.add(logout);

		 this.setPreferredSize(new Dimension(250,250));
		 this.setVisible(true);
	 }
	 
	 /* Funciones para organizar la disposicion de algunos componentes con respecto a este panel */
	 public void colocarNombreEjercicio() {
		 pestadisticas.putConstraint(SpringLayout.WEST, nombreEjercicio, 10, SpringLayout.EAST, jsgeneral);
		 pestadisticas.putConstraint(SpringLayout.NORTH, nombreEjercicio, 0, SpringLayout.NORTH, nombreAsignatura);
	 }
	 public void colocarJSEjercicio() {
		 pestadisticas.putConstraint(SpringLayout.WEST, jsejercicio, 0, SpringLayout.WEST, nombreEjercicio);
		 pestadisticas.putConstraint(SpringLayout.NORTH, jsejercicio, 10, SpringLayout.SOUTH, nombreEjercicio);
	 }
	public void colocarAtras2() {
		 pestadisticas.putConstraint(SpringLayout.WEST, atras2, 0, SpringLayout.WEST, jsejercicio);
		 pestadisticas.putConstraint(SpringLayout.NORTH, atras2, 10, SpringLayout.SOUTH, jsejercicio);
	}
	
	/* Setters de los diversos action listeners a utilizar en este panel */
	public void setControladorAtras(ActionListener c) {
		atras1.addActionListener(c);
	}
	
	public void setControladorAtras2(ActionListener c) {
		atras2.addActionListener(c);
	}
	
	/* Getters de diversos componentes que conforman el panel */
	public DefaultTableModel getDEjercicio() {
		return this.dejercicio;
	}
	
	public DefaultTableModel getDEjgeneral() {
		return this.dgeneral;
	}
	
	public JLabel getNombreEjercicio() {
		return this.nombreEjercicio;
	}
	
	public JScrollPane getJSEjercicio() {
		return this.jsejercicio;
	}
	
	public JButton getAtras1() {
		return this.atras1;
	}
	
	public JButton getAtras2() {
		return this.atras2;
	}
	
	public JButton getLogout() {
		return this.logout;
	}
		
	/**
	 * Forma la tabla que muestra las solicitudes pendientes a un profesor mediante una serie de
	 * restricciones y la pertienente inclusion del action listener que detecte su seleccion
	 * @param modelo : tabla dinamica
	 * @param c : table selection listener
	 */
	public void setTablaPendientes(DefaultTableModel modelo, CPEntrada c) {
		dgeneral = modelo;
		jtgeneral = new JTable(modelo);
		jtgeneral.setCellSelectionEnabled(true);
		this.cellSelectionModel = jtgeneral.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(c);
		jtgeneral.setAutoCreateRowSorter(true);
		jsgeneral = new JScrollPane(jtgeneral);
	}
}