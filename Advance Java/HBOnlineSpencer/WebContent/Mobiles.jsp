<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="in.com.prestige.dto.ProductsDTO"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class=" js flexbox no-touch csstransforms3d"><head>
<title>Spencer</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="Elite Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--//tags -->
<script type="text/javascript">
   function checkExist() {
	var xmlhttp = new XMLHttpRequest();
	var email = document.forms["regF"]["cemail"].value;
	var url = "Exist.jsp?email="+email;
	xmlhttp.onreadystatechange = function(){
		 if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			 if(xmlhttp.responseText == "\n\n\n\n\nEmail already exists"){
				 document.getElementById("isE").style.color = "red";
			 }else{
				 document.getElementById("isE").style.color = "green";
                 document.getElementById("isE").innerHTML = xmlhttp.responseText;
			 }
		 }
	};
	try{
        xmlhttp.open("GET",url,true);
        xmlhttp.send();
    }catch(e){alert("unable to connect to server");
    }
  }
</script>
<link href="KLOF%20Indore_files/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="KLOF%20Indore_files/team.css" rel="stylesheet" type="text/css" media="all">
<link href="KLOF%20Indore_files/style.css" rel="stylesheet" type="text/css" media="all">
<link href="KLOF%20Indore_files/font-awesome.css" rel="stylesheet"> 
<!-- //for bootstrap working -->
<link href="KLOF%20Indore_files/css_002.css" rel="stylesheet">
<link href="KLOF%20Indore_files/css.css" rel="stylesheet" type="text/css">
<style type="text/css">@keyframes pop-in {    0% { opacity: 0; transform: scale(0.1); }    60% { opacity: 1; transform: scale(1.2); }    100% { transform: scale(1); }}@-webkit-keyframes pop-in {    0% { opacity: 0; -webkit-transform: scale(0.1); }    60% { opacity: 1; -webkit-transform: scale(1.2); }    100% { -webkit-transform: scale(1); }}@-moz-keyframes pop-in {    0% { opacity: 0; -moz-transform: scale(0.1); }    60% { opacity: 1; -moz-transform: scale(1.2); }    100% { -moz-transform: scale(1); }}.minicart-showing #PPMiniCart {    display: block;    transform: translateZ(0);    -webkit-transform: translateZ(0);    -moz-transform: translateZ(0);    animation: pop-in 0.25s;    -webkit-animation: pop-in 0.25s;    -moz-animation: pop-in 0.25s;}#PPMiniCart {    display: none;    position: fixed;    left: 50%;    top: 75px;}#PPMiniCart form {    position: relative;    width: 400px;    max-height: 400px;    margin-left: -200px;    padding: 10px 10px 40px;    background: #fbfbfb;    border: 1px solid #d7d7d7;    border-radius: 4px;    box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);    font: 15px/normal arial, helvetica;    color: #333;}#PPMiniCart form.minicart-empty {    padding-bottom: 10px;    font-size: 16px;    font-weight: bold;}#PPMiniCart ul {    clear: both;    float: left;    width: 380px;    margin: 5px 0 20px;    padding: 10px;    list-style-type: none;    background: #fff;    border: 1px solid #ccc;    border-radius: 4px;    box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.2);}#PPMiniCart .minicart-empty ul {    display: none;}#PPMiniCart .minicart-closer {    float: right;    margin: -12px -10px 0;    padding: 10px;    background: 0;    border: 0;    font-size: 18px;    cursor: pointer;    font-weight: bold;}#PPMiniCart .minicart-item {    clear: left;    padding: 6px 0;    min-height: 25px;}#PPMiniCart .minicart-item + .minicart-item {    border-top: 1px solid #f2f2f2;}#PPMiniCart .minicart-item a {    color: #333;    text-decoration: none;}#PPMiniCart .minicart-details-name {    float: left;    width: 62%;}#PPMiniCart .minicart-details-quantity {    float: left;    width: 15%;}#PPMiniCart .minicart-details-remove {    float: left;    width: 7%;}#PPMiniCart .minicart-details-price {    float: left;    width: 16%;    text-align: right;}#PPMiniCart .minicart-attributes {    margin: 0;    padding: 0;    background: transparent;    border: 0;    border-radius: 0;    box-shadow: none;    color: #999;    font-size: 12px;    line-height: 22px;}#PPMiniCart .minicart-attributes li {    display: inline;}#PPMiniCart .minicart-attributes li:after {    content: ",";}#PPMiniCart .minicart-attributes li:last-child:after {    content: "";}#PPMiniCart .minicart-quantity {    width: 30px;    height: 18px;    padding: 2px 4px;    border: 1px solid #ccc;    border-radius: 4px;    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);    font-size: 13px;    text-align: right;    transition: border linear 0.2s, box-shadow linear 0.2s;    -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;    -moz-transition: border linear 0.2s, box-shadow linear 0.2s;}#PPMiniCart .minicart-quantity:hover {    border-color: #0078C1;}#PPMiniCart .minicart-quantity:focus {    border-color: #0078C1;    outline: 0;    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 3px rgba(0, 120, 193, 0.4);}#PPMiniCart .minicart-remove {    width: 18px;    height: 19px;    margin: 2px 0 0;    padding: 0;    background: #b7b7b7;    border: 1px solid #a3a3a3;    border-radius: 3px;    color: #fff;    font-size: 13px;    opacity: 0.70;    cursor: pointer;}#PPMiniCart .minicart-remove:hover {    opacity: 1;}#PPMiniCart .minicart-footer {    clear: left;}#PPMiniCart .minicart-subtotal {    position: absolute;    bottom: 17px;    padding-left: 6px;    left: 10px;    font-size: 16px;    font-weight: bold;}#PPMiniCart .minicart-submit {    position: absolute;    bottom: 10px;    right: 10px;    min-width: 153px;    height: 33px;    margin-right: 6px;    padding: 0 9px;    border: 1px solid #ffc727;    border-radius: 5px;    color: #000;    text-shadow: 1px 1px 1px #fff6e9;    cursor: pointer;    background: #ffaa00;    background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iI2ZmZjZlOSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiNmZmFhMDAiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);    background: -moz-linear-gradient(top, #fff6e9 0%, #ffaa00 100%);    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#fff6e9), color-stop(100%,#ffaa00));    background: -webkit-linear-gradient(top, #fff6e9 0%,#ffaa00 100%);    background: -o-linear-gradient(top, #fff6e9 0%,#ffaa00 100%);    background: -ms-linear-gradient(top, #fff6e9 0%,#ffaa00 100%);    background: linear-gradient(to bottom, #fff6e9 0%,#ffaa00 100%);}#PPMiniCart .minicart-submit img {    vertical-align: middle;    padding: 4px 0 0 2px;}</style></head>
<body>


