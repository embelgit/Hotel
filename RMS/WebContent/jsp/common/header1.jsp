<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="/RMS/staticContent/js/jquery.min.js"></script>

<!-- Bootstrap css -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- custome css -->
<link href="/RMS/staticContent/css/header.css" rel="stylesheet">

<!-- All JS files -->

<!-- Bootstrap JS -->
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>


<!-- Custome JS -->
<script src="/RMS/staticContent/js/header.js"></script>
 <script src="/RMS/staticContent/js/login.js"></script>
</head>
<body>
	<div id="wrapper">

		<div class="overlay"></div>
	
		<nav class="navbar navbar-inverse navbar-fixed-top"
			id="sidebar-wrapper" role="navigation">
		<ul class="nav sidebar-nav">
			<li class="sidebar-brand"><img
				src="/RMS/staticContent/images/profile photo.png"
				class="img-circle img-responsive pro-image" alt="Pro img" />
			<p align="center" style="color: #FFFFFF; margin-top: -35px;">Menu</p>
			</li>
			
			
					  <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="menu-name-style">Menu Update</span> <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li></li>
						<li><a href="/RMS/jsp/add-update-menu.jsp"><span class="menu-item-style">Add/Update Menu</span></a></li>
						<li><a href="/RMS/jsp/itemEntry.jsp"><span class="menu-item-style">Item Entry</span></a></li>
						<li><a href="/RMS/jsp/editItemEntry.jsp"><span class="menu-item-style">Edit Item Entry</span></a></li>
						<li><a href="/RMS/jsp/itemDetails.jsp"><span class="menu-item-style">Item Details</span></a></li>
						<li><a href="/RMS/jsp/editItemDetails.jsp"><span class="menu-item-style">Edit Item Details</span></a></li>
						<li><a href="/RMS/jsp/editDrinkDetails.jsp"><span class="menu-item-style">Edit Drink Details</span></a></li>
						<li><a href="/RMS/jsp/SupplierDetails.jsp"><span class="menu-item-style">Supplier Details</span></a></li>
						<li><a href="/RMS/jsp/editSupplierDetails.jsp"><span class="menu-item-style">Edit Supplier Details</span></a></li>
						<li><a href="/RMS/jsp/goodReceived.jsp"><span class="menu-item-style">Good Received</span></a></li>
						<li><a href="/RMS/jsp/menuList.jsp"><span class="menu-item-style">Menu List</span></a></li>
						<li><a href="/RMS/jsp/KYCDetails.jsp"><span class="menu-item-style">KYC Details</span></a></li>
						<li><a href="/RMS/jsp/allPaymentWithLeftTabs.jsp"><span class="menu-item-style">Cashbook</span></a></li>
					</ul>
				</li> 
			</ul>
		</nav>

		<!-- /#sidebar-wrapper -->
		<!-- Page Content -->
		<div id="page-content-wrapper">

			<button type="button" class="hamburger is-closed"
				data-toggle="offcanvas">
				<span class="hamb-top"></span> <span class="hamb-middle"></span> <span
					class="hamb-bottom"></span>
			</button>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
			
</body>
</html>