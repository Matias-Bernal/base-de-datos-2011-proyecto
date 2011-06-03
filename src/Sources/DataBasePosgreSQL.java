package Sources;
import java.sql.*;
import java.util.Vector;

public class DataBasePosgreSQL {

	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/Proyecto";
	private static String username = "postgres";
	private static String password = "root";
	static Connection connection;

	public DataBasePosgreSQL(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Statement NuevoEstado() throws SQLException{
		try{
			Statement statement = connection.createStatement();
			return statement;
		} catch (Exception e) {
			throw new SQLException();
		}
	}
	
	public boolean existGenero(String nombreGenero) throws SQLException {
		try {	
			Statement statement = NuevoEstado();
			String query = "SELECT * FROM plarpebu.genero WHERE '"+nombreGenero+"' IN (SELECT nombreGenero from plarpebu.genero);";
			ResultSet resultSet;
			resultSet = statement.executeQuery(query);
			if (resultSet.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
				throw new SQLException();
		}
	}
	public boolean existOrden(String orden) throws SQLException {
		try {
			Statement statement = NuevoEstado();
			String query = "SELECT * FROM plarpebu.orden WHERE '"+orden+"' IN (SELECT num_orden from plarpebu.orden);";
			ResultSet resultSet;
			resultSet = statement.executeQuery(query);
			if (resultSet.next()){
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			throw new SQLException();
		}
	}

	public void insertUser(String nombre) throws SQLException {
		try {
			connection.setAutoCommit(false);
			Statement statement = NuevoEstado();
			String idperfilDefault = newPerfilDefault(nombre);
			String query = "INSERT INTO plarpebu.usuario VALUES (NEXTVAL('Plarpebu.usuario_id_seq'),'"+nombre+"',"+idperfilDefault+");";
			statement.executeUpdate(query);
			String id_usuario = lastUserID();
			query = "UPDATE plarpebu.perfil SET id_usuario = "+id_usuario+" WHERE id_perfil="+idperfilDefault+";";
			statement.executeUpdate(query);
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			throw new SQLException();
		}
	}

	private String newPerfilDefault(String nombre) throws SQLException {
		try {
			connection.setAutoCommit(false);
			Statement statement = NuevoEstado();
			String idRaizDefault = newRaizDefault(nombre);
			String query = "INSERT INTO plarpebu.perfil VALUES (NEXTVAL('Plarpebu.perfil_id_seq'),'Default_"+nombre+"',1,'default',"+idRaizDefault+",null);";
			statement.executeUpdate(query);
			query = "SELECT id_perfil FROM plarpebu.perfil ORDER BY id_perfil DESC;";
			ResultSet resultSet;
			String id = null;
			resultSet = statement.executeQuery(query);
			if(resultSet.next()){
				id = resultSet.getString(1);
			}
			connection.commit();
			return (id);
		} catch (Exception e) {
			connection.rollback();
			throw new SQLException();
		}
	}

	private String newRaizDefault(String nombre) throws SQLException {
		try{
			connection.setAutoCommit(false);
			Statement statement = NuevoEstado();
			String query = "INSERT INTO plarpebu.carpeta VALUES (NEXTVAL('Plarpebu.carpeta_id_seq'),'raiz_"+nombre+"',null);";
			statement.executeUpdate(query);
			String id_carpeta = ultimaCarpetaInsertada();
			query = "INSERT INTO plarpebu.raiz VALUES ('"+id_carpeta+"');";
			statement.executeUpdate(query);
			connection.commit();
			return id_carpeta;
		} catch (Exception e) {
			connection.rollback();
			throw new SQLException();
		}
		
	}

	private String ultimaCarpetaInsertada() throws SQLException {
		try {
			Statement statement = NuevoEstado();
			String query = "SELECT id_carpeta FROM plarpebu.carpeta ORDER BY id_carpeta DESC;";
			ResultSet resultSet;
			String id = null;
			resultSet = statement.executeQuery(query);
			if(resultSet.next()){
				id = resultSet.getString(1);
			}
			return (id);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	public Vector<User> getUsers() throws SQLException{
		try {
			Statement statement = NuevoEstado();
			String query = "SELECT * FROM plarpebu.USUARIO;";
			Vector<User> user = new Vector<User>();
			ResultSet resultSet;
			resultSet = statement.executeQuery(query);
			while (resultSet.next()){
				User userAc = new User();
				userAc.setIdUser(resultSet.getString(1));
				userAc.setName(resultSet.getString(2));
				userAc.setPerfilDefec(resultSet.getString(3));
				user.add(userAc);
			}
			return user;
		} catch (Exception e) {
			throw new SQLException();
		}

	}

	public String lastUserID() throws SQLException{
		try {
			Statement statement = NuevoEstado();
			String query = "SELECT id_usuario FROM plarpebu.usuario ORDER BY id_usuario DESC;";
			ResultSet resultSet;
			resultSet = statement.executeQuery(query);
			if(resultSet.next()){
				String id = resultSet.getString(1);
				return (id);
			}else{
				return("0");
			}
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	private Vector<String> listas(String idCarpeta) throws SQLException{
		try {
			Statement statement = NuevoEstado();
			String query = "SELECT * FROM plarpebu.lista l WHERE l.id_carpeta="+idCarpeta+";";
			Vector<String> list = new Vector<String>();
			ResultSet resultSet;
			resultSet = statement.executeQuery(query);
			while (resultSet.next()){
				list.add(resultSet.getString(1));
			}
			return list;
		} catch (Exception e) {
			throw new SQLException();
		}
	}
	public Vector<String> getList(String idCarpeta) throws SQLException {
		try {
			Statement statement = NuevoEstado();
			String query = "SELECT * FROM plarpebu.lista l WHERE l.id_carpeta="+idCarpeta+";";
			Vector<String> list = new Vector<String>();
			ResultSet resultSet;
			resultSet = statement.executeQuery(query);
			while (resultSet.next()){
				String listAc = new String();
				listAc="NOMBRE: "+resultSet.getString(2)+"- (ID LISTA: "+resultSet.getString(1)+")";
				list.add(listAc);
			}
			return list;
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	public void insertTema(String idLista, String pathTema,String titulo, String artista, String album, String anio, String nombreGenero, String duracion)throws SQLException {
		try {
			connection.setAutoCommit(false);
			Statement statement = NuevoEstado();
			String query;
			if (!existGenero(nombreGenero)){
				query = "INSERT INTO plarpebu.genero VALUES ('"+nombreGenero+"');";
				statement.executeUpdate(query);
			}
			query = "INSERT INTO plarpebu.tema VALUES ('"+pathTema+"',"+anio+",'"+titulo+"','"+artista+"','"+album+"','"+nombreGenero+"','"+duracion+"');";
			statement.executeUpdate(query);
			String orden = String.valueOf(ultimoOrden(idLista)+1);
			if (!existOrden(orden)){
				query = "INSERT INTO plarpebu.orden VALUES ("+orden+");";
				statement.executeUpdate(query);
			}
			query = "INSERT INTO plarpebu.se_repr VALUES ("+orden+","+idLista+",null,'"+pathTema+"');";
			statement.executeUpdate(query);
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			throw new SQLException();	
		}
	}

	private int ultimoOrden(String idLista) throws SQLException {
		try {
			Statement statement = NuevoEstado();
			String query = "SELECT num_orden FROM plarpebu.se_repr WHERE id_lista = "+idLista+" ORDER BY num_orden DESC;";
			ResultSet resultSet;
			resultSet = statement.executeQuery(query);
			if(resultSet.next()){
				String id = resultSet.getString(1);
				return (Integer.parseInt(id));
			}else{
				return(0);
			}
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	public void eliminarTema(String userID, String idLista, String pathTema)throws SQLException {
		try {
			connection.setAutoCommit(false);
			Statement statement = NuevoEstado();
			String query = "DELETE FROM plarpebu.se_repr WHERE path_tema='"+pathTema+"' AND id_lista='"+idLista+"';";
			statement.executeUpdate(query);
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			throw new SQLException();
		}
	}

	public boolean dueno(String userID, String idCarpeta) throws SQLException{
		Vector<String> carpetas = carpetasDe(userID);
		if (carpetas.contains(idCarpeta)){
			return true;
		}else{
			return false;
		}
	}

	private Vector<String> carpetasDe(String userID) throws SQLException {
		try {
			Statement statement = NuevoEstado();
			String query = "SELECT id_carpetaraiz FROM plarpebu.perfil p WHERE p.id_usuario="+userID+";";
			Vector<String> carpetasRaiz = new Vector<String>();
			ResultSet resultSet;
			resultSet = statement.executeQuery(query);
			while (resultSet.next()){
				String root = new String();
				root = resultSet.getString(1);
				carpetasRaiz.add(root);
			}
			Vector<String> carpetas = new Vector<String> (carpetasRaiz);
			int i=0;
			while (i<carpetasRaiz.size()){
				int index=0;
				Vector<String> subcarpetas = getCarpeta(carpetasRaiz.elementAt(i));
				while (index<subcarpetas.size()){
					carpetas.add(subcarpetas.elementAt(index));
					index++;
				}
				i++;
			}
			return carpetas;
		}catch (Exception e) {
			throw new SQLException();
		}
	}

	private Vector<String> getCarpeta(String idCarpeta)throws SQLException {
		try {
			Statement statement = NuevoEstado();
			Vector<String> carpetas = new Vector<String>();
			ResultSet resultSet;
			String query = "SELECT id_carpeta FROM plarpebu.carpeta c WHERE c.id_carpetapadre="+idCarpeta+";";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()){
				String root = new String();
				root = resultSet.getString(1);
				carpetas.add(root);
				Vector<String> subcarpetas = getCarpeta(root);
				int index=0;
				while (index<subcarpetas.size()){
					carpetas.add(subcarpetas.elementAt(index));
					index++;
				}
			}
			return carpetas;
		}catch (Exception e) {
			throw new SQLException();
		}
	}

	public boolean duenoLista(String userID, String idLista) throws SQLException{
		Vector<String> listas = listasDe(userID);
		if (listas.contains(idLista)){
			return true;
		}else{
			return false;
		}
	}

	private Vector<String> listasDe(String userID) throws SQLException {
		try {
			Vector<String> carpetas = carpetasDe(userID);
			Vector<String> listas = new Vector<String>();
			int index=0;
			while (index<carpetas.size()){
				listas.addAll(listas(carpetas.elementAt(index)));
				index++;
			}
			return listas;
		}catch (Exception e) {
			throw new SQLException();
		}
	}
}