<!-- banner -->
<div class="ban-top">
	
		<div class="top_nav_left">

			<!-- header-bot -->
			<div class="col-md-2 logo_agile">
				<h1 style="margin-top:22px; font-family: Aleo Light;"><a href="index.html"><font color="00FFFF">SPENCER</font></a></h1>
			</div>



			<nav class="navbar navbar-default">
			  <div class="container-fluid">



				<!-- Brand and toggle get grouped for better mobile display -->
				<div class=" col-md-8 navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse menu--shylock" id="bs-example-navbar-collapse-1">

				  <ul class="nav navbar-nav menu__list">
					<li class=" menu__item"><a class="menu__link" href="Index.jsp"><b>HOME</b> <span class="sr-only">(current)</span></a></li>
					<li class=" menu__item  menu__item--current"><a class="menu__link" href="Mobiles.jsp"><b>Mobiles</b></a></li>
					<li class=" menu__item"><a class="menu__link" href="#"><b>WHAT'S NEW</b></a></li>
					<li class=" menu__item"><a class="menu__link" href="Electonics.jsp"><b>Electronics</b></a></li>
					
					
					
					<li class=" menu__item"><a class="menu__link" href="#"><b>CONTACT US</b></a></li>
				  </ul>
				  
				</div>
			  </div>
			</nav>	
		</div>
		<div class="top_nav_right">

			<div class="wthreecartaits wthreecartaits2 cart cart box_1"> 
						<form action="#" method="post" class="last"> 
						<input name="cmd" value="_cart" type="hidden">
						<input name="display" value="1" type="hidden">
						<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
					</form>  
  
						</div>
		</div>
		<div class="top_nav_right">
		    <li class=" menu__item"><a class="menu__link" href="#">
			<%
			 if(session.getAttribute("userLoginsession") == null){
				 %>
				 <li class=" menu__item"><a class="menu__link" href="#" data-toggle="modal" data-target="#myModal">LOGIN</a></li>
				  
			 <%} else{ %>
				 <li class=" menu__item"><a class="menu__link" href="#"><%= session.getAttribute("userLoginsession") %></a></li>
				 <li class=" menu__item"><a class="menu__link" href="LogoutUserCtl">Logout</a></li>
			<%  }                                          
			 %>
			 </a></li>
			

		</div>
		
		<div class="clearfix"></div>
	
