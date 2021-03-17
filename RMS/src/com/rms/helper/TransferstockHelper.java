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
import com.rms.dao.TransferstockDao;
import com.rms.hibernate.GoodsReceiveHibernate;
import com.rms.hibernate.ItemDetails;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.transferstockHibernate;


public class TransferstockHelper {
	
	/*public List getGridForGoodReceiveGridData(String fk_item_id_drop1)*/

	public List getGridForTransferStock(HttpServletRequest request, HttpServletResponse response)
	{
				/*GoodsReceiveBean bean = new GoodsReceiveBean();
				bean.setFk_item_id_drop1(fk_item_id_drop1); 
				System.out.println("fk_item_id_drop1 "+fk_item_id_drop1);
				return bean;*/
				String fk_item_id_drop1 = request.getParameter("fk_item_id1");		
				System.out.println(" hi this is Item Name is -=============   "+fk_item_id_drop1);		
				TransferstockDao dao = new TransferstockDao();
				// Map<Long,OutwardBean> map = new HashMap<Long,OutwardBean>();
//				 List<ItemDetailss> expL= dao.getGridDataForgoodreceive(fk_item_id_drop1);
				 List<ItemEntry> expL = dao.getGridTransferStock(fk_item_id_drop1);
				 System.out.println("in helper method of item grid -");
				 return expL;
	}
	
	
public void addTranferstock(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		/*
		 * String hotelid = (String)sessionn.getAttribute("hotelid"); String
		 * hotelname=(String)sessionn.getAttribute("hotelname");
		 */
		 String hotelid = (String)sessionn.getAttribute("hotelid");

		//System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+nwshopName+" , hotelid - "+hotelid);
		
		 Integer count = Integer.parseInt(request.getParameter("count"));
         System.out.println("Total Count Is =====-------  "+count);
         
         String nwfkShopId = request.getParameter("hotelid");
         String nwshopName = request.getParameter("hotelName");
       //  String nwgrossTotal = request.getParameter("grossTotal");
         System.out.println(" Hotel Id is ----== == = "+nwfkShopId+" hotel name -   "+nwshopName+"   --  >  in out of for loop ");
         
         for(int i =0 ; i<count;i++)
 		{
        
      //  String fk_item_id1 = request.getParameter("fk_item_id1");
       // System.out.println(" hi this is Fk ID----------======= "+fk_item_id1);
        
        String pkshopId = request.getParameter("hotelid");
        System.out.println(" Shop Id is ----== == = "+hotelid);
        String hotelName = request.getParameter("hotelName");
        //String billno = request.getParameter("billno");
        //String goodsReceiveDate = request.getParameter("goodsReceiveDate");
        
        String fk_item_id_drop1 = request.getParameter("fk_item_id_drop1"+i);
        
        System.out.println(" hi this is item name            ---    "+fk_item_id_drop1);
       String buyPrice = request.getParameter("buyPrice"+i);
        String quantity = request.getParameter("quantity"+i);
        //String gst = request.getParameter("gst"+i);
        String total = request.getParameter("total"+i);
        System.out.println("HI this is Total===++++"+total);
        String pk_item_entry_Id =request.getParameter("pk_item_entry_Id"+i);
        System.out.println(" Hi this is pk_item_entry_Id ===----- "+pk_item_entry_Id);
        
        String itemName = request.getParameter("fk_item_id1");
        System.out.println("item name -----------------  > > "+itemName);
        
        String salePrice = request.getParameter("salePrice"+i);
        System.out.println("sale price is ==="+salePrice);
        
     //  String igst = request.getParameter("igst"+i);
      //  String cgst = request.getParameter("cgst"+i);
      //  String sgst = request.getParameter("sgst"+i);
      //  System.out.println("igst - "+igst+" cgst - "+cgst+" sgst - "+sgst);
        
        //String unit = request.getParameter("unit"+i);
     //   System.out.println("sale price is ==="+unit);
      //  String HSNNo = request.getParameter("HSNNo"+i);
       // System.out.println("sale HSNNo is ==="+HSNNo);
        //String grossTotal = request.getParameter("grossTotal");	
 		
        String value = request.getParameter("value"+i);
  
       // System.out.println("unit -  "+unit+" & value quant - "+value);
        
        transferstockHibernate b = new transferstockHibernate();
        
       // System.out.println(" date before parsing" +goodsReceiveDate);
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Date closingDate = null;
		
		//try{
		///closingDate = format.parse(goodsReceiveDate);
			//b.setGoodsReceiveDate(closingDate);
			//System.out.println(" date dateOfBirth parsing" +goodsReceiveDate);
		//}
		//catch(Exception e){
			//e.printStackTrace();
		//	System.out.println("Exception in date parsing");
		//}
        
		b.setFk_item_id(Long.parseLong(pk_item_entry_Id));
      //  b.setFk_item_id(Long.parseLong(fk_item_id));
      //  b.setFkSupplierId(Long.parseLong(fkSupplierId));
		//b.setHotelid(Long.parseLong(pkhotelId));
        b.setHotelid(Long.parseLong(pkshopId));
 		b.setFk_item_id_drop1(fk_item_id_drop1);
        
 //		b.setFk_item_id_drop1(itemName);
        
 		//b.setSuplierName(suplierName);
 		//b.setBillno(Long.parseLong(billno));
 		b.setBuyPrice(Double.parseDouble(buyPrice));
 		b.setQuantity(Double.parseDouble(quantity));
 		b.setSaleprice(Double.parseDouble(salePrice));
 		//b.setUnit(unit);
 		//b.setValue(Long.parseLong(value));
 		
 		b.setUsername(username);
		b.setUserid(Long.parseLong(userid));
		b.setHotelid(Long.parseLong(nwfkShopId));
		b.setHotelname(nwshopName);
 		
 	
 		System.out.println(" Item Name sett - "+b.getFk_item_id_drop1());
 		
 		

 		b.setTotal(Double.parseDouble(total));
 		//b.setGrossTotal(Double.parseDouble(grossTotal));
 		
 		
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
			newEntry.setHotelid(Long.parseLong(nwfkShopId));
			newEntry.setHotelname(nwshopName);
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
        		 
        // DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        	//	 Date date = new Date();
        	
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
        			newEntry.setHotelid(Long.parseLong(nwfkShopId));
        			newEntry.setHotelname(nwshopName);
        			System.out.println("item name || "+newEntry.getItemname());
        			com.rms.dao.StockDao dao2 = new com.rms.dao.StockDao();
        			dao2.registerStock(newEntry);	
        			break;
        		}
        	}
        	
          }	
        com.rms.dao.StockDao dao2 = new com.rms.dao.StockDao();
        List stkList1  = dao1.getAllStockEntry(pk_item_entry_Id,hotelid);
        
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
			newEntry.setHotelname(nwshopName);
			System.out.println("item name  "+newEntry.getItemname());
			com.rms.dao.StockDao dao3 = new com.rms.dao.StockDao();
			dao3.registerStock(newEntry);	
        	
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
        		
        		 Double updatequnty = (double) (qunty - Double.parseDouble(quantity));
        		 System.out.println("for loop stock update Quantity---------- "+updatequnty);
        				 
  
        		 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
        		 Session session = hbu.getHibernateSession();
        		 Transaction transaction = session.beginTransaction();
        		 
        // DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        	//	 Date date = new Date();
        	
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
        			newEntry.setHotelname(nwshopName);
        			System.out.println("item name || "+newEntry.getItemname());
        			com.rms.dao.StockDao dao3 = new com.rms.dao.StockDao();
        			dao2.registerStock(newEntry);	
        			break;
        		}
        	}
        	
          }	
        }
        TransferstockDao dao = new TransferstockDao();
 		dao.transferstockHibernate(b);
 		
 		}
        }
 		}

































			

}