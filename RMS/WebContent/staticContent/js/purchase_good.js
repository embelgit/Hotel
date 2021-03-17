function addGood(){
	
	//document.addGood.btn.disabled =true;
	var vegetables= $('#vegetables').val();
	var grocery= $('#grocery').val();
	var other = $('#other').val();
	/*var itemName = $('#itemName').val();
	var price = $('#price').val();*/
	var total= $('#total').val();
	
	var params = {};
	
	params["vegetables"] =vegetables;
	params["grocery"] =grocery;
	params["other"] =other;
	/*params["itemName"] =itemName;
	params["price"] =price;*/
	params["total"] =total;
	
	params["methodName"] = "addGoods";

 	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
 	    	{
 				
 			alert(data);
 				
 				/*if(document.addGood)
 				{
 					document.addGood.reset();
 				}	
 				document.addGood.btn.disabled =false;*/
 			}
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});

}

function reset()
{
document.addGood.reset();	

}


function hideContents()
{
	$("#extraPurchasedItem").hide();
	
}

function calculateTotal()
{
	var veg = document.getElementById("vegetables").value;
	var gro = document.getElementById("grocery").value;
	var oth = document.getElementById("other").value;
	/*var othItem = document.getElementById("price").value;*/
	var total = Number(veg) + Number(gro) + Number(oth);
	document.getElementById("total").value = total;
	
	
}

//--------validation for Amount float Number-----//

function cheakExpenceAmt(obj)
{
	
	var exp = /^[+-]?\d+(\.\d+)?$/;
	var val = obj.value;
		
	if(exp.test(val) && val!="")
	{		
		obj.style="border:1px solid black";
	}else
		{
			obj.style="border:1px solid red";
		}
}

/*$(document).ready(function(){
    $("#showPurchaseItem").click(function(){
    	 var $this = $(this);
    	 $("#extraPurchasedItem").fadeToggle("slow");
    	 $this.toggleClass('ShowHide');
    	 
    	 if($this.hasClass('ShowHide')){
             $this.text("dont add item");           
         } else {
             $this.text("Add item manually");
         }
        
    });
});*/