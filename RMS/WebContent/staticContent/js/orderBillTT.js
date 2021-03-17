function listForOrderBill(){
	window.open("kitchenOrder.jsp");
}	

function unBookTable(){

	var  abc = data.id;
//	var abc = data.value;
	var tableNo = +abc;
//	var abc = data.value;
//	var tableNo = +abc;
//	document.getElementById("table_No").value = tableNo;
	
	
//	var table_No = $('#table_No').val();

	var params = {};
	
	params["table_No"] = tableNo;
	
	params["methodName"] = "unBookTable";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
		alert(data);
			if(document.empd1)
			{
				document.empd1.reset();
			}	
			document.empd1.btn.disabled =false;
		}
	    	).error(function(jqXHR, textStatus, errorThrown){
	    		
	    		if(textStatus==="timeout") {
	    			$(loaderObj).hide();
	    			$(loaderObj).find('#errorDiv').show();
	    		}
	    	});
}

function getItemDetailById1(data)
{
//	var input = document.getElementById('fk_item_id'),
 /*   list = document.getElementById('fk_item_id_drop'),
    i,fk_item_id;
for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input.value) {
   	 fk_item_id = list.options[i].getAttribute('data-value');
    }
}*/

//document.getElementById('productName1').value="";

//var tableNo = $('#table_No').val();

//var myList = document.getElementsByName("p");
//var xyz = tableNo - 1;
//myList[xyz].style.backgroundColor = "green";
//	document.order.print.disabled =false;
	
	
	var  abc = data.id;
//	var abc = data.value;
	var tableNo = +abc;
//	document.getElementById("table_No").value = tableNo;
//	document.getElementById("gst").value = 0;
//	document.getElementById("gstAmt").value = 0;
	
 var params = {};

params["fk_item_id"] = tableNo;
//params["tableNo"] = tableNo;

params["methodName"] = "getItemDetailsById10";
$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		{
	getItemDetailByTableNewww(tableNo);
//	getItemDetailByTable1(tableNo);
	return false;
		});

}


