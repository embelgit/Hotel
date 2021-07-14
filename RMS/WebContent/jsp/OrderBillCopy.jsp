<%@page import="com.rms.hibernate.CustomerOrder"%>
<%@page import="com.rms.dao.CustomerOrderDao"%>
<%@page import="com.rms.dao.AddWaitersDao"%>
<%@page import="com.rms.hibernate.AddWaiters"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.helper.TempItemDetailHelper"%>
<%@page import="com.rms.hibernate.TempItemDetail"%>
<%@page import="java.util.List"%> 

<% boolean isHome=false;%>
<%@include file="common/header.jsp"%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Bill</title>

<script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/bootstrap.js"></script>
<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->

	<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
     
    <link rel="stylesheet" href="/RMS/staticContent/y_css/jquery-ui.css">
  	<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>

<script src="/RMS/staticContent/js/orderBill.js"></script>

                       <script type="text/javascript">
							function listForGoodsReceive(){
								 window.location = "listForGoods_Receive.jsp";
							}
						</script>	


<%-- <script>
	
	$(document).ready(function(){
		
		<%
		   TempItemDetailHelper catHelper = new TempItemDetailHelper();
   		  List catList = catHelper.getAllMainTableNo();
	    %>
	  
	       var myList = document.getElementsByName("p");
	  
	    <%
		    for(int i=0;i<catList.size();i++){
			TempItemDetail category = (TempItemDetail)catList.get(i);
	    %>

	        var value ="<%=category.getTableNo()%>";
	        var abc = value-1;
		
	        myList[abc].style.backgroundColor = "green";
	
	   <%
		  }
	   %>
		
	});
	 
	</script> --%>

<!-- <script type="text/javascript">

function Activechange(){
	
	var table = document.getElementById("table_No").value;
	var xyz = table - 1;
	var myList = document.getElementsByName("p");
	for(i=0;i<myList.length;i++){
	     if(i == xyz){
	          myList[xyz].style.color = "red";
         } 
	     else{
	    	 myList[i].style.color = "white";
	     }
	}
}

function Activechange1(data){
		
	var abc = data.value;
	var tableNo = +abc;
	var xyz = tableNo - 1;
	var myList = document.getElementsByName("p");
	for(i=0;i<myList.length;i++){
	     if(i == xyz){
	          myList[xyz].style.color = "red";
         } 
	     else{
	    	 myList[i].style.color = "white";
	    	 
	     }
	}
}

 function tableValidation(){
	var tabNum = document.getElementById("table_No").value;
		if(tabNum == 0){
			 alert("select Table First!!!!!!");
			 return false;
			
         } 
} 
 

</script>
 -->

<style type="text/css">

	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap');

	* {
		font-family: 'Poppins', sans-serif;
	}

	body {
		background: #131D28 /* #131d28d1 */ /* #1d2831c4 */;
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
	.form-group input[type="date"]:invalid ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.ibutton input[type="button"],[type="reset"]{
		width: 200px;
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
	
	select option {
		color: #000;
		padding: 5px;
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
		
		.form-group label {
    		left: 1px;
    	}
    	
    	.row1 .btn {
    		height: 90px;    		
    		width: 90px;
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
					<h2 align="center" class="form-heading" ><b>Order Bill Copy</b></h2>
				</div>
			</div>
		</div>
		<br>
		<div class="form-background">
			<form class="form-horizontal" action="#" method="post" name="order">
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">			
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
							<%
								CustomerOrderDao CustomerOrder = new CustomerOrderDao();
								List iList= CustomerOrder.getAllItemEntriesForOrderBill1();
							%>
								<input list="tableNo_drop" id="table_No" onchange="OrderGetBillNo()" required autofocus="autofocus">
					 			<datalist id="tableNo_drop">
							<%
								for(int i=0;i<iList.size();i++){
									CustomerOrder Cust = (CustomerOrder)iList.get(i);
							%>
									<option data-value="<%=Cust.getPk_custOrder_id()%>" value="<%=Cust.getTableNo() %>" >
				        	<%
					       		}
				       	 	%>
				   				</datalist> 
				   				<span></span>
				   				<label >Table No <sup>*</sup></label>
							</div>
						</div>
						<!-- <div class="col-md-2">
						<input type="text" class="form-control" id="table_No" placeholder="Select Table No"  />
					</div> 	 -->
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="">
							<%-- 	<%
					CustomerOrderDao Dao1 = new CustomerOrderDao();
						List iList1= Dao1.getAllItemEntriesForOrderBill2();
						
						%>
					
					<div class="col-md-2">
						<input list="fk_item_id_drop" id="Bill_No"  class="form-control" ">
					 <datalist id="fk_item_id_drop">
				
						<%
						for(int i=0;i<iList1.size();i++){
							CustomerOrder bean = (CustomerOrder)iList1.get(i);
						%>
				
					<option data-value="<%=bean.getPk_custOrder_id()%>" value="<%=bean.getBillNo() %>">
				        <%
					       }
				        %>
				   </datalist> --%>
							<!-- <input type="text" class="form-control" id="Bill_No" placeholder="Select Bill No " /> -->
						 		<select class="selectpicker" id="Bill_No" name="Bill_No">
								</select>
								<span></span>
								<label>Bill No <sup>*</sup></label>
							</div>
						</div> 	
					</div>					
				</div>
				<div class="ibutton"  style="margin-bottom:50px">
					<div class="row" align="center">
						<i class="las la-print la-2x cust"></i>
						<input type="button" class="btn btn-lg btn-primary btn-md"  onclick="BillCopy(); return false;" value="Print Bill Copy"/>
					</div>
				</div>
			</form>
		</div>	
	</div>
</body>
</html>
 <%@include file="common/newFooter.jsp"%> 
