
function addWaiter()
{
	
	if(document.Waiter.waiterId.value=="")
		{
		alert(document.Waiter.salary.value)
		
		return false;
		}

	if(document.Waiter.firstName.value=="")
		{
		alert("Please Enter First Name");
		return false;
		}
	if ( document.Waiter.firstName.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.Waiter.firstName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper firstName");
			return false;
		}
	}
	if(document.Waiter.middleName.value=="")
	{
	alert("Please Enter Middle Name");
	return false;
	}
	if (document.Waiter.middleName.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.Waiter.middleName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper middleName");
			return false;
		}
	}
	if(document.Waiter.lastName.value=="")
	{
	alert("Please Enter Last Name");
	return false;
	}
	if ( document.Waiter.lastName.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.Waiter.lastName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper lastName");
			return false;
		}
	}
	
	/*if(document.Waiter.middleName.value=="")
		{
		alert("Please Enter Middle Name");
		return false;
		}*/

	/*if(document.Waiter.lastName.value=="")
		{
		alert("Please Enter Last Name");
		return false;
		}*/
    //  var letter = /^[0-9]$/;
	if(document.Waiter.mobileNo.value==""){
		alert("please enter mobile no ")
		return false;
	}
	if(document.Waiter.mobileNo.value!="")
		{
//		var letter = /^[0-9]$/;
		var letterNo = /^[0-9]{10}$/;
		if(document.Waiter.mobileNo.value.match(letterNo))
		{
			
		}
		else
		{
		alert("Please Enter proper Mobile Number");
		return false;
		}
	}
	
	if(document.Waiter.salary.value=="" )
	{
		alert("Please Enter Salary");
		return false;
	}
	if(document.Waiter.salary.value !="" )
		{
		 	var sal = document.getElementById("salary").value;
		 	var letterNoo = /^[0-9]{3,10}$/;
		 	if(document.Waiter.salary.value.match(letterNoo))
			 {
		 		if(sal>=100)
				{
					//alert("matched...");

				}
				else
				{
					alert("Please enter three digit salary");
					return false;
				}
			 }
		 	else
		 	{
		 		alert("Please Enter proper salary");
		 		return false;
		 	}
		}
	

	
	
	if(document.Waiter.address.value==""){
		alert("Please Enter address ")
		return false;
	}
	
	
/*	if(document.Waiter.salary.value!="")
		{
//		var letter = /^[0-9]$/;
		var letterNo = /^[0-9]{10}$/;
		if(document.Waiter.salary.value.match(letterNo))
		{
			
		}
		else
		{
		alert("Please Enter proper Salary");
		return false;
		}
	}*/
	
	
/*	if(document.Waiter.emailId.value=="")
	{
	alert("Please Enter Email Id");
	return false;
	}*/
/*	if(document.Waiter.emailId.value!="")
	{
	var checkEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(document.Waiter.emailId.value.match(checkEmail))
	{
		
	}
	else
		{
			alert("please enter proper email ID");
			return false;
		}
	}*/
	
	addWaiter1();
}


function addWaiter1(){
	
	
	var waiterId= $('#waiterId').val();
	var firstName= $('#firstName').val();
	var middleName = $('#middleName').val();
	var lastName = $('#lastName').val();
	var mobileNo = $('#mobileNo').val();
	var emailId= $('#emailId').val();
	var dob = $('#dob').val();
	var joiningDate = $('#joiningDate').val();
	var salary = $('#salary').val();
	var address= $('#address').val();
	var city = $('#city').val();
	var zip = $('#zip').val();
	var state = $('#state').val();
	
	var params = {};
	
	params["waiterId"] =waiterId;
	params["middleName"] =middleName;
	params["firstName"] =firstName;
	params["lastName"] =lastName;
	params["mobileNo"] =mobileNo;
	params["emailId"] =emailId;
	params["joiningDate"] =joiningDate;
	params["dob"] =dob;
	params["salary"] =salary;
	params["address"] =address;
	params["city"] =city;
	params["zip"] =zip;
	params["state"] =state;
	
	params["methodName"] = "addWaiters";

// 	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 			{
 				
 		alert(data);
 		location.reload();
//		return false;
 			
 	    	}
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
}


