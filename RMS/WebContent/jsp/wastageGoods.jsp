<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>

<%@include file="common/header.jsp"%>

<html>
<head>
<title>Wastage Good & Foods</title>
<!-- All CSS files -->

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
		<script src="/RMS/staticContent/js/jquery.min.js"></script>
		
		<!-- custom JS -->
		<script src="/RMS/staticContent/js/wastageGoods.js"></script>
		<script src="/RMS/staticContent/js/wastageFood.js"></script>

</head>
<body>

	<div class="container">
		<h2 align="center" class="form-heading">Wastage Good & Foods</h2>

		<div class="row margin-t-13">
			<div class="">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home">Vegetables</a></li>
					<li><a data-toggle="tab" href="#menu1">Food</a></li>
				</ul>
			</div>
		</div>

		<div class="tab-content">

			<div id="home" class="tab-pane fade in active">

				<form class="form-horizontal" action="#" method="post">

					<div class="row margin-t-13">
						<div class="col-sm-2">
							<label class="control-label">Vegetables Name:</label>
						</div>
						<div class="col-sm-4 col-md-3">
							<input type="text" class="form-control" id="vegetableName" placeholder="Vegetables Name" required autofocus />
						</div>
					</div>

					<div class="row margin-t-13">
						<div class="col-sm-2">
							<label class="control-label">Amount:</label>
						</div>
						<div class="col-sm-4 col-md-3">
							<input type="text" class="form-control" id="amount" placeholder="Amount" required />
						</div>
					</div>

					<div class="margin-t-50">
						<div class="col-sm-offset-2">
							<button class="btn btn-success" name="createbtn" title="Submit filled Information" style="height: 65px; width: 180; font-size: 25" onclick="wastageGoods()">Submit</button>
							<input type="reset" class="btn btn-lg btn-danger btn-lg btn-md button_hw button_margin_right" onclick="reloadPage()" value="Clear" style="height: 65px; width: 180; font-size: 25" />
						</div>
					</div>
				</form>
			</div>

			<div id="menu1" class="tab-pane fade">

				<form class="form-horizontal" name="foodWastageForm" action="#"
					method="post">

					<div class="row margin-t-13">
						<div class="col-sm-2">
							<label class="control-label">Item Name:</label>

							<%
						ItemEntryDao itemEntryDao = new ItemEntryDao();
						List iList= itemEntryDao.getAllItemEntries();
				      %>
						</div>

						<div class="col-md-2 col-sm-3">
							<input list="fk_item_id_drop" id="fk_item_id" class="form-control">
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
						<div class="col-sm-2">
							<label class="control-label">Amount:</label>
						</div>
						<div class="col-sm-4 col-md-3">
							<input type="text" class="form-control" id="foodAmount" placeholder="Amount" required />
						</div>
					</div>

					<div class="margin-t-50">
						<div class="col-sm-offset-2">
							<button type="submit" class="btn btn-success" name="foodBtn" title="Update Menu Item" style="height: 65px; width: 180; font-size: 25" onclick="wastageFoods()">Submit</button>
							<input type="reset" class="btn btn-lg btn-danger btn-lg btn-md button_hw button_margin_right" onclick="reloadPage()" value="Clear" style="height: 65px; width: 180; font-size: 25" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

<%@include file="common/newFooter.jsp"%>
