package com.rms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.CustomerDetailsHibernate;
import com.rms.utility.HibernateUtility;

public class CustomerDetails {
	
	public void valCustomer(CustomerDetailsHibernate cd) {

		System.out.println("In DAO");
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		try{
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
	
		 System.out.println("Transaction started --  ");
		session.save(cd);
		System.out.println("object saved in CustomerDetails dao --");
		transaction.commit();
		System.out.println("commit Successful in dao -- ");
		}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(RuntimeException rbe)
			{
				rbe.printStackTrace();
			}	
		}
		finally{
		hbu.closeSession(session);
		}
	}
	

	public List getcustomerdetails() {

		HibernateUtility hbu = null ;
		Session session = null;
		List<CustomerDetailsHibernate> list  = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query = session.createSQLQuery("select cutomer_name,dob,mob_no from customerdetails");
			//list = query.list();
			
			List<Object[]> list1 = query.list();
			list = new ArrayList<CustomerDetailsHibernate>(0);
			for (Object[] o : list1) {
				CustomerDetailsHibernate po= new CustomerDetailsHibernate();
				po.setCustomerName(o[0].toString());
				po.setDob((Date)o[1]);
				po.setMobileNumber(Long.parseLong(o[2].toString()));
		    	list.add(po);
			}

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
		return list;
	}
	}

		
	

