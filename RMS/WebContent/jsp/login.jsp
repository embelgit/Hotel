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
			alert("Please Enter Appropriate Credentials ! ");
			location.reload();
			return false;
		}
}

</script> -->


</head>
<body class="login-body">
	<div class="container-fluid">
		<div class="row">
			<div class="login-form">
				<img class="user" src="/RMS/staticContent/images/user.png">
				<h1 class="login-heading">Login</h1>
				<form id="myModal"   method="post">
					<div class="item">			
						<div class="form-group"> 
         					<input type="text" required id="UserName" onchange="gethotel()"> 
							<span></span>
							<label>Username</label>
						</div>
						<div class="form-group"> 
         					<input type="password" required id="Passwod"  value=""> 
         					<span></span>
         					<label>Password</label>									
         				</div>
						<div class="form-group"> 
         					<select class="input-md" id='hotelname_id'  name="hotelname_id"></select>
         					<span></span>
         					<label for="hotelname_id">Hotel Name</label>
         				</div>
						<div class="login-checkbox ">
							<input type="checkbox" onclick="Toggle()" id="showpass">
               				<label for="showpass">Show Password</label> 
						</div>
					</div>
					<div class="ibutton">
						<div class="row" align="center" style="margin-bottom:70px">		 
							<input type="button" align="left" value="Login" id="save" onclick="login()"  class=" btn btn-md btn-lg btn-success"> 
							<input type="button" align="right" value="Clear" id="clear" onclick="reloadPage()" class=" btn btn-md btn-lg btn-danger">
						</div>
					</div>
					<div id="myModal" class="modal fade" style="margin: 180px;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-body">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" style="color: red;">
										<b>Error!</b>
									</h4>
									<hr color="red"></hr>
									<h5>Invalid user name and password.</h5>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-primary" data-dismiss="modal" style="background: #D63333;">Close</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>	
	</div>

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

</body>
</html>