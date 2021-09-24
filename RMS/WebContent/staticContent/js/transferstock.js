//grid for Transfer Stock
function getGridForTransferStock(){
	var params= {};
	var count=0;
	var newrow;
	var rowId;

	
	
	var id=$("#fk_item_id1").val(); 

	var itemname= $('#fk_item_id_drop1').find('option[data-value="' +id + '"]').attr('value');
	var abc = itemname;
	if(abc == undefined){
		document.getElementById('fk_item_id1').value=id;

	}
	if(abc != undefined){
	document.getElementById('fk_item_id1').value=itemname;

	}

	var input = document.getElementById('fk_item_id1'),
    list = document.getElementById('fk_item_id_drop1'),
    i,fk_item_id1;
	for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input.value) {
    	fk_item_id1 = list.options[i].getAttribute('data-value');
    }
}
	
	
//	var fk_item_id1 = $('#fk_item_id1').val();
	params["fk_item_id1"] = fk_item_id1;
	params["methodName"] ="gridForTranforStock";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
		  var jsonData = $.parseJSON(data);
			
	     $.each(jsonData,function(i,v)
			{
	         count = jQuery("#list4").jqGrid('getGridParam','records'); 
		     var rowdata =$("#list4").jqGrid('getGridParam','data');
		     var ids = jQuery("#list4").jqGrid('getDataIDs');
			 var prodName,com,packing,unit;
			  var idd;
			 for (var j = 0; j < count; j++) 
			  {
			//	  prodName = rowdata[j].fk_item_id_drop1;
				  idd = rowdata[j].pk_item_entry_Id;
				  
				  var rowId = ids[j];
				 var rowData = jQuery('#list4').jqGrid ('getRowData', rowId);
				/* var setZero = 0; 
	 	     		$("#list4").jqGrid("setCell",rowId,"quantity",setZero);
				 	$("#list4").jqGrid("setCell",rowId,"gst",setZero);  */ 
				 
//				if (prodName==jsonData.offer.productName) {
			    if(idd == fk_item_id1){	
					newrow=false;
					alert("item Name Already Inserted !!!");
					var grid = jQuery("#list4");
				    grid.trigger("reloadGrid");
			    	break;
				}  
				else
				{
					newrow = true;
					/*  var setZero = 0; 
			     		$("#list4").jqGrid("setCell",rowId,"quantity",setZero);*/
				}

			  }
				
			  if(newrow == true)
				 {
				  $("#list4").addRowData(count,jsonData.offer);
				 }
			  		
			  

			  document.getElementById('fk_item_id1').value = "";

			  
				/*$(document).ready(function () {
					var lastsel;
					rownumbers: true,*/

			  
		$("#list4").jqGrid({
			datatype: "local",
			
			colNames:["Item Name","Purchase Price","Sale Price", "Quantity", "pk_item_entry_Id","stock", "stockhide"],
			colModel:[ 
				
/*			     {	name:'fk_item_id_drop1',
			    	 width:150,
				},*/
				{
					name: 'itemName',
					width: 150,
				},
				
				{	name:'buyPrice',
			    	 width:150,
			    	 editable: true
				},
				
				{	name:'salePrice',
			    	 width:150,
			    	 editable: true
				},
				
			{
					name:'quantity',
					width:100,
					editable: true

					
				},
				
				
				/*{	name:'total',
					width:100,
					editable: false
				},*/
				
				{
					name:'pk_item_entry_Id',
					width:100,
					hidden: true	
				},
		           {
	        	    name: "stock",
		        	 width: 250,
		        	hidden:true
		       },
	           
	           {
	        	   name: "stockhide",
	        	   width: 250,
	        	   hidden: true,
	           }
				
			],
				
			sortorder : 'desc',
			loadonce: false,
			viewrecords: true,
			width: 1200,
            //height: 350,
			shrinkToFit:true,
            rowheight: 300,
            hoverrows: true,
	        rownumbers: true,
            rowNum: 10,
            'cellEdit':true,
			
         	 afterSaveCell: function  Total()
			{
			       // 	Calculation of total after editing quantity         		 			
         		 			//var count = jQuery("#list4").jqGrid('getGridParam', 'records');
         		 
         		 			var rowId =$("#list4").jqGrid('getGridParam','selrow');  
	                        var rowData = jQuery("#list4").getRowData(rowId);
	                        var quantity1 = rowData['quantity'];
	                    	var buyPrice1 = rowData['buyPrice'];
	                    	//var total = rowData['total'];
	                    	
	                    	var SalePrice = rowData['salePrice'];
	                    	
	                    	
	                    	var quantity = rowData['quantity'];
	                    	var buyPrice = rowData['buyPrice'];
	                    	
	                    	
	                    	var stock = rowData['stock'];

	                    	var stockhide = rowData['stock'];
	                    
	                    	var value = rowData['value'];
	                    	
	                    	if(Number(quantity) > Number(stock))
	                    	{
	                    		var setQty = 0;
	                    	alert(" Stock Is Not Available The Available Stock is== "+stock+" ");	
	                    	$("#list").jqGrid("setCell", rowId, "quantity", setQty);
	                    	//alert("The Total Of Ok (Qty) and Rejected (Qty) and unprocessed(Qty) is greter than "+dupQuantity+" Inword Quantity ");
							$("#list").jqGrid("reloadGrid");
							return false;
	                    	}
	                
	                    	//var total1 = rowData['total'];
	                    	
	                    
	                    	
                    		
                    		var count = jQuery("#list4").jqGrid('getGridParam', 'records');
        		        	var allRowsInGrid1 = $('#list4').getGridParam('data');
        		        	var AllRows=JSON.stringify(allRowsInGrid1);
        		        //	var finalTotal = 0;
        		        //var totAmt1 = 0;
        		        	
        		        //	var Total = 0;

        		        	//for (var k = 0; k < count; k++)
        		        	//{     
        		        		//var tota = 0;
        		       
        		        	// var tot3=0; 
        		        		//extra code
        		        	
        						 
								/*if(totAmt1 == undefined || totAmt1 == 'NaN' || totAmt1 == null)
        		        		{        
        		        			var total = 0;
        		        			$("#list4").jqGrid("setCell", rowId, "total", total);
        		        			return false;
        		        		}
								else
        		        		{
//									
									if(tota == 0)
									{
									tota = (quantity*buyPrice);
									}
									$("#list4").jqGrid("setCell", rowId, "total", tota.toFixed(2));
        		        		}
								*/
									        		
        		        
        		        	/*var Total1 = allRowsInGrid1[k].total;
							if (Total1 != undefined) {
								
								Total = +Total + +Total1;
							}*/
    		        	//}
    		        	

						

				
        		        	
	        	},
           
			pager: "#jqGridPager",
			
		});
		
		if(count==0 || count==null)
		{
			  $("#list4").addRowData(0,jsonData.offer);
		}
		
		 $('#list4').navGrid('#jqGridPager',
	                
	                { 
			 edit: true, add: false, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
	                {
	                    editCaption: "The Edit Dialog",
	                   
	                    afterSubmit: function () {
							
	                      var grid = $("#list4"),
						  intervalId = setInterval(
							 function() {
							         grid.trigger("reloadGrid",[{current:true}]);
							   },
							   500);
						},
						
						 recreateForm: true,
						 checkOnUpdate : true,
						 checkOnSubmit : true,
		                 closeAfterEdit: true,
						
	                    errorTextFormat: function (data) {
	                        return 'Error: ' + data.responseText
	                    }
	                },
	                
	                {
	                    closeAfterAdd: true,
	                    recreateForm: true,
	                    errorTextFormat: function (data) {
	                        return 'Error: ' + data.responseText
	                    }
	                },
	                
	                {
	                	closeAfterdel:true,
	                	checkOnUpdate : true,
						checkOnSubmit : true,
						recreateForm: true,
	                	
						reloadAftersubmit:true,	
	                    errorTextFormat: function (data) {
	                        return 'Error: ' + data.responseText
	                    },
	                afterComplete: function  grossTotal() {
	 			       // 	Calculation of total after editing quantity
	                	var rowId =$("#list4").jqGrid('getGridParam','selrow');  
                        var rowData = jQuery("#list4").getRowData(rowId);
                    	var quantity1 = rowData['quantity'];
                    	var buyPrice1 = rowData['buyPrice'];
                    	//var total = rowData['total'];
                    	var SalePrice = rowData['salePrice'];
                    	
                    	
                    	var quantity = rowData['quantity'];
                    	var buyPrice = rowData['buyPrice'];
               
                    	var value = rowData['value'];
   
                    	
                    	
                		var count = jQuery("#list4").jqGrid('getGridParam', 'records');
    		        	var allRowsInGrid1 = $('#list4').getGridParam('data');
    		        	var AllRows=JSON.stringify(allRowsInGrid1);
    		        	//var finalTotal = 0;
    		        	var totAmt1 = 0;
    		        
    		        	//var Total = 0;
    		        	//var tota = 0;
    		        	
      		        	 //var gstAmnt1 = 0;
      		        	// gstAmnt2=0;
      		        	// gstAmnt3=0;
      		        	// tot1=0;
      		        	//var tot2=0;
      		        	// tot3=0;
    		        	for (var k = 0; k < count; k++)
    		        	{        		        		
    		        		
    		        		

						
    		        		if(buyPrice != 0 && quantity == 0){
        		        
        		        		tota = (buyPrice*quantity);
        		        		}
    		        		
        		        		
        		        		
							
							/*if(totAmt== null)
    		        		{        
    		        			var total = 0;
    		        			$("#list4").jqGrid("setCell", rowId, "total", total);
    		        			return false;
    		        		}
							else
    		        		{
//    		        			$("#list4").jqGrid("setCell", rowId, "total", totAmt1);
    		        			$("#list4").jqGrid("setCell", rowId, "total", tota.toFixed(2));
    		        		}
							
    		        		
    		            	var Total1 = allRowsInGrid1[k].total;
							if (Total1 != undefined) {
								Total = +Total + +Total1;
							}*/
    		        	}
    		        	
    		        	//document.getElementById("grossTotal").value = GST;
    		        	//document.getElementById("grossTotal").value = (Total).toFixed(2);
    	     	//document.getElementById("grossTotal").value = (finalTotal).toFixed(2);
    	     	//EXTRA CODE
    	     	//documnent.getElementById("total").value = (Total).toFixed(2);
    	     	//
	 	        	},
	                		
	 	        	
				});
		 
			   });
		});
}


