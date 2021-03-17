<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.helper.ItemEntryHelper"%>

    <% boolean isHome=false;%>
	<%@include file="common/header.jsp"%>
	
		<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
        
         <script src="/RMS/staticContent/shree/jquery.dataTables.min.js" type="text/javascript"></script>
         <script src="/RMS/staticContent/shree/dataTables.buttons.min.js" type="text/javascript"></script>
         <script src="/RMS/staticContent/shree/buttons.flash.min.js" type="text/javascript"></script>
         <script src="/RMS/staticContent/shree/jszip.min.js" type="text/javascript"></script>
         <script src="/RMS/staticContent/shree/pdfmake.min.js" type="text/javascript"></script>
         <script src="/RMS/staticContent/shree/vfs_fonts.js" type="text/javascript"></script>
         <script src="/RMS/staticContent/shree/buttons.html5.min.js" type="text/javascript"></script>
         <script src="/RMS/staticContent/shree/buttons.print.min.js" type="text/javascript"></script>
         <link href="/RMS/staticContent/y_css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" media="all" />
         <link href="/RMS/staticContent/y_css/buttons.dataTables.min.css" rel="stylesheet" type="text/css" media="all">
         <link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
         <script src="/RMS/staticContent/js/bootstrap.min.js"></script>
         <script src="/RMS/staticContent/js/bootstrap.js"></script>
         <link rel="stylesheet" href="/RMS/staticContent/css/style.css">
        
		<script src="/RMS/staticContent/js/drinkWiseReport.js"></script>
	
	<script>
	     $(document).ready(function(){
	    	 getDrinkwiseReport();
	}); 
	</script>
	
	<body id="dt_example" class="master_form_img">
	    <div class="container-fluid">

		<div class="row header_margin_top" style="margin-top: 60px;">
			<div align="center">
				<h2 class="form-name style_heading">Stock Entry Report Drink Wise</h2>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group" align="right">
				<div class="col-sm-offset-8 col-md-4 control-label">
					<div id="date">
						<label id="demo"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

			<!-- <div id="demo_jui"> -->
			
			<form class="form-horizontal">

			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
						<label class="control-label">Drink Name:</label>

						<%
						ItemEntryDao itemEntryDao1 = new ItemEntryDao();
						List iList1= itemEntryDao1.getAllItemEntries1(request);
						%>
					</div>
					<div class="col-md-2 col-sm-3">
						<input list="fk_item_id_drop1" id="fk_item_id1" class="form-control">
				         <datalist id="fk_item_id_drop1">
				
				         <%
					       for(int j=0;j<iList1.size();j++){
				   		    ItemEntry itemEntry = (ItemEntry)iList1.get(j);
				         %>
				
					<option data-value="<%=itemEntry.getPk_item_entry_Id()%>" value="<%=itemEntry.getItemName() %>">
				<%
					}
				%>
				</datalist>
					</div>
				

				<div class="col-md-offset-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getDrinkwiseReport()" value="Search" />
				</div>
			</div>
		</div>
			
			<div class="table-responsive">
					<table id="catName" class="display" style=" border: 2px solid black;border-collapse: collapse;">
						    <thead>
								<tr>
									<th>Sr No</th>
									<th>Drink Name</th>
									<th>Sale Price</th>
									<th>Buy Price</th>
									<th>Unit in ml</th>

								</tr>
							</thead>
						</table>
					</div>
 
               </form>
		</div>
</body>
</html>
		
		