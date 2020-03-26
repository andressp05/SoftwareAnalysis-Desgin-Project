package interfaces.profesor;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * Esta clase es la encargada de construir la interfaz que representa el panel de creacion
 * de ejercicios por parte de un profesor
 * @author Andres y Francisco
 */
@SuppressWarnings("serial")
public class PCreacion extends JPanel {

	/* Declaracion de los distintos componentes del panel */
	private JTable tabledatos;
	private JLabel info, nombreAsig, tipoMaterial, ltitulo, fini, ffin, ponderacion, aleat, normas;
	private JLabel ejercicio, numero, peso, tipopregunta, pregunta, correcta, lpenalizacion;
	private JLabel lopcion,lnumop;
	private JTextField topcion,tnumop;
	private JTextArea apuntes, tnormas, tpregunta;
	private JScrollPane apuntescroll;
	@SuppressWarnings("rawtypes")
	private JComboBox jtipo, ttipo;
	private JTextField ttitulo, tfini, tffin, tponderacion;
	private JTextField tnumero, tpeso, tpenalizacion;
	private JButton atras1, atras2, atras3;
	private JButton guardar1, guardar2;
	private JButton anyadir1, anyadir2, anyadir3, anyadir4;
	private JButton logout, finalizar;
	private JButton anyadiroc, anyadirof;
	private ButtonGroup taleat, rc;
	private JRadioButton opcion1, opcion2, rcsi, rcno;
	private SpringLayout pcreacion;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PCreacion() {
		pcreacion = new SpringLayout(); 
		this.setLayout(pcreacion); 
		
		/* Inicializacion de los diversos componentes del panel */
		String[] titulos = {"Nombre", "Rol"};
		Object[][] filas = {
				{"Profesorado" , "Profesor"},
				};
		
		String[] tipos = {"Subtema", "Apuntes", "Ejercicio"};
		
		String[] tipos2 = {"Respuesta Simple", "Respuesta Multiple", "Respuesta Unica", "Respuesta Abierta"};
		
		info = new JLabel("Datos del usuario");
		 
		tabledatos = new JTable(filas,titulos){
			@Override
			 public boolean isCellEditable(int row, int col){
				 return false;
			 }
		 }; 
		tabledatos.setPreferredSize(new Dimension(300,16));
	
		nombreAsig = new JLabel("<Insertar nombre asig>");
		tipoMaterial = new JLabel("Tipo Material");
		
		jtipo = new JComboBox(tipos);
	
		logout = new JButton("Cerrar Sesion");
		 
		/* Para subtema, apuntes y ejercicio */
		ltitulo = new JLabel("Titulo");
		ttitulo = new JTextField(20);
		guardar1 = new JButton("Guardar");
		guardar2 = new JButton("Guardar");
		atras1 = new JButton("Salir");
		atras2 = new JButton("Salir");
		atras3 = new JButton("Salir");
		
		/* Para apuntes */
		apuntes = new JTextArea("");
		apuntescroll = new JScrollPane(apuntes);
		apuntescroll.setPreferredSize(new Dimension(400,400));
		
		/* Para Ejercicio */
		fini = new JLabel("Fecha Inicio (anyo-mes-dia)");
		ffin = new JLabel("Fecha Fin (anyo-mes-dia)");
		ponderacion = new JLabel("Ponderacion Total)");
		aleat = new JLabel("Orden Preguntas Aleatorio");
		normas = new JLabel("Normas y Criterios de Correcion");
		tfini =  new JTextField(10);
		tffin = new JTextField(10);
		tponderacion = new JTextField(2);
		opcion1 = new JRadioButton("Si");
		opcion2 = new JRadioButton("No");
		opcion2.setSelected(true);
		taleat = new ButtonGroup();
		taleat.add(opcion1);
		taleat.add(opcion2);
		tnormas = new JTextArea();
		tnormas.setPreferredSize(new Dimension(400,300));
		
		ejercicio = new JLabel("EJERCICIO");
		numero = new JLabel("Numero Pregunta");
		peso = new JLabel("Peso");
		tipopregunta = new JLabel("Tipo de Pregunta");
		pregunta = new JLabel("Enunciado");
		correcta = new JLabel("Respuesta Correcta");
		tnumero = new JTextField(3);
		tpeso = new JTextField(3);
		ttipo = new JComboBox(tipos2);
		tpregunta = new JTextArea();
		tpregunta.setPreferredSize(new Dimension(250,50));
		finalizar = new JButton("Finalizar creacion");
		anyadir1 = new JButton("Anyadir Pregunta");
		anyadir2 = new JButton("Anyadir Pregunta");
		anyadir3 = new JButton("Anyadir Pregunta");
		anyadir4 = new JButton("Anyadir Pregunta");
		
		//Respuesta Simple
		rcno = new JRadioButton("No");
		rcsi = new JRadioButton("Si");
		rcno.setSelected(true);
		rc = new ButtonGroup();
		rc.add(rcno);
		rc.add(rcsi);
		
		//Respuesta Unica, Multiple y Abierta
		lopcion = new JLabel("Opcion");
		topcion = new JTextField(20);
		lnumop = new JLabel("Numero Opcion");
		tnumop = new JTextField(5);
		anyadiroc = new JButton("Anyadir Opcion Correcta");
		anyadirof = new JButton("Anyadir Opcion Erronea  ");
		lpenalizacion = new JLabel("Penalizacion(+)");
		tpenalizacion = new JTextField(5);
		
		/* Restricciones del layout */
		
		/*generales*/
		pcreacion.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.WEST, this);
		pcreacion.putConstraint(SpringLayout.NORTH, info, 10, SpringLayout.NORTH, this);
		pcreacion.putConstraint(SpringLayout.WEST, tabledatos, 0, SpringLayout.WEST, info);
		pcreacion.putConstraint(SpringLayout.NORTH, tabledatos, 10, SpringLayout.SOUTH, info);
		pcreacion.putConstraint(SpringLayout.WEST, nombreAsig, 0, SpringLayout.WEST, info);
		pcreacion.putConstraint(SpringLayout.NORTH, nombreAsig, 20, SpringLayout.SOUTH, tabledatos);
		pcreacion.putConstraint(SpringLayout.WEST, tipoMaterial, 0, SpringLayout.WEST, info);
		pcreacion.putConstraint(SpringLayout.NORTH, tipoMaterial, 20, SpringLayout.SOUTH, nombreAsig);
		pcreacion.putConstraint(SpringLayout.NORTH, jtipo, 0, SpringLayout.NORTH, tipoMaterial);
		pcreacion.putConstraint(SpringLayout.WEST, jtipo, 10, SpringLayout.EAST, tipoMaterial);
		pcreacion.putConstraint(SpringLayout.EAST, logout, -10, SpringLayout.EAST, this);
		pcreacion.putConstraint(SpringLayout.NORTH, logout, 10, SpringLayout.NORTH, this);
		
