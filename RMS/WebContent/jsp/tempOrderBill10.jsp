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
<title>New Order Bill</title>

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

<script src="/RMS/staticContent/js/orderBillTT.js"></script>
<script src="/RMS/staticContent/js/split.min.js"></script>
                       <script type="text/javascript">
/* 							function listForOrderBill(){
								window.location = "kitchenOrder.jsp";
							}	 */
                       
                       /* function listForOrderBill(){
								 window.location = "ListOrderBill.jsp";
							} */
							
						</script>	
 
<style type="text/css">

</style>



<script type="text/javascript">
 
	function reloadPage() {
		location.reload();
	}
 
</script>

</head>
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
						
						<%
						ItemEntryDao itemEntryDao = new ItemEntryDao();
						List iList= itemEntryDao.getAllItemEntriesForOrderBill(request);
						
						%>
					
				   </datalist>
				
					</div>
					
				

	
		<!-- <div class="row">
		 -->

			<!-- Order bill data table -->
			
			 <div class="col-md-8">
		<!-- 	 <h4 align="center" style="color: purple;">Ordered Items</h4> --> 
				<div class="table-responsive">
					<table id="list" ></table>
					<div id="jqGridPager"></div>
										
				</div> 
				
				<div class="row margin-t-13">
					<div class="col-md-offset-1 col-md-5" align="right">
						<label class="control-label" style="font-size: 22px;" >Total Amount: </label>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control" id="totalAmount" style="font-size:22px;height:35px;" placeholder="Total Amout" style="font-size: 22px;" readonly="readonly"/>
					</div> 
				</div>
				
				<div class="row">
					<div align="center" class="margin-t-50 margin-b-13">
					<button class="btn btn-primary btn-lg"   onclick="listForOrderBill()" id="order" style="height: 81px; width: 200px;font-size:22px">Order</button>
						<button class="btn btn-lg btn btn-success"  onclick="registerBill(); return false;" id="print" style="height: 81px;
    width: 200px; margin-left:25px;font-size:22px">Print Bill</button>

						<!-- <button class="btn btn-danger btn-lg" style="width:150px; margin-left:25px;">Clear</button> -->
						
						<button class="btn btn-danger btn-lg" style="height: 81px;
    width: 200px; margin-left:25px;font-size:22px" onclick="reloadPage()">Clear</button>
			
					</div>
				</div>
			</div>

			</form>

						<div class="col-lg-4 col-md-4" style="margin-top:10px; height:550px; overflow-x: none; overflow-y: auto;"
				id="tableArea1">
						<%
						for(int i=0;i<iList.size();i++){
						ItemEntry itemEntry = (ItemEntry)iList.get(i);
				
						%>
			
		
				

			 <button class="btn btn-primary mt-3 mb-3" name="p" id="<%=itemEntry.getPk_item_entry_Id()%>" style="height:100px; width:140px; margin-top: inherit; font-size:20px" onclick="getItemDetailById1(this); return false;" value="<%=itemEntry.getPk_item_entry_Id()%>"><%=itemEntry.getItemName()%></button>
							
				

					

				        <%
					       }
				        %>
				</div>
				</div>	


</body>
</html>

<%@include file="common/newFooter.jsp"%> 