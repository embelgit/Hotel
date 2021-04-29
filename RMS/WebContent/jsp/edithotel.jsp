<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.rms.dao.hotelnamedao"%>
<%@page import="com.rms.hibernate.hotelnamebean"%>	
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Hotel</title>

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
<script src="/RMS/staticContent/js/hotelname.js"></script>

<%@include file="common/header.jsp"%>
<script type="text/javascript">
							
							function back(){
								 window.location = "hotelname.jsp";
							}
						</script>

</head>
<body>

<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
				<div class="heading">
		<h2 align="center" class="form-heading"><b>Edit Hotel</b></h2>
		</div>
		<hr>		
</div>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
	</div>
		<form class="form-horizontal" action="#" method="post" name="hotelname">

		<div class="item">
	<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					
			
						<%
						hotelnamedao Dao = new hotelnamedao();
						List iList= Dao.gethotelname(request);
						%>
					
						<input list="fk_hotel_id_drop" id="fk_hotel_id"
								class="form-control" onchange="gethotelnamees()" autofocus="autofocus" required>
							<datalist id="fk_hotel_id_drop">

								<%
					         for(int i=0;i<iList.size();i++){
						     hotelnamebean bean = (hotelnamebean)iList.get(i);
				              %>

								<option data-value="<%=bean.getPk_id()%>"
									value="<%=bean.getHotelname()%>">
									<%
					           }
				                %>
								
							</datalist>
							<label>Select Hotel Name :<sup> *</sup> </label>
						</div>
						</div>
						
						
				<!-- <div class="col-md-2 col-sm-3" style="margin-left: -70px">
					<input type="text" class="form-control" id="hotelname"
						placeholder="Hotel Name" required autofocus />
				</div> -->

		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<input type="text" class="form-control" id="hotelname" required autofocus />
				<label >Hotel Name : <sup>*</sup> </label>
				</div>

			</div>
		</div>
</div>
</div>
	<div class="ibutton">
	<div class="row" align="center">

			<input  type="button" title="Submit filled Information" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="createbtn" value="Update" onclick="updatehotel()" />		
	
		<input  type="reset" title="Submit filled Information" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Back" onclick="back()"/>
		</div>	
	</div>


		</form>

</body>
</html>

<%@include file="common/newFooter.jsp"%>