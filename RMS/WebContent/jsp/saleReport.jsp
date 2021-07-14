
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>

<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.dao.GoodsReceiveDao" %>
<%@page import="com.rms.hibernate.GoodsReceiveHibernate" %>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.hibernate.SupplierDetailsHibernate" %>
<%@ page import="com.rms.dao.TempItemDetailDao"%>
<%@page import="com.rms.bean.OrderBillReportDateWiseBean" %>
<%@page import="com.rms.helper.ItemEntryHelper"%>

<%@page import="com.rms.dao.AddWaitersDao"%>
<%@page import="com.rms.dao.CustomerOrderDao"%>
<%@page import="com.rms.hibernate.CustomerOrder"%>
<%@ page import="com.rms.dao.StockDao"%>
<%@page import="com.rms.hibernate.AddWaiters" %>
<%@page import="com.rms.bean.AddWaitersList" %>
<%@page import="com.rms.hibernate.Stock" %>

<% boolean isHome=false;%>
 <%@include file="common/header.jsp"%> 
<title>Sale Report</title>


<head>



		<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
		<script src="/RMS/staticContent/shree/jquery.dataTables.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/dataTables.buttons.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/buttons.flash.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/jszip.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/pdfmake.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/vfs_fonts.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/buttons.html5.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/buttons.print.min.js" type="text/javascript"></script>
		<link href="/RMS/staticContent/y_css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/RMS/staticContent/y_css/buttons.dataTables.min.css" rel="stylesheet" type="text/css" media="all">
		<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
		<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
		<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->
		
	

		<script type="text/javascript" src="/RMS/staticContent/js/selectjj.js"></script>
		<script src="/RMS/staticContent/js/jquery.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.dataTables.js" type="text/javascript"></script>
		<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
		<link href="/RMS/staticContent/css/dataTa.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/RMS/staticContent/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css" media="all">
		<link href="/RMS/staticContent/css/select.css" rel="stylesheet" type="text/css" media="all">

		<script src="/RMS/staticContent/js/orderBillReport.js"></script>
		<script src="/RMS/staticContent/js/orderBillTableWiseReport.js"></script>
		<script src="/RMS/staticContent/js/attendedWaiter.js"></script>
		
			<!-- 	<script type="text/javascript"> 
			$(document).ready(function () {
		         var table=$("#list").dataTable();
				 var tableTools = new $.fn.dataTable.TableTools(table, {
					 'sSwfPath':'//cdn.datatables.net/tabletools/2.2.4/swf/copy_csv_xls_pdf.swf',
					 	'aButtons':['copy','print','csv',{
						 'sExtends':'xls',
						 'sFileName':'Data.xls',
						 'sButtonText': 'Save to Excel'
							}
						]
					});
						$(tableTools.fnContainer()).insertBefore('#list_wrapper');
				});
		</script>   -->

