<%@page import="javafx.scene.control.Alert"%>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.rms.utility.HibernateUtility"%>
<%@page import="org.hibernate.Session"%>

<html>
<head>


<% 					
					String type1= "";
    				String type2= "";
                     String name1 = "";
		             if (session != null) 
		             {
		            	 System.out.println("If session is not null");
		            	 
		            	 if (session.getAttribute("user") != null) {
			            	 System.out.println("If username is not null");
		//	            	 out.println("<font color=red>Either userName or Password is wrong.</font>");
			        				 }
			         else {
					     System.out.println("Before redieecting to login in header.jsp - ");
					     response.sendRedirect("/RMS/jsp/login.jsp");	
					     System.out.println("If user is null ----");
					  //   out.println("Please Login Again !");
	//				     out.println("alert('User or Password is Incorrect');");
		            	 out.println("<font color=red>Either Username or Password is wrong.</font>");
				        }
		         
		             }			
		             else {
							
		            	 response.sendRedirect("/RMS/jsp/login.jsp");	
					     System.out.println("If session is null - --- ");
					 //    out.println("Please Login !");
					     out.println("alert('User or Password is Incorrect');");
				        }
	           %>





<!-- All CSS files -->
<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">


<!-- Bootstrap css -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- custome css -->
<link href="/RMS/staticContent/css/header.css" rel="stylesheet">

<!-- All JS files -->

<!-- Bootstrap JS -->
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>

<script src="/RMS/staticContent/js/jquery.min.js"></script>
<!-- Custome JS -->
<script src="/RMS/staticContent/js/header.js"></script>
 <script src="/RMS/staticContent/js/login.js"></script>
