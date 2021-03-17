package com.rms.helper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.GoodsReceiveReportBean;
import com.rms.dao.CustomerOrderDao;
import com.rms.dao.GoodsReceiveDao;
import com.rms.dao.kitchenorderDao;
import com.rms.dao.tempOrderbillDao;
import com.rms.hibernate.CustomerOrder;
import com.rms.hibernate.GoodsReceiveHibernate;

public class CustomerOrderHelper {

	Long BillNo;
	public void registerBill(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session3 = request.getSession();
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		CustomerOrderDao data = new CustomerOrderDao();
		List stkList  = data.getLastBillNo(request);
		
		for(int i=0;i<stkList.size();i++){
			
			CustomerOrder st = (CustomerOrder)stkList.get(i);
			BillNo = st.getBillNo();
			
			BillNo++;
		}
		
		com.rms.hibernate.CustomerOrder cust = new com.rms.hibernate.CustomerOrder();
		
		Integer count = Integer.parseInt(request.getParameter("count"));
//		System.out.println("count is -- "+count);

		for(int i=0;i<count;i++){
			
			String pkTempId = request.getParameter("pkTempId"+i);
			System.out.println("pktemp iD ---- > in customerHelper - > "+pkTempId);
			Long id = Long.parseLong(pkTempId);
			
			String newTempId = request.getParameter("itemId"+i);
			Long newid = Long.parseLong(newTempId);
			
//			System.out.println("Item ID ::  "+id);

			String itemName = request.getParameter("itemName"+i);
			cust.setItemName(itemName);
			
			String cgst = request.getParameter("cgst"+i);
			cust.setCgst(Double.parseDouble(cgst));
			
			String sgst = request.getParameter("sgst"+i);
			cust.setSgst(Double.parseDouble(sgst));
			System.out.println("cgst & sgst set is - "+cust.getCgst()+" & "+cust.getSgst());
			
			String waiterName = request.getParameter("waiterName");
			System.out.println("Waiter Name got WHILE SAVING ORDER IS - - - - -   "+waiterName);
			
		//	if(!"".equals(waiterName)){
			if(waiterName != null) {
			cust.setWaiterName(waiterName);
			System.out.println("SET WAITER NAME TO  - - - -"+cust.getWaiterName());
			}
			else 
			{
				cust.setWaiterName("N/A");
				System.out.println("SET WAITER NAME TO N/A - - "+cust.getWaiterName());
			}
			
			
			String totalAmount = request.getParameter("totalAmount");
			System.out.println("total grid amount is (helper) -----  "+totalAmount);
	//		Double totalAmount = Double.parseDouble(quantity)   * Double.parseDouble(prrice);
	//		cust.setTotalAmount(Double.parseDouble(totalAmount));
			
			String quantity= request.getParameter("quantity"+i);
			System.out.println("quantity from UI (in customerordrhelper)  --------------  > > @ "+quantity);
            cust.setQuantity(Double.parseDouble(quantity));
            
            String prrice= request.getParameter("prrice"+i);
			System.out.println("price ----- >"+prrice);
            cust.setUnitPrice(Double.parseDouble(prrice));
       
            String forTotal = request.getParameter("forTotal"+i);
            
    		Double totalAt = Double.parseDouble(quantity)   * Double.parseDouble(prrice);
    		System.out.println("total price quantity wise (helper) ----  "+totalAt);
    		
			/*
			 * if(!0.eqequals(cgst)){ var gst1 = ((cgst)/(100)*totalAt); totalAt = totalAt +
			 * gst1; } if(sgst != 0){ var gst2 = ((sgst)/(100)*totalAt); totalAt = totalAt +
			 * gst2; }
			 */
    		
    		cust.setTotalAmount(totalAt);
    		cust.setTotalAmt(totalAt); 
			/*
			 * cust.setTotalAmount(Double.parseDouble(forTotal));
			 * cust.setTotalAmt(Double.parseDouble(forTotal));
			 */
    		System.out.println("total -------------------------------------------------   "+cust.getTotalAmt());
    		System.out.println("item wise total (customerorderhelper) --> "+cust.getTotalAmount());
    		
            String unit= request.getParameter("unit"+i);
//			System.out.println("unitinMl"+unitinMl);
            cust.setUnit(unit);
            // cust.setUnitInMl(Double.parseDouble(unitinMl));
            String value = request.getParameter("value"+i);
            cust.setValue(Long.parseLong(value));
            System.out.println("unit set  -  "+cust.getUnit()+" , unitvalue - -  "+cust.getValue());
       //     String totalAmt1= request.getParameter("totalAmt"+i);
//           System.out.println("hi this total === "+totalAmt1);
            cust.setGridTotal(totalAmount);
            System.out.println("grid total set (customerorderhelper)  --->  "+cust.getGridTotal());
            
           /* Double totalAmt=Double.parseDouble(quantity)   * Double.parseDouble(prrice);
			System.out.println("totalAmt"+totalAmt);
            cust.setTotalAmt(totalAmt)*/;
            
           /* String totalAmt= request.getParameter("totalAmt"+i);
			System.out.println("totalAmt"+totalAmt);
            cust.setTotalAmt(Double.parseDouble(totalAmt));*/

            String gst = request.getParameter("gst");
            String gstAmt = request.getParameter("gstAmt");
            
            if(!"".equals(gst)) {
            cust.setGst(Double.parseDouble(gst));
            }
            else {
            	cust.setGst(0d);
            }
            if(!"".equals(gstAmt)) {
            cust.setGstAmt(Double.parseDouble(gstAmt));	
            }
            else {
            	cust.setGstAmt(0d);
            }
            
            
            String table_No = request.getParameter("table_No");
			/*if(!"".equals(table_No)) {
            cust.setTableNo(Long.parseLong(table_No)); 
			}
			else {
				cust.setTableNo(1l);
			}*/
            if(table_No==null) {
            	cust.setTableNo(1l);
            	System.out.println("in if section of table no - - ==========");
            }
            else
            {
            	cust.setTableNo(Long.parseLong(table_No));
            }
			System.out.println("table no when bill PRINTED IS  - - = - = - =  =  = =  "+cust.getTableNo());
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date dateobj = new Date();
//			System.out.println(df.format(dateobj));
			String newDate = df.format(dateobj);
			cust.setCurrent_date(dateobj);
			cust.setType("credit");
			cust.setOrderbill("Table wise Bill");
			session3.setAttribute("BillNo", BillNo);
			
			if(BillNo == null){
				cust.setBillNo(1l);
				}
				else
				{
					cust.setBillNo(BillNo);	
				}
			cust.setUsername(username);
			cust.setUserid(Long.parseLong(userid));
			cust.setHotelid(Long.parseLong(hotelid));
			cust.setHotelname(hotelname);
			System.out.println("hotelid saved - "+cust.getHotelid()+" , userid - "+cust.getUserid());
			CustomerOrderDao dao=new CustomerOrderDao();
			dao.registerBill(cust);
			
			Long pk_temp_id = Long.parseLong(request.getParameter("pkTempId"+i));
			System.out.println("pk_temp_id ---  (customerorder helper) to set N -- !! --  " +pk_temp_id);
			dao.updateTabaleStatus(pk_temp_id);
			
			
			kitchenorderDao daoo = new kitchenorderDao();
			List list = daoo.getAllkitchen(newTempId,hotelid);
			
				String table1  = request.getParameter("table_No");
			Long tableNo = Long.parseLong(table1);
			System.out.println("Table  - (cust order helper) to set N for kitchen order ORDER() - - "+tableNo);
		/*	daoo.updatetabStatus(tableNo);  */
			for(int k=0; k<list.size(); k++) {
	        	com.rms.hibernate.kitchenorderHibernate kt = (com.rms.hibernate.kitchenorderHibernate)list.get(k);
	        	Long pkidd = kt.getPk_temp_id();
	        	Long tabb = kt.getTableNo();
	        	char status = kt.getActiveYN();
	        	char M = 'N';
	        	System.out.println("pk ID - "+pkidd+" table no - - "+tabb+" active status - - "+status+"  - from all kitchen method - - ");
	        	if(tableNo.equals(tabb) && status=='Y') {
	        		
	       		 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
        		 Session session = hbu.getHibernateSession();
        		 Transaction transaction = session.beginTransaction();
        		 
        		 DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
        		 Date date = new Date();
        	
        	     com.rms.hibernate.kitchenorderHibernate update = (com.rms.hibernate.kitchenorderHibernate) session.get(com.rms.hibernate.kitchenorderHibernate.class, new Long(pkidd));	 
        		// updateStock.setUpdateDate(date);
        		 update.setActiveYN(M);
      //  		 updateStock.setStock(qunty);
        		session.saveOrUpdate(update);
        	
        		transaction.commit();
        		System.out.println("set N  to kitchen table of pkID - "+pkidd);
        		break;
	        	}
			}
			
			
			// stock update
			com.rms.dao.StockDao dao1 = new com.rms.dao.StockDao();
	        List stkList1  = dao1.getAllStockEntry1(newTempId,hotelid);
	        
	        for(int j=0;j<stkList1.size();j++){
	        	
	        	com.rms.hibernate.Stock st = (com.rms.hibernate.Stock)stkList1.get(j);
	        	Long ItemId = st.getFk_good_received_id();
	        	Long PkItemId = st.getPk_item_stock_id();
	        	
//	        	System.out.println("id from stock"+ItemId);
	        	
//	        	System.out.println("id from ui"+newid);
	        	
	        	//If ItemName Is Already Exists In Stock Table  
	        	if(ItemId.equals(newid)){
	        		 Double qunty = st.getStock();
	        		System.out.println("stock got from Database is (in customerorderhelper) ---------------> "+qunty);
	        		 Double updatequnty = (double) (qunty - Double.parseDouble(quantity));
	        		System.out.println("updated stock ie current stock minus ordered is (in customeerorderhelper)  ---------------->  "+updatequnty);		 
	        		 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
	        		 Session session = hbu.getHibernateSession();
	        		 Transaction transaction = session.beginTransaction();
	        		 
	        		 DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
	        		 Date date = new Date();
	        	
	        	     com.rms.hibernate.Stock updateStock = (com.rms.hibernate.Stock) session.get(com.rms.hibernate.Stock.class, new Long(PkItemId));	 
	        		// updateStock.setUpdateDate(date);
	        		 updateStock.setStock(updatequnty);
	      //  		 updateStock.setStock(qunty);
	        		session.saveOrUpdate(updateStock);
	        		transaction.commit();
	        		break;
	        	}
	        }  
			
		}
	}
	
	
	// -----------------------------------------------------------------------------------------
	
	
	
