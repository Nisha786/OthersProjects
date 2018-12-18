<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="in.com.prestige.dto.ProductsDTO"%>
<%@page import="org.hibernate.Criteria"%>
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
<html>
<head>
<title>Spencer</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Elite Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //tags -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/easy-responsive-tabs.css" rel='stylesheet' type='text/css'/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

<!-- //for bootstrap working -->
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
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
</head>
<body>

<!-- banner -->
<div class="ban-top">
	
		<div class="top_nav_left">

			<!-- header-bot -->
			<div class="col-md-2 logo_agile">
				<h1 style="margin-top:22px; font-family: Aleo Light;"><a href="Index.jsp"><font color='00FFFF'>SPENCER</font></a></h1>
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
					<li class=" menu__item menu__item--current"><a class="menu__link" href="index.html"><b>HOME</b> <span class="sr-only">(current)</span></a></li>
			<li class=" menu__item"><a class="menu__link" href="Mobiles.jsp"><b>Mobiles</b></a></li>
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
						<input type="hidden" name="cmd" value="_cart">
						<input type="hidden" name="display" value="1">
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
						<button type="button" class="close" data-dismiss="modal">&times;</button>
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
														<p><a href="#" data-toggle="modal" data-target="#myModal2" > Don't have an account?</a></p>

						</div>
						<div class="col-md-4 modal_body_right modal_body_right1">
							<img src="images/log_pic.jpg" alt=" "/>
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
						<button type="button" class="close" data-dismiss="modal">&times;</button>
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
								<input type="text" name="contact" required=""> 
								<label>Contact No</label>
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
							<img src="images/log_pic.jpg" alt=" "/>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<!-- //Modal content-->
			</div>
		</div>
<!-- //Modal2 -->
<!--/single_page-->
       <!-- /banner_bottom_agile_info -->
<div class="page-head_agile_info_w3l">
		<div class="container">
			<h3>Single <span>Page </span></h3>
			<!--/w3_short-->
				 <div class="services-breadcrumb">
						<div class="agile_inner_breadcrumb">

						   <ul class="w3_short">
								<li><a href="Index.jsp">Home</a><i>|</i></li>
								<li>Single Page</li>
							</ul>
						 </div>
				</div>
	   <!--//w3_short-->
	</div>
</div>

  <!-- banner-bootom-w3-agileits -->
<div class="banner-bootom-w3-agileits">
 <h2 align="center">
 <%if (session.getAttribute("pid") != null){ %>
 ${msg}
 
 <%
 session.removeAttribute("msg");
 } %>
 <c:remove var="message" scope = "session"/></h2>
	<div class="container">
	     <div class="col-md-4 single-right-left ">
			<div class="grid images_3_of_2">
				<div class="flexslider">
					  
					  <%
					  try{
					  int id = 0;
					  if(session.getAttribute("pid") == null){
						  id = Integer.parseInt(request.getParameter("pid"));
					  }else{
						  
						  id = (Integer)session.getAttribute("pid");
					  }
					  
					 
					  SessionFactory factory = new Configuration().configure().buildSessionFactory();
					  Session s = factory.openSession();
					  Transaction txn = s.beginTransaction();
					  Criteria crit = s.createCriteria(ProductsDTO.class);
					  crit.add(Restrictions.eq("productID", id));
					  crit.add(Restrictions.gt("numberofproducts", 0));
					  List list = crit.list();
					  Iterator it = list.iterator();
					  while(it.hasNext()){
						 ProductsDTO dto = (ProductsDTO)it.next();
						 String filename = dto.getFilename(); 
						 double price = dto.getPrice();
						 String pname = dto.getProductname();
						 int number = dto.getNumberofproducts();
	                     int pid = dto.getProductID();
						 %>
					  
					  
					<ul class="slides">
						<li data-thumb="upload/upload/<%= filename %>">
							<div class="thumb-image"> <img src="upload/upload/<%= filename %>" data-imagezoom="true" class="img-responsive"> </div>
						</li>
						<li data-thumb="upload/upload/<%= filename %>">
							<div class="thumb-image"> <img src="upload/upload/<%= filename %>" data-imagezoom="true" class="img-responsive"> </div>
						</li>	
						<li data-thumb="upload/upload/<%= filename %>">
							<div class="thumb-image"> <img src="upload/upload/<%= filename %>" data-imagezoom="true" class="img-responsive"> </div>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>	
			</div>
		</div>
		<div class="col-md-8 single-right-left simpleCart_shelfItem">
					<h3><%=  pname%></h3>
					<p><span class="item_price">Rs.<%= price %>/-</span> <del>- Rs. <%= (price+2000) %>/-</del></p>
					<div class="rating1">
						<span class="starRating">
							<input id="rating5" type="radio" name="rating" value="5">
							<label for="rating5">5</label>
							<input id="rating4" type="radio" name="rating" value="4">
							<label for="rating4">4</label>
							<input id="rating3" type="radio" name="rating" value="3" checked="">
							<label for="rating3">3</label>
							<input id="rating2" type="radio" name="rating" value="2">
							<label for="rating2">2</label>
							<input id="rating1" type="radio" name="rating" value="1">
							<label for="rating1">1</label>
						</span>
					</div>
					<div class="description">
						<h5>Check delivery, payment options and charges at your location</h5>
						 <form action="#" method="post">
						<input type="text" value="452001" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter pincode';}" required="" readonly="readonly">
						<input type="submit" value="Check">
						</form>
					</div>
					
					                                
					
															<form action="CheckOut.jsp" method="post">
															        <input type="hidden" name ="fiename" value ="<%= filename %>">
																	<input type="hidden" name="pname" value="<%= pname %>">
																	<input type="hidden" name="price" value="<%= price %>">
																	<input type="hidden" name="pid" value="<%= pid%>">
																	<input type="hidden" name="discount" value="500.00">
																	<input type="hidden" name="currency_code" value="INR">
																	Quantity:<select name = "qua">
																	<%for(int i = 1;i<= number ;i++){ %>
																	 <option value="<%= i%>"><%= i%></option>
																	 <%} %>
																	 </select>
																	<input type="submit" name="submit" value="BUY" class="button">
															
															</form>
														
					
					
		      </div>
	 			<div class="clearfix"> </div>
				
	  	
		         </div>
	        </div>
	        
	       <%
					  }
					  }catch(Exception e){
						  e.printStackTrace();
					  }
	       %>
 </div>
