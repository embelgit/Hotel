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
			
			<link rel="stylesheet" href="/RMS/staticContent/css/style.css">
			
					<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>	
			  <script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui-min.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
			<script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
									
          
		<!-- 	<link href="/RMS/staticContent/css/style.css" rel="stylesheet"> -->
		
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



</head>
<body ><!-- onload="pageLoad()"> -->

	<!-- <form class="form-horizontal" name="itemEntryFormName"> -->
       <div class="row">
	
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading"><b>Add Menu</b></h2>
			</div>
				<hr>
		</div>
	
		</div>
		<div class="row">
		<!-- <div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"> -->
		
			<div class="form-group" align="right" style="margin-right: 331px;">
					<div id="date">
						<label id="demo"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
			<!-- 	</div> -->
			</div>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		</div>
		<form  action="#" method="post" name="item" class="form-horizontal" > 
		<div class="item">
	<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<input type="text" class="form-control" id="itemName"  required />
					<label>Item Name : <sup>*</sup> </label>
				</div>
			</div>
		
<!-- onblur="checkForItemDuplicate();  " -->

			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
					<select class="form-control" id="type" onchange="type()">
					 <option>Select Type</option> 
						<option value="item">Item</option>
						<option value="drink">Drink</option>
					</select>
					<label>Type: </label>
				</div>
			</div>
		</div>
	</div>	
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<input type="text" class="form-control" id="sale_price1"
								 required  />
								<label >Sale Price : <sup>*</sup> </label>
						</div>
					</div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
							<input type="text" class="form-control" id="buy_price_drink"
								 required onchange="checkForSaleBuyPrice()"/>
								<label class="control-label">Buy Price : </label>
						</div>
						<!-- onblur="checkForSaleBuyPrice()"  -->
						</div>
					</div>
</div>
					<!-- <div class="row margin-t-13">
						<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
							<label class="control-label">Buy Price:<sup>*</sup> </label>
						</div>
						<div class="col-md-2 col-sm-3">
							<input type="text" class="form-control" id="buy_price_drink"
								placeholder="Buy Price" required autofocus
								onblur="checkForSaleBuyPrice()" />
						</div>
					</div> -->


<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
 							<select class="form-control" id="unit"> 
 								<option>Select Unit</option>
								<option value="ml">ml</option>
								<option value="litre">litre</option>
								<option value="gram">gram</option>
								<option value="kilogram">kilogram</option>
								<option value="plate">plate</option>
								<option value="piece">piece</option>
								<option value="small">small</option>
								<option value="regular">regular</option>
								</select>
								<label >Unit : </label>
						</div>
						</div>
						
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="value" required />
						<label>Unit Value : </label>
				</div> 
		</div>
	</div>	
</div>				
					<!-- <div class="row margin-t-13">
						<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
							<label class="control-label">Gram : </label>
						</div>
						<div class="col-md-2 col-sm-3">
							<input type="text" class="form-control" id="gram"
								placeholder="Gram"/>
						</div>
						</div> -->	
						
			</div>			

				<!--  <input  type="button"  onclick="itemEntry()"  value="Save" name="btn" class="btn btn-success" >  -->
	<div class="ibutton">
	<div class="row" align="center">		
	<input  type="button" class="btn btn-lg btn-success btn-md " name="btn" value="Save" onclick="itemEntry()" /> 

	<input type="button" class="btn btn-lg btn-danger btn-md" value="Clear" onclick="reset()" /> 

	<input type="button" value="Edit"  class="btn btn-lg btn-primary btn-md" onclick="editItemEntry()" /> 

	<input  type="button" value="List"  class=" btn btn-lg btn-primary btn-md" onclick="itemEntryList()" />
  </div>
 </div> 


			<!--  <div class="row buttons_margin_top">
	  <div align="center">
		  <input type="button" style=" height: 65px; width: 180; font-size: 25" class="btn btn-lg btn-success btn-md button_hw button_margin_right"
						name="btn" value="Save" onclick="itemEntry()"/>
	     <input type="reset" style=" height: 65px; width: 180; font-size: 25" class="btn btn-lg btn-danger btn-md button_hw button_margin_right"
					    value="Clear"  onclick="reloadPage()"/>
	 </div>
	</div> -->
	</form>
	
</body>
</html>
<%@include file="common/newFooter.jsp"%>
