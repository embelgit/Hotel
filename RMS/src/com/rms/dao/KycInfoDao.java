package com.rms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.KycDetailsBean;
import com.rms.hibernate.KycInfoHibernate;
import com.rms.utility.HibernateUtility;

public class KycInfoDao {
	public void KycInfoHibernate(KycInfoHibernate sd){

		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
	     
		session.save(sd);
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
	

	// get kyc detail list
	 public List getAllKYCDetailsForList(){
			
			HibernateUtility hbu=null;
			Session session=null;
			List<KycDetailsBean> custList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("SELECT pk_kyc_details_id,item_name,quantity,table_no,price,kyc_date FROM Kyc_details");
			List<Object[]> list = query.list();

			custList= new ArrayList<KycDetailsBean>(0);


		for (Object[] object : list) {	
			KycDetailsBean reports = new KycDetailsBean();
			reports.setPkKycDetailId(Long.parseLong(object[0].toString()));
			reports.setItemName(object[1].toString());
			reports.setQuantity(Long.parseLong(object[2].toString()));
			reports.setTableNo(Long.parseLong(object[3].toString()));
			reports.setPrice(Double.parseDouble(object[4].toString()));
			reports.setKYCDate(object[5].toString());
			
			custList.add(reports);

		}}catch(RuntimeException e){	

		}
		finally{

		hbu.closeSession(session);	
		}
		return custList;

	 }


}
