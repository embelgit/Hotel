<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<html>
<head>
<title>Edit Item Entry</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="common/header.jsp"%>

<script type="text/javascript"
	src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
<script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/js/jquery-ui-min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/bootstrap.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

<script src="/RMS/staticContent/js/itemEntry.js"></script>
<script type="text/javascript">
  			function Back()
  			{
  				window.location = "itemEntry.jsp" ;
  			}
  		</script>
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<!-- <div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<h2 align="center" class="form-heading"><b>Edit Item Details</b></h2>
			</div>
			<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
			
			<div class="form-group" align="right">
				
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
			<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
		</div> -->
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading" ><b>Edit Item Details</b></h2>
			</div>
				<hr>
		</div>
		
	
		</div>
		<div class="row">
		<!-- <div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"> -->
		
			<div class="form-group" align="right" style="margin-right: 331px;">
					<div id="date">
						<label id="demo"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
			<!-- 	</div> -->
			</div>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		</div>

		<!-- <div class="row">
			<div class="col-sm-offset-1 col-md-10" align="right">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>
 -->
		<form class="form-horizontal" name="editItemEntry">

		<div class="item">
	<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
<!-- 						<label class="control-label">Select item Name<sup>*</sup></label> -->
						
						<%
						ItemEntryDao itemEntryDao = new ItemEntryDao();
						List iList= itemEntryDao.getAllItemEntriesForOrderBill(request);
						%>

							<input list="fk_item_id_drop" id="fk_item_id"
								class="form-control" onchange="getItemEntryDetails()" required>
							<datalist id="fk_item_id_drop">

								<%
					         for(int i=0;i<iList.size();i++){
						     ItemEntry itemEntry = (ItemEntry)iList.get(i);
				              %>

								<option data-value="<%=itemEntry.getPk_item_entry_Id()%>"
									value="<%=itemEntry.getItemName() %>" value1="<%=itemEntry.getType() %>"
									value2=<%=itemEntry.getSalePrice() %> value3=<%=itemEntry.getBuyPrice() %>>
									<%
					           }
				                %>
								
							</datalist>
							<label>Item Name : <sup>*</sup></label>
						</div>
					</div>
					
				<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<input type="text" class="form-control" id="item_name" required/>
							<label >Item Name : <sup>*</sup></label>
						</div>
					</div>
				</div>
			</div>
			
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<select class="form-control" id="type">
						<option value="selected">Select Type</option> 
							<option value="item">Item</option>
							<option value="drink">Drink</option>
						</select>
						<label>Type : <sup>*</sup> </label>
					</div>
					</div>
					<!-- </div> -->
					
					<!-- <div class="col-md-12"> -->
<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<input type="text" class="form-control" id="esale_price" required/>
							<label >Sale Price :<sup>*</sup> </label>
						</div>
						</div>
					</div>
</div>
	<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<input type="text" class="form-control" id="ebuy_price"	required/>
						<label >Buy Price :  </label>
					</div>
				</div>
				<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<select class="form-control" id="unit">
								<option>Select</option>
								<option value="ml">ml</option>
								<option value="litre">litre</option>
								<option value="gram">gram</option>
								<option value="kilogram">kilogram</option>
								<option value="plate">plate</option>
								<option value="piece">piece</option>
						</select>
						<label >Unit : </label>
						</div>
						</div>
		</div>
</div>
				
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<input type="text" class="form-control" id="value"	required/>
							<label >Unit Value : </label>
						</div>			
						</div>
				</div>
				
			</div>
</div>
	<div class="ibutton">
	<div class="row" align="center">	
<input type="button" 
				class="btn btn-lg btn-success btn-md button_hw button_margin_right"
				name="btn" value="Update" onclick="updateItemEntryInfo()" /> 

			
				<input type="reset" 
				class="btn btn-lg btn-danger btn-md button_hw button_margin_right"
				value="Clear" onclick="reset"/>
	
				<input type="button" class="btn btn-lg btn-primary btn-md button_hw button_margin_right"
				 value="Back" onclick="Back()"/>
		</div>
	</div>

	</form>


</body>
</html>

<%@include file="common/newFooter.jsp"%>
