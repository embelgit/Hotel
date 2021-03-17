<% boolean isHome=false; %>
<%@include file="common/header.jsp"%>

<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.CashBook"%>
<%@page import="com.rms.helper.CashBookHelper"%>
<%@page import="com.rms.dao.CashBookDao"%>
<%@page import= "java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Payment</title>
<script type="text/javascript"
	src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
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
<script type="text/javascript" src="/RMS/staticContent/js/cash_book.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/cashBook.js"></script>
<script>
	function defaultHideElement() {

		document.getElementById("neft_acc_no").style.display = "none";
		document.getElementById("cheque_no").style.display = "none";
		document.getElementById("card_no").style.display = "none";
	}

	$(document).ready(function() {
		$("#paymebtById").change(function() {
			$(this).find("option:selected").each(function() {
				if ($(this).attr("value") == "cheque") {

					$("#cheque_no").show();

					$("#neft_acc_no").hide();
					$("#card_no").hide();
				} else if ($(this).attr("value") == "card") {

					$("#card_no").show();

					$("#neft_acc_no").hide();
					$("#cheque_no").hide();
				} else if ($(this).attr("value") == "neft") {

					$("#neft_acc_no").show();

					$("#card_no").hide();
					$("#cheque_no").hide();
				} else if ($(this).attr("value") == "cash") {

					$("#neft_acc_no").hide();
					$("#cheque_no").hide();
					$("#card_no").hide();
				}

			});
		}).change();
	});
</script>
<script>
function defaultHideElement()
{
	document.getElementById("cheque_no").style.display = "none";
	document.getElementById("card_no").style.display = "none";
	document.getElementById("neft_acc_no").style.display = "none";
}

$(document).ready(function(){
		 $("#paymebtById").change(function(){
   	$(this).find("option:selected").each(function(){
       	if($(this).attr("value")==""){
       	
       	$("#cheque_no").hide(); 
       	
       	$("#neft_acc_no").hide(); 
       	$("#card_no").hide();
       	}
       	else if($(this).attr("value")=="cheque"){
           	
           	$("#cheque_no").show(); 
           	
           	$("#neft_acc_no").hide(); 
           	$("#card_no").hide();
           	}
      	 else if($(this).attr("value")=="card"){
       	
      		$("#card_no").show(); 	
      		
      		$("#neft_acc_no").hide(); 
    		$("#cheque_no").hide();
       }
      	 else if($(this).attr("value")=="neft"){
            	
       		$("#neft_acc_no").show(); 	
       		
       		$("#card_no").hide(); 
    		$("#cheque_no").hide();
        }
      	 else if($(this).attr("value")=="cash"){
         	
        		$("#neft_acc_no").hide(); 
        		$("#cheque_no").hide();
        		$("#card_no").hide(); 
         }
      
   });
}).change();
});	
</script>
<script>

function defaultHideElement()
{
	document.getElementById("KisanAdvanceAmount").style.display = "none";
}

$(document).ready(function(){
		 $("#paymenttonameid").change(function(){
   	$(this).find("option:selected").each(function(){
       	
      	  if($(this).attr("value")=="supplier"){
       	
      		$("#KisanAdvanceAmount").hide(); 
      		$("#BalanceAmount").hide();
    		$("#RemainingBalanceAmount").hide();
       	
       }
      	 else if($(this).attr("value")=="employee"){
            	
       		$("#KisanAdvanceAmount").hide();
       		$("#BalanceAmount").hide();
    		$("#RemainingBalanceAmount").hide();
       	
        }
    
      
   });
}).change();
});	
</script>
<script>
<% 
	Long TransactionID = 1l;
%>
<%
		CashBookDao data = new CashBookDao();
		List stkList  = data.gettransID(request);
		
		for(int i=0; i<stkList.size(); i++){
			
			CashBook st = (CashBook)stkList.get(i);
			TransactionID = st.getTransID();
			
			TransactionID++;
			
			}
			
 %>
 </script> 

<script>
<% 
String pattern = "yyyy-MM-dd";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String todayDate = simpleDateFormat.format(new Date());

System.out.println(todayDate);
%>
</script>

<!-- <script type="text/javascript">

function balanceAmt()
{
var TotalAmt = document.getElementById('paymentAmountId').value;

var PaidAmt = document.getElementById('payingAmountId').value;
	
var RemainingAmt = 	(TotalAmt - PaidAmt);

document.getElementById('remainingBalance').value = RemainingAmt;	
}

