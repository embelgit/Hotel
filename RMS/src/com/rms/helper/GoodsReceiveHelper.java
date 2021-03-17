package com.rms.helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.GoodsReceiveBean;
import com.rms.bean.GoodsReceiveReportBean;
import com.rms.bean.ItemDetailss;
import com.rms.bean.SaleReport;
import com.rms.dao.CashBookDao;
import com.rms.dao.GoodsReceiveDao;
import com.rms.hibernate.GoodsReceiveHibernate;
import com.rms.hibernate.ItemDetails;
import com.rms.hibernate.ItemEntry;

public class GoodsReceiveHelper {
/*public List getGridForGoodReceiveGridData(String fk_item_id_drop1)*/

public List getGridForGoodReceiveGridData(HttpServletRequest request, HttpServletResponse response)
{
			/*GoodsReceiveBean bean = new GoodsReceiveBean();
			bean.setFk_item_id_drop1(fk_item_id_drop1); 
			System.out.println("fk_item_id_drop1 "+fk_item_id_drop1);
			return bean;*/
			String fk_item_id_drop1 = request.getParameter("fk_item_id1");		
			System.out.println(" hi this is Item Name is -=============   "+fk_item_id_drop1);		
			GoodsReceiveDao dao = new GoodsReceiveDao();
			// Map<Long,OutwardBean> map = new HashMap<Long,OutwardBean>();
//			 List<ItemDetailss> expL= dao.getGridDataForgoodreceive(fk_item_id_drop1);
			 List<ItemEntry> expL = dao.getGridDataForgoodreceive(fk_item_id_drop1);
			 System.out.println("in helper method of item grid -");
			 return expL;
}
	//adding stock
	public void doaddGoodsReceive(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		 Integer count = Integer.parseInt(request.getParameter("count"));
         System.out.println("Total Count Is =====-------  "+count);
         
         String nwfkSupplierId = request.getParameter("fk_supplier_id");
         String nwsuplierName = request.getParameter("suplierName");
         String nwgrossTotal = request.getParameter("grossTotal");
         System.out.println(" Suppler Id is ----== == = "+nwfkSupplierId+" supp name -   "+nwsuplierName+"  gross total -  -   "+nwgrossTotal+"  --  >  in out of for loop ");
         
         for(int i =0 ; i<count;i++)
 		{
        
      //  String fk_item_id1 = request.getParameter("fk_item_id1");
       // System.out.println(" hi this is Fk ID----------======= "+fk_item_id1);
        
        String fkSupplierId = request.getParameter("fk_supplier_id");
        System.out.println(" Suppler Id is ----== == = "+fkSupplierId);
        String suplierName = request.getParameter("suplierName");
        String billno = request.getParameter("billno");
        String goodsReceiveDate = request.getParameter("goodsReceiveDate");
        
        String fk_item_id_drop1 = request.getParameter("fk_item_id_drop1"+i);
        
        System.out.println(" hi this is item name            ---    "+fk_item_id_drop1);
        String buyPrice = request.getParameter("buyPrice"+i);
        String quantity = request.getParameter("quantity"+i);
        String gst = request.getParameter("gst"+i);
        String total = request.getParameter("total"+i);
        System.out.println("HI this is Total===++++"+total);
        String pk_item_entry_Id =request.getParameter("pk_item_entry_Id"+i);
        System.out.println(" Hi this is pk_item_entry_Id ===----- "+pk_item_entry_Id);
        
        String itemName = request.getParameter("fk_item_id1");
        System.out.println("item name -----------------  > > "+itemName);
        
        String salePrice = request.getParameter("salePrice"+i);
        System.out.println("sale price is ==="+salePrice);
        
        String igst = request.getParameter("igst"+i);
        String cgst = request.getParameter("cgst"+i);
        String sgst = request.getParameter("sgst"+i);
        System.out.println("igst - "+igst+" cgst - "+cgst+" sgst - "+sgst);
        
        String unit = request.getParameter("unit"+i);
        System.out.println("sale price is ==="+unit);
        String HSNNo = request.getParameter("HSNNo"+i);
        System.out.println("sale HSNNo is ==="+HSNNo);
        String grossTotal = request.getParameter("grossTotal");	
 		
        String value = request.getParameter("value"+i);
  
        System.out.println("unit -  "+unit+" & value quant - "+value);
        
        GoodsReceiveHibernate b = new GoodsReceiveHibernate();
        
        System.out.println(" date before parsing" +goodsReceiveDate);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date closingDate = null;
		
		try{
			closingDate = format.parse(goodsReceiveDate);
			b.setGoodsReceiveDate(closingDate);
			System.out.println(" date dateOfBirth parsing" +goodsReceiveDate);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in date parsing");
		}
        
		b.setFk_item_id(Long.parseLong(pk_item_entry_Id));
      //  b.setFk_item_id(Long.parseLong(fk_item_id));
        b.setFkSupplierId(Long.parseLong(fkSupplierId));
 		b.setFk_item_id_drop1(fk_item_id_drop1);
        
 //		b.setFk_item_id_drop1(itemName);
        
 		b.setSuplierName(suplierName);
 		b.setBillno(Long.parseLong(billno));
 		b.setBuyPrice(Double.parseDouble(buyPrice));
 		b.setQuantity(Double.parseDouble(quantity));
 		b.setSaleprice(Double.parseDouble(salePrice));
 		b.setUnit(unit);
 		b.setValue(Long.parseLong(value));
 		
 		b.setUsername(username);
		b.setUserid(Long.parseLong(userid));
		b.setHotelid(Long.parseLong(hotelid));
		b.setHotelname(hotelname);
 		
 		if(!"".equals(igst)) {
 		b.setIgst(Double.parseDouble(igst));
 		}
 		else
 		{
 			b.setIgst(0d);
 		}
 		if(!"".equals(cgst)) {
 		b.setCgst(Double.parseDouble(cgst));
 		}
 		else
 		{
 			b.setCgst(0d);
 		}
 		if(!"".equals(sgst)) {
 		b.setSgst(Double.parseDouble(sgst));
 		}
 		else
 		{
 			b.setSgst(0d);
 		}
 		
 		System.out.println(" unit set -  "+b.getUnit()+" unit value set --  "+b.getValue()+" Item Name sett - "+b.getFk_item_id_drop1());
 		
 		if(HSNNo==null) {
 		b.setHsnno("0");
 		}
 		else {
 	 		b.setHsnno(HSNNo); 		
 		}
 		
/* 		if(!"".equals(gst)) {
 		b.setGst(Double.parseDouble(gst));
 		}
 		else
 		{
 			b.setGst(0d);
 		} */

 		b.setTotal(Double.parseDouble(total));
 		b.setGrossTotal(Double.parseDouble(grossTotal));
 		
 		
 		 /* To Update Stock in Stock Table*/
        com.rms.dao.StockDao dao1 = new com.rms.dao.StockDao();
        List stkList  = dao1.getAllStockEntry(pk_item_entry_Id,hotelid);
        
        /*If Stock Is Empty */ 
        if(stkList.size() == 0){
        	System.out.println("in hello1 stkList.size()= = = - "+stkList.size());
        	com.rms.hibernate.Stock newEntry = new com.rms.hibernate.Stock();
			
			newEntry.setFk_good_received_id(Long.parseLong(pk_item_entry_Id));
			newEntry.setStock(Double.parseDouble(quantity));
			newEntry.setItemname(fk_item_id_drop1);
			newEntry.setUserid(Long.parseLong(userid));
			newEntry.setUsername(username);
			newEntry.setHotelid(Long.parseLong(hotelid));
			newEntry.setHotelname(hotelname);
			System.out.println("item name  "+newEntry.getItemname());
			com.rms.dao.StockDao dao2 = new com.rms.dao.StockDao();
			dao2.registerStock(newEntry);	
        	
        }
        else/*To Update Stock Table If It is Not Empty */
        {
        	
        for(int j=0;j<stkList.size();j++){
        //	System.out.println("hi this is 2");
        	
        	com.rms.hibernate.Stock st = (com.rms.hibernate.Stock)stkList.get(j);
        	Long ItemId = st.getFk_good_received_id();
        	
        	Long PkItemId = st.getPk_item_stock_id();
        	
        	/*If ItemName Is Already Exists In Stock Table */ 
        	if(ItemId.equals(Long.parseLong(pk_item_entry_Id))){
        		 Double qunty = st.getStock();
        		
        		 Double updatequnty = (double) (qunty + Double.parseDouble(quantity));
        		 System.out.println("for loop stock update Quantity---------- "+updatequnty);
        				 
  
        		 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
        		 Session session = hbu.getHibernateSession();
        		 Transaction transaction = session.beginTransaction();
        		 
        		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        		 Date date = new Date();
        	
        		 com.rms.hibernate.Stock updateStock = (com.rms.hibernate.Stock) session.get(com.rms.hibernate.Stock.class, new Long(PkItemId));	 
        		// updateStock.setUpdateDate(date);
        		 updateStock.setStock(updatequnty);
        		 
        		 updateStock.setItemname(fk_item_id_drop1);
        		 
        		session.saveOrUpdate(updateStock);
        		System.out.println("stock updated !!");
        		transaction.commit();
        		break;
        	}
        	else
        	{
        		//ItemName is Not Exists 
        		if(j+1 == stkList.size()){
        			System.out.println("HI this is List after More3 Item=-======   "+stkList.size());
        			com.rms.hibernate.Stock newEntry = new com.rms.hibernate.Stock();
        			
        			newEntry.setFk_good_received_id(Long.parseLong(pk_item_entry_Id));
        			newEntry.setStock(Double.parseDouble(quantity));
        			newEntry.setItemname(fk_item_id_drop1);
        			newEntry.setUserid(Long.parseLong(userid));
        			newEntry.setUsername(username);
        			newEntry.setHotelid(Long.parseLong(hotelid));
        			newEntry.setHotelname(hotelname);
        			System.out.println("item name || "+newEntry.getItemname());
        			com.rms.dao.StockDao dao2 = new com.rms.dao.StockDao();
        			dao2.registerStock(newEntry);	
        			break;
        		}
        	}
        	
          }	
        }
        
     	
        
 		GoodsReceiveDao dao = new GoodsReceiveDao();
 		dao.GoodsReceiveHibernate(b);
 		

       } 
         
         //   ---------------------------------------------------
         
         
      // CASH BOOK ENTRY -----	
  		
         com.rms.dao.CashBookDao daoo = new com.rms.dao.CashBookDao();
         List cblist = daoo.getAllcashBookEntry(nwfkSupplierId,hotelid);
         
         // cash book update if cash is empty
         if(cblist.size() == 0){
         	System.out.println("iN cashbook List.size() goodsrecievehelper, updating total = = =  "+cblist.size());
         	com.rms.hibernate.CashBook newEntry = new com.rms.hibernate.CashBook();
  			
  		//	newEntry.setFk_good_received_id(Long.parseLong(pk_item_entry_Id));
  		//	newEntry.setStock(Double.parseDouble(quantity));
  		//	newEntry.setItemname(fk_item_id_drop1);
  		//	System.out.println("item name  "+newEntry.getItemname());
         	newEntry.setFkSupplierId(Long.parseLong(nwfkSupplierId));
         	newEntry.setToPayNameId(nwsuplierName);
         	newEntry.setPaymentAmountId(Double.parseDouble(nwgrossTotal));
         	newEntry.setRemainingBalance(Double.parseDouble(nwgrossTotal));
         	System.out.println("when size is 0 in CASHBOOK - - -  fk supp  ID "+newEntry.getFkSupplierId()+" supp name - - "+newEntry.getToPayNameId()+" total amount sett  -  "+newEntry.getPaymentAmountId()+"  reamining bal set  "+newEntry.getRemainingBalance());
         	newEntry.setPayToId("supplier");		
//         	newEntry.setToPayNameId(suplierName);
         	newEntry.setPaymentTypeId("NA");
         	newEntry.setPaymebtById("NA");
         	newEntry.setChequeNoId(0l);
         	newEntry.setCardNoId(0l);
         	newEntry.setNeftAccNoId(0l);
        // 	newEntry.setPaymentAmountId(0d);
         	newEntry.setPayingAmountId(0d);
         	newEntry.setPaymentReasonId("NA");
         	newEntry.setTransID(Long.parseLong("0"));
         	newEntry.setFkemployeeId(0l);
         	newEntry.setUserid(Long.parseLong(userid));
			newEntry.setUsername(username);
			newEntry.setHotelid(Long.parseLong(hotelid));
			newEntry.setHotelname(hotelname);
       //  	newEntry.setRemainingBalance(0d);
//     		cb.setFkSupplierId(suppID);
     		
         	try {
         		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         		Date dateobj = new Date();
         		String CurrentDate = df.format(dateobj);
         		Date newdate = df.parse(CurrentDate);		
         		newEntry.setChequeDateId(newdate);
         		newEntry.setPaymentDate(newdate);
         		}
         		catch(Exception e) {
         			e.printStackTrace();
         		}
         	com.rms.dao.CashBookDao dao2 = new com.rms.dao.CashBookDao();
  			dao2.registerCB(newEntry);	
         	
         }
         else  //To Update cash Table If It is Not Empty 
         {
         	
         for(int j=0;j<cblist.size();j++){
         	System.out.println("in for loop of cash book update  ");
         	
         	com.rms.hibernate.CashBook st = (com.rms.hibernate.CashBook)cblist.get(j);
    //     	Long ItemId = st.getFk_good_received_id();
     //    	Long PkItemId = st.getPk_item_stock_id();
         		Long supplierID = st.getFkSupplierId();
         		String suppName  = st.getToPayNameId();
         		Long PkItemId = st.getPkCashBookEntry();
         	
         	/*If supplier Is Already Exists In cashbook Table */ 
         	if(supplierID.equals(Long.parseLong(nwfkSupplierId))){
         		 Double totalAt = st.getPaymentAmountId();
         		 Double remainBal = st.getRemainingBalance();
         		 Double updatetotalAmt = (double) (totalAt + Double.parseDouble(nwgrossTotal));
         		 Double updateremainBal = (double) (remainBal + Double.parseDouble(nwgrossTotal));
         		 
         		 System.out.println("total updated amount is  ---------- Rs. "+updatetotalAmt+" and Remain Bal updated amount is -  Rs. "+updateremainBal+"  in CASHBOOK ");
         				 
   
         		 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
         		 Session session = hbu.getHibernateSession();
         		 Transaction transaction = session.beginTransaction();
         		 
         		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
         		 Date date = new Date();
         	
         		 com.rms.hibernate.CashBook updatetotal = (com.rms.hibernate.CashBook) session.get(com.rms.hibernate.CashBook.class, new Long(PkItemId));	 
         		// updateStock.setUpdateDate(date);
         		 updatetotal.setPaymentAmountId(updatetotalAmt);
         		 updatetotal.setToPayNameId(suppName);
         		 updatetotal.setFkSupplierId(Long.parseLong(nwfkSupplierId));
         		 System.out.println("supp name is - "+updatetotal.getToPayNameId()+" & supp ID is - - - "+updatetotal.getFkSupplierId());
         		 updatetotal.setRemainingBalance(updateremainBal);
         		session.saveOrUpdate(updatetotal);
         		transaction.commit();
         		break;
         	}
         	else
         		{
      		//supplier is Not Exists 
      		if(j+1 == cblist.size()){
      			System.out.println("in else loop where supp name not exist   "+cblist.size());
      			com.rms.hibernate.CashBook newEntry = new com.rms.hibernate.CashBook();
      			
//      			newEntry.set(Long.parseLong(pk_item_entry_Id));
      			newEntry.setToPayNameId(suppName);
      			newEntry.setPaymentAmountId(Double.parseDouble(nwgrossTotal));
      			newEntry.setFkSupplierId(Long.parseLong(nwfkSupplierId));
      			newEntry.setRemainingBalance(Double.parseDouble(nwgrossTotal));
      			newEntry.setUserid(Long.parseLong(userid));
    			newEntry.setUsername(username);
    			newEntry.setHotelid(Long.parseLong(hotelid));
    			newEntry.setHotelname(hotelname);
      			System.out.println("item name || -  "+newEntry.getToPayNameId()+" total amount set when supp not exist "+newEntry.getPaymentAmountId()+" supp fk ID -- "+newEntry.getFkSupplierId()+" Reamining bal set is - - - "+newEntry.getRemainingBalance()+" in CASHBOOK ");
      			com.rms.dao.CashBookDao dao2 = new com.rms.dao.CashBookDao();
      			dao2.registerCB(newEntry);	
      			break;
      		}
      	}
         }
         } 
         
	}
	
	
	
	
	// get stock entry report
				public List getGoodsReceiveReport(HttpServletRequest request,HttpServletResponse response) throws IOException {
					
					HttpSession sessionn = request.getSession(true);
					String username = (String)sessionn.getAttribute("user");		
					String userid = (String)sessionn.getAttribute("userid");
					String hotelid = (String)sessionn.getAttribute("hotelid");
					String hotelname=(String)sessionn.getAttribute("hotelname");
					String usertype = (String)sessionn.getAttribute("usertype");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
					//  PrintWriter out = response.getWriter();
					
					String itemName = request.getParameter("itemName");

				        Map<Long,GoodsReceiveReportBean> map = new HashMap<Long,GoodsReceiveReportBean>();
						
				        GoodsReceiveDao dao = new GoodsReceiveDao();
//						List<GoodsReceiveReportBean> exp1List = dao.getGoodsReceiveReport(itemName);
						List<GoodsReceiveReportBean> catList = dao.getGoodsReceiveReport(itemName,hotelid,usertype);
						/*	if(exp1List.size()>0)
						{
							return exp1List;
						}
						else
						{
							
							out.println("alert('No Data. .')");
							
							return null;
						}  */
						return catList;
				}
			public List getgoodsreceiveReport(HttpServletRequest request, HttpServletResponse response) {
				HttpSession sessionn = request.getSession(true);
				String username = (String)sessionn.getAttribute("user");		
				String userid = (String)sessionn.getAttribute("userid");
				String hotelid = (String)sessionn.getAttribute("hotelid");
				String hotelname=(String)sessionn.getAttribute("hotelname");
				String usertype = (String)sessionn.getAttribute("usertype"); 
				System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
				String supplierName = request.getParameter("supplierName");
				String datefrom = request.getParameter("datefrom");
				String dateto = request.getParameter("dateto");
		        Map<Long,GoodsReceiveHibernate> map = new HashMap<Long,GoodsReceiveHibernate>();
				
		        GoodsReceiveDao dao = new GoodsReceiveDao();
		        List<GoodsReceiveHibernate> catList = dao.getgoodsreceiveReport(supplierName,datefrom,dateto,hotelid,usertype);
		        return catList;
			}	
			
			public List getgoodReceiveDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
				HttpSession sessionn = request.getSession(true);
				String username = (String)sessionn.getAttribute("user");		
				String userid = (String)sessionn.getAttribute("userid");
				String hotelid = (String)sessionn.getAttribute("hotelid");
				String hotelname=(String)sessionn.getAttribute("hotelname");
				String usertype = (String)sessionn.getAttribute("usertype"); 
				System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" , usrtype - "+usertype);
				String goodReceiveDate = request.getParameter("goodReceiveDate");
				String goodReceiveDateto = request.getParameter("goodReceiveDateto");
				System.out.println("goods receive date ----  "+goodReceiveDate+" & "+goodReceiveDateto);
				Map<Long,GoodsReceiveHibernate> map = new HashMap<Long,GoodsReceiveHibernate>();
				
		        GoodsReceiveDao dao = new GoodsReceiveDao();
		        List<GoodsReceiveHibernate> catList = dao.getgoodReceiveDateWiseReport(goodReceiveDate, goodReceiveDateto,hotelid,usertype);
		        return catList;
			}
			
			
				
}
