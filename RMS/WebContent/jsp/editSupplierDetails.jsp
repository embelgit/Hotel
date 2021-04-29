
<%@page import="com.rms.hibernate.SupplierDetailsHibernate"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.SupplierDetailsDao"%>
<html>
<head>
<title>Supplier List</title>
<%@include file="common/header.jsp"%>


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

<script src="/RMS/staticContent/js/supplierDetails.js"></script>

<script type="text/javascript">
  			function Back()
  			{
  				window.location = "SupplierDetails.jsp" ;
  			}
  		</script>

<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<!-- <div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<h2 align="center" class="form-heading"><b>Edit
					Supplier Details</b></h2>
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
			<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
		</div>
</div> -->
<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading" ><b>Edit
					Supplier Details</b></h2>
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
<form class="form-horizontal" name="editSupplier">
<div class="item">
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<%
							SupplierDetailsDao sdd = new SupplierDetailsDao();
							List sList = sdd.getAllSupplierName(request);
							%>

							<input list="suplierName" id="fk_supplier_id"
								class="form-control" onchange="getSupplierDetails()" required>
							<datalist id="suplierName">
								<%
							 for (int i = 0; i < sList.size(); i++) {
 	                         SupplierDetailsHibernate sup = (SupplierDetailsHibernate) sList.get(i);
                             %>
								<option data-value="<%=sup.getPkSupplierDetailId()%>"
									value="<%=sup.getSuplierName()%>">

									<%
									}
								%>
								
							</datalist>
						<label>Supplier Name <sup>*</sup></label>
					</div>
						</div>
					</div>
		 		</div>
				
				
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
			<input type="text" id='suppName' name="suppName" class="form-control" required/>
					<label >Edit Supplier Name <sup>*</sup></label>
			</div>
		</div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
			<input type="text" id='gstNo' name="gstNo" class="form-control" required/>
							<label>GST No :</label>
			</div>
			</div>
		</div>
</div>
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
			 <input type="text" id='contactPerson' name="contactPerson" class="form-control" required/>
				<label>Contact Person : <sup>*</sup></label>
			</div>
		</div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
				 <input type="text" id='suplierContact' maxlength="10" name="suplierContact" required class="form-control"/>
				<label>Supplier Contact No. :</label>
			</div>
			</div>
					
	</div>
</div>
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
				<input type="text" id='emailID' name="emailID" class="form-control" required/>
				<label>Email :</label>
			</div>
		</div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
				 <input type="text" id='suplierCity' name="suplierCity" class="form-control" required/>
				<label>City :</label>
			</div>
			</div>
					
	</div>
</div>
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
				<input type="text" id='address' name="address" class="form-control" required/>
				<label >Address :</label>
			</div>
			</div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
				 <input type="text" id='suplierState' name="suplierState" class="form-control" required/>
				<label >State :</label>
			</div>
			</div>
	</div>
</div>
</div>
<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">
	<input type="button"  class="btn btn-lg btn-success btn-md button_hw button_margin_right"
	name="btn" value="Update" onclick="updateSupplierInfo()" />

	<input type="reset"  class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" />
	
	<input type="button"  class="btn btn-lg btn-primary" value="Back" onclick="Back()"/>

</div>
</div>			
	</form>

</body>
</html>

<%@include file="common/newFooter.jsp"%>