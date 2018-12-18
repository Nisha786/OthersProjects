<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Spencer Admin</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="vendor/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@page import="javax.servlet.http.HttpSession"%>
	<%
		if (session.getAttribute("adminLogin") == null) {
			response.sendRedirect("admin.jsp");
		}
	%>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav"> <a class="navbar-brand" href="index.html">Spencer
		Admin</a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Dashboard"><a class="nav-link" href="index.html"> <i
					class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Tables"><a class="nav-link" href="ProductAddView.jsp"> <i
					class="fa fa-fw fa-table"></i> <span class="nav-link-text">Add
						Products</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Tables"><a class="nav-link" href="tables.html"> <i
					class="fa fa-fw fa-table"></i> <span class="nav-link-text">Add
						Customers</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Tables"><a class="nav-link" href="tables.html"> <i
					class="fa fa-fw fa-table"></i> <span class="nav-link-text">Customers
						List</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Tables"><a class="nav-link" href="tables.html"> <i
					class="fa fa-fw fa-table"></i> <span class="nav-link-text">Get
						Stock</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Tables"><a class="nav-link" href="tables.html"> <i
					class="fa fa-fw fa-table"></i> <span class="nav-link-text">OrderList</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Tables"><a class="nav-link" href="tables.html"> <i
					class="fa fa-fw fa-table"></i> <span class="nav-link-text">AddHomePageImages</span>
			</a></li>

		</ul>
		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item"><a class="nav-link text-center"
				id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
			</a></li>
		</ul>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><font color="white">Welcome :
					${adminLogin}</font></li>
			<li class="nav-item"><a class="nav-link" href="LogOutCtl"> <i
					class="fa fa-fw fa-sign-out"></i>Logout
			</a></li>
		</ul>
	</div>
	</nav>
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
				<li class="breadcrumb-item active">My Dashboard</li>
			</ol>
			<!-- Icon Cards-->
			<div class="row">
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-primary o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-fw fa-comments"></i>
							</div>
							<div class="mr-5">26 New Messages!</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-warning o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-fw fa-list"></i>
							</div>
							<div class="mr-5">11 New Tasks!</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-success o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-fw fa-shopping-cart"></i>
							</div>
							<div class="mr-5">123 New Orders!</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-danger o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-fw fa-support"></i>
							</div>
							<div class="mr-5">13 New Tickets!</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
			</div>
			<!-- Area Chart Example-->

			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Data Table Example
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Name</th>
									<th>Position</th>
									<th>Office</th>
									<th>Age</th>
									<th>Start date</th>
									<th>Salary</th>
								</tr>
							</thead>


						</table>
					</div>
				</div>
				<div class="card-footer small text-muted">
					Updated
					<%=new Date()%></div>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © Your Website 2018</small>
			</div>
		</div>
		</footer>
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>
		<!-- Logout Modal-->

		<!-- Bootstrap core JavaScript-->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
		<!-- Page level plugin JavaScript-->
		<script src="vendor/chart.js/Chart.min.js"></script>
		<script src="vendor/datatables/jquery.dataTables.js"></script>
		<script src="vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="vendor/sb-admin.min.js"></script>
		<!-- Custom scripts for this page-->
		<script src="vendor/sb-admin-datatables.min.js"></script>
		<script src="vendor/sb-admin-charts.min.js"></script>
	</div>
</body>

</html>
