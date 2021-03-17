<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.SupplierDetail"%>
<%@page import="com.rms.dao.SupplierDetailDao"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% boolean isHome=false;%>
<%@include file="common/header.jsp"%>

<div class="container">
	<h2 class="form-name">Cash Bank Book Supplier</h2>
</div>

<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<script src="/RMS/staticContent/js/cashbankbook.js"></script>
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

<!-- custom css -->
<link href="/RMS/staticContent/css/style.css" rel="stylesheet">
<!-- custom JS -->
<script src="/RMS/staticContent/js/jquery.min.js"></script>
<div id="date">
	<label id="demo"></label>
	<script>
		   var date = new Date();
		   document.getElementById("demo").innerHTML = date.toDateString();;
		</script>
</div>

<form action="cashBankBook" name="cashboook" method="post"
	class="form-horizontal">
	<div class="col-lg-12">

		<%
			SupplierDetailDao dao = new SupplierDetailDao();
	     	List supList = dao.getAllSupplier();
		       %>

		<div class="form-group-2">
			<div class="col-lg-12">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label>Supplier:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 ">
					<input list="sup_drop" id="supplier" onchange="bill.getAllBills();"
						class="form-control">
					<datalist id="sup_drop">

						<%
				               			for(int i=0;i<supList.size();i++){
										SupplierDetail supD=(SupplierDetail)supList.get(i);
									%>

						<option data-value="<%=supD.getSupplierId()%>"
							value="<%=supD.getSupplierName() %>">
							<%
					               }
				                %>
						
					</datalist>
				</div>

				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label>Supplier:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 ">
					<input list="sup1_drop" id="supplier12"
						onchange="billforde.getAllBillsforDe();" class="form-control">
					<datalist id="sup1_drop">

						<%
				               			for(int i=0;i<supList.size();i++){
										SupplierDetail supD=(SupplierDetail)supList.get(i);
									%>

						<option data-value="<%=supD.getSupplierId()%>"
							value="<%=supD.getSupplierName() %>">
							<%
					}
				%>
						
					</datalist>
				</div>

				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label> Bill No:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 ">
					<select class="form-control" id='billNo12' name="billNo"
						onchange="billforde.getTotalAmtByBillsforde()">
						<option value="">Select Bill</option>
					</select>
				</div>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="form-group-2">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label> Bill No:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 ">
					<select class="form-control" id='billNo' name="billNo"
						onchange="bill.getTotalAmtByBills()">
						<option value="">Select Bill</option>
					</select>
				</div>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="form-group-2">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label>credit:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<input type="text" id="credit" name="credit" class="form-control"
						placeholder="credit" oninput="forOptionselect1()">
				</div>

			</div>
		</div>
		<div class="col-lg-12">
			<div class="form-group-2">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label>debit:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<input type="text" id="debit" name="debit" class="form-control"
						placeholder="debit" oninput="forOptionselects()">
				</div>
			</div>
		</div>

		<div class="col-lg-12">
			<div class="form-group-2">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label>Total Amount:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<input readonly="readonly" id="totalAmount" name="totalAmount"
						class="form-control" placeholder="Total Amount">
				</div>
			</div>
		</div>

		<div class="col-lg-12">
			<div class="form-group-2">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label>Reason:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<input type="text" id="reason" name="reason" class="form-control"
						placeholder="Reason">
				</div>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="form-group-2">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label>Payment Type:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<select class="form-control" name="paymentType" id="paymentType"
						onchange="forOptionselect()">
						<option value="selected">Select Payment</option>
						<option value="online">online</option>
						<option value="cash">cash</option>
						<option value="check">cheque</option>
					</select>
				</div>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="form-group-2">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label>Registration No :</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<input type="text" id="registrationNo" class="form-control"
						placeholder="Registraion No">
				</div>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="form-group-2">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<label>Person Name:</label>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
					<input type="text" id="personName" name="personName"
						class="form-control" placeholder="Person Name">
				</div>
			</div>
		</div>
	</div>
	</div>
	<div
		style='position: absolute; top: 200px; left: 480px; height: 300px; width: 630px;'>
		<table id="jqGrid">
		</table>

	</div>
	<div class="wrapper" style="">
		<input type="button" class="btn btn-md btn-lg btn-success" name="btn"
			value="Save" onclick="cash()" /> <input type="button"
			class="btn btn-md btn-lg btn-danger" onclick="reset()" value="Cancel" />

	</div>
</form>


<%@include file="common/shortcut.jsp"%>

<%@include file="common/footer.jsp"%>