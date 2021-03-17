function goodsReieve(){
	
			var params= {};

		params["methodName"] = "getlistgoodsRecieve";
		
		$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
		{

			$('#list5').dataTable().fnClearTable();
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
		/*	$(document).ready(function() {
				var total =   $('#list').DataTable({
				fnRowCallback : function(nRow, aData, iDisplayIndex)
				{		
					$("th:first", nRow).html(iDisplayIndex +1);
					return nRow;
				},
				  
						"columnDefs": [ {
					    "targets": 5,
					    "createdCell": function (td, cellData, rowData, row, col)
					    {
					      if(cellData < 10)
					      {
					    	$(td).css('color', 'red')
					        $(td).css('font-weight', '700')
					      }
					    }
					  } ],			
					
					 "footerCallback": function ( row, data, start, end, display ) {
				            var api = this.api(), data;
				            // Remove the formatting to get integer data for summation
				            var intVal = function ( i ) {
				                return typeof i === 'string' ?
				                    i.replace(/[\$,]/g, '')*1 :
				                    typeof i === 'number' ?
				                        i : 0;
				            };
				            
				            // Total over this page
				            pageTotal = api
				                .column( 7 )
				                .data()
				                .reduce( function (a, b) {
				                    return intVal(a) + intVal(b);
				                }, 0 );
				 
				         
				            // Update footer
				            $( api.column( 7 ).footer() ).html(
				            		 str = pageTotal.toFixed(2)
				            );
				            console.log( pageTotal);
							            
				        },

					"sPaginationType": "full_numbers",
					destroy: true,
					searching: true,
					orderable: true, */
					
			$(document).ready(function() {
				 var total =   $('#list5').DataTable( {
					 
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
		                .column( 8 )
		                .data()
		                .reduce( function (a, b) {
		                    return intVal(a) + intVal(b);
		                }, 0 );
		 
		            // Update footer
		            $( api.column( 8 ).footer() ).html(
		            		
		              'Rs'+' '+parseFloat(pageTotal).toFixed(2)
		               
		            );
		            console.log( pageTotal);
			            },       
			           
		 
			            "sPaginationType": "full_numbers",
				    	destroy: true,
				        searching: true,
				        orderable: true,
			
			
					columns: [
					          {"data": "suplierName", "width": "5%"},
					          {"data": "billno", "width": "5%"},
					          {"data": "fk_item_id_drop1", "width": "5%"},
					          {"data": "buyPrice", "width": "5%"},
					          {"data": "sale_Price", "width": "5%"},
					          {"data": "quantity", "width": "5%"},
					          {"data": "gst", "width": "5%"},
					          {"data": "grossTotal", "width": "5%"},
					          {"data": "goodsReceiveDate", "width": "5%"}
					          
					          ],
					          dom : 'Bfrtip',
					          buttons : [ 
					                     { extend: 'copyHtml5', footer: true },
					                     { extend: 'excelHtml5', footer: true },
					                     { extend: 'csvHtml5', footer: true },
					                     { extend : 'pdfHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Current Stock Report";
					                    	 },
					                    	 orientation : 'landscape',
					                    	 pageSize : 'LEGAL',
					                    	 titleAttr : 'PDF' 
					                     } ]
					                    
				} );
			} );
			var mydata = catmap;
			$('#list5').dataTable().fnAddData(mydata);
				}
		);
	
	
}