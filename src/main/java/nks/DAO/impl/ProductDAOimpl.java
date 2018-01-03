package nks.DAO.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import nks.DAO.ProductDAO;
import nks.beans.Prodcategory;
import nks.beans.Product;
import nks.mapper.ProductMapper;

public class ProductDAOimpl implements ProductDAO {

	@Autowired
	protected JdbcTemplate jdbcTemplate;  

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public int saveProduct(Product p) {
		System.out.println(p);
		String Query="insert into product (Name,ProdCatId,SubCatId,qunatdesc,Maxquant,price,ShortDesc,DetailedDesc,Image) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(Query, new Object[]{p.getName(),p.getProdCatId(),p.getSubCatId(),p.getQunatdesc(),p.getMaxquant(),p.getPrice(),p.getShortDesc(),p.getDetailedDesc(),p.getImage()});
		
	}

	@Override
	public int updateProduct(Product p) {
		
		System.out.println(p);
		String Query="update product set qunatdesc=?, Maxquant=?, price=?, ShortDesc=?, DetailedDesc=?  where Id= ? ";
		/*String Query="insert into product (qunatdesc,Maxquant,price,ShortDesc,DetailedDesc) "
				+ "values(?,?,?,?,?)";*/
		return jdbcTemplate.update(Query, new Object[]{p.getQunatdesc(),p.getMaxquant(),p.getPrice(),p.getShortDesc(),p.getDetailedDesc(),p.getId()});
	
	}

	@Override
	public int deleteProduct(int Id) {
		String Query="delete from  product  WHERE Id=?";
		
		 return jdbcTemplate.update(Query, new Object[]{Id});
	}



	@Override
	public Product getProduct(int id) {
		String Query="select * from product where Id=? and Name!='0'";
		System.out.println(Query);
		Product p=new Product();
		List<Product> list=(List<Product>) jdbcTemplate.query(Query, new Object[]{id},new ProductMapper());
		for(Product p1:list)
		{
			p=p1;
			System.out.println("product is"+p.toString());
		}
		return p;
	}

	@Override
	public List<Product> getALLProduct() {
		String Query="select * from product where Name!='0'";
		return jdbcTemplate.query(Query,new ProductMapper());
	}


	@Override
	public List<Product> getProductOfProdCategory(String Prodcategory) {
		String Query="SELECT * FROM product p,prodcats pc WHERE p.prodcatid=pc.id AND pc.name=? and p.Name!='0'";
		return jdbcTemplate.query(Query,new Object[] {Prodcategory},new ProductMapper());
	}

	@Override
	public List<Product> getProductOfProdCategoryID(int ProdcategoryID) {
		String Query= "SELECT * FROM product p,prodcats pc WHERE p.prodcatid=pc.id AND pc.id=? and p.Name!='0'";
		return jdbcTemplate.query(Query,new Object[] {ProdcategoryID},new ProductMapper());
	}

	@Override
	public List<Product> getProductOfSubcategory(String subCategory) {
		String Query= "SELECT * FROM product p, prodsubcat sc WHERE p.subcatid=sc.id AND sc.name=? and p.Name!='0'";
		return jdbcTemplate.query(Query,new Object[] {subCategory},new ProductMapper());
	}

	@Override
	public List<Product> getProductOfSubcategoryID(int subCategoryID) {
		String Query="SELECT * FROM product p, prodsubcat sc WHERE p.subcatid=sc.id AND sc.id=? and p.Name!='0'"; 
		return jdbcTemplate.query(Query,new Object[] {subCategoryID},new ProductMapper());
	}

	
	
	@Override
	public String ToShowGetProductBy_ProdCat(int id) {
		
		String str="";
		List<Product> list1 =getProductOfProdCategoryID(id);
		for( Product p : list1)
		{
			str+="<li class='span3'><div class='thumbnail'><a class='GetDetails' href='#showInfo' value='"+ p.getId() +"'><img style='width:200px;height:150px;' src='"+ p.getImage() +"' alt=''/></a><div class='caption'>";
			str+="<h5>"+p.getName()+"</h5>";
			str+="<p>"+p.getShortDesc()+"</p>";
		
			str+="<h4 style='text-align:center'><a class='btn GetDetails' href='#showInfo' value='"+ p.getId() +"'> <i class='icon-zoom-in'></i></a> <a class='btn addToCart' value='"+p.getId()+"' href='#showInfo'>Add to <i class='icon-shopping-cart'></i></a> <i class='btn btn-primary' >Rs"+p.getPrice()+"</i></h4>";
			str+="</div></div></li>";		
		}
		 System.out.println(str);
		return str;
	}

