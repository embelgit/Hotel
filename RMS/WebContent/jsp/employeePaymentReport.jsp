<%@page import="com.rms.hibernate.CashBook"%>
<%@page import="com.rms.dao.CashBookDao"%>
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
<title>Employee Payment Report</title>
<div class="container" align="center" style="margin-top: 10px">
				  		<h2 class="form-name-report">Employee Payment Reports</h2>
				  	</div>

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

		<script src="/RMS/staticContent/js/cashbookReport.js"></script>
	
</head>
<br>

<!--  <ul class="nav nav-tabs">
	    <li class="active"><a data-toggle="tab" href="#supp"><h4 style="color:blue">suup</h4></a></li> </ul> 
<ul class="nav nav-tabs"><li><a data-toggle="tab" href="#empl"><h4 style="color:blue">empl</h4></a></li></ul> 
  -->	
 	 
 	  <ul class="nav nav nav-tabs">
	    <li class="active"><a data-toggle="tab" href="#date"><h4 style="color:blue">Date Wise</h4></a></li>
	    <li><a data-toggle="tab" href="#employee"><h4 style="color:blue">Employee Wise</h4></a></li> 	  
 	    <li><a data-toggle="tab" href="#range"><h4 style="color:blue">Range Wise</h4></a></li> 	 
 	 </ul>
 	
 	 <div class="tab-content" style="float: left">
 
 	<!-- Total Stock -->
 	 <div id="date" class="tab-pane fade in active">

	<div>
			
			<form action="#" method="post" name="cashbookempDate" class="form-horizontal">
	<!-- 		<div class="row">
				<div class="form-group"> -->
				<fieldset>
					<div class="row form-group" style="margin-top: 20px">
				
					<div class="col-md-2 col-sm-offset-1" align="right">
					<label class="control-label">Payment Date :<sup>*</sup></label>
				</div>
				<div class="col-sm-3">
					<div class="input-group">
						<span class="input-group-addon"> 
						<i class="glyphicon glyphicon-calendar"></i>
						</span> 
						<input type="date" id='cashbookempDate' name="cashbookempDate" class="form-control" placeholder="Enter Date" />
					</div>
				</div>

			    <div class="col-md-offset-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getemppaymentDateWiseReport()" value="Search" />
				</div>
					</div>
					
						<div class="table-responsive">
						<table id="catName2" class="display" style=" border: 2px solid black; border-collapse: collapse;">
						    <thead>
								<tr>
						   
						    <th>Payment Type</th>
						    <th>Payment Name</th>
							<th>Type</th>
							<th>Payment Mode</th>
							<th>Total Amount</th>
							<th>Paid Amount</th>
							<th>Balance Amount</th>
							
							
						</tr>
					</thead>
				
				 <tfoot>
			<tr>
				<th colspan="4" style="text-align: right">Total:</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			</tfoot> 
				
				</table>
					</div>
					
					</fieldset>
					</form>
					</div>
					</div>
					
					
 	<div id="employee" class="tab-pane">
	<div>		
					
							
			<form action="#" method="post" name="cashbookemployee" class="form-horizontal">
		<!-- 	<div class="row">
				<div class="form-group"> -->
<!-- 					<div class="row" style="padding-top: 20"> -->
					<div class="row form-group" style="margin-top: 20px">
					  
						<div class="col-md-2 col-lg-2 col-sm-offset-1" align="right">
						<label class="control-label">Employee Name :<sup>*</sup></label>
						</div>
					
					<%
							CashBookDao daoo = new CashBookDao();
							List iList = daoo.getemployee(request);
					
					%>
					
					<div class="col-sm-3 col-lg-3">
					<div class="input-group">
					<span class="input-group-addon"> 
						<i class="glyphicon glyphicon-calendar"></i>
						</span> 
					<input list="cashbookempdrop" id="cashbookemp" class="form-control" autofocus="autofocus">
						<datalist id="cashbookempdrop">

							<%
								for (int i = 0; i < iList.size(); i++) {
									CashBook cust = (CashBook) iList.get(i);
							%>

							<option data-value="<%=cust.getPkCashBookEntry()%>"
								value="<%=cust.getToPayNameId()%>">
								<%
									}
								%>
							
						</datalist>
						</div>
				</div>

					<div class="col-md-offset-2">
						<input type="button" id="btn" name="save"
							class="btn btn-lg btn-success btn-md button_hw button_margin_left"
							onclick="getemppaymentSuppWiseReport()" value="Search" />
					</div>
					
					</div>
					<div class="table-responsive">
					<table id="catName3" class="display"
					style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
							   <th>Payment Type</th>
						    <th>Payment Name</th>
							<th>Type</th>
							<th>Payment Mode</th>
							<th>Total Amount</th>
							<th>Paid Amount</th>
							<th>Balance Amount</th>

						</tr>
					</thead>
		  <tfoot>
			<tr>
				<th colspan="4" style="text-align: right">Total:</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			</tfoot>  
		
		
				</table>
			</div>
				<!-- </div>-->
			
			</form> 
			</div>
			</div>
<!-- range wise -->
			<div id="range" class="tab-pane">
	<div>	
		<form action="#" method="post" name="cashbookemployeee" class="form-horizontal">
			
				<div class="row form-group" style="margin-top: 20px">
				<div class="col-md-2 col-lg-1 col-sm-offset-1" align="right">
					<label class="control-label">From:<sup>*</sup></label>
				</div>
				<div class="col-md-2 col-sm-3 col-lg-2">
					<div class="input-group">
						<span class="input-group-addon"> 
						<i class="glyphicon glyphicon-calendar"></i>
						</span> 
						<input type="date" id='datefrom' name="datefrom" class="form-control" placeholder="Enter order Bill Date" />
					</div>
				</div>

				<div class="col-md-2 col-lg-1 col-sm-offset-1" align="right">
					<label class="control-label">To:<sup>*</sup></label>
				</div>
				<div class="col-md-2 col-sm-3 col-lg-2">
					<div class="input-group">
						<span class="input-group-addon"> 
						<i class="glyphicon glyphicon-calendar"></i>
						</span> 
						<input type="date" id='dateto' name="dateto" class="form-control" placeholder="Enter order Bill Date" />
					</div>
				</div>

			    <div class="col-md-offset-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getpaymentRangeWiseReportemp()" value="Search" />
				</div>
			</div>
	<!-- 	</div>
												
						</div>
				</div>
 -->			
			
 			<div class="table-responsive">
					<table id="catName4" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Payment Type</th>
						    <th>Payment Name</th>
							<th>Type</th>
							<th>Payment Mode</th>
							<th>Total Amount</th>
							<th>Paid Amount</th>
							<th>Balance Amount</th>
						</tr>
					</thead>
					  <tfoot>
			<tr>
				<th colspan="4" style="text-align: right">Total:</th>
				
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

