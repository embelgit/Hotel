<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Expenditure details</title>

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
<script type="text/javascript" src="/RMS/staticContent/js/expenditure.js"></script>
<%@include file="common/header.jsp"%>

<script type="text/javascript">
	 function listt() {
			 window.location = "expenditurelist.jsp";
	}

	 
 </script>
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		<!-- <div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<h2 align="center" class="form-heading"><b>Expenditure Details</b></h2>
			</div>
		<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
		
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
		</div> -->
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading" ><b>Expenditure Details</b></h2>
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
		
		<form class="form-horizontal" action ="#" method ="post" name ="expenditurename">
<div class="item">
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-3 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						 <input type="text" id="expenditurename"  class="form-control" required />
						<label>Expenditure Name:<sup>*</sup></label>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="ibutton">
	<div class="row" align="center">
			<input type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="btn" value="Save" onclick="addexpenditure()" id="save"/> 
			<input  type="button" value="List" id="listBtn" class=" btn btn-lg btn-primary btn btn-primary" onclick="listt()" />
			<input type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()" />	
				</div>
			</div>
</form>
</body>
</html>