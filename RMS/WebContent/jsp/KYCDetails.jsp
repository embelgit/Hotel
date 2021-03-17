<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<html>
<head>
<title>kyc Details</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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

<script type="text/javascript">
							function listForKycDetails(){
								 window.location = "listForKycDetails.jsp";
							}
						</script>

<script src="/RMS/staticContent/js/kycDetails.js"></script>
<%@include file="common/header.jsp"%>
</head>

<body>

	<div class="container-fluid">

		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">KYC
					Details</h2>
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

		<form class="form-horizontal">
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Item Name:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-road"></i>
							</span>

							<%
						         ItemEntryDao itemEntryDao = new ItemEntryDao();
						         List iList= itemEntryDao.getAllItemEntries();
						    %>
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

					<div class="col-sm-2" align="right">
						<label class="control-label">Table No.:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" id='tableNo' name="tableNo"
								class="form-control" placeholder="Enter Table No" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Quantity:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-road"></i>
							</span> <input type="text" id='quantity' name="quantity"
								class="form-control" placeholder="Enter quantity" />
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Price:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" id='price' name="price" class="form-control"
								placeholder="Enter price" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Date:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="date" id='KYCDate' name="KYCDate"
								class="form-control" placeholder="Select KYC Date" />
						</div>
					</div>
				</div>
			</div>

			<div align="center" class="margin-t-70">
				<input style="height: 65px; width: 180; font-size: 25" type="button"
					class="btn btn-lg btn-success btn-md button_hw button_margin_right"
					name="btn" value="Save" onclick="KycInfo()" /> <input
					style="height: 65px; width: 180; font-size: 25" type="reset"
					class="btn btn-lg btn-danger btn-md button_hw button_margin_right"
					value="Clear" onclick="reloadPage()" /> <input
					style="height: 65px; width: 180; font-size: 25" type="button"
					value="List" id="listBtn"
					class=" btn btn-lg btn-primary btn btn-primary"
					onclick="listForKycDetails()" />
			</div>

		</form>
	</div>
</body>
</html>

<%@include file="common/newFooter.jsp"%>
