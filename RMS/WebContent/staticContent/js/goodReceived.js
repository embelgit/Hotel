function goodReceived(){
	
	document.goodsReceive.btn.disabled = true;
	
	 var input = document.getElementById('fk_item_id'),
     list = document.getElementById('fk_item_id_drop'),
     i,fk_item_id;
 for (i = 0; i < list.options.length; ++i) {
     if (list.options[i].value === input.value) {
    	 fk_item_id = list.options[i].getAttribute('data-value');
     }
 }
	var quantity = $('#quantity').val();
	var itemName = $('#itemName').val();


	var params = {};
	
	params["fk_item_id"] = fk_item_id;
	params["quantity"] = quantity;
	params["itemName"] = itemName;
	
	params["methodName"] = "goodReceive";
	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
 				alert(data);
 				
 				if(document.goodsReceive)
 				{
 					document.goodsReceive.reset();
 				}	
 				document.goodsReceive.btn.disabled =false;
 			}
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});

}
function reset()
{
document.goodsReceive.reset();

}