<style type="text/css">
	
	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap');

	* {
		font-family: 'Poppins', sans-serif;
	}

	body {
		background: #131D28;
	}
	
	#start {
		margin-left: 75px; 
		transition: margin-left 500ms;
	}
	
	#wrapper.toggled ~ #start {
		margin-left: 240px !important; 
	}
	
	#wrapper.toggled ~ #foot {
		left: 240px !important;  
		padding-left: 335px;
	}
	
	.form-heading {
		color: #fff;
	}
	
	.display-transaction {
	 	float: right; 
	 	margin-right: 30px; 
	 	margin-top: 10px;  
	 	color: /* #f00 */#ead24c;
	 }
	 
	.display-date {
	 	float: right; 
	 	margin-right: 50px; 
	 	margin-top: 10px; 
	 	color: #fff;
	 }
	
	.form-background {
		/* background: #0B1218;
    	position: relative;
    	padding: 20px; */
    	
    	background: #2e3c48;
    	position: relative;
    	padding: 20px;
    	box-shadow: 5px 8px 12px #0c1317;
	}
	
	form .form-group {
		position: relative;
		margin: 30px 30px;
		float: center;
	}
	
	.form-group input {
		width: 100%;
		padding: 0 5px;
		height: 40px;
		font-size: 16px;
		border: none;
		outline: none;
		background: none !important;
		color: #fff;
	}
	
	.form-group label {
		position: absolute;
		top: 50%;
		left: 23px;
		color: #fff;
		transform: translateY(-50%);
		font-size: 16px;
		pointer-events: none;
		transition: .5s;
	}
	
	.form-group select{
		width: 100%;
		padding: 0px 5px;
		height: 40px;
		font-size: 16px;
		border: none;
		outline: none;
		background: none !important;
		color: #fff;
		font-weight: 900;
	}
	
	.op-bg {
		background-color: #131d28;
	}
	
	.form-group span:before {
		content:'';
		position: absolute;
		top: 40px;
		left: 0;
		width: 100%;
		height: 2px;
		background: #00aabb;
	}
	
	.form-group input:focus ~ label,
	.form-group input:valid ~ label,
	.form-group input:read-only ~ label,
	.form-group select:focus ~ label,
	.form-group select:valid ~ label,
	.form-group input[type="date"] ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.table-responsive .ui-jqgrid-bdiv {
		height: 175px !important;
	}
	
	.ibutton input[type="button"],[type="reset"] {
		width: 150px;
		padding-left: 40px;
		padding-bottom: 7px;
		margin-top: 28px;
		margin-left:20px;
	}
	
	.cust {
		position: absolute;
		margin-left: 38px;
		margin-top: 35px;
		font-size: 30px;
		color: #fff;
	}
	
	.ibutton .row {
    	margin-left: -30px;
	}
	
	::-webkit-calendar-picker-indicator {
    	filter: invert(1);
	}
	
	table.dataTable thead th, table.dataTable tfoot th {
    	color: #5cb85c;
	} 
	
	.dataTables_wrapper .dataTables_length, .dataTables_wrapper .dataTables_filter, .dataTables_wrapper .dataTables_info, .dataTables_wrapper .dataTables_processing, .dataTables_wrapper .dataTables_paginate {
    	color: #00afc1;
	}
	
	.nav-pills .nav-link {
    	border-radius: 50px;
	} 

	.nav-pills a.nav-link {
    	color: #00aabb;
	}
	
	.nav-pills>li.active>a, .nav-pills>li.active>a:focus, .nav-pills>li.active>a:hover {
    	color: #fff;
    	/* background-color: #314190; */
	}
	
	.ui-widget-header {
   		border: 1px solid #1110;
    	background: #1110 url(images/ui-bg_highlight-soft_75_cccccc_1x100.png) 50% 50% repeat-x;
	}

	.ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default {
    	border: 1px solid #1110;
    	background: #1110 url(images/ui-bg_glass_75_e6e6e6_1x400.png) 50% 50% repeat-x;
	}
	
	.dataTables_wrapper .dataTables_paginate .fg-button:first-child {
    	color: #00afc1;
	}
	
	.dataTables_wrapper .dataTables_paginate .fg-button:last-child {
    	color: #00afc1;
	}
	
	.ui-state-disabled, .ui-widget-content .ui-state-disabled, .ui-widget-header .ui-state-disabled {
    	opacity: 1;
    }

	@media ( max-width : 1200px) {
		#wrapper.toggled ~ #start {
			width: 1200px;
		}
		
		.row {
			margin-right: 0px !important;
		}
	}
	
	@media ( max-width : 992px) {
		#wrapper.toggled ~ #start {
    		width: 1104px;
    	}
    }
	
	@media ( max-width : 767px) {
		#wrapper.toggled ~ #start { 
			width: 966px !important;
		}
	}
	
	@media (max-width: 580px) {
		#wrapper.toggled ~ #start {
    		width: 966px;
		}
	}
	
	@media (max-width: 480px) {
		#wrapper.toggled ~ #start {
    		width: 963px;
		}
	}
</style>