</div>
<!-- //banner-top -->
<!-- Modal1 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
					</div>
						<div class="modal-body modal-body-sub_agile">
						<div class="col-md-8 modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">Sign In <span>Now</span></h3>
									<form action="LoginCtl" method="post">
							
							<div class="styled-input">
								<input type="text" name="username" required=""> 
								<label>Email</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="password" name="password" required=""> 
								<label>Password</label>
								<span></span>
							</div> 
							<input type="submit" value="Sign In">
						</form>
						  <ul class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
															<li><a href="#" class="facebook">
																  <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="twitter"> 
																  <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="instagram">
																  <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="pinterest">
																  <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
														</ul>
														<div class="clearfix"></div>
														<p><a href="#" data-toggle="modal" data-target="#myModal2"> Don't have an account?</a></p>

						</div>
						<div class="col-md-4 modal_body_right modal_body_right1">
							<img src="KLOF%20Indore_files/log_pic.jpg" alt=" ">
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<!-- //Modal content-->
			</div>
		</div>
<!-- //Modal1 -->
<!-- Modal2 -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
					</div>
						<div class="modal-body modal-body-sub_agile">
						<div class="col-md-8 modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">Sign Up <span>Now</span></h3>
									<form action="CustomersCtl" method="post" name = "regF">
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="cname" required="">
								<label>Name</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="email" name="cemail" required="" onblur="checkExist()"> 
								<label>Email</label>
								<span></span>
							</div> 
							<div class="styled-input">
								<input type="password" name="cpwd" required=""> 
								<label>Password</label>
								<span></span>
							</div> 
							
							<input type="submit" value="Sign Up" name="submit">
						</form>
						  <ul class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
															<li><a href="#" class="facebook">
																  <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="twitter"> 
																  <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="instagram">
																  <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="pinterest">
																  <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
														</ul>
														<div class="clearfix"></div>
														<p><a href="#">By clicking register, I agree to your terms</a></p>

						</div>
						<div class="col-md-4 modal_body_right modal_body_right1">
							<img src="KLOF%20Indore_files/log_pic.jpg" alt=" ">
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<!-- //Modal content-->
			</div>
		</div>
<!-- //Modal2 -->
<!-- /banner_bottom_agile_info -->
<!-- /banner_bottom_agile_info -->
<div class="page-head_agile_info_w3l1">
		
			<img src="KLOF%20Indore_files/inner3.jpg" alt=" ">
			
	
