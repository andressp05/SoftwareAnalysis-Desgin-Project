package interfaces.alumno;

import java.awt.Color;
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

import aplicacion.estadisticas.EjercicioAlumno;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import aplicacion.recursos.ejercicios.TipoRespuesta;

/**
 * Esta clase es la encargada de establecer la interfaz de la pagina de feedback sobre un ejercicio
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class Feedback extends JPanel {
	
	/* Componentes del panel */
	private JLabel info, nombreAsig, ra;
	private JTable tabledatos; 
	private DefaultTableModel datos;
	private JButton logout, salir;
	private SpringLayout feedback;
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
	
	/**
	 * Constructor de la clase
	 * @param eAlumno : ejercicio alumno del que se da feedback
	 */
	public Feedback(EjercicioAlumno eAlumno) {
		Ejercicio e = eAlumno.getEjercicio();
		
		feedback = new SpringLayout();
		this.setLayout(feedback);
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
		salir = new JButton("Salir");
		
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
				
				JLabel correccion = new JLabel("");
				JRadioButton siLocal = new JRadioButton("Si");
				JRadioButton noLocal = new JRadioButton("No");
				rsBG.add(new ButtonGroup());
				
				si.add(siLocal);
				no.add(noLocal);
				
				rsBG.get(rsBG.size() - 1).add(siLocal);
				rsBG.get(rsBG.size() - 1).add(noLocal);
				
				if (eAlumno.getPreguntaAlumnoPorPregunta(p).esCorrecta()) {
					correccion.setText("Bien");
					correccion.setForeground(Color.GREEN);
				}
				else {
					correccion.setText("Mal, la correcta es: " + p.getOpcionCorrecta().getTexto());
					correccion.setForeground(Color.RED);
				}
				
				pestanya.putConstraint(SpringLayout.WEST, siLocal, 10, SpringLayout.EAST, pregunta);
				pestanya.putConstraint(SpringLayout.NORTH, siLocal, 20, SpringLayout.SOUTH, pregunta);
				pestanya.putConstraint(SpringLayout.WEST, noLocal, 0, SpringLayout.WEST, siLocal);
				pestanya.putConstraint(SpringLayout.NORTH, noLocal, 10, SpringLayout.SOUTH, siLocal);
				pestanya.putConstraint(SpringLayout.WEST, correccion, 0, SpringLayout.WEST, noLocal);
				pestanya.putConstraint(SpringLayout.NORTH, correccion, 20, SpringLayout.SOUTH, noLocal);
				
				pestania.add(siLocal);
				pestania.add(noLocal);
				pestania.add(correccion);
				
			}
			else if (p.getTipoRespuesta().equals(TipoRespuesta.UNICA)) {
				ArrayList<JRadioButton> unicosLocal = new ArrayList<JRadioButton>();
				System.out.println("unica");
				ArrayList<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
				ruBG.add(new ButtonGroup());
				JLabel correccion = new JLabel("");
				int j = 0;
				
				for (Opcion o: p.getOpciones()) {
					JRadioButton opcion = new JRadioButton(o.getTexto());
					unicosLocal.add(opcion);
					radioButtons.add(opcion);
					ruBG.get(ruBG.size() - 1).add(opcion);
					
					if (eAlumno.getPreguntaAlumnoPorPregunta(p).esCorrecta()) {
						correccion.setText("Bien");
						correccion.setForeground(Color.GREEN);
					}
					else {
						correccion.setText("Mal, la correcta es: " + p.getOpcionCorrecta().getTexto());
						correccion.setForeground(Color.RED);
					}
					
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
				
				pestanya.putConstraint(SpringLayout.WEST, correccion, 0, SpringLayout.WEST, radioButtons.get(j-1));
				pestanya.putConstraint(SpringLayout.NORTH, correccion, 20, SpringLayout.SOUTH, radioButtons.get(j-1));
				
				unicos.add(unicosLocal);
				pestania.add(correccion);
			}
			
			else if (p.getTipoRespuesta().equals(TipoRespuesta.MULTIPLE)) {
				System.out.println("multiple");
				ArrayList<JCheckBox> multipleslocal = new ArrayList<JCheckBox>();
				ArrayList<JCheckBox> casillas = new ArrayList<JCheckBox>(); 
				JLabel correccion = new JLabel("");
				
				int j = 0;
				for (Opcion o: p.getOpciones()) {
					JCheckBox opcion = new JCheckBox(o.getTexto());
					multipleslocal.add(opcion);
					casillas.add(opcion);
					
					if (eAlumno.getPreguntaAlumnoPorPregunta(p).esCorrecta()) {
						correccion.setText("Bien");
						correccion.setForeground(Color.GREEN);
					}
					else {
						String str = "Mal, las opciones correctas son: ";
						
						for (Opcion op: p.getOpcionesCorrecta()) {
							str = str.concat("\n\t" + op.getTexto());
						}
						correccion.setText(str);
						correccion.setForeground(Color.RED);
					}
					
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
				
				pestanya.putConstraint(SpringLayout.WEST, correccion, 0, SpringLayout.WEST, casillas.get(j-1));
				pestanya.putConstraint(SpringLayout.NORTH, correccion, 20, SpringLayout.SOUTH, casillas.get(j-1));
				
				multiples.add(multipleslocal);
				pestania.add(correccion);			}
			
			else if (p.getTipoRespuesta().equals(TipoRespuesta.ABIERTA)) {
				System.out.println("abierta");
				ra = new JLabel("Respuesta:");
				JTextField respuesta = new JTextField(20);
				abiertas.add(respuesta);
				JLabel correccion = new JLabel("");
		
				if (eAlumno.getPreguntaAlumnoPorPregunta(p).esCorrecta()) {
					correccion.setText("Bien");
					correccion.setForeground(Color.GREEN);
				}
				else {
					String str = "Mal, las opciones admitidas son: ";
					
					for (Opcion op: p.getOpcionesCorrecta()) {
						str = str.concat("\n\t" + op.getTexto());
					}
					correccion.setText(str);
					correccion.setForeground(Color.RED);
				}
				
				pestanya.putConstraint(SpringLayout.WEST, ra, 10, SpringLayout.EAST, pregunta);
				pestanya.putConstraint(SpringLayout.NORTH, ra, 20, SpringLayout.SOUTH, pregunta);
				pestanya.putConstraint(SpringLayout.WEST, respuesta, 5, SpringLayout.EAST, ra);
				pestanya.putConstraint(SpringLayout.NORTH, respuesta, 0, SpringLayout.SOUTH, ra);
				pestanya.putConstraint(SpringLayout.WEST, correccion, 0, SpringLayout.WEST, respuesta);
				pestanya.putConstraint(SpringLayout.NORTH, correccion, 20, SpringLayout.SOUTH, respuesta);
				
				pestania.add(ra);
				pestania.add(respuesta);
				pestania.add(correccion);
				
			}
			System.out.println("Iteracion: " + Integer.toString(i));
			pestanias.addTab(Integer.toString(i), pestania);
			System.out.println("Iteracion: " + Integer.toString(i));
			pestania.add(pregunta);
			i++;
		}
		
		pestanias.setPreferredSize(new Dimension(700,400));
		
		/* Panel Externo */
		feedback.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.WEST, this);
		feedback.putConstraint(SpringLayout.NORTH, info, 10, SpringLayout.NORTH, this);
		feedback.putConstraint(SpringLayout.WEST, tabledatos, 0, SpringLayout.WEST, info);
		feedback.putConstraint(SpringLayout.NORTH, tabledatos, 10, SpringLayout.SOUTH, info);
		feedback.putConstraint(SpringLayout.WEST, nombreAsig, 0, SpringLayout.WEST, info);
		feedback.putConstraint(SpringLayout.NORTH, nombreAsig, 20, SpringLayout.SOUTH, tabledatos);
		feedback.putConstraint(SpringLayout.EAST, logout, -10, SpringLayout.EAST, this);
		feedback.putConstraint(SpringLayout.NORTH, logout, 10, SpringLayout.NORTH, this);
		feedback.putConstraint(SpringLayout.WEST, pestanias, 0, SpringLayout.WEST, info);
		feedback.putConstraint(SpringLayout.NORTH, pestanias, 20, SpringLayout.SOUTH, nombreAsig);
		feedback.putConstraint(SpringLayout.HORIZONTAL_CENTER, salir, 0, SpringLayout.HORIZONTAL_CENTER, pestanias);
		feedback.putConstraint(SpringLayout.NORTH, salir, 20, SpringLayout.SOUTH, pestanias);
		
		this.add(info);
		this.add(tabledatos);
		this.add(nombreAsig);
		this.add(logout);
		this.add(pestanias);
		this.add(salir);
	}
	
	public void setControladorSalir(ActionListener c){
		salir.addActionListener(c);
	}
	
	public void setControladorLogout(ActionListener c) {
		logout.addActionListener(c);
	}
	
	public JTable getTableDatos() {
		return this.tabledatos;
	}
	
	public JButton getSalir() {
		return this.salir;
	}
	
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
	
	public JButton getLogout() {
		return this.logout;
	}
}

