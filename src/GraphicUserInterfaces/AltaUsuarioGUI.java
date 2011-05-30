package GraphicUserInterfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AltaUsuarioGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel jPanelPrincipal = null;
	private JButton jButtonCancelar = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JButton jButtonCrear = null;
	private JTextField jtfNombreUsuario = null;
	
	public AltaUsuarioGUI() {
		super();
		initialize();
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initialize() {
        this.setSize(new Dimension(400, 400));
        this.setTitle("ALTA DE USUARIO");
        this.add(getJPanelPrincipal(), BorderLayout.CENTER);
        this.add(getJLabel(), BorderLayout.SOUTH);
        this.add(getJLabel1(), BorderLayout.NORTH);
                		
	}
	
	public JPanel getJPanelPrincipal() {
		if (jPanelPrincipal == null) {
			jPanelPrincipal = new JPanel();
			jPanelPrincipal.setLayout(null);
			jPanelPrincipal.add(getjButtonCancelar(), null);
			jPanelPrincipal.add(getJButtonCrear(), null);
			jPanelPrincipal.add(getJtfNombreUsuario(), null);
		}
		return jPanelPrincipal;
	}
	
	public JButton getjButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(new Rectangle(50, 250, 135, 45));
		}
		return jButtonCancelar;
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
			jLabel1.setText("INGRESE EL NOMBRE DEL NUEVO USUARIO");
			jLabel1.setHorizontalAlignment(JLabel.CENTER);
		}
		return jLabel1;
	}

	public void setActionListeners(ActionListener lis) {
		jButtonCrear.addActionListener(lis);
		jButtonCancelar.addActionListener(lis);
	}

	public JButton getJButtonCrear() {
		if (jButtonCrear == null) {
			jButtonCrear = new JButton();
			jButtonCrear.setText("Crear Usuario");
			jButtonCrear.setBounds(new Rectangle(200, 250, 135, 45));
		}
		return jButtonCrear;
	}

	private JTextField getJtfNombreUsuario() {
		if (jtfNombreUsuario == null) {
			jtfNombreUsuario = new JTextField();
			jtfNombreUsuario.setBounds(new Rectangle(50, 100, 285, 20));
		}
		return jtfNombreUsuario;
	}
	
	public String getNombreUsuario(){
		return(jtfNombreUsuario.getText());
	}

}