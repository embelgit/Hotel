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
<title>Insert title here</title>

<link rel="stylesheet" href="/RMS/staticContent/css/style.css">

	<link rel="stylesheet" href="/RMS/staticContent/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.min.css">
     
    <link rel="stylesheet" href="/RMS/staticContent/y_css/jquery-ui.css">
  	<link rel="stylesheet" href="/RMS/staticContent/css/ui.jqgrid.css">
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.min.js"></script>
   <!--  <script type="text/javascript" src="/RMS/staticContent/js/jquery-ui.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jqueryUi.js"></script>
    <script type="text/javascript" src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script> -->
<script src="/RMS/staticContent/js/orderBillTT.js"></script>
<script src="/RMS/staticContent/js/split.min.js"></script>

<script type="text/javascript">
$(function(){

	Split([ '#tableArea', '#tableArea1' ], {
		sizes : [ 70, 30 ],
		minSize : 300
	});
	
	$("body").on('focus', ":input", function (){
		
		$("[id*=quantity]").on('input',function (){
			
			var output = 0;
			for(j = 2; j<= $('#mainTable tr').length; j++){
	        	
				if($("#quantity"+j).val()){
					output = +output + +$("#quantity"+j).val();
	        	}
	        	    	
			        	
			 }
			
			$('#total1').html(output);
			
		});
	
	});
	
	
	 var ChangeTbody = $('#mainTable').children('tbody');

	    //Then if no tbody just select your table 
	    var Change = ChangeTbody.length ? ChangeTbody : $('#mainTable');
	
	$('.table_No').click(function(){
		
        //Add row
		 var rowCount= $('#mainTable tr').length;
        
        var name = $(this).val();
		var present = 0;
		var quantity = 1;
		var total1 = 0;
		 
        for(i = 2; i<= $('#mainTable tr').length; i++){
        	
        	if($("#itemName"+i).val()){
        		
        		if($("#itemName"+i).val() === name){
        			present = 1;
        			quantity = +quantity + +$("#quantity"+i).val();
        			break;
        		}
        	}		
        	
        }	
        
		  for(j = 2; j<= $('#mainTable tr').length; j++){
		        	
			if($("#quantity"+j).val()){
        		total1 = +total1 + +$("#quantity"+j).val();
        	}
        	    	
		        	
		   }	
        	
        	if(present == 1){
        		
    		 $('#quantity'+i).val(quantity);
    		 total1 = +total1 + 1;
    		 $('#total1').html(total1);
    		 
        	}
        	else {
        		
        		$(' <tr id="tableRow'+rowCount+'" style="border: 1px solid black">'+
    				 	'<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="6%"><span class="content" ><button type="button" id="'+rowCount+'" class="removebutton btn btn-link"><span class="glyphicon glyphicon-remove"></span></button></span></td>'+
    		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="itemName'+rowCount+'" class="form-control no_border" placeholder="Enter Item Name"></span></td>'+
    		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="quantity'+rowCount+'" class="form-control no_border" placeholder="Enter Quantity"></span></td>'+
    		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="unitprice'+rowCount+'" class="form-control no_border" placeholder="Enter Unit Price"></span></td>'+
    		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="unitinml'+rowCount+'" class="form-control no_border" placeholder="Enter Unit In Ml"></span></td>'+
    		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="total'+rowCount+'" class="form-control no_border" placeholder="Enter Total"></span></td>'+
    		            '<td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" ><input type="text" id="stock'+rowCount+'" class="form-control no_border" placeholder="Enter Stock"></span></td>'+
    		            
    		        '</tr>').insertBefore('#tableRow2');
    		
    		 $('#itemName'+rowCount).val(name);
    		 $('#quantity'+rowCount).val(quantity);
    		 
    		 total1 = +total1 + 1;
    		 $('#total1').html(total1);
    		 $('#itemName'+rowCount).attr('readonly', true); 
        		
        	}
       
		
	
    });

});

</script>
</head>
<body>

<div class="container-fluid" id="placeholder">
		
		<div class="example-1"
			style="padding-top: 15px;">
			<div class="col-lg-8 col-md-8" style="margin-top: 15px; height:600px; overflow-x: none;overflow-y: auto;"
				id="tableArea">
				<table class="ex2" id="mainTable">
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
				            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="total" ><b>Total</b></span></td>
				            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="total1" ></span></td>
				            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="total2" ></span><span class="content" id="FCTBAMT2" ></span></td>
				            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="total3" ></span><span class="content" id="FCTCAMT2" ></span></td>
				            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="15%"><span class="content" id="total4" ></span></td>
				            <td style="border: 1px solid black;min-width: 50px;height: 21px;" width="10%"><span class="content" id="total5" ></span></td>	            
				              
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
					//	GoodsReceiveBean goodrecieve = (GoodsReceiveBean)iList.get(i);
						%>
			
			
			
			 <button class="btn btn-primary table_No" name="p" style="height:100px;width:100px; padding: 10px;" id="table_No"  value="<%=itemEntry.getItemName()%><%=itemEntry.getPk_item_entry_Id()%>"><%=itemEntry.getItemName()%></button>
							
				        <%
					       }
				        %>				

					</div>
				</div>

				</div>
	

</body>
</html>