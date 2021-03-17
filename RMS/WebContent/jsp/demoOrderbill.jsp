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
<% boolean isHome=false;%>
 <%@include file="common/header.jsp"%>

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

<script src="/RMS/staticContent/js/tempOrder.js"></script>

                       <script type="text/javascript">
							function listForOrderBill(){
								 window.location = "ListOrderBill.jsp";
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

<script type="text/javascript">

/*  function Activechange(){
	
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
}  */

/*  function Activechange1(data){
		
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
}  */

 /* function tableValidation(){
	var tabNum = document.getElementById("table_No").value;
		if(tabNum == 0){
			 alert("select Table First!!!!!!");
			 return false;
			
         } 
}  
 */
	function reloadPage() {
		location.reload();
	}
 
</script>

</head>
<% 
	Long orderBill = 1l;
%>

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
		CustomerOrderDao data = new CustomerOrderDao();
		List stkList  = data.getLastBillNo(request);
		
		for(int i=0;i<stkList.size();i++){
			
			CustomerOrder st = (CustomerOrder)stkList.get(i);
			orderBill = st.getBillNo();
			
			orderBill++;
		}
 %>


<body>

<div class="container" style="margin-left: 230px">
		<h2 class="form-name">Order Bill</h2>

		<div align="right" style="margin-right: 200px;">
			<h3 style="color: red; margin-right: -297px; margin-top: -50px">
				Bill No ::
				<%
				out.println(orderBill);
			%>
			</h3>
		</div>
	</div>

<br>
<form class="form-horizontal" action="" method="post" name  = "order">
	<div class="container-fluid">
		<!-- <h2 align="center" class="form-heading">Order Bill</h2> -->
		
			 <div class="row margin-t-13">
						<div class="col-md-1" align="right">
							<label class="control-label" style="font-size:22px;">Item:</label>
						</div>
						
						<%
						ItemEntryDao itemEntryDao = new ItemEntryDao();
						List iList= itemEntryDao.getAllItemEntriesForOrderBill(request);
						
						%>
					
					<div class="col-md-2">
						 <input list="fk_item_id_drop" id="fk_item_id" autofocus="fk_item_id"  class="form-control" onchange="tableValidation(); return shree();"/>
					<!--  <input list="fk_item_id_drop" id="fk_item_id" autofocus="fk_item_id"  class="form-control" onchange="getItemDetailById(); "> -->
					 <datalist id="fk_item_id_drop">
				
						<%
						for(int i=0;i<iList.size();i++){
						ItemEntry itemEntry = (ItemEntry)iList.get(i);
					//	GoodsReceiveBean goodrecieve = (GoodsReceiveBean)iList.get(i);
						%>
				
					<option data-value="<%=itemEntry.getPk_item_entry_Id()%>" value="<%=itemEntry.getItemName() %> <%=itemEntry.getUnitsInMl()%>">
				        <%
					       }
				        %>
				   </datalist>
				
					</div>
					
					
	<!-- 			    <div class="col-md-1" align="right">
						<label class="control-label" style="font-size:22px;">Table:<sup>*</sup></label>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" id="table_No"  placeholder="Enter Table Number" required onchange="getItemDetailByTable1(); Activechange();" />
					</div>	 -->
					
					<div class="col-md-1" align="right">
						<label class="control-label" style="font-size:22px;">Waiter:<sup>*</sup></label>
					</div>
					
						
						<%
						AddWaitersDao wList = new AddWaitersDao();
						List waiterList= wList.getAllWaitersList(request);
						
						%>
					
					<div class="col-md-2">
					
						<input type="text" class="form-control" list="waiterList" id="waiterName" name="waiterName" placeholder="Waiter Name"   />
						
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
						
					</div>	
				
			</div>
				
	
		<div class="row">
		

			<!-- Order bill data table -->

			 <div class="col-md-8">
			 <h4 align="center" style="color: purple;">Ordered Items</h4> 
				<div class="table-responsive">
					<table id="list" ></table>
					<div id="jqGridPager"></div>
										
				</div> 
				
				<div class="row margin-t-13">
					<div class="col-md-offset-4 col-md-2" align="right">
						<label class="control-label" style="font-size: 22px;" >Total Amount: </label>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control" id="totalAmount" style="font-size:22px;height:35px;" placeholder="Total Amout" style="font-size: 22px;" readonly="readonly"/>
					</div> 
				</div>
				
				<div class="row">
					<div align="center" class="margin-t-50 margin-b-13">
					<button class="btn btn-primary btn-lg"   onclick="listForOrderBill()" id="order" style="width:150px;">Order</button>
						<button class="btn btn-lg btn btn-success"  onclick="resBill(); return false;" id="print" style="width:20%; margin-left:25px;">Print Bill</button>
<!-- 						<button class="btn btn-primary btn-lg"   onclick="listForOrderBill()" id="order" style="width:150px; margin-left:25px;">Order</button> -->
						<!-- <button class="btn btn-danger btn-lg" style="width:150px; margin-left:25px;">Clear</button> -->
						
						<button class="btn btn-danger btn-lg" style="width:150px; margin-left:25px;" onclick="reloadPage()">Clear</button>
					<!-- 	<button style="width:150px; margin-left:25px" class="btn btn-danger btn-lg" type="reset"  name="btn" value="Reset" onclick="reloadPage()">Reset</button> -->
					</div>
				</div>
			</div>

			<!-- Table number -->
			
			<div class="col-md-4">
			<h4 align="center" style="color: purple;">Select Table</h4>
				<div class="row" align="center">		
					<div>		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" id="fk_item_id" value="French_Fries" onclick="getItemDetailByTable(this)"><h4>french-fries</h4></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" id="fk_item_id" value="Noodles" onclick="getItemDetailByTable(this)"><h3>Noodles</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" id="fk_item_id" value="Burger" onclick="getItemDetailByTable(this)"><h3>Burger</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" id="fk_item_id" value="Sandwich" onclick="getItemDetailByTable(this)"><h3>Sandwich</h3></button>
					</div>
				</div>
				
			<!-- 	<div class="row" align="center">		
					<div style="padding-top: 15px;">		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Pizza" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Pizza</h3></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Shake" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Shake</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Mocktails" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Mocktails</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Corny_feast" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Corny feast</h3></button>
					</div>
				</div>
				

				<div class="row" align="center">		
					<div style="padding-top: 15px;">
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Coffeezzz" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Coffeezzz</h3></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Exclusive Hotyzzz" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Exclusive Hotyzzz</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Alfresco_thanda_chaai" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Alfresco thanda chaai</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Lassi-e-khaas" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Lassi-e-khaas</h3></button>
					</div>
				</div>
				
				<div class="row" align="center">		
					<div style="padding-top: 15px;">		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Chaat_walaaa" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Chaat walaaa</h3></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Coffee_Hotyzzz" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Coffee Hotyzzz</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Alfresco_garam chaai" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Alfresco garam chaai</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="Potato_twister" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>Potato twister</h3></button>
					</div>
				</div>

				<div class="row" align="center">		
					<div style="padding-top: 15px;">		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="17" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>17</h3></button>					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="18" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>18</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="19" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>19</h3></button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="20" onclick=" Activechange1(this); getItemDetailByTable(this); return false;"><h3>20</h3></button>
					</div>
				</div> -->
			</div>
		</div>
	</div>
	
</form>

</body>
</html>

<%@include file="common/newFooter.jsp"%> 