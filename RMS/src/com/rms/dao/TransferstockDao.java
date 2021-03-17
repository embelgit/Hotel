package com.rms.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.TransferStockHibernateBean;
import com.rms.hibernate.transferstockHibernate;
import com.rms.hibernate.ItemEntry;
import com.rms.utility.HibernateUtility;

public class TransferstockDao {
	
	public void transferstockHibernate(transferstockHibernate gr) {

		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
		
		session.save(gr);
		System.out.println("data saved in Trasfer Stock table --  ! ");
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
	
	public List getAllTranferStockList(HttpServletRequest request){
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		HibernateUtility hbu=null;
		Session session=null;
		List<TransferStockHibernateBean> custList=null;
	try{	

		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		
//		Query query=session.createSQLQuery("SELECT pk_store_management_id, item_name, supplier_name, bill_no, buy_price, sale_Price, quantity, gst, gross_total, date_of_goods_receive from goods_receive");
		Query query = session.createSQLQuery("SELECT hotelName,item_name, buy_price, sale_Price, quantity,  total  from transferstock ");	
		List<Object[]> list = query.list();

		custList= new ArrayList<TransferStockHibernateBean>(0);

	  for (Object[] object : list) {	
		  System.out.println("Result fetched --  "+Arrays.toString(object));
		  TransferStockHibernateBean reports = new TransferStockHibernateBean();
		  
		  	reports.setHotelname(object[0].toString());
			reports.setFk_item_id_drop1(object[1].toString());  
			reports.setBuyPrice(Double.parseDouble(object[2].toString()));
			reports.setSaleprice(Double.parseDouble(object[3].toString()));
			reports.setQuantity(Double.parseDouble(object[4].toString()));
			reports.setTotal(Double.parseDouble(object[5].toString()));
		
		custList.add(reports);

	}}catch(RuntimeException e){	

	}
	finally{

	hbu.closeSession(session);	
	}
	return custList;

}



public List getGridTransferStock(String fk_item_id_drop1) {

	HibernateUtility hbu = null ;
	Session session = null;
	List<ItemEntry> list  = null;
	try {
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		//Query query = session.createSQLQuery("SELECT p.pk_outward_id, p.productName, p.okquantity, p.rate,p.hsn ,p.Operation  FROM outward_details p WHERE p.outwardchallan_no="+outwardchallanno);
//		Query query = session.createSQLQuery("select pk_item_entry_Id,itemName,Type,buy_Price,sale_Price,units_InMl from itementry where itemName='"+fk_item_id_drop1+"'");
	
//		Query query = session.createSQLQuery("select pk_item_entry_Id,itemName,Type,buy_Price,sale_Price,units_InMl from itementry where pk_item_entry_Id ='"+fk_item_id_drop1+"'");
		Query query = session.createSQLQuery("select pk_item_entry_Id,itemName,buy_Price,sale_Price,quantity from itementry where pk_item_entry_Id = '"+fk_item_id_drop1+"'");
		//	list = query.list();
		
		List<Object[]> list1 = query.list();
		list = new ArrayList<ItemEntry>(0);
		for (Object[] o : list1) {
//			ItemDetailss poJqgrid = new ItemDetailss();
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
		//	po.setType(o[2].toString());
			po.setBuyPrice(Long.parseLong(o[2].toString()));
			po.setSalePrice(Long.parseLong(o[3].toString()));
			//po.setUnit(o[5].toString());
			po.setValue(Long.parseLong(o[4].toString()));
			
			po.setQuantity(0d);
		//	po.setGst(0d);
			//po.setIgst(0d);
	//		po.setCgst(0d);
	//		po.setSgst(0d);
			//po.setGst(0d);
			//po.setHSNNo(0d);
			System.out.println("pk id - "+po.getPk_item_entry_Id()+", item name  "+po.getItemName()+", buyprice - "+po.getBuyPrice()+", sale price  "+po.getSalePrice()+",  quantitttt - - "+po.getValue());
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
}

