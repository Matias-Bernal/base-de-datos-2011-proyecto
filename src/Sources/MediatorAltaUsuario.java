package Sources;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GraphicUserInterfaces.AltaUsuarioGUI;

public class MediatorAltaUsuario implements ActionListener{

	private AltaUsuarioGUI GraphicUserInterface;
	public DataBasePosgreSQL  dataBase;

	public MediatorAltaUsuario(){
		dataBase = new DataBasePosgreSQL();
		GraphicUserInterface = new AltaUsuarioGUI();
		GraphicUserInterface.setActionListeners(this);
        show();
	}

	@SuppressWarnings("deprecation")
	private void show() {
		GraphicUserInterface.show();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
    	if (source == GraphicUserInterface.getJButtonCrear()) {
            try{
            	String user = GraphicUserInterface.getNombreUsuario();
            	if(user.length()==0){
            		JOptionPane.showMessageDialog(new JFrame(),"No ha ingresado un nombre","",JOptionPane.ERROR_MESSAGE);
            	}
            	else{
                	if(user.length()>40){
                		JOptionPane.showMessageDialog(new JFrame(),"Nombre Demasiado Largo","",JOptionPane.ERROR_MESSAGE);
                	}else{
            		dataBase.insertUser(user);
            		String userID = dataBase.lastUserID();
            		GraphicUserInterface.dispose();
            		new MainMenuMediator(userID);
                	}
            	}
             }catch(Exception q) {
               	JOptionPane.showMessageDialog(new JFrame(),"Error en la Base de Datos","",JOptionPane.ERROR_MESSAGE);
             }
       }
       else if (source == GraphicUserInterface.getjButtonCancelar()) {
    	   GraphicUserInterface.dispose();
       }  			
    }

}
