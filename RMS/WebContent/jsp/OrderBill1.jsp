<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Bill</title>

<%@include file="common/header.jsp"%>

<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<script src="/RMS/staticContent/js/orderBill.js"></script>

<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
<script src="/RMS/staticContent/js/jquery.min.js"></script>
<script src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>

<link href="/RMS/staticContent/css/style.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<h2 align="center" class="form-heading">Order Bill</h2>

		<div class="row">

			<!-- Manual Order -->

			<div class="col-md-2">
				<h4 align="center" style="color: purple;">Book Table</h4>
				<div class="row">
					<div class="col-md-4">
						<label class="control-label">Waiter:</label>
					</div>
					<div class="col-md-8">
						<select class="form-control" name="waiterName" id="waiterNameID">
							<option value="selected">--Select Waiter--</option>
							<option value="supplier">Dynamic</option>
						</select>
					</div>
				</div>

				<div class="row margin-t-13">
					<div class="col-md-4">
						<label class="control-label">Table:</label>
					</div>
					<div class="col-md-8">
						<input type="number" class="form-control" id="table_No"
							placeholder="Enter Table Number" required />
					</div>
				</div>

				<div class="row margin-t-13">
					<form class="form-horizontal" action="#" method="post" name="order">
						<div class="col-md-4">
							<label class0="control-label">Item:</label>
						</div>

						<%
						ItemEntryDao itemEntryDao = new ItemEntryDao();
						List iList= itemEntryDao.getAllItemEntries();
						%>

						<div class="col-md-8">
							<input list="fk_item_id_drop" id="fk_item_id"
								class="form-control" onchange="return  shree()">
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
					</form>
				</div>
				<!-- <div class="row margin-t-13">
					<div class="col-md-6">
						<label class="control-label">Quantity:</label>
					</div>
					<div class="col-md-6">
						<input type="number" class="form-control" id="quantity1" onchange="updateItem()"
								placeholder="Quantity Number" required />
					</div>
				</div> -->

				<div class="row">
					<div align="center" class="margin-t-50 margin-b-13">
						<button class="btn btn-success btn-md">Save</button>
						<button class="btn btn-primary btn-md">Order</button>
						<button class="btn btn-danger btn-md">Clear</button>
					</div>
				</div>

			</div>

			<!-- Order bill data table -->

			<div class="col-md-6">
				<h4 align="center" style="color: purple;">Ordered Items</h4>
				<div class="table-responsive">

					<table id="list"></table>
					<div id="jqGridPager"></div>

				</div>

				<div class="row margin-t-13">
					<div class="col-md-6">
						<label class="control-label">Total Amount: </label>
					</div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="totalAmount"
							placeholder="Total Amout" readonly="readonly" />
					</div>
				</div>

			</div>

			<!-- Table number -->

			<div class="col-md-4">
				<h4 align="center" style="color: purple;">Select Table</h4>
				<div class="row" align="center">
					<div>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="1"
							onclick="rohan(this)">1</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="2"
							onclick="rohan(this)">2</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="3"
							onclick="rohan(this)">3</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="4"
							onclick="rohan(this)">4</button>
					</div>
				</div>

				<div class="row" align="center">
					<div style="padding-top: 15px;">
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="5"
							onclick="rohan(this)">5</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="6"
							onclick="rohan(this)">6</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="7"
							onclick="rohan(this)">7</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="8"
							onclick="rohan(this)">8</button>
					</div>
				</div>

				<div class="row" align="center">
					<div style="padding-top: 15px;">
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="9"
							onclick="rohan(this)">9</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="10"
							onclick="rohan(this)">10</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="11"
							onclick="rohan(this)">11</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="12"
							onclick="rohan(this)">12</button>
					</div>
				</div>

				<div class="row" align="center">
					<div style="padding-top: 15px;">
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="13"
							onclick="rohan(this)">13</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="14"
							onclick="rohan(this)">14</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="15"
							onclick="rohan(this)">15</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="16"
							onclick="rohan(this)">16</button>
					</div>
				</div>

				<div class="row" align="center">
					<div style="padding-top: 15px;">
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="17"
							onclick="rohan(this)">17</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="18"
							onclick="rohan(this)">18</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="19"
							onclick="rohan(this)">19</button>
						<button class="btn btn-primary"
							style="height: 75px; width: 75px; padding: 10px;" value="20"
							onclick="rohan(this)">20</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>
