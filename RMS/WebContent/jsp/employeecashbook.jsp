<% boolean isHome=false; %>
<%@include file="common/header.jsp"%>

<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.CashBook"%>
<%@page import="com.rms.helper.CashBookHelper"%>
<%@page import="com.rms.dao.CashBookDao"%>
<%@page import="com.rms.hibernate.AddWaiters"%>
<%@page import= "java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Payment</title>
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
				<%-- <div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
		<h2 align="center" class="form-heading"><b>Employee Payment</b></h2>
		</div>
		<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
		<div align="right">
			<h3 style="color: red;">
				Transaction ID ::
		 	<%
				out.println(TransactionID);
			%>  
			</h3>
		</div>
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
			</div>--%>
							
<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading" ><b>Employee Payment</b></h2>
			</div>
				<hr>
		</div>
		<div class="col-md-12 col-lg-3 col-xl-2 col-sm-12">
			<h3 style="color: red" align="right">
				Transaction ID ::
                  <%
				out.println(TransactionID);
			%> 
			</h3>
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
		<!-- <div class="row">
			<div class="col-sm-offset-1 col-md-10" align="right">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div> -->
	
	<!-- 	<h2 class="form-name" style="margin-top: 10px; " align="center">Cash Book</h2> -->
	

<!-- 	<form action="cashbook" method="post" name="cashbook" style="margin-left: 200px; margin-top: 50px "> -->

	<form class="form-horizontal" name="cashbook" action="#" method="post">
					
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						
					
							<%
						com.rms.dao.AddWaitersDao dao = new com.rms.dao.AddWaitersDao();			
						List waitlist =	dao.getAllWiterList(request);	
							%>
							<input list="waiterid_drop" id="waiterid" class="form-control" onchange="getEmpAmount()" required autofocus="autofocus">
					    <datalist id="waiterid_drop">
						<%
							for(int i=0;i<waitlist.size();i++){
								AddWaiters emp = (AddWaiters)waitlist.get(i);
						%>
							<option data-value="<%=emp.getWaiterId()%>" value="<%=emp.getFirstName()%> <%=emp.getMiddleName()%> <%=emp.getLastName()%>">
						<%
							}
						%>
						</datalist>
						<label>Name :</label>
							
					<!-- 	<select id="itemNames" onchange="getEmpAmount()" class="form-control" name="itemNames">
						</select> -->
						<!-- <input type="text" id="OtherPayment" style= "color: black;"/> -->					
					</div>
				</div>
				<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						 <input type="date" id='paymentDate' name="paymentDate" class="form-control" required value="<%=todayDate%>"/>
						<label>Date :</label>
					</div>
						</div>
					</div>
			</div>
				
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
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



<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			<div id="cheque_no">
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<input class="form-control" type="text" name="" id="chequeNoId"
							required />
						<label>Cheque No :</label>
						</div>
						</div>
						
						
						
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						
							<input class="form-control" type="date" name="" id="chequeDateId"
								required/>
									<label>Date :</label>
						</div>
						</div>
						</div>
					

					<div id="card_no">
					<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<input class="form-control" type="text" name="" id="cardNoId"
								required/>
							<label>Card No. :</label>
								</div>
						</div>

					</div>

					<div id="neft_acc_no">
					<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<input class="form-control" type="text" name="" id="neftAccNoId"
							required />
						<label>NEFT Acc No. :</label>
						</div>
					</div>
					</div>

				</div>
			</div>

			<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" name="amount" id="paymentAmountId" required readonly="readonly">
						<label>Total Amount :</label>
					</div>
				</div>
		
			  <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" name="amount" id="payingAmountId" required>
						<label>Paid Amount :</label>
					</div>
				</div>
			</div>
			</div>

		
				<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="remainingBalance" name="remainingBalance" required readonly="readonly">					
					<label>Remaining Balance :</label>
					</div>
					</div>
				
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


			
	<div class="ibutton">
	<div class="row" align="center">
			<input  type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="saveButton" value="Save" onclick="validateCashBooknw()" id="buttonCSS"/> 
		
		<input type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()"/>
					
	</div>
</div>


</body>
</html>

 <%@include file="common/newFooter.jsp"%>