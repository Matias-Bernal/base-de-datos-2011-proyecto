package GraphicUserInterfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuGUI extends JFrame{
		private static final long serialVersionUID = 1L;
		private JPanel jPanelPrincipal = null;
		private JButton jButtonCerrarSesion = null;
		private JLabel jLabel = null;
		private JLabel jLabel1 = null;
		private JButton jButtonAlta = null;
		private JButton jButtonEliminar = null;
		private JButton jButtonListar = null;
		
		public MainMenuGUI() {
			super();
			initialize();
		}
		private void initialize() {
	        this.setSize(new Dimension(400, 400));
	        this.setTitle("MENU PRINCIPAL");
	        this.add(getJPanelPrincipal(), BorderLayout.CENTER);
	        this.add(getJLabel(), BorderLayout.SOUTH);
	        this.add(getJLabel1(), BorderLayout.NORTH);
	                		
		}
		
		public JPanel getJPanelPrincipal() {
			if (jPanelPrincipal == null) {
				jPanelPrincipal = new JPanel();
				jPanelPrincipal.setLayout(null);
				jPanelPrincipal.add(getjButtonCerrarSesion(), null);
				jPanelPrincipal.add(getJButtonAlta(), null);
				jPanelPrincipal.add(getJButtonEliminar(), null);
				jPanelPrincipal.add(getJButtonListar(), null);
			}
			return jPanelPrincipal;
		}

		public JButton getjButtonCerrarSesion() {
			if (jButtonCerrarSesion == null) {
				jButtonCerrarSesion = new JButton();
				jButtonCerrarSesion.setText("Cerrar Sesion");
				jButtonCerrarSesion.setBounds(new Rectangle(125, 250, 135, 45));
			}
			return jButtonCerrarSesion;
		}
		
		private JLabel getJLabel() {
			if (jLabel == null) {
				jLabel = new JLabel();
				jLabel.setHorizontalAlignment(JLabel.CENTER);
				jLabel.setText("BASES DE DATOS-UNRC-2011");
			}
			return jLabel;
		}

		private JLabel getJLabel1() {
			if (jLabel1 == null) {
				jLabel1 = new JLabel();
				jLabel1.setText("INGRESE LA OPCION DESEADA");
				jLabel1.setHorizontalAlignment(JLabel.CENTER);
			}
			return jLabel1;
		}
		/**
		 * This method initializes jButtonAlta	
		 * 	
		 * @return javax.swing.JButton	
		 */
		public JButton getJButtonAlta() {
			if (jButtonAlta == null) {
				jButtonAlta = new JButton();
				jButtonAlta.setText("INSERTAR TEMA");
				jButtonAlta.setBounds(new Rectangle(75, 50, 250, 45));
			}
			return jButtonAlta;
		}
		/**
		 * This method initializes jButtonEliminar	
		 * 	
		 * @return javax.swing.JButton	
		 */
		public JButton getJButtonEliminar() {
			if (jButtonEliminar == null) {
				jButtonEliminar = new JButton();
				jButtonEliminar.setText("ELIMINAR TEMA");
				jButtonEliminar.setBounds(new Rectangle(75, 100, 250, 45));
			}
			return jButtonEliminar;
		}
		/**
		 * This method initializes jButtonListar	
		 * 	
		 * @return javax.swing.JButton	
		 */
		public JButton getJButtonListar() {
			if (jButtonListar == null) {
				jButtonListar = new JButton();
				jButtonListar.setText("LISTAS");
				jButtonListar.setBounds(new Rectangle(75, 150, 250, 45));
			}
			return jButtonListar;
		}
		
		public void setActionListeners(ActionListener lis) {
			jButtonAlta.addActionListener(lis);
			jButtonEliminar.addActionListener(lis);
			jButtonListar.addActionListener(lis);
			jButtonCerrarSesion.addActionListener(lis);
		}
}
