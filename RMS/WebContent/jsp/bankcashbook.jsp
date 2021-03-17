<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% boolean isHome=false; %>
<%@include file="common/header.jsp"%>

<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.banktransaction"%>
<%@page import="com.rms.hibernate.bankdetailHibernate" %>
<%@page import="com.rms.helper.CashBookHelper"%>
<%@page import="com.rms.dao.CashBookDao"%>
<%@page import= "java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank cashbook</title>
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
<script src="/RMS/staticContent/js/jquery.min.js"></script>
<script src="/RMS/staticContent/js/bankcashbook.js"></script>

<script>
	function defaultHideElement() {

		document.getElementById("neft_acc_no").style.display = "none";
		document.getElementById("cheque_no").style.display = "none";
		document.getElementById("card_no").style.display = "none";
	}

/* 	$(document).ready(function() {
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
	}); */
</script>
<script>
function defaultHideElement()
{
	document.getElementById("cheque_no").style.display = "none";
	document.getElementById("card_no").style.display = "none";
	document.getElementById("neft_acc_no").style.display = "none";
}

/* $(document).ready(function(){
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
});	 */
</script>
<script>
<% 
	Long TransactionID = 1l;
%>
<%
		CashBookDao data = new CashBookDao();
		List stkList  = data.gettransIDforbank(request);
		
		for(int i=0; i<stkList.size(); i++){
			
			banktransaction st = (banktransaction)stkList.get(i);
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
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
		<h2  align="center" class="form-heading"><b>Bank Transaction Payment</b></h2>
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
	<form class="form-horizontal" name="cashbook">
	<div class="item">
	<div class="row "> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						
				
<%-- 							<%
							com.rms.dao.CashBookDao daoo = new CashBookDao();
							List slist = daoo.getAllsuppEntryforCB(request);
							%> --%>

<!-- 							<input list="" id="" autofocus="" onchange="" class="form-control" required autofocus="autofocus"> -->
							<%-- <datalist id="">
								<%
							 for (int i = 0; i < slist.size(); i++) {
								 CashBook sup = (CashBook) slist.get(i);
                             %>
								<option data-value="<%=sup.getFkSupplierId()%>"
									value="<%=sup.getToPayNameId()%>">

									<%
									}
								%>
								
							</datalist> --%>
							<%
							com.rms.dao.CashBookDao daoo = new CashBookDao();
							List slist = daoo.getAllbankfromCB(request);
							%>
							
							<input list="bankname_drop" id="bankname" class="form-control" required autofocus="autofocus">
							<datalist id="bankname_drop">
								<%
							 for (int i = 0; i < slist.size(); i++) {
								 bankdetailHibernate sup = (bankdetailHibernate) slist.get(i);
                             %>
								<option data-value="<%=sup.getPkbankdetailid()%>"
									value="<%=sup.getBankname()%>">

									<%
									}
								%>
								
							</datalist>
							
						<!-- 	 <input type="text" id='bankname' name="bankname" class="form-control" required autofocus="autofocus"/> -->	
							<label>Bank Name : <sup>*</sup></label>
					</div>
							
							
							
									
					</div>
				
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						
				
					
				
					
						 <input type="date" id='datee' name="datee" class="form-control" required value="<%=todayDate%>"/>
						<label>Date :<sup>*</sup></label>
						</div>
					</div>
					
				
			</div>
		</div>
					
	
<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
				<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up"> 
				 <input type="text" id='contactno' maxlength="10" name="contactno" class="form-control" required />
				<label>Contact Number :</label>
			</div>
			</div>
						
		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
			
	

						<select class="form-control" name="selectType" id="paymentType">
							<!-- <option value="">--Select Type--</option> -->
							<option value="credit">Credit</option>
							<option value="debit">Debit</option>
						</select>
						<label>Payment Type :</label>
					</div>
					</div>
				
			</div>
	</div>



	<!-- <!-- <div class="row form-group"> 
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
			</div> --> 


			
		<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" name="accountname" id="accountname" required >
						<label>Account Holder's Name:</label>
					</div>
				</div>
					<!-- <div class="form-group-2">
				<div class="col-lg-12"> -->
			  <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" name="amount" id="amount" required>
						<label>Amount :</label>
					</div>
				</div>
			</div>
		</div>


	</div>
</form>

	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">
		<input type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="saveButton" value="Save" onclick="banktransaction()"/>

	<input  type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()"/>
					
	</div>
	</div>
	
</body>
</html>