package nks.beans;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable{
	private int Id,ProdCatId,SubCatId,Maxquant;
	private String Name,qunatdesc,ShortDesc,DetailedDesc,Image;
	private Float price;
	
	
	
	
	public Product() {
		
	}
	public Product(int name2, int maxquant2, String qunatdesc2, String shortDesc2, String detailedDesc2, Float price2) {
	
		this.Id = name2;
		this.Maxquant = maxquant2;
		this.qunatdesc = qunatdesc2;
		this.ShortDesc = shortDesc2;
		this.DetailedDesc =detailedDesc2;
		this.price = price2;
	}
	public Product(int id, int prodCatId, int subCatId, int maxquant, String name, String qunatdesc, String shortDesc,
			String detailedDesc, String image, Float price) {
		super();
		Id = id;
		ProdCatId = prodCatId;
		SubCatId = subCatId;
		Maxquant = maxquant;
		Name = name;
		this.qunatdesc = qunatdesc;
		ShortDesc = shortDesc;
		DetailedDesc = detailedDesc;
		Image = image;
		this.price = price;
	}
	//ProdCatId,SubCatId,Maxquant,Name,qunatdesc,ShortDesc,DetailedDesc,Image,price
	public Product( int prodCatId, int subCatId, int maxquant, String name, String qunatdesc, String shortDesc,
			String detailedDesc, String image, Float price) {
		super();
		Id = 0;
		ProdCatId = prodCatId;
		SubCatId = subCatId;
		Maxquant = maxquant;
		Name = name;
		this.qunatdesc = qunatdesc;
		ShortDesc = shortDesc;
		DetailedDesc = detailedDesc;
		Image = image;
		this.price = price;
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
	public int getSubCatId() {
		return SubCatId;
	}
	public void setSubCatId(int subCatId) {
		SubCatId = subCatId;
	}
	public int getMaxquant() {
		return Maxquant;
	}
	public void setMaxquant(int maxquant) {
		Maxquant = maxquant;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getQunatdesc() {
		return qunatdesc;
	}
	public void setQunatdesc(String qunatdesc) {
		this.qunatdesc = qunatdesc;
	}
	public String getShortDesc() {
		return ShortDesc;
	}
	public void setShortDesc(String shortDesc) {
		ShortDesc = shortDesc;
	}
	public String getDetailedDesc() {
		return DetailedDesc;
	}
	public void setDetailedDesc(String detailedDesc) {
		DetailedDesc = detailedDesc;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", ProdCatId=" + ProdCatId + ", SubCatId=" + SubCatId + ", Maxquant=" + Maxquant
				+ ", Name=" + Name + ", qunatdesc=" + qunatdesc + ", ShortDesc=" + ShortDesc + ", DetailedDesc="
				+ DetailedDesc + ", Image=" + Image + ", price=" + price + "]";
	}
	@Override
	public int compareTo(Product p) {
		
		if(this.getId()==p.getId())  
			return 0;  
			else if(this.getId()>p.getId())  
			return 1;  
			else  
			return -1;  
			 
		
	}
	
	

}
