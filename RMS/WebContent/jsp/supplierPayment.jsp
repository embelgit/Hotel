
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
<title>Payment Report</title>


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
	<style type="text/css">
	@media only screen and (min-width: 1200px){
	.table-responsive{
	margin-right:199px;
	margin-bottom:50px
	}
	}
	
	</style>
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<div class="heading">
				  		<h2 align="center" class="form-heading"><b>Payment Reports</b></h2>
				  		</div>
				  		<hr>
				  	</div>
				  	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
			</div>
	<div class="row" style="min-height:300px;">
    <div  class="col-md-12 col-lg-12 col-12 col-sm-12 col-xs-12 col-xl-12">
      <!--   <h3>Left Tabs</h3> -->
      
        <div class="col-md-2 col-12 col-sm-12 col-lg-2 col-xl-2 col-xs-12 ">
            <ul class="nav nav-tabs tabs-left">
                <li class="active"><a href="#home" data-toggle="tab" >Supplier Payment Reports</a></li>
                <li><a href="#employeerp" data-toggle="tab">Employee Payment Reports</a></li>
                
            </ul>
        </div>
  <div class="col-xs-9 col-9 col-md-9 col-lg-9 col-xl-9 col-sm-9">
            <!-- Tab panes -->
    <div class="tab-content">
    	
    <!---------- 	supplier Payment reports --------     ============      ======== ==========   ============     ===================   ========      ----->
    
    <div class="tab-pane active" id="home">
       		<div class="row">
				  <div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
				<div class="col-md-12 col-lg-5 col-xl-5 col-sm-12">
				<div class="heading">
				  		<h3 align="center" class="form-heading"><b>Supplier Payment Reports</b></h3>
				  		</div>
				  	</div>
				 	<div class="col-md-12 col-lg-1 col-xl-1 col-sm-12"></div>
			   
			    
			    </div>
 	 
 	  <ul class="nav nav nav-tabs">
	    <li class="active"><a data-toggle="tab" href="#date"><h4 style="color:blue">Date Wise</h4></a></li>
	    <li><a data-toggle="tab" href="#supplier"><h4 style="color:blue">Supplier Wise</h4></a></li> 	  
 		<li><a data-toggle="tab" href="#range"><h4 style="color:blue">Range Wise</h4></a></li>
 	 </ul>
 	
 	 <div class="tab-content" style="float: left">
 
 	<!-- Total Stock -->
 	 <div id="date" class="tab-pane fade in active">

	<div>
			
			<form action="#" method="post" name="cashbooktableDate" class="form-horizontal">
	<!-- 		<div class="row">
				<div class="form-group"> -->
				
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='cashbookDate' name="cashbookDate" class="form-control"  required />
						<label>Payment Date:<sup>*</sup></label>
					</div>
				</div>
			</div>
		</div>
	</div>
<div class="row form-group " align="center" style="margin-bottom:50px"> 
<div class="col-lg-12 col-md-offset-3 col-md-12 col-sm-12 col-xs-12">
<div class="helt">
<div class="col-md-2  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getpaymentDateWiseReport()" value="Search" />
				</div>
			</div>
		</div>
	</div>
					<div class="container">
						<div class="table-responsive">
						<table id="catName" class="display" style=" border: 2px solid black; border-collapse: collapse;">
						    <thead>
								<tr>
						   <th>Transaction ID</th>
						    <th>Payment Type</th>
						    <th>Payment Name</th>
							<th>Type</th>
							<th>Payment Mode</th>
							<th>Total Amount</th>
							<th>Paid Amount</th>
							<th>Balance Amount</th>
							<th>Date</th>
							
						</tr>
					</thead>
				
				 <tfoot>
			<tr>
				<th colspan="5" style="text-align: right">Total:</th>
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
					
					
 	<div id="supplier" class="tab-pane">
	<div>		
					
							
			<form action="#" method="post" name="cashbooksupplier" class="form-horizontal">
		<!-- 	<div class="row">
				<div class="form-group"> -->
