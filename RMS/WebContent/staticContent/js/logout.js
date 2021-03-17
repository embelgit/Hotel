function Logout(){
	
	var params = {};
	
	params["methodName"] = "LogOut";
	
	$.post('/embel/jsp/utility/controller.jsp',params,function(data)
	    	{   
				
		        alert (" You are logged out Successfully !");
				window.location.replace("/RMS/jsp/login.jsp");
				
			    }
	    	).error(function(jqXHR, textStatus, errorThrown){
	    		if(textStatus==="timeout") {
	    			$(loaderObj).hide();
	    			$(loaderObj).find('#errorDiv').show();
	    		}
	    	});
	
}