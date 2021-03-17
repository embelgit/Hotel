function getGoodsReceiveReport(){
	
	if(document.Orderrecievereport.fk_item_id.value==""){
		alert("Please select the Item");
		return false;
	}
	getGoodsReceiveReport1();
}

function getGoodsReceiveReport1(){
	var itemName=$('#fk_item_id').val();
	var params= {};
	
	
	params["itemName"] = itemName;
	params["methodName"] = "getGoodsReceiveReport";
	
	$("#catName").show();

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
			
		
		$('#catName').dataTable().fnClearTable();
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		if(catmap == null || catmap ==""){
			alert("No data available for the Item you have selected ");
		//	location.reload(true);
			document.Orderrecievereport.fk_item_id.value = "";
			return false;
			
		}
		
		$(document).ready(function() {
		 var total =   $('#catName').DataTable( {
			 
			 fnRowCallback : function(nRow, aData, iDisplayIndex){
	                $("th:first", nRow).html(iDisplayIndex +1);
	               return nRow;
	            },
			    
	            "footerCallback": function ( row, data, start, end, display ) {
		            var api = this.api(), data;
		 
		            // Remove the formatting to get integer data for summation
		            var intVal = function ( i ) {
		                return typeof i === 'string' ?
		                    i.replace(/[\$,]/g, '')*1 :
		                    typeof i === 'number' ?
		                        i : 0;
		            };
		            
	            pageTotal = api
                .column( 7 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
 
            // Update footer
            $( api.column( 7 ).footer() ).html(
            		
              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
               
            );
            console.log( pageTotal);
	            },
	            
	            "sPaginationType": "full_numbers",
		    	destroy: true,
		        searching: true,
		        orderable: true,
		        
		      
		columns: [
			
					{"data": "srNo", "width": "5%", "defaultContent": ""},
					{"data": "productName", "width": "5%", "defaultContent": ""},
					{"data": "suplierName", "width": "5%", "defaultContent": ""},
					{"data": "billno", "width": "5%", "defaultContent": ""},
					{"data": "buyPrice", "width": "5%", "defaultContent": ""},
					{"data": "quantity", "width": "5%", "defaultContent": ""},
					{"data": "grossTotal", "width": "5%", "defaultContent": ""},
					{"data": "total", "width": "5%", "defaultContent": ""},
					{"data": "goodsReceiveDate", "width": "5%", "defaultContent": ""}
					
		        ],
		       
		        dom : 'Bfrtip',
		          buttons : [ 

		                     { extend: 'copyHtml5', footer: true },
		                     { extend: 'excelHtml5', footer: true },
		                     { extend: 'csvHtml5', footer: true },
		                     { extend : 'pdfHtml5', footer: true,
		                    	 title : function() {
		                    		 return "Goods Receive Report";
		                    	 },
		                    	 orientation : 'landscape',
		                    	 pageSize : 'LEGAL',
		                    	 titleAttr : 'PDF' 
		                     } ]  
		      
		    } );
		 
		/* var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=1){
				alert("No Stock For Selected Item Or Drink!!!")
				listcount=0;
				return false;
			}*/
		 
		} );
		
	var mydata = catmap;
	//var check=mydata.length;
	$('#catName').dataTable().fnAddData(mydata);
	document.Orderrecievereport.fk_item_id.value = "";
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				
				}
		});
	
	
}


function getgoodsreceiveReport(){
	if(document.Orderrecievereport1.fk_item_id1.value==""){	
		
		alert("Please select the Supplier");
		return false;
	}
	if(document.Orderrecievereport1.Datefrom.value==""){	
		
		alert("Please select From date");
		return false;
	}
	if(document.Orderrecievereport1.Dateto.value==""){	
		
		alert("Please select the to date");
		return false;
	}
	getgoodsreceiveReport1();
}

