
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
<script type="text/javascript">


function subcatDetailsDivAction(a)
	{	
		if(a==1){
			$( "#subCategoryDiv" ).dialog({height: 420, width:1000});   	
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
.bt{
padding-left:30%;
}
li a {
	font-weight: 600;
	text-decoration: none;
	padding: 15px 14px;
	display: block;
	color: #fff;
	transition: all 0.2s ease-in-out 0s;
	font-size: 13px;
}
#logoutButton {
	height: 35px;
	width: 80px;
	background: #353535;
	border: 2px solid #353535;
	color: white;
	font-weight: bolder;
	font-size: 12px;
	position: fixed;
	top: 3%;
	right: 2%;
}

#currentUser {
	color: orange;
	font-weight: 600;
	font-size: 17px;
	position: fixed;
	top: 1%;
	right: 2%;
}

#logo {
	width: 110px;
	height: auto;
	position: fixed;
	top: 9%;
	right: 1%;
	z-index: -1;
	opacity: 0.6;
}

.col-lg-offset-1 {
	margin-left: 9.333333%;
}

.col-md-offset-1 {
	margin-left: 4.333333%;
}

.btn_pur {
	margin-left: 47px;
}

.col-md-2.col-lg-2 {
	display: inline-block;
width:auto;
}
.col-md-4.col-sm-12.col-xs-12.col-xl-3.col-lg-3 {
    width: 46%;
}
.col-md-3.col-sm-12.col-xs-12.col-xl-3.col-lg-3 {
    width: 90%;
}
.subbtn {
    margin-left: 102px;
}

@media ( min-width : 980px) and (max-width:1180px) {
	.mainWrap {
		width: 768px;
	}
	.menu ul {
		top: 37px;
	}
	.menu li a {
		font-size: 11px;
	}
	a.homer {
		background: #E95546;
	}
	li a {
		padding: 15px 11px;
	}
	#logoutButton {
		width: 70px;
		position: fixed;
		top: 3%;
		right: 2%;
		font-size: 12px
	}
	#currentUser {
		color: orange;
		font-weight: 600;
		font-size: 14px;
		position: fixed;
		top: 1%;
		right: 2%;
	}
	#logo {
		width: 110px;
		height: auto;
		position: fixed;
		top: 10%;
		right: 2%;
		z-index: -1;
		opacity: 0.6;
	}
}

@media ( min-width : 768px) and (max-width: 979px) {
	.mainWrap {
		width: 768px;
	}
	.menu ul {
		top: 37px;
	}
	.menu li a {
		font-size: 9px;
	}
	a.homer {
		background: #E95546;
	}
	li a {
		padding: 15px 8px;
	}
	#logoutButton {
		width: 70px;
		font-size: 11px;
		position: fixed;
		top: 12px;
		right: 44px;
	}
	#currentUser {
		color: orange;
		font-weight: 600;
		font-size: 13px;
		position: fixed;
		top: 4px;
		right: 45px;
	}
	#logo {
		width: 110px;
		height: auto;
		position: fixed;
		top: 9%;
		right: 2%;
		z-index: -1;
		opacity: 0.6;
	}
}

