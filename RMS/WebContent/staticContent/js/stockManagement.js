//grid for stock management
function getGridForStoreManagement(){
	var params= {};
	var count=0;
	var newrow;
	var rowId;

	var productName = $('#productName').val();
	params["productName"]=productName;
	params["methodName"] ="gridForStoreManagement";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
		  var jsonData = $.parseJSON(data);
			
	     $.each(jsonData,function(i,v)
			{
	         count = jQuery("#list4").jqGrid('getGridParam', 'records'); 
		     var rowdata =$("#list4").jqGrid('getGridParam','data');
		     var ids = jQuery("#list4").jqGrid('getDataIDs');
			 var prodName,com,packing,unit;
			  for (var j = 0; j < count; j++) 
			  {
				  prodName = rowdata[j].productName;
				
				 var rowId = ids[j];
				 var rowData = jQuery('#list4').jqGrid ('getRowData', rowId);
				
				if (prodName == jsonData.offer.productName) {
			    	newrow=false;
					alert("Product Name Already Inserted !!!");
					var grid = jQuery("#list4");
				    grid.trigger("reloadGrid");
			    	break;
				}
				else
				{
					newrow = true;
				}
			 }
			  
			  if(newrow == true)
				 {
				  $("#list4").addRowData(count,jsonData.offer);
				 }
		
		$("#list4").jqGrid({
			datatype: "local",
			
			colNames:['Item Name','Supplier Name','Buy Price','Quantity','GST'],
			colModel:[ 
				
			     {	name:'productName',
			    	 width:150,
				},
				
			     {	name:'supplierName',
			    	 width:150,
			    	 editable: true
				},
				{	name:'buyPrice',
			    	 width:150,
			    	 editable: true
				},
			       
				{	name:'quantity',
					width:100,
					editable: true
				},
				
				{	name:'total',
					width:100,
					editable: true
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
         	 afterSaveCell: function  grossTotal() {
			       // 	Calculation of total after editing quantity
			        	   var rowId =$("#list4").jqGrid('getGridParam','selrow');  
	                        var rowData = jQuery("#list4").getRowData(rowId);
	                    	var quantity1 = rowData['quantity'];
	                    	var buyPrice1 = rowData['buyPrice'];
	                    	var total = rowData['total'];
	                    	
	                    	/*var tota = quantity * buyPrice * total;
                    		$("#list4").jqGrid("setCell", rowId, "total", tota);*/
                    		
                    		var GST =0;
                    		var count = jQuery("#list4").jqGrid('getGridParam', 'records');
        		        	var allRowsInGrid1 = $('#list4').getGridParam('data');
        		        	var AllRows=JSON.stringify(allRowsInGrid1);
        		        	for (var k = 0; k < count; k++) {
        		        		
        		        		var quantity = rowData['quantity'];
    	                    	var buyPrice = rowData['buyPrice'];
    	                    	var gst1 = rowData['total'];
        		        		
        		        		var gstAmt = 0;
        		        		gstAmt =  (gst1/100)*(quantity*buyPrice);
        		        		
        		        		var tota = (quantity*buyPrice) + +gstAmt;
        		        		
        		        	/*	
        		        		var Total1 = allRowsInGrid1[k].total;
        		        		var Total2 = allRowsInGrid1[k].total;*/
        		        		GST = +GST + +tota;
        		        	}
        		        	document.getElementById("grossTotal").value = GST;
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
	                    }
	                		
	                });
		 
			   });
		})
}

//add store management
 function addStoreManagement(){
	 
	 var input = document.getElementById('fk_item_id'),
     list = document.getElementById('fk_item_id_drop'),
     i,fk_item_id;
	 
     for (i = 0; i < list.options.length; ++i) {
     if (list.options[i].value === input.value) {
    	 fk_item_id = list.options[i].getAttribute('data-value');
     }
  }
	 
	var input = document.getElementById('fk_supplier_id'),
    list = document.getElementById('suplierName'),
    i,fk_supplier_id;

	for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input.value) {
    	fk_supplier_id = list.options[i].getAttribute('data-value');
    	}
	}
	
	var params = {};
	
	var suplierName= $('#fk_supplier_id').val();
	var fk_item_id_drop= $('#fk_item_id').val();
	params["fk_item_id"] = fk_item_id;
	params["fk_supplier_id"] = fk_supplier_id;
	params["suplierName"] = suplierName;
	
	var count = jQuery("#list4").jqGrid('getGridParam', 'records');
	var allRowsInGrid = $('#list4').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	for (var i = 0; i < count; i++) {

		var productName = allRowsInGrid[i].productName;
		params["productName"+i] = productName;
	
		var supplierName = allRowsInGrid[i].supplierName;
		params["supplierName"+i] = supplierName;
		
		var buyPrice = allRowsInGrid[i].buyPrice;
		params["buyPrice"+i] = buyPrice;
	
		var quantity = allRowsInGrid[i].quantity;
		params["quantity"+i] = quantity;

		var total = allRowsInGrid[i].total;
		params["total"+i] = total;
	}
	
	params["count"] = count;
    
	var grossTotal = $('#grossTotal').val();
	 params["grossTotal"] = grossTotal;
	 
 	params["methodName"] = "addStoreManagement";
 	
 	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
		 		alert(data)
		 		location.reload();
		
 			}
 		
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	})
 	    	
	
}

