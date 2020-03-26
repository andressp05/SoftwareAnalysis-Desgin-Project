package interfaces.alumno;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

/**
 * Esta clase es la encargada de establecer la interfaz de la pagina de entrada a un ejercicio
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class EntradaEjercicio extends JPanel {

	/* Componentes del panel */
	private JLabel info, titulo, estado;
	private JTextArea contenido;
	private JScrollPane contenidoscroll;
	private JTable tabledatos;
	private JButton logout, salir, comenzar;
	
	/**
	 * Constructor de la clase
	 */
	public EntradaEjercicio(){
		SpringLayout aentradaejercicio = new SpringLayout(); 
		this.setLayout(aentradaejercicio);
		
		String[] titulos = {"Nombre", "Rol"};
		Object[][] filas = {
				 {"" , ""},
				};
		
		tabledatos = new JTable(filas,titulos);
		tabledatos.setPreferredSize(new Dimension(300,16));
		
		info = new JLabel("Datos del usuario");
		titulo = new JLabel("Comentarios y fechas del ejercicio");
		estado = new JLabel("");
		
		contenido = new JTextArea("");
		contenido.setEditable(false);
		contenidoscroll = new JScrollPane(contenido);
		contenidoscroll.setPreferredSize(new Dimension(600,300));

		logout = new JButton("Cerrar Sesion");
		salir = new JButton("Salir");
		comenzar = new JButton("Acceder Ejercicio");
		
		aentradaejercicio.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.WEST, this);
		aentradaejercicio.putConstraint(SpringLayout.NORTH, info, 10, SpringLayout.NORTH, this);
		aentradaejercicio.putConstraint(SpringLayout.WEST, tabledatos, 0, SpringLayout.WEST, info);
		aentradaejercicio.putConstraint(SpringLayout.NORTH, tabledatos, 10, SpringLayout.SOUTH, info);
		aentradaejercicio.putConstraint(SpringLayout.EAST, logout, -10, SpringLayout.EAST, this);
		aentradaejercicio.putConstraint(SpringLayout.NORTH, logout, 10, SpringLayout.NORTH, this);
		aentradaejercicio.putConstraint(SpringLayout.WEST, titulo, 0, SpringLayout.WEST, info);
		aentradaejercicio.putConstraint(SpringLayout.NORTH, titulo, 20, SpringLayout.SOUTH, tabledatos);
		aentradaejercicio.putConstraint(SpringLayout.EAST, estado, 0, SpringLayout.EAST, contenidoscroll);
		aentradaejercicio.putConstraint(SpringLayout.NORTH, estado, 0, SpringLayout.NORTH, titulo);
		aentradaejercicio.putConstraint(SpringLayout.WEST, contenidoscroll, 0, SpringLayout.WEST, info);
		aentradaejercicio.putConstraint(SpringLayout.NORTH, contenidoscroll, 10, SpringLayout.SOUTH, titulo);
		aentradaejercicio.putConstraint(SpringLayout.WEST, salir, 0, SpringLayout.WEST, info);
		aentradaejercicio.putConstraint(SpringLayout.NORTH, salir, 10, SpringLayout.SOUTH, contenidoscroll);
		aentradaejercicio.putConstraint(SpringLayout.EAST, comenzar, 0, SpringLayout.EAST, contenidoscroll);
		aentradaejercicio.putConstraint(SpringLayout.NORTH, comenzar, 0, SpringLayout.NORTH, salir);

		this.add(info);
		this.add(tabledatos);
		this.add(logout);
		this.add(titulo);
		this.add(estado);
		this.add(contenidoscroll);
		this.add(salir);
		this.add(comenzar);
		
		this.setPreferredSize(new Dimension(250,250));
		this.setVisible(true);
	}
	
	public void setControladorLogout(ActionListener c){
		logout.addActionListener(c);
	}
	
	public void setControladorComenzar(ActionListener c){
		comenzar.addActionListener(c);
	}
	
	public void setControladorSalir(ActionListener c){
		salir.addActionListener(c);
	}
	
	public JButton getLogout() {
		return this.logout;
	}
	
	public JButton getComenzar() {
		return this.comenzar;
	}
	
	public JButton getSalir() {
		return this.salir;
	}
	
	public JTable getTableDatos() {
		return tabledatos;
	}
	
	public JLabel getEstado() {
		return estado;
	}
	
	public JTextArea getContenido() {
		return contenido;
	}
	
	
	
}
