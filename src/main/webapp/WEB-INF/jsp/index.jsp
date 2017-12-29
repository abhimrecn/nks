
<%@page import="sunrise.beans.User"%>
<%@page import="sunrise.DAO.impl.ProductDAOimpl"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<!DOCTYPE html>
<html lang="en">
  <head>
  
    <meta charset="utf-8">
    <title>NamkeenKeShaukeen Basket</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--Less styles -->
   <!-- Other Less css file //different less files has different color scheam
	<link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
	-->
	<!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
	<script src="themes/js/less.js" type="text/javascript"></script> -->
	
<!-- Bootstrap style --> 
    <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
    <link href="themes/css/base.css" rel="stylesheet"/>
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
	
	<!-- we are including here all our jQury functions for dynamic running of project  -->
	<script type="text/javascript" src="js/jQuery.js"></script>
	
	
</head>

<body>
<div id="header">
<div class="container">
<div id="welcomeLine" class="row">

	<div class="span6"><h2>Welcome <strong>${user.getFname()}</strong> !</h2></div>
	<div class="span6">
	<div class="pull-right">

		<% 
	 User u = (User)session.getAttribute("Type");
	 
	 if(u.getType()!=3) {%>
	
	 <a href="#showInfo"><span class="btn btn-mini btn-primary cartDetails"><i class="icon-shopping-cart icon-white cartDetails"></i><div class="cartNoOfProd" style="display: inline">${cart.size()}</div> Items in your cart </span> </a>
	<%} else
	{
	 %>
	 <a href="#showInfo"><span class="btn btn-mini btn-primary cartDetailsWenLogin"><i class="icon-shopping-cart icon-white cartDetails"></i><div class="cartNoOfProd" style="display: inline">${cart.size()}</div> Items in your cart </span> </a>
	 <%} %>
	</div>
	</div>
