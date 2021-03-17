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
		            	 System.out.println("if session is not null");
		            	 
		            	 if (session.getAttribute("user") != null) {
			            	 System.out.println("if username is not null");
		//	            	 out.println("<font color=red>Either userName or Password is wrong.</font>");
			        				 }
			         else {
					     System.out.println("before redieecting to login in header.jsp - ");
					     response.sendRedirect("/RMS/jsp/login.jsp");	
					     System.out.println("if user is null ----");
					  //   out.println("Please Login Again !");
	//				     out.println("alert('User or Password is Incorrect');");
		            	 out.println("<font color=red>Either userName or Password is wrong.</font>");
				        }
		         
		             }			
		             else {
							
		            	 response.sendRedirect("/RMS/jsp/login.jsp");	
					     System.out.println("if session is null - --- ");
					 //    out.println("Please Login !");
					     out.println("alert('User or Password is Incorrect');");
				        }
	           %>





<!-- All CSS files -->



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

		<div class="overlay"></div>
		<!-- Sidebar -->
		<nav class="navbar navbar-inverse navbar-fixed-top"
			id="sidebar-wrapper" role="navigation">
		<ul class="nav sidebar-nav">
			<li class="sidebar-brand"><img
				src="/RMS/staticContent/images/profile photo.png"
				class="img-circle img-responsive pro-image" alt="Pro img" />
			<p align="center" style="color: #FFFFFF; margin-top: -35px;">Menu</p>
			</li>
		
			<!-- <button onclick="Logout()" style="height: 35px;width: 85px;color: blue; background: #ffffff;font-weight: 600;border: 2px solid black;"></button>
 -->
			<!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="menu-name-style"> User</span> <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li></li>	
						<li></li>										
						<li><a href="/RMS/jsp/create-user.jsp"><span class="menu-item-style">Create User</span></a></li>
						<li><a href="/RMS/jsp/addWaiter.jsp"><span class="menu-item-style">Create Waiter</span></a></li>				
					</ul>
				</li> -->
				


			<!--  <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="menu-name-style">Menu Update</span> <span class="caret"></span></a>
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
				</li> -->
			<li><a href="/RMS/jsp/itemEntry.jsp"><span
					class="menu-item-style"><p align="left"></p>Add Menu</span></a></li>
		
		

			<li><a href="/RMS/jsp/SupplierDetails.jsp"><span
					class="menu-name-style"><p align="left"></p>Add Supplier</span></a></li>
	
			<!-- <li><a href="/RMS/jsp/KYCDetails.jsp"><span class="menu-item-style">KYC Details</span></a></li> -->
			<!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="menu-name-style"> Stock</span> <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li></li>
						<li><a href="/RMS/jsp/purchase_good.jsp"><span class="menu-item-style">Purchased Goods</span></a></li>
						<li><a href="/RMS/jsp/wastageGoods.jsp"><span class="menu-item-style">Wastage Goods</span></a></li>
						<li><a href="/RMS/jsp/stockReport.jsp"><span class="menu-item-style">Stock Report</span></a></li>						
					</ul>
				</li> -->

