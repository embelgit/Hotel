<%@page import="com.rms.bean.AddWaitersList"%>
<%@page import="com.rms.dao.AddWaitersDao"%>
<%@page import="com.rms.hibernate.CreateUser"%>
<%@page import="com.rms.dao.CreateUserDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.SupplierDetailsHibernate"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.SupplierDetailsDao"%>

<%@include file="common/header.jsp"%>

	<title>Waiter List</title>
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
	 function Back() {
		 window.location = "addWaiter.jsp";
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

<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<h2 align="center" class="form-heading"><b>Waiter List</b></h2>
		</div>
<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12">
<div id="date" align="right">
		<label id="demo">Date : </label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div>
</div>
<div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"></div>
</div>
		
	 <%
	AddWaitersDao dao=new AddWaitersDao();
	List list12=dao.getAllWaiterDetailsForList(request);
	%>
		<div class="row">
			<div class="col-md-12 col-12 col-sm-12 col-xs-12 col-lg-12 col-xl-12">

			<div class="table-responsive">
		
					<table id="list" class="display" align="center" border="1">
					<thead>
						<tr>
					<th>Waiter ID</th>
						<th>First Name</th>
						<th>Middle Name</th>
						<th>Last Name</th>
						<th>Mobile No</th>
						<th>DOB</th>
						<th>Date Of Joining</th>
						<th>Salary</th>
						<th>Address</th>
						<th>City</th>
						<th>ZipCode</th>
						<th>State</th>
					</tr>
					</thead>
					<tbody>
						<%
					for(int i=0;i<list12.size();i++){
						AddWaitersList sr=(AddWaitersList)list12.get(i);
				%>

					<tr>
<%-- 					<td class="align"><%=sr.getPkAddWaiterId()%></td> --%>
						<td class="align"><%=sr.getWaiterId()%></td>
						<td class="align"><%=sr.getFirstName()%></td>
						<td class="align"><%=sr.getMiddleName()%></td>
						<td class="align"><%=sr.getLastName()%></td>
						<td class="align"><%=sr.getMobileNo()%></td>
						<td class="align"><%=sr.getDob()%></td>
						<td class="align"><%=sr.getJoiningDate() %>
						<td class="align"><%=sr.getSalary() %>
						<td class="align"><%=sr.getAddress() %>
						<td class="align"><%=sr.getCity() %>
						<td class="align"><%=sr.getZip() %>
						<td class="align"><%=sr.getState() %>
						
					</tr>

					<%
					}
				%>

				</table>
			</div>
		</div>
	</div>
		<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:10px ; padding-bottom:35px">	
<input type="button"  value="Back" id="listBtn" class="btn btn-lg btn btn-primary btn btn-primary" onclick="Back()"/>
		
			</div>
		</div>
	
</body>
</html>
<%@include file="common/newFooter.jsp"%>