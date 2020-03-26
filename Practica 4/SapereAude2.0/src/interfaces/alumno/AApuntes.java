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
 * Esta clase es la encargada de establecer la interfaz de la pagina de apuntes
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class AApuntes extends JPanel{

	/* Componentes del panel*/
	private JLabel info, titulo;
	private JTextArea contenido;
	private JScrollPane apuntescroll;
	private JTable tabledatos;
	private JButton logout, salir;
	
	/**
	 * Constructor de la clase
	 */
	public AApuntes() {
		SpringLayout aapuntes = new SpringLayout(); 
		this.setLayout(aapuntes);
		
		String[] titulos = {"Nombre", "Rol"};
		Object[][] filas = {
			 {"" , ""},
			};
		
		tabledatos = new JTable(filas,titulos){
			@Override
			 public boolean isCellEditable(int row, int col){
				 return false;
			 }
		 }; 
		tabledatos.setPreferredSize(new Dimension(300,16));
		
		info = new JLabel("Datos del usuario");
		titulo = new JLabel("");
		
		contenido = new JTextArea("Don Quijote de la Manchaa es una novela escrita por el español Miguel de Cervantes Saavedra. Publicada su primera parte con el título de El ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la obra más destacada de la literatura española y una de las principales de la literatura universal.1 2 En 1615 apareció su continuación con el título de Segunda parte del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se publicó dividido en cuatro partes; pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, quedó revocada de hecho la partición en cuatro secciones del volumen publicado diez años antes por Cervantes.\nDon Quijote de la Manchaa es una novela escrita por el español Miguel de Cervantes Saavedra. Publicada su primera parte con el título de El ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la obra más destacada de la literatura española y una de las principales de la literatura universal.1 2 En 1615 apareció su continuación con el título de Segunda parte del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se publicó dividido en cuatro partes; pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, quedó revocada de hecho la partición en cuatro secciones del volumen publicado diez años antes por Cervantes.\nDon Quijote de la Manchaa es una novela escrita por el español Miguel de Cervantes Saavedra. Publicada su primera parte con el título de El ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la obra más destacada de la literatura española y una de las principales de la literatura universal.1 2 En 1615 apareció su continuación con el título de Segunda parte del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se publicó dividido en cuatro partes; pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, quedó revocada de hecho la partición en cuatro secciones del volumen publicado diez años antes por Cervantes.\nDon Quijote de la Manchaa es una novela escrita por el español Miguel de Cervantes Saavedra. Publicada su primera parte con el título de El ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la obra más destacada de la literatura española y una de las principales de la literatura universal.1 2 En 1615 apareció su continuación con el título de Segunda parte del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se publicó dividido en cuatro partes; pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, quedó revocada de hecho la partición en cuatro secciones del volumen publicado diez años antes por Cervantes.\nDon Quijote de la Manchaa es una novela escrita por el español Miguel de Cervantes Saavedra. Publicada su primera parte con el título de El ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la obra más destacada de la literatura española y una de las principales de la literatura universal.1 2 En 1615 apareció su continuación con el título de Segunda parte del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se publicó dividido en cuatro partes; pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, quedó revocada de hecho la partición en cuatro secciones del volumen publicado diez años antes por Cervantes.\nDon Quijote de la Manchaa es una novela escrita por el español Miguel de Cervantes Saavedra. Publicada su primera parte con el título de El ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la obra más destacada de la literatura española y una de las principales de la literatura universal.1 2 En 1615 apareció su continuación con el título de Segunda parte del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se publicó dividido en cuatro partes; pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, quedó revocada de hecho la partición en cuatro secciones del volumen publicado diez años antes por Cervantes.\nDon Quijote de la Manchaa es una novela escrita por el español Miguel de Cervantes Saavedra. Publicada su primera parte con el título de El ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la obra más destacada de la literatura española y una de las principales de la literatura universal.1 2 En 1615 apareció su continuación con el título de Segunda parte del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se publicó dividido en cuatro partes; pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, quedó revocada de hecho la partición en cuatro secciones del volumen publicado diez años antes por Cervantes.\nDon Quijote de la Manchaa es una novela escrita por el español Miguel de Cervantes Saavedra. Publicada su primera parte con el título de El ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la obra más destacada de la literatura española y una de las principales de la literatura universal.1 2 En 1615 apareció su continuación con el título de Segunda parte del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se publicó dividido en cuatro partes; pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, quedó revocada de hecho la partición en cuatro secciones del volumen publicado diez años antes por Cervantes.\n\n");
		contenido.setEditable(false);
		apuntescroll = new JScrollPane(contenido);
		apuntescroll.setPreferredSize(new Dimension(600,300));

		logout = new JButton("Cerrar Sesion");
		salir = new JButton("Salir");
		
		aapuntes.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.WEST, this);
		aapuntes.putConstraint(SpringLayout.NORTH, info, 10, SpringLayout.NORTH, this);
		aapuntes.putConstraint(SpringLayout.WEST, tabledatos, 0, SpringLayout.WEST, info);
		aapuntes.putConstraint(SpringLayout.NORTH, tabledatos, 10, SpringLayout.SOUTH, info);
		aapuntes.putConstraint(SpringLayout.EAST, logout, -10, SpringLayout.EAST, this);
		aapuntes.putConstraint(SpringLayout.NORTH, logout, 10, SpringLayout.NORTH, this);
		aapuntes.putConstraint(SpringLayout.WEST, titulo, 0, SpringLayout.WEST, info);
		aapuntes.putConstraint(SpringLayout.NORTH, titulo, 20, SpringLayout.SOUTH, tabledatos);
		aapuntes.putConstraint(SpringLayout.WEST, apuntescroll, 0, SpringLayout.WEST, info);
		aapuntes.putConstraint(SpringLayout.NORTH, apuntescroll, 10, SpringLayout.SOUTH, titulo);
		aapuntes.putConstraint(SpringLayout.WEST, salir, 0, SpringLayout.WEST, info);
		aapuntes.putConstraint(SpringLayout.NORTH, salir, 10, SpringLayout.SOUTH, apuntescroll);

		this.add(info);
		this.add(tabledatos);
		this.add(logout);
		this.add(titulo);
		this.add(apuntescroll);
		this.add(salir);
		
		this.setPreferredSize(new Dimension(250,250));
		this.setVisible(true);
	}
	
	public void setControladorSalir(ActionListener c) {
		 salir.addActionListener(c);
	}
	
	public void setControladorLogout(ActionListener c) {
		 logout.addActionListener(c);
	}
	
	public JButton getSalir() {
		return this.salir;
	}
	
	public JButton getLogout() {
		return this.logout;
	}
	
	public JTextArea getContenido() {
		return this.contenido;
	}

	public JTable getTableDatos() {
		return tabledatos;
	}
	
	public JLabel getTitulo() {
		return titulo;
	}
}