</head>
<body>
	<div id="start">
		<div class="row">
			<div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
				<div class="heading">
				  	<h2 align="center" class="form-heading"><b>Sale Reports</b></h2>
				</div>
			</div>
		</div>	
		<br>
		<div class="form-background">
			<div class="mm" >
				<ul class="nav nav-pills mb-3">
	    			<li class="nav-item active"><a class="nav-link" data-toggle="tab" href="#date"><h4>Date Wise</h4></a></li>
	     			<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#table"><h4>Order Billing Wise</h4></a></li>
	    			<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#today"><h4>Waiter Wise</h4></a></li>
	   				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#range"><h4>Range Wise</h4></a></li>
 	 			</ul>
 			</div>	 
 	 		<div class="tab-content">
 				<!-- Total Stock -->
 	 			<div id="date" class="tab-pane fade in active">
					<form action="#" method="post" name="OrderBilltableDate" class="form-horizontal">
						<div class="row form-group"> 
							<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
								<div class="col-md-4  col-md-offset-4 col-sm-offset-4 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
									<div class="">
										<input type="date" id='orderBillDate' name="orderBillDate" required/>
										<span></span>
										<label>Order Bill Date <sup>*</sup></label>
									</div>
								</div>
							</div>
						</div>
						<div class="ibutton" style="padding-bottom:20px;">
							<div class="row" align="center">
								<i class="las la-search la-2x cust"></i>
								<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md" onclick="getOrderBillDateWiseReport()" value="Search" />
							</div>
						</div>
						<br>
						<div class="table-responsive">
							<table id="catName" class="display" style="border:2px solid white; border-collapse: collapse;">
						    	<thead>
									<tr>
						    			<th>Sr. No.</th>
						    			<th>Table No.</th>
						    			<th>Item Name</th>
										<th>Quantity</th>
										<th>Unit Price</th>
										<th>Unit</th>
										<th>Unit Value</th>
										<th>Total</th>
										<th>GrossTotal</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th colspan="7" style="text-align: right">Total:</th>
										<th></th>
										<th></th>
									</tr>
								</tfoot> 
							</table>
						</div>
					</form>
				</div>				
 				<div id="table" class="tab-pane">		
					<form action="#" method="post" name="OrderBilltable" class="form-horizontal">
						<div class="row form-group"> 
							<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
								<div class="col-md-4  col-md-offset-4 col-sm-offset-4 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
									<div class="">
										<select name="department" class="selectpicker" id='tableNo' autofocus="autofocus" required>
									<!--  <option value=""></option> --> 
											<option class="op-bg" value="Kiosk Bill">Kiosk Billing</option>
											<option class="op-bg" value="Table wise Bill">Table wise Billing</option>