function getItemDetailByTableNew(tableNo)
{
//	var abc = data.value;
//	var tableNo = +abc;
//	alert("-- "+tableNo);
//	document.getElementById("table_No").value = tableNo;
	//var deletedPkTempId;
	
var params = {};

params["tableNo"] = tableNo;


params["methodName"] = "getItemDetailByTable10";
$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		{ 
	var jsonData = $.parseJSON(data);
	//alert(jsonData.quantity);
	console.log(jsonData);
	
	    $("#list").jqGrid("clearGridData", true).trigger("reloadGrid");
     

	$.each(jsonData,function(i,v)
	{			
		function sumFmatter (cellvalue, options, rowObject)
		{
			var params={};
			var tot= (options.rowData.quantity * options.rowData.prrice);
			var jam = 0; 
			
			var count = jQuery("#list").jqGrid('getGridParam', 'records');
	//		var rowId =$("#list").jqGrid('getGridParam','selrow');  
//            var rowData = jQuery("#list").getRowData(rowId);
			var allRowsInGrid1 = $('#list').getGridParam('data');
			var AllRows=JSON.stringify(allRowsInGrid1);
				
			
			for (var i = 0; i < count; i++) {

/*		     	var quantity = allRowsInGrid1[j].quantity;		     	
		     	var prrice = allRowsInGrid1[j].prrice;	
		     	var itemId = allRowsInGrid1[j].itemId;*/
		     	
		    	var quantity = allRowsInGrid1[i].quantity;
		     	params["quantity"+i] = quantity;
		     	
		     	var prrice = allRowsInGrid1[i].prrice;
		    	params["prrice"+i] = prrice;
	
		    	var totals1 = quantity * prrice;
		    	jam = jam + totals1;

		     	
/*		     	if(itemId == tableNo){
		     		newrow=false;
//					alert("item Name Already Inserted !!!");
					
				//	var grid = jQuery("#list");
			//		grid.trigger("reloadGrid",[{current:true}]);
			//		grid.trigger("reloadGrid");
			    	break;
		     	}   */
		     	
		     	
	/*	     	if(quantity == undefined)
        		{
            		var quantity = 0.00;
            		$("#list").jqGrid("setCell", rowId, "quantity", quantity);
            		//document.getElementById("grossTotal").value = Gstm;
            		//$("#list4").jqGrid("setCell", rowId, "grossTotal", quna);
            		return false;
        		}
		     	
		     	if(prrice == undefined)
        		{
            		var prrice = 0.00;
            		$("#list").jqGrid("setCell", rowId, "quantity", prrice);
            		//document.getElementById("grossTotal").value = Gstm;
            		//$("#list4").jqGrid("setCell", rowId, "grossTotal", quna);
            		return false;
        		}*/
		     	     	
//		    	var totals1 = quantity * prrice;		    	
		    	//$("#list").jqGrid("setCell", rowId, "totalAmt", totals1);
//		    	jam = jam + totals1;
		    	

		    }
				
				jam = jam + tot;
				document.getElementById("totalAmount").value = jam;
				document.getElementById("grndtotalAmount").value = jam;
				return tot;
			//updateData();
				 
				// updateData();
		//		 updateNewData();
				 
		}
		
		 //document.getElementById('fk_item_id').value = "";
		
		$(document).ready(function () {
			var lastsel;
			rownumbers: true,
			
			

			$("#list").jqGrid({

				datatype:"local",
				editurl: 'clientArray',
				colNames: ["pkTempId","itemID","Item Name","tableNo","Quantity","Unit Price","Unit","UnitValue" ,"Total","AllTotal","stock", "stockhide"],

				colModel: [
					       {
								   name:"pkTempId",
								   hidden:true
							},
				           {
				        	   name:"itemId",
				        	   hidden:true
				           },
				           { 	
				        	   name: "itemName",
				        	   width:200,

				           },
				           
				           { 	
				        	   name: "tableNo",
				        	   width:200,
				        	   hidden:true

				           },
				           {
				        	   name: "quantity",
				        	   width: 200,
				        	   editable: true
				           },	

				           {
				        	   name:  "prrice",
				        	   width: 200,
				        	   editable: true
				           },

				           {
				        	   name: "unit",
				        	   width: 200,
				        	   editable: false
				           },
				           
				           {
				        	   name: "value",
				        	   width: 200,
				        	   editable: false
				           },
				           
				           /*{
					           name: "forTotal",
				        	   width: 250,
				        	   formatter: sumFmatter,
				           },*/
				           
				           {
				        	   name: "totalAmt",
				        	   formatter: sumFmatter,
				        	   sorttype: 'number',
				        	   width: 250,
				           },
				           
				           {
				        	   name: "totalAmt",
				        	   width: 250,
				        	   editable: true,
				        	   hidden : true,
				        	   //formatter: sumFmatter,
				           },
				           {
				        	    name: "stock",
					        	 width: 250,
					        	// hidden:true
					       },
				           
				           {
				        	   name: "stockhide",
				        	   width: 250,
				        	   hidden: true,
				           }
				           
				           ],

				           sortorder : 'desc',

				           loadonce: true,
				           viewrecords: true,
				           width: 950,
				           height: 300,
				           rowNum: 10,
				           hoverrows: true,
				           rownumbers: true, // show row numbers
			               rownumWidth: 25,
			               'cellEdit':true,
			              
			               beforeSelectRow: function ()
			               {		            	   
			            	    var rowId =$("#list").jqGrid('getGridParam','selrow');  
			            	    
		                        var rowData = jQuery("#list").getRowData(rowId);		                       
		           				var count = jQuery("#list").jqGrid('getGridParam', 'records');
		           				var allRowsInGrid1 = $('#list').getGridParam('data');
			            	    //var deletedPkTempId = rowData['pkTempId'];
								//alert(rowData['pkTempId']);
								deletedPkTempId=rowData['pkTempId'];
				            	//alert(deletedPkTempId);
			               },		               
			               
			               afterSaveCell: function  grossTotal()
			               {
						        //	Calculation of total after editing quantity
						        	   
						        	   $(this).trigger('reloadGrid');
			            	   		   var FinalTotal = 0;	
						        	   var rowId =$("#list").jqGrid('getGridParam','selrow');  
				                       var rowData = jQuery("#list").getRowData(rowId);
				                       
				                       
				           			var count = jQuery("#list").jqGrid('getGridParam', 'records');
				        			var allRowsInGrid1 = $('#list').getGridParam('data');
				                       
				                       
				                    	var quantity = rowData['quantity'];
				                    	var buyPrice = rowData['prrice'];
				                    	var pkTempId =rowData['pkTempId'];
				                    	var itemName =rowData['itemName'];
				                    	var unitinMl =rowData['unitinMl'];
				                    	var forTotal = rowData['forTotal'];
				                    	var totalAmt = rowData['totalAmt'];
				                    	var tableNo = rowData['tableNo'];
				                    	var stock = rowData['stock'];
				                    	var itemId = rowData['itemId'];
				                    	var stockhide = rowData['stock'];
				                    	var unit = rowData['unit'];
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
				                    	
				                    	
				                    	
				                    	var tota = quantity * buyPrice;
				                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
				                    	
				                    	for (var j = 0; j < count; j++)
				                    	{
				                    		var forTotal = allRowsInGrid1[j].forTotal;
				  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
				            		     	var prrice = allRowsInGrid1[j].prrice;	
				                    		FinalTotal = +FinalTotal + (quantity*prrice);
				                    	}
				                    					                    	
				                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
				                    	document.getElementById("totalAmount").value = FinalTotal;
				                     	document.getElementById("grndtotalAmount").value = FinalTotal;
				                    	//updateData();
				                    	updateNewData();
				        	
			},

				           pager: "#jqGridPager",
				           'cellEdit':true,

			});
			
			
						
			$("#list").addRowData(i+1,jsonData[i]);

		    function calDiscount(cellvalue, options, rowObject){
			return ((options.rowData.buyPriceForItemNAme)*(options.rowData.quantity))+(((options.rowData.buyPriceForItemNAme)*(options.rowData.quantity))*((options.rowData.vatPec)/100));
		} 

			$('#list').navGrid('#jqGridPager',
					// the buttons to appear on the toolbar of the grid
					{ add: false, edit: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
					// options for the Edit Dialog
					{
						editCaption: "The Edit Dialog",
						/*afterSubmit: function () {
						  var grid = $("#list"),
						  intervalId = setInterval(
							 function() {
							         grid.trigger("reloadGrid",[{current:true}]);
							   },
							   500);
						},*/
						
						recreateForm: true,
						checkOnUpdate : true,
						checkOnSubmit : true,
						closeAfterEdit: true,
					},
					
					// options for the Delete Dailog
					{
						delCaption: "delete row",
						/*afterSubmit: function () {
							  var grid = $("#list"),
							  intervalId = setInterval(
								 function() {
								         grid.trigger("reloadGrid",[{current:true}]);
								   },
								   500);
							},*/
						
					
						closeAfterdel:true,
						recreateForm: true,

						// --
						
						onclickSubmit: function (request, postdata)
						{
							var params={};
							
							var tot= (options.rowData.quantity * options.rowData.price);
							
							var jam = 0; 
							var count = jQuery("#list").jqGrid('getGridParam', 'records');
							var allRowsInGrid1 = $('#list').getGridParam('data');
							var AllRows=JSON.stringify(allRowsInGrid1);
							for (var i = 0; i <= count; i++) {
								
						     	var quantity = allRowsInGrid1[i].quantity;
						     	params["quantity"+i] = quantity; 
						     	
						     	var prrice = allRowsInGrid1[i].prrice;
						    	params["prrice"+i] = prrice;
						    	
						    	var totals1 = quantity * prrice;
						    	jam = jam + totals1;
							
						    }
							
/*							var gst = document.getElementById("gst").value
	                    	var FinalTotal1 = ((gst/100)*FinalTotal)+FinalTotal;*/
							
								 document.getElementById("totalAmount").value = jam;
								 document.getElementById("grndtotalAmount").value = jam;
							     //return tot;
								 document.getElementById("gst").value = 0;
						},
						
						// --
						errorTextFormat: function (data) {
							return 'Error: ' + data.responseText
						},
						
						
						/*afterComplete : function  grossTotal()  {
							
							//$('#list').trigger('reloadGrid');

							// $(this).trigger('reloadGrid'); 
							//var rowId = $("#list").jqGrid('getGridParam','selrow');
							//var rowData = jQuery("#list").getRowData(rowId);
							//var count = jQuery("#list").jqGrid('getGridParam','records');
							
								var FinalTotal = 0;	
				        	   //var rowId =$("#list").jqGrid('getGridParam','selrow');  
		                       //var rowData = jQuery("#list").getRowData(rowId);
		                       
		                       
		           			//var count = jQuery("#list").jqGrid('getGridParam', 'records');
		        			//var allRowsInGrid1 = $('#list').getGridParam('data');
		                       
		                       
		                    	var quantity = rowData['quantity'];
		                    	var buyPrice = rowData['prrice'];
		                    	
		                    	var tota = quantity * buyPrice;
		                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
		                    	
		                    	for (var j = 0; j < count; j++)
		                    	{
		                    		var forTotal = allRowsInGrid1[j].forTotal;
		  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
		            		     	var prrice = allRowsInGrid1[j].prrice;	
		                    		FinalTotal = +FinalTotal + (quantity*prrice);
		                    	}
		                    					                    	
		                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
		                    	document.getElementById("totalAmount").value = FinalTotal;

						},*/
						onSelectRow: function(id) {
							if (id && id !== lastSel) {
								jQuery("#list").saveRow(lastSel, true, 'clientArray');
								jQuery("#list").editRow(id, true);
								lastSel = id;
								console.log(id);
							}
						}
					});  
			
/*			$('#list').navGrid('#jqGridPager',
					{	
						edit : true,
						add : false,
						del : true,
						{
						    caption: "Delete",
						    msg: "Delete selected record(s)?",
						    bSubmit: "Delete",
						    bCancel: "Cancel",
						},
						
					//	del : true,
						search : true,
						refresh : true,
						view : true,
						position : "left",
						cloneToTop : false,
										
						
					},
					
					{
						editCaption : "The Edit Dialog",

						afterSubmit : function()
						{
							var grid = $("#list"), intervalId = setInterval(
									function()
									{
										grid.trigger("reloadGrid",[ {current : true} ]);
									}, 500);
						},

						recreateForm : true,
						checkOnUpdate : true,
						checkOnSubmit : true,
						closeAfterEdit : true,

						errorTextFormat : function(
								data) {
							return 'Error: '
									+ data.responseText
						}
					},
					
					
					{
						closeAfterAdd : true,
						recreateForm : true,
						errorTextFormat : function(
								data) {
							return 'Error: '
									+ data.responseText
						}
					},
					
					
					{
						closeAfterdel:true,
	                	checkOnUpdate : true,
						checkOnSubmit : true,
						afterSubmit : function()
						{
							var rowId = $("#list").jqGrid('getGridParam','selrow');
							var ids = jQuery("#list").jqGrid('getDataIDs');
							var rowData = jQuery("#list").getRowData(rowId);
							var pkTempId =rowData['pkTempId'];
							
							updateNewDataDelete(pkTempId);
						},
						afterComplete : function()
						{
						//	$('#list').trigger('reloadGrid');

							// $(this).trigger('reloadGrid');
							var count = jQuery("#list").jqGrid('getGridParam','records');							
							var rowId = $("#list").jqGrid('getGridParam','selrow');
							var ids = jQuery("#list").jqGrid('getDataIDs');
							var rowData = jQuery("#list").getRowData(rowId);
							var pkTempId =rowData['pkTempId'];
							//alert(deletedPkTempId);
	                    	//alert(pkTempId);
							//alert("rowId  :: "+rowId+ "   rowData :: "+rowData +"ids::"+ids);
							var count = jQuery("#list").jqGrid('getGridParam','records');
							
							   var FinalTotal = 0;	
				        	   var rowId =$("#list").jqGrid('getGridParam','selrow');  
		                       var rowData = jQuery("#list").getRowData(rowId);
		                       
		                       
		           			var count = jQuery("#list").jqGrid('getGridParam', 'records');
		        			var allRowsInGrid1 = $('#list').getGridParam('data');
		                       
		                       
		                    	var quantity = rowData['quantity'];
		                    	var buyPrice = rowData['prrice'];
		                    	
		                    	var tota = quantity * buyPrice;
		                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
		                    	
		                    	for (var j = 0; j < count; j++)
		                    	{
		                    		var forTotal = allRowsInGrid1[j].forTotal;
		  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
		            		     	var prrice = allRowsInGrid1[j].prrice;	
		                    		FinalTotal = +FinalTotal + (quantity*prrice);
		                    	}
		                    					                    	
		                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
		                    	document.getElementById("totalAmount").value = FinalTotal;
		                    	document.getElementById("grndtotalAmount").value = FinalTotal;
		                    	//updateData();
		                    	//updateNewDataDelete();
						},*/

						/*onSelectRow : function(id) {
							if (id && id !== lastSel) {
								jQuery("#list").saveRow(lastSel,true,'clientArray');
								jQuery("#list").editRow(id,true);
								lastSel = id;
								console.log(id);
							}
						}
*/
		//			});
		});
		
			}); 

		}); 
	

	}
// -- 


