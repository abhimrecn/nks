<%@page import="org.springframework.ui.Model"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>SunRise Basket System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content=""> 
    <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
    <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
<!-- Bootstrap style responsive -->	
	<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
	<link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
<!-- Google-code-prettify -->	
	<link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
<!-- fav and touch icons -->
    <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
	<style type="text/css" id="enject"></style>
	 <script src="themes/js/jquery-3.1.1.min.js"></script>
    <script>
    $(document).ready(function () {
    	
        $("#emp").click(function () {
        
            $.get("getAllEmp.html", function (data, status) {
                if (status == "success") {
                	$("#info").show();
                    $("#info").html(data);
                    $(".deleteEmp").hide();
                    $("#AddProductsForm").hide();
                    $("#assingTaskForm").hide();
                    $("#addCategoryForm").hide();
                    $("#addEmpForm").hide();
                    $("#updateProductForm").hide();                    
                }
            });            
        });
        
        
     
      
        
        
        
        $("#RemEmp").click(function () {

            $.get("getAllEmp.html", function (data, status) {
                if (status == "success") {
                	$("#info").show();
                    $("#info").html(data);
                    $("#AddProductsForm").hide();
                    $("#assingTaskForm").hide();
                    $("#addCategoryForm").hide();
                    $("#addEmpForm").hide();
                    $("#updateProductForm").hide();     
                }
             });            
        });
        
        //AllProducts
        $("#AllProducts").click(function () {

            $.get("AllProducts.html", function (data, status) {
                if (status == "success") {
                	 $("#info").show();
                    $("#info").html(data);
                    $(".deleteProd").hide();
                    $("#AddProductsForm").hide();
                    $("#assingTaskForm").hide();
                    $("#addCategoryForm").hide();
                    $("#addEmpForm").hide();
                    $("#updateProductForm").hide();     
//                     $("#getAllProducts").show();
                }
            });            
        });
        
        $("#RemProducts").click(function () {

            $.get("AllProducts.html", function (data, status) {
                if (status == "success") {
                	$("#info").show();
                    $("#info").html(data);
                    $("#AddProductsForm").hide();
                    $("#assingTaskForm").hide();
                    $("#addCategoryForm").hide();
                    $("#addEmpForm").hide();
                    $("#updateProductForm").hide();     
                }
            });            
        });
        
        
        $("#AddProducts").click(function () {

        	$("#AddProductsForm").show();
        	$("#info").hide();
        	$("#assingTaskForm").hide();
        	$("#addCategoryForm").hide();
//         	$.get("getProdCat.html", function (data, status) {
//                 if (status == "success") {
//                 	$("#AddProductsForm").show();
//                 	$("#getAllEmp").hide();
//                 	alert(data);
//                     $("#prodOption").html(data);
//                 }
//             });     
$("#updateProductForm").hide();     
                  
        	  $("#addEmpForm").hide();     
                  
                
        });
        

        
        
        
        
        
        
        $("#addEmp").click(function () {

        	$("#addEmpForm").show();
        	$("#info").hide();
        	$("#assingTaskForm").hide();
        	$("#addCategoryForm").hide();
//         	$.get("getProdCat.html", function (data, status) {
//                 if (status == "success") {
//                 	$("#AddProductsForm").show();
//                 	$("#getAllEmp").hide();
//                 	alert(data);
//                     $("#prodOption").html(data);
//                 }
//             });     
                   
        	$("#updateProductForm").hide();     
        });
        
        
        
        
        
        
        
        $("#ProdCatId").change(function (event){
        		
        		//alert($(this).val());
        			$.get("getSubProdCat.html?Id="+$(this).val(), function (data, status) {
		                if (status == "success") {
		                	$("#AddProductsForm").show();
		                	$("#getAllEmp").hide();
		                    $("#SubprodOption").html(data);
		                    $("#assingTaskForm").hide();
		                    $("#addCategoryForm").hide();
		                    $("#addEmpForm").hide();
		                }
		            });     
        	
        	});
        	
        	$("#assingTask").click(function (event) {
        	
        		$("#assingTaskForm").show();
        		$("#info").hide();
        		$("#getAllEmp").hide();
        		$("#addCategoryForm").hide();
        		$("#AddProductsForm").hide();
        		  $("#addEmpForm").hide();
        		  $("#updateProductForm").hide();     
        	});
        	
        	$("#addCategory").click(function (event) {
        		document.getElementById("nProdcatID").disabled = true;
        		$("#assingTaskForm").hide();
        		$("#AddProductsForm").hide();
        		$("#info").hide();
        		$("#getAllEmp").hide();
        		$("#addCategoryForm").show();
        		  $("#addEmpForm").hide();
        		  $("#updateProductForm").hide();     
        	});
        	
        	

        	
  
        	
        	$("#updateProduct").click(function (event) {
        		 $("#updateProductForm").show();
        		$("#assingTaskForm").hide();
        		$("#AddProductsForm").hide();
        		$("#info").hide();
        		$("#getAllEmp").hide();
        		$("#addCategoryForm").hide();
        		  $("#addEmpForm").hide();
        		 
        	});
        	 
        	$("#changeCat").click(function (event){
        		
        		if ( $(this).is( ":checked" ) )
        		{	
        			alert("check bocx is clicked");
        			
        			
        			
        			document.getElementById("pCatID").disabled = true;
        			document.getElementById("nProdcatID").disabled = false;
        			$("#updateProductForm").hide();     
//         			$("#ProdcatID").disabled();
//         			$("#nProdcatID").enable();
        		}
        		else
        		{
        			alert("check bocx isno clicked");
        			document.getElementById("pCatID").disabled = false;
        			document.getElementById("nProdcatID").disabled = true;
//         			$("#ProdcatID").enable();
//         			$("#nProdcatID").disabled();    
        			$("#updateProductForm").hide();     
        		}
        			
        			
        	});
        	
        			
        	
    });
    </script>
