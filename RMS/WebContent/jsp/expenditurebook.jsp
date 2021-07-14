<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% boolean isHome=false; %>
<%@include file="common/header.jsp"%>

<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.expenditurepaymentHibernate"%>
<%@page import="com.rms.helper.CashBookHelper"%>
<%@page import="com.rms.dao.CashBookDao"%>
<%@page import= "java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.rms.hibernate.expenditureHibernate" %>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expenditure Payment</title>

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
<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->

<!-- custom css -->
<!-- <link href="/RMS/staticContent/css/style.css" rel="stylesheet"> -->
<!-- custom JS -->
<script src="/RMS/staticContent/js/jquery.min.js"></script>

<!-- <script type="text/javascript" src="/RMS/staticContent/js/cashBook.js"></script> -->
<script type="text/javascript" src="/RMS/staticContent/js/expenditure.js"></script>
<script>
<% 
	Long TransactionID = 1l;
%>
<%
		CashBookDao data = new CashBookDao();
		List stkList  = data.gettransIDexp(request);
		
		for(int i=0; i<stkList.size(); i++){
			
			expenditurepaymentHibernate st = (expenditurepaymentHibernate)stkList.get(i);
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
<script>
	function defaultHideElement() {

		document.getElementById("neft_acc_no").style.display = "none";
		document.getElementById("cheque_no").style.display = "none";
		document.getElementById("card_no").style.display = "none";
	}

	$(document).ready(function() {
		$("#paymentById").change(function() {
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
		 $("#paymentById").change(function(){
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
	
	.display-transaction {
	 	float: right; 
	 	margin-right: 30px; 
	 	margin-top: 10px;  
	 	color: /* #f00 */#ead24c;
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
		background: none !important;
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
	
	.form-group select{
		width: 100%;
		padding: 0px 5px;
		height: 40px;
		font-size: 16px;
		border: none;
		outline: none;
		background: none !important;
		color: #fff;
		font-weight: 900;
	}
	
	.op-bg {
		background-color: #131d28;
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
	.form-group input:valid ~ label,
	.form-group input:read-only ~ label,
	.form-group select:focus ~ label,
	.form-group select:valid ~ label,
	.form-group input[type="date"] ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.table-responsive .ui-jqgrid-bdiv {
		height: 175px !important;
	}
	
	.ibutton input[type="button"],[type="reset"] {
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
	
	::-webkit-calendar-picker-indicator {
    	filter: invert(1);
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

</head>
<body>
	<div id="start">
		<div class="row">
			<div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
				<div class="heading">	
					<h2 align="center" class="form-heading" ><b>Employee Payment</b></h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div  class="display-transaction">
				<h3>
					Transaction ID ::
                	<%
						out.println(TransactionID);
					%> 
				</h3>
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
			<form class="form-horizontal" name="expenditurename"  action="#" method="post">
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
							<%
								com.rms.dao.CashBookDao daoo = new CashBookDao();
								List slist = daoo.getAllexpenditurefromCB(request);
							%>
								<input list="expenditurename_drop" id="expenditurename" required autofocus="autofocus">
								<datalist id="expenditurename_drop">
							<%
							 	for (int i = 0; i < slist.size(); i++) {
									expenditureHibernate sup = (expenditureHibernate) slist.get(i);
                            %>
									<option data-value="<%=sup.getPk_expid()%>" value="<%=sup.getExpenditurename()%>">
							<%
								}
							%>
								</datalist>
								<span></span>
								<label>Expenditure Name <sup>*</sup></label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
				 				<input type="date" id='paymentdate' name="paymentdate" required value="<%=todayDate%>"/>
								<span></span>
								<label>Date</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row form-group"> 
 					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up"> 
								<input type="text" id='expenditureamount' name="expenditureamount" required />
								<span></span>
								<label>Expenditure Amount <sup>*</sup></label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="">
								<select id="paymentById">
									<option class="op-bg" value="" hidden>--Select Type--</option>	
									<option class="op-bg" value="cash">Cash</option>
									<option class="op-bg" value="cheque">Cheque</option>
									<option class="op-bg" value="card">Card</option>
									<option class="op-bg" value="neft">NEFT</option>
								</select>
								<span></span>
								<label>Mode of Payment</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div id="cheque_no">
							<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
								<div class="invoice_label_up">
									<input type="text" name="chequeNoId" id="chequeNoId" required />
									<span></span>
									<label>Cheque No.</label>
								</div>
							</div>
							<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
								<div class="">
									<input type="date" name="chequeDateId" id="chequeDateId" required/>
									<span></span>
									<label>Date</label>
								</div>
							</div>
						</div>
						<div id="card_no">
							<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
								<div class="invoice_label_up">
									<input type="text" name="cardNoId" id="cardNoId" required/>
									<span></span>
									<label>Card No.</label>
								</div>
							</div>
						</div>
						<div id="neft_acc_no">
							<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
								<div class="invoice_label_up">
									<input type="text" name="neftAccNoId" id="neftAccNoId" required />
									<span></span>
									<label>NEFT Acc No.</label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="ibutton" style="padding-bottom:50px;">
				<div class="row" align="center">
					<i class="las la-save la-2x cust"></i>	
					<input type="button" class="btn btn-lg btn-success btn-md" name="btn" value="Save" onclick="addexp_payment()" id="save"/> 
					<i class="las la-eraser la-2x cust"></i>
					<input type="reset" class="btn btn-lg btn-danger btn-md" value="Clear" onclick="reloadPage()" />	
				</div>
			</div>		
		</div>
	</div>
</body>
</html>