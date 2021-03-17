<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Goods</title>

<!-- All CSS files -->

<!-- Bootstrap css -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">



<!-- custome css -->
<link href="/RMS/staticContent/css/style.css" rel="stylesheet">

<!-- All JS files -->

<!-- Bootstrap JS -->
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/jquery.min.js"></script>


<!-- custome JS -->
<script src="/RMS/staticContent/js/purchase_good.js"></script>

<%@include file="common/header.jsp"%>

</head>
<body onload="hideContents()">

	<div class="container">
		<h2 align="center" class="form-heading">Purchase Good</h2>
		<form class="form-horizontal" action="#" method="post">

			<div class="row">
				<div class="col-sm-offset-2 col-sm-2">
					<label class="control-label margin-b-13">Vegetables : </label>
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="input-group margin-b-13">
						<span class="input-group-addon">Rs</span> 
						<input type="text" class="form-control" id="vegetables" placeholder="Enter Vegetables here" onblur="cheakExpenceAmt(this)" onkeyup="calculateTotal()" autofocus />
					</div>
				</div>
			</div>
			<!--row-div-->


			<div class="row">
				<div class="col-sm-offset-2 col-sm-2">
					<label class="control-label margin-b-13">Grocery : </label>
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="input-group margin-b-13">
						<span class="input-group-addon">Rs</span> 
						<input type="text" class="form-control" id="grocery" onblur="cheakExpenceAmt(this)" onkeyup="calculateTotal()" placeholder="Enter Grocery here" />
					</div>
				</div>
			</div>
			<!--row-div-->

			<div class="row">
				<div class="col-sm-offset-2 col-sm-2">
					<label class="control-label margin-b-13">Other : </label>
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="input-group margin-b-13">
						<span class="input-group-addon">Rs</span> 
						<input type="text" class="form-control" id="other" onblur="cheakExpenceAmt(this)" onkeyup="calculateTotal()" placeholder="Enter Other here" />
					</div>
				</div>
			</div>
			<!--row-div-->


			<!-- <div class="row">						
					<div class="margin-b-13" align="center">
								<button type="button" class="btn btn-success" id="showPurchaseItem"  title="Add new item">Add Item manually</button>	
							</div>										
				</div>row-div
				
				
				<div class="row" id="extraPurchasedItem">													
						<div class="col-sm-offset-2 col-sm-2">						
							<label class="control-label margin-b-13">Item Name : </label>	
						</div>
						<div class="col-sm-2 col-md-2">
							<div class="margin-b-13">	
								<input type="text" class="form-control" placeholder="Item Name" id="itemName"  />	
							</div>											
						</div>
						<div class="col-sm-2 col-md-2">
							<div class="input-group margin-b-13">
								<span class="input-group-addon">Rs</span>	
								<input type="number" class="form-control" id="price" onblur="cheakExpenceAmt(this)" onkeyup="calculateTotal()" placeholder="Price" />	
							</div>											
						</div>					
				</div>row-div -->



			<div class="row">

				<div class="col-sm-offset-6 col-sm-2 col-md-2">
					<div class="margin-b-13 margin-t-20" style="margin-top: 20px;">
						<input type="text" class="form-control" id="total" placeholder="Total" readonly="readonly" />
					</div>
				</div>
			</div>
			<!--row-div-->


			<div align="center" style="margin-top: 50px;">
				<button style="height: 65px; width: 180; font-size: 25" type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="createbtn" title="Submit filled Information" onclick="addGood()">Add</button>
				<!-- <button type="submit" class="btn btn-primary" title="Submit filled Information">Add</button> -->
				<button style="height: 65px; width: 180; font-size: 25" type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" title="Submit filled Information">Reset</button>
			</div>


		</form>

	</div>
	<!--container closed--->

</body>
</html>