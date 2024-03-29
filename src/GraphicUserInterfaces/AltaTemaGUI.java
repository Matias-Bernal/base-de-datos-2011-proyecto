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


public class AltaTemaGUI extends Frame{

	private static final long serialVersionUID = 1L;
	private JPanel jPanelPrincipal = null;
	private JButton jButtonCancelar = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JButton jButtonAgregar = null;
	private JLabel jLabelIDlista = null;
	private JTextField jTFIDlista = null;
	private JLabel jLabelPathTema = null;
	private JTextField jTFPathTema = null;
	private JLabel jLabelTitulo = null;
	private JTextField jTFTitulo = null;
	private JLabel jLabelArtista = null;
	private JTextField jTFArtista = null;
	private JLabel jLabelAlbum = null;
	private JTextField jTFAlbum = null;
	private JLabel jLabelAnio = null;
	private JTextField jTFA�io = null;
	private JLabel jLabelGenero = null;
	private JTextField jTFGenero = null;
	private JLabel jLabelDuracion = null;
	private JTextField jTFDuracionHoras = null;
	private JLabel jLabelmin = null;
	private JTextField jTFDuracionMinutos = null;
	private JLabel jLabelseg = null;
	private JTextField jTFDuracionSegundos = null;
	
	public AltaTemaGUI() {
		super();
		initialize();
	}

	private void initialize() {
        this.setSize(new Dimension(400, 400));
        this.setTitle("INSERTAR TEMA");
        this.add(getJPanelPrincipal(), BorderLayout.CENTER);
        this.add(getJLabel(), BorderLayout.SOUTH);
        this.add(getJLabel1(), BorderLayout.NORTH);
                		
	}

	public JPanel getJPanelPrincipal() {
		if (jPanelPrincipal == null) {
			jPanelPrincipal = new JPanel();
			jPanelPrincipal.setLayout(null);
			jPanelPrincipal.add(getjButtonCancelar(), null);
			jPanelPrincipal.add(getjButtonAgregar(), null);
			jPanelPrincipal.add(getJLabelIDlista(), null);
			jPanelPrincipal.add(getJTFIDlista(), null);
			jPanelPrincipal.add(getJLabelPathTema(), null);
			jPanelPrincipal.add(getJTFPathTema(), null);
			jPanelPrincipal.add(getJLabelTitulo(), null);
			jPanelPrincipal.add(getJTFTitulo(), null);
			jPanelPrincipal.add(getJLabelArtista(), null);
			jPanelPrincipal.add(getJTFArtista(), null);
			jPanelPrincipal.add(getJLabelAlbum(), null);
			jPanelPrincipal.add(getJTFAlbum(), null);
			jPanelPrincipal.add(getJLabelAnio(), null);
			jPanelPrincipal.add(getJTFA�io(), null);
			jPanelPrincipal.add(getJLabelGenero(), null);
			jPanelPrincipal.add(getJTFGenero(), null);
			jPanelPrincipal.add(getJLabelDuracion(), null);
			jPanelPrincipal.add(getJTFDuracionHoras(), null);
			jPanelPrincipal.add(getJLabelmin(), null);
			jPanelPrincipal.add(getJTFDuracionMinutos(), null);
			jPanelPrincipal.add(getJLabelseg(), null);
			jPanelPrincipal.add(getJTFDuracionSegundos(), null);
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

	public JButton getjButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setText("Insertar");
			jButtonAgregar.setBounds(new Rectangle(200, 250, 135, 45));
		}
		return jButtonAgregar;
	}

	private JLabel getJLabelIDlista() {
		if (jLabelIDlista == null) {
			jLabelIDlista = new JLabel();
			jLabelIDlista.setText("ID LISTA");
			jLabelIDlista.setHorizontalAlignment(JLabel.CENTER);
			jLabelIDlista.setBounds(new Rectangle(10, 10, 80, 25));
		}
		return jLabelIDlista;
	}

	public JTextField getJTFIDlista() {
		if (jTFIDlista == null) {
			jTFIDlista = new JTextField();
			jTFIDlista.setBounds(new Rectangle(100, 10, 250, 25));
		}
		return jTFIDlista;
	}

	private JLabel getJLabelPathTema() {
		if (jLabelPathTema == null) {
			jLabelPathTema = new JLabel();
			jLabelPathTema.setText("PATH TEMA");
			jLabelPathTema.setHorizontalAlignment(JLabel.CENTER);
			jLabelPathTema.setBounds(new Rectangle(10, 40, 80, 25));
		}
		return jLabelPathTema;
	}

	public JTextField getJTFPathTema() {
		if (jTFPathTema == null) {
			jTFPathTema = new JTextField();
			jTFPathTema.setBounds(new Rectangle(100, 40, 250, 25));
		}
		return jTFPathTema;
	}

	private JLabel getJLabelTitulo() {
		if (jLabelTitulo == null) {
			jLabelTitulo = new JLabel();
			jLabelTitulo.setText("TITULO");
			jLabelTitulo.setHorizontalAlignment(JLabel.CENTER);
			jLabelTitulo.setBounds(new Rectangle(10,70, 80, 25));
		}
		return jLabelTitulo;
	}

	public JTextField getJTFTitulo() {
		if (jTFTitulo == null) {
			jTFTitulo = new JTextField();
			jTFTitulo.setBounds(new Rectangle(100, 70, 250, 25));
		}
		return jTFTitulo;
	}

