
<% boolean isHome=false;%>
<%@include file="common/header.jsp"%>

<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>

<script src="/RMS/staticContent/shree/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script src="/RMS/staticContent/shree/dataTables.buttons.min.js"
	type="text/javascript"></script>
<script src="/RMS/staticContent/shree/buttons.flash.min.js"
	type="text/javascript"></script>
<script src="/RMS/staticContent/shree/jszip.min.js"
	type="text/javascript"></script>
<script src="/RMS/staticContent/shree/pdfmake.min.js"
	type="text/javascript"></script>
<script src="/RMS/staticContent/shree/vfs_fonts.js"
	type="text/javascript"></script>
<script src="/RMS/staticContent/shree/buttons.html5.min.js"
	type="text/javascript"></script>
<script src="/RMS/staticContent/shree/buttons.print.min.js"
	type="text/javascript"></script>
<link href="/RMS/staticContent/y_css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="/RMS/staticContent/y_css/buttons.dataTables.min.css"
	rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/bootstrap.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

<script src="/RMS/staticContent/js/stockEntryReport.js"></script>

<script>
	     $(document).ready(function(){
	    	 getStockEntryReport();
	}); 
	</script>

<body id="dt_example" class="master_form_img">
	<div class="container-fluid">

		<div class="row header_margin_top" style="margin-top: 60px;">
			<div align="center">
				<h2 class="form-name style_heading">Stock Entry Report</h2>
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

		<div class="row" align="center">
			<div class="table-responsive">
				<table class="table table-bordered table-striped table-condensed cf"
					id="catName" class="display"
					style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>

							<th>Sr No</th>
							<th>Item Name</th>
							<th>Supplier Name</th>
							<th>Bill No</th>
							<th>Buy Price</th>
							<th>Quantity</th>
							<th>GST</th>
							<th>Gross Total</th>
							<th>Date Of Goods Receive</th>

						</tr>
					</thead>

				</table>
			</div>
		</div>
		<!-- </div> -->

	</div>
</body>
</html>
