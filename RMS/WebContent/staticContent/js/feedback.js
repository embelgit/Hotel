function validation() {
	var name = $('#name').val();
	var contact = $('#contact').val();
	var conLength = contact.length;
	var tfeedback = $('#tfeedback').val();

	if (name == "") {
		alert("Enter Name");
		return false;
	} 
	if (contact == "")
	{
		alert("Enter Contact no");
		return false;
	}
	else
	{
		if((conLength<Number(10) ||  conLength<Number>(10)))
		{
			
			 alert("Enter 10 Digit number only");
			 return false;
		}
	}
	
	if(tfeedback == "")
	{
		alert("Enter FeedBack");
		return false;
	}
	
	feedback1();
	

}

function feedback1() {
	var name = $('#name').val();
	var contact = $('#contact').val();
	if (document.getElementById('r1').checked) {
		rate_value = document.getElementById('r1').value;
	} else if (document.getElementById('r2').checked) {
		rate_value = document.getElementById('r2').value;
	} else if (document.getElementById('r3').checked) {
		rate_value = document.getElementById('r3').value;
	} else if (document.getElementById('r4').checked) {
		rate_value = document.getElementById('r4').value;
	} else {
		rate_value = "N/A";
	}
	var tfeedback = $('#tfeedback').val();

	var params = {};

	params["name"] = name;
	params["contact"] = contact;
	params["rate_value"] = rate_value;
	params["tfeedback"] = tfeedback;

	params["methodName"] = "feedBackform";

	$.post('/RMS/jsp/utility/controller.jsp', params, function(data) {
		alert(data);
		location.reload();
		document.feedBack.createbtn.disabled = false;
	}).error(function(jqXHR, textStatus, errorThrown) {
		if (textStatus === "timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});

}

function reset() {
	document.feedBack.reset();

}
