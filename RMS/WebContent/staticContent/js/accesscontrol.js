function getuserDetails(){
	var params= {};

	var input = document.getElementById('username'),
	list = document.getElementById('user_drop'),

	i,userid;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			userid = list.options[i].getAttribute('data-value');
		}
	}
	
/*	$("#username").append($("<input/>").attr("value","").text());
	$("#pass").append($("<input/>").attr("value","").text());*/
	
	
	params["userid"]= userid;
	params["methodName"] = "getuserDetails";
	$.post('/RMS/jsp/utility/controller.jsp', params,function(data){
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		$.each(jsonData,function(i,v)
				{
//				document.getElementById("username").value = v.userName;
				document.getElementById("user").value = v.userName;
				document.getElementById("pass").value = v.password;
			
				});
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
		}
	});
}

function addaccess(){
	if(document.createUser.username.value=="")
	{
		alert("Please select username");
		return false;
	}	
	if(document.createUser.usertype.value=="")
	{
		alert("Please select usertype");
		return false;
	}
	if(document.createUser.hotel.value=="")
	{
		alert("Please select hotel name");
		return false;
	}
	 addaccess1();
}
function addaccess1(){
	
	
		var params = {};
		
//		document.getElementById('save').disabled=true;
		var input = document.getElementById('username'),
		list = document.getElementById('user_drop'),

		i,useridd;
		for (i = 0; i < list.options.length; ++i) {
			if (list.options[i].value === input.value) {
				useridd = list.options[i].getAttribute('data-value');
			}
		}
			
		var user = $('#user').val();
		var user_id = useridd;
		var pass = $('#pass').val();
		var usertype = $('#usertype').val();
		var hotelname = $('#hotel').val();
		
		var input = document.getElementById('hotel'),
		list = document.getElementById('hotel_drop'),

		i,userid;
		for (i = 0; i < list.options.length; ++i) {
			if (list.options[i].value === input.value) {
				userid = list.options[i].getAttribute('data-value');
			}
		}
		
		var hotelid = userid;
//		var hotelname = hotelname;
		
		params["user"] = user;
		params["pass"] = pass;
		params["usertype"] = usertype;
		params["user_id"] = user_id;
		params["hotelid"] = hotelid;
		params["hotelname"] = hotelname;
		params["methodName"] = "addaccess";
		
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
