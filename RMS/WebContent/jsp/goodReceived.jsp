<%@page import="java.util.List"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Good Received</title>
<!-- All CSS files -->

<!-- Bootstrap css -->
<link href="/RMS/staticContent/css/bootstrap.min.css" rel="stylesheet">

<!-- custom css -->
<link href="/RMS/staticContent/css/style.css" rel="stylesheet">

<!-- All JS files -->

<!-- Bootstrap JS -->

<script src="/RMS/staticContent/js/bootstrap.min.js"></script>

<!-- custom JS -->
<script src="/RMS/staticContent/js/jquery.min.js"></script>
<script src="/RMS/staticContent/js/goodReceived.js"></script>

<%@include file="common/header.jsp"%>
</head>

<body>

	<div class="container">
		<h2 align="center" class="form-heading">Good Received</h2>
		<form class="form-horizontal" action="#" method="post"
			name="goodsReceive">
			<div class="row margin-t-13">
				<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
					<label class="control-label">Drink Name:</label>

					<%
					ItemEntryDao itemEntryDao = new ItemEntryDao();
					List iList= itemEntryDao.getAllItemEntries1(request);
					%>

				</div>
				<div class="col-md-2 col-sm-3">
					<input list="fk_item_id_drop" id="fk_item_id" class="form-control">
					<datalist id="fk_item_id_drop"> <%
				    for(int i=0;i<iList.size();i++){
					ItemEntry itemEntry = (ItemEntry)iList.get(i);
				  %>

					<option data-value="<%=itemEntry.getPk_item_entry_Id()%>"
						value="<%=itemEntry.getItemName() %>">
						<%
					}
				%>
					
					</datalist>
				</div>
			</div>

			<div class="row margin-t-13">
				<div class="col-md-offset-2 col-md-2 col-sm-offset-1 col-sm-2">
					<label class="control-label">Quantity: </label>
				</div>
				<div class="col-md-2 col-sm-3">
					<input type="text" class="form-control" id="quantity" placeholder="Quantity" onkeyup="firstNameValidation(this)" onblur="cheakEmpty(this)" required autofocus />
				</div>
			</div>

			<div align="center" class="margin-t-70">
				<button type="button" onclick="goodReceived()" name="btn" class="btn btn-lg btn-success btn-md button_hw button_margin_right">Save</button>
				<button type="reset" class="btn btn-lg btn-danger btn-md button_hw button_margin_right" title="Submit filled Information">Reset</button>
			</div>

		</form>
	</div>

</body>
</html>
   <%@include file="common/newFooter.jsp"%>