package interfaces;

import javax.swing.JFrame;

import controladores.CInicio;

/**
 * Esta es la clase principal de la interfaz, la cual engloba el jframe principal que llama 
 * al resto de paneles que conforman la interfaz de nuestra aplicacion
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class SapereAude extends JFrame {

	/** Instancia de la clase */
	private static SapereAude instance = null;
	
	/** Vista correspondiente al inicio de la aplicacion (login) */
	private static Inicio inicio = new Inicio();
	
	/** Controlador correspondiendte al inicio de la aplicacion (login) */
	private static CInicio cinicio = new CInicio(inicio);
	
	/**
	 * Constructor de la clase (patron singleton)
	 */
	private SapereAude() {
		super("Sapere Aude");
		
		inicio.getEntrar().addActionListener(cinicio);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(inicio);
		inicio.setVisible(true);
		this.setSize(350, 150);
	}
	
	/**
	 * Obtiene la instancia de la clase principal de la apliacaion (Sapere Aude)
	 * al tratarse de un singleton. Si no existe llama al constructor
	 * @return unica instancia de sapere aude
	 */
	public static SapereAude getInstance() {
		if (instance == null) {
			instance = new SapereAude();
		}
		return instance;
	}
	
	/**
	 * Funcion principal del sistema
	 * @param args : nada
	 */
	public static void main(String[] args) {
		SapereAude s = new SapereAude();
		s.setVisible(true);
	}
	
}
