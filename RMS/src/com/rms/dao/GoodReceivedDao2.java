package com.rms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.GoodReceived;
import com.rms.hibernate.ItemEntry;
import com.rms.utility.HibernateUtility;

public class GoodReceivedDao2 {
	
	public void GoodReceive(GoodReceived gr){
		
		/*HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{*/
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session = hbu.getHibernateSession();
		Transaction transaction = session.beginTransaction();
			
		Long fk_item_id = gr.getFk_item_id();
		ItemEntry itemDe = (ItemEntry) session.load(ItemEntry.class, fk_item_id);
		gr.setItemEntry(itemDe);
		

		
		session.save(gr);
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
		
	public List getAllItemEntries()

	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("from ItemEntry");
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
		
	}
