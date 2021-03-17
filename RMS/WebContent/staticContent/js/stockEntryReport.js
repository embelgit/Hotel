function getStockEntryReport(){
	
var params= {};
	
	params["methodName"] = "getStockEntryReport";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#catName').dataTable().fnClearTable();
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		$(document).ready(function() {
		 var total =   $('#catName').DataTable( {
			 
			 dom: 'Bfrtip',
	         buttons: [
	             'copy', 'csv', 'excel', 'pdf', 'print'
	         ],
			 
			 fnRowCallback : function(nRow, aData, iDisplayIndex){
	                $("th:first", nRow).html(iDisplayIndex +1);
	               return nRow;
	            },
			    
	            "sPaginationType": "full_numbers",
		    	destroy: true,
		        searching: true,
		        orderable: true,
		        
		      
		columns: [
					{"data": "srNo", "width": "5%", "defaultContent": ""},
					{"data": "productName", "width": "5%", "defaultContent": ""},
					{"data": "supplierName", "width": "5%", "defaultContent": ""},
					{"data": "buyPrice", "width": "5%", "defaultContent": ""},
					{"data": "quantity", "width": "5%", "defaultContent": ""},
					{"data": "total", "width": "5%", "defaultContent": ""},
					{"data": "grossTotal", "width": "5%", "defaultContent": ""},
		            
		        ],
		      
		    } );
		} );
		
	var mydata = catmap;
	$('#catName').dataTable().fnAddData(mydata);
	
		}

	);
	
	
}