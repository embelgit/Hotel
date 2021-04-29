<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>

<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.dao.GoodsReceiveDao" %>
<%@page import="com.rms.hibernate.GoodsReceiveHibernate" %>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.hibernate.SupplierDetailsHibernate" %>
<% boolean isHome=false;%>
 <%@include file="common/header.jsp"%> 
<title>Purchase Report</title>

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
		<script src="/RMS/staticContent/js/goodsReceiveReport.js"></script>

</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<div class="heading">
				  		<h2 align="center" class="form-heading"><b>Purchase Report</b></h2>
				  		</div>
				  		<hr>
				  	</div>
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
</div>
<div class="mm">
 <ul class="nav nav-tabs" style="border-bottom: none;">
	    <li class="active"><a data-toggle="tab" href="#item"><h4 style="color:blue">Item Name</h4></a></li>
	     <li><a data-toggle="tab" href="#Supplier"><h4 style="color:blue">Supplier Name</h4></a></li>
	    <li><a data-toggle="tab" href="#date"><h4 style="color:blue">Range</h4></a></li> 	  
 	 </ul>
 	 </div>
 
 	 <div class="tab-content">
 
 	<!-- Total Stock -->
 	 <div id="item" class="tab-pane fade in active">

	<div>
			
		<form action="#" method="post" name="Orderrecievereport" class="form-horizontal">
	<!-- 		<div class="row">
				<div class="form-group"> -->
				
		<div class="item">
	<div class="row form-group"> 
   <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-3 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					
						

						<%
							ItemEntryDao itemEntryDao = new ItemEntryDao();
							List iList = itemEntryDao.getAllItemEntriesForOrderBill(request);
						%>
		 
						<input list="fk_item_id_drop" id="fk_item_id" class="form-control" autofocus="autofocus" required>
						<datalist id="fk_item_id_drop">

							<%
								for (int i = 0; i < iList.size(); i++) {
									ItemEntry itemEntry = (ItemEntry) iList.get(i);
							%>

							<option data-value="<%=itemEntry.getPk_item_entry_Id()%>"
								value="<%=itemEntry.getItemName()%>">
								<%
									}
								%>
							
						</datalist>
						<label>Item Name:<sup>*</sup></label>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div class="ibutton">
	<div class="row" align="center">
						<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_left" onclick="getGoodsReceiveReport()" value="Search" />
					</div>
				</div>
		
		
	
		<div class="table-responsive">
		<div class="container">
					<table id="catName" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Sr No</th>
							<th>Item Name</th>
							<th>Supplier Name</th>
							<th>Bill No</th>
							<th>Buy Price</th>
							<th>Quantity</th>
							<!-- <th>GST</th> -->
							<th>Total</th>
							<th>Gross Total</th>
							<th>Date Of Goods Receive</th>

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
					
					
 	<div id="Supplier" class="tab-pane">
	<div>		
					
							
			<form action="#" method="post" name="Orderrecievereport1" class="form-horizontal">
		<!-- 	<div class="row">
				<div class="form-group"> -->
<!-- 					<div class="row" style="padding-top: 20"> -->
			
		<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						

						<%
						GoodsReceiveDao Dao = new GoodsReceiveDao();
						List iiList = Dao.getAllsupplierEntriesForOrderBill(request);
						%>
					
						<input list="fk_item_id_drop1" id="fk_item_id1" class="form-control" autofocus="autofocus" required>
						<datalist id="fk_item_id_drop1">

							<%
								for (int i = 0; i < iiList.size(); i++) {
									SupplierDetailsHibernate itemEntryy = (SupplierDetailsHibernate) iiList.get(i);
							%>

							<option data-value="<%=itemEntryy.getPkSupplierDetailId()%>"
								value="<%=itemEntryy.getSuplierName()%>">
								<%
									}
								%>
							
						</datalist>
						<label>Supplier:<sup>*</sup></label>
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
	<div class="row" align="center">
		<input type="button" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_left" onclick="getgoodsreceiveReport()" value="Search" />
	</div>
</div>

		<div class="container">		
					<div class="table-responsive">
					<table id="catName1" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Sr No</th>
							<th>Bill No</th>
							<th>Item Name</th>	
							<th>Buy Price</th>
							<th>Sale Price</th>
							<th>Quantity</th>
							<th>IGST</th>
							<th>CGST</th>
							<th>SGST</th> 
							<th>Total</th>
							<th>Gross Total</th>
	

						</tr>
					</thead>
					  <tfoot>
			<tr>
				<th colspan="9" style="text-align: right">Total:</th>
				<th></th>
				
				
				<th></th>
			</tr>
			</tfoot>
					</table>
			</div>
				<!-- </div>-->
			</div>
			</form> 
			</div>
	
</div>

	<div id="date" class="tab-pane">
	<div>	
		<form action="#" method="post" name="OrderBilltableDate" class="form-horizontal">
		<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" id='orderBillDate' name="orderBillDate" class="form-control" required/>
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
						<input type="date" id='orderBillDateto' name="orderBillDateto" class="form-control" required />
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
						onclick="getgoodReceiveDateWiseReport()" value="Search" />
				</div>
			</div>
		
	<!-- 	</div>
												
						</div>
				</div>
 -->			
		<div class="container">
 			<div class="table-responsive">
					<table id="catName3" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Sr No</th>
							<th>Item Name</th>	
							<th>Bill No</th>
							<th>Buy Price</th>
							<th>Sale Price</th>
							<th>Quantity</th>
							<th>Total</th>
							<th>Gross Total</th>
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
				</div>
					</form>
					</div>
					</div>
</div>

