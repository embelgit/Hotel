<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Stock</title>
<!-- All CSS files -->

<!-- Bootstrap css -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- custome css -->
<link href="/RMS/staticContent/css/style.css" rel="stylesheet">

<!-- All JS files -->

<!-- Bootstrap JS -->

<script src="/RMS/staticContent/js/bootstrap.min.js"></script>

<!-- custom JS -->
<script src="/RMS/staticContent/js/jquery.min.js"></script>
<script src="/RMS/staticContent/js/create-user.js"></script>

<%@include file="common/header.jsp"%>
</head>

<body>

	<div class="container">
		<h2 align="center" class="form-heading">Item Stock</h2>
		<form class="form-horizontal" action="#" method="post" name="">

			<div class="row margin-t-13">
				<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
					<label class="control-label">Item Name:</label>
				</div>
				<div class="col-md-2 col-sm-3">
					<select class="form-control" name="userType" id="">
						<option value="selected">--Select Item Name--</option>
						<option value="">abc</option>
						<option value=" ">xyz</option>
					</select>
				</div>
			</div>

			<div class="row margin-t-13">
				<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
					<label class="control-label">Quantity: </label>
				</div>
				<div class="col-md-2 col-sm-3">
					<input type="text" class="form-control" id=""
						placeholder="Quantity" onkeyup="firstNameValidation(this)"
						onblur="cheakEmpty(this)" required autofocus />
				</div>
			</div>

			<div align="center" class="margin-t-70">
				<button class="btn btn-success" name="createbtn"
					title="Submit filled Information" onclick="">Save</button>
				<button type="reset" class="btn btn-danger"
					title="Submit filled Information">Reset</button>
			</div>

		</form>
	</div>

</body>
</html>