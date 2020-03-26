package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import aplicacion.Aplicacion;
import aplicacion.usuarios.Profesor;
import interfaces.Inicio;
import interfaces.SapereAude;
import interfaces.alumno.AEntrada;
import interfaces.profesor.PEntrada;

/**
 * Esta clase implementa el controlador asociado al panel de inicio
 * @author Andres y Francisco
 */
public class CInicio implements ActionListener {
	
	/** Jpanel al que vamos a dar funcionalidad */
	private Inicio ini;
	
	/**
	 * Constructoe de la clase
	 * @param ini : jpanel pertinente
	 */
	public CInicio(Inicio ini) {
		this.ini = ini;
	}
	
	/**
	 * Funcion que es llamada cada vez que se interacciona con un componente
	 * seleccionable del panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Aplicacion app = null;
		
		try {
			app = Aplicacion.getInstance();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		CPEntrada cpentrada;
		CAEntrada caentrada;
		
		try {
			
			if (e.getSource().equals(ini.getEntrar())) {
				if (app.identificarse(ini.getNuma().getText(), new String(ini.getPassword().getPassword()))) { /* Identificacion exitosa */
					//Oculta el panel actual para que tan solo aparezca el nuevo
					SwingUtilities.getWindowAncestor(ini).setVisible(false);
					if (app.getUsuarioAct() instanceof Profesor) { /* Logueado como profesor */
						//Creamos y lanzamos el panel de entrada para el profesor
						PEntrada pe = new PEntrada();
						cpentrada = new CPEntrada(pe);
						
						SapereAude.getInstance().setContentPane(CPEntrada.getPEntrada());
						SapereAude.getInstance().setVisible(true);
						SapereAude.getInstance().setSize(800, 600);
						
						//Llamamos a los controladores necesarios del nuevo panel
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

					} else { /* Logueado como alumno */
						//Creamos y lanzamos el panel de entrada para el alumno
						AEntrada ae = new AEntrada();
						caentrada = new CAEntrada(ae);
						
						SapereAude.getInstance().setContentPane(caentrada.getAEntrada());
						SapereAude.getInstance().setVisible(true);
						SapereAude.getInstance().setSize(800,600);
						
						//Llamamos a los controladores necesarios del nuevo panel
						ae.setControladorSolicitar(caentrada);
						ae.setControladorAtras(caentrada);
						ae.setControladorAtras2(caentrada);
						ae.setControladorLDisp(caentrada);
						ae.setControladorAsignaturas(caentrada);
						ae.setControladorLogout(caentrada);
						ae.setControladorAbrir(caentrada);
					}
					
				} else { /* Identificacion fallida */
					JOptionPane.showMessageDialog(null, "Error Identificacion Usuario", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (IOException e1) {
			System.out.println("Error accediendo a la aplicacion");
			e1.printStackTrace();
		}
		
	}

}