</head>
<body>
<div id="header">
<div class="container">
<div id="welcomeLine" class="row">

	<div class="span6"><h2>Welcome!<strong> ${user.getFname()}</strong></h2></div>
	<div class="span6">
	<div class="pull-right">
<!-- 		<a href="product_summary.html"><span class="">Fr</span></a> -->
<!-- 		<a href="product_summary.html"><span class="">Es</span></a> -->
<!-- 		<span class="btn btn-mini">En</span> -->
<!-- 		<a href="product_summary.html"><span>&pound;</span></a> -->
<!-- 		<span class="btn btn-mini">$155.00</span> -->
<!-- 		<a href="product_summary.html"><span class="">$</span></a> -->
 
	</div>
	</div>
</div>
<!-- Navbar ================================================== -->
<div id="logoArea" class="navbar">
<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
</a>
  <div class="navbar-inner">
    <a class="brand" href="index.html"><img src="themes/images/logo.png" alt="Bootsshop"/></a>
		
    
	  <ul id="topMenu" class="nav pull-right">
	<li class=""><a href="logout.html">Log Out</a></li>
	 </ul>
		  
  </div>
</div>
</div>
</div>
<!-- Header End====================================================================== -->
<div id="mainBody">
	<div class="container">
	<div class="row">
<!-- Sidebar ================================================== -->
	<div id="sidebar" class="span3">
		<div class="well well-small">

		<ul id="sideManu" class="nav nav-tabs nav-stacked">
			<li class="subMenu"><a>EMPLOYEE MANAGEMENT</a>
				<ul>
				<li><a href="#" id="emp"><i class="icon-chevron-right"></i>All Employee </a></li>
				<li><a href="#" id="addEmp" role="button" data-toggle="modal" style="padding-right:0"><i class="icon-chevron-right"></i>Add Employee</a></li>
				<li><a href="#" id="RemEmp"><i class="icon-chevron-right"></i>Remove Employee</a></li>
				<li><a href="#" id="assingTask"><i class="icon-chevron-right"></i>Assign Task</a></li>
				</ul>
			</li>
			<li class="subMenu"><a>PRODUCTS MANAGEMENT </a>
			<ul style="display:none">
				<li><a href="#" id="AllProducts"><i class="icon-chevron-right"></i>All Product</a></li>
				<li><a href="#" id="AddProducts"><i class="icon-chevron-right"></i>Add Product</a></li>
				<li><a href="#" id="updateProduct"><i class="icon-chevron-right"></i>Update Product</a></li>
				<li><a href="#" id="RemProducts"><i class="icon-chevron-right"></i>Remove Product</a></li>
				<li><a href="#" id="addCategory"><i class="icon-chevron-right"></i>Add Category</a></li>
				
			</ul>
			</li>
			<li class="subMenu"><a>SERVICE AREA</a>
				<ul style="display:none">
				<li><a href="#addServiceAreaForm" data-toggle="modal"><i class="icon-chevron-right"></i>Add Service Area</a></li>
			
			</ul>
			</li>
			
			<!-- <li class="subMenu"><a>VENDOR MANAGEMENT</a>
				<ul style="display:none">
 				<li><a href="#" ><i class="icon-chevron-right"></i>Place order to vendor</a></li>
					
			
			</ul>
			</li>
			
			<li class="subMenu"><a> REPORT GENERATION </a>
				<ul style="display:none">
				<li><a href="#"><i class="icon-chevron-right"></i>Employee</a></li>
				<li><a href="#"><i class="icon-chevron-right"></i>Customer</a></li>												
				<li><a href="#"><i class="icon-chevron-right"></i>Sales</a></li>	
				<li><a href="#"><i class="icon-chevron-right"></i>purchase Report</a></li>
				</ul>
			</li> -->
		</ul>
		</div>
		  <div class="thumbnail">
		  </div><br/>
			<div class="thumbnail">
				
			  </div><br/>
			<div class="thumbnail">	
			  </div>
	</div>