<!-- 									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>

									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>

									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>

									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option> -->
										</select>
										<span></span>
										<label>Billing Type <sup>*</sup></label>
									</div>
								</div>
							</div>
						</div>
						<div class="ibutton" style="padding-bottom:20px">
							<div class="row" align="center">
								<i class="las la-search la-2x cust"></i>
								<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md" onclick="getOrderBillTableWiseReport()" value="Search" />
							</div>
						</div>
						<div class="table-responsive">
							<table id="catName1" class="display" style="border:2px solid white; border-collapse: collapse;">
								<thead>
									<tr>
										<th>Sr. No.</th>
										<th>Table No.</th>
										<th>Item Name</th>
										<th>Quantity</th>
										<th>Unit Price</th>
										<th>Unit</th>
										<th>Unit Value</th>
										<th>Total</th>
										<th>GrossTotal</th>
										<th>Bill No</th>
										<th>Current Date</th>
									</tr>
								</thead>
		  						<tfoot>
									<tr>
										<th colspan="7" style="text-align: right">Total:</th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</tfoot>  
							</table>
						</div>
					</form> 
				</div>
				<div id="today" class="tab-pane">
	 				<form action="#" method="post" name="attendedWaiterreport" class="form-horizontal">
						<div class="row form-group"> 
							<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
								<div class="col-md-3  col-md-offset-1 col-sm-offset-1 col-sm-3 col-xs-3 col-xl-3 col-lg-3">
									<div class="invoice_label_up">
									<%
										AddWaitersDao itemEntryDao = new AddWaitersDao();
										List iList = itemEntryDao.getAllwaiterName(request);
									%> 
										<input list="fk_item_id_drop" id="fk_item_id" autofocus="autofocus" required>
										<datalist id="fk_item_id_drop">
									<%
										for (int i = 0; i < iList.size(); i++) {
											AddWaiters cust = (AddWaiters) iList.get(i);
									%>
											<option data-value="<%=cust.getPkAddWaiterId()%>" value="<%=cust.getFirstName()%> <%=cust.getLastName()%>">
									<%
										}
									%>
										</datalist>
										<span></span>
										<label>Waiter Name <sup>*</sup></label>
									</div>
								</div>
								<div class="col-md-3  col-md-offset-1 col-sm-offset-1 col-sm-3 col-xs-3 col-xl-3 col-lg-3">
									<div class="">
										<input type="date" id='Datefrom' name="Datefrom" required />
										<span></span>
										<label>From <sup>*</sup></label>
									</div>
								</div>
								<div class="col-md-3  col-md-offset-1 col-sm-offset-1 col-sm-3 col-xs-3 col-xl-3 col-lg-3">
									<div class="">
										<input type="date" id='Dateto' name="Dateto" required />
										<span></span>
										<label>To <sup>*</sup></label>
									</div>
								</div>
							</div>
						</div>	
						<div class="ibutton" style="padding-bottom:20px">
							<div class="row" align="center">
								<i class="las la-search la-2x cust"></i>
								<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md" onclick="getattendedwaiterReport()" value="Search" />
							</div>
						</div>
						<br>
						<div class="table-responsive">
							<table id="catName2" class="display" style="border: 2px solid white; border-collapse: collapse;">
 								<thead>
									<tr>
										<th>Bill No.</th>
										<th>Table No.</th>
										<th>Item Name</th>
										<th>Quantity</th>
										<th>Price</th>
										<th>Total</th>
									</tr>
								</thead>
					 			<tfoot>
									<tr>
										<th colspan="5" style="text-align: right">Total:</th>
										<th></th>
									</tr>
								</tfoot>
							</table>
						</div>
	 				</form> 
				</div>
				<div id="range" class="tab-pane">	
					<form action="#" method="post" name="OrderBilltableDate" class="form-horizontal">
						<div class="row form-group"> 
							<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
								<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
									<div class=""> 
										<input type="date" id='datefrom' name="datefrom" required />
										<span></span>
										<label>From <sup>*</sup></label>
									</div>
								</div>
								<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
									<div class="">
										<input type="date" id='dateto' name="dateto" required />
										<span></span>
										<label>To <sup>*</sup></label>					
									</div>
								</div>
							</div>
						</div>
						<div class="ibutton" style="padding-bottom:20px">
							<div class="row" align="center">
								<i class="las la-search la-2x cust"></i>
								<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md" onclick="getgoodReceiveRangeWiseReport()" value="Search" />
							</div>
						</div>
 						<div class="table-responsive">
							<table id="catName4" class="display" style=" border: 2px solid white; border-collapse: collapse;">
 								<thead>
									<tr>
										<th>Sr. No.</th>
						    			<th>Table No.</th>
						    			<th>Item Name</th>
										<th>Quantity</th>
										<th>Unit Price</th>
										<th>Unit</th>
										<th>Unit Value</th>
										<th>Total</th>
										<th>GrossTotal</th>
										<th>Bill No.</th>
									</tr>
								</thead>
					 	 		<tfoot>
									<tr>
										<th colspan="7" style="text-align: right">Total:</th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</tfoot>
							</table>
						</div>
					</form>
				</div>
			</div>	
		</div>
	</div>
</body>
</html>

<%@include file="common/newFooter.jsp"%>