<!-- 			<li><a href="/RMS/jsp/OrderBill.jsp"><span
					class="menu-name-style"><p align="left"></p>Order Bill Table
						No wise</span></a></li> -->

			<li><a href="/RMS/jsp/Goods_Receive.jsp"><span
					class="menu-name-style"><p align="left"></p>Purchase Good</span></a></li>
				
				<li class="dropdown">
		<a href="" class="dropdown-toggle" data-toggle="dropdown">
		<span class="menu-name-style">Order Billing</span>
					<span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
						<li></li>
			<li>
			<a href="/RMS/jsp/tempOrderbill.jsp">
			<span class="menu-item-style"><p align="left">
			</p>Kiosk Bill</span></a></li>
	      
	       <li>
	       <a href="/RMS/jsp/OrderBill.jsp">
	       <span class="menu-item-style"><p align="left"></p>
	            Order Bill Table No wise</span></a></li>
		</ul>
		</li>
		
		<li>
		<a href="/RMS/jsp/transferstock.jsp"><span
			class="menu-name-style"><p align="left"></p>Transfer Stock</span></a></li>
			
					<!-- 	<li><a href="/RMS/jsp/cashBook.jsp"><span
					class="menu-name-style"><p align="left"></p>Cash Book</span></a></li> -->
				
		<li class="dropdown"><a href="" class="dropdown-toggle" data-toggle="dropdown">
		<span class="menu-name-style">CashBook</span><span class="caret"></span></a><ul class="dropdown-menu" role="menu">
						<li>
						</li>
			<li>
			<a href="/RMS/jsp/cashBook.jsp"><span class="menu-item-style"><p align="left"></p>Supplier Payment</span></a>
			</li>
	      
	       <li>
	       <a href="/RMS/jsp/employeecashbook.jsp"><span class="menu-item-style"><p align="left"></p> Employee Payment</span></a></li>
		</li>
		 <li>
	       <a href="/RMS/jsp/expenditurebook.jsp"><span class="menu-item-style"><p align="left"></p> Expenditure Payment</span></a></li>
		</li>
		<!--  <li>
			<a href="/RMS/jsp/bankcashbook.jsp"><span class="menu-item-style"><p align="left"></p>Bank Transaction</span></a>
			</li>--></ul>
		
		
			<li><a href="/RMS/jsp/kitchenOrder.jsp"><span
					class="menu-name-style"><p align="left"></p>Kitchen Order</span></a></li>

