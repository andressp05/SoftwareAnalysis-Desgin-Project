package controladores;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import aplicacion.Aplicacion;
import aplicacion.Asignatura;
import aplicacion.recursos.Apuntes;
import aplicacion.recursos.Recurso;
import aplicacion.recursos.Tema;
import aplicacion.recursos.ejercicios.TipoRespuesta;
import aplicacion.recursos.ejercicios.Ejercicio;
import aplicacion.recursos.ejercicios.Opcion;
import aplicacion.recursos.ejercicios.Pregunta;
import interfaces.SapereAude;
import interfaces.profesor.PCreacion;
import interfaces.profesor.PEntrada;

/**
 * Esta clase implementa el controlador asociado al panel de creacion de
 * recursos
 * @author Andres y Francisco
 */
public class CPCreacion implements ActionListener {
	/** Jpanel al que vamos a dar funcionalidad */
	private PCreacion pc;
	
	/** Instancia de la aplicacion */
	private Aplicacion app = null;
	
	/** Recurso donde creamos */
	private Recurso rec = null;
	
	/** Tipo de respuesta seleccionado */
	private TipoRespuesta tipoSeleccionado;
	
	/** Array temporal para almacenar las preguntas que se van creando */
	private ArrayList<Pregunta> preguntasCreadas;
	
	/** Cuenta de las preguntas creadas para cada ejercicio */
	private int contPreguntas;
	
	/** Cuenta de las opciones creadas  para cada pregunta */
	private int contOpciones;
	
	/** Cuenta de las preguntas correctas creadas para cada ejercicio */
	private int contCorrectas;

	/** Array temporal para almacenar las opciones que se van creando */
	private ArrayList<Opcion> opcionesCreadas;
	/**
	 * Constructor de la clase
	 * @param pc
	 * @param recurso 
	 */
	public CPCreacion(PCreacion pc, Object recurso) {
		this.pc = pc;
		pc.setPreferredSize(new Dimension(800,600));
		this.rec = (Recurso) recurso;
		this.tipoSeleccionado = TipoRespuesta.SIMPLE;
		this.preguntasCreadas = new ArrayList<Pregunta>();
		this.opcionesCreadas = new ArrayList<Opcion>();
		this.contPreguntas = 1;
		this.contOpciones = 1;
		this.contCorrectas = 0;
		
		pc.getTPenalizacion().setText("0");
		pc.getTPeso().setText("1");
		try {
			app = Aplicacion.getInstance();
		} catch (IOException e) {
			System.out.println("Error al obtener la instancia de la aplicacion");
			e.printStackTrace();
		}

		pc.getTNumero().setText(Integer.toString(contPreguntas));
		pc.getTNumero().setEditable(false);
		
		pc.getTNumop().setText(Integer.toString(contOpciones));
		pc.getTNumop().setEditable(false);
		
	}
	
