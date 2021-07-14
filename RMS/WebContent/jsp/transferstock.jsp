<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.hotelnamebean" %>
<%@page import="com.rms.dao.hotelnamedao"%>
<%@page import="java.text.ParseException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% boolean isHome = false; %>   
<%@include file="common/header.jsp"%>
<head>

	<title>Transfer Stock</title>

	<script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
	<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">

	<script src="/RMS/staticContent/js/bootstrap.min.js"></script>

	<script src="/RMS/staticContent/js/bootstrap.js"></script>

	<script src="/RMS/staticContent/js/bootbox.js"></script>
	<script src="/RMS/staticContent/js/bootbox.min.js"></script>
	<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->

	<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
     
    <link rel="stylesheet" href="/RMS/staticContent/y_css/jquery-ui.css">
  	<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
    <!-- <script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script> -->
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
	
	
		
	<script src="/RMS/staticContent/js/transferstock.js"></script>

     <script type="text/javascript">
	      function transferStockList(){
		  window.location = "listoftransfer_stock.jsp";
	    							 }
	      function reloadPage(){
	    	  location.reload();
		     }
     </script>

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
    	
    	top: 20px;
    	
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
		background: none;
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
	.form-group input:valid ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.table-responsive .ui-jqgrid-jquery-ui, .ui-jqgrid-view, .ui-state-default, .ui-jqgrid-bdiv {
		width: 898px !important;
	}
	
	.table-responsive {
		display: flex;
   	 	align-content: center;
    	justify-content: center;
	}
	
	.ui-state-default th:first-child {
		width: 50px !important;
	}
	
	.ui-state-default th {
		width: 212px !important;
	}
	
	.ui-jqgrid-btable td:first-child {
		width: 50px !important;
	} 
	
	.ui-jqgrid-btable td {
		width: 212px !important;
	}
	
	.ibutton input[type="button"],[type="reset"]{
		width: 120px;
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
    	
    	.table-responsive .ui-jqgrid-jquery-ui, .ui-jqgrid-view, .ui-state-default, .ui-jqgrid-bdiv {
			width: 594px !important;
		}
		
		.ui-state-default th {
			width: 136px !important;
		}
	
		.ui-jqgrid-btable td {
			width: 136px !important;
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
				<!-- <h2 align="center" class="form-heading"><b>Transfer Stock</b></h2> -->
				<div class="heading">	
					<h2 align="center" class="form-heading"><b>Transfer Stock</b></h2>
				</div>
			</div>
		</div>
		<div class="form-background">
			<form action="" method="post" name="transferStock"  class="form-horizontal">
     			<div class="row form-group"> 
      				<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
							<%
								hotelnamedao sdd = new hotelnamedao();
								List sList = sdd.gethotelname(request);
							%>
								<input list="hotelName" id="hotelid" autofocus="hotelid" required>
								<datalist id="hotelName">
							<%
								for (int i = 0; i < sList.size(); i++) {
 	                        		hotelnamebean hotel = (hotelnamebean) sList.get(i);
                             %>
									<option data-value="<%=hotel.getHotelid()%>" value="<%=hotel.getHotelname()%>">
							 <%
								}
							 %>	
								</datalist>
								<span></span>
								<label>Shop Name <sup>*</sup></label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
							<%
								ItemEntryDao itemEntryDao1 = new ItemEntryDao();
								List iList1= itemEntryDao1.getAllItemEntries1(request);
							%>
								<input list="fk_item_id_drop1" id="fk_item_id1" autofocus="fk_item_id1" onchange="getGridForTransferStock()" required />
								<datalist id="fk_item_id_drop1" required>
							<%
					    		for(int j=0;j<iList1.size();j++){
									ItemEntry itemEntry = (ItemEntry)iList1.get(j);
				       		%>
									<option data-value="<%=itemEntry.getPk_item_entry_Id()%>" value="<%=itemEntry.getItemName() %> - <%=itemEntry.getValue()%> <%=itemEntry.getUnit()%>">
							<%
					     		}
				         	%>
								</datalist>
								<span></span>
								<label>Item Name<sup>*</sup></label>
							</div>
						</div>
					</div>
				</div>	
				<div class="row">
					<div class="">
						<div class="table-responsive">
							<table id="list4"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
				<!-- <input style="  height: 65px; width: 180; font-size: 25"  type="button" id="save" class="btn btn-large btn-success glyphicon glyphicon-save  button-height-width" name="btn" value="Save" onclick="addGoodsReceive1()" /> 
					<input style="height: 48px; width: 180; font-size: 25" type="reset" class="btn btn-large btn-danger glyphicon glyphicon-remove-circle  button-height-width" 	value="Clear" onclick="reloadPage()" />
				 <input style=" height: 65px; width: 180; font-size: 25" type="button" value="Edit" id="listBtn" class="btn btn-lg btn-primary btn btn-primary" onclick="editItemEntry()" />
				<input style="height: 48px; width: 180; font-size: 25" type="button" value="List" id="listBtn" class=" btn btn-lg btn-primary btn btn-primary" onclick="goodsReceiveList()" /> -->
				<div class="ibutton" style="margin-bottom:50px">
					<div class="row" align="center">			
						<i class="las la-save la-2x cust"></i>	
						<input  type="button" id="Save" name="btn" value="Save" class="btn btn-lg btn-success btn-md" onclick="addTrasferStock()" /> 
             			<i class="las la-eraser la-2x cust"></i>
             			<input class="btn btn-lg btn-danger btn-md" type="reset"  name="btn" value="Clear" onclick="reloadPage()" /> 
           				<i class="las la-clipboard-list la-2x cust"></i>
            			<input  type="button" value="List" id="listBtn" class="btn btn-lg btn-warning btn-md" onclick="transferStockList()" /> 
					</div>               
				</div>
			<!-- <div class="row buttons_margin_top">
				<div align="center">
					<input type="button" class="btn btn-lg btn-success btn-lg btn-md button_hw button_margin_right" name="btn" value="Save" onclick="addGoodsReceive()" style=" height: 65px; width: 180; font-size: 25"/>
					<input type="reset" class="btn btn-lg btn-danger btn-lg btn-md button_hw button_margin_right" onclick="reloadPage()" value="Clear" style=" height: 65px; width: 180; font-size: 25"/>
				</div>
			</div> -->
			</form>
		</div>
	</div>
</body>
</html>
<%@include file="common/newFooter.jsp"%>