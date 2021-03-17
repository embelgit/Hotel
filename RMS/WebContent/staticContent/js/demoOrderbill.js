function shree(){
	var id=$("#fk_item_id").val(); 

	var itemname= $('#fk_item_id_drop').find('option[data-value="' +id + '"]').attr('value');
	var abc = itemname;
	if(abc == undefined){
		document.getElementById('fk_item_id').value=id;
		getItemDetailById();
	}
	if(abc != undefined){
	document.getElementById('fk_item_id').value=itemname;
	getItemDetailById();
	abc();
	}
}

function unBookTable(){

	var table_No = $('#table_No').val();

	var params = {};
	
	params["table_No"] = table_No;
	
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

function abc(){
	
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
}

/*function tableValidation(){
	var tabNum = document.getElementById("table_No").value;
		if(tabNum == 0){
			 alert("select Table First!!!!!!")
			location.reload();
         } 
}*/ 
function BillCopy(){
	if(document.order.table_No.value==""){
		alert("Please Select Table Name");
		return false;
	}
	if(document.order.Bill_No.value ==""){
		alert("Please Select Bill No");
		return false;
	}
	BillCopy1();
}
function BillCopy1(){
	
	var tableno = $('#table_No').val();
	var billno = $('#Bill_No').val();
	var params = {};
	params["table_No"] = tableno;
	params["Bill_No"] = billno;

	params["methodName"] = "BillCopyMethod";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
	
		location.reload(true);
		window.open("Copy_Other_Bill_CopyPDF.jsp");
	}).error(function(jqXHR, textStatus, errorThrown) {
		if (textStatus === "timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}


function resBill(){
	
	var tabNum = document.getElementById("table_No").value;
	if(tabNum ==0){
		alert("Select table First!!!!!!");
		return false;
	}
	
/*	if (document.order.fk_item_id.value == "") {
		alert("Please Enter Item Name");
		return false;
	}*/
	
	if (document.order.table_No.value == "") {
		alert("Please Enter Table No");
		return false;
	}
	if (document.order.waiterName.value == "") {
		alert("Please Enter Waiter Name");
		return false;
	}
	var tableNo = document.getElementById("table_No").value;
	 if (confirm("Do You Want to Print Bill Of Table No ::--  "+tableNo+"  !!") == true) {
		 registerBill();
	    } else {
	       alert("Bill Print Cancelled !!!");
	    }
}

function registerBill(){
	
	var params= {};
	var count = jQuery("#list").jqGrid('getGridParam', 'records');
	var allRowsInGrid1 = $('#list').getGridParam('data');
	var AllRows=JSON.stringify(allRowsInGrid1);
	
	for (var i = 0; i < count; i++)
	{
	
		var pkTempId = allRowsInGrid1[i].pkTempId;
     	params["pkTempId"+i] = pkTempId;
		
		var itemId = allRowsInGrid1[i].itemId;
     	params["itemId"+i] = itemId;
     	
		var itemName = allRowsInGrid1[i].itemName;
		params["itemName"+i] = itemName;
		
		var stock = allRowsInGrid1[i].stock;
		params["stock"+i] = stock;
		
		var quantity = allRowsInGrid1[i].quantity;
		if(quantity > stock){
			alert("Stock of "+itemName+" is less than the Quantity Entered");
			return false;
		}
		else{
		params["quantity"+i] = quantity;
		}
		
		var prrice = allRowsInGrid1[i].prrice;
		params["prrice"+i] = prrice;
		
		var unitinMl = allRowsInGrid1[i].unitinMl;
		params["unitinMl"+i] = unitinMl;
		
		var totalAmt = allRowsInGrid1[i].totalAmt;
		params["totalAmt"+i] = totalAmt;
	//	alert("total amounnt is -- "+totalAmt);
		
	}	
	
	    var table_No=$('#table_No').val();
	    
	    var waiterName=$('#waiterName').val();
	    var totalAmount =$('#totalAmount').val();
	
		params ["table_No"] = table_No;

		params["count"] = count;
		
		params["waiterName"] = waiterName;
		params["totalAmount"] = totalAmount;
		
		params["methodName"] = "registerBill";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{
			
				alert(data);
			//	window.open("Other_Bill_CopyPDF.jsp");
				window.open("tempPDF.jsp");
				location.reload(true);
			    return false;
/*			$.getScript('/RMS/staticContent/js/bootbox.min.js', function() 
					{
		
				var msg=data;
				var dialog = bootbox.dialog({
					//title: "Embel Technologies Says :",
				    message: '<p class="text-center">'+msg.fontcolor("red").fontsize(5),
				    closeButton: false
				});
				
				setTimeout(function() {
					dialog.modal('hide');
					location.reload(true);
					document.order.print.disabled = false;
				}, 1500);
				
				return false;
				
					});				
				window.open("Other_Bill_CopyPDF.jsp");
				location.reload(true);
			    return false;
*/			   
				    }
		    	).error(function(jqXHR, textStatus, errorThrown){
		    		if(textStatus==="timeout") {
		    			$(loaderObj).hide();
		    			$(loaderObj).find('#errorDiv').show(); 
		    		}
		    	});
}

function getItemDetailById()
{
	var input = document.getElementById('fk_item_id'),
    list = document.getElementById('fk_item_id_drop'),
    i,fk_item_id;
for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input.value) {
   	 fk_item_id = list.options[i].getAttribute('data-value');
    }
}

//document.getElementById('productName1').value="";

var tableNo = $('#table_No').val();

var myList = document.getElementsByName("p");
var xyz = tableNo - 1;
myList[xyz].style.backgroundColor = "green";
	
var params = {};

params["fk_item_id"] = fk_item_id;
params["tableNo"] = tableNo;

params["methodName"] = "getItemDetailsById";
$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		{
	     getItemDetailByTable1();
	
		}); 
}

