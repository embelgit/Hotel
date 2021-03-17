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
			
			colNames:['Item Name','Purchase Price','Sale Price', 'Quantity','Total', 'pk_item_entry_Id'],
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
				
				
				{	name:'total',
					width:100,
					editable: false
				},
				
				{
					name:'pk_item_entry_Id',
					width:100,
					hidden: true	
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
			
         	 afterSaveCell: function  grossTotal()
			{
			       // 	Calculation of total after editing quantity         		 			
         		 			//var count = jQuery("#list4").jqGrid('getGridParam', 'records');
         		 
         		 			var rowId =$("#list4").jqGrid('getGridParam','selrow');  
	                        var rowData = jQuery("#list4").getRowData(rowId);
	                        var quantity1 = rowData['quantity'];
	                    	var buyPrice1 = rowData['buyPrice'];
	                    	var total = rowData['total'];
	                    	//var gst = rowData['gst'];
	                    	var SalePrice = rowData['salePrice'];
	                    	//var unit = rowData['unit'];
	                    	//var igst = rowData['igst'];
	                    	var gst = rowData['gst'];
	                  //  	var sgst = rowData['sgst'];
	                    	
	                    	var quantity = rowData['quantity'];
	                    	var buyPrice = rowData['buyPrice'];
	                    	//var gst1 = rowData['gst'];
	                    	//var gst = rowData['gst'];
	                    	//var gstAmount = rowData['gstAmount'];
	                    	
	                    	var value = rowData['value'];
	                    	//var stock = rowData['stock'];

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
	                    	
	                    var total1 = rowData['total'];
	                    	
	                    	//var totAmt1 = 0;
	                    	
	                    	/*var GST=0;
         		 			var tota = 0;
	                    	var quantity1 = 0;
	                    	var buyPrice1 = 0;
	                    	*/
	                    	
	                    	/*if(buyPrice1 !="")
							{
							var Price = /^\d{0,10}(?:\.\d{0,2})?$/;
							if(buyPrice1.match(Price))
							{}
							else
								{
								 var buy ="0";
								alert("Please Enter Only Number In Purchase Price ");
								$("#jqGrid").jqGrid("setCell",rowId, "buyPrice", buy);
								//location.reload();
								return false;
								}
							}
	                    	
	                    	
	                    	if(SalePrice !="")
							{
							var salePrice1 = /^\d{0,10}(?:\.\d{0,2})?$/;
							if(SalePrice.match(salePrice1)){
								
							}
							else
								{
								 var sale ="0";
								alert("Please Enter Only Number In Sale Price ");
								$("#jqGrid").jqGrid("setCell",rowId, "salePrice", sale);
								//location.reload();
								return false;
								}
							}
	                    	
	                    	if(unit !="")
							{
							var unitg = /^[a-zA-Z, ]+$/;
							if(unit.match(unitg)){
								
							}
							else
								{
								 var units ="0";
								alert("Please Enter Only Alphabates  In Unit");
								$("#jqGrid").jqGrid("setCell",rowId, "unit", units);
								//location.reload();
								return false;
								}
							}
	                    	
	                    	
	                    	if(quantity1 !="")
							{
							var quan = /^\d{0,10}(?:\.\d{0,2})?$/;
							if(quantity1.match(quan)){
								
							}
							else
								{
								 var quanti ="0";
								alert("Please Enter Only Number In Quantity ");
								$("#jqGrid").jqGrid("setCell",rowId, "quantity", quanti);
								//location.reload();
								return false;
								}
							}
	                    	
	                    	if(gst !="")
	                    	{
	                    	var gstd = /^\d{0,10}(?:\.\d{0,2})?$/;
	                    	if(gst.match(gstd))
	                    		{
	                    		
	                    		}
	                    	else{
	                    		var gsts ="0";
	                    		alert("Please Enter Only  Number In GST ");
	                    		$("#jqGrid").jqGrid("setCell",rowId, "gst", gsts);
	                    		return false;
	                    	}
	                    		
	                    	}
	                    	*/
	                    	
	                    	/*var tota = quantity * buyPrice * total;*/
	                    	/*var tota = quantity1 * buyPrice1;
                    		$("#list4").jqGrid("setCell", rowId, "total", tota);
                    		document.getElementById("grossTotal").value = tota;*/
	                    		
	                    	
                    		
                    		var count = jQuery("#list4").jqGrid('getGridParam', 'records');
        		        	var allRowsInGrid1 = $('#list4').getGridParam('data');
        		        	var AllRows=JSON.stringify(allRowsInGrid1);
        		        	var finalTotal = 0;
        		        	var totAmt1 = 0;
        		        	
        		        	var Total = 0;

        		        	for (var k = 0; k < count; k++)
        		        	{     
        		        		var tota = 0;
        		        		var abc = 0;
           		        	// var gstAmnt1 = 0;
        		        	// var gstAmnt2=0;
        		        	// var gstAmnt3=0;
        		        	//var tot1 = 0;
        		        	//var tot2=0;
        		        	 var tot3=0; 
        		        		//extra code
        		        	 if(buyPrice !=0 &&  quantity !=0)
        		        		 {
        		        		 tota =(quantity*buyPrice);
     		        			$("#list4").jqGrid("setCell", rowId, "total", tota);
        		        		 }
        		        		
        						 
								if(totAmt1 == undefined || totAmt1 == 'NaN' || totAmt1 == null)
        		        		{        
        		        			var total = 0;
        		        			$("#list4").jqGrid("setCell", rowId, "total", total);
        		        			return false;
        		        		}
								else
        		        		{
//									var tott = +tot1 + +tot2;
//        		        			$("#list4").jqGrid("setCell", rowId, "total", tott);
									if(tota == 0)
									{
									tota = (quantity*buyPrice);
									}
									$("#list4").jqGrid("setCell", rowId, "total", tota.toFixed(2));
        		        		}
								
									        		
        		        		
        		        	//	var total1 = allRowsInGrid1[k].total;
        		        		
        		        		/*if(total1 == undefined || total1 == null || total1 == 'NaN')
        		        		{
        		        			total1 = 0;
        		        			finalTotal = +finalTotal + +total1;
        		        		}
        		        		else
        		        		{
        		        			finalTotal = +finalTotal + +total1;
        		        		}*/
            		        	
        		        	var Total1 = allRowsInGrid1[k].total;
							if (Total1 != undefined) {
								
								Total = +Total + +Total1;
							}
    		        	}
    		        	

						

					//		document.getElementById("grossTotal").value = (Total).toFixed(2);
        		        	
        		        	
        		        	
        		        	//document.getElementById("grossTotal").value = GST;
        		  //      	document.getElementById("grossTotal").value = (finalTotal).toFixed(2);
        		        	
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
                    	var total = rowData['total'];
                    //	var gst = rowData['gst'];
                    	var SalePrice = rowData['salePrice'];
                    //	var unit = rowData['unit'];
                    	
                    	//var igst = rowData['igst'];
                    //	var gst = rowData['gst'];
                   // 	var sgst = rowData['sgst'];
                    	
                    	var quantity = rowData['quantity'];
                    	var buyPrice = rowData['buyPrice'];
                   // 	var gst1 = rowData['gst'];
                   // 	var gst = rowData['gst'];
                    	
               // // 
                    	var value = rowData['value'];
   
                    	
                    	
                		var count = jQuery("#list4").jqGrid('getGridParam', 'records');
    		        	var allRowsInGrid1 = $('#list4').getGridParam('data');
    		        	var AllRows=JSON.stringify(allRowsInGrid1);
    		        	var finalTotal = 0;
    		        	var totAmt1 = 0;
    		        
    		        	var Total = 0;
    		        	var tota = 0;
    		        	
      		        	 //var gstAmnt1 = 0;
      		        	// gstAmnt2=0;
      		        	// gstAmnt3=0;
      		        	// tot1=0;
      		        	//var tot2=0;
      		        	// tot3=0;
    		        	for (var k = 0; k < count; k++)
    		        	{        		        		
    		        		
    		        		
    		        		var abc = 0;
    /*		        		if(igst !=0 && (cgst !=0 || sgst !=0)){
    		        			alert("please either igst or cgst/sgst");
    		        			
    		        			$("#list4").jqGrid("setCell", rowId, "igst", abc);
    		        			$("#list4").jqGrid("setCell", rowId, "cgst", abc);
    		        			$("#list4").jqGrid("setCell", rowId, "sgst", abc);
//    		        			$("#list4").jqGrid("setCell", rowId, "total", tota);
    		        			return false;
    		        		}*/
						
    		        	//	tota = (quantity*buyPrice);
    		        //		gstAmnt = ((tota * gst) / 100);
    		        //		tota = tota	+ gstAmnt;
							/*
							if(igst != 0){
        		        		gstAmnt = ((tota * igst) / 100);
        		        		tota = tota	+ gstAmnt;
        		        		}
        		        		if(cgst != 0){
            		        		gstAmnt = ((tota * cgst) / 100);
            		        		tota = tota	+ gstAmnt;
            		        		}
        		        		if(sgst != 0){
            		        		gstAmnt = ((tota * sgst) / 100);
            		        		tota = tota	+ gstAmnt;
            		        		}	*/
						
    		        		if(buyPrice != 0 && quantity == 0){
        		        	//	gstAmnt1 = ((igst / 100)*(quantity*buyPrice));
        		        		//tot1 = (quantity*buyPrice)+gstAmnt1;
        		        		tota = (buyPrice*quantity);
        		        		}
    		        		
        		        		// if(gst != 0 && igst == 0){
            		        		//gstAmnt2 = ((gst / 100)*(quantity*buyPrice));
            		        		//tot2 = (quantity*buyPrice) + gstAmnt2;
            		        	//	tota = tota + tot2;
        		        		// }

        		        		/* if(sgst != 0 && igst == 0){
            		        		gstAmnt3 = ((sgst / 100)*(quantity*buyPrice));
            		        		tot3 = (quantity*buyPrice)	+ gstAmnt3;
            		        		}*/
        		        		 
        		        		 
        		        	/*	if(igst !=0 && gst !=0)
        		        			{
        		        			alert("please enter either igst or gst");
        		        			var abc = 0;
        		        			$("#list4").jqGrid("setCell", rowId, "igst", abc);
        		        			$("#list4").jqGrid("setCell", rowId, "gst", abc);
        		      //  			$("#list4").jqGrid("setCell", rowId, "sgst", abc);
        		        //			$("#list4").jqGrid("setCell", rowId, "total", tota);
        		       // 			document.getElementById("grossTotal").value = (tota)
        		        			return false;
        		        	//		break;
        		        			}*/
/*       		        		 if(tot2!=0 && tot3!=0){
    		        			 tota = +tot2 + +tot3;
    		        		 }		*/
        		        		
							
							if(totAmt== null)
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
							
							/*if((cgst !=0 && sgst == 0) || (cgst ==0 && sgst !=0)){
		        		 			alert("please enter both cgst and sgst");
		        		 			return false;
		        		 		} */     		
    		        		
    		        	/*	var total1 = allRowsInGrid1[k].total;
    		        		
    		        		if(total1 == undefined || total1 == null || total1 == 'NaN')
    		        		{
    		        			total1 = 0;
    		        			finalTotal = +finalTotal + +total1;
    		        		}
    		        		else
    		        		{
    		        			finalTotal = +finalTotal + +total1;
    		        		} */
    		        		
    		            	var Total1 = allRowsInGrid1[k].total;
							if (Total1 != undefined) {
								Total = +Total + +Total1;
							}
    		        	}
    		        	
    		        	//document.getElementById("grossTotal").value = GST;
    		        	document.getElementById("grossTotal").value = (Total).toFixed(2);
    	     	document.getElementById("grossTotal").value = (finalTotal).toFixed(2);
	 	        	},
	                		
	 	        	/*errorTextFormat: function (data) {
						return 'Error: ' + data.responseText
					},
					
					
					onSelectRow: function(id) {
						if (id && id !== lastSel) {
							jQuery("#list4").saveRow(lastSel, true, 'clientArray');
							jQuery("#list4").editRow(id, true);
							lastSel = id;
							console.log(id);
						}
					}
	 	        	
	                });*/
				});
		 
			   });
		});
}


