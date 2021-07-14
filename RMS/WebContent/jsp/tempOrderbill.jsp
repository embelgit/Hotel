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
	
	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap');

	* {
		font-family: 'Poppins', sans-serif;
	}

	body {
		background: #131D28;
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
	
	.form-group span:before {
		content:'';
		position: absolute;
		top: 40px;
		left: 0;
		width: 100%;
		height: 2px;
		background: #00aabb;
	}
	
	.form-group input:read-only ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.table-responsive .ui-jqgrid-bdiv {
		height: 175px !important;
	}
	
	.ui-jqgrid-labels .ui-state-default {
		width: 104px !important;
	} 
	
	.ui-jqgrid tr.jqgfirstrow>td {
		width: 104px !important;
	} 
	
	.ibutton input[type="button"] {
		width: 150px;
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
	<div id="start"> 
		<div class="row">
			<div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
				<div class="heading">	
					<h2 align="center" class="form-heading"><b>KIOSK Bill</b></h2>
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
		<div class="row">
			<form class="form-horizontal" action="" method="post" name="order">
				<div class="col-lg-6  col-md-6 col-sm-12 col-xs-12 col-xl-6">	
					<div class="form-background">
						<div class="conatiner">
							<div class="row">
							<!-- Order bill data table -->
			 					<div class="col-md-12 col-12 col-lg-12 col-xl-12 col-sm-12 col-xs-12">
									<%
										ItemEntryDao itemEntryDao = new ItemEntryDao();
										List iList= itemEntryDao.getAllItemEntriesForOrderBillkioskbill(request);
									%>
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
									<div class="total-amount">
										<input type="text" id="totalAmount" readonly="readonly" required/>					
										<span></span>
										<label >Grand Total </label>
				   					</div>
			      	 			</div>
		         			 </div>
						</div>
						<div class="ibutton" style="padding-bottom:50px;">
							<div class="row" align="center">
								<i class="las la-print la-2x cust"></i>
								<input type="button" class="btn btn-lg btn-primary btn-md" value="Print Bill" onclick="registerBill(); return false;" id="print" />
								<i class="las la-eraser la-2x cust"></i>
								<input type="button"  class="btn btn-lg btn-danger btn-md"  onclick="reloadPage()"  value="Clear"/>
							</div>
						</div>
					</div>	
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-lg-6 col-xl-6" id="tableArea1">
					<div class="form-background">
						<%
							for(int i=0;i<iList.size();i++){
								ItemEntry itemEntry = (ItemEntry)iList.get(i);
						%>
			 			<button class="btn btn-primary " name="p" id="<%=itemEntry.getPk_item_entry_Id()%>" style="height:100px; width:140px; margin-top:3px; font-size:20px;" onclick="getItemDetailById1(this); return false;" value="<%=itemEntry.getPk_item_entry_Id()%>"><%=itemEntry.getItemName()%><br><%=itemEntry.getValue()%> <%=itemEntry.getUnit()%></button>
						<%
					       }
				        %>
				        <div class="row form-group"></div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

<%@include file="common/newFooter.jsp"%> 