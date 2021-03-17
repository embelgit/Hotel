<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.helper.ItemEntryHelper"%>

<% boolean isHome=false;%>
<%@include file="common/header.jsp"%> 
	<title>Order Bill Report</title>
	
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
        
		<script src="/RMS/staticContent/js/orderBillReport.js"></script>
		<script src="/RMS/staticContent/js/orderBillTableWiseReport.js"></script>
	
<!-- 	<script>
	     $(document).ready(function(){
	    	 getOrderBillDateWiseReport();
	}); 
	</script> -->

	<body id="dt_example" class="master_form_img">
	    <div class="container-fluid">

		<div class="row header_margin_top" style="margin-top: 10px; align: centre">
			<div align="center">
				<h2 class="form-name style_heading">Order Bill Report Date Wise</h2>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group" align="right">
				<div class="col-sm-offset-8 col-md-4 control-label">
					<div id="date">
						<label id="demo"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

			<!-- <div id="demo_jui"> -->
			
		<form action="#" method="post" name="OrderBilltableDate" class="form-horizontal">
			
			<div class="row">
			<div class="form-group">
				<div class="col-md-2 col-sm-offset-1" align="right">
					<label class="control-label">Order Bill Date:<sup>*</sup></label>
				</div>
				<div class="col-sm-3">
					<div class="input-group">
						<span class="input-group-addon"> 
						<i class="glyphicon glyphicon-calendar"></i>
						</span> 
						<input type="date" id='orderBillDate' name="orderBillDate" class="form-control" placeholder="Enter order Bill Date" />
					</div>
				</div>

			    <div class="col-md-offset-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getOrderBillDateWiseReport()" value="Search" />
				</div>
			</div>
		</div>
			
			
			<div class="table-responsive">
					<table id="catName" class="display" style=" border: 2px solid black;border-collapse: collapse;">
						    <thead>
								<tr>
						    <th>Sr No</th>
						    <th>Table No</th>
						    <th>Item Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Unit In Ml</th>
							<th>Total</th>
							<th>GrossTotal</th>
							
							
						</tr>
					</thead>
				
				 <tfoot>
			<tr>
				<th colspan="6" style="text-align: right">Total:</th>
				<th></th>
				
				<th></th>
			</tr>
			</tfoot> 
				
				</table>
					</div>
 
               </form>
		</div>
</body>
</html>

 <%@include file="common/newFooter.jsp"%> 		