<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>

<%@page import="java.util.List"%>
<%@page import="com.rms.dao.CashBookDao"%>
<%@page import="com.rms.dao.CustomerOrderDao" %>
<%@page import="com.rms.hibernate.GoodsReceiveHibernate" %>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.hibernate.SupplierDetailsHibernate" %>
<% boolean isHome=false;%>
 <%@include file="common/header.jsp"%> 
<title>Credit Debit Report</title>

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
		
		<script src="/RMS/staticContent/js/credit_debit.js"></script>

</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<div class="heading">
				  		<h2 align="center" class="form-heading"><b>Credit Debit Report</b></h2>
				  		</div>
				  		<hr>
				  	</div>
<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
</div>
 
 <div class="mm"> 
 	 <ul class="nav nav nav-tabs" style="border-bottom: none;">
	    <li class="active"><a data-toggle="tab" href="#credit"><h4 style="color:blue">Credit Report</h4></a></li>
	    <li><a data-toggle="tab" href="#debit"><h4 style="color:blue">Debit Report</h4></a></li> 	  
 	 </ul>
 </div>	 
 	 <div class="tab-content" style="float: left">
 
 	<!-- Total Stock -->
 	
 	
 	 <div id="credit" class="tab-pane fade in active">
	<div>	
		<form action="#" method="post" name="creditDate" class="form-horizontal">
			
			<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-2 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='creditdatefrm' name="creditdatefrm" class="form-control" required />
							<label>Credit Date From:<sup>*</sup></label>
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
						<input type="date" id='creditdateto' name="creditdateto" class="form-control"  />
						<label>Credit Date To:<sup>*</sup></label>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getCreditDateWiseReport()" value="Search" />
				</div>
			</div>
	
	<!-- 	</div>
												
						</div>
				</div>
 -->			
			
 			<div class="container" style="margin-left: 95px;">
 			<div class="table-responsive">
					<table id="catName1" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Bill No</th>
							<th>Table No</th>	
							<th>Waiter Name</th>
							<th>Credit Amount</th>
						</tr>
					</thead>
					  <tfoot>
			<tr>
				<th colspan="3" style="text-align: right">Total:</th>
				
				<th></th>
			</tr>
			</tfoot>
					</table>
					</div>
				</div>
					</form>
					</div>
					</div>
					
					
 	

	 <div id="debit" class="tab-pane">
	<div>	
		<form action="#" method="post" name="debitDate" class="form-horizontal">
			
	<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6 col-md-offset-2  col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='debitdatefrm' name="debitdatefrm" class="form-control" required />
						<label>Debit Date From:<sup>*</sup></label>
			
					</div>
				</div>

<!-- 			    <div class="col-md-offset-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getdebitDateWiseReport()" value="Search" />
				</div>
			</div>
			
			<div class="row form-group" style="margin-top: 20px"> -->
			<div class="col-md-6 col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='debitdateto' name="debitdateto" class="form-control" required />
						<label>Debit Date To:<sup>*</sup></label>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="ibutton">
	<div class="row" align="center"  style="margin-bottom:50px">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getdebitDateWiseReport()" value="Search" />
				</div>
			</div>
	
		<!-- </div> -->
												
						<!-- </div> -->
				<!-- </div> -->
			
			<div class="container" style="margin-left: 95px;"> 
 			<div class="table-responsive">
					<table id="catName2" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Transaction ID</th>
							<th>Type</th>	
							<th>Name</th>
							<th>Debit Total Amount</th>
							<th>Debit Balance Amount</th>
							
						</tr>
					</thead>
					  <tfoot>
			<tr>
				<th colspan="3" style="text-align: right">Total:</th>
				
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

