<%@page import="com.rms.dao.CreateUserDao"%>
<%@page import="com.rms.hibernate.CreateUser"%>
<%@page import="com.rms.hibernate.usercreateBean"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.AddWaiters"%>
<%@page import="com.rms.dao.AddWaitersDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Create User</title>

<!-- All CSS files -->

<!-- Bootstrap CSS -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- custom CSS -->
<link href="/RMS/staticContent/css/style.css" rel="stylesheet">

<!-- All JS files -->

<!-- Bootstrap JS -->

<script src="/RMS/staticContent/js/bootstrap.min.js"></script>

<!-- custome JS -->
<script src="/RMS/staticContent/js/jquery.min.js"></script>
<script src="/RMS/staticContent/js/create-user.js"></script>
<script type="text/javascript">
function createuserList(){
	window.location ="createuserList.jsp";
}
function EditcreateUser(){
	window.location = "EditcreateUser.jsp";
}
function Back(){
	window.location = "create-user.jsp";
}

</script>
<%@include file="common/header.jsp"%>
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
		<form class="form-horizontal" action="" method="post"
			name="createUser">


		<!-- <div class="row"> -->
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<!-- <div class=" col-md-offset-1 col-sm-1"> -->
						
					<!-- <div class="col-sm-2">
						<input type="number" class="form-control" id="waiterId" placeholder="Enter Id" onkeyup="" required autofocus />
						<input type="text" class="form-control" id="waiterId" placeholder="Enter Id"  />
					</div> -->
					
							<!-- <span class="input-group-addon"> <i
								class="glyphicon glyphicon-road"></i>
							</span> -->
							<%
							CreateUserDao itemEntryDao = new CreateUserDao();
						List iList= itemEntryDao.getAllCreateUserList();
						%>

							<input list="fk_item_id_drop" id="fk_item_id" 
								class="form-control" onchange="getAllCreateUserDetails()" required autofocus="autofocus">
							<datalist id="fk_item_id_drop">

								<%
					         for(int i=0;i<iList.size();i++){
					        	 usercreateBean itemEntry = (usercreateBean)iList.get(i);
				              %>

								<option data-value="<%=itemEntry.getPk_create_user_id()%>"
									<%--  value="<%=itemEntry.getUserType() %> " --%>
									<%--  value="<%=itemEntry.getPk_create_user_id()%>" --%>
									value="<%=itemEntry.getFirstName() %> <%=itemEntry.getLastName() %>" 
									 >
									<%
					           }
				                %>
								
							</datalist>
							<label>Select Name</label>
				
						</div>
					</div>
				</div>
			</div>


<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			  <div class="">
					<select class="form-control" name="userType" id="userType">
						<option value="selected">--Select User type--</option>
						<option value="admin">Admin</option>
						<option value="personal user">Personal User</option>
					</select>
					<label >User Type:<sup>*</sup></label>
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
						onblur="cheakEmpty(this)" required/>
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
						 onblur="cheakEmpty(this)"
						onkeyup="cheakEmpty(this)" required />
						<label>User Name: <sup>*</sup></label>
				</div>
			</div>
			<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
		 <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<input type="text" class="form-control" maxlength="10" id="mobileNo"
					 onblur="moNoValidation(this)" onkeyup="moNoValidation(this)" required/>
					<label>Mobile Number:<sup>*</sup></label>
				</div>
			</div>
		</div>
	</div>
<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
	<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<input type="text" class="form-control" id="password"
						 onblur="cheakEmpty(this)" required />
					<label>Password:<sup>*</sup></label>
				</div>
			</div>
			<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<input type="text" class="form-control" id="confirmPassword"
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
			<div class="invoice_label_up">
			 <input type="email" class="form-control" id="emailId"
			 onblur="cheakEmpty(this)" onkeyup="cheakEmpty(this) " required />
				<label>Email Id: </label>
			</div>
		</div>
	</div>
</div>
</div>	

 
	<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px">	
			<input type="button" class="btn btn-lg btn btn-success" name="createbtn" 
					title="Submit filled Information" onclick="UpdatecreateAppUser()" value="Update"/>
		
				<input type="reset" class="btn btn-lg btn btn-danger" 
					title="Submit filled Information" value="Clear"/>
			
		<input type="reset" class="btn btn-lg btn btn-primary" 
					title="Submit filled Information" onclick="Back()" value="Back"/>
		</div>
	</div>
				<!-- 	<button type="reset" class="btn btn-primary"
					title="Submit filled Information" onclick="createuserList()">Back</button> -->
	
		</form>

</body>
</html>

<%@include file="common/newFooter.jsp"%>
