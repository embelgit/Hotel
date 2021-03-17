package com.rms.dao;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.util.Log;

import com.rms.bean.GoodsReceiveReportBean;
import com.rms.hibernate.CustomerOrder;
import com.rms.hibernate.GoodsReceiveHibernate;
import com.rms.hibernate.Stock;
import com.rms.hibernate.TempItemDetail;
import com.rms.hibernate.newTempItemDetail;
import com.rms.utility.HibernateUtility;

public class CustomerOrderDao {
	
	
	public List getOrderBillNo() {

		HibernateUtility hbu=null;
		Session session=null;
		List<CustomerOrder> orderList=null;
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			Query query = session.createSQLQuery("SELECT billNo , Itemname FROM customerorder ORDER BY billNo DESC LIMIT 1");

			List<Object[]> list = query.list();
			orderList= new ArrayList<CustomerOrder>(0);
			for (Object[] object : list) {
				CustomerOrder reports = new CustomerOrder();
				reports.setBillNo(Long.parseLong(object[0].toString()));
				orderList.add(reports);	 
			}}
		catch(RuntimeException e)
		{
			Log.error("Error in getOrderBillNo()", e);	
		}finally
		{if(session!=null){
			hbu.closeSession(session);	
		}
		}
		return orderList;	
	
	}
	
	
	public List getallsale(HttpServletRequest request) {
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype"); 
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		HibernateUtility hbu=null;
		Session session=null;
		List list2=null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		String CurrentDate = df.format(dateobj);
		System.out.println("Today's date  -- ==== "+CurrentDate);
		String ad = "admin";
		if(usertype.equals(ad)) {
		try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createSQLQuery("select pk_custOrder_id, SUM(GridTotal) from customerorder where CurrentDate = '"+CurrentDate+"'");
			 list2 = query.list();
			 System.out.println("list-- "+query.list().size());
				}
		catch(RuntimeException e){	
				e.printStackTrace();
		}
		finally{
			if(session!=null){
				hbu.closeSession(session);
			}	
		}
		}
		else {
			try{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 Query query = session.createSQLQuery("select SUM(GridTotal) from customerorder where CurrentDate = '"+CurrentDate+"' AND hotelid = '"+hotelid+"'");
				 list2 = query.list();
				 System.out.println("list -- "+query.list().size());
					}
			catch(RuntimeException e){	
					e.printStackTrace();
			}
			finally{
				if(session!=null){
					hbu.closeSession(session);
				}	
			}
			}	
		
		return list2;
		}
	
	public List getattendedWaiters() {
		HibernateUtility hbu = null ;
		Session session  = null;
		List<CustomerOrder> custOrder =null;
		
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			Query query = session.createSQLQuery("select BillNo, TableNo, Itemname, Quantity, unitPrice, totalAmount from customerorder where WaiterName = 'Francis dco'");
			List<Object[]> list = query.list();
			
			 custOrder = new ArrayList<CustomerOrder>(0);
			 
			 for (Object[] o : list) {	
				 CustomerOrder cust = new CustomerOrder();
				 cust.setBillNo(Long.parseLong(o[0].toString()));
				 cust.setTableNo(Long.parseLong(o[1].toString()));
				 cust.setItemName(o[2].toString());
				 cust.setQuantity(Double.parseDouble(o[3].toString()));
				 cust.setUnitPrice(Double.parseDouble(o[4].toString()));
				 cust.setTotalAmount(Double.parseDouble(o[5].toString()));
				 custOrder.add(cust);
			 } 
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if (session!=null) {
				
				hbu.closeSession(session);
			}
		}
			return custOrder;

	}	
		
		

	
	
	public void registerBill(CustomerOrder cust) {
		
		HibernateUtility hbu = null ;
		Session session  = null;
		Transaction transaction = null;
		
		
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			transaction = session.beginTransaction();
			
			session.save(cust);
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
	
	
	public List getLastBillNo(HttpServletRequest request)
	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		
		 Query query = session.createQuery("from CustomerOrder where hotelid = '"+hotelid+"'");
		
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
	
	public List getAllItemEntriesForOrderBill1()

	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 //String item = "item";
		 //String drink = "drink";
		 Query query = session.createQuery("from CustomerOrder group by tableNo ");
		
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

	public List getAllItemEntriesForOrderBill2()

	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 //String item = "item";
		 //String drink = "drink";
		 Query query = session.createQuery("from CustomerOrder group by billNo ");
		
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

	public void updateTabaleStatus(Long pk_temp_id) {
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction = null;
	
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
		
		 TempItemDetail itemDetail = (TempItemDetail) session.get(TempItemDetail.class, new Long(pk_temp_id));
		 itemDetail.setActiveYN('N');
		 System.out.println(" -- ## - in update table status method, set table status to - N in @@@ customerOrderDao --  ");
		 session.saveOrUpdate(itemDetail);
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
	
	
	// --- new --
	
	
	public void updateTabaleStatusnew(Long pk_temp_id) {
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction = null;
	
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
		
		 newTempItemDetail itemDetail = (newTempItemDetail) session.get(newTempItemDetail.class, new Long(pk_temp_id));
		 itemDetail.setActiveYN('N');
		 System.out.println(" -- ## - in update table status customerOrderDao new temp table --  ");
		 session.saveOrUpdate(itemDetail);
		 transaction.commit();
		 
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
	
	//for bill copy
	
		public List getAllBillNo1(String TableNo)
		{
			
			HibernateUtility hbu = null;
			Session session = null;
			List list = null;
			
			try {
				//String paymentdone = "y";
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				/*String abc = "0.0";*/
				Query query = session.createSQLQuery("SELECT BillNo,pk_custOrder_id from customerorder where TableNo='"+TableNo+"'");
				list = query.list();

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			finally {
				if (session != null) {
					hbu.closeSession(session);
				}
			}
			return list;
			
		}

		public List<CustomerOrder> getattendedWaiterReport(String waiterName,String datefrom,String dateto, String hotelid, String usertype){
			System.out.println("in dao - "+waiterName+" "+datefrom+" "+dateto+"   "+hotelid+"  "+usertype);
			HibernateUtility hbu=null;
			Session session=null;
			List<CustomerOrder> catList=null;
			String ad = "admin";
			if(usertype.equals(ad)) {
				try
				{
				Long k = 0l;
				hbu = HibernateUtility.getInstance();
	     		 session = hbu.getHibernateSession();

	     		 Query query = session.createSQLQuery("SELECT BillNo, TableNo, Itemname, Quantity, unitPrice, totalAmount from customerorder where WaiterName = '"+waiterName+"' AND CurrentDate BETWEEN '"+dateto+"' AND '"+datefrom+"'");	
			        List<Object[]> list = query.list();
			        catList= new ArrayList<CustomerOrder>(0);
			        
					for (Object[] object : list) {
						
						 System.out.println("Result -->  "+Arrays.toString(object));
						k++;		
						CustomerOrder reports = new CustomerOrder();
			//			reports.setSrNo(k);
						reports.setBillNo(Long.parseLong(object[0].toString()));
						reports.setTableNo(Long.parseLong(object[1].toString()));
						reports.setItemName(object[2].toString());
						reports.setQuantity(Double.parseDouble(object[3].toString()));
						reports.setUnitPrice(Double.parseDouble(object[4].toString()));
						reports.setTotalAmount(Double.parseDouble(object[5].toString()));
						catList.add(reports); 
				
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally {

					hbu.closeSession(session);
				}
			}
			else {
			try
			{
			Long k = 0l;
			hbu = HibernateUtility.getInstance();
     		 session = hbu.getHibernateSession();

     		 Query query = session.createSQLQuery("SELECT BillNo, TableNo, Itemname, Quantity, unitPrice, totalAmount from customerorder where WaiterName = '"+waiterName+"' AND hotelid = '"+hotelid+"' AND CurrentDate BETWEEN '"+dateto+"' AND '"+datefrom+"'");	
		        List<Object[]> list = query.list();
		        catList= new ArrayList<CustomerOrder>(0);
		        
				for (Object[] object : list) {
					
					 System.out.println("Result -->  "+Arrays.toString(object));
					k++;		
					CustomerOrder reports = new CustomerOrder();
		//			reports.setSrNo(k);
					reports.setBillNo(Long.parseLong(object[0].toString()));
					reports.setTableNo(Long.parseLong(object[1].toString()));
					reports.setItemName(object[2].toString());
					reports.setQuantity(Double.parseDouble(object[3].toString()));
					reports.setUnitPrice(Double.parseDouble(object[4].toString()));
					reports.setTotalAmount(Double.parseDouble(object[5].toString()));
					catList.add(reports); 
			
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {

				hbu.closeSession(session);
			}
			}
			return catList;
			
			
		}
		
		
		public List getAllwaiterName()

		{
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 String item = "item";
			 String drink = "drink";
			 Query query = session.createQuery("from CustomerOrder");
			//Query query = session.createQuery("from GoodReceive");
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
		// credit 
		
	public List<CustomerOrder> getcreditDateWiseReport(String creditdatefrm, String creditdateto, String hotelid, String usertype){
			HibernateUtility hbu = null;
			Session session = null;
			List<CustomerOrder> catList = null;
			String ad = "admin";
			if(usertype.equals(ad)) {
				try
				{
					Long k = 0l;
					hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();

				
				
		Query  query = session.createSQLQuery("SELECT BillNo,TableNo,WaiterName ,GridTotal from customerorder WHERE CurrentDate BETWEEN '"+creditdatefrm+"' AND '"+creditdateto+"' GROUP BY BillNo");		
	    List<Object[]> list = query.list();
	    catList= new ArrayList<CustomerOrder>(0);
	    System.out.println("credit list size -  "+query.list().size());
		for (Object[] o : list) {
			
			 System.out.println("Result -->  "+Arrays.toString(o));
			k++;		
			CustomerOrder rep = new CustomerOrder();
			
		//	rep.setSrNo(k);
			rep.setBillNo(Long.parseLong(o[0].toString()));
			rep.setTableNo(Long.parseLong(o[1].toString()));
			rep.setWaiterName(o[2].toString());
			rep.setGridTotal(o[3].toString());
			catList.add(rep); 
		}
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally {

					hbu.closeSession(session);
				}
			}
			else {
			try
			{
				Long k = 0l;
				hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();

			
			
	Query  query = session.createSQLQuery("SELECT BillNo,TableNo,WaiterName ,GridTotal from customerorder WHERE hotelid = '"+hotelid+"' AND CurrentDate BETWEEN '"+creditdatefrm+"' AND '"+creditdateto+"' GROUP BY BillNo");		
    List<Object[]> list = query.list();
    catList= new ArrayList<CustomerOrder>(0);
    System.out.println("credit list size -  "+query.list().size());
	for (Object[] o : list) {
		
		 System.out.println("Result -->  "+Arrays.toString(o));
		k++;		
		CustomerOrder rep = new CustomerOrder();
		
	//	rep.setSrNo(k);
		rep.setBillNo(Long.parseLong(o[0].toString()));
		rep.setTableNo(Long.parseLong(o[1].toString()));
		rep.setWaiterName(o[2].toString());
		rep.setGridTotal(o[3].toString());
		catList.add(rep); 
	}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {

				hbu.closeSession(session);
			}
			}
			return catList;
		
	}
		
		
}		
		

