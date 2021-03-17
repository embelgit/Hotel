
<%@page import="com.rms.dao.AddWaitersDao"%>
<%@page import="com.rms.hibernate.AddWaiters"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.helper.TempItemDetailHelper"%>
<%@page import="com.rms.hibernate.TempItemDetail"%>
<%@page import="java.util.List"%> 
<%@page import="com.rms.bean.CustomerBean" %>
<%@page import="com.rms.dao.CustomerOrderDao" %>
<%@page import="com.rms.bean.orderBillbean" %>
<%@page import="com.rms.hibernate.CustomerOrder" %>
<%@include file="common/header.jsp"%>
 
<% boolean isHome=false;%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Bill</title>

 <script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">

<script src="/RMS/staticContent/js/bootbox.js"></script>
<script src="/RMS/staticContent/js/bootbox.min.js"></script>
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
    
<%--     <link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
    <link rel="stylesheet" href="/RMS/staticContent/y_css/jquery-ui.css">
 	<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">

<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>    
   <script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
    	<%@include file="common/header.jsp"%>
<script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
<script src="/RMS/staticContent/js/bootstrap.js"></script> --%>
    

	<script type="text/javascript" src="/RMS/staticContent/js/orderBill.js"></script>

                      <!--  <script type="text/javascript">
							function listForOrderBill(){
								 window.location = "ListOrderBill.jsp";
							}
						</script> -->	

 
<script>
	