	@Override
	public String ToShowGetProductBy_SubCat(int id) {
		String str="";
		List<Product> list2 = getProductOfSubcategoryID(id);
		
		for( Product p : list2)
		{
			str+="<li class='span3'><div class='thumbnail'><a class='GetDetails' href='#showInfo' value='"+ p.getId() +"'><img style='width:200px;height:150px;' src='"+ p.getImage() +"' alt=''/></a><div class='caption'>";
			str+="<h5>"+p.getName()+"</h5>";
			
			str+="<p>"+p.getShortDesc()+"</p>";
			
			str+="<h4 style='text-align:center'><a class='btn GetDetails' href='#showInfo' value='"+ p.getId() +"'> <i class='icon-zoom-in'></i></a> <a class='btn addToCart' value='"+p.getId()+"'href='#showInfo'>Add to <i class='icon-shopping-cart'></i></a> <a class='btn btn-primary addToCart' value='"+p.getId()+"' href='#'>Rs"+p.getPrice()+"</a></h4>";
			str+="</div></div></li>";		
		}
		 
		return str;
	}

	@Override
	public String ToShowProductDetails(int id) {
		Product p=getProduct(id);
		System.out.println("*******************");
		System.out.println(p.toString());
		System.out.println("*******************");
		
		String str="<div class='span9'> <ul class='breadcrumb'> <li><span class='divider'></span></li> <li class='active'>Home /</li> <li class='active'>Products /</li> <li class='active'>Product Details</li> </ul>";
		str+="<div class='row><div id='gallery' class='span3'>";
		 str+="<a href='"+p.getImage()+"' title="+p.getName()+">";
		 str+="<img src="+p.getImage()+" style='width:200px;height:150px;' alt="+p.getName()+"/>";
		 str+="</a></div>";
		 str+="<div class='span6'><h3>"+p.getName()+"</h3>";
		 str+="<hr class='soft'/><form class='form-horizontal qtyFrm'><div class='control-group'>";
		 str+="<label class='control-label'><span>Rs"+p.getPrice()+"</span></label>";
		 str+="<div class='controls'><a id='myCart' href='#showInfo' type='submit' class='btn btn-large btn-primary pull-right addToCart' value='"+p.getId()+"'> Add to cart <i class=' icon-shopping-cart'></i></a></div>";
		 str+= "</div></form>	<hr class='soft'/>";
		 str+="<hr class='soft clr'/><p>"+p.getDetailedDesc()+"</p>";
		 str+="<br class='clr'/>";
		 str+="<a href='#showInfo' name='detail'></a><hr class='soft'/></div>";
		 
		 
		 str+="<div class='span9'> <ul id='productDetail' class='nav nav-tabs'> <li class='active'><a href='#profile' data-toggle='tab'>Related Products</a></li> </ul> <div class='active' id='myTabContent' class='tab-content'>";
		 str+="<div class='active' class='tab-pane fade' id='profile'> <div id='myTab' class='pull-right'>";
	 str+="<a href='#blockView' data-toggle='tab'><span class='btn btn-large btn-primary'><i class='icon-th-large'></i></span></a> </div> <br class='clr'/> <hr class='soft'/> <div class='tab-content'> <div class='tab-pane active' id='blockView'> <ul class='thumbnails'>";
		 str+=ToShowGetProductBy_ProdCat(p.getProdCatId());
	 str+="</ul> <hr class='soft'/> </div> </div> <br class='clr'> </div> </div> </div> </div>";
		 
		 System.out.println("*******************");
		 System.out.println(str);
		 System.out.println("*******************");
		return str;
	}

	@Override
	public String ToShowAllProduct() {
		String str="";
		List<Product> list3=getALLProduct();
		for( Product p : list3)
		{
			str+="<li class='span3'><div class='thumbnail'><a class='GetDetails' href='#showInfo' value='"+ p.getId() +"'><img  style='width:200px;height:150px;' src='"+ p.getImage() +"' alt=''/></a><div class='caption'>";
			str+="<h5>"+p.getName()+"</h5>";
			
			str+="<p>"+p.getShortDesc()+"</p>";
			
			str+="<h4 style='text-align:center'><a class='btn GetDetails' href='#showInfo' value='"+ p.getId() +"'> <i class='icon-zoom-in'></i></a> <a class='btn addToCart' value='"+p.getId()+"'href='#'>Add to <i class='icon-shopping-cart'></i></a> <a class='btn btn-primary addToCart' value='"+p.getId()+"' href='#'>Rs"+p.getPrice()+"</a></h4>";
			str+="</div></div></li>";		
		}
		return null;
	}