<!-- Sidebar end=============================================== -->

	<div class="span9">

<!--     <ul class="breadcrumb"> -->
<!-- 		<li><a href="index.html">Home</a> <span class="divider">/</span></li> -->
<!-- 		<li class="active">Registration</li> -->
<!--     </ul> -->
		<span id="info"></span>
<!-- 		<span id="getAllProducts"></span> -->

<!-- get Service Area end -->

 <form action="addServiceArea.html" method="post">
		<div id="addServiceAreaForm" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="false" >
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3>Add Service Area </h3>
			  </div>
			  <div class="modal-body">
				<form class="form-horizontal">
				  <div class="control-group">								
					<input type="text" name="Pincode" id="Pincode" placeholder="pincode" required>
				  </div>
				  <div class="control-group">
					<input type="text" name="State" id="State" placeholder="State" required>
				  </div>
				  <div class="control-group">
					<input type="text" name="City" id="City" placeholder="City" required>
				  </div>
			</form>		
			<button type="submit" class="btn btn-success">Add</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			
		  </div>
	</div>
	</form>

<!-- get Service Area end -->
		
		
		<!-- Add Products Form ==================================================== -->
	<div id="AddProductsForm" hidden="true">
			<form action="addProd.html" method="post" class="form-horizontal" name="form" >
				<h4>Product information</h4>
		
		<div class="control-group">
			<label class="control-label" for="inputLname"> Name <sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="Name" name="Name" placeholder="Name" required/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="state"> Type<sup>*</sup></label>
			<div class="controls">
<!-- 			<select id="prodCat1" name="prodCat"> -->
<!-- 			 <span id="prodOption"></span>	 -->
<!-- 			 </select> -->
				<sql:setDataSource var="category" driver="com.mysql.jdbc.Driver" 
 					url="jdbc:mysql://localhost/sunrise" user="root" password="root"/> 
					
				<sql:query dataSource="${category}" var="result"> 
					Select * from prodcats;
				</sql:query>
				
				<select id="ProdCatId" name="ProdCatId">
				<c:forEach var="prod" items="${result.rows}">
					<option id="prodCat" value="${prod.Id}">${prod.Name}</option>
				</c:forEach>
			
				</select>
			</div>
		</div>	
		
		<div class="control-group">
			<label class="control-label" for="state">Sub Type<sup>*</sup></label>
			<div class="controls">
<!-- 			<select name="ProdSubCat" id="ProdSubCat"> -->
			 	<div id="SubprodOption"></div>