function getItemDetailByTableNewww(tableNo)
{
//	var abc = data.value;
//	var tableNo = +abc;
//	alert("-- "+tableNo);
//	document.getElementById("table_No").value = tableNo;
	//var deletedPkTempId;
	
var params = {};

params["tableNo"] = tableNo;


params["methodName"] = "getItemDetailByTable10";
$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		{ 
	var jsonData = $.parseJSON(data);
	//alert(jsonData.quantity);
	console.log(jsonData);
	
	   $("#list").jqGrid("clearGridData", true).trigger("reloadGrid");
        
	$.each(jsonData,function(i,v)
	{			
		function sumFmatter (cellvalue, options, rowObject)
		{
			var params={};
			var jam = 0; 
			var totals1 =0;
			
			
			
			var count = jQuery("#list").jqGrid('getGridParam', 'records');
			var tot= (options.rowData.quantity * options.rowData.prrice);
		//	var tot = options.rowData.forTotal;
			var gst = (options.rowData.gst);
//			var cgst = (options.rowData.cgst);
//			var sgst = (options.rowData.sgst);
			
			var tot1=0;
			var tot2 = 0;
			if(gst != 0){
		    	var gst1 = ((gst)/(100)*(options.rowData.quantity * options.rowData.prrice));
		    	tot1  = tot1 + gst1;
		    	tot = tot + tot1;
			}
/*		    if(sgst != 0){
		    	var gst2 = ((sgst)/(100)*(options.rowData.quantity * options.rowData.prrice));
    		     tot2  = tot2 + gst2;
		    }
			if(tot1!=0 || tot2!=0){
				tot = (options.rowData.quantity * options.rowData.prrice)+tot1+tot2;
			}*/
		    
			var rowId =$("#list").jqGrid('getGridParam','selrow');  
            var rowData = jQuery("#list").getRowData(rowId);
			var allRowsInGrid1 = $('#list').getGridParam('data');
			var AllRows=JSON.stringify(allRowsInGrid1);
			for (var j = 0; j < count; j++) {
				
		     	var quantity = allRowsInGrid1[j].quantity;		     	
		     	var prrice = allRowsInGrid1[j].prrice;	
		     	var itemId = allRowsInGrid1[j].itemId;
		     	var gst = allRowsInGrid1[j].gst;
		     	var stock = allRowsInGrid1[j].stock;
		     	/*if(Number(quantity)>Number(stock))
		     		{
		     		alert("Stock is not available");
		     		var quantity = 0.00;
            		$("#list").jqGrid("setCell", rowId, "quantity", quantity);
		     		return false;
		     		}*/
		  //   	var cgst = allRowsInGrid1[j].cgst;
		 //    	var sgst = allRowsInGrid1[j].sgst;
		     	
		  /*    	var quantity = allRowsInGrid1[j].quantity;
		     	params["quantity"+j] = quantity;
		     	
		     	var prrice = allRowsInGrid1[j].prrice;
		    	params["prrice"+j] = prrice;
		    */	

		   
		     	
		     	
	/*	     	if(itemId==tableNo){
		     		newrow=false;
			//		alert("item Name Already Inserted !!!");
					var grid = jQuery("#list");
				    grid.trigger("reloadGrid");
			    	break;
		     	}  */
		     	
		     	
		     	if(quantity == undefined)
        		{
            		var quantity = 0.00;
            		$("#list").jqGrid("setCell", rowId, "quantity", quantity);
            		//document.getElementById("grossTotal").value = Gstm;
            		//$("#list4").jqGrid("setCell", rowId, "grossTotal", quna);
            		return false;
        		}
		     	
		     	if(prrice == undefined)
        		{
            		var prrice = 0.00;
            		$("#list").jqGrid("setCell", rowId, "quantity", prrice);
            		//document.getElementById("grossTotal").value = Gstm;
            		//$("#list4").jqGrid("setCell", rowId, "grossTotal", quna);
            		return false;
        		}
		     	
		     	
		    	var totals1 = quantity * prrice;
		   //  	var totals1 = allRowsInGrid1[j].forTotal;
				var tot1=0;
				var tot2 = 0;
				if(gst != 0){
			    	var gst1 = ((gst)/(100)*(quantity * prrice));
			    	tot1  = tot1 + gst1;
			    	totals1 = totals1 + tot1;
				}
/*			    if(sgst != 0){
			    	var gst2 = ((sgst)/(100)*(quantity * prrice));
	    		     tot2  = tot2 + gst2;
			    }
				if(tot1!=0 || tot2!=0){
					totals1 = (quantity * prrice)+tot1+tot2;
				}
	*/	    	
		    	//$("#list").jqGrid("setCell", rowId, "totalAmt", totals1);
		    	
		    	jam = jam + totals1;
		    	
		 
		    	
		    }
			    jam = jam + tot;
				document.getElementById("totalAmount").value = jam;
		//		document.getElementById("grndtotalAmount").value = jam;
		
			//	document.getElementById("gst").value = 0;
			//	document.getElementById("gstAmt").value = 0;
				
			//updateData();
				 return tot;
				// updateData();
				 updateNewData();
				 
		}
		
		 //document.getElementById('fk_item_id').value = "";
		
		$(document).ready(function () {
			var lastsel;
			rownumbers: true,
			
			

			$("#list").jqGrid({

				datatype:"local",
				editurl: 'clientArray',
				colNames: ["pkTempId","itemID","Item Name","tableNo","Quantity","Unit Price","Unit","UnitValue","GST","Total","AllTotal","stock", "stockhide"],

				colModel: [
					       {
								   name:"pkTempId",
								   hidden:true
							},
				           {
				        	   name:"itemId",
				        	   hidden:true
				           },
				           { 	
				        	   name: "itemName",
				        	   width:200,

				           },
				           
				           { 	
				        	   name: "tableNo",
				        	   width:200,
				        	   hidden:true

				           },
				           {
				        	   name: "quantity",
				        	   width: 200,
				        	   editable: true
				           },	

				           {
				        	   name:  "prrice",
				        	   width: 200,
				        	   editable: false
				           },

				           {
				        	   name: "unit",
				        	   width: 200,
				        	   editable: false
				           },
				           
				           {
				        	   name: "value",
				        	   width: 200,
				        	   editable: false
				           },
				           
				           {
				        	   name: "gst",
				        	   width: 200,
				        	   editable: true
				           },
/*				           {
				        	   name: "sgst",
				        	   width: 200,
				        	   editable: true
				           },*/
				           {
					           name: "forTotal",
				        	   width: 250,
				        	   formatter: sumFmatter,
				           },
				           
				           {
				        	   name: "totalAmt",
				        	   width: 250,
				        	   editable: true,
				        	   hidden : true,
				        	   //formatter: sumFmatter,
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

				           loadonce: true,
				           viewrecords: true,
				           width: 950,
				           height: 300,
				           rowNum: 10,
				           hoverrows: true,
				           rownumbers: true, // show row numbers
			               rownumWidth: 25,
			               'cellEdit':true,
			               beforeSelectRow: function ()
			               {		            	   
			            	    var rowId =$("#list").jqGrid('getGridParam','selrow');  
			            	    
		                        var rowData = jQuery("#list").getRowData(rowId);		                       
		           				var count = jQuery("#list").jqGrid('getGridParam', 'records');
		           				var allRowsInGrid1 = $('#list').getGridParam('data');
			            	    //var deletedPkTempId = rowData['pkTempId'];
								//alert(rowData['pkTempId']);
								deletedPkTempId=rowData['pkTempId'];
				            	//alert(deletedPkTempId);
			               },		               
			               
			               afterSaveCell: function  grossTotal()
			               {
						        //	Calculation of total after editing quantity
						        	   
						        	   // $(this).trigger('reloadGrid');
			            	   		   var FinalTotal = 0;	
						        	   var rowId =$("#list").jqGrid('getGridParam','selrow');  
				                       var rowData = jQuery("#list").getRowData(rowId);
				                       
				                       
				           			var count = jQuery("#list").jqGrid('getGridParam', 'records');
				        			var allRowsInGrid1 = $('#list').getGridParam('data');
				                       
				                       
				                    	var quantity = rowData['quantity'];
				                    	var buyPrice = rowData['prrice'];
				                    	var pkTempId =rowData['pkTempId'];
				                    	var itemName =rowData['itemName'];
				                    	var unitinMl =rowData['unitinMl'];
				                    	var forTotal = rowData['forTotal'];
				                    	var totalAmt = rowData['totalAmt'];
				                    	var tableNo = rowData['tableNo'];
				                    	var stock = rowData['stock'];
				                    	var itemId = rowData['itemId'];
				                    	var stockhide = rowData['stock'];
				                    	var unit = rowData['unit'];
				                    	var value = rowData['value'];
				                    	var gst = rowData['gst'];
				                   // 	var sgst = rowData['sgst'];
				                    	
				                    	if(Number(quantity) > Number(stock))
				                    	{
				                    		var setQty = 0;
				                    	alert(" Stock Is Not Available The Available Stock is== "+stock+" ");	
				                    	$("#list").jqGrid("setCell", rowId, "quantity", setQty);
				                    	//alert("The Total Of Ok (Qty) and Rejected (Qty) and unprocessed(Qty) is greter than "+dupQuantity+" Inword Quantity ");
										$("#list").jqGrid("reloadGrid");
										return false;
				                    	}
				                    	if(quantity != '')
			                    		{
			                    			 var checkQuantity = /^[0-9]+$/;
			                    			 if(String(quantity).match(checkQuantity))
			                    			 {}
			                    			 else
			                    			 {
			                    				 alert("Please Enter Valid Quantity");
			                    				 quantity = 0;
			                    				 var setZero = 0;
		                                  		 $("#list").jqGrid("setCell", rowId, "quantity", setZero);
		                                  		 return false;
			                    			 }
			                    			 
			                    		}
				                    	
				                    	if(gst != '')
			                    		{
			                    			// var checkQuantity = /^[0-9]+$/;
				                    		var checkQuantity = /^[0-9]*\.?[0-9]+$/;
			                    			 if(String(gst).match(checkQuantity))
			                    			 {}
			                    			 else
			                    			 {
			                    				 alert("Please Enter Valid GST");
			                    				 gst = 0;
			                    				 var setZero = 0;
		                                  		 $("#list").jqGrid("setCell", rowId, "gst", setZero);
		                                  		 return false;
			                    			 }
			                    			 
			                    		}
				                    	
				                    	var tota = quantity * buyPrice;
				                    	
				            			var tot1=0;
				            			var tot2 = 0;
				            			if(gst != 0){
				            		    	var gst1 = ((gst)/(100)*(quantity * buyPrice));
				            		    	tot1  = tot1 + gst1;
				            		    	tota = tota + tot1;
				            			}
				            		   /* if(sgst != 0){
				            		    	var gst2 = ((sgst)/(100)*(quantity * buyPrice));
				                		     tot2  = tot2 + gst2;
				            		    }
				            			if(tot1!=0 || tot2!=0){
				            				tota = (quantity * buyPrice)+tot1+tot2;
				            			}*/
				            		    	
				                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
				                    	
				                    	for (var j = 0; j < count; j++)
				                    	{
				                    		var forTotal = allRowsInGrid1[j].forTotal;
				  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
				            		     	var prrice = allRowsInGrid1[j].prrice;
				            		     	var totals1 = (quantity*prrice);
				            		     	
				            		     	var tot1=0;
					            			var tot2 = 0;
					            			if(gst != 0){
					            		    	var gst1 = ((gst)/(100)*(quantity * prrice));
					            		    	tot1  = tot1 + gst1;
					            		    	totals1 = totals1 + tot1;
					            		    }
					            		   /* if(sgst != 0){
					            		    	var gst2 = ((sgst)/(100)*(quantity * prrice));
					                		     tot2  = tot2 + gst2;
					            		    }
					            			if(tot1!=0 || tot2!=0){
					            				totals1 = (quantity * prrice)+tot1+tot2;
					            			}*/
					            			
					            	//		FinalTotal = +FinalTotal + forTotal;
				                    		FinalTotal = +FinalTotal + +totals1;
				                    	}
				                    					                    	
				                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
				                    	document.getElementById("totalAmount").value = FinalTotal;
				        //            	document.getElementById("grndtotalAmount").value = FinalTotal;
				                    	//updateData();
				                    	updateNewData();
				        	
			},

				           pager: "#jqGridPager",
				           'cellEdit':true,

			});
			
			
						
			$("#list").addRowData(i+1,jsonData[i]);

			function calDiscount(cellvalue, options, rowObject){

				return ((options.rowData.buyPriceForItemNAme)*(options.rowData.quantity))+(((options.rowData.buyPriceForItemNAme)*(options.rowData.quantity))*((options.rowData.vatPec)/100));
			} 

/*			$('#list').navGrid('#jqGridPager',
					// the buttons to appear on the toolbar of the grid
					{ add: false, edit: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
					// options for the Edit Dialog
					{
						editCaption: "The Edit Dialog",
						afterSubmit: function () {
						  var grid = $("#list"),
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
					},
					
					// options for the Delete Dailog
					{
						delCaption: "delete row",
						afterSubmit: function () {
							  var grid = $("#list"),
							  intervalId = setInterval(
								 function() {
								         grid.trigger("reloadGrid",[{current:true}]);
								   },
								   500);
							},
						
					
						closeAfterdel:true,
						recreateForm: true,

						errorTextFormat: function (data) {
							return 'Error: ' + data.responseText
						},
						afterComplete : function  grossTotal()  {
							
							//$('#list').trigger('reloadGrid');

							// $(this).trigger('reloadGrid'); 
							//var rowId = $("#list").jqGrid('getGridParam','selrow');
							//var rowData = jQuery("#list").getRowData(rowId);
							//var count = jQuery("#list").jqGrid('getGridParam','records');
							
								var FinalTotal = 0;	
				        	   //var rowId =$("#list").jqGrid('getGridParam','selrow');  
		                       //var rowData = jQuery("#list").getRowData(rowId);
		                       
		                       
		           			//var count = jQuery("#list").jqGrid('getGridParam', 'records');
		        			//var allRowsInGrid1 = $('#list').getGridParam('data');
		                       
		                       
		                    	var quantity = rowData['quantity'];
		                    	var buyPrice = rowData['prrice'];
		                    	
		                    	var tota = quantity * buyPrice;
		                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
		                    	
		                    	for (var j = 0; j < count; j++)
		                    	{
		                    		var forTotal = allRowsInGrid1[j].forTotal;
		  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
		            		     	var prrice = allRowsInGrid1[j].prrice;	
		                    		FinalTotal = +FinalTotal + (quantity*prrice);
		                    	}
		                    					                    	
		                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
		                    	document.getElementById("totalAmount").value = FinalTotal;

						},
						onSelectRow: function(id) {
							if (id && id !== lastSel) {
								jQuery("#list").saveRow(lastSel, true, 'clientArray');
								jQuery("#list").editRow(id, true);
								lastSel = id;
								console.log(id);
							}
						}
					});  */
			
			$('#list').navGrid('#jqGridPager',
					{	
						edit : true,
						add : false,
						del : true,
						/*{
						    caption: "Delete",
						    msg: "Delete selected record(s)?",
						    bSubmit: "Delete",
						    bCancel: "Cancel",
						},*/
						
					//	del : true,
						search : true,
						refresh : false,
						view : true,
						position : "left",
						cloneToTop : false,
										
						
					},
					
					{
						editCaption : "The Edit Dialog",

						afterSubmit : function()
						{
							var grid = $("#list"), intervalId = setInterval(
									function()
									{
										grid.trigger("reloadGrid",[ {current : true} ]);
									}, 500);
						},

						recreateForm : true,
						checkOnUpdate : true,
						checkOnSubmit : true,
						closeAfterEdit : true,

						errorTextFormat : function(
								data) {
							return 'Error: '
									+ data.responseText
						}
					},
					
					
					{
						closeAfterAdd : true,
						recreateForm : true,
						errorTextFormat : function(
								data) {
							return 'Error: '
									+ data.responseText
						}
					},
					
					
					{
						closeAfterdel:true,
	                	checkOnUpdate : true,
						checkOnSubmit : true,
						afterSubmit : function()
						{
							var rowId = $("#list").jqGrid('getGridParam','selrow');
							var ids = jQuery("#list").jqGrid('getDataIDs');
							var rowData = jQuery("#list").getRowData(rowId);
							var pkTempId =rowData['pkTempId'];
							
							updateNewDataDelete(pkTempId);
						},
						afterComplete : function()
						{
						//	$('#list').trigger('reloadGrid');

							// $(this).trigger('reloadGrid');
							var count = jQuery("#list").jqGrid('getGridParam','records');							
							var rowId = $("#list").jqGrid('getGridParam','selrow');
							var ids = jQuery("#list").jqGrid('getDataIDs');
							var rowData = jQuery("#list").getRowData(rowId);
							var pkTempId =rowData['pkTempId'];
							//alert(deletedPkTempId);
	                    	//alert(pkTempId);
							//alert("rowId  :: "+rowId+ "   rowData :: "+rowData +"ids::"+ids);
							var count = jQuery("#list").jqGrid('getGridParam','records');
							
							   var FinalTotal = 0;	
				        	   var rowId =$("#list").jqGrid('getGridParam','selrow');  
		                       var rowData = jQuery("#list").getRowData(rowId);
		                       
		                       
		           			var count = jQuery("#list").jqGrid('getGridParam', 'records');
		        			var allRowsInGrid1 = $('#list').getGridParam('data');
		                       
		                       
		                    	var quantity = rowData['quantity'];
		                    	var buyPrice = rowData['prrice'];
		                    	
		                  //  	var tota = quantity * buyPrice;
		                    	
		                    	var gst = rowData['gst'];
		                 //   	var sgst = rowData['sgst'];
		                    	
		                    	var tota = quantity * buyPrice;
		                    	
		                    	var tot1=0;
		            			var tot2 = 0;
		            			if(gst != 0){
		            		    	var gst1 = ((gst)/(100)*(quantity * buyPrice));
		            		    	tot1  = tot1 + gst1;
		            		    	tota = tota + tot1;
		            		    }
		            		  /*  if(sgst != 0){
		            		    	var gst2 = ((sgst)/(100)*(quantity * buyPrice));
		                		     tot2  = tot2 + gst2;
		            		    }
		            			if(tot1!=0 || tot2!=0){
		            				tota = (quantity * buyPrice)+tot1+tot2;
		            			}*/
		                    	
		                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
		                    	
		                    	for (var j = 0; j < count; j++)
		                    	{
		                    		var forTotal = allRowsInGrid1[j].forTotal;
		  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
		            		     	var prrice = allRowsInGrid1[j].prrice;	
		                    		var gst = allRowsInGrid1[j].gst;
//updated code for after delete total		                    		
		                    		var totals=0;
		            		     	var tot1=0;
		                        	var tot2 =0;
		            		    	
		                        	totals = (quantity*prrice);
		                        	
		            		    	if(gst != 0){
		            		    	var gst1 = ((gst)/(100)*(quantity * prrice));
		            		    	tot1  = tot1 + gst1;
		            		    
		            		    	}

		            		    	if(tot1 !=0){
		            	    			totals = (quantity * prrice)+tot1;
		            		    	}
		                    		
		            		    	FinalTotal = +FinalTotal + totals;
		                   // 		FinalTotal = +FinalTotal + +forTotal;
		                    		//	FinalTotal = +FinalTotal + (quantity*prrice);
		                    	}
		                    					                    	
		                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
		                    	document.getElementById("totalAmount").value = FinalTotal;
		                  //  	document.getElementById("grndtotalAmount").value = FinalTotal;
		                //    	document.getElementById("gst").value = 0;
		                 //   	document.getElementById("gstAmt").value = 0;
		                    	//updateData();
		                    	//updateNewDataDelete();
						},

						onSelectRow : function(
								id) {
							if (id
									&& id !== lastSel) {
								jQuery(
										"#list")
										.saveRow(
												lastSel,
												true,
												'clientArray');
								jQuery(
										"#list")
										.editRow(
												id,
												true);
								lastSel = id;
								console
										.log(id);
							}
						}

					});
		});
		
			}); 

		}); 
}






// --
function getId()
{
			
}

function getItemDetailByTable(data)
{
	var abc = data.value;
	var tableNo = +abc;
	document.getElementById("table_No").value = tableNo;
	//var deletedPkTempId;
	
var params = {};

params["tableNo"] = tableNo;


params["methodName"] = "getItemDetailByTable";
$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		{ 
	var jsonData = $.parseJSON(data);
	//alert(jsonData.quantity);
	console.log(jsonData);
	
	//    $("#list").jqGrid("clearGridData", true).trigger("reloadGrid");
        
	$.each(jsonData,function(i,v)
			{
			
		function sumFmatter (cellvalue, options, rowObject)
		{
			var params={};
			var jam = 0; 
			var totals1 =0;
			
			var count = jQuery("#list").jqGrid('getGridParam', 'records');
			var tot= (options.rowData.quantity * options.rowData.prrice);
			var rowId =$("#list").jqGrid('getGridParam','selrow');  
            var rowData = jQuery("#list").getRowData(rowId);
			var allRowsInGrid1 = $('#list').getGridParam('data');
			var AllRows=JSON.stringify(allRowsInGrid1);
			for (var j = 0; j < count; j++) {
				
		     	var quantity = allRowsInGrid1[j].quantity;		     	
		     	var prrice = allRowsInGrid1[j].prrice;	
		     	
		     	
		     	if(quantity == undefined)
        		{
            		var quantity = 0.00;
            		$("#list").jqGrid("setCell", rowId, "quantity", quantity);
            		//document.getElementById("grossTotal").value = Gstm;
            		//$("#list4").jqGrid("setCell", rowId, "grossTotal", quna);
            		return false;
        		}
		     	
		     	if(prrice == undefined)
        		{
            		var prrice = 0.00;
            		$("#list").jqGrid("setCell", rowId, "quantity", prrice);
            		//document.getElementById("grossTotal").value = Gstm;
            		//$("#list4").jqGrid("setCell", rowId, "grossTotal", quna);
            		return false;
        		}
		     	
		     	
		    	var totals1 = quantity * prrice;
		    	
		    	//$("#list").jqGrid("setCell", rowId, "totalAmt", totals1);
		    	
		    	jam = jam + totals1;
		    	
		    	
		    	
		    }
			    jam = jam + tot;
				document.getElementById("totalAmount").value = jam;
			
		
			//updateData();
				 return tot;
				// updateData();
				 updateNewData();
				 
		}
		
		 //document.getElementById('fk_item_id').value = "";
		
		$(document).ready(function () {
			var lastsel;
			rownumbers: true,
			
			

			$("#list").jqGrid({

				datatype:"local",
				editurl: 'clientArray',
				colNames: ["pkTempId","itemID","Item Name","tableNo","Quantity","Unit Price","UnitInMl", "Total","AllTotal","stock", "stockhide"],

				colModel: [
					       {
								   name:"pkTempId",
								   hidden:true
							},
				           {
				        	   name:"itemId",
				        	   hidden:true
				           },
				           { 	
				        	   name: "itemName",
				        	   width:200,

				           },
				           
				           { 	
				        	   name: "tableNo",
				        	   width:200,
				        	   hidden:true

				           },
				           {
				        	   name: "quantity",
				        	   width: 100,
				        	   editable: true
				           },	

				           {
				        	   name:  "prrice",
				        	   width: 200,
				        	   editable: true
				           },

				           {
				        	   name: "unitinMl",
				        	   width: 200,
				        	   editable: false
				           },
				           
				           {
					           name: "forTotal",
				        	   width: 250,
				        	   formatter: sumFmatter,
				           },
				           
				           {
				        	   name: "totalAmt",
				        	   width: 250,
				        	   editable: true,
				        	   hidden : true,
				        	   //formatter: sumFmatter,
				           },
				           {
				        	    name: "stock",
					        	 width: 250,
					        	// hidden:true
					       },
				           
				           {
				        	   name: "stockhide",
				        	   width: 250,
				        	   hidden: true,
				           }
				           
				           ],

				           sortorder : 'desc',

				           loadonce: true,
				           viewrecords: true,
				           width: 950,
				           height: 300,
				           rowNum: 10,
				           hoverrows: true,
				           rownumbers: true, // show row numbers
			               rownumWidth: 25,
			              
			               beforeSelectRow: function ()
			               {		            	   
			            	    var rowId =$("#list").jqGrid('getGridParam','selrow');  
			            	    
		                        var rowData = jQuery("#list").getRowData(rowId);		                       
		           				var count = jQuery("#list").jqGrid('getGridParam', 'records');
		           				var allRowsInGrid1 = $('#list').getGridParam('data');
			            	    //var deletedPkTempId = rowData['pkTempId'];
								//alert(rowData['pkTempId']);
								deletedPkTempId=rowData['pkTempId'];
				            	//alert(deletedPkTempId);
			               },		               
			               
			               afterSaveCell: function  grossTotal()
			               {
						        //	Calculation of total after editing quantity
						        	   
						        	   // $(this).trigger('reloadGrid');
			            	   		   var FinalTotal = 0;	
						        	   var rowId =$("#list").jqGrid('getGridParam','selrow');  
				                       var rowData = jQuery("#list").getRowData(rowId);
				                       
				                       
				           			var count = jQuery("#list").jqGrid('getGridParam', 'records');
				        			var allRowsInGrid1 = $('#list').getGridParam('data');
				                       
				                       
				                    	var quantity = rowData['quantity'];
				                    	var buyPrice = rowData['prrice'];
				                    	var pkTempId =rowData['pkTempId'];
				                    	var itemName =rowData['itemName'];
				                    	var unitinMl =rowData['unitinMl'];
				                    	var forTotal = rowData['forTotal'];
				                    	var totalAmt = rowData['totalAmt'];
				                    	var tableNo = rowData['tableNo'];
				                    	var stock = rowData['stock'];
				                    	var itemId = rowData['itemId'];
				                    	var stockhide = rowData['stock'];
				                    	
				                    	if(Number(quantity) > Number(stock))
				                    	{
				                    		var setQty = 0;
				                    	alert(" Stock Is Not Available The Available Stock is== "+stock+" ");	
				                    	$("#list").jqGrid("setCell", rowId, "quantity", setQty);
				                    	//alert("The Total Of Ok (Qty) and Rejected (Qty) and unprocessed(Qty) is greter than "+dupQuantity+" Inword Quantity ");
										$("#list").jqGrid("reloadGrid");
										return false;
				                    	}
				                    	
				                    	var tota = quantity * buyPrice;
				                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
				                    	
				                    	for (var j = 0; j < count; j++)
				                    	{
				                    		var forTotal = allRowsInGrid1[j].forTotal;
				  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
				            		     	var prrice = allRowsInGrid1[j].prrice;	
				                    		FinalTotal = +FinalTotal + (quantity*prrice);
				                    	}
				                    					                    	
				                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
				                    	document.getElementById("totalAmount").value = FinalTotal;
				                    	
				                    	//updateData();
				                    	updateNewData();
				        	
			},

				           pager: "#jqGridPager",
				           'cellEdit':true,

			});
			
			
						
			$("#list").addRowData(i+1,jsonData[i]);

			function calDiscount(cellvalue, options, rowObject){

				return ((options.rowData.buyPriceForItemNAme)*(options.rowData.quantity))+(((options.rowData.buyPriceForItemNAme)*(options.rowData.quantity))*((options.rowData.vatPec)/100));
			} 

/*			$('#list').navGrid('#jqGridPager',
					// the buttons to appear on the toolbar of the grid
					{ add: false, edit: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
					// options for the Edit Dialog
					{
						editCaption: "The Edit Dialog",
						afterSubmit: function () {
						  var grid = $("#list"),
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
					},
					
					// options for the Delete Dailog
					{
						delCaption: "delete row",
						afterSubmit: function () {
							  var grid = $("#list"),
							  intervalId = setInterval(
								 function() {
								         grid.trigger("reloadGrid",[{current:true}]);
								   },
								   500);
							},
						
					
						closeAfterdel:true,
						recreateForm: true,

						errorTextFormat: function (data) {
							return 'Error: ' + data.responseText
						},
						afterComplete : function  grossTotal()  {
							
							//$('#list').trigger('reloadGrid');

							// $(this).trigger('reloadGrid'); 
							//var rowId = $("#list").jqGrid('getGridParam','selrow');
							//var rowData = jQuery("#list").getRowData(rowId);
							//var count = jQuery("#list").jqGrid('getGridParam','records');
							
								var FinalTotal = 0;	
				        	   //var rowId =$("#list").jqGrid('getGridParam','selrow');  
		                       //var rowData = jQuery("#list").getRowData(rowId);
		                       
		                       
		           			//var count = jQuery("#list").jqGrid('getGridParam', 'records');
		        			//var allRowsInGrid1 = $('#list').getGridParam('data');
		                       
		                       
		                    	var quantity = rowData['quantity'];
		                    	var buyPrice = rowData['prrice'];
		                    	
		                    	var tota = quantity * buyPrice;
		                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
		                    	
		                    	for (var j = 0; j < count; j++)
		                    	{
		                    		var forTotal = allRowsInGrid1[j].forTotal;
		  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
		            		     	var prrice = allRowsInGrid1[j].prrice;	
		                    		FinalTotal = +FinalTotal + (quantity*prrice);
		                    	}
		                    					                    	
		                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
		                    	document.getElementById("totalAmount").value = FinalTotal;

						},
						onSelectRow: function(id) {
							if (id && id !== lastSel) {
								jQuery("#list").saveRow(lastSel, true, 'clientArray');
								jQuery("#list").editRow(id, true);
								lastSel = id;
								console.log(id);
							}
						}
					});  */
			
			$('#list').navGrid('#jqGridPager',
					{	
						edit : true,
						add : false,
						del : true,
						/*{
						    caption: "Delete",
						    msg: "Delete selected record(s)?",
						    bSubmit: "Delete",
						    bCancel: "Cancel",
						},*/
						
					//	del : true,
						search : true,
						refresh : true,
						view : true,
						position : "left",
						cloneToTop : false,
										
						
					},
					
					{
						editCaption : "The Edit Dialog",

						afterSubmit : function()
						{
							var grid = $("#list"), intervalId = setInterval(
									function()
									{
										grid.trigger("reloadGrid",[ {current : true} ]);
									}, 500);
						},

						recreateForm : true,
						checkOnUpdate : true,
						checkOnSubmit : true,
						closeAfterEdit : true,

						errorTextFormat : function(
								data) {
							return 'Error: '
									+ data.responseText
						}
					},
					
					
					{
						closeAfterAdd : true,
						recreateForm : true,
						errorTextFormat : function(
								data) {
							return 'Error: '
									+ data.responseText
						}
					},
					
					
					{
						closeAfterdel:true,
	                	checkOnUpdate : true,
						checkOnSubmit : true,
						afterSubmit : function()
						{
							var rowId = $("#list").jqGrid('getGridParam','selrow');
							var ids = jQuery("#list").jqGrid('getDataIDs');
							var rowData = jQuery("#list").getRowData(rowId);
							var pkTempId =rowData['pkTempId'];
							
							updateNewDataDelete(pkTempId);
						},
						afterComplete : function()
						{
						//	$('#list').trigger('reloadGrid');

							// $(this).trigger('reloadGrid');
							var count = jQuery("#list").jqGrid('getGridParam','records');							
							var rowId = $("#list").jqGrid('getGridParam','selrow');
							var ids = jQuery("#list").jqGrid('getDataIDs');
							var rowData = jQuery("#list").getRowData(rowId);
							var pkTempId =rowData['pkTempId'];
							//alert(deletedPkTempId);
	                    	//alert(pkTempId);
							//alert("rowId  :: "+rowId+ "   rowData :: "+rowData +"ids::"+ids);
							var count = jQuery("#list").jqGrid('getGridParam','records');
							
							   var FinalTotal = 0;	
				        	   var rowId =$("#list").jqGrid('getGridParam','selrow');  
		                       var rowData = jQuery("#list").getRowData(rowId);
		                       
		                       
		           			var count = jQuery("#list").jqGrid('getGridParam', 'records');
		        			var allRowsInGrid1 = $('#list').getGridParam('data');
		                       
		                       
		                    	var quantity = rowData['quantity'];
		                    	var buyPrice = rowData['prrice'];
		                    	
		                    	var tota = quantity * buyPrice;
		                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
		                    	
		                    	for (var j = 0; j < count; j++)
		                    	{
		                    		var forTotal = allRowsInGrid1[j].forTotal;
		  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
		            		     	var prrice = allRowsInGrid1[j].prrice;	
		                    		FinalTotal = +FinalTotal + (quantity*prrice);
		                    	}
		                    					                    	
		                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
		                    	document.getElementById("totalAmount").value = FinalTotal;
							
		                    	//updateData();
		                    	//updateNewDataDelete();
						},

						onSelectRow : function(
								id) {
							if (id
									&& id !== lastSel) {
								jQuery(
										"#list")
										.saveRow(
												lastSel,
												true,
												'clientArray');
								jQuery(
										"#list")
										.editRow(
												id,
												true);
								lastSel = id;
								console
										.log(id);
							}
						}

					});
		});
		
			}); 

		}); 
}



