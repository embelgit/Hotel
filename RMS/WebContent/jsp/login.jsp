<%@page import="com.rms.helper.loginHelper"%>
<%@page import="com.rms.helper.LoginController"%>
<%@page import="com.rms.hibernate.UserDetailsBean" %>
<%@page import="com.rms.hibernate.usercreateBean" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<!-- All CSS files -->

<!-- Bootstrap css -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- login.php css -->
<link href="/RMS/staticContent/css/login.css" rel="stylesheet">
<link href="/RMS/staticContent/css/DailogBootstrap.min.css"
	rel="stylesheet">

<!-- All JS files -->

<!-- Bootstrap JS -->
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
<script src="/RMS/staticContent/js/jquery.min.js"></script>

<!-- login.jsp JS -->
 <script src="/RMS/staticContent/js/login.js"></script> 
<script src="/RMS/staticContent/js/DailogBootstrap.min.js"></script>
<script src="/RMS/staticContent/js/DailogJquery.min.js"></script>
<script>
function reloadPage() {
	location.reload();
}
</script>

<!--  <script type="text/javascript">
 function check(){
	<%
		loginHelper log = new loginHelper();
		List list1 = log.getUsers();
	%>
	var count = 0;
	<%
		for(int x=0; x<list1.size(); x++){
		usercreateBean bean = (usercreateBean)list1.get(x);
	%>
		var user = "<%=bean.getUserName()%>";
		var pass = "<%=bean.getPassword()%>";

	
		var username = document.getElementById("UserName").value;
		var password = document.getElementById("Passwod").value;
		
//		alert("username -  "+username+" & passwrd -  "+password);	
//		alert("username -  "+user+" & passwrd -  "+pass);
		
		//if(username=="" || password==""){
			//alert("Please enter Username and Password");
			//location.reload();
			//return false;
			
		}
		
	//	if(user==username && pass==password){
		//	window.location="/RMS/jsp/OrderBill.jsp";
		//	break;
		//count++;
		//}
		

		<%
		}
		%>
		
		if(count!=0){
			window.location="/RMS/jsp/OrderBill.jsp";
		}
		else
		{
			alert("Please Enter Appropriate Credentails ! ");
			location.reload();
			return false;
		}
}

</script> -->


</head>
<body class="login-body">
<div class="row ">
<div class="col-sm-4 col-xs-4 col-md-4 col-lg-4 col-xl-4"></div>
<div class="col-sm-4 col-xs-4 col-md-4 col-lg-4 col-xl-4">
<div class="login-form">
	<!-- <div class="login-form"> -->
		<h1 class="login-heading">Login</h1>
		<form id="myModal"   method="post">
		
		<div class="item">			
	<div class="row form-group"> 
         <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
         <div class="col-md-12  col-sm-12 col-xs-12 col-xl-10 col-lg-10">
			<div class="">
			<input type="text" class="form-control" required
				id="UserName" onchange="gethotel()" autofocus=""> 
				<label>Username </label>
		</div>
	</div>
	</div>
</div>

			
	<div class="row"> 
         <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
         <div class="col-md-12  col-sm-12 col-xs-12 col-xl-10 col-lg-10">
			<div class="">
			<input type="password" class="form-control" required
				id="Passwod"  value=""> 
				<label>Password </label>				
  
    <script> 
    // Change the type of input to password or text 
        function Toggle() { 
            var temp = document.getElementById("Passwod"); 
            if (temp.type === "password") { 
                temp.type = "text"; 
            } 
            else { 
                temp.type = "password"; 
            } 
        } 
</script>
		</div>
	</div>
</div>
</div>

		<%-- <%
		loginHelper log = new loginHelper();
		List list1 = log.getUsers();
		%> --%>
			
	<div class="row "> 
         <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
         <div class="col-md-12  col-sm-12 col-xs-12 col-xl-10 col-lg-10">
			<div class="">
				<div class="">
								<select class="form-control input-md" id='hotelname_id'  name="hotelname_id" placeholder="Select Hotel">
					</select>
					<label>Hotel Name </label>
				</div>	
			</div>
			<div class="show-checkbox"  style="color:#009172; font-weight: Ita;">
				<h4>Show Password</h4> 
				
             <div class="login-checkbox">
               <input type="checkbox" onclick="Toggle()"    > 
            
    		</div>
    		</div>
		</div>
	</div>
	</div>
	</div>
				<%-- <input list="hotelname" class="form-control"  id="hotelname_id" name="hotelname" placeholder="Select Hotel Name"/>
						
						 <datalist id="hotelname">
				
						<%
						for(int i=0;i<list1.size();i++){
							usercreateBean user = (usercreateBean)list1.get(i);
						%>
				
					<option data-value="<%=user.getPk_create_user_id()%>" value="<%=user.getPk_create_user_id()%> <%=user.getHotelname()%>">
				     
				        <%
					       }
				        %>
				   </datalist> --%>
						
	<!--		<input type="password" class="form-control" placeholder="Select Hotel Name"
				id="Passwod"> <i class="fa fa-lock"></i>-->
		 
		
		<!-- <input type="checkbox" name="" class="btn-lg" value=""><span
			class="rememberMe">Remember Me</span> <a class="link" href="#"><br>Forgot password?</a> -->
		<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:70px">		 
			<input type="button" align="left" value="Login" onclick="login()" id="save" class=" btn btn-md btn-lg btn-success"> 
				<input type="button" value="Clear" align="right" id="clear" onclick="reloadPage()" class=" btn btn-md btn-lg btn-danger">
	</div>
	</div>

		</form>
	</div>
		</div>
		
	
<div class="col-sm-4 col-xs-4 col-md-4 col-lg-4 col-xl-4"></div>
</div>

	<div id="myModal" class="modal fade" style="margin: 180px;">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- dialog body -->
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style="color: red;">
						<b>Error!</b>
					</h4>
					<hr color="red"></hr>
					<h5>Invalid user name and password.</h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						style="background: #D63333;">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>