<!-- 			 </select>	 -->
			</div>
		</div>	
	
		<div class="control-group">
		<label class="control-label" for="Price">Price <sup>*</sup></label>
		<div class="controls">
		  <input type="number" id="price" name="price" placeholder="Price" >
		</div>
	  </div>	 
		
		
		 <div class="control-group">
		<label class="control-label" for="qunatdesc">Quantity Desc<sup>*</sup></label>
		<div class="controls">
		  <input type="text" id="qunatdesc " name="qunatdesc"  placeholder="Quantity" required/>
		</div>
	  </div>
	
	<div class="control-group">
		<label class="control-label" for="Quantity (l)"> Max Quantity <sup>*</sup></label>
		<div class="controls">
		  <input type="number" id="Maxquant" name="Maxquant"  placeholder="Max Quantity" required/>
		</div>
	  </div>
	
	
	<div class="control-group">
		<label class="control-label" for="ImagePath">Image Path <sup>*</sup></label>
		<div class="controls">
		<input type="file" name="Image" id="Image" required/>	
		</div>
	</div>
	
	<div class="control-group">
		<label class="control-label" for="ShortDesc">Short Description <sup>*</sup></label>
		<div class="controls">
		<textarea rows="5" cols="10" id="ShortDesc" name="ShortDesc"></textarea>
			 	</div>
	  </div>
	
	<div class="control-group">
		<label class="control-label" for="desc">Detail Description <sup>*</sup></label>
		<div class="controls">
		<textarea rows="5" cols="15" id="DetailedDesc" name="DetailedDesc"></textarea>
			 	</div>
	  </div>
		
	
	
	<p><sup><label style="color: red;" >*  Required field</label></sup>	</p>
	
	<div class="control-group">
			<div class="controls">
				
				<input class="btn btn-large btn-success" type="submit" value="Submit " />
			</div>
		</div>
			
			</form>
	
	</div>
	
		<!-- Add Product Form end==================================================== -->
		
		
		
		
		
				
		<!-- Update Products Form ==================================================== -->
	<div id="updateProductForm" hidden="true">
			<form action="updateProduct.html" method="post" class="form-horizontal" name="form" >
				<h4>Product information</h4>
		
		<div class="control-group">
			<label class="control-label" for="state"> Type<sup>*</sup></label>
			<div class="controls">

				<sql:setDataSource var="category" driver="com.mysql.jdbc.Driver" 
 					url="jdbc:mysql://localhost/sunrise" user="root" password="root"/> 
					
				<sql:query dataSource="${category}" var="result"> 
					Select * from product;
				</sql:query>
				
				<select id="ProductId" name="ProductId">
				<c:forEach var="prod" items="${result.rows}">
					<option id="ProductId" value="${prod.Id}">${prod.Name}</option>
				</c:forEach>
				</select>
			</div>
		</div>	
	
	
		<div class="control-group">
		<label class="control-label" for="Price">Price <sup>*</sup></label>
		<div class="controls">
		  <input type="number" id="price" name="price" placeholder="Price" required="required" />
		</div>
	  </div>	 
		
		
		 <div class="control-group">
		<label class="control-label" for="qunatdesc">Quantity Desc<sup>*</sup></label>
		<div class="controls">
		  <input type="text" id="qunatdesc " name="qunatdesc"  placeholder="Quantity" required="required"/>
		</div>
	  </div>
	
	<div class="control-group">
		<label class="control-label" for="Quantity (l)"> Max Quantity <sup>*</sup></label>
		<div class="controls">
		  <input type="number" id="Maxquant" name="Maxquant"  placeholder="Max Quantity" required="required"/>
		</div>
	  </div>
	
	
	<div class="control-group">
		<label class="control-label" for="ShortDesc">Short Description <sup>*</sup></label>
		<div class="controls">
		<textarea rows="5" cols="10" id="ShortDesc" name="ShortDesc" required="required"></textarea>
			 	</div>
	  </div>
	
	<div class="control-group">
		<label class="control-label" for="desc">Detail Description <sup>*</sup></label>
		<div class="controls">
		<textarea rows="5" cols="15" id="DetailedDesc" name="DetailedDesc" required="required"></textarea>
			 	</div>
	  </div>
		
	
	
	<p><sup><label style="color: red;" >*  Required field</label></sup>	</p>
	
	<div class="control-group">
			<div class="controls">
				
				<input class="btn btn-large btn-success" type="submit" value="Submit " />
			</div>
		</div>
			
			</form>
	
	</div>
		
		
		
		
		
		
		
		
		
		
	<!-- Add Emp Form ==================================================== -->
 <!--   <div id="EmpAddForm" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" > -->
   	<div id="addEmpForm" hidden="true">
   		 <form action="addEmp.html" method="post">
		
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3>Add Employee</h3>
			  </div>
			  <div class="modal-body">
				<form class="form-horizontal loginFrm">
				  <div class="control-group">							
					<input type="text" name="Eid" id="Eid" placeholder="Emp Id" required>
				  </div>
				  <div class="control-group">
					<input type="text" name="Fname" id="Fname" placeholder="Fname" required>
				  </div>
				  <div class="control-group">
					<input type="text" name="Lname" id="Lname" placeholder="Lname" required>
				  </div>
				  <div class="control-group">
					<input type="email" name="Email" id="Email" placeholder="Email" required>
				  </div>
				  <div class="control-group">
					<input type="text" name="ContactNo" id="ContactNo" placeholder="ContactNo" required>
				  </div>
				  <div class="control-group">
					<input type="text" name="Address" id="Address" placeholder="Address" required>
				  </div>
				  <div class="control-group">
					Male :<input type="radio" name="Gender" id="Gender" value="M" required> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
				    Female : <input type="radio" name="Gender" id="Gender" value="F" required>
				  </div>
				  
			</form>		
			<button type="submit" class="btn btn-success">Add Employee</button>
		  </div>
	</div>
	</form>
	
	<!-- Add Emp Form end==================================================== -->
	<!-- Asing Task Form -->
	 <div id="assingTaskForm" hidden="true">
	 <form action="assingTask.html" method="post">
		
				<h3>Assign Task</h3>
			 
			  <div class="modal-body">
				<form class="form-horizontal loginFrm">
				  <div class="control-group">		
				   					
					<sql:query dataSource="${category}" var="result"> 
						SELECT * FROM orders WHERE packingEmploye IS NULL;
					</sql:query>
				<p3>Order No :</p3>	
					<select id="ordersID" name="ordersID" style='margin-left:4% '>
						<c:forEach var="ord" items="${result.rows}">
							<option id="ordID" value="${ord.OrderID}">${ord.OrderID}</option>
						</c:forEach>
					</select>
				  </div>
				  
				  <div class="control-group">
					<sql:query dataSource="${category}" var="result"> 
						SELECT * FROM employee WHERE Fname!='0';
					</sql:query>
				 <p3>Employee ID:</p3>
					<select id="empID" name="empID" style='margin-left:2% '>
						<c:forEach var="emp" items="${result.rows}">
							<option id="EmpID" value="${emp.Eid}">${emp.Eid}</option>
						</c:forEach>
					</select>
				  </div>
				  <input type="submit" class="btn btn-success"/>
				  </form>	
				  </div>
				  </div>
				
			
	
