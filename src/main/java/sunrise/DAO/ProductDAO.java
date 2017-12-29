package sunrise.DAO;

import java.util.List;
import java.util.TreeMap;

import sunrise.beans.Prodcategory;
import sunrise.beans.Product;

public interface ProductDAO {
	public int saveProduct(Product p);
	public int updateProduct(Product p);
	public int deleteProduct(int id);
	public Product getProduct(int id);
	public List<Product> getALLProduct();
	
	
	// get products from Category of product ie.new paper ,milk,flowers etc
	public List<Product> getProductOfProdCategory(String Prodcategory);
	public List<Product> getProductOfProdCategoryID(int ProdcategoryID);
	
	// get product from subcategory ie.-cow milk, buffalo milk
	public List<Product> getProductOfSubcategory(String subCategory);
	public List<Product> getProductOfSubcategoryID(int subCategoryID);
	
	
	public String ToShowGetProductBy_ProdCat(int id); 
	public String ToShowGetProductBy_SubCat(int id);
	public String ToShowProductDetails(int id);
	public String ToShowproductSliderOnHomePage();
	
	public String ToShowAllProduct();
	
	public String ToShowCartDetails(TreeMap<Product,Integer> t);
	public int getProd(String name);
		
	
	}

