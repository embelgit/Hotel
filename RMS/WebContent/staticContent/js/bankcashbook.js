function banktransaction() {
	{

//		var payToId = 'supplier';
		var bankname = $('#bankname').val();
		var datee = $('#datee').val();
		var contactno = $('#contactno').val();
		var paymentType = $('#paymentType').val();
/*		var chequeNoId = $('#chequeNoId').val();
		var chequeDateId = $('#chequeDateId').val();
		var cardNoId = $('#cardNoId').val();
		var neftAccNoId = $('#neftAccNoId').val();	*/
		var accountname = $('#accountname').val();
		var amount = $('#amount').val();
		
		var params = {};
		
//		params['payToId'] = payToId;	
		params['bankname'] = bankname;
		params['datee'] = datee;
		params['contactno'] = contactno;
		params['paymentType'] = paymentType;

		params['accountname'] = accountname;
		params['amount'] = amount;
		
		
		params["methodName"] = "addbanktransaction";
		
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

// bank detail
function addbankdetails() {
	{

//		var payToId = 'supplier';
		var bankname = $('#bankname').val();
		var branchname = $('#branchname').val();
		var accountname = $('#accountname').val();
		var accountnum = $('#accountnum').val();
		var ifsccode = $('#ifsccode').val();
		
		var contactno = $('#contactnum').val();
		
		var params = {};
		
//		params['payToId'] = payToId;	
		params['bankname'] = bankname;
		params['branchname'] = branchname;
		
		params['contactno'] = contactno;
		params['ifsccode'] = ifsccode;

		params['accountname'] = accountname;
		params['accountnum'] = accountnum;
		
		
		params["methodName"] = "addbankdetails";
		
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

//bank report name wise

function getbanknamewiseReport(){
	if(document.bankreport1.fkbankname.value =="")
	{
		alert("Please Selct bank name");
		return false;
	}
	getbanknamewiseReport1(); 
}
var listcount=0;
function getbanknamewiseReport1(){
	
	var params= {};
	var input = document.getElementById('fkbankname'),
    list = document.getElementById('fkbankname_drop'),
    i,fk_bank_id;
	for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input.value) {
    	fk_bank_id = list.options[i].getAttribute('data-value');
    }
}
	var bankid = fk_bank_id;
	var fkbankname= $('#fkbankname').val();
	
	params["bankid"] = bankid;
	params["fkbankname"] = fkbankname;
	
		params["methodName"] = "getbanknamewiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName1').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected Bank Name");
				return false;
			}
			
			$(document).ready(function() {
			 var total =   $('#catName1').DataTable( {
				 
				 fnRowCallback : function(nRow, aData, iDisplayIndex){
		                $("th:first", nRow).html(iDisplayIndex +1);
		               return nRow;
		            },
				    
		            
		            "footerCallback": function ( row, data, start, end, display ) {
			            var api = this.api(), data;
			 
			            // Remove the formatting to get integer data for summation
			            var intVal = function ( i ) {
			                return typeof i === 'string' ?
			                    i.replace(/[\$,]/g, '')*1 :
			                    typeof i === 'number' ?
			                        i : 0;
			            };
			            pageTotal = api
		                .column( 3 )
		                .data()
		                .reduce( function (a, b) {
		                    return intVal(a) + intVal(b);
		                }, 0 );
		 
		            // Update footer
		            $( api.column( 3 ).footer() ).html(
		            		
		              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
		               
		            );
		            console.log( pageTotal);
		            
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
						
				
				{"data": "sr", "width": "5%", "defaultContent": ""},
				{"data": "bankname", "width": "5%", "defaultContent": ""},
				{"data": "accountname", "width": "5%", "defaultContent": ""},
				{"data": "amount", "width": "5%", "defaultContent": ""},
				{"data": 'contactno', "width": "5%", "defaultContent": ""},
				{"data": "paymentType", "width": "5%", "defaultContent": ""},
				{"data": "datee", "width": "5%", "defaultContent": ""},
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Bank Name Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName1').dataTable().fnAddData(mydata);
		document.getElementById("fkbankname").value = "";
			}

		);
		
		
	}

// bank range wise rp

function getBankrangeWiseReport(){
	if(document.bankreport2.rangefrom.value =="")
	{
		alert("Please Selct Date from");
		return false;
	}
	if(document.bankreport2.rangetoo.value =="")
	{
		alert("Please Selct Date to");
		return false;
	}
	getBankrangeWiseReport1(); 
}
var listcount=0;
function getBankrangeWiseReport1(){
	
	var params= {};
	

	var rangefrom= $('#rangefrom').val();
	var rangetoo = $('#rangetoo').val();
	
	params["rangefrom"] = rangefrom;
	params["rangetoo"] = rangetoo;

		params["methodName"] = "getbankRangewiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName3').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected date ");
				return false;
			}
			
			$(document).ready(function() {
			 var total =   $('#catName3').DataTable( {
				 
				 fnRowCallback : function(nRow, aData, iDisplayIndex){
		                $("th:first", nRow).html(iDisplayIndex +1);
		               return nRow;
		            },
				    
		            
		            "footerCallback": function ( row, data, start, end, display ) {
			            var api = this.api(), data;
			 
			            // Remove the formatting to get integer data for summation
			            var intVal = function ( i ) {
			                return typeof i === 'string' ?
			                    i.replace(/[\$,]/g, '')*1 :
			                    typeof i === 'number' ?
			                        i : 0;
			            };
			            pageTotal = api
		                .column( 3 )
		                .data()
		                .reduce( function (a, b) {
		                    return intVal(a) + intVal(b);
		                }, 0 );
		 
		            // Update footer
		            $( api.column( 3 ).footer() ).html(
		            		
		              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
		               
		            );
		            console.log( pageTotal);
		            
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
						
				
				{"data": "sr", "width": "5%", "defaultContent": ""},
				{"data": "bankname", "width": "5%", "defaultContent": ""},
				{"data": "accountname", "width": "5%", "defaultContent": ""},
				{"data": "amount", "width": "5%", "defaultContent": ""},
				{"data": 'contactno', "width": "5%", "defaultContent": ""},
				{"data": "paymentType", "width": "5%", "defaultContent": ""},
				{"data": "datee", "width": "5%", "defaultContent": ""},
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Bank Name Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName3').dataTable().fnAddData(mydata);
		
		document.getElementById("rangefrom").value = "";
		document.getElementById("rangetoo").value = "";
		
			}

		);
		
		
	}