function updateData(){
	
	
	
	
	var tota=0;
	var params= {};
	var count = jQuery("#list").jqGrid('getGridParam', 'records');
	var allRowsInGrid1 = $('#list').getGridParam('data');
	var AllRows=JSON.stringify(allRowsInGrid1);
	
	for (var i = 0; i <count; i++) {
	
		var pkTempId = allRowsInGrid1[i].pkTempId;
     	params["pkTempId"+i] = pkTempId;
		
		var itemId = allRowsInGrid1[i].itemId;
     	params["itemId"+i] = itemId;
     	
		var itemName = allRowsInGrid1[i].itemName;
		params["itemName"+i] = itemName;
		
		var quantity = allRowsInGrid1[i].quantity;
		params["quantity"+i] = quantity;
		
		var prrice = allRowsInGrid1[i].prrice;
		params["prrice"+i] = prrice;
		
		var unit = allRowsInGrid1[i].unit;
		params["unit"+i] = unit;
		
		var value = allRowsInGrid1[i].value;
		params["value"+i] = value;
		
		var totalAmt = allRowsInGrid1[i].totalAmt;
		params["totalAmt"+i] = totalAmt;
		
		var total=quantity*prrice;
		
		
		tota=tota+total;
	}
	
	 document.getElementById("totalAmount").value = tota;
	
	params["count"] = count;
	  
//		params["methodName"] = "updateGridData";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{  
			
			   return true;
				    }
		    	).error(function(jqXHR, textStatus, errorThrown){
		    		if(textStatus==="timeout") {
		    			$(loaderObj).hide();
		    			$(loaderObj).find('#errorDiv').show();
		    		}
		    	});
	
}