	public void registerBillnew(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session3 = request.getSession();
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		CustomerOrderDao data = new CustomerOrderDao();
		List stkList  = data.getLastBillNo(request);
		
		for(int i=0;i<stkList.size();i++){
			
			CustomerOrder st = (CustomerOrder)stkList.get(i);
			BillNo = st.getBillNo();
			
			BillNo++;
		}
		
		com.rms.hibernate.CustomerOrder cust = new com.rms.hibernate.CustomerOrder();
		
		Integer count = Integer.parseInt(request.getParameter("count"));
//		System.out.println("count is -- "+count);

		for(int i=0;i<count;i++){
			
	//		String pkTempId = request.getParameter("pkTempId"+i);
	//		System.out.println("pktemp iD ---- > in customerHelper - > "+pkTempId);
	//		Long id = Long.parseLong(pkTempId);
			
			String newTempId = request.getParameter("itemId"+i);
			Long newid = Long.parseLong(newTempId);
			
//			System.out.println("Item ID ::  "+id);

			String itemName = request.getParameter("itemName"+i);
			cust.setItemName(itemName);
			
			String cgst = request.getParameter("cgst"+i);
			cust.setCgst(Double.parseDouble(cgst));
			String sgst = request.getParameter("sgst"+i);
			cust.setSgst(Double.parseDouble(sgst));
			System.out.println("cgst & sgst set is - "+cust.getCgst()+" & "+cust.getSgst());
			String waiterName = request.getParameter("waiterName");
			System.out.println("Waiter Name got WHILE SAVING ORDER IS - - - - -   "+waiterName);
			
		//	if(!"".equals(waiterName)){
			if(waiterName != null) {
			cust.setWaiterName(waiterName);
			System.out.println("SET WAITER NAME TO  - - - -"+cust.getWaiterName());
			}
			else 
			{
				cust.setWaiterName("N/A");
				System.out.println("SET WAITER NAME TO N/A - - "+cust.getWaiterName());
			}
			
			
			String totalAmount = request.getParameter("totalAmount");
			System.out.println("total grid amount is (helper) --  -     "+totalAmount);
	//		Double totalAmount = Double.parseDouble(quantity)   * Double.parseDouble(prrice);
	//		cust.setTotalAmount(Double.parseDouble(totalAmount));
			
			String gst = request.getParameter("gst");
			String gstAmt = request.getParameter("gstAmt");
        	cust.setGst(0d);
        	cust.setGstAmt(0d);
/*			if(!"".equals(gst)) {
		            cust.setGst(Double.parseDouble(gst));
		            }
		            else {
		            	cust.setGst(0d);
		            }
		            if(!"".equals(gstAmt)) {
		            cust.setGstAmt(Double.parseDouble(gstAmt));	
		            }
		            else {
		            	cust.setGstAmt(0d);
		            }*/
			
			String quantity= request.getParameter("quantity"+i);
			System.out.println("quantity from UI (in customerordrhelper)  --------------  > > @ "+quantity);
            cust.setQuantity(Double.parseDouble(quantity));
            
            String prrice= request.getParameter("prrice"+i);
			System.out.println("price ----- >"+prrice);
            cust.setUnitPrice(Double.parseDouble(prrice));
            
        //    String forTotal = request.getParameter("forTotal"+i);
       
    		Double totalAt = Double.parseDouble(quantity)   * Double.parseDouble(prrice);
    		System.out.println("total price * quantity wise (helper) ----  "+totalAt);
    		cust.setTotalAmount(totalAt);
    		cust.setTotalAmt(totalAt);
			/*
			 * cust.setTotalAmount(Double.parseDouble(forTotal));
			 * cust.setTotalAmt(Double.parseDouble(forTotal));
			 */
            
    		System.out.println("total -------------------------------------------------   "+cust.getTotalAmt());
    		System.out.println("item wise total (customerorderhelper) --> "+cust.getTotalAmount());
    		
            String unit= request.getParameter("unit"+i);
//			System.out.println("unitinMl"+unitinMl);
            cust.setUnit((unit));
           
            String value = request.getParameter("value"+i);
            cust.setValue(Long.parseLong(value));
            
       //     String totalAmt1= request.getParameter("totalAmt"+i);
//           System.out.println("hi this total === "+totalAmt1);
            cust.setGridTotal(totalAmount);
            System.out.println("grid total set (customerorderhelper)  --->  "+cust.getGridTotal());
            
           /* Double totalAmt=Double.parseDouble(quantity)   * Double.parseDouble(prrice);
			System.out.println("totalAmt"+totalAmt);
            cust.setTotalAmt(totalAmt)*/;
            
           /* String totalAmt= request.getParameter("totalAmt"+i);
			System.out.println("totalAmt"+totalAmt);
            cust.setTotalAmt(Double.parseDouble(totalAmt));*/
            
            String table_No = request.getParameter("table_No");
			/*if(!"".equals(table_No)) {
            cust.setTableNo(Long.parseLong(table_No)); 
			}
			else {
				cust.setTableNo(1l);
			}*/
            if(table_No==null) {
            	cust.setTableNo(0l);
            	System.out.println("in if section of table no - - ======  "+cust.getTableNo());
            }
            else
            {
            	cust.setTableNo(Long.parseLong(table_No));
            }
			System.out.println("table no when bill PRINTED IS  - - = - = - =  =  = =  "+cust.getTableNo());
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date dateobj = new Date();
//			System.out.println(df.format(dateobj));
			String newDate = df.format(dateobj);
			cust.setCurrent_date(dateobj);
			cust.setType("credit");
			cust.setOrderbill("Kiosk Bill");
			session3.setAttribute("BillNo", BillNo);
			
			if(BillNo == null){
				cust.setBillNo(1l);
				}
				else
				{
					cust.setBillNo(BillNo);	
				}
			
			cust.setUsername(username);
			cust.setUserid(Long.parseLong(userid));
			cust.setHotelid(Long.parseLong(hotelid));
			cust.setHotelname(hotelname);
			System.out.println("hotelid saved  - "+cust.getHotelid()+" , userid - "+cust.getUserid());
			CustomerOrderDao dao=new CustomerOrderDao();
			dao.registerBill(cust);
			
		//	Long pk_temp_id = Long.parseLong(request.getParameter("pkTempId"+i));
		//	System.out.println("pk_temp_id ---  (customerorder helper) to set N -- !! --  " +pk_temp_id);
		//	dao.updateTabaleStatusnew(pk_temp_id);
			
	// =========================================================================================== to set N   -- 	
		
			String newTemp = request.getParameter("itemId"+i);
			Long newi = Long.parseLong(newTemp);
			
			tempOrderbillDao daoo = new tempOrderbillDao();
			List list = daoo.getAllnewtabEntry(newTemp,hotelid);
			
		
			
//			String newTemp = request.getParameter("itemId");
//			Long nwItemid = Long.parseLong(newTemp);
			
			System.out.println("Item id  - (cust order helper) to set N for newOrder table  - - "+newi);
		/*	daoo.updatetabStatus(tableNo);  */
			for(int k=0; k<list.size(); k++) {
	        	
				com.rms.hibernate.newTempItemDetail kt = (com.rms.hibernate.newTempItemDetail)list.get(k);
	        //	Long pkid = kt.getPk_temp_id();
	        	Long pkItem = kt.getPk_temp_id();
	        	Long itemID = kt.getItemId();
	        	char actv = kt.getActiveYN();
	        	
	        	System.out.println("IN FOR LOOP to set ```N```` from newTabletemp  pk ID - "+pkItem+",,   Item ID- - "+itemID);
	     //   	if(newi.equals(itemID) && actv =='Y') {
	        		if(actv =='Y') {
	       		 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
        		 Session session = hbu.getHibernateSession();
        		 Transaction transaction = session.beginTransaction();
        		 
        		 DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
        		 Date date = new Date();
        	
        	     com.rms.hibernate.newTempItemDetail upd = (com.rms.hibernate.newTempItemDetail) session.get(com.rms.hibernate.newTempItemDetail.class, new Long(pkItem));	 
        		// updateStock.setUpdateDate(date);
        		 upd.setActiveYN('N');
      //  		 updateStock.setStock(qunty);
        		session.saveOrUpdate(upd);
        		System.out.println("set N -- to newTAble  ``````````````````  ");
        		transaction.commit();
        		break;
	        	}
			}
			
			
			
			
			
		// -------========================= stock updation ===================================	
			
			com.rms.dao.StockDao dao1 = new com.rms.dao.StockDao();
	        List stkList1  = dao1.getAllStockEntry1(newTempId, hotelid);
	        
	        for(int j=0;j<stkList1.size();j++){
	        	
	        	com.rms.hibernate.Stock st = (com.rms.hibernate.Stock)stkList1.get(j);
	        	Long ItemId = st.getFk_good_received_id();
	        	Long PkItemId = st.getPk_item_stock_id();
	        	
//	        	System.out.println("id from stock"+ItemId);
	        	
//	        	System.out.println("id from ui"+newid);
	        	
	        	//If ItemName Is Already Exists In Stock Table  
	        	if(ItemId.equals(newid)){
	        		 Double qunty = st.getStock();
	        		System.out.println("stock got from Database is (in customerorderhelper) ---------------> "+qunty);
	        		 Double updatequnty = (double) (qunty - Double.parseDouble(quantity));
	        		System.out.println("updated stock ie current stock minus ordered is (in customeerorderhelper)  ---------------->  "+updatequnty);		 
	        		 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
	        		 Session session = hbu.getHibernateSession();
	        		 Transaction transaction = session.beginTransaction();
	        		 
	        		 DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
	        		 Date date = new Date();
	        	
	        	     com.rms.hibernate.Stock updateStock = (com.rms.hibernate.Stock) session.get(com.rms.hibernate.Stock.class, new Long(PkItemId));	 
	        		// updateStock.setUpdateDate(date);
	        		 updateStock.setStock(updatequnty);
	      //  		 updateStock.setStock(qunty);
	        		session.saveOrUpdate(updateStock);
	        		transaction.commit();
	        		break;
	        	}
	        }  
			
		}
	}
	
	
	
	
	
	
	public void OrderBillCOPY(HttpServletRequest request, HttpServletResponse response) {
		String billNo = request.getParameter("Bill_No");
		System.out.println("hi this is Bill No==== "+billNo);
		String tableno =request.getParameter("table_No");
		System.out.println("hit this isTable No  Is===== "+tableno);
		
		System.out.println("----------------Credit cust Bill No before session create: :"+billNo);
		
		HttpSession session3 = request.getSession();
		
		Long billNo2 = Long.parseLong(billNo);
		//String billNo2 =String.valueOf(billNo);
		
		String bill = billNo2.toString();
		
		session3.setAttribute("BillNo", bill);
		
		System.out.println("----------------Credit cust Bill No before session create::- "+session3.getAttribute("BillNo"));
		
	}
	