</div>
<!-- Navbar ================================================== -->
			<div id="logoArea" class="navbar">
				<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="navbar-inner">
					<a class="brand" href="index.html"><img
						src="themes/images/logo.png" alt="Bootsshop" /></a>
					<!-- Search --------------------------------------------------------------------------------------- -->
					<ul id="topMenu" class="nav pull-right">
						<!-- 	 <li class=""><a href="special_offer.html">Specials Offer</a></li> -->
						<!-- 	 <li class=""><a href="normal.html">Delivery</a></li> -->
						<!-- <li class=""><a href="contact.html">Contact</a>  -->

						<% 
	 User u1 = (User)session.getAttribute("Type");
	 
	 if(u1.getType()!=3) {%>

						<li class=""><div id='logbtn' class='loginBtn'
								style="padding-top: 10%">
								<a href="#login" role="button" data-toggle="modal"
									style="padding-right: 0"><span
									class="btn btn-large btn-success">Login</span></a>
							</div></li>
						<li class=""><div id='regbtn'
								style="padding-top: 8%; padding-left: 4%">
								<a href="#registerForm" role="button" data-toggle="modal"
									style="padding-right: 0"><span
									class="btn btn-large btn-success">Register</span></a>
							</div></li>
						<%} else
	{
	 %>
						<!--  <li class=""><a href="contact.html">Change Password</a> -->
						<li class="">
							<div id='logoutbtn' style="padding-top: 10%">
								<a href="logout.html" role="button"><span
									class="btn btn-large btn-success">Logout</span></a>
							</div>
						</li>
						<%} %>

						<!-- 	 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    -->

						<form action="CheckIfSuchUserExist.html" method="post">
							<%    String str2=(String)session.getAttribute("msg"); 
	 	   if(str2.length()>20)
	 		{
	 %>
							<script>
		$(document).ready(function(){
 		   // Show the Modal on load
 		   $("#login").modal("show");
		});
	 </script>
							<% } else { %>

							<% } %>

							<div id="login" class="modal hide fade in" tabindex="-1"
								role="dialog" aria-labelledby="login" aria-hidden="false">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">×</button>
									<h3>Login</h3>
								</div>
								<div class="modal-body">
									<form class="form-horizontal loginFrm">
										<div class="control-group">
											<input type="email" name="id" id="inputEmail"
												placeholder="Email">
										</div>
										<div class="control-group">
											<input type="password" name="password" id="inputPassword"
												placeholder="Password">
										</div>


										<div class=" label label-warning" id="warn">${str5}</div>
										<div class="container">
											<a href="#" data-target="#pwdModal" data-toggle="modal">Forgot
												Password?</a>
										</div>

										<!--modal-->
										<div id="pwdModal" class="modal fade" tabindex="-1"
											role="dialog" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h3 class="text-center">
															Password Reset
															</h1>
													</div>
													<div class="modal-body">
														<div class="col-md-12">
															<div class="panel panel-default">
																<div class="panel-body">
																	<div class="text-center">

																		<p>If you have forgotten your password you can
																			reset it here.</p>
																		<div class="panel-body">
																			<fieldset>
																				<div class="form-group">
																					<input class="form-control input-lg "
																						placeholder="E-mail Address" name="email"
																						type="email">
																				</div>
																				<input class="btn-success" value="Send My Password"
																					type="submit">
																			</fieldset>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
													<div class="modal-footer">
														<div class="col-md-12">
															<button class="btn" data-dismiss="modal"
																aria-hidden="true">Cancel</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</form>
									<button type="submit" class="btn btn-success submitBtn">Sign
										in</button>
									<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
									New Registration? <a href="#registerForm" role="button"
										data-toggle="modal" style="padding-right: 0" ><span
										class="btn btn-success">Click Here</span></a>
								</div>
								</li>
							</div>
						</form>
				</div>


				<!-------------------------------------------- Registration form===================================== -->

				<form class="form-horizontal" action="registerCustomer.html">
					<div id="registerForm" class="modal hide fade in" tabindex="-1"
						role="dialog" aria-labelledby="" aria-hidden="false">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3>Registration</h3>
						</div>

						<div class="modal-body">
							<form class="form-horizontal loginFrm">

								<div class="control-group">
									<label class="control-label" for="inputFname1">First
										name <sup>*</sup>
									</label>
									<div class="controls">
										<input type="text" name="inputFname" placeholder="First Name"
											required="required" pattern="[a-zA-Z]+" title="ONLY ALPHABATES"  maxlength="20">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputLname">Last name
										<sup>*</sup>
									</label>
									<div class="controls">
										<input type="text" id="inputLname" name="inputLname"
											placeholder="Last Name" required="required" pattern="[a-zA-Z]+" title="ONLY ALPHABATES" maxlength="20">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="input_email">Email <sup>*</sup></label>
									<div class="controls">
										<input type="text" id="input_email" name="input_email"
											placeholder="Email" required="required"
											pattern="[a-z0-9._%+-]+@[a-z.-]+\.[a-z]{2,3}$"
											title="enter email like a@gmail.com">
									</div>
								</div>


								<div class="control-group">
									<label class="control-label" for="inputLnam">Gender <sup>*</sup></label>
									<div class="controls">
										<input type="radio" name="gender" value="M"> Male
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" name="gender" value="F"> Female <br />

									</div>
								</div>


								<div class="control-group">
									<label class="control-label" for="inputPassword1">Password
										<sup>*</sup>
									</label>
									<div class="controls">
										<input type="password" id="inputPassword1"
											name="inputPassword1" placeholder="Password"
											required="required" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
											title="Eight or more characters One Capital letter, One Special Character/Number  " maxlength="20">
									</div>
								</div>


								<h4>Your address</h4>


								<div class="control-group">
									<label class="control-label" for="address">Address<sup>*</sup></label>
									<div class="controls">
										<input type="text" id="address" name="address"
											placeholder="Adress" / required="required"> <span>Street
											address, P.O. box, company name, c/o</span>
									</div>
								</div>


								<div class="control-group">
									<label class="control-label" for="city">City<sup>*</sup></label>
									<div class="controls">
										<select id="city" name="city">
											<!-- <option value="pune">-</option> -->
											<option value="pune">PUNE</option>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="state">State<sup>*</sup></label>
									<div class="controls">
										<select id="state" name="state">
											<option value="Maharashtra">Maharashtra</option>
								        </select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="postcode">Zip /
										Postal Code<sup>*</sup>
									</label>
									<select id="postcode" name="postcode" style="margin-left: 4%">
									<option id="prodCat" value="411020">411020</option>
									
			
									</select>
									
									
								<!--  	<sql:setDataSource var="post" driver="com.mysql.jdbc.Driver" 
 										url="jdbc:mysql://localhost/sunrise" user="root" password="root"/> 
					
									<sql:query dataSource="${post}" var="result"> 
									Select * from servicearea;
									</sql:query>
					
									<select id="postcode" name="postcode" style="margin-left: 4%">
									<c:forEach var="post" items="${result.rows}">
									<option id="prodCat" value="${post.Pincode}">${post.Pincode}</option>
									</c:forEach>
			
									</select>
									-->
								</div> 

								<div class="control-group">
									<label class="control-label" for="country">Country<sup>*</sup></label>
									<div class="controls">
										<select id="country" name="country">
											<option value="India">India</option>
										</select>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="inputPassword1">Contact
										Number <sup>*</sup>
									</label>
									<div class="controls">
										<input type="tel" id="contactno" name="contactno"
											placeholder="Contact No" required="required"
											pattern="^\d{10}$"  title=""/>
									</div>
								</div>

								<p>
									<sup><label style="color: red;">* Required field</label></sup>
								</p>

								<div class="control-group">
									<div class="controls">
										<input type="hidden" name="email_create" value="1"> <input
											type="hidden" name="is_new_customer" value="1"> <input
											class="btn btn-large btn-success" type="submit"
											value="Register" />
										<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
									</div>
								</div>
						</div>
				</form>
			</div>
			</form>
			<!-- End Registration form===================================== -->
  </div>