function getgoodsreceiveReport1(){
	
	var supplierName = $('#fk_item_id1').val();
	var datefrom = $('#Datefrom').val();
	var dateto = $('#Dateto').val();
	var params= {};
	
	
	params["supplierName"] = supplierName;
	params["datefrom"] = datefrom;
	params["dateto"] = dateto;
	params["methodName"] = "getgoodsreceiveReport";
	
	$("#catName1").show();

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
			
		
		$('#catName1').dataTable().fnClearTable();
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		if(catmap == null || catmap ==""){
			alert("No data available for the Supplier you have selected ");
		//	location.reload(true);
			document.Orderrecievereport1.fk_item_id1.value = "";
			document.Orderrecievereport1.Datefrom.value = "";
			document.Orderrecievereport1.Dateto.value = "";
			return false;
			
		}
		
		$(document).ready(function() {
		 var total =   $('#catName1').DataTable( {
			 
			 fnRowCallback : function(nRow, aData, iDisplayIndex){
	                $("th:first", nRow).html(iDisplayIndex +1);
	               return nRow;
	            },
			    
	            "footerCallback": function ( row, data, start, end, display ) {
		            var api = this.api(), data;
		 
		            // Remove the formatting to get integer data for summation
		            var intVal = function ( i ) {
		                return typeof i === 'string' ?
		                    i.replace(/[\$,]/g, '')*1 :
		                    typeof i === 'number' ?
		                        i : 0;
		            };
		            
	            pageTotal = api
                .column( 9 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
 
            // Update footer
            $( api.column( 9 ).footer() ).html(
            		
              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
               
            );
            console.log( pageTotal);
	            },
	            
	            "sPaginationType": "full_numbers",
		    	destroy: true,
		        searching: true,
		        orderable: true,
		        
		      
		columns: [
			
					{"data": "srNo", "width": "5%", "defaultContent": ""},
					{"data": "billno", "width": "5%", "defaultContent": ""},
					{"data": "fk_item_id_drop1", "width": "5%", "defaultContent": ""},
					{"data": "buyPrice", "width": "5%", "defaultContent": ""},
					{"data": "saleprice", "width": "5%", "defaultContent": ""},
					{"data": "quantity", "width": "5%", "defaultContent": ""},
			//		{"data": "gst", "width": "5%", "defaultContent": ""},
					{"data": "igst", "width": "5%", "defaultContent": ""},
					{"data": "cgst", "width": "5%", "defaultContent": ""},
					{"data": "sgst", "width": "5%", "defaultContent": ""},
					{"data": "total", "width": "5%", "defaultContent": ""},
					{"data": "grossTotal", "width": "5%", "defaultContent": ""},            
		        ],
		       
		        dom : 'Bfrtip',
		          buttons : [ 

		                     { extend: 'copyHtml5', footer: true },
		                     { extend: 'excelHtml5', footer: true },
		                     { extend: 'csvHtml5', footer: true },
		                     { extend : 'pdfHtml5', footer: true,
		                    	 title : function() {
		                    		 return "Goods Receive Report";
		                    	 },
		                    	 orientation : 'landscape',
		                    	 pageSize : 'LEGAL',
		                    	 titleAttr : 'PDF' 
		                     } ]  
		      
		    } );
		 
		/* var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=1){
				alert("No Stock For Selected Item Or Drink!!!")
				listcount=0;
				return false;
			}*/
		 
		} );
		
	var mydata = catmap;
	//var check=mydata.length;
	$('#catName1').dataTable().fnAddData(mydata);
	
	
	document.Orderrecievereport1.fk_item_id1.value = "";
	document.Orderrecievereport1.Datefrom.value = "";
	document.Orderrecievereport1.Dateto.value = "";
	
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				
				}
		});

}

function getgoodReceiveDateWiseReport(){
	if(document.OrderBilltableDate.orderBillDate.value =="")
	{
		alert("Please Select Goods Receive Date");
		return false;
	}
	if(document.OrderBilltableDate.orderBillDateto.value =="")
	{
		alert("Please Select Goods Receive Date");
		return false;
	}
	getgoodReceiveDateWiseReport1(); 
}
var listcount=0;
function getgoodReceiveDateWiseReport1(){
	
	var params= {};
	
	var goodReceiveDate= $('#orderBillDate').val();
	var goodReceiveDateto = $('#orderBillDateto').val();
	params["goodReceiveDate"] = goodReceiveDate;
	params["goodReceiveDateto"] = goodReceiveDateto;	
		params["methodName"] = "getgoodReceiveDateWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName3').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected date ");
				return false;
			}
			
			/*var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=2){
				alert("No Data For Selected Date!!!")
				listcount=0;
				return false;
			}*/
			
			$(document).ready(function() {
			 var total =   $('#catName3').DataTable( {
				 
				 fnRowCallback : function(nRow, aData, iDisplayIndex){
		                $("th:first", nRow).html(iDisplayIndex +1);
		               return nRow;
		            },
				    
		            
		            "footerCallback": function ( row, data, start, end, display ) {
			            var api = this.api(), data;
			 
			            // Remove the formatting to get integer data for summation
			            var intVal = function ( i ) {
			                return typeof i === 'string' ?
			                    i.replace(/[\$,]/g, '')*1 :
			                    typeof i === 'number' ?
			                        i : 0;
			            };
			          
		            pageTotal = api
	                .column( 6 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 6 ).footer() ).html(
	            		
	              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
	               
	            );
	            console.log( pageTotal);
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
						/*{"data": "srNo", "width": "5%", "defaultContent": ""},
						{"data": "tableNo", "width": "5%", "defaultContent": ""},
						{"data": "itemName", "width": "5%", "defaultContent": ""},
						{"data": "quantity", "width": "5%", "defaultContent": ""},
						{"data": 'unitPrice', "width": "5%", "defaultContent": ""},
						{"data": "unitInMl", "width": "5%", "defaultContent": ""},
						{"data": "GridTotal", "width": "5%", "defaultContent": ""},
						{"data": "totalAmt", "width": "5%", "defaultContent": ""},*/
				
				{"data": "srNo", "width": "5%", "defaultContent": ""},
				{"data": "fk_item_id_drop1", "width": "5%", "defaultContent": ""},
				{"data": "billno", "width": "5%", "defaultContent": ""},
				{"data": "buyPrice", "width": "5%", "defaultContent": ""},
				{"data": "saleprice", "width": "5%", "defaultContent": ""},
				{"data": "quantity", "width": "5%", "defaultContent": ""},
				{"data": "total", "width": "5%", "defaultContent": ""},
				{"data": "grossTotal", "width": "5%", "defaultContent": ""}
	
	
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Order Bill Report Date Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName3').dataTable().fnAddData(mydata);
		document.OrderBilltableDate.orderBillDate.value = "";
		document.OrderBilltableDate.orderBillDateto.value = "";
			}

		);
		
		
	}



