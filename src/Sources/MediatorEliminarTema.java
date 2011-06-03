package Sources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import GraphicUserInterfaces.EliminarTemaGUI;


public class MediatorEliminarTema implements ActionListener{

	private EliminarTemaGUI GraphicUserInterface;
	public DataBasePosgreSQL  dataBase;
	private String userID= null;

	public MediatorEliminarTema(String userID){
		this.userID=userID;
		dataBase = new DataBasePosgreSQL();
		GraphicUserInterface = new EliminarTemaGUI();
		GraphicUserInterface.setActionListeners(this);
        show();
	}
	
	@SuppressWarnings("deprecation")
	private void show() {
		GraphicUserInterface.show();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == GraphicUserInterface.getjButtonEliminar()) {
			try{
				String idLista = GraphicUserInterface.getJTFIDlista().getText();
				String pathTema = GraphicUserInterface.getJTFPathTema().getText();
				if(idLista.length()==0||pathTema.length()==0){
					JOptionPane.showMessageDialog(new JFrame(),"Alguno de los campos obligatorios estan vacio","",JOptionPane.ERROR_MESSAGE);
				}else{
					if (!(dataBase.duenoLista(userID,idLista))){
	            		JOptionPane.showMessageDialog(new JFrame(),"No existe la lista","",JOptionPane.ERROR_MESSAGE);
					}else{
						dataBase.eliminarTema(userID,idLista,pathTema);
						JOptionPane.showMessageDialog(new JFrame(),"Tema Eliminado","",JOptionPane.ERROR_MESSAGE);
						GraphicUserInterface.reset();
					}
				}
			}catch(Exception q) {
        		System.out.println("Error en MediadorEliminar: "+q);
            }
		}else{
			GraphicUserInterface.dispose();
		}
	}

}
