/*  $(document).ready(function(){
        $('.log-btn').click(function(){
            $('.log-status').addClass('wrong-entry');
           $('.alert').fadeIn(500);
           setTimeout( "$('.alert').fadeOut(1500);",3000 );
        });
        $('.form-control').keypress(function(){
            $('.log-status').removeClass('wrong-entry');
        });

    });*/
  
/*  function login()
  {
	 
	  var uname = $("#UserName").val();
	  var pass = $("#Passwod").val();
	  
	  if(uname=="raj" && pass=="raj")
	  if(uname=="" && pass=="")
	  {
		  window.location.replace("/RMS/jsp/OrderBill.jsp");
	  }
	  else
	  {
		  $("#myModal").on("show", function() {    // wire up the OK button to dismiss the modal when shown
		        $("#myModal a.btn").on("click", function(e) {
		            console.log("button pressed");   // just as an example...
		            $("#myModal").modal('hide');     // dismiss the dialog
		        });
		    });
		    $("#myModal").on("hide", function() {    // remove the event listeners when the dialog is dismissed
		        $("#myModal a.btn").off("click");
		    });
		    
		    $("#myModal").on("hidden", function() {  // remove the actual elements from the DOM when fully hidden
		        $("#myModal").remove();
		    });
		    
		    $("#myModal").modal({                    // wire up the actual modal functionality and show the dialog
		      "backdrop"  : "static",
		      "keyboard"  : true,
		      "show"      : true                     // ensure the modal is shown immediately
		    });// Java Document
		    
		    alert("Invalid username and password.");
	  }
	  
	  
  }
  */
  function login(){
	//  	document.getElementById("save").disabled=true;
		
		
		
		
	/*	var input = document.getElementById('hotelname_id'),
	    list = document.getElementById('hotelname'),
	    i,hotel_id;
		for (i = 0; i < list.options.length; ++i) {
	    if (list.options[i].value === input.value) {
	    	hotel_id = list.options[i].getAttribute('data-value');
	    }
	} */

		$("#hotelname_id option:selected").each(function() {
			selectedVal = $(this).text();
		});

		
		
		var uname = $("#UserName").val();
		if(uname == "")
		{
			alert("Please enter the Username !");
			window.location.replace("/RMS/jsp/login.jsp");
			return false;
		}
		
		
		var pass = $("#Passwod").val();
		if(pass == "")
		{
			alert("Please enter the Password !");
			window.location.replace("/RMS/jsp/login.jsp");
			return false;
		}
		
		var hotelname_id = $('#hotelname_id').val();
		if(hotelname_id == "")
		{
			alert("Please enter the Hotelname !");
			window.location.replace("/RMS/jsp/login.jsp");
			return false;
		}
		
		
		
		
		var splitText = selectedVal.split(",");
		var userid = splitText[0];
		var hotelid = splitText[1];
		var hotelname = splitText[2];
		var usertype = splitText[3];
		
		
		var params = {};
		
/*		params["UserName"] = uname;

		params["Passwod"] = pass;
*/		
		
		params["uname"] = uname;
		params["pass"] = pass;
		params["hotelid"] = hotelid;
		params["hotelname"] = hotelname;
		params["userid"] = userid;
		params["usertype"] = usertype;
		params["methodName"] = "login";
		
//		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)			
				{  
				
			window.location.replace("/RMS/jsp/OrderBill.jsp");
	//		alert("redirect to order bill - from login.js -    ");
		//	return false;			
			}
		    	).error(function(jqXHR, textStatus, errorThrown){
		    		if(textStatus==="timeout") {
		    			$(loaderObj).hide();
		    			$(loaderObj).find('#errorDiv').show();
		    		}
		    	});
		
	}
  // getshop
  function gethotel(){
		//  	document.getElementById("save").disabled=true;
			var uname = $("#UserName").val();
	//		var pass = $("#Passwod").val();
			
		
			
			$("#hotelname_id").empty();
			$("#hotelname_id").append($("<option></option>").attr("value", "").text("Select Hotel"));
			
			var params = {};
			
			params["uname"] = uname;

			params["methodName"] = "gethotel";
			
			$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
//			$.post('/RMS/jsp/utility/controller.jsp',params,function(data)

					{  
					var count = 1;

					var jsonData = $.parseJSON(data);
					// var jsonData = jsonData.list;
					$.each(jsonData, function(i, v) 
				{
				$("#hotelname_id").append($("<option></option>").attr("value", count).text(v.userid+","+v.hotelid+ "," +v.hotelname+ "," +v.usertype));
						count++;
					});		
				}).error(function(jqXHR, textStatus, errorThrown){
			    		if(textStatus==="timeout") {
			    			$(loaderObj).hide();
			    			$(loaderObj).find('#errorDiv').show();
			    		}
			    	});
			
		}
  
  
/*  function login()
  {
  	
  	document.getElementById("save").disabled=true;
  	
  	var uname = $("#uname").val();
  	var pass = $("#pass").val();
  	var params = {};

  	params["uname"] = uname;
  	params["pass"] = pass;
  	params["methodName"] = "login";
  	$.post('/society/jsp/utility/controller.jsp',params,function(data)
  			{   
  		
  				document.getElementById("save").disabled=false;
  				window.location.replace("/society/jsp/MemberDetails.jsp");
  			}
  	).error(function(jqXHR, textStatus, errorThrown){
  		if(textStatus==="timeout") {
  			$(loaderObj).hide();
  			$(loaderObj).find('#errorDiv').show();
  		}
  	});
  }*/
  
  
  
  
  
  
  
  function Logout(){
		
		var params = {};
		
		params["methodName"] = "logout";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		    	{                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
					
			alert ("You are logged Out Successfully !");
					window.location.replace("/RMS/jsp/login.jsp");
					
				    }
		    	).error(function(jqXHR, textStatus, errorThrown){
		    		if(textStatus==="timeout") {
		    			$(loaderObj).hide();
		    			$(loaderObj).find('#errorDiv').show();
		    		}
		    	});
		
	}