	// for bill copy

	public Map getAllBillNo(String TableNo) {

		CustomerOrderDao dao = new CustomerOrderDao();
		List list = dao.getAllBillNo1(TableNo);
		Map map = new HashMap();
		System.out.println("map ---- > " + map);
		for (int i = 0; i < list.size(); i++) {
			Object[] o = (Object[]) list.get(i);
			CustomerOrder bean = new CustomerOrder();
			System.out.println("Result (in for loop) --> "+Arrays.toString(o));

			/*
			 * String pendingBal = o[0].toString(); if
			 * (pendingBal.equals("0.0")) { continue;
			 * 
			 * }
			 */ /* else { */
			bean.setBillNo(Long.parseLong(o[0].toString()));
			bean.setPk_custOrder_id(Long.parseLong(o[1].toString()));
			/* } */
			// bean.setTotalAmount((Double)o[1]);
			System.out.println("********* - " + o[0]);
			map.put(bean.getBillNo(), bean);
		}
		return map;
	}
	
	public List getattendedWaitersReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			String waiterName = request.getParameter("waiterName");
			String dateto = request.getParameter("dateto");
			String datefrom = request.getParameter("datefrom");
	        Map<Long,CustomerOrder> map = new HashMap<Long,CustomerOrder>();
			
	        CustomerOrderDao dao = new CustomerOrderDao();
			List<CustomerOrder> catList = dao.getattendedWaiterReport(waiterName,dateto,datefrom,hotelid,usertype);
			return catList;
	}	
	
	// credit report
	public List getcreditDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+"  ad = "+usertype);
		
		String creditdatefrm = request.getParameter("creditdatefrm");
		String creditdateto = request.getParameter("creditdateto");
		System.out.println("credit receive date between ----  "+creditdatefrm+" -&- "+creditdateto);
		Map<Long,CustomerOrder> map = new HashMap<Long,CustomerOrder>();
		
        CustomerOrderDao dao = new CustomerOrderDao();
        List<CustomerOrder> catList = dao.getcreditDateWiseReport(creditdatefrm, creditdateto, hotelid,usertype);
        return catList;
	}
	
	
	
	
	
/*	Long billNo = 0L;
	
	CustomerOrderDao data = new CustomerOrderDao();
	List stkList  = data.getLastBillNo();
	
	if(stkList.size() <=0) {
		billNo = 1L;
	}
} */
}