function addTrasferStock(){
	if(document.transferStock.hotelid.value ==""){
		alert("Please Select Shop Name");
		return false;
	}
	
	//if(document.transferStock.fk_item_id1.value ==""){
	//	alert("Please Select Item Name");
		//return false;
	//}
	

	
	addTrasferStock1();
}
//Transfer Stock
function addTrasferStock1()
{
	document.getElementById("save").disabled = true;
	 
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
//	var fk_item_id1 = $('#itemName').val();
	var fk_item_id = fk_item_id;// $('#fk_item_id1').val();
	
	
	var hotelName= $('#hotelid').val();
	var fk_item_id_drop1= $('#fk_item_id').val();
	
	params["fk_item_id1"] = fk_item_id1;
	params["fk_item_id"] = fk_item_id;
//	params["fk_item_id_drop1"] = fk_item_id_drop1;
	
	params["hotelid"] = hotelid;
	params["hotelName"] = hotelName;
	
	
	var count = jQuery("#list4").jqGrid('getGridParam', 'records');
	//alert(count);
	var allRowsInGrid = $('#list4').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	for (var i = 0; i < count; i++) {

		var fk_item_id_drop1 = allRowsInGrid[i].itemName;
		params["fk_item_id_drop1"+i] = fk_item_id_drop1;
	
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


		

		
		
		
	
	
	
		
		var quantity = allRowsInGrid[i].quantity;
		if(quantity=="" || quantity==undefined || quantity==null)
		{
			alert("Please Enter Quantity In Grid");
			document.getElementById("save").disabled = false;
			return false;
			
			
		}
		
		params["quantity"+i] = quantity;
		
		var gst = allRowsInGrid[i].gst;
		/*if(gst=="" || gst==undefined || gst==null)
		{
			alert("Please Enter GST In Grid");
			document.getElementById("save").disabled = false;
			return false;
			
			
		}*/

		var total = allRowsInGrid[i].total;
		params["total"+i] = total;
		
		var pk_item_entry_Id  = allRowsInGrid[i].pk_item_entry_Id;
		params["pk_item_entry_Id"+i] = pk_item_entry_Id;
	}
	
	params["count"] = count;
   
	var grossTotal = $('#grossTotal').val();
	 params["grossTotal"] = grossTotal;
	 
	params["methodName"] = "addTrasferStock";
	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
	    	{
		 		alert(data)
		 		location.reload();
		 		return false; 
		 		
		 		/*$.getScript('/RMS/staticContent/js/bootbox.min.js', function() 
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
						document.goodReceive.save.disabled = false;
					}, 1500);
					
					return false;
					
						});*/		
		 		
			}
		
	    	).error(function(jqXHR, textStatus, errorThrown){
	    		if(textStatus==="timeout") {
	    			$(loaderObj).hide();
	    			$(loaderObj).find('#errorDiv').show();
	    		}
	    	})
	    	
	
}

