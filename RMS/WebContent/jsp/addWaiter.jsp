<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@page import="com.rms.dao.AddWaitersDao" %>   
 <%@page import="com.rms.hibernate.AddWaiters" %> 
 <%@page import="java.util.List"%>  
 <%@page import="com.rms.bean.AddWaitersList" %>
<%@include file="common/header.jsp"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Waiter</title>

<!-- All CSS files -->

 	
 	 <link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
 	<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
 	  <script src="/RMS/staticContent/js/bootstrap.min.js"></script>
 	 <script src="/RMS/staticContent/js/bootstrap.js"></script> 
 		 <script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
 	 <script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
     <link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
  <!--   <link href="/RMS/staticContent/css/header.css"> -->
   <!--   <link rel="stylesheet" href="/RMS/staticContent/css/style.css"> -->     
	<!--  <link href="/RMS/staticContent/css/style.css" rel="stylesheet">	 -->
	 <!-- All CSS files -->
	 
	 	 <script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
	
    
     <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.min.js"></script>
     <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
    
     <script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
  
		<!-- custom css -->

			
		<!-- custome JS -->
	
<!-- 	<script src="/RMS/staticContent/js/bootbox.min.js"></script>
	<script src="/RMS/staticContent/js/bootbox.js"></script> -->
		<script src="/RMS/staticContent/js/addWaiter.js"></script>	
		
	<script type="text/javascript">
	
	$(function(){
	    var dtToday = new Date();
	    
	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	        day = '0' + day.toString();
	    
	    var maxDate = year + '-' + month + '-' + day;
	    //alert(maxDate);
	    $('#dob').attr('max', maxDate);
	});
	
	</script>
		<script type="text/javascript">
		
		function EditWaiter(){
			window.location="EditWaiter.jsp";
		}
		function ListWaiter()
		{
			
			 window.location="waiterlist.jsp";
		}
		
		</script>
		
 	   
 		
 	
