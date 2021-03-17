
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
		<link rel="stylesheet" href="/RMS/staticContent/css/style.css">
		
	

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
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				  		<h2 align="center" class="form-heading"><b>Sale Reports</b></h2>
				  	</div>
				 <div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
			</div>	
<div class="mm1" >
<ul class="nav nav-tabs" style="border-bottom: none;">
	    <li class="active"><a data-toggle="tab" href="#date"><h4 style="color:blue">Date Wise</h4></a></li>
	     <li><a data-toggle="tab" href="#table"><h4 style="color:blue">Order Billing Wise</h4></a></li>
	    <li><a data-toggle="tab" href="#today"><h4 style="color:blue">Waiter Wise</h4></a></li>
	   <li><a data-toggle="tab" href="#range"><h4 style="color:blue">Range Wise</h4></a></li>
 	 </ul>
 </div>	 
 	 <div class="tab-content" style="float: left">
 
 	<!-- Total Stock -->
 	 <div id="date" class="tab-pane fade in active">

	<div>
			
			<form action="#" method="post" name="OrderBilltableDate" class="form-horizontal">
	<!-- 		<div class="row">
				<div class="form-group"> -->
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-4 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='orderBillDate' name="orderBillDate" class="form-control" required/>
						<label>Order Bill Date:<sup>*</sup></label>
					</div>
				</div>
		</div>
	</div>
</div>
<div class="row form-group " align="center" style="margin-bottom:50px"> 
	<div class="col-lg-12 col-md-offset-6 col-md-12 col-sm-12 col-xs-12">
		<div class="helt">
			<div class="col-md-2  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
					<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getOrderBillDateWiseReport()" value="Search" />
			</div>
		</div>
	</div>
</div>
					<div class="container" style="margin-bottom:100px;margin-left:92px">
						<div class="table-responsive">
						<table id="catName" class="display" style=" border: 2px solid black;border-collapse: collapse;">
						    <thead>
								<tr>
						    <th>Sr No</th>
						    <th>Table No</th>
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
		</div>	
	</form>
	</div>
</div>
					
					
 	<div id="table" class="tab-pane">
	<div>		
					
							
			<form action="#" method="post" name="OrderBilltable" class="form-horizontal">
		<!-- 	<div class="row">
				<div class="form-group"> -->
<!-- 					<div class="row" style="padding-top: 20"> -->
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-4 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
					
					<select name="department"
								class="form-control selectpicker" id='tableNo' autofocus="autofocus" required>
									<!--  <option value=""></option> --> 
									<option value="Kiosk Bill">Kiosk Billing</option>
									<option value="Table wise Bill">Table wise Billing</option>
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
							
							<!-- <input type="text" id='tableNo' name="tableNo" class="form-control" placeholder="Enter table no." /> -->
							<label>Billing Type:<sup>*</sup></label>
						</div>
					</div>
				</div>
			</div>
		</div>
		

	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">
	<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_left"
		onclick="getOrderBillTableWiseReport()" value="Search" />
					</div>
				</div>
		
		
			<div class="container" style="margin-bottom:100px;margin-left:92px">
					<div class="table-responsive">
					<table id="catName1" class="display "
					style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
							<th>Sr No</th>
							<th>Table No</th>
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
		</div>
				<!-- </div>-->
			
			</form> 
			</div>
	
</div>




	<div id="today" class="tab-pane">
	<div>	

	 <form action="#" method="post" name="attendedWaiterreport" class="form-horizontal">
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						

						<%
							AddWaitersDao itemEntryDao = new AddWaitersDao();
							List iList = itemEntryDao.getAllwaiterName(request);
						%> 
						<input list="fk_item_id_drop" id="fk_item_id" class="form-control" autofocus="autofocus" required>
						<datalist id="fk_item_id_drop">

							<%
								for (int i = 0; i < iList.size(); i++) {
									AddWaiters cust = (AddWaiters) iList.get(i);
							%>

							<option data-value="<%=cust.getPkAddWaiterId()%>"
								value="<%=cust.getFirstName()%> <%=cust.getLastName()%>">
								<%
									}
								%>
							
						</datalist>
						<label>Waiter Name:<sup>*</sup></label>
					</div>
					</div>
			<div class="col-md-6   col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='Datefrom' name="Datefrom" class="form-control" required />
						<label>From:<sup>*</sup></label>
					</div>
				</div>
		<div class="col-md-6   col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='Dateto' name="Dateto" class="form-control" required />
						<label>To:<sup>*</sup></label>
				</div>
		</div>
	</div>
</div>
</div>
					
			<!-- </div> -->
			
<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">
			<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_left" onclick="getattendedwaiterReport()" value="Search" />
					</div>
				</div>
		
	<div class="container" style="margin-bottom:100px;margin-left:92px">
			<div class="table-responsive">
					<table id="catName2" class="display" style="border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Bill No</th>
							<th>Table No</th>
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
		</div>
	 					</form> 
					</div>
					</div>
					
					
	<div id="range" class="tab-pane">
	<div>	
		<form action="#" method="post" name="OrderBilltableDate" class="form-horizontal">
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-2 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class=""> 
						<input type="date" id='datefrom' name="datefrom" class="form-control" required />
						<label>From:<sup>*</sup></label>
					</div>
				</div>

			   <!--  <div class="col-md-offset-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getgoodReceiveDateWiseReport()" value="Search" />
				</div> -->
			<!-- </div>
			
			<div class="row form-group" style="margin-top: 20px"> -->
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='dateto' name="dateto" class="form-control" required />
						<label>To:<sup>*</sup></label>					
					</div>
				</div>
			</div>
		</div>
	</div>

<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">
		<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getgoodReceiveRangeWiseReport()" value="Search" />
				</div>
			</div>
	
	<!-- 	</div>
												
						</div>
				</div>
 -->			
			<div class="container" style="margin-bottom:100px;margin-left:90px">
 			<div class="table-responsive">
					<table id="catName4" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Sr No</th>
						    <th>Table No</th>
						    <th>Item Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Unit</th>
							<th>Unit Value</th>
							<th>Total</th>
							<th>GrossTotal</th>
							<th>Bill No</th>
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
				</div>
					</form>
					</div>
					</div>	
					
					
					
</div>

