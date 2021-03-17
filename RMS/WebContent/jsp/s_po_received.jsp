
<%@page import="com.rms.hibernate.SupplierDetail"%>
<%@page import="com.rms.helper.SupplierDetailHelper"%>
<%@page import="java.util.List"%>

<% boolean isHome=false;%>
<%@include file="common/header.jsp"%>

<script type="text/javascript">
	
	 function grasstotal1(){
			
			var total = document.getElementById("resolution1").value;           
			var extraDiscount = document.getElementById("extraDiscount").value;
			var disAmount =  (extraDiscount/100)*total;
			var gross = +total - +disAmount;
			document.getElementById("resolution").value = Math.round(gross);
    }


    function grasstotal(){
    var extraDiscount = document.getElementById("extraDiscount").value;
    var total = document.getElementById("resolution1").value;
    if(extraDiscount != ""){
    	var disAmount =  (extraDiscount/100)*total;
		var gross = +total - +disAmount;
		var total = Math.round(gross);
		var expence = document.getElementById("expence").value;
		var gross = +total + +expence;
		
		document.getElementById("resolution").value = gross;
    	
    }else{       
    	var expence = document.getElementById("expence").value;
    	var gross = +total + +expence;
    	
    	document.getElementById("resolution").value = gross;
    }
	
    }

</script>
<script type="text/javascript">
	var profiles =
	{

		windowCenter:
		{
			height:550,
			width:660,
			status:1,
			center:1
			
		},
};
	$(function()
	{
   		$(".popupwindow").popupwindow(profiles);
   	});
	
	
	</script>


<script src="/RMS/staticContent/js/jquery-1.12.3.min.js"></script>
<link rel="stylesheet" href="/RMS/staticContent/y_css/ui.jqgrid.min.css">
<link rel="stylesheet" href="/RMS/staticContent/y_css/jquery-ui.css">
<link rel="stylesheet" href="/RMS/staticContent/y_css/ui.jqgrid.css">
<script src="/RMS/staticContent/js/jquery-ui.min.js"></script>
<script src="/RMS/staticContent/js/jquery-ui.js"></script>
<script src="/RMS/staticContent/js/jqueryUi.js"></script>
<script src="/RMS/staticContent/js/jquery.jqgrid.min.js"></script>
<script src="/RMS/staticContent/js/jquery.popupwindow.js"></script>

<script src="/RMS/staticContent/js/newgoodsreceived.js"></script>
<script src="/RMS/staticContent/js/bootstrap.min.js"></script>

