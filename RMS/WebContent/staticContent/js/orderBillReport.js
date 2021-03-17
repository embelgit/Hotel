function getOrderBillDateWiseReport(){
	/*if(document.OrderBilltableDate.orderBillDate.value =="")
	{
		alert("Please Selct Order Bill Date");
		return false;
	}*/
	getOrderBillDateWiseReport1(); 
}
var listcount=0;
function getOrderBillDateWiseReport1(){
	
	var params= {};
	
	var orderBillDate= $('#orderBillDate').val();
	params["orderBillDate"] = orderBillDate;
		
		params["methodName"] = "getOrderBillDateWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName').dataTable().fnClearTable();
			
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
		            
		 /*           pageTotal = api
	                .column( 8 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 8 ).footer() ).html(
	            		
	              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
	               
	            );
	            console.log( pageTotal);*/
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
				{"data": "tableNo", "width": "5%", "defaultContent": ""},
				{"data": "itemName", "width": "5%", "defaultContent": ""},
				{"data": "quantity", "width": "5%", "defaultContent": ""},
				{"data": 'unitPrice', "width": "5%", "defaultContent": ""},
				{"data": "unit", "width": "5%", "defaultContent": ""},
				{"data": "value", "width": "5%", "defaultContent": ""},
				{"data": "totalAmt", "width": "5%", "defaultContent": ""},
				{"data": "GridTotal", "width": "5%", "defaultContent": ""}
				
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
		$('#catName').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}





function getgoodReceiveRangeWiseReport(){
	/*if(document.OrderBilltableDate.dateto.value =="")
	{
		alert("Please Selct Order Bill Date");
		return false;
	}
	if(document.OrderBilltableDate.datefrom.value =="")
	{
		alert("Please Selct Order Bill Date");
		return false;
	}*/
	getgoodReceiveRangeWiseReport1(); 
}
var listcount=0;
function getgoodReceiveRangeWiseReport1(){
	
	var params= {};
	var dateto= $('#dateto').val();
	var datefrom= $('#datefrom').val();
	params["dateto"] = dateto;
	params["datefrom"] = datefrom;
		
		params["methodName"] = "getOrderBillRangeWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName4').dataTable().fnClearTable();
			
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
			 var total =   $('#catName4').DataTable( {
				 
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
		            
		 /*           pageTotal = api
	                .column( 8 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 8 ).footer() ).html(
	            		
	              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
	               
	            );
	            console.log( pageTotal);*/
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
				{"data": "tableNo", "width": "5%", "defaultContent": ""},
				{"data": "itemName", "width": "5%", "defaultContent": ""},
				{"data": "quantity", "width": "5%", "defaultContent": ""},
				{"data": 'unitPrice', "width": "5%", "defaultContent": ""},
				{"data": "unit", "width": "5%", "defaultContent": ""},
				{"data": "value", "width": "5%", "defaultContent": ""},
				{"data": "totalAmt", "width": "5%", "defaultContent": ""},
				{"data": "GridTotal", "width": "5%", "defaultContent": ""},
				{"data": "billno", "width": "5%", "defaultContent": ""}
				
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
		$('#catName4').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}