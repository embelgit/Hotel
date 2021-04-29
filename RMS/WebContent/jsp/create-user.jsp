<%@page import="java.util.List"%>
<%@page import="com.rms.dao.hotelnamedao"%>
<%@page import="com.rms.hibernate.hotelnamebean"%>
<%@page import="com.rms.dao.CreateUserDao"%>
<%@page import="com.rms.hibernate.UserDetailsBean" %> 
<%@page import="com.rms.hibernate.usercreateBean" %>
<%@include file="common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>

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
<script src="/RMS/staticContent/js/create-user.js"></script>
<script type="text/javascript">
function createuserList(){
	window.location ="listofusers.jsp";
}
function Editcreateuser(){
	window.location ="Editcreate-user.jsp";
}

</script>

 <script type="text/javascript">
	function checku(){
		<%
		CreateUserDao dao1 = new CreateUserDao();
		List list1 = dao1.getalluserNamee();
		%>
		
		 <%
	
		for(int x=0; x<list1.size(); x++){
			usercreateBean bean = (usercreateBean)list1.get(x);
		%>
		
		var userr = "<%=bean.getUserName()%>"; 
	    var usergot = document.getElementById("userName").value;

/* 	    alert("user frm table - "+userr);
	    alert("user entered - "+usergot); */
		if(userr==usergot){
			alert("Username entered is aleardy exist !! Duplicate not allowed");
			location.reload();
			return false;
		}
		<%
		}
		%>
		
		}
	</script>   


</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<div class="heading">	
		<h2 align="center" class="form-heading"><b>Create User</b></h2>
		</div>
		<hr>
	</div>
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
</div>
		<form class="form-horizontal" action="#" method="post"
			name="createUser">

<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
					<select class="form-control" name="userType" id="userType">
						<option value="selected">--Select User type--</option>
						<option value="admin">Admin</option>
						<option value="personal user">Personal User</option>
					</select>
					<label>User Type:<sup>*</sup></label>
				</div>
			</div>
		</div>
	</div>
			
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<input type="text" class="form-control" id="firstName"
						 onkeyup="firstNameValidation(this)"
						onblur="cheakEmpty(this)" required autofocus />
					<label>First Name:<sup>*</sup> </label>
				</div>
			</div>
			<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<input type="text" class="form-control" id="lastName"
						 onkeyup="firstNameValidation(this)"
						onblur="cheakEmpty(this)" pattern="[a-zA-Z]+" required />
					<label>Last Name:<sup>*</sup> </label>
				</div>
			</div>
		</div>
	</div>
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			 <div class="invoice_label_up">
					<input type="text" class="form-control" id="userName"
						required  onchange="checku()"/>
					<label>User Name: <sup>*</sup></label>	
				</div>
			</div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
				<!--onblur="cheakEmpty(this)"    onkeyup="cheakEmpty(this)"  -->
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			 <div class="invoice_label_up">
				<!-- <span class="input-group-addon">
				 <span class="glyphicon glyphicon-phone"></span></span> -->
					<input type="text" class="form-control" id="mobileNo" maxlength="10" pattern="\d{10}"
						required/>
					<label>Mobile Number:<sup>*</sup></label>
						</div>
				</div>
			</div>
		</div>
<!-- onblur="moNoValidation(this)"  onkeyup="moNoValidation(this)"  -->
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			 <div class="invoice_label_up">
					<input type="password" class="form-control" id="password"
					 onblur="cheakEmpty(this)" required />
					<label>Password:<sup>*</sup></label>
				</div>
			</div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			 <div class="invoice_label_up">
					<input type="password" class="form-control" id="confirmPassword"
						onblur="cheakConPassword(this)" onkeyup="cheakConPassword(this)"
						required />
						<label>Confirm Pass:<sup>*</sup></label>
						</div>
				</div>
			</div>
</div>
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			 <div class="">
					<!-- <div class="input-group">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-envelope"></span> 
						</span> -->
						<input type="email" class="form-control" id="emailId" required onblur="cheakEmpty(this)" onkeyup="cheakEmpty(this)" />
					<!-- </div> -->
					<label>Email Id: </label>
				</div>
			</div>
		</div>
	</div>
				<%-- <div class="col-md-2 col-sm-3">
					<label class="control-label">Hotel Name: <sup>*</sup></label>
				</div>
					<div class="col-md-2 col-sm-3">
				<%
						hotelnamedao dao11 = new hotelnamedao();
						List ilist= dao11.getAllhotelname();
				%>

							<input list="hotel_drop" id="hotelname"
								class="form-control" placeholder="Select Hotel" autofocus="autofocus">
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
				</div> --%>
				<!-- <div class="col-md-2 col-sm-3">
				<div class="input-group">
					<input type="password" class="form-control" id="hotelname"
						placeholder= "Enter Hotel Name"	required />
						</div>
				</div> -->
			</div>

		
				<!-- <button class="btn btn-success" name="createbtn"
					title="Submit filled Information" onclick="createAppUser()">Create</button> -->

	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px ; padding-bottom:35px">			
	<input  type="button" title="Submit filled Information" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="createbtn" value="Save" onclick="createAppUser()" />		
	
		<input  type="reset" title="Submit filled Information" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Clear" onclick="reset()" /> 		
				<!-- <button type="reset" class="btn btn-danger"
					title="Submit filled Information">Reset</button> -->
				
		<input type="reset" class="btn btn-lg btn btn-primary" 
					title="Submit filled Information" onclick="Editcreateuser()" value="Edit"/>
	
		<input type="reset" class="btn btn-lg btn btn-primary" 
					title="Submit filled Information" onclick="createuserList()" value="List"/>
			</div>
</div>

		</form>

</body>
</html>

<%@include file="common/newFooter.jsp"%>