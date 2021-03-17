package com.rms.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.CreateUser;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.feedback;
import com.rms.hibernate.usercreateBean;
import com.rms.utility.HibernateUtility;
import com.rms.hibernate.UserDetailsBean;;
public class CreateUserDao {
	
	public void addUser(usercreateBean cu){
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
	
		 
		 DateFormat df=new SimpleDateFormat("dd/mm/yyyy");
		 Date dObj=new Date();
		 
		 cu.setInsertDate(dObj);
		cu.setModifiedDate(dObj);
		 
		 
		 
		System.out.println("object before saving --  ");
		session.save(cu);
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
	// get usr
	public List getAlluser()

	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		
		 Query query = session.createQuery("from usercreateBean ");
		//Query query = session.createQuery("from GoodReceive");
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
	
	public List getalluserNamee() {
		HibernateUtility hbuu=null;
		Session sessionn=null;
		List list1=null;
		
		try{
			 hbuu = HibernateUtility.getInstance();
			 sessionn = hbuu.getHibernateSession();
		//	 Query query = sessionn.createQuery("from UserDetailsBean");
			 Query query = sessionn.createQuery("from usercreateBean");
			 list1 = query.list();
			 System.out.println("user list size -- "+query.list().size());
				}
		catch(RuntimeException e){	
				e.printStackTrace();
		}
		finally{
			if(sessionn!=null){
				hbuu.closeSession(sessionn);
			}	
		}
		return list1;
		}
	
	// get USer Deails By 
	
	public List getAllUserDetailsForEdit(Long pk_item_details_id) {

		HibernateUtility hbu = null;
		Session session =  null;
		Query query = null;
		 List list = null;
		 
		 System.out.println("id in DAO- ID----------#############################"+pk_item_details_id);
		 
		 try {
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 query = session.createSQLQuery("SELECT pk_create_user_id,user_type,first_name,last_name,user_name,`password`,confirm_password,email_id,mobile_no from user_details where  pk_create_user_id =:pk_item_details_id");
//			 query = session.createSQLQuery("SELECT pk_create_user_id,user_type,first_name,last_name,user_name,`password`,confirm_password,email_id,mobile_no from create_user where  pk_create_user_id = '"+pk_item_details_id+"'"); 
			 query.setParameter("pk_item_details_id", pk_item_details_id);
			 list = query.list(); 
			 
			 System.out.println("Size-----------#############################"+list.size());
			 
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

	
	
	
	// get Crate  List For dropdown
		public List getAllCreateUserList()

		{
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 //String item = "item";
			 //String drink = "drink";
			 Query query = session.createQuery("from usercreateBean");
			
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
	
	
	// get User Details detail list
	 public List getAllUserDetailsForList(){
			
			HibernateUtility hbu=null;
			Session session=null;
			List<usercreateBean> custList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("SELECT pk_create_user_id,user_type,first_name,last_name,user_name,mobile_no,email_id from user_details");
			List<Object[]> list = query.list();

			custList= new ArrayList<usercreateBean>(0);


		for (Object[] object : list) {	
			usercreateBean reports = new usercreateBean();
			reports.setPk_create_user_id(Long.parseLong(object[0].toString()));
			reports.setUserType(object[1].toString());
			reports.setFirstName(object[2].toString());
			reports.setLastName((object[3].toString()));
			reports.setUserName((object[4].toString()));
			reports.setMobileNO(((object[5].toString())));
			reports.setEmailId(object[6].toString());
			
			custList.add(reports);

		}}catch(RuntimeException e){	

		}
		finally{

		hbu.closeSession(session);	
		}
		return custList;

	 }
		
	 public List getuserName() {
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			
			try{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 Query query = session.createQuery("from usercreateBean");
				 list = query.list();
				 System.out.println("username name -- "+list);
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
	 
	
	 public void feedBackformDAO(feedback fb){
		
		/*HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{*/
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session = hbu.getHibernateSession();
		Transaction transaction = session.beginTransaction();
	
		 
		 DateFormat df=new SimpleDateFormat("dd/mm/yyyy");
		 Date dObj=new Date();
		 
		 fb.setiDate(dObj);
		/*cu.setModifiedDate(dObj);*/
		 
		 
		 
		
		session.save(fb);
		transaction.commit();
		/*}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(Exception rbe)
			{
				rbe.printStackTrace();
			}	
		}finally{*/
		hbu.closeSession(session);
		//}
	}
	}