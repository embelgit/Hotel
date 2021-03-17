package com.rms.helper;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.GetItemDetails;
import com.rms.bean.OrderBillReportDateWiseBean;
import com.rms.bean.OrderBillReportTableWiseBean;
import com.rms.dao.CashBookDao;
import com.rms.dao.CustomerOrderDao;
import com.rms.dao.TempItemDetailDao;
import com.rms.hibernate.TempItemDetail;
import com.rms.hibernate.newTempItemDetail;
import com.rms.utility.HibernateUtility;
import com.sun.xml.internal.bind.v2.runtime.Location;

public class TempItemDetailHelper {
	private static final char M = 0;

	public List getAllMainTableNo(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotel = (String)sessionn.getAttribute("hotelid");
		
	/*	if (sessionn.getAttribute("user") != null) {
			
		}
		else {
			System.out.println("before redieecting to login in getAllMainTableNo() - ");
			response.sendRedirect("/RMS/jsp/login.jsp");	
		     System.out.println("if user is null ----");
		  //   out.println("Please Login Again !");
		     out.println("alert('User or Password is Incorrect');");
		}*/
		
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" - in getAllMainTableNo()");
		
		Long hotelid = Long.parseLong(hotel);
		TempItemDetailDao dao1 = new TempItemDetailDao();
		System.out.println("in temp helper -- ");
		return dao1.getAllMainTableNo(hotelid);
	} 
	
	
	public void saveCookStatus(HttpServletRequest request, HttpServletResponse response) 
	{
		String cooking = request.getParameter("cooking");
		System.out.println("in helper temp cooking status is -- >  "+cooking);
	}
	
	public List getSuppliers()
	{
		 
		 CashBookDao dao = new CashBookDao();
			return dao.getSupplierNameByToPay();
	
	}
	
	
	public List getItemDetailsByTable(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String tableNo= request.getParameter("tableNo");
//		String fk_item_id= request.getParameter("fk_item_id");
		System.out.println("table no is (getItemdetailsbyTable) in helper -- "+tableNo);
		//	 System.out.println("hi vikas first record in table");
	    //   System.out.println(tableNo);
			
	         Map<Long,GetItemDetails> map = new HashMap<Long,GetItemDetails>();
	 		
	         TempItemDetailDao dao = new TempItemDetailDao ();
	 		List<GetItemDetails> saleList = dao.getItemDetailsByTable(tableNo, hotelid);
	 		
	 		return saleList;
		
	} 
	           //      ==============================================================================================
	
	public List getItemDetailsUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		 String tableNo = request.getParameter("tableNo");
		
		 System.out.println(tableNo+" - tableNo - vxvdfvdf");
			
         Map<Long,GetItemDetails> map = new HashMap<Long,GetItemDetails>();
 		
         TempItemDetailDao dao = new TempItemDetailDao ();
 		List<GetItemDetails> saleList = dao.getItemDetailsByTable(tableNo, hotelid);
 		
 		return saleList;
	}     // ==========================================================================================================
	
	public void unBookTable(HttpServletRequest request,
			HttpServletResponse response) {

		char M='N';
		String tableNo= request.getParameter("table_No");
	       System.out.println(tableNo+" --   in unbook table method----- ");
			
	       HibernateUtility hbu=null;
			Session session = null;
			Transaction transaction = null;
			
			 hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			 transaction = session.beginTransaction();
		
			long tableNo1 = Long.parseLong(tableNo);
			 
			TempItemDetail det = (TempItemDetail) session.get(TempItemDetail.class, tableNo1);
			det.setActiveYN(M);
			session.saveOrUpdate(det);
			System.out.println(" - ### active status is changed to N #### - ");
			transaction.commit();
			System.out.println("success");
	
	} 
	
	// get Order Bill report Date Wise
				public List getOrderBillDateWiseReport(HttpServletRequest request,
						HttpServletResponse response) {
					
					HttpSession sessionn = request.getSession(true);
					String username = (String)sessionn.getAttribute("user");		
					String userid = (String)sessionn.getAttribute("userid");
					String hotelid = (String)sessionn.getAttribute("hotelid");
					String hotelname=(String)sessionn.getAttribute("hotelname");
					String usertype = (String)sessionn.getAttribute("usertype");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
					String orderBillDate = request.getParameter("orderBillDate");
				        Map<Long,OrderBillReportDateWiseBean> map = new HashMap<Long,OrderBillReportDateWiseBean>();
						
				        TempItemDetailDao dao = new TempItemDetailDao();
						List<OrderBillReportDateWiseBean> exp1List = dao.getOrderBillDateWiseReport(hotelid,usertype,orderBillDate);
						
						return exp1List;
				}
				// range sale report
				
				public List getOrderBillRangeWiseReport(HttpServletRequest request, HttpServletResponse response) {
					HttpSession sessionn = request.getSession(true);
					String username = (String)sessionn.getAttribute("user");		
					String userid = (String)sessionn.getAttribute("userid");
					String hotelid = (String)sessionn.getAttribute("hotelid");
					String hotelname=(String)sessionn.getAttribute("hotelname");
					String usertype = (String)sessionn.getAttribute("usertype");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
					    String dateto = request.getParameter("dateto");
					    String datefrom = request.getParameter("datefrom");
				        Map<Long,OrderBillReportDateWiseBean> map = new HashMap<Long,OrderBillReportDateWiseBean>();
						
				        TempItemDetailDao dao = new TempItemDetailDao();
						List<OrderBillReportDateWiseBean> exp1List = dao.getOrderBillRangeWiseReport(dateto,datefrom,hotelid,usertype);
						
						return exp1List;
				}
				
				// get Order Bill report Table no. Wise
				public List getOrderBillTableWiseReport(HttpServletRequest request,
						HttpServletResponse response) {
					HttpSession sessionn = request.getSession(true);
					String username = (String)sessionn.getAttribute("user");		
					String userid = (String)sessionn.getAttribute("userid");
					String hotelid = (String)sessionn.getAttribute("hotelid");
					String hotelname=(String)sessionn.getAttribute("hotelname");
					String usertype = (String)sessionn.getAttribute("usertype");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
					
					    String tableNo = request.getParameter("tableNo");
				        Map<Long,OrderBillReportTableWiseBean> map = new HashMap<Long,OrderBillReportTableWiseBean>();
						
				        TempItemDetailDao dao = new TempItemDetailDao();
						List<OrderBillReportTableWiseBean> exp1List = dao.getOrderBillTableWiseReport(tableNo,hotelid,usertype);
						
						return exp1List;
				}


				
				//to upadate grid data
				public void updateGridData(HttpServletRequest request, HttpServletResponse response) {
					HttpSession sessionn = request.getSession(true);
					String username = (String)sessionn.getAttribute("user");		
					String userid = (String)sessionn.getAttribute("userid");
					String hotelid = (String)sessionn.getAttribute("hotelid");
					String hotelname=(String)sessionn.getAttribute("hotelname");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
					// TODO Auto-generated method stub
					Long pk_temp_id = 0l;
					String itemId = null;
					Integer count = Integer.parseInt(request.getParameter("count"));
					System.out.println("c count is (tempitemdetailhelper) -->  "+count);

					for(int i=0;i<count;i++){
						
						String pkTempId = request.getParameter("pkTempId"+i);
						//System.out.println("hi this Id IS ==="+pkTempId);
						Long id = Long.parseLong(pkTempId);
						
						//System.out.println("temp id ::: " + id);
						
						itemId = request.getParameter("itemId"+i);
						//Long newid = Long.parseLong(pkTempId);
					//	System.out.println(" hi this is itemId---======="+itemId);
						//System.out.println(" hi this is newItemID Is-----==== "+newid);
					//	String cgst = request.getParameter("cgst"+i);
					//	String sgst = request.getParameter("sgst"+i);
						String gst = request.getParameter("gst"+i);

						
						String quantity= request.getParameter("quantity"+i);
						if(quantity == null) {
							quantity = "0";
						}
						
						String prrice= request.getParameter("prrice"+i);
						System.out.println(" price from user in to grid ---------  "+prrice+" gst - - -  "+gst);
					//	String unitinMl = request.getParameter("unitinMl"+i);
						
						String unit = request.getParameter("unit"+i);
						if(unit == null) {
							unit = "NA";
						}
						String value = request.getParameter("value"+i);
						if(value == null) {
							value = "0";
						}
						
						Double totalAmt = Double.parseDouble(quantity) * Double.parseDouble(prrice);
						System.out.println("  ---------------- total -------------------  "+totalAmt);
						
						String stockhide = request.getParameter("stockhide"+i);
						
						pk_temp_id = Long.parseLong(request.getParameter("pkTempId"+i));
						
						System.out.println("Quantity from user is (in tempitemHelper Grid) -- > --     "+quantity+", pkitemid - "+pkTempId+
								", itemid -  "+itemId+" , price - "+prrice+", unit - "+unit+", value - "+value+",pktempid - "+pk_temp_id);
						HibernateUtility hbu=null;
					    Session session = null;
					    Transaction transaction = null;
							
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
					    transaction = session.beginTransaction();
						
						TempItemDetail det = (TempItemDetail) session.get(TempItemDetail.class, id);
						det.setQuantity(Double.parseDouble(quantity));
						System.out.println("quantity is (tempItemhelper)  - > "+det.getQuantity());
						det.setUnitPrice(Double.parseDouble(prrice));
						System.out.println("price got from grid bill is ---  >  "+det.getUnitPrice());
					//	det.setUnitInMl(Double.parseDouble(unitinMl));
						det.setTotalAmt(totalAmt);
					//	det.setCgst(Double.parseDouble(cgst));
					//	det.setSgst(Double.parseDouble(sgst));
					//	System.out.println("cgst & sgst set - >  "+det.getCgst()+" "+det.getSgst());
						det.setGst(Double.parseDouble(gst));
						System.out.println("total amount to be updated in tempitem table (in tempitemhelper) -- > Rs. .. "+det.getTotalAmt()+" gst set when entered -  "+det.getGst());
						det.setItemId(Long.parseLong(itemId));
						session.saveOrUpdate(det);
						transaction.commit();
						System.out.println("success in temp item helper updategrid() -- ");
			           
//						System.out.println("prrice"+prrice);
			            
			            
			           
//						System.out.println("unitinMl"+unitinMl);
			           
			            
			           
//						System.out.println("totalAmt"+totalAmt);
						
						
			           
					
					
					
				/*	CustomerOrderDao dao=new CustomerOrderDao();

					System.out.println("pk_temp_id" +pk_temp_id);
					dao.updateTabaleStatus(pk_temp_id);*/
					
					com.rms.dao.StockDao dao1 = new com.rms.dao.StockDao();
			        List stkList1  = dao1.getAllStockEntry1(itemId,hotelid);
			        
			        for(int j=0;j<stkList1.size();j++){
			        	
			        	com.rms.hibernate.Stock st = (com.rms.hibernate.Stock)stkList1.get(j);
			        	Long ItemId = st.getFk_good_received_id();
			        	Long PkItemId = st.getPk_item_stock_id();
			        	
			        	//System.out.println("id from stock is ====="+ItemId);
			        	//System.out.println(" pk Item Id is ===="+PkItemId);
			        	
			        	//System.out.println("id from ui"+newid);
			        	
			        	//If ItemName Is Already Exists In Stock Table  
			        	if(ItemId.equals(Long.parseLong(itemId))){
			        	//	 Double qunty = st.getStock();
			        	//	 System.out.println("qunty from Database is (in tempitemHelper) --  >  - - "+qunty);
			        		
			        	//	 Double updatequnty = (double) (qunty - Double.parseDouble(quantity));
			        	//	 System.out.println("updatequnty ie. DB qunty - quantity from user is (in tempitemHelper) - > - - "+updatequnty);
			        				 
			        		 com.rms.utility.HibernateUtility hbu1 = com.rms.utility.HibernateUtility.getInstance();
			        		 Session session1 = hbu1.getHibernateSession();
			        		 Transaction transaction1 = session1.beginTransaction();
			        		 
			        		 DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
			        		 Date date = new Date();
			        	
			        	     com.rms.hibernate.Stock updateStock = (com.rms.hibernate.Stock) session.get(com.rms.hibernate.Stock.class, new Long(PkItemId));	 
			        		// updateStock.setUpdateDate(date);
			        	//	 updateStock.setStock(updatequnty);
			        		 
			        	//	session1.saveOrUpdate(updateStock);
			        		transaction1.commit();
			        		break;
			        	}
			        }
					}
					
				}
				
				// for kiosk bill
				
				public void updateGridDatanw(HttpServletRequest request, HttpServletResponse response) {
					HttpSession sessionn = request.getSession(true);
					String username = (String)sessionn.getAttribute("user");		
					String userid = (String)sessionn.getAttribute("userid");
					String hotelid = (String)sessionn.getAttribute("hotelid");
					String hotelname=(String)sessionn.getAttribute("hotelname");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
					// TODO Auto-generated method stub
					Long pk_temp_id = 0l;
					String itemId = null;
					Integer count = Integer.parseInt(request.getParameter("count"));
					System.out.println("c count is (tempitemdetailhelper) -->  "+count);

					for(int i=0;i<count;i++){
						
						String pkTempId = request.getParameter("pkTempId"+i);
						//System.out.println("hi this Id IS ==="+pkTempId);
						Long id = Long.parseLong(pkTempId);
						
						//System.out.println("temp id ::: " + id);
						
						itemId = request.getParameter("itemId"+i);
						//Long newid = Long.parseLong(pkTempId);
					//	System.out.println(" hi this is itemId---======="+itemId);
						//System.out.println(" hi this is newItemID Is-----==== "+newid);
						
							
						String quantity= request.getParameter("quantity"+i);
						if(quantity == null) {
							quantity = "0";
						}
						
						String prrice= request.getParameter("prrice"+i);
						System.out.println(" price from user in to grid ---------  "+prrice);
					//	String unitinMl = request.getParameter("unitinMl"+i);
						
						String unit = request.getParameter("unit"+i);
						if(unit == null) {
							unit = "NA";
						}
						String value = request.getParameter("value"+i);
						if(value == null) {
							value = "0";
						}
						
						String gst = request.getParameter("gst"+i);
					//	String sgst  =request.getParameter("sgst"+i);
						
						Double totalAmt = Double.parseDouble(quantity) * Double.parseDouble(prrice);
						System.out.println("  ---------------- total -------------------  "+totalAmt+", gst - "+gst);
						
						String stockhide = request.getParameter("stockhide"+i);
						
						pk_temp_id = Long.parseLong(request.getParameter("pkTempId"+i));
						
						System.out.println("Quantity from user is (in tempitemHelper Grid) -- > --     "+quantity+", pkitemid - "+pkTempId+
								", itemid -  "+itemId+" , price - "+prrice+", unit - "+unit+", value - "+value+",pktempid - "+pk_temp_id);
						HibernateUtility hbu=null;
					    Session session = null;
					    Transaction transaction = null;
							
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
					    transaction = session.beginTransaction();
						
					    newTempItemDetail det = (newTempItemDetail) session.get(newTempItemDetail.class, id);
						det.setQuantity(Double.parseDouble(quantity));
						System.out.println("quantity is (tempItemhelper)  - > "+det.getQuantity());
						det.setUnitPrice(Double.parseDouble(prrice));
						System.out.println("price got from grid bill is ---  >  "+det.getUnitPrice());
						
//						det.setCgst(Double.parseDouble(cgst));
//						det.setSgst(Double.parseDouble(sgst));
						
						det.setGst(Double.parseDouble(gst));
						System.out.println("gst updated to temp table  - --------------------------       - "+det.getGst());
					//	det.setUnitInMl(Double.parseDouble(unitinMl));
						det.setTotalAmt(totalAmt);
						System.out.println("total amount to be updated in tempitem table (in tempitemhelper) -- > Rs. .. "+det.getTotalAmt());
						det.setItemId(Long.parseLong(itemId));
						session.saveOrUpdate(det);
						transaction.commit();
						System.out.println("success in temp item helper updategrid() -- ");
			           
//						System.out.println("prrice"+prrice);
			            
			            
			           
//						System.out.println("unitinMl"+unitinMl);
			           
			            
			           
//						System.out.println("totalAmt"+totalAmt);
						
						
			           
					
					
					
				/*	CustomerOrderDao dao=new CustomerOrderDao();

					System.out.println("pk_temp_id" +pk_temp_id);
					dao.updateTabaleStatus(pk_temp_id);*/
					
					com.rms.dao.StockDao dao1 = new com.rms.dao.StockDao();
			        List stkList1  = dao1.getAllStockEntry1(itemId,hotelid);
			        
			        for(int j=0;j<stkList1.size();j++){
			        	
			        	com.rms.hibernate.Stock st = (com.rms.hibernate.Stock)stkList1.get(j);
			        	Long ItemId = st.getFk_good_received_id();
			        	Long PkItemId = st.getPk_item_stock_id();
			        	
			        	//System.out.println("id from stock is ====="+ItemId);
			        	//System.out.println(" pk Item Id is ===="+PkItemId);
			        	
			        	//System.out.println("id from ui"+newid);
			        	
			        	//If ItemName Is Already Exists In Stock Table  
			        	if(ItemId.equals(Long.parseLong(itemId))){
			        	//	 Double qunty = st.getStock();
			        	//	 System.out.println("qunty from Database is (in tempitemHelper) --  >  - - "+qunty);
			        		
			        	//	 Double updatequnty = (double) (qunty - Double.parseDouble(quantity));
			        	//	 System.out.println("updatequnty ie. DB qunty - quantity from user is (in tempitemHelper) - > - - "+updatequnty);
			        				 
			        		 com.rms.utility.HibernateUtility hbu1 = com.rms.utility.HibernateUtility.getInstance();
			        		 Session session1 = hbu1.getHibernateSession();
			        		 Transaction transaction1 = session1.beginTransaction();
			        		 
			        		 DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
			        		 Date date = new Date();
			        	
			        	     com.rms.hibernate.Stock updateStock = (com.rms.hibernate.Stock) session.get(com.rms.hibernate.Stock.class, new Long(PkItemId));	 
			        		// updateStock.setUpdateDate(date);
			        	//	 updateStock.setStock(updatequnty);
			        		 
			        	//	session1.saveOrUpdate(updateStock);
			        		transaction1.commit();
			        		break;
			        	}
			        }
					}
					
				}
				
				// Delete Grid data From table Name 
				public void updateGridDataGridDelete(HttpServletRequest request,
						HttpServletResponse response) {
					// TODO Auto-generated method stub
					HttpSession sessionn = request.getSession(true);
					String username = (String)sessionn.getAttribute("user");		
					String userid = (String)sessionn.getAttribute("userid");
					String hotelid = (String)sessionn.getAttribute("hotelid");
					String hotelname=(String)sessionn.getAttribute("hotelname");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
					/*char M='N';
					String tableNo= request.getParameter("table_No");
				       System.out.println(tableNo+" Hi THis SI TAble No Is ------------------------");
						
				       HibernateUtility hbu=null;
						Session session = null;
						Transaction transaction = null;
						
						 hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
						 transaction = session.beginTransaction();
					
						long tableNo1 = Long.parseLong(tableNo);
						 
						TempItemDetail det = (TempItemDetail) session.get(TempItemDetail.class, tableNo1);
						det.setActiveYN(M);
						session.saveOrUpdate(det);
						transaction.commit();
						System.out.println("success");*/
					
					/*Integer count = Integer.parseInt(request.getParameter("count"));
					System.out.println("c111111"+count);
					
						for(int i=0;i<count;i++){
						
						String pkTempId = request.getParameter("pkTempId");
						System.out.println("hi this Id IS ==="+pkTempId);
						Long id = Long.parseLong(pkTempId);*/
					String delTempID = request.getParameter("pkTempId");
					
					System.out.println(" update grid data delete method in temp helper-- tempID received is  ---    "+delTempID);
					   
					TempItemDetailDao dao2 = new TempItemDetailDao();
					dao2.deleteGridData(delTempID,hotelid);
						/*}*/
				/*	
					char M ='N';
					char Y ='Y';
					//count = 1;
					Integer count = Integer.parseInt(request.getParameter("count"));
					System.out.println("c111111"+count);

					for(int i=0;i<count;i++){
						
						
						String tableNo =request.getParameter("tableNo"+i);
						System.out.println(" hi this is table no is 0000000--------"+tableNo);
						
						
						
						String pkTempId = request.getParameter("pkTempId"+i);
						System.out.println("hi this Id IS ==="+pkTempId);
						Long id = Long.parseLong(pkTempId);
						
						System.out.println("temp id ::: " + id);
						
						String itemId =request.getParameter("itemId");
					System.out.println(" Hi This Item  Id IS======= "+itemId);

						String quantity= request.getParameter("quantity"+i);
						System.out.println(" hi this is Kishor Qyantity -----------=========="+quantity);
						
						
						
						String prrice= request.getParameter("prrice"+i);
						String unitinMl = request.getParameter("unitinMl"+i);
						Double totalAmt = Double.parseDouble(quantity)   * Double.parseDouble(prrice);
						
						
						HibernateUtility hbu=null;
					    Session session = null;
					    Transaction transaction = null;
							
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
					    transaction = session.beginTransaction();
					    
					    
					
						
						TempItemDetail det = (TempItemDetail) session.get(TempItemDetail.class, id);
						if(pkTempId.equals(pkTempId))
						 {
							 det.setActiveYN(M);
							 System.out.println(" Hi this is "+M);
						 }
						 else{
							 det.setActiveYN(Y);
							 System.out.println(" Hi this is ===="+Y);
						 }
						 
							
						det.setQuantity(Double.parseDouble(quantity));
						det.setUnitPrice(Double.parseDouble(prrice));
						det.setUnitInMl(Double.parseDouble(unitinMl));
						det.setTotalAmt(totalAmt);
						det.setTableNo(Long.parseLong(tableNo));
						det.setActiveYN(M);
						session.saveOrUpdate(det);
						//session.delete(det);
						 //session.flush();
				           //session.close();
						transaction.commit();
						System.out.println("success");
			           
			            
			            
						
						
						
			           
					}
					*/
					
				}
					
				// - old delete
				public void updateGridDataGridDeleteold(HttpServletRequest request,
						HttpServletResponse response) {
					// TODO Auto-generated method stub
					
					HttpSession sessionn = request.getSession(true);
					String username = (String)sessionn.getAttribute("user");		
					String userid = (String)sessionn.getAttribute("userid");
					String hotelid = (String)sessionn.getAttribute("hotelid");
					String hotelname=(String)sessionn.getAttribute("hotelname");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
					

					/*char M='N';
					String tableNo= request.getParameter("table_No");
				       System.out.println(tableNo+" Hi THis SI TAble No Is ------------------------");
						
				       HibernateUtility hbu=null;
						Session session = null;
						Transaction transaction = null;
						
						 hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
						 transaction = session.beginTransaction();
					
						long tableNo1 = Long.parseLong(tableNo);
						 
						TempItemDetail det = (TempItemDetail) session.get(TempItemDetail.class, tableNo1);
						det.setActiveYN(M);
						session.saveOrUpdate(det);
						transaction.commit();
						System.out.println("success");*/
					
					/*Integer count = Integer.parseInt(request.getParameter("count"));
					System.out.println("c111111"+count);
					
						for(int i=0;i<count;i++){
						
						String pkTempId = request.getParameter("pkTempId");
						System.out.println("hi this Id IS ==="+pkTempId);
						Long id = Long.parseLong(pkTempId);*/
					String delTempID = request.getParameter("pkTempId");
					
					System.out.println(" update grid data delete method in temp helper-- tempID received is  ---    "+delTempID);
					   
					TempItemDetailDao dao2 = new TempItemDetailDao();
					dao2.deleteGridDataold(delTempID,hotelid);
						/*}*/
				/*	
					char M ='N';
					char Y ='Y';
					//count = 1;
					Integer count = Integer.parseInt(request.getParameter("count"));
					System.out.println("c111111"+count);

					for(int i=0;i<count;i++){
						
						
						String tableNo =request.getParameter("tableNo"+i);
						System.out.println(" hi this is table no is 0000000--------"+tableNo);
						
						
						
						String pkTempId = request.getParameter("pkTempId"+i);
						System.out.println("hi this Id IS ==="+pkTempId);
						Long id = Long.parseLong(pkTempId);
						
						System.out.println("temp id ::: " + id);
						
						String itemId =request.getParameter("itemId");
					System.out.println(" Hi This Item  Id IS======= "+itemId);

						String quantity= request.getParameter("quantity"+i);
						System.out.println(" hi this is Kishor Qyantity -----------=========="+quantity);
						
						
						
						String prrice= request.getParameter("prrice"+i);
						String unitinMl = request.getParameter("unitinMl"+i);
						Double totalAmt = Double.parseDouble(quantity)   * Double.parseDouble(prrice);
						
						
						HibernateUtility hbu=null;
					    Session session = null;
					    Transaction transaction = null;
							
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
					    transaction = session.beginTransaction();
					    
					    
					
						
						TempItemDetail det = (TempItemDetail) session.get(TempItemDetail.class, id);
						if(pkTempId.equals(pkTempId))
						 {
							 det.setActiveYN(M);
							 System.out.println(" Hi this is "+M);
						 }
						 else{
							 det.setActiveYN(Y);
							 System.out.println(" Hi this is ===="+Y);
						 }
						 
							
						det.setQuantity(Double.parseDouble(quantity));
						det.setUnitPrice(Double.parseDouble(prrice));
						det.setUnitInMl(Double.parseDouble(unitinMl));
						det.setTotalAmt(totalAmt);
						det.setTableNo(Long.parseLong(tableNo));
						det.setActiveYN(M);
						session.saveOrUpdate(det);
						//session.delete(det);
						 //session.flush();
				           //session.close();
						transaction.commit();
						System.out.println("success");
			           
			            
			            
						
						
						
			           
					}
					*/
					
				}
				
				public void deletekitchen(HttpServletRequest request, HttpServletResponse response) {
					// TODO Auto-generated method stub
					HttpSession sessionn = request.getSession(true);
					String username = (String)sessionn.getAttribute("user");		
					String userid = (String)sessionn.getAttribute("userid");
					String hotelid = (String)sessionn.getAttribute("hotelid");
					String hotelname=(String)sessionn.getAttribute("hotelname");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
					
			//		String delTempID = request.getParameter("pkTempId");
					String tableNo = request.getParameter("tableNo");
					String itemId = request.getParameter("itemId");
					
					System.out.println(" delete kitchen itemid && table no  received is  ---    "+itemId+" & "+tableNo);
					   
	/*				TempItemDetailDao dao2 = new TempItemDetailDao();
					List stkList1 = dao2.getallkitchen(hotelid);
					
				      for(int j=0;j<stkList1.size();j++){
				        	
				        	com.rms.hibernate.kitchenorderHibernate st = (com.rms.hibernate.kitchenorderHibernate)stkList1.get(j);
				        	Long ItemId = st.getItemId();
				        	Long PkItemId = st.getPk_temp_id();
				        	Long tableno = st.getTableNo();
				        	char actve = st.getActiveYN();
				        	System.out.println("item id and pk id from table - - "+ItemId+" &&&  "+PkItemId+" active status from table - "+actve);
				             	
				        	//If ItemName Is Already Exists In Stock Table  
				        	if(ItemId.equals(Long.parseLong(itemId)) && tableno.equals(Long.parseLong(tableNo)) && actve == 'Y'){
				        	 				 
				        		 com.rms.utility.HibernateUtility hbu1 = com.rms.utility.HibernateUtility.getInstance();
				        		 Session session1 = hbu1.getHibernateSession();
				        		 Transaction transaction1 = session1.beginTransaction();
				        		 
				        		 DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
				        		 Date date = new Date();
				        	System.out.println("when item id matches set n ");
				        	     com.rms.hibernate.kitchenorderHibernate updateStock = (com.rms.hibernate.kitchenorderHibernate) session1.get(com.rms.hibernate.kitchenorderHibernate.class, new Long(PkItemId));	 
				        		 updateStock.setActiveYN('N');
				        	//	 updateStock.setStock(updatequnty);
				        		 
				        		session1.saveOrUpdate(updateStock);
				        		transaction1.commit();
				        		break;
					
					
					
				}
				
			}  */
					TempItemDetailDao dao2 = new TempItemDetailDao();
					dao2.deletekitchenDataold(tableNo,itemId,hotelid);

}
				
				
}