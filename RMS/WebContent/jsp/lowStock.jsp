<%@ page import="com.rms.dao.StockDao"%>
<%@page import="com.rms.hibernate.Stock" %>
<%@page import="java.util.List" %>
<%@include file="common/header.jsp"%>
<title>Low Stock Report</title>
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
	</head>
	<body>
	
	<div class="row">
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<h2 align="center" class="form-heading"><b>Low Stock Report</b></h2>
		</div>

		<!-- <div class="row">
			<div class="col-sm-offset-1 col-md-10">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div> -->
	<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
<div id="date" align="right" style="margin-right: 20px">
		<label id="demo">Date : </label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div></div>
<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
</div>
	
		<%
				StockDao dao = new StockDao();
				List list = dao.getlowStock(request);
		
		%>
	
	
	<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>
	<div class="container">
			<div class="table-responsive">
		
					<table id="list" class="display" align="center" border="2">
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
	</body>
	</html>