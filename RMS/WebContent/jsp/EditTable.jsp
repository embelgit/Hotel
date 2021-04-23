<%@page import="com.rms.hibernate.kitchenorderHibernate"%>
<%@page import="com.rms.bean.kitchenOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.rms.dao.OrderBillDao"%>
<%@page import="com.rms.hibernate.OrderBill"%>	

<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Move Table</title>

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
<script src="/RMS/staticContent/js/orderBill.js"></script>

<%@include file="common/header.jsp"%>
<script type="text/javascript">
							
							function back(){
								 window.location = "OrderBill.jsp";
							}
						</script>

</head>
<body>

<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
				<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
		<h2 align="center" class="form-heading"><b>Edit Table</b></h2>
		</div>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
	</div>
	<form class="form-horizontal" name="editTableNumber">
<!-- 		<form class="form-horizontal" action="#" method="post" name="tablenumber">
 -->
		<div class="item">
	<div class="row form-group"> 
<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					
			
						<%
						OrderBillDao Dao = new OrderBillDao();
						List iList= Dao.gettableEdit(request);
						%> 
					
						<input type="text" list="fk_table_id_drop1" id="fk_table_id"
								class="form-control" onchange="gettablenumbers()" autofocus="autofocus" required>
							 <datalist id="fk_table_id_drop1">

								<%
									for(int i=0;i<iList.size();i++){
								   	kitchenorderHibernate bean = (kitchenorderHibernate) iList.get(i);
								%> 

								<option data-value="<%=bean.getPk_temp_id()%>"
									value="<%=bean.getTableNo()%>">
								
									<%
					           }
								%> 
							</datalist>
							<label>Select Table number :<sup> *</sup> </label>
						</div>
						</div>
						
						
				<!-- <div class="col-md-2 col-sm-3" style="margin-left: -70px">
					<input type="text" class="form-control" id="hotelname"
						placeholder="Hotel Name" required autofocus />
				</div> -->

		
			
			<div class="col-md-6  col-md-offset-1 col-sm-12 col-xs-12 col-xl-3 col-lg-3">
			<div class="invoice_label_up">
					<input type="number"     class="form-control"  name="tablename" id="tablename" required autofocus />
				<label >New Table Number : <sup>*</sup> </label>
				</div>

			</div>
		</div>
</div>
</div>
	<div class="ibutton">
	<div class="row" align="center">

			<input  type="button" title="Submit filled Information" class="btn btn-lg btn-success btn-md button_hw button_margin_right" name="createbtn" value="Update" onclick="updateTable()" />		
	
		<input  type="reset" title="Submit filled Information" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" value="Back" onclick="back()"/>
		</div>	
	</div>


		</form>

</body>
</html>

<%@include file="common/newFooter.jsp"%>