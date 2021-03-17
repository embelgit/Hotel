<%@page import="com.rms.hibernate.CreateUser"%>
<%@page import="com.rms.dao.CreateUserDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.SupplierDetailsHibernate"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.SupplierDetailsDao"%>
<%@include file="common/header.jsp"%>

<html>
<head>
<script src="/RMS/staticContent/js/itemEntry.js"></script>
<script type="text/javascript">
	 function Back() {
			 window.location = "create-user.jsp";
	}

</script>
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

<style type="text/css">
td {
	color: black;
}
</style>
</head>

<div class="container-fluid" style="min-height: 300px;">

	<div class="row header_margin_top">
		<div align="center">
			<h2 class="form-name style_heading" style="margin-top: 80px">Create User List</h2>
		</div>
	</div>


	<div class="row">
		<div class="form-group" align="right">
			<div class="col-sm-offset-6 col-md-5 control-label">
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
		<div class="col-sm-offset-1 col-md-10">
			<hr style="border-top-color: #c1b1b1;">
		</div>
	</div>

	<%
	CreateUserDao dao=new CreateUserDao();
	List list12=dao.getAllUserDetailsForList();
	%>

	<div id="date">
		<label id="demo"></label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div>

	<div id="demo_jui">
		<div class="table-responsive">
			<table id="list" class="table table-bordered display">
				<thead>
					<tr>
						<th>Sr.No</th>
						<th>UserType</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>User Name</th>
						<th>Mobile Number</th>
						<th>Email Id</th>
					</tr>
				</thead>

				<tbody>
					<%
					for(int i=0;i<list12.size();i++){
						CreateUser sr=(CreateUser)list12.get(i);
				%>

					<tr>
						<td class="align"><%=sr.getPk_create_user_id()%></td>
						<td class="align"><%=sr.getUserType()%></td>
						<td class="align"><%=sr.getFirstName()%></td>
						<td class="align"><%=sr.getLastName()%></td>
						<td class="align"><%=sr.getUserName()%></td>
						<td class="align"><%=sr.getMobileNO()%></td>
						<td class="align"><%=sr.getEmailId() %>

					</tr>

					<%
					}
				%>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrapper" align="center" ">
		<input type="button" style="height: 65px; width: 180; font-size: 25; "
			value="Back" id="listBtn" class="btn btn-lg btn-primary btn btn-primary" onclick="Back()" />
	</div>

	 <%@include file="common/newFooter.jsp"%> 

</div>