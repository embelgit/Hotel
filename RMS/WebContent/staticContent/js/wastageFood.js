function wastageFoods(){
					/*document.wastageGoods.createbtn.disabled = true;*/
					
	var params = {};
	document.foodWastageForm.foodBtn.disabled = true;
	 var input = document.getElementById('fk_item_id'),
     list = document.getElementById('fk_item_id_drop'),
     i,fk_item_id;
	 
 for (i = 0; i < list.options.length; ++i) {
     if (list.options[i].value === input.value) {
    	 fk_item_id = list.options[i].getAttribute('data-value');
     }
 }
 ;
                                var foodAmount = $('#foodAmount').val();
								
                                params["fk_item_id"] = fk_item_id
								params["foodAmount"] = foodAmount;
							
								params["methodName"] = "wastageFoods";
								
								$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
							 	    	{
							 				alert(data);
							 				if(document.wastageFoods)
							 				{
							 					document.wastageFoods.reset();
							 				}	
							 				document.foodWastageForm.foodBtn.disabled =false;
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
document.wastageFoods.reset();	

}