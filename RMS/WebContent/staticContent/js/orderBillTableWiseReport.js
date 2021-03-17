function getOrderBillTableWiseReport()
{
if(document.OrderBilltable.tableNo.value == ""){
	alert("Please Select Table No ");
	return false;
}	
getOrderBillTableWiseReport1();
}
function getOrderBillTableWiseReport1(){
	
	        var params= {};
	  		var tableNo= $('#tableNo').val();
	  		params["tableNo"] = tableNo;

	params["methodName"] = "getOrderBillTableWiseReport";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#catName1').dataTable().fnClearTable();
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		if (catmap == null ||catmap == "") {
			alert("No data available for the table you have selected");
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
	            
	            /*pageTotal = api
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
				{"data": "srNo", "width": "5%", "defaultContent": ""},
				{"data": "tableNo", "width": "5%", "defaultContent": ""},
				{"data": "itemName", "width": "5%", "defaultContent": ""},
				{"data": "quantity", "width": "5%", "defaultContent": ""},
				{"data": "unitPrice", "width": "5%", "defaultContent": ""},
				{"data": "unit", "width": "5%", "defaultContent": ""},
				{"data": "value", "width": "5%", "defaultContent": ""},
				{"data": "totalAmt", "width": "5%", "defaultContent": ""},
				{"data": "GridTotal", "width": "5%", "defaultContent": ""},
				{"data": "billNo", "width": "5%", "defaultContent": ""},
				{"data": "current_date", "width": "5%", "defaultContent": ""}
		          
		        ],
		        dom : 'Bfrtip',
		          buttons : [ 

		                     { extend: 'copyHtml5', footer: true },
		                     { extend: 'excelHtml5', footer: true },
		                     { extend: 'csvHtml5', footer: true },
		                     { extend : 'pdfHtml5', footer: true,
		                    	 title : function() {
		                    		 return "Order Bill Report Table No. Wise";
		                    	 },
		                    	 orientation : 'landscape',
		                    	 pageSize : 'LEGAL',
		                    	 titleAttr : 'PDF' 
		                     } ]  
		      
		    } );
		} );
		
	var mydata = catmap;
	$('#catName1').dataTable().fnAddData(mydata);
	
	document.getElementById('tableNo').value = "";
		}

	);
	
	
}