<body class="purchase_form_img">
	<div class="container-fluid">

		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading">Purchase Goods Received</h2>
			</div>
		</div>

		<div class="row">
			<div class="form-group" align="right">
				<div class="col-sm-offset-6 col-md-5 control-label">
					<div id="date">
						<label id="demo"></label>
						<script>
							var date = new Date();
							document.getElementById("demo").innerHTML = date
									.toDateString();
						</script>
					</div>
				</div>
			</div>
		</div>

		<div id="myDialogBox" title="My Dialog Box">
			<div id="myContentLayer">
				<p></p>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-offset-1 col-md-10">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

		<form action="goods" method="post" name="good" class="form-horizontal">

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="center">
						<label class="control-label">Bill No:<sup
							style="color: red;">*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id="billNo" id="jander" name="billNo"
								autofocus="autofocus" class="form-control" placeholder="Bill No" />
						</div>
					</div>

					<div class="col-sm-2" align="center">
						<label class="control-label">Supplier Name:<sup
							style="color: red;">*</sup>
						</label>
					</div>
					<div class="col-sm-3">
						<%
							SupplierDetailHelper poHelper = new SupplierDetailHelper();
							List supplierList = poHelper.getAllSuppliers();
						%>

						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input list="supplierId_drop" id="supplierId"
								class="form-control">
							<datalist id="supplierId_drop">
								<%
							for(int i =0 ;i<supplierList.size();i++)
								{
								SupplierDetail supplier = (SupplierDetail)supplierList.get(i);
						%>
								<option data-value="<%=supplier.getSupplierId()%>"
									value="<%=supplier.getSupplierName()%>">
									<%   	
								}	
						%>
								
							</datalist>

						</div>
					</div>
				</div>
			</div>




			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="center">
						<label class="control-label">Contact Person:<sup
							style="color: red;">*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='contactPerson' name="contactPerson"
								class="form-control" placeholder="Contact Person" />
						</div>
					</div>

					<div class="col-sm-2" align="center">
						<label class="control-label">Purchase Date:<sup
							style="color: red;">*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="date" id='pDate' name="pDate" class="form-control"
								id="jander" placeholder="Purchase Date" />
						</div>
					</div>

					<!--  <div class="col-sm-2" align="center">
						<label class="control-label">Vat:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='vat' name="vat"
								 class="form-control" placeholder="Vat" />
						</div>
					</div>
					 -->
				</div>
			</div>

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="center">
						<label class="control-label" for="billType">Type:<sup
							style="color: red;">*</sup></label>
					</div>
					<div class="col-sm-4">
						<div class="col-md-4 col-xs-6 ">
							<label class="radio-inline"> <input type="radio"
								name="car" value="Gst" id="gst" checked>
							<h4 style="margin-top: 0px;">GST</h4>
							</label>
						</div>
						<div class="col-md-6 col-xs-6 col-md-ffset-1 ">
							<label class="radio-inline"> <input type="radio"
								name="car" value="noGst" id="nogst">
							<h4 style="margin-top: 0px;">No GST</h4>
							</label>
						</div>
					</div>
				</div>

				<%-- <div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="center">
						<label class="control-label">Item List:<sup style="color: red;">*</sup></label>
					</div>
					<div class="col-sm-5">
					
					    <%
					    ProductDetailHelper item = new ProductDetailHelper();
						List itemList = item.getAllItemName();
						%>
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
								</span>
								<input list="itemId_drop" id="itemName" class="form-control" onchange="getProductList()" >
						        <datalist id="itemId_drop">
						       <%
							      for(int j =0 ;j<itemList.size();j++)
								{
							    	  ProductNameBean itm = (ProductNameBean)itemList.get(j);
						       %>
							       <option data-value="<%=itm.getCaregoryName()%>" value="<%=itm.getCaregoryName()%> :::>>> <%=itm.getItemName()%>" myvalue="<%=itm.getItemName()%>" myvalue1="<%=itm.getHsnsacno()%>" myvalue2="<%=itm.getProductid()%>" myvalue3="<%=itm.getColor()%>"  myvalue4="<%=itm.getSize()%>" myvalue5="<%=itm.getFkCatId()%>"> 
						      <%   	
								}	
						       %>
						</datalist>
							
						</div>
					</div>

					
				</div>
			</div> --%>

				<!-- <div id ="jqSubGrid" class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="table-responsive">
							<table id="jqGrid"></table>
			                <div id="jqGridPager"></div>
						</div>
					</div>
				</div> -->

				<div class="row">

					<div class="col-sm-10 col-sm-offset-1">
						<div class="table-responsive">
							<table id="jqGrid"></table>
							<div id="jqGridPager">
								<!-- <a href="#" class="btn btn-primary btn-sm" role="button" data-toggle="modal" data-target="#login-modal">+</a> -->
							</div>
						</div>
					</div>

					<!-- <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    				<div class="modal-dialog">
						<div class="modal-content">
		                
        			      		Begin # Login Form
                    			
		            				<div class="col-sm-10 col-sm-offset-1">
										<div class="table-responsive">
											<table id="jqGrid1"></table>
			                				<div id="jqGridPager1">  </div>
										</div>
									</div>
                    			
                    		End # Login Form
							</div>
                		
					</div>
				</div> -->
				</div>


			</div>

			<div class="row row_margin">
				<div class="form-group">
					<div class="col-sm-1 col-sm-offset-1" align="center">
						<label class="control-label">Total Quantity:</label>
					</div>

					<div class="col-sm-2">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='totalQuantity' name="totalQuantity"
								class="text-border form-control" placeholder="Total Quantity"
								style="background-color: rgba(251, 243, 0, 0.27)" id="jander" />
						</div>
					</div>


					<div class="col-sm-1" align="center">
						<label class="control-label">Total GST:</label>
					</div>

					<div class="col-sm-2">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='totalGst' name="totalGst"
								class="text-border form-control" placeholder="Total Gst"
								style="background-color: rgba(251, 243, 0, 0.27)" id="jander" />
						</div>
					</div>

					<div class="col-sm-2" align="center">
						<label class="control-label">Total IGST:</label>
					</div>
					<div class="col-sm-2">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='totalIgst' name="totalIgst"
								class="text-border form-control" placeholder="Total Igst"
								style="background-color: rgba(251, 243, 0, 0.27)" id="jander" />
						</div>
					</div>

				</div>
			</div>

			<div class="row row_margin">
				<div class="form-group">
					<div class="col-sm-1 col-sm-offset-1" align="center">
						<label class="control-label">Total Discount:</label>
					</div>

					<div class="col-sm-2">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='extraDiscount' name="extraDiscount"
								class="text-border form-control" placeholder="In %" autofocus
								onkeyup="grasstotal1(); return false;"
								style="background-color: rgba(251, 243, 0, 0.27)" id="jander" />
						</div>
					</div>


					<div class="col-sm-1" align="center">
						<label class="control-label">Expenses:</label>
					</div>

					<div class="col-sm-2">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='expence' name="expence"
								class="text-border form-control" placeholder="Expenses"
								autofocus onchange="grasstotal(); return false;"
								style="background-color: rgba(251, 243, 0, 0.27)" id="jander" />
						</div>
					</div>

					<div class="col-sm-2" align="center">
						<label class="control-label" style="font-size: 30px">Total:</label>
					</div>
					<div class="col-sm-2">
						<div class="input-group">
							<input type="text" name="resolution" id="resolution"
								readonly="readonly" class="form-group"
								style="font-size: 30px; float: right; width: 200px; height: 50px; background-color: rgba(251, 243, 0, 0.27);" />
							<input type="hidden" id='resolution1' name="resolution1"
								class="form-control" />
						</div>
					</div>

				</div>
			</div>

			<div class="row buttons_margin_top">
				<div align="center">
					<input type="button"
						class="btn btn-lg btn-success btn-md button_hw button_margin_right"
						name="btn" id="btnSubmit" onclick="validateRegGoodReceive()"
						value="Register" /> <input type="reset" value="Cancel"
						onclick="window.location.reload()" name="btn1"
						class="btn btn-lg btn-danger btn-md button_hw button_margin_right" />
				</div>
			</div>

		</form>

		<div class="row footer_margin_top" align="center">
			<%@include file="common/newFooter.jsp"%>
		</div>

	</div>
</body>
</html>