	/**
	 * Funcion que es llamada cada vez que se interacciona con un componente
	 * seleccionable del panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Crear Subtema
		if (e.getSource().equals(pc.getJTipo()) && pc.getValorSeleccionado().equals("Subtema")) {
			pc.remove(pc.getLTitulo());
			pc.remove(pc.getTTitulo());
			pc.remove(pc.getGuardar2());
			pc.remove(pc.getApuntesScroll());
			pc.remove(pc.getAtras2());
			pc.remove(pc.getFIni());
			pc.remove(pc.getTFIni());
			pc.remove(pc.getFFin());
			pc.remove(pc.getTFFin());
			pc.remove(pc.getPonderacion());
			pc.remove(pc.getAleat());
			pc.remove(pc.getNormas());
			pc.remove(pc.getTPonderacion());
			pc.remove(pc.getOpcion1());
			pc.remove(pc.getOpcion2());
			pc.remove(pc.getTNormas());
			pc.remove(pc.getEjercicio());
			pc.remove(pc.getNumero());
			pc.remove(pc.getPeso());
			pc.remove(pc.getTipoPregunta());
			pc.remove(pc.getPregunta());
			pc.remove(pc.getCorrecta());
			pc.remove(pc.getTNumero());
			pc.remove(pc.getTPeso());
			pc.remove(pc.getTTipo());
			pc.remove(pc.getTPregunta());
			pc.remove(pc.getRCNo());
			pc.remove(pc.getRCSi());
			
			pc.remove(pc.getLOpcion());
			pc.remove(pc.getTOpcion());
			pc.remove(pc.getLNumop());
			pc.remove(pc.getTNumop());
			pc.remove(pc.getAnyadirOC());
			pc.remove(pc.getAnyadirOF());
			
			pc.remove(pc.getAnyadir1());
			pc.remove(pc.getAnyadir2());
			pc.remove(pc.getAnyadir3());
			pc.remove(pc.getFinalizar());
			pc.remove(pc.getAtras3());
			pc.remove(pc.getGuardar1());
			pc.remove(pc.getAtras1());
			pc.remove(pc.getLPenalizacion());
			pc.remove(pc.getTPenalizacion());
			
			
			
			pc.colocarLTitulo();
			pc.colocarTTitulo();
			pc.colocarGuardar1();
			pc.colocarAtras1();
			
			pc.add(pc.getLTitulo());
			pc.add(pc.getTTitulo());
			pc.add(pc.getGuardar1());
			pc.add(pc.getAtras1());
			pc.setVisible(true);
			pc.updateUI();
		}
		
		// Crear Apuntes
		else if (e.getSource().equals(pc.getJTipo()) && pc.getValorSeleccionado().equals("Apuntes")) {
			
			pc.remove(pc.getLTitulo());
			pc.remove(pc.getTTitulo());
			pc.remove(pc.getGuardar1());
			pc.remove(pc.getAtras1());
			pc.remove(pc.getFIni());
			pc.remove(pc.getTFIni());
			pc.remove(pc.getFFin());
			pc.remove(pc.getTFFin());
			pc.remove(pc.getPonderacion());
			pc.remove(pc.getAleat());
			pc.remove(pc.getNormas());
			pc.remove(pc.getTPonderacion());
			pc.remove(pc.getOpcion1());
			pc.remove(pc.getOpcion2());
			pc.remove(pc.getTNormas());
			pc.remove(pc.getEjercicio());
			pc.remove(pc.getNumero());
			pc.remove(pc.getPeso());
			pc.remove(pc.getTipoPregunta());
			pc.remove(pc.getPregunta());
			pc.remove(pc.getCorrecta());
			pc.remove(pc.getTNumero());
			pc.remove(pc.getTPeso());
			pc.remove(pc.getTTipo());
			pc.remove(pc.getTPregunta());
			pc.remove(pc.getRCNo());
			pc.remove(pc.getRCSi());
			
			pc.remove(pc.getLOpcion());
			pc.remove(pc.getTOpcion());
			pc.remove(pc.getLNumop());
			pc.remove(pc.getTNumop());
			pc.remove(pc.getAnyadirOC());
			pc.remove(pc.getAnyadirOF());
			
			pc.remove(pc.getAnyadir1());
			pc.remove(pc.getAnyadir2());
			pc.remove(pc.getAnyadir3());
			pc.remove(pc.getFinalizar());
			pc.remove(pc.getAtras3());
			pc.remove(pc.getGuardar2());
			pc.remove(pc.getApuntesScroll());
			pc.remove(pc.getAtras2());
			pc.remove(pc.getLPenalizacion());
			pc.remove(pc.getTPenalizacion());
			
			
			
			pc.colocarLTitulo();
			pc.colocarTTitulo();
			pc.colocarGuardar2();
			pc.colocarApuntesScroll();
			pc.colocarAtras2();
			
			pc.add(pc.getLTitulo());
			pc.add(pc.getTTitulo());
			pc.add(pc.getGuardar2());
			pc.add(pc.getApuntesScroll());
			pc.add(pc.getAtras2());
			pc.setVisible(true);
			pc.updateUI();
		}
		
		//  Crear Ejercicio
		else if (e.getSource().equals(pc.getJTipo()) && pc.getValorSeleccionado().equals("Ejercicio")) {
			vaciarSeleccionEjercicio();
			
			pc.remove(pc.getLTitulo());
			pc.remove(pc.getTTitulo());
			pc.remove(pc.getGuardar1());
			pc.remove(pc.getAtras1());
			pc.remove(pc.getGuardar2());
			pc.remove(pc.getApuntesScroll());
			pc.remove(pc.getAtras2());
			pc.remove(pc.getFIni());
			pc.remove(pc.getTFIni());
			pc.remove(pc.getFFin());
			pc.remove(pc.getTFFin());
			pc.remove(pc.getPonderacion());
			pc.remove(pc.getAleat());
			pc.remove(pc.getNormas());
			pc.remove(pc.getTPonderacion());
			pc.remove(pc.getOpcion1());
			pc.remove(pc.getOpcion2());
			pc.remove(pc.getTNormas());
			pc.remove(pc.getEjercicio());
			pc.remove(pc.getNumero());
			pc.remove(pc.getPeso());
			pc.remove(pc.getTipoPregunta());
			pc.remove(pc.getPregunta());
			pc.remove(pc.getCorrecta());
			pc.remove(pc.getTNumero());
			pc.remove(pc.getTPeso());
			pc.remove(pc.getTTipo());
			pc.remove(pc.getTPregunta());
			pc.remove(pc.getRCNo());
			pc.remove(pc.getRCSi());
			
			pc.remove(pc.getLOpcion());
			pc.remove(pc.getTOpcion());
			pc.remove(pc.getLNumop());
			pc.remove(pc.getTNumop());
			pc.remove(pc.getAnyadirOC());
			pc.remove(pc.getAnyadirOF());
			
			pc.remove(pc.getAnyadir1());
			pc.remove(pc.getAnyadir2());
			pc.remove(pc.getAnyadir3());
			pc.remove(pc.getFinalizar());
			pc.remove(pc.getAtras3());
			
			pc.colocarLTitulo();
			pc.colocarTTitulo();
			pc.colocarFIni();
			pc.colocarTFIni();
			pc.colocarFFin();
			pc.colocarTFFin();
			pc.colocarPonderacion();
			pc.colocarAleat();
			pc.colocarNormas();
			pc.colocarTPonderacion();
			pc.colocarOpcion1();
			pc.colocarOpcion2();
			pc.colocarTNormas();
			pc.colocarEjercicio();
			pc.colocarNumero();
			pc.colocarPeso();
			pc.colocarTipoPregunta();
			pc.colocarPregunta();
			pc.colocarCorrecta();
			pc.colocarTNumero();
			pc.colocarTPeso();
			pc.colocarTTipo();
			pc.colocarTPregunta();
			pc.colocarRCNo();
			pc.colocarRCSi();
			pc.colocarLPenalizacion1();
			pc.colocarTPenalizacion1();
			pc.colocarAnyadir1();
			pc.colocarFinalizar1();
			pc.colocarAtras31();
			
			pc.add(pc.getLTitulo());
			pc.add(pc.getTTitulo());
			pc.add(pc.getFIni());
			pc.add(pc.getTFIni());
			pc.add(pc.getFFin());
			pc.add(pc.getTFFin());
			pc.add(pc.getPonderacion());
			pc.add(pc.getAleat());
			pc.add(pc.getNormas());
			pc.add(pc.getTPonderacion());
			pc.add(pc.getOpcion1());
			pc.add(pc.getOpcion2());
			pc.add(pc.getTNormas());
			pc.add(pc.getEjercicio());
			pc.add(pc.getNumero());
			pc.add(pc.getPeso());
			pc.add(pc.getTipoPregunta());
			pc.add(pc.getPregunta());
			pc.add(pc.getCorrecta());
			pc.add(pc.getTNumero());
			pc.add(pc.getTPeso());
			pc.add(pc.getTPregunta());
			pc.add(pc.getRCNo());
			pc.add(pc.getRCSi());
			pc.add(pc.getLPenalizacion());
			pc.add(pc.getTPenalizacion());
			pc.add(pc.getAnyadir1());
			pc.add(pc.getFinalizar());
			pc.add(pc.getAtras3());
			pc.getTTipo().setSelectedIndex(0);
			pc.add(pc.getTTipo());
			pc.setVisible(true);
			pc.updateUI();
		}
		
		// Crear Respuesta Simple
		else if (e.getSource().equals(pc.getTTipo()) && pc.getRespuestaSeleccionada().equals("Respuesta Simple")) {
			vaciarSeleccionPregunta();
			
			pc.remove(pc.getFinalizar());
			pc.remove(pc.getAtras3());
			pc.remove(pc.getRCNo());
			pc.remove(pc.getRCSi());
			
			pc.remove(pc.getLOpcion());
			pc.remove(pc.getTOpcion());
			pc.remove(pc.getLNumop());
			pc.remove(pc.getTNumop());
			pc.remove(pc.getAnyadirOC());
			pc.remove(pc.getAnyadirOF());
			
			pc.remove(pc.getAnyadir1());
			pc.remove(pc.getAnyadir2());
			pc.remove(pc.getAnyadir3());
			pc.remove(pc.getLPenalizacion());
			pc.remove(pc.getTPenalizacion());
			
			
			this.tipoSeleccionado = TipoRespuesta.SIMPLE;
			
			pc.colocarCorrecta();
			pc.colocarRCNo();
			pc.colocarRCSi();
			pc.colocarAnyadir1();
			pc.colocarFinalizar1();
			pc.colocarAtras31();
			pc.colocarLPenalizacion1();
			pc.colocarTPenalizacion1();
			
			pc.add(pc.getRCNo());
			pc.add(pc.getRCSi());
			pc.add(pc.getLPenalizacion());
			pc.add(pc.getTPenalizacion());
			pc.add(pc.getAnyadir1());
			pc.add(pc.getFinalizar());
			pc.add(pc.getAtras3());
			pc.setVisible(true);
			pc.updateUI();
		}
		
		// Crear Respuesta Multiple
		else if (e.getSource().equals(pc.getTTipo()) && pc.getRespuestaSeleccionada().equals("Respuesta Multiple")) {
			vaciarSeleccionPregunta();
			
			pc.remove(pc.getFinalizar());
			pc.remove(pc.getAtras3());
			pc.remove(pc.getRCNo());
			pc.remove(pc.getRCSi());
			pc.remove(pc.getCorrecta());
			
			pc.remove(pc.getLOpcion());
			pc.remove(pc.getTOpcion());
			pc.remove(pc.getLNumop());
			pc.remove(pc.getTNumop());
			pc.remove(pc.getAnyadirOC());
			pc.remove(pc.getAnyadirOF());
			
			pc.remove(pc.getAnyadir1());
			pc.remove(pc.getAnyadir2());
			pc.remove(pc.getAnyadir3());
			pc.remove(pc.getLPenalizacion());
			pc.remove(pc.getTPenalizacion());
			
			
			this.tipoSeleccionado = TipoRespuesta.MULTIPLE;
			
			pc.colocarLOpcion();
			pc.colocarTOpcion();
			pc.colocarLNumop();
			pc.colocarTNumop();
			pc.colocarAnyadirOC();
			pc.colocarAnyadirOCF();
			
			pc.colocarAnyadir2();
			pc.colocarFinalizar2();
			pc.colocarAtras32();
			pc.colocarLPenalizacion2();
			pc.colocarTPenalizacion2();
			
			pc.add(pc.getLOpcion());
			pc.add(pc.getTOpcion());
			pc.add(pc.getLNumop());
			pc.add(pc.getTNumop());
			pc.add(pc.getAnyadirOC());
			pc.add(pc.getAnyadirOF());
			
			pc.add(pc.getLPenalizacion());
			pc.add(pc.getTPenalizacion());
			pc.add(pc.getAnyadir2());
			pc.add(pc.getFinalizar());
			pc.add(pc.getAtras3());
			pc.setVisible(true);
			pc.updateUI();
		}
		
		// Crear Respuesta Unica
		else if (e.getSource().equals(pc.getTTipo()) && pc.getRespuestaSeleccionada().equals("Respuesta Unica")) {
			vaciarSeleccionPregunta();
			
			pc.remove(pc.getFinalizar());
			pc.remove(pc.getAtras3());
			pc.remove(pc.getRCNo());
			pc.remove(pc.getRCSi());
			pc.remove(pc.getCorrecta());
			
			pc.remove(pc.getLOpcion());
			pc.remove(pc.getTOpcion());
			pc.remove(pc.getLNumop());
			pc.remove(pc.getTNumop());
			pc.remove(pc.getAnyadirOC());
			pc.remove(pc.getAnyadirOF());
			
			pc.remove(pc.getAnyadir1());
			pc.remove(pc.getAnyadir2());
			pc.remove(pc.getAnyadir3());
			pc.remove(pc.getLPenalizacion());
			pc.remove(pc.getTPenalizacion());
			
			
			this.tipoSeleccionado = TipoRespuesta.UNICA;
			
			pc.colocarLOpcion();
			pc.colocarTOpcion();
			pc.colocarLNumop();
			pc.colocarTNumop();
			pc.colocarAnyadirOC();
			pc.colocarAnyadirOCF();
			
			pc.colocarAnyadir3();
			pc.colocarFinalizar3();
			pc.colocarAtras33();
			pc.colocarLPenalizacion2();
			pc.colocarTPenalizacion2();
			
			pc.add(pc.getLOpcion());
			pc.add(pc.getTOpcion());
			pc.add(pc.getLNumop());
			pc.add(pc.getTNumop());
			pc.add(pc.getAnyadirOC());
			pc.add(pc.getAnyadirOF());
			
			pc.add(pc.getLPenalizacion());
			pc.add(pc.getTPenalizacion());
			pc.add(pc.getAnyadir3());
			pc.add(pc.getFinalizar());
			pc.add(pc.getAtras3());
			pc.setVisible(true);
			pc.updateUI();
		}
		
		// Crear Respuesta Abierta
		else if (e.getSource().equals(pc.getTTipo()) && pc.getRespuestaSeleccionada().equals("Respuesta Abierta")) {
			vaciarSeleccionPregunta();
			
			pc.remove(pc.getFinalizar());
			pc.remove(pc.getAtras3());
			pc.remove(pc.getRCNo());
			pc.remove(pc.getRCSi());
			pc.remove(pc.getCorrecta());
			
			pc.remove(pc.getLOpcion());
			pc.remove(pc.getTOpcion());
			pc.remove(pc.getLNumop());
			pc.remove(pc.getTNumop());
			pc.remove(pc.getAnyadirOC());
			pc.remove(pc.getAnyadirOF());
			
			pc.remove(pc.getAnyadir1());
			pc.remove(pc.getAnyadir2());
			pc.remove(pc.getAnyadir3());
			pc.remove(pc.getLPenalizacion());
			pc.remove(pc.getTPenalizacion());
			
			this.tipoSeleccionado = TipoRespuesta.ABIERTA;
			
			pc.colocarLOpcion();
			pc.colocarTOpcion();
			pc.colocarLNumop();
			pc.colocarTNumop();
			pc.colocarAnyadirOC();
			pc.colocarAnyadirOCF();
			
			pc.colocarLPenalizacion2();
			pc.colocarTPenalizacion2();
			pc.colocarAnyadir2();
			pc.colocarFinalizar2();
			pc.colocarAtras32();
			
			pc.add(pc.getLOpcion());
			pc.add(pc.getTOpcion());
			pc.add(pc.getLNumop());
			pc.add(pc.getTNumop());
			pc.add(pc.getAnyadirOC());
			pc.add(pc.getAnyadirOF());
			
			pc.add(pc.getLPenalizacion());
			pc.add(pc.getTPenalizacion());
			pc.add(pc.getAnyadir2());
			pc.add(pc.getFinalizar());
			pc.add(pc.getAtras3());
			pc.setVisible(true);
			pc.updateUI();
		}
		
		// Volver Panel Entrada
		else if (e.getSource().equals(pc.getAtras1()) || e.getSource().equals(pc.getAtras2()) || e.getSource().equals(pc.getAtras3())) {
			SwingUtilities.getWindowAncestor(pc).setVisible(false);
			
			CPEntrada cpentrada;
			PEntrada pe = new PEntrada();
			try {
				cpentrada = new CPEntrada(pe);
				SapereAude.getInstance().setContentPane(CPEntrada.getPEntrada());
				SapereAude.getInstance().setVisible(true);
				SapereAude.getInstance().setSize(800, 600);
				
				pe.setControladorAtender(cpentrada);
				pe.setControladorCrear(cpentrada);
				pe.setControladorAtras(cpentrada);
				pe.setControladorGuardarAsignatura(cpentrada);
				pe.setControladorAtras2(cpentrada);
				pe.setControladorAceptar(cpentrada);
				pe.setControladorDenegar(cpentrada);
				pe.setControladorAsignaturas(cpentrada);
				pe.setControladorLogout(cpentrada);
				pe.setControladorAnyadir(cpentrada);
				pe.setControladorModificar(cpentrada);
				pe.setControladorEliminar(cpentrada);
				pe.setControladorVisibilidad(cpentrada);
				pe.setControladorAtras3(cpentrada);
				pe.setControladorAtras4(cpentrada);
				pe.setControladorListado(cpentrada);
				pe.setControladorExpulsar(cpentrada);
				pe.setControladorReadmitir(cpentrada);
				pe.setControladorAbrir(cpentrada);
				pe.setControladorNotas(cpentrada);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		//Crear subtema
		else if (e.getSource().equals(pc.getGuardar1())) {
			String titulo = pc.getTTitulo().getText();
			
			((Tema)rec).anyadirRecurso(new Tema(titulo, rec.getAsignatura()));
			
			SwingUtilities.getWindowAncestor(pc).setVisible(false);
			
			CPEntrada cpentrada;
			PEntrada pe = new PEntrada();
			try {
				cpentrada = new CPEntrada(pe);
				SapereAude.getInstance().setContentPane(CPEntrada.getPEntrada());
				SapereAude.getInstance().setVisible(true);
				SapereAude.getInstance().setSize(800, 600);
				
				pe.setControladorAtender(cpentrada);
				pe.setControladorCrear(cpentrada);
				pe.setControladorAtras(cpentrada);
				pe.setControladorGuardarAsignatura(cpentrada);
				pe.setControladorAtras2(cpentrada);
				pe.setControladorAceptar(cpentrada);
				pe.setControladorDenegar(cpentrada);
				pe.setControladorAsignaturas(cpentrada);
				pe.setControladorLogout(cpentrada);
				pe.setControladorAnyadir(cpentrada);
				pe.setControladorModificar(cpentrada);
				pe.setControladorEliminar(cpentrada);
				pe.setControladorVisibilidad(cpentrada);
				pe.setControladorAtras3(cpentrada);
				pe.setControladorAtras4(cpentrada);
				pe.setControladorListado(cpentrada);
				pe.setControladorExpulsar(cpentrada);
				pe.setControladorReadmitir(cpentrada);
				pe.setControladorAbrir(cpentrada);
				pe.setControladorNotas(cpentrada);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//Crear apuntes
		else if (e.getSource().equals(pc.getGuardar2())) {
			System.out.println("apunteeeees ");
			String titulo = pc.getTTitulo().getText();
			String apuntes = pc.getApuntes().getText();
			
			if (titulo.equals("") || apuntes.equals("")) {
				
			}

			((Tema)rec).anyadirRecurso(new Apuntes(titulo, apuntes, rec.getAsignatura()));
			
			SwingUtilities.getWindowAncestor(pc).setVisible(false);
			
			CPEntrada cpentrada;
			PEntrada pe = new PEntrada();
			try {
				cpentrada = new CPEntrada(pe);
				SapereAude.getInstance().setContentPane(CPEntrada.getPEntrada());
				SapereAude.getInstance().setVisible(true);
				SapereAude.getInstance().setSize(800, 600);
				
				pe.setControladorAtender(cpentrada);
				pe.setControladorCrear(cpentrada);
				pe.setControladorAtras(cpentrada);
				pe.setControladorGuardarAsignatura(cpentrada);
				pe.setControladorAtras2(cpentrada);
				pe.setControladorAceptar(cpentrada);
				pe.setControladorDenegar(cpentrada);
				pe.setControladorAsignaturas(cpentrada);
				pe.setControladorLogout(cpentrada);
				pe.setControladorAnyadir(cpentrada);
				pe.setControladorModificar(cpentrada);
				pe.setControladorEliminar(cpentrada);
				pe.setControladorVisibilidad(cpentrada);
				pe.setControladorAtras3(cpentrada);
				pe.setControladorAtras4(cpentrada);
				pe.setControladorListado(cpentrada);
				pe.setControladorExpulsar(cpentrada);
				pe.setControladorReadmitir(cpentrada);
				pe.setControladorAbrir(cpentrada);
				pe.setControladorNotas(cpentrada);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//Opcion correcta registrada
		else if(e.getSource().equals(pc.getAnyadirOC())) {
			System.out.println("Opcion correcta registrada " + contOpciones + " (" + contCorrectas + ")");
			if (tipoSeleccionado.equals(TipoRespuesta.UNICA)) {
				if (contCorrectas == 1) {
					JOptionPane.showMessageDialog(null, "Se admite una unica opcion correcta", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String texto = pc.getTOpcion().getText();
					opcionesCreadas.add(new Opcion(contOpciones, texto, true));
					contOpciones++;
					contCorrectas++;
					vaciarSeleccionOpcion();
				}
			} else {
				String texto = pc.getTOpcion().getText();
				opcionesCreadas.add(new Opcion(contOpciones, texto, true));
				contOpciones++;
				contCorrectas++;
				vaciarSeleccionOpcion();
			}
			
			
		}
		//Opcion incorrecta registrada
		else if(e.getSource().equals(pc.getAnyadirOF())) {
			System.out.println("Opcion erronea registrada " + contOpciones);
			if (tipoSeleccionado.equals(TipoRespuesta.ABIERTA)) {
				JOptionPane.showMessageDialog(null, "Solo se admiten opciones correctas", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				String texto = pc.getTOpcion().getText();
				opcionesCreadas.add(new Opcion(contOpciones, texto, false));
				contOpciones++;
				vaciarSeleccionOpcion();
			}
			
			
		}
		//Pregunta registrada
		else if (e.getSource().equals(pc.getAnyadir1()) || e.getSource().equals(pc.getAnyadir2()) || e.getSource().equals(pc.getAnyadir3()) || e.getSource().equals(pc.getAnyadir4())) {
			System.out.println("Pregunta registrada " + contPreguntas);
			boolean flag = false;
			String enunciado = pc.getTPregunta().getText();
			
			if (pc.getTPeso().getText().equals("") || enunciado.equals("") || pc.getTPenalizacion().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Los campos de creacion no han sido debidamente cumplimentados", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				double peso = Double.parseDouble(pc.getTPeso().getText());
				double penalizacion = Double.parseDouble(pc.getTPenalizacion().getText());
				
				Pregunta nuevaPregunta = new Pregunta(contPreguntas, peso, enunciado, penalizacion, tipoSeleccionado);
				
				if (tipoSeleccionado.equals(TipoRespuesta.SIMPLE)) {
					nuevaPregunta.anyadirOpcionSimple(pc.seleccionRS());
					flag = true;
				}
				else if (tipoSeleccionado.equals(TipoRespuesta.UNICA)) {
					
					for (Opcion op: opcionesCreadas) {
						nuevaPregunta.anyadirOpcion(op.getTexto(), op.getCorreccion());
						if (op.getCorreccion()) {
							flag = true;
						}
					}
				}
				else if (tipoSeleccionado.equals(TipoRespuesta.MULTIPLE)) {
					for (Opcion op: opcionesCreadas) {
						nuevaPregunta.anyadirOpcion(op.getTexto(), op.getCorreccion());
						if (op.getCorreccion()) {
							flag = true;
						}
					}
				}
				else if (tipoSeleccionado.equals(TipoRespuesta.ABIERTA)) {
					for (Opcion op: opcionesCreadas) {
						nuevaPregunta.anyadirOpcion(op.getTexto(), op.getCorreccion());
						flag = true;
					}
				}
				
				if (flag == false) {
					JOptionPane.showMessageDialog(null, "Debes introducir al menos una opcion correcta", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					preguntasCreadas.add(nuevaPregunta);
					contPreguntas++;
					vaciarSeleccionPregunta();
					System.out.println("Cont preg: " + contPreguntas);
				}
			}
			
			
			
		}
		//Ejercicio finalizado
		else if (e.getSource().equals(pc.getFinalizar())) {
			System.out.println("Ejercicio registrado");
			String titulo = pc.getTTitulo().getText();
			//fechas
			String sini = pc.getTFIni().getText();
			String sfin = pc.getTFFin().getText();
			try {
				String[] siniTok = sini.split("-");
				if (sini.length() < 3) {
					throw new DateTimeException("Error");
				}
				if (sini.length() < 4 || siniTok[0].equals("") || siniTok[1].equals("") || siniTok[2].equals("")) {
					throw new DateTimeException("Error");
				}
				String sfinTok[] = sfin.split("-");
				if (sini.length() < 3 || siniTok[0].equals("") || siniTok[1].equals("") || siniTok[2].equals("")) {
					throw new DateTimeException("Error");
				}
			
				int anyoIni = Integer.parseInt(siniTok[0]);
				int mesIni = Integer.parseInt(siniTok[1]);
				int diaIni = Integer.parseInt(siniTok[2]);
				int anyoFin = Integer.parseInt(sfinTok[0]);
				System.out.println(sfinTok[1]);
				int mesFin = Integer.parseInt(sfinTok[1]);
				int diaFin = Integer.parseInt(sfinTok[2]);
			
				LocalDate fini = LocalDate.of(anyoIni, mesIni, diaIni);
				LocalDate ffin = LocalDate.of(anyoFin, mesFin, diaFin);
				if (fini.isAfter(ffin)) {
					throw new DateTimeException("Error");
				}
				if (pc.getTPonderacion().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Rellena el campo ponderacion", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Double ponderacion = Double.parseDouble(pc.getTPonderacion().getText());
					Boolean aleatorio = false;
					if (pc.seleccionAleat()) {
						aleatorio = true;
					}
					String comentarios;
					if (pc.getTNormas().getText() == null || pc.getTNormas().getText().equals("")) {
						comentarios = "";
					}
					else {
						comentarios = pc.getTNormas().getText();
					}
					Asignatura asig = rec.getAsignatura();
					
					Ejercicio nuevoEjercicio = new Ejercicio(titulo, fini, ffin, ponderacion, aleatorio, comentarios, asig);
					
					for (Pregunta p: preguntasCreadas) {
						nuevoEjercicio.anyadirPregunta(p);
					}
					if (nuevoEjercicio.isAleatorio()) {
						nuevoEjercicio.barajarPreguntas();
					}
					((Tema)rec).anyadirRecurso(nuevoEjercicio);
					
					SwingUtilities.getWindowAncestor(pc).setVisible(false);
					
					CPEntrada cpentrada;
					PEntrada pe = new PEntrada();
					try {
						cpentrada = new CPEntrada(pe);
						SapereAude.getInstance().setContentPane(CPEntrada.getPEntrada());
						SapereAude.getInstance().setVisible(true);
						SapereAude.getInstance().setSize(800, 600);
						
						pe.setControladorAtender(cpentrada);
						pe.setControladorCrear(cpentrada);
						pe.setControladorAtras(cpentrada);
						pe.setControladorGuardarAsignatura(cpentrada);
						pe.setControladorAtras2(cpentrada);
						pe.setControladorAceptar(cpentrada);
						pe.setControladorDenegar(cpentrada);
						pe.setControladorAsignaturas(cpentrada);
						pe.setControladorLogout(cpentrada);
						pe.setControladorAnyadir(cpentrada);
						pe.setControladorModificar(cpentrada);
						pe.setControladorEliminar(cpentrada);
						pe.setControladorVisibilidad(cpentrada);
						pe.setControladorAtras3(cpentrada);
						pe.setControladorAtras4(cpentrada);
						pe.setControladorListado(cpentrada);
						pe.setControladorExpulsar(cpentrada);
						pe.setControladorReadmitir(cpentrada);
						pe.setControladorAbrir(cpentrada);
						pe.setControladorNotas(cpentrada);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
				
			} catch(DateTimeException err) {
				System.out.println("Fechas erroneas");
				JOptionPane.showMessageDialog(null, "Fechas introducidas erroneas", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		
		
		//Logout
		else if (e.getSource().equals(pc.getLogout())) {
			try {
				app.guardarDatos();
			} catch (IOException e1) {
				System.out.println("Error guardando el sistema");
				e1.printStackTrace();
			}
			SwingUtilities.getWindowAncestor(pc).setVisible(false);
			System.exit(1);
		}
		

	}
	
	public PCreacion getPCreacion(){
		return this.pc;
	}
	
	
	/**
	 * Funcion auxiliar para resetear una opcion
	 */
	public void vaciarSeleccionOpcion() {
		pc.getTOpcion().setText("");
		pc.getTNumop().setText(Integer.toString(contOpciones));
		
		System.out.println("nueva opcion");
		pc.updateUI();
	}
	
	/**
	 * Funcion auxiliar para resetear una pregunta
	 */
	public void vaciarSeleccionPregunta() {
		pc.getTPregunta().setText("");
		pc.getTPeso().setText("1");
		pc.getTPenalizacion().setText("0");
		pc.getTNumero().setText(Integer.toString(contPreguntas));
		
		contCorrectas = 0;
		contOpciones = 1;
		vaciarSeleccionOpcion();
		
		System.out.println("nueva pregunta");
		pc.updateUI();
	}
	
	/**
	 * Funcion auxiliar para resetear un ejercicio
	 */
	public void vaciarSeleccionEjercicio() {
		pc.getTPonderacion().setText("1");
		pc.getTFIni().setText(LocalDate.now().toString());
		pc.getTFFin().setText(LocalDate.now().plusDays(7).toString());
		
		vaciarSeleccionPregunta();
		vaciarSeleccionOpcion();
		
		
		this.opcionesCreadas = new ArrayList<Opcion>();
		
		pc.updateUI();
	}
}