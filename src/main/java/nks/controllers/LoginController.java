package nks.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import nks.DAO.impl.AdminDAOimpl;
import nks.DAO.impl.CategoryDAOimpl;
import nks.DAO.impl.CustomerDAOimpl;
import nks.DAO.impl.EmployeDAOempl;
import nks.DAO.impl.OrdersDAOimpl;
import nks.DAO.impl.ProductDAOimpl;
import nks.DAO.impl.UserDAOimpl;
import nks.beans.Admin;
import nks.beans.Customer;
import nks.beans.Employee;
import nks.beans.Login;
import nks.beans.Orders;
import nks.beans.ProdSubCat;
import nks.beans.Product;
import nks.beans.User;

@Controller
@SessionAttributes({"user","cart","Type","sidebar","msg"})
public class LoginController {

	@Autowired
	UserDAOimpl userDAO;
	
	@Autowired
	AdminDAOimpl AdminDAO;
	
	@Autowired
	EmployeDAOempl EmpDAO;
	
	@Autowired
	CustomerDAOimpl CustDAO;
	
	@Autowired
	CategoryDAOimpl CatDAO;
	
	@Autowired
	ProductDAOimpl prodDAO;
	
	@Autowired
	OrdersDAOimpl ordDAO;

	//****************Customer**********************************************************
	
	
	@ModelAttribute("cart")
    public TreeMap<Product,Integer> createCart() {
		  TreeMap<Product,Integer> cart=new  TreeMap<Product,Integer>();
        return cart;
    }
	
