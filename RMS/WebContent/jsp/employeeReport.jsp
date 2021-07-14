<%@ page import="com.rms.dao.AddWaitersDao"%>
<%@page import="com.rms.bean.AddWaitersList" %>
<%@page import="java.util.List" %>
<%@include file="common/header.jsp"%>
<head>
<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
		<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
		<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->
		
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
<!-- <script>
	     $(document).ready(function(){
	    	 getWaiterReportJoiningDateWise();
	}); 
	</script>
 -->
<!-- <body id="dt_example" class="master_form_img">
	<div class="container-fluid">

		<div class="row header_margin_top" style="margin-top: 60px;">
			<div align="center">
				<h2 class="form-name style_heading">Employee Report</h2>
			</div>
		</div>
 -->
 
 <style type="text/css">
	
	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap');

	* {
		font-family: 'Poppins', sans-serif;
	}

	body {
		background: #131D28;
	}
	
	#start {
		margin-left: 75px; 
		transition: margin-left 500ms;
	}
	
	#wrapper.toggled ~ #start {
		margin-left: 240px !important; 
	}
	
	#wrapper.toggled ~ #foot {
		left: 240px !important;  
		padding-left: 335px;
	}
	
	.form-heading {
		color: #fff;
	}
	
	.display-date {
	 	float: right; 
	 	margin-right: 50px; 
	 	margin-top: 10px; 
	 	color: #fff;
	}
	
	.form-background {
		/* background: #0B1218;
    	position: relative;
    	padding: 20px; */
    	
    	background: #2e3c48;
    	position: relative;
    	padding: 20px;
    	box-shadow: 5px 8px 12px #0c1317;
	}
	
	@media ( max-width : 1200px) {
		#wrapper.toggled ~ #start {
			width: 1200px;
		} 
	
		.row {
			margin-right: 0px !important;
		}
	}
	
	@media ( max-width : 992px) {
		#wrapper.toggled ~ #start {
    		width: 1104px;
    	}
    }
	
	@media ( max-width : 767px) {
		#wrapper.toggled ~ #start { 
			width: 966px !important;
		}
	}
	
	@media (max-width: 580px) {
		#wrapper.toggled ~ #start {
    		width: 966px;
		}
	}
	
	@media (max-width: 480px) {
		#wrapper.toggled ~ #start {
    		width: 963px;
		}
	}
	
</style>

 </head>
 <body>
	<div id="start">
		<div class="row">
			<div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
				<div class="heading">	
					<h2 align="center" class="form-heading"><b>Employee Report</b></h2>
				</div>
			</div>
		</div>
		<br>
		<div class="form-background">
			<div class="row">
				<div class="display-date">
					<div id="date">
						<label id="demo"></label>
						<script>
							var date = new Date();
							document.getElementById("demo").innerHTML = date.toDateString();
						</script>
					</div>
				</div>
			</div>
			<br>
			<%
				AddWaitersDao addwait = new AddWaitersDao();
				List list = addwait.getWaiter(request);
			%>
			<div class="table-responsive">
				<table id="list" class="display" align="center" border="1">
					<thead>
						<tr>
							<th>Waiter ID</th>
							<th>First Name</th>
							<th>Middle Name</th>
							<th>Last Name</th>
							<th>Mobile No.</th>
							<th>Email ID</th>
							<th>DOB</th>
							<th>Joining Date</th>
							<th>Salary</th>
<!-- 							<th>IAddress</th> -->
							<th>City</th>
<!-- 							<th>Zip Code</th> -->
							<th>State</th>
						</tr>
					</thead>
					<tbody>
					<% 
						for(int i=0; i<list.size(); i++ ){
							AddWaitersList ad = (AddWaitersList)list.get(i);
						
					%>
						<tr>
							<td class="align"><%=ad.getWaiterId() %></td>
							<td class="align"><%=ad.getFirstName() %></td>
							<td class="align"><%=ad.getMiddleName() %></td>
							<td class="align"><%=ad.getLastName()%></td>
							<td class="align"><%=ad.getMobileNo() %></td>
							<td class="align"><%=ad.getEmailId() %></td>					
							<td class="align"><%=ad.getDob() %></td>					
							<td class="align"><%=ad.getJoiningDate() %></td>
							<td class="align"><%=ad.getSalary() %></td>
							<td class="align"><%=ad.getCity() %></td>
							<td class="align"><%=ad.getState() %></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="common/newFooter.jsp"%>