package com.rms.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.GoodReceive;
import com.rms.hibernate.PurchaseReturn;
import com.rms.utility.HibernateUtility;

public class PurchaseReturnDao {

	public void regGoodReceive(PurchaseReturn gd) {
		// TODO Auto-generated method stub
		HibernateUtility hbu = null ;
		Session session  = null;
		Transaction transaction = null;
		
		
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			
			session.save(gd);
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
	
	public void updateQuantity(Long PkGoodRecId,String availquantity,String total ) {
		// TODO Auto-generated method stub
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction =null;

		try
		{
			hbu = HibernateUtility.getInstance();
		    session = hbu.getHibernateSession();
		    transaction = session.beginTransaction();
		    
		    org.hibernate.Query query = session.createQuery("from GoodReceive where PkGoodRecId = :PkGoodRecId ");
		    query.setParameter("PkGoodRecId", PkGoodRecId);
		    
		    GoodReceive uniqueResult = (GoodReceive) query.uniqueResult();
		    Double quant = uniqueResult.getQuantity();
		    Double oriQuantity = uniqueResult.getOringnalQuantity();
		    
		    Double updatequnty = (Double) (quant - Double.parseDouble(availquantity));
		    Double oQuant = (Double) (oriQuantity - Double.parseDouble(availquantity));

		    GoodReceive updateStock = (GoodReceive) session.get(GoodReceive.class, new Long(PkGoodRecId));	 
   		
   		    updateStock.setQuantity(updatequnty);
   		    updateStock.setOringnalQuantity(oQuant);
   		    updateStock.setTotal(Double.parseDouble(total));
   		 
   		    session.saveOrUpdate(updateStock);
   		    transaction.commit();
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}finally
		{if(session!=null){
			session.close();	
		}
		}
		
		
	}

}