<!-- 	<script src="/RMS/staticContent/js/logout.js"></script> -->
</head>
<body>

	<!-- <h3 style="float: right;">This is Date</h3> -->

 	<div id="wrapper">

		<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
			<ul class="nav sidebar-nav">
				<li class="sidebar-brand"><!-- <img src="/RMS/staticContent/images/profile photo.png" class="img-circle img-responsive pro-image" alt="Pro img" /> -->
				<i class="las la-utensils"></i><span>Menu</span> <!-- margin-top: -35px; -->
				</li>
				
				<li class="dropdown">
					<a href="" class="dropdown-toggle" data-toggle="dropdown">
					<i class="las la-cash-register" title="Order Billing"></i><span class="menu-name-style">Order Billing</span>
					<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li></li>
						<li><a href="/RMS/jsp/tempOrderbill.jsp"><span class="menu-name-style">Kiosk Bill</span></a></li>
	     				<li><a href="/RMS/jsp/OrderBill.jsp"><span class="menu-name-style">Order Bill Table No wise</span></a></li>
					</ul>
				</li> 
				
				<li><a href="/RMS/jsp/kitchenOrder.jsp"><i class="las la-concierge-bell" title="Kitchen Order"></i><span class="menu-name-style">Kitchen Order</span></a></li>						
				
				<li><a href="/RMS/jsp/Goods_Receive.jsp"><i class="las la-cart-arrow-down" title="Purchase Good"></i><span class="menu-name-style">Purchase Good</span></a></li>
				
				<li><a href="/RMS/jsp/expenditure.jsp"><i class="las la-wallet" title="Add Expenditure"></i><span class="menu-name-style">Add Expenditure</span></a></li>		
				
				<li><a href="/RMS/jsp/itemEntry.jsp"><i class="las la-book-medical" title="Add Menu"></i><span class="menu-name-style">Add Menu</span></a></li>
		
				<li><a href="/RMS/jsp/SupplierDetails.jsp"><i class="las la-cart-plus" title="Add Supplier"></i><span class="menu-name-style">Add Supplier</span></a></li>

				<li><a href="/RMS/jsp/addWaiter.jsp"><i class="las la-id-card" title="Add Employees"></i><span class="menu-name-style">Add Employees</span></a></li>		
				
				<li><a href="/RMS/jsp/create-user.jsp"><i class="las la-user-plus" title="Add User"></i><span class="menu-name-style">Add User</span></a></li>
				
				<li><a href="/RMS/jsp/hotelname.jsp"><i class="las la-hotel" title="Add Hotel"></i><span class="menu-name-style">Add Hotel</span></a></li>
				
				<li><a href="/RMS/jsp/transferstock.jsp"><i class="las la-shipping-fast" title="Transfer Stock"></i><span class="menu-name-style">Transfer Stock</span></a></li>
				
				<li class="dropdown">
					<a href="" class="dropdown-toggle" data-toggle="dropdown">
					<i class="las la-book" title="Cash Book"></i><span class="menu-name-style">Cash Book</span>
					<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li></li>
						<li><a href="/RMS/jsp/cashBook.jsp"><span class="menu-name-style">Supplier Payment</span></a></li>
	      				<li><a href="/RMS/jsp/employeecashbook.jsp"><span class="menu-name-style">Employee Payment</span></a></li>
						<li><a href="/RMS/jsp/expenditurebook.jsp"><span class="menu-name-style">Expenditure Payment</span></a></li>
					</ul>
				</li>
		
				<li class="dropdown">
					<a href="" class="dropdown-toggle" data-toggle="dropdown">
					<i class="las la-clipboard" title="Reports"></i><span class="menu-name-style">Reports</span>
					<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li></li>					
						<li><a href="/RMS/jsp/GoodsReceiveReportnew.jsp"><span class="menu-name-style">Purchase Reports</span></a></li>	
						<li><a href="/RMS/jsp/saleReport.jsp"><span class="menu-name-style">Sale Reports</span></a></li>					
						<li><a href="/RMS/jsp/supplierPayment.jsp"><span class="menu-name-style">Payment Reports</span></a></li>										
						<li><a href="/RMS/jsp/credit_debitReport.jsp"><span class="menu-name-style">Credit Debit Report</span></a></li>
						<li><a href="/RMS/jsp/expenditureReport.jsp"><span class="menu-name-style">Expenditure Report</span></a></li>
				    	<li><a href="/RMS/jsp/today'sReport.jsp"><span class="menu-name-style">Day Closure</span></a></li>				
						<li><a href="/RMS/jsp/lowStock.jsp"><span class="menu-name-style">Low Stock Report</span></a></li>
						<li><a href="/RMS/jsp/totalstock.jsp"><span class="menu-name-style">Total Stock</span></a></li>	
						<li><a href="/RMS/jsp/employeeReport.jsp"><span class="menu-name-style">Employee Report</span></a></li>
						<li><a href="/RMS/jsp/menuList.jsp"><span class="menu-name-style">Menu List Report</span></a></li>
						<li><a href="/RMS/jsp/OrderBillCopy.jsp"><span class="menu-name-style">Order Bill Copy</span></a></li>	
					</ul>
				</li>			
					
				<li><a href="/RMS/jsp/access_control.jsp"><i class="las la-user-lock" title="Access Control"></i><span class="menu-name-style">Access Control</span></a></li>					
					
				<li><a onclick="Logout()" style="cursor: pointer;"><i class="las la-sign-out-alt" title="Logout"></i><span class="menu-name-style">Logout</span></a></li>						
			</ul>
		</nav>

		<div id="page-content-wrapper">
			<button type="button" class="hamburger is-closed" data-toggle="offcanvas">
				<span class="hamb-top"></span> <span class="hamb-middle"></span> <span class="hamb-bottom"></span>
			</button>
			<div class="shortcut-i">
				<a href="/RMS/jsp/Goods_Receive.jsp"><i class="las la-cart-arrow-down" title="Purchase Good"></i></a>
				<a onclick="Logout()" style="cursor: pointer;"><i class="las la-sign-out-alt" title="Logout"></i></a>
			</div>
		</div>
	</div>   
</body>
</html>

