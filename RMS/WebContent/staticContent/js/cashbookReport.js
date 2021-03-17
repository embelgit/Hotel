function getpaymentDateWiseReport(){
	if(document.cashbooktableDate.cashbookDate.value =="")
	{
		alert("Please Selct Payment Date");
		return false;
	}
	getpaymentDateWiseReport1(); 
}
var listcount=0;
function getpaymentDateWiseReport1(){
	
	var params= {};
	
	var cashbookDate= $('#cashbookDate').val();
	params["cashbookDate"] = cashbookDate;
		
		params["methodName"] = "getpaymentDateWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected date ");
				return false;
			}
			
			/*var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=2){
				alert("No Data For Selected Date!!!")
				listcount=0;
				return false;
			}*/
			
			$(document).ready(function() {
			 var total =   $('#catName').DataTable( {
				 
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
			
				{"data": "transID", "width": "5%", "defaultContent": ""},
				{"data": "payToId", "width": "5%", "defaultContent": ""},
				{"data": "toPayNameId", "width": "5%", "defaultContent": ""},
				{"data": "paymentTypeId", "width": "5%", "defaultContent": ""},
				{"data": 'paymebtById', "width": "5%", "defaultContent": ""},
				{"data": "paymentAmountId", "width": "5%", "defaultContent": ""},
				{"data": "payingAmountId", "width": "5%","defaultContent": ""},
				{"data": "remainingBalance", "width": "5%", "defaultContent": ""},
				{"data": "paymentDate1", "width": "5%", "defaultContent": ""}		
				
		
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Order Bill Report Date Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}
// range wise supplier
function getpaymentRangeWiseReport(){
	if(document.cashbooksupplierrange.datefrom.value =="")
	{
		alert("Please Selct Payment Date");
		return false;
	}
	if(document.cashbooksupplierrange.dateto.value =="")
	{
		alert("Please Selct Payment Date");
		return false;
	}
	getpaymentRangeWiseReport1(); 
}
var listcount=0;
function getpaymentRangeWiseReport1(){
	
	var params= {};
	
	var datefrom= $('#datefrom').val();
	var dateto = $('#dateto').val();
	params['dateto'] = dateto;
	params["datefrom"] = datefrom;
		
		params["methodName"] = "getpaymentRangeWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName2').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected date ");
				return false;
			}
			
			/*var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=2){
				alert("No Data For Selected Date!!!")
				listcount=0;
				return false;
			}*/
			
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
			
				{"data": "transID", "width": "5%", "defaultContent": ""},
				{"data": "payToId", "width": "5%", "defaultContent": ""},
				{"data": "toPayNameId", "width": "5%", "defaultContent": ""},
				{"data": "paymentTypeId", "width": "5%", "defaultContent": ""},
				{"data": 'paymebtById', "width": "5%", "defaultContent": ""},
				{"data": "paymentAmountId", "width": "5%", "defaultContent": ""},
				{"data": "payingAmountId", "width": "5%","defaultContent": ""},
				{"data": "remainingBalance", "width": "5%", "defaultContent": ""},
				{"data": "paymentDate1", "width": "5%", "defaultContent": ""}		
				
		
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Order Bill Report Date Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName2').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}

// supplier name wise

function getpaymentsupplierReport(){
	if(document.cashbooksupplier.cashbooksupp.value =="")
	{
		alert("Please Selct Supplier name ");
		return false;
	}
	getpaymentsupplierReport1(); 
}
var listcount=0;
function getpaymentsupplierReport1(){
	
	var params= {};
	
	var cashbooksupp= $('#cashbooksupp').val();
	params["cashbooksupp"] = cashbooksupp;
		
		params["methodName"] = "getpaymentsupplierReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName1').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected supplier");
				return false;
			}
			
			/*var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=2){
				alert("No Data For Selected Date!!!")
				listcount=0;
				return false;
			}*/
			
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
				{"data": "transID", "width": "5%", "defaultContent": ""},
				{"data": "payToId", "width": "5%", "defaultContent": ""},
				{"data": "toPayNameId", "width": "5%", "defaultContent": ""},
				{"data": "paymentTypeId", "width": "5%", "defaultContent": ""},
				{"data": 'paymebtById', "width": "5%", "defaultContent": ""},
				{"data": "paymentAmountId", "width": "5%", "defaultContent": ""},
				{"data": "payingAmountId", "width": "5%","defaultContent": ""},
				{"data": "remainingBalance", "width": "5%", "defaultContent": ""},
				{"data": "paymentDate1", "width": "5%", "defaultContent": ""}
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Order Bill Report Date Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName1').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}

// employee  date
function getemppaymentDateWiseReport(){
	if(document.cashbookempDate.cashbookempDate.value =="")
	{
		alert("Please Selct Payment Date");
		return false;
	}
	getemppaymentDateWiseReport1(); 
}
var listcount=0;
function getemppaymentDateWiseReport1(){
	
	var params= {};
	
	var cashbookempDate= $('#cashbookempDate').val();
	params["cashbookempDate"] = cashbookempDate;
		
		params["methodName"] = "getEmppaymentDateWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName5').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected date ");
				return false;
			}
			
			/*var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=2){
				alert("No Data For Selected Date!!!")
				listcount=0;
				return false;
			}*/
			
			$(document).ready(function() {
			 var total =   $('#catName5').DataTable( {
				 
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
	       
            
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
			
				{"data": "payToId", "width": "5%", "defaultContent": ""},
				{"data": "toPayNameId", "width": "5%", "defaultContent": ""},
				{"data": "paymentTypeId", "width": "5%", "defaultContent": ""},
				{"data": 'paymebtById', "width": "5%", "defaultContent": ""},
				{"data": "paymentAmountId", "width": "5%", "defaultContent": ""},
				{"data": "payingAmountId", "width": "5%","defaultContent": ""},
				{"data": "remainingBalance", "width": "5%", "defaultContent": ""}
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Order Bill Report Date Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName5').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}


// emp payment emp wise

function getemppaymentSuppWiseReport(){
	if(document.cashbookemployee.cashbookemp.value =="")
	{
		alert("Please Selct Payment Date");
		return false;
	}
	getemppaymentSuppWiseReport1(); 
}
var listcount=0;
function getemppaymentSuppWiseReport1(){
	
	var params= {};
	
	var cashbookemp= $('#cashbookemp').val();
	params["cashbookemp"] = cashbookemp;
		
		params["methodName"] = "getEmppaymentSuppWiseReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName6').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected date ");
				return false;
			}
			
			/*var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=2){
				alert("No Data For Selected Date!!!")
				listcount=0;
				return false;
			}*/
			
			$(document).ready(function() {
			 var total =   $('#catName6').DataTable( {
				 
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
            
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
			
				{"data": "payToId", "width": "5%", "defaultContent": ""},
				{"data": "toPayNameId", "width": "5%", "defaultContent": ""},
				{"data": "paymentTypeId", "width": "5%", "defaultContent": ""},
				{"data": 'paymebtById', "width": "5%", "defaultContent": ""},
				{"data": "paymentAmountId", "width": "5%", "defaultContent": ""},
				{"data": "payingAmountId", "width": "5%","defaultContent": ""},
				{"data": "remainingBalance", "width": "5%", "defaultContent": ""}
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Order Bill Report Date Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName6').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}
// emp rangewise
function getpaymentRangeWiseReportemp10(){
	if(document.cashbookemployeee1.datefromm.value =="")
	{
		alert("Please Selct Payment Date");
		return false;
	}
	if(document.cashbookemployeee1.datetoo.value =="")
	{
		alert("Please Selct Payment Date");
		return false;
	}
	getpaymentRangeWiseReportemp1(); 
}
var listcount=0;
function getpaymentRangeWiseReportemp1(){
	
	var params= {};
	var datefrom  = $('#datefromm').val();
	var dateto= $('#datetoo').val();
	params["datefrom"] = datefrom;
	params["dateto"] = dateto;	
		params["methodName"] = "getEmppaymentSuppRangeWiseReport1";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName7').dataTable().fnClearTable();
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			if(catmap == null || catmap == ""){
				alert("No date available for the selected date ");
				return false;
			}
			
			/*var size=Object.keys(catmap).length
			if(size==0){
				listcount++;
			}
			
			if(listcount>=2){
				alert("No Data For Selected Date!!!")
				listcount=0;
				return false;
			}*/
			
			$(document).ready(function() {
			 var total =   $('#catName7').DataTable( {
				 
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
            
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
			
				{"data": "payToId", "width": "5%", "defaultContent": ""},
				{"data": "toPayNameId", "width": "5%", "defaultContent": ""},
				{"data": "paymentTypeId", "width": "5%", "defaultContent": ""},
				{"data": 'paymebtById', "width": "5%", "defaultContent": ""},
				{"data": "paymentAmountId", "width": "5%", "defaultContent": ""},
				{"data": "payingAmountId", "width": "5%","defaultContent": ""},
				{"data": "remainingBalance", "width": "5%", "defaultContent": ""}
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Order Bill Report Date Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName7').dataTable().fnAddData(mydata);
		
			}

		);
		
		
	}
