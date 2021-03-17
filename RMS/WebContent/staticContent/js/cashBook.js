function cheak()
{
	 var x = document.getElementById("paymenttonameid").value;	
	 
	 if(x=="supplier")
	 {
/*		 document.getElementById("OtherPayment").style.display = "none";*/
	 	 document.getElementById("itemNames").style.display = "initial";
		 $("#itemNames").empty();
			$("#itemNames").append($("<option></option>").attr("value","").text("Select Supplier Name"));
			var params= {};
			params["methodName"] = "getSuppliers";
		
			$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
					{
				var jsonData = $.parseJSON(data);
				var catmap = jsonData.list;
				$.each(jsonData,function(i,v)
						{
					$("#itemNames").append($("<option></option>").attr("value",v.suplierName).text(v.suplierName)); 

						});
					}).error(function(jqXHR, textStatus, errorThrown){
						if(textStatus==="timeout") {

						}
					}); 	
	 }
	 
	 if(x=="employee")	 
	 {		 
/*		 document.getElementById("OtherPayment").style.display = "none";*/
		 document.getElementById("itemNames").style.display = "initial";
		 $("#itemNames").empty();
			$("#itemNames").append($("<option></option>").attr("value","").text("Select Employee Name"));
			var params= {};
			params["methodName"] = "getEmployee";
			/*params["empid"]= toPay;*/
			$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
					{
				var jsonData = $.parseJSON(data);
				var catmap = jsonData.list;
				$.each(jsonData,function(i,v)
						{
	//				$("#itemNames").append($("<option></option>").attr("value",v.firstName).text(v.empName)); 
					$("#itemNames").append($("<option></option>").attr("value",v.firstName+" "+v.middleName+" "+v.lastName).text(v.firstName+" "+v.middleName+" "+v.lastName));
						});
					}).error(function(jqXHR, textStatus, errorThrown){
						if(textStatus==="timeout") {

						}
					});
	 }
	 
}

function validateCashBook()
{
	if(document.cashbook.fk_supplier_id.value !="")
	{
		if(document.cashbook.payingAmountId.value !="")
		{
			validateCashBook1();
		}
		else
		{
			alert("Please Enter Paid Amount ");
			return false;
		}
	}
	else
	{
		alert("Please Select Supplier Name");
		return false;
	}
	

	
}

	
function validateCashBook1(){
{
	//document.getElementById("buttonCSS").disabled = true;

	var input = document.getElementById('fk_supplier_id'),
    list = document.getElementById('suplierName'),
    i,fk_supplier_id1;
	for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input.value) {
    	fk_supplier_id1 = list.options[i].getAttribute('data-value');

    }
}

	   var fk_supplier_id = fk_supplier_id1;
	    var payToId = 'supplier';
		var toPayNameId = $('#fk_supplier_id').val();
		var paymentDate = $('#paymentDate').val();
		var paymentTypeId = $('#paymentTypeId').val();
		var paymebtById = $('#paymebtById').val();
		var chequeNoId = $('#chequeNoId').val();
		var chequeDateId = $('#chequeDateId').val();
		var cardNoId = $('#cardNoId').val();
		var neftAccNoId = $('#neftAccNoId').val();	
		var paymentAmountId = $('#paymentAmountId').val();
		var payingAmountId = $('#payingAmountId').val();
		var paymentReasonId = $('#paymentReasonId').val();
		var remainingBalance = $('#remainingBalance').val();
			
		var params = {};
		
		params['fk_supplier_id']=fk_supplier_id;
		params['payToId'] = payToId;	
		params['toPayNameId'] = toPayNameId;
		params['paymentDate'] = paymentDate;
		params['paymentTypeId'] = paymentTypeId;
		params['paymebtById'] = paymebtById;
		params['chequeNoId'] = chequeNoId;
		params['chequeDateId'] = chequeDateId;
		params['cardNoId'] = cardNoId;
		params['neftAccNoId'] = neftAccNoId;	
		params['paymentAmountId'] = paymentAmountId;
		params['payingAmountId'] = payingAmountId;
		params['paymentReasonId'] = paymentReasonId;
		params['remainingBalance'] = remainingBalance;		
		
		params["methodName"] = "addCashBooks";
		
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

// emp


function validateCashBooknw()
{
	if(document.cashbook.waiterid.value !="")
	{
		if(document.cashbook.payingAmountId.value !="")
		{
			validateCashBooknw1();
		}
		else
		{
			alert("Please Enter Paid Amount ");
			return false;
		}
	}
	else
	{
		alert("Please Select Employee Name");
		return false;
	}

	
}

