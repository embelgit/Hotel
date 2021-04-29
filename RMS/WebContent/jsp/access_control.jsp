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
<title>Access Control</title>

<!-- All CSS files -->

<!-- Bootstrap CSS -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- custom CSS -->
<link href="/RMS/staticContent/css/style.css" rel="stylesheet">

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
@media only screen and (min-width: 1200px){
.form-group {
margin-left:10px
}
}
</style>
</head>
<body>
<div class="row">
<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<div class="heading">	
		<h2 align="center" class="form-heading"><b>Access Control</b></h2>
		</div>
		<hr>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		</div>
</div>	
		<form class="form-horizontal" action="#" method="post"
			name="createUser">
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
				
							
							<%
						CreateUserDao dao = new CreateUserDao();
						List iList= dao.getAlluser();
							%>

							<input list="user_drop" id="username"
								class="form-control" onchange="getuserDetails()" required autofocus="autofocus">
							<datalist id="user_drop">

								<%
					         for(int i=0;i<iList.size();i++){
					        	 usercreateBean us = (usercreateBean)iList.get(i);
				              %>

								<option data-value="<%=us.getPk_create_user_id()%>"
									value="<%=us.getUserName()%>">
									<%
					           }
				                %>
								
							</datalist>
							<label>Select UserName:<sup>*</sup> </label>
				</div>
				
			</div>
	</div>
</div>
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
					<input type="text" class="form-control" id="user"
						required readonly="readonly"/>
						<label >UserName: <sup>*</sup> </label>
				</div>
			</div>
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
					<input type="text" class="form-control" required id="pass" readonly="readonly" />
						<label>Password:<sup>*</sup></label>
						</div>
				</div>
			</div>
		</div>


	<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
					<select class="form-control" name="usertype" id="usertype">
						<option value="">--Select User type--</option>
						<option value="admin">Admin</option>
						<option value="personal user">Personal User</option>
					</select>
					<label >User Type : <sup>*</sup></label>
				</div>
			</div>
				<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
				
				<%
						hotelnamedao dao1 = new hotelnamedao();
						List ilist= dao1.getAllhotel();
							%>

							<input list="hotel_drop" id="hotel"
								class="form-control" autofocus="autofocus" required>
							<datalist id="hotel_drop">

								<%
					         for(int i=0;i<ilist.size();i++){
					        	 hotelnamebean us = (hotelnamebean)ilist.get(i);
				              %>

								<option data-value="<%=us.getPk_id()%>"
									value="<%=us.getHotelname()%>">
									<%
					           }
				                %>
								
							</datalist>
							<label>Hotel Name : <sup>*</sup></label>
				</div>
			</div>
	</div>
</div>	
</div>			

	<div class="ibutton">
	<div class="row" align="center">
	<input  type="button" title="Submit filled Information" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="save" value="Save" onclick="addaccess()" />		
	
		<input  type="reset" title="Submit filled Information" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reset()" /> 		
		</div>
	</div>

		</form>
	
</body>
</html>

<%@include file="common/newFooter.jsp"%>