
<%@page import="com.rms.hibernate.kitchenorderHibernate"%>
<%@page import="com.rms.dao.OrderBillDao"%>
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
<%@page import="com.rms.helper.CustomerD" %>
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
<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->
	
	<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

	<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
     
    <link rel="stylesheet" href="/RMS/staticContent/y_css/jquery-ui.css">
  	<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
     <script type="text/javascript" src="/RMS/staticContent/js/drowpdownlist.js"></script>
    
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

 <script type="text/javascript">
	
	$(function(){
	    var dtToday = new Date();
	    
	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	        day = '0' + day.toString();
	    
	    var maxDate = year + '-' + month + '-' + day;
	    //alert(maxDate);
	    $('#customerDOB').attr('max', maxDate);
	});
	
	</script>
	
	
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
	
        myList[abc].style.backgroundColor = "#7d5d81";
        myList[abc].style.borderColor = "#7d5d81";

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
	          myList[xyz].style.color = "#ead24c";
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
	          myList[xyz].style.color = "#ead24c";
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
<script type="text/javascript">


function subcatDetailsDivAction(a)
	{	
		if(a==1){
			$( "#subCategoryDiv" ).dialog({height: 520, width:1000});   	
	    }else{
	    	$( "#subCategoryDiv" ).dialog('close');  
	    }		
		$('#subcategoryrefresh').load(document.URL +  ' #subcategoryrefresh');
	}
	</script>

<script type="text/javascript">

	 function EditTable() {
			 window.location = "EditTable.jsp";
	}
	
</script>
<style type="text/css">