@media ( max-width : 767px) {
	.mainWrap {
		width: auto;
		padding: 30px 20px;
	}
	.menu {
		display: none;
	}
	.responsive-menu {
		display: block;
	}
	nav {
		margin: 0;
		background: none;
	}
	.menu li {
		display: block;
		margin: 0;
	}
	.menu li a {
		background: #fff;
		color: #797979;
	}
	.menu li a:hover, .menu li:hover>a {
		background: #8c7674;
		color: #fff;
	}
	.menu ul {
		visibility: hidden;
		opacity: 0;
		top: 0;
		left: 0;
		width: 100%;
		transform: initial;
	}
	.menu li:hover>ul {
		visibility: visible;
		opacity: 1;
		position: relative;
		transform: initial;
	}
	.menu ul ul {
		left: 0;
		transform: initial;
	}
	.menu li>ul ul:hover {
		transform: initial;
	}
	#logoutButton {
		width: 94px;
		font-size: 14px;
		position: relative;
		top: 0;
		right: 0;
		height: 15%;
	}
	#currentUser {
		color: yellow;
		font-weight: 600;
		font-size: 16px;
		position: fixed;
		top: 5px;
		right: 7%;
	}
	#logo {
		width: 110px;
		height: auto;
		position: fixed;
		top: 7%;
		right: 2%;
		z-index: -1;
		opacity: 0.6;
	}
	.col-lg-offset-1 {
		margin-left: 9.333333%;
	}
	.col-md-3.col-sm-12.col-xs-12.col-xl-3.col-lg-3 {
    width: 90%;
}
.btn_pur {
    margin-left: 53px;
}
}
.kebab {
  cursor: pointer;
  position: relative;
  display: inline-block;
  box-sizing: border-box;
  padding: 0 16px;
  top: 12px;
  figure {
    width: 6px;
    height: 6px;
    border-radius: 5px;
    background: $cyan;
    margin: 3px 0;
  }
}
.cross {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%) scale(0);
  margin-top: -1px;
  font-family: $nunito;
  color: white;
  transition: all 0.2s $cubic-in;
  font-size: 22px;
  user-select: none;
}
/* .dropdown-list .dropdown {
    position: absolute;
    right: 0;
    top: 3em;
    transition: all 0.25s ease-out;
    transform: scale(0);
    transform-origin: 100% 0;
    box-shadow: $shadow;
    li {
      display: block;
      width: 100%;
      a {
        width: 100%;
        padding: 1em 18px;
        display: inline-block;
        white-space: pre;
        box-sizing: border-box;
        &:hover {
          background: lighten($grey, 30%);
        }
      }
    }
  &:hover {
    ul {
      transform: scale(1);
    }
  }
} */
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
<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>

       <div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading" ><b>Order Bill</b></h2>
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
	
		</div>
		<div class="row">
		
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
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
					<label style="font-size: 18px;">Item : </label>
					
					</div>
				</div>
					
		 <div class="col-md-6  col-sm-12 col-xs-12 col-xl-2 col-lg-2">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="table_No"   required onchange="getItemDetailByTable1(); Activechange();" />
							<label style=" font-size: 18px;">Table : <sup>*</sup></label>
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
						<label style= "font-size: 18px;"> Waiter : <sup>*</sup></label>
					</div>	
				</div>
		
		<!-- 		
		 <div class="col-md-6  col-sm-12 col-xs-12 col-xl-4 col-lg-4">
			<div class="invoice_label_up">
						<input type="text" class="form-control"  id="customerdetails" onclick="customerdetails" name="customerdetails" required  />
							<label style=" font-size: 18px;">Customer Details : <sup>*</sup></label>
					</div>	
				</div>
				 -->
				
				
				<form action="" class="form-horizontal" method="post" name="Customer">			
		 <div class="col-md-6  col-sm-12 col-xs-12 col-xl-4 col-lg-4 customerdetails" id="customerdetailslist">
			<div class="invoice_label_up">
						<select id='customerdetails' name='customerdetails' required></select><span
						class="customer"><label>Customer Details : <sup>*</sup></span>	<span class ="godbtn">
			<button type="button" onclick="customerdetailsDivAction(1);">
							<i class ="glyphicon glyphicon-plus" style="color: #0078ae; font-size: 18px;"></i>
							</button>
							</span>
						
					</div>	
				</div>
				
			
				
<div class="conatiner">
	<div class="row">
			<!-- Order bill data table -->

			 <div class="col-md-12 col-12 col-lg-12 col-xl-12 col-sm-12 col-xs-12">
				<div class="table-responsive" >
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
						<input type="number" class="form-control" id="totalAmount"  readonly="readonly" style= "font-size: 18px;"/>
						<label>Grand Total </label>
						</div>
					</div> 
				</div>
			</div>

	</div>
		<div class="bt" >
	
		<input type="button" class="btn btn-primary btn-lg" id="order" onclick="orderbilling(); return false;" value="Order" style="margin-right: 3px;"/>

		<input type="button" class="btn btn-lg btn btn-success"  onclick="resBill(); return false;" id="print" value="Print Bill" style="margin-right: 3px;"/>
	
