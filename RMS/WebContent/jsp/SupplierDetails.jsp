<%-- <%@include file="common/header.jsp"%> --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Supplier</title>

<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->

<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

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
	.form-group input:valid ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.ibutton input[type="button"],[type="reset"]{
		width: 120px;
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
<%-- <%@include file="common/header.jsp"%> --%>
</head>
<body>
	<div id="start"> 
		<div class="row">
			<div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
				<div class="heading">
					<h2 align="center" class="form-heading" ><b>Add Supplier</b></h2>
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
			<form class="form-horizontal" name="supplierFormName">
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
						 		<input type="text" id='suplierName' name="suplierName"  required />
						 		<span></span>
								<label>Supplier Name <sup>*</sup></label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
						 		<input type="text" id='gstNo' name="gstNo" pattern="{0-9}{14-14}"  required/>
						 		<span></span>
								<label>GST No.</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up"> 
								<input type="text" id='contactPerson' name="contactPerson" pattern="[a-z A-Z]" title="Name must be character" required />
								<span></span>
								<label>Contact Person <sup>*</sup></label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up"> 
				 				<input type="text" id='suplierContact' maxlength="10" name="suplierContact"  pattern="[0-9]{10,10}" required />
								<span></span>
								<label>Supplier Contact No. <sup>*</sup></label>
							</div>
						</div>
					</div>
				</div>
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">  
								<input type="text" id='emailID' name="emailID" required />
								<span></span>
								<label >Email</label>
							</div>
						</div>	
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up"> 
						 		<input type="text" id='suplierCity' name="suplierCity" required/>
								<span></span>
								<label >City</label>
							</div>
						</div>
					</div>				
				</div>
				<div class="row form-group"> 
 					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up"> 
								<input type="text" id='address' name="address" required />
								<span></span>
								<label>Address</label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id='suplierState' name="suplierState" required />
								<span></span>
								<label>State</label>
							</div>
						</div>
					</div>
				</div>
				<div class="ibutton"  style="margin-bottom:50px">
					<div class="row" align="center">
						<i class="las la-save la-2x cust"></i>	
						<input type="button" class="btn btn-lg btn-success btn-md" name="btn" value="Save" onclick="SupplierInfo()" id="save"/> 
						<i class="las la-eraser la-2x cust"></i>
						<input type="reset" class="btn btn-lg btn-danger btn-md" value="Clear" onclick="reloadPage()" />
						<i class="las la-edit la-2x cust"></i>
						<input  type="button" value="Edit" id="listBtn" class="btn btn-lg btn-primary btn-md" onclick="editSupplier()" /> 
						<i class="las la-clipboard-list la-2x cust"></i>
						<input  type="button" value="List" id="listBtn" class="btn btn-lg btn-warning btn-md" onclick="supplierList()" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<%@include file="common/newFooter.jsp"%>