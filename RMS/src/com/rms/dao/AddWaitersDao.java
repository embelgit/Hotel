package com.rms.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.velocity.runtime.log.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.AddWaitersList;
import com.rms.bean.GetItemDetails;
import com.rms.hibernate.AddWaiters;
import com.rms.hibernate.CreateUser;
import com.rms.utility.HibernateUtility;

public class AddWaitersDao {

	public void addingWaiter(AddWaiters adw) {

		System.out.println("In DAO");
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		try{
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
	
		 System.out.println("Transaction started --  ");
		session.save(adw);
		System.out.println("object saved in waiters dao --");
		transaction.commit();
		System.out.println("commit Successful in dao -- ");
		}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(RuntimeException rbe)
			{
				rbe.printStackTrace();
			//	Log.error("Couldn't roll back tranaction",rbe);
			}	
		}
		finally{
		hbu.closeSession(session);
		}
	}
	
	public List getWaiter(HttpServletRequest request)
	{
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype"); 
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" , usrtype - "+usertype);
		
		HibernateUtility hbu = null;
		Session session = null ;
		List<AddWaitersList> waiterlist=null;
		String ad = "admin";
		if(usertype.equals(ad)) {
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();

				Query query = session.createSQLQuery("select waiter_id ,first_name, middle_name, last_name, mobile_no, email_id, dob, joining_date, salary, city, state from waiter_entry");	

				List<Object[]> list = query.list();
				
				 waiterlist= new ArrayList<AddWaitersList>(0);
				 
				 for (Object[] object : list) {	
					 AddWaitersList addwaiter = new AddWaitersList();
					 addwaiter.setWaiterId(Long.parseLong(object[0].toString()));
					 addwaiter.setFirstName(object[1].toString());
					 addwaiter.setMiddleName(object[2].toString());
					 addwaiter.setLastName(object[3].toString());
					 addwaiter.setMobileNo(Long.parseLong(object[4].toString()));
					 addwaiter.setEmailId(object[5].toString());
					 addwaiter.setDob(object[6].toString());
					 addwaiter.setJoiningDate(object[7].toString());
					 addwaiter.setSalary(Double.parseDouble(object[8].toString()));
					 addwaiter.setCity(object[9].toString());
					 addwaiter.setState(object[10].toString());
					
					 waiterlist.add(addwaiter);
					 System.out.println("waiter list --->  "+waiterlist);
				 }
			}catch(RuntimeException e){	

			}
			finally{

			hbu.closeSession(session);	
			}
		}
		else {
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query = session.createSQLQuery("select waiter_id ,first_name, middle_name, last_name, mobile_no, email_id, dob, joining_date, salary, city, state from waiter_entry where hotelid = '"+hotelid+"'");	

			List<Object[]> list = query.list();
			
			 waiterlist= new ArrayList<AddWaitersList>(0);
			 
			 for (Object[] object : list) {	
				 AddWaitersList addwaiter = new AddWaitersList();
				 addwaiter.setWaiterId(Long.parseLong(object[0].toString()));
				 addwaiter.setFirstName(object[1].toString());
				 addwaiter.setMiddleName(object[2].toString());
				 addwaiter.setLastName(object[3].toString());
				 addwaiter.setMobileNo(Long.parseLong(object[4].toString()));
				 addwaiter.setEmailId(object[5].toString());
				 addwaiter.setDob(object[6].toString());
				 addwaiter.setJoiningDate(object[7].toString());
				 addwaiter.setSalary(Double.parseDouble(object[8].toString()));
				 addwaiter.setCity(object[9].toString());
				 addwaiter.setState(object[10].toString());
				
				 waiterlist.add(addwaiter);
				 System.out.println("waiter list --->  "+waiterlist);
			 }
		}catch(RuntimeException e){	

		}
		finally{

		hbu.closeSession(session);	
		}
		}
