<%@page import="com.rms.dao.AddWaitersDao"%>
<%@page import="com.rms.dao.CustomerOrderDao"%>
<%@page import="com.rms.hibernate.CustomerOrder"%>
<%@ page import="com.rms.dao.StockDao"%>
<%@page import="com.rms.hibernate.AddWaiters" %>
<%@page import="com.rms.bean.AddWaitersList" %>
<%@page import="com.rms.hibernate.Stock" %>
<%@page import="java.util.List" %>
<%@include file="common/header.jsp"%>

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
		
	<script src="/RMS/staticContent/js/attendedWaiter.js"></script>
 	
 <!-- 	<script type="text/javascript"> 
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
	</script>   -->
	
	
	<div class="row">
		<div align="center">
			<h2 class="form-name style_heading">Waiter Attended Report</h2>
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
	
		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

		<form action="#" method="post" name="attendedWaiterreport" class="form-horizontal">
			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
						<label class="control-label">Waiter Name:<sup>*</sup></label>

						<%
							AddWaitersDao itemEntryDao = new AddWaitersDao();
							List iList = itemEntryDao.getAllwaiterName(request);
						%>
					</div>
					<div class="col-md-2 col-sm-3">
						<input list="fk_item_id_drop" id="fk_item_id" class="form-control" autofocus="autofocus">
						<datalist id="fk_item_id_drop">

							<%
								for (int i = 0; i < iList.size(); i++) {
									AddWaiters cust = (AddWaiters) iList.get(i);
							%>

							<option data-value="<%=cust.getPkAddWaiterId()%>"
								value="<%=cust.getFirstName()%> <%=cust.getLastName()%>">
								<%
									}
								%>
							
						</datalist>
					</div>
			<!-- </div> -->
			
					<div class="col-md-offset-2">
						<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_left" onclick="getattendedwaiterReport()" value="Search" />
					</div>
			</div>
				</div>
			
			</form>
			</div>
			

 			<div class="table-responsive">
					<table id="catName" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Bill No</th>
							<th>Table No</th>
							<th>Item Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Total</th>

						</tr>
					</thead>
					 <tfoot>
			<tr>
				<th colspan="4" style="text-align: right">Total:</th>
				<th></th>
				
				<th></th>
			</tr>
			</tfoot>
				
				</table>
			</div>
			
	</div>
	</body>
	</html>
	 <%@include file="common/newFooter.jsp"%> 