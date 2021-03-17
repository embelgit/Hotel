package com.rms.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.SupplierDetailsHibernate;
import com.rms.hibernate.accesscontrolbean;
import com.rms.hibernate.hotelnamebean;
import com.rms.utility.HibernateUtility;

public class hotelnamedao {

public void addhotel(hotelnamebean bn){
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
			 
		System.out.println("object before saving --  ");
		session.save(bn);
		System.out.println("object saved ! ");
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

public List gethotelID()
{
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	
	 Query query = session.createQuery("from hotelnamebean GROUP BY hotelid");
	  
	 list = query.list();
	 System.out.println(" list size of trans ID - - "+list.size());
	 
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

public List getuserDetails(Long user_id) {

	HibernateUtility hbu = null;
	Session session =  null;
	Query query = null;
	 List list = null;
	 
	 System.out.println("id in DAO- ID---------userid  "+user_id);
	 
	 try {
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 query = session.createSQLQuery("select pk_create_user_id, user_name, `password` from user_details where pk_create_user_id ='"+user_id+"'");
		// query.setParameter("user_id", user_id);
		 list = query.list(); 
		 
		 System.out.println("Size----   "+list.size());
		 
	} catch (RuntimeException e) {
		e.printStackTrace();
	}
	 
	 finally
	 {
		 if (session!=null) {
			hbu.closeSession(session);
		}
	 }
	 //System.out.println("out of dao - return credit customer List : "+list);
			return list;

	}


public List getAllhotel()

{
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	
	 Query query = session.createQuery("from hotelnamebean ");

	 list = query.list();
	 System.out.println("list size - "+query.list().size());
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

public List getAllhotelname()

{
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	
	 Query query = session.createQuery("from hotelnamebean ");

	 list = query.list();
	 System.out.println("list size - "+query.list().size());
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

public void addaccess(accesscontrolbean sd){

	HibernateUtility hbu=null;
	Session session=null;
	Transaction transaction=null;
	
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 transaction = session.beginTransaction();
     
	session.save(sd);
	transaction.commit();
	System.out.println("tx commit  - ");
	}
	
	catch(RuntimeException e){
		try{
			transaction.rollback();
		}catch(RuntimeException rbe)
		{
			rbe.printStackTrace();
		}	
	}finally{
	hbu.closeSession(session);
	}
}

public List gethotel(String uname)
{
	System.out.println("IN DAO - "+uname);
	HibernateUtility hbu = null;
	Session session =  null;
	Query query = null;
	 List list = null;
	System.out.println("IN DAO "+uname);
	 try {
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 System.out.println("IN DAO - "+uname);
		 query = session.createSQLQuery("select pk_id, hotelid, hotelname,userid,usertype from accesscontrol where username = '"+uname+"'");
		 list = query.list(); 
		 System.out.println("=== list ====  "+query.list().size());
		 
	} catch (RuntimeException e) {
		Log.error("Error in getAllMainCat", e);
	}
	 
	 finally
	 {
		 if (session!=null) {
			hbu.closeSession(session);
		}
	 }
			return list;
	
}
//
public List gethotelForEdit(Long pk_hotel_id) {

	HibernateUtility hbu = null;
	Session session =  null;
	Query query = null;
	 List list = null;
	 
	 System.out.println("id in DAO- ID----------##### - "+pk_hotel_id);
	 
	 try {
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 query = session.createSQLQuery("SELECT pk_id, hotelId, hotelName from hotel_name where pk_id ='"+pk_hotel_id+"'");
//		 query.setParameter("pk_item_details_id", pk_item_details_id);
		 list = query.list(); 		 
		 System.out.println("Size-----------### - "+list.size());
		 
	} catch (RuntimeException e) {
		e.printStackTrace();
	}
	 
	 finally
	 {
		 if (session!=null) {
			hbu.closeSession(session);
		}
	 }
	 //System.out.println("out of dao - return credit customer List : "+list);
			return list;

	}



// toget all hotel to edit
	public List gethotelname(HttpServletRequest request)

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
	try{
	//	System.out.println("in else part");
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 String item = "item";
	 String drink = "drink";
	 Query query = session.createQuery("from hotelnamebean");
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
// list
	public List gethotelForList(HttpServletRequest request){
		 HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		  	
			HibernateUtility hbu=null;
			Session session=null;
			List<hotelnamebean> custList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("select hotelId,hotelName from hotel_name");
			List<Object[]> list = query.list();

			custList= new ArrayList<hotelnamebean>(0);


		for (Object[] object : list) {	
			hotelnamebean ht = new hotelnamebean();
			ht.setHotelid(Long.parseLong(object[0].toString()));
			ht.setHotelname(object[1].toString());
			custList.add(ht);

		}}catch(RuntimeException e){	

		}
		finally{

		hbu.closeSession(session);	
		}
		return custList;

	 }
	
}
