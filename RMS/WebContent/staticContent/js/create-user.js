	function createAppUser(){
		if(document.createUser.userType.value =="selected"){
			alert("Please Select  User Type");
			return false;
		}
		if ( document.createUser.firstName.value == "")
		{
			alert("please enter firstname");
			return false;
		}
		if ( document.createUser.firstName.value != "")
		{
			var checkName =  /^[a-zA-Z]+$/;
			
			if(document.createUser.firstName.value.match(checkName))
			{
				//alert("matched...");
			}
			else
			{
				alert("Please enter proper firstName ");
				return false;
			}
		}
		if ( document.createUser.lastName.value == "")
		{
			alert("please enter lastname");
			return false;
		}
		
		if ( document.createUser.lastName.value != "")
		{
			var checkName =  /^[a-zA-Z]+$/;
			
			if(document.createUser.lastName.value.match(checkName))
			{
				//alert("matched...");
			}
			else
			{
				alert("Please enter proper lastName");
				return false;
			}
		}
		
		/*if(document.createUser.firstName.value ==""){
			alert("Please Enter First Name");
			return false;
		}
		if(document.createUser.lastName.value ==""){
			alert("Please Enter Last Name");
			return false;
		}*/
		if(document.createUser.userName.value ==""){
			alert("Please Enter User Name");
			return false;
		}
		if(document.createUser.mobileNo.value!="")
		{
//		var letter = /^[0-9]$/;
		var letterNo = /^[0-9]{10}$/;
		if(document.createUser.mobileNo.value.match(letterNo))
		{
			
		}
		else
		{
		alert("Please Enter proper Mobile Number");
		return false;
		}
	}
		
	/*	if(document.createUser.mobileNo.value ==""){
			alert("Please Enter Mobile Number");
			return false;
		}
	*/
		if(document.createUser.password.value ==""){
			alert("Please Enter Passward");
			return false;
		}
		
		if(document.createUser.password.value !=""){
		//	var pass = /^[a-zA-Z][0-9]$/;
			var pass = /^[a-zA-Z0-9]+$/;

			if(document.createUser.password.value.match(pass))
				{
					
				}
			else {
				alert("Please enter password in proper format !");
				return false;
			}
		}
				
		if(document.createUser.confirmPassword.value ==""){
			alert("Please Enter Confirm Passward");
			return false;
		}
		
		if(document.createUser.confirmPassword.value !=""){
	//		var cpass = /^[a-zA-Z][0-9]$/;
			var cpass = /^[a-zA-Z0-9]+$/;
			if(document.createUser.confirmPassword.value.match(cpass))
				{
					
				}
			else {
				alert("Please enter confirm password in proper format !");
				return false;
			}
		}

		
		if(document.createUser.emailId.value!="")
		{
		var checkEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if(document.createUser.emailId.value.match(checkEmail))
		{
			
		}
		else
			{
				alert("please enter proper email ID");
				return false;
			}
		}
/*		if(document.createUser.hotelname.value ==""){
			alert("Please Enter hotel name");
			return false;
		}*/
		
		/*if(document.createUser.emailId.value ==""){
			alert("Please Enter Email Id");
			return false;
		}*/
		createAppUser1();
	}
	
	function createAppUser1(){
					/*alert("In js");*/
				//	document.createUser.createbtn.disabled = true;
					
								var userType = $('#userType').val();
								var firstName = $('#firstName').val();
								var lastName = $('#lastName').val();
								var userName = $('#userName').val();
								var password = $('#password').val();
								var mobileNo = $("#mobileNo").val();
								var confirmPassword = $('#confirmPassword').val();
								var emailId = $('#emailId').val();
								
							//	var hotelname = $('#hotelname').val();
								var hotelname = "NA";
								
								/*var input = document.getElementById('hotelname'),
								list = document.getElementById('hotel_drop'),

								i,hotelid;
								for (i = 0; i < list.options.length; ++i) {
									if (list.options[i].value === input.value) {
										hotelid = list.options[i].getAttribute('data-value');
									}
								}*/
								
								if(password != confirmPassword){
									alert("Password and Confirm password should be same !");
									location.reload();
									return false;
								}
								
								var hotelid = 0;
								var params = {};
								
								params["userType"] = userType;
								params["firstName"] = firstName;
								params["userName"] =userName;
								params["lastName"] = lastName;
								params["password"] = password;
								params["mobileNo"] = mobileNo;
								params["confirmPassword"] = confirmPassword;
								params["emailId"] = emailId;
								params["hotelname"] = hotelname;
								params["hotelid"] = hotelid;
								
								params["methodName"] = "createUser";
								
								$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
							 	    	{
					 				alert(data);
									location.reload();
								//	return false;
									/*$.getScript('/RMS/staticContent/js/bootbox.min.js', function() 
											{
								
										var msg=data;
										var dialog = bootbox.dialog({
											//title: "Embel Technologies Says :",
										    message: '<p class="text-center">'+msg.fontcolor("red").fontsize(5),
										    closeButton: false
										});
										
										setTimeout(function() {
											dialog.modal('hide');
											location.reload();
											document.createUser.createbtn.disabled = false;
										}, 1500);
										
										return false;
										
											});		
					*/				
							 				
							 			/*	if(document.createUser)
							 				{
							 					document.createUser.reset();
							 				}	
							 				document.createUser.createbtn.disabled =false;*/
							 			}
							 	    	).error(function(jqXHR, textStatus, errorThrown){
							 	    		if(textStatus==="timeout") {
							 	    			$(loaderObj).hide();
							 	    			$(loaderObj).find('#errorDiv').show();
							 	    		}
							 	    	});

				}

			
