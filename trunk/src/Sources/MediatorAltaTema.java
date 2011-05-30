package Sources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GraphicUserInterfaces.AltaTemaGUI;


public class MediatorAltaTema implements ActionListener{

	private AltaTemaGUI GraphicUserInterface;
	public DataBasePosgreSQL  dataBase;
	private String userID;

	public MediatorAltaTema(String userID){
		this.userID=userID;
		dataBase = new DataBasePosgreSQL();
		GraphicUserInterface = new AltaTemaGUI();
		GraphicUserInterface.setActionListeners(this);
        show();
	}

	@SuppressWarnings("deprecation")
	private void show() {
		GraphicUserInterface.show();
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == GraphicUserInterface.getjButtonAgregar()) {
			try{
				String idLista = GraphicUserInterface.getJTFIDlista().getText();
				String pathTema = GraphicUserInterface.getJTFPathTema().getText();
				String titulo = GraphicUserInterface.getJTFTitulo().getText();
				String artista = GraphicUserInterface.getJTFArtista().getText();
				String album = GraphicUserInterface.getJTFAlbum().getText();
				String anio = GraphicUserInterface.getJTFAñio().getText();
				if(idLista.length()==0||pathTema.length()==0||titulo.length()==0||artista.length()==0||album.length()==0||anio.length()==0){
					JOptionPane.showMessageDialog(new JFrame(),"Alguno de los campos obligatorios estan vacio","",JOptionPane.ERROR_MESSAGE);
				}else{
					//resvisar que los datos sean correctos para evitar que la base de datos de exepciones
					dataBase.insertTema(userID,idLista,pathTema,titulo,artista,album,anio);
					JOptionPane.showMessageDialog(new JFrame(),"Tema Agregado","",JOptionPane.ERROR_MESSAGE);
					GraphicUserInterface.reset();
				}
			}catch(Exception q) {
        		System.out.println("Error en MediadorListar: "+q);
            }
		}else{
			GraphicUserInterface.dispose();
		}
	}

}