// Update Waiter Data 
function UpdateWaiter()
{
	if(document.eWaiter.waiterID.value=="")
	{
		
	("Please Enter Waiter Id");
	return false;
	}

if(document.eWaiter.firstName.value=="")
	{
	alert("Please Enter First Name");
	return false;
	}
if ( document.eWaiter.firstName.value != "")
{
	var checkName =  /^[a-zA-Z]+$/;
	
	if(document.eWaiter.firstName.value.match(checkName))
	{
		//alert("matched...");
	}
	else
	{
		alert("Please enter proper firstName");
		return false;
	}
}
if(document.eWaiter.middleName.value=="")
{
alert("Please Enter Middle Name");
return false;
}

if(document.eWaiter.middleName.value=="")
{
alert("Please Enter Middle Name");
return false;
}
if (document.eWaiter.middleName.value != "")
{
	var checkName =  /^[a-zA-Z]+$/;
	
	if(document.eWaiter.middleName.value.match(checkName))
	{
		//alert("matched...");
	}
	else
	{
		alert("Please enter proper middleName");
		return false;
	}
}
if(document.eWaiter.lastName.value=="")
{
alert("Please Enter Last Name");
return false;
}
if ( document.eWaiter.lastName.value != "")
{
	var checkName =  /^[a-zA-Z]+$/;
	
	if(document.eWaiter.lastName.value.match(checkName))
	{
		//alert("matched...");
	}
	else
	{
		alert("Please enter proper lastName");
		return false;
	}
}



/*if(document.eWaiter.lastName.value=="")
	{
	alert("Please Enter Last Name");
	return false;
	}*/
//  var letter = /^[0-9]$/;
if(document.eWaiter.mobileNo.value==""){
	alert("please enter mobile no ")
	return false;
}
if(document.eWaiter.mobileNo.value!="")
	{
//	var letter = /^[0-9]$/;
	var letterNo = /^[0-9]{10}$/;
	if(document.eWaiter.mobileNo.value.match(letterNo))
	{
		
	}
	else
	{
	alert("Please Enter proper Mobile Number");
	return false;
	}
}
if(document.eWaiter.salary.value==""){
	alert("Please Enter Salary ")
	return false;
}

if(document.eWaiter.address.value==""){
	alert("Please Enter address ")
	return false;
}
	
	// ------------------
/*	if ( document.Waiter.firstName.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.Waiter.firstName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper firstName");
			return false;
		}
	}
	
	if ( document.Waiter.middleName.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.Waiter.middleName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper middleName");
			return false;
		}
	}
	if ( document.Waiter.lastName.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.Waiter.lastName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper lastName");
			return false;
		}
	}
	if(document.Waiter.mobileNo.value!="")
		{

		var letterNo = /^[0-9]{10}$/;
		if(document.Waiter.mobileNo.value.match(letterNo))
		{
			
		}
		else
		{
		alert("Please Enter proper Mobile Number");
		return false;
		}
	}*/
UpdateWaiter1();
}

function UpdateWaiter1()
{
	//document.editItemEntry.btn.disabled = true;
	
	var input = document.getElementById('fk_item_id'),
	list = document.getElementById('fk_item_id_drop'),
	i,fkRootSupId;
	/*for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}*/

	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}
	
	var waiterId= fkRootSupId;
	var waiterID = $('#waiterID').val();
	var firstName= $('#firstName').val();
	var middleName = $('#middleName').val();
	var lastName = $('#lastName').val();
	var mobileNo = $('#mobileNo').val();
	var emailId= $('#emailId').val();
	var dob = $('#dob').val();
	var joiningDate = $('#joiningDate').val();
	var salary = $('#salary').val();
	var address= $('#address').val();
	var city = $('#city').val();
	var zip = $('#zip').val();
	var state = $('#state').val();
	
	var params = {};

	params["waiterId"] = waiterId;
	params["waiterID"] = waiterID;
	params["middleName"] =middleName;
	params["firstName"] =firstName;
	params["lastName"] =lastName;
	params["mobileNo"] =mobileNo;
	params["emailId"] =emailId;
	params["joiningDate"] =joiningDate;
	params["dob"] =dob;
	params["salary"] =salary;
	params["address"] =address;
	params["city"] =city;
	params["zip"] =zip;
	params["state"] =state;	
	
	params["methodName"] = "updateWaiterEntrys";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
			alert(data);
			location.reload(true);
			return false;
			
			/*if(document.item)
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

/********* get Waiter Details ************/
function getAllWaiterDetails(){
	var params= {};

	var input = document.getElementById('fk_item_id'),
	list = document.getElementById('fk_item_id_drop'),

	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}

	$("#waiterId").append($("<input/>").attr("value","").text());
	$("#firstName").append($("<input/>").attr("value","").text());
	$("#middleName").append($("<input/>").attr("value","").text());
	$("#lastName").append($("<input/>").attr("value","").text());
	$("#mobileNo").append($("<input/>").attr("value","").text());
	$("#emailId").append($("<input/>").attr("value","").text());
	$("#dob").append($("<input/>").attr("value","").text());
	$("#joiningDate").append($("<input/>").attr("value","").text());
	$("#salary").append($("<input/>").attr("value","").text());
	$("#address").append($("<input/>").attr("value","").text());
	$("#city").append($("<input/>").attr("value","").text());
	$("#zip").append($("<input/>").attr("value","").text());
	$("#state").append($("<input/>").attr("value","").text());
	
	
	params["itemId"]= fkRootSupId;
	params["methodName"] = "getWaiterDetailsToEdit";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
				document.getElementById("waiterID").value = v.waiterId;
				document.getElementById("firstName").value = v.firstName;
				document.getElementById("middleName").value = v.middleName;
				document.getElementById("lastName").value = v.lastName;
				document.getElementById("mobileNo").value = v.mobileNo;
				document.getElementById("emailId").value = v.emailId;
				document.getElementById("dob").value = v.dob;
				document.getElementById("joiningDate").value = v.joiningDate;
				document.getElementById("salary").value = v.salary;
				document.getElementById("address").value = v.address;
				document.getElementById("city").value = v.city;
				document.getElementById("zip").value = v.zip;
				document.getElementById("state").value = v.state;
				});
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
		}
	});
}


function reset()
{
document.addWaiter.reset();	

}

