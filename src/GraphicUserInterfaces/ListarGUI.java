package GraphicUserInterfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;


public class ListarGUI extends Frame{
	
	private static final long serialVersionUID = 1L;
	private JPanel jPanelPrincipal = null;
	private JButton jButtonCancelar = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabelIDCarpeta = null;
	private JTextField jTFIDCarpeta = null;
	private JScrollPane jScrollPane = null;
	private JList jList = null;
	private JButton jButtonListar = null;
	
	public ListarGUI() {
		super();
		initialize();
	}
	
	private void initialize() {
        this.setSize(new Dimension(400, 400));
        this.setTitle("LISTAS DE REPRODUCCION");
        this.add(getJPanelPrincipal(), BorderLayout.CENTER);
        this.add(getJLabel(), BorderLayout.SOUTH);
        this.add(getJLabel1(), BorderLayout.NORTH);
                		
	}
	
	public JPanel getJPanelPrincipal() {
		if (jPanelPrincipal == null) {
			jPanelPrincipal = new JPanel();
			jPanelPrincipal.setLayout(null);
			jPanelPrincipal.add(getjButtonCancelar(), null);
			jPanelPrincipal.add(getJLabelIDCarpeta(), null);
			jPanelPrincipal.add(getJTFIDCarpeta(), null);
			jPanelPrincipal.add(getJScrollPane(), null);
			jPanelPrincipal.add(getJButtonListar(), null);
		}
		return jPanelPrincipal;
	}

	public JButton getjButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(new Rectangle(200, 280, 135, 45));
		}
		return jButtonCancelar;
	}
	
	public JButton getJButtonListar() {
		if (jButtonListar == null) {
			jButtonListar = new JButton();
			jButtonListar.setText("Listar");
			jButtonListar.setBounds(new Rectangle(40, 280, 135, 45));
		}
		return jButtonListar;
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
			jLabel1.setText("INGRESE LA IDE DE LA CARPETA Y SE LISTARAN SUS LISTAS");
			jLabel1.setHorizontalAlignment(JLabel.CENTER);
		}
		return jLabel1;
	}

	public void setJList(Vector<String> listData){
			jList.setListData(listData);
	}
	
	public void setActionListeners(ActionListener lis) {
		jButtonCancelar.addActionListener(lis);
		jButtonListar.addActionListener(lis);
	}

	private JLabel getJLabelIDCarpeta() {
		if (jLabelIDCarpeta == null) {
			jLabelIDCarpeta = new JLabel();
			jLabelIDCarpeta.setText("ID CARPETA");
			jLabelIDCarpeta.setHorizontalAlignment(JLabel.CENTER);
			jLabelIDCarpeta.setBounds(new Rectangle(5, 5, 75, 25));
		}
		return jLabelIDCarpeta;
	}

	public JTextField getJTFIDCarpeta() {
		if (jTFIDCarpeta == null) {
			jTFIDCarpeta = new JTextField();
			jTFIDCarpeta.setBounds(new Rectangle(85, 5, 295, 25));
		}
		return jTFIDCarpeta;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(5, 35, 375, 240));
			jScrollPane.setViewportView(getJList());
		}
		return jScrollPane;
	}

	private JList getJList() {
		if (jList == null) {
			jList = new JList();
		}
		return jList;
	}
}