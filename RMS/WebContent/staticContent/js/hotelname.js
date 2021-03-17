 function addhotel(){
	 if(document.hotelname.hotelname.value=="")
		{
			alert("Please enter hotel name");
			return false;
		}	
	 
	 addhotel1();
 }
function addhotel1(){

		var hotelname = $("#hotelname").val();		
		var params = {};
				
		
		params["hotelname"] = hotelname;
	
		params["methodName"] = "addhotel";
		
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


function gethotelnamees(){
	var params= {};

	var input = document.getElementById('fk_hotel_id'),
	list = document.getElementById('fk_hotel_id_drop'),

	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}
	
	$("#hotelname").append($("<input/>").attr("value","").text());
	
	
	params["hotelid"]= fkRootSupId;
	params["methodName"] = "gethotelToEdit";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
				document.getElementById("hotelname").value = v.hotelname;
			
				}
		);
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
		}
	});
}



function updatehotel()
{
//	document.editItemEntry.btn.disabled = true;
	
	var input = document.getElementById('fk_hotel_id'),
	list = document.getElementById('fk_hotel_id_drop'),
	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}

	//var itemName = $('#fk_item_id').val();
	var hotelid = fkRootSupId;
	var hotelname = $('#hotelname').val();	
	var params = {};
	params['h_id']=hotelid;
	params['h_name'] = hotelname;
	
	params["methodName"] = "updatehotel";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
			alert(data);
			location.reload();
		/*	if(document.item)
			{
				document.item.reset();
			}*/	
			//document.item.btn.disabled =false;
		}
 	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
	
}

