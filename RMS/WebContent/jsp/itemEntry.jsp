<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <%@include file="common/header.jsp"%> --%>
<title>Add Menu</title>
			<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
			<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
			<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
			
			<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->
			
			<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>	
			<script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui-min.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
			<script src="/RMS/staticContent/js/bootstrap.js"></script>
									
		<!-- 	<link href="/RMS/staticContent/css/style.css" rel="stylesheet"> -->
		
			<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
		
			<%@include file="common/header.jsp"%>
			<script type="text/javascript" src="/RMS/staticContent/js/itemEntry.js"></script>
			<!-- custom css -->

			<!-- custom JS -->
	<!-- 		<script src="/RMS/staticContent/js/jquery.min.js"></script> -->


           <script type="text/javascript">
                <%-- function checkForItemDuplicate(){
          			<%
          			ItemEntryDao dao = new ItemEntryDao();
          			List list = dao.getAllItemEntriesForOrderBill();
          			%>
          			
          			<%
          			int z = 0;
          			for(z=0;z<list.size();z++){
          				ItemEntry bean = (ItemEntry)list.get(z);
          			%>
          			var pro = "<%=bean.getItemName()%>";
          			var proName=document.getElementById("itemName").value;
          			if(proName == pro){
          				alert("item name already exist...Duplicate Not allowed");
          				location.reload();
          				return false;
          			}
          			<%
          			}
          			%>
          			
          			} --%>
				function pageLoad(){
					$("#CashCustDetail").show();
					$("#CreditCustDetail").hide(); 
				}
				function type(){
					var type=document.getElementById("type").value;
					if(type == item){
				function openItem() {
					$("#CashCustDetail").show();
					$("#CreditCustDetail").hide();
					location.reload();
				}
				}
			  else{
				function openDrink() {
					$("#CreditCustDetail").show();
					$("#CashCustDetail").hide();
				}
			  }
				}
           </script>    

          <%-- <script type="text/javascript">	
			 
			function checkForDuplicateSubCategoryEntry(){
					<%
					SubCategoryDao dao2 = new SubCategoryDao();
					List list1 = dao2.getSubCategoryName();
					%>
					
					<%
					int x = 0;
					for(x=0;x<list1.size();x++){
						SubCategoryBean bean = (SubCategoryBean)list1.get(x);
					%>
					var subCat = "<%=bean.getSubCategoryName()%>";
					var cat = "<%=bean.getCategoryName()%>";
					var subcatName=document.getElementById("subCategoryName").value;
					var catName=document.getElementById("fkCatID").value;
			
					if(subcatName == subCat && cat == catName){
						alert("subcategory already exist...Duplicate Not allowed");
						location.reload();
						return false;
					}
					<%
					}
					%>
					
					}
			</script> --%>
<!-- 			    <script type="text/javascript">
							  function checkForSaleBuyPrice() {
								 
								 var buyPrice= document.getElementById('buy_price_drink').value;
								 var salePrice= document.getElementById('sale_price1').value;
								 
								 if(buyPrice == salePrice){
									 alert("Buy Price and sale price is same !!!")
									return true;
								 }
								 else if(buyPrice < salePrice)
								 {
									 alert("buy price should be less than sale price !! ");
									 location.reload();
									 return false;
								 }
								 
							} 
							
						</script>
 -->
                       <script type="text/javascript">
							 function editItemEntry() {
									 window.location = "editItemEntry.jsp";
							}
							function itemEntryList(){
								 window.location = "listforitems.jsp";
							}
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
	
	.display-date {
	 	float: right; 
	 	margin-right: 50px; 
	 	margin-top: 10px; 
	 	color: #fff;
	 }
	
	.form-background {
		/* background: #0B1218;
    	position: relative;
    	padding: 20px; */
    	
    	top: 20px;
    	
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
		background: none;
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
	.form-group select:focus ~ label,
	.form-group select:valid ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.ibutton input[type="button"]{
		width: 120px;
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

</head>
<body >
	<div id="start"> 
    	<div class="row">
			<div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
				<div class="heading">	
					<h2 align="center" class="form-heading"><b>Add Menu</b></h2>
				</div>
			</div>
		</div>
		<div class="form-background">
			<div class="row">
				<div class="display-date">
					<div id="date">
						<label id="demo"></label>
						<script>
							var date = new Date();
					 	    document.getElementById("demo").innerHTML = date.toDateString();
						</script>
					</div>
				</div>
			</div>
			<form  action="#" method="post" name="item" class="form-horizontal" > 
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up"> 
								<input type="text" id="itemName"  required />
								<span></span>
								<label>Item Name <sup>*</sup> </label>
							</div> 
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="">
								<select id="type" onchange="type()">
				    				<option class="op-bg" hidden>Select Type</option> 
									<option value="item" class="op-bg">Item</option>
									<option value="drink" class="op-bg">Drink</option>
								</select>
								<span></span>
								<label>Type</label> 
							</div>
						</div>
					</div>
				</div>	
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="sale_price1" required  />
								<span></span>
								<label >Sale Price <sup>*</sup> </label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="buy_price_drink" required onchange="checkForSaleBuyPrice()"/>
								<span></span>
								<label>Buy Price </label>
							</div>
						</div>
					</div>
				</div>
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">			
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="">
								<select id="unit"> 
									<option class="op-bg" hidden>Select Unit</option>
									<option value="ml" class="op-bg">ml</option>
									<option value="liter" class="op-bg">liter</option>
									<option value="gram" class="op-bg">gram</option>
									<option value="kilogram" class="op-bg">kilogram</option>
									<option value="plate" class="op-bg">plate</option>
									<option value="piece" class="op-bg">piece</option>
									<option value="small" class="op-bg">small</option>
									<option value="regular" class="op-bg">regular</option>
								</select>
								<span></span>
								<label >Unit</label>
							</div>	
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="value" required />
								<span></span>
								<label>Unit Value</label>
							</div> 
						</div>
					</div>	
				</div>						
				<div class="ibutton"  style="margin-bottom:50px">
					<div class="row" align="center">	
						<i class="las la-save la-2x cust"></i>	
						<input  type="button" class="btn btn-lg btn-success btn-md" name="btn" value="Save" onclick="itemEntry()" /> 
						<i class="las la-eraser la-2x cust"></i>
						<input type="button" class="btn btn-lg btn-danger btn-md" value="Clear" onclick="reset()" />
						<i class="las la-edit la-2x cust"></i>
						<input type="button" value="Edit"  class="btn btn-lg btn-primary btn-md" onclick="editItemEntry()" /> 
						<i class="las la-clipboard-list la-2x cust"></i>
						<input  type="button" value="List"  class="btn btn-lg btn-warning btn-md" onclick="itemEntryList()" />
 					 </div>
				 </div> 
			</form>
		</div>
	</div>
</body>
</html>
<%@include file="common/newFooter.jsp"%>
