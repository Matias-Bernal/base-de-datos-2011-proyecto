package GraphicUserInterfaces;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Sources.User;

public class SelectUserGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel jPanelPrincipal = null;
	private Choice choice = null;
	private JButton jButtonAceptar = null;
	private JButton jButtonCrear = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private Vector<User> users = null;
	private JButton jButtonActualizar = null;
	
	public SelectUserGUI(Vector<User> users) {
		super();
		this.users=users;
		initialize();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initialize() {
        this.setSize(new Dimension(400, 400));
        this.setTitle("SELECCION DE USUARIO");
        this.add(getJPanelPrincipal(), BorderLayout.CENTER);
        this.add(getJLabel(), BorderLayout.SOUTH);
        this.add(getJLabel1(), BorderLayout.NORTH);
                		
	}
	
	public JPanel getJPanelPrincipal() {
		if (jPanelPrincipal == null) {
			jPanelPrincipal = new JPanel();
			jPanelPrincipal.setLayout(null);
			jPanelPrincipal.add(getjButtonAceptar(), null);
			jPanelPrincipal.add(getjButtonCrear(), null);
			jPanelPrincipal.add(getChoice(), null);
			jPanelPrincipal.add(getJButtonActualizar(), null);
		}
		return jPanelPrincipal;
	}
	
	public void setActionListeners(ActionListener lis) {
		jButtonCrear.addActionListener(lis);
		jButtonAceptar.addActionListener(lis);
		jButtonActualizar.addActionListener(lis);
	}

	@SuppressWarnings("deprecation")
	public String getUserID(){
		if(choice.countItems()==0){
			return null;
		}else{
			int indexini = choice.getSelectedItem().lastIndexOf("(ID: ");
			int indexfin = choice.getSelectedItem().lastIndexOf(")");
			String IdUser = choice.getSelectedItem().substring(indexini+5, indexfin);
			return(IdUser);		
		}
	}
	
	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			int i=0;
			while (i<users.size()){
					choice.addItem(users.get(i).getName()+" - (ID: "+users.get(i).getIdUser()+")");
					i++;
			}
			choice.setBounds(new Rectangle(40, 25, 300, 20));
		}
		return choice;
	}
	
	public void setUsers(Vector<User> users){
		this.users=users;
		choice.removeAll();
		int i=0;
		while (i<users.size()){
			choice.addItem(users.get(i).getName()+" - (ID: "+users.get(i).getIdUser()+")");
			i++;
		}
	}

	public JButton getjButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar.setBounds(new Rectangle(50, 250, 135, 45));
		}
		return jButtonAceptar;
	}

	public JButton getjButtonCrear() {
		if (jButtonCrear == null) {
			jButtonCrear = new JButton();
			jButtonCrear.setText("Crear Usuario");
			jButtonCrear.setBounds(new Rectangle(200, 250, 135, 45));
		}
		return jButtonCrear;
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
			jLabel1.setText("INGRESE EL USUARIO O CREE UNO NUEVO PARA COMENZAR");
			jLabel1.setHorizontalAlignment(JLabel.CENTER);
		}
		return jLabel1;
	}	
	
	private JButton getJButtonActualizar() {
		if (jButtonActualizar == null) {
			jButtonActualizar = new JButton();
			jButtonActualizar.setBounds(new Rectangle(345, 25, 30, 20));
			jButtonActualizar.setIcon(new ImageIcon("src\\GraphicUserInterfaces\\1.gif"));
		}
		return jButtonActualizar;
	}

}