<!--//single_page-->



<!-- footer -->
<div class="footer" style="background-color:#000000; margin-top: 80px;">
	<div class="footer_agile_inner_info_w3l">
		<div class="col-md-3 footer-left">
			<h2 style="font-family: Aleo Light;"><a href="index.html"><span></span><font color='00FFFF'>KLOF</font></a></h2>
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
					<h4><font color='00FFFF'>Our <span>Information</span> </font></h4>
					<ul>
						<li><a href="index.html">Home</a></li>
							<li><a href="about.html">About</a></li>
						<li><a href="terms.html">Terms & Conditions</a></li>
						<li><a href="privacy.html">Privacy Policy</a></li>
					
						
					</ul>
				</div>
				<div class="col-md-3 sign-gd">
					<h4><font color='00FFFF'>Customer <span>Service</span></font></h4>
					<ul>
						<li><a href="contact.html">Contact Us</a></li>
						<li><a href="#">Track Order</a></li>
						<li><a href="return.html">Return Order</a></li>
						<li><a href="cancel.html">Cancel Order</a></li>
						
					</ul>
				</div>
				<div class="col-md-5 sign-gd-two">
					<h4><font color='00FFFF'>Store <span>Information</span></font></h4>
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
		
		<p class="copy-right">&copy 2017 Elof. All rights reserved | Design by <a href="arihantsoftechsolution">Arihant Softech Solution</a></p>
	</div>
</div>
<!-- //footer -->

<!-- login -->
			<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body modal-spa">
							<div class="login-grids">
								<div class="login">
									<div class="login-bottom">
										<h3>Sign up for free</h3>
										<form>
											<div class="sign-up">
												<h4>Email :</h4>
												<input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
											</div>
											<div class="sign-up">
												<h4>Password :</h4>
												<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">
												
											</div>
											<div class="sign-up">
												<h4>Re-type Password :</h4>
												<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">
												
											</div>
											<div class="sign-up">
												<input type="submit" value="REGISTER NOW" >
											</div>
											
										</form>
									</div>
									<div class="login-right">
										<h3>Sign in with your account</h3>
										<form>
											<div class="sign-in">
												<h4>Email :</h4>
												<input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
											</div>
											<div class="sign-in">
												<h4>Password :</h4>
												<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">
												<a href="#">Forgot password?</a>
											</div>
											<div class="single-bottom">
												<input type="checkbox"  id="brand" value="">
												<label for="brand"><span></span>Remember Me.</label>
											</div>
											<div class="sign-in">
												<input type="submit" value="SIGNIN" >
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
<a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<script src="js/modernizr.custom.js"></script>
	<!-- Custom-JavaScript-File-Links --> 
	<!-- cart-js -->
	<script src="js/minicart.min.js"></script>
<script>
	// Mini Cart
	paypal.minicart.render({
		action: '#'
	});

	if (~window.location.search.indexOf('reset=true')) {
		paypal.minicart.reset();
	}
</script>

	<!-- //cart-js --> 
	<!-- single -->
<script src="js/imagezoom.js"></script>
<!-- single -->
<!-- script for responsive tabs -->						
<script src="js/easy-responsive-tabs.js"></script>
<script>
	$(document).ready(function () {
	$('#horizontalTab').easyResponsiveTabs({
	type: 'default', //Types: default, vertical, accordion           
	width: 'auto', //auto or any width like 600px
	fit: true,   // 100% fit in a container
	closed: 'accordion', // Start closed if in accordion view
	activate: function(event) { // Callback function if tab is switched
	var $tab = $(this);
	var $info = $('#tabInfo');
	var $name = $('span', $info);
	$name.text($tab.text());
	$info.show();
	}
	});
	$('#verticalTab').easyResponsiveTabs({
	type: 'vertical',
	width: 'auto',
	fit: true
	});
	});
</script>
<!-- FlexSlider -->
<script src="js/jquery.flexslider.js"></script>
						<script>
						// Can also be used with $(document).ready()
							$(window).load(function() {
								$('.flexslider').flexslider({
								animation: "slide",
								controlNav: "thumbnails"
								});
							});
						</script>
					<!-- //FlexSlider-->
<!-- //script for responsive tabs -->		
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/jquery.easing.min.js"></script>
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
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
