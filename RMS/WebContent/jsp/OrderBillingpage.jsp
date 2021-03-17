<%@page import="com.rms.dao.AddWaitersDao"%>
<%@page import="com.rms.hibernate.AddWaiters"%>
<%@page import="com.rms.hibernate.ItemEntry"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.helper.TempItemDetailHelper"%>
<%@page import="com.rms.hibernate.TempItemDetail"%>
<%@page import="java.util.List"%> 
<%@page import="com.rms.bean.CustomerBean" %>
<%@page import="com.rms.dao.CustomerOrderDao" %>
<%@page import="com.rms.bean.orderBillbean" %>
<%@page import="com.rms.hibernate.CustomerOrder" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<% boolean isHome=false;%>
 <%@include file="common/header.jsp"%>


<head>
<meta charset="ISO-8859-1">
<title>Fresh Order Bill</title>

<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

	<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
     
    <link rel="stylesheet" href="/RMS/staticContent/y_css/jquery-ui.css">
  	<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
<script src="/RMS/staticContent/js/orderBillTT.js"></script>
<script src="/RMS/staticContent/js/split.min.js"></script>

<script type="text/javascript">
$(function() {
	Split([ '#tableArea', '#tableArea1' ], {
		sizes : [ 70, 30 ],
		minSize : 300
	});
	
	
	 var ChangeTbody = $('#mainTable').children('tbody');

	    //Then if no tbody just select your table 
	    var Change = ChangeTbody.length ? ChangeTbody : $('#mainTable');
	
	$('#table_No').click(function(){
		debugger
        //Add row
		 var rowCount= $('#mainTable tr').length;
		 //rowCountFacility = rowCountFacility-2;
			
		 
		ChangeTbody.append(' <tr id="tableRow'+rowCount+'" style="border: 1px solid black">'+
				 	'<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="6%"><span class="content" ><button type="button" id="'+rowCount+'" class="removebutton btn btn-link"><span class="glyphicon glyphicon-remove"></span></button></span></td>'+
		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="itemName'+rowCount+'" class="form-control no_border" placeholder="Enter Item Name"></span></td>'+
		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="itemName'+rowCount+'" class="form-control no_border" placeholder="Enter Item Name"></span></td>'+
		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="itemName'+rowCount+'" class="form-control no_border" placeholder="Enter Item Name"></span></td>'+
		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="itemName'+rowCount+'" class="form-control no_border" placeholder="Enter Item Name"></span></td>'+
		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="itemName'+rowCount+'" class="form-control no_border" placeholder="Enter Item Name"></span></td>'+
		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="itemName'+rowCount+'" class="form-control no_border" placeholder="Enter Item Name"></span></td>'+
		            
		        '</tr>').insertBefore('#tableRow2');
	
    }) 
	
})

</script>
</head>
<body>

<div class="container-fluid" id="placeholder">
		
		<div class="example-1"
			style="padding-top: 15px;">
			<div class="col-lg-8 col-md-8" style="margin-top: 15px; height:400px; overflow-x: none;overflow-y: auto;"
				id="tableArea">
				<table class="table table-bordered table-striped table-hover protable" id="mainTable">
					<tbody>
		        <tr id="facilitytableHeading">
		         	<th style="border: none;min-width: 50px;height: 21px;" width="3%"><span class="content"></span></th> 
		            <th style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content">Item Name <em>*</em></span></th>
		            <th style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content">Quantity</span></th>
		            <th style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content">Unit Price <em>*</em></span></th>
		            <th style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content">unit in ml<em>*</em></span></th>
		            <th style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content">Total</span></th>
		            <th style="border: 1px solid black;min-width: 50px;height: 21px;" width="10%"><span class="content">Stock</span></th>
		           
		        </tr>
		       
		        <tr id="tableRow2">
 		        	<td style="border: none;min-width: 50px;height: 21px;" width="3%"><span class="content" id="FCTDEL2" ></span></td> 
		            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="FCTA2" ><b>Total</b></span></td>
		            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="FCTAB2" ></span></td>
		            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="FCTB2" ></span><span class="content" id="FCTBAMT2" ></span></td>
		            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="FCTC2" ></span><span class="content" id="FCTCAMT2" ></span></td>
		            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="FCTCDA2" ></span></td>
		            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="10%"><span class="content" id="FCTF2" ></span></td>	            
		              
		        </tr>	        
		    </tbody>
				</table>
			</div>
			
			<%
						ItemEntryDao itemEntryDao = new ItemEntryDao();
						List iList= itemEntryDao.getAllItemEntriesForOrderBill(request);
						
						%>
			<div class="col-lg-4 col-md-4" style="margin-top: 15px; height:400px; overflow-x: none;overflow-y: auto;"
				id="tableArea1">
				<!-- <div class="container" align="right">
			<div class="row" style="margin-right: 10px; margin-top: 10px"> -->
			<%
						for(int i=0;i<iList.size();i++){
						ItemEntry itemEntry = (ItemEntry)iList.get(i);
					
						%>
			
			
			
			 <button class="btn btn-primary" name="p" style="height:100px;width:100px; padding: 10px;" id="table_No"  value="<%=itemEntry.getPk_item_entry_Id()%>"><%=itemEntry.getItemName()%> <%=itemEntry.getPk_item_entry_Id()%></button>
							
				        <%
					       }
				        %>				

					</div>
				</div>

				</div>
	

</body>
</html>