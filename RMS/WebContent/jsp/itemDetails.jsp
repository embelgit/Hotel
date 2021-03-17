<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.helper.ItemEntryHelper"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Details</title>
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
			<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

<!-- Bootstrap css -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- custom css -->
<link href="/RMS/staticContent/css/style.css" rel="stylesheet">

<!-- All JS files -->

<!-- Bootstrap JS -->

<script src="/RMS/staticContent/js/bootstrap.min.js"></script>

<!-- custom JS -->
<script src="/RMS/staticContent/js/jquery.min.js"></script>
<script src="/RMS/staticContent/js/itemDetails.js"></script>

<%@include file="common/header.jsp"%>
</head>

<script type="text/javascript">
				function pageLoad(){
					$("#CreditCustDetail").hide(); 
				}
				function openItem() {
					$("#CreditCustDetail").hide();
					location.reload();
				}
				function openDrink() {
					$("#CreditCustDetail").show();
				}
				</script>

<script type="text/javascript">
			
				 function editItemDetails() {
						 window.location = "editItemDetails.jsp";
				}
				function itemDetailsList(){
					 window.location = "listForItemDetails.jsp";
				}
			   </script>

<script type="text/javascript">
			
				 function editDrinkDetails() {
						 window.location = "editDrinkDetails.jsp";
				}
				function drinkDetailsList(){
					 window.location = "listForDrinkDetails.jsp";
				}
			   </script>


<body onload="pageLoad()">

	<div class="row header_margin_top">
		<div align="center">
			<h2 class="form-name style_heading">Item Details</h2>
		</div>

	</div>

	<div class="row form-group">
		<div align="center"></div>
	</div>

	<div class="container col-sm-offset-1 ">

		<div class="row form-group">
			<div class="col-md-3 control-label">
				<label for="item" style="float: right">Item Type<sup>*</sup></label>
			</div>
			<div class="col-md-3">
				<div class="col-xs-6 ">
					<label class="radio-inline"> <input type="radio"
						name="item" id="item" checked="checked" onclick="openItem()">Item
					</label>
				</div>
				<div class="col-xs-6 col-md-ffset-1 ">
					<label class="radio-inline"> <input type="radio" name="item" id="item" onclick="openDrink()">Drink
					</label>
				</div>
			</div>

		</div>

		<!------------------Code for item ------------------>

		<div id="CashCustDetail">

			<form class="form-horizontal" method="post" action=""
				name="itemdetail">
				<fieldset>

					<div class="row margin-t-13">
						<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
							<label class="control-label">Item Name:</label>

							<%
						ItemEntryDao itemEntryDao = new ItemEntryDao();
						List iList= itemEntryDao.getAllItemEntries();
						%>
						</div>
						<div class="col-md-2 col-sm-3">
							<input list="fk_item_id_drop" id="fk_item_id"
								class="form-control">
							<datalist id="fk_item_id_drop">

								<%
					for(int i=0;i<iList.size();i++){
						ItemEntry itemEntry = (ItemEntry)iList.get(i);
				%>

								<option data-value="<%=itemEntry.getPk_item_entry_Id()%>"
									value="<%=itemEntry.getItemName() %>">
									<%
					}
				%>
								
							</datalist>
						</div>
					</div>

					<div class="row margin-t-13">
						<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
							<label class="control-label">Sale Price: </label>
						</div>
						<div class="col-md-2 col-sm-3">
							<input type="text" class="form-control" id="sale_price"
								placeholder="Sale Price" required autofocus />
						</div>
					</div>

					<div class="row margin-t-13">
						<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
							<label class="control-label">Buy Price: </label>
						</div>
						<div class="col-md-2 col-sm-3">
							<input type="text" class="form-control" id="buy_price"
								placeholder="Buy Price" required autofocus
								onblur="checkForSaleBuyPrice()" />
						</div>
					</div>


	<div align="center" class="margin-t-70">
		<input style="height: 65px; width: 180; font-size: 25" type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="btn" value="Save" onclick="itemDetail()" /> 
		<input style="height: 65px; width: 180; font-size: 25" type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()" /> 
		<input style="height: 65px; width: 180; font-size: 25" type="button" value="Edit" id="listBtn" class="btn btn-lg btn-primary btn btn-primary" onclick="editItemDetails()" /> 
		<input style="height: 65px; width: 180; font-size: 25" type="button" value="List" id="listBtn" class=" btn btn-lg btn-primary btn btn-primary" onclick="itemDetailsList()" />
	</div>

		<!-- <div align="center" class="margin-t-70">
			 <button type="button" onclick="itemDetail()" name="btn" class="btn btn-success" >Save</button>  
			<button type="reset" class="btn btn-danger" title="Submit filled Information">Reset</button>
		</div> -->
				</fieldset>
			</form>
		</div>

		<!--         For drink details   -->

		<div id="CreditCustDetail">
			<form class="form-horizontal" method="post" action=""
				name="drinkDetail">
				<fieldset>
					<div class="row margin-t-13">
						<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
							<label class="control-label">Item Name:</label>

							<%
						ItemEntryDao itemEntryDao1 = new ItemEntryDao();
						List iList1= itemEntryDao1.getAllItemEntries1(request);
						%>
						</div>
						<div class="col-md-2 col-sm-3">
							<input list="fk_item_id_drop1" id="fk_item_id1"
								class="form-control">
							<datalist id="fk_item_id_drop1">

								<%
					       for(int j=0;j<iList1.size();j++){
				   		    ItemEntry itemEntry = (ItemEntry)iList1.get(j);
				         %>

								<option data-value="<%=itemEntry.getPk_item_entry_Id()%>"
									value="<%=itemEntry.getItemName() %>">
									<%
				                     	}
			                      	%>
							</datalist>
						</div>
					</div>

					<div class="row margin-t-13">
						<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
							<label class="control-label">Sale Price: </label>
						</div>
						<div class="col-md-2 col-sm-3">
							<input type="text" class="form-control" id="sale_price1"
								placeholder="Sale Price" required autofocus />
						</div>
					</div>

					<div class="row margin-t-13">
						<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
							<label class="control-label">Buy Price: </label>
						</div>
						<div class="col-md-2 col-sm-3">
							<input type="text" class="form-control" id="buy_price_drink"
								placeholder="Buy Price" required autofocus
								onblur="checkForSaleBuyPrice()" />
						</div>
					</div>


					<div class="row margin-t-13">
						<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
							<label class="control-label">Unit in ml: </label>
						</div>
						<div class="col-md-2 col-sm-3">
							<input type="text" class="form-control" id="unit_in_ml"
								placeholder="Unit in ml" required autofocus />
						</div>
					</div>

	<div align="center" class="margin-t-70">
	 <input style="height: 65px; width: 180; font-size: 25" type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="btn_drink" value="Save" onclick="drinkDetail1()" />
	 <input style="height: 65px; width: 180; font-size: 25" type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()" />
	 <input style="height: 65px; width: 180; font-size: 25" type="button" value="Edit" id="listBtn" class="btn btn-lg btn-primary btn btn-primary" onclick="editDrinkDetails()" /> 
	 <input style="height: 65px; width: 180; font-size: 25" type="button" value="List" id="listBtn" class=" btn btn-lg btn-primary btn btn-primary" onclick="drinkDetailsList()" />
   </div>

		<!-- <div align="center" class="margin-t-70">
			 <button type="button" onclick="drinkDetail1()" name="btn_drink" class="btn btn-success" >Save</button>  
			 <button type="reset" class="btn btn-danger" title="Submit filled Information">Reset</button>
		</div> -->

				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>
<%@include file="common/newFooter.jsp"%>