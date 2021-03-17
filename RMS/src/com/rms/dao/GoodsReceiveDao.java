package com.rms.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.GoodsReceiveBean;
import com.rms.bean.GoodsReceiveHibernateBean;
import com.rms.bean.GoodsReceiveReportBean;
import com.rms.bean.ItemDetailss;
import com.rms.bean.StockEntryReportBean;
import com.rms.hibernate.GoodsReceiveHibernate;
import com.rms.hibernate.ItemDetails;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.SupplierDetailsHibernate;
import com.rms.utility.HibernateUtility;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class GoodsReceiveDao {
	
	public void GoodsReceiveHibernate(GoodsReceiveHibernate gr) {

		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
		
		session.save(gr);
		System.out.println("data saved in goods recieve table --  ! ");
		transaction.commit();
		}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(RuntimeException rbe)
			{
				rbe.printStackTrace();
			}	
		}
		finally{
		hbu.closeSession(session);
		}
	
	}
	
	
	public List getAllsupplierEntriesForOrderBill(HttpServletRequest request)
	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype"); 
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		String ad = "admin";
		if(usertype.equals(ad)) {
			try{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
			//	 String item = "item";
			//	 String drink = "drink";
//				 Query query = session.createQuery("from GoodsReceiveHibernate ");
				Query query = session.createQuery("from SupplierDetailsHibernate"); 
				 list = query.list();
				 System.out.println("get all supp name () query size - - "+query.list().size());
				}
					catch(RuntimeException e){	

				}
					finally
					{
							if(session!=null){
							hbu.closeSession(session);
						}
					}
		}
		else {
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
	//	 String item = "item";
	//	 String drink = "drink";
//		 Query query = session.createQuery("from GoodsReceiveHibernate ");
		Query query = session.createQuery("from SupplierDetailsHibernate where hotelid = '"+hotelid+"'"); 
		 list = query.list();
		 System.out.println("get all supp name () query size - - "+query.list().size());
		}
			catch(RuntimeException e){	

		}
			finally
			{
					if(session!=null){
					hbu.closeSession(session);
				}
			}
		}
	return list;
	
	}
	
	//get All Item details For DropDown
	public List getAllItemEntriesForOrderBill()

	{
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		// String item = "item";
		 //String drink = "drink";
		 Query query = session.createQuery("from GoodsReceiveHibernate ");
		
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
	
	public List getGridDataForgoodreceive(String fk_item_id_drop1) {

		HibernateUtility hbu = null ;
		Session session = null;
		List<ItemEntry> list  = null;
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			//Query query = session.createSQLQuery("SELECT p.pk_outward_id, p.productName, p.okquantity, p.rate,p.hsn ,p.Operation  FROM outward_details p WHERE p.outwardchallan_no="+outwardchallanno);
	//		Query query = session.createSQLQuery("select pk_item_entry_Id,itemName,Type,buy_Price,sale_Price,units_InMl from itementry where itemName='"+fk_item_id_drop1+"'");
		
	//		Query query = session.createSQLQuery("select pk_item_entry_Id,itemName,Type,buy_Price,sale_Price,units_InMl from itementry where pk_item_entry_Id ='"+fk_item_id_drop1+"'");
			Query query = session.createSQLQuery("select pk_item_entry_Id,itemName,Type,buy_Price,sale_Price,unit, quantity from itementry where pk_item_entry_Id = '"+fk_item_id_drop1+"'");
			//	list = query.list();
			
			List<Object[]> list1 = query.list();
			list = new ArrayList<ItemEntry>(0);
			for (Object[] o : list1) {
//				ItemDetailss poJqgrid = new ItemDetailss();
				ItemEntry po= new ItemEntry();
				
		/*		poJqgrid.setPk_item_entry_Id(Long.parseLong((o[0].toString())));
				System.out.println("item entry id -- "+poJqgrid.getPk_item_entry_Id());
				poJqgrid.setFk_item_id_drop1(o[1].toString());
				System.out.println("fk item id drop1 (item name)--  "+poJqgrid.getFk_item_id_drop1());
				poJqgrid.setType((o[2].toString()));
				System.out.println("type -- "+poJqgrid.getType());
				poJqgrid.setBuyPrice(Double.parseDouble(o[3].toString()));
				System.out.println("buy price --  "+poJqgrid.getBuyPrice());
				poJqgrid.setSalePrice(Double.parseDouble(o[4].toString()));
				System.out.println("sale pricce --  "+poJqgrid.getSalePrice());
				poJqgrid.setUnit(Long.parseLong((o[5].toString())));
				System.out.println("unit in ml -- "+poJqgrid.getUnit());
				poJqgrid.setQuantity(0d);
				poJqgrid.setGst(0d); */
				//poJqgrid.setOperation(o[5].toString());
				//poJqgrid.setOkquantity1(Double.parseDouble(o[2].toString()));
				po.setPk_item_entry_Id(Long.parseLong(o[0].toString()));
				po.setItemName(o[1].toString());
				po.setType(o[2].toString());
				po.setBuyPrice(Long.parseLong(o[3].toString()));
				po.setSalePrice(Long.parseLong(o[4].toString()));
				po.setUnit(o[5].toString());
				po.setValue(Long.parseLong(o[6].toString()));
				
				po.setQuantity(0d);
			//	po.setGst(0d);
				po.setIgst(0d);
		//		po.setCgst(0d);
		//		po.setSgst(0d);
				po.setGst(0d);
				po.setHSNNo(0d);
				System.out.println("pk id - "+po.getPk_item_entry_Id()+", item name  "+po.getItemName()+", type "+po.getType()+", buyprice - "+po.getBuyPrice()+", sale price  "+po.getSalePrice()+", units  - "+po.getUnit()+" quantitttt - - "+po.getValue());
				list.add(po);
			}

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
		return list;
	}

	
	public List getGridForGoodReceive(String fk_item_id_drop1)
	{
		HibernateUtility hbu = null;
		Session session =  null;
		Query query = null;
		 List<SupplierDetailsHibernate> list = null;
		 try {
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 query = session.createQuery("select fk_item_id , fk_supplier_id, item_name, supplier_name, bill_no, date_of_goods_receive, buy_price, quantity,gst, gross_total from goods_receive where fk_item_id_drop1 ="+fk_item_id_drop1);
			 list = query.list(); 
		} catch (RuntimeException e) {
			e.printStackTrace();
			
		}
		 
		 finally
		 {
			 if (session!=null) {
				hbu.closeSession(session);
			}
		 }
				return list;
	}
	
	// get goods receive list
		 public List getAllGoodsReceiveList(HttpServletRequest request){
			 HttpSession sessionn = request.getSession(true);
				String username = (String)sessionn.getAttribute("user");		
				String userid = (String)sessionn.getAttribute("userid");
				String hotelid = (String)sessionn.getAttribute("hotelid");
				String hotelname=(String)sessionn.getAttribute("hotelname");
				System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
				HibernateUtility hbu=null;
				Session session=null;
				List<GoodsReceiveHibernateBean> custList=null;
			try{	

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				
//				Query query=session.createSQLQuery("SELECT pk_store_management_id, item_name, supplier_name, bill_no, buy_price, sale_Price, quantity, gst, gross_total, date_of_goods_receive from goods_receive");
				Query query = session.createSQLQuery("SELECT supplier_name, bill_no, item_name, buy_price, sale_Price, quantity,  gross_total, date_of_goods_receive from goods_receive where hotelid = '"+hotelid+"'");	
				List<Object[]> list = query.list();

				custList= new ArrayList<GoodsReceiveHibernateBean>(0);

			  for (Object[] object : list) {	
				  System.out.println("Result fetched --  "+Arrays.toString(object));
				  GoodsReceiveHibernateBean reports = new GoodsReceiveHibernateBean();
	
				  reports.setSuplierName(object[0].toString());
				  reports.setBillno(Long.parseLong(object[1].toString()));
					reports.setFk_item_id_drop1(object[2].toString());  
					reports.setBuyPrice(Double.parseDouble(object[3].toString()));
					reports.setSale_Price(Double.parseDouble(object[4].toString()));
					reports.setQuantity(Double.parseDouble(object[5].toString()));
				//	reports.setGst(Double.parseDouble(object[6].toString()));
				//	reports.setTotal(Double.parseDouble(object[6].toString()));
					reports.setGrossTotal(Double.parseDouble(object[6].toString()));
					reports.setGoodsReceiveDate(object[7].toString());		
				
				custList.add(reports);

			}}catch(RuntimeException e){	

			}
			finally{

			hbu.closeSession(session);	
			}
			return custList;

		 }
		
	
	//get goods receive report 
			public List<GoodsReceiveReportBean> getGoodsReceiveReport(String itemName, String hotelid, String usertype) {
				
						HibernateUtility hbu=null;
						Session session=null;
						List<GoodsReceiveReportBean> catList=null;
						String ad  = "admin";
						if(usertype.equals(ad)) {
							try
							{
								Long k = 0l;
								hbu = HibernateUtility.getInstance();
							 session = hbu.getHibernateSession();
							 Query query2 = session.createSQLQuery("select item_name, supplier_name, bill_no, buy_price, quantity, gross_total, date_of_goods_receive,Grid_total from goods_receive where item_name='"+itemName+"'");
			//				 Query query2 = session.createSQLQuery("select item_name, supplier_name, bill_no, buy_price, quantity,Grid_total, date_of_goods_receive,  gross_total from goods_receive where item_name='"+itemName+"' AND hotelid = '"+hotelid+"'");
						        List<Object[]> list = query2.list();
						        catList= new ArrayList<GoodsReceiveReportBean>(0);
						        
								for (Object[] object : list) {
									
									 System.out.println("Result -->  "+Arrays.toString(object));
									k++;		
									GoodsReceiveReportBean reports = new GoodsReceiveReportBean();
									reports.setSrNo(k);
									reports.setProductName(object[0].toString());
									reports.setSuplierName(object[1].toString());
									reports.setBillno(Double.parseDouble(object[2].toString()));
									reports.setBuyPrice(Double.parseDouble(object[3].toString()));
									reports.setQuantity(Double.parseDouble(object[4].toString()));
									reports.setTotal(Double.parseDouble(object[5].toString()));
									reports.setGoodsReceiveDate(object[6].toString());
									reports.setGrossTotal(Double.parseDouble(object[7].toString()));
							//		reports.setGrid_total(object[8].toString());
									
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
//						 Query query2 = session.createSQLQuery("select item_name, supplier_name, bill_no, buy_price, quantity, gross_total, date_of_goods_receive,Grid_total from goods_receive where item_name='"+itemName+"'");
						 Query query2 = session.createSQLQuery("select item_name, supplier_name, bill_no, buy_price, quantity,Grid_total, date_of_goods_receive,  gross_total from goods_receive where item_name='"+itemName+"' AND hotelid = '"+hotelid+"'");
					        List<Object[]> list = query2.list();
					        catList= new ArrayList<GoodsReceiveReportBean>(0);
					        
							for (Object[] object : list) {
								
								 System.out.println("Result -->  "+Arrays.toString(object));
								k++;		
								GoodsReceiveReportBean reports = new GoodsReceiveReportBean();
								reports.setSrNo(k);
								reports.setProductName(object[0].toString());
								reports.setSuplierName(object[1].toString());
								reports.setBillno(Double.parseDouble(object[2].toString()));
								reports.setBuyPrice(Double.parseDouble(object[3].toString()));
								reports.setQuantity(Double.parseDouble(object[4].toString()));
								reports.setTotal(Double.parseDouble(object[5].toString()));
								reports.setGoodsReceiveDate(object[6].toString());
								reports.setGrossTotal(Double.parseDouble(object[7].toString()));
						//		reports.setGrid_total(object[8].toString());
								
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
					
public List<GoodsReceiveHibernate> getgoodsreceiveReport(String supplierName,String datefrom, String dateto, String hotelid, String usertype) {
						
						HibernateUtility hbu = null;
						Session session = null;
						List<GoodsReceiveHibernate> catList = null;
						String ad = "admin";
						if(usertype.equals(ad)) {
							try
							{
								Long k = 0l;
								hbu = HibernateUtility.getInstance();
							 session = hbu.getHibernateSession();
		
				Query query = session.createSQLQuery("select  bill_no,item_name, buy_price,sale_Price ,quantity,igst,cgst,sgst ,gross_total, Grid_total from goods_receive where supplier_name='"+supplierName+"' AND date_of_goods_receive BETWEEN '"+datefrom+"' AND '"+dateto+"'");				
						        List<Object[]> list = query.list();
						        catList= new ArrayList<GoodsReceiveHibernate>(0);
						        
								for (Object[] object : list) {
									
									 System.out.println("Result -->  "+Arrays.toString(object));
									k++;		
									GoodsReceiveHibernate reports = new GoodsReceiveHibernate();
									reports.setSrNo(k);
									reports.setBillno(Long.parseLong(object[0].toString()));
									reports.setFk_item_id_drop1(object[1].toString());
									reports.setBuyPrice(Double.parseDouble(object[2].toString()));
									reports.setSaleprice(Double.parseDouble(object[3].toString()));
									reports.setQuantity(Double.parseDouble(object[4].toString()));
									reports.setIgst(Double.parseDouble(object[5].toString()));
									reports.setCgst(Double.parseDouble(object[6].toString()));
									reports.setSgst(Double.parseDouble(object[7].toString()));
							//		reports.setGst(Double.parseDouble(object[5].toString()));
									reports.setGrossTotal(Double.parseDouble(object[8].toString()));
									reports.setTotal(Double.parseDouble(object[9].toString()));
							
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
	
			Query query = session.createSQLQuery("select  bill_no,item_name, buy_price,sale_Price ,quantity,igst,cgst,sgst ,gross_total, Grid_total from goods_receive where supplier_name='"+supplierName+"' AND date_of_goods_receive BETWEEN '"+datefrom+"' AND '"+dateto+"' AND hotelid = '"+hotelid+"'");				
					        List<Object[]> list = query.list();
					        catList= new ArrayList<GoodsReceiveHibernate>(0);
					        
							for (Object[] object : list) {
								
								 System.out.println("Result -->  "+Arrays.toString(object));
								k++;		
								GoodsReceiveHibernate reports = new GoodsReceiveHibernate();
								reports.setSrNo(k);
								reports.setBillno(Long.parseLong(object[0].toString()));
								reports.setFk_item_id_drop1(object[1].toString());
								reports.setBuyPrice(Double.parseDouble(object[2].toString()));
								reports.setSaleprice(Double.parseDouble(object[3].toString()));
								reports.setQuantity(Double.parseDouble(object[4].toString()));
								reports.setIgst(Double.parseDouble(object[5].toString()));
								reports.setCgst(Double.parseDouble(object[6].toString()));
								reports.setSgst(Double.parseDouble(object[7].toString()));
						//		reports.setGst(Double.parseDouble(object[5].toString()));
								reports.setGrossTotal(Double.parseDouble(object[8].toString()));
								reports.setTotal(Double.parseDouble(object[9].toString()));
						
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

					public List<GoodsReceiveHibernate> getgoodReceiveDateWiseReport(String goodReceiveDate, String goodReceiveDateto, String hotelid, String usertype){
						HibernateUtility hbu = null;
						Session session = null;
						List<GoodsReceiveHibernate> catList = null;
						String ad = "admin";
						if(usertype.equals(ad)) {
							try
							{
								Long k = 0l;
								hbu = HibernateUtility.getInstance();
							 session = hbu.getHibernateSession();

							
							
					Query  query = session.createSQLQuery("select item_name, bill_no, buy_price,sale_Price ,quantity, Grid_total, gross_total from goods_receive where date_of_goods_receive BETWEEN '"+goodReceiveDate+"' AND '"+goodReceiveDateto+"'");		
			        List<Object[]> list = query.list();
			        catList= new ArrayList<GoodsReceiveHibernate>(0);
			        
					for (Object[] object : list) {
						
						 System.out.println("Result -->  "+Arrays.toString(object));
						k++;		
						GoodsReceiveHibernate reports = new GoodsReceiveHibernate();
						
						reports.setSrNo(k);
						reports.setFk_item_id_drop1(object[0].toString());
						reports.setBillno(Long.parseLong(object[1].toString()));
						reports.setBuyPrice(Double.parseDouble(object[2].toString()));
						reports.setSaleprice(Double.parseDouble(object[3].toString()));
						reports.setQuantity(Double.parseDouble(object[4].toString()));
						reports.setTotal(Double.parseDouble(object[5].toString()));
						reports.setGrossTotal(Double.parseDouble(object[6].toString()));
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

						
						
				Query  query = session.createSQLQuery("select item_name, bill_no, buy_price,sale_Price ,quantity, Grid_total, gross_total from goods_receive where date_of_goods_receive BETWEEN '"+goodReceiveDate+"' AND '"+goodReceiveDateto+"' AND hotelid = '"+hotelid+"'");		
		        List<Object[]> list = query.list();
		        catList= new ArrayList<GoodsReceiveHibernate>(0);
		        
				for (Object[] object : list) {
					
					 System.out.println("Result -->  "+Arrays.toString(object));
					k++;		
					GoodsReceiveHibernate reports = new GoodsReceiveHibernate();
					
					reports.setSrNo(k);
					reports.setFk_item_id_drop1(object[0].toString());
					reports.setBillno(Long.parseLong(object[1].toString()));
					reports.setBuyPrice(Double.parseDouble(object[2].toString()));
					reports.setSaleprice(Double.parseDouble(object[3].toString()));
					reports.setQuantity(Double.parseDouble(object[4].toString()));
					reports.setTotal(Double.parseDouble(object[5].toString()));
					reports.setGrossTotal(Double.parseDouble(object[6].toString()));
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
}