	@Override
	public String ToShowCartDetails(TreeMap<Product, Integer> t) {
		
		String str="";
	
		str+="<table class='table table-bordered'><thead> <tr> <th>Product</th> <th>Description</th> <th>Quantity/Update</th> <th>Price</th><th colspan='2'>Subtotal</th> <th>Total</th> </tr> </thead> <tbody>";
		
		float total=0;
		float discount=0;
		for(Map.Entry<Product, Integer> entry:t.entrySet()){  
		    	Product p=entry.getKey();
		    	int q=entry.getValue();
		    	str+="<tr>";
		    	str+="<td> <img width='60' height='50' src='"+p.getImage()+"' alt=''/></td>";
		    	str+="<td>"+p.getName()+"<br/>"+p.getShortDesc()+"</td>";
		    	str+="<td>";
		    	
		    	//+-* buttons
		    	str+="<div class='input-append'><input class='span1' style='max-width:34px' placeholder='"+q+"' id='appendedInputButtons' readonly size='16' type='text'>";
		    	str+="<a class='MinusQuantity' value='"+p.getId()+"' href='#showProdDetails'><button class='btn' type='button'><i class='icon-minus'></i></button>  </a>";
		    	str+="<a class='IncreaseQuantity' value='"+p.getId()+"' href='#showProdDetails'><button class='btn' type='button'><i class='icon-plus'></i></button> </a>";
		    	str+="<a class='RemoveItemFromCart' value='"+p.getId()+"' href='#showProdDetails'> <button class='btn btn-danger' type='button'><i class='icon-remove icon-white'></i></button>	</a>			</div>";

		    	str+="</td>";
		    
		    	str+="<td>"+p.getPrice()+"</td>";total+=q*p.getPrice();
		    	str+="<td colspan='2'>"+q+"*"+p.getPrice()+"="+q*p.getPrice()+"</td>";
		    	str+="<td>"+q*p.getPrice()+"</td>";
		  
		    	str+="</tr>";
		    	
		    }  
		discount=(5*total)/100;
		str+="<tr><td colspan='6' style='text-align:right'>Total Price:	</td>";
		str+="<td>Rs "+total+"</td></tr>";
		str+="<tr><td colspan='6' style='text-align:right'>Total Discount:	</td>";
		str+="<td>Rs "+discount+"</td></tr>";
		str+="<tr><td colspan='6' style='text-align:right'>Total Delivery Charges:	</td>";
		if(total==0)
		{
			str+="<td>Rs 0</td></tr>";
			str+="<td colspan='6' style='text-align:right'><strong>TOTAL ("+total+"-"+discount+"+"+0+") =</strong></td>";
			str+="<td class='label label-important' style='display:block'> <strong>"+(total-discount+0)+"</strong></td>";
		}
		else
		{
			str+="<td>Rs 100</td></tr>";
			str+="<td colspan='6' style='text-align:right'><strong>TOTAL / DAY ("+total+"-"+discount+"+"+100+") =</strong></td>";
			str+="<td class='label label-important' style='display:block'> <strong>"+(total-discount+100)+"</strong></td>";
		}
		
	
		str+="</tr>";
		str+="</tbody></table>";
		
		
		  str+="<a href='/index.html' class='btn btn-large'><i class='icon-arrow-left'></i> Continue Shopping </a>";

		  
		  if(total!=0)
	         { 
			  str+="<a href='#showProdDetails' id='SelectDates' class='btn btn-large pull-right SelectDates'>Next <i class='icon-arrow-right'></i></a>";
	         }
         

          return str;
		
	}
	
public String ToShowCartDetailsWhenNotLogin(TreeMap<Product, Integer> t) {
		
		String str="";
	
str+="<table class='table table-bordered'><thead> <tr> <th>Product</th> <th>Description</th> <th>Quantity/Update</th> <th>Price</th><th colspan='2'>Subtotal</th> <th>Total</th> </tr> </thead> <tbody>";
		
		float total=0;
		float discount=0;
		for(Map.Entry<Product, Integer> entry:t.entrySet()){  
		    	Product p=entry.getKey();
		    	int q=entry.getValue();
		    	str+="<tr>";
		    	str+="<td> <img width='60' height='50' src='"+p.getImage()+"' alt=''/></td>";
		    	str+="<td>"+p.getName()+"<br/>"+p.getShortDesc()+"</td>";
		    	str+="<td>";
		    	
		    	//+-* buttons
		    	str+="<div class='input-append'><input class='span1' style='max-width:34px' placeholder='"+q+"' id='appendedInputButtons' readonly size='16' type='text'>";
		    	str+="<a class='MinusQuantityWhenNotLogin' value='"+p.getId()+"' href='#showProdDetails'><button class='btn' type='button'><i class='icon-minus'></i></button>  </a>";
		    	str+="<a class='IncreaseQuantityWhenNotLogin' value='"+p.getId()+"' href='#showProdDetails'><button class='btn' type='button'><i class='icon-plus'></i></button> </a>";
		    	str+="<a class='RemoveItemFromCartWhenNotLogin' value='"+p.getId()+"' href='#showProdDetails'> <button class='btn btn-danger' type='button'><i class='icon-remove icon-white'></i></button>	</a>			</div>";

		    	str+="</td>";
		    
		    	str+="<td>"+p.getPrice()+"</td>";total+=q*p.getPrice();
		    	str+="<td colspan='2'>"+q+"*"+p.getPrice()+"="+q*p.getPrice()+"</td>";
		    	str+="<td>"+q*p.getPrice()+"</td>";
		  
		    	str+="</tr>";
		    	
		    }  
		discount=(5*total)/100;
		str+="<tr><td colspan='6' style='text-align:right'>Total Price:	</td>";
		str+="<td>Rs "+total+"</td></tr>";
		str+="<tr><td colspan='6' style='text-align:right'>Total Discount:	</td>";
		str+="<td>Rs "+discount+"</td></tr>";
		str+="<tr><td colspan='6' style='text-align:right'>Total Delivery Charges:	</td>";
		if(total==0)
		{
			str+="<td>Rs 0</td></tr>";
			str+="<td colspan='6' style='text-align:right'><strong>TOTAL / DAY ("+total+"-"+discount+"+"+0+") =</strong></td>";
			str+="<td class='label label-important' style='display:block'> <strong>"+(total-discount+0)+"</strong></td>";
		}
		else
		{
			str+="<td>Rs 100</td></tr>";
			str+="<td colspan='6' style='text-align:right'><strong>TOTAL ("+total+"-"+discount+"+"+100+") =</strong></td>";
			str+="<td class='label label-important' style='display:block'> <strong>"+(total-discount+100)+"</strong></td>";
		}
		
	
		str+="</tr>";
		str+="</tbody></table>";
		
		
		
		  str+="<a href='/index.html' class='btn btn-large'><i class='icon-arrow-left'></i> Continue Shopping </a>";

         // str+="<a href='#showProdDetails' id='placeOrder' class='btn btn-large pull-right'>Next <i class='icon-arrow-right'></i></a>";
         if(total!=0)
         { 
        	 str+="<a href='#login' class='loginBtn' role='button' data-toggle='modal' style='padding-right:0'><span class='btn btn-large btn-success pull-right logbtn'>Login to Place Order</span></a>";
         }
          return str;
		
	}
	


public String OrderSummaryTable(TreeMap<Product, Integer> t,int days) {
	
	String str="";

str+="<table class='table table-bordered'><thead> <tr> <th>Product</th> <th>Description</th> <th>Quantity/Update</th> <th>Price</th><th colspan='2'>Subtotal</th> <th>Total</th> </tr> </thead> <tbody>";
	
	float total=0;
	float discount=0;
	for(Map.Entry<Product, Integer> entry:t.entrySet()){  
	    	Product p=entry.getKey();
	    	int q=entry.getValue();
	    	str+="<tr>";
	    	str+="<td> <img width='60' height='50' src='"+p.getImage()+"' alt=''/></td>";
	    	str+="<td>"+p.getName()+"<br/>"+p.getShortDesc()+"</td>";
	    	str+="<td>";
	    	
	    	//+-* buttons
	    	str+="<p>"+q+"</p>";
	    	//str+="<a class='MinusQuantityWhenNotLogin' value='"+p.getId()+"' href='#showProdDetails'><button class='btn' type='button'><i class='icon-minus'></i></button>  </a>";
	    	//str+="<a class='IncreaseQuantityWhenNotLogin' value='"+p.getId()+"' href='#showProdDetails'><button class='btn' type='button'><i class='icon-plus'></i></button> </a>";
	    //	str+="<a class='RemoveItemFromCartWhenNotLogin' value='"+p.getId()+"' href='#showProdDetails'> <button class='btn btn-danger' type='button'><i class='icon-remove icon-white'></i></button>	</a>			</div>";

	    	str+="</td>";
	    
	    	str+="<td>"+p.getPrice()+"</td>";total+=q*p.getPrice();
	    	str+="<td colspan='2'>"+q+"(Quant)*"+p.getPrice()+"(Price)="+q*p.getPrice()+"</td>";
	    	str+="<td>"+q*p.getPrice()+"</td>";
	  
	    	str+="</tr>";
	    	
	    }  
	discount=(5*total)/100;
	str+="<tr><td colspan='6' style='text-align:right'>Total Price:	</td>";
	str+="<td>Rs "+total+"</td></tr>";
	str+="<tr><td colspan='6' style='text-align:right'>Total Discount:	</td>";
	str+="<td>Rs "+discount+"</td></tr>";
	str+="<tr><td colspan='6' style='text-align:right'>Total Delivery Charges:	</td>";
	if(total==0)
	{
		str+="<td>Rs 0</td></tr>";
		str+="<td colspan='6' style='text-align:right'><strong>TOTAL / DAY ("+total+"-"+discount+"+"+0+") =</strong></td>";
		str+="<td class='label label-important' style='display:block'> <strong>"+(total-discount+0)+"</strong></td>";
	}
	else
	{
		str+="<td>Rs 100</td></tr>";
		str+="<td colspan='6' style='text-align:right'><strong>TOTAL ("+total+"-"+discount+"+"+100+") =</strong></td>";
		str+="<td class='label label-important' style='display:block'> <strong>"+(total-discount+100)+"</strong></td>";
	}
	

	str+="</tr>";
	str+="</tbody></table>";
	
	
	
	 
    
      return str;
	
}



