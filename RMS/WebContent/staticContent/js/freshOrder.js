//var abc = data.value;
	//var tableNo = abc;
	
//	document.getElementById("table_No").value = tableNo;
//	alert("button u clicked -- "+tableNo);

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
	
	    //$("#list").jqGrid("clearGridData", true).trigger("reloadGrid");
        
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
				        	   editable: false
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