		/*para subtema */
		pcreacion.putConstraint(SpringLayout.NORTH, ltitulo, 10, SpringLayout.SOUTH, jtipo);
		pcreacion.putConstraint(SpringLayout.WEST, ltitulo, 0, SpringLayout.WEST, tipoMaterial);
		pcreacion.putConstraint(SpringLayout.NORTH, ttitulo, 0, SpringLayout.NORTH, ltitulo);
		pcreacion.putConstraint(SpringLayout.WEST, ttitulo, 0, SpringLayout.WEST, jtipo);
		pcreacion.putConstraint(SpringLayout.NORTH, guardar1, 10, SpringLayout.SOUTH, ltitulo);
		pcreacion.putConstraint(SpringLayout.WEST, guardar1, 0, SpringLayout.EAST, ltitulo);
		pcreacion.putConstraint(SpringLayout.NORTH, atras1, 0, SpringLayout.NORTH, guardar1);
		pcreacion.putConstraint(SpringLayout.WEST, atras1, 10, SpringLayout.EAST, guardar1);
		
		
		/* para apuntes */
		pcreacion.putConstraint(SpringLayout.NORTH, ltitulo, 10, SpringLayout.SOUTH, jtipo);
		pcreacion.putConstraint(SpringLayout.WEST, ltitulo, 0, SpringLayout.WEST, tipoMaterial);
		pcreacion.putConstraint(SpringLayout.NORTH, ttitulo, 0, SpringLayout.NORTH, ltitulo);
		pcreacion.putConstraint(SpringLayout.WEST, ttitulo, 0, SpringLayout.WEST, jtipo);
		pcreacion.putConstraint(SpringLayout.NORTH, guardar2, 10, SpringLayout.SOUTH, ltitulo);
		pcreacion.putConstraint(SpringLayout.WEST, guardar2, 0, SpringLayout.EAST, ltitulo);
		pcreacion.putConstraint(SpringLayout.NORTH, apuntescroll, 0, SpringLayout.NORTH, ttitulo);
		pcreacion.putConstraint(SpringLayout.WEST, apuntescroll, 20, SpringLayout.EAST, ttitulo);
		pcreacion.putConstraint(SpringLayout.NORTH, atras2, 0, SpringLayout.NORTH, guardar2);
		pcreacion.putConstraint(SpringLayout.WEST, atras2, 10, SpringLayout.EAST, guardar2);
		
