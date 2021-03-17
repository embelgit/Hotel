package com.rms.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.WastageFoods;
import com.rms.utility.HibernateUtility;

public class WastageFooodsDao {

	public void addStockIntoDatabase(WastageFoods wsf) {

		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
		
		session.save(wsf);
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

}