	private JLabel getJLabelArtista() {
		if (jLabelArtista == null) {
			jLabelArtista = new JLabel();
			jLabelArtista.setText("ARTISTA");
			jLabelArtista.setHorizontalAlignment(JLabel.CENTER);
			jLabelArtista.setBounds(new Rectangle(10,100, 80, 25));
		}
		return jLabelArtista;
	}

	public JTextField getJTFArtista() {
		if (jTFArtista == null) {
			jTFArtista = new JTextField();
			jTFArtista.setBounds(new Rectangle(100, 100, 250, 25));
		}
		return jTFArtista;
	}

	private JLabel getJLabelAlbum() {
		if (jLabelAlbum == null) {
			jLabelAlbum = new JLabel();
			jLabelAlbum.setText("ALBUM");
			jLabelAlbum.setHorizontalAlignment(JLabel.CENTER);
			jLabelAlbum.setBounds(new Rectangle(10, 130, 80, 25));
		}
		return jLabelAlbum;
	}

	public JTextField getJTFAlbum() {
		if (jTFAlbum == null) {
			jTFAlbum = new JTextField();
			jTFAlbum.setBounds(new Rectangle(100, 130, 250, 25));
		}
		return jTFAlbum;
	}

	private JLabel getJLabelAnio() {
		if (jLabelAnio == null) {
			jLabelAnio = new JLabel();
			jLabelAnio.setText("A�O");
			jLabelAnio.setHorizontalAlignment(JLabel.CENTER);
			jLabelAnio.setBounds(new Rectangle(10, 190, 80, 25));
		}
		return jLabelAnio;
	}

	public JTextField getJTFA�io() {
		if (jTFA�io == null) {
			jTFA�io = new JTextField();
			jTFA�io.setBounds(new Rectangle(100, 190, 50, 25));
		}
		return jTFA�io;
	}

	public void setActionListeners(ActionListener lis) {
		jButtonAgregar.addActionListener(lis);
		jButtonCancelar.addActionListener(lis);
	}

	public void reset() {
		jTFIDlista.setText(null);
		jTFPathTema.setText(null);
		jTFTitulo.setText(null);
		jTFArtista.setText(null);
		jTFAlbum.setText(null);
		jTFA�io.setText(null);
		jTFGenero.setText(null);
		jTFDuracionHoras.setText(null);
		jTFDuracionMinutos.setText(null);
		jTFDuracionSegundos.setText(null);
	}

	/**
	 * This method initializes jLabelGenero	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabelGenero() {
		if (jLabelGenero == null) {
			jLabelGenero = new JLabel();
			jLabelGenero.setText("GENERO");
			jLabelGenero.setHorizontalAlignment(JLabel.CENTER);
			jLabelGenero.setBounds(new Rectangle(10, 160, 80, 25));
		}
		return jLabelGenero;
	}

	/**
	 * This method initializes jTFGenero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTFGenero() {
		if (jTFGenero == null) {
			jTFGenero = new JTextField();
			jTFGenero.setBounds(new Rectangle(100, 160, 250, 25));
		}
		return jTFGenero;
	}

	/**
	 * This method initializes jLabelDuracion	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabelDuracion() {
		if (jLabelDuracion == null) {
			jLabelDuracion = new JLabel();
			jLabelDuracion.setText("DURACION");
			jLabelDuracion.setHorizontalAlignment(JLabel.CENTER);
			jLabelDuracion.setBounds(new Rectangle(10, 220, 80, 25));
		}
		return jLabelDuracion;
	}

	/**
	 * This method initializes jTFDuracionHoras	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTFDuracionHoras() {
		if (jTFDuracionHoras == null) {
			jTFDuracionHoras = new JTextField();
			jTFDuracionHoras.setBounds(new Rectangle(100, 220, 50, 25));
		}
		return jTFDuracionHoras;
	}

	/**
	 * This method initializes jLabelmin	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabelmin() {
		if (jLabelmin == null) {
			jLabelmin = new JLabel();
			jLabelmin.setText(":");
			jLabelmin.setHorizontalAlignment(JLabel.CENTER);
			jLabelmin.setBounds(new Rectangle(150, 220, 15, 25));
		}
		return jLabelmin;
	}

	/**
	 * This method initializes jTFDuracionMinutos	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTFDuracionMinutos() {
		if (jTFDuracionMinutos == null) {
			jTFDuracionMinutos = new JTextField();
			jTFDuracionMinutos.setBounds(new Rectangle(166, 220,50,25));
		}
		return jTFDuracionMinutos;
	}

	/**
	 * This method initializes jLabelseg	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabelseg() {
		if (jLabelseg == null) {
			jLabelseg = new JLabel();
			jLabelseg.setHorizontalAlignment(JLabel.CENTER);
			jLabelseg.setBounds(new Rectangle(217, 220, 15, 25));
			jLabelseg.setText(":");
		}
		return jLabelseg;
	}

	/**
	 * This method initializes jTFDuracionSegundos	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTFDuracionSegundos() {
		if (jTFDuracionSegundos == null) {
			jTFDuracionSegundos = new JTextField();
			jTFDuracionSegundos.setBounds(new Rectangle(233, 220, 50, 25));
		}
		return jTFDuracionSegundos;
	}
}