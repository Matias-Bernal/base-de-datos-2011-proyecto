package GraphicUserInterfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EliminarTemaGUI extends Frame{

	private static final long serialVersionUID = 1L;
	private JPanel jPanelPrincipal = null;
	private JButton jButtonCancelar = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JButton jButtonEliminar = null;
	private JLabel jLabelIDlista = null;
	private JTextField jTFIDlista = null;
	private JLabel jLabelPathTema = null;
	private JTextField jTFPathTema = null;

	public EliminarTemaGUI() {
		super();
		initialize();
	}

	private void initialize() {
        this.setSize(new Dimension(400, 400));
        this.setTitle("ELIMINAR TEMA");
        this.add(getJPanelPrincipal(), BorderLayout.CENTER);
        this.add(getJLabel(), BorderLayout.SOUTH);
        this.add(getJLabel1(), BorderLayout.NORTH);
                		
	}

	public JPanel getJPanelPrincipal() {
		if (jPanelPrincipal == null) {
			jPanelPrincipal = new JPanel();
			jPanelPrincipal.setLayout(null);
			jPanelPrincipal.add(getjButtonCancelar(), null);
			jPanelPrincipal.add(getjButtonEliminar(), null);
			jPanelPrincipal.add(getJLabelIDlista(), null);
			jPanelPrincipal.add(getJTFIDlista(), null);
			jPanelPrincipal.add(getJLabelPathTema(), null);
			jPanelPrincipal.add(getJTFPathTema(), null);
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
			jLabel1.setText("INGRESE LOS DATOS DEL TEMA");
			jLabel1.setHorizontalAlignment(JLabel.CENTER);
		}
		return jLabel1;
	}

	public JButton getjButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.setBounds(new Rectangle(200, 250, 135, 45));
		}
		return jButtonEliminar;
	}

	private JLabel getJLabelIDlista() {
		if (jLabelIDlista == null) {
			jLabelIDlista = new JLabel();
			jLabelIDlista.setText("ID LISTA");
			jLabelIDlista.setHorizontalAlignment(JLabel.CENTER);
			jLabelIDlista.setBounds(new Rectangle(10, 15, 80, 25));
		}
		return jLabelIDlista;
	}

	public JTextField getJTFIDlista() {
		if (jTFIDlista == null) {
			jTFIDlista = new JTextField();
			jTFIDlista.setBounds(new Rectangle(100, 15, 250, 25));
		}
		return jTFIDlista;
	}

	private JLabel getJLabelPathTema() {
		if (jLabelPathTema == null) {
			jLabelPathTema = new JLabel();
			jLabelPathTema.setText("PATH TEMA");
			jLabelPathTema.setHorizontalAlignment(JLabel.CENTER);
			jLabelPathTema.setBounds(new Rectangle(10, 50, 80, 25));
		}
		return jLabelPathTema;
	}

	public JTextField getJTFPathTema() {
		if (jTFPathTema == null) {
			jTFPathTema = new JTextField();
			jTFPathTema.setBounds(new Rectangle(100, 50, 250, 25));
		}
		return jTFPathTema;
	}
	
	public void setActionListeners(ActionListener lis) {
		jButtonEliminar.addActionListener(lis);
		jButtonCancelar.addActionListener(lis);
	}

	public void reset() {
		jTFIDlista.setText(null);
		jTFPathTema.setText(null);		
	}

}