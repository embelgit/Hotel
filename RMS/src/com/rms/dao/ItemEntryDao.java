package com.rms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.SupplierDetailsHibernate;
import com.rms.utility.HibernateUtility;

public class ItemEntryDao {
	
	public void itemEntry(ItemEntry ie){
		
		HibernateUtility hbu = null ;
		Session session  = null;
		Transaction transaction = null;
		
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			
			session.save(ie);
			transaction.commit();
		
		} catch (Exception e) {
			try {
				transaction.rollback();
			} catch (RuntimeException ede) {
			     
			//	Log.error("Error in transaction", ede);
			}
		}
		
		finally
		{
			if (session!=null) {
				hbu.closeSession(session);
				
			}
		}		
	}
	
	
	public List getAllItemEntries()

	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 String item = "item";
		 String drink = "drink";
		 Query query = session.createQuery("from ItemEntry where Type=:item");
		 query.setParameter("item", item);
		 list = query.list();
		}
			catch(RuntimeException e){	
		//		Log.error("Error in getAllItemEntries()", e);
		}
			finally
			{
					if(session!=null){
					hbu.closeSession(session);
				}
			}
		
	return list;
	
	}
	// menu for bill
	public List getAllItemEntriesForOrderBilling(HttpServletRequest request)

	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype"); 
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" -in getAllItemEntriesForOrderBilling()");
		System.out.println("usertype = -  "+usertype);
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		String ad = "admin";
		if(usertype.equals(ad)) {
			try{
				System.out.println("in admin in if part");
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 String item = "item";
				 String drink = "drink";
				 Query query = session.createQuery("from ItemEntry where hotelid = '"+hotelid+"'");
				//Query query = session.createQuery("from GoodReceive");
				 list = query.list();
				}
			catch(RuntimeException e){	
				//		Log.error("Error in getAllItemEntries()", e);
				}
					finally
					{
							if(session!=null){
							hbu.closeSession(session);
						}
					}
		}
		return list;
		
	}
	
	// getting menu in old bill
	public List getAllItemsEntriesForOrderBill(HttpServletRequest request)

	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype"); 
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" -in getAllItemsEntriesForOrderBill()");
		System.out.println("usertype = -  "+usertype);
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
	//	String ad = "admin";
			try{
	
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 String item = "item";
				 String drink = "drink";
				 Query query = session.createQuery("from ItemEntry where hotelid = '"+hotelid+"'");
				//Query query = session.createQuery("from GoodReceive");
				 list = query.list();
				}
			catch(RuntimeException e){	
				//		Log.error("Error in getAllItemEntries()", e);
				}
					finally
					{
							if(session!=null){
							hbu.closeSession(session);
						}
					}
		
		return list;
		
	}
	// getting kiosk menu
	public List getAllItemEntriesForOrderBillkioskbill(HttpServletRequest request)

	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype"); 
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" - in getAllItemEntriesForOrderBillkioskbill()");
		System.out.println("usertype = -  "+usertype);
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		
			try{
				System.out.println("in admin in if part");
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 String item = "item";
				 String drink = "drink";
				 Query query = session.createQuery("from ItemEntry where hotelid = '"+hotelid+"'");
				//Query query = session.createQuery("from GoodReceive");
				 list = query.list();
				}
			catch(RuntimeException e){	
				//		Log.error("Error in getAllItemEntries()", e);
				}
					finally
					{
							if(session!=null){
							hbu.closeSession(session);
						}
					}
		
		return list;
		
	}
	
	
	//menu for kiosk bill
	public List getAllItemEntriesForOrderBillkiosk(HttpServletRequest request)

	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype"); 
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		System.out.println("usertype = -  "+usertype);
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		String ad = "admin";
		if(usertype.equals(ad)) {
			try{
				System.out.println("in admin in if part");
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 String item = "item";
				 String drink = "drink";
				 Query query = session.createQuery("from ItemEntry where hotelid = '"+hotelid+"'");
				//Query query = session.createQuery("from GoodReceive");
				 list = query.list();
				}
			catch(RuntimeException e){	
				//		Log.error("Error in getAllItemEntries()", e);
				}
					finally
					{
							if(session!=null){
							hbu.closeSession(session);
						}
					}
		}
		return list;
		
	}
	
	
	public List getAllItemEntriesForOrderBill(HttpServletRequest request)

	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype"); 
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		System.out.println("usertype = -  "+usertype);
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		String ad = "admin";
		if(usertype.equals(ad)) {
			try{
				System.out.println("in admin in if part");
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 String item = "item";
				 String drink = "drink";
				 Query query = session.createQuery("from ItemEntry");
				//Query query = session.createQuery("from GoodReceive");
				 list = query.list();
				}
			catch(RuntimeException e){	
				//		Log.error("Error in getAllItemEntries()", e);
				}
					finally
					{
							if(session!=null){
							hbu.closeSession(session);
						}
					}
		}
		else {
		try{
			System.out.println("in else part");
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 String item = "item";
		 String drink = "drink";
		 Query query = session.createQuery("from ItemEntry where hotelid = '"+hotelid+"'");
		//Query query = session.createQuery("from GoodReceive");
		 list = query.list();
		}
		
			catch(RuntimeException e){	
		//		Log.error("Error in getAllItemEntries()", e);
		}
			finally
			{
					if(session!=null){
					hbu.closeSession(session);
				}
			}
		}
	return list;
	
	}
	// get Good Receive Data 
	
	public List getAllItemEntriesForOrderBill1()

	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 String item = "item";
		 String drink = "drink";
		 Query query = session.createQuery("from GoodsReceiveHibernate ");
		
		 list = query.list();
		}
			catch(RuntimeException e){	
		//		Log.error("Error in getAllItemEntries()", e);
		}
			finally
			{
					if(session!=null){
					hbu.closeSession(session);
				}
			}
		
	return list;
	
	}
	
	public List getAllItemEntries1(HttpServletRequest request)

	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 String drink = "drink";
		 Query query = session.createQuery("from ItemEntry where hotelid ='"+hotelid+"'");
		 list = query.list();
		}
			catch(RuntimeException e){	

		}
			finally
			{
					if(session!=null){
					hbu.closeSession(session);
				}
			}
		
	return list;
	
	}

	/*public List getItemName() {
		HibernateUtility hbu=null;
		Session session=null;
		List <Object[]> list=null;
		
		try
		{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query =session.createQuery("select itemName from ItemEntry");
			 list=query.list();
			}
				catch(RuntimeException e)
					{	
						Log.error("Error in getItemName()", e);
					}
					finally	{
							if(session!=null)	{
								
								hbu.closeSession(session);
								
							}
					}
		
			return list;
		
	}*/
		
	
	// get item entry detail to edit
		public List getAllItemEntryDetailsForEdit(Long pk_item_entry_Id) {

			HibernateUtility hbu = null;
			Session session =  null;
			Query query = null;
			 List list = null;
			 try {
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 query = session.createSQLQuery("SELECT pk_item_entry_Id,itemName,Type FROM itementry WHERE pk_item_entry_Id ="+pk_item_entry_Id);
				 list = query.list(); 
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			 
			 finally
			 {
				 if (session!=null) {
					hbu.closeSession(session);
				}
			 }
			 System.out.println("out of dao - return credit customer List : "+list);
					return list;

			}

		
		// get item entry detail list
	//	(, HttpServletResponse response);
		
		public List getAllItemEntryDetailsForList(HttpServletRequest request){
			 HttpSession sessionn = request.getSession(true);
				String username = (String)sessionn.getAttribute("user");		
				String userid = (String)sessionn.getAttribute("userid");
				String hotelid = (String)sessionn.getAttribute("hotelid");
				String hotelname=(String)sessionn.getAttribute("hotelname");
				System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			  	
				HibernateUtility hbu=null;
				Session session=null;
				List<ItemEntry> custList=null;
			try{	

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();

				Query query=session.createSQLQuery("SELECT pk_item_entry_Id, itemName, Type, sale_Price, buy_Price, unit, quantity FROM itementry where hotelid ='"+hotelid+"'");
				List<Object[]> list = query.list();

				custList= new ArrayList<ItemEntry>(0);

				int sr=0;
			for (Object[] object : list) {	
				ItemEntry reports = new ItemEntry();
				sr++;
				reports.setPk_item_entry_Id(Long.parseLong(object[0].toString()));
				reports.setItemName(object[1].toString());
				reports.setType(object[2].toString());
				reports.setSalePrice(Long.parseLong(object[3].toString()));
				reports.setBuyPrice(Long.parseLong(object[4].toString()));
				reports.setUnit(object[5].toString());
				reports.setValue(Long.parseLong(object[6].toString()));
				reports.setSr(sr);
				custList.add(reports);

			}}catch(RuntimeException e){	

			}
			finally{

			hbu.closeSession(session);	
			}
			return custList;

		 }
		

		public void deletItemListDetails(String TransportId1) {
					
	Long pk_sport_id= Long.parseLong(TransportId1);
	System.out.println("In DAO");
	HibernateUtility hbu = null ;
	Transaction tx = null; 
	Session session = null;
	 List list  = null;
	 try {
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 tx = session.beginTransaction();
			Query query = session.createSQLQuery("DELETE FROM sport_master WHERE pk_sport_id =:pk_sport_id");
			query.setParameter("pk_sport_id",pk_sport_id);
			int seletedRecords = query.executeUpdate();
			System.out.println("Number of credit Cusr deleted = = "+seletedRecords);
			//list = query.list();
			tx.commit();
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
		
	 finally
	 {
		 if (session!=null) {
			hbu.closeSession(session);
		}
	 }
	
}


}