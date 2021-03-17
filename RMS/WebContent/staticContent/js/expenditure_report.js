function getexpenditureReport(){
	if(document.expenditurereport1.fkexpenditurename.value =="")
	{
		alert("Please Selct expenditure name");
		return false;
	}
	getexpenditureReport1(); 
}
var listcount=0;
function getexpenditureReport1(){
	
	var params= {};
	var input = document.getElementById('fkexpenditurename'),
    list = document.getElementById('fkexpenditurename_drop'),
    i,fk_exp_id;
	for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input.value) {
    	fk_exp_id = list.options[i].getAttribute('data-value');
    }
}
	var expenid = fk_exp_id;
	var fkexpenditurename= $('#fkexpenditurename').val();
	
	params["expenid"] = expenid;
	params["fkexpenditurename"] = fkexpenditurename;
		
		params["methodName"] = "getexpenditurenameReport";

		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
				{
			
			$('#catName1').dataTable().fnClearTable();
			
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
		            
		 /*           pageTotal = api
	                .column( 8 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 8 ).footer() ).html(
	            		
	              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
	               
	            );
	            console.log( pageTotal);*/
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
						
				
				{"data": "sr", "width": "5%", "defaultContent": ""},
				{"data": "expenditurename", "width": "5%", "defaultContent": ""},
				{"data": "expenditureamount", "width": "5%", "defaultContent": ""},
				{"data": "paymentById", "width": "5%", "defaultContent": ""},
				{"data": 'paymentdate', "width": "5%", "defaultContent": ""},
				{"data": "cardNoId", "width": "5%", "defaultContent": ""},
				{"data": "chequeNoId", "width": "5%", "defaultContent": ""},
				{"data": "chequeDateId", "width": "5%", "defaultContent": ""},
				{"data": "neftAccNoId", "width": "5%", "defaultContent": ""}
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Expenditure Name Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName1').dataTable().fnAddData(mydata);
		document.getElementById("fkexpenditurename").value = "";
			}

		);
		
		
	}

//date wise

function getexpDateWiseReport(){
	if(document.expenditurereport2.expdatee.value =="")
	{
		alert("Please Selct expenditure date");
		return false;
	}
	getexpDateWiseReport1(); 
}
var listcount=0;
function getexpDateWiseReport1(){
	
	var params= {};
	

	var expdate= $('#expdatee').val();
	
	
	params["expdate"] = expdate;
		
		params["methodName"] = "getexpDateWiseReport";

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
		            
		
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
						
				
				{"data": "sr", "width": "5%", "defaultContent": ""},
				{"data": "expenditurename", "width": "5%", "defaultContent": ""},
				{"data": "expenditureamount", "width": "5%", "defaultContent": ""},
				{"data": "paymentById", "width": "5%", "defaultContent": ""},
				{"data": 'paymentdate', "width": "5%", "defaultContent": ""},
				{"data": "cardNoId", "width": "5%", "defaultContent": ""},
				{"data": "chequeNoId", "width": "5%", "defaultContent": ""},
				{"data": "chequeDateId", "width": "5%", "defaultContent": ""},
				{"data": "neftAccNoId", "width": "5%", "defaultContent": ""}
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Expenditure Name Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName2').dataTable().fnAddData(mydata);
		document.getElementById("expdatee").value = "";
			}

		);
		
		
	}

// range wise

function getexprangeWiseReport(){
	if(document.expenditurereport3.rangefrm.value =="")
	{
		alert("Please Selct expenditure date from");
		return false;
	}
	if(document.expenditurereport3.rangeto.value =="")
	{
		alert("Please Selct expenditure date to");
		return false;
	}
	getexprangeWiseReport1(); 
}
var listcount=0;
function getexprangeWiseReport1(){
	
	var params= {};
	

	var rangefrm= $('#rangefrm').val();
	var rangeto = $('#rangeto').val();
	
	params["rangefrm"] = rangefrm;
	params["rangeto"] = rangeto;
	
		params["methodName"] = "getexpRangeWiseReport";

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
		            
		
		            }, 
		            
		            
		            "sPaginationType": "full_numbers",
			    	destroy: true,
			        searching: true,
			        orderable: true,
			        
			      
			columns: [
						
				
				{"data": "sr", "width": "5%", "defaultContent": ""},
				{"data": "expenditurename", "width": "5%", "defaultContent": ""},
				{"data": "expenditureamount", "width": "5%", "defaultContent": ""},
				{"data": "paymentById", "width": "5%", "defaultContent": ""},
				{"data": 'paymentdate', "width": "5%", "defaultContent": ""},
				{"data": "cardNoId", "width": "5%", "defaultContent": ""},
				{"data": "chequeNoId", "width": "5%", "defaultContent": ""},
				{"data": "chequeDateId", "width": "5%", "defaultContent": ""},
				{"data": "neftAccNoId", "width": "5%", "defaultContent": ""}
				
			        ],
			        dom : 'Bfrtip',
			          buttons : [ 

			                     { extend: 'copyHtml5', footer: true },
			                     { extend: 'excelHtml5', footer: true },
			                     { extend: 'csvHtml5', footer: true },
			                     { extend : 'pdfHtml5', footer: true,
			                    	 title : function() {
			                    		 return "Expenditure Name Wise";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     } ]  
			      
			    } );
			} );
			
		var mydata = catmap;
		$('#catName3').dataTable().fnAddData(mydata);
		document.getElementById("rangefrm").value = "";
		document.getElementById("rangeto").value = "";
		
			}

		);
		
		
	}