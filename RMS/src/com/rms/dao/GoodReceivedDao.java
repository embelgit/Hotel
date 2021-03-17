package com.rms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.GoodReceived;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.stockReport;
import com.rms.utility.HibernateUtility;

public class GoodReceivedDao {
	
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
		
/*		 DateFormat df=new SimpleDateFormat("dd/mm/yyyy");
		 Date dObj=new Date();
		 
		 ie.setInsertDate(dObj);
		 ie.setModifiedDate(dObj);
		 */
		
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
	
	public List getStockList()

	{
		HibernateUtility hbu=null;
		Session session=null;
		List<stockReport> empList=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createSQLQuery("select p.quantity,itemName from good_received p left join itementry  on p.fk_item_id=pk_item_entry_Id where quantity>0");
		
		 List<Object[]> list = query.list();
		
		 empList= new ArrayList<stockReport>(0);
		 
		 for (Object[] object : list) {	
			 
			 stockReport reports = new stockReport();
				
				reports.setQuantity(Double.parseDouble(object[0].toString()));
				reports.setItemName(object[1].toString());
				
				
				empList.add(reports);
				System.out.println("list in dao"+empList);

			}}catch(RuntimeException e){	

			}
			finally{

			hbu.closeSession(session);	
			}
		
	return empList;
	
	}
		
	}