function validateCashBooknw1() {
	{
	//	document.cashbook.saveButton.disabled = true;
		
		var input = document.getElementById('waiterid'),
	    list = document.getElementById('waiterid_drop'),
	    i,fk_item_id1;
		for (i = 0; i < list.options.length; ++i) {
	    if (list.options[i].value === input.value) {
	    	fk_item_id1 = list.options[i].getAttribute('data-value');
	    }
	}
		var waiterid = fk_item_id1;
		var payToId = 'employee';
		var toPayNameId = $('#waiterid').val();
		var paymentDate = $('#paymentDate').val();
		var paymentTypeId = $('#paymentTypeId').val();
		var paymebtById = $('#paymebtById').val();
		var chequeNoId = $('#chequeNoId').val();
		var chequeDateId = $('#chequeDateId').val();
		var cardNoId = $('#cardNoId').val();
		var neftAccNoId = $('#neftAccNoId').val();	
		var paymentAmountId = $('#paymentAmountId').val();
		var payingAmountId = $('#payingAmountId').val();
		var paymentReasonId = $('#paymentReasonId').val();
		var remainingBalance = $('#remainingBalance').val();
			
		var params = {};
		
		params['waiterid'] = waiterid;
		params['payToId'] = payToId;	
		params['toPayNameId'] = toPayNameId;
		params['paymentDate'] = paymentDate;
		params['paymentTypeId'] = paymentTypeId;
		params['paymebtById'] = paymebtById;
		params['chequeNoId'] = chequeNoId;
		params['chequeDateId'] = chequeDateId;
		params['cardNoId'] = cardNoId;
		params['neftAccNoId'] = neftAccNoId;	
		params['paymentAmountId'] = paymentAmountId;
		params['payingAmountId'] = payingAmountId;
		params['paymentReasonId'] = paymentReasonId;
		params['remainingBalance'] = remainingBalance;		
		
		params["methodName"] = "addCashBooksemp";
		
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

function getAmount()
{
	 var input = document.getElementById('fk_supplier_id').value;
//	var fk_supplier_id = $("#supplierId").val();
//	var billNo = $("#billNo").val();
//	$("#totalAmount").empty();
//	$("#totalAmount").append($("<input/>").attr("value","").text());
	 /*var input = document.getElementById('waiterid'),
	    list = document.getElementById('waiterid_drop'),
	    i,fk_item_id1;
		for (i = 0; i < list.options.length; ++i) {
	    if (list.options[i].value === input.value) {
	    	fk_item_id1 = list.options[i].getAttribute('data-value');
	    }
	}*/
	 
	var params= {};


	params["supplier"]= input;
	params["methodName"] = "getTotalAmt";	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
		var jsonData = $.parseJSON(data);
		var catmap = jsonData;
		if(catmap==null){
			alert("no data");
			return false;
		}
		//var jsonData = jsonData.list;
		$.each(jsonData,function(i,v)
				{
					//document.getElementById("totalAmount").value = v.grossTotal;
					document.getElementById("paymentAmountId").value = v.paymentAmountId;
					document.getElementById("remainingBalance").value=v.remainingBalance;
			
					//document.getElementById("balanceAmount").value = v.balanceamount;
			
				});
			})
		
}

// --- employeee


function getEmpAmount()
{
//	 var input = document.getElementById('waiterid').value;
//	var fk_supplier_id = $("#supplierId").val();
//	var billNo = $("#billNo").val();
//	$("#totalAmount").empty();
//	$("#totalAmount").append($("<input/>").attr("value","").text());
	
	 var input = document.getElementById('waiterid'),
	    list = document.getElementById('waiterid_drop'),
	    i,fk_item_id1;
		for (i = 0; i < list.options.length; ++i) {
	    if (list.options[i].value === input.value) {
	    	fk_item_id1 = list.options[i].getAttribute('data-value');
	    }
	}
		
	 var params= {};


	params["employee"]= fk_item_id1;
	params["methodName"] = "getEmpTotalAmt";	
	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
		var jsonData = $.parseJSON(data);
		var catmap = jsonData;
		if(catmap==null){
			alert("no data");
			return false;
		}
		//var jsonData = jsonData.list;
		$.each(jsonData,function(i,v)
				{
					//document.getElementById("totalAmount").value = v.grossTotal;
					document.getElementById("paymentAmountId").value = v.paymentAmountId;
					document.getElementById("remainingBalance").value=v.remainingBalance;
			
					//document.getElementById("balanceAmount").value = v.balanceamount;
			
				});
			})
		
}

/*function checkAmt(){
	var RemainBal = document.getElementById('remainingBalance').value;

	var PaidAmtt = document.getElementById('payingAmountId').value;
	
	if(PaidAmtt > RemainBal){
		alert("Paid Amount entered should be less than the Balance Amount");
	//	location.reload();
		return false;
	}
}*/

function reloadPage(){
	location.reload();
}



