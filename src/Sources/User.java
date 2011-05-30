package Sources;

public class User {
	
	private String IdUser;
	private String Name;
	private String PerfilDefec;
	
	public User() {
		IdUser=null;
		Name=null;
		PerfilDefec=null;
	}
	
	public User(String IdUser, String Name, String PerfilDefec){
		this.IdUser=IdUser;
		this.Name=Name;
		this.PerfilDefec=PerfilDefec;
	}
	
	public void setIdUser (String IdUser){
		this.IdUser=IdUser;
	}
	
	public void setName (String Name){
		this.Name=Name;
	}
	
	public void setPerfilDefec (String PerfilDefec){
		this.PerfilDefec=PerfilDefec;
	}
	
	public String getIdUser(){
		return IdUser;
	}
	
	public String getName(){
		return Name;
	}
	
	public String getPerfilDefec(){
		return PerfilDefec;
	}


}
