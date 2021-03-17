<%@page import="java.util.List"%>
<%@page import="com.rms.dao.SupplierDetailDao"%>
<%@page import="com.rms.bean.SupplierListBean"%>

<% boolean isHome=false;%>
<%@include file="common/header.jsp"%>

<div class="container">
	<h2 class="form-name-report">Supplier Detail List</h2>
</div>

<html>
<head>
<!-- For datatable to pdf,print,excel etc conversion -->
<script type="text/javascript"
	src="/RMS/staticContent/jsForReport/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/jsForReport/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/jsForReport/dataTables.buttons.min.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/jsForReport/buttons.flash.min.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/jsForReport/jszip.min.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/jsForReport/pdfmake.min.js"></script>

<script type="text/javascript"
	src="/RMS/staticContent/jsForReport/vfs_fonts.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/jsForReport/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/jsForReport/buttons.print.min.js"></script>
<link rel="stylesheet"
	href="/RMS/staticContent/cssForReport/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="/RMS/staticContent/cssForReport/buttons.dataTables.min.css">

<script type="text/javascript"
	src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
<script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/js/jquery-ui-min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
<script type="text/javascript"
	src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/bootstrap.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/style.css">
</head>

<div id="report">
	<label id="demo"></label>
	<script>
		   var date = new Date();
		   document.getElementById("demo").innerHTML = date.toDateString();;
		</script>
</div>

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

<body id="dt_example">
	<%
	    SupplierDetailDao dao=new SupplierDetailDao();
		List lis2=dao.getAllMAinSupp();
	%>
	<div id="demo_jui">
		<table id="list" class="display" border="1">
			<thead>
				<tr>
					<th>Supplier ID</th>
					<th>Supplier Name</th>
					<th>Address</th>

					<!-- 	<th>Email</th>
						
						<th>Pan No</th> -->

					<th>Tin No</th>
					<th>City</th>

				</tr>
			</thead>

			<tbody>
				<%
					for(int i=0;i<lis2.size();i++){
				    SupplierListBean empB=(SupplierListBean)lis2.get(i);
				%>

				<tr>
					<td class="align"><%=empB.getSupplierId()%></td>
					<td class="align"><%=empB.getSupplierName()%></td>
					<td class="align"><%=empB.getAddress()%></td>




					<%-- <td class="align"><%=empB.getEmail()%></td>
					
					<td class="align"><%=empB.getPanNo()%></td>  --%>

					<td class="align"><%=empB.getTinNo()%></td>
					<td class="align"><%=empB.getCity()%></td>

				</tr>

				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>

</html>

<%@include file="common/shortcut.jsp"%>

<%@include file="common/footer.jsp"%>
