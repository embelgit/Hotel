<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<html>
<head>
<title>Edit Item Entry</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="common/header.jsp"%>

<script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
<script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui-min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/bootstrap.js"></script>
<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->

<script src="/RMS/staticContent/js/itemEntry.js"></script>
<script type="text/javascript">
  			function Back()
  			{
  				window.location = "itemEntry.jsp" ;
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
	.form-group select:focus ~ label,
	.form-group select:valid ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.ibutton input[type="button"],[type="reset"]{
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
					<h2 align="center" class="form-heading" ><b>Edit Item Details</b></h2>
				</div>
			</div>
		</div>
		<div class="form-background">
			<div class="row">	
				<div class="display-date">
					<div id="date">
						<label id="demo"></label>
						<script>
							var date = new Date();
							document.getElementById("demo").innerHTML = date.toDateString();
						</script>
					</div>
				</div>
			</div>
			<form class="form-horizontal" name="editItemEntry">
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
							<%
								ItemEntryDao itemEntryDao = new ItemEntryDao();
								List iList= itemEntryDao.getAllItemEntriesForOrderBill(request);
							%>
								<input list="fk_item_id_drop" id="fk_item_id" onchange="getItemEntryDetails()" required>
								<datalist id="fk_item_id_drop">
							<%
					         	for(int i=0;i<iList.size();i++){
						     		ItemEntry itemEntry = (ItemEntry)iList.get(i);
				            %>
									<option data-value="<%=itemEntry.getPk_item_entry_Id()%>" value="<%=itemEntry.getItemName() %>" value1="<%=itemEntry.getType() %>" value2=<%=itemEntry.getSalePrice() %> value3=<%=itemEntry.getBuyPrice() %>>
							<%
					           }
				            %>								
								</datalist>
								<span></span>
								<label>Item Name <sup>*</sup></label>
							</div>
						</div>
					</div>
				</div>			
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">			
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="item_name" required/>
								<span></span>
								<label >Edit Item Name <sup>*</sup></label>
							</div>
						</div>		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="">
								<select id="type">
									<option class="op-bg" value="selected">Select Type</option> 
									<option class="op-bg" value="item">Item</option>
									<option class="op-bg" value="drink">Drink</option>
								</select>
								<span></span>
								<label>Type <sup>*</sup> </label>
							</div>
						</div>	
					</div>
				</div>
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="esale_price" required/>
								<span></span>
								<label >Sale Price <sup>*</sup> </label>
							</div>
						</div>			
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="ebuy_price"	required/>
								<span></span>
								<label >Buy Price</label>
							</div>
						</div>
					</div>
				</div>				
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="">
								<select id="unit">
									<option class="op-bg">Select</option>
									<option class="op-bg" value="ml">ml</option>
									<option class="op-bg" value="litre">litre</option>
									<option class="op-bg" value="gram">gram</option>
									<option class="op-bg" value="kilogram">kilogram</option>
									<option class="op-bg" value="plate">plate</option>
									<option class="op-bg" value="piece">piece</option>
								</select>
								<span></span>
								<label >Unit</label>
							</div>
						</div>				
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="value" required/>
								<span></span>
								<label >Unit Value</label>
							</div>			
						</div>
					</div>				
				</div>
				<div class="ibutton" style="margin-bottom:50px">
					<div class="row" align="center">	
						<i class="las la-edit la-2x cust"></i>
						<input type="button" class="btn btn-lg btn-success btn-md" name="btn" value="Update" onclick="updateItemEntryInfo()" /> 
						<i class="las la-eraser la-2x cust"></i>
						<input type="reset" class="btn btn-lg btn-danger btn-md" value="Clear" onclick="reset"/>
						<i class="las la-angle-left la-2x cust"></i>
						<input type="button" class="btn btn-lg btn-primary btn-md" value="Back" onclick="Back()"/>
					</div>
				</div>
			</form>
		</div>
	</div>	
</body>
</html>

<%@include file="common/newFooter.jsp"%>
