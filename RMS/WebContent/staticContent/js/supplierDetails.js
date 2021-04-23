function SupplierInfo(){
	
	if(document.supplierFormName.suplierName.value ==""){
		alert("Please Enter Supplier Name");
		return false;
	}
	
	if ( document.supplierFormName.suplierName.value != "")
	{
		var checkName =  /^[a-zA-Z . ]+$/;
		
		if(document.supplierFormName.suplierName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper supplier Name");
			return false;
		}
	}
		
	/*if(document.supplierFormName.suplierName.value ==""){
		alert("Please Enter Supplier Name");
		return false;
	}*/
	
	/*if(document.supplierFormName.gstNo.value ==""){
		alert("Please Enter Gst No");
		return false;
	}*/
//	if(document.supplierFormName.gstNo.value!="")
	{
//	var letter = /^[0-9]$/;
	/*var letterNo = /^[0-9 ]+$/;
	if(document.supplierFormName.gstNo.value.match(letterNo))
	{
		
	}
	else
	{
	alert("Please Enter proper GST Number");
	return false;
	} */
}
	
	if(document.supplierFormName.contactPerson.value ==""){
		alert("Please Enter Contact Person Name");
		return false;
	}
	
	if ( document.supplierFormName.contactPerson.value != "")
	{
		var checkName =  /^[a-zA-Z ]+$/;
		
		if(document.supplierFormName.contactPerson.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper contact Name");
			return false;
		}
	}
	if(document.supplierFormName.suplierContact.value ==""){
		var letterNo = /^[0-9]{10}$/;
		if(document.supplierFormName.suplierContact.value.match(letterNo))
		{
			
		}
		else
		{
		alert("Please Enter proper Mobile Number");
		return false;
		}
	}

	if(document.supplierFormName.emailID.value!="")
	{
	var checkEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(document.supplierFormName.emailID.value.match(checkEmail))
	{
		
	}
	else
		{
			alert("please enter proper email ID");
			return false;
		}
	}
	
	SupplierInfo1();
}

/******** Save Supplier Detailas**********/
function SupplierInfo1(){
	
var params = {};
	
	document.getElementById('save').disabled=true;

	var suplierName = $('#suplierName').val();
	var gstNo= $('#gstNo').val();
	var contactPerson = $('#contactPerson').val();
	var suplierContact = $('#suplierContact').val();
	var emailID = $('#emailID').val();
	var suplierCity = $('#suplierCity').val();
	var address = $('#address').val();
	var suplierState = $('#suplierState').val();
	
	params["suplierName"] = suplierName;
	params["gstNo"] = gstNo;
	params["contactPerson"] = contactPerson;
	params["suplierContact"] = suplierContact;
	params["emailID"] = emailID;
	params["suplierCity"] = suplierCity;
	params["address"] = address;
	params["suplierState"] = suplierState;
	
	params["methodName"] = "SupplierInfo";
	
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


/********* get Supplier Details ************/
function getSupplierDetails(){
	var params= {};

	var input = document.getElementById('fk_supplier_id'),
	list = document.getElementById('suplierName'),

	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}
	
	$("#suppName").append($("<input/>").attr("value","").text());
	$("#gstNo").append($("<input/>").attr("value","").text());
	$("#contactPerson").append($("<input>").attr("value","").text());
	$("#suplierContact").append($("<input>").attr("value","").text());
	$("#emailID").append($("<input>").attr("value","").text());
	$("#suplierCity").append($("<input>").attr("value","").text());
	$("#address").append($("<input>").attr("value","").text());
	$("#suplierState").append($("<input>").attr("value","").text());
	
	params["supplierId"]= fkRootSupId;
	
	params["methodName"] = "getSupplierDetailsToEdit";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
				document.getElementById("suppName").value = v.suplierName;
				document.getElementById("gstNo").value = v.gstNo;
				document.getElementById("contactPerson").value = v.contactPerson;
				document.getElementById("suplierContact").value = v.suplierContact;
				document.getElementById("emailID").value = v.emailID;
				document.getElementById("suplierCity").value = v.suplierCity;
				document.getElementById("address").value = v.address;
				document.getElementById("suplierState").value = v.suplierState;
				
				});
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
		}
	});
}

/***********Update Supplier Detailas**********/
function updateSupplierInfo(){
	
	
	
	if(document.editSupplier.fk_supplier_id.value ==""){
		alert("Please Select  Supplier Name");
		return false;
	}
	/*if(document.editSupplier.gstNo.value ==""){
		alert("Please Enter Gst No");
		return false;
	}*/
	if(document.editSupplier.contactPerson.value ==""){
		alert("Please Enter Contact Person Name");
		return false;
	}
/*	if ( document.editSupplier.contactPerson.value!= "")
	{
		var checkName =  /^[a-zA-Z ]+$/;
		
		if(document.editSupplier.contactPerson.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper Name contact Name");
			return false;
		}
	}*/
	if(document.editSupplier.suplierContact.value!="")
	{
//	var letter = /^[0-9]$/;
	var letterNo = /^[0-9]{10}$/;
	if(document.editSupplier.suplierContact.value.match(letterNo))
	{
		
	}
	else
	{
	alert("Please Enter proper Mobile Number");
	return false;
	}
}

/*	if(document.editSupplier.emailID.value!="")
	{
		var checkEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if(document.editSupplier.emailID.value.match(checkEmail))
		{
	
		}
			else
		{
		alert("please enter proper email ID");
		return false;
	}
}*/
	
/*	if ( document.editSupplier.suplierCity.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.editSupplier.suplierCity.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper City Name");
			return false;
		}
	}*/
/*	if ( document.editSupplier.suplierState.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.editSupplier.suplierState.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper State Name");
			return false;
		}
	}*/

	
	
	updateSupplierInfo1();
}
function updateSupplierInfo1()
{
	document.editSupplier.btn.disabled = true;
	
	var input = document.getElementById('fk_supplier_id'),
	list = document.getElementById('suplierName'),
	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}

	//var itemName = $('#fk_item_id').val();
	var suppName = $('#suppName').val();
	var gstNo = $('#gstNo').val();
	var contactPerson = $('#contactPerson').val();
	var suplierContact = $('#suplierContact').val();
	var emailID = $('#emailID').val();
	var suplierCity = $('#suplierCity').val();
	var address = $('#address').val();
	var suplierState = $('#suplierState').val();
	
	var params = {};
	
	//params['itemName'] = itemName;
	params['supplierId'] = fkRootSupId;
	params['suppName']  = suppName;
	params['gstNo'] = gstNo;
	params['contactPerson'] = contactPerson;
	params['suplierContact'] = suplierContact;
	params['emailID'] = emailID;
	params['suplierCity'] = suplierCity;
	params['address']  = address;
	params['suplierState']  = suplierState;
	
	params["methodName"] = "updateSupplierDetailas";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
			alert(data);
			location.reload();
			if(document.item)
			{
				document.item.reset();
			}	
			//document.editSupplier.btn.disabled =false;
		}
 	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
	
}
