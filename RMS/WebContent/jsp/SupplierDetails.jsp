<%-- <%@include file="common/header.jsp"%> --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Supplier</title>

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


	
<script src="/RMS/staticContent/js/supplierDetails.js"></script>

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
			<div class="heading">	
			<h2 align="center" class="form-heading" ><b>Add Supplier</b></h2>
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

<form class="form-horizontal" name="supplierFormName">
<div class="item">
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						 <input type="text" id='suplierName' name="suplierName" class="form-control" required />
						<label>Supplier Name:<sup>*</sup></label>
					</div>
				</div>
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						 <input type="text" id='gstNo' name="gstNo" class="form-control" pattern="{0-9}{14-14}"  required/>
						<label>GST No:</label>
			</div>
		</div>
	</div>
</div>

<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
				<input type="text" id='contactPerson' name="contactPerson" class="form-control" pattern="[a-z A-Z]" title="Name must be character" required />
				<label>Contact Person:<sup>*</sup></label>
			</div>
		</div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
				 <input type="text" id='suplierContact' maxlength="10" name="suplierContact"  pattern="[0-9]{10,10}" class="form-control" required />
				<label>Supplier Contact No. :<sup>*</sup></label>
			</div>
			</div>
					
	</div>
</div>
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">  
				<input type="text" id='emailID' name="emailID" class="form-control" required />
					<label >Email :</label>
					</div>
						</div>
					
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
						 <input type="text" id='suplierCity' name="suplierCity" class="form-control" required/>
						<label >City :</label>
		</div>
		</div>
	</div>
					
	</div>
<div class="row form-group"> 
 <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
	<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
				<input type="text" id='address' name="address" class="form-control"  required />
				<label>Address :</label>
			</div>
	</div>
	<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
		<div class="invoice_label_up">
			 <input type="text" id='suplierState' name="suplierState" class="form-control" required />
			<label>State :</label>
		</div>
	</div>
</div>
</div>
</div>
<div class="ibutton">
	<div class="row" align="center">
			<input type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="btn" value="Save" onclick="SupplierInfo()" id="save"/> 
		
			<input type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()" />
		
			<input  type="button" value="Edit" id="listBtn" class="btn btn-lg btn-primary btn btn-primary" onclick="editSupplier()" /> 
		
	
			<input  type="button" value="List" id="listBtn" class=" btn btn-lg btn-primary btn btn-primary" onclick="supplierList()" />
				</div>
			</div>
		
		</form>
	
</body>
</html>

<%@include file="common/newFooter.jsp"%>