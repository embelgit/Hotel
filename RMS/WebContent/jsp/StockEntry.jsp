<%@include file="common/header.jsp"%>

<html>
<head>

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

<script src="/RMS/staticContent/js/stockEntry.js"></script>
</head>
<body>

	<div class="container-fluid">

		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Good
					REceive</h2>
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
						<label class="control-label">Item Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id='itemName' name="itemName"
								class="form-control" placeholder="Enter Item name">
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Buy Price:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" id='buyPrice' name="buyPrice"
								class="form-control" placeholder="Enter buyPrice" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Quantity:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id='quantity' name="quantity"
								class="form-control" placeholder="Enter quantity">
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">GST:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" id='gst' name="gst" class="form-control"
								placeholder="Enter gst" onchange="calculationsForStock()" />
						</div>
					</div>
				</div>
			</div>

			<div class="row form-group"></div>
			<div class="row" style="margin-top: 15px;">
				<label class="col-md-2 col-md-offset-6 control-label"
					for="grossTotal"><h4>
						<b>Gross Total</b>
					</h4></label>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon"> Rs </span> <input
							readonly="readonly" id='grossTotal' name="grossTotal"
							class="form-control input-md" type="text"
							style="font-size: 25px; height: 55px;">
					</div>
				</div>
			</div>

			<div class="row buttons_margin_top">
				<div align="center">
					<input type="button"
						class="btn btn-lg btn-success btn-md button_hw button_margin_right"
						name="btn" value="Save" onclick="addStockEntry()"
						style="height: 65px; width: 180; font-size: 25" /> <input
						type="reset"
						class="btn btn-lg btn-danger btn-md button_hw button_margin_right"
						onclick="" value="Clear"
						style="height: 65px; width: 180; font-size: 25" />

				</div>
			</div>
		</form>
	</div>
	<!-- </body> -->