</div>

  <!-- banner-bootom-w3-agileits -->
	<div class="banner-bootom-w3-agileits" style="text-align:center;">
	<div class="container">
         <!-- mens -->
		
		<div class="col-md-12 products-center" style="text-align:center;">
				<%
				 try{
					 SessionFactory factory = new Configuration().configure().buildSessionFactory();
						Session s = factory.openSession();
						Transaction txn = s.beginTransaction();
						Criteria crit = s.createCriteria(ProductsDTO.class);
						crit.add(Restrictions.eq("category", "MOBILE"));
						crit.add(Restrictions.gt("numberofproducts", 0));
						List list = crit.list();
						Iterator it = list.iterator();

						while (it.hasNext()) {
							ProductsDTO dto = (ProductsDTO) it.next();
							String productname = dto.getProductname();
							double price = dto.getPrice();
							String filename = dto.getFilename();
							int id = dto.getProductID();
				  
				%>
				
				
				<div class="col-md-4 product-men">
								<div class="men-pro-item simpleCart_shelfItem">
									<div class=" " style="height:350px;">
										<img src="upload/upload/<%= filename %>" alt="" class="pro-image-front">
										<img src="upload/upload/<%= filename %>" alt="" class="pro-image-back">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
												<a href="#" class="link-product-add-cart">Quick View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
											
									</div>
									<div class="item-info-product ">
										<h4><a href="#"><%= productname %></a></h4>
										<div class="info-product-price">
											<span class="item_price">Rs. <%= price %>/-</span>
											<del>Rs. <%= (price+2000) %>/-</del>
										</div>
										<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<a href="Single.jsp?pid=<%=id%>"><input name="submit" value="Add to cart" class="button" type="button"></a>
																
														</div>
																			
									</div>
								</div>
							</div>
							
							<%
				  }
				 }catch(Exception e){
					 e.printStackTrace();
				 }
							
							%>
								
			
				<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
				
							

	</div>
</div>	
<!-- //mens -->

<!-- footer -->
<div class="footer">
	<div class="footer_agile_inner_info_w3l">
		<div class="col-md-3 footer-left">
			<h2 style="font-family: Aleo Light;"><a href="http://klof.in/index.php"><span></span><font color="00FFFF">KLOF</font></a></h2>
			<p>Lorem ipsum quia dolor
			sit amet, consectetur, adipisci velit, sed quia non 
			numquam eius modi tempora.</p>
			<ul class="social-nav model-3d-0 footer-social w3_agile_social two">
															<li><a href="#" class="facebook">
																  <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="twitter"> 
																  <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="instagram">
																  <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="pinterest">
																  <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
														</ul>
		</div>
		<div class="col-md-9 footer-right">
			<div class="sign-grds">
				<div class="col-md-4 sign-gd">
					<h4><font color="00FFFF">Our <span>Information</span> </font></h4>
					<ul>
						<li><a href="http://klof.in/index.html">Home</a></li>
							<li><a href="http://klof.in/about.html">About</a></li>
						<li><a href="http://klof.in/terms.html">Terms &amp; Conditions</a></li>
						<li><a href="http://klof.in/privacy.html">Privacy Policy</a></li>
					
						
					</ul>
				</div>
				<div class="col-md-3 sign-gd">
					<h4><font color="00FFFF">Customer <span>Service</span></font></h4>
					<ul>
						<li><a href="http://klof.in/contact.html">Contact Us</a></li>
						<li><a href="#">Track Order</a></li>
						<li><a href="http://klof.in/return.html">Return Order</a></li>
						<li><a href="http://klof.in/cancel.html">Cancel Order</a></li>
						
					</ul>
				</div>
				<div class="col-md-5 sign-gd-two">
					<h4><font color="00FFFF">Store <span>Information</span></font></h4>
					<div class="w3-address">
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-phone" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Phone Number</h6>
								<p>+91 983 567 8901</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Email Address</h6>
								<p>Email :<a href="#"> info@klof.com</a></p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-map-marker" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Location</h6>
								<p> Indore. 
								
								</p>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				
				<div class="clearfix"></div>
			</div>
		</div>
		
		<p class="copy-right">© 2017 Elof. All rights reserved | Design by <a href="http://klof.in/arihantsoftechsolution">Arihant Softech Solution</a></p>
	</div>
