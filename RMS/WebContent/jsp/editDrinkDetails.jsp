<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<html>
<head>
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

<script src="/RMS/staticContent/js/itemDetails.js"></script>

</head>
<body>

	<div class="container-fluid">
		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Edit
					Drink Details</h2>
			</div>
		</div>

		<div class="row">
			<div class="form-group" align="right">
				<div class="col-sm-offset-6 col-md-5 control-label">
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
			<div class="col-sm-offset-1 col-md-10" align="right">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

		<form class="form-horizontal" name="drinkDetail">

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Select Drink Name</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-road"></i>
							</span>

							<%
						     ItemEntryDao itemEntryDao1 = new ItemEntryDao();
						     List iList1= itemEntryDao1.getAllItemEntries1(request);
						     %>

							<input list="fk_item_id_drop1" id="fk_item_id1"
								class="form-control" onchange="getDrinkDetails()">
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

					<div class="col-sm-2" align="right">
						<label class="control-label">Sale Price:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" class="form-control" id="sale_price"
								placeholder="Sale Price" required autofocus />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Buy Price:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" class="form-control" id="buy_price"
								placeholder="Buy Price" required autofocus
								onblur="checkForSaleBuyPrice()" />
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Unit in Ml:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" class="form-control" id="unit_in_ml"
								placeholder="Unit in ml" required autofocus />
						</div>
					</div>
				</div>
			</div>

			<div class="row buttons_margin_top">
				<div align="center">
					<input type="button"
						style="height: 65px; width: 180; font-size: 25"
						class="btn btn-lg btn-success btn-md button_hw button_margin_right"
						name="btn" value="Save" onclick="updateDrinkDetailsInfo()" /> <input
						type="reset" style="height: 65px; width: 180; font-size: 25"
						class="btn btn-lg btn-danger btn-md button_hw button_margin_right"
						value="Clear" />
				</div>
			</div>

		</form>
	</div>

</body>
</html>


<%@include file="common/newFooter.jsp"%>