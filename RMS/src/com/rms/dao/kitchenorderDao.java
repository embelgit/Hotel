package com.rms.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.CustomerOrder;
import com.rms.hibernate.TempItemDetail;
import com.rms.hibernate.kitchenorderHibernate;
import com.rms.utility.HibernateUtility;

public class kitchenorderDao {

public void orderBill(kitchenorderHibernate cust) {
		
		HibernateUtility hbu = null ;
		Session session  = null;
		Transaction transaction = null;
		
		
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			
			session.save(cust);
			System.out.println("object saved ! in kitchen dao ");
			transaction.commit();
			
		/*	String itemName = cust.getItemName();
			Long table_No = cust.getTableNo();
			*/
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

     public void updatetabStatus(Long tableNo){
    	 
    	 HibernateUtility hbu=null;
 		Session session=null;
 		Transaction transaction = null;
 		System.out.println("table got in kitchen dao - "+tableNo);
 		char M = 'N';
 		try{
 		 hbu = HibernateUtility.getInstance();
 		 session = hbu.getHibernateSession();
 		 transaction = session.beginTransaction();
 		
 		 kitchenorderHibernate item = (kitchenorderHibernate) session.get(kitchenorderHibernate.class, new Long(tableNo));
 		 item.setActiveYN(M);
 		 System.out.println(" -- ## - in update table  status to - N in @@@ KitchenOrderDao  for ORDER() --  ");
 		 session.saveOrUpdate(item);
 		 transaction.commit();
 		 
 		 
 		/* String activeYN = "N";
 		 System.out.println("asdas == " +activeYN);
 		 String hql = "UPDATE tempdata set ActiveYN ="+activeYN   + "where pk_temp_id ="+pk_temp_id ;
 		    Query query = session.createSQLQuery("UPDATE tempdata set ActiveYN =:activeYN where pk_temp_id ="+pk_temp_id);
 		    query.setParameter("activeYN", activeYN);
 		
 		    int result = query.executeUpdate();
 		 */
 		/* Long table = Long.parseLong(table_No);
 		 char activeYN = 'N';
 		 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
 			Date dateobj = new Date();
 			System.out.println(df.format(dateobj));
 			String newDate = df.format(dateobj);
 		 String hql = "UPDATE tempdata set ActiveYN ="+activeYN   + "  " +"where ItemName ="+itemName  + "  "+  "AND TableNo ="+table+ "and CurrentDate="+newDate ;
 	    Query query = session.createSQLQuery(hql);
 	
 	    int result = query.executeUpdate();
 	    System.out.println("Rows affected: " + result);*/

 		
 		 //list = query.list();
 		 
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
}
     
     
 	public List getAllkitchen(String itemId, String hotelid)
 	{
 		System.out.println("item ID in allKitchen() "+itemId);
 		HibernateUtility hbu=null;
 		Session session=null;
 		List list=null;
 		try{
 		 hbu = HibernateUtility.getInstance();
 		 session = hbu.getHibernateSession();
 		// Query query = session.createQuery("From Stock where fk_good_received_id ='"+itemId+"'");From Stock where  
 		 Query query = session.createQuery("From kitchenorderHibernate where itemId ='"+itemId+"' AND hotelid = '"+hotelid+"'");
 		 list = query.list();
 		 System.out.println("Result of allkitchen() - - "+query.list().toString());
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
 	
 	
	public List getAllkitchenEntry(String newTempId, String hotelid)
	{
		System.out.println("in get  all kitchen() - itemID - > "+newTempId);
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("From kitchenorderHibernate where itemId = '"+newTempId+"' AND hotelid = '"+hotelid+"'");
	//	 Query query = session.createSQLQuery("select ItemID, ItemName,Quantity, TableNo, CurrentDate, ActiveYN from kitchenOrder where ItemID = '"+newTempId+"' ");
		 list = query.list();
		 System.out.println("result for getting all kitchen entries size - -  - "+list.size());
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
		

}