function addTrasferStock(){
	
	if(document.transferStock.hotelid.value ==""){
		alert("Please Select Shop Name");
		return false;
	}
	
	addTrasferStock1();
}
//Transfer Stock
function addTrasferStock1()
{
	
	//document.getElementById("save").disabled = true;
	 
	var input = document.getElementById('hotelid'),
   list = document.getElementById('hotelName'),
   i,hotelid;

	for (i = 0; i < list.options.length; ++i) {
   if (list.options[i].value === input.value) {
	   hotelid = list.options[i].getAttribute('data-value');
   	}
	}
	
	 var input = document.getElementById('fk_item_id1'),
	    list = document.getElementById('fk_item_id_drop1'),
	    j,fk_item_id;
	for (j = 0; j < list.options.length; ++j) {
	    if (list.options[j].value === input.value) {
	   	 fk_item_id = list.options[j].getAttribute('data-value');
	   	 
	    }
	}
	
	var params = {};
	var fk_item_id1 = $('#fk_item_id1').val();
	var fk_item_id = fk_item_id1;
	
	
	var hotelName= $('#hotelid').val();
	var fk_item_id_drop1= $('#fk_item_id').val();
	
	params["fk_item_id1"] = fk_item_id1;
	params["fk_item_id"] = fk_item_id;
	
	params["hotelid"] = hotelid;
	params["hotelName"] = hotelName;
	
	
	var count = jQuery("#list4").jqGrid('getGridParam', 'records');
	//alert(count);
	var allRowsInGrid = $('#list4').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	for (var i = 0; i < count; i++) {

		var fk_item_id_drop1 = allRowsInGrid[i].itemName;
		params["fk_item_id_drop1"+i] = fk_item_id_drop1;
		
		var itemName = allRowsInGrid[i].itemName;
		params["itemName"+i] = itemName;
	
		var buyPrice = allRowsInGrid[i].buyPrice;
		if(buyPrice=="" || buyPrice==undefined || buyPrice==null)
		{
			alert("Please Enter PurchasePrice In Grid");
			document.getElementById("save").disabled = false;
			return false;
			
			
		}
		params["buyPrice"+i] = buyPrice;
		
		
		
		var salePrice = allRowsInGrid[i].salePrice;
		if(salePrice=="" || salePrice==undefined || salePrice==null)
		{
			alert("Please Enter SalePrice In Grid");
			document.getElementById("save").disabled = false;
			return false;
		}
		params["salePrice"+i] = salePrice;
		
		//EXTRA CODE
		var stock = allRowsInGrid[i].stock;
		params["stock"+i] = stock;
//
		
		var quantity = allRowsInGrid[i].quantity;
	
		//EXTRA CODE
		if(quantity ==0 || quantity =="" || quantity == undefined || quantity == null)
		{
		alert(" Please enter valid Quantity for product "  +itemName);
		return false;
		}
	if(+quantity > +stock){
		alert("stock of "  +itemName+  " is low , please enter Quantity less than or equal to "  +stock);
		return false;
		}
	else
		{
		params["quantity" +i] = quantity;
		}
		
		
		/*var total = allRowsInGrid[i].total;
		params["total"+i] = total;
		*/
		var pk_item_entry_Id  = allRowsInGrid[i].pk_item_entry_Id;
		params["pk_item_entry_Id"+i] = pk_item_entry_Id;
	}
	
	params["count"] = count;
	 
	params["methodName"] = "addTrasferStock";
	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
	    	{
		 		alert(data)
		 		location.reload();
		 		return false; 
		 		
			}
		
	    	).error(function(jqXHR, textStatus, errorThrown){
	    		if(textStatus==="timeout") {
	    			$(loaderObj).hide();
	    			$(loaderObj).find('#errorDiv').show();
	    		}
	    	})
	    	
	
}

