package Sources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GraphicUserInterfaces.MainMenuGUI;

public class MainMenuMediator implements ActionListener {
	
	private MainMenuGUI GraphicUserInterface;
	public DataBasePosgreSQL  dataBase;
	private String userID= null;

	public MainMenuMediator(String userID){
		this.userID=userID;
		dataBase = new DataBasePosgreSQL();
		GraphicUserInterface = new MainMenuGUI();
		GraphicUserInterface.setActionListeners(this);
        show();
	}

	@SuppressWarnings("deprecation")
	private void show() {
		GraphicUserInterface.show();
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == GraphicUserInterface.getJButtonAlta()) {
			try{
				new MediatorAltaTema(userID);
			}catch(Exception q) {
        		System.out.println("Error en MainMenuMediador.AltaTema: "+q);
            }
		}else{
			if (source == GraphicUserInterface.getJButtonEliminar()) {
				try{
					new MediatorEliminarTema(userID);
				}catch(Exception q) {
	        		System.out.println("Error en MainMenuMediador.EliminarTema: "+q);
	            }
			}else{
				if (source == GraphicUserInterface.getJButtonListar()) {
					try{
						new MediatorListar(userID);
					}catch(Exception q) {
		        		System.out.println("Error en MainMenuMediador.Listar: "+q);
		            }
				}else{
					GraphicUserInterface.dispose();
				}
			}
		}
	}

}