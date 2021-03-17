function KycInfo(){
	
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
	var tableNo = $('#tableNo').val();
	var quantity = $('#quantity').val();
	var price= $('#price').val();
	var KYCDate = $('#KYCDate').val();
	
	params["fk_item_id"] = fk_item_id;
	params["fk_item_id_drop"] = fk_item_id_drop;
	params["tableNo"] = tableNo;
	params["quantity"] = quantity;
	params["price"] = price;
	params["KYCDate"] = KYCDate;
	
	params["methodName"] = "KycInfo";
	
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
 	    	})
}