</script> -->
<!--  <script type="text/javascript">
function checkAmt(){
	var ReaminBal = document.getElementById('remainingBalance').value;

	var PaidAmtt = document.getElementById('payingAmountId').value;
	
	if(RemainBal < PaidAmtt){
		alert("Paid Amount entered should be less than the Balance Amount");
	//	location.reload();
		return false;
	}
}
</script>  -->
 

</head>
<body onload="defaultHideElement()">
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
		<h2  align="center" class="form-heading"><b>Supplier Payment</b></h2>
		</div>
			<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
			<h3 style="color: red" align="right">
				Transaction ID ::
		 		<%
				out.println(TransactionID);
			%> 
			</h3>
		</div>
		<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
		<div id="date" align="right">
						<label id="demo"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
	</div>
</div>


	<!-- <div class="container-fluid">
	
		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 10px">Cash Book</h2>
			</div>
		</div>
 -->
		
				
					
		
	<!-- 	<h2 class="form-name" style="margin-top: 10px; " align="center">Cash Book</h2> -->
	

<!-- 	<form action="cashbook" method="post" name="cashbook" style="margin-left: 200px; margin-top: 50px "> -->
	<form class="form-horizontal" name="cashbook"  action="#" method="post">
	<!-- 	<div class="col-lg-12">

			<div class="form-group-2">
				<div class="col-lg-12">
					<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6"> -->
				
					
					<!-- <div class="col-sm-2 col-sm-offset-1" align="right">
						<label>Payment To :</label>
					</div>
					<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6">
							<div class="col-sm-2">
						<div class="input-group">
							<span class="input-group-addon">
							 <i class="glyphicon glyphicon-road"></i>
							</span>
							<input type="text" class="form-control" name="paymenttonameid" id="paymenttonameid" placeholder="Supplier" readonly>	
						<select id="paymenttonameid" onchange="cheak()" class="form-control" autofocus="autofocus">
							<option id="0" value="" selected="selected">Select To Pay</option>
							<option id="0" value="supplier">Supplier</option>
							<option id="1" value="employee">Employee</option>
							 <option id="2" value="employee">Other</option> 
						</select>
					</div>
						</div>	 -->			

<!-- 			<div class="form-group-2">
				<div class="col-lg-12">
 	-->	
<!--  						<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6"> -->
<div class="item">
	<div class="row "> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						
					<!-- <div class="col-lg-2 col-md-1 col-sm-1 col-xs-6"> -->
				
							<%
							com.rms.dao.CashBookDao daoo = new CashBookDao();
							List slist = daoo.getAllsuppEntryforCB(request);
							%>
							
							<input list="suplierName" id="fk_supplier_id" autofocus="fk_supplier_id" onchange="getAmount()" class="form-control" required autofocus="autofocus">
							<datalist id="suplierName">
								<%
							 for (int i = 0; i < slist.size(); i++) {
								 CashBook sup = (CashBook) slist.get(i);
                             %>
								<option data-value="<%=sup.getFkSupplierId()%>"
									value="<%=sup.getToPayNameId()%>">

									<%
									}
								%>
								
							</datalist>
							<label>Name :</label>
					</div>
							
							
							
					<!-- 	<select id="itemNames" onchange="getAmount()" class="form-control" name="itemNames">
						</select> -->
						<!-- <input type="text" id="OtherPayment" style= "color: black;"/> -->					
					</div>
				
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						
				
					
					<!-- <div class="col-lg-2 col-md-1 col-sm-1 col-xs-6"> -->
					
						 <input type="date" id='paymentDate' name="paymentDate" class="form-control" required value="<%=todayDate%>"/>
						<label>Date :</label>
						</div>
					</div>
					
				
			</div>
		</div>
					<%-- <%
						employeeDetailHelper helper = new employeeDetailHelper();
						List empNameList = helper.getAllEmployeeNames();
						%>
					
					<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6">
						<input list="empId_drop" id="empId" class="form-control">
					    <datalist id="empId_drop">
						<%
							for(int i=0;i<empNameList.size();i++){
							EmployeeDetail emp = (EmployeeDetail)empNameList.get(i);
						%>
							<option data-value="<%=emp.getPkEmpId()%>" value="<%=emp.getEmpName()%>">
						<%
							}
						%>
						</datalist> --%>

					<!-- <div class="col-lg-2 col-md-1 col-sm-1 col-xs-6">
						<select class="form-control" id="itemNames" name="itemNames">
						</select>
					</div> -->

				
		<!-- 	</div> -->


			<!-- <div class="form-group-2">
				<div class="col-lg-12">
					<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6">
						<label>Date:</label>
					</div>
					<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6">
						<input class="form-control" type="date" name="" id="paymentDate" placeholder="Payment Date" />
					</div>
				</div>
			</div> -->
