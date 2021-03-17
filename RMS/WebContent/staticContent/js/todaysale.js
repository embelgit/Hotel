function addtodaysale() {
	{


		var saleamount = $('#saleamount').val();
		var currentcash = $('#currentcash').val();
		var cardpayment = $('#cardpayment').val();
		var googlepaypayment = $('#googlepaypayment').val();
	
		var phonpepayment = $('#phonpepayment').val();
		var paytmpayment = $('#paytmpayment').val();
		var otherpayment = $('#otherpayment').val();
		/*var neftAccNoId = $('#neftAccNoId').val();	*/
		
		var params = {};
		
		params['saleamount'] = saleamount;	
		params['currentcash'] = currentcash;
		params['cardpayment'] = cardpayment;
		params['googlepaypayment'] = googlepaypayment;

		params['phonpepayment'] = phonpepayment;
		params['paytmpayment'] = paytmpayment;
		params['otherpayment'] = otherpayment;
/*		params['neftAccNoId'] = neftAccNoId;*/
		
		params["methodName"] = "addtodaysale";
		
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


//date wise report

function getsaleDateWiseReport(){
	if(document.todaysalereport1.saledatee.value =="")
	{
		alert("Please Selct Sale date");
		return false;
	}
	getsaleDateWiseReport1(); 
}
var listcount=0;
function getsaleDateWiseReport1(){
	
	var params= {};
	

	var saledatee= $('#saledatee').val();
	
	
	params["saledatee"] = saledatee;
		
		params["methodName"] = "gettodaysaleDateWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName2').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected date ");
				return false;
			}
			
			
			
			$(document).ready(function() {
			 var total =   $('#catName2').DataTable( {
				 
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
		                .column( 1 )
		                .data()
		                .reduce( function (a, b) {
		                    return intVal(a) + intVal(b);
		                }, 0 );
		 
		            // Update footer
		            $( api.column( 1 ).footer() ).html(
		            		
		              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
		               
		            );
		            console.log( pageTotal);
		            //
		            pageTotal = api
	                .column( 2 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 2 ).footer() ).html(
	            		
	              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
	               
	            );
	            
	            console.log( pageTotal);
	     //
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
           //
            pageTotal = api
            .column( 4 )
            .data()
            .reduce( function (a, b) {
                return intVal(a) + intVal(b);
            }, 0 );

        // Update footer
        $( api.column( 4 ).footer() ).html(
        		
          'Rs'+' '+parseFloat(pageTotal).toFixed(2)
           
        );
        console.log( pageTotal);
        //
        pageTotal = api
        .column( 5 )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
        $( api.column( 5 ).footer() ).html(
    		
      'Rs'+' '+parseFloat(pageTotal).toFixed(2)
       
        );
        console.log( pageTotal);
    //
    pageTotal = api
    .column( 6 )
    .data()
    .reduce( function (a, b) {
        return intVal(a) + intVal(b);
    	}, 0 );

    // Update footer
    $( api.column( 6 ).footer() ).html(
		
    		'Rs'+' '+parseFloat(pageTotal).toFixed(2)
   
    	);
    	console.log( pageTotal);
//
    	
        pageTotal = api
        .column( 7 )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
    $( api.column( 7 ).footer() ).html(
    		
      'Rs'+' '+parseFloat(pageTotal).toFixed(2)
       
    );
    console.log( pageTotal);
    
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
						
				
				{"data": "sr", "width": "3%", "defaultContent": ""},
				{"data": "saleamount", "width": "5%", "defaultContent": ""},
				{"data": "currentcash", "width": "5%", "defaultContent": ""},
				{"data": "cardpayment", "width": "5%", "defaultContent": ""},
				{"data": 'googlepaypayment', "width": "5%", "defaultContent": ""},
				{"data": "phonpepayment", "width": "5%", "defaultContent": ""},
				{"data": "paytmpayment", "width": "5%", "defaultContent": ""},
				{"data": "otherpayment", "width": "5%", "defaultContent": ""},
				{"data": "todaysdate", "width": "5%", "defaultContent": ""}
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Today Sale Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName2').dataTable().fnAddData(mydata);
		document.getElementById("saledatee").value = "";
			}

		);
		
		
	}

// range  wise today sale

function getsalerangeWiseReport(){
	if(document.todaysalereport2.rangefrom.value =="")
	{
		alert("Please Selct sale date from");
		return false;
	}
	if(document.todaysalereport2.rangetoo.value =="")
	{
		alert("Please Selct sale date to");
		return false;
	}
	getsalerangeWiseReport1(); 
}
var listcount=0;
function getsalerangeWiseReport1(){
	
	var params= {};
	

	var rangefrom= $('#rangefrom').val();
	var rangetoo = $('#rangetoo').val();
	
	params["rangefrom"] = rangefrom;
	params["rangetoo"] = rangetoo;
	
		params["methodName"] = "getsalerangeWiseReportt";

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
		                .column( 1 )
		                .data()
		                .reduce( function (a, b) {
		                    return intVal(a) + intVal(b);
		                }, 0 );
		 
		            // Update footer
		            $( api.column( 1 ).footer() ).html(
		            		
		              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
		               
		            );
		            console.log( pageTotal);
		            //
		            pageTotal = api
	                .column( 2 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 2 ).footer() ).html(
	            		
	              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
	               
	            );
	            
	            console.log( pageTotal);
	     //
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
           //
            pageTotal = api
            .column( 4 )
            .data()
            .reduce( function (a, b) {
                return intVal(a) + intVal(b);
            }, 0 );

        // Update footer
        $( api.column( 4 ).footer() ).html(
        		
          'Rs'+' '+parseFloat(pageTotal).toFixed(2)
           
        );
        console.log( pageTotal);
        //
        pageTotal = api
        .column( 5 )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
        $( api.column( 5 ).footer() ).html(
    		
      'Rs'+' '+parseFloat(pageTotal).toFixed(2)
       
        );
        console.log( pageTotal);
    //
    pageTotal = api
    .column( 6 )
    .data()
    .reduce( function (a, b) {
        return intVal(a) + intVal(b);
    	}, 0 );

    // Update footer
    $( api.column( 6 ).footer() ).html(
		
    		'Rs'+' '+parseFloat(pageTotal).toFixed(2)
   
    	);
    	console.log( pageTotal);
//
    	
        pageTotal = api
        .column( 7 )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
    $( api.column( 7 ).footer() ).html(
    		
      'Rs'+' '+parseFloat(pageTotal).toFixed(2)
       
    );
    console.log( pageTotal);
		            
		
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
						
				
				{"data": "sr", "width": "3%", "defaultContent": ""},
				{"data": "saleamount", "width": "5%", "defaultContent": ""},
				{"data": "currentcash", "width": "5%", "defaultContent": ""},
				{"data": "cardpayment", "width": "5%", "defaultContent": ""},
				{"data": 'googlepaypayment', "width": "5%", "defaultContent": ""},
				{"data": "phonpepayment", "width": "5%", "defaultContent": ""},
				{"data": "paytmpayment", "width": "5%", "defaultContent": ""},
				{"data": "otherpayment", "width": "5%", "defaultContent": ""},
				{"data": "todaysdate", "width": "5%", "defaultContent": ""}
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Todays Sale Wise";
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