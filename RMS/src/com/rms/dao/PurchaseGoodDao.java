package com.rms.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.PurchaseGood;
import com.rms.utility.HibernateUtility;

public class PurchaseGoodDao {

	public void addGood(PurchaseGood ag){
		
System.out.println("In DAO");
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		try{
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
	
		 System.out.println("Tx started");
		session.save(ag);
		transaction.commit();
		System.out.println("Successful");
		}
		
		/*catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(RuntimeException rbe)
			{
				Log.error("Couldn't roll back tranaction",rbe);
			}	
		}*/finally{
		hbu.closeSession(session);
		}
		
	}


	}
	
