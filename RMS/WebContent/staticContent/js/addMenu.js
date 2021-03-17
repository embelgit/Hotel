	
				function addItem(){
					alert("In js");
					//document.addItem.createbtn.disabled = true;
					
								var itemName = $('#itemName').val();
								var quantity = $('#quantity').val();
								var price = $('#price').val();
								
								var params = {};
								
								params["itemName"] =itemName;
								params["quantity"] =quantity;
								params["price"] =price;
								
								params["methodName"] = "addItems";
								
								$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
							 	    	{
							 				alert(data);
							 				if(document.addItems)
							 				{
							 					document.addItems.reset();
							 				}	
							 				document.addItems.createbtn.disabled =false;
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
document.addItems.reset();	

}

		
