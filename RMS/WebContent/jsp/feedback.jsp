<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Feedback</title>



<script type="text/javascript"
	src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
<script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui-min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/bootstrap.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

<!-- custom css -->
<link href="/RMS/staticContent/css/style.css" rel="stylesheet">
<!-- custom JS -->
<script src="/RMS/staticContent/js/jquery.min.js"></script>

<script src="/RMS/staticContent/js/feedback.js"></script>
<script type="text/javascript">
function backonBill()
{
	window.location = "OrderBill.jsp" ;

	}
</script>

</head>
<body>

	<div class="container">
		<h2 align="center" class="form-heading">FeedBack</h2>
		<form class="form-horizontal" action="#" method="post">

			<div class="row margin-t-13">
				<div class="col-md-offset-2 col-md-1 col-sm-offset-1 col-sm-1">
					<label class="control-label">Name </label>
				</div>
				<div class="col-md-6 col-sm-8">
					<input type="text" class="form-control" id="name"
						placeholder="Enter your Full Name" onkeyup="" required />
				</div>
			</div>

			<div class="row margin-t-13">
				<div class="col-md-offset-2 col-md-1 col-sm-offset-1 col-sm-1">
					<label class="control-label">Contact</label>
				</div>
				<div class="col-md-2 col-sm-3">
					<input type="number" class="form-control" id="contact"
						placeholder="Mobile Number" onkeyup="" required />
				</div>
			</div>

			<div class="row margin-t-13">
				<div class="col-md-offset-2 col-md-1 col-sm-offset-1 col-sm-1">
					<label class="control-label">Rate Us</label>
				</div>
				<div class="col-md-8 col-sm-9">
					<label class="radio-inline"> <input type="radio"
						class="font-bold-16" name="Rate" value="Very Good" id="r1"><span
						class="font-bold-16">Very Good</span>
					</label> <label class="radio-inline"><input type="radio"
						name="Rate" value="Good" id="r2"><span
						class="font-bold-16">Good</span> </label> <label class="radio-inline">
						<input type="radio" name="Rate" value="Not Bad" id="r3"><span
						class="font-bold-16">Not Bad</span>
					</label> <label class="radio-inline"> <input type="radio"
						name="Rate" value="Not Bad" id="r4"><span
						class="font-bold-16">Bad</span>
					</label>
				</div>
			</div>

			<div class="row margin-t-13">
				<div class="col-md-offset-2 col-md-1 col-sm-offset-1 col-sm-1">
					<label class="control-label"></label>
				</div>
				<div class="col-md-6 col-sm-8">
					<textarea id="tfeedback" style="resize: none; margin-bottom: 10px;"
						rows="3" class="form-control"
						placeholder="Give your feedback What do you think about our service ?"></textarea>
				</div>
			</div>

			<div align="center" class="margin-t-70">
				<button onclick="validation()"
					style="height: 65px; width: 180; font-size: 25" type="button"
					class="btn btn-lg btn-success btn-md button_hw button_margin_right"
					title="Submit filled Information">Submit</button>
				<button style="height: 65px; width: 180; font-size: 25" type="reset"
					class="btn btn-lg btn-danger btn-md button_hw button_margin_right"
					title="Submit filled Information">Reset</button>
					<button style="height: 65px; width: 180; font-size: 25;" class="btn btn-primary" onclick="backonBill()">BACK</button>
			</div>

		</form>
	</div>
</body>
</html>