</form>	
	<!-- Assing Task Form -->
	
	
	<!-- Add Category -->
	 	<div id="addCategoryForm" hidden="true">
	 <form action="addCategory.html" method="post">
	
	    	<h3>Add Category</h3>
			  
			  <div class="modal-body">
				<form class="form-horizontal loginFrm">
				  <div class="control-group">								
					<sql:query dataSource="${category}" var="result"> 
						SELECT * FROM prodcats;
					</sql:query>
				
					<select id="pCatID" name="pCatID">
						<c:forEach var="cat" items="${result.rows}">
							<option id="pCatID" name="pCatID" value="${cat.Id}">${cat.Name}</option>
						</c:forEach>
					</select>
				  </div>
				  <div class="control-group">
					New : <input  type="checkbox" name="changeCat" id="changeCat"/>
				  </div>
				  <div class="control-group">
					<input type="text" name="nProdcatID" id="nProdcatID" placeholder="Product Category" required>
				  </div>
				  <div class="control-group">
					<input type="text" name="subCat" id="subCat" placeholder="Sub Category" required>
				  </div>
				  <input type="submit" class="btn btn-success"/>
				  </form>	
				  </div>
				  </div>
	</form>	
	<!-- Add Category  -->
	
</div>
</div>
</div>
</div>
<!-- MainBody End ============================= -->
<!-- Footer ================================================================== -->
	<div  id="footerSection">
	<div class="container">
		<div class="row">
			<div class="span3">
				<h5>ACCOUNT</h5>
				<a href="login.html">YOUR ACCOUNT</a>
				<a href="login.html">PERSONAL INFORMATION</a> 
				<a href="login.html">ADDRESSES</a> 
				<a href="login.html">DISCOUNT</a>  
				<a href="login.html">ORDER HISTORY</a>
			 </div>
			<div class="span3">
				<h5>INFORMATION</h5>
				<a href="contact.html">CONTACT</a>  
				<a href="register.html">REGISTRATION</a>  
				<a href="legal_notice.html">LEGAL NOTICE</a>  
				<a href="tac.html">TERMS AND CONDITIONS</a> 
				<a href="faq.html">FAQ</a>
			 </div>
			<div class="span3">
				<h5>OUR OFFERS</h5>
				<a href="#">NEW PRODUCTS</a> 
				<a href="#">TOP SELLERS</a>  
				<a href="special_offer.html">SPECIAL OFFERS</a>  
				<a href="#">MANUFACTURERS</a> 
				<a href="#">SUPPLIERS</a> 
			 </div>
			<div id="socialMedia" class="span3 pull-right">
				<h5>SOCIAL MEDIA </h5>
				<a href="#"><img width="60" height="60" src="themes/images/facebook.png" title="facebook" alt="facebook"/></a>
				<a href="#"><img width="60" height="60" src="themes/images/twitter.png" title="twitter" alt="twitter"/></a>
				<a href="#"><img width="60" height="60" src="themes/images/youtube.png" title="youtube" alt="youtube"/></a>
			 </div> 
		 </div>
		<p class="pull-right">&copy; SunRise</p>
	</div><!-- Container End -->
	</div>