	@ModelAttribute("Type")
    public User userType() {
		User user=new User();
        return user;
    }
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,@ModelAttribute("Type") User user,Model model){
		System.out.println("form index controller");
		//String str1=prodDAO.ToShowGetProductBy_ProdCat(4);
		
		//String str11= prodDAO.ToShowProductDetails(3);
		//System.out.println(str1);
		model.addAttribute("msg", "index page");
		 System.out.println("inside the prodcuct slider loader");
		
		String str=CatDAO.GetCategory_and_SubCategory_toShow();
		System.out.println("sidebar is ********: "+str);
		System.out.println("user credentials are uid= "+user.getUid()+" pwd is "+user.getPassword()+" type is "+user.getType()+"");
		
		if(user!=null)
		{
			model.addAttribute("msg", "msg from cntroller");
			if(user.getType()==1)
			{
				System.out.println("user is Admin");
				return new ModelAndView("AdminHomePage");
				
			}else if(user.getType()==2)
			{
				System.out.println("user is Employee");
				return new ModelAndView("EmployeeMasterPage");
			}else if(user.getType()==3)
			{
				System.out.println("user is Customer");
				return new ModelAndView("index","sidebar",str);
			}
			else
				System.out.println("something went wrong user credentials are nt correct");
		}
		System.out.println("use is null");
		//System.out.println(str);
		
		return new ModelAndView("index","sidebar",str);
	}
	
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,SessionStatus sessionStatus){
		System.out.println("logout controller ");
		sessionStatus.setComplete();
		return new ModelAndView("redirect:index.html");
		
	}
	
	@RequestMapping("/product_summary")
	public ModelAndView product_summary(HttpServletRequest request,SessionStatus sessionStatus){
		System.out.println("product_summary controller ");
		sessionStatus.setComplete();
		return new ModelAndView("product_summary");
		
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact(HttpServletRequest request,SessionStatus sessionStatus){
		System.out.println("contact controller ");
		return new ModelAndView("contact");
	}
	
	@RequestMapping("/submitContact")
	public ModelAndView submitContact(HttpServletRequest request,SessionStatus sessionStatus){
		System.out.println("submitContact controller ");
		String fname=request.getParameter("inputFname");
		String emailid=request.getParameter("input_email");
		String	contactno=request.getParameter("contactno");
		String message = request.getParameter("message");

		EmailUtil.recievedContact(fname +" has send following message : "+message+" His contact no is :"+contactno, emailid, contactno);
		return new ModelAndView("redirect:index.html");
	}
	
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request,SessionStatus sessionStatus){
		System.out.println("register controller ");
		return new ModelAndView("redirect:index.html");
	}
	
	@RequestMapping("/registerCustomer")
	public ModelAndView registerCustomer(HttpServletRequest request , HttpServletResponse response) throws IOException{
		System.out.println("form product registerCustomer");
		String fname=request.getParameter("inputFname");
		String lname=request.getParameter("inputLname");
		String emailid=request.getParameter("input_email");
		String gender=request.getParameter("gender");
		String	contactno=request.getParameter("contactno");
		int pincode=Integer.parseInt(request.getParameter("postcode"));
		String address=request.getParameter("address");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String password = request.getParameter("inputPassword1");
		String country = request.getParameter("country");
		
		Customer customer = new Customer(emailid, fname, lname, emailid, contactno, state, city, address, gender, pincode, password);
		
		System.out.println(customer);
		
		System.out.println(lname);
		int i = CustDAO.saveCustomer(customer);
		
		Login u=new Login(emailid, password);
		CustDAO.loginCustomer(u);
		
		System.out.println("Registered  user has credentials as"+u.getUsername()+""+u.getPassword()+".");
		
		return  new ModelAndView("index");
	}
	
	
	@RequestMapping(value = "/CheckIfSuchUserExist", method = RequestMethod.POST)
    public ModelAndView  CheckIfSuchUserExist(HttpServletRequest request,Model model ,HttpServletResponse response,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
	 
		System.out.println("form  CheckIfSuchUserExist");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		int i=userDAO.CheckExistance(id, password);
		
		String str5="";
		if(i==0)
		{
			str5=str5+"User name or Password is incorrect";
			model.addAttribute("msg", str5);
			return new ModelAndView("index" ,"str5",str5);
		}
			else
		{
			model.addAttribute("msg", "success");
			str5=str5+"login succesfull";
			User user=userDAO.find(id, password);
			System.out.println("user is created with "+user.getUid()+" pswd"+user.getPassword()+"  type "+user.getType()+"");
			model.addAttribute("Type", user);
			System.out.println("user is added to model attribute");
			System.out.println(str5);
						
			if(user.getType()==1)
			{
				System.out.println("Admin");
				Admin a=AdminDAO.findAdmin(id);
				System.out.println(a.toString());
				model.addAttribute("user", a);
				return new ModelAndView("AdminHomePage");
			}
			else if(user.getType()==2)
			{
				System.out.println("Employee");
				Employee e=EmpDAO.findEmployee(id);
				System.out.println(e.toString());
				model.addAttribute("user", e);
				return new ModelAndView("EmployeeMasterPage");
			}
			else if(user.getType()==3)
			{
				System.out.println("customer");
				Customer c=CustDAO.findCustomer(id);
				System.out.println("inside login");
			    System.out.println(c.toString());
				model.addAttribute("user", c);
				return new ModelAndView("index");
			}
			else
			{
				System.out.println("error type of user");
			}
		}
			System.out.println("it did not eexuced response.redirect");
			
			return new ModelAndView("index");
    }
	
   
	/// Admin Module by RAhul pr************************************************************
	
	 @RequestMapping(value = "/getAllEmp", method = RequestMethod.GET)
	    public @ResponseBody String getEmp(){
		 
		 List<Employee> list=EmpDAO.getAllEmployee();
	        String result = "<table class='table table-striped'>";   
				result += "<tr>";
					result += "<th>Eid</th>";
					result += "<th>Fname</th>";
					result += "<th>Lname</th>";
					result += "<th>Email</th>";
					result += "<th>ContactNo</th>";
					result += "<th>Address</th>";
					result += "<th>Gender</th>";
					result += "<th class='deleteEmp'>Delete</th>";//class='deleteEmp'
					
				result += "</tr>";

				for(Employee e : list)
				{
					result += "<tr>";
					
						result += "<td>";
							result+=e.getEid();
						result += "</td>";
				
						result += "<td>";
							result+=e.getFname();
						result += "</td>";
						
						result += "<td>";
							
						result+=e.getLname();
						result += "</td>";
						
						result += "<td>";
							
						result+=e.getEmail();
						result += "</td>";
						
						
						result += "<td>";
						
							result+=e.getContactNo();

						result += "</td>";
						
						result += "<td>";
						
							result+=e.getAddress();

						result += "</td>";
					
						result += "<td>";
						
							result+=e.getGender();

						result += "</td>";
						
						result += "<td class='deleteEmp'>";
						
							result+="<a href='delEmp.html?Id="+e.getEid()+"'>Delete</a>";

						result += "</td>";
				
						
					result += "</tr>";
				}

			result += "</table>";
	     
		return result;
	    }

	 @RequestMapping("/delEmp")
		public ModelAndView delEmp(HttpServletRequest request){
		 	
		    String id = request.getParameter("Id");
		    System.out.println(id);
		    EmpDAO.deleteEmployee(id);
			return new ModelAndView("AdminHomePage");
		}
	 
	 @RequestMapping("/addEmp")
		public ModelAndView addEmp(HttpServletRequest request){

		 System.out.println("inside add Employe Controller");
		
		    String Eid = request.getParameter("Eid");
		    String Fname = request.getParameter("Fname");
		    String Lname = request.getParameter("Lname");
		    String Email = request.getParameter("Email");
		    String ContactNo = request.getParameter("ContactNo");
		    String Address = request.getParameter("Address");
		    String Gender = request.getParameter("Gender");
		   
		    Employee emp = new Employee(Eid, Fname, Lname, Email, ContactNo, Address, Gender);
		    EmpDAO.saveEmployee(emp);
		    System.out.println(ContactNo);
		    Login login = new Login(emp.getEmail() , emp.getContactNo());
		    System.out.println(login);
		    EmpDAO.loginCustomer(login);
		    
			return new ModelAndView("AdminHomePage");
		}	 
	 
	 @RequestMapping("/getSubProdCat")
		public @ResponseBody
		String getSubProdCat(HttpServletRequest request){

		    //String result="";
		    String result="<select name='SubCatId' id='SubCatId'>";
		    List<ProdSubCat> prod = CatDAO.getSubProductCategories(Integer.parseInt(request.getParameter("Id")));
		    for(ProdSubCat pp : prod)
		    	result += "<option value='"+ pp.getId() +"'>"+ pp.getName() +"</option>";
		    result += "</select>";
			return result;
		}
	 
	 @RequestMapping("/addProd")
		public ModelAndView addProd(HttpServletRequest request){
		
		 	//Name  ProdCatId  SubCatId         ShortDesc     
		    
		    String Name = request.getParameter("Name");
		    int ProdCatId = Integer.parseInt(request.getParameter("ProdCatId"));
		    int SubCatId = Integer.parseInt(request.getParameter("SubCatId"));
		    String qunatdesc = request.getParameter("qunatdesc");
		    int Maxquant = Integer.parseInt(request.getParameter("Maxquant"));
		    Float price = Float.parseFloat(request.getParameter("price"));
		    String ShortDesc = request.getParameter("ShortDesc");
		    String DetailedDesc = request.getParameter("DetailedDesc");
		    String Image = request.getParameter("Image");
		   
		    Product product = new Product(ProdCatId,SubCatId,Maxquant,Name,qunatdesc,ShortDesc,DetailedDesc,Image,price);
		    
		    prodDAO.saveProduct(product);
		    
			return new ModelAndView("AdminHomePage");
		}
	

	    @RequestMapping("/addCategory")
		public ModelAndView addCategory(HttpServletRequest request){
		
	    	String pcat=request.getParameter("pCatID");
	    	String nProdcatID = request.getParameter("nProdcatID");
	 		String subCat = request.getParameter("subCat");
	    	if (pcat!=null)
	    	{
	    		int ProdcatID = Integer.parseInt(pcat);
	    		 System.out.println(ProdcatID);
	 		  
	 		   CatDAO.saveSubCategory(subCat,ProdcatID);
	    	}

	    	else
		    {
		    	CatDAO.saveCatgory(nProdcatID);
		    	int prodcategory = prodDAO.getProd(nProdcatID);
		    	System.out.println(""+prodcategory);
		    	CatDAO.saveSubCategory(subCat,prodcategory);
		    	
		    }
		   
			return new ModelAndView("AdminHomePage");
		}


	    @RequestMapping("/assingTask")
	    public ModelAndView assingTask(HttpServletRequest request)
	    {
	    	
	    	int ordersID = Integer.parseInt(request.getParameter("ordersID"));
	    	String empID = request.getParameter("empID");
	    	
	    	System.out.println(ordDAO.assignTask(ordersID, empID));
	    	
	    	return new ModelAndView("AdminHomePage");
	    }

	    @RequestMapping("/AllProducts")
	 	public @ResponseBody String AllProducts(){
		 
		 List<Product> Prodlist=prodDAO.getALLProduct();
		 //Id  Name       ProdCatId  SubCatId  qunatdesc       Maxquant   price  ShortDesc    DetailedDesc       Image   
	        String result = "<table class='table table-striped'>";   
				result += "<tr>";
					result += "<th>Name</th>";
					result += "<th>prodCatId</th>";
					result += "<th>subCatId</th>";
					result += "<th>qunatdesc</th>";
					result += "<th>maxquant</th>";
					result += "<th>detailedDesc</th>";
					result += "<th>price</th>";
					
					result += "<th class='deleteProd'>Delete</th>";//class='deleteEmp'
					
				result += "</tr>";

				for(Product pp : Prodlist)
				{
					result += "<tr>";
					
						result += "<td>";
							result+=pp.getName();//.getEid();
						result += "</td>";
				
						result += "<td>";
							result+=pp.getProdCatId();
						result += "</td>";
						
						result += "<td>";
							
						result+=pp.getSubCatId();
						
						result += "</td>";
						
						result += "<td>";
						
							result+=pp.getQunatdesc();

						result += "</td>";
						
						result += "<td>";
						
							result+=pp.getMaxquant();

						result += "</td>";
						
						
						result += "<td>";
						
							result+=pp.getDetailedDesc();

						result += "</td>";
						
					   result += "<td>";
					
					   			result+=pp.getPrice();

					   result += "</td>";
						
						result += "<td class='deleteProd'>";
						
							result+="<a href='delProd.html?Id="+pp.getId()+"'>Delete</a>";

						result += "</td>";
				
						
					result += "</tr>";
				}

			result += "</table>";
	     
		return result;
	    }

	    
	    @RequestMapping("/updateProduct")
		public ModelAndView updateProduct(HttpServletRequest request){
		
		 	//Name  ProdCatId  SubCatId         ShortDesc     
		    
		    String Name = request.getParameter("ProductId");
		    int id = Integer.parseInt(Name);
		    Float price = Float.parseFloat(request.getParameter("price"));
		 
		    String qunatdesc = request.getParameter("qunatdesc");
		 
		    int Maxquant = Integer.parseInt(request.getParameter("Maxquant"));
		   
		    String ShortDesc = request.getParameter("ShortDesc");
		    String DetailedDesc = request.getParameter("DetailedDesc");
		 
		   
		    Product product = new Product(id,Maxquant,qunatdesc,ShortDesc,DetailedDesc,price);
		    
		    prodDAO.updateProduct(product);
		    
			return new ModelAndView("AdminHomePage");
		}
	   	    
	    @RequestMapping("/delProd")
		public ModelAndView delProd(HttpServletRequest request){
		 	
		    int id = Integer.parseInt(request.getParameter("Id"));
		    System.out.println(id);
		    prodDAO.deleteProduct(id);
			return new ModelAndView("AdminHomePage");
		}
	    
	    
	    
	    @RequestMapping("/addServiceArea")
		public ModelAndView addServiceArea(HttpServletRequest request){
		
		    int Pincode = Integer.parseInt(request.getParameter("Pincode"));
		    String State = request.getParameter("State");
		    String City = request.getParameter("City");
		    
		    CustDAO.addServiceArea(Pincode, State, City);
		    	
			return new ModelAndView("AdminHomePage");
		}


	 // *************************************products*************************************
	 
	 @RequestMapping("/getProductsListOfProductCAtegory")
	    public @ResponseBody String getProductsListOfProductCAtegory(HttpServletRequest request){
		 
		 int cat=Integer.parseInt(request.getParameter("ProductCategory"));
		 System.out.println("show product of category "+cat);
		 String str=prodDAO.ToShowGetProductBy_ProdCat(cat);
		 System.out.println(str);
	     
		return str;
	    }
	 
	 @RequestMapping(value = "/getProductListOf_Subcategory", method = RequestMethod.GET)
	    public @ResponseBody String getProductListOf_Subcategory(HttpServletRequest request){
		 
		 int subcat=Integer.parseInt(request.getParameter("Product_SubCategory"));
		 System.out.println(subcat);
		 String str=prodDAO.ToShowGetProductBy_SubCat(subcat);
		 System.out.println(str);
	     
		return str;
	    }
	 
	 
	 @RequestMapping(value = "/GetDetails", method = RequestMethod.GET)
	    public @ResponseBody String GetDetails(HttpServletRequest request){
		 
		 int id=Integer.parseInt(request.getParameter("ProductId"));
		 System.out.println(id);
		 String str=prodDAO.ToShowProductDetails(id);
		 System.out.println(str);
	     
		return str;
	    }
	 
	 @RequestMapping(value = "/loadProductSlider", method = RequestMethod.GET)
	    public @ResponseBody String loadProductSlider( ){
		 System.out.println("inside the prodcuct slider loader");
		 String str=prodDAO.ToShowproductSliderOnHomePage();
		 System.out.println(str);
	     
		return str;
	    }
	 
	  //*********************************Sagar_pr ******************************************
	 
	  //add to main
		@RequestMapping("/EmployeeChangePassword")
		public ModelAndView EmployeeChangePassword(HttpServletRequest request){
			//System.out.println("form EmployeeChangePassword controller");
			
			return new ModelAndView("EmployeeChangePassword");
		}
		
		@RequestMapping("/changepass")
		public ModelAndView changepass(HttpServletRequest request){
			System.out.println("EmployeeChangePassword controller");
			
			int  i=EmpDAO.changepassword(request.getParameter("username"),request.getParameter("newpassword"));
			return new ModelAndView("EmployeeChangePassword");
		}
		
		@RequestMapping("/EmployeeUpdateProfile")
		public ModelAndView EmployeeUpdateProfile(HttpServletRequest request){
			System.out.println("form EmployeeUpdateProfile controller");
			return new ModelAndView("EmployeeUpdateProfile");
		}

		@RequestMapping("/updateEmployee")
		public ModelAndView updatEmp(HttpServletRequest request){
			System.out.println("form updatEmp controller");
			String Eid=request.getParameter("username");
			String Fname=request.getParameter("Fname");
			String Lname=request.getParameter("Lname");
			String Email=request.getParameter("Email");
			String ContactNo=request.getParameter("ContactNo");
			String Address=request.getParameter("Address");
			
			Employee e=new Employee(Eid,Fname, Lname, Email, ContactNo, Address);
			int i=EmpDAO.updateEmployee(e);
			return new ModelAndView("EmployeeUpdateProfile");
		}

		@RequestMapping("/WorkDetails")
		public ModelAndView WorkDetails(HttpServletRequest request,@ModelAttribute("user") Employee emp1){

		System.out.println("the is from EmployeeWorkDetails controller ");	
		 String username=emp1.getEid();
		 
		 List<Orders> list=EmpDAO.getWorkDetails(username);
		     String result = "<table class='table table-striped'>";   
				    result += "<tr>";
					result += "<th>Order number</th>";
					result += "<th>Product Name</th>";
					result += "<th>Quantity</th>";
				    result += "</tr>";

				for(Orders e : list)
				{
					result += "<tr>";
						result += "<td>";
						result+=e.getOrderID();
						result += "</td>";
				
						result += "<td>";
						result+=e.getProductName();
						result += "</td>";
						
						result += "<td>";
						result+=e.getQuantity();
						result += "</td>";
						
						result += "<td>";
				}
          result += "</table>";
		//System.out.println(result);
			System.out.println("t EmployeeWorkDetails controller executed succesfully ");
			return new ModelAndView("EmployeeWorkDetails","str",result);
		}

	
    //add new
	@RequestMapping("/CustomerUpdateProfile")
	public ModelAndView CustomerUpdateProfile(HttpServletRequest request){
		System.out.println("Customer UpdateProfile controller");
		return new ModelAndView("CustomerUpdateProfile");
	}

	//add new
	@RequestMapping("/custchange")
	public ModelAndView Custupdate(HttpServletRequest request){
		System.out.println("update Customer controller");
		String Custid=request.getParameter("username");
		String Fname=request.getParameter("Fname");
		String Lname=request.getParameter("Lname");
		String Email=request.getParameter("Email");
		String ContactNo=request.getParameter("ContactNo");
		String Address=request.getParameter("Address");
		int Pincode=Integer.parseInt(request.getParameter("Pincode"));
		
		Customer c=new Customer(Custid, Fname, Lname, Email, ContactNo, Address, Pincode);
		int i=CustDAO.updateCustomer(c);
		return new ModelAndView("CustomerUpdateProfile");
	}



	// add new

		@RequestMapping("/CustomerChangePassword")
		public ModelAndView CustomerChangePassword(HttpServletRequest request){
			//System.out.println("form EmployeeChangePassword controller");
			
			return new ModelAndView("CustomerChangePassword");
		}
		
		
		//add new
		@RequestMapping("/changeCustpass")
		public ModelAndView changeCustpass(HttpServletRequest request){
			System.out.println("CustomerChangePassword controller");
			
			int  i=CustDAO.changepassword(request.getParameter("username"),request.getParameter("newpassword"));
			return new ModelAndView("CustomerChangePassword");
		}

	
	//******************************cart******************************************************
		@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
	    public @ResponseBody String addToCart(HttpServletRequest request,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
		 
		 int id=Integer.parseInt(request.getParameter("ProductId"));
		 System.out.println("************no Prod id="+id);
		 Product p=prodDAO.getProduct(id);
		 
		 cart.put(p, 1);
		 int i=cart.size();
		 System.out.println("there are "+i+"no of items incart");
		 String str1 = Integer.toString(i);
		 System.out.println(str1);
		return str1;
	    }
		
		
		//show cart details when not login
		@RequestMapping(value = "/cartDetails", method = RequestMethod.GET)
	    public @ResponseBody String cartDetails(@ModelAttribute("cart") TreeMap<Product,Integer> cart){
		 System.out.println("from cartDetails controller");
					String str="";
					str+= prodDAO.ToShowCartDetailsWhenNotLogin(cart);

		 
		return str;
	    }
				
		@RequestMapping(value = "/cartDetailsWenLogin", method = RequestMethod.GET)
	    public @ResponseBody String cartDetailsWenLogin(@ModelAttribute("cart") TreeMap<Product,Integer> cart){
		 System.out.println("from cartDetails controller");
					String str="";
					str+= prodDAO.ToShowCartDetails(cart);

		 
		return str;
	    }
				
		@RequestMapping(value = "/NoOfItemsInCart", method = RequestMethod.GET)
	    public @ResponseBody String NoOfItemsInCart(HttpServletRequest request,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
		 
			System.out.println("from NoOfItemsInCart controller");
			int i=cart.size();
			if(i<0)
			{
				i=i-1;
			}
			
			 System.out.println("there are "+i+"no of items incart");
			 String str1 = Integer.toString(i);
			 System.out.println(str1);
			return str1;
	    }
		
		@RequestMapping(value = "/RemoveProductFromCart", method = RequestMethod.GET)
	    public @ResponseBody String RemoveProductFromCart	(HttpServletRequest request,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
		 
			System.out.println("from RemoveProductFromCart controller");
			int Product_Id=Integer.parseInt(request.getParameter("Product_Id"));
			Product p=prodDAO.getProduct(Product_Id);
			cart.remove(p);
			System.out.println("product "+p.getName()+" is Removed from Cart");
			String str1 = prodDAO.ToShowCartDetails(cart);
			//System.out.println(str1);
		return str1;
	    }
		
		@RequestMapping(value = "/MinusQuantity", method = RequestMethod.GET)
	    public @ResponseBody String MinusQuantity(HttpServletRequest request,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
			System.out.println("from MinusQuantity controller");
			int Product_Id=Integer.parseInt(request.getParameter("Product_Id"));
			Product p=prodDAO.getProduct(Product_Id);
			int no=cart.get(p);
			if(no>1)
			{
				int no2=no-1;
				cart.replace(p,no2);
			}
			
			String str1 = prodDAO.ToShowCartDetails(cart);
			return str1;
	    }
		
		@RequestMapping(value = "/IncreaseQuantity", method = RequestMethod.GET)
	    public @ResponseBody String IncreaseQuantity(HttpServletRequest request,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
			System.out.println("from IncreaseQuantity controller");
			int Product_Id=Integer.parseInt(request.getParameter("Product_Id"));
			Product p=prodDAO.getProduct(Product_Id);
			int no=cart.get(p);
			
			if(no<p.getMaxquant())
			{
				int no2=no+1;
				cart.replace(p,no2);
			}
			
			String str1 = prodDAO.ToShowCartDetails(cart);
			return str1;
	    }
		 		
		@RequestMapping(value = "/RemoveItemFromCartWhenNotLogin", method = RequestMethod.GET)
	    public @ResponseBody String RemoveProductFromCartWhenNotLogin	(HttpServletRequest request,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
		 
			System.out.println("from RemoveProductFromCart controller");
			int Product_Id=Integer.parseInt(request.getParameter("Product_Id"));
			Product p=prodDAO.getProduct(Product_Id);
			cart.remove(p);
			System.out.println("product "+p.getName()+" is Removed from Cart");
			String str1 = prodDAO.ToShowCartDetailsWhenNotLogin(cart);
			//System.out.println(str1);
		return str1;
	    }
		
		@RequestMapping(value = "/MinusQuantityWhenNotLogin", method = RequestMethod.GET)
	    public @ResponseBody String MinusQuantityWhenNotLogin(HttpServletRequest request,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
			System.out.println("from MinusQuantity controller");
			int Product_Id=Integer.parseInt(request.getParameter("Product_Id"));
			Product p=prodDAO.getProduct(Product_Id);
			int no=cart.get(p);
			if(no>1)
			{
				int no2=no-1;
				cart.replace(p,no2);
			}
			
			String str1 = prodDAO.ToShowCartDetailsWhenNotLogin(cart);
			return str1;
	    }
		
		@RequestMapping(value = "/IncreaseQuantityWhenNotLogin", method = RequestMethod.GET)
	    public @ResponseBody String IncreaseQuantityWhenNotLogin(HttpServletRequest request,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
			System.out.println("from IncreaseQuantity controller");
			int Product_Id=Integer.parseInt(request.getParameter("Product_Id"));
			Product p=prodDAO.getProduct(Product_Id);
			int no=cart.get(p);
			
			if(no<p.getMaxquant())
			{
				int no2=no+1;
				cart.replace(p,no2);
			}
			
			String str1 = prodDAO.ToShowCartDetailsWhenNotLogin(cart);
			return str1;
	    }
		
		@RequestMapping(value = "/payment", method = RequestMethod.GET)
		public @ResponseBody String paymentProceed(HttpServletRequest request,@ModelAttribute("user") Customer c){
		            String str="<div class='control-group'><div class='controls'><h4>Your address:</h4><p>"+c.getAddress()+", "+c.getCity()+", <br>"+c.getState()+"-"+c.getPincode()+".</P></div></div>";
		                           str+="<div class='control-group'><label class='control-label' for='inputPhone'>Phone</label><div class='controls'><input class='span3'  type='text' id='phone' placeholder='"+c.getContactNo()+"' readonly></div></div>";
//	                               str+="<div class='control-group'><label class='control-label' for='inputFromDate'>Place order From Date</label><div class='controls'><input class='span3'  type='date' id='cal1' placeholder='dd-mm-yyyy' required></div></div>";
//		                           str+="<div class='control-group'><label class='control-label' for='inputToDate'>Place order To Date</label><div class='controls'><input class='span3'  type='date' id='cal2' placeholder='dd-mm-yyyy' required></div></div>";
		                           str+="<div class='btn-group' ><input class='btn btn-success' type='submit' id='submit1' value='REVIEW ORDER' ></div>";
		                     
		                           return str;
		 }
		
		@RequestMapping(value = "/reviewOrder", method = RequestMethod.POST)

        public @ResponseBody String reviewOrder(HttpServletRequest request,@ModelAttribute("user") Customer c,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
			System.out.println("from reviewOrder controller");
		
//	    	 Calendar date1=Calendar.getInstance();
//			 Calendar date2=Calendar.getInstance();
//			 System.out.println("date 1 is "+request.getParameter("date1"));
//			 System.out.println("date 2 is "+request.getParameter("date2"));
//			 
//			 String day1=request.getParameter("date1").substring(8,10);
//			 String day2=request.getParameter("date2").substring(8,10);
//			
//			 String month1=request.getParameter("date1").substring(5,7);
//			 String month2=request.getParameter("date2").substring(5,7);
//			 
//			 System.out.println(day1+" "+day2+" "+month1+" "+month2);
//			 String year1=request.getParameter("date1").substring(0,4);
//			 String year2=request.getParameter("date2").substring(0,4);
//			
//			 date1.set(Integer.parseInt(year1),Integer.parseInt(month1),Integer.parseInt(day1));
//			 date2.set(Integer.parseInt(year2),Integer.parseInt(month2),Integer.parseInt(day2));
//			
//			 long diff=date2.getTimeInMillis()-date1.getTimeInMillis();
//		     long diffInDays = diff / (24 * 60 * 60 * 1000);
			
		     String str="<div><div class='control-group'><div class='controls'><h4>Your address:</h4>"+c.getAddress()+", "+c.getCity()+", <br>"+c.getState()+"-"+c.getPincode()+".</P></div></div>";
             str+="<div class='control-group'><div class='controls'><h4>Your Phone:</h4><p>"+c.getContactNo()+".</P></div></div>";
            // str+="<div class='control-group'>Your order is from this date: <div id='date1'>"+request.getParameter("date1")+"</div> Your order is till date:<div id='date2'>"+request.getParameter("date2")+"</div></div>";
             /* str+="<div class='btn-group' ><input class='btn btn-success' type='submit' id='reviewOrder' value='REVIEW ORDER' ></div>";*/
             str+=prodDAO.OrderSummaryTable(cart,0);
             //str+="<a href='#showProdDetails' id='SelectDates' class='btn btn-large SelectDates'><i class='icon-arrow-left' ></i> Change Dates</a>";
             str+="<a href='#showProdDetails' id='PlaceOrder'' role='button' style='padding-right:0'><span class='btn btn-large btn-success pull-right'>Place Order</span></a>";
             str+="</div>";
               return str;
		}
		
		
		
		@RequestMapping(value = "/PlaceOrderFinal", method = RequestMethod.GET)
		public @ResponseBody String PlaceOrderFinal(HttpServletRequest request,@ModelAttribute("user") Customer c,@ModelAttribute("cart") TreeMap<Product,Integer> cart){
		           
			System.out.println("in the PlaceOrderFinal controller");
			
//			 Calendar date1=Calendar.getInstance();
//			 Calendar date2=Calendar.getInstance();
//		
//			 String day1=request.getParameter("Start_date").substring(8,10);
//			 String day2=request.getParameter("End_date").substring(8,10);
//			
//			 String month1=request.getParameter("Start_date").substring(5,7);
//			 String month2=request.getParameter("End_date").substring(5,7);
//			 
//		
//			 String year1=request.getParameter("Start_date").substring(0,4);
//			 String year2=request.getParameter("End_date").substring(0,4);
//			 
//			 
//			 date1.set(Integer.parseInt(year1),Integer.parseInt(month1),Integer.parseInt(day1));
//			 date2.set(Integer.parseInt(year2),Integer.parseInt(month2),Integer.parseInt(day2));
//			 
//			 long diff=date2.getTimeInMillis()-date1.getTimeInMillis();
//		     long diffInDays = diff / (24 * 60 * 60 * 1000);
//		     
//			
			 String d1=""+2017+"-"+12+"-"+29;
			 String d2=""+2017+"-"+12+"-"+28;
//			 
//			 System.out.println("date 1 is :"+d1);
//			 System.out.println("date 2 is :"+d2);
			 String str="";
			 String response ="";
			 if(ordDAO.PlaceOrder(d1, d2,((int) 0)+1, cart, c)>0)
			{	str+="<div><h2 style='color: green'>Order Placed Successfully</h2></div>";
				 str+="<div><div class='control-group'><div class='controls'><h4>Your address:</h4>"+c.getAddress()+", "+c.getCity()+", <br>"+c.getState()+"-"+c.getPincode()+".</P></div></div>";
	             str+="<div class='control-group'><div class='controls'><h4>Your Phone:</h4><p>"+c.getContactNo()+".</P></div></div>";
	            // str+="<div class='control-group'>Your order is from this date: <div id='date1'>"+request.getParameter("Start_date")+"</div> Your order is till date:<div id='date2'>"+request.getParameter("End_date")+"</div></div>";
	             str+=prodDAO.OrderSummaryTable(cart,0);
	             response = prodDAO.OrderSummaryTable(cart,0);	
	             cart.clear();
	             str+="<a href='/NamkeenKeShaukeen/index.html' id='ContinueShopping' class='btn btn-large ContinueShopping'><i class='icon-arrow-left' ></i>Continue Shopping</a>";
	             str+="</div>";
			}
			else
			{
				str+="<div><h1>Error in placing order plz try again</h1></div>";
				response = str;
			}
			EmailUtil.sendEmail(response, c.getEmail(), c.getContactNo());
			return str;
		 }
		
}
