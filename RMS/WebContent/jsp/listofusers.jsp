<%@page import="com.rms.hibernate.usercreateBean"%>
<%@page import="com.rms.hibernate.CreateUser"%>
<%@page import="com.rms.dao.CreateUserDao"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.hibernate.SupplierDetailsHibernate"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.SupplierDetailsDao"%>

<%@include file="common/header.jsp"%>

	<title>User List</title>
<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
		<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
		<!-- <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->
		
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
		 window.location = "create-user.jsp";
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
		
	.ibutton input[type="button"] {
		width: 150px;
		padding-left: 40px;
		padding-bottom: 7px;
		margin-top: 28px;
		margin-left:20px;
	}
	
	.cust {
		position: absolute;
		margin-left: 38px;
		margin-top: 35px;
		font-size: 30px;
		color: #fff;
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
					<h2 align="center" class="form-heading"><b>User List</b></h2>
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
				CreateUserDao dao=new CreateUserDao();
				List list12=dao.getAllUserDetailsForList();
			%>
			<div class="row">
				<div class="table-responsive">
					<table id="list" class="display" align="center" border="1">
						<thead>
							<tr>
								<th>Sr. No.</th>
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
								usercreateBean sr=(usercreateBean)list12.get(i);
						%>
							<tr>
								<td class="align"><%=sr.getPk_create_user_id()%></td>
								<td class="align"><%=sr.getUserType()%></td>
								<td class="align"><%=sr.getFirstName()%></td>
								<td class="align"><%=sr.getLastName()%></td>
								<td class="align"><%=sr.getUserName()%></td>
								<td class="align"><%=sr.getMobileNO()%></td>
								<td class="align"><%=sr.getEmailId() %></td>
							</tr>
						<%
							}
						%>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibutton" style="padding-bottom:50px;">
				<div class="row" align="center">
					<i class="las la-angle-left la-2x cust"></i>
					<input type="button"  value="Back" id="listBtn" class="btn btn-lg btn-primary btn-md" onclick="Back()"/>
				</div>
			</div>
		</div>	
	</div>
</body>
</html>
<%@include file="common/newFooter.jsp"%>