$(document).ready(function(){
 	
	<%
	   TempItemDetailHelper catHelper = new TempItemDetailHelper();
		  List catList = catHelper.getAllMainTableNo(request,response);
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

	
	</script>

<script type="text/javascript">

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
<style type="text/css">
.bt{
padding-left:30%;
}
</style>

</head>


<!-- 
CustomerOrderDao dao1 = new CustomerOrderDao();

	List bill = dao1.getOrderBillNo();

	for (int i = 0; i < bill.size(); i++) {
		orderBillbean sa = (orderBillbean) bill.get(i);
		orderBill = sa.getBillNo();

		orderBill++;
	}
 -->
 <% 
	Long orderBill = 1l;
%>
 <%
		CustomerOrderDao data = new CustomerOrderDao();
		List stkList  = data.getLastBillNo(request);
		
		for(int i=0;i<stkList.size();i++){
			CustomerOrder st = (CustomerOrder)stkList.get(i);
			orderBill = st.getBillNo();
			
			orderBill++;
			
			}
 %>  


<body>

<div class="row">

<div class="col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8">
<h2 align="center" class="form-heading"><b>Order Bill</b></h2>
</div>
<div class="col-2 col-sm-2 col-md-2 col-lg-2 col-xl-2">

			
		</div>
<div class="col-2 col-sm-2 col-md-2 col-lg-2 col-xl-2">
<h3 style="color: red">
				Bill No ::
		 		<%
				out.println(orderBill);
			%> 
			</h3>
</div>
</div>

<form class="form-horizontal" action="" method="post" name  = "order">
		<!-- <h2 align="center" class="form-heading">Order Bill</h2> -->
<div class="row form-group"> 
		<div class="col-lg-6  col-md-12 col-sm-12 col-xs-12 col-xl-6">	
		<div class="item">	
			<div class="col-md-6  col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<%
						ItemEntryDao itemEntryDao = new ItemEntryDao();
						List iList= itemEntryDao.getAllItemsEntriesForOrderBill(request);
						
						%>
					
						 <input list="fk_item_id_drop" id="fk_item_id" autofocus="fk_item_id" required class="form-control" onchange="tableValidation(); return shree(); return false"/>
					<!--  <input list="fk_item_id_drop" id="fk_item_id" autofocus="fk_item_id"  class="form-control" onchange="getItemDetailById(); "> -->
					 <datalist id="fk_item_id_drop">
				
						<%
						for(int i=0;i<iList.size();i++){
						ItemEntry itemEntry = (ItemEntry)iList.get(i);
					//	GoodsReceiveBean goodrecieve = (GoodsReceiveBean)iList.get(i);
						%>
				
					<option data-value="<%=itemEntry.getPk_item_entry_Id()%>" value="<%=itemEntry.getItemName() %> - <%=itemEntry.getValue()%> <%=itemEntry.getUnit()%>">
				        <%
					       }
				        %>
				   </datalist>
					<label>Item : </label>
					
					</div>
				</div>
					
		 <div class="col-md-6  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="table_No"   required onchange="getItemDetailByTable1(); Activechange();" />
							<label>Table : <sup>*</sup></label>
					</div>	
				</div>
			 <div class="col-md-6  col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<%
						AddWaitersDao wList = new AddWaitersDao();
						List waiterList= wList.getAllWaitersList(request);
						
						%>
					
						<input type="text" class="form-control" list="waiterList" id="waiterName" name="waiterName" required  />
						
						 <datalist id="waiterList">
				
						<%
						for(int i=0;i<waiterList.size();i++){
						AddWaiters waiter = (AddWaiters)waiterList.get(i);
						%>
				
					<option data-value="<%=waiter.getPkAddWaiterId()%>" value="<%=waiter.getFirstName()%> <%=waiter.getLastName()%>">
				        <%
					       }
				        %>
				   </datalist>
						<label>Waiter : <sup>*</sup></label>
					</div>	
				</div>
		
	

		
<div class="conatiner">
	<div class="row">
			<!-- Order bill data table -->

			 <div class="col-md-12 col-12 col-lg-12 col-xl-12 col-sm-12 col-xs-12">
			
				<div class="table-responsive">
					<table id="list" ></table>
					<div id="jqGridPager"></div>
										
				</div> 
			</div>
		</div>
	</div>
				
<!-- </div> -->		
			
		 
					<!-- <div class="col-md-2">
							<label class="control-label" style="font-size: 22px;" >GST % : </label>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="gst" style="font-size:16px; height:35px;" placeholder="GST %" style="font-size: 20px;" onchange="gstCal()"/>					
					</div>
					<div class="col-md-2">
						<label class="control-label" style="font-size: 22px;" >GST Amount</label>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="gstAmt" style="font-size:16px; height:35px;" placeholder="GST Amount" style="font-size: 20px;" readonly="readonly"/>					
					</div> -->
					<div class="row form-group"></div>
	<div class="row form-group"> 
		<div class="col-lg-7  col-md-12 col-sm-12 col-12 col-xs-12 col-xl-7">		
			
			<div class="col-md-6  col-sm-12 col-xs-12 col-xl-5 col-lg-5">
			<div class="">
						<input type="number" class="form-control" id="totalAmount"  readonly="readonly"/>
						<label>Grand Total </label>
						</div>
					</div> 
				</div>
			</div>

	</div>
		<div class="bt" >
	
		<input type="button" class="btn btn-primary btn-lg" id="order" onclick="orderbilling(); return false;" value="Order" style="margin-right: 3px;"/>

		<input type="button" class="btn btn-lg btn btn-success"  onclick="resBill(); return false;" id="print" value="Print Bill" style="margin-right: 3px;"/>
	
<!-- 						<button class="btn btn-primary btn-lg"   onclick="listForOrderBill()" id="order" style="width:150px; margin-left:25px;">Order</button> -->
						
<input type="button" class="btn btn-danger btn-lg"  onclick="reloadPage() return false" value="Clear" style="margin-right: 3px;"/>

	<input type="button" style="width:150px;"  class="btn btn-primary btn-lg" onclick="orderkitchen()" value="Kitchen Order" style="margin-right: 3px;"/>
	
						
					<!-- 	<button style="width:150px; margin-left:25px" class="btn btn-danger btn-lg" type="reset"  name="btn" value="Reset" onclick="reloadPage()">Reset</button> -->
			</div>	
	</div>

		
			<div class="col-md-12 col-12 col-sm-12 col-xs-12 col-lg-5 col-xl-5">
			<h4 align="center" style="color: purple;">Select Table</h4>
				
					<div class="row" align="center" style="margin-left:50px">		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="1" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>1</h3></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="2" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>2</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="3" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>3</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="4" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>4</h3></button>
					
			
			
				<div class="row " align="center">		
						<div style="padding-top: 15px;">	
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="5" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>5</h3></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="6" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>6</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="7" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>7</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="8" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>8</h3></button>
					</div>
				</div>
				

				<div class="row" align="center">		
					<div style="padding-top: 15px;">
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="9" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>9</h3></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="10" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>10</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="11" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>11</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="12" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>12</h3></button>
					</div>
				</div>
				
				<div class="row" align="center">		
					<div style="padding-top: 15px;">		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="13" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>13</h3></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="14" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>14</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="15" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>15</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="16" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>16</h3></button>
					</div>
				</div>

				<div class="row" align="center">		
					<div style="padding-top: 15px;margin-bottom:50px">		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="17" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>17</h3></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="18" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>18</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="19" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>19</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="20" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>20</h3></button>
					</div>
				</div>
			</div>
		</div>
		
	</div>

				<!-- <div class="row" style="margin-top: 30px">
					<div class="col-md-2" style="margin-left: 330px">
						<label class="control-label" style="font-size: 22px;">Grand Total </label>
					</div>
					<div class="col-sm-2">
						<input type="number" class="form-control" id="grndtotalAmount" style="font-size:16px; height:35px;" placeholder="Grand Total" style="font-size: 18px;" readonly="readonly"/>
					</div> 
				</div> -->

			
	

			<!-- Table number -->
		
</form>

</body>
</html>

<%@include file="common/newFooter.jsp"%> 