function updateNewData(){
	
	var tota=0;
	var params= {};
	var count = jQuery("#list").jqGrid('getGridParam', 'records');
	var allRowsInGrid1 = $('#list').getGridParam('data');
	var AllRows=JSON.stringify(allRowsInGrid1);
	
	for (var i = 0; i<count; i++) {
	
		var pkTempId = allRowsInGrid1[i].pkTempId;
     	params["pkTempId"+i] = pkTempId;
		
		var itemId = allRowsInGrid1[i].itemId;
     	params["itemId"+i] = itemId;
     	
		var itemName = allRowsInGrid1[i].itemName;
		params["itemName"+i] = itemName;
		
		var quantity = allRowsInGrid1[i].quantity;
		params["quantity"+i] = quantity;
		
		var prrice = allRowsInGrid1[i].prrice;
		params["prrice"+i] = prrice;
		
		var unit = allRowsInGrid1[i].unit;
		params["unit"+i] = unit;
		
		var value = allRowsInGrid1[i].value;
		params["value"+i] = value;
		
		var stock = allRowsInGrid1[i].stock;
		params["stock"+i] = stock;
		
		if(Number(quantity)>Number(stock))
			{
			alert("Stock not availble");
			return false;
			}
		var gst = allRowsInGrid1[i].gst;
		
		
		if(gst =="" || gst == null || gst == undefined){
			gst = 0;
			
		
		}
		params["gst"+i] = gst;
	
		/*var cgst = allRowsInGrid1[i].cgst;
		params["cgst"+i] = cgst;
		
		var sgst = allRowsInGrid1[i].sgst;
		params["sgst"+i] = sgst;*/
		
		var totalAmt = quantity * prrice;
		
		if(gst != 0){
	    	var gst1 = ((gst)/(100)*totalAmt);
	    	totalAmt  = totalAmt + gst1;
	    	}
//	    	if(sgst != 0){
//	    	var gst2 = ((sgst)/(100)*totalAmt);
//	    	totalAmt  = totalAmt + gst2;
//	    	}
		
		var forTotal = allRowsInGrid1[i].forTotal;
	/*	params["forTotal"+i] = forTotal; */
		
//		var totalAmt = quantity * prrice;
		params["totalAmt"+i] = totalAmt;
		
/*		var stockhide = allRowsInGrid1[i].stock;
		params["stockhide"+i] = stockhide; */
		
//		var total=quantity*prrice;
		var total = 0;
		total = (quantity*prrice);
		var tot1 = 0;
		var tot2=0;
		if(gst != 0){
	    	var gst1 = (((gst)/(100))*(quantity*prrice));
	    	tot1  = tot1 + gst1;
	    	total = total + tot1;
			}
/*	    	if(sgst != 0){
	    	var gst2 = (((sgst)/(100))*(quantity*prrice));
	    	tot2  = tot2 + gst2;
	    	}
	    	if(tot1!=0 || tot2 !=0){
	    	total = (quantity*prrice)+tot1+tot2;
	    	}*/
	    	
	    	//		tota= tota+forTotal;
		tota=tota+total;
	}
	
	 document.getElementById("totalAmount").value = tota;
	
	params["count"] = count;
	  
		params["methodName"] = "updateGridDatanw";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{  
			
			   return true;
				    }
		    	).error(function(jqXHR, textStatus, errorThrown){
		    		if(textStatus==="timeout") {
		    			$(loaderObj).hide();
		    			$(loaderObj).find('#errorDiv').show();
		    		}
		    	});
}