/********* get User  Details ************/
function getAllCreateUserDetails(){
			var params= {};

					var input = document.getElementById('fk_item_id'),
					list = document.getElementById('fk_item_id_drop'),

					i,fkRootSupId;
					for (i = 0; i < list.options.length; ++i) {
						if (list.options[i].value === input.value) {
							fkRootSupId = list.options[i].getAttribute('data-value');
						}
					}
					
					$("#userType").append($("<input/>").attr("value","").text());
					$("#firstName").append($("<input/>").attr("value","").text());
					$("#lastName").append($("<input/>").attr("value","").text());
					$("#userName").append($("<input/>").attr("value","").text());
					$("#mobileNo").append($("<input/>").attr("value","").text());
					$("#password").append($("<input/>").attr("value","").text());
					$("#confirmPassword").append($("<input/>").attr("value","").text());
					$("#emailId").append($("<input/>").attr("value","").text());
					
					
					
					params["itemId"]= fkRootSupId;
					params["methodName"] = "getCreateDetailsToEdit";
					$.post('/RMS/jsp/utility/controller.jsp',params,function(data){
						var jsonData = $.parseJSON(data);
						var catmap = jsonData.list;
						$.each(jsonData,function(i,v)
								{
								document.getElementById("userType").value = v.userType;
								document.getElementById("firstName").value = v.firstName;
								document.getElementById("lastName").value = v.lastName;
								document.getElementById("userName").value = v.userName;
								document.getElementById("mobileNo").value = v.mobileNO;
								document.getElementById("password").value = v.password;
								document.getElementById("confirmPassword").value = v.confirmPassword;
								document.getElementById("emailId").value = v.emailId;
								
								});
					}).error(function(jqXHR, textStatus, errorThrown){
						if(textStatus==="timeout") {
						}
					});
				}