		/* para ejercicio */
		pcreacion.putConstraint(SpringLayout.NORTH, ltitulo, 10, SpringLayout.SOUTH, jtipo);
		pcreacion.putConstraint(SpringLayout.WEST, ltitulo, 0, SpringLayout.WEST, tipoMaterial);
		pcreacion.putConstraint(SpringLayout.NORTH, ttitulo, 0, SpringLayout.NORTH, ltitulo);
		pcreacion.putConstraint(SpringLayout.WEST, ttitulo, 0, SpringLayout.WEST, jtipo);
		
		
		/* Respuesta Simple por defecto */
		pcreacion.putConstraint(SpringLayout.NORTH, rcno, 0, SpringLayout.NORTH, correcta);
		pcreacion.putConstraint(SpringLayout.WEST, rcno, 5, SpringLayout.EAST, correcta);
		pcreacion.putConstraint(SpringLayout.NORTH, rcsi, 0, SpringLayout.NORTH, correcta);
		pcreacion.putConstraint(SpringLayout.WEST, rcsi, 5, SpringLayout.EAST, rcno);
		pcreacion.putConstraint(SpringLayout.NORTH, lpenalizacion, 10, SpringLayout.SOUTH, correcta);
		pcreacion.putConstraint(SpringLayout.WEST, lpenalizacion, 0, SpringLayout.WEST, correcta);
		pcreacion.putConstraint(SpringLayout.NORTH, tpenalizacion, 0, SpringLayout.NORTH, lpenalizacion);
		pcreacion.putConstraint(SpringLayout.WEST, tpenalizacion, 5, SpringLayout.EAST, lpenalizacion);
		pcreacion.putConstraint(SpringLayout.NORTH, anyadir1, 10, SpringLayout.SOUTH, lpenalizacion);
		pcreacion.putConstraint(SpringLayout.WEST, anyadir1, 5, SpringLayout.WEST, correcta);
		pcreacion.putConstraint(SpringLayout.NORTH, finalizar, 0, SpringLayout.NORTH, anyadir1);
		pcreacion.putConstraint(SpringLayout.WEST, finalizar, 5, SpringLayout.EAST, anyadir1);
		pcreacion.putConstraint(SpringLayout.NORTH, atras3, 10, SpringLayout.SOUTH, anyadir1);
		pcreacion.putConstraint(SpringLayout.WEST, atras3, 0, SpringLayout.EAST, anyadir1);

		
		/* Adicion de ciertos componentes al panel */
		this.add(info);
		this.add(tabledatos);
		this.add(nombreAsig);
		this.add(tipoMaterial);
		this.add(jtipo);
		this.add(logout);
		this.add(ltitulo);
		this.add(ttitulo);
		this.add(guardar1);
		this.add(atras1);
		this.setPreferredSize(new Dimension(250,250));
		this.setVisible(true);
	}
		
	/* Funciones para organizar la disposicion de algunos componentes con respecto a este panel */
	public void colocarLTitulo() {
		pcreacion.putConstraint(SpringLayout.NORTH, ltitulo, 10, SpringLayout.SOUTH, jtipo);
		pcreacion.putConstraint(SpringLayout.WEST, ltitulo, 0, SpringLayout.WEST, tipoMaterial);
	}
	
	public void colocarTTitulo() {
		pcreacion.putConstraint(SpringLayout.NORTH, ttitulo, 0, SpringLayout.NORTH, ltitulo);
		pcreacion.putConstraint(SpringLayout.WEST, ttitulo, 0, SpringLayout.WEST, jtipo);
	}
	
	public void colocarGuardar1() {
		pcreacion.putConstraint(SpringLayout.NORTH, guardar1, 10, SpringLayout.SOUTH, ltitulo);
		pcreacion.putConstraint(SpringLayout.WEST, guardar1, 0, SpringLayout.EAST, ltitulo);
	}
	
	public void colocarAtras1() {
		pcreacion.putConstraint(SpringLayout.NORTH, atras1, 0, SpringLayout.NORTH, guardar1);
		pcreacion.putConstraint(SpringLayout.WEST, atras1, 10, SpringLayout.EAST, guardar1);
	}
	
	/* Colocacion Apuntes */
	public void colocarGuardar2() {
		pcreacion.putConstraint(SpringLayout.NORTH, guardar2, 10, SpringLayout.SOUTH, ltitulo);
		pcreacion.putConstraint(SpringLayout.WEST, guardar2, 0, SpringLayout.EAST, ltitulo);
	}
	
	public void colocarApuntesScroll() {
		pcreacion.putConstraint(SpringLayout.NORTH, apuntescroll, 0, SpringLayout.NORTH, ttitulo);
		pcreacion.putConstraint(SpringLayout.WEST, apuntescroll, 20, SpringLayout.EAST, ttitulo);
	}
	
	public void colocarAtras2() {
		pcreacion.putConstraint(SpringLayout.NORTH, atras2, 0, SpringLayout.NORTH, guardar2);
		pcreacion.putConstraint(SpringLayout.WEST, atras2, 10, SpringLayout.EAST, guardar2);
	}	
	
	/* Colocacion Ejercicio */
	 public void colocarFIni() {
		pcreacion.putConstraint(SpringLayout.NORTH, fini, 10, SpringLayout.SOUTH, ttitulo);
		pcreacion.putConstraint(SpringLayout.WEST, fini, 0, SpringLayout.WEST, ltitulo);
	 }
	 
	 public void colocarTFIni() {
		pcreacion.putConstraint(SpringLayout.NORTH, tfini, 0, SpringLayout.NORTH, fini);
		pcreacion.putConstraint(SpringLayout.WEST, tfini, 5, SpringLayout.EAST, fini);	
	 }
	 
	 public void colocarFFin() {
		pcreacion.putConstraint(SpringLayout.NORTH, ffin, 10, SpringLayout.SOUTH, fini);
		pcreacion.putConstraint(SpringLayout.WEST, ffin, 0, SpringLayout.WEST, ltitulo);
	 }
	 
	 public void colocarTFFin() {
		pcreacion.putConstraint(SpringLayout.NORTH, tffin, 0, SpringLayout.NORTH, ffin);
		pcreacion.putConstraint(SpringLayout.WEST, tffin, 5, SpringLayout.EAST, ffin);	
	 }
	 
	 public void colocarPonderacion() {
		 pcreacion.putConstraint(SpringLayout.NORTH, ponderacion, 10, SpringLayout.SOUTH, ffin);
		 pcreacion.putConstraint(SpringLayout.WEST, ponderacion, 0, SpringLayout.WEST, ltitulo);
		 }
	 
	 public void colocarAleat() {
		 pcreacion.putConstraint(SpringLayout.NORTH, aleat, 10, SpringLayout.SOUTH, ponderacion);
		 pcreacion.putConstraint(SpringLayout.WEST, aleat, 0, SpringLayout.WEST, ltitulo);		
		 }
	 
	 public void colocarNormas() {
		 pcreacion.putConstraint(SpringLayout.NORTH, normas, 10, SpringLayout.SOUTH, aleat);
		 pcreacion.putConstraint(SpringLayout.WEST, normas, 0, SpringLayout.WEST, ltitulo);			 
		 }
	 
	 public void colocarTPonderacion() {
		 pcreacion.putConstraint(SpringLayout.NORTH, tponderacion, 0, SpringLayout.NORTH, ponderacion);
		 pcreacion.putConstraint(SpringLayout.WEST, tponderacion, 5, SpringLayout.EAST, ponderacion);
		 }
	 
	 public void colocarOpcion1() {
		 pcreacion.putConstraint(SpringLayout.NORTH, opcion1, 0, SpringLayout.NORTH, aleat);
		 pcreacion.putConstraint(SpringLayout.WEST, opcion1, 5, SpringLayout.EAST, aleat);	
		 }
	 
	 public void colocarOpcion2() {
		 pcreacion.putConstraint(SpringLayout.NORTH, opcion2, 0, SpringLayout.NORTH, aleat);
		 pcreacion.putConstraint(SpringLayout.WEST, opcion2, 5, SpringLayout.EAST, opcion1);
		 }
	 
	 public void colocarTNormas() {
		 pcreacion.putConstraint(SpringLayout.NORTH, tnormas, 10, SpringLayout.SOUTH, normas);
		 pcreacion.putConstraint(SpringLayout.WEST, tnormas, 0, SpringLayout.WEST, normas);			
		 }
	 
	 public void colocarEjercicio() {
		 pcreacion.putConstraint(SpringLayout.NORTH, ejercicio, 0, SpringLayout.NORTH, nombreAsig);
		 pcreacion.putConstraint(SpringLayout.WEST, ejercicio, 20, SpringLayout.EAST, tnormas);		 
		 }
	 
	 public void colocarNumero() {
		 pcreacion.putConstraint(SpringLayout.NORTH, numero, 10, SpringLayout.SOUTH, ejercicio);
		 pcreacion.putConstraint(SpringLayout.WEST, numero, 20, SpringLayout.EAST, tnormas);
		 }
	 
	 public void colocarPeso() {
		 pcreacion.putConstraint(SpringLayout.NORTH, peso, 10, SpringLayout.SOUTH, numero);
		 pcreacion.putConstraint(SpringLayout.WEST, peso, 20, SpringLayout.EAST, tnormas);		 
		 }
	 
	 public void colocarTipoPregunta() {
		 pcreacion.putConstraint(SpringLayout.NORTH, tipopregunta, 10, SpringLayout.SOUTH, peso);
		 pcreacion.putConstraint(SpringLayout.WEST, tipopregunta, 20, SpringLayout.EAST, tnormas); 
		 }
	 
	 public void colocarPregunta() {
		 pcreacion.putConstraint(SpringLayout.NORTH, pregunta, 15, SpringLayout.SOUTH, tipopregunta);
		 pcreacion.putConstraint(SpringLayout.WEST, pregunta, 20, SpringLayout.EAST, tnormas);
		 }
	 
	 public void colocarTNumero() {
		 pcreacion.putConstraint(SpringLayout.NORTH, tnumero, 0, SpringLayout.NORTH, numero);
		 pcreacion.putConstraint(SpringLayout.WEST, tnumero, 10, SpringLayout.EAST, numero);
		 }
	 
	 public void colocarTPeso() {
		 pcreacion.putConstraint(SpringLayout.NORTH, tpeso, 0, SpringLayout.NORTH, peso);
		 pcreacion.putConstraint(SpringLayout.WEST, tpeso, 10, SpringLayout.EAST, peso);
		 }
	 
	 public void colocarTTipo() {
		pcreacion.putConstraint(SpringLayout.NORTH, ttipo, 0, SpringLayout.NORTH, tipopregunta);
		pcreacion.putConstraint(SpringLayout.WEST, ttipo, 10, SpringLayout.EAST, tipopregunta);
		}
	 
	 public void colocarTPregunta() {
		pcreacion.putConstraint(SpringLayout.NORTH, tpregunta, 0, SpringLayout.NORTH, pregunta);
		pcreacion.putConstraint(SpringLayout.WEST, tpregunta, 10, SpringLayout.EAST, pregunta); 
		}
	 
	 
	 /* Tipos de Respuestas Colocacion */
	 
	 
	 /* Respuesta Simple */
	 public void colocarCorrecta() {
		 pcreacion.putConstraint(SpringLayout.NORTH, correcta, 10, SpringLayout.SOUTH, tpregunta);
		 pcreacion.putConstraint(SpringLayout.WEST, correcta, 20, SpringLayout.EAST, tnormas);
		 }
	 
	 public void colocarRCNo() {
		 pcreacion.putConstraint(SpringLayout.NORTH, rcno, 0, SpringLayout.NORTH, correcta);
		 pcreacion.putConstraint(SpringLayout.WEST, rcno, 5, SpringLayout.EAST, correcta);
	 }
	 public void colocarRCSi() {
		 pcreacion.putConstraint(SpringLayout.NORTH, rcsi, 0, SpringLayout.NORTH, correcta);
		 pcreacion.putConstraint(SpringLayout.WEST, rcsi, 5, SpringLayout.EAST, rcno);
			
	 }
	 
	 public void colocarLPenalizacion1() {
		 pcreacion.putConstraint(SpringLayout.NORTH, lpenalizacion, 10, SpringLayout.SOUTH, correcta);
		 pcreacion.putConstraint(SpringLayout.WEST, lpenalizacion, 0, SpringLayout.WEST, correcta);	
	 }
	 
	 public void colocarTPenalizacion1() {
		 pcreacion.putConstraint(SpringLayout.NORTH, tpenalizacion, 0, SpringLayout.NORTH, lpenalizacion);
		 pcreacion.putConstraint(SpringLayout.WEST, tpenalizacion, 5, SpringLayout.EAST, lpenalizacion);	
	 }
	 
	 public void colocarAnyadir1() {
		 pcreacion.putConstraint(SpringLayout.NORTH, anyadir1, 10, SpringLayout.SOUTH, lpenalizacion);
		 pcreacion.putConstraint(SpringLayout.WEST, anyadir1, 5, SpringLayout.WEST, correcta);	
	 }
	 
	 public void colocarFinalizar1() {
		 pcreacion.putConstraint(SpringLayout.NORTH, finalizar, 0, SpringLayout.NORTH, anyadir1);
		 pcreacion.putConstraint(SpringLayout.WEST, finalizar, 5, SpringLayout.EAST, anyadir1);	
	 }
	 
	 public void colocarAtras31() {
		 pcreacion.putConstraint(SpringLayout.NORTH, atras3, 10, SpringLayout.SOUTH, anyadir1);
		 pcreacion.putConstraint(SpringLayout.WEST, atras3, 0, SpringLayout.EAST, anyadir1);
	 }
	 
	 /* Respuesta Multiple, Unica, Abierta */
	 public void colocarLOpcion() {
		 pcreacion.putConstraint(SpringLayout.NORTH, lopcion, 10, SpringLayout.SOUTH, tpregunta);
		 pcreacion.putConstraint(SpringLayout.WEST, lopcion, 30, SpringLayout.WEST, pregunta);
	 }
	 
	 public void colocarTOpcion() {
		 pcreacion.putConstraint(SpringLayout.NORTH, topcion, 0, SpringLayout.NORTH, lopcion);
		 pcreacion.putConstraint(SpringLayout.WEST, topcion, 5, SpringLayout.EAST, lopcion);
	 }
	 
	 public void colocarLNumop() {
		 pcreacion.putConstraint(SpringLayout.NORTH, lnumop, 10, SpringLayout.SOUTH, lopcion);
		 pcreacion.putConstraint(SpringLayout.WEST, lnumop, 0, SpringLayout.WEST, lopcion);
	 }
	 
	 public void colocarTNumop() {
		 pcreacion.putConstraint(SpringLayout.NORTH, tnumop, 0, SpringLayout.NORTH, lnumop);
		 pcreacion.putConstraint(SpringLayout.WEST, tnumop, 5, SpringLayout.EAST, lnumop);
	 }
	 
	 public void colocarAnyadirOC() {
		 pcreacion.putConstraint(SpringLayout.NORTH, anyadiroc, 10, SpringLayout.SOUTH, lnumop);
		 pcreacion.putConstraint(SpringLayout.WEST, anyadiroc, 0, SpringLayout.WEST, lnumop);
	 }
	 
	 public void colocarAnyadirOCF() {
		 pcreacion.putConstraint(SpringLayout.NORTH, anyadirof, 10, SpringLayout.SOUTH, anyadiroc);
		 pcreacion.putConstraint(SpringLayout.WEST, anyadirof, 0, SpringLayout.WEST, lnumop);
	 }
	 
	 public void colocarLPenalizacion2() {
		 pcreacion.putConstraint(SpringLayout.NORTH, lpenalizacion, 10, SpringLayout.SOUTH, anyadirof);
		 pcreacion.putConstraint(SpringLayout.WEST, lpenalizacion, 0, SpringLayout.WEST, pregunta);	
	 }
	 
	 public void colocarTPenalizacion2() {
		 pcreacion.putConstraint(SpringLayout.NORTH, tpenalizacion, 0, SpringLayout.NORTH, lpenalizacion);
		 pcreacion.putConstraint(SpringLayout.WEST, tpenalizacion, 5, SpringLayout.EAST, lpenalizacion);	
	 }
	 
	 /*Respuesta Multiple */
	 public void colocarAnyadir2() {
		pcreacion.putConstraint(SpringLayout.NORTH, anyadir2, 10, SpringLayout.SOUTH, lpenalizacion);
		pcreacion.putConstraint(SpringLayout.WEST, anyadir2, 0, SpringLayout.WEST, pregunta);
		}
	 
	 public void colocarFinalizar2() {
		pcreacion.putConstraint(SpringLayout.NORTH, finalizar, 0, SpringLayout.NORTH, anyadir2);
		pcreacion.putConstraint(SpringLayout.WEST, finalizar, 5, SpringLayout.EAST, anyadir2);	 
	 	}

	 public void colocarAtras32() {
		pcreacion.putConstraint(SpringLayout.NORTH, atras3, 10, SpringLayout.SOUTH, anyadir2);
		pcreacion.putConstraint(SpringLayout.WEST, atras3, 0, SpringLayout.EAST, anyadir2); 
	 	}
	 
	 /* Respuesta Unica */
	 public void colocarAnyadir3() {
		 pcreacion.putConstraint(SpringLayout.NORTH, anyadir3, 10, SpringLayout.SOUTH, lpenalizacion);
		 pcreacion.putConstraint(SpringLayout.WEST, anyadir3, 0, SpringLayout.WEST, pregunta);
	 }
	 
	 public void colocarFinalizar3() {
		 pcreacion.putConstraint(SpringLayout.NORTH, finalizar, 0, SpringLayout.NORTH, anyadir3);
		 pcreacion.putConstraint(SpringLayout.WEST, finalizar, 5, SpringLayout.EAST, anyadir3);	
	 }
	 
	 public void colocarAtras33() {
		 pcreacion.putConstraint(SpringLayout.NORTH, atras3, 10, SpringLayout.SOUTH, anyadir3);
		 pcreacion.putConstraint(SpringLayout.WEST, atras3, 0, SpringLayout.EAST, anyadir3);
	 }
	 
	 /* Respuesta Abierta */
	 public void colocarAnyadir4() {
		 pcreacion.putConstraint(SpringLayout.NORTH, anyadir4, 10, SpringLayout.SOUTH, lpenalizacion);
		 pcreacion.putConstraint(SpringLayout.WEST, anyadir4, 0, SpringLayout.WEST, pregunta);
	 }
	 
	 public void colocarFinalizar4() {
		 pcreacion.putConstraint(SpringLayout.NORTH, finalizar, 0, SpringLayout.NORTH, anyadir4);
		 pcreacion.putConstraint(SpringLayout.WEST, finalizar, 5, SpringLayout.EAST, anyadir4);	
	 }
	 
	 public void colocarAtras34() {
		 pcreacion.putConstraint(SpringLayout.NORTH, atras3, 10, SpringLayout.SOUTH, anyadir4);
		 pcreacion.putConstraint(SpringLayout.WEST, atras3, 0, SpringLayout.EAST, anyadir4);
	 }
	 
	 
	 /* Setters de los diversos action listeners a utilizar en este panel */
	 public void setControladorJTipo(ActionListener c) {
		 jtipo.addActionListener(c);
	 }
	 
	 public void setControladorTTipo(ActionListener c) {
		 ttipo.addActionListener(c);
	 }

	 public void setControladorAtras1(ActionListener c) {
		 atras1.addActionListener(c);
	 }
	 
	 public void setControladorAtras2(ActionListener c) {
		 atras2.addActionListener(c);
	 }
	 
	 public void setControladorAtras3(ActionListener c) {
		 atras3.addActionListener(c);
	 }
	 
	 public void setControladorGuardar1(ActionListener c) {
		 guardar1.addActionListener(c);
	 }
	 
	 public void setControladorGuardar2(ActionListener c) {
		 guardar2.addActionListener(c);
	 }
	 
	 public void setControladorLogout(ActionListener c) {
		 logout.addActionListener(c);
	 }
	 
	 public void setControladorFinalizar(ActionListener c) {
		 finalizar.addActionListener(c);
	 }
	 
	 public void setControladorAnyadires(ActionListener c) {
		 anyadir1.addActionListener(c);
		 anyadir2.addActionListener(c);
		 anyadir3.addActionListener(c);
		 anyadir4.addActionListener(c);
	 }
	 
	 public void setControladorAnyadiroc(ActionListener c) {
		 anyadiroc.addActionListener(c);
	 }
	 
	 public void setControladorAnyadirof(ActionListener c) {
		 anyadirof.addActionListener(c);
	 }
	 
	 
    /* Getters de diversos componentes que conforman el panel */
	@SuppressWarnings("rawtypes")
	public JComboBox getJTipo() {
		return this.jtipo;
	}
	
	public String getValorSeleccionado() {
		return (String) jtipo.getSelectedItem();
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox getTTipo(){
		return this.ttipo;
	}
	
	public String getRespuestaSeleccionada(){
		return (String) ttipo.getSelectedItem();
	}
	
	/* Getters para Subtema */
	public JLabel getLTitulo() {
		return this.ltitulo;
	}
	
	public JTextField getTTitulo() {
		return this.ttitulo;
	}
	
	public JButton getGuardar1() {
		return this.guardar1;
	}
	
	public JButton getAtras1() {
		return this.atras1;
	}
	
	/* Getters para Apuntes */
	public JButton getGuardar2() {
		return this.guardar2;
	}
	
	public JButton getAtras2() {
		return this.atras2;
	}
	
	public JScrollPane getApuntesScroll() {
		return this.apuntescroll;
	}
	
	/* Getters para Ejercicio*/
	public JLabel getFIni() {
		return this.fini;
	}
	
	public JTextField getTFIni() {
		return this.tfini;
	}
	
	public JLabel getFFin() {
		return this.ffin;
	}
	
	public JTextField getTFFin() {
		return this.tffin;
	}
	
	public JLabel getPonderacion() {
		return this.ponderacion;
	}
	
	public JLabel getAleat() {
		return this.aleat;
	}
	
	public JLabel getNormas() {
		return this.normas;
	}
	
	public JTextField getTPonderacion() {
		return this.tponderacion;
	}
	
	public JRadioButton getOpcion1() {
		return this.opcion1;
	}
	
	public JRadioButton getOpcion2() {
		return this.opcion2;
	}
	
	public JTextArea getTNormas() {
		return this.tnormas;
	}
	
	public JLabel getEjercicio() {
		return this.ejercicio;
	}
	
	public JLabel getNumero() {
		return this.numero;
	}
	
	public JLabel getPeso() {
		return this.peso;
	}
	
	public JLabel getTipoPregunta() {
		return this.tipopregunta;
	}
	
	public JLabel getPregunta() {
		return this.pregunta;
	}
	
	public JLabel getCorrecta() {
		return this.correcta;
	}
	
	public JTextField getTNumero() {
		return this.tnumero;
	}
	
	public JTextField getTPeso() {
		return this.tpeso;
	}
	
	public JTextArea getTPregunta() {
		return this.tpregunta;
	}
	
	/* Comunes a todas las respuestas */
	
	public JLabel getLPenalizacion() {
		return this.lpenalizacion;
	}
	
	public JTextField getTPenalizacion() {
		return this.tpenalizacion;
	}
	
	public JButton getFinalizar() {
		return this.finalizar;
	}
	
	public JButton getAtras3() {
		return this.atras3;
	}
	
	/* Respuesta Simple */
	public JRadioButton getRCNo() {
		return this.rcno;
	}
	
	public JRadioButton getRCSi() {
		return this.rcsi;
	}
	
	public JButton getAnyadir1() {
		return this.anyadir1;
	}
	
	/* Respuesta Multiple, Unica, Abierta */
	 public JLabel getLOpcion() {
		 return this.lopcion;
	 }
	 
	 public JTextField getTOpcion() {
		 return this.topcion;
	 }
	 
	 public JLabel getLNumop() {
		 return this.lnumop;
	 }
	 
	 public JTextField getTNumop() {
		 return this.tnumop;
	 }
	 
	 public JButton getAnyadirOC() {
		 return this.anyadiroc;
	 }
	 
	 public JButton getAnyadirOF() {
		 return this.anyadirof;
	 }
	
	/* Respuesta Multiple */
	public JButton getAnyadir2() {
		return this.anyadir2;
	}
	
	/* Respuesta Unica */
	public JButton getAnyadir3() {
		return this.anyadir3;
	}
	
	/* Respuesta Abierta */
	public JButton getAnyadir4() {
		return this.anyadir4;
	}
	
	public JButton getLogout() {
		return logout;
	}

	public JTextArea getApuntes() {
		return apuntes;
	}

	
	public ButtonGroup getTaleat() {
		return taleat;
	}
	
	public boolean seleccionAleat() {
		return opcion1.isSelected();
	}
	
	public boolean seleccionRS() {
		return rcsi.isSelected();
	}
	
}
