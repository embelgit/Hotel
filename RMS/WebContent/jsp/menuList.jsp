<%-- <%@include file="common/header.jsp"%> --%>
<%@page import="com.rms.bean.menuList"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.hibernate.ItemDetails"%>
<%@page import="com.rms.dao.ItemDetailsDao"%>
<%@page import="java.util.List"%>
<% boolean isHome=false;%>
<%@include file="common/header.jsp"%>
<head>		<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
		<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/style.css">
		
		<script type="text/javascript" src="/RMS/staticContent/js/selectjj.js"></script>
		<script type="text/javascript" src="/RMS/staticContent/js/buttom.js"></script>
		<script src="/RMS/staticContent/js/jquery.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.dataTables.js" type="text/javascript"></script>
		<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
		
		<link href="/RMS/WebContent/staticContent/css/dataTa.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/RMS/staticContent/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css" media="all">
		<link href="/RMS/staticContent/css/select.css" rel="stylesheet" type="text/css" media="all">
		<link href="/RMS/staticContent/css/button.css" rel="stylesheet" type="text/css" media="all">
		<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
		<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">



<title>Menu List</title>

<script type="text/javascript">
  			function Back()
  			{
  				window.location = "OrderBill.jsp" ;
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
<body id="dt_example" style="min-height: 300px;">

	<div class="row">
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<h2 align="center" class="form-heading"><b>Menu-Card</b></h2>
		</div>

		
	

	               <%   
						ItemDetailsDao dao = new ItemDetailsDao();
						List list12 = dao.getMenuList(request);
					%>
<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
	<div id="date">
		<label id="demo">Date : </label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div>
</div>

<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
</div>
<div class="row">
			<div class="col-sm-offset-1 col-md-10">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>
		<div class="container">
	<div id="demo_jui">
		<table id="list" class="display" border="1">
			<thead>
				<tr>
					<th>Item Name</th>
					<th>Value</th>
					<th>Unit</th>
					<th>Price</th>
				</tr>
			</thead>

			<tbody>
				<%
					for(int i=0;i<list12.size();i++){
						menuList sr=(menuList)list12.get(i);
				%>

				<tr>
					<td class="align"><%=sr.getItemName()%></td>
					<td class="align"><%=sr.getValue()%></td>
						<td class="align"><%=sr.getUnit()%></td>
					<td class="align"><%=sr.getSale_price()%></td>
				</tr>

				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>

	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">
		<input  type="button" class="btn btn-lg btn-primary btn-md button_hw button_margin_right" value="Back" id="listBtn" class="btn btn-primary" onclick="Back()" />
	</div>
</div>

</body>

</html>

<%@include file="common/newFooter.jsp"%>

