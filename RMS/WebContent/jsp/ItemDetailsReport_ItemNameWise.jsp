 <%@page import="com.rms.dao.ItemDetailsDao" %>
<%@page import="com.rms.dao.ItemEntryDao"%>
 <%@ page import="com.rms.dao.StockDao"%>
<%@page import="com.rms.hibernate.Stock" %>
<%@page import="java.util.List" %>
<%@include file="common/header.jsp"%>
<title> Stock Report</title>
<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
		<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/style.css">
		
		<script type="text/javascript" src="/RMS/staticContent/js/selectjj.js"></script>
		<!-- <script type="text/javascript" src="/RMS/staticContent/js/buttom.js"></script> -->
		<script src="/RMS/staticContent/js/jquery.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.dataTables.js" type="text/javascript"></script>
		<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
		

		
		
		<link href="/RMS/staticContent/css/dataTa.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/RMS/staticContent/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css" media="all">
		<link href="/RMS/staticContent/css/select.css" rel="stylesheet" type="text/css" media="all">
	<!-- 	<link href="/RMS/staticContent/css/button.css" rel="stylesheet" type="text/css" media="all"> -->
		<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
		<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
		
	<script src="/RMS/staticContent/js/addWaiterReport.js"></script>
 	<script type="text/javascript"> 
		$(document).ready(function () {
	         var table=$("#list").dataTable();
			 var tableTools = new $.fn.dataTable.TableTools(table, {
				 'sSwfPath':'//cdn.datatables.net/tabletools/2.2.4/swf/copy_csv_xls_pdf.swf',
				 	'aButtons':['copy','print','csv',{
					 'sExtends':'xls',
					 'sFileName':'Data.xls',
					 'sButtonText': 'Save to Excel'
						}
					]
				});
					$(tableTools.fnContainer()).insertBefore('#list_wrapper');
			});
	</script>  
	
	
	<div class="row">
		<div align="center">
			<h2 class="form-name style_heading">Low Stock Report</h2>
		</div>

		<!-- <div class="row">
			<div class="col-sm-offset-1 col-md-10">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div> -->
	</div>
<div id="date" align="right" style="margin-right: 20px">
		<label id="demo">Date : </label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div>
	
		<%
		ItemDetailsDao dao = new ItemDetailsDao();
		List ilist = dao.getItemNamewiseReport(request);
		
		%>
	
	
	<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>
		
			<div class="table-responsive">
		
					<table id="list" class="display" align="center" border="2">
					<thead>
						<tr>

							<th>Sr No</th>
							<th>Item Name</th>
							<th>Total Stock</th>
				
						</tr>
					</thead>
					<tbody>
					<% 
					for(int k=0; k<ilist.size(); k++){
						Stock st  = (Stock)ilist.get(k);
						
					%>
						<tr>
						<td class="align"><%=st.getSrNo()%></td>
										<td class="align"><%=st.getItemName()%></td>
										<td class="align"><%=st.getStock()%></td>
	
					</tr>
					</tbody>
					<%
						}
					%>

				</table>
		
		</div>
 
 
 
 <!--    ============================== old code for total stock  -->
 
 
 
 <%-- <%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.helper.ItemEntryHelper"%>
<%@page import="com.rms.dao.ItemDetailsDao"%>
<%@page import="com.rms.hibernate.Stock" %>
<% boolean isHome=false;%>
<%@include file="common/header.jsp"%> 
<title>Item Details Report Item Name wise</title>
	<!-- 	<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
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
		
		<script src="/RMS/staticContent/js/itemNameWiseReport.js"></script>
	 -->	
	<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
		<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/style.css">
		
		<script type="text/javascript" src="/RMS/staticContent/js/selectjj.js"></script>
		<!-- <script type="text/javascript" src="/RMS/staticContent/js/buttom.js"></script> -->
		<script src="/RMS/staticContent/js/jquery.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.dataTables.js" type="text/javascript"></script>
		<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
		<link href="/RMS/staticContent/css/dataTa.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/RMS/staticContent/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css" media="all">
		<link href="/RMS/staticContent/css/select.css" rel="stylesheet" type="text/css" media="all">
	<!-- 	<link href="/RMS/staticContent/css/button.css" rel="stylesheet" type="text/css" media="all"> -->
		<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
		<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">	
		
	<script type="text/javascript"> 
		$(document).ready(function () {
	         var table=$("#list").dataTable();
			 var tableTools = new $.fn.dataTable.TableTools(table, {
				 'sSwfPath':'//cdn.datatables.net/tabletools/2.2.4/swf/copy_csv_xls_pdf.swf',
				 	'aButtons':['copy','print','csv',{
					 'sExtends':'xls',
					 'sFileName':'Data.xls',
					 'sButtonText': 'Save to Excel'
						}
					]
				});
					$(tableTools.fnContainer()).insertBefore('#list_wrapper');
			});
	</script>  
<!-- <script>
	     $(document).ready(function(){
	    	 getItemNamewiseReport();
	}); 
	</script> -->


<!-- <body id="dt_example" class="master_form_img">
	<div class="container-fluid">
 -->
		<div class="row header_margin_top" style="margin-top: 10px;">
			<div align="center">
				<h2 class="form-name style_heading">Stock Entry Report Item Name Wise</h2>
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

			<%
					ItemDetailsDao dao = new ItemDetailsDao();
					List ilist = dao.getItemNamewiseReport();
			%>
	
		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

		<!-- <div id="demo_jui"> -->

		<form action="#" method="post" name="StockItemDetails" class="form-horizontal">

			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
						<label class="control-label">Item Name:<sup>*</sup></label>

						<%
							ItemEntryDao itemEntryDao = new ItemEntryDao();
							List iList = itemEntryDao.getAllItemEntriesForOrderBill();
						%>
					</div>
					<div class="col-md-2 col-sm-3">
						<input list="fk_item_id_drop" id="fk_item_id" class="form-control" autofocus="autofocus">
						<datalist id="fk_item_id_drop">

							<%
								for (int i = 0; i < iList.size(); i++) {
									ItemEntry itemEntry = (ItemEntry) iList.get(i);
							%>

							<option data-value="<%=itemEntry.getPk_item_entry_Id()%>"
								value="<%=itemEntry.getItemName()%>">
								<%
									}
								%>
							
						</datalist>
					</div>

					<div class="col-md-offset-2">
						<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_left" onclick="getItemNamewiseReport()" value="Search" />
					</div>
				</div>
			</div>


			<div class="table-responsive">
				<table id="catName" class="display" style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
							<th>Sr No</th>
							<th>Item Name</th>
							<th>Total Stock</th>
						</tr>
					</thead>
					<tbody>
							<%
									for(int k=0; k<ilist.size(); k++){
									Stock st  = (Stock)ilist.get(k);
							%>
							<tr>
										<td class="align"><%=st.getItem_details_id()%></td>
										<td class="align"><%=st.getItemName()%></td>
										<td class="align"><%=st.getStock()%></td>
							</tr>
					<% } %>
					</tbody>
				</table>
			</div> --%>

		<%-- </form>
	</div>
</body>
</html>
 <%@include file="common/newFooter.jsp"%>  --%>

 
 
 