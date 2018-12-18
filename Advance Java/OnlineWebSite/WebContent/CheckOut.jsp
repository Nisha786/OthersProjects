<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>Spencer||</title>
    <meta charset="utf-8">
    <meta name="description" content="Plus E-Commerce Template">
    <meta name="author" content="Diamant Gjota" />
    <meta name="keywords" content="plus, html5, css3, template, ecommerce, e-commerce, bootstrap, responsive, creative" />
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">

    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
	
    <!--Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    
    <!-- css files -->
    <link rel="stylesheet" type="text/css" href="css1/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css1/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css1/owl.carousel.min.css" />
    <link rel="stylesheet" type="text/css" href="css1/owl.theme.default.min.css" />
    <link rel="stylesheet" type="text/css" href="css1/animate.css" />
    <link rel="stylesheet" type="text/css" href="css1/swiper.css" />
    
    <!-- this is default skin you can replace that with: dark.css, yellow.css, red.css ect -->
    <link id="pagestyle" rel="stylesheet" type="text/css" href="css1/default.css" />
    
    <!-- Google fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i,900,900i&subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:100,300,400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800&amp;subset=latin-ext" rel="stylesheet">
    



<link  rel="stylesheet" type="text/css" href="css1/style123.css" />
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
       <%
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       String pname = request.getParameter("pname");
       if(session.getAttribute("userLoginsession") == null){
    	 String msg = "Please Login First For Purchasing Products";
    	 request.getSession().setAttribute("msg", msg);
    	 request.getSession().setAttribute("pname", pname);
    	 response.sendRedirect("Single.jsp");
       }
       %>
        
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
                    <li class=" menu__item menu__item--current"><a class="menu__link" href="Index.jsp"><b>HOME</b> <span class="sr-only">(current)</span></a></li>
                    <li class=" menu__item"><a class="menu__link" href="Mobiles.jsp"><b>MOBILES</b></a></li>
                    <li class=" menu__item"><a class="menu__link" href="#"><b>WHAT'S NEW</b></a></li>
                    <li class=" menu__item"><a class="menu__link" href="Electonics.jsp"><b>ELECTRONICS</b></a></li>
                    
                    
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
</div>
<!-- //banner-top -->
        
        <div class="breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <ul>
                            <li><a href="#">Home</a></li>
                            <li><a href="#">Pages</a></li>
                            <li class="active">Checkout</li>
                        </ul><!-- end breadcrumb -->
                    </div><!-- end col -->    
                </div><!-- end row -->
            </div><!-- end container -->
        </div><!-- end breadcrumbs -->
        
        <!-- start section -->
        <section class="section white-backgorund">
            <div class="container">
               
                    
                   
                    <div class="col-sm-12">
                        
                            <div class="col-sm-12 text-left">
                                <h2 class="title">Checkout</h2>
                            </div><!-- end col -->
                        </div><!-- end row -->
                        
                        <hr class="spacer-5"><hr class="spacer-20 no-border">
                        
                      
                            <div class="col-sm-12">
                                <ul class="nav nav-pills style2 nav-justified">
                                    <li class="active">
                                        <a href="#shopping-cart" data-toggle="tab">
                                            1. Shopping Cart
                                            <div class="icon">
                                                <i class="fa fa-check"></i>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#billing-info" data-toggle="tab">
                                            2. Billing Info
                                            <div class="icon">
                                                <i class="fa fa-home"></i>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#payment" data-toggle="tab">
                                            3. Payment
                                            <div class="icon">
                                                <i class="fa fa-credit-card"></i>
                                            </div>
                                        </a>
                                    </li>
                                </ul>

                                <div class="tab-content pills">
                                    <div class="tab-pane active" id="shopping-cart">
                                      <div class="table-responsive"> 
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th colspan="2">Products</th>
                                                        <th>Price</th>
                                                        <th>Quantity</th>
                                                        <th colspan="2">Total</th>
                                                    </tr>
                                                </thead>
                                                   <%
                                                     session.setAttribute("productname", request.getParameter("pname"));
                                                     session.setAttribute("price", (Double.parseDouble(request.getParameter("price"))) * (Integer.parseInt(request.getParameter("qua"))));
                                                     session.setAttribute("quantity", request.getParameter("qua"));
                                                   %>
                                                <tbody>
                                                    <tr>
                                                        <td>
                                                            
                                                                <img width="60px" src="<%= request.getParameter("fiename") %>" alt="product">
                                                           
                                                        </td>
                                                        <td>
                                                            <h6 class="regular"><%= request.getParameter("pname") %></h6>
                                                            
                                                        </td>
                                                        <td>
                                                            <span><%= request.getParameter("price") %></span>
                                                        </td>
                                                        <td>
                                                             <span><%= request.getParameter("qua") %></span>
                                                        </td>
                                                        <td>
                                                            <span class="text-primary">$<%= (Double.parseDouble(request.getParameter("price"))) * (Integer.parseInt(request.getParameter("qua"))) %></span>
                                                        </td>
                                                        <td>
                                                            <button type="button" class="close">×</button>
                                                        </td>
                                                    </tr>
                                                   
                                                    
                                                </tbody>
                                            </table><!-- end table -->
                                       </div>
                                    </div><!-- end tab-pane -->
                                    <div class="tab-pane" id="billing-info">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <h5 class="thin subtitle">Billing Address</h5>



                                                
                                                <div class="row" style="margin-top: 50px;">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <input id="name" type="text" placeholder="First Name" name="firstname" class="form-control input-md required">
                                                        </div><!-- end form-group -->
                                                        <div class="form-group">
                                                            <input id="email" type="text" placeholder="Email" name="email" class="form-control input-md required email">
                                                        </div><!-- end form-group -->
                                                    </div><!-- end col -->
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <input id="surname" type="text" placeholder="Last Name" name="lastname" class="form-control input-md required">
                                                        </div><!-- end form-group -->
                                                        <div class="form-group">
                                                            <input id="phone" type="tel" placeholder="Phone" name="phone" class="form-control input-md required">
                                                        </div><!-- end form-group -->
                                                    </div>
                                                </div><!-- end row -->
                                                <div class="form-group">
                                                    <input id="billingAddress" type="text" placeholder="Address Line 1" name="address1" class="form-control input-md required">
                                                </div><!-- end form-group -->
                                                <div class="form-group">
                                                    <input id="billingAddress2" type="text" placeholder="Address Line 2" name="address2" class="form-control input-md required">
                                                </div><!-- end form-group -->
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <input id="city" type="text" placeholder="City" name="city" class="form-control input-md required">
                                                        </div><!-- end form-group -->
                                                    </div><!-- end col -->
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <input id="zip" type="text" placeholder="Zip/Postal Code" name="zip" class="form-control input-md required">
                                                        </div><!-- end form-group -->
                                                    </div><!-- end col -->
                                                </div><!-- end row -->
                                            </div><!-- end col -->

                                            
                                        </div><!-- end row -->
                                    </div><!-- end tab-pane -->
                                    <div class="tab-pane" id="payment">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <h5 class="thin subtitle">Choose a Payment Method</h5>
                                                <div class="panel-group accordion style2" id="accordionPayment" role="tablist" aria-multiselectable="true">
                                                    <div class="panel panel-default">
                                                        <div class="panel-heading" role="tab" id="headingPayment1">
                                                            <h4 class="panel-title">
                                                                <a class="" data-toggle="collapse" data-parent="#accordionPayment" href="#collapsePayment1" aria-expanded="true" aria-controls="collapsePayment1">
                                                                    <i class="fa fa-credit-card mr-10"></i>Credit or Debit Card
                                                                </a>
                                                            </h4><!-- end panel-title -->
                                                        </div><!-- end panel-heading -->
                                                        <div id="collapsePayment1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingPayment1">
                                                            <div class="panel-body">
                                                                <div class="form-group">
                                                                    <div class="row">
                                                                        <label class="col-sm-4">Cardholder Name <span class="text-danger">*</span></label>
                                                                        <div class="col-sm-8">
                                                                            <input type="text" class="form-control required" name="cardholder" placeholder="">
                                                                        </div><!-- end col -->
                                                                    </div><!-- end row -->
                                                                </div><!-- end form-group -->
                                                                <div class="form-group">
                                                                    <div class="row">
                                                                        <label class="col-sm-4">Card Number <span class="text-danger">*</span></label>
                                                                        <div class="col-sm-8">
                                                                            <input type="text" class="form-control required" name="cardnumber" placeholder="">
                                                                        </div><!-- end col -->
                                                                    </div><!-- end row -->
                                                                </div><!-- end form-group -->
                                                                <div class="form-group">
                                                                    <div class="row">
                                                                        <label class="col-sm-4">Payment Types <span class="text-danger">*</span></label>
                                                                        <div class="col-sm-8">
                                                                            <ul class="list list-inline">
                                                                                <li><i class="fa fa-cc-visa fa-2x"></i></li>
                                                                                <li><i class="fa fa-cc-paypal fa-2x"></i></li>
                                                                                <li class="text-primary"><i class="fa fa-cc-mastercard fa-2x"></i></li>
                                                                                <li><i class="fa fa-cc-discover fa-2x"></i></li>
                                                                            </ul>
                                                                        </div><!-- end col -->
                                                                    </div><!-- end row -->
                                                                </div><!-- end form-group -->
                                                                <div class="form-group">
                                                                    <div class="row">
                                                                        <label class="col-sm-4">Expiration Date <span class="text-danger">*</span></label>
                                                                        <div class="col-sm-8">
                                                                            <div class="row">
                                                                                <div class="col-sm-6">
                                                                                    <input type="text" name="mm" placeholder="MM" class="form-control required">
                                                                                </div><!-- end col -->
                                                                                <div class="col-sm-6">
                                                                                    <input type="text" name="yy" placeholder="YY" class="form-control required">
                                                                                </div><!-- end col -->
                                                                            </div><!-- end row -->      
                                                                        </div><!-- end col -->
                                                                    </div><!-- end row -->
                                                                </div><!-- end form-group -->
                                                                <div class="form-group">
                                                                    <div class="row">
                                                                        <label class="col-sm-4">CSC <span class="text-danger">*</span></label>
                                                                        <div class="col-sm-8">
                                                                            <input type="text" name="number" placeholder="" class="form-control mb-10 required">
                                                                            <a href="javascript:void(0);">What's this?</a>
                                                                        </div><!-- end col -->
                                                                    </div><!-- end row -->
                                                                </div><!-- end form-group -->
                                                                <div class="form-group">
                                                                    <div class="row">
                                                                        <div class="col-sm-offset-4 col-sm-8">
                                                                            <div class="checkbox-input checkbox-primary mb-10">
                                                                                <input id="save-my-card" class="styled" type="checkbox">
                                                                                <label for="save-my-card">
                                                                                    Save my Card information?
                                                                                </label>
                                                                            </div><!-- end checkbox-input -->
                                                                        </div><!-- end col -->
                                                                    </div><!-- end row -->
                                                                </div><!-- end form-group -->
                                                                <div class="form-group">
                                                                    <div class="row">
                                                                        <div class="col-sm-offset-4 col-sm-8 text-right">
                                                                            <a href="Order.jsp" class="btn btn-default btn-md round">Order <i class="fa fa-arrow-circle-right ml-5"></i></a>
                                                                        </div><!-- end col -->
                                                                    </div><!-- end row -->
                                                                </div><!-- end form-group -->
                                                            </div><!-- end panel-body -->
                                                        </div><!-- end collapse -->
                                                    </div><!-- end panel -->

                                                    <div class="panel panel-default">
                                                        <div class="panel-heading" role="tab" id="headingPayment2">
                                                            <h4 class="panel-title">
                                                                <a class="collapsed" data-toggle="collapse" data-parent="#accordionPayment" href="#collapsePayment2" aria-expanded="false" aria-controls="collapsePayment2">
                                                                    <i class="fa fa-paypal mr-10"></i>Pay with PayPal
                                                                </a>
                                                            </h4>
                                                        </div><!-- end panel-heading -->
                                                        <div id="collapsePayment2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingPayment2">
                                                            <div class="panel-body">
                                                                <div class="form-group">
                                                                    <div class="checkbox-input checkbox-primary mb-10">
                                                                        <input id="pay-with-paypal" class="styled" type="checkbox">
                                                                        <label for="pay-with-paypal">
                                                                            <i class="fa fa-cc-paypal mr-5"></i>Checkout with paypal
                                                                        </label>
                                                                    </div><!-- end checkbox-input -->
                                                                </div><!-- end form-group -->
                                                                <div class="form-group">
                                                                    <a href="order-confirmation.html" class="btn btn-default btn-md round">Order <i class="fa fa-arrow-circle-right ml-5"></i></a>
                                                                </div><!-- end form-group -->
                                                            </div><!-- end panel-body -->
                                                        </div><!-- end collapse -->
                                                    </div><!-- end panel -->
                                                </div><!-- end panel-group -->
                                            </div><!-- end col -->
                                            <div class="col-md-6">
                                                <h5 class="thin subtitle">Frequently asked questions</h5>
                                                <div class="panel-group accordion style1" id="question" role="tablist" aria-multiselectable="true">
                                                    <div class="panel panel-default">
                                                        <div class="panel-heading" role="tab" id="questionOne">
                                                            <h4 class="panel-title">
                                                                <a class="" data-toggle="collapse" data-parent="#question" href="#collapseQuestionOne" aria-expanded="true" aria-controls="collapseOne">
                                                                    What payments methods can I use?
                                                                </a>
                                                            </h4>
                                                        </div><!-- end panel-heading -->
                                                        <div id="collapseQuestionOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="questionOne">
                                                            <div class="panel-body">
                                                                <p>Lorem ipsum dolor sit amet, link adipisicing elit. Dicta voluptatem, tenetur eum tempore minus libero voluptates eos doloremque. Dolore minima rem consequuntur exercitationem quaerat deleniti repellendus enim necessitatibus mollitia tenetur?</p>
                                                            </div><!-- end panel-body -->
                                                        </div><!-- end collapse -->
                                                    </div><!-- end panel -->

                                                    <div class="panel panel-default">
                                                        <div class="panel-heading" role="tab" id="questionTwo">
                                                            <h4 class="panel-title">
                                                                <a class="collapsed" data-toggle="collapse" data-parent="#question" href="#collapseQuestionTwo" aria-expanded="false" aria-controls="collapseTwo">
                                                                    Can I use gift card to pay for my purchase?
                                                                </a>
                                                            </h4>
                                                        </div><!-- end panel-heading -->
                                                        <div id="collapseQuestionTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="questionTwo">
                                                            <div class="panel-body">
                                                                <p>Lorem ipsum dolor sit amet, link adipisicing elit. Dicta voluptatem, tenetur eum tempore minus libero voluptates eos doloremque. Dolore minima rem consequuntur exercitationem quaerat deleniti repellendus enim necessitatibus mollitia tenetur?</p>
                                                            </div><!-- end panel-body -->
                                                        </div><!-- end collapse -->
                                                    </div><!-- end panel -->

                                                    <div class="panel panel-default">
                                                        <div class="panel-heading" role="tab" id="questionThree">
                                                            <h4 class="panel-title">
                                                                <a class="collapsed" data-toggle="collapse" data-parent="#question" href="#collapseQuestionThree" aria-expanded="false" aria-controls="collapseThree">
                                                                    How long will it take to get my order?
                                                                </a>
                                                            </h4>
                                                        </div><!-- end panel-heading -->
                                                        <div id="collapseQuestionThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="questionThree">
                                                            <div class="panel-body">
                                                                <p>Lorem ipsum dolor sit amet, link adipisicing elit. Dicta voluptatem, tenetur eum tempore minus libero voluptates eos doloremque. Dolore minima rem consequuntur exercitationem quaerat deleniti repellendus enim necessitatibus mollitia tenetur?</p>
                                                            </div><!-- end panel-body -->
                                                        </div><!-- end collapse -->
                                                    </div><!-- end panel -->
                                                </div><!-- end panel-group -->
                                            </div><!-- end col -->
                                        </div><!-- end row -->
                                    </div><!-- end tab-pane -->
                                </div><!-- end pills content -->
                        
                                <hr class="spacer-30">

                                <div class="row">
                                    <div class="col-sm-7 text-left">
                                        
                                    </div><!-- end col -->

                                    <div class="col-sm-5">
                                        
                                            <table class="table no-border">
                                                <tr>
                                                    <th>Cart Subtotal</th>
                                                    <td>$ <%= (Double.parseDouble(request.getParameter("price"))) * (Integer.parseInt(request.getParameter("qua"))) %></td>
                                                </tr>
                                                <tr>
                                                    <th>Shipping and Handling</th>
                                                    <td>Free Shipping</td>
                                                </tr>
                                                <tr>
                                                    <th>Order Total</th>
                                                    <td>$ <%= (Double.parseDouble(request.getParameter("price"))) * (Integer.parseInt(request.getParameter("qua"))) %></td>
                                                </tr>
                                            </table><!-- end table -->
                                        
                                    </div><!-- end col -->
                              
                            </div><!-- end col -->
                  
                    </div><!-- end col -->
                           
            </div><!-- end container -->
        </section>
        <!-- end section -->
       
               
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
        
        
        <!-- JavaScript Files -->
        <script type="text/javascript" src="js1/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js1/bootstrap.min.js"></script>
       
    </body>
</html>