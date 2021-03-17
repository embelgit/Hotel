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
<title>Expenditure payment</title>

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
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<h2 align="center" class="form-heading"><b>Expenditure Payment</b></h2>
			</div>
		<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
				
			<h3 style="color: red" >
				Transaction ID ::
		 		<%
				out.println(TransactionID);
			%> 
			</h3>
	</div>
			<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
					<div id="date">
						<label id="demo" align="right"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
				
			</div>	
	</div>
<form class="form-horizontal" name="expenditurename"  action="#" method="post">
<div class="item">
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
			
							<%
							com.rms.dao.CashBookDao daoo = new CashBookDao();
							List slist = daoo.getAllexpenditurefromCB(request);
							%>
							
							<input list="expenditurename_drop" id="expenditurename" class="form-control" required autofocus="autofocus">
							<datalist id="expenditurename_drop">
								<%
							 for (int i = 0; i < slist.size(); i++) {
								 expenditureHibernate sup = (expenditureHibernate) slist.get(i);
                             %>
								<option data-value="<%=sup.getPk_expid()%>"
									value="<%=sup.getExpenditurename()%>">

									<%
									}
								%>
								
							</datalist>
			
			
					<!-- 	 <input type="text" id='expenditurename' name="expenditurename" class="form-control" required /> -->
						<label>Expenditure Name:<sup>*</sup></label>
					</div>
				</div>
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
				 <input type="date" id='paymentdate' name="paymentdate" class="form-control" required value="<%=todayDate%>"/>
						<label>Date :</label>
			</div>
		</div>
	</div>
</div>



<div class="row form-group"> 
 <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
	<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
				<input type="text" id='expenditureamount' name="expenditureamount" class="form-control"  required />
				<label>Expenditure Amount:<sup>*</sup></label>
			</div>
	</div>
	
	<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
				

						<select class="form-control" id="paymentById">
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
						
				
						<input class="form-control" type="text" name="chequeNoId" id="chequeNoId" required />
							<label>Cheque No :</label>
						</div>
						</div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
							<input class="form-control" type="date" name="chequeDateId" id="chequeDateId" required/>
							<label>Date :</label>
						</div>
				</div>
		</div>

			<div id="card_no">
				<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
					<div class="invoice_label_up">
							<input class="form-control" type="text" name="cardNoId" id="cardNoId" required/>
								<label>Card No. :</label>
						</div>
					</div>
			</div>
				<div id="neft_acc_no">
					<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
					<div class="invoice_label_up">
						<input class="form-control" type="text" name="neftAccNoId" id="neftAccNoId" required />
							<label>NEFT Acc No. :</label>
						</div>
					</div>
				</div>

				</div>
			</div>
		
</div>

<div class="ibutton">
	<div class="row" align="center">
			<input type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="btn" value="Save" onclick="addexp_payment()" id="save"/> 
			<input type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()" />	
				</div>
			</div>
		
		</form>


</body>
</html>