function UpdatecreateAppUser(){
	if(document.createUser.userType.value =="selected"){
		alert("Please Select  User Type");
		return false;
	}
	if(document.createUser.firstName.value ==""){
		alert("Please Enter First Name");
		return false;
	}
	if(document.createUser.lastName.value ==""){
		alert("Please Enter Last Name");
		return false;
	}
	if(document.createUser.userName.value ==""){
		alert("Please Enter User Name");
		return false;
	}
	if(document.createUser.mobileNo.value ==""){
		alert("Please Enter Mobile Number");
		return false;
	}
	if(document.createUser.password.value ==""){
		alert("Please Enter Passward");
		return false;
	}
	if(document.createUser.confirmPassword.value ==""){
		alert("Please Enter Confirm Passward");
		return false;
	}
	
	if ( document.createUser.firstName.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.createUser.firstName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper firstName ");
			return false;
		}
	}
	
	if ( document.createUser.lastName.value != "")
	{
		var checkName =  /^[a-zA-Z]+$/;
		
		if(document.createUser.lastName.value.match(checkName))
		{
			//alert("matched...");
		}
		else
		{
			alert("Please enter proper lastName");
			return false;
		}
	}
	
	/*if(document.createUser.firstName.value ==""){
		alert("Please Enter First Name");
		return false;
	}
	if(document.createUser.lastName.value ==""){
		alert("Please Enter Last Name");
		return false;
	}*/
	if(document.createUser.userName.value ==""){
		alert("Please Enter User Name");
		return false;
	}
	if(document.createUser.mobileNo.value!="")
	{
//	var letter = /^[0-9]$/;
	var letterNo = /^[0-9]{10}$/;
	if(document.createUser.mobileNo.value.match(letterNo))
	{
		
	}
	else
	{
	alert("Please Enter proper Mobile Number");
	return false;
	}
}
	
/*	if(document.createUser.emailId.value!="")
	{
	var checkEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(document.createUser.emailId.value.match(checkEmail))
	{
		
	}
	else
		{
			alert("please enter proper email ID");
			return false;
		}
	}*/
	
	
	UpdatecreateAppUser1();
}
//Update Create User  Data 
function UpdatecreateAppUser1()
{
	//document.editItemEntry.btn.disabled = true;
	
	var input = document.getElementById('fk_item_id'),
	list = document.getElementById('fk_item_id_drop'),
	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootSupId = list.options[i].getAttribute('data-value');
		}
	}

	//var itemName = $('#fk_item_id').val();
	var CreateUserId= fkRootSupId;
	var userType = $('#userType').val();
	var firstName = $('#firstName').val();
	var lastName = $('#lastName').val();
	var userName = $('#userName').val();
	var password = $('#password').val();
	var mobileNo = $("#mobileNo").val();
	var confirmPassword = $('#confirmPassword').val();
	var emailId = $('#emailId').val();
	
	if(password != confirmPassword){
		alert("Password and Confirm Password entered should be same !");
//		location.reload();
		return false;
	}
	
	var params = {};
	params["CreateUserId"] = CreateUserId;
	params["userType"] = userType;
	params["firstName"] = firstName;
	params["userName"] = userName;
	params["lastName"] = lastName;
	params["password"] = password;
	params["mobileNo"] = mobileNo;
	params["confirmPassword"] = confirmPassword;
	params["emailId"] = emailId;
	
	
	params["methodName"] = "updateCreateUSerEntrys";
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
			alert(data);
			location.reload(true);
			return false;
/*			if(document.item)
			{
				document.item.reset();
			}	
*/			//document.item.btn.disabled =false;
		}
 	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
	
}
/*
  Name:Meghraj Menkudle
  Date:28/01/2017
  



//-------------------validation---------------//

//--------validation for firstName and lastName-----//

function firstNameValidation(obj)
{
	
	var exp = /^[a-zA-Z]{1,25}$/;
	var val = obj.value;	
	
	if(exp.test(val))
	{		
		obj.style="border:1px solid black";
	}else
		{
			obj.style="border:1px solid red";
		}
}


//--------validation Mobile Number-----//

function moNoValidation(obj)
{
	
	var exp = /^[0-9]{10,10}$/;
	var val = obj.value;	
	
	if(exp.test(val))
	{		
		obj.style="border:1px solid black";
	}else
		{
			obj.style="border:1px solid red";
		}
}

//--------validation Password-----//

function cheakConPassword(obj)
{
	var con_pass = obj.value;		
	var pass = document.getElementById("passwordId").value;
	
	if(pass==con_pass && con_pass!="")
	{		
		obj.style="border:1px solid black";
	}
	else
	{
		obj.style="border:1px solid red";
	}
}

//--------Check for empty field-----//

function cheakEmpty(obj)
{
	var val = obj.value;
	
	if(val=="")
	{
		obj.style="border:1px solid red";
	}
	
	if(val!="")
	{
		obj.style="border:1px solid black";
	}
		
}
*/



function reset()
{
document.createUser.reset();	

}

		