function updateNewDataDelete(pkTempId)
{
	

/*	var input = document.getElementById('fk_item_id'),
    list = document.getElementById('fk_item_id_drop'),
    i,fk_item_id;
for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input.value) {
    	fk_item_id = list.options[i].getAttribute('data-value');
    }
	
}
	
	//var pkTempId =$('pkTempId').val();
	
	var tota=0;
	var params= {};
	var count = jQuery("#list").jqGrid('getGridParam', 'records');
	var rowId = $("#list").jqGrid('getGridParam','selrow');
	var allRowsInGrid1 = $('#list').getGridParam('data');
	var AllRows=JSON.stringify(allRowsInGrid1); */
	var tota=0;
	var params= {};
	var count = jQuery("#list").jqGrid('getGridParam', 'records');
	var rowId = $("#list").jqGrid('getGridParam','selrow');
	var ids = jQuery("#list").jqGrid('getDataIDs');
	var allRowsInGrid1 = $('#list').getGridParam('data');
	var AllRows=JSON.stringify(allRowsInGrid1);
	var rowData = jQuery("#list").getRowData(rowId);
	var pkTempId =rowData['pkTempId'];
	
	
	for (var i = 0; i<count; i++) {
	
/*		var pkTempId = allRowsInGrid1[i].pkTempId;
     	params["pkTempId"+i] = pkTempId;
		
		var itemId = allRowsInGrid1[i].itemId;
    // 	params["itemId"+i] = itemId;
     	
   	*/
		var quantity = allRowsInGrid1[i].quantity;
//		params["quantity"+i] = quantity;
		
		var prrice = allRowsInGrid1[i].prrice;
		var fortotal = allRowsInGrid1[i].forTotal;
		var gst = allRowsInGrid1[i].gst;
	//	var sgst = allRowsInGrid1[i].sgst;
		
		//		params["prrice"+i] = prrice;
	/*	
		var prrice = allRowsInGrid1[i].forTotal;
			
		var totalAmt = allRowsInGrid1[i].totalAmt;
	//	params["totalAmt"+i] = totalAmt;
		
		var totalAmt = quantity * prrice;
//		params["totalAmt"+i] = totalAmt;
		
		var total=quantity*prrice; */
		
		
		var total = 0;
		tota  = (quantity*prrice);
		var tot1 = 0;
		var tot2=0;
		
		if(gst != 0){
	    	var gst1 = (((gst)/(100))*(quantity*prrice));
	    	tot1  = tot1 + gst1;
	    //	tota = tota + tot1;
	    	}
			if(tot1!=0){
	    	total = (quantity*prrice)+tot1;
	    	}
			if(total ==0  || total == null || total == undefined){
	    		total = (quantity*prrice);
	    	}
			
			tota=tota+total;
			
	   	//	tota=tota+fortotal;
	}
	 
	
	 document.getElementById("totalAmount").value = tota; 
	
	//params["count"] = count;
	params["pkTempId"] = pkTempId;
	//params["table_No"] = table_No;
	  
		params["methodName"] = "updateGridDataDelete";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{  
			 //getItemDetailByTable(data);
			   return true;
				    }
		    	).error(function(jqXHR, textStatus, errorThrown){
		    		if(textStatus==="timeout") {
		    			$(loaderObj).hide();
		    			$(loaderObj).find('#errorDiv').show();
		    		}
		    	});






}