<!-- 					<div class="row" style="padding-top: 20"> -->
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						
					
					<%
							CashBookDao daoo = new CashBookDao();
							List iList = daoo.getsupplier(request);
					
					%>
					
					<input list="cashbooksuppdrop" id="cashbooksupp" class="form-control" autofocus="autofocus" required>
						<datalist id="cashbooksuppdrop">

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
						<label>Supplier Name :<sup>*</sup></label>
						</div>
				</div>
			</div>
	</div>
</div>
<div class="row form-group " align="center" style="margin-bottom:50px"> 
<div class="col-lg-12 col-md-offset-3 col-md-12 col-sm-12 col-xs-12">
<div class="helt">
<div class="col-md-2  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
						<input type="button" id="btn" name="save"
							class="btn btn-lg btn-success btn-md "
							onclick="getpaymentsupplierReport()" value="Search" />
					</div>
				</div>
			</div>
		</div>
			<div class="container">
					<div class="table-responsive" >
					<table id="catName1" class="display"
					style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
							<th>Transaction ID</th>
							 <th>Payment Type</th>
						    <th>Payment Name</th>
							<th>Type</th>
							<th>Payment Mode</th>
							<th>Total Amount</th>
							<th>Paid Amount</th>
							<th>Balance Amount</th>
							<th>Date</th>

						</tr>
					</thead>
		  <tfoot>
			<tr>
				<th colspan="5" style="text-align: right">Total:</th>
				
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

<!-- range wise -->
			
			<div id="range" class="tab-pane">
	<div>	
		<form action="#" method="post" name="cashbooksupplierrange" class="form-horizontal">
			
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6   col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
				 
						<input type="date" id='datefrom' name="datefrom" class="form-control" required/>
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
		<div class="col-md-6  col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
				<input type="date" id='dateto' name="dateto" class="form-control" required />
				<label>To:<sup>*</sup></label>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<div class="row form-group " align="center" style="margin-bottom:50px"> 
<div class="col-lg-12 col-md-offset-3 col-md-12 col-sm-12 col-xs-12">
<div class="helt">
<div class="col-md-2  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left" style="margin: inherit;"
						onclick="getpaymentRangeWiseReport()" value="Search" />
				</div>
			</div>
	</div>
</div>
	<!-- 	</div>
												
						</div>
				</div>
 -->			
		<div class="container">
 			<div class="table-responsive">
					<table id="catName2" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Transaction ID</th>
							 <th>Payment Type</th>
						    <th>Payment Name</th>
							<th>Type</th>
							<th>Payment Mode</th>
							<th>Total Amount</th>
							<th>Paid Amount</th>
							<th>Balance Amount</th>
							<th>Date</th>
						</tr>
					</thead>
					  <tfoot>
			<tr>
				<th colspan="5" style="text-align: right">Total:</th>
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
	
</div>

</div>

	<!-- employee payment reports    --------------------------------------- ------------------------------------------------------------------------------ -->
			 <div class="tab-pane" id="employeerp">
	         	<div class="row">
				  <div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
				<div class="col-md-12 col-lg-6 col-xl-6 col-sm-12">
				<div class="heading">
				  		<h2 align="center" class="form-heading"><b>Employee Payment Reports</b></h2>
				  		</div>
				  	</div>
				 	 <div class="col-md-12 col-lg-1 col-xl-1 col-sm-12"></div>
				 	</div>
			    
					
					<ul class="nav nav nav-tabs">
	    <li class="active"><a data-toggle="tab" href="#date1"><h4 style="color:blue">Date Wise</h4></a></li>
	    <li><a data-toggle="tab" href="#employee1"><h4 style="color:blue">Employee Wise</h4></a></li> 	  
 	    <li><a data-toggle="tab" href="#range1"><h4 style="color:blue">Range Wise</h4></a></li> 	 
 	 </ul>
 	
 	 <div class="tab-content" style="float: left">
 
 	<!-- Total Stock -->
 	 <div id="date1" class="tab-pane fade in active">

	<!-- <div> -->
			
			<form action="#" method="post" name="cashbookempDate" class="form-horizontal">
	<!-- 		<div class="row">
				<div class="form-group"> -->
			<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='cashbookempDate' name="cashbookempDate" class="form-control" required />
						<label>Payment Date :<sup>*</sup></label>
					</div>
				</div>
			</div>
		</div>
	</div>
				<div class="row form-group " align="center" style="margin-bottom:50px"> 
