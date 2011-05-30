package Sources;
import java.sql.*;
import java.util.Vector;

public class DataBasePosgreSQL {

	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/Proyecto";
	private static String username = "postgres";
	private static String password = "root";

	public DataBasePosgreSQL(){}

	public static Statement NuevoEstado() throws SQLException{
		try{
			Class.forName(driver);
			Connection connection =	DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			return statement;
		} catch (Exception e) {
			throw new SQLException();
		}
	}
	
	public boolean exist(String dni) throws SQLException {
			Statement statement = NuevoEstado();
			String query = "SELECT * FROM persona.persona WHERE '"+dni+"' IN (select dni from persona.persona);";
			ResultSet resultSet;
			try {
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
	
	public static void insert(String dni,String nombre) throws SQLException{
		Statement statement = NuevoEstado();
		String query = "INSERT INTO persona.persona VALUES ("+dni+",'"+nombre+"');";
		try {
			statement.executeUpdate(query);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	public void insertUser(String nombre) throws SQLException {
		Statement statement = NuevoEstado();
		int id = Integer.parseInt(lastUserID())+1;
		String query = "INSERT INTO plarpebu.usuario VALUES ("+id+",'"+nombre+"',1);";
		try {
			statement.executeUpdate(query);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	public Vector<User> getUsers() throws SQLException{
		Statement statement = NuevoEstado();
		String query = "SELECT * FROM plarpebu.USUARIO;";
		Vector<User> user = new Vector<User>();
		ResultSet resultSet;
		try {
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
		Statement statement = NuevoEstado();
		String query = "SELECT id_usuario FROM plarpebu.usuario ORDER BY id_usuario DESC;";
		ResultSet resultSet;
		try {
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
//TERMINAR QUERY
	public Vector<String> getList(String idCarpeta) throws SQLException {
		Statement statement = NuevoEstado();
		String query = "SELECT * FROM plarpebu.lista l WHERE l.id_carpeta="+idCarpeta+";";
		Vector<String> list = new Vector<String>();
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(query);
			if (resultSet.next()){
				String listAc = new String();
				listAc="NOMBRE: "+resultSet.getString(2)+"- (ID LISTA: "+resultSet.getString(1)+")";
				list.add(listAc);
			}
			return list;
		} catch (Exception e) {
			throw new SQLException();
		}
	}
//TERMINAR QUERY
	public void insertTema(String userID, String idLista, String pathTema,String titulo, String artista, String album, String anio)throws SQLException {
		Statement statement = NuevoEstado();
		String query = "INSERT INTO plarpebu.persona VALUES ('"+pathTema+"','"+titulo+"','"+artista+"','"+album+"','"+anio+"');";
		try {
			statement.executeUpdate(query);
		} catch (Exception e) {
			throw new SQLException();
		}
	}
	//TERMINAR QUERY
	public void eliminarTema(String userID, String idLista, String pathTema)throws SQLException {
		Statement statement = NuevoEstado();
		String query = "INSERT INTO plarpebu.persona WHERE('"+pathTema+"');";
		try {
			statement.executeUpdate(query);
		} catch (Exception e) {
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
		Statement statement = NuevoEstado();
		String query = "SELECT id_carpetaraiz FROM plarpebu.perfil p WHERE p.id_usuario="+userID+";";
		Vector<String> carpetasRaiz = new Vector<String>();
		ResultSet resultSet;
		try {
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
		Statement statement = NuevoEstado();
		Vector<String> carpetas = new Vector<String>();
		ResultSet resultSet;
		String query = "SELECT id_carpeta FROM plarpebu.carpeta c WHERE c.id_carpetapadre="+idCarpeta+";";
		try {
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
}