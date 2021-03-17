/*function itemDetail(){
	var params = {};
	document.itemdetail.btn.disabled = true;
	 var input = document.getElementById('fk_item_id'),
     list = document.getElementById('fk_item_id_drop'),
     i,fk_item_id;
 for (i = 0; i < list.options.length; ++i) {
     if (list.options[i].value === input.value) {
    	 fk_item_id = list.options[i].getAttribute('data-value');
     }
 }
	var sale_price = $('#sale_price').val();
	var buy_price = $('#buy_price').val();
	
	if(document.getElementById('drink').checked){
		var isDrink = "True";
		var unit_in_ml = $('#unit_in_ml').val();
	}
	else{
		var isDrink = "False";
	}
	
	function itemDetail1(){
		var params = {};
		document.itemdetail.btn1.disabled = true;
		 var input = document.getElementById('fk_item_id1'),
	     list = document.getElementById('fk_item_id_drop1'),
	     j,fk_item_id;
	 for (j = 0; j < list.options.length; ++j) {
	     if (list.options[i].value === input.value) {
	    	 fk_item_id = list.options[j].getAttribute('data-value');
	     }
	 }
		var sale_price = $('#sale_price1').val();
		var buy_price = $('#buy_price1').val();
	
	params["fk_item_id"] = fk_item_id;
	params["sale_price"] = sale_price;
	params["buy_price"] = buy_price;
	params["unit_in_ml"] = unit_in_ml;
	params["isDrink"] = isDrink;
	
	params["methodName"] = "itemDetails";
	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
 				alert(data);
 				if(document.itemDetail)
 				{
 					document.itemDetail.reset();
 				}	
 				document.itemDetail.btn.disabled =false;
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
document.itemDetail.reset();

}

}*/


//conditions For buy and sale price
function checkForSaleBuyPrice(){
	var sale_price= $('#sale_price').val();
	var buy_price= $('#buy_price').val(); 
	if(Number(sale_price)<= Number(buy_price) )
		{
		alert("buy price should be less than sale price");
		}
}

// conditions For duplicate Item name
function checkForDuplicateItemName(){
	
	for (var j = 0; j < count; j++) 
	  {
		itemName = rowdata[j].itemName;
		if (itemName == jsonData[i].itemName) {
			 var rowId = ids[j];
	    	newrow=false;
			alert("item Name Already Inserted !!!");
		}
			else
			{
				newrow = true;
			}
	  }
}
	

//to add item details info
function addItemDetailsInfo(){
	if(document.itemdetail.fk_item_id_drop.value == "")
	{
		alert("Enter item Name.");
		return false;
	}	
	itemDetail();
}

//to add drink details info
function addDrinkDetailsInfo(){
	if(document.drinkDetail.fk_item_id_drop1.value == "")
	{
		alert("Enter Drink Name.");
		return false;
	}	
	drinkDetail1();
}
		
//to add item details
function itemDetail(){
	var params = {};
	document.itemdetail.btn.disabled = true;
	 var input = document.getElementById('fk_item_id'),
     list = document.getElementById('fk_item_id_drop'),
     i,fk_item_id;
 for (i = 0; i < list.options.length; ++i) {
     if (list.options[i].value === input.value) {
    	 fk_item_id = list.options[i].getAttribute('data-value');
     }
 }
	var sale_price = $('#sale_price').val();
	var buy_price = $('#buy_price').val();
	
	params["fk_item_id"] = fk_item_id;
	params["sale_price"] = sale_price;
	params["buy_price"] = buy_price;
	params["unit_in_ml"] = 0.0;
	
params["methodName"] = "itemDetails";
	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
 				alert(data);
 				location.reload();
 				if(document.itemDetail)
 				{
 					document.itemDetail.reset();
 				}	
 				//document.itemDetail.btn.disabled =false;
 			}
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
	
}

//to add drinks details
function drinkDetail1(){

	var params = {};
	document.drinkDetail.btn_drink.disabled = true;
	 var input = document.getElementById('fk_item_id1'),
     list = document.getElementById('fk_item_id_drop1'),
     j,fk_item_id;
 for (j = 0; j < list.options.length; ++j) {
     if (list.options[j].value === input.value) {
    	 fk_item_id = list.options[j].getAttribute('data-value');
     }
 }
	var sale_price = $('#sale_price1').val();
	var buy_price = $('#buy_price_drink').val();
	var unit_in_ml = $('#unit_in_ml').val();
	

params["fk_item_id"] = fk_item_id;
params["sale_price"] = sale_price;
params["buy_price"] = buy_price;
params["unit_in_ml"] = unit_in_ml;
//params["isDrink"] = isDrink;

params["methodName"] = "itemDetails";

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
	    	});
}

//get item detail to edit item detail
function getItemDetails(){

	var params= {};
	
	 var input = document.getElementById('fk_item_id'),
     list = document.getElementById('fk_item_id_drop'),
     i,fk_item_id;
    for (i = 0; i < list.options.length; ++i) {
     if (list.options[i].value === input.value) {
    	 fk_item_id = list.options[i].getAttribute('data-value');
     }
 }
	
	$("#sale_price").append($("<input/>").attr("value","").text());
	$("#buy_price").append($("<input/>").attr("value","").text());
	
	params["itemId"]= fk_item_id;
	
	params["methodName"] = "getItemDetailsToEdit";
	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
				  document.getElementById("sale_price").value = v.sale_price;
			      document.getElementById("buy_price").value = v.buy_price;
			   
				});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
 	    
}

//update item details info
function updateItemDetailsInfo(){

	document.editItemDetails.btn.disabled = true;
	
	 var input = document.getElementById('fk_item_id'),
     list = document.getElementById('fk_item_id_drop'),
     i,fk_item_id;
 for (i = 0; i < list.options.length; ++i) {
     if (list.options[i].value === input.value) {
    	 fk_item_id = list.options[i].getAttribute('data-value');
     }
 }
	
	var sale_price = $('#sale_price').val();
	var buy_price = $('#buy_price').val();
	
	var params = {};
	
	params["itemId"]= fk_item_id;
	params["buy_price"] = buy_price;	
	params["sale_price"] = sale_price;
	
	params["methodName"] = "updateItemDetails";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
			alert(data);
			location.reload();
			}
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
}

//get drink detail to edit drink detail
function getDrinkDetails(){

	var params= {};
	
	 var input = document.getElementById('fk_item_id1'),
     list = document.getElementById('fk_item_id_drop1'),
     j,fk_item_id;
    for (j = 0; j < list.options.length; ++j) {
     if (list.options[j].value === input.value) {
    	 fk_item_id = list.options[j].getAttribute('data-value');
     }
 }
	$("#sale_price").append($("<input/>").attr("value","").text());
	$("#buy_price").append($("<input/>").attr("value","").text());
	$("#unit_in_ml").append($("<input/>").attr("value","").text());
	
	params["itemId"]= fk_item_id;
	
	params["methodName"] = "getDrinkDetailsToEdit";
	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
				  document.getElementById("sale_price").value = v.sale_price;
			      document.getElementById("buy_price").value = v.buy_price;
			      document.getElementById("unit_in_ml").value = v.unit_in_ml;
			   
				});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
 	    
}

//update drink details info
function updateDrinkDetailsInfo(){

	/*document.editDrinkDetails.btn.disabled = true;*/
	
	document.drinkDetail.btn.disabled = true;
	
	 var input = document.getElementById('fk_item_id1'),
     list = document.getElementById('fk_item_id_drop1'),
     j,fk_item_id;
 for (j = 0; j < list.options.length; ++j) {
     if (list.options[j].value === input.value) {
    	 fk_item_id = list.options[j].getAttribute('data-value');
     }
 }
	
	var sale_price = $('#sale_price').val();
	var buy_price = $('#buy_price').val();
	var unit_in_ml = $('#unit_in_ml').val();
	
	var params = {};
	
	params["itemId"]= fk_item_id;
	params["buy_price"] = buy_price;	
	params["sale_price"] = sale_price;
	params["unit_in_ml"] = unit_in_ml;
	
	params["methodName"] = "updateDrinkDetails";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
			alert(data);
			location.reload();
			}
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
}