<div class="col-lg-12 col-md-offset-3 col-md-12 col-sm-12 col-xs-12">
<div class="helt">
<div class="col-md-2  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getemppaymentDateWiseReport()" value="Search" />
				</div>
			</div>
	</div>
	</div>
					<div class="container">
						<div class="table-responsive">
						<table id="catName5" class="display" style=" border: 2px solid black; border-collapse: collapse;">
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
				</div>
				
					</form>
					<!-- </div> -->
					</div>
					
					
 	<div id="employee1" class="tab-pane">
	<!-- <div> -->		
					
							
			<form action="#" method="post" name="cashbookemployee" class="form-horizontal">
		<!-- 	<div class="row">
				<div class="form-group"> -->
<!-- 					<div class="row" style="padding-top: 20"> -->
						<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					
					
					<%
							CashBookDao daoo1 = new CashBookDao();
							List iList1 = daoo1.getemployee(request);
					
					%>
					
					<input list="cashbookempdrop" id="cashbookemp" class="form-control" autofocus="autofocus" required>
						<datalist id="cashbookempdrop">

							<%
								for (int i = 0; i < iList1.size(); i++) {
									CashBook cust = (CashBook) iList1.get(i);
							%>

							<option data-value="<%=cust.getPkCashBookEntry()%>"
								value="<%=cust.getToPayNameId()%>">
								<%
									}
								%>
							
						</datalist>
							<label>Employee Name :<sup>*</sup></label>
						</div>
				</div>
			</div>
		</div>
	</div>
		<div class="row form-group " align="center" style="margin-bottom:50px"> 
<div class="col-lg-12 col-md-offset-3 col-md-12 col-sm-12 col-xs-12">
<div class="helt">
<div class="col-md-2  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
						<input type="button" id="btn" name="save"
							class="btn btn-lg btn-success btn-md button_hw button_margin_left"
							onclick="getemppaymentSuppWiseReport()" value="Search" />
					</div>
				</div>
			</div>
		</div>
			
				<div class="container">
					<div class="table-responsive">
					<table id="catName6" class="display"
					style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
							   <th>Payment Type</th>
						    <th>Payment Name</th>
							<th>Type</th>
							<th>Payment Mode</th>
							<th>Total Amount</th>
							<th>Paid Amount</th>
							<th>Total Balance Amount</th>

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
		</div>
				<!-- </div>-->
			
			</form> 
			<!-- </div> -->
			</div>
<!-- range wise -->
			<div id="range1" class="tab-pane">
	<div>	
		<form action="#" method="post" name="cashbookemployeee1" class="form-horizontal">
	<div class="item">		
	<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
	<div class="col-md-6  col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
					<input type="date" id='datefromm' name="datefromm" class="form-control" required />
						<label>From:<sup>*</sup></label>
					</div>
				</div>

			<div class="col-md-6  col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='datetoo' name="datetoo" class="form-control" required/>
						<label>To:<sup>*</sup></label>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row form-group " align="center" style="margin-bottom:50px"> 
<div class="col-lg-12 col-md-offset-3 col-md-12 col-sm-12 col-xs-12">
<div class="helt">
<div class="col-md-2  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left" style="margin: inherit;"
						onclick="getpaymentRangeWiseReportemp10()" value="Search" />
				</div>
			</div>
		</div>
	</div>
		
	<!-- 	</div>
												
						</div>
				</div>
 -->			
			<!-- <div class="container"> -->
 			<div class="table-responsive">
					<table id="catName7" class="display" style=" border: 2px solid black; border-collapse: collapse;">
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
				</div>
					</form>
					</div>
					</div>
	
</div>
					


</div>

</div>
</div>
</div>
</div>
</body>
</html>