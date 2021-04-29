<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.SupplierDetailsHibernate"%>
<%@page import="com.rms.dao.SupplierDetailsDao"%>
<%@page import= "java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% boolean isHome = false; %>   
<%@include file="common/header.jsp"%>
<head>

	<title>Purchase Good</title>

	<script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
	<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">

	<script src="/RMS/staticContent/js/bootstrap.min.js"></script>

	<script src="/RMS/staticContent/js/bootstrap.js"></script>

	<script src="/RMS/staticContent/js/bootbox.js"></script>
	<script src="/RMS/staticContent/js/bootbox.min.js"></script>
	<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

	<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
     
    <link rel="stylesheet" href="/RMS/staticContent/y_css/jquery-ui.css">
  	<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
    <!-- <script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script> -->
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
	
	
		
	<script src="/RMS/staticContent/js/goodsReceive.js"></script>

     <script type="text/javascript">
	      function goodsReceiveList(){
		  window.location = "listofgoods_receive.jsp";
	    							 }
	      function reloadPage(){
	    	  location.reload();
		     }
     </script>
<script>
<% 
String pattern = "yyyy-MM-dd";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String todayDate = simpleDateFormat.format(new Date());

System.out.println("today's date in purchase good - "+todayDate);
%>
</script>
</head>
<body>
<div class="row">
	 <div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<!--<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<h2 align="center" class="form-heading"><b>Purchase Good</b></h2>
			</div>
			<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
			<div class="form-group" align="right">
					<div id="date">
						<label id="demo"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
				</div>
			</div>
			<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
		</div> -->
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading"><b>Purchase Good</b></h2>
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

		
	<form action="" method="post" name="goodReceive"  class="form-horizontal">
	<div class="item">
     <div class="row form-group"> 
      <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">

							<%
							SupplierDetailsDao sdd = new SupplierDetailsDao();
							List sList = sdd.getAllSupplierName(request);
							%>

							<input list="suplierName" id="fk_supplier_id" autofocus="fk_supplier_id"  class="form-control" required>
							<datalist id="suplierName">
								<%
							 for (int i = 0; i < sList.size(); i++) {
 	                         SupplierDetailsHibernate sup = (SupplierDetailsHibernate) sList.get(i);
                             %>
								<option data-value="<%=sup.getPkSupplierDetailId()%>"
									value="<%=sup.getSuplierName()%>">

									<%
									}
								%>
								
							</datalist>
							<label>Supplier Name:<sup>*</sup></label>
						</div>
					</div>

					<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						 <input type="text" id='billno' name="billno" class="form-control" required />
						<label>Bill No: <sup>*</sup></label>
						</div>
					</div>
				</div>
			</div>

			<div class="row form-group"> 
      <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<%
						ItemEntryDao itemEntryDao1 = new ItemEntryDao();
						List iList1= itemEntryDao1.getAllItemEntries1(request);
						%>

							<input list="fk_item_id_drop1" id="fk_item_id1" autofocus="fk_item_id1"  class="form-control" onchange="getGridForGoodReceive()" required />
							<datalist id="fk_item_id_drop1">

						<%
					    for(int j=0;j<iList1.size();j++){
						ItemEntry itemEntry = (ItemEntry)iList1.get(j);
				        %>
								<option data-value="<%=itemEntry.getPk_item_entry_Id()%>"
									value="<%=itemEntry.getItemName() %> - <%=itemEntry.getValue()%> <%=itemEntry.getUnit()%>">
									<%
					     }
				         %>
							</datalist>
							<label>Item Name:</label>
						</div>
					</div>
					
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
			<input type="date" id='goodsReceiveDate' name="goodsReceiveDate"
								class="form-control" value="<%=todayDate %>"/>
									<label>Purchase Date:<sup>*</sup></label>
						</div>
					</div>
					
					
				</div>
			</div>
	
	<div class="row">
		<div class="">
			<div class="table-responsive">
				<table id="list4"></table>
				<div id="jqGridPager"></div>
			</div>
		</div>
	</div>
	<div class="row form-group"></div>	
  <div class="row form-group"> 
    <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
					<input readonly="readonly" id="grossTotal" name="grossTotal" class="form-control input-md" type="text" style="font-size: 25px; height: 55px;" required>
					<label  for="grossTotal">Gross Total</label>
					</div>
				</div>
			</div>
	</div>
</div>

			
				<!-- <input style="  height: 65px; width: 180; font-size: 25"  type="button" id="save" class="btn btn-large btn-success glyphicon glyphicon-save  button-height-width" name="btn" value="Save" onclick="addGoodsReceive()" /> 
					<input style="height: 48px; width: 180; font-size: 25" type="reset" class="btn btn-large btn-danger glyphicon glyphicon-remove-circle  button-height-width" 	value="Clear" onclick="reloadPage()" />
				 <input style=" height: 65px; width: 180; font-size: 25" type="button" value="Edit" id="listBtn" class="btn btn-lg btn-primary btn btn-primary" onclick="editItemEntry()" />
				<input style="height: 48px; width: 180; font-size: 25" type="button" value="List" id="listBtn" class=" btn btn-lg btn-primary btn btn-primary" onclick="goodsReceiveList()" /> -->
	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">			
				<input  type="button"  id="save" name="btn" value="Save" class="btn btn-lg btn-success" onclick="addGoodsReceive()" /> 
             
             	<input class="btn btn-lg btn-danger" type="reset"  name="btn" value="Clear" onclick="reloadPage()" /> 
           	
            	<input  type="button" value="List" id="listBtn" class="btn btn-lg btn-primary" onclick="goodsReceiveList()" /> 
			</div>               
		</div>

			<!-- <div class="row buttons_margin_top">
				<div align="center">
					<input type="button" class="btn btn-lg btn-success btn-lg btn-md button_hw button_margin_right" name="btn" value="Save" onclick="addGoodsReceive()" style=" height: 65px; width: 180; font-size: 25"/>
					<input type="reset" class="btn btn-lg btn-danger btn-lg btn-md button_hw button_margin_right" onclick="reloadPage()" value="Clear" style=" height: 65px; width: 180; font-size: 25"/>
				</div>
			</div> -->
		</form>
	</div>

	<%@include file="common/newFooter.jsp"%>