
/*	var abc = data.value;
	var tableNo = abc;

	//alert("button u clicked -- "+tableNo);
	
	//var updatedPkTempId;
	var Hotelid;
	var params = {};
	
	params["tableNo"] = tableNo;*/

	
	
	/*var table = $('#list').DataTable();
//	var rowcount = $('#list').dataTable().rows().count();
	var rowcount = table.data().length();*/
	
/*	var table = $('#list').DataTable();
	 
	var data = table
	    .rows()
	    .data();
	 
//	alert( 'The table has '+data.length+' records' );
	var rowcount = data.length;
	
	for(var i =0; i<= rowcount; i++){
	
	//var itemID = $('#').val();
	
		var cooked = $('#cooked').val();
		var uncooked = $('#un-cooked').val();
	
	}*/
	
	/*var table = $('#demo_jui').DataTable();
	 
	$('#demo_jui').on( 'click', 'tr', function () {
	    var id = table.rows( this ).id();
	 
	    alert( 'you just Clicked on row id is --> '+id );
	} );*/
	
	
	 
	     /*   document.getElementById('submit').innerHTML = "";
	        var myTab = document.getElementById('list');

	        // LOOP THROUGH EACH ROW OF THE TABLE AFTER HEADER.
	        for (i = 1; i < myTab.rows.length; i++) {

	            // GET THE CELLS COLLECTION OF THE CURRENT ROW.
	            var objCells = myTab.rows.item(i).cells;

	            // LOOP THROUGH EACH CELL OF THE CURENT ROW TO READ CELL VALUES.
	            for (var j = 0; j < objCells.length; j++) {
	                submit.innerHTML = submit.innerHTML + ' ' + objCells.item(j).innerHTML;
	            }
	            submit.innerHTML = submit.innerHTML + '<br />';     // ADD A BREAK (TAG).
	        }*/

//function saveStatus()
function saveStatus(data)
{
	
/*
	if(document.kordr.cooking.value == "selected") {
	saveStatu1();
	}
	else
		{
		alert("please select Order Status if it is cooked/completed.");
		return false;
		}
}
function saveStatu1() {*/
	
	var params = {};
	
	//document.getElementById('submit').disabled=true;
	var abc = data.id;
	var pk_id = abc;
	
	var cooking = $('input[name="cooking"]:checked').val();
	
	
	params["cooking"] = cooking;
	params["pk_id"] = pk_id;
	 
	 params["methodName"] = "saveCookingStatus";
	 
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