package interfaces;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * Esta clase es la encargada de establecer la interfaz de la pagina de inicio; es decir el login
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class Inicio extends JPanel {
	 /* Listado de componentes que constituyen este panel */
	 private JLabel nombre, pswd;
	 private JTextField numa;
	 private JPasswordField password;
	 private JButton entrar;
	 
	 /**
	  * Constructor de la clase
	  */
	 public Inicio() {
		 SpringLayout inicio = new SpringLayout(); 
		 this.setLayout(inicio);
		 
		 /* Inicializacion de los componentes */
		 nombre = new JLabel("Usuario (numa): ");
		 numa = new JTextField(15);
		 pswd = new JLabel("Contrasenya: ");
		 password = new JPasswordField(15);
		 entrar = new JButton("Entrar");
		 
		 /* Restricciones del layout */
		 inicio.putConstraint(SpringLayout.WEST, nombre, 5, SpringLayout.WEST, this);
	 	 inicio.putConstraint(SpringLayout.NORTH, nombre, 5, SpringLayout.NORTH, this);
		 inicio.putConstraint(SpringLayout.WEST, numa, 35, SpringLayout.EAST, nombre);
		 inicio.putConstraint(SpringLayout.NORTH, numa, 5, SpringLayout.NORTH, this);
		 inicio.putConstraint(SpringLayout.WEST, pswd, 0, SpringLayout.WEST, nombre);
		 inicio.putConstraint(SpringLayout.NORTH, pswd, 8, SpringLayout.SOUTH, nombre);
		 inicio.putConstraint(SpringLayout.WEST, password, 0, SpringLayout.WEST, numa);
		 inicio.putConstraint(SpringLayout.NORTH, password, 5, SpringLayout.SOUTH, numa);
		 inicio.putConstraint(SpringLayout.WEST, entrar, 0, SpringLayout.WEST, numa);
		 inicio.putConstraint(SpringLayout.NORTH, entrar, 10, SpringLayout.SOUTH, pswd);
		 
		 /* Adicion al panel */
		 this.add(nombre); 
		 this.add(numa);
		 this.add(pswd);
		 this.add(password);
		 this.add(entrar);
		 
		 this.setPreferredSize(new Dimension(300,10));
		 this.setVisible(true);
	 }
	 
	 
	 /* Getters de ciertos componentes del panel */
	 public JTextField getNuma(){
		 return numa;
	 }
	 
	 public JPasswordField getPassword(){
		 return password;
	 }
	 
	 public JButton getEntrar(){
		 return entrar;
	 }
	 
}
