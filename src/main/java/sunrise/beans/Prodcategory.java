package sunrise.beans;



public class Prodcategory {
	
	
	@Override
	public String toString() {
		return "Prodcategory [CatID=" + CatID + ", Name=" + Name + "]";
	}
	private int CatID;
	private String Name;
	
	public Prodcategory(int catID, String name) {
		super();
		CatID = catID;
		Name = name;
	}
	public Prodcategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCatID() {
		return CatID;
	}
	public void setCatID(int catID) {
		CatID = catID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	

}