.col-sm-offset-1 {
	margin-left: 4%;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 130px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
.dropdown-content a {
  color: black;
  padding: 5px 5px;
  text-decoration: none;
  display: block;
}
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
	
	.display-bill {
	 	float: right; 
	 	margin-right: 30px; 
	 	margin-top: 10px;  
	 	color: /* #f00 */#ead24c;
	 }
	
	.form-background {
		/* background: #0B1218;
    	position: relative;
    	padding: 20px;*/
    	
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
	
	.table-responsive .ui-jqgrid-bdiv {
		height: 140px !important;
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
	
	.godbtn i {
		font-size: 20px;
		color: #00aabb;
	}
	
	.godbtn button {
		background-color: #000;
		float: right;
		border-color: #00aabb;
		padding: 4px;
	}
	
	.row1 .btn {
		height:100px;
		width:100px;
		padding: 10px;
		margin: 5px;
	}
	
	.row1 span {
		color: #ffffff; 
		margin-left: 67px;
	}
	
	.row1 h3 {
		margin-bottom: 17px;
		margin-top: 5px;
	}
	
	#customerdetailsDiv {
		display: none;
   	 	background-color: #131d28;
   	 	width: 300px;
	}
	
	.ui-jqgrid .ui-jqgrid-pager {
    	z-index: 100 !important;
	}
	
	.ui-helper-clearfix:before{
    	content: "Add Coustomer Details";
    	display: block;
    }
    
    .ui-helper-clearfix span {
    	display: none;
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
	<div id="start">
		<div class="row">
			<div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
				<div class="heading">	
					<h2 align="center" class="form-heading" ><b>Order Bill</b></h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="display-bill">
				<h3>
					Bill No ::
		 			<%
						out.println(orderBill);
					%> 
				</h3>
			</div>
		</div>
		<div class= "row">
			<form class="form-horizontal" action="" method="post" name="order">
				<div class="col-lg-6  col-md-6 col-sm-12 col-xs-12 col-xl-6">	
					<div class="form-background">
						<div class="row form-group"> 
							<div class="col-md-5  col-sm-5 col-xs-5 col-xl-5 col-lg-5 col-sm-offset-1">
								<div class="invoice_label_up">
									<%
										ItemEntryDao itemEntryDao = new ItemEntryDao();
										List iList= itemEntryDao.getAllItemsEntriesForOrderBill(request);	
									%>
						 				<input list="fk_item_id_drop" id="fk_item_id" autofocus="fk_item_id" required onchange="tableValidation(); return shree(); return false">
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
				  				 		<span></span>
								 		<label>Item</label>
								</div>
							</div>
							<div class="col-md-5  col-sm-5 col-xs-5 col-xl-5 col-lg-5 col-sm-offset-1">
								<div class="invoice_label_up">
									<input type="text" id="table_No" required onchange="getItemDetailByTable1(); Activechange();" />
									<span></span>
									<label>Table <sup>*</sup></label>
								</div>	
							</div>
						</div>
						<div class="row form-group"> 
							<div class="col-md-5  col-sm-5 col-xs-5 col-xl-5 col-lg-5 col-sm-offset-1">
								<div class="invoice_label_up">
									<%
										AddWaitersDao wList = new AddWaitersDao();
										List waiterList= wList.getAllWaitersList(request);
									%>
									<input type="text" list="waiterList" id="waiterName" name="waiterName" required  />
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
				   					<span></span>
									<label> Waiter <sup>*</sup></label>
								</div>	
							</div>
		 					<div class="col-md-5  col-sm-5 col-xs-5 col-xl-5 col-lg-5 col-sm-offset-1 customerdetails" id="customerdetailslist">
								<div class="invoice_label_up">
									<select id='customerdetails' name='customerdetails' required></select>
									<span></span>
									<!-- <span class="customer"> --><label>Customer Details <sup>*</sup></label><!-- </span> -->
		
								</div>	
							</div>
						</div>
						<span class ="godbtn">
							<button type="button" onclick="customerdetailsDivAction(1);">
								<i class ="las la-plus"></i>
							</button>
						</span>
						<div class="conatiner">
							<div class="row">
							<!-- Order bill data table -->
			 					<div class="col-md-12 col-12 col-lg-12 col-xl-12 col-sm-12 col-xs-12">
			 						<br>
									<div class="table-responsive" >
										<table id="list" ></table>
										<div id="jqGridPager"></div>						
									</div> 
								</div>
							</div>
						</div>
						<div class="row form-group"> 
							<div class="col-lg-6  col-md-6 col-sm-12 col-xs-12 col-xl-6">		
								<div class="col-md-6  col-sm-6 col-xs-6 col-xl-6 col-lg-6 col-sm-offset-1">
									<div class="">
										<input type="number" id="totalAmount"  readonly="readonly"/>
										<span></span>
										<label class="totallabel">Grand Total</label>
									</div>
								</div> 
							</div>
						</div>	
						<div class="ibutton" style="padding-bottom:50px;">
							<div class="row" align="center">	
								<i class="las la-edit la-2x cust"></i>
								<input type="button" class="btn btn-lg btn-success btn-md" id="order" onclick="orderbilling(); return false;" value="Order"/>
								<i class="las la-print la-2x cust"></i>
								<input type="button" class="btn btn-lg btn-primary btn-md"  onclick="resBill(); return false;" id="print" value="Print Bill"/>
							</div>
							<div class="row" align="center">	
								<i class="las la-eraser la-2x cust"></i>
								<input type="reset" class="btn btn-lg btn-danger btn-md" value="Clear" onclick="reloadPage()" />
								<i class="las la-concierge-bell la-2x cust"></i>
								<input type="button" class="btn btn-lg btn-warning btn-md" onclick="orderkitchen()" value="Kitchen Order" />
							</div>
						</div>
					</div>
				</div>
		    	<div class="col-md-6 col-sm-12 col-xs-12 col-lg-6 col-xl-6">
		    		<div class="form-background">
						<h3 align="center" style="color: #fff; margin-top: 40px;">Select Table</h3>
						<div class="row" align="center" style="margin-top: 30px;">
							<div class="row1">			
								<button class="btn btn-primary" name="p" value="1" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list"> 
										<span onclick="myFunction()" class="dropbtn">&#8942;</span>
										<div id="myDropdown" class="dropdown-content">
											<a href="orderBill.js" onclick="resBill1()">Print Bill</a>
											<a href="EditTable.jsp" onclick="EditTable()">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
										</div>
										<h3>1</h3>
    								</div>
    							</button>			
								<button class="btn btn-primary" name="p" value="2" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction1()" class="dropbtn">&#8942;</span>
										<div id="myDropdown1" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                		</div>
                                		<h3>2</h3>
                            		</div>
    							</button>
								<button class="btn btn-primary" name="p"  value="3" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction2()" class="dropbtn">&#8942;</span>
										<div id="myDropdown2" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                    	</div>
                                    	<h3>3</h3>
    								</div>		
    							</button>						
								<button class="btn btn-primary" name="p"  value="4" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction3()" class="dropbtn">&#8942;</span>
										<div id="myDropdown3" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                    	</div>
                                    	<h3>4</h3>
    								</div>				
    							</button>						
							</div>
						</div>
						<div class="row " align="center">		
							<div class="row1">	
								<button class="btn btn-primary" name="p"  value="5" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">	
										<span onclick="myFunction4()" class="dropbtn">&#8942;</span>
										<div id="myDropdown4" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>5</h3>
    								</div>				
    							</button>											
								<button class="btn btn-primary" name="p"  value="6" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction5()" class="dropbtn">&#8942;</span>
										<div id="myDropdown5" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>6</h3>
    								</div>										
    							</button>						
								<button class="btn btn-primary" name="p"  value="7" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction6()" class="dropbtn">&#8942;</span>
										<div id="myDropdown6" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>7</h3>
    								</div>
    							</button>						
								<button class="btn btn-primary" name="p"  value="8" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction7()" class="dropbtn">&#8942;</span>
										<div id="myDropdown7" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>8</h3>
    								</div>			
    							</button>						
							</div>
						</div>
						<div class="row" align="center">		
							<div class="row1">
								<button class="btn btn-primary" name="p"  value="9" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction8()" class="dropbtn">&#8942;</span>
										<div id="myDropdown8" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>9</h3>
    								</div>
    							</button>											
								<button class="btn btn-primary" name="p"  value="10" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction9()" class="dropbtn">&#8942;</span>
										<div id="myDropdown9" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>10</h3>
    								</div>		
    							</button>						
								<button class="btn btn-primary" name="p"  value="11" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction10()" class="dropbtn">&#8942;</span>
										<div id="myDropdown10" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>11</h3>
    								</div>			
    							</button>						
								<button class="btn btn-primary" name="p"  value="12" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction11()" class="dropbtn">&#8942;</span>
										<div id="myDropdown11" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>12</h3>
    								</div>
    							</button>						
							</div>
						</div>
						<div class="row" align="center">		
							<div class="row1">		
								<button class="btn btn-primary" name="p"  value="13" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction12()" class="dropbtn">&#8942;</span>
										<div id="myDropdown12" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>13</h3>
    								</div>			
    							</button>											
								<button class="btn btn-primary" name="p"  value="14" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction13()" class="dropbtn">&#8942;</span>
										<div id="myDropdown13" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>14</h3>
    								</div>			
    							</button>						
								<button class="btn btn-primary" name="p"  value="15" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction14()" class="dropbtn">&#8942;</span>
										<div id="myDropdown14" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>15</h3>
    								</div>			
    							</button>						
								<button class="btn btn-primary" name="p"  value="16" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">			
									<div class="dropdown-list">
										<span onclick="myFunction15()" class="dropbtn">&#8942;</span>
										<div id="myDropdown15" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>16</h3>
    								</div>			
    							</button>						
							</div>
						</div>
						<div class="row" align="center">		
							<div class="row1" style="margin-bottom:50px">		
								<button class="btn btn-primary" name="p"  value="17" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
									<div class="dropdown-list">
										<span onclick="myFunction16()" class="dropbtn">&#8942;</span>
										<div id="myDropdown16" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>17</h3>
    								</div>
    							</button>												
								<button class="btn btn-primary" name="p"  value="18" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
                         			<div class="dropdown-list">
                         				<span onclick="myFunction17()" class="dropbtn">&#8942;</span>
										<div id="myDropdown17" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                       	</div>
                                        <h3>18</h3>
    								</div>
    							</button>						
								<button class="btn btn-primary" name="p"  value="19" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
       								<div class="dropdown-list">
       									<span onclick="myFunction18()" class="dropbtn">&#8942;</span>
										<div id="myDropdown18" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>19</h3>
    								</div>	
    							</button>						
								<button class="btn btn-primary" name="p"  value="20" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
                                	<div class="dropdown-list">
                                		<span onclick="myFunction19()" class="dropbtn">&#8942;</span>
										<div id="myDropdown19" class="dropdown-content">
											<a href="orderBill.js">Print Bill</a>
											<a href="#about">Move Table</a>
											<a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                        </div>
                                        <h3>20</h3>
    								</div>
    							</button>						
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>	
	</div>
	<div class ="container" id="customerdetailsDiv">
		<div class="popup">
			<form action="" class="form-horizontal" method="post" name="Customer">	
				<div class="container" style="width: auto; margin: 0;">
					<div class="row form-group">
						<div class ="popup_label_up">	
							<div class="col-md-4 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
								<div id="categoryListForSubCat">
									<input list="fkcustomerId" id="fkcustomerId" name="fkcustomerId" required>
									<datalist id="fkcustomerList">
									<%-- 	<% 
														for (int i = 0; i < catList.size(); i++) {
															CustomerDetailsHibernate cat = (CustomerDetailsHibernate) catList.get(i);
													%>
													<option data-value="<%=cat.getPkCategoryId()%>"
														value="<%=cat.getCategoryName()%>">
														<%
															}
														%> 
													 --%>
									<%
										for(int i=0;i<waiterList.size();i++){
										AddWaiters waiter = (AddWaiters)waiterList.get(i);
									%>
										<option data-value="<%=waiter.getPkAddWaiterId()%>" value="<%=waiter.getFirstName()%> <%=waiter.getLastName()%>">
				        			<%
					       				}
				        			%>
				   					</datalist>
				   					<span></span>
									<label>Customer Name</label>
								</div>
							</div>
						</div>
						<div class="popup_label_up">
							<div class="col-md-4 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
								<input type="date" list="customerDOB" id="customerDOB" name="customerDOB" onchange="cheakForcustomer()" required>
								<span></span>
								<label>DOB</label>
							</div>
						</div>
						<div class="popup_label_up">
							<div class="col-md-4 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
								<input list="customerNumber" id="customerNumber" name="customerNumber"  maxlength="10"  required  pattern="[0-9]{10,10}" onchange="cheakForcustomer()" required>
								<span></span>
								<label>Mobile Number</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="row ibutton">
							<div class="popup_label_up">
								<div class="col-md-3 col-sm-3 col-xs-3 col-xl-3 col-lg-3">			
									<input type="hidden" value="POPUPSUBCATDATAILS"  id="popUpSubCatJspId" />
								</div>
							</div>  
							<i class="las la-save la-2x cust"></i>	
							<input type="button" name="customerBtn1" id="save" style="width: 124px;" onclick="valcustomer();" value="Save" class="btn btn-lg btn-success btn-md" />
							<i class="las la-times la-2x cust"></i>
							<input type="button" value="Cancel" name="cancelCustomerBtn" style="width: 124px;" id="cancelCustomerBtn" onclick="customerdetailsDivAction(0); emptyCustomerFields();" class="btn btn-lg btn-danger btn-md" />
						</div>
					</div>
				</div>	
			</form>
			<%-- <%-- <script type="text/javascript">
<!-- ================= Check Duplicate Sub-Category =================== -->
function checkForDuplicateTableNumber(){
	
		<%
		OrderBillDao dao11 = new OrderBillDao();
			List list1 = dao11.getSubCategoryName(request);
		%>
		<%
		  int x = 0;
		  for (x = 0; x < list1.size(); x++) {
			  kitchenorderHibernate bean = (kitchenorderHibernate) list1.get(x);
	    %>
	    var temp = "<%=bean.getPk_temp_id()%>";
	    var table = "<%=bean.getTableNo()%>";
	    var tempid=document.getElementById("pk_temp_id").value;
		var tableNumber=document.getElementById("tableNo").value;
		
		

		if(subcatName == subCat && cat == catName)
		{
			var msg="Sub-Category already exist...Duplicate Not allowed";
			var dialog = bootbox.dialog({
				
			    message: '<p class="text-center">'+msg.fontcolor("red").fontsize(5)+'<img src="/Shop/staticContent/images/s1.jpg" height="50" width="50"/></p>',
			    message: '<p class="text-center">'+msg.fontcolor("red").fontsize(5)+'</p>',
			    closeButton: false
			});
			
			setTimeout(function() {
				dialog.modal('hide');
			}, 1500);

			document.getElementById("pk_temp_id").value = "";
			document.getElementById("tableNo").value = "";

			return false;
		   }
		<%
		}
		%>
	} 
</script> --%>
				
				


 <%--  function checkForAvailbleCustomer()
{
<% CustomerD customerHelper = new  CustomerD()
List customerList  = customerHelper.getcustomerdetails() %>
var 
}	 --%> 
		</div>
	</div>
</body>
</html>

<%@include file="common/newFooter.jsp"%> 




































