// calculations for fuel rate and Fuel quantity For 
function calculationsForStock(){
	var buyPrice= $('#buyPrice').val();
	var quantity= $('#quantity').val(); 
	var gst= $('#gst').val();
	
	var grossTotal = Number(buyPrice) * Number(quantity) * Number(gst);
	 document.getElementById("grossTotal").value = grossTotal;
              	
}

function addStockEntry(){
	
var params = {};

	var itemName= $('#itemName').val();
	var buyPrice= $('#buyPrice').val();
	var quantity = $('#quantity').val();
	var gst= $('#gst').val();
	var grossTotal= $('#grossTotal').val();
	
	params["itemName"] = itemName;
	params["buyPrice"] = buyPrice;
	params["quantity"] = quantity;
	params["gst"] = gst;
	params["grossTotal"] = grossTotal;
	
	params["methodName"] = "addStockEntry";
	
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

