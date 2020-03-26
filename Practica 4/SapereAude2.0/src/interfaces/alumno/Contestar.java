package interfaces.alumno;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import aplicacion.recursos.ejercicios.TipoRespuesta;


/**
 * Esta clase es la encargada de establecer la interfaz de la pagina de contestar un ejercicio
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class Contestar extends JPanel {
	
	/* Componentes del panel */
	private JLabel info, nombreAsig, ra;
	private JTable tabledatos; 
	private DefaultTableModel datos;
	private JButton logout, descartar, enviar;
	private SpringLayout contestar;
	private JTabbedPane pestanias;
	private ArrayList<SpringLayout> pestanyasSL;
	private ArrayList<JPanel> pestanyasJP;
	private ArrayList<JLabel> preguntasJL;
	private ArrayList<ButtonGroup> rsBG;
	private ArrayList<ButtonGroup> ruBG;
	
	private ArrayList<JRadioButton> si;
	private ArrayList<JRadioButton> no;
	private ArrayList<ArrayList<JRadioButton>> unicos;
	private ArrayList<JTextField> abiertas;
	private ArrayList<ArrayList<JCheckBox>> multiples;
	
	public ArrayList<ButtonGroup> getRsBG() {
		return this.rsBG;
	}
	
	public ArrayList<ButtonGroup> getRuBG() {
		return this.ruBG;
	}
	
	public ArrayList<JRadioButton> getSi() {
		return si;
	}
	public ArrayList<JRadioButton> getNo() {
		return no;
	}
	
	public ArrayList<ArrayList<JRadioButton>> getUnicos() {
		return unicos;
	}
	
	public ArrayList<JTextField> getAbiertas() {
		return abiertas;
	}
	
	public ArrayList<ArrayList<JCheckBox>> getMultiples() {
		return multiples;
	}
	
