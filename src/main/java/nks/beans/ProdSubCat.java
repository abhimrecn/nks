package nks.beans;

public class ProdSubCat {

	// Id  Name          ProdCatId  
	int  Id ,ProdCatId;
	String Name;
	public ProdSubCat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProdSubCat(int id, int prodCatId, String name) {
		super();
		Id = id;
		ProdCatId = prodCatId;
		Name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getProdCatId() {
		return ProdCatId;
	}
	public void setProdCatId(int prodCatId) {
		ProdCatId = prodCatId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "ProdSubCat [Id=" + Id + ", ProdCatId=" + ProdCatId + ", Name=" + Name + "]";
	}  
	
	
}
