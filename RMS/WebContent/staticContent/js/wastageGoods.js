function wastageGoods(){
					/*document.wastageGoods.createbtn.disabled = true;*/
					
								var vegetableName = $('#vegetableName').val();
								var amount = $('#amount').val();
								
								var params = {};
								
								params["vegetableName"] = vegetableName;
								params["amount"] = amount;
							
								params["methodName"] = "wastageGoods";
								
								$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
							 	    	{
							 				alert(data);
							 				if(document.wastageGoods)
							 				{
							 					document.wastageGoods.reset();
							 				}	
							 				document.wastageGoods.createbtn.disabled =false;
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
document.wastageGoods.reset();	

}