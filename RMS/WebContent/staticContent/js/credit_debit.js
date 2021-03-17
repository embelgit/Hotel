function getCreditDateWiseReport(){
	if(document.creditDate.creditdatefrm.value =="")
	{
		alert("Please Select Credit Date from");
		return false;
	}
	if(document.creditDate.creditdateto.value =="")
	{
		alert("Please Select Credit Date to");
		return false;
	}
	getCreditDateWiseReport1(); 
}
var listcount=0;
function getCreditDateWiseReport1(){
	
	var params= {};
	
	var creditdatefrm= $('#creditdatefrm').val();
	var creditdateto = $('#creditdateto').val();
	params["creditdatefrm"] = creditdatefrm;
	params["creditdateto"] = creditdateto;	
	
		params["methodName"] = "getcreditDateWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName1').dataTable().fnClearTable();
			
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
	                .column( 3 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 3 ).footer() ).html(
	            		
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
				
				{"data": "billNo", "width": "5%", "defaultContent": ""},
				{"data": "tableNo", "width": "5%", "defaultContent": ""},
				{"data": "waiterName", "width": "5%", "defaultContent": ""},
				{"data": "GridTotal", "width": "5%", "defaultConontent": ""}
	
	
				
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
		$('#catName1').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}


// debit

function getdebitDateWiseReport(){
	if(document.debitDate.debitdatefrm.value =="")
	{
		alert("Please Select Debit Date from");
		return false;
	}
	if(document.debitDate.debitdateto.value =="")
	{
		alert("Please Select Debit Date To");
		return false;
	}
	getdebitDateWiseReport1(); 
}
var listcount=0;
function getdebitDateWiseReport1(){
	
	var params= {};
	
	var debitdatefrm= $('#debitdatefrm').val();
	var debitdateto = $('#debitdateto').val();
	params["debitdatefrm"] = debitdatefrm;
	params["debitdateto"] = debitdateto;	
	
		params["methodName"] = "getdebitDateWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName2').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected dates ");
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
			 var total =   $('#catName2').DataTable( {
				 
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
	                .column( 3 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 3 ).footer() ).html(
	            		
	              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
	               
	            );
	            console.log( pageTotal);
	            
	            pageTotal = api
                .column( 4 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
 
            // Update footer
            $( api.column( 4 ).footer() ).html(
            		
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
				
				{"data": "transID", "width": "5%", "defaultContent": ""},
				{"data": "payToId", "width": "5%", "defaultContent": ""},
				{"data": "toPayNameId", "width": "5%", "defaultContent": ""},
				{"data": "paymentAmountId", "width": "5%", "defaultConontent": ""},
				{"data": "remainingBalance", "width": "5%", "defaultConontent": ""}
	
				
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
		$('#catName2').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}