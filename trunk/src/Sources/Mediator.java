package Sources;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GraphicUserInterfaces.SelectUserGUI;

public class Mediator implements ActionListener{
	
	private SelectUserGUI GraphicUserInterface;
	public DataBasePosgreSQL  dataBase;

	public Mediator(){
		dataBase = new DataBasePosgreSQL();
		try {
			GraphicUserInterface = new SelectUserGUI(dataBase.getUsers());
		} catch (SQLException e) {
			System.out.println("Error al cargar los usuarios: "+e);
		}
		GraphicUserInterface.setActionListeners(this);
        show();
	}

	@SuppressWarnings("deprecation")
	private void show() {
		GraphicUserInterface.show();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
    	if (source == GraphicUserInterface.getjButtonAceptar()) {
            try{
            	if (GraphicUserInterface.getUserID()==null){
            		JOptionPane.showMessageDialog(new JFrame(),"No ha seleccionado un usuario","",JOptionPane.ERROR_MESSAGE);
            	}else{
            	String userID = GraphicUserInterface.getUserID();
            	new MainMenuMediator(userID);
            	}
                }catch(Exception q) {
                		System.out.println("Error en Mediador: "+q);
                }
       }
       else if (source == GraphicUserInterface.getjButtonCrear()){
    	   	new MediatorAltaUsuario();
       }else{
    	   try {
    		   GraphicUserInterface.setUsers(dataBase.getUsers());
    	   }catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
    	   }
       }
    }
}