<!-- 			<li><a href="/RMS/jsp/kitchenOrder.jsp"><span
					class="menu-name-style"><p align="left"></p>Kitchen Order</span></a></li> -->


	<!-- 	 	<li class="dropdown"><a href="" class="dropdown-toggle"
				data-toggle="dropdown"><span class="menu-name-style">Reports</span>
					<span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
						<li></li>
						
					<li><a href="/RMS/jsp/kitchenOrder.jsp"><span
					class="menu-item-style"><p align="left"></p>Kitchen Order</span></a></li>	
						
					<li><a href="/RMS/jsp/lowStock.jsp"><span
							class="menu-item-style"><p align="left"></p>Low Stock
								Report</span></a></li>
					<li><a href="/RMS/jsp/today'sReport.jsp"><span
							class="menu-item-style"><p align="left"></p>Today's Sale
								Report</span></a></li>
								
					<li><a href="/RMS/jsp/attendedWaiter.jsp"><span
							class="menu-item-style"><p align="left"></p>Attended
								Waiter Report</span></a></li>
					<li><a href="/RMS/jsp/employeeReport.jsp"><span
							class="menu-item-style"><p align="left"></p>Employee
								Report</span></a></li>
					<li><a href="/RMS/jsp/Goods_Receive_Report.jsp"><span
							class="menu-item-style"><p align="left"></p>Goods Receive
								Report Item Wise</span></a></li>
					<li><a href="/RMS/jsp/goods_receiveReport.jsp"><span
							class="menu-item-style"><p align="left"></p>Goods Receive
								Report Supplier Wise</span></a></li>
					<li><a href="/RMS/jsp/goodsreceiveReport1jsp.jsp"><span
							class="menu-item-style"><p align="left"></p>Goods Receive
								Report Date Wise</span></a></li>
					
					<li><a href="/RMS/jsp/OrderBillReport.jsp"><span
							class="menu-item-style"><p align="left"></p>Order Bill
								Report Date Wise</span></a></li>
					<li><a href="/RMS/jsp/OrderBillReportTableNoWise.jsp"><span
							class="menu-item-style"><p align="left"></p>Order Bill
								Report Table Wise</span></a></li>
					<li><a href="/RMS/jsp/menuList.jsp"><span
							class="menu-item-style"><p align="left"></p>Menu List
								Report</span></a></li>
					<li><a href="/RMS/jsp/ItemDetailsReport_ItemNameWise.jsp"><span
							class="menu-item-style"><p align="left"></p>Total Stock</span></a></li>
					<li  style="margin-bottom: 15%"><a href="/RMS/jsp/OrderBillCopy.jsp"><span
							class="menu-item-style"><p align="left"></p>Order Bill
								Copy</span></a></li>
						
				</ul></li>  -->
						
				<!-- <li class="dropdown"><a href="" class="dropdown-toggle"
				data-toggle="dropdown"><span class="menu-name-style">Purchase Reports</span>
					<span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
						<li></li>
						<li><a href="/RMS/jsp/Goods_Receive_Report.jsp"><span
							class="menu-item-style"><p align="left"></p>Goods Receive
								Report Item Wise</span></a></li>
					<li><a href="/RMS/jsp/goods_receiveReport.jsp"><span
							class="menu-item-style"><p align="left"></p>Goods Receive
								Report Supplier Wise</span></a></li>
					<li><a href="/RMS/jsp/goodsreceiveReport1jsp.jsp"><span
							class="menu-item-style"><p align="left"></p>Goods Receive
								Report Date Wise</span></a></li>
					
					
					</ul></li>
					
				<li class="dropdown"><a href="" class="dropdown-toggle"
				data-toggle="dropdown"><span class="menu-name-style">Sale Reports</span>
					<span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
						<li></li>
			
						<li><a href="/RMS/jsp/today'sReport.jsp"><span
							class="menu-item-style"><p align="left"></p>Today's Sale
								Report</span></a></li>
					<li><a href="/RMS/jsp/OrderBillReport.jsp"><span
							class="menu-item-style"><p align="left"></p>Order Bill
								Report Date Wise</span></a></li>
					<li><a href="/RMS/jsp/OrderBillReportTableNoWise.jsp"><span
							class="menu-item-style"><p align="left"></p>Order Bill
								Report Table Wise</span></a></li>
						<li><a href="/RMS/jsp/attendedWaiter.jsp"><span
							class="menu-item-style"><p align="left"></p>Attended
								Waiter Report</span></a></li>
									
						</ul></li>	 -->
						
				
			<li class="dropdown"><a href="" class="dropdown-toggle"
				data-toggle="dropdown"><span class="menu-name-style">Reports</span>
					<span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
						<li></li>			
					
			<!-- <li><a href="/RMS/jsp/day_closure.jsp"><span
					class="menu-name-style"><p align="left"></p>New Day Closure Report</span></a></li>	 -->
					
			<li><a href="/RMS/jsp/GoodsReceiveReportnew.jsp"><span
					class="menu-name-style"><p align="left"></p>Purchase Reports</span></a></li>	
			<li><a href="/RMS/jsp/saleReport.jsp"><span
					class="menu-name-style"><p align="left"></p>Sale Reports</span></a></li>					
					
						
		<li><a href="/RMS/jsp/supplierPayment.jsp"><span
					class="menu-name-style"><p align="left"></p>Payment Reports</span></a></li>				
						
			<!-- 	<li><a href="/RMS/jsp/employeePaymentReport.jsp"><span
					class="menu-name-style"><p align="left"></p>Payment Report</span></a></li> -->								
				
				<li><a href="/RMS/jsp/credit_debitReport.jsp"><span
					class="menu-name-style"><p align="left"></p>Credit Debit Report</span></a></li>
					
					<!-- <li><a href="/RMS/jsp/todaysalereport.jsp"><span
					class="menu-name-style"><p align="left"></p>Today's Sale Report</span></a></li>	 -->
					
				<li><a href="/RMS/jsp/expenditureReport.jsp"><span
					class="menu-name-style"><p align="left"></p>Expenditure Report</span></a></li>
			
				<!-- <li><a href="/RMS/jsp/banktransactionReport.jsp"><span
					class="menu-name-style"><p align="left"></p>Bank Transaction Report</span></a></li> -->
					
				<!-- <li class="dropdown"><a href="" class="dropdown-toggle"
				data-toggle="dropdown"><span class="menu-name-style">Stock Reports</span>
					<span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
						<li></li> -->	
		     <li>
                    <a href="/RMS/jsp/today'sReport.jsp"><span class="menu-name-style"><p align="left"></p>Day Closure</span></a>
                </li>				
						
						<li><a href="/RMS/jsp/lowStock.jsp"><span
							class="menu-name-style"><p align="left"></p>Low Stock Report</span></a></li>
							<li><a href="/RMS/jsp/totalstock.jsp"><span
							class="menu-name-style"><p align="left"></p>Total Stock</span></a></li>		
				<!-- 		</ul></li> -->
				
						
						
					<!-- <li class="dropdown"><a href="" class="dropdown-toggle"
				data-toggle="dropdown"><span class="menu-name-style">Other Reports</span>
					<span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
						<li></li>		 -->
								<li><a href="/RMS/jsp/employeeReport.jsp"><span
							class="menu-item-style"><p align="left"></p>Employee
								Report</span></a></li>
											<li><a href="/RMS/jsp/menuList.jsp"><span
							class="menu-name-style"><p align="left"></p>Menu List
								Report</span></a></li>
								
							<li><a href="/RMS/jsp/OrderBillCopy.jsp"><span
							class="menu-name-style"><p align="left"></p>Order Bill
								Copy</span></a></li>	
					<!-- 	</ul></li>				 -->	
						
					</ul></li>
						
					<!--<li><a href="/RMS/jsp/todaySale.jsp"><span
					class="menu-name-style"><p align="left"></p>Add Today's Sale</span></a></li>-->		
					
						<li><a href="/RMS/jsp/expenditure.jsp"><span
					class="menu-name-style"><p align="left"></p>Add Expenditure</span></a></li>		
						<!--<li><a href="/RMS/jsp/bankdetails.jsp"><span
					class="menu-name-style"><p align="left"></p>Add Bank Details</span></a></li>  -->			
							<li><a href="/RMS/jsp/hotelname.jsp"><span
					class="menu-name-style"><p align="left"></p>Add Hotel</span></a></li>
					
		<li><a href="/RMS/jsp/access_control.jsp"><span
					class="menu-name-style"><p align="left"></p>Access Control</span></a></li>					
					
			<li><a href="/RMS/jsp/addWaiter.jsp"><span
					class="menu-item-style"><p align="left"></p>Add Employees</span></a></li>		
			
					<li><a href="/RMS/jsp/create-user.jsp"><span
					class="menu-item-style"><p align="left"></p>Add User</span></a></li>
				
						
	<li>   <!--  <a href="/RMS/jsp/login.jsp"><span class="menu-name-style">Logout</span></a> -->
				<a onclick="Logout()" style="cursor: pointer;"><span
					class="menu-name-style"><p align="left"></p>Logout</span></a> <%--  <button onclick="Logout()" style="height: 35px;width: 85px;color: black;background: #ffffff;font-weight: 600;border: 2px solid black;"><%if(abc.equals("marathi")){%><%=PropertiesHelper.marathiProperties.getProperty("logout") %> <%}%> <%if(abc.equals("english")){%>Log Out<%}%></button> --%>
			</li>					
						
						
