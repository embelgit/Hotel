package com.rms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.AddWaitersList;
import com.rms.bean.GetItemDetails;
import com.rms.hibernate.Stock;
import com.rms.utility.HibernateUtility;

public class StockDao {

	public List getAllStockEntry(String pk_item_entry_Id,String hotelid)
	
	{

		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("From Stock where fk_good_received_id ='"+pk_item_entry_Id+"' AND hotelid = '"+hotelid+"'");
		 list = query.list();
		}
			catch(Exception e){	
				e.printStackTrace();
		}
			finally
			{
					if(session!=null){
					hbu.closeSession(session);
				}
			}
		
	return list;
	}
	
	public List getAllStockEntry1(String itemId, String hotelid)
	
	{

		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		// Query query = session.createQuery("From Stock where fk_good_received_id ='"+itemId+"'");From Stock where  
		 Query query = session.createQuery("From Stock where fk_item_details_id ='"+itemId+"' AND hotelid = '"+hotelid+"'");
		 list = query.list();
		}
			catch(Exception e){	
				e.printStackTrace();
		}
			finally
			{
					if(session!=null){
					hbu.closeSession(session);
				}
			}
		
	return list;
	}
	
	/*To register New ItemName In Stock Table*/
	
	public void registerStock(Stock newEntry){
	
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
		
		session.save(newEntry);
		transaction.commit();
		}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(Exception rbe)
			{
				rbe.printStackTrace();
			}	
		}finally{
		hbu.closeSession(session);
		}
	}
	
	public List getlowStock(HttpServletRequest request)
	{
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype"); 
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" usertype - "+usertype);
		
		HibernateUtility hbu = null;
		Session session = null ;
		List<Stock> stk =null;
		String ad = "admin";
		if(usertype.equals(ad)) {
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();

				Query query = session.createSQLQuery("SELECT Itemname, stock from stock where stock <= '"+10+"'");
				List<Object[]> list = query.list();
				
				 stk = new ArrayList<Stock>(0);
				 
				 for (Object[] object : list) {	
					 	Stock stk1 = new Stock();
					 	stk1.setItemname(object[0].toString());
					 	stk1.setStock(Double.parseDouble(object[1].toString()));
					 	stk.add(stk1);
				 } 
		}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				if (session!=null) {
					
					hbu.closeSession(session);
				}
			}
		}
		else {
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query = session.createSQLQuery("SELECT Itemname, stock from stock where stock <= '"+10+"' AND hotelid = '"+hotelid+"'");
			List<Object[]> list = query.list();
			
			 stk = new ArrayList<Stock>(0);
			 
			 for (Object[] object : list) {	
				 	Stock stk1 = new Stock();
				 	stk1.setItemname(object[0].toString());
				 	stk1.setStock(Double.parseDouble(object[1].toString()));
				 	stk.add(stk1);
			 } 
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if (session!=null) {
				
				hbu.closeSession(session);
			}
		}
		}
			return stk;

	}	
	
	
	
	
	
	/* To Fetch ItemName And Quantity from Stock Table  */
	
	public List getItemNameAndQuantity(){
		
		HibernateUtility hbu =null;
		Session session = null ;
		Query query = null ;
		List <Object[]> list =null;
		List<GetItemDetails> ibean = null ;
		
		try{
			
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			query=session.createSQLQuery("select i.ItemName, s.goods_receive, s.pk_item_stock_id , s.fk_good_received_id , s.fk_item_details_id from itementry i right join goods_receive s ON s.fk_item_details_id = i.pk_item_entry_Id");
			
			list=query.list();
			ibean = new ArrayList<GetItemDetails>(0);
			for(Object[] object : list){
				
				GetItemDetails gibean = new GetItemDetails();
				gibean.setItemName((object[0].toString()));
				Double quantity = (Double) object[1];
				gibean.setQuantity(quantity);
		
				ibean.add(gibean);
			
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				if (session!=null) {
					
					hbu.closeSession(session);
				}
			}
				
			return ibean;
	}
	
/* To Fetch ItemName And Quantity from Stock Table  */
	
	public List getItemNameAndQuantityReport(){
		
		HibernateUtility hbu =null;
		Session session = null ;
		Query query = null ;
		List <Object[]> list =null;
		List<GetItemDetails> ibean = null ;
		
		try{
			
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			query=session.createSQLQuery("select i.ItemName, s.stock, s.pk_item_stock_id , s.fk_item_details_id from itementry i right join stock s ON s.fk_item_details_id = i.pk_item_entry_Id where s.stock < 10");
			
			list=query.list();
			ibean = new ArrayList<GetItemDetails>(0);
			for(Object[] object : list){
				
				GetItemDetails gibean = new GetItemDetails();
				gibean.setItemName((object[0].toString()));
				Double quantity = (Double) object[1];
				gibean.setQuantity(quantity);
		
				ibean.add(gibean);
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				if (session!=null) {
					
					hbu.closeSession(session);
				}
			}
				
			return ibean;
	}
	
	
	public void updateStock()
	{
		HibernateUtility hbu=null;
	    Session session = null;
	    Transaction transaction = null;
			
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
	    transaction = session.beginTransaction();
	}
	
	
	
	
}