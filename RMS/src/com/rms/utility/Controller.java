package com.rms.utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rms.bean.GetStoreManagementDetailBean;
import com.rms.dao.GoodsReceiveDao;
import com.rms.helper.AddWaitersHelper;
import com.rms.helper.BankHelper;
import com.rms.helper.CashBookHelper;
import com.rms.helper.CreateUserHelper;
import com.rms.helper.CustomerD;
import com.rms.helper.CustomerDetailsHelper;
import com.rms.helper.CustomerOrderHelper;
import com.rms.helper.CustomerPaymentHelper;
import com.rms.helper.EmployeeDetailsHelper;
import com.rms.helper.EmployeePaymentHelper;
import com.rms.helper.ExpenditureHelper;
import com.rms.helper.ExpenditurePaymentHelper;
import com.rms.helper.GoodReceiveHelper;
import com.rms.helper.GoodReceivedHelper;
import com.rms.helper.GoodsReceiveHelper;
import com.rms.helper.ItemDetailHelper;
import com.rms.helper.ItemEntryHelper;
import com.rms.helper.KycInfoHelper;
import com.rms.helper.LoginController;
import com.rms.helper.LogoutController;
import com.rms.helper.OrderBillHelper;
import com.rms.helper.PurchaseGoodHelper;
import com.rms.helper.StockEntryHelper;
import com.rms.helper.StockManagementHelper;
import com.rms.helper.SupplierAccountDetailsHelper;
import com.rms.helper.SupplierCashBankHelper;
import com.rms.helper.SupplierDetailHelper;
import com.rms.helper.SupplierDetailsHelper;
import com.rms.helper.TempItemDetailHelper;
import com.rms.helper.TodaySaleHelper;
import com.rms.helper.TransferstockHelper;
import com.rms.helper.WastageFoodsHelper;
import com.rms.helper.WastageGoodsHelper;
import com.rms.helper.hotelnamehelper;
import com.rms.helper.kitchenorderHelper;
import com.rms.helper.tempOrderBill;
import com.rms.helper.tempOrderhelper;

public class Controller
{

