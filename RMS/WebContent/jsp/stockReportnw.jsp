<%@page import="com.rms.dao.ItemDetailsDao" %>
<%@page import="com.rms.dao.ItemEntryDao"%>
 <%@ page import="com.rms.dao.StockDao"%>
<%@page import="com.rms.hibernate.Stock" %>
<%@page import="java.util.List" %>
<%@include file="common/header.jsp"%>

<% boolean isHome=false;%>
<%--  <%@include file="common/header.jsp"%>  --%>
<title>Sale Report</title>
<div class="container" align="center" style="margin-top: 10px">
				  		<h2 class="form-name-report">Sale Reports</h2>
				  	</div>

<head>
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
	<script type="text/javascript"> 
		$(document).ready(function () {
	         var table=$("#list1").dataTable();
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

</head>
<br>

 <ul class="nav nav-tabs">
	    <li class="active"><a data-toggle="tab" href="#total"><h4 style="color:blue">Total Stock</h4></a></li>
	     <li><a data-toggle="tab" href="#low"><h4 style="color:blue">Low Stock</h4></a></li>
	  
 	 </ul>
 	 
 	 <div class="tab-content" style="float: left">
 
 	<!-- Total Stock -->
 	 <div id="total" class="tab-pane fade in active">

	<div>
		<%
		ItemDetailsDao dao = new ItemDetailsDao();
		List ilist = dao.getItemNamewiseReport(request);
		
		%>
			
		
	<!-- 		<div class="row">
				<div class="form-group"> -->
				

					
						<div class="table-responsive">
					<table id="list" class="display" style=" border: 2px solid black; border-collapse: collapse;">

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
					</tbody>
					<%
						}
					%>

				</table>
				
				 <!-- <tfoot>
			<tr>
				<th colspan="6" style="text-align: right">Total:</th>
				<th></th>
				
				<th></th>
			</tr>
			</tfoot>  -->
				
				
					</div>
					
					
					
					</div>
					</div>
					
					
 	<div id="low" class="tab-pane">
	<div>		
		<%
				StockDao daoo = new StockDao();
				List list = daoo.getlowStock(request);
		
		%>
							
		
		<!-- 	<div class="row">
				<div class="form-group"> -->
<!-- 					<div class="row" style="padding-top: 20"> -->
				
	<div class="table-responsive">
		
					<table id="list1" class="display" style=" border: 2px solid black; border-collapse: collapse;">												
					<thead>
						<tr>

							<th>Item Name</th>
							<th>Stock</th>
				
						</tr>
					</thead>
					<tbody>
					<% 
						for(int i=0; i<list.size(); i++ ){
							Stock ad = (Stock)list.get(i);
						
					%>
						<tr>
					<td class="align"><%=ad.getItemname() %></td>
					<td class="align"><%=ad.getStock() %></td>
	
					</tr>
					</tbody>
					<%
						}
					%>

				</table>
		
		</div>
					
			 
			</div>
	
</div>

</div>

