<%@page import="com.rms.dao.ItemDetailsDao" %>
<%@page import="com.rms.dao.ItemEntryDao"%>
 <%@ page import="com.rms.dao.StockDao"%>
<%@page import="com.rms.hibernate.Stock" %>

<%@page import="java.util.List"%>


<%@include file="common/header.jsp"%>

	<title>Total Stock</title>
<head>
<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
		<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/style.css">
		
		<script type="text/javascript" src="/RMS/staticContent/js/selectjj.js"></script>
		<script src="/RMS/staticContent/js/jquery.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.dataTables.js" type="text/javascript"></script>
		<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
		<link href="/RMS/staticContent/css/dataTa.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/RMS/staticContent/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css" media="all">
		<link href="/RMS/staticContent/css/select.css" rel="stylesheet" type="text/css" media="all">

		<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
		<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
		<script src="/RMS/staticContent/js/addWaiterReport.js"></script>
	<script type="text/javascript">
	 function Back() {
			 window.location = "itemEntry.jsp";
	}

	 
 </script>
		
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
			<h2 align="center" class="form-heading"><b>Total Stock</b></h2>
		</div>


<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
<div id="date" align="right">
		<label id="demo">Date : </label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div>
<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
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
		<div class="container">
			<div class="table-responsive">
		
					<table id="list" class="display" align="center" border="1" style="margin-bottom: 25px">
					<thead>
						<tr>
							<th>Sr No</th>
							<th>Item Name</th>
							<th>Unit Value</th>
							<th>Unit</th>
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
						<td class-"align"><%=st.getValue()%></td>
						<td class="align"><%=st.getUnit()%></td>
						<td class="align"><%=st.getStock()%></td>
		
						</tr>
					</tbody>
					<%
						}
					%>

				</table>
			</div>
			</div>
			<!-- <br>
		 <div align="center" style="margin-bottom: 50px"> 
	<input type="button" style="height: 65px; width: 10%; font-size: 25;" value="Back" id="listBtn" class="btn btn-lg btn btn-primary btn btn-primary" onclick="Back()"/>
		
	</div> -->

</body>
</html>
<%@include file="common/newFooter.jsp"%>