<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.CashBookDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>

<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.dao.GoodsReceiveDao" %>
<%@page import="com.rms.hibernate.expenditureHibernate" %>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.hibernate.SupplierDetailsHibernate" %>
<% boolean isHome=false;%>
 <%@include file="common/header.jsp"%> 
<title>Expenditure Report</title>

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
		<script src="/RMS/staticContent/js/expenditure_report.js"></script>
		
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
		background-color: black;
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
	
	.dataTables_wrapper .dataTables_paginate .paginate_button.disabled, .dataTables_wrapper .dataTables_paginate .paginate_button.disabled:hover, .dataTables_wrapper .dataTables_paginate .paginate_button.disabled:active {
   		color: #00afc1 !important;
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
				  	<h2 align="center" class="form-heading"><b>Expenditure Report</b></h2>
				</div>
			</div>
		</div>
		<br>
		<div class="form-background">
			<div class="mm">
 				<ul class="nav nav-pills mb-3">
	    			<li class="nav-item active"><a class="nav-link" data-toggle="tab" href="#exp"><h4>Expenditure Name </h4></a></li>
	     			<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#expdate"><h4>Date wise</h4></a></li>
	    			<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#exprage"><h4>Range wise</h4></a></li> 	  
 	 			</ul>
 	 		</div>
 			<div class="tab-content">
 				<!-- expenditure name Stock -->
 	 			<div id="exp" class="tab-pane fade in active">
					<form action="#" method="post" name="expenditurereport1" class="form-horizontal">
						<div class="row form-group"> 
							<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
								<div class="col-md-4  col-md-offset-4 col-sm-offset-4 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
									<div class="invoice_label_up">
									<%
										com.rms.dao.CashBookDao daoo = new CashBookDao();
										List slistt = daoo.getAllexpenditureforreport(request);
									%>
										<input list="fkexpenditurename_drop" id="fkexpenditurename" required autofocus="autofocus">
										<datalist id="fkexpenditurename_drop"> 
									<%
							 			for (int i = 0; i < slistt.size(); i++) {
								 			expenditureHibernate sup = (expenditureHibernate) slistt.get(i);
                             		%>
											<option data-value="<%=sup.getPk_expid()%>" value="<%=sup.getExpenditurename()%>">
									<%
										}
									%>
										</datalist>
										<span></span>
										<label>Expenditure Name <sup>*</sup></label>
									</div>
								</div>
							</div>
						</div>
						<div class="ibutton" style="padding-bottom:20px;">
							<div class="row" align="center">
								<i class="las la-search la-2x cust"></i>
								<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md" onclick="getexpenditureReport()" value="Search" />
							</div>
						</div>
						<br>
						<div class="table-responsive">
							<table id="catName1" class="display" style=" border: 2px solid white; border-collapse: collapse;">
						    	<thead>
									<tr>
						    			<th>Sr. No.</th>
						    			<th>Expenditure Name</th>
						    			<th>Expenditure Amount</th>
										<th>Payment Type</th>
										<th>Payment Date</th>
										<th>Card No</th>
										<th>Cheque No</th>
										<th>Cheque Date</th>
										<th>NEFT Account No</th>
									</tr>
								</thead>
				 				<tfoot>
									<tr>
										<th colspan="2" style="text-align: right">Total:</th>
										<th></th>
										<th></th>
										<th></th>
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
				<!-- 	Date wise--------------------------------------------------------------- -->
				<div id="expdate" class="tab-pane">
					<form action="#" method="post" name="expenditurereport2" class="form-horizontal">
						<div class="row form-group"> 
							<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
								<div class="col-md-4  col-md-offset-4 col-sm-offset-4 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
									<div class="">
										<input type="date" id='expdatee' name="expdatee" required />
										<span></span>
										<label>Payment Date <sup>*</sup></label>
									</div>
								</div>
							</div>
						</div>
						<div class="ibutton" style="padding-bottom:20px;">
							<div class="row" align="center">
								<i class="las la-search la-2x cust"></i>
								<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md" onclick="getexpDateWiseReport()" value="Search" />
							</div>
						</div>
						<br>
						<div class="table-responsive">
							<table id="catName2" class="display" style="border: 2px solid white; border-collapse: collapse;">
						   		<thead>
									<tr>
						   				<th>Sr. No.</th>
						   				<th>Expenditure Name</th>
						   				<th>Expenditure Amount</th>
										<th>Payment Type</th>
										<th>Payment Date</th>
										<th>Card No</th>
										<th>Cheque No</th>
										<th>Cheque Date</th>
										<th>NEFT Account No</th>
									</tr>
								</thead>
				 				<tfoot>
									<tr>
										<th colspan="2" style="text-align: right">Total:</th>
										<th></th>
										<th></th>
										<th></th>
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
				<!-- range wise ------------          ------------         ----------------------->
				<div id="exprage" class="tab-pane">
					<form action="#" method="post" name="expenditurereport3" class="form-horizontal">
						<div class="row form-group"> 
							<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
								<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
									<div class="">
										<input type="date" id='rangefrm' name="rangefrm" required/>
										<span></span>
										<label>From <sup>*</sup></label>
									</div>
								</div>
								<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
									<div class=""> 
										<input type="date" id='rangeto' name="rangeto" required />
										<span></span>
										<label>To <sup>*</sup></label>
									</div>
								</div>
							</div>
						</div>
						<div class="ibutton" style="padding-bottom:20px;">
							<div class="row" align="center">
								<i class="las la-search la-2x cust"></i>
								<input type="button"  name="save" class="btn btn-lg btn-success btn-md" onclick="getexprangeWiseReport()" value="Search" />
							</div>
						</div>
						<br>
						<div class="table-responsive">
							<table id="catName3" class="display" style="border: 2px solid white; border-collapse: collapse;">
						   		<thead>
									<tr>
						   				<th>Sr. No.</th>
						   				<th>Expenditure Name</th>
						   				<th>Expenditure Amount</th>
										<th>Payment Type</th>
										<th>Payment Date</th>
										<th>Card No</th>
										<th>Cheque No</th>
										<th>Cheque Date</th>
										<th>NEFT Account No</th>
									</tr>
								</thead>
				 				<tfoot>
									<tr>
										<th colspan="2" style="text-align: right">Total:</th>
										<th></th>
										<th></th>
										<th></th>
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
			</div>
		</div>
	</div>
</body>
</html>

<%@include file="common/newFooter.jsp"%>