<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	
	<script src="themes/js/bootshop.js"></script>
    <script src="themes/js/jquery.lightbox-0.5.js"></script>
	
	<!-- Themes switcher section ============================================================================================= -->
<div id="secectionBox">
<link rel="stylesheet" href="themes/switch/themeswitch.css" type="text/css" media="screen" />
<script src="themes/switch/theamswitcher.js" type="text/javascript" charset="utf-8"></script>
	<div id="themeContainer">
	<div id="hideme" class="themeTitle">Style Selector</div>
	<div class="themeName">Oregional Skin</div>
	<div class="images style">
	<a href="themes/css/#" name="bootshop"><img src="themes/switch/images/clr/bootshop.png" alt="bootstrap business templates" class="active"></a>
	<a href="themes/css/#" name="businessltd"><img src="themes/switch/images/clr/businessltd.png" alt="bootstrap business templates" class="active"></a>
	</div>
	<div class="themeName">Bootswatch Skins (11)</div>
	<div class="images style">
		<a href="themes/css/#" name="amelia" title="Amelia"><img src="themes/switch/images/clr/amelia.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="spruce" title="Spruce"><img src="themes/switch/images/clr/spruce.png" alt="bootstrap business templates" ></a>
		<a href="themes/css/#" name="superhero" title="Superhero"><img src="themes/switch/images/clr/superhero.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="cyborg"><img src="themes/switch/images/clr/cyborg.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="cerulean"><img src="themes/switch/images/clr/cerulean.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="journal"><img src="themes/switch/images/clr/journal.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="readable"><img src="themes/switch/images/clr/readable.png" alt="bootstrap business templates"></a>	
		<a href="themes/css/#" name="simplex"><img src="themes/switch/images/clr/simplex.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="slate"><img src="themes/switch/images/clr/slate.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="spacelab"><img src="themes/switch/images/clr/spacelab.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="united"><img src="themes/switch/images/clr/united.png" alt="bootstrap business templates"></a>
		<p style="margin:0;line-height:normal;margin-left:-10px;display:none;"><small>These are just examples and you can build your own color scheme in the backend.</small></p>
	</div>
	<div class="themeName">Background Patterns </div>
	<div class="images patterns">
		<a href="themes/css/#" name="pattern1"><img src="themes/switch/images/pattern/pattern1.png" alt="bootstrap business templates" class="active"></a>
		<a href="themes/css/#" name="pattern2"><img src="themes/switch/images/pattern/pattern2.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern3"><img src="themes/switch/images/pattern/pattern3.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern4"><img src="themes/switch/images/pattern/pattern4.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern5"><img src="themes/switch/images/pattern/pattern5.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern6"><img src="themes/switch/images/pattern/pattern6.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern7"><img src="themes/switch/images/pattern/pattern7.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern8"><img src="themes/switch/images/pattern/pattern8.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern9"><img src="themes/switch/images/pattern/pattern9.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern10"><img src="themes/switch/images/pattern/pattern10.png" alt="bootstrap business templates"></a>
		
		<a href="themes/css/#" name="pattern11"><img src="themes/switch/images/pattern/pattern11.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern12"><img src="themes/switch/images/pattern/pattern12.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern13"><img src="themes/switch/images/pattern/pattern13.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern14"><img src="themes/switch/images/pattern/pattern14.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern15"><img src="themes/switch/images/pattern/pattern15.png" alt="bootstrap business templates"></a>
		
		<a href="themes/css/#" name="pattern16"><img src="themes/switch/images/pattern/pattern16.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern17"><img src="themes/switch/images/pattern/pattern17.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern18"><img src="themes/switch/images/pattern/pattern18.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern19"><img src="themes/switch/images/pattern/pattern19.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern20"><img src="themes/switch/images/pattern/pattern20.png" alt="bootstrap business templates"></a>
		 
	</div>
	</div>
</div>
<span id="themesBtn"></span>
</body>
</html>