	@Override
	public String ToShowproductSliderOnHomePage() {
		
		
		System.out.println("this is from ToShowproductSliderOnHomePage");
		String str="";
		
		str+="<div id='featuresProd' class='well well-small'>";
		str+="<h4>";
		str+="Featured Products <small class='pull-right'>200+";
		str+="featured products</small>";
		str+="</h4>";
		str+="<div class='row-fluid'>";
		str+="<div id='featured' class='carousel slide'>";
		str+="<div class='carousel-inner'>";
		for(int i=1;i<5;i++)
		{
			String Query= "SELECT * FROM product p,prodcats pc WHERE p.prodcatid=pc.id AND pc.id=? and p.Name!='0' limit 4";
			List<Product> li=jdbcTemplate.query(Query,new Object[] {i},new ProductMapper());

			str+="	<div class='item ";
			if(i==1)
			{
				str+="active";
			}
			str+=" '>";
			str+="<ul class='thumbnails'>";
			for(Product p:li)
			{

				str+="<li class='span3'>";
				str+="				<div class='thumbnail'>";
				str+="							<i class='tag'></i> <a class='GetDetails' style='width:200px;height:150px;' href='#showInfo' value='"+p.getId()+"'><img";
				str+="								src='"+p.getImage()+"' alt=''></a>";
				str+="							<div class='caption'>";
				str+="								<h5>"+p.getName()+"</h5>";
				str+="								<h4>";
				str+="									<a class='GetDetails' href='#showInfo' value='"+p.getId()+"'>VIEW</a>"; 
				str+="									<span class='pull-right'>Rs "+p.getPrice()+"</span>";
				str+="								</h4>";
				str+="							</div>";
				str+="						</div>";
				str+="					</li>";

			}
			str+="				</ul>";
			str+="			</div>";

		}


		str+="		</div>";
		str+="		<a class='left carousel-control' href='#featured'";
		str+="			data-slide='prev'>‹</a> <a class='right carousel-control'";
		str+="			href='#featured' data-slide='next'>›</a>";
		str+="	</div>";
		str+="</div>";
		str+="</div>";

		return str;
	}

	public int getProd(String nProdcatID) {
		String query="select Id from prodcats where Name=?";
		int id= jdbcTemplate.queryForInt(query, new Object[]{nProdcatID});
		
		
		return id;
		 
	}
}
