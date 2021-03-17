function getWaiterReportJoiningDateWise(){
	
var params= {};
	
	params["methodName"] = "getWaiterReportJoiningDateWise";

	$.post('/RMS/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#catName').dataTable().fnClearTable();
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		$(document).ready(function() {
		 var total =   $('#catName').DataTable( {
			 
			 dom: 'Bfrtip',
	         buttons: [
	             'copy', 'csv', 'excel', 'pdf', 'print'
	         ],
			 
			 fnRowCallback : function(nRow, aData, iDisplayIndex){
	                $("th:first", nRow).html(iDisplayIndex +1);
	               return nRow;
	            },
			    
	            "sPaginationType": "full_numbers",
		    	destroy: true,
		        searching: true,
		        orderable: true,
		      
		columns: [
		          	{"data": "srNo", "width": "5%", "defaultContent": ""},
		          	{"data": "firstName", "width": "5%", "defaultContent": ""},
		            {"data": "middleName", "width": "5%", "defaultContent": ""},
		            {"data": "lastName", "width": "5%", "defaultContent": ""},
		            {"data": "mobileNo", "width": "5%", "defaultContent": ""},
		            {"data": "emailId", "width": "5%", "defaultContent": ""},
		            {"data": "dob", "width": "5%", "defaultContent": ""},
		            {"data": "joiningDate", "width": "5%", "defaultContent": ""},
		            {"data": "salary", "width": "5%", "defaultContent": ""},
		            {"data": "address", "width": "5%", "defaultContent": ""},
		            {"data": "city", "width": "5%", "defaultContent": ""},
		            {"data": "zip", "width": "5%", "defaultContent": ""},
		            {"data": "state", "width": "5%", "defaultContent": ""},
		            
		        ],
		      
		    } );
		} );
		
	var mydata = catmap;
	$('#catName').dataTable().fnAddData(mydata);
	
		}

	);
	
	
}