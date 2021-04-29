<%-- <%@include file="common/header.jsp"%> --%>
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


<html>
<%boolean isHome=false; %>
	<%@include file="common/header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kiosk Bill</title>
<script src="/RMS/staticContent/js/split.min.js"></script>
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


<!-- <link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
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

<script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
<script src="/RMS/staticContent/js/bootstrap.js"></script>


<script type="text/javascript" src="/RMS/staticContent/js/bootbox.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/bootbox.min.js"></script> 
<script src="/RMS/staticContent/js/bootbox.min.js"></script>
<script src="/RMS/staticContent/js/bootbox.js"></script>   -->  


<script src="/RMS/staticContent/js/orderBillTT.js"></script>


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


<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		<%-- 		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
<h2 align="center" class="form-heading"><b>Kiosk Bill</b></h2>
</div>
	<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
<h3 align="right">
				Bill No ::
		 		<%
				out.println(orderBill);
			%> 
			</h3>
</div>
<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
</div> --%>
<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading" ><b>Kiosk Bill</b></h2>
			</div>
				<hr>
		</div>
		<div class="col-md-12 col-lg-3 col-xl-2 col-sm-12">
			<h3 style="color: red" align="right">
				Bill No ::
		 		<%
				out.println(orderBill);
			%> 
			</h3>
		</div>
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		</div>
		
<form class="form-horizontal" action="" method="post" name  = "order">
<div class="row">
<div class="col-10 col-md-10 col-lg-6 col-sm-10 col-xs-6 col-xl-6">
		<!-- <h2 align="center" class="form-heading">Order Bill</h2> -->
	
		<div class="item">	
		<div class="row">
		<div class="col-12 col-lg-12 col-md-12 col-sm-12 col-xl-12 col-xs-12">
						
						<%
						ItemEntryDao itemEntryDao = new ItemEntryDao();
						List iList= itemEntryDao.getAllItemEntriesForOrderBillkioskbill(request);
						
						%>
					
			
				
					
					
				

	
		<!-- <div class="row">
		 -->

			<!-- Order bill data table -->
			
		
		<!-- 	 <h4 align="center" style="color: purple;">Ordered Items</h4> --> 
		
				<div class="table-responsive" >
					<table id="list" ></table>
					<div id="jqGridPager"></div>
										
				</div> 
				</div>
				</div>
					<!-- <div class="col-lg-2">
							<label  style="font-size: 22px;" >GST %:</label>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="gst" style="font-size:22px;height:35px;" placeholder="GST %" style="font-size: 22px;" onchange="gstCal()"/>					
					</div>
					<div class="col-md-2">
						<label class="control-label" style="font-size: 22px;" >GST Amount</label>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="gstAmt" style="font-size:22px;height:35px;" placeholder="Amount" style="font-size: 22px;" readonly="readonly"/>					
					</div> -->
					<div class="row form-group"></div>
	               <div class="row form-group"> 
				
					<div class="col-md-12 col-sm-12 col-xs-12 col-xl-4 col-lg-4">
			        <div class="total-amount">
						<input type="text" class="form-control" id="totalAmount" readonly="readonly" style="font-size: 18px;" required/>					
							<label >Grand Total </label>
				   </div>
			       </div>
		          </div>
	</div>
	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">
<!-- <button class="btn btn-primary btn-lg"   onclick="listForOrderBill()" id="order" style="height: 81px; width: 200px;font-size:22px">Order</button> -->
	<input type="button" class="btn btn-lg btn btn-success" value="Print Bill" onclick="registerBill(); return false;" id="print"
						/>

						<!-- <button class="btn btn-danger btn-lg" style="width:150px; margin-left:25px;">Clear</button> -->
			
		<input type="button"  class="btn btn-danger btn-lg"  onclick="reloadPage()"  value="Clear"/>
			
					</div>
				</div>
</div>	
				<!-- <div class="row margin-t-13">
					<div class="col-md-2 col-lg-2" style="margin-left: 330px" >
						<label class="control-label" style="font-size: 22px;" >Grand Total:</label>
					</div>
					<div class="col-sm-2 col-lg-2">
						<input type="text" class="form-control" id="grndtotalAmount" style="font-size:20px;height:35px;" placeholder="Grand Total" style="font-size: 22px;" readonly="readonly"/>
					</div> 
				</div> -->
		



			

<div class="col-lg-5 col-md-12 col-sm-12 col-12 col-xl-5" id="tableArea1" style="margin-left:65px;">
						<%
						for(int i=0;i<iList.size();i++){
						ItemEntry itemEntry = (ItemEntry)iList.get(i);
				
						%>
			
		
				

			 <button class="btn btn-primary " name="p" id="<%=itemEntry.getPk_item_entry_Id()%>" 
			 style="height:100px; width:140px; margin-top:3px; font-size:20px;" onclick="getItemDetailById1(this); return false;" 
			 value="<%=itemEntry.getPk_item_entry_Id()%>"><%=itemEntry.getItemName()%><br><%=itemEntry.getValue()%> <%=itemEntry.getUnit()%></button>
							
				

					

				        <%
					       }
				        %>
				</div>

	</div>


</form>


</body>
</html>

<%@include file="common/newFooter.jsp"%> 