return waiterlist;
			 
	}		 
			 
	public List getWaitersName() {
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		
		try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("from AddWaiters");
			 list = query.list();
			 System.out.println("waiter name -- "+list);
				}
		catch(RuntimeException e){	
				e.printStackTrace();
		}
		finally{
			if(session!=null){
				hbu.closeSession(session);
			}	
		}
		return list;
		}
	
	
	// get Waiter List For dropdown
	public List getAllWiterList(HttpServletRequest request)

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
		 //String item = "item";
		 //String drink = "drink";
		 Query query = session.createQuery("from AddWaiters where hotelid = '"+hotelid+"'");
		
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
//waiter list
	
	public List getAllWaitersList(HttpServletRequest request){
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
		 
		 Query query = session.createQuery("from AddWaiters where hotelid = '"+hotelid+"'");
		
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
	
	// get all waiter List
	// get User Details detail list
	 public List getAllWaiterDetailsForList(HttpServletRequest request){
			
		 HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
			HibernateUtility hbu=null;
			Session session=null;
			List<AddWaitersList> custList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("SELECT pk_waiter_entry_id, waiter_id,first_name,middle_name,last_name,mobile_no,dob,joining_date,salary,address,city,zip_code,state,email_id from waiter_entry where hotelid = '"+hotelid+"'");
			List<Object[]> list = query.list();

			custList= new ArrayList<AddWaitersList>(0);


		for (Object[] object : list) {	
			
			AddWaitersList reports = new AddWaitersList();
			reports.setPkAddWaiterId(Long.parseLong(object[0].toString()));
			reports.setWaiterId(Long.parseLong(object[1].toString()));
			reports.setFirstName(object[2].toString());
			reports.setMiddleName(object[3].toString());
			reports.setLastName(object[4].toString());
			reports.setMobileNo(Long.parseLong((object[5].toString())));
			reports.setDob(object[6].toString());
			reports.setJoiningDate((object[7].toString()));
			reports.setSalary(Double.parseDouble(object[8].toString()));
			reports.setAddress(object[9].toString());
			reports.setCity(object[10].toString());
			reports.setZip(Long.parseLong(object[11].toString()));
			reports.setState(object[12].toString());
			reports.setEmailId(object[13].toString());
			
			custList.add(reports);

		}}catch(RuntimeException e){	

		}
		finally{

		hbu.closeSession(session);	
		}
		return custList;

	 }
	 
	 //get Waiter List Deatils
	//get item detail to edit
			public List getAllWaiterForEdit(Long pk_item_details_id) {

				HibernateUtility hbu = null;
				Session session =  null;
				Query query = null;
				 List list = null;
				 
				 System.out.println("id in DAO- ID-------"+pk_item_details_id);
				 
				 try {
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					 query = session.createSQLQuery("SELECT pk_waiter_entry_id,waiter_id,first_name,middle_name,last_name,mobile_no,dob,joining_date,salary,address,city,zip_code,state,email_id from waiter_entry where pk_waiter_entry_id=:pk_item_details_id");
					 query.setParameter("pk_item_details_id", pk_item_details_id);
					 list = query.list(); 
					 
					 System.out.println("Size----"+list.size());
					 
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

			public List getAllwaiterName(HttpServletRequest request)
			{
				HttpSession sessionn = request.getSession(true);
				String username = (String)sessionn.getAttribute("user");		
				String userid = (String)sessionn.getAttribute("userid");
				String hotelid = (String)sessionn.getAttribute("hotelid");
				String hotelname=(String)sessionn.getAttribute("hotelname");
				String usertype = (String)sessionn.getAttribute("usertype");
				System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
				HibernateUtility hbu=null;
				Session session=null;
				List list=null;
				String ad = "admin";
				if(usertype.equals(ad)) {
					try{
						 hbu = HibernateUtility.getInstance();
						 session = hbu.getHibernateSession();
						 String item = "item";
						 String drink = "drink";
						 Query query = session.createQuery("from AddWaiters");
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
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 String item = "item";
				 String drink = "drink";
				 Query query = session.createQuery("from AddWaiters where hotelid = '"+hotelid+"'");
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

	}