<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.usercreateBean"%>
<%@page import="com.rms.dao.CreateUserDao"%>
<%@page import="com.rms.dao.hotelnamedao"%>
<%@page import="com.rms.hibernate.hotelnamebean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access Control New One</title>

<!-- All CSS files -->

<!-- Bootstrap CSS -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- custom CSS -->
<!-- <link href="/RMS/staticContent/css/style.css" rel="stylesheet"> -->

<!-- All JS files -->

<!-- Bootstrap JS -->

<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/bootbox.js"></script>
<script src="/RMS/staticContent/js/bootbox.min.js"></script>
<!-- custome JS -->
<script src="/RMS/staticContent/js/jquery.min.js"></script>
<script src="/RMS/staticContent/js/accesscontrol.js"></script>

<script type="text/javascript">
function createuserList(){
	window.location ="listofusers.jsp";
}
function Editcreateuser(){
	window.location ="Editcreate-user.jsp";
}

</script>
<%@include file="common/header.jsp"%>
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
		background: #0B1218;
		top: 20px;
    	position: relative;
    	padding: 20px;
	}
	
	form .form-group {
		position: relative;
		margin: 30px 30px;
		float: center;
	}
	
	.form-group input {
		width: 100%;
		padding: 0 5px;
		height: 40px;
		font-size: 16px;
		border: none;
		outline: none;
		background: none;
		color: #fff;
	}
	
	.form-group label {
		position: absolute;
		top: 50%;
		left: 23px;
		color: #fff;
		transform: translateY(-50%);
		font-size: 16px;
		pointer-events: none;
		transition: .5s;
	}
	
	.form-group select{
		width: 100%;
		padding: 0px 5px;
		height: 40px;
		font-size: 16px;
		border: none;
		outline: none;
		background: none !important;
		color: #fff;
		font-weight: 900;
	}
	
	.op-bg {
		background-color: black;
	}
	
	.form-group span:before {
		content:'';
		position: absolute;
		top: 40px;
		left: 0;
		width: 100%;
		height: 2px;
		background: #00aabb;
	}
	
	.form-group input:focus ~ label,
	.form-group input:valid ~ label,
	.form-group input:read-only ~ label,
	.form-group select:focus ~ label,
	.form-group select:valid ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.ibutton input[type="button"],[type="reset"]{
		width: 120px;
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
	
	.ibutton .row {
    	margin-left: -30px;
	}
	
	@media ( max-width : 1200px) {
		#wrapper.toggled ~ #start {
			width: 1184px;
		}
	}
	
	@media ( max-width : 992px) {
		#wrapper.toggled ~ #start {
    		width: 1094px;
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

}
</style>
</head>
<body>
	<div id="start">
		<div class="row">
			<div class="col-md-6 col-lg-6 col-xl-6 col-sm-6">
				<div class="heading">	
					<h2 align="center" class="form-heading"><b>Access Control</b></h2>
				</div>
			</div>
		</div>	
		<div class="form-background">
			<form class="form-horizontal" action="#" method="post" name="createUser">
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
							<%
								CreateUserDao dao = new CreateUserDao();
								List iList= dao.getAlluser();
							%>
								<input list="user_drop" id="username" onchange="getuserDetails()" required autofocus="autofocus">
								<datalist id="user_drop">
							<%
					         	for(int i=0;i<iList.size();i++){
					        		usercreateBean us = (usercreateBean)iList.get(i);
				            %>
									<option data-value="<%=us.getPk_create_user_id()%>" value="<%=us.getUserName()%>">
							<%
					           }
				            %>	
								</datalist>
								<span></span>
								<label>Select UserName <sup>*</sup></label>
							</div>
						</div>
					</div>
				</div>
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="">
								<input type="text" id="user" required readonly="readonly"/>
								<span></span>
								<label >UserName <sup>*</sup> </label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="">
								<input type="text" required id="pass" readonly="readonly" />
								<span></span>
								<label>Password <sup>*</sup></label>
							</div>
						</div>
					</div>
				</div>
				<div class="row form-group"> 
					<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="">
								<select name="usertype" id="usertype">
									<option value="" class="op-bg" hidden>--Select User type--</option>
									<option value="admin" class="op-bg">Admin</option>
									<option value="personal user" class="op-bg">Personal User</option>
								</select>
								<span></span>
								<label >User Type <sup>*</sup></label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
							<%
								hotelnamedao dao1 = new hotelnamedao();
								List ilist= dao1.getAllhotel();
							%>
								<input list="hotel_drop" id="hotel" autofocus="autofocus" required>
								<datalist id="hotel_drop">
							<%
					        	for(int i=0;i<ilist.size();i++){
					        		hotelnamebean us = (hotelnamebean)ilist.get(i);
				            %>
									<option data-value="<%=us.getPk_id()%>" value="<%=us.getHotelname()%>">
							<%
					           }
				            %>	
								</datalist>
								<span></span>
								<label>Hotel Name <sup>*</sup></label>
							</div>
						</div>
					</div>
				</div>
				<div class="ibutton" style="margin-bottom:50px">
					<div class="row" align="center">
						<i class="las la-save la-2x cust"></i>	
						<input  type="button" title="Submit filled Information" class="btn btbtn btn-lg btn-success btn-md" name="save" value="Save" onclick="addaccess()" />		
						<i class="las la-eraser la-2x cust"></i>
						<input  type="reset" title="Submit filled Information" class="btn btn-lg btn-danger btn-md" value="Clear" onclick="reset()" /> 		
					</div>
				</div>	
			</form>
		</div>
	</div>
</body>
</html>

<%@include file="common/newFooter.jsp"%>