	private String toJson(Object data)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting ().disableHtmlEscaping ().create ();
        return gson.toJson(data);
    }
	
	 //Register Create User 
	  public String createUser(HttpServletRequest request , HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  CreateUserHelper createUserHelper = new CreateUserHelper();
		  createUserHelper.userCreate(request, response);
		  return toJson("Data Added Successfully");
	  }
	  
	  // Logout
	// for logout
		public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("In Helper==========");
			LogoutController helper = new LogoutController();
			helper.logoutUser(request, response);
			System.out.println("logged off -- ");
			return toJson("Data Added Successsfully");
		}
		
		
		// For login
		public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
			LoginController helper = new LoginController();
			helper.loginUser(request, response);
			System.out.println("in controller login - ");
		//	return toJson("Data Added Successsfully");
			return toJson("Logged in successfully");
		}

		public String addhotel(HttpServletRequest request, HttpServletResponse response) throws IOException {
			hotelnamehelper helper = new hotelnamehelper();
			helper.addhotel(request, response);
			System.out.println("in controller - ");
		//	return toJson("Data Added Successsfully");
			return toJson("Data Added successfully");
		}
		
		// For language\
		public String language(HttpServletRequest request, HttpServletResponse response) throws IOException {
			LoginController helper = new LoginController();
			helper.language(request, response);
			return toJson("Data Added Successsfully");
		}
	  
	  //feedback 
	  
	  public String feedBackform(HttpServletRequest request , HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  CreateUserHelper createUserHelper = new CreateUserHelper();
		  createUserHelper.feedBackformhelper(request, response);
		  return toJson("Data Added Successfully");
	  }
	  //cashbook
	  public String getTotalAmt(HttpServletRequest request , HttpServletResponse response) {
		
			String supplier = request.getParameter("supplier");
			System.out.println(" in controller - supplier name received is - - "+supplier);
			CashBookHelper helper = new CashBookHelper();
			Map map = helper.getTotalAmtSupplier(supplier, request);
			String xyz = toJson(map);
			System.out.println(xyz);
			return xyz;
	  }
	  // get shop
		public String gethotel(HttpServletRequest request, HttpServletResponse response) {
			
			String uname = request.getParameter("uname");
			System.out.println("IN CONTROLLER usname - "+uname);
			hotelnamehelper catdh = new hotelnamehelper();
			Map map=catdh.gethotel(uname);
			String xyz = toJson(map);
			System.out.println(xyz);
			return xyz;
		}
	  // emp cB
	  public String getEmpTotalAmt(HttpServletRequest request , HttpServletResponse response) {
			
			String employee = request.getParameter("employee");
			System.out.println(" in controller - emp name received is - - "+employee);
			CashBookHelper helper = new CashBookHelper();
			Map map = helper.getEmpTotalAmtSupplier(employee, request);
			String xyz = toJson(map);
			System.out.println(xyz);
			return xyz;
	  }
	  
	  //Order Bill
	  public String orderBills(HttpServletRequest request , HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  OrderBillHelper orderBillHelper = new OrderBillHelper();
		  orderBillHelper.billOrder(request, response);
		  return toJson("Data Added Successfully");
	  }
	  
	//Add Waiter
	  public String addWaiters(HttpServletRequest request , HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  AddWaitersHelper addWaitersHelper = new AddWaitersHelper();
		  addWaitersHelper.waiterDetails(request, response);
		  System.out.println("in add waiter controller ");
		  return toJson("Waiter Added Successfully");
		 
	  }
	  
	//Item Entry
	  public String itemEntrys(HttpServletRequest request , HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  ItemEntryHelper itemEntryHelper = new ItemEntryHelper();
		  itemEntryHelper.entryItem(request, response);
		  return toJson("Data Added Successfully");
	  }
	   
	      // Fetching item entry Details To Edit
			public String getItemEntryDetailsToEdit(HttpServletRequest request,
					HttpServletResponse response) {
				String itemId = request.getParameter("itemId");
				Long pk_item_entry_Id = Long.parseLong(itemId);
				System.out.println("in controller itemId : " + pk_item_entry_Id);
				ItemEntryHelper helper = new ItemEntryHelper();
				Map map = helper.getItemEntryDetailsForEdit(pk_item_entry_Id);
				Map<String, List> returnMap = new HashMap<String, List>();
				String xyz = toJson(map);
				System.out.println(xyz);
				System.out.println("going out of controller");
				return xyz;
			}
			
			// update item entry info details
			public String updateItemEntryDetails(HttpServletRequest request,
					HttpServletResponse response) {
				System.out.println("In controller update item entry Details");
				ItemEntryHelper helper = new ItemEntryHelper();
				helper.updateItemEntryInfoDetail(request, response);
				System.out.println("In controller Update item entry");
				return toJson("Data Updated Successfully");

			}
	  
	//Item Details
	  public String itemDetails(HttpServletRequest request, HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  ItemDetailHelper itemDetailHelper = new ItemDetailHelper();
		  itemDetailHelper.detailItem(request, response);
		  return toJson("Data Added Successfully");
	  }
	  
	  // Fetching item Details To Edit
		public String getItemDetailsToEdit(HttpServletRequest request,HttpServletResponse response) {
			String itemId = request.getParameter("itemId");
			System.out.println("in controller @@@@ @@@@ id @@ -   "+itemId);
			
			Long pk_item_details_id = Long.parseLong(itemId);
			
			System.out.println("in controller itemId : " + pk_item_details_id);
			ItemDetailHelper helper = new ItemDetailHelper();
			
		
			Map map = helper.getItemDetailsForEdit(pk_item_details_id);
			
			Map<String, List> returnMap = new HashMap<String, List>();
			String xyz = toJson(map);
			System.out.println(xyz);
			System.out.println("going out of controller");
			return xyz;
		}
		//get hotel to edit
		public String gethotelToEdit(HttpServletRequest request,HttpServletResponse response) {
			String hotelId = request.getParameter("hotelid");
			System.out.println("in controller @@@@ @@@@ hotel id @@ -   "+hotelId);
			Long pk_hotel_id = Long.parseLong(hotelId);
			System.out.println("in controller hotelId : " +pk_hotel_id);
			hotelnamehelper helper = new hotelnamehelper();
			Map map = helper.gethotelForEdit(pk_hotel_id);
			Map<String, List> returnMap = new HashMap<String, List>();
			String xyz = toJson(map);
			System.out.println(xyz);
			System.out.println("going out of controller");
			return xyz;
		}
		
		//get username pass
	/*	public String getuserDetails(HttpServletRequest request,HttpServletResponse response) {
			String userid = request.getParameter("userid");
			Long user_id = Long.parseLong(userid);			
			
			System.out.println("in controller user_id : " + user_id);
			
			hotelnamehelper helper = new hotelnamehelper();
			Map map = helper.getuserDetails(user_id);
			
			Map<String, List> returnMap = new HashMap<String, List>();
			String xyz = toJson(map);
			System.out.println("Data - "+xyz);
			System.out.println("going out of controller");
			return xyz;
	
		}*/
		  public String getuserDetails(HttpServletRequest request , HttpServletResponse response) {
				
			  String userid = request.getParameter("userid");
				Long user_id = Long.parseLong(userid);
				System.out.println("in controller user_id : " + user_id);
				
				hotelnamehelper helper = new hotelnamehelper();
				Map map = helper.getuserDetails(user_id);
				Map<String, List> returnmap = new HashMap<String, List>();
				String xyz = toJson(map);
				
				System.out.println("Data - "+xyz);
				System.out.println("going out of controller");
				return xyz;
		  }
		
		
		
		
		public String getEmployee(HttpServletRequest request , HttpServletResponse response)
		{
			
			
			//String empid= request.getParameter("empid");
			//String subCatID=request.getParameter("subCatId");
			EmployeeDetailsHelper helper=new EmployeeDetailsHelper();
			List leafcat = helper.getEmployee();
			String aa=toJson(leafcat);
			System.out.println("emplyee nme- "+aa);
			return aa;
		}
		
		
	/*This getSupplier() used to get supplier names in cashbook when user payment to supplier*/
		
		public String getSuppliers(HttpServletRequest request , HttpServletResponse response)
		{
			
			
			//String empid= request.getParameter("empid");
			//String subCatID=request.getParameter("subCatId");
			SupplierDetailsHelper helper=new SupplierDetailsHelper();
			List leafcat = helper.getSuppliers();
			String aa=toJson(leafcat);
			System.out.println("supplier ---  "+aa);
			return aa;
		}
		
		public String addCashBooks(HttpServletRequest request, HttpServletResponse response)
		{
			
			CashBookHelper helper = new CashBookHelper();
			helper.registerCashBookEntry(request, response);
			return toJson("Data Added Successsfully");
		}		
		//bank trans
		public String addbanktransaction(HttpServletRequest request, HttpServletResponse response)
		{
			
			CashBookHelper helper = new CashBookHelper();
			helper.banktransactionEntry(request, response);
			return toJson("Data Added Successsfully");
		}
		//add bank
		public String addbankdetails(HttpServletRequest request, HttpServletResponse response)
		{
			
			CashBookHelper helper = new CashBookHelper();
			helper.addbankdetails(request, response);
			return toJson("Data Added Successsfully");
		}
		//expenditure  pay
		public String addexpenditurepayment(HttpServletRequest request, HttpServletResponse response)
		{
			
			CashBookHelper helper = new CashBookHelper();
			helper.addexpenditurepayment(request, response);
			return toJson("Data Added Successsfully");
		}
		//today sale
		public String addtodaysale(HttpServletRequest request, HttpServletResponse response)
		{
			
			TodaySaleHelper helper = new TodaySaleHelper();
			helper.addtodaytotalsale(request, response);
			return toJson("Data Added Successsfully");
		}
		
		// add expenditure
		public String addexpenditure(HttpServletRequest request, HttpServletResponse response)
		{
			
			CashBookHelper helper = new CashBookHelper();
			helper.addexpenditure(request, response);
			return toJson("Data Added Successsfully");
		}
		
		public String addCashBooksemp(HttpServletRequest request, HttpServletResponse response)
		{
			
			CashBookHelper helper = new CashBookHelper();
			helper.registerCashBookEntryemp(request, response);
			return toJson("Data Added Successsfully");
		}		
		
		// Get Waiter TO Edit
		public String getWaiterDetailsToEdit(HttpServletRequest request,HttpServletResponse response) {
			String itemId = request.getParameter("itemId");
			System.out.println("in controller @ id @@@@  - --  "+itemId);
			
			Long pk_item_details_id = Long.parseLong(itemId);
			
			System.out.println("in controller itemId : " + pk_item_details_id);
			AddWaitersHelper helper = new AddWaitersHelper();
			
		
			Map map = helper.getWaiterForEdit(pk_item_details_id);
			
			Map<String, List> returnMap = new HashMap<String, List>();
			String xyz = toJson(map);
			System.out.println(xyz);
			System.out.println("going out of controller");
			return xyz;
		}
		
		// Get Create User  TO Edit
				public String getCreateDetailsToEdit(HttpServletRequest request,HttpServletResponse response) {
					String itemId = request.getParameter("itemId");
					System.out.println("in controller@@@@@@@@@@@@@@@@@@@@id@@@@@@@@@@@@@@@@@ -- "+itemId);
					
					Long pk_item_details_id = Long.parseLong(itemId);
					
					System.out.println("in controller itemId : " + pk_item_details_id);
					CreateUserHelper helper = new CreateUserHelper();
					
				
					Map map = helper.getCreateUserForEdit(pk_item_details_id);
					
					Map<String, List> returnMap = new HashMap<String, List>();
					String xyz = toJson(map);
					System.out.println(xyz);
					System.out.println("going out of controller");
					return xyz;
				}
		
		// update item details info
		public String updateItemDetails(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("In controller update item Details");
			ItemDetailHelper helper = new ItemDetailHelper();
			helper.updateItemInfoDetail(request, response);
			System.out.println("In controller Update item entry");
			return toJson("Data Updated Successfully");

		}
		
		//update item entry info
		public String updateItemEntrys(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("In controller update Supplier Details");
			ItemDetailHelper helper = new ItemDetailHelper();
			helper.editItemEntry(request, response);
			System.out.println("In controller Updateemployee");
			return toJson("Data Updated Successfully");
		}
		//update hotel
		public String updatehotel(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("In controller update hotelname");
			hotelnamehelper helper = new hotelnamehelper();
			helper.edithotel(request, response);
			System.out.println("In controller Updatehotel");
			return toJson("Data Updated Successfully");
		}
		
		// update waiter Details
		public String updateWaiterEntrys(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("In controller update Supplier Details");
			AddWaitersHelper helper = new AddWaitersHelper();
			helper.editWaiterEntry(request, response);
			System.out.println("In controller Updateemployee");
			return toJson("Data Updated Successfully");
		}
		
		// Update Create User 
		public String updateCreateUSerEntrys(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("In controller update Supplier Details");
			CreateUserHelper helper = new CreateUserHelper();
			helper.editCreateUserEntry(request, response);
			System.out.println("In controller Updateemployee");
			return toJson("Data Updated Successfully");
		}
		
		
		 // Fetching drink Details To Edit
		public String getDrinkDetailsToEdit(HttpServletRequest request,
				HttpServletResponse response) {
			String itemId = request.getParameter("itemId");
			Long pk_item_details_id = Long.parseLong(itemId);
			System.out.println("in controller itemId : " + pk_item_details_id);
			ItemDetailHelper helper = new ItemDetailHelper();
			Map map = helper.getDrinkDetailsForEdit(pk_item_details_id);
			Map<String, List> returnMap = new HashMap<String, List>();
			String xyz = toJson(map);
			System.out.println(xyz);
			System.out.println("going out of controller");
			return xyz;
		}
		
		// update drink details info
		public String updateDrinkDetails(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("In controller update Drink Details");
			ItemDetailHelper helper = new ItemDetailHelper();
			helper.updateDrinkInfoDetail(request, response);
			System.out.println("In controller Update Drink entry");
			return toJson("Data Updated Successfully");

		}

	// get Item Details report item name wise
			public String getItemNamewiseReport(HttpServletRequest request, HttpServletResponse response) {
				ItemDetailHelper helper = new ItemDetailHelper();
				List categories = helper.getItemNamewiseReport(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
	  
			// get Item Details report drink wise
				public String getDrinkwiseReport(HttpServletRequest request, HttpServletResponse response) {
					ItemDetailHelper helper = new ItemDetailHelper();
				    List categories = helper.getDrinkwiseReport(request, response);
					Map<String, List> returnMap = new HashMap<String, List>();
					returnMap.put("list", categories);
					System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
					return toJson(returnMap);
				}
				  
			
	  //kyc Details
	  public String KycInfo(HttpServletRequest request, HttpServletResponse response)
		{
			System.out.println("In controller");
			KycInfoHelper stk = new KycInfoHelper();
			stk.doKycDetails(request, response);
			return toJson("Data Added Successfully");
		}
	  
	  
	//to update grid data
	  public String updateGridData(HttpServletRequest request, HttpServletResponse response)
		{
			System.out.println("In controller");
			TempItemDetailHelper stk = new TempItemDetailHelper();
			stk.updateGridData(request, response);
			return toJson("Data Added Successfully");
		}
	  
	  public String updateGridDatanw(HttpServletRequest request, HttpServletResponse response)
		{
			System.out.println("In controller");
			TempItemDetailHelper stk = new TempItemDetailHelper();
			stk.updateGridDatanw(request, response);
			return toJson("Data Added Successfully");
		}
	  
	  // Delete Data From  Grid
	  
	  public String updateGridDataDelete(HttpServletRequest request, HttpServletResponse response)
			{
				System.out.println("In controller");
				TempItemDetailHelper stk = new TempItemDetailHelper();
				stk.updateGridDataGridDelete(request, response);
				return toJson("Data Added Successfully");
				
				
				/*
				 * Map<String, List> returnMap = new HashMap<String, List>();
				 * returnMap.put("list", categories);
				 * System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				 */
				/*String data = "Product Deleted Sucessfully";
				return data;*/
			}
	  // delete old grid
	  public String updateGridDataDeleteold(HttpServletRequest request, HttpServletResponse response)
			{
				System.out.println("In controller");
				TempItemDetailHelper stk = new TempItemDetailHelper();
				stk.updateGridDataGridDeleteold(request, response);
				return toJson("Data Added Successfully");
				
				
				/*
				 * Map<String, List> returnMap = new HashMap<String, List>();
				 * returnMap.put("list", categories);
				 * System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				 */
				/*String data = "Product Deleted Sucessfully";
				return data;*/
			}
	  // delete kitchen
	  public String deletekitchen(HttpServletRequest request, HttpServletResponse response)
			{
				System.out.println("In controller");
				TempItemDetailHelper stk = new TempItemDetailHelper();
				stk.deletekitchen(request, response);
				return toJson("Data Added Successfully");

			}
	  
	  public String SupplierInfo(HttpServletRequest request,HttpServletResponse response)
		{
			System.out.println("In controller");
			SupplierDetailsHelper sd = new SupplierDetailsHelper();
			sd.doSupplierDetails(request, response);
			return toJson("Data Added Successfully");
		}
	  // add access
	  public String addaccess(HttpServletRequest request,HttpServletResponse response)
		{
			System.out.println("In controller");
			hotelnamehelper sd = new hotelnamehelper();
			sd.addaccess(request, response);
			return toJson("Data Added Successfully");
		}
	  
	// register Supplier Detail
		public String doSupplierDetails(HttpServletRequest request, HttpServletResponse response) {

			SupplierDetailHelper helper = new SupplierDetailHelper();
			helper.doSupplier(request, response);
			return toJson("Data Added Successfully");
		}

		// edit Supplier Detail
		public String editSupp(HttpServletRequest request, HttpServletResponse response) {

			SupplierDetailHelper helper = new SupplierDetailHelper();
			helper.editSupplier(request, response);
			return toJson("Data Updated Successfully");
		}

	// Fetching supplier Details To Edit
		public String getSupplierDetailsToEdit(HttpServletRequest request, HttpServletResponse response) 
		{
			String supplierId = request.getParameter("supplierId");
			Long pkSupplierDetailId = Long.parseLong(supplierId);
			
			System.out.println("in controller schoolId : " + pkSupplierDetailId);
			SupplierDetailsHelper helper = new SupplierDetailsHelper();
			Map map = helper.getSupplierDetailsForEdit(pkSupplierDetailId);
			Map<String, List> returnMap = new HashMap<String, List>();
			String xyz = toJson(map);
			System.out.println("data: - "+xyz);
			System.out.println("going out of controller");
			return xyz;
		}
		
		// update supplier info details
		public String updateSupplierDetailas(HttpServletRequest request, HttpServletResponse response) 
		{
			System.out.println("In controller update Supplier Details");
			SupplierDetailsHelper helper = new SupplierDetailsHelper();
			helper.updateSupplierInfoDetail(request, response);
			System.out.println("In controller Update supplier");
			return toJson("Data Updated Successfully");

		}
	  
	       // Stock entry report
			public String getStockEntryReport(HttpServletRequest request, HttpServletResponse response) {
				StockManagementHelper helper = new StockManagementHelper();
				List categories = helper.getStockEntryReport(request, response);
				
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
				
				
			}
			
			public String getgoodsreceiveReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
				GoodsReceiveHelper helper = new GoodsReceiveHelper();
				List categories = helper.getgoodsreceiveReport(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$==================---------" + returnMap.size());
				return toJson(returnMap);
			}
			
			 // goods receive report
			public String getGoodsReceiveReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
				GoodsReceiveHelper helper = new GoodsReceiveHelper();
				List categories = helper.getGoodsReceiveReport(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$==================---------" + returnMap.size());
				return toJson(returnMap);
				
				
			}
			
			public String getattendedWaitersReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
				CustomerOrderHelper helper = new CustomerOrderHelper();
				List categories = helper.getattendedWaitersReport(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$===---------    " + returnMap.size());
				return toJson(returnMap);	
			}
			
			//to get product name into grid of store Management
			public String gridForStoreManagement(HttpServletRequest request,
					HttpServletResponse response) {
				String productName = request.getParameter("productName");
				
				StockManagementHelper helper = new StockManagementHelper();
				GetStoreManagementDetailBean timeTable = helper.getGridForStoreManagement(productName);
				Map<String, GetStoreManagementDetailBean> items = new HashMap<String, GetStoreManagementDetailBean>();
				items.put("offer", timeTable);
				return toJson(items);
			}
			
			// add store Management 
			public String addStoreManagement(HttpServletRequest request,HttpServletResponse response)
			{
				System.out.println("In controller");
				StockManagementHelper cdst = new StockManagementHelper();
				cdst.doaddStoreManagement(request, response);
				return toJson("Data Added Successfully");
			}
	  
			//to get grid of goods receive
			public String gridForGoodsReceive(HttpServletRequest request,HttpServletResponse response) {
				
				
				/*GoodsReceiveHelper helper = new GoodsReceiveHelper();
				GoodsReceiveBean timeTable = helper.getGridForGoodReceive(fk_item_id_drop1);
				Map<String, GoodsReceiveBean> items = new HashMap<String, GoodsReceiveBean>();
				items.put("offer", timeTable);
				return toJson(items);*/
				
				GoodsReceiveHelper helper = new GoodsReceiveHelper();

				List product = helper.getGridForGoodReceiveGridData(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("offer", product);
				System.out.println("$$$$$$$$$$$ -- " + returnMap);
				return toJson(returnMap);

			}
			
			public String getlistgoodsRecieve(HttpServletRequest request, HttpServletResponse response) {
				System.out.println("in controller --  ");
			/*	GoodsReceiveHelper helper = new GoodsReceiveHelper();
				List categories = helper.getGoodsReceiveReport(request, response);*/
				GoodsReceiveDao dao=new GoodsReceiveDao();
				List list2 =dao.getAllGoodsReceiveList(request);
				
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", list2);
				System.out.println("$$$$$$$$$$$------  " + returnMap.size());
				return toJson(returnMap);
			}
			
			
			// add good receive
			public String addGoodsReceive(HttpServletRequest request,HttpServletResponse response)
			{
				System.out.println("In controller");
				GoodsReceiveHelper cdst = new GoodsReceiveHelper();
				cdst.doaddGoodsReceive(request, response);
				return toJson("Data Added Successfully");
			}

	//Good Received
	public String goodReceive(HttpServletRequest request, HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		 GoodReceivedHelper goodReceivedHelper = new GoodReceivedHelper();
		 goodReceivedHelper.receiveGood(request, response);
		 return toJson("Data Addedd Successfully");
	  }
	  
	//Purchase Good
	  public String addGoods(HttpServletRequest request , HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  PurchaseGoodHelper purchaseGoodHelper = new PurchaseGoodHelper();
		  purchaseGoodHelper.purchaseDetails(request, response);
		  return toJson("Data Added Successfully");
	  }
	  
	//unBook Table
	  public String unBookTable(HttpServletRequest request , HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  TempItemDetailHelper tid = new TempItemDetailHelper();
		  tid.unBookTable(request, response);
		  return toJson("Data Added Successfully");
	  }
	  
	//Wastage Goods
	  public String wastageGoods(HttpServletRequest request , HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  WastageGoodsHelper wastageGoodsHelper = new WastageGoodsHelper();
		  wastageGoodsHelper.wastageGoods(request, response);
		  return toJson("Data Added Successfully");
	  }
	  
		//Wastage foods
		  public String wastageFoods(HttpServletRequest request , HttpServletResponse response)
		  {
			  System.out.println("IN CONTROLLER");
			  WastageFoodsHelper wastageFoodsHelper = new WastageFoodsHelper();
			  wastageFoodsHelper.wastageFoods(request, response);
			  return toJson("Data Added Successfully");
		  }
	  
	  public String getItemDetailsById(HttpServletRequest request , HttpServletResponse response)
		{
			OrderBillHelper helper  = new OrderBillHelper();
			List categories =  helper.getItemDetailsById(request, response);
			Map<String,List> returnMap = new HashMap<String,List>();
			returnMap.put("list",categories);
			System.out.println("$$$$$$$$$$$$$$$$"+returnMap);
			return toJson(returnMap);
		}
	  
	  public String getItemDetailsById10(HttpServletRequest request, HttpServletResponse response) {
		  System.out.println(" in   get item detials methid 10 ---  ");
		  tempOrderBill helper = new tempOrderBill();
		  List categories = helper.getItemDetailsById(request, response);
		  Map<String,List> returnMap = new HashMap<String,List>();
			returnMap.put("list",categories);
			System.out.println("$$$$$$$ - (getItemDetailsById10) --  "+returnMap);
		  return toJson(returnMap);
	  }
	  
	  public String getItemDetailByTable(HttpServletRequest request , HttpServletResponse response)
		{
		   TempItemDetailHelper helper  = new TempItemDetailHelper();
			List categories =  helper.getItemDetailsByTable(request, response);
			Map<String,List> returnMap = new HashMap<String,List>();
			returnMap.put("list",categories);
			System.out.println("$$$$$$$$$$$$$$$$ -- "+returnMap);
			return toJson(returnMap);
		}
	  
	  public String getItemDetailByTable10(HttpServletRequest request, HttpServletResponse response) {
		//  TempItemDetailHelper helper  = new TempItemDetailHelper();
			tempOrderhelper helper = new tempOrderhelper();
		  List categories =  helper.getItemDetailByTable10(request, response);
			Map<String,List> returnMap = new HashMap<String,List>();
			returnMap.put("list",categories);
			System.out.println("$$$$ - (getItemDetailByTable10) -- "+returnMap);
			return toJson(returnMap);
	  }
	  
	  //Update Data
	  public String updateDataItem(HttpServletRequest request , HttpServletResponse response)
			{
			   TempItemDetailHelper helper  = new TempItemDetailHelper();
				List categories =  helper.getItemDetailsUpdate(request, response);
				Map<String,List> returnMap = new HashMap<String,List>();
				returnMap.put("list",categories);
				System.out.println("$$$$$$$$$$$$$$$$"+returnMap);
				return toJson(returnMap);
			}
	  
	/*  public String TempitemDetails(HttpServletRequest request, HttpServletResponse response)
	  {
		  System.out.println("IN CONTROLLER");
		  TempItemDetailHelper Helper = new TempItemDetailHelper();
		  Helper.tempdetailItem(request, response);
		  return toJson("Data Added Successfully");
	  }*/
	  
	  public String registerBill(HttpServletRequest request, HttpServletResponse response)
	    {
		  System.out.println("IN CONTROLLER");
		  CustomerOrderHelper Helper = new CustomerOrderHelper();
		  Helper.registerBill(request, response);
		  return toJson("Data Added Successfully");
	    }
	  
	  public String registerBillnew(HttpServletRequest request, HttpServletResponse response)
	    {
		  System.out.println("IN CONTROLLER");
		  CustomerOrderHelper Helper = new CustomerOrderHelper();
		  Helper.registerBillnew(request, response);
		  return toJson("Data Added Successfully");
	    }
	  
	  public String orderBill10(HttpServletRequest request, HttpServletResponse response)
	    {
		  System.out.println("IN CONTROLLER");
		  System.out.println("in controller of kithen () - - ");
		  kitchenorderHelper Helper = new kitchenorderHelper();
		  Helper.orderBill(request, response);
		  
		  return toJson("Ordered Successfully");
	    }
	  
	  //to get Order Bill Copy Meathod
	  public String BillCopyMethod(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			System.out.println("Start In regProfarmaDetail Controller");
			
			CustomerOrderHelper helper = new CustomerOrderHelper();
			helper.OrderBillCOPY(request, response);
			
			System.out.println("Start In regProfarmaDetail Controller");
			return toJson("Data Added Successsfully");
		}
	  
	  // TO get All Bill No By Table Wise 
		public String getAllBillByOrderDetails(HttpServletRequest request, HttpServletResponse response) {
			String TableNo = request.getParameter("table_No");

			CustomerOrderHelper helper = new CustomerOrderHelper();
			Map map = helper.getAllBillNo(TableNo);
			String xyz = toJson(map);
			System.out.println(xyz);
			return xyz;
		}
	  
	// get Order Bill Report Date wise
		public String getOrderBillDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
			TempItemDetailHelper helper = new TempItemDetailHelper();
			List categories = helper.getOrderBillDateWiseReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		//expenditure name wise report
		public String getexpenditurenameReport(HttpServletRequest request, HttpServletResponse response) {
			ExpenditureHelper helper = new ExpenditureHelper();
			List categories = helper.getexpenditureWiseReportt(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		//bank name wise report
		public String getbanknamewiseReport(HttpServletRequest request, HttpServletResponse response) {
			BankHelper helper = new BankHelper();
			List categories = helper.getbanksnameWiseReport1(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		//bank range wise report
		public String getbankRangewiseReport(HttpServletRequest request, HttpServletResponse response) {
			BankHelper helper = new BankHelper();
			List categories = helper.getbankRangeWiseReport1(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		//expendtre date
		public String getexpDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
			ExpenditureHelper helper = new ExpenditureHelper();
			List categories = helper.getexpendituredateWiseReportt(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		//date wise today sale
		public String gettodaysaleDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
			TodaySaleHelper helper = new TodaySaleHelper();
			List categories = helper.gettodaysaledateWiseReportt(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		//today sale range wise
		
		public String getsalerangeWiseReportt(HttpServletRequest request, HttpServletResponse response) {
			TodaySaleHelper helper = new TodaySaleHelper();
			List categories = helper.getsalerangeWiseReporttt(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		
		//range wise expenfdte
		public String getexpRangeWiseReport(HttpServletRequest request, HttpServletResponse response) {
			ExpenditureHelper helper = new ExpenditureHelper();
			List categories = helper.getexpRangeWiseReportt(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		// sale range wise
		public String getOrderBillRangeWiseReport(HttpServletRequest request, HttpServletResponse response) {
			TempItemDetailHelper helper = new TempItemDetailHelper();
			List categories = helper.getOrderBillRangeWiseReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
			// cashbook report date wise
		public String getpaymentDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
			CashBookHelper helper = new CashBookHelper();
			List categories = helper.getpaymentDateWiseReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		//supp range wise
		public String getpaymentRangeWiseReport(HttpServletRequest request, HttpServletResponse response) {
			CashBookHelper helper = new CashBookHelper();
			List categories = helper.getpaymentRangeWiseReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		// cashbook supp wise
		public String getpaymentsupplierReport(HttpServletRequest request, HttpServletResponse response) {
			CashBookHelper helper = new CashBookHelper();
			List categories = helper.getpaymentsupplierReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		// cashbook employee date
		public String getEmppaymentDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
			CashBookHelper helper = new CashBookHelper();
			List categories = helper.getEmppaymentsupplierReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		// cashbook employee name
		public String getEmppaymentSuppWiseReport(HttpServletRequest request, HttpServletResponse response) {
			CashBookHelper helper = new CashBookHelper();
			List categories = helper.getEmppaymentSuppWiseReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		//emp range wise
		public String getEmppaymentSuppRangeWiseReport1(HttpServletRequest request, HttpServletResponse response) {
			CashBookHelper helper = new CashBookHelper();
			List categories = helper.getEmppaymentSuppRangeWiseReport1(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		public String getgoodReceiveDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
		
			GoodsReceiveHelper helper = new GoodsReceiveHelper();
			List categories = helper.getgoodReceiveDateWiseReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		// credit report
		public String getcreditDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
			
			CustomerOrderHelper helper = new CustomerOrderHelper();
			List categories = helper.getcreditDateWiseReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		// debit report
		public String getdebitDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
			
			CashBookHelper helper = new CashBookHelper();
			List categories = helper.getdebitDateWiseReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessing data in controller ==  " + returnMap);
			return toJson(returnMap);
		}
		
		// get Order Bill Report Date wise
		public String getOrderBillTableWiseReport(HttpServletRequest request, HttpServletResponse response) {
			TempItemDetailHelper helper = new TempItemDetailHelper();
			List categories = helper.getOrderBillTableWiseReport(request, response);
			Map<String, List> returnMap = new HashMap<String, List>();
			returnMap.put("list", categories);
			System.out.println("proccessin data controller ==" + returnMap);
			return toJson(returnMap);
		}
		
		  //Stock entry Details
		  public String addStockEntry(HttpServletRequest request, HttpServletResponse response)
			{
				System.out.println("In controller");
				StockEntryHelper stk = new StockEntryHelper();
				stk.doStockEntry(request, response);
				return toJson("Data Added Successfully");
			}

		
		  public String saveCookingStatus(HttpServletRequest request, HttpServletResponse response)
		  {
			  System.out.println("in controller of saving cooking status");
			  TempItemDetailHelper temp = new TempItemDetailHelper();
			  temp.saveCookStatus(request, response);
			  return toJson("Data Added");
		  }
		  
		/*
		 * This getSupplierToPayment() used to get supplier names in cashbook when
		 * user payment to supplier
		 */

		
		// Registering Supplier Payment
				public String regSupCashBook(HttpServletRequest request,
						HttpServletResponse response) {
					System.out.println("In controller");

					com.rms.helper.SupplierCashBankHelper helper = new com.rms.helper.SupplierCashBankHelper();
					helper.regSupplierCashBank(request, response);
					return toJson("Data Added Successfully");
				}
		
				// Registering Credit Customer Payment
				public String regCreditCustCashBook(HttpServletRequest request,
						HttpServletResponse response) {
					System.out.println("In controller");

					CustomerPaymentHelper helper = new CustomerPaymentHelper();
					helper.regCreditCustomerCashBank(request, response);
					return toJson("Data Added Successfully");
				}
				
				// Registering Employee Payment
				public String regEmpCashBook(HttpServletRequest request,
						HttpServletResponse response) {
					System.out.println("IN CONTROLLER");
					EmployeePaymentHelper helper = new EmployeePaymentHelper();
					helper.regEmployeePayment(request, response);
					return toJson("Data Added Successfully");
				}
				
				// Registering Expenditure Payment
				public String regExpenseCashBook(HttpServletRequest request,
						HttpServletResponse response) {
					System.out.println("IN CONTROLLER");
					ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
					helper.regExpensePayment(request, response);
					return toJson("Data Added Successfully");
				}
				
				// Register Customer Details
					public String customerDetails(HttpServletRequest request,
							HttpServletResponse response) {
						System.out.println("IN CONTROLLER");
						CustomerDetailsHelper cdh = new CustomerDetailsHelper();
						cdh.customerDetails(request, response);
						return toJson("Data Added Successfully");
					}
					
			// Fetching Credit Customer Details To Edit
			public String getCreditCustomerDetailsToEdit(HttpServletRequest request,
					HttpServletResponse response) {
				String strcustomerId = request.getParameter("creditCustomer");
				Long customerId = Long.parseLong(strcustomerId);
				System.out.println("in controller customerId : " + customerId);
				CustomerDetailsHelper helper = new CustomerDetailsHelper();
				Map map = helper.getCreditCustomerDetailsForEdit(customerId);
				Map<String, List> returnMap = new HashMap<String, List>();
				String xyz = toJson(map);
				System.out.println(xyz);
				System.out.println("going out of controller");
				return xyz;
			}
			
			// update credit customer details
			public String updateCreditCustomerDetails(HttpServletRequest request,
					HttpServletResponse response) {
				System.out.println("In controller UpdateCreditCustomer");
				CustomerDetailsHelper helper = new CustomerDetailsHelper();
				helper.editCreditCustomer(request, response);
				System.out.println("In controller Updateemployee");
				return toJson("Data Updated Successfully");

			}

		/* Add Cash Book Entry */
		public String addCashBook(HttpServletRequest request, HttpServletResponse response) {

			CashBookHelper helper = new CashBookHelper();
			helper.registerCashBookEntry(request, response);
			return toJson("Data Added Successsfully");
		}

		// Register Employee Details
		public String regDetails(HttpServletRequest request, HttpServletResponse response) {
			EmployeeDetailsHelper edh = new EmployeeDetailsHelper();
			boolean b = edh.employeeDetails(request, response);
			if (b) {
				return toJson("Data Added Successfully");
			} else {
				return toJson("Data is not added successfully !");
			}
		}
		
		// Fetching Employee Details To Edit
			public String getEmployeeDetailsToEdit(HttpServletRequest request,
					HttpServletResponse response) {
				String empID = request.getParameter("EmpId");
				Long empId = Long.parseLong(empID);
				System.out.println("in controller customerId : " + empId);
				EmployeeDetailsHelper helper = new EmployeeDetailsHelper();
				Map map = helper.getEmployeeDetailsForEdit(empId);
				Map<String, List> returnMap = new HashMap<String, List>();
				String xyz = toJson(map);
				System.out.println(xyz);
				System.out.println("going out of controller");
				return xyz;
			}
			
			// update Employee details
			public String updateEmployeeDetails(HttpServletRequest request,
					HttpServletResponse response) {
				System.out.println("In controller update Supplier Details");
				EmployeeDetailsHelper helper = new EmployeeDetailsHelper();
				helper.editEmployeeDetail(request, response);
				System.out.println("In controller Updateemployee");
				return toJson("Data Updated Successfully");

			}
			
			// Register Expense Details
			public String addExpenseDetails(HttpServletRequest request,
					HttpServletResponse response) {
				System.out.println("IN CONTROLLER");
				com.rms.helper.ExpenditureDetailsHelper exdh = new com.rms.helper.ExpenditureDetailsHelper();
				exdh.expenseDetails(request, response);
				return toJson("Data Added Successfully");
			}
			
			public String getEmlpToPayment(HttpServletRequest request, HttpServletResponse response) {
				SupplierDetailHelper helper = new SupplierDetailHelper();
				List leafcat = helper.getEmployee();
				String aa = toJson(leafcat);
				System.out.println(aa);
				return aa;
			}
			
			// get Supplier Detail
			public String getAllMAinSupp(HttpServletRequest request, HttpServletResponse response) {
				SupplierDetailHelper helper = new SupplierDetailHelper();
				List categories = helper.getAllMAinSupp(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// get all Information about Supplier on SupplierEdit Form
			public String getSupplier(HttpServletRequest request, HttpServletResponse response) {

				String supplierName = request.getParameter("supplierName");
				Long suppilerId = Long.parseLong(supplierName);
				SupplierDetailHelper helper = new SupplierDetailHelper();
				Map map = helper.getEditSupplier(suppilerId);
				Map<String, List> returnMap = new HashMap<String, List>();
				String xyz = toJson(map);
				System.out.println(xyz);
				return xyz;
			}

			// Register PurchaseReturn
			public String returngoodsReceipt(HttpServletRequest request, HttpServletResponse response) {
				System.out.println("IN CONTROLLER");
				com.rms.helper.PurchaseReturnHelper helper = new com.rms.helper.PurchaseReturnHelper();
				helper.returngoodsReceipt(request, response);
				return toJson("Data Added Successfully");
			}
			

			// register gooods receive
			public String regGoodReceive(HttpServletRequest request, HttpServletResponse response) {
				System.out.println("IN CONTROLLER");
				GoodReceiveHelper Helper = new GoodReceiveHelper();
				Helper.regGoodReceive(request, response);
				return toJson("Data Added Successfully");

			}
			// get billNo in purchase return Form
			public String getAllBillBySuppliers(HttpServletRequest request, HttpServletResponse response) {
				String supplierId = request.getParameter("supplier");

				SupplierDetailHelper helper = new SupplierDetailHelper();
				Map map = helper.getAllBillBySuppliers(supplierId);
				String xyz = toJson(map);
				System.out.println(xyz);
				return xyz;
			}
			

			// Getting Total amount as per Bill number in Supplier Payment from goods
			// receive table
			public String getTotalAmtByBillNo(HttpServletRequest request,
					HttpServletResponse response) {
				String billNo = request.getParameter("billNo");
				String supplierId = request.getParameter("supplier");
				com.rms.helper.SupplierAccountDetailsHelper helper = new com.rms.helper.SupplierAccountDetailsHelper();
				Map map = helper.getTotalAmtByBillNo(billNo, supplierId);
				String xyz = toJson(map);
				System.out.println(xyz);
				return xyz;
			}
			

			// Getting Total amount as per Bill number in Customer Payment from
			// fertilizer bill table
			public String getTotalAmtByBillNoForCreditCustomer(
					HttpServletRequest request, HttpServletResponse response) {
				String billNo = request.getParameter("billNo1");
				String creditCustomer = request.getParameter("creditCustomer");
				CustomerDetailsHelper helper = new CustomerDetailsHelper();
				Map map = helper.getTotalAmtByBillNo(billNo,creditCustomer);
				String xyz = toJson(map);
				System.out.println(xyz);
				return xyz;
			}

			// fetching balance amount as per Bill number in Customer Payment from
			// Customer Payment table
			public String getBalanceAmtByBillNoForCreditCustomer(
					HttpServletRequest request, HttpServletResponse response) {
				System.out.println("In controller balance");
				String billNo = request.getParameter("billNo1");
				
				String creditCustomer = request.getParameter("creditCustomer");
				CustomerDetailsHelper helper = new CustomerDetailsHelper();
				Map map = helper.getBalanceAmtByBillNo(billNo,creditCustomer);
				String xyz = toJson(map);
				System.out.println(xyz);
				return xyz;
			}
			
			// Supplier payment as per single date
			public String getSupplierPaymentDetailsForSingleDate(
					HttpServletRequest request, HttpServletResponse response) {
				SupplierCashBankHelper helper = new SupplierCashBankHelper();
				List categories = helper.getSupplierPaymentDetailsBySingleDate(request,
						response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}

			// Supplier payment report between two days
			public String getSupplierPaymentReportBetweenTwoDates(
					HttpServletRequest request, HttpServletResponse response) {
				SupplierCashBankHelper helper = new SupplierCashBankHelper();
				List categories = helper.getSupplierPaymentByTwoDate(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// Supplier payment as per bill number
			public String getSupplierPaymentDetailsAsPerBillNumber(
					HttpServletRequest request, HttpServletResponse response) {
				SupplierCashBankHelper helper = new SupplierCashBankHelper();
				List categories = helper.getSupplierPaymentDetailsByBillNumber(request,
						response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}

			// Supplier payment as per name
			public String getSupplierPaymentDetailsAsPerName(
					HttpServletRequest request, HttpServletResponse response) {
				SupplierCashBankHelper helper = new SupplierCashBankHelper();
				List categories = helper.getSupplierPaymentDetailsByNames(request,
						response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			
			// Supplier Unpaid payment as per name
					public String getAllUnPaidBillAmount(
							HttpServletRequest request, HttpServletResponse response) {
						SupplierCashBankHelper helper = new SupplierCashBankHelper();
						List categories = helper.getSupplierUnpaidPaymentDetailsByNames(request,
								response);
						Map<String, List> returnMap = new HashMap<String, List>();
						returnMap.put("list", categories);
						System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
						return toJson(returnMap);
					}
			
			// Credit Customer payment as per Name
			public String getCustomerReportByName(HttpServletRequest request,
					HttpServletResponse response) {
				CustomerPaymentHelper helper = new CustomerPaymentHelper();
				List categories = helper
						.getCustPaymentDetailsByNames(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			// Credit Customer payment as per Name
			public String getCreditCustomerBalanceReportNameWise(HttpServletRequest request,
					HttpServletResponse response) {
				CustomerPaymentHelper helper = new CustomerPaymentHelper();
				List categories = helper
						.getCreditCustomerBalanceReportNameWise(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}

			
			// Credit Customer payment as per bill number
			public String getCreditCustPaymentDetailsForBillNo(
					HttpServletRequest request, HttpServletResponse response) {
				CustomerPaymentHelper helper = new CustomerPaymentHelper();
				List categories = helper.getCustPaymentDetailsByBill(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			

			// Credit Customer payment as per single date
			public String getCreditCustPaymentDetailsForSingleDate(
					HttpServletRequest request, HttpServletResponse response) {
				CustomerPaymentHelper helper = new CustomerPaymentHelper();
				List categories = helper.getCustPaymentDetailsBySingleDate(request,
						response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// Credit Customer payment report between two days
			public String getCustomerReportBetweenTwoDates(HttpServletRequest request,
					HttpServletResponse response) {
				CustomerPaymentHelper helper = new CustomerPaymentHelper();
				List categories = helper.getCustDetailsByDate(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			// Employee payment as per single date
			public String getEmpPaymentDetailsForSingleDate(HttpServletRequest request,
					HttpServletResponse response) {
				EmployeePaymentHelper helper = new EmployeePaymentHelper();
				List categories = helper.getEmployeePaymentDetailsForSingleDate(
						request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			

			// Employee payment report between two days
			public String getEmployeeReportBetweenTwoDates(HttpServletRequest request,
					HttpServletResponse response) {
				EmployeePaymentHelper helper = new EmployeePaymentHelper();
				List categories = helper.getEmpPaymentByTwoDate(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// Expenditure payment report as per single date
			public String getExpensePaymentDetailsForSingleDate(
					HttpServletRequest request, HttpServletResponse response) {
				ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
				List categories = helper.getExpensePaymentDetailsForSingleDate(request,
						response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// Expenditure payment report between two days
			public String getExpenditurePaymentReportBetweenTwoDates(
					HttpServletRequest request, HttpServletResponse response) {
				ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
				List categories = helper.getExpensePaymentDetailByTwoDate(request,
						response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// get taday credit and debit report
			public String getTodayCreditDebitReport(HttpServletRequest request,
					HttpServletResponse response) {
				ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
				List categories = helper.getTodayCreditDebitReport(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// get taday credit and debit report
			public String getTodayCreditDebitReport1(HttpServletRequest request,
					HttpServletResponse response) {
				ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
				List categories = helper.getTodayCreditDebitReport1(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}

			// get single credit and debit report
			public String creditdebitForsingleDate(HttpServletRequest request,
					HttpServletResponse response) {
				ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
				List categories = helper.creditdebitForsingleDate(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// get single credit and debit report
			public String creditdebitForsingleDate1(HttpServletRequest request,
					HttpServletResponse response) {
				ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
				List categories = helper.creditdebitForsingleDate1(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// get two credit and debit report
			public String creditdebitForBetTowDate(HttpServletRequest request,
					HttpServletResponse response) {
				ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
				List categories = helper.creditdebitForBetTowDate(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			public String creditdebitForBetTowDate1(HttpServletRequest request,
					HttpServletResponse response) {
				ExpenditurePaymentHelper helper = new ExpenditurePaymentHelper();
				List categories = helper.creditdebitForBetTowDate1(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("list", categories);
				System.out.println("$$$$$$$$$$$$$$$$" + returnMap);
				return toJson(returnMap);
			}
			
			// Supplier Account details
			public String getYesterdarTotalAmount(HttpServletRequest request,
					HttpServletResponse response) {
				SupplierAccountDetailsHelper helper = new SupplierAccountDetailsHelper();
				Map map = helper.getYesterdarTotalAmount();
				String xyz = toJson(map);
				System.out.println(xyz);
				return xyz;
			}
			public String getTodaySaleTotalAmount(HttpServletRequest request,
					HttpServletResponse response) {
				SupplierAccountDetailsHelper helper = new SupplierAccountDetailsHelper();
				Map map = helper.getTodaySaleTotalAmount();
				String xyz = toJson(map);
				System.out.println(xyz);
				return xyz;
			}
			
			public String getTodaySaleTotalAmount1(HttpServletRequest request,
					HttpServletResponse response) {
				SupplierAccountDetailsHelper helper = new SupplierAccountDetailsHelper();
				Map map = helper.getTodaySaleTotalAmount1();
				String xyz = toJson(map);
				System.out.println(xyz);
				return xyz;
			}
			
			
			
			//grid for transfer stock
			
			//to get grid of goods receive
			public String gridForTranforStock(HttpServletRequest request,HttpServletResponse response) {
				
				
				/*GoodsReceiveHelper helper = new GoodsReceiveHelper();
				GoodsReceiveBean timeTable = helper.getGridForGoodReceive(fk_item_id_drop1);
				Map<String, GoodsReceiveBean> items = new HashMap<String, GoodsReceiveBean>();
				items.put("offer", timeTable);
				return toJson(items);*/
				
				TransferstockHelper helper = new TransferstockHelper();

				List product = helper.getGridForTransferStock(request, response);
				Map<String, List> returnMap = new HashMap<String, List>();
				returnMap.put("offer", product);
				System.out.println("$$$$$$$$$$$ -- " + returnMap);
				return toJson(returnMap);

			}
			
			public String addTrasferStock(HttpServletRequest request,HttpServletResponse response)
			{
				System.out.println("In controller");
				TransferstockHelper cdst = new TransferstockHelper();
				cdst.addTranferstock(request, response);
				return toJson("Data Added Successfully");
			}
			
			//Deleted menu list
			public String deleteList(HttpServletRequest request, HttpServletResponse response) {
				System.out.println("In Controller");
				String id=request.getParameter("delSportId");
				System.out.println("Dlete Id"+id);
				ItemEntryHelper helper = new ItemEntryHelper();
				helper.deleteIteEntryList(request, response);
				
				String data = "Item Details Deleted Sucessfully";
				return data;
			}
			
			//Customer Details
			
			 public String customerdetails(HttpServletRequest request, HttpServletResponse response)
			  {
				  System.out.println("IN CONTROLLER");
				  CustomerD CustomerD = new CustomerD();
				//  CustomerD.detailItem(request, response);
				  return toJson("Data Added Successfully");
			  }
			 
			 
			 public String CustomerInfo(HttpServletRequest request, HttpServletResponse response)
			 {
				 System.out.println("In controller");
				  CustomerD CustomerD = new CustomerD();
				  CustomerD.customersDetails(request, response);
					return toJson("Data Added Successfully");
			 }
			
			 public String gettableToEdit(HttpServletRequest request, HttpServletResponse response) 
				{
					String pk_temp_id1 = request.getParameter("pk_temp_id1");
					Long pk_temp_id = Long.parseLong(pk_temp_id1);
		/*
		 * String empID = request.getParameter("EmpId"); 
		 * Long empId =Long.parseLong(empID);
		 */
				//	System.out.println("in controller Table Number Id : " + pk_temp_id);
					OrderBillHelper helper = new OrderBillHelper();
					Map map = helper.gettableForEdit(pk_temp_id);
					Map<String, List> returnMap = new HashMap<String, List>();
					String xyz = toJson(map);
					System.out.println("data: - "+xyz);
					System.out.println("going out of controller");
					return xyz;
				}

				//update Table
				public String updatetable(HttpServletRequest request, HttpServletResponse response) 
				{
					System.out.println("In controller update Table Number Details");
				OrderBillHelper helper = new OrderBillHelper();
					helper.edittable(request, response);
					System.out.println("In controller Update Table Number");
					return toJson("Data Updated Successfully");

				}
				
				public String getAllMainCat(HttpServletRequest request, HttpServletResponse response) 
				{
					
				}

				
				
				
		
			
}