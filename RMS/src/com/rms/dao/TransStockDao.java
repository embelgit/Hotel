package com.rms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rms.utility.HibernateUtility;

public class TransStockDao {

public List getAllStockEntry(String pk_item_entry_Id,String hotelid)
	
	{

		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 Query query = session.createQuery("From Stock where pk_hotel_id ='"+pk_item_entry_Id+"' AND hotelid = '"+hotelid+"'");
		 list = query.list();
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