<script type="text/javascript">
			function isNumber(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		        return false;
		    }
		    return true;
		}
	</script>	
	
	<script type="text/javascript">
		
		function isNumberKey(evt,id)
		{
			try{
		        var charCode = (evt.which) ? evt.which : event.keyCode;
		  
		        if(charCode==46){
		            var txt=document.getElementById(id).value;
		            if(!(txt.indexOf(".") > -1)){
			
		                return true;
		            }
		        }
		        if (charCode > 31 && (charCode < 48 || charCode > 57) )
		            return false;

		        return true;
			}catch(w){
				alert(w);
			}
		}
		
		</script>	
	
	<script type="text/javascript">
	function checkforDuplicateWaiterID(){
		<%
		AddWaitersDao dao1 = new AddWaitersDao();
		List list1 = dao1.getWaitersName();
		%>
		
		 <%
	
		for(int x=0; x<list1.size(); x++){
			AddWaiters bean = (AddWaiters)list1.get(x);
		%>
		
		var waiterID = "<%=bean.getWaiterId()%>";
	    var waiter = document.getElementById("waiterId").value;
		if(waiterID == waiter){
			alert("Waiter ID aleardy exist !! Duplicate not allowed");
			location.reload();
			return false;
		}
		<%
		}
		%>
		
		}
	</script>	
	
	 <script type="text/javascript">	
			 
		 	function checkForDuplicateWaiterEntry(){
		 		debugger;
					<%
					AddWaitersDao dao = new AddWaitersDao();
					List list = dao.getWaitersName();
					%>
					
					 <%
					//int x = 0;
					for(int x=0; x<list.size(); x++){
						AddWaiters bean = (AddWaiters)list.get(x);
					%>
					
					var firstName = "<%=bean.getFirstName()%>";
				 	var middleName = "<%=bean.getMiddleName()%>";
					var lastName = "<%=bean.getLastName()%>";  
					
				    var first = document.getElementById("firstName").value;
 					var middle = document.getElementById("middleName").value;
					var last = document.getElementById("lastName").value; 
							
 						if(firstName == first && middleName == middle && lastName == last){
							alert("Name already exist ! Duplicate not allowed ");
							location.reload(true);
							return false;
						}
			
						/*  if (document.Waiter.firstName.value == first){
							 alert("firstname already exists !");
							 return false;
						 } */
 
 
					<%
					}
					%>
			}
					
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

	.form-background {
		/* background: #0B1218;
    	position: relative;
    	padding: 20px; */
    	
    	top: 20px;
    	
    	background: #2e3c48;
    	position: relative;
    	padding: 20px;
    	box-shadow: 5px 8px 12px #0c1317;
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
	.form-group input[type="date"]:invalid ~ label {
		top: -5px;
		color: #00e3a2;
	}
	
	.ibutton input[type="button"],[type="reset"]{
		width: 140px;
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
	
	::-webkit-calendar-picker-indicator {
    	filter: invert(1);
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
					<h2 align="center" class="form-heading"><b>Add Employee</b></h2>
				</div>
			</div>
		</div>
		<div class="form-background">
			<form action="" class="form-horizontal" method="post" name="Waiter">			
				<div class="row form-group"> 
         			<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
         				<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="waiterId"  onchange="checkforDuplicateWaiterID()" required autofocus="autofocus" />
								<span></span>
								<label>ID <sup>*</sup></label>
							</div>
						</div>
					</div>
				</div>
				<div class="row form-group"> 
         			<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-2  col-md-offset-1 col-sm-offset-1 col-sm-2 col-xs-2 col-xl-2 col-lg-2">
							<div class="invoice_label_up">
								<input type="text" id="firstName" required onkeyup=""  />
								<span></span>
								<label>First Name <sup>*</sup> </label>
							</div>
						</div>
						<div class="col-md-2  col-md-offset-1 col-sm-offset-1 col-sm-3 col-xs-3 col-xl-2 col-lg-2">
							<div class="invoice_label_up">			
								<input type="text" id="middleName" required />
								<span></span>
								<label>Middle Name <sup>*</sup></label>
							</div>
						</div>
						<div class="col-md-2  col-md-offset-1 col-sm-offset-1 col-sm-2 col-xs-2 col-xl-2 col-lg-2">
							<div class="invoice_label_up">
								<input type="text" id="lastName"  onchange="checkForDuplicateWaiterEntry()" required />
								<span></span>
								<label>Last Name <sup>*</sup></label>
							</div>
						</div>					
					</div>
				</div>
				<div class="row form-group"> 
      				<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						 <div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
						   <!-- <input type="text" class="form-control"  id="mobileNo" maxlength="10" pattern="[0-9]{10,10}" placeholder="Mobile Number" onkeyup="" required /> -->
								<input list="mobileNo" id="mobileNo" maxlength="10" name="mobileNo" required  pattern="[0-9]{10,10}" title="Mobile number must 10 digit." />		
								<span></span>
								<label>Mobile Number <sup>*</sup></label>
							</div>
						</div>
					 	<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="email" id="emailId"  onkeyup="" required />
								<span></span>
								<label>Email ID</label>
							</div>
						</div>				 
	  				</div>
				</div>
				<div class="row form-group"> 
      				<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						 <div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="date" id="dob" required onkeyup="" />
								<span></span>
								<label>DOB</label>	
							</div>
						</div>							 
					</div>
				</div>	
				<div class="row form-group"> 
      				<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						 <div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="date" id="joiningDate" required onkeyup="" />
								<span></span>
								<label>Joining Date</label>
							</div>
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<!-- <div class="input-group">
								<span class="input-group-addon">Rs</span> -->
								<input type="text" maxlength="8"  id="salary" required onkeyup="" />
								<span></span>
								<label>Salary <sup>*</sup></label>
								<!-- </div> -->
							</div>				 
						</div>
					</div>
				</div>		
				<div class="row form-group"> 
      				<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="address" required onkeyup="" />
								<span></span>
								<label>Address <sup>*</sup></label>
							</div>								 
						</div>
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="city" required onkeyup=""  />
								<span></span>
								<label>City</label>
							</div>								 
						</div>
					</div>
				</div>	
				<div class="row form-group"> 
      				<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
						<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" maxlength="6" id="zip" pattern="[0-9]{6,6}" required onkeyup=""/>
								<span></span>
								<label>Zip Code</label>
							</div>
						</div>								
					 	<div class="col-md-4  col-md-offset-1 col-sm-offset-1 col-sm-4 col-xs-4 col-xl-4 col-lg-4">
							<div class="invoice_label_up">
								<input type="text" id="state" required onkeyup=""   />
								<span></span>
								<label>State</label>
							</div>
						</div>
					</div>								 
				</div>	
				<div class="ibutton" style="margin-bottom:50px">
					<div class="row" align="center">	
						<i class="las la-save la-2x cust"></i>
						<input type="button" class="btn btn-lg btn-success btn-md"   name="createbtn" title="Submit filled Information" onclick="addWaiter(); return false;" value="Create"/>
						<!-- <input type="button" value="Edit" class="btn btn-primary" title="Submit filled Information" onclick=" EditWaiter();"/> -->
						<i class="las la-redo-alt la-2x cust"></i>
						<input type="reset" class="btn btn-lg btn-danger btn-md" title="Submit filled Information" value="Reset"/>
						<i class="las la-edit la-2x cust"></i>
						<input type="reset" class="btn btn-lg btn-primary btn-md" title="Submit filled Information"  onclick="EditWaiter()" value="Edit"/>
						<!-- <button type="reset" class="btn btn-primary" title="Submit filled Information" onclick="ListWaiter()">List</button> -->
						<i class="las la-clipboard-list la-2x cust"></i>
						<input type="reset" class="btn btn-lg btn-warning btn-md" title="Submit filled Information"  onclick="ListWaiter()" value="List"/>
					</div>
				</div>	
			</form>			
		</div>
	</div>
</body>
</html>

 <%@include file="common/newFooter.jsp"%> 