</div>
</div>
</div>

<!-- Header End====================================================================== -->
<%  if(u.getType()!=3) {%>
	 <div id="carouselBlk">
	<div id="myCarousel" class="carousel slide">
		<div class="carousel-inner">
		  <div class="item active">
		  <div class="container">
			<a href="#login" role="button" data-toggle="modal"><img style="width:100%" src="themes/images/carousel/1.png" alt="special offers"/></a>
			<div class="carousel-caption">
				  <h4>Second Thumbnail label</h4>
				  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				</div>
		  </div>
		  </div>
		  <div class="item">
		  <div class="container">
			<a href="#login" role="button" data-toggle="modal"><img style="width:100%" src="themes/images/carousel/2.png" alt=""/></a>
				<div class="carousel-caption">
				  <h4>Second Thumbnail label</h4>
				  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				</div>
		  </div>
		  </div>
		  <div class="item">
		  <div class="container">
			<a href="#login" role="button" data-toggle="modal"><img src="themes/images/carousel/3.png" alt=""/></a>
			<div class="carousel-caption">
				  <h4>Second Thumbnail label</h4>
				  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				</div>
			
		  </div>
		  </div>
		   <div class="item">
		   <div class="container">
			<a href="#login" role="button" data-toggle="modal"><img src="themes/images/carousel/4.png" alt=""/></a>
			<div class="carousel-caption">
				  <h4>Second Thumbnail label</h4>
				  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				</div>
		   
		  </div>
		  </div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
	  </div>  
</div><%} %>
<div id="mainBody">
		<div class="container">
			<div class="row">
				<!-- Sidebar ================================================== -->
				<div id='sidebar' class='span3'>


					<%
         User u3 = (User)session.getAttribute("Type");
	 if(u3.getType()!=3) {%>

					<div class='well well-small cartDetails'>
						<a id='myCart' href='#showInfo'><img
							src='themes/images/ico-cart.png' alt='cart'>
							<div class="cartNoOfProd" style="display: inline">${cart.size()}</div>
							Items in your cart </a>
					</div>
					<%} else
	{
	 %>
					<div class='well well-small cartDetailsWenLogin'>
						<a id='myCart' href='#showInfo'><img
							src='themes/images/ico-cart.png' alt='cart'>
							<div class="cartNoOfProd" style="display: inline">${cart.size()}</div>
							Items in your cart </a>
					</div>
					<%} %>
					<ul id='sideManu' class='nav nav-tabs nav-stacked'>

						<!-- 	<div id="ProductsCat"></div> -->
						<!-- 	<li class='subMenu open'><a>Flowers</a><ul><li><a href='products.html?ProductCategory=3'><i class='icon-chevron-right'></i>All </a></li><li><a class='active' href='products.html?ProductSubCategory=6'><i class='icon-chevron-right'></i>Flower </a></li><li><a class='active' href='products.html?ProductSubCategory=7'><i class='icon-chevron-right'></i>Garland </a></li></ul></li><li class='subMenu'><a>Bakery_Products</a><ul style='display:none'><li><a href='products.html?ProductCategory=4'><i class='icon-chevron-right'></i>All </a></li><li><a class='active' href='products.html?ProductSubCategory=8'><i class='icon-chevron-right'></i>Bun Pav </a></li><li><a class='active' href='products.html?ProductSubCategory=9'><i class='icon-chevron-right'></i>Cookies </a></li></ul></li><li class='subMenu'><a>Newspaper</a><ul style='display:none'><li><a href='products.html?ProductCategory=2'><i class='icon-chevron-right'></i>All </a></li><li><a class='active' href='products.html?ProductSubCategory=3'><i class='icon-chevron-right'></i>Marathi </a></li><li><a class='active' href='products.html?ProductSubCategory=4'><i class='icon-chevron-right'></i>English </a></li><li><a class='active' href='products.html?ProductSubCategory=5'><i class='icon-chevron-right'></i>Hindi </a></li><li><a class='active' href='products.html?ProductSubCategory=10'><i class='icon-chevron-right'></i>Urdu </a></li></ul></li><li class='subMenu'><a>Milk</a><ul style='display:none'><li><a href='products.html?ProductCategory=1'><i class='icon-chevron-right'></i>All </a></li><li><a class='active' href='products.html?ProductSubCategory=1'><i class='icon-chevron-right'></i>cow </a></li><li><a class='active' href='products.html?ProductSubCategory=2'><i class='icon-chevron-right'></i>buffalo </a></li></ul></li> -->
						${sidebar}
					</ul>
					<br />
				</div>

				<!-- ################Sidebar end=============================================== -->



				<div id="showInfo" class="span9">
					<div class="breadcrumb">
						<div id="showProdDetails">

							<div id='featuresProd' class='well well-small'>
								<h4>
									Our Products<small class='pull-right'>Top Rated
										Products</small>
								</h4>
								<div class='row-fluid'>
									<div id='featured' class='carousel slide'>
										<div class='carousel-inner'>
											<div class='item active '>
												<ul class='thumbnails'>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
		                                                     value='3'><img src='themes/images/products/Amul.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Amul milk</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='3'>VIEW</a>
																	<span class='pull-right'>Rs 20.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='4'><img src='themes/images/products/chitale.jpeg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Chitale</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='4'>VIEW</a>
																	<span class='pull-right'>Rs 20.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='12'><img src='themes/images/products/1.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Gokul 500 ML</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='12'>VIEW</a>
																	<span class='pull-right'>Rs 30.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='13'><img src='themes/images/products/2.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Chitale</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='13'>VIEW</a>
																	<span class='pull-right'>Rs 100.0</span>
																</h4>
															</div>
														</div>
													</li>
												</ul>
											</div>
											<div class='item  '>
												<ul class='thumbnails'>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='6'><img
																src='themes/images/products/lokmat.png'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Lokmat</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='6'>VIEW</a>
																	<span class='pull-right'>Rs 5.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='22'><img src='themes/images/products/14.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Punya Nagari</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='22'>VIEW</a>
																	<span class='pull-right'>Rs 20.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='23'><img src='themes/images/products/13.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Divya Marathi</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='23'>VIEW</a>
																	<span class='pull-right'>Rs 20.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='24'><img src='themes/images/products/b2.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Lokmat</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='24'>VIEW</a>
																	<span class='pull-right'>Rs 10.0</span>
																</h4>
															</div>
														</div>
													</li>
												</ul>
											</div>
											<div class='item  '>
												<ul class='thumbnails'>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='10'><img src='themes/images/products/Rose.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Rose</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='10'>VIEW</a>
																	<span class='pull-right'>Rs 5.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='11'><img src='themes/images/products/Marigold.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Marigold</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='11'>VIEW</a>
																	<span class='pull-right'>Rs 10.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='16'><img src='themes/images/products/21.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Rose</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='16'>VIEW</a>
																	<span class='pull-right'>Rs 100.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='17'><img src='themes/images/products/19.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Flowers Gerbera</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='17'>VIEW</a>
																	<span class='pull-right'>Rs 50.0</span>
																</h4>
															</div>
														</div>
													</li>
												</ul>
											</div>
											<div class='item  '>
												<ul class='thumbnails'>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='10'><img src='themes/images/products/PohaSev.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Special Poha Sev</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='30'>VIEW</a>
																	<span class='pull-right'>Rs 120.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='16'><img src='themes/images/products/LaungSev.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Laung Sev</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='31'>VIEW</a>
																	<span class='pull-right'>Rs 100.0</span>
																</h4>
															</div>
														</div>
													</li>

													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='11'><img src='themes/images/products/LahusanSev.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Lahusan Sev</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='32'>VIEW</a>
																	<span class='pull-right'>Rs 100.0</span>
																</h4>
															</div>
														</div>
													</li>
												</ul>
											</div>
											<div class='item  '>
												<ul class='thumbnails'>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='16'><img src='themes/images/products/TeekaMixture.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Teeka Mixture</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='33'>VIEW</a>
																	<span class='pull-right'>Rs 120.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='10'><img src='themes/images/products/IndoriMixture.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Indori Mixture</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='34'>VIEW</a>
																	<span class='pull-right'>Rs 120.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='17'><img src='themes/images/products/FalhariMixture.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Falhari Mixture</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='35'>VIEW</a>
																	<span class='pull-right'>Rs 120.0</span>
																</h4>
															</div>
														</div>
													</li>
												</ul>
											</div>
											<div class='item  '>
												<ul class='thumbnails'>

													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='11'><img src='themes/images/products/ChatpatiChanaDal.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Chatpati ChanaDal</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='36'>VIEW</a>
																	<span class='pull-right'>Rs 140.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='16'><img src='themes/images/products/DhaniyaDal.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Dhaniya Dal</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='37'>VIEW</a>
																	<span class='pull-right'>Rs 120.0</span>
																</h4>
															</div>
														</div>
													</li>
																										
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='17'><img src='themes/images/products/TeekhiChanaDal.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Teekhi ChanaDal</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='38'>VIEW</a>
																	<span class='pull-right'>Rs 120.0</span>
																</h4>
															</div>
														</div>
													</li>
												</ul>
											</div>
											<div class='item  '>
												<ul class='thumbnails'>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='11'><img src='themes/images/products/TastyDane.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Tasty Dane</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='39'>VIEW</a>
																	<span class='pull-right'>Rs 120.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='17'><img src='themes/images/products/MasalaPeanut.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Masala Peanut</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='40'>VIEW</a>
																	<span class='pull-right'>Rs 120.0</span>
																</h4>
															</div>
														</div>
													</li>
													
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='10'><img src='themes/images/products/BlackPepperPeanut.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Black PepperPeanut</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='41'>VIEW</a>
																	<span class='pull-right'>Rs 120.0</span>
																</h4>
															</div>
														</div>
													</li>
												</ul>
											</div>
											
											<div class='item  '>
												<ul class='thumbnails'>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='8'><img src='themes/images/products/bread-bun.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Pav</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='8'>VIEW</a>
																	<span class='pull-right'>Rs 8.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='9'><img src='themes/images/products/Cookies1.jpg' alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>cookie</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='9'>VIEW</a>
																	<span class='pull-right'>Rs 18.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='18'><img src='themes/images/products/5.jpg'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Bun Pav</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='18'>VIEW</a>
																	<span class='pull-right'>Rs 20.0</span>
																</h4>
															</div>
														</div>
													</li>
													<li class='span3'>
														<div class='thumbnail'>
															<i class='tag'></i> <a class='GetDetails' href='#showInfo'
																value='19'><img src='themes/images/products/khari.png'
																alt='' style='width: 200px; height: 150px;'></a>
															<div class='caption'>
																<h5>Khari</h5>
																<h4>
																	<a class='GetDetails' href='#showInfo' value='19'>VIEW</a>
																	<span class='pull-right'>Rs 20.0</span>
																</h4>
															</div>
														</div>
													</li>
												</ul>
											</div>
										</div>
										<a class='left carousel-control' href='#featured'
											data-slide='prev'>‹</a> <a class='right carousel-control'
											href='#featured' data-slide='next'>›</a>
									</div>
								</div>
							</div>

							<div id="ShowProducts">
								<div class="span9" style="padding-top: 3%; margin-left:0px">


									<ul class="thumbnails">

										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='6'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/lokmat.png' alt='' /></a>
												<div class='caption'>
													<h5>Lokmat</h5>
													<p>Lokmat</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='6'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='6' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs5.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='22'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/14.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Punya Nagari</h5>
													<p>Punya Nagari</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='22'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='22' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs20.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='23'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/13.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Divya Marathi</h5>
													<p>Divya Marathi</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='23'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='23' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs20.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='24'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/b2.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Lokmat</h5>
													<p>Lokmat-Hindi</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='24'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='24' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs10.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='25'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/timesOfIndia.png' alt='' /></a>
												<div class='caption'>
													<h5>Indian Times</h5>
													<p>Indian Times</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='25'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='25' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs10.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='26'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/12.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Hindustan Times</h5>
													<p>Hindustan Times</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='26'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='26' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs10.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='27'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/10.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Western Times</h5>
													<p>Western Times</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='27'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='27' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs10.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='28'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/17.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Dainik Bhaskar</h5>
													<p>Dainik Bhaskar</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='28'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='28' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs10.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='29'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/18.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Navbharta Times</h5>
													<p>Navbharta Times</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='29'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='29' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs10.0</i>
													</h4>
												</div>
											</div></li>
									
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='31'><img
													style='width: 200px; height: 150px;' src='themes/images/products/sakal.png' alt='' /></a>
												<div class='caption'>
													<h5>Sakal Marathi New</h5>
													<p>20 Pages</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='31'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='31' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs20.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='10'><img
													style='width: 200px; height: 150px;' src='themes/images/products/Rose.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Rose</h5>
													<p>red</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='10'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='10' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs5.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='11'><img
													style='width: 200px; height: 150px;' src='themes/images/products/Marigold.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Marigold</h5>
													<p>Yellow</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='11'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='11' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs10.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='16'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/21.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Rose</h5>
													<p>Flowers</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='16'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='16' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs30.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='17'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/19.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Flowers Gerbera</h5>
													<p>Flowers</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='17'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='17' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs50.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='8'><img
													style='width: 200px; height: 150px;' src='themes/images/products/bread-bun.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Pav</h5>
													<p>maida</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='8'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='8' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs20.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='9'><img
													style='width: 200px; height: 150px;' src='themes/images/products/cookies.jpg' alt='' /></a>
												<div class='caption'>
													<h5>cookie</h5>
													<p>cookie</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='9'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='9' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs18.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='18'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/5.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Bun Pav</h5>
													<p>Bun Pav</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='18'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='18' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs20.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='19'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/khari.png' alt='' /></a>
												<div class='caption'>
													<h5>Khari</h5>
													<p>Khari</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='19'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='19' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs20.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='20'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/b1.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Cookies</h5>
													<p>Cookies</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='20'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='20' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs10.0</i>
													</h4>
												</div>
											</div></li>
										<li class='span3'><div class='thumbnail'>
												<a class='GetDetails' href='#showInfo' value='21'><img
													style='width: 200px; height: 150px;'
													src='themes/images/products/6.jpg' alt='' /></a>
												<div class='caption'>
													<h5>Pav</h5>
													<p>Pav</p>
													<h4 style='text-align: center'>
														<a class='btn GetDetails' href='#showInfo' value='21'>
															<i class='icon-zoom-in'></i>
														</a> <a class='btn addToCart' value='21' href='#showInfo'>Add
															to <i class='icon-shopping-cart'></i>
														</a> <i class='btn btn-primary'>Rs20.0</i>
													</h4>
												</div>
											</div></li>
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="themes/images/products/11.jpg" alt="" /></a>
												<div class="caption">
													<h5>Indian Express</h5>
													<p>Indian Express</p>
													<h4 style="text-align: center">
														<a class="btn" href="product_details.html"> <i
															class="icon-zoom-in"></i></a> <a class="btn" href="#">Add
															to <i class="icon-shopping-cart"></i>
														</a> <a class="btn btn-primary" href="#">Rs25.00</a>
													</h4>
												</div>
											</div>
										</li>
									</ul>
								</div>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
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
				<h1 style="font-family: fantasy; padding-top:20%; color: orange; ">NamkeenKeShaukeen Basket</h1>
				
				
			 </div> 
		 </div>
		<p class="pull-right">&copy; NamkeenKeShaukeen Basket</p>
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
