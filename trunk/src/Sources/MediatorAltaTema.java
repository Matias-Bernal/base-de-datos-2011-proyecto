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
				String nombreGenero = GraphicUserInterface.getJTFGenero().getText();
				String hs = GraphicUserInterface.getJTFDuracionHoras().getText();
				String min = GraphicUserInterface.getJTFDuracionMinutos().getText();
				String seg = GraphicUserInterface.getJTFDuracionSegundos().getText();
				if(idLista.length()==0||pathTema.length()==0||titulo.length()==0||artista.length()==0||album.length()==0||anio.length()==0||nombreGenero.length()==0||
					hs.length()==0||min.length()==0||seg.length()==0){
					JOptionPane.showMessageDialog(new JFrame(),"Alguno de los campos obligatorios estan vacio","",JOptionPane.ERROR_MESSAGE);
				}else{
					int horas = Integer.parseInt(hs);
					int minutos = Integer.parseInt(min);
					int segundos = Integer.parseInt(seg);
					if ((horas>23)||(horas<0)||(minutos>59)||(minutos<0)||(segundos>59)||(segundos<0)){
						JOptionPane.showMessageDialog(new JFrame(),"Duracion Incorrecta","",JOptionPane.ERROR_MESSAGE);
					}else{
						if(anio.length()!=4){
							JOptionPane.showMessageDialog(new JFrame(),"Error en Años","",JOptionPane.ERROR_MESSAGE);	
						}else{
							String duracion = hs+":"+min+":"+seg;
							if (!(dataBase.duenoLista(userID,idLista))){
			            		JOptionPane.showMessageDialog(new JFrame(),"No existe la lista","",JOptionPane.ERROR_MESSAGE);
							}else{
								dataBase.insertTema(idLista,pathTema,titulo,artista,album,anio,nombreGenero,duracion);
								JOptionPane.showMessageDialog(new JFrame(),"Tema Agregado","",JOptionPane.INFORMATION_MESSAGE);
								GraphicUserInterface.reset();
							}
						}
					}
				}
			}catch(Exception q) {
				System.out.println("Error en MediadorAltaTema: "+q);
            }
		}else{
			GraphicUserInterface.dispose();
		}
	}

}