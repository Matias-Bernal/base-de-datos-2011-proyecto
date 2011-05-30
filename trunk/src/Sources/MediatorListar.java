package Sources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GraphicUserInterfaces.ListarGUI;


public class MediatorListar implements ActionListener {

	private ListarGUI GraphicUserInterface;
	public DataBasePosgreSQL  dataBase;
	public String userID;

	public MediatorListar(String userID){
		this.userID=userID;
		dataBase = new DataBasePosgreSQL();
		GraphicUserInterface = new ListarGUI();
//		try {
//			GraphicUserInterface.setJList(dataBase.getList(userID));
//		} catch (SQLException e) {
//			System.out.println("Error al cargar los usuarios: "+e);
//		}
		GraphicUserInterface.setActionListeners(this);
        show();
	}
	
	@SuppressWarnings("deprecation")
	private void show() {
		GraphicUserInterface.show();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == GraphicUserInterface.getJButtonListar()) {
			try{
            	String idCarpeta = GraphicUserInterface.getJTFIDCarpeta().getText();
            	if(idCarpeta.length()==0){
            		JOptionPane.showMessageDialog(new JFrame(),"No ha ingresado un id carpeta","",JOptionPane.ERROR_MESSAGE);
            	}
            	//puede este usuario listar esta carpeta
            	if (!(dataBase.dueno(userID,idCarpeta))){
            		JOptionPane.showMessageDialog(new JFrame(),"No existe la carpeta","",JOptionPane.ERROR_MESSAGE);
				}else{Vector<String> listas = dataBase.getList(idCarpeta);
				GraphicUserInterface.setJList(listas);
				}
			}catch(Exception q) {
        		System.out.println("Error en MediadorListar: "+q);
            }
		}else{
			GraphicUserInterface.dispose();
		}
	}

}