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
	<title>Add waiter</title>

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
	 <link href="/RMS/staticContent/css/style.css" rel="stylesheet">	
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
	
	
</head>
<body>
<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
	<div class="heading">	
		<h2 align="center" class="form-heading"><b>Add Employee</b></h2>
		</div>
		<hr>
		</div>
			<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
	</div>
			<form action="" class="form-horizontal" method="post" name="Waiter">
			

<div class="item">			
	<div class="row form-group"> 
         <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
         <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="waiterId"  onchange="checkforDuplicateWaiterID()" required autofocus="autofocus" />
						<label>ID :<sup>*</sup> </label>
					</div>
				</div>
			</div>
		</div>
				
				

	<div class="row form-group"> 
         <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-2 col-lg-2">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="firstName" required onkeyup=""  />
						<label >First Name:<sup>*</sup> </label>
			</div>
		</div>
		<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
		<div class="col-md-6   col-sm-12 col-xs-12 col-xl-2 col-lg-2">
			<div class="invoice_label_up">			
						<input type="text" class="form-control" id="middleName"  required />
						<label >Middle Name:<sup>*</sup></label>
					</div>
			</div>
		<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
		<div class="col-md-6   col-sm-12 col-xs-12 col-xl-2 col-lg-2">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="lastName"  onchange="checkForDuplicateWaiterEntry()" required />
						<label >Last Name:<sup>*</sup></label>
					</div>
					</div>					
				</div>
			</div>
<div class="row form-group"> 
      <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
		 <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div class="invoice_label_up">
						<!-- <input type="text" class="form-control"  id="mobileNo" maxlength="10" pattern="[0-9]{10,10}" placeholder="Mobile Number" onkeyup="" required /> -->
			<input list="mobileNo" id="mobileNo" maxlength="10" name="mobileNo" class="form-control" required  pattern="[0-9]{10,10}" title="Mobile number must 10 digit." />		
				<label>Mobile Number:<sup>*</sup></label>
			</div>
		</div>
		<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
		 <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div class="invoice_label_up">
						<input type="email" class="form-control" id="emailId"  onkeyup="" required />
						<label >Email ID :</label>
					</div>
			</div>				 
	  </div>
</div>
<div class="row form-group"> 
      <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
		 <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div class="invoice_label_up">
						<input type="date" class="form-control" id="dob" required onkeyup="" />
						<label>DOB : </label>
						
					</div>
					</div>							 
				</div>
			</div>	
								
			
				
<div class="row form-group"> 
      <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
		 <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div class="invoice_label_up">
						<input type="date" class="form-control" id="joiningDate" required onkeyup="" />
						<label >Joining Date : </label>
					</div>
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div class="invoice_label_up">
						<!-- <div class="input-group">
							<span class="input-group-addon">Rs</span> -->
							<input type="text" class="form-control"   maxlength="8"  id="salary" required onkeyup="" />
		
							<label >Salary:<sup>*</sup></label>
						<!-- </div> -->
					</div>				 
				</div>
			</div>
		</div>		
				
				
<div class="row form-group"> 
      <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
		 <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div class="invoice_label_up">
						<input type="text" class="form-control" id="address" required onkeyup="" />
							<label >Address :<sup>*</sup></label>
					</div>								 
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
		 <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div class="invoice_label_up">
						<input type="text" class="form-control" id="city" required onkeyup=""  />
						<label>City : </label>
					</div>								 
				</div>
			</div>
		</div>	
<div class="row form-group"> 
      <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
		 <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div class="invoice_label_up">
						<input type="text" maxlength="6" class="form-control" id="zip" pattern="[0-9]{6,6}" required onkeyup=""/>
						<label>Zip Code :</label>
					</div>
					</div>								 
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
				
				 <div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
				<div class="invoice_label_up">
						<input type="text" class="form-control" id="state" required onkeyup=""   />
						<label>State : </label>
					</div>
				</div>
			</div>								 
		</div>	
	</div>
<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:10px ; padding-bottom:35px">	
					<input type="button" class="btn btn-lg btn-success"   name="createbtn" title="Submit filled Information" onclick="addWaiter(); return false;" value="Create"/>
				
					<!-- <input type="button" value="Edit" class="btn btn-primary" title="Submit filled Information" onclick=" EditWaiter();"/> -->
					<input type="reset" class="btn btn-lg btn-danger" title="Submit filled Information" value="Reset"/>
					
					<input type="reset" class="btn btn-lg btn btn-primary" title="Submit filled Information"  onclick="EditWaiter()" value="Edit"/>
					
					<!-- <button type="reset" class="btn btn-primary" title="Submit filled Information" onclick="ListWaiter()">List</button> -->
		
					<input type="reset" class="btn btn-lg btn btn-primary" title="Submit filled Information"  onclick="ListWaiter()" value="List"/>
				</div>
			</div>
				
			</form>			

</body>
</html>

 <%@include file="common/newFooter.jsp"%> 