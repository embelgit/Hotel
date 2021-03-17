function getDrinkwiseReport(){
	
	var params = {};
	 var input = document.getElementById('fk_item_id1'),
     list = document.getElementById('fk_item_id_drop1'),
     j,fk_item_id;
 for (j = 0; j < list.options.length; ++j) {
     if (list.options[j].value === input.value) {
    	 fk_item_id = list.options[j].getAttribute('data-value');
     }
 }
  		var fk_item_id_drop= $('#fk_item_id').val();
  		var sale_price = $('#sale_price').val();
  		var buy_price = $('#buy_price').val();
  		var unit_in_ml = $('#unit_in_ml').val();
  		
  		params["fk_item_id"] = fk_item_id;
  		params["sale_price"] = sale_price;
  		params["buy_price"] = buy_price;
  		params["unit_in_ml"] = unit_in_ml;
	
	params["methodName"] = "getDrinkwiseReport";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#catName').dataTable().fnClearTable();
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		$(document).ready(function() {
		 var total =   $('#catName').DataTable( {
			 
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
					{"data": "fk_item_id", "width": "5%", "defaultContent": ""},
					{"data": "sale_price", "width": "5%", "defaultContent": ""},
					{"data": "buy_price", "width": "5%", "defaultContent": ""},
					{"data": "unit_in_ml", "width": "5%", "defaultContent": ""},
					
		        ],
		      
		        dom : 'Bfrtip',
		          buttons : [ 

		                     { extend: 'copyHtml5', footer: true },
		                     { extend: 'excelHtml5', footer: true },
		                     { extend: 'csvHtml5', footer: true },
		                     { extend : 'pdfHtml5', footer: true,
		                    	 title : function() {
		                    		 return "Stock Entry Report Drink Wise";
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