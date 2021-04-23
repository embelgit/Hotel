package com.rms.dao;

import com.rms.bean.customerdetails;
import com.rms.hibernate.CustomerDetailsHibernate;
import com.rms.hibernate.ItemEntry;
import com.rms.utility.HibernateUtility;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class CustomerDetails {
	public void valCustomer(CustomerDetailsHibernate customer) {
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
		 
		 session.save(customer);
			System.out.println("data saved successfully  --  ! ");
			transaction.commit();
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
		List<customerdetails> list  = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			
			Query query = session.createSQLQuery(" select cutomer_name,dob,mob_no from customerdetails; ");
			//list = query.list();
			
			List<Object[]> list1 = query.list();
			list = new ArrayList<customerdetails>(0);
			for (Object[] o : list1) {
				customerdetails po= new customerdetails();
				po.setCustomerName(o[0].toString());
				po.setDob(o[1].toString());
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

		
	