<!-- 			 <li><a href="/RMS/jsp/Goods_Receive_Report.jsp"><span class="menu-item-style">Goods Receive Report</span></a></li>
						<li><a href="/RMS/jsp/ItemDetailsReport_ItemNameWise.jsp"><span class="menu-item-style">Total Stock</span></a></li>

						<li><a href="/RMS/jsp/OrderBillReport.jsp"><span class="menu-item-style">Order Bill Report Date Wise</span></a></li>
						<li><a href="/RMS/jsp/OrderBillReportTableNoWise.jsp"><span class="menu-item-style">Order Bill Report Table Wise</span></a></li>
						<li><a href="/RMS/jsp/menuList.jsp"><span class="menu-item-style">Menu List Report</span></a></li> 
			 <li>
                    <a href="/RMS/jsp/lowStock.jsp"><span class="menu-name-style"><p align="left"></p>Low Stock Report</span></a>
                </li> 
	        <li>
                    <a href="/RMS/jsp/today'sReport.jsp"><span class="menu-name-style"><p align="left"></p>Today's Sale Report</span></a>
                </li>
                
				<li>
                    <a href="/RMS/jsp/attendedWaiter.jsp"><span class="menu-name-style"><p align="left"></p>Attended Waiter Report</span></a>
                </li> 	
				
					<li><a href="/RMS/jsp/employeeReport.jsp"><span class="menu-item-style"><p align="left"></p>Employee Report</span></a></li>	
	 			<li><a href="/RMS/jsp/Goods_Receive_Report.jsp"><span class="menu-item-style"><p align="left"></p>Goods Receive Report Item Wise</span></a></li> 
	<li><a href="/RMS/jsp/goods_receiveReport.jsp"><span class="menu-item-style"><p align="left"></p>Goods Receive Report Supplier Wise</span></a></li>					
	<li><a href="/RMS/jsp/goodsreceiveReport1jsp.jsp"><span class="menu-item-style"><p align="left"></p>Goods Receive Report Date Wise</span></a></li>	 -->
 
			<%-- 				 <li class="treeview ">
                            <a>
                                <i class="fa fa ti-calendar"></i> <span>Good Receive Report</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                           	<li><a class="padding" class="padding" href="<%=path%>/RMS/jsp/Goods_Receive_Report.jsp">Good Receive Item wise</a></li>
 				<li><a class="padding" class="padding" href="<%=path%>/RMS/jsp/goods_receiveReport.jsp">Good Receive Supplier wise</a></li>
 					<li><a class="padding" class="padding" href="<%=path%>/RMS/jsp/goodsreceiveReport1jsp.jsp">Good Receive Date wise</a></li>
 				
                            </ul>
                        </li> --%>
			<!-- 			<li><a href="/RMS/jsp/ItemDetailsReport_DrinkWise.jsp"><span class="menu-item-style">Item Drink Wise</span></a></li> -->

			<!-- 						<li><a href="/RMS/jsp/ItemDetailsReport_ItemNameWise.jsp"><span class="menu-item-style"><p align="left"></p>Total Stock</span></a></li> -->

			<!-- <li><a href="/RMS/jsp/ItemDetailsReport_DrinkWise.jsp"><span class="menu-item-style">Item Drink Wise</span></a></li> -->

			<!-- 						<li><a href="/RMS/jsp/OrderBillReport.jsp"><span class="menu-item-style"><p align="left"></p>Order Bill Report Date Wise</span></a></li>
						<li><a href="/RMS/jsp/OrderBillReportTableNoWise.jsp"><span class="menu-item-style"><p align="left"></p>Order Bill Report Table Wise</span></a></li>
						<li><a href="/RMS/jsp/menuList.jsp"><span class="menu-item-style"><p align="left"></p>Menu List Report</span></a></li> -->

			<!--    <li>
                    <a href="/RMS/jsp/feedback.jsp"><span class="menu-name-style">Feedback</span></a>
                </li> -->

			<!-- <li>
                    <a href="#"><span class="menu-name-style">Help</span></a>
                </li> -->


			<!--                 <li>
                    <a href="/RMS/jsp/OrderBillCopy.jsp"><span class="menu-name-style"><p align="left"></p>Order Bill Copy</span></a>
                </li> -->

			
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
	<!-- /#wrapper -->
</body>
</html>

