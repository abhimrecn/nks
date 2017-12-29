package sunrise.DAO;

import java.util.Hashtable;
import java.util.List;

import sunrise.beans.ProdSubCat;
import sunrise.beans.Prodcategory;

public interface CategoryDAO {

	public int create(Prodcategory cat);
	public List<String> getAllProductCategories();
	

	public Prodcategory find1(int id);
	
	// id and CAtegory name;
	public List<Prodcategory> GetAllMainProductCAtegories();
	
	//subcategory name list 
	public List<String> getSubCategories(String prodCat);
	
	public List<Prodcategory> getSubCategories_By_Main_category_id(int prodCat);
	
	public List<Prodcategory> getSubCategories_In_Id__Name_Format(String prodCat);
	
	
	public Hashtable<String,List<String>> GetCategoryAndSubCategory();
	
	public Hashtable<Prodcategory,List<Prodcategory>>GetCategoryAndSubCategory_in_Id_Name_Format();
	
	public List<ProdSubCat> getSubProductCategories(int prodCat);
	
	
	public String GetCategory_and_SubCategory_toShow();
	
	
	
	public int getProductCategoryID(String id);
	
	public int saveCatgory(String p);
	
	public int saveSubCategory(String name,int id);


}
