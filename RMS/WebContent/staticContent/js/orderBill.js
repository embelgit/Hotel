/*function listForOrderBill(){
	
	var tabNum = document.getElementById("table_No").value;
	if(tabNum ==0){
		alert("Select table First!!!!!!");
		return false;
	}
	
	if (document.order.waiterName.value == "") {
		alert("Please Enter Waiter Name");
		return false;
	}
	
	 window.open("ListOrderBill.jsp");
}*/
	
function orderkitchen()
{
	window.open("kitchenOrder.jsp");
}

function reloadPage() {
		window.location.reload(true);
	}

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
  //  	jam = jam + totals1;
    }
//		 document.getElementById("totalAmount").value = jam;
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

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
				alert(data);
				window.open("Copy_Other_Bill_CopyPDF.jsp");
				location.reload(true);
				return false;

//		window.open("temp2newPDF.jsp");
	}).error(function(jqXHR, textStatus, errorThrown) {
		if (textStatus === "timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}



function prtBill(){
	
	var tabNum = document.getElementById("table_No").value;
	if(tabNum ==0){
		alert("Select table First!!!!!!");
		return false;
	}
	
/*	if (document.order.fk_item_id.value == "") {
		alert("Please Enter Item Name");
		return false;
	}
	
	if (document.order.table_No.value == "") {
		alert("Please Enter Table No");
		return false;
	}
	if (document.order.waiterName.value == "") {
		alert("Please Enter Waiter Name");
		return false;
	}
/*	var tableNo = document.getElementById("table_No").value;
	 if (confirm("Do You Want to Print Bill Of Table No ::--  "+tableNo+"  !!") == true) {
	//	 registerBill();
	    } else {
	       alert("Bill Print Cancelled !!!");
	    } */
	 registerBill1();
}

function registerBill1(){
	
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
		
		if(quantity ==0 || quantity =="" || quantity == undefined || quantity == null)
			{
			alert("Please enter valid Quantity for product"  +itemName);
			return false;
			}
		if(+quantity > +stock){
			alert(" stock of "  +itemName+ " is low , please enter Quantity less than or equal to "+stock);
			return false;
			}
		else
			{
			params["quantity" +i] = quantity;
			}
		
		var prrice = allRowsInGrid1[i].prrice;
		params["prrice"+i] = prrice;
		
		var unit = allRowsInGrid1[i].unit;
		params["unit"+i] = unit;
		
		var value = allRowsInGrid1[i].value;
		params["value"+i] = value;
		
		var gst = allRowsInGrid1[i].gst;
	//	params["gst"+i] = gst;
		
		var gst1 = (gst)/2;
//		alert("gst splits - "+gst1+" %");
	
		var cgst = gst1;
		params["cgst"+i] = cgst;
		
		var sgst = gst1;
		params["sgst"+i] = sgst;
		
		var totalAmt = allRowsInGrid1[i].totalAmt;
//		params["totalAmt"+i] = totalAmt;
	//	alert("total amounnt is -- "+totalAmt);
		
	/*	var forTotal = allRowsInGrid1[i].forTotal;
		params["forTotal"+i] = forTotal;*/
	//		alert("fortotal - "+forTotal);
	}	
	
	    var table_No=$('#table_No').val();
	    
	    var waiterName=$('#waiterName').val();
	    var totalAmount =$('#totalAmount').val();
	    var gst = 0;
	    var gstAmt = 0;
	    
		params ["table_No"] = table_No;

		params["count"] = count;
		
		params["waiterName"] = waiterName;
		params["totalAmount"] = totalAmount;
		params["gst"] = gst;
		params["gstAmt"] = gstAmt;
		
		params["methodName"] = "registerBill";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{
			
				alert(data);
		//	System.out.println(" Data saved now its time to print PDF bill ----  ");
				//	window.open("Other_Bill_CopyPDF.jsp");
		//		window.open("tempPDF.jsp");
		//		window.open("Billing-PDF.jsp");
				window.open("pdfbill.jsp");
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
/*	var tableNo = document.getElementById("table_No").value;
	 if (confirm("Do You Want to Print Bill Of Table No ::--  "+tableNo+"  !!") == true) {
	//	 registerBill();
	    } else {
	       alert("Bill Print Cancelled !!!");
	    } */
	 registerBill();
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
		
		if(quantity ==0 || quantity =="" || quantity == undefined || quantity == null)
			{
			alert("Please enter valid Quantity for product"  +itemName);
			return false;
			}
		if(+quantity > +stock){
			alert(" stock of "  +itemName+ " is low , please enter Quantity less than or equal to "+stock);
			return false;
			}
		else
			{
			params["quantity" +i] = quantity;
			}
		
		var prrice = allRowsInGrid1[i].prrice;
		params["prrice"+i] = prrice;
		
		var unit = allRowsInGrid1[i].unit;
		params["unit"+i] = unit;
		
		var value = allRowsInGrid1[i].value;
		params["value"+i] = value;
		
		var gst = allRowsInGrid1[i].gst;
	//	params["gst"+i] = gst;
		
		var gst1 = (gst)/2;
//		alert("gst splits - "+gst1+" %");
	
		var cgst = gst1;
		params["cgst"+i] = cgst;
		
		var sgst = gst1;
		params["sgst"+i] = sgst;
		
		var totalAmt = allRowsInGrid1[i].totalAmt;
//		params["totalAmt"+i] = totalAmt;
	//	alert("total amounnt is -- "+totalAmt);
		
	/*	var forTotal = allRowsInGrid1[i].forTotal;
		params["forTotal"+i] = forTotal;*/
	//		alert("fortotal - "+forTotal);
	}	
	
	    var table_No=$('#table_No').val();
	    
	    var waiterName=$('#waiterName').val();
	    var totalAmount =$('#totalAmount').val();
	    var gst = 0;
	    var gstAmt = 0;
	    
		params ["table_No"] = table_No;

		params["count"] = count;
		
		params["waiterName"] = waiterName;
		params["totalAmount"] = totalAmount;
		params["gst"] = gst;
		params["gstAmt"] = gstAmt;
		
		params["methodName"] = "registerBill";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{
			
				alert(data);
		//	System.out.println(" Data saved now its time to print PDF bill ----  ");
				//	window.open("Other_Bill_CopyPDF.jsp");
		//		window.open("tempPDF.jsp");
		//		window.open("Billing-PDF.jsp");
				window.open("pdfbill.jsp");
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




function getItemDetailByTableNew(data)
{
	var abc = data.value;
	var tableNo = +abc;
	document.getElementById("table_No").value = tableNo;
	//var deletedPkTempId;
	
var params = {};

params["tableNo"] = tableNo;


//params["methodName"] = "getItemDetailByTable";
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



function getItemDetailByTable(data)
{
	var abc = data.value;
	var tableNo = +abc;
	document.getElementById("table_No").value = tableNo;
	
	document.getElementById("totalAmount").value = 0;
//	document.getElementById("gst").value = 0;
//	document.getElementById("gstAmt").value = 0;
//	document.getElementById("grndtotalAmount").value = 0;
//	document.getElementById("waiterName").value = "";
	
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
			var gst = (options.rowData.gst);
	//		var sgst = (options.rowData.sgst);
			
	    	var tot1=0;
        	var tot2 =0;
			if(gst != 0){
		    	var gst1 = ((gst)/(100)*(options.rowData.quantity * options.rowData.prrice));
		    	tot1  = tot1 + gst1;
		    	tot = tot + tot1;
		    	}
		    	/*if(sgst != 0){
		    	var gst2 = ((sgst)/(100)*(options.rowData.quantity * options.rowData.prrice));
    			 tot2  = tot2 + gst2;
		    	}*/
/*		    	if(tot1 !=0 || tot2 !=0){
	    			tot = (options.rowData.quantity * options.rowData.prrice)+tot1+tot2;
		    	}*/
		    	
			var rowId =$("#list").jqGrid('getGridParam','selrow');  
            var rowData = jQuery("#list").getRowData(rowId);
			var allRowsInGrid1 = $('#list').getGridParam('data');
			var AllRows=JSON.stringify(allRowsInGrid1);
			for (var j = 0; j < count; j++) {
				
		     	var quantity = allRowsInGrid1[j].quantity;		     	
		     	var prrice = allRowsInGrid1[j].prrice;	
		     	
		     	var gst = allRowsInGrid1[j].gst;
	//	     	var sgst = allRowsInGrid1[j].sgst;
		     	
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
		    	
		    	var tot1=0;
            	var tot2 =0;
		    	
		    	if(gst != 0){
		    	var gst1 = ((gst)/(100)*(quantity * prrice));
		    	tot1  = tot1 + gst1;
		    	totals1 = totals1 + tot1;
		    	}
		    	/*if(sgst != 0){
		    	var gst2 = ((sgst)/(100)*(quantity * prrice));
    			 tot2  = tot2 + gst2;
		    	}
		    	if(tot1 !=0 || tot2 !=0){
	    			totals1 = (quantity * prrice)+tot1+tot2;
		    	}*/
		    	
/*		    	if(vatPercentage != 0){

					var taxcal = (vatPercentage/100) * salePrice;
					var totals1=((salePrice)*(quantity)) + taxcal;
					jam = jam + totals1;
				}  */
		    	
		    	jam = jam + totals1;
		    	
//			    jam = jam + tot;
		    	
		    	
		    	
		    	
		    	
		    }
			    jam = jam + tot;
			    
/*				var gst = document.getElementById("gst").value
            	var Final = ((gst/100)*jam)+jam;*/
			    
/*				var gst = document.getElementById("gst").value
				var gstt = ((gst)/(100))

				var gsttt = ((gstt) * (jam));
				
				var final = +jam + +gsttt;
				
				document.getElementById("gstAmt").value = gsttt;
				document.getElementById("totalAmount").value = final;*/
			    
			    
				document.getElementById("totalAmount").value = jam;
	//			document.getElementById("grndtotalAmount").value = jam;
					
	//			document.getElementById("gst").value = 0;
	//			document.getElementById("gstAmt").value = 0;
				
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
				colNames: ["pkTempId","itemID","Item Name","tableNo","Quantity","Unit Price","Unit","unitValue","GST","Total","AllTotal","stock", "stockhide"],

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
				           /*{
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
				                    	var unit =rowData['unit'];
				                    	var forTotal = rowData['forTotal'];
				                    	var totalAmt = rowData['totalAmt'];
				                    	var tableNo = rowData['tableNo'];
				                    	var stock = rowData['stock'];
				                    	var itemId = rowData['itemId'];
				                    	var stockhide = rowData['stock'];
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
			                    		//	 var checkQuantity = /^[0-9]+$/;
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
				                    	var tot2 =0;
				                    	if(gst != 0){
				            		    	var gst1 = ((gst)/(100)*(quantity * buyPrice));
				            		    	tot1  = tot1 + gst1;
				            		    	tota = tota + tot1;
				                    		}
				            		    	/*if(sgst != 0){
				            		    	var gst2 = ((sgst)/(100)*(quantity * buyPrice));
				                			 tot2  = tot2 + gst2;
				            		    	}
				            		    	if(tot1 !=0 || tot2 !=0){
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
					                    	var tot2 =0;
					                    	if(gst != 0){
					            		    	var gst1 = ((gst)/(100)*(quantity * prrice));
					            		    	tot1  = tot1 + gst1;
					            		    	totals1 = totals1 + tot1;
					                    		}
/*					            		    	if(sgst != 0){
					            		    	var gst2 = ((sgst)/(100)*(quantity * prrice));
					                			 tot2  = tot2 + gst2;
					            		    	}
					            		    	if(tot1 !=0 || tot2 !=0){
					            		    		totals1 = (quantity * prrice)+tot1+tot2;
					            		    	}*/
				            		     	
				                    	//	FinalTotal = +FinalTotal + (quantity*prrice);
					            		    FinalTotal = +FinalTotal + forTotal;
				                    	//	FinalTotal = +FinalTotal + totals1;
				                    	}
				                    					                    	
				                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
				                   /* 	var gst = document.getElementById("gst").value
				                    	var FinalTotal1 = ((gst/100)*FinalTotal)+FinalTotal;*/
				                    	
				                   	 
				                    	document.getElementById("totalAmount").value = FinalTotal;
		//		                    	document.getElementById("grndtotalAmount").value = FinalTotal;
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
							
							var tableNo = rowData['tableNo'];
							var itemId = rowData['itemId'];
							
							updateNewDataDelete(pkTempId);
							updatekitchen(tableNo,itemId);
			//				document.getElementById("gst").value = 0;
			//				document.getElementById("gstAmt").value = 0;
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
		                    	
		                    	var gst = rowData['gst'];
		                  //  	var sgst = rowData['sgst'];
		                    	
		                    	var tota = quantity * buyPrice;
		                    	
		                    	var tot1=0;
		                    	var tot2 =0;
		                    	if(gst != 0){
		            		    	var gst1 = ((gst)/(100)*(quantity * buyPrice));
		            		    	tot1  = tot1 + gst1;
		            		    	tota = tota+tot1;
		                    	}
		            		    	/*if(sgst != 0){
		            		    	var gst2 = ((sgst)/(100)*(quantity * buyPrice));
		                			 tot2  = tot2 + gst2;
		            		    	}
		            		    	if(tot1 !=0 || tot2 !=0){
		            		    		tota = (quantity * buyPrice)+tot1+tot2;
		            		    	}*/
		                    	
		                    	$("#list").jqGrid("setCell", rowId, "forTotal", tota);
		                    	
		                    	for (var j = 0; j < count; j++)
		                    	{
		                    		var forTotal = allRowsInGrid1[j].forTotal;
		  				            var quantity = allRowsInGrid1[j].quantity;				            		     	
		            		     	var prrice = allRowsInGrid1[j].prrice;	
		            		     	var gst = allRowsInGrid1[j].gst;
		            		    // 	var sgst = allRowsInGrid1[j].sgst;
		            		     	
		            		     	var totals=0;
		            		     	var tot1=0;
		                        	var tot2 =0;
		            		    	
		                        	totals = (quantity*prrice);
		                        	
		            		    	if(gst != 0){
		            		    	var gst1 = ((gst)/(100)*(quantity * prrice));
		            		    	tot1  = tot1 + gst1;
		            		    
		            		    	}
/*		            		    	if(sgst != 0){
		            		    	var gst2 = ((sgst)/(100)*(quantity * prrice));
		                			 tot2  = tot2 + gst2;
		            		    	}*/
		            		    	if(tot1 !=0){
		            	    			totals = (quantity * prrice)+tot1;
		            		    	}
		            		     	
		            		     	
//		            		     	FinalTotal = +FinalTotal + (quantity*prrice);
		            		   // 	FinalTotal = +FinalTotal + +forTotal;
		            		    	FinalTotal = +FinalTotal + totals;
		                    	}
		                    					                    	
		                    	//$("#list").jqGrid("setCell", rowId, "forTotal", FinalTotal);
		                    	document.getElementById("totalAmount").value = FinalTotal;
		      //              	document.getElementById("grndtotalAmount").value = FinalTotal;
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
		
	/*	var unitinMl = allRowsInGrid1[i].unitinMl;
		params["unitinMl"+i] = unitinMl;*/
		
		var unit = allRowsInGrid1[i].unit;
		params["unit"+i] = unit;
		
		var value = allRowsInGrid1[i].value;
		params["value"+i] = value;
		
		/*	var totalAmt = allRowsInGrid1[i].totalAmt;
		params["totalAmt"+i] = totalAmt; */
		/*
		var cgst = allRowsInGrid1[i].cgst;
		if(cgst =="" || cgst == null || cgst == undefined){
			cgst = 0;
		}
		params["cgst"+i] = cgst;*/
		
/*		var sgst = allRowsInGrid1[i].sgst;
		if(sgst =="" || sgst == null || sgst == undefined){
			sgst = 0;
		}
		params["sgst"+i] = sgst;*/
		
		var gst = allRowsInGrid1[i].gst;
		if(gst =="" || gst == null || gst == undefined){
			gst = 0;
		}
		params["gst"+i] = gst;
		
		var totalAmt = quantity * prrice;
		
		if(gst != 0){
	    	var gst1 = ((gst)/(100)*totalAmt);
	    	totalAmt  = totalAmt + gst1;
	    	}
	    /*	if(sgst != 0){
	    	var gst2 = ((sgst)/(100)*totalAmt);
	    	totalAmt  = totalAmt + gst2;
	    	}*/
		
		params["totalAmt"+i] = totalAmt;
		
/*		var stockhide = allRowsInGrid1[i].stock;
		params["stockhide"+i] = stockhide; */
		
	/*	var total=quantity*prrice;
		
		
		if(cgst != 0){
	    	var gst1 = ((cgst)/(100)*total);
	    	total  = total + gst1;
	    	}
	    	if(sgst != 0){
	    	var gst2 = ((sgst)/(100)*total);
	    	total  = total + gst2;
	    	}*/
		
	    	var total = 0;
			
			var tot1 = 0;
			var tot2=0;
			if(gst != 0){
		    	var gst1 = (((gst)/(100))*(quantity*prrice));
		    	tot1  = tot1 + gst1;
		    	}
/*		    	if(sgst != 0){
		    	var gst2 = (((sgst)/(100))*(quantity*prrice));
		    	tot2  = tot2 + gst2;
		    	}*/
		    	if(tot1!=0){
		    	total = (quantity*prrice)+tot1;
		    	}
	    	
		    	if(total == 0 || total == "" || total == undefined){
		    		total = (quantity*prrice);
		    	
		    	}
		    	
		    	if(total !=0){
		    	tota=tota+total;
		    	}	
		    	
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
		/*
	var params= {};
	var rowId = $("#list").jqGrid('getGridParam','selrow');
	var ids = jQuery("#list").jqGrid('getDataIDs');
	var rowData = jQuery("#list").getRowData(rowId);
	var pkTempId =rowData['pkTempId']; */
	
	var tota = 0;
	var params= {};
	var count = jQuery("#list").jqGrid('getGridParam', 'records');
	var rowId = $("#list").jqGrid('getGridParam','selrow');
	var ids = jQuery("#list").jqGrid('getDataIDs');
	var allRowsInGrid1 = $('#list').getGridParam('data');
	var AllRows=JSON.stringify(allRowsInGrid1);
	var rowData = jQuery("#list").getRowData(rowId);
	var pkTempId =rowData['pkTempId'];
	
	for (var i = 0; i<count; i++) {
	/*
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
		*/
		var quantity = allRowsInGrid1[i].quantity;
		var prrice = allRowsInGrid1[i].prrice;
		var fortotal = allRowsInGrid1[i].forTotal;
		var gst = allRowsInGrid1[i].gst;
//		var sgst = allRowsInGrid1[i].sgst;
		
		var total = 0;
		
		var tot1 = 0;
		var tot2=0;
	
		if(gst != 0){
	    	var gst1 = (((gst)/(100))*(quantity*prrice));
	    	tot1  = tot1 + gst1;
	    	}
	    	/*if(sgst != 0){
	    	var gst2 = (((sgst)/(100))*(quantity*prrice));
	    	tot2  = tot2 + gst2;
	    	}*/
	    	if(tot1!=0){
	    	total = (quantity*prrice)+tot1;
	    	}
		
//		tota = tota+fortotal;
	    	if(total ==0  || total == null || total == undefined){
	    		total = (quantity*prrice);
	    	}
	    		tota=tota+total;
	}
	 
	
	 document.getElementById("totalAmount").value = tota; 
	
	//params["count"] = count;
	params["pkTempId"] = pkTempId;
	//params["table_No"] = table_No;
	  
		params["methodName"] = "updateGridDataDeleteold";
		
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
// to delete order from kitcen
function updatekitchen(tableNo,itemId){
	var params= {};
	var rowId = $("#list").jqGrid('getGridParam','selrow');
	var ids = jQuery("#list").jqGrid('getDataIDs');
	var rowData = jQuery("#list").getRowData(rowId);
	
	var tableNo =rowData['tableNo'];
	var itemId = rowData['itemId'];
	params["tableNo"] = tableNo;
	params["itemId"] = itemId;
	
	params["methodName"] = "deletekitchen";
	
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
	
/*var input = document.getElementById('fk_item_id'),
list = document.getElementById('fk_item_id_drop'),
    i,fk_item_id;
for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input.value) {
   	 fk_item_id = list.options[i].getAttribute('data-value');
    }
}*/	
//	document.getElementById("gst").value = 0;
//	document.getElementById("gstAmt").value = 0;
var tableNo = $('#table_No').val();	


var params = {};

params["tableNo"] = tableNo;
//params["fk_item_id"] = fk_item_id;

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
			var gst = (options.rowData.gst);
		//	var sgst = (options.rowData.sgst);
			
	    	var tot1=0;
        	var tot2 =0;
			if(cgst != 0){
		    	var gst1 = ((cgst)/(100)*(options.rowData.quantity * options.rowData.prrice));
		    	tot1  = tot1 + gst1;
		    	tot = tot + tot1;
			}
/*		    	if(sgst != 0){
		    	var gst2 = ((sgst)/(100)*(options.rowData.quantity * options.rowData.prrice));
    			 tot2  = tot2 + gst2;
		    	}
		    	if(tot1 !=0 || tot2 !=0){
	    			tot = (options.rowData.quantity * options.rowData.prrice)+tot1+tot2;
		    	}*/
			
			
			var jam = 0; 
			var count = jQuery("#list").jqGrid('getGridParam', 'records');
			var allRowsInGrid1 = $('#list').getGridParam('data');
			var AllRows=JSON.stringify(allRowsInGrid1);
			for (var i = 0; i < count; i++) {
		     	
		     	var quantity = allRowsInGrid1[i].quantity;
		     	params["quantity"+i] = quantity;
		     	
		     	var prrice = allRowsInGrid1[i].prrice;
		    	params["prrice"+i] = prrice;
		    	
		    	var gst = allRowsInGrid1[i].gst;
		    	params["gst"+i] = gst;
		   /* 	var sgst = allRowsInGrid1[i].sgst;
		    	params["sgst"+i] = sgst;*/
		    	
		    	var totals1 = quantity * prrice;
		    	
		    	var tot1=0;
            	var tot2 =0;
		    	
		    	if(cgst != 0){
		    	var gst1 = ((gst)/(100)*(quantity * prrice));
		    	tot1  = tot1 + gst1;
		    	totals1 = totals1 + tot1;
		    	}
		    	/*if(sgst != 0){
		    	var gst2 = ((sgst)/(100)*(quantity * prrice));
    			 tot2  = tot2 + gst2;
		    	}
		    	if(tot1 !=0 || tot2 !=0){
	    			totals1 = (quantity * prrice)+tot1+tot2;
		    	}*/
		    	
		    	jam = jam + totals1;
		    }
				 document.getElementById("totalAmount").value = jam;
	//			 document.getElementById("grndtotalAmount").value = jam;
			     return tot;
		}

		
		
		/*			var gst = document.getElementById("gst").value
		        	var Final = ((gst/100)*jam)+jam;*/
					
//					var total  = document.getElementById("totalAmount").value;
		/*			var gst = document.getElementById("gst").value
					var gstt = ((gst)/(100))

					var gsttt = ((gstt) * (jam));
					
					var final = +jam + +gsttt;
					
					document.getElementById("gstAmt").value = gsttt;
					document.getElementById("totalAmount").value = final;*/
					
					
					

		
		document.getElementById('fk_item_id').value = "";

		$(document).ready(function () {
			var lastsel;
			rownumbers: true,
			
			

			$("#list").jqGrid({

				datatype:"local",
				editurl: 'clientArray',
				colNames: ["pkTempId","pkItemId","Item Name","Quantity","Unit Price","Unit","unitValue","GST","Total","AllTotal","stock", "stockhide"],

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
				           /*{
				        	   name: "sgst",
				        	   width: 200,
				        	   editable: true
				           },*/
				           {
				        	   name: "forTotal",
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
					{ add: false, edit: true, del: true, search: true, refresh: false, view: true, position: "left", cloneToTop: false },
					
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
						    	
						    	var gst = allRowsInGrid1[i].gst;
						    	params["gst"+i] = gst;
						   /* 	var sgst = allRowsInGrid1[i].sgst;
						    	params["sgst"+i] = sgst;
						    */	
						    	var totals1 = quantity * prrice;
						    	
						    	var tot1=0;
				            	var tot2 =0;
						    	
						    	if(gst != 0){
						    	var gst1 = ((gst)/(100)*(quantity * prrice));
						    	tot1  = tot1 + gst1;
						    	totals1 = totals1 + tot1;
						    	}
						    	/*if(sgst != 0){
						    	var gst2 = ((sgst)/(100)*(quantity * prrice));
				    			 tot2  = tot2 + gst2;
						    	}*/
						    	/*if(tot1 !=0 || tot2 !=0){
						    		totals1 = (quantity * prrice)+tot1+tot2;
						    	}*/
						    	
						    	jam = jam + totals1;
							
						    }
							
/*							var gst = document.getElementById("gst").value
	                    	var FinalTotal1 = ((gst/100)*FinalTotal)+FinalTotal;*/
							
								 document.getElementById("totalAmount").value = jam;
		//						 document.getElementById("grndtotalAmount").value = jam;
							     //return tot;
		//						 document.getElementById("gst").value = 0;
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

function orderbilling(){
	var tabNum = document.getElementById("table_No").value;
	if(tabNum ==0){
		alert("Select table First!!!!!!");
    	return false;
	}
	orderbilling1();
}


function orderbilling1()
{
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
		
//		var stock = allRowsInGrid1[i].stock;
//		params["stock"+i] = stock;
		
		var quantity = allRowsInGrid1[i].quantity;
		params["quantity"+i] = quantity;
		
		var unit = allRowsInGrid1[i].unit;
		params["unit"+i] = unit;
		
		var value = allRowsInGrid1[i].value;
		params["value"+i] = value;
				
	}	
	
	    var table_No=$('#table_No').val();
	    	
		params ["table_No"] = table_No;

		params["count"] = count;
				
		params["methodName"] = "orderBill10";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{
			
				alert(data);
			//	window.open("kitchenOrder.jsp");
			//	location.reload(true);
			//    return false;

				    }
		    	).error(function(jqXHR, textStatus, errorThrown){
		    		if(textStatus==="timeout") {
		    			$(loaderObj).hide();
		    			$(loaderObj).find('#errorDiv').show(); 
		    		}
		    	});
}

function customerdetailsDivAction(a)
{
	if(a==1)
		{
		$("#customerdetailsDiv").dialog({
			height :240,
			width:600,
			resizable:true,
			draggable:false,
			position:
				{
				my:"center",
				at:"center",
				of:window,
				collision:"none",
				}
		})
		}
	else
		{
		$("#customerdetailsDiv").dialog('close');
		}
}

function myAlert(msg)
{
	var dialog = bootbox.dialog({
		message:'<p class="text-center">'+msg.fontcolor("red").fontsize(5)+'</p>',
		closeButton: false
	});
	setTimeout(function(){
		dialog.modal('hide');
	}, 1500);
	}

function successAlert(msg)
{

	var dialog = bootbox.dialog({
		message:'<p class="text-center">'+msg.fontcolor("green").fontsize(5)+'</p>',
		closeButton: false
	});
	setTimeout(function(){
		dialog.modal('hide');
	}, 1500);
	}

function valcustomer()
{
	
	var fkcustomerId =$("#fkcustomerId").val();
	var customerDOB = $("#customerDOB").val();
	var customerNumber = $("#customerNumber").val();
	
	if(fkcustomerId ==""){
		myAlert("Please Enter Customer Name");
		return false;
	}
	if(customerDOB ==""){
		myAlert("Please Enter Date of Birth ");
		return false;
	}
	
	
	if(customerNumber ==""){
		myAlert("Please Enter Mobile number");
		return false;
	}
	
	
	var letterNumber = /^[a-zA-Z ]+$/;
	if(fkcustomerId.match(letterNumber))
		{
	//	customerName();
		}
	else
	{
		myAlert("Enter Alphabets only in customer Name.");
		return false;
	}
	
	//if(document.Customer.customerNumber.value!="")
	//{
//	var letter = /^[0-9]$/;
	var letterNo = /^[0-9]{10}$/;
	if(customerNumber.match(letterNo))
	{
		
	}
	else
	{
		myAlert("Please Enter proper 10 digit Mobile Number");
	return false;
	}
	addCustomerDetails();
}
	
//}
	
function addCustomerDetails()
{
	var params = {};
	
	document.getElementById('save').disabled=true;

	var customerName = $('#fkcustomerId').val();
	var dob= $('#dob').val();
	var mobileNumber = $('#mobNo').val();
	
	
	params["customerName"] = customerName;
	params["dob"] = dob;
	params["mobileNumber"] = mobileNumber;
	
	params["methodName"] = "CustomerInfo";
	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
 		alert(data);
 		location.reload();
 			}
 	
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
}

function emptyCustomerFields()
{
	document.getElementById("fkcustomerId").value = "";
	document.getElementById("customerDOB").value = "";
	document.getElementById("customerNumber").value = "";
	

}



/*function gstCal(){

	
	var total  = document.getElementById("totalAmount").value;
	
//	var total = jam;
//	var nwtotal = total;
	
	var gst = document.getElementById("gst").value
	var gstt = ((gst)/(100))

	var gsttt = ((gstt) * (total));

		  var final = +total + +gsttt;
			document.getElementById("gstAmt").value = gsttt;
			document.getElementById("grndtotalAmount").value = final;
}*/

function resBill1(){
	
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
/*	var tableNo = document.getElementById("table_No").value;
	 if (confirm("Do You Want to Print Bill Of Table No ::--  "+tableNo+"  !!") == true) {
	//	 registerBill();
	    } else {
	       alert("Bill Print Cancelled !!!");
	    } */
	 registerBill1();
}


function registerBill1(){
	
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
		
		if(quantity ==0 || quantity =="" || quantity == undefined || quantity == null)
			{
			alert("Please enter valid Quantity for product"  +itemName);
			return false;
			}
		if(+quantity > +stock){
			alert(" stock of "  +itemName+ " is low , please enter Quantity less than or equal to "+stock);
			return false;
			}
		else
			{
			params["quantity" +i] = quantity;
			}
		
		var prrice = allRowsInGrid1[i].prrice;
		params["prrice"+i] = prrice;
		
		var unit = allRowsInGrid1[i].unit;
		params["unit"+i] = unit;
		
		var value = allRowsInGrid1[i].value;
		params["value"+i] = value;
		
		var gst = allRowsInGrid1[i].gst;
	//	params["gst"+i] = gst;
		
		var gst1 = (gst)/2;
//		alert("gst splits - "+gst1+" %");
	
		var cgst = gst1;
		params["cgst"+i] = cgst;
		
		var sgst = gst1;
		params["sgst"+i] = sgst;
		
		var totalAmt = allRowsInGrid1[i].totalAmt;
//		params["totalAmt"+i] = totalAmt;
	//	alert("total amounnt is -- "+totalAmt);
		
	/*	var forTotal = allRowsInGrid1[i].forTotal;
		params["forTotal"+i] = forTotal;*/
	//		alert("fortotal - "+forTotal);
	}	
	
	    var table_No=$('#table_No').val();
	    
	    var waiterName=$('#waiterName').val();
	    var totalAmount =$('#totalAmount').val();
	    var gst = 0;
	    var gstAmt = 0;
	    
		params ["table_No"] = table_No;

		params["count"] = count;
		
		params["waiterName"] = waiterName;
		params["totalAmount"] = totalAmount;
		params["gst"] = gst;
		params["gstAmt"] = gstAmt;
		
		params["methodName"] = "registerBill";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{
			
				alert(data);
		//	System.out.println(" Data saved now its time to print PDF bill ----  ");
				//	window.open("Other_Bill_CopyPDF.jsp");
		//		window.open("tempPDF.jsp");
		//		window.open("Billing-PDF.jsp");
				window.open("pdfbill.jsp");
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


//Move table Numbers
function gettablenumbers(){
	var params= {};

	var input = document.getElementById('fk_table_id'),
	list = document.getElementById('fk_table_id_drop1'),

	i,fkRootTableId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootTableId = list.options[i].getAttribute('data-value');
		}
	}
	
	$("#table_No").append($("<input/>").attr("value","").text());
	
	
	params["table_No"]= fkRootTableId;
	params["methodName"] = "gettableToEdit";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
				document.getElementById("tablenumber").value = v.hotelname;
			
				}
		);
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
		}
	});
}

function updateTable()
{
	//document.editTableNumber.btn.disabled = true;

	
	var input = document.getElementById('fk_table_id'),
	list = document.getElementById('fk_table_id_drop1'),
	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}
	

	//var itemName = $('#fk_item_id').val();
	var pk_id = fkRootSupId;
	var tableNo = $('#tablename').val();	
	var params = {};
	params['pk_id']=pk_id;
	params['tableNo'] = tableNo;
	
	params["methodName"] = "updatetable";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
			alert(data);
			location.reload();
		
		}
 	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
	
}