<!-- 		 <input type="button" class="btn btn-danger btn-lg"  onclick="reloadPage() return false" value="Clear" style="margin-right: 3px;"/>
 -->		<input type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reloadPage()" />
		 

		<input type="button" style="width:150px;"  class="btn btn-primary btn-lg" onclick="orderkitchen()" value="Kitchen Order" style="margin-left: 3px;"/>
	
						
					<!-- 	<button style="width:150px; margin-left:25px" class="btn btn-danger btn-lg" type="reset"  name="btn" value="Reset" onclick="reloadPage()">Reset</button> -->
			</div>	
	</div>

		
			<div class="col-md-12 col-12 col-sm-12 col-xs-12 col-lg-5 col-xl-5">
			<h4 align="center" style="color: purple;">Select Table</h4>
				
					<div class="row" align="center" style="margin-left:50px">		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="1" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
												<div class="dropdown-list"> 
												<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown" class="dropdown-content">
												 <a href="orderBill.js" onclick="resBill1()">Print Bill</a>
												 <a href="EditTable.jsp" onclick="EditTable()">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">1</h3>
    											</div>
    												
    											
    												</button>
											
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="2" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
												<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction1()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown1" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">2</h3>
    												<!-- </div> -->
    												
    											
    												</button>
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="3" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction2()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown2" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">3</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="4" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction3()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown3" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">4</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
					
			
			
				<div class="row " align="center">		
						<div style="padding-top: 15px;">	
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="5" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction4()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown4" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">5</h3>
    												<!-- </div> -->
    												
    											
    												</button>											
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="6" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction5()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown5" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">6</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="7" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction6()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown6" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">7</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="8" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction7()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown7" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">8</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
					</div>
				</div>
				

				<div class="row" align="center">		
					<div style="padding-top: 15px;">
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="9" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction8()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown8" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">9</h3>
    												<!-- </div> -->
    												
    											
    												</button>											
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="10" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction9()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown9" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">10</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="11" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction10()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown10" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">11</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="12" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction11()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown11" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">12</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
					</div>
				</div>
				
				<div class="row" align="center">		
					<div style="padding-top: 15px;">		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="13" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction12()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown12" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">13</h3>
    												<!-- </div> -->
    												
    											
    												</button>											
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="14" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction13()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown13" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">14</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="15" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction14()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown14" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">15</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="16" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">			
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction15()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown15" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">16</h3>
    												<!-- </div> -->
    												
    											
    												</button>						
				</div>
				</div>
				

				<div class="row" align="center">		
					<div style="padding-top: 15px;margin-bottom:50px">		
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="17" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
<span style="color: #ffffff; margin-left: 67px;" onclick="myFunction16()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown16" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">17</h3>
    												<!-- </div> -->
    												
    											
    												</button>												



					
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="18" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
                         <span style="color: #ffffff; margin-left: 67px;" onclick="myFunction17()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown17" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">18</h3>
    												<!-- </div> -->
    												</button>						
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="19" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
       <span style="color: #ffffff; margin-left: 67px;" onclick="myFunction18()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown18" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">19</h3>
    												<!-- </div> -->
    			
    												</button>						
						<button class="btn btn-primary" name="p" style="height:100px;width:100px;padding: 10px;" value="20" onclick=" Activechange1(this); getItemDetailByTable(this); return false;">
                                                 <span style="color: #ffffff; margin-left: 67px;" onclick="myFunction19()" class="dropbtn">&#8942;</span>
												 <div id="myDropdown19" class="dropdown-content">
												 <a href="orderBill.js">Print Bill</a>
												 <a href="#about">Move Table</a>
												 <a href="OrderBill.jsp" onclick="reloadPage()">Clear</a>
                                                 </div>
                                                 <h3 style=" margin-bottom: 17px;">20</h3>
    												<!-- </div> -->
    												
    											</button>						
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

		
		

		
		<div class ="container" id="customerdetailsDiv"
				style="display: none;">
				<div class="popup">
				<div class="row">
				<h2>Add Customer Details</h2>
				</div>
				<div class="containeer" style="width:auto;margin: 0;">
				<div class="row col-md-offset-1">
				<div class ="popup_label_up">
				
				<div class="col-md-4 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div id="categoryListForSubCat">
				<input list="fkcustomerId" id="fkcustomerId"
					name="fkcustomerId" style="background: #f0f0f0" required>
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
											
						 
						
												

												<label>Customer Name</label>
											</div>
										</div>
									</div>
									<div class="popup_label_up">
										<div class="col-md-4 col-sm-12 col-xs-12 col-xl-3 col-lg-3">

											<input type="date" list="customerDOB" id="customerDOB"
												name="customerDOB" onchange="cheakForcustomer()"
												style="background: #f0f0f0" required>
											

											<tr><label>DOB</label></tr>
										</div>
									</div>
									</div>
									
									
										<div class="popup_label_up">
										<div class="col-md-4 col-sm-12 col-xs-12 col-xl-3 col-lg-3">

											<input list="customerNumber" id="customerNumber"
												name="customerNumber"  maxlength="10"  required  pattern="[0-9]{10,10}" onchange="cheakForcustomer()"
												style="background: #f0f0f0" required>
											<tr><label>Mobile Number</label></tr>
										</div>
									</div>
									
								</div>
								<input type="hidden" value="POPUPSUBCATDATAILS"  id="popUpSubCatJspId" />
								<div class="row customerbtn">
									<div class="col-md-2 col-sm-3 col-xs-3 col-lg-2 col-xl-3">
										<input type="button" name="customerBtn1" id="save"
											style="width: 124px;" onclick="valcustomer();" value="Save"
											class="btn btn-success" />
									</div>

									<div class="col-md-2 col-lg-2">
										<input type="button" value="Cancel" name="cancelCustomerBtn"
											style="width: 124px;" id="cancelCustomerBtn"
											onclick="customerdetailsDivAction(0); emptyCustomerFields();"
											class="btn btn-large btn-danger btn-md button_hw button_margin_right"
											;" />
									</div>
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


</body>
</html>

<%@include file="common/newFooter.jsp"%> 




