//	public boolean isBGselected(ButtonGroup grupo, Pregunta pregunta) {
//		int num = pregunta.getOpciones().size();
//		
//		for (int i = 0; )
//		
//	}
	
	/**
	 * Constructor de la clase
	 * @param e : ejercicio a contestar
	 */
	public Contestar(Ejercicio e) {
		contestar = new SpringLayout();
		this.setLayout(contestar);
		pestanyasSL = new ArrayList<SpringLayout>();
		pestanyasJP = new ArrayList<JPanel>();
		preguntasJL = new ArrayList<JLabel>();
		rsBG = new ArrayList<ButtonGroup>();
		ruBG = new ArrayList<ButtonGroup>();
		unicos = new ArrayList<ArrayList<JRadioButton>>();
		abiertas = new ArrayList<JTextField>();
		multiples = new ArrayList<ArrayList<JCheckBox>>();
		
		si = new ArrayList<JRadioButton>();
		no = new ArrayList<JRadioButton>();
		
		/* Inicializacion de los diversos componentes del panel */
		String[] titulos = {"Nombre", "Rol"};
		Object[][] filas = {
			 {"" , ""},
			};
		
		info = new JLabel("Datos del usuario");
		
		datos = new DefaultTableModel(filas,titulos);
		tabledatos = new JTable(datos);
		
		nombreAsig = new JLabel(e.getAsignatura().getNombre());
		
		logout = new JButton("Cerrar Sesion");
		descartar = new JButton("Descartar Intento");
		enviar = new JButton("Finalizar");
		
		pestanias = new JTabbedPane();
		
		int i = 0;
		
		for (Pregunta p: e.getPreguntas()) {
			System.out.println(p.getNumero() + p.getEnunciado());
		}
		
		for (Pregunta p: e.getPreguntas()) {
			pestanyasSL.add(new SpringLayout());
			pestanyasJP.add(new JPanel());
			preguntasJL.add(new JLabel(p.getEnunciado()));
			
			pestanyasJP.get(i).setLayout(pestanyasSL.get(i));
			SpringLayout pestanya = pestanyasSL.get(i);
			JLabel pregunta = preguntasJL.get(i);
			JPanel pestania = pestanyasJP.get(i);
			
			pestanya.putConstraint(SpringLayout.WEST, pregunta, 10, SpringLayout.WEST, pestania);
			pestanya.putConstraint(SpringLayout.NORTH, pregunta, 10, SpringLayout.NORTH, pestania);
			
			
			if (p.getTipoRespuesta().equals(TipoRespuesta.SIMPLE)) {
				System.out.println("simple");
				
				JRadioButton siLocal = new JRadioButton("Si");
				JRadioButton noLocal = new JRadioButton("No");
				rsBG.add(new ButtonGroup());
				
				si.add(siLocal);
				no.add(noLocal);
				
				rsBG.get(rsBG.size() - 1).add(siLocal);
				rsBG.get(rsBG.size() - 1).add(noLocal);
				
				pestanya.putConstraint(SpringLayout.WEST, siLocal, 10, SpringLayout.EAST, pregunta);
				pestanya.putConstraint(SpringLayout.NORTH, siLocal, 20, SpringLayout.SOUTH, pregunta);
				pestanya.putConstraint(SpringLayout.WEST, noLocal, 0, SpringLayout.WEST, siLocal);
				pestanya.putConstraint(SpringLayout.NORTH, noLocal, 10, SpringLayout.SOUTH, siLocal);
				
				pestania.add(siLocal);
				pestania.add(noLocal);
			}
			else if (p.getTipoRespuesta().equals(TipoRespuesta.UNICA)) {
				ArrayList<JRadioButton> unicosLocal = new ArrayList<JRadioButton>();
				System.out.println("unica");
				ArrayList<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
				ruBG.add(new ButtonGroup());
				int j = 0;
				for (Opcion o: p.getOpciones()) {
					JRadioButton opcion = new JRadioButton(o.getTexto());
					unicosLocal.add(opcion);
					radioButtons.add(opcion);
					ruBG.get(ruBG.size() - 1).add(opcion);
					
					if (j == 0) {
						pestanya.putConstraint(SpringLayout.WEST, radioButtons.get(j), 10, SpringLayout.EAST, pregunta);
						pestanya.putConstraint(SpringLayout.NORTH, radioButtons.get(j), 20, SpringLayout.SOUTH, pregunta);
					}
					else {
						pestanya.putConstraint(SpringLayout.WEST, radioButtons.get(j), 0, SpringLayout.WEST, radioButtons.get(j - 1));
						pestanya.putConstraint(SpringLayout.NORTH, radioButtons.get(j), 10, SpringLayout.SOUTH, radioButtons.get(j - 1));
					}
					
					pestania.add(radioButtons.get(j));
					j++;
				}
				unicos.add(unicosLocal);
			}
			
			else if (p.getTipoRespuesta().equals(TipoRespuesta.MULTIPLE)) {
				System.out.println("multiple");
				ArrayList<JCheckBox> multipleslocal = new ArrayList<JCheckBox>();
				ArrayList<JCheckBox> casillas = new ArrayList<JCheckBox>(); 
				
				int j = 0;
				for (Opcion o: p.getOpciones()) {
					JCheckBox opcion = new JCheckBox(o.getTexto());
					multipleslocal.add(opcion);
					casillas.add(opcion);
					
					if (j == 0) {
						pestanya.putConstraint(SpringLayout.WEST, casillas.get(j), 10, SpringLayout.EAST, pregunta);
						pestanya.putConstraint(SpringLayout.NORTH, casillas.get(j), 20, SpringLayout.SOUTH, pregunta);
					}
					else {
						pestanya.putConstraint(SpringLayout.WEST, casillas.get(j), 0, SpringLayout.WEST, casillas.get(j - 1));
						pestanya.putConstraint(SpringLayout.NORTH, casillas.get(j), 10, SpringLayout.SOUTH, casillas.get(j - 1));
					}
					
					pestania.add(casillas.get(j));
					j++;
				}
				multiples.add(multipleslocal);
			}
			
			else if (p.getTipoRespuesta().equals(TipoRespuesta.ABIERTA)) {
				System.out.println("abierta");
				ra = new JLabel("Respuesta:");
				JTextField respuesta = new JTextField(20);
				abiertas.add(respuesta);
				
				pestanya.putConstraint(SpringLayout.WEST, ra, 10, SpringLayout.EAST, pregunta);
				pestanya.putConstraint(SpringLayout.NORTH, ra, 20, SpringLayout.SOUTH, pregunta);
				pestanya.putConstraint(SpringLayout.WEST, respuesta, 5, SpringLayout.EAST, ra);
				pestanya.putConstraint(SpringLayout.NORTH, respuesta, 0, SpringLayout.SOUTH, ra);
				
				pestania.add(ra);
				pestania.add(respuesta);
		
			}
			System.out.println("Iteracion: " + Integer.toString(i));
			pestanias.addTab(Integer.toString(i), pestania);
			System.out.println("Iteracion: " + Integer.toString(i));
			pestania.add(pregunta);
			i++;
		}
		
		pestanias.setPreferredSize(new Dimension(700,400));
		
		/* Panel Externo */
		contestar.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.WEST, this);
		contestar.putConstraint(SpringLayout.NORTH, info, 10, SpringLayout.NORTH, this);
		contestar.putConstraint(SpringLayout.WEST, tabledatos, 0, SpringLayout.WEST, info);
		contestar.putConstraint(SpringLayout.NORTH, tabledatos, 10, SpringLayout.SOUTH, info);
		contestar.putConstraint(SpringLayout.WEST, nombreAsig, 0, SpringLayout.WEST, info);
		contestar.putConstraint(SpringLayout.NORTH, nombreAsig, 20, SpringLayout.SOUTH, tabledatos);
		contestar.putConstraint(SpringLayout.EAST, logout, -10, SpringLayout.EAST, this);
		contestar.putConstraint(SpringLayout.NORTH, logout, 10, SpringLayout.NORTH, this);
		contestar.putConstraint(SpringLayout.WEST, pestanias, 0, SpringLayout.WEST, info);
		contestar.putConstraint(SpringLayout.NORTH, pestanias, 20, SpringLayout.SOUTH, nombreAsig);
		contestar.putConstraint(SpringLayout.WEST, descartar, 0, SpringLayout.WEST, pestanias);
		contestar.putConstraint(SpringLayout.NORTH, descartar, 20, SpringLayout.SOUTH, pestanias);
		contestar.putConstraint(SpringLayout.EAST, enviar, 0, SpringLayout.EAST, pestanias);
		contestar.putConstraint(SpringLayout.NORTH, enviar, 0, SpringLayout.NORTH, descartar);
		
		this.add(info);
		this.add(tabledatos);
		this.add(nombreAsig);
		this.add(logout);
		this.add(pestanias);
		this.add(descartar);
		this.add(enviar);
	}
	
	public void setControladorDescartar(ActionListener c){
		descartar.addActionListener(c);
	}
	
	public void setControladorLogout(ActionListener c) {
		logout.addActionListener(c);
	}
	
	public void setControladorEnviar(ActionListener c) {
		enviar.addActionListener(c);
	}
	
	public JTable getTableDatos() {
		return this.tabledatos;
	}
	
	public JButton getDescartar() {
		return this.descartar;
	}
	
	public JButton getLogout() {
		return this.logout;
	}
	
	public JButton getEnviar(){
		return this.enviar;
	}
}
