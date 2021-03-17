function getItemNamewiseReport(){
	if(document.StockItemDetails.fk_item_id.value =="")
		{
		alert("Please Select Item Name");
		return false;
		}
	getItemNamewiseReport1();
}

var listcount=0;
function getItemNamewiseReport1(){
	var params = {};
	 var input = document.getElementById('fk_item_id'),
     list = document.getElementById('fk_item_id_drop'),
     i,fk_item_id;
	 
     for (i = 0; i < list.options.length; ++i) {
     if (list.options[i].value === input.value) {
    	 fk_item_id = list.options[i].getAttribute('data-value');
     }
 }
  		var fk_item_id_drop= $('#fk_item_id').val();
  		var sale_price = $('#sale_price').val();
  		var buy_price = $('#buy_price').val();
  		
  		
  		params["fk_item_id"] = fk_item_id;
  		params["sale_price"] = sale_price;
  		params["buy_price"] = buy_price;

	
	params["methodName"] = "getItemNamewiseReport";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#catName').dataTable().fnClearTable();
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		
		
		
		
		$(document).ready(function() 
{
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
					{"data": "itemName", "width": "5%", "defaultContent": ""},
					{"data": "stock", "width": "5%", "defaultContent": ""},
					
		        ],
		        dom : 'Bfrtip',
		          buttons : [ 

		                     { extend: 'copyHtml5', footer: true },
		                     { extend: 'excelHtml5', footer: true },
		                     { extend: 'csvHtml5', footer: true },
		                     { extend : 'pdfHtml5', footer: true,
		                    	 title : function() {
		                    		 return "Stock Entry Report Item Wise";
		                    	 },
		                    	 orientation : 'landscape',
		                    	 pageSize : 'LEGAL',
		                    	 titleAttr : 'PDF' 
		                     } ]  
		    } );
		 
		 var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=1){
				alert("No Stock For Selected Item Or Drink!!!")
				
				listcount=0;
				return false;
			}
		} );
		
	var mydata = catmap;
	var check=mydata.length;
	
	$('#catName').dataTable().fnAddData(mydata);
	document.getElementById('fk_item_id').value = "";
		}

	);
	
}