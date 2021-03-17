<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.hotelnamebean" %>
<%@page import="com.rms.dao.hotelnamedao"%>
<%@page import="java.text.ParseException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% boolean isHome = false; %>   
<%@include file="common/header.jsp"%>
<head>

	<title>Transfer Stock</title>

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
	
	
		
	<script src="/RMS/staticContent/js/transferstock.js"></script>

     <script type="text/javascript">
	      function transferStockList(){
		  window.location = "listoftransfer_stock.jsp";
	    							 }
	      function reloadPage(){
	    	  location.reload();
		     }
     </script>
<script>

</script>
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<h2 align="center" class="form-heading"><b>Transfer Stock</b></h2>
			</div>
			
			<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
		</div>

		
	<form action="" method="post" name="transferStock"  class="form-horizontal">
	<div class="item">
     <div class="row form-group"> 
      <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">

							<%
							hotelnamedao sdd = new hotelnamedao();
							List sList = sdd.gethotelname(request);
							%>

							<input list="hotelName" id="hotelid" autofocus="hotelid"  class="form-control" required>
							<datalist id="hotelName">
								<%
							 for (int i = 0; i < sList.size(); i++) {
 	                         hotelnamebean hotel = (hotelnamebean) sList.get(i);
                             %>
								<option data-value="<%=hotel.getHotelid()%>"
									value="<%=hotel.getHotelname()%>">

									<%
									}
								%>
								
							</datalist>
							<label>Shop Name:<sup>*</sup></label>
						</div>
					</div>

					<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
					<div class="invoice_label_up">
						<%
						ItemEntryDao itemEntryDao1 = new ItemEntryDao();
						List iList1= itemEntryDao1.getAllItemEntries1(request);
						%>

							<input list="fk_item_id_drop1" id="fk_item_id1" autofocus="fk_item_id1"  class="form-control" onchange="getGridForTransferStock()" required />
							<datalist id="fk_item_id_drop1" required>

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
							<label>Item Name:<sup>*</sup></label>
						</div>
					</div>
		
					</div>
				</div>
			</div>

			
	
	<div class="row">
		<div class="">
			<div class="table-responsive" style="margin-left: 175px;">
				<table id="list4"></table>
				<div id="jqGridPager"></div>
			</div>
		</div>
	</div>
	
  
</div>

			
				<!-- <input style="  height: 65px; width: 180; font-size: 25"  type="button" id="save" class="btn btn-large btn-success glyphicon glyphicon-save  button-height-width" name="btn" value="Save" onclick="addGoodsReceive1()" /> 
					<input style="height: 48px; width: 180; font-size: 25" type="reset" class="btn btn-large btn-danger glyphicon glyphicon-remove-circle  button-height-width" 	value="Clear" onclick="reloadPage()" />
				 <input style=" height: 65px; width: 180; font-size: 25" type="button" value="Edit" id="listBtn" class="btn btn-lg btn-primary btn btn-primary" onclick="editItemEntry()" />
				<input style="height: 48px; width: 180; font-size: 25" type="button" value="List" id="listBtn" class=" btn btn-lg btn-primary btn btn-primary" onclick="goodsReceiveList()" /> -->
	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">			
				<input  type="button"  id="save" name="btn" value="save" class="btn btn-lg btn-success" onclick="addTrasferStock()" /> 
             
             	<input class="btn btn-lg btn-danger" type="reset"  name="btn" value="Clear" onclick="reloadPage()" /> 
           	
            	<input  type="button" value="List" id="listBtn" class="btn btn-lg btn-primary" onclick="transferStockList()" /> 
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