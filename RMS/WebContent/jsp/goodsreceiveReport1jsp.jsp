<%@page import="java.util.List"%>
<%@page import="com.rms.dao.ItemEntryDao"%>
<%@page import="com.rms.dao.GoodsReceiveDao" %>
<%@page import="com.rms.hibernate.GoodsReceiveHibernate" %>
<%@page import="com.rms.hibernate.ItemEntry"%>
<% boolean isHome=false;%>
 <%@include file="common/header.jsp"%> 
<head>
<title>Good Receive Report</title>
		<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
		<script src="/RMS/staticContent/shree/jquery.dataTables.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/dataTables.buttons.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/buttons.flash.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/jszip.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/pdfmake.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/vfs_fonts.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/buttons.html5.min.js" type="text/javascript"></script>
		<script src="/RMS/staticContent/shree/buttons.print.min.js" type="text/javascript"></script>
		<link href="/RMS/staticContent/y_css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/RMS/staticContent/y_css/buttons.dataTables.min.css" rel="stylesheet" type="text/css" media="all">
		<link rel="stylesheet" href="/RMS/staticContent/css/bootstrap.min.css">
		<script src="/RMS/staticContent/js/bootstrap.min.js"></script>
		<script src="/RMS/staticContent/js/bootstrap.js"></script>
		<link rel="stylesheet" href="/RMS/staticContent/css/style.css">
		
		<script src="/RMS/staticContent/js/goodsReceiveReport.js"></script>

<!-- <script>
	     $(document).ready(function(){
	    	 getGoodsReceiveReport();
	}); 
	</script> -->


<!-- 					<script type="text/javascript"> 
		$(document).ready(function () {
			var table=$("#catName").dataTable({
				
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
			 
			            // Total over all pages
			            total = api
			                .column( 7 )
			                .data()
			                .reduce( function (a, b) {
			                    return intVal(a) + intVal(b);
			                }, 0 ); 
			 			console.log(total); 
			 			
			 		
			            // Update footer
			            $( api.column( 7 ).footer() ).html(
			                'Rs'+' '+total
			            );
			            console.log( total);
			            
			         // Total over all pages
			            total = api
			                .column( 8 )
			                .data()
			                .reduce( function (a, b) {
			                    return intVal(a) + intVal(b);
			                }, 0 ); 
			 			console.log(total); 
			 			
			 		
			            // Update footer
			            $( api.column( 8 ).footer() ).html(
			                'Rs'+' '+total
			            );
			            console.log( total);
			            
			         // Total over all pages
			          /*   total = api
			                .column( 11 )
			                .data()
			                .reduce( function (a, b) {
			                    return intVal(a) + intVal(b);
			                }, 0 ); 
			 			console.log(total); 
			 			
			 		
			            // Update footer
			            $( api.column( 11 ).footer() ).html(
			                'Rs'+' '+total
			            );
			            console.log( total); */
			            
			            
			            
			    }
			
			
			
				
			});
	         var table=$("#catName").dataTable();
			  var tableTools = new $.fn.dataTable.TableTools(table, {
				 'sSwfPath':'//cdn.datatables.net/tabletools/2.2.4/swf/copy_csv_xls_pdf.swf',
				 	'aButtons':['copy','print','csv',{
					 'sExtends':'xls',
					 'sFileName':'Data.xls',
					 'sButtonText': 'Save to Excel'
						}
					]
				}); 
			//		$(tableTools.fnContainer()).insertBefore('#catName_wrapper');
			});

		</script>
 -->

	<!-- 				<script type="text/javascript"> 
		$(document).ready(function () {
			var table=$("#catName").dataTable({
				
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
			 
			            // Total over all pages
			            total = api
			                .column( 7 )
			                .data()
			                .reduce( function (a, b) {
			                    return intVal(a) + intVal(b);
			                }, 0 ); 
			 			console.log(total); 
			 			
			 		
			            // Update footer
			            $( api.column( 7 ).footer() ).html(
			                'Rs'+' '+total
			            );
			            console.log( total);
			            
			         // Total over all pages
			            total = api
			                .column( 8 )
			                .data()
			                .reduce( function (a, b) {
			                    return intVal(a) + intVal(b);
			                }, 0 ); 
			 			console.log(total); 
			 			
			 		
			            // Update footer
			            $( api.column( 8 ).footer() ).html(
			                'Rs'+' '+total
			            );
			            console.log( total);
			            
			         // Total over all pages
			        
			            
			            
			            
			    },
			    
			
			
				
			});
	         var table=$("#catName").dataTable();
			 var tableTools = new $.fn.dataTable.TableTools(table, {
				 'sSwfPath':'//cdn.datatables.net/tabletools/2.2.4/swf/copy_csv_xls_pdf.swf',
				 	'aButtons':['copy','print','csv',{
					 'sExtends':'xls',
					 'sFileName':'Data.xls',
					 'sButtonText': 'Save to Excel'
						}
					]
				});
					$(tableTools.fnContainer()).insertBefore('#catName_wrapper');
			});
	</script>
 -->


</head>
<body id="dt_example" class="master_form_img">
	<div class="container-fluid">

		<div class="row header_margin_top" style="margin-top: 10px;">
			<div align="center">
				<h2 class="form-name style_heading">Goods Receive Report</h2>
			</div>
		</div>

		<div class="row">
			<div class="form-group" align="right">
				<div class="col-sm-offset-8 col-md-4 control-label">
					<div id="date">
						<label id="demo"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>
			<form action="#" method="post" name="OrderBilltableDate" class="form-horizontal">
			
			<div class="row">
			<div class="form-group">
				<div class="col-md-2 col-sm-offset-1" align="right">
					<label class="control-label">Good Receive Date:<sup>*</sup></label>
				</div>
				<div class="col-sm-3">
					<div class="input-group">
						<span class="input-group-addon"> 
						<i class="glyphicon glyphicon-calendar"></i>
						</span> 
						<input type="date" id='orderBillDate' name="orderBillDate" class="form-control" placeholder="Enter order Bill Date" />
					</div>
				</div>

			    <div class="col-md-offset-2">
					<input type="button" id="btn" name="save"
						class="btn btn-lg btn-success btn-md button_hw button_margin_left"
						onclick="getgoodReceiveDateWiseReport()" value="Search" />
				</div>
			</div>
		</div>
												
						</div>
				</div>
			

			</div>
			
<!-- 		<div class="row" align="center">
			<div class="responsive"  class="col-md-2 col-sm-offset-1">
				<table class="table table-bordered table-striped table-condensed cf"
					id="catName" class="display"
					style="border: 2px solid black; border-collapse: collapse;">
 -->
 			<div class="table-responsive">
					<table id="catName" class="display" style=" border: 2px solid black; border-collapse: collapse;">
 					<thead>
						<tr>

							<th>Sr No</th>
							<th>Item Name</th>	
							<th>Bill No</th>
							<th>Buy Price</th>
							<th>Sale Price</th>
							<th>Quantity</th>
							<th>GST</th>
							<th>Total</th>
							<th>Gross Total</th>
	

						</tr>
					</thead>
					<!-- <tfoot>
							<tr>
								<th colspan="7" style="text-align: right">Total Rs: </th>
								<th></th>`
								<th></th>
								<th></th>
			
							</tr>
						</tfoot> -->
				</table>
			</div>
			</form>
		</div>
		<!-- </div> -->

	</div>
</body>
</html>
 <%@include file="common/newFooter.jsp"%> 