</div>
<!-- //footer -->

<!-- login -->
			<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>						
						</div>
						<div class="modal-body modal-spa">
							<div class="login-grids">
								<div class="login">
									<div class="login-bottom">
										<h3>Sign up for free</h3>
										<form>
											<div class="sign-up">
												<h4>Email :</h4>
												<input value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="" type="text">	
											</div>
											<div class="sign-up">
												<h4>Password :</h4>
												<input value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="" type="password">
												
											</div>
											<div class="sign-up">
												<h4>Re-type Password :</h4>
												<input value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="" type="password">
												
											</div>
											<div class="sign-up">
												<input value="REGISTER NOW" type="submit">
											</div>
											
										</form>
									</div>
									<div class="login-right">
										<h3>Sign in with your account</h3>
										<form>
											<div class="sign-in">
												<h4>Email :</h4>
												<input value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="" type="text">	
											</div>
											<div class="sign-in">
												<h4>Password :</h4>
												<input value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="" type="password">
												<a href="#">Forgot password?</a>
											</div>
											<div class="single-bottom">
												<input id="brand" value="" type="checkbox">
												<label for="brand"><span></span>Remember Me.</label>
											</div>
											<div class="sign-in">
												<input value="SIGNIN" type="submit">
											</div>
										</form>
									</div>
									<div class="clearfix"></div>
								</div>
								<p>By logging in you agree to our <a href="#">Terms and Conditions</a> and <a href="#">Privacy Policy</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
<!-- //login -->
<a href="#home" class="scroll" id="toTop" style="display: block;"><span id="toTopHover"></span> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- js -->
<script type="text/javascript" src="KLOF%20Indore_files/jquery-2.js"></script>
<!-- //js -->
<script src="KLOF%20Indore_files/responsiveslides.js"></script>
				<script>
						// You can also use "$(window).load(function() {"
						$(function () {
						 // Slideshow 4
						$("#slider3").responsiveSlides({
							auto: true,
							pager: true,
							nav: false,
							speed: 500,
							namespace: "callbacks",
							before: function () {
						$('.events').append("<li>before event fired.</li>");
						},
						after: function () {
							$('.events').append("<li>after event fired.</li>");
							}
							});
						});
				</script>
<script src="KLOF%20Indore_files/modernizr.js"></script>
	<!-- Custom-JavaScript-File-Links --> 
	<!-- cart-js -->
	<script src="KLOF%20Indore_files/minicart.js"></script>
<script>
	// Mini Cart
	paypal.minicart.render({
		action: '#'
	});

	if (~window.location.search.indexOf('reset=true')) {
		paypal.minicart.reset();
	}
</script><div id="PPMiniCart"><form method="post" class="minicart-empty" action="#" target="">    <button type="button" class="minicart-closer">×</button>    <ul>            </ul>    <div class="minicart-footer">                    <p class="minicart-empty-text">Your shopping cart is empty</p>            </div>    <input name="cmd" value="_cart" type="hidden">    <input name="upload" value="1" type="hidden">            <input name="bn" value="MiniCart_AddToCart_WPS_US" type="hidden">    </form></div>

	<!-- //cart-js --> 
	<!---->
							<script type="text/javascript">//<![CDATA[ 
							$(window).load(function(){
							 $( "#slider-range" ).slider({
										range: true,
										min: 0,
										max: 9000,
										values: [ 1000, 7000 ],
										slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
										}
							 });
							$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

							});//]]>  

							</script>
						<script type="text/javascript" src="KLOF%20Indore_files/jquery-ui.js"></script>
					 <!---->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="KLOF%20Indore_files/move-top.js"></script>
<script type="text/javascript" src="KLOF%20Indore_files/jquery.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->

<!-- for bootstrap working -->
<script type="text/javascript" src="KLOF%20Indore_files/bootstrap.js"></script>


<a href="#" id="toTop">To Top</a></body></html>