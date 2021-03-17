<%@page import="com.rms.hibernate.AddWaiters"%>
<%@page import="com.rms.dao.AddWaitersDao"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
	<%@include file="common/header.jsp"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edit waiter</title>
<!-- All CSS files -->

	 <!-- All CSS files -->
	
	 <script type="text/javascript" src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
	 <link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
     <link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
     <script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
     <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.min.js"></script>
     <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
     <script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
     <script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
     <link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
     <script src="/RMS/staticContent/js/bootstrap.min.js"></script>
     <script src="/RMS/staticContent/js/bootstrap.js"></script>
     <link rel="stylesheet" href="/RMS/staticContent/css/style.css">
     
		
		<!-- custom css -->
			<link href="/RMS/staticContent/css/style.css" rel="stylesheet">	
		<!-- custome JS -->
	
	
		<script src="/RMS/staticContent/js/addWaiter.js"></script>
			
		<script type="text/javascript">
		/* function ListWaiter();
		{
			
			 window.location="ListWaiter.jsp";
		}
		function EditWaiter(){
			window.location="EditWaiter.jsp";
		} */
		function Back(){
			window.location = "addWaiter.jsp"; 
		}
		
		</script>
		

	
</head>
<body>

	<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
		<h2 align="center" class="form-heading"><b>Edit Waiter Entry</b></h2>
		</div>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
	</div>
			<form class="form-horizontal" action="#" method="post" name="eWaiter">
			
<div class="item">
	<div class="row form-group"> 
		<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					
				<!-- 	<div class=" col-md-offset-1  col-2 col-sm-2 col-md-2 col-lg-2 col-xl-2"> -->
				
						
					<!-- <div class="col-sm-2">
						<input type="number" class="form-control" id="waiterId" placeholder="Enter Id" onkeyup="" required autofocus />
						<input type="text" class="form-control" id="waiterId" placeholder="Enter Id"  />
					</div> -->
						<!-- <div class="input-group"> -->
						<!-- 	<span class="input-group-addon"> <i
								class="glyphicon glyphicon-road"></i>
							</span> -->
							<%
							AddWaitersDao itemEntryDao = new AddWaitersDao();
						List iList= itemEntryDao.getAllWiterList(request);
						%>

							<input list="fk_item_id_drop" id="fk_item_id"
								class="form-control" onchange="getAllWaiterDetails()" autofocus="autofocus" required>
							<datalist id="fk_item_id_drop">

								<%
					         for(int i=0;i<iList.size();i++){
					        	 AddWaiters itemEntry = (AddWaiters)iList.get(i);
				              %>

								<option data-value="<%=itemEntry.getPkAddWaiterId()%>"
									value="<%=itemEntry.getFirstName()%> <%=itemEntry.getMiddleName()%> <%=itemEntry.getLastName()%>"
									 >
									<%
					           }
				                %>
								
								
							</datalist>
							<label>Select Waiter Name:</label>
					</div>
						<!-- </div> -->
					</div>
			<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
 		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="waiterID" required/>
						<label>Waiter ID :<sup>*</sup></label>
					</div>  
				</div>
		</div>
	</div>
	
				
				
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-2 col-lg-2">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="firstName"  onkeyup="" required  />
						<label>First Name:<sup>*</sup></label>
					</div>
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-2 col-lg-2">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="middleName" required  />
						<label>Middle Name:<sup>*</sup></label>
					</div>
				</div>
			<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
			<div class="col-md-6 col-sm-12 col-xs-12 col-xl-2 col-lg-2">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="lastName" required/>
						<label>Last Name:<sup>*</sup></label>
					</div>					
				</div>
			</div>
		</div>
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="mobileNo" maxlength="10" required/>
						<label>Mob Number:<sup>*</sup></label>
					</div>
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="email" class="form-control" id="emailId" required/>
						<label>Email ID : </label>
					</div>				 
				</div>
			
		</div>	
	</div>
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">	
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" class="form-control" id="dob" required/>
							<label>DOB : </label>
					</div>							 
				</div>	
			</div>
		</div>	
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">
		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="">
						<input type="date" class="form-control" id="joiningDate" required/>
						<label>Joining Date : </label>
				</div>
			</div>
			<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<!-- 	<div class="input-group"> --> 
<!-- 							<span class="input-group-addon">Rs</span> -->
							<input type="text" class="form-control" maxlength="10" id="salary" required/>
							<label>Salary :<sup>*</sup></label>
					</div>				 
				</div>
			</div>
		</div>
				
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">
		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="address" required/>
						<label>Address :<sup>*</sup></label>
					</div>								 
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="city" required/>
						<label>City : </label>
					</div>								 
				</div>
			</div>
		</div>		
<div class="row form-group"> 
	<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">
		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="zip" maxlength="6" required/>
						<label>Zip Code : </label>
					</div>								 
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12 col-xl-1 col-lg-1"></div>
		<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
						<input type="text" class="form-control" id="state" required/>
						<label>State : </label>
					</div>								 
				</div>	
			</div>
		</div>
	</div>


		<div class="ibutton">
	<div class="row" align="center" style="margin-bottom:50px ; padding-bottom:35px">	
				<input type="button" class="btn btn-lg btn btn-success" name="createbtn"  title="Submit filled Information" onclick="UpdateWaiter(); return false;" value="Update"/>
		
					<!-- <input type="button" value="print bill" class="btn btn-success" title="Submit filled Information" onclick=" addWaiter();"/> -->
		
				<input type="reset" class="btn btn-lg btn btn-danger"  title="Submit filled Information" value="Clear"/>
		
					<input type="reset" class="btn btn-lg btn btn-primary"  title="Submit filled Information" onclick="Back()" value="Back"/>
					<!-- <button type="reset" class="btn btn-primary"title="Submit filled Information" onclick="EditWaiter()">Edit</button>
					<button type="reset" class="btn btn-primary" title="Submit filled Information" onclick="ListWaiter()">List</button> -->
				</div>
				</div>
			
			</form>			

</body>
</html>

 <%@include file="common/newFooter.jsp"%> 