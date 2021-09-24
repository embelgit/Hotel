package com.rms.dao;

import java.math.BigInteger;
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

import com.rms.bean.GetItemDetails;
import com.rms.bean.OrderBillReportDateWiseBean;
import com.rms.bean.OrderBillReportTableWiseBean;
import com.rms.bean.menuList;
import com.rms.hibernate.TempItemDetail;
import com.rms.hibernate.kitchenorderHibernate;
import com.rms.hibernate.newTempItemDetail;
import com.rms.utility.HibernateUtility;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class TempItemDetailDao {

	public void regTempData(TempItemDetail tid) {
		
		System.out.println("*********** first entery in temp table *********");
			System.out.println(" ---------   "+tid);
			HibernateUtility hbu = null ;
			Session session  = null;
			Transaction transaction = null;
			
			
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				transaction = session.beginTransaction();
				Long itemid1 = tid.getItemId();
				System.out.println("----------********************---------");
				session.save(tid);
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
	
	
public void newregTempData(newTempItemDetail tid) {
		
		System.out.println("*********** first entery in temp table *********");
			System.out.println(" ---------   "+tid);
			HibernateUtility hbu = null ;
			Session session  = null;
			Transaction transaction = null;
			
			
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				transaction = session.beginTransaction();
				Long itemid1 = tid.getItemId();
				System.out.println("----------************ NEW  ********---------");
				session.save(tid);
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
	
	public List getAllItemEntry(Long hotelid)
	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date dateobj = new Date();
		 System.out.println("hi vikas -  "+df.format(dateobj));
		 Query query = session.createQuery("from TempItemDetail where activeYN='y' and current_date=:dateobj and hotelid =:hotelid");
		 System.out.println("in getAllItemEntry method of temp item dao ---------------------------------------------------------- ");
		 query.setParameter("dateobj", dateobj);
		 query.setParameter("hotelid",hotelid);
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
	
	public List getallkitchen(String hotelid) {
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date dateobj = new Date();
		 System.out.println("hi date is -  "+df.format(dateobj));
		 Query query = session.createQuery("from kitchenorderHibernate where activeYN='Y' and current_date=:dateobj and hotelid =: hotelid");
		 System.out.println("in getallkitchen entry method of temp  dao ---------------------------------------------------------- ");
		 query.setParameter("dateobj", dateobj);
		 query.setParameter("hotelid",hotelid);
		 list = query.list();
		 System.out.println("all kitchen size -   "+query.list().size());
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
	
	
	public List newgetAllItemEntry(Long hotelid)
	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date dateobj = new Date();
		 System.out.println("date is in newgetALLitemENTRY method - -  "+df.format(dateobj));
		 Query query = session.createQuery("from newTempItemDetail where activeYN='y' and current_date=:dateobj and hotelid ='"+hotelid+"'");
	
		 query.setParameter("dateobj", dateobj);
//		 query.setParameter("hotelid",hotelid);
		 list = query.list();
		 System.out.println("in  NEW getAllItemEntry method of temp item dao ---------------------------------------------------list size is "+query.list().size());	 
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
	
	public List getAllMainTableNo(Long hotelid)
	{
		
		
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
//		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateobj = new Date();
		 System.out.println("df.format(dateobj) -   "+df.format(dateobj));
		 String datee = df.format(dateobj);
		 System.out.println("datee -   "+datee);
/*		 Query query = session.createQuery("from TempItemDetail where activeYN='y' and current_date=:dateobj and hotelid=:hotelid GROUP BY tableNo");
		 query.setParameter("dateobj", dateobj);
		 query.setParameter("hotelid",hotelid); */
		 Query query = session.createQuery("from TempItemDetail where activeYN='y' and current_date='"+datee+"' and hotelid= '"+hotelid+"' GROUP BY tableNo");
		 list = query.list();
		 System.out.println(" list size in getting table no ----  "+list.size());
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

	
	public List getItemDetailsByTable(String tableNo, String hotelid) {

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
		 System.out.println(CurrentDate);
		 String status = "Y";
		 		
		 Query query = session.createSQLQuery("select tableNo, itemName, quantity, unitPrice, unit, value ,pk_temp_id, itemId, stock, GST from tempdata where activeYN='Y' AND current_date='"+CurrentDate+"' AND tableNo='"+tableNo+"' AND hotelid = '"+hotelid+"'");
			
			 list = query.list();
	
			 saleReports = new ArrayList<GetItemDetails>(0);
			 for (Object[] object : list) {
			System.out.println("final Result is ---=== > > "+Arrays.toString(object)); 
			com.rms.bean.GetItemDetails reports = new com.rms.bean.GetItemDetails();
	
			reports.setTableNo(Long.parseLong(object[0].toString()));
			System.out.println("table set in daoooo -- >  "+reports.getTableNo());
			reports.setItemName(((object[1].toString())));
			reports.setQuantity((Double.parseDouble(object[2].toString())));
			reports.setPrrice((Double.parseDouble((object[3].toString()))));
			System.out.println(" quantity is-  "+reports.getQuantity()+" price is - -  "+reports.getPrrice());
	//		reports.setUnitinMl((Double.parseDouble((object[4].toString()))));
			reports.setUnit(object[4].toString());
			reports.setValue(Long.parseLong(object[5].toString()));
			reports.setPkTempId(Long.parseLong(object[6].toString()));
			reports.setItemId((Long.parseLong(object[7].toString())));
			reports.setStock((Double.parseDouble((object[8].toString()))));
			
			System.out.println("Stock is -- "+((Double)(object[8])));
			reports.setGst(Double.parseDouble(object[9].toString()));
		//	reports.setSgst(Double.parseDouble(object[10].toString()));
			System.out.println("gst - - - - "+reports.getGst());
			//reports.setTotalAmt((Double)object[7]);
			saleReports.add(reports);
			
		}
	//		}
		}catch(Exception e){	
			e.printStackTrace();
		}
		finally{
			session.flush();
			hbu.closeSession(session);	
		}
		return saleReports;

	}	

	//get Order Bill Report Date Wise 
			public List<OrderBillReportDateWiseBean> getOrderBillDateWiseReport(String hotelid,String usertype,String orderBillDate) {
				
				System.out.println(hotelid+"  "+usertype);
				
						HibernateUtility hbu=null;
						Session session=null;
						List<OrderBillReportDateWiseBean> catList=null;
						String ad = "admin";
						if(usertype.equals(ad)) 
						{
							try
							
							{
								Long k = 0l;
								hbu = HibernateUtility.getInstance();
							 session = hbu.getHibernateSession();
//							 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
							Query query = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unit, value, totalAmount,GridTotal from customerorder WHERE CurrentDate  = '"+orderBillDate+"'");	
						        List<Object[]> list = query.list();
						        System.out.println("in list size==" +list.size());
						        catList= new ArrayList<OrderBillReportDateWiseBean>(0);
								
								for (Object[] object : list) {
									k++;		
									OrderBillReportDateWiseBean reports = new OrderBillReportDateWiseBean();
									System.out.println("result - "+Arrays.toString(object));
									reports.setSrNo(k);
									reports.setTableNo(Long.parseLong(object[0].toString()));
									reports.setItemName(object[1].toString());
									reports.setQuantity(Double.parseDouble(object[2].toString()));
									reports.setUnitPrice(Double.parseDouble(object[3].toString()));
						//			reports.setUnitInMl(Double.parseDouble(object[4].toString()));
									reports.setUnit(object[4].toString());
									reports.setValue(Long.parseLong(object[5].toString()));
									reports.setTotalAmt(Double.parseDouble(object[6].toString()));
									reports.setGridTotal(Double.parseDouble(object[7].toString()));
									catList.add(reports); 
							
								}
								}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else {
						try
						
						{
							Long k = 0l;
							hbu = HibernateUtility.getInstance();
						 session = hbu.getHibernateSession();
//						 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
						Query query = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unit, value, totalAmount,GridTotal from customerorder WHERE CurrentDate  = '"+orderBillDate+"' AND hotelid = '"+hotelid+"'");	
					        List<Object[]> list = query.list();
					        System.out.println("in list size== " +list.size());
					        catList= new ArrayList<OrderBillReportDateWiseBean>(0);
							
							for (Object[] object : list) {
								k++;		
								OrderBillReportDateWiseBean reports = new OrderBillReportDateWiseBean();
						//		reports.setSrNo(k);
								reports.setTableNo(Long.parseLong(object[0].toString()));
								reports.setItemName(object[1].toString());
								reports.setQuantity(Double.parseDouble(object[2].toString()));
								reports.setUnitPrice(Double.parseDouble(object[3].toString()));
					//			reports.setUnitInMl(Double.parseDouble(object[4].toString()));
								reports.setUnit(object[4].toString());
								reports.setValue(Long.parseLong(object[5].toString()));
								reports.setTotalAmt(Double.parseDouble(object[6].toString()));
								reports.setGridTotal(Double.parseDouble(object[7].toString()));
								catList.add(reports); 
						
							}
							}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						}
						return catList;
			}
			// sale report range wise
			
	public List<OrderBillReportDateWiseBean> getOrderBillRangeWiseReport(String dateto, String datefrom, String hotelid, String usertype) {
				
				System.out.println();
				
						HibernateUtility hbu=null;
						Session session=null;
						List<OrderBillReportDateWiseBean> catList=null;
						String ad = "admin";
						if(usertype.equals(ad)) {
							try
							{
								Long k = 0l;
								hbu = HibernateUtility.getInstance();
							 session = hbu.getHibernateSession();
//							 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
							Query query = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unit, value, totalAmount,GridTotal, BillNo from customerorder WHERE CurrentDate  BETWEEN '"+datefrom+"' AND '"+dateto+"'");	
						        List<Object[]> list = query.list();
						        System.out.println("in list size==" +list.size());
						        catList= new ArrayList<OrderBillReportDateWiseBean>(0);
								
								for (Object[] object : list) {
									k++;		
									OrderBillReportDateWiseBean reports = new OrderBillReportDateWiseBean();
									reports.setSrNo(k);
									reports.setTableNo(Long.parseLong(object[0].toString()));
									reports.setItemName(object[1].toString());
									reports.setQuantity(Double.parseDouble(object[2].toString()));
									reports.setUnitPrice(Double.parseDouble(object[3].toString()));
						//			reports.setUnitInMl(Double.parseDouble(object[4].toString()));
									reports.setUnit(object[4].toString());
									reports.setValue(Long.parseLong(object[5].toString()));
									reports.setTotalAmt(Double.parseDouble(object[6].toString()));
									reports.setGridTotal(Double.parseDouble(object[7].toString()));
									reports.setBillno(Double.parseDouble(object[8].toString()));
									catList.add(reports); 
							
								}}
							catch(Exception e)
							{
								e.printStackTrace();
							}	
						}
						else {
						try
						{
							Long k = 0l;
							hbu = HibernateUtility.getInstance();
						 session = hbu.getHibernateSession();
//						 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
						Query query = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unit, value, totalAmount,GridTotal, BillNo from customerorder WHERE hotelid = '"+hotelid+"' AND CurrentDate  BETWEEN '"+datefrom+"' AND '"+dateto+"'");	
					        List<Object[]> list = query.list();
					        System.out.println("in list size==" +list.size());
					        catList= new ArrayList<OrderBillReportDateWiseBean>(0);
							
							for (Object[] object : list) {
								k++;		
								OrderBillReportDateWiseBean reports = new OrderBillReportDateWiseBean();
								reports.setSrNo(k);
								reports.setTableNo(Long.parseLong(object[0].toString()));
								reports.setItemName(object[1].toString());
								reports.setQuantity(Double.parseDouble(object[2].toString()));
								reports.setUnitPrice(Double.parseDouble(object[3].toString()));
					//			reports.setUnitInMl(Double.parseDouble(object[4].toString()));
								reports.setUnit(object[4].toString());
								reports.setValue(Long.parseLong(object[5].toString()));
								reports.setTotalAmt(Double.parseDouble(object[6].toString()));
								reports.setGridTotal(Double.parseDouble(object[7].toString()));
								reports.setBillno(Double.parseDouble(object[8].toString()));
								catList.add(reports); 
						
							}}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						}
						return catList;
			}
	
			
			//get Order Bill Report Table No Wise 
			public List<OrderBillReportTableWiseBean> getOrderBillTableWiseReport(String tableNo, String hotelid, String usertype) {
						
						System.out.println("bill type - - "+tableNo);
						HibernateUtility hbu=null;
						Session session=null;
						List<OrderBillReportTableWiseBean> catList=null;
						String ad = "admin";
						if(usertype.equals(ad)) {
							try
							{
								Long k = 0l;
								hbu = HibernateUtility.getInstance();
							 session = hbu.getHibernateSession();
							 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unit,value ,totalAmount,GridTotal,CurrentDate, BillNo from customerorder WHERE orderBill ='"+tableNo+"'");
								
						        List<Object[]> list = query2.list();
						        System.out.println("in list size==" +list.size());
						        catList= new ArrayList<OrderBillReportTableWiseBean>(0);
								
								for (Object[] object : list) {
									k++;		
									OrderBillReportTableWiseBean reports = new OrderBillReportTableWiseBean();
									System.out.println("Result - "+Arrays.toString(object));
									reports.setSrNo(k);
									reports.setTableNo(Long.parseLong(object[0].toString()));
									reports.setItemName(object[1].toString());
									reports.setQuantity(Double.parseDouble(object[2].toString()));
									reports.setUnitPrice(Double.parseDouble(object[3].toString()));
								//	reports.setUnitInMl(Double.parseDouble(object[4].toString()));
									reports.setUnit(object[4].toString());
									reports.setValue(Long.parseLong(object[5].toString()));
									reports.setTotalAmt(Double.parseDouble(object[6].toString()));
									reports.setGridTotal(Double.parseDouble(object[7].toString()));
									reports.setCurrent_date(object[8].toString());
									reports.setBillNo(Long.parseLong(object[9].toString()));
									catList.add(reports); 
							
								}}
							catch(Exception e)
							{
								e.printStackTrace();
							}	
						}
						else {
						try
						{
							Long k = 0l;
							hbu = HibernateUtility.getInstance();
						 session = hbu.getHibernateSession();
						 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unit,value ,totalAmount,GridTotal,CurrentDate, BillNo from customerorder WHERE orderBill ='"+tableNo+"' AND hotelid = '"+hotelid+"'");
							
					        List<Object[]> list = query2.list();
					        System.out.println("in list size==" +list.size());
					        catList= new ArrayList<OrderBillReportTableWiseBean>(0);
							
							for (Object[] object : list) {
								k++;		
								OrderBillReportTableWiseBean reports = new OrderBillReportTableWiseBean();
								System.out.println("Result - "+Arrays.toString(object));
								reports.setSrNo(k);
								reports.setTableNo(Long.parseLong(object[0].toString()));
								reports.setItemName(object[1].toString());
								reports.setQuantity(Double.parseDouble(object[2].toString()));
								reports.setUnitPrice(Double.parseDouble(object[3].toString()));
							//	reports.setUnitInMl(Double.parseDouble(object[4].toString()));
								reports.setUnit(object[4].toString());
								reports.setValue(Long.parseLong(object[5].toString()));
								reports.setTotalAmt(Double.parseDouble(object[6].toString()));
								reports.setGridTotal(Double.parseDouble(object[7].toString()));
								reports.setCurrent_date(object[8].toString());
								reports.setBillNo(Long.parseLong(object[9].toString()));
								catList.add(reports); 
						
							}}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						}
						return catList;
			}
			
			
			public void deleteGridData(String delTempID, String hotelid) {
				
				
				System.out.println("In delete grid data method of newtemp DAO tempID is --- > "+delTempID);
				
				HibernateUtility hbu = null ;
				 Session session = null;
				 List list  = null;
				Transaction transaction = null;
				 try {
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					 transaction = session.beginTransaction();
					 Query query = session.createSQLQuery("delete from newtempdata where pk_temp_id='"+delTempID+"' AND hotelid = '"+hotelid+"'");
						int seletedRecords = query.executeUpdate();
						transaction.commit();
						System.out.println("Number of credit Cusr deleted == + =  "+seletedRecords);
						//list = query.list();
						
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
					
				 finally
				 { 
					 if (session!=null) {
						hbu.closeSession(session);
					}
				 }
				
			}
			// old grid delete
			public void deleteGridDataold(String delTempID, String hotelid) {
				
				
				System.out.println("In delete grid data method of temp DAO tempID is --- >  "+delTempID);
				
				HibernateUtility hbu = null ;
				 Session session = null;
				 List list  = null;
				Transaction transaction = null;
				 try {
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					 transaction = session.beginTransaction();
						Query query = session.createSQLQuery("delete from tempdata where pk_temp_id='"+delTempID+"' AND hotelid = '"+hotelid+"'");
						 query.executeUpdate();
						 transaction.commit();
					//	System.out.println("Number of credit Cusr deleted == + =   "+seletedRecord);
						 System.out.println("deleted from temp table+++++++++ +++++++++++++++ +++++++++++++ ");
						 //list = query.list();
						
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
					
				 finally
				 { 
					 if (session!=null) {
						hbu.closeSession(session);
					}
				 }
				
			}
			// kitchen del
			public void deletekitchenDataold(String tableNo, String itemId,String hotelid) {
				
				
				System.out.println("In delete kitcehn data method of temp DAO tempID is --- >  "+tableNo+ " "+itemId);
				
				HibernateUtility hbu = null ;
				 Session session = null;
				 List list  = null;
				Transaction transaction = null;
				 try {
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					 transaction = session.beginTransaction();
			//			Query query = session.createSQLQuery("delete from tempdata where pk_temp_id='"+delTempID+"' AND hotelid = '"+hotelid+"'");
						Query query = session.createSQLQuery("DELETE from kitchenorder where tableNo = '"+tableNo+"' AND itemId = '"+itemId+"' AND ActiveYN = 'N' AND hotelid = '"+hotelid+"'");
						
						
						 query.executeUpdate();
						 transaction.commit();
					//	System.out.println("Number of credit Cusr deleted == + =   "+seletedRecord);
						 System.out.println("deleted from kitchen table +++++++++ +++++++++++++++ +++++++++++++ ");
						 //list = query.list();
						
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
					
				 finally
				 { 
					 if (session!=null) {
						hbu.closeSession(session);
					}
				 }
				
			}
			
			
			
			
			public List getkitchenOrder(HttpServletRequest request){
				HttpSession sessionn = request.getSession(true);
				String username = (String)sessionn.getAttribute("user");		
				String userid = (String)sessionn.getAttribute("userid");
				String hotelid = (String)sessionn.getAttribute("hotelid");
				String hotelname=(String)sessionn.getAttribute("hotelname");
				System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
				
				HibernateUtility hbu = null;
				Session session = null ;
				List<TempItemDetail> empList=null;
	//			Transaction tx = null;
/*				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dateobj = new Date();
				 String CurrentDate = df.format(dateobj);
				 System.out.println(CurrentDate);  */
				try {
				//	String status = "Y";
					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
				//	tx = session.beginTransaction();
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date dateobj = new Date();
					 String CurrentDate = df.format(dateobj);
					 System.out.println("Today's date  -- > "+CurrentDate);

//					 Query query = session.createSQLQuery("select itemName,sale_Price,units_InMl from itementry");
	//				Query query = session.createSQLQuery("select ItemID,TableNo, ItemName, Quantity from tempdata where CurrentDate = '"+CurrentDate+"'");	
//					Query query = session.createSQLQuery("select ItemID,TableNo, ItemName, Quantity from tempdata where CurrentDate = '"+CurrentDate+"' AND ActiveYN = 'Y' ");
//			Query query = session.createSQLQuery("select k.ItemID, k.TableNo, k.ItemName, k.Quantity from kitchenorder k JOIN tempdata t ON k.ItemID = t.ItemID where t.ActiveYN ='y' AND k.CurrentDate = '"+CurrentDate+"'");	
//			Query query = session.createSQLQuery("select k.ItemID, t.TableNo, k.ItemName, k.Quantity, t.ActiveYN from tempdata t JOIN kitchenorder k ON t.ItemID = k.ItemID where t.ActiveYN ='Y' AND k.CurrentDate = '"+CurrentDate+"' GROUP BY t.ItemID");
			Query query = session.createSQLQuery("select ItemID, TableNo, ItemName, Quantity, unit, unitValue, pk_id from kitchenorder where ActiveYN ='Y' AND CurrentDate = '"+CurrentDate+"' AND hotelid = '"+hotelid+"'");
			List<Object[]> list = query.list();
					
					 empList= new ArrayList<TempItemDetail>(0);
					 
					 for (Object[] object : list) {	
						 
						 TempItemDetail reports = new TempItemDetail();
						 System.out.println("Result - - -  "+object.toString());	
						 reports.setItemId(Long.parseLong(object[0].toString()));
							reports.setTableNo(Long.parseLong(object[1].toString()));
							reports.setItemName(object[2].toString());
							reports.setQuantity(Double.parseDouble(object[3].toString()));
							reports.setUnit(object[4].toString());
							reports.setValue(Long.parseLong(object[5].toString()));
							reports.setPk_temp_id(Long.parseLong(object[6].toString()));
//							reports.setSale_price(Double.parseDouble(object[1].toString()));
//							reports.setUnit_in_ml(Double.parseDouble(object[2].toString()));
								
							empList.add(reports);
							System.out.println("list in dao"+empList);

						}
			//		 tx.commit();
				}catch(RuntimeException e){	

						}
						finally{

						hbu.closeSession(session);	
						}
					
				return empList;
				
				}	
					
			public List<OrderBillReportDateWiseBean> gettodaysReport(HttpServletRequest request) {
				HttpSession sessionn = request.getSession(true);
				String username = (String)sessionn.getAttribute("user");		
				String userid = (String)sessionn.getAttribute("userid");
				String hotelid = (String)sessionn.getAttribute("hotelid");
				String hotelname=(String)sessionn.getAttribute("hotelname");
				String usertype = (String)sessionn.getAttribute("usertype"); 
				System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
				System.out.println("usertype- "+usertype);
				
						HibernateUtility hbu=null;
						Session session=null;
						List<OrderBillReportDateWiseBean> catList=null;
						String ad = "admin";
						if(usertype.equals(ad)) {
							try
							{
								DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
								Date dateobj = new Date();
							 String CurrentDate = df.format(dateobj);
							 System.out.println("Today's date  -- > "+CurrentDate);
								Long k = 0l;
								hbu = HibernateUtility.getInstance();
							 session = hbu.getHibernateSession();

							Query query = session.createSQLQuery("select Itemname, Quantity, unitPrice, unit, value, totalAmount, GridTotal from customerorder WHERE CurrentDate  = '"+CurrentDate+"'");	
						        List<Object[]> list = query.list();
						        System.out.println("in list size -- " +list.size());
						        catList= new ArrayList<OrderBillReportDateWiseBean>(0);
								
								for (Object[] object : list) {
									k++;		
									OrderBillReportDateWiseBean reports = new OrderBillReportDateWiseBean();
									reports.setSrNo(k);
									reports.setItemName(object[0].toString());
									reports.setQuantity(Double.parseDouble(object[1].toString()));
									reports.setUnitPrice(Double.parseDouble(object[2].toString()));
							//		reports.setUnitInMl(Double.parseDouble(object[3].toString()));
									reports.setUnit(object[3].toString());
									reports.setValue(Long.parseLong(object[4].toString()));
									reports.setTotalAmt(Double.parseDouble(object[5].toString()));
									reports.setGridTotal(Double.parseDouble(object[6].toString()));
									catList.add(reports); 
							
								}}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else {
						try
						{
							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							Date dateobj = new Date();
						 String CurrentDate = df.format(dateobj);
						 System.out.println("Today's date  -- > "+CurrentDate);
							Long k = 0l;
							hbu = HibernateUtility.getInstance();
						 session = hbu.getHibernateSession();

						Query query = session.createSQLQuery("select Itemname, Quantity, unitPrice, unit, value, totalAmount, GridTotal from customerorder WHERE CurrentDate  = '"+CurrentDate+"' AND hotelid = '"+hotelid+"'");	
					        List<Object[]> list = query.list();
					        System.out.println("in list size -- " +list.size());
					        catList= new ArrayList<OrderBillReportDateWiseBean>(0);
							
							for (Object[] object : list) {
								k++;		
								OrderBillReportDateWiseBean reports = new OrderBillReportDateWiseBean();
								reports.setSrNo(k);
								reports.setItemName(object[0].toString());
								reports.setQuantity(Double.parseDouble(object[1].toString()));
								reports.setUnitPrice(Double.parseDouble(object[2].toString()));
						//		reports.setUnitInMl(Double.parseDouble(object[3].toString()));
								reports.setUnit(object[3].toString());
								reports.setValue(Long.parseLong(object[4].toString()));
								reports.setTotalAmt(Double.parseDouble(object[5].toString()));
								reports.setGridTotal(Double.parseDouble(object[6].toString()));
								catList.add(reports); 
						
							}}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						}
						return catList;
			}
			
			
			public void clearGridDataold(Long tableNo1) {
	
				HibernateUtility hbu = null ;
				 Session session = null;
				Transaction transaction = null;
				 try {
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					 transaction = session.beginTransaction();
						Query query = session.createSQLQuery("delete from tempdata where TableNo='"+tableNo1+"'");
						 query.executeUpdate();
						 transaction.commit();
						 System.out.println("-----------------cleared from temp table");
						
				} catch (Exception e) {
					e.printStackTrace();
				}
					
				 finally
				 { 
					 if (session!=null) {
						hbu.closeSession(session);
					}
				 }
				
			}

}