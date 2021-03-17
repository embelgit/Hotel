package com.rms.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;



import com.rms.dao.GoodReceivedDao2;
import com.rms.hibernate.GoodReceived;
import com.rms.dao.StockDao;
public class GoodReceivedHelper {
	
	public void receiveGood(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		String quantity = request.getParameter("quantity");
		String fk_item_id = request.getParameter("fk_item_id");
		String itemName= request.getParameter("itemName");
		
		System.out.println("rhn"+quantity );
		System.out.println("avi"+fk_item_id);
		GoodReceived gr = new GoodReceived();

		gr.setQuantity(Double.parseDouble(quantity));
		gr.setItemName(itemName);
		gr.setFk_item_id(Long.parseLong(fk_item_id));
		GoodReceivedDao2 goodReceivedDao = new GoodReceivedDao2();
		goodReceivedDao.GoodReceive(gr);
		
		 /* To Update Stock in Stock Table*/
        com.rms.dao.StockDao dao1 = new com.rms.dao.StockDao();
        List stkList  = dao1.getAllStockEntry(itemName,hotelid);
        
        /*If Stock Is Empty */ 
        if(stkList.size() == 0){
        	System.out.println("in hello");
        	com.rms.hibernate.Stock newEntry = new com.rms.hibernate.Stock();
			
			newEntry.setFk_good_received_id(Long.parseLong(fk_item_id));
			newEntry.setStock(Double.parseDouble(quantity));
			
			com.rms.dao.StockDao dao2 = new com.rms.dao.StockDao();
			dao2.registerStock(newEntry);	
        	
        }
        else/*To Update Stock Table If It is Not Empty */
        {
        	
        for(int i=0;i<stkList.size();i++){
        	
        	com.rms.hibernate.Stock st = (com.rms.hibernate.Stock)stkList.get(i);
        	Long ItemId = st.getFk_good_received_id();
        	Long PkItemId = st.getPk_item_stock_id();
        	
        	/*If ItemName Is Already Exists In Stock Table */ 
        	if(ItemId.equals(Long.parseLong(fk_item_id))){
        		 Double qunty = st.getStock();
        		
        		 Double updatequnty = (double) (qunty + Double.parseDouble(quantity));
        				 
  
        		 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
        		 Session session = hbu.getHibernateSession();
        		 Transaction transaction = session.beginTransaction();
        		 
        		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        		 Date date = new Date();
        	
        	     com.rms.hibernate.Stock updateStock = (com.rms.hibernate.Stock) session.get(com.rms.hibernate.Stock.class, new Long(PkItemId));	 
        		// updateStock.setUpdateDate(date);
        		 updateStock.setStock(updatequnty);
        		 
        		session.saveOrUpdate(updateStock);
        		transaction.commit();
        		break;
        	}
        	else
        	{
        		/*ItemName is Not Exists */
        		if(i+1 == stkList.size()){
        			
        			com.rms.hibernate.Stock newEntry = new com.rms.hibernate.Stock();
        			
        			newEntry.setFk_good_received_id(Long.parseLong(fk_item_id));
        			newEntry.setStock(Double.parseDouble(quantity));
        			
        			com.rms.dao.StockDao dao2 = new com.rms.dao.StockDao();
        			dao2.registerStock(newEntry);
        			
        		}
        	}
        	
          }	
        }
        
	}

}