function getId()
{
			
}

function getItemDetailByTable(data)
{
	var abc = data.value;
//	var tableNo = +abc;
//	document.getElementById("table_No").value = tableNo;
	var deletedPkTempId;
	
var params = {};

params["tableNo"] = tableNo;


params["methodName"] = "getItemDetailByTable";
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
		
		 document.getElementById('fk_item_id').value = "";
		
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
		
		var unitinMl = allRowsInGrid1[i].unitinMl;
		params["unitinMl"+i] = unitinMl;
		
		var totalAmt = allRowsInGrid1[i].totalAmt;
		params["totalAmt"+i] = totalAmt;
		
		var total=quantity*prrice;
		
		
		tota=tota+total;
	}
	
	 document.getElementById("totalAmount").value = tota;
	
	params["count"] = count;
	  
		params["methodName"] = "updateGridData";
		
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
		
		var unitinMl = allRowsInGrid1[i].unitinMl;
		params["unitinMl"+i] = unitinMl;
		
	/*	var totalAmt = allRowsInGrid1[i].totalAmt;
		params["totalAmt"+i] = totalAmt; */
		
		var totalAmt = quantity * prrice;
		params["totalAmt"+i] = totalAmt;
		
/*		var stockhide = allRowsInGrid1[i].stock;
		params["stockhide"+i] = stockhide; */
		
		var total=quantity*prrice;
		
		
		
		tota=tota+total;
	}
	
	 document.getElementById("totalAmount").value = tota;
	
	params["count"] = count;
	  
		params["methodName"] = "updateGridData";
		
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
	var params= {};
	var rowId = $("#list").jqGrid('getGridParam','selrow');
	var ids = jQuery("#list").jqGrid('getDataIDs');
	var rowData = jQuery("#list").getRowData(rowId);
	var pkTempId =rowData['pkTempId'];
	
	
/*	for (var i = 0; i<count; i++) {
	
		var pkTempId = allRowsInGrid1[i].pkTempId;
     	params["pkTempId"+i] = pkTempId;
		
		var itemId = allRowsInGrid1[i].itemId;
     	params["itemId"+i] = itemId;
     	
     	var tableNo = allRowsInGrid1[i].tableNo;
     	params["tableNo"+i] = tableNo;
     	
		var itemName = allRowsInGrid1[i].itemName;
		params["itemName"+i] = itemName;
		
		var quantity = allRowsInGrid1[i].quantity;
		params["quantity"+i] = quantity;
		
		var prrice = allRowsInGrid1[i].prrice;
		params["prrice"+i] = prrice;
		
		var unitinMl = allRowsInGrid1[i].unitinMl;
		params["unitinMl"+i] = unitinMl;
		
		var totalAmt = allRowsInGrid1[i].totalAmt;
		params["totalAmt"+i] = totalAmt;
		
		var totalAmt = quantity * prrice;
		params["totalAmt"+i] = totalAmt;
		
		var total=quantity*prrice;
		
		
		
		tota=tota+total;
	}
	 
	
	 document.getElementById("totalAmount").value = tota; */
	
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


function getItemDetailByTable1()
{
	
var tableNo = $('#table_No').val();	
	
var params = {};

params["tableNo"] = tableNo;

params["methodName"] = "getItemDetailByTable";
$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		{ 
	var jsonData = $.parseJSON(data);
	console.log(jsonData)
	   $("#list").jqGrid("clearGridData", true).trigger("reloadGrid");
       
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
		     	
		     	var prrice = allRowsInGrid1[i].prrice;
		    	params["prrice"+i] = prrice;
		    	
		    	var totals1 = quantity * prrice;
		    	jam = jam + totals1;
		    }
				
				 document.getElementById("totalAmount").value = jam;
			     return tot;
		}
		
		document.getElementById('fk_item_id').value = "";

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
/*
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
}*/

