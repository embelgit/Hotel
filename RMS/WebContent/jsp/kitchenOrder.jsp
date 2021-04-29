<%-- <%@include file="common/header.jsp"%> --%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.rms.bean.GetItemDetails"%>
<%-- <%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.hibernate.ItemDetails"%> --%>
<%@page import="com.rms.dao.TempItemDetailDao"%>
<%@page import="com.rms.hibernate.TempItemDetail" %>
<%@page import="java.util.List"%>
<% boolean isHome=false;%>
<%@include file="common/header.jsp"%>

		<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
		<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/style.css">
		
		<script type="text/javascript" src="/RMS/staticContent/js/selectjj.js"></script>
		<!-- <script type="text/javascript" src="/RMS/staticContent/js/buttom.js"></script> -->
		<script src="/RMS/staticContent/js/jquery.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
		<script src="/RMS/staticContent/js/jquery.dataTables.js" type="text/javascript"></script>
		<script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
		

		
		
		<link href="/RMS/staticContent/css/dataTa.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/RMS/staticContent/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css" media="all">
		<link href="/RMS/staticContent/css/select.css" rel="stylesheet" type="text/css" media="all">
	<!-- 	<link href="/RMS/staticContent/css/button.css" rel="stylesheet" type="text/css" media="all"> -->
		<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
		<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
		<script src="/RMS/staticContent/js/kitchenOrder.js"></script>
<!-- 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>	 -->
  		 	 <meta http-equiv="refresh" content="5"/> 

<html>
<head>

<title>Kitchen Order</title>

<script>
 
 setTimeout(function(){
	   window.location.reload(true);
	}, 5000);	
 
 /* 	 setInterval(function() {
				$('#demo_jui').load('kitchenOrder.jsp');
			}, 5000); */
 		 
  			/* function Back()
  			{
  				window.location = "OrderBill.jsp" ;
  			} */
  		
		    			
  	
  			/*		$document.ready(function(){
  	 			refresh();
  			})
  		function refresh(){
  		     var auto = setInterval(function () 
  				   setTimeout( funtion() {
					
  		          $('#demo_jui').fadeOut("slow").load('kitchenOrder.jsp').fadeIn("slow");
  		        refresh();
  				   }, 3000); */ // refresh every 5000 milliseconds
  			 		
  			
  			
  		</script>
<!-- <script>
$(function worker(){
    // don't cache ajax or content won't be fresh
    $.ajaxSetup ({
        cache: false,
        complete: function() {
          // Schedule the next request when the current one's complete
          setTimeout(worker, 5000);
        }
    });
   // var ajax_load = "<img src='http://automobiles.honda.com/images/current-offers/small-loading.gif' alt='loading...' />";
    
    // load() functions
    var loadUrl = "http://localhost:8083/RMS/jsp/kitchenOrder.jsp";
    
    $("#demo_jui").html(ajax_load).load(loadUrl);

// end  
});
</script> -->

	
</head>

  <script type="text/javascript"> 
		$(document).ready(function () {
	         var table=$("#list").dataTable();
			 var tableTools = new $.fn.dataTable.TableTools(table, {
				 'sSwfPath':'//cdn.datatables.net/tabletools/2.2.4/swf/copy_csv_xls_pdf.swf',
				 	'aButtons':['copy','print','csv',{
					 'sExtends':'xls',
					 'sFileName':'Data.xls',
					 'sButtonText': 'Save to Excel'
						 
						}
					]
			 
				});
			 $('.dataTable_paginate').hide()
			 $(tableTools.fnContainer()).insertBefore('#list_wrapper');
			});
	</script>  

<body id="dt_example" style="min-height: 300px;">

	<div class="row">
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		<!-- <div align="center">
		<div class="heading">
			<h2 class="form-name style_heading"><b>Kitchen Order</b></h2>
			</div>
			<hr>
		</div>

		<div class="row">
			<div class="col-sm-offset-1 col-md-10">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>
	</div>

	              

	<div id="date">
		<label id="demo">Date : </label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div> -->
	<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12">
			<div class="heading">	
			<h2 align="center" class="form-heading" ><b>Kitchen Order</b></h2>
			</div>
				<hr>
		</div>
		
	
		</div>
		<div class="row">
		<!-- <div class="col-md-12 col-lg-2 col-xl-2 col-sm-12"> -->
		
			<div class="form-group" align="right" style="margin-right: 331px;">
					<div id="date">
						<label id="demo"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
			<!-- 	</div> -->
			</div>
		<div class="col-md-12 col-lg-4 col-xl-4 col-sm-12"></div>
		</div>
               <%   
	               TempItemDetailDao dao = new TempItemDetailDao();
						List list12 = dao.getkitchenOrder(request);
					%>
	<div id="demo_jui">
		<table id="list" class="display" align="center" border="1">
			<thead>
				<tr>
<!-- 					<th>No</th>
 -->					<th>Table No</th>	
					<th>Item Name</th>
					<th>Quantity</th>
					<th>Value</th>
					<th>Unit</th>
					<!-- <th>Cooking Status</th>
					<th>Submit</th> -->
				</tr>
			</thead>
	
	 		<tbody>
				
				<%
				int num =1;
					for(int i=0;i<list12.size();i++){
						TempItemDetail sr=(TempItemDetail)list12.get(i);

						
						%>

				<tr>
						
					<td class="align"><%=sr.getTableNo() %></td>
					<td class="align"><%=sr.getItemName()%></td>
					<td class="align"><%=sr.getQuantity()%></td>
					<td class="align"><%=sr.getValue()%></td>
					<td class="align"><%=sr.getUnit()%></td>
	 	 	<!-- <td>
		 	<input type="radio" name="cooking" id="cooked">
    		<label for="cooked">Cooked</label>
    		<br><br>
    		<input type="radio" name="cooking" id="un-cooked">
    		<label for="un-cooked">Un-cooked</label>

    		</td> -->
	<!-- 	<td>
			<input style="height: 45px; width: 180; font-size: 20" type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" value="Save" id="submit" class="btn btn-primary" onclick="save()" />			
				
		</td> --> 
				
				</tr>

						
				<%
					}
				%>  
			</tbody>  
		</table>
	</div>
<br>
	<!-- <div class="wrapper" align="center"  style="padding-bottom: 50px; padding-top: 20px;" >
		<input style="height: 45px; width: 180; font-size: 25" type="button" class="btn btn-lg btn-success btn-md button_hw button_margin_right" value="Back" id="listBtn" class="btn btn-primary" onclick="Back()" />
	</div> -->
	<div class="row" align="center" style="padding-bottom:50px">		
	<input type="button" class="btn btn-lg btn-success btn-md " name="btn" value="Order" onclick="deltorder()">		
	
  </div>
</body>

</html>

<%@include file="common/newFooter.jsp"%>
