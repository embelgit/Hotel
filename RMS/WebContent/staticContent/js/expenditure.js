function addexp_payment(){
	if(document.expenditurename.expenditurename.value!="")
	{
		if(document.expenditurename.expenditureamount.value!="")
			{
			addexp_payment1();
			}
		else
			{
			alert("Please Enter expenditureamount");
			return false;
			
			}
		
	}	
	  else{
		alert("Please select expenditurename");
		return false;
	}
		
}
	function addexp_payment1() {
	{
		//	document.cashbook.saveButton.disabled = true;
				
				var input = document.getElementById('expenditurename'),
			    list = document.getElementById('expenditurename_drop'),
			    i,fk_item_id1;
				for (i = 0; i < list.options.length; ++i) {
			    if (list.options[i].value === input.value) {
			    	fk_item_id1 = list.options[i].getAttribute('data-value');
			    }
			}


//		var payToId = 'supplier';
		//var expenditure		
		var expenditurename = $('#expenditurename').val();
		var paymentdate = $('#paymentdate').val();
		var expenditureamount = $('#expenditureamount').val();
		var paymentById = $('#paymentById').val();
	
		var chequeNoId = $('#chequeNoId').val();
		var chequeDateId = $('#chequeDateId').val();
		var cardNoId = $('#cardNoId').val();
		var neftAccNoId = $('#neftAccNoId').val();	
		
		var params = {};
		
		params['expenditurename'] = expenditurename;	
		params['paymentdate'] = paymentdate;
		params['expenditureamount'] = expenditureamount;
		params['paymentById'] = paymentById;

		params['chequeNoId'] = chequeNoId;
		params['chequeDateId'] = chequeDateId;
		params['cardNoId'] = cardNoId;
		params['neftAccNoId'] = neftAccNoId;
		
		params["methodName"] = "addexpenditurepayment";
		
		
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
	 	    	{
	 				alert(data);
	 				location.reload();
				//	document.podetail.btn.disabled = false;
	 				
	 			}
	 	    	).error(function(jqXHR, textStatus, errorThrown){
	 	    		if(textStatus==="timeout") {
	 	    			$(loaderObj).hide();
	 	    			$(loaderObj).find('#errorDiv').show();
	 	    		}
	 	    	});
	}
	
	
}




//add exp..

function addexpenditure() {
	{
		 if(document.expenditurename.expenditurename.value=="")
			{
				alert("Please enter Expenditure name");
				return false;
			}	
		 
		 addexpenditure1();
	 }
	
function addexpenditure1()
{
//		var payToId = 'supplier';
		var expenditurename = $('#expenditurename').val();
		
		
		var params = {};
		
		params['expenditurename'] = expenditurename;	
		
		
		params["methodName"] = "addexpenditure";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
	 	    	{
	 				alert(data);
	 				location.reload();
				//	document.podetail.btn.disabled = false;
	 				
	 			}
	 	    	).error(function(jqXHR, textStatus, errorThrown){
	 	    		if(textStatus==="timeout") {
	 	    			$(loaderObj).hide();
	 	    			$(loaderObj).find('#errorDiv').show();
	 	    		}
	 	    	});
	}
	
	
}