function getItemDetailByTable1(tableNo)
{
	
/*	var abc = data.value;
	var tableNo = +abc;
	document.getElementById("table_No").value = tableNo;	
*/	
	
//var tableNo = $('#table_No').val();	
	
var params = {};

params["tableNo"] = tableNo;

params["methodName"] = "getItemDetailByTable10";
						
$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		{ 
	var jsonData = $.parseJSON(data);
	console.log(jsonData)
	//   $("#list").jqGrid("clearGridData", true).trigger("reloadGrid");
       
	$.each(jsonData,function(i,v)
			{
		
		function sumFmatter (cellvalue, options, rowObject)
		{
			var params={};
			
			var tot= (options.rowData.quantity * options.rowData.prrice);
			//document.getElementById("totalAmount").value = tot;
			
			var jam = 0; 
			var count = jQuery("#list").jqGrid('getGridParam', 'records');
			var allRowsInGrid1 = $('#list').getGridParam('data');
			var AllRows=JSON.stringify(allRowsInGrid1);
			for (var i = 0; i < count; i++) {
		     	
		     	var quantity = allRowsInGrid1[i].quantity;
		     	params["quantity"+i] = quantity;
		     	
		     	var itemName = allRowsInGrid1[i].itemName;
		    	params["itemName"+i] = itemName;
		    	
		     
		     	var prrice = allRowsInGrid1[i].prrice;
		    	params["prrice"+i] = prrice;
		    	
		    	var totals1 = quantity * prrice;
		    	jam = jam + totals1;
		    	
		    }
				
				 document.getElementById("totalAmount").value = jam;
			     return tot;
		}
		
	//	document.getElementById('fk_item_id').value = "";

		$(document).ready(function () {
			var lastsel;
			rownumbers: true,
			
			

			$("#list").jqGrid({

				datatype:"local",
				editurl: 'clientArray',
				colNames: ["pkTempId","pkItemId","Item Name","Quantity","Unit Price","UnitInMl","Total","AllTotal","stock", "stockhide"],

				colModel: [
                           {
	                           name:"pkTempId",
	                           hidden:true
                           },
				           {
				        	   name:"pkItemId",
				        	   hidden:true
				           },
				           { 	
				        	   name: "itemName",
				        	   width: 200,
				           },
				           {
				        	   name: "quantity",
				        	   width: 100,
				        	   editable: true
				           },	

				           {
				        	   name:  "prrice",
				        	   width: 200,
				        	   editable: true
				           },

				           {
				        	   name: "unitinMl",
				        	   width: 200,
				        	   editable: true
				           },
				           {
				        	   name: "totalAmt",
				        	   formatter: sumFmatter,
				        	   sorttype: 'number',
				        	   width: 250,
				           },
				           {
				        	   name: "totalAmt",
				        	   hidden : true
				      
				       
				           },
				           
				           {
				        	    name: "stock",
					        	 width: 250,
					        	 hidden : true
					       },
				          {
				        	 name: "stockhide",
				        	 width: 250,
				        	 hidden: true
				          }
				           
					       ],

				           sortorder : 'desc',

				           loadonce: true,
				           viewrecords: true,
				           width: 950,
				           height: 300,
				           rowNum: 10,
				           hoverrows: true,
				           rownumbers: true, // show row numbers
			               rownumWidth: 25,
			             
				           pager: "#jqGridPager",
				          'cellEdit':true

			});
			
			$("#list").addRowData(i+1,jsonData[i]);

			    function calDiscount(cellvalue, options, rowObject){
				return ((options.rowData.buyPriceForItemNAme)*(options.rowData.quantity))+(((options.rowData.buyPriceForItemNAme)*(options.rowData.quantity))*((options.rowData.vatPec)/100));
			} 

			$('#list').navGrid('#jqGridPager',
					// the buttons to appear on the toolbar of the grid
					{ add: false, edit: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
					
					// options for the Edit Dialog
					{
						editCaption: "The Edit Dialog",
						recreateForm: true,
						checkOnUpdate : true,
						checkOnSubmit : true,
						
						closeAfterEdit: true,
					},
					
					// options for the Delete Dailog
					{
						delCaption: "delete row",
						closeAfterdel:true,
						recreateForm: true,
						onclickSubmit: function (request, postdata)
						{
							var params={};
							
							var tot= (options.rowData.quantity * options.rowData.price);
							
							var jam = 0; 
							var count = jQuery("#list").jqGrid('getGridParam', 'records');
							var allRowsInGrid1 = $('#list').getGridParam('data');
							var AllRows=JSON.stringify(allRowsInGrid1);
							for (var i = 0; i <= count; i++) {
								
						     	var quantity = allRowsInGrid1[i].quantity;
						     	params["quantity"+i] = quantity; 
						     	
						     	var prrice = allRowsInGrid1[i].prrice;
						    	params["prrice"+i] = prrice;
						    	
						    	var totals1 = quantity * prrice;
						    	jam = jam + totals1;
							
						    }
								 document.getElementById("totalAmount").value = jam;
							     //return tot;
							
						} ,
					/*	afterComplete : function() {
							$('#jqGrid').trigger('reloadGrid');

							// $(this).trigger('reloadGrid');
							var rowId = $("#jqGrid").jqGrid('getGridParam','selrow');
							var rowData = jQuery("#jqGrid").getRowData(rowId);
							var count = jQuery("#jqGrid").jqGrid('getGridParam','records');
							var params={};
							
							var tot= (options.rowData.quantity * options.rowData.price);
							
							var jam = 0; 
							var count = jQuery("#list").jqGrid('getGridParam', 'records');
							var allRowsInGrid1 = $('#list').getGridParam('data');
							var AllRows=JSON.stringify(allRowsInGrid1);
							for (var i = 0; i <= count; i++) {
								
						     	var quantity = allRowsInGrid1[i].quantity;
						     	params["quantity"+i] = quantity; 
						     	
						     	var prrice = allRowsInGrid1[i].prrice;
						    	params["prrice"+i] = prrice;
						    	
						    	var totals1 = quantity * prrice;
						    	jam = jam + totals1;
							
						    }
								 document.getElementById("totalAmount").value = jam;

						},
						
  */

						errorTextFormat: function (data) {
							return 'Error: ' + data.responseText
						},
						
						
						onSelectRow: function(id) {
							if (id && id !== lastSel) {
								jQuery("#list").saveRow(lastSel, true, 'clientArray');
								jQuery("#list").editRow(id, true);
								lastSel = id;
								console.log(id);
							}
						}
					});
			
			//$("#list").jqGrid("clearGridData", true).trigger("reloadGrid");
			
	//		$('#list').trigger( 'reloadGrid' );
	//		$('#list').data('kendoGrid').refresh();
		});
	
			}); 

		}); 
}

