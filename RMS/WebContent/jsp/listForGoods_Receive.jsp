<%@page import="com.rms.bean.GoodsReceiveHibernateBean"%>
<%@page import="com.rms.bean.GoodsReceiveBean"%>
<%@page import="java.util.List"%>
<%@page import="com.rms.dao.GoodsReceiveDao"%>
<%@page import="com.rms.hibernate.GoodsReceiveHibernate"%>
<html>
<head>
<title>List For Good Receive</title>
<script src="/RMS/staticContent/js/goodsReceive.js"></script>
<script type="text/javascript">
	 function Back() {
			 window.location = "Goods_Receive.jsp";
	}

</script>
<!-- For datatable to pdf,print,excel etc conversion -->
<!-- <script type="text/javascript" src="/RMS/staticContent/jsForReport/jquery-1.12.4.js"></script>
<script type="text/javascript" src="/RMS/staticContent/jsForReport/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/jsForReport/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/jsForReport/buttons.flash.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/jsForReport/jszip.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/jsForReport/pdfmake.min.js"></script>

<script type="text/javascript" src="/RMS/staticContent/jsForReport/vfs_fonts.js"></script>
<script type="text/javascript" src="/RMS/staticContent/jsForReport/buttons.html5.min.js"></script>
<script type="text/javascript" src="/RMS/staticContent/jsForReport/buttons.print.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/cssForReport/jquery.dataTables.min.css">
<link rel="stylesheet" href="/RMS/staticContent/cssForReport/buttons.dataTables.min.css"> -->

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
<script src="/RMS/staticContent/js/listgoodsRecieve.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/css/style.css">


<style type="text/css">
td {
	color: black;
}
</style>

<script>

		$(document).ready(function(){
			goodsReieve();
		});

</script>

</head>

<div class="container" style="min-height: 300px;">

	<div class="row header_margin_top">
		<div align="center">
			<h2 class="form-name style_heading" style="margin-top: 5px">Goods Receive List</h2>
		</div>
	</div>

	<div class="row">
		<div class="form-group" align="right">
			<div class="col-sm-offset-6 col-md-5 control-label">
				<div id="date">
					<label id="demo"></label>
					<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-offset-1 col-md-10">
			<hr style="border-top-color: #c1b1b1;">
		</div>
	</div>

 	 <%
	GoodsReceiveDao dao=new GoodsReceiveDao();
	List list12=dao.getAllGoodsReceiveList(request);
	%>  

<!-- 	<div id="date">
		<label id="demo"></label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div> -->

	<div id="demo_jui">
		<div class="table-responsive">
			<table id="list5" class="table table-bordered display">
				<thead>
					<tr>

						<th>Supplier Name</th>
						<th>Bill No</th>
						<th>Item Name</th>
						<th>Buy Price</th>
						<th>Sale Price</th>
						<th>Quantity</th>
						<th>GST</th>
						<th>Gross Total</th>
						<th>Date Of Goods Receive</th>
					</tr>
				</thead>
					
<!-- 				<tfoot>
						<tr>
							<th colspan="7" style="text-align: right">Total:</th>
							<th></th>
							
						
							<th></th>
						</tr>
					</tfoot>	 -->
					
					
					
				<tbody>
				 	<%
					for(int i=0;i<list12.size();i++){
						GoodsReceiveHibernateBean sr=(GoodsReceiveHibernateBean)list12.get(i);
				%> 

				  	<tr>

						<td class="align"><%=sr.getSuplierName()%></td>
						<td class="align"><%=sr.getBillno()%></td>
						<td class="align"><%=sr.getFk_item_id_drop1()%></td>
						<td class="align"><%=sr.getBuyPrice()%></td>
						<td class="align"><%=sr.getSale_Price() %></td>
						<td class="align"><%=sr.getQuantity()%></td>
						<td class="align"><%=sr.getGst()%></td>
						<td class="align"><%=sr.getGrossTotal()%></td>
						<td class="align"><%=sr.getGoodsReceiveDate()%></td>

					</tr>  

				 	<%
					}
				%> 
				</tbody>
			</table>
		</div>
	</div>
</div>
<div class="ibutton">
	<div class="row" align="center">
		<input type="button" 
			value="Back" id="listBtn" class="btn btn-lg btn-primary" onclick="Back()" />
		</div>	
	</div>

	<%@include file="common/newFooter.jsp"%>