<br><br>

			<!-- <div class="form-group-2">
				<div class="col-lg-12"> -->
			
				
<!-- 				<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6"> -->
				
					
<!-- 					<div class="col-sm-3">
						<input class="form-control" type="date" name="paymentDate" id="paymentDate" placeholder="Payment Date" />
					</div> -->
<!-- 					<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6"> -->
<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
					
					<!-- <div class="col-lg-2 col-md-1 col-sm-1 col-xs-6"> -->
					
						<select class="form-control" name="selectType" id="paymentTypeId">
							<!-- <option value="">--Select Type--</option> -->
							<option value="credit">Credit</option>
							<option value="debit">Debit</option>
						</select>
						<label>Payment Type :</label>
					</div>
				</div>
		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
				
<!-- 					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 first"> -->
						
						<select class="form-control" id="paymebtById">
						<!-- 	<option value="">--Select Type--</option> -->
							<option value="cash">Cash</option>
							<option value="cheque">Cheque</option>
							<option value="card">Card</option>
							<option value="neft">NEFT</option>
						</select>
						<label>Mode of Payment :</label>
					</div>
					</div>
				
			</div>
	</div>

<!-- 			<div class="form-group-2">
				<div class="col-lg-12">
								
					<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6">
						<label>Payment Type:</label>
					</div>
					<div class="col-lg-2 col-md-1 col-sm-1 col-xs-6">
						<select class="form-control" name="selectType" id="paymentTypeId">
							<option value="">--Select Type--</option>
							<option value="credit">Credit</option>
							<option value="debit">Debit</option>
						</select>
					</div>
				</div>
			</div>
 -->


		<!-- 	<div class="col-lg-12" id="drop_cust_name">
				<div class="form-group-2"> -->
			
				
				<!-- 	<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6"> -->
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
				<div id="cheque_no">
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						
				
						<input class="form-control" type="text" name="" id="chequeNoId" required />
							<label>Cheque No :</label>
						</div>
						</div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
							<input class="form-control" type="date" name="" id="chequeDateId" required/>
							<label>Date :</label>
						</div>
				</div>
		</div>

			<div id="card_no">
				<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
					<div class="invoice_label_up">
							<input class="form-control" type="text" name="" id="cardNoId" required/>
								<label>Card No. :</label>
						</div>
					</div>
			</div>
				<div id="neft_acc_no">
					<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
					<div class="invoice_label_up">
						<input class="form-control" type="text" name="" id="neftAccNoId" required />
							<label>NEFT Acc No. :</label>
						</div>
					</div>
				</div>

				</div>
			</div>

			<!-- <div class="form-group-2">
				<div class="col-lg-12"> -->
		<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" name="amount" id="paymentAmountId" required readonly="readonly">
						<label>Total Amount :</label>
					</div>
				</div>
					<!-- <div class="form-group-2">
				<div class="col-lg-12"> -->
			  <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" name="amount" id="payingAmountId" required>
						<label>Paid Amount :</label>
					</div>
				</div>
			</div>
		</div>
<!-- 					<div class="form-group-2">
				<div class="col-lg-12"> -->
				 	<!-- <div id="RemainingBalanceAmount">  -->

	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="remainingBalance" name="remainingBalance" required readonly="readonly">					
						<label>Remaining Balance :</label>
					</div>
			</div>


<!-- 			<div class="form-group-2">
				<div class="col-lg-12">
 -->				
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" name="reason"
							id="paymentReasonId" required>
						<label>Reason :</label>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

			<!-- <div class="wrapper" style="margin-left: 500px">
				<input type="button" id="buttonCSS" value="Save" name="saveButton"
					class="btn btn-success" onclick="validateCashBook()" /> <input
					type="reset" id="buttonCSS" value="Reset" name="reset"
					class="btn btn-danger" /><br>
			</div> -->
	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">
		<input type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="saveButton" value="Save" onclick="validateCashBook()" id="buttonCSS"/>

	<input  type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()"/>
					
	</div>
	</div>

	<!-- 	</div> -->

	
</body>
</html>

 <%@include file="common/newFooter.jsp"%>