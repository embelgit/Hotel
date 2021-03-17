function getattendedwaiterReport(){
	
	if(document.attendedWaiterreport.fk_item_id.value==""){
		alert("Please select the Waiter Name");
		return false;
	}
	getattendedwaiterReport1();
}

function getattendedwaiterReport1(){
	var waiterName=$('#fk_item_id').val();
	var datefrom = $('#Datefrom').val();
	var dateto = $('#Dateto').val();
	var params= {};
	
	
	params["waiterName"] = waiterName;
	params["datefrom"] = datefrom;
	params["dateto"] = dateto;
	params["methodName"] = "getattendedWaitersReport";
	
	$("#catName2").show();

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
			
		
		$('#catName2').dataTable().fnClearTable();
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		if(catmap == null || catmap ==""){
			alert("No data available for the Waiter you have selected ");
		//	location.reload(true);
			document.attendedWaiterreport.fk_item_id.value = "";
			return false;
			
		}
		
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
		            /*pageTotal = api
	                .column( 4 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 4 ).footer() ).html(
	            		
	              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
	               
	            );
	            console.log( pageTotal);*/
	            
	            pageTotal = api
                .column( 5 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
 
            // Update footer
            $( api.column( 5 ).footer() ).html(
            		
              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
               
            );
            console.log( pageTotal);
	            },
			    
	            "sPaginationType": "full_numbers",
		    	destroy: true,
		        searching: true,
		        orderable: true,
		        
		      
		columns: [
			
					{"data": "billNo", "width": "5%", "defaultContent": ""},
					{"data": "tableNo", "width": "5%", "defaultContent": ""},
					{"data": "itemName", "width": "5%", "defaultContent": ""},
					{"data": "quantity", "width": "5%", "defaultContent": ""},
					{"data": "unitPrice", "width": "5%", "defaultContent": ""},
					{"data": "totalAmount", "width": "5%", "defaultContent": ""},
				    
				/*	{"data": "billNo", "width": "5%"},
					{"data": "tableNo", "width": "5%"},
					{"data": "itemName", "width": "5%"},
					{"data": "quantity", "width": "5%"},
					{"data": "unitPrice", "width": "5%"},
					{"data": "totalAmount", "width": "5%"},*/
		        ],
		       
		        dom : 'Bfrtip',
		          buttons : [ 

		                     { extend: 'copyHtml5', footer: true },
		                     { extend: 'excelHtml5', footer: true },
		                     { extend: 'csvHtml5', footer: true },
		                     { extend : 'pdfHtml5', footer: true,
		                    	 title : function() {
		                    		 return "Attended Waiter Report";
		                    	 },
		                    	 orientation : 'landscape',
		                    	 pageSize : 'LEGAL',
		                    	 titleAttr : 'PDF' 
		                     } ]  
		      
		    } );
		 		 
		} );
		
	var mydata = catmap;
	//var check=mydata.length;
	$('#catName2').dataTable().fnAddData(mydata);
	document.attendedWaiterreport.fk_item_id.value = "";
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				
				}
		});
	
	
}