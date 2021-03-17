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
<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

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
 
<style type="text/css">

</style>

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

</head>
<body>
<form class="form-horizontal" action="#" method="post" name  = "order">
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
		<h2 align="center" class="form-heading"><b>Order Bill Copy</b></h2>
		</div>
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
	</div>
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6 col-md-offset-2  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
			<div class="invoice_label_up">
						
					<%
					CustomerOrderDao CustomerOrder = new CustomerOrderDao();
						List iList= CustomerOrder.getAllItemEntriesForOrderBill1();
						
						%>
					
						<input list="tableNo_drop" id="table_No" class="form-control" onchange="OrderGetBillNo()" required autofocus="autofocus">
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
				   <label >Table No :<sup>*</sup></label>
					</div>
					</div>
				 	<!-- <div class="col-md-2">
						<input type="text" class="form-control" id="table_No" placeholder="Select Table No"  />
					</div> 	 -->
					
					
				<div class="col-md-6 col-md-offset-1  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
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
						 
					<select class="form-control selectpicker" id="Bill_No" name="Bill_No">
					</select>
					<label>Bill No :<sup>*</sup></label>
				</div>
		</div> 	
	</div>					
</div>
</div>
			
<div class="row form-group " align="center" style="margin-bottom:50px"> 
<div class="col-lg-12 col-md-offset-5 col-md-12 col-sm-12 col-xs-12">
<div class="helt">
<div class="col-md-2  col-sm-12 col-xs-12 col-xl-2 col-lg-2">	
						<input type="button" class="btn btn-success btn-lg"  onclick="BillCopy(); return false;" style="width:150px;" value="Print Bill Copy"/>
						
					</div>
				</div>
			</div>
		</div>	
	
	
	
</form>
</body>
</html>
 <%@include file="common/newFooter.jsp"%> 
