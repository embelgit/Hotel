<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today's Sale</title>

<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui-min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
<script src="/RMS/staticContent/js/bootstrap.js"></script>


	<%@include file="common/header.jsp"%>



<!-- custom css -->
<!-- <link href="/RMS/staticContent/css/style.css" rel="stylesheet"> -->
<!-- custom JS -->
<!-- <script src="/RMS/staticContent/js/jquery.min.js"></script> -->


	
<script src="/RMS/staticContent/js/todaysale.js"></script>

<script type="text/javascript">

	 function editSupplier() {
			 window.location = "editSupplierDetails.jsp";
	}
	function supplierList(){
		 window.location = "listOfSuppliers.jsp";
	}
</script>
<%-- <%@include file="common/header.jsp"%> --%>
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<h2 align="center" class="form-heading"><b>Today's Sale</b></h2>
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
				<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
		</div>

<form class="form-horizontal" name="supplierFormName">
<div class="item">
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						 <input type="text" id='saleamount' name="saleamount" class="form-control" required />
						<label>Today's Total Sale Amount:</label>
					</div>
				</div>
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						 <input type="text" id='currentcash' name="currentcash" class="form-control" pattern="{0-9}{14-14}"  required/>
						<label>Current Cash (Take Home):</label>
			</div>
		</div>
	</div>
</div>

<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
				<input type="text" id='cardpayment' name="cardpayment" class="form-control" pattern="[a-z A-Z]" title="Name must be character" required />
				<label>Payment Received by Card:</label>
			</div>
		</div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
				 <input type="text" id='googlepaypayment'  name="googlepaypayment" class="form-control" required />
				<label>Payment Received by GooglePay:</label>
			</div>
			</div>
					
	</div>
</div>
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">  
				<input type="text" id='phonpepayment' name="phonpepayment" class="form-control" required />
					<label >Payment Received by Phonpe :</label>
					</div>
						</div>
					
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
						 <input type="text" id='paytmpayment' name="paytmpayment" class="form-control" required/>
						<label >Payment Received by Paytm :</label>
		</div>
		</div>
	</div>
					
	</div>
<div class="row form-group"> 
 <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
	<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
				<input type="text" id='otherpayment' name="otherpayment" class="form-control"  required />
				<label>Payment Received by Other Source:</label>
			</div>
	</div>
	<!-- <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
		<div class="invoice_label_up">
			 <input type="text" id='suplierState' name="suplierState" class="form-control" required />
			<label>Cash :</label>
		</div>
	</div> -->
</div>
</div>


</div>
<div class="ibutton">
	<div class="row" align="center">
			<input type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="btn" value="Save" onclick="addtodaysale()" id="save"/> 
			<input type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()" />	
				</div>
			</div>
		
		</form>
	
</body>
</html>

<%@include file="common/newFooter.jsp"%>