package com.rms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.StockEntryReportBean;
import com.rms.hibernate.StockEntryHibernate;
import com.rms.utility.HibernateUtility;

public class StockEntryDao {

public void StockEntryHibernate(StockEntryHibernate stk){
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
	     
		session.save(stk);
		transaction.commit();
		}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(RuntimeException rbe)
			{
				rbe.printStackTrace();
			}	
		}finally{
		hbu.closeSession(session);
		}
	}


//get Stock entry report 
/*public List<StockEntryReportBean> getStockEntryReport() {
	
			HibernateUtility hbu=null;
			Session session=null;
			List<StockEntryReportBean> catList=null;
			try
			{
				Long k = 0l;
				hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query2 = session.createSQLQuery("select product_name, supplier_name, buy_price, quantity, total, gross_total from store_management");
				
		        List<Object[]> list = query2.list();
		        catList= new ArrayList<StockEntryReportBean>(0);
				
				for (Object[] object : list) {
					k++;		
					StockEntryReportBean reports = new StockEntryReportBean();
					reports.setSrNo(k);
					reports.setProductName(object[0].toString());
					reports.setSupplierName(object[1].toString());
					reports.setBuyPrice(Double.parseDouble(object[2].toString()));
					reports.setQuantity(Double.parseDouble(object[3].toString()));
					reports.setTotal(Double.parseDouble(object[4].toString()));
					reports.setGrossTotal(Double.parseDouble(object[5].toString()));
					
					catList.add(reports); 
			
				}}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return catList;
		
}*/
}
