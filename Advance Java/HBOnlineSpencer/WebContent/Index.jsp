<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.com.prestige.dto.HomePageDTO"%>
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
<title>Spencer ||</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Elite Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!--//tags -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/team.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //for bootstrap working -->
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800"
	rel="stylesheet">
<link
	href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic'
	rel='stylesheet' type='text/css'>
<script type="text/javascript">
	function checkExist() {
		var xmlhttp = new XMLHttpRequest();
		var email = document.forms["regF"]["cemail"].value;
		var url = "Exist.jsp?email=" + email;
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				if (xmlhttp.responseText == "\n\n\n\n\nEmail already exists") {
					document.getElementById("isE").style.color = "red";
				} else {
					document.getElementById("isE").style.color = "green";
					document.getElementById("isE").innerHTML = xmlhttp.responseText;
				}
			}
		};
		try {
			xmlhttp.open("GET", url, true);
			xmlhttp.send();
		} catch (e) {
			alert("unable to connect to server");
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
				<h1 style="margin-top: 22px; font-family: Aleo Light;">
					<a href="index.html"><font color='00FFFF'>SPENCER</font></a>
				</h1>
			</div>
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class=" col-md-8 navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse menu--shylock"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav menu__list">
						<li class=" menu__item menu__item--current"><a
							class="menu__link" href="Index.jsp"><b>HOME</b> <span
								class="sr-only">(current)</span></a></li>
						<li class=" menu__item"><a class="menu__link"
							href="Mobiles.jsp"><b>Mobiles</b></a></li>
						<li class=" menu__item"><a class="menu__link" href="#"><b>WHAT'S
									NEW</b></a></li>
						<li class=" menu__item"><a class="menu__link"
							href="Electonics.jsp"><b>Electronics</b></a></li>
						<li class=" menu__item"><a class="menu__link" href="#"><b>CONTACT
									US</b></a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
		<div class="top_nav_right">

			<div class="wthreecartaits wthreecartaits2 cart cart box_1">
				<form action="#" method="post" class="last">
					<input type="hidden" name="cmd" value="_cart"> <input
						type="hidden" name="display" value="1">
					<button class="w3view-cart" type="submit" name="submit" value="">
						<i class="fa fa-cart-arrow-down" aria-hidden="true"></i>
					</button>
				</form>

			</div>
		</div>
		<div class="top_nav_right">


			<li class=" menu__item"><a class="menu__link" href="#"> <%
 	if (session.getAttribute("userLoginsession") == null) {
 %>
					<li class=" menu__item"><a class="menu__link" href="#"
						data-toggle="modal" data-target="#myModal">LOGIN</a></li> <%
 	} else {
 %>
					<li class=" menu__item"><a class="menu__link" href="#"><%=session.getAttribute("userLoginsession")%></a></li>
					<li class=" menu__item"><a class="menu__link"
						href="LogoutUserCtl">Logout</a></li> <%
 	}
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
						<h3 class="agileinfo_sign">
							Sign In <span>Now</span>
						</h3>
						<form action="LoginCtl" method="post">

							<div class="styled-input">
								<input type="text" name="username" required=""> <label>Email</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="password" name="password" required=""> <label>Password</label>
								<span></span>
							</div>
							<input type="submit" value="Sign In">
						</form>
						<ul
							class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
							<li><a href="#" class="facebook">
									<div class="front">
										<i class="fa fa-facebook" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-facebook" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a href="#" class="twitter">
									<div class="front">
										<i class="fa fa-twitter" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-twitter" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a href="#" class="instagram">
									<div class="front">
										<i class="fa fa-instagram" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-instagram" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a href="#" class="pinterest">
									<div class="front">
										<i class="fa fa-linkedin" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-linkedin" aria-hidden="true"></i>
									</div>
							</a></li>
						</ul>
						<div class="clearfix"></div>
						<p>
							<a href="#" data-toggle="modal" data-target="#myModal2">
								Don't have an account?</a>
						</p>

					</div>
					<div class="col-md-4 modal_body_right modal_body_right1">
						<img src="images/log_pic.jpg" alt=" " />
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
				<div id="show-message"></div>
				<div class="modal-body modal-body-sub_agile">
					<div class="col-md-8 modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">
							Sign Up <span>Now </span>
						</h3>
						<form action="CustomersCtl" method="post" name="regF">
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="cname" required=""> <label>Name</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="email" name="cemail" required=""
									onblur="checkExist()"> <label>Email<span
									id="isE"></span></label>

							</div>
							<div class="styled-input">
								<input type="password" name="cpwd" required=""> <label>Password</label>
								<span></span>
							</div>

							<input type="submit" value="Sign Up" name="submit">
						</form>
						<ul
							class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
							<li><a href="#" class="facebook">
									<div class="front">
										<i class="fa fa-facebook" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-facebook" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a href="#" class="twitter">
									<div class="front">
										<i class="fa fa-twitter" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-twitter" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a href="#" class="instagram">
									<div class="front">
										<i class="fa fa-instagram" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-instagram" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a href="#" class="pinterest">
									<div class="front">
										<i class="fa fa-linkedin" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-linkedin" aria-hidden="true"></i>
									</div>
							</a></li>
						</ul>
						<div class="clearfix"></div>
						<p>
							<a href="#">By clicking register, I agree to your terms</a>
						</p>

					</div>
					<div class="col-md-4 modal_body_right modal_body_right1">
						<img src="images/log_pic.jpg" alt=" " />
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //Modal content-->
		</div>
	</div>
	<!-- //Modal2 -->




	<!-- Modal4 -->
	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body modal-body-sub_agile">
					<div class="col-md-8 modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">Choose a Payment Method</h3>
						<hr>
						<form action="#" method="post">
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Name" required=""> <label>Name</label>
								<span></span>
							</div>
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Name" required=""> <label>Phone
									No.</label> <span></span>
							</div>
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Name" required=""> <label>Alternet
									No.</label> <span></span>
							</div>
							<div class="styled-input agile-styled-input-top">
								<input type="email" name="Email" required=""> <label>Email</label>
								<span></span>
							</div>
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Name" required=""> <label>Address
									Line 1</label> <span></span>
							</div>
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Name" required=""> <label>Address
									Line 2</label> <span></span>
							</div>
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Name" required=""> <label>State</label>
								<span></span>
							</div>
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Name" required=""> <label>City</label>
								<span></span>
							</div>
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Name" required=""> <label>Pin
									Code</label> <span></span>
							</div>

							<input type="submit" value="Prv"> <input type="submit"
								value="Next">

						</form>

					</div>

					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //Modal content-->
		</div>
	</div>
	<!-- //Modal4 -->


	<!-- banner -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1" class=""></li>
			<li data-target="#myCarousel" data-slide-to="2" class=""></li>
			<li data-target="#myCarousel" data-slide-to="3" class=""></li>
			<li data-target="#myCarousel" data-slide-to="4" class=""></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>
			<div class="item item2">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>
			<div class="item item3">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>

		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
		<!-- The Modal -->
	</div>

	<!--/grids-->
	<div class="coupons" style="background-color: #000000;">
		<div class="coupons-grids text-center">
			<div class="w3layouts_mail_grid">
				<div class="col-md-4 w3layouts_mail_grid_left">
					<div class="w3layouts_mail_grid_left1 hvr-radial-out">
						<i class="fa fa-truck" view="true"></i>
					</div>
					<div class="w3layouts_mail_grid_left2">
						<h3>FREE SHIPPING</h3>
						<p>Lorem ipsum dolor sit amet, consectetur</p>
					</div>
				</div>
				<div class="col-md-4 w3layouts_mail_grid_left">
					<div class="w3layouts_mail_grid_left1 hvr-radial-out">
						<i class="fa fa-headphones" aria-hidden="true"></i>
					</div>
					<div class="w3layouts_mail_grid_left2">
						<h3>24/7 SUPPORT</h3>
						<p>Lorem ipsum dolor sit amet, consectetur</p>
					</div>
				</div>

				<div class="col-md-4 w3layouts_mail_grid_left">
					<div class="w3layouts_mail_grid_left1 hvr-radial-out">
						<i class="fa fa-gift" aria-hidden="true"></i>
					</div>
					<div class="w3layouts_mail_grid_left2">
						<h3>FREE GIFT COUPONS</h3>
						<p>Lorem ipsum dolor sit amet, consectetur</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>

		</div>
	</div>
	<!--grids-->
	<!-- //schedule-bottom -->
	<!-- banner-bootom-w3-agileits -->


	<h3 class="wthree_text_info" style="margin-top: -50px;">
		<font color='white'>What's <span>Trending</span></font>
	</h3>
	<%
		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session s = factory.openSession();
			Transaction txn = s.beginTransaction();
			Criteria crit = s.createCriteria(HomePageDTO.class);
			crit.setMaxResults(2);
			List list = crit.list();
			Iterator it = list.iterator();

			while (it.hasNext()) {
				HomePageDTO dto = (HomePageDTO) it.next();
				String filename = dto.getFilename();
				String path = dto.getPath();
	%>
	<div class="banner-bootom-w3-agileits"
		style="margin-top: -60px; background-color: #000000;">

		<div class="col-md-12 bb-grids bb-left-agileits-w3layouts"
			style="background-color: #000000;">
			<a href="#">
				<div class="bb-left-agileits-w3layouts-inner grid">
					<figure class="effect-roxy"> <figcaption>
					<h3>
						<span>S</span>ale
					</h3>
					<p>Upto 55%</p>
					</figcaption> </figure>
				</div>
			</a>
		</div>



	</div>
	<img src="upload/upload/<%=filename%>" alt=" "
		style="margin-left: 115px;" img-responsive"  background-color:#000000; />
	<%
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>





	<!-- banner-bootom-w3-agileits -->
	<div class="banner-bootom-w3-agileits"
		style="background-color: #000000;">

		<img src="images/imagesss.jpg" alt=" " class="img-responsive" />




	</div>


	<!-- footer -->
	<div class="footer" style="background-color: #000000;">
		<div class="footer_agile_inner_info_w3l">
			<div class="col-md-3 footer-left">
				<h2 style="font-family: Aleo Light;">
					<a href="Index.jsp"><span></span><font color='00FFFF'>Spencer</font></a>
				</h2>
				<p>Lorem ipsum quia dolor sit amet, consectetur, adipisci velit,
					sed quia non numquam eius modi tempora.</p>
				<ul class="social-nav model-3d-0 footer-social w3_agile_social two">
					<li><a href="#" class="facebook">
							<div class="front">
								<i class="fa fa-facebook" aria-hidden="true"></i>
							</div>
							<div class="back">
								<i class="fa fa-facebook" aria-hidden="true"></i>
							</div>
					</a></li>
					<li><a href="#" class="twitter">
							<div class="front">
								<i class="fa fa-twitter" aria-hidden="true"></i>
							</div>
							<div class="back">
								<i class="fa fa-twitter" aria-hidden="true"></i>
							</div>
					</a></li>
					<li><a href="#" class="instagram">
							<div class="front">
								<i class="fa fa-instagram" aria-hidden="true"></i>
							</div>
							<div class="back">
								<i class="fa fa-instagram" aria-hidden="true"></i>
							</div>
					</a></li>
					<li><a href="#" class="pinterest">
							<div class="front">
								<i class="fa fa-linkedin" aria-hidden="true"></i>
							</div>
							<div class="back">
								<i class="fa fa-linkedin" aria-hidden="true"></i>
							</div>
					</a></li>
				</ul>
			</div>
			<div class="col-md-9 footer-right">
				<div class="sign-grds">
					<div class="col-md-4 sign-gd">
						<h4>
							<font color='00FFFF'>Our <span>Information</span>
							</font>
						</h4>
						<ul>
							<li><a href="Index.jsp">Home</a></li>
							<li><a href="#">About</a></li>
							<li><a href="#">Terms & Conditions</a></li>
							<li><a href="#">Privacy Policy</a></li>


						</ul>
					</div>
					<div class="col-md-3 sign-gd">
						<h4>
							<font color='00FFFF'>Customer <span>Service</span></font>
						</h4>
						<ul>
							<li><a href="#">Contact Us</a></li>
							<li><a href="#">Track Order</a></li>
							<li><a href="#">Return Order</a></li>
							<li><a href="#">Cancel Order</a></li>

						</ul>
					</div>
					<div class="col-md-5 sign-gd-two">
						<h4>
							<font color='00FFFF'>Store <span>Information</span></font>
						</h4>
						<div class="w3-address">
							<div class="w3-address-grid">
								<div class="w3-address-left">
									<i class="fa fa-phone" aria-hidden="true"></i>
								</div>
								<div class="w3-address-right">
									<h6>Phone Number</h6>
									<p>+91 895623125</p>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="w3-address-grid">
								<div class="w3-address-left">
									<i class="fa fa-envelope" aria-hidden="true"></i>
								</div>
								<div class="w3-address-right">
									<h6>Email Address</h6>
									<p>
										Email :<a href="#"> info@spencer.com</a>
									</p>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="w3-address-grid">
								<div class="w3-address-left">
									<i class="fa fa-map-marker" aria-hidden="true"></i>
								</div>
								<div class="w3-address-right">
									<h6>Location</h6>
									<p>Indore.</p>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>

					<div class="clearfix"></div>
				</div>
			</div>

			<p class="copy-right">
				&copy 2017 Elof. All rights reserved | Design by <a
					href="arihantsoftechsolution">Arihant Softech Solution</a>
			</p>
		</div>
	</div>
	<!-- //footer -->

	<!-- login -->
	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content modal-info">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body modal-spa">
					<div class="login-grids">
						<div class="login">
							<div class="login-bottom">
								<h3>Sign up for free</h3>
								<form>
									<div class="sign-up">
										<h4>Email :</h4>
										<input type="text" value="Type here"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Type here';}"
											required="">
									</div>
									<div class="sign-up">
										<h4>Password :</h4>
										<input type="password" value="Password"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Password';}"
											required="">

									</div>
									<div class="sign-up">
										<h4>Re-type Password :</h4>
										<input type="password" value="Password"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Password';}"
											required="">

									</div>
									<div class="sign-up">
										<input type="submit" value="REGISTER NOW">
									</div>

								</form>
							</div>
							<div class="login-right">
								<h3>Sign in with your account</h3>
								<form>
									<div class="sign-in">
										<h4>Email :</h4>
										<input type="text" value="Type here"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Type here';}"
											required="">
									</div>
									<div class="sign-in">
										<h4>Password :</h4>
										<input type="password" value="Password"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Password';}"
											required=""> <a href="#">Forgot password?</a>
									</div>
									<div class="single-bottom">
										<input type="checkbox" id="brand" value=""> <label
											for="brand"><span></span>Remember Me.</label>
									</div>
									<div class="sign-in">
										<input type="submit" value="SIGNIN">
									</div>
								</form>
							</div>
							<div class="clearfix"></div>
						</div>
						<p>
							By logging in you agree to our <a href="#">Terms and
								Conditions</a> and <a href="#">Privacy Policy</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //login -->
	<a href="#home" class="scroll" id="toTop" style="display: block;">
		<span id="toTopHover" style="opacity: 1;"> </span>
	</a>

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
			action : '#'
		});

		if (~window.location.search.indexOf('reset=true')) {
			paypal.minicart.reset();
		}
	</script>

	<!-- //cart-js -->
	<!-- script for responsive tabs -->
	<script src="js/easy-responsive-tabs.js"></script>
	<script>
		$(document).ready(function() {
			$('#horizontalTab').easyResponsiveTabs({
				type : 'default', //Types: default, vertical, accordion           
				width : 'auto', //auto or any width like 600px
				fit : true, // 100% fit in a container
				closed : 'accordion', // Start closed if in accordion view
				activate : function(event) { // Callback function if tab is switched
					var $tab = $(this);
					var $info = $('#tabInfo');
					var $name = $('span', $info);
					$name.text($tab.text());
					$info.show();
				}
			});
			$('#verticalTab').easyResponsiveTabs({
				type : 'vertical',
				width : 'auto',
				fit : true
			});
		});
	</script>
	<!-- //script for responsive tabs -->
	<!-- stats -->
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.countup.js"></script>
	<script>
		$('.counter').countUp();
	</script>
	<!-- //stats -->
	<!-- start-smoth-scrolling -->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/jquery.easing.min.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1000);
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

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->


	<!-- for bootstrap working -->
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
