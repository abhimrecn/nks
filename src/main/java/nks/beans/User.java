package nks.beans;



public class User {

	
	private int type;
	private String uid;
	private String password;
	
	
	
	
	
	public User(int type, String uid, String password) {
		super();
		this.type = type;
		this.uid = uid;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
