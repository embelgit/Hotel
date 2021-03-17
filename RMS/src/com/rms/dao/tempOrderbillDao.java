package com.rms.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rms.bean.GetItemDetails;
import com.rms.utility.HibernateUtility;

public class tempOrderbillDao {
	
	public List getItemDetailsByTable10(String tableNo,String hotelid) {

		HibernateUtility hbu=null;
		Session session=null;
		 List<GetItemDetails> saleReports = null; 
		 List<Object[]> list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateobj = new Date();
		 String CurrentDate = df.format(dateobj);
		 System.out.println("table no got in dao -- "+tableNo);
		 System.out.println("date in dao --   "+CurrentDate);
		 String status = "Y";
		 
			//Query query = session.createQuery("select tableNo, itemName, quantity, unitPrice, unitInMl ,pk_temp_id, itemId from TempItemDetail where activeYN=:status AND current_date=:dateobj AND tableNo="+tableNo + "  "+"group by pk_temp_id");
//			Query query = session.createSQLQuery("select t.tableNo, t.itemName, t.quantity, t.unitPrice, t.unitInMl ,t.pk_temp_id, t.itemId,s.stock from tempdata t join stock s  on t.ItemID = s.fk_item_details_id where activeYN='Y' AND current_date='"+CurrentDate+"' AND tableNo='"+tableNo+"'");
			//Query query = session.createSQLQuery("select tableNo, itemName, quantity, unitPrice, unitInMl ,pk_temp_id, itemId from tempdata where activeYN=:status AND current_date=:dateobj AND tableNo='"+tableNo+"' group by pk_temp_id");
			//query.setParameter("dateobj", dateobj);
			//System.out.println(" hi this is DAte:++++"+dateobj);
			//query.setParameter("status", status);
			//System.out.println(" hi this is Status===="+status);
//		Query query = session.createSQLQuery("select t.tableNo, t.itemName,  t.quantity, t.unitPrice, t.unitInMl ,t.pk_temp_id, t.itemId,s.stock from tempdata t join stock s  on t.ItemID = s.fk_item_details_id where activeYN='Y' AND current_date='"+CurrentDate+"' AND t.ItemID='"+tableNo+"' HAVING COUNT(1)");	
	
//--= Query query = session.createSQLQuery("select t.itemName,  t.quantity, t.unitPrice, t.unit, t.value ,t.pk_temp_id, t.itemId,s.stock from newtempdata t join stock s  on t.ItemID = s.fk_item_details_id where t.activeYN='Y' AND current_date='"+CurrentDate+"' AND t.ItemID='"+tableNo+"'");			

//--		 Query query = session.createSQLQuery("select t.itemName,   t.sale_Price, t.unit, quantity ,t.pk_item_entry_Id, s.stock from itementry t join stock s  on t.pk_item_entry_Id = s.fk_item_details_id where t.pk_item_entry_Id='"+tableNo+"'");

		 Query query = session.createSQLQuery("select itemName,  quantity, unitPrice, unit, value ,pk_temp_id, itemId , stock, gst from newtempdata where ActiveYN='Y' AND CurrentDate='"+CurrentDate+"' AND hotelid = '"+hotelid+"'");	 
		 list = query.list();
		 /*	if(query.list().size()==0) {
				 Query queryy = session.createSQLQuery("select itemName,  quantity, unitPrice, unit,value ,pk_temp_id, itemId , stock from newtempdata where ActiveYN='Y' AND CurrentDate='"+CurrentDate+"' AND ItemID='"+tableNo+"'");
	//			 Query queryy = session.createSQLQuery("SELECT itemName, sale_Price, unit, quantity, pk_item_entry_Id from itementry  where pk_item_entry_Id = '"+tableNo+"'");	
				 list = queryy.list();
				 saleReports = new ArrayList<GetItemDetails>(0);
				 for (Object[] object : list) {
				System.out.println(" IN IF  -- NEW -- main Result is === > > "+Arrays.toString(object)); 
				com.rms.bean.GetItemDetails reports = new com.rms.bean.GetItemDetails();
				 
					reports.setItemName(object[0].toString());
					reports.setQuantity(Double.parseDouble(object[1].toString()));
					reports.setPrrice(Double.parseDouble(object[2].toString()));
				//	reports.setUnitinMl(Double.parseDouble(object[2].toString()));
					reports.setUnit(object[3].toString());
					reports.setValue(Long.parseLong(object[4].toString()));
					
				reports.setPkTempId(Long.parseLong(object[5].toString()));
					reports.setItemId(Long.parseLong(object[6].toString()));
					reports.setStock(Double.parseDouble(object[7].toString()));
			//		reports.setQuantity(1d);
		//			reports.setStock(0d);
					saleReports.add(reports);
				
				 }
				 }
		 	else {  */
		 saleReports = new ArrayList<GetItemDetails>(0);
			 for (Object[] object : list) {
			System.out.println(" IN ELSE  -- NEW -- main Result is === > > "+Arrays.toString(object)); 
			com.rms.bean.GetItemDetails reports = new com.rms.bean.GetItemDetails();
			//GetItemDetails reports = new GetItemDetails();
			/*reports.setTableNo((Long)object[0]);
			reports.setItemName((String)object[1]);
			reports.setQuantity((Double)object[2]);
			reports.setPrrice((Double)object[3]);
			reports.setUnitinMl((Double)object[4]);
			reports.setPkTempId((BigInteger)object[5]);
			reports.setItemId((Long)object[6]);
			reports.setStock((Double)(object[7]));*/

	/*		reports.setTableNo(Long.parseLong(object[0].toString()));
			System.out.println("table set in daoooo -- >  "+reports.getTableNo());
			reports.setItemName(((object[1].toString())));
			reports.setQuantity((Double.parseDouble(object[2].toString())));
	//		reports.setQuantity(1d);
			reports.setPrrice((Double.parseDouble((object[3].toString()))));
			reports.setUnitinMl((Double.parseDouble((object[4].toString()))));
			reports.setPkTempId(Long.parseLong(object[5].toString()));
			reports.setItemId((Long.parseLong(object[6].toString())));
			reports.setStock((Double.parseDouble((object[7].toString()))));
		//	reports.setStock(object[7].toString());
			System.out.println("Stock is -- "+((Double)(object[7])));
			//reports.setTotalAmt((Double)object[7]); */
		
	//		reports.setTableNo(Long.parseLong(object[0].toString()));
			reports.setItemName(object[0].toString());
			reports.setQuantity(Double.parseDouble(object[1].toString()));
			reports.setPrrice(Double.parseDouble(object[2].toString()));
	//		reports.setUnitinMl(Double.parseDouble(object[2].toString()));
			reports.setUnit(object[3].toString());
			reports.setValue(Long.parseLong(object[4].toString()));
				reports.setPkTempId(Long.parseLong(object[5].toString()));
			reports.setItemId(Long.parseLong(object[6].toString()));
			reports.setStock(Double.parseDouble(object[7].toString()));
			reports.setGst(Double.parseDouble(object[8].toString()));
			/*
				 * reports.setCgst(Double.parseDouble(object[8].toString()));
				 * reports.setSgst(Double.parseDouble(object[9].toString()));
				 */
		//	reports.setQuantity(1d);
			saleReports.add(reports);
			
		}
//		 	}
		}catch(Exception e){	
			e.printStackTrace();
		}
		finally{
			session.flush();
			hbu.closeSession(session);	
		}
		return saleReports;

	}	

	//    
	
	public List getAllnewtabEntry(String newTempId, String hotelid) {
		
		HibernateUtility hbu=null;
 		Session session=null;
 		List list=null;
 		try{
 			System.out.println("item id when item to set N -   >  "+newTempId);
 		 hbu = HibernateUtility.getInstance();
 		 session = hbu.getHibernateSession();
 		// Query query = session.createQuery("From Stock where fk_good_received_id ='"+itemId+"'");From Stock where  
 		 Query query = session.createQuery("From newTempItemDetail where itemId ='"+newTempId+"' AND hotelid = '"+hotelid+"'");
 		 list = query.list();
 		 System.out.println("query list size - "+query.list().size());
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
	
public List getAllnewtabEn() {
		
		HibernateUtility hbu=null;
 		Session session=null;
 		List list=null;
 		try{
// 			System.out.println("item id when item to set N -   >  "+newTempId);
 		 hbu = HibernateUtility.getInstance();
 		 session = hbu.getHibernateSession();
 		// Query query = session.createQuery("From Stock where fk_good_received_id ='"+itemId+"'");From Stock where  
 		 Query query = session.createQuery("From newTempItemDetail");
 		 list = query.list();
 		 System.out.println("query list size - "+query.list().size());
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
