<%@ page import="com.rms.dao.TempItemDetailDao"%>
<%@page import="com.rms.bean.OrderBillReportDateWiseBean" %>
<%@page import="java.util.List" %>
<%@include file="common/header.jsp"%>
<%@page import="com.rms.hibernate.CustomerOrder" %>
<%@page import="com.rms.dao.CustomerOrderDao" %>
	<title>Day Closure</title>
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
<%-- <script type="text/javascript">
	function gettotalsale(){
		<%
		CustomerOrderDao dao1 = new CustomerOrderDao();
		List list2 = dao1.getallsale(request);
		%>
		
		 <%
	
		for(int x=0; x<list2.size(); x++){
			CustomerOrder bean = (CustomerOrder)list2.get(x);
		%>
		
		var totall = "<%=bean.getGridTotal()%>";
		 document.getElementById("tota").value=totall;
	
		}
		<%
		}
		%>
		
		
	</script> --%>
</head>
<body>
<div class="row">
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				
<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading" ><b>Day Closure Report</b></h2>
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
		
			<%
			TempItemDetailDao addwait = new TempItemDetailDao();
				List list = addwait.gettodaysReport(request);
			%>

		<div class="row">
			<div class="col-md-12">
				<!-- <hr style="border-top-color: #c1b1b1;"> -->
			</div>
		</div>
			<div class="container">
			<div class="table-responsive">
		
					<table id="list" class="display" align="center" border="1">
					<thead>
						<tr>

							<th>Item Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Unit Value</th>
							<th>Unit</th>
							<th>Total</th>
					

						</tr>
					</thead>
					<tbody>
					<% 
						for(int i=0; i<list.size(); i++ )
						{
							OrderBillReportDateWiseBean ad = (OrderBillReportDateWiseBean)list.get(i);
						
					%>
					<tr>
					<td class="align"><%=ad.getItemName() %></td>
					<td class="align"><%=ad.getQuantity() %></td>
					<td class="align"><%=ad.getUnitPrice() %></td>
					<td class="align"><%=ad.getValue()%></td>
					<td class="align"><%=ad.getUnit()%></td>
					<td class="align"><%=ad.getTotalAmt()%></td>
				
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
<%@include file="common/newFooter.jsp"%>