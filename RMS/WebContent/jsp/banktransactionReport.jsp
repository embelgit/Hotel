<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.CashBookDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>

<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.dao.GoodsReceiveDao" %>
<%@page import="com.rms.hibernate.bankdetailHibernate" %>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.hibernate.SupplierDetailsHibernate" %>
<% boolean isHome=false;%>
 <%@include file="common/header.jsp"%> 
<title>Bank Transaction Report</title>

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
		<script src="/RMS/staticContent/js/bankcashbook.js"></script>
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				  		<h2 align="center" class="form-heading"><b>Bank Transaction Report</b></h2>
				  	</div>
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
</div>
<div class="mm">
 <ul class="nav nav-tabs" style="border-bottom: none;">
	    <li class="active"><a data-toggle="tab" href="#exp"><h4 style="color:blue">Bank Name Wise</h4></a></li>

	    <li><a data-toggle="tab" href="#exprage"><h4 style="color:blue">Range wise</h4></a></li> 	  
 	 </ul>
 	 </div>
 <div class="tab-content">
 
 	<!-- expenditure name Stock -->
 	 <div id="exp" class="tab-pane fade in active">
			
		<form action="#" method="post" name="bankreport1" class="form-horizontal">
		<div class="item">
	<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-3 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
			
							<%
							com.rms.dao.CashBookDao daoo = new CashBookDao();
							List slist = daoo.getAllbankfromCBforreport(request);
							%>
							
							<input list="fkbankname_drop" id="fkbankname" class="form-control" required autofocus="autofocus">
							<datalist id="fkbankname_drop">
								<%
							 for (int i = 0; i < slist.size(); i++) {
								 bankdetailHibernate sup = (bankdetailHibernate) slist.get(i);
                             %>
								<option data-value="<%=sup.getPkbankdetailid()%>"
									value="<%=sup.getBankname()%>">

									<%
									}
								%>
								
							</datalist>
						
						<label>Bank Name:<sup>*</sup></label>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div class="ibutton">
	<div class="row" align="center">
						<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_left" onclick="getbanknamewiseReport()" value="Search" />
					</div>
				</div>
				<br>
				<div class="container" style="margin-bottom:100px;margin-left:90px">
						<div class="table-responsive">
						<table id="catName1" class="display" style=" border: 2px solid black;border-collapse: collapse;">
						    <thead>
						<tr>
						    <th>Sr No</th>
						    <th>Bank Name</th>
						    <th>Account Name</th>
							<th>Amount</th>
							<th>Contact Number</th>
							<th>Payment Type</th>
							<th>Date</th>
						</tr>
					</thead>
				
				 <tfoot>
			<tr>
				<th colspan="3" style="text-align: right">Total:</th>
				
				<th></th>			
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
		
<!-- 	<!-- 	Date wise--------------------------------------------------------------- -->

	<!-- range wise ------------          ------------         ----------------------->
	
	
		<div id="exprage" class="tab-pane">
	
		<form action="#" method="post" name="bankreport2" class="form-horizontal">
		<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='rangefrom' name="rangefrom" class="form-control" required/>
						<label>From:<sup>*</sup></label>
					</div>
				</div>
				<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class=""> 
						<input type="date" id='rangetoo' name="rangetoo" class="form-control" required />
						<label>To:<sup>*</sup></label>
					</div>
				</div>
		</div>
	</div>
</div>
<div class="ibutton">
	<div class="row" align="center">
					<input type="button"  name="save" 
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getBankrangeWiseReport()" value="Search" />
				</div>
			</div>
			<br>
			<div class="container" style="margin-bottom:100px;margin-left:90px">
						<div class="table-responsive">
						<table id="catName3" class="display" style=" border: 2px solid black;border-collapse: collapse;">
						    <thead>
								<tr>
						    <th>Sr No</th>
						    <th>Bank Name</th>
						    <th>Account Name</th>
							<th>Amount</th>
							<th>Contact Number</th>
							<th>Payment Type</th>
							<th>Date</th>
						</tr>
					</thead>
				
				 <tfoot>
			<tr>
				<th colspan="3" style="text-align: right">Total:</th>
				<th></th>
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
		
</body>
</html>