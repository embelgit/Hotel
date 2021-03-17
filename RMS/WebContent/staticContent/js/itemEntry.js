function updateItemEntryInfo(){
	if(document.editItemEntry.fk_item_id.value==""){
		alert("Please Select Item Name ");
		return false;
	}
	/*if(document.editItemEntry.type.value=="selected"){
		alert("Please Select Item Type ");
		return false;
	}*/
	
	if(document.editItemEntry.esale_price.value ==""){
		alert("Please Enter Sale Price ");
		return false;
	}
/*	if(document.editItemEntry.ebuy_price.value==""){
		alert("Please Enter Buy Price ");
		return false;
	}*/

	updateItemEntryInfo1();
}
function updateItemEntryInfo1()
{
	document.editItemEntry.btn.disabled = true;
	
	var input = document.getElementById('fk_item_id'),
	list = document.getElementById('fk_item_id_drop'),
	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}

	//var itemName = $('#fk_item_id').val();
	var itemName = fkRootSupId;
	var itemName = $('#item_name').val();
	var type = $('#type').val();
	var salePrice = $('#esale_price').val();
	var buyPrice = $('#ebuy_price').val();
	if(buyPrice == null || buyPrice == "" || buyPrice == undefined){
		buyPrice = 0;
	}
	var unit = $('#unit').val();
	if(unit == null || unit == "" || unit == undefined){
		unit = "unit";
	}
	var value = $('#value').val();
	if(value == null || value == "" || value == undefined){
		value = 0;
	}
	
	var params = {};
	
	params['itemName'] = itemName;
	params['itemId']=fkRootSupId;
	params['type'] = type;
	params['salePrice'] = salePrice;
	params['buyPrice'] = buyPrice;
	
	params['unit'] =unit;
	params['value'] = value;
	
	params["methodName"] = "updateItemEntrys";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
			alert(data);
			location.reload();
			if(document.item)
			{
				document.item.reset();
			}	
			//document.item.btn.disabled =false;
		}
 	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
	
}

/********* get Product Details ************/
function getItemEntryDetails(){
	var params= {};

	var input = document.getElementById('fk_item_id'),
	list = document.getElementById('fk_item_id_drop'),

	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}
	
	$("#type").append($("<input/>").attr("value","").text());
	$("#esale_price").append($("<input/>").attr("value","").text());
	$("#ebuy_price").append($("<input/>").attr("value","").text());
	$("#unit").append($("<input/>").attr("value","").text());
	$("#value").append($("<input/>").attr("value","").text());
	
	params["itemId"]= fkRootSupId;
	params["methodName"] = "getItemDetailsToEdit";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
				document.getElementById("item_name").value = v.itemName;
				document.getElementById("type").value = v.type;
				document.getElementById("esale_price").value = v.salePrice;
				document.getElementById("ebuy_price").value = v.buyPrice;
				document.getElementById("unit").value = v.unit;
				document.getElementById("value").value = v.value;
			
				});
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
		}
	});
}
function itemEntry(){
	if(document.item.itemName.value==""){
		alert("Please Enter Item Name ");
		return false;
	}
	if(document.item.itemName.value!=""){
	
		var checkName =  /^[a-zA-Z0-9 ]+$/;
		if(document.item.itemName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper Item Name");
			return false;
		}
	}
	if(document.item.sale_price1.value==""){
		alert("Please Enter Sale Price ");
		return false;
	}

	if(document.item.sale_price1.value!=""){
	var letterNoo =  /^[0-9]+$/;
	if(document.item.sale_price1.value.match(letterNoo))
	{
		//
	}
	else
	{
		alert("Please Enter proper Sale price");
		return false;
	}
}
	/*
	if(document.item.buy_price_drink.value==""){
		alert("Please Enter buy Price ");
		return false;
	}*/
	if(document.item.buy_price_drink.value!=""){
		var letterNo = /^[0-9]+$/;
		if(document.item.buy_price_drink.value.match(letterNo))
		{
			
		}
		else
		{
		alert("Please Enter proper Buy price");
		return false;
		}
		} 
	
	if(document.item.value.value!=""){
		var letterNop = /^[0-9]+$/;
		if(document.item.value.value.match(letterNop))
		{
			
		}
		else
		{
		alert("Please Enter proper Value");
		return false;
		}
		} 
/*	if(document.item.unit.value==""){
		alert("Please Select Unit ");
		return false;
	}
	
	if(document.item.value.value==""){
		alert("Please Enter quantity");
		return false;
	}*/
	
/*	if(document.item.stock.value==""){
		alert("Please Select Stock entry ");
		return false;
	}*/
	/*	if(document.item.buy_price_drink.value==""){
		alert("Please Enter Buy Price ");
		return false;
	}
*/	
//	if(document.item.buy_price_drink.value > document.item.sale_price1.value){
//		alert("buy price should less than sale price !! @@@@");
//		return false;
//	}
	
	itemEntry1();
}
/*
function checkForSaleBuyPrice() {
	 
	
	 var salePrice1= document.getElementById('sale_price1').value;
	 var buyPrice1= document.getElementById('buy_price_drink').value; 
	 
	 
	 if( buyPrice1 > salePrice1)
	 {
		 alert("buy price should be less than sale price ");
		 return false;
		 
	 }
	 
}
*/
function itemEntry1(){
					
					document.item.btn.disabled = true;
					
								var itemName = $('#itemName').val();
								var type = $('#type').val();
								if(document.item.type.value=="Select Type"){
									type = "";
								}
								var sale_price1 = $('#sale_price1').val();
								var buy_price_drink = $('#buy_price_drink').val();
								
								/*var unit_in_ml = $('#unit_in_ml').val();
								var kilogram = $('#kilogram').val();
								var gram = $('#gram').val();*/
								var unit = $('#unit').val();
								if(document.item.unit.value=="Select Unit"){
									unit = "";
								}
								
								var value = $('#value').val();
								
								var params = {};
														
/*								if(buy_price_drink > sale_price1){
									alert("Buyprice entered should be less than the Sale Price ");
									location.reload();
									return false;
									
								} */
								
/*								if(unit_in_ml=="" |unit_in_ml==null |unit_in_ml=="undefined")
								{
									unit_in_ml="00";
								}
								
								if(kilogram=="" || kilogram==null || kilogram=="undefined")
								{
									kilogram ="00";
								}
								if(gram=="" || gram==null || gram=="undefined")
								{
									gram ="00";
								}
	*/							
								
								
								params["itemName"] = itemName;
								params["type"] = type;
								params["sale_price1"] = sale_price1;
								params["buy_price_drink"] = buy_price_drink;
							/*	params["unit_in_ml"] = unit_in_ml;
								params["kilogram"] = kilogram;
								params["gram"] = gram;*/
								params["unit"] = unit;
								params["value"] = value;
								
								params["methodName"] = "itemEntrys";
								$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
							 	    	{
							 				alert(data);
							 				location.reload(true);
							 				if(document.item)
							 				{
							 					document.item.reset();
							 				}	
							 				//document.item.btn.disabled =false;
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
document.itemEntry.reset();

}

function deleteList()
{
	var params = {};
	var input = document.getElementById('fk_class_id'),
    list = document.getElementById('classId'),
    	i,fkRootClassId;
	 		for (i = 0; i < list.options.length; ++i) {
			     if (list.options[i].value === input.value) {
			    	 fkRootClassId = list.options[i].getAttribute('data-value');
			     }
	 		}

	 		
		var division = $('#fk_class_id').val();
		var classname = $('#className').val();
		
		params["fk_class_id"] = fkRootClassId;
		params["className"] = classname;
	
		params["methodName"] = "deleteList";
		
		$.post('/srb/JSP/utility/controller.jsp',params,function(data)
	 	    	{
			 	
			 		alert(data)
			 		location.reload();
			
	 			}
	 		
	 	    	).error(function(jqXHR, textStatus, errorThrown){
	 	    		if(textStatus==="timeout") {
	 	    			$(loaderObj).hide();
	 	    			$(loaderObj).find('#errorDiv').show();
	 	    		}
	 	    	})
	 	
	
}