function OrderGetBillNo(){
	var TableNo = $('#table_No').val();

	$("#Bill_No").empty();
	$("#Bill_No").append($("<option></option>").attr("value", "").text("Select Bill No"));

	var params = {};

	params["table_No"] = TableNo;
	params["methodName"] = "getAllBillByOrderDetails";

	$.post('/RMS/jsp/utility/controller.jsp',params, function(data) {

		var jsonData = $.parseJSON(data);
		// var jsonData = jsonData.list;
		$.each(jsonData, function(i, v) {
			$("#Bill_No").append($("<option></option>").attr("value", i).text(v.billNo));
			
		});
	})
}

/*function resBill(){
//	var tabNum = document.getElementById("table_No").value;
	var  abc = data.id;
	var tabNum = +abc;
	if(tabNum ==0){
		alert("Select Item First !!!!");
		return false;
	}
	registerBill();
}*/

function registerBill(){
	
	var params= {};
	var count = jQuery("#list").jqGrid('getGridParam', 'records');
	if(count == null || count ==0){
		alert("Please select the Item first");
		return false;
	}
	var allRowsInGrid1 = $('#list').getGridParam('data');
	var AllRows=JSON.stringify(allRowsInGrid1);
	
	for (var i = 0; i < count; i++)
	{
	
		var pkTempId = allRowsInGrid1[i].pkTempId;
     	params["pkTempId"+i] = pkTempId;
/*     	console.log("pk tempID -  "+pkTempId);*/
		
		var itemId = allRowsInGrid1[i].itemId;
     	params["itemId"+i] = itemId;
     /*	console.log("item ID -  "+itemId);*/
     	
		var itemName = allRowsInGrid1[i].itemName;
		params["itemName"+i] = itemName;
		
		var quantity = allRowsInGrid1[i].quantity;
		params["quantity"+i] = quantity;
				
		var stock = allRowsInGrid1[i].stock;
		params["stock"+i] = stock;
		
		
 		if(quantity ==0 || quantity =="")
 			{
 			alert("Plz enter valid quantity");
 			return false;
 			}
		
		
		
		var quantity = allRowsInGrid1[i].quantity;
/*		if(quantity > stock){
			alert("Stock of "+itemName+" is less than the Quantity Entered");
			return false;
		}
		else{  */
		params["quantity"+i] = quantity;
//		}
		
		var prrice = allRowsInGrid1[i].prrice;
		params["prrice"+i] = prrice;
		
	/*	var unitinMl = allRowsInGrid1[i].unitinMl;
		params["unitinMl"+i] = unitinMl;
	*/
		
		var unit = allRowsInGrid1[i].unit;
		params["unit"+i] = unit;
		
		var value = allRowsInGrid1[i].value;
		params["value"+i] = value;
		
		var gst = allRowsInGrid1[i].gst;
		
		var gst1 = (gst)/2;
		
		var cgst = gst1;
		params["cgst"+i] = cgst;
		
		var sgst = gst1;
		params["sgst"+i] = sgst;
		
		var totalAmt = allRowsInGrid1[i].totalAmt;
	//	params["totalAmt"+i] = totalAmt;
	//	alert("total amnt in grid - "+totalAmt);
		
		var forTotal = allRowsInGrid1[i].forTotal;
		params["forTotal"+i] = forTotal;
	//	alert("forTotal amnt in grid - "+forTotal);
	//	alert("total amounnt is -- "+totalAmt);
		
	}	
	
//	var  abc = data.id;

//	var table_No = +abc;
	
	//    var table_No=$('#table_No').val();
	    
	    var waiterName=$('#waiterName').val();
	    var totalAmount =$('#totalAmount').val();
	    var gst = 0;
	    var gstAmt = 0;
	    
	//	params ["table_No"] = table_No;

		params["count"] = count;
		
		params["waiterName"] = waiterName;
		params["totalAmount"] = totalAmount;
		params["gst"]  = gst;
		params["gstAmt"] = gstAmt;
		
		params["methodName"] = "registerBillnew";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{
			
				alert(data);
			//	window.open("Other_Bill_CopyPDF.jsp");
		//		window.open("temp1PDF.jsp");
		//		window.open("KioskBilling-PDF.jsp")
				window.open("pdfkiosk.jsp");
				location.reload(true);
			    return false;
		/*	$.getScript('/RMS/staticContent/js/bootbox.min.js', function() 
						{
			
			    	var msg=data;
					var dialog = bootbox.dialog({
						//title: "Embel Technologies Says :",
						   message: '<p class="text-center">'+msg.fontcolor("red").fontsize(5),
						    closeButton: false
					});
					
					setTimeout(function() {
						dialog.modal('hide');
						location.reload();
					//	document.createUser.createbtn.disabled = false;
					}, 1500);
					
					return false;
					
						});			*/	
			//	window.open("temp1PDF.jsp");
			//	location.reload(true);
			   // return false;
			   
				    }
		    	).error(function(jqXHR, textStatus, errorThrown){
		    		if(textStatus==="timeout") {
		    			$(loaderObj).hide();
		    			$(loaderObj).find('#errorDiv').show(); 
		    		}
		    	});
}


/*function gstCal(){

	
	var total  = document.getElementById("totalAmount").value;
	var gst = document.getElementById("gst").value
	var gstt = ((gst)/(100))

	var gsttt = ((gstt) * (total));
	
	var final = +total + +gsttt;
	
	document.getElementById("gstAmt").value = gsttt;
	document.getElementById("grndtotalAmount").value = final;

}*/