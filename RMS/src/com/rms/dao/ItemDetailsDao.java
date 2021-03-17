package com.rms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.GetItemDetailsDrinkWiseBean;
import com.rms.bean.GetItemDetailsItemNameWiseBean;
import com.rms.bean.menuList;
import com.rms.hibernate.ItemDetails;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.Stock;
import com.rms.utility.HibernateUtility;

public class ItemDetailsDao {
	
	public void ItemDetail(ItemDetails items)
	{	
	HibernateUtility hbu = null ;
	Session session  = null;
	Transaction transaction = null;
	
	
	try {
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		transaction = session.beginTransaction();
		
		Long fk_item_id = items.getFk_item_id();
		ItemEntry itemDe = (ItemEntry) session.load(ItemEntry.class, fk_item_id);
		items.setItemEntry(itemDe);
		
		session.save(items);
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


public List getAllItemDetails(){
	
	HibernateUtility hbu = null;
	Session session = null ;
	Query query = null;
	List list = null;
	try {
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();

		query = session.createQuery("from ItemEntry");
		 list = query.list();

	} catch (RuntimeException e) {
	//	Log.error("error in method", e);
	}
	finally
	{
		if (session!=null) {
			hbu.closeSession(session);
		}
	}
return list;	
}


//get item detail to edit
		public List getAllItemDetailsForEdit(Long pk_item_details_id) {

			HibernateUtility hbu = null;
			Session session =  null;
			Query query = null;
			 List list = null;
			 
			 System.out.println("id in DAO- ID----------#############################"+pk_item_details_id);
			 
			 try {
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
	//			 query = session.createSQLQuery("SELECT pk_item_entry_Id,sale_price,buy_price,Type,units_InMl FROM itementry WHERE pk_item_entry_Id =:pk_item_details_id");
				 query = session.createSQLQuery("SELECT pk_item_entry_Id,itemName ,sale_price,buy_price,Type,unit, quantity FROM itementry WHERE pk_item_entry_Id =:pk_item_details_id");
				 query.setParameter("pk_item_details_id", pk_item_details_id);
				 list = query.list(); 
				 
				 System.out.println("Size-----------#############################"+list.size());
				 
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			 
			 finally
			 {
				 if (session!=null) {
					hbu.closeSession(session);
				}
			 }
			 //System.out.println("out of dao - return credit customer List : "+list);
					return list;

			}

		
		// get item detail list
		 public List getAllItemDetailsForList(){
				
				HibernateUtility hbu=null;
				Session session=null;
				List<ItemDetails> custList=null;
			try{	

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();

				Query query=session.createSQLQuery("SELECT pk_item_details_id,sale_price,buy_price FROM item_details");
				List<Object[]> list = query.list();

				custList= new ArrayList<ItemDetails>(0);


			for (Object[] object : list) {	
				ItemDetails reports = new ItemDetails();
				reports.setPk_item_details_id(Long.parseLong(object[0].toString()));
				reports.setSale_price(Double.parseDouble(object[1].toString()));
				reports.setBuy_price(Double.parseDouble(object[2].toString()));
				
				custList.add(reports);

			}}catch(RuntimeException e){	

			}
			finally{

			hbu.closeSession(session);	
			}
			return custList;

		 }

		//get drink detail to edit
			public List getAllDrinkDetailsForEdit(Long pk_item_details_id) {

				HibernateUtility hbu = null;
				Session session =  null;
				Query query = null;
				 List list = null;
				 try {
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					 query = session.createSQLQuery("SELECT pk_item_details_id, sale_price, buy_price, unit_in_ml FROM item_details WHERE pk_item_details_id ="+pk_item_details_id);
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
				 System.out.println("out of dao - return credit customer List : "+list);
						return list;

				}

			
			// get drink detail list
			 public List getAllDrinkDetailsForList(){
					
					HibernateUtility hbu=null;
					Session session=null;
					List<ItemDetails> custList=null;
				try{	

					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();

					Query query=session.createSQLQuery("SELECT pk_item_details_id,sale_price,buy_price,unit_in_ml FROM item_details");
					List<Object[]> list = query.list();

					custList= new ArrayList<ItemDetails>(0);


				for (Object[] object : list) {	
					ItemDetails reports = new ItemDetails();
					reports.setPk_item_details_id(Long.parseLong(object[0].toString()));
					reports.setSale_price(Double.parseDouble(object[1].toString()));
					reports.setBuy_price(Double.parseDouble(object[2].toString()));
					reports.setUnit_in_ml(Double.parseDouble(object[3].toString()));
					
					custList.add(reports);

				}}catch(RuntimeException e){	

				}
				finally{

				hbu.closeSession(session);	
				}
				return custList;

			 }


public List getMenuList(HttpServletRequest request)
{
	HttpSession sessionn = request.getSession(true);
	String username = (String)sessionn.getAttribute("user");		
	String userid = (String)sessionn.getAttribute("userid");
	String hotelid = (String)sessionn.getAttribute("hotelid");
	String hotelname=(String)sessionn.getAttribute("hotelname");
	String usertype = (String)sessionn.getAttribute("usertype"); 
	System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" , usrtype - "+usertype);
	
	HibernateUtility hbu = null;
	Session session = null ;
	List<menuList> empList=null;
	String ad = "admin";
	if(usertype.equals(ad)) {
		try {
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			 Query query = session.createSQLQuery("select itemName,sale_Price,unit, quantity from itementry");
				
			 List<Object[]> list = query.list();
			
			 empList= new ArrayList<menuList>(0);
			 
			 for (Object[] object : list) {	
				 
				 menuList reports = new menuList();
					
					reports.setItemName(object[0].toString().toString());
					reports.setSale_price(Double.parseDouble(object[1].toString()));
					reports.setUnit((object[2].toString()));
					reports.setValue(Double.parseDouble(object[3].toString()));
					
					empList.add(reports);
					System.out.println("list in dao"+empList);

				}}catch(RuntimeException e){	

				}
				finally{

				hbu.closeSession(session);	
				}
	}
	else {
	try {
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();

		 Query query = session.createSQLQuery("select itemName,sale_Price,unit, quantity from itementry where hotelid = '"+hotelid+"'");
			
		 List<Object[]> list = query.list();
		
		 empList= new ArrayList<menuList>(0);
		 
		 for (Object[] object : list) {	
			 
			 menuList reports = new menuList();
				
				reports.setItemName(object[0].toString().toString());
				reports.setSale_price(Double.parseDouble(object[1].toString()));
				reports.setUnit((object[2].toString()));
				reports.setValue(Double.parseDouble(object[3].toString()));
				
				empList.add(reports);
				System.out.println("list in dao"+empList);

			}}catch(RuntimeException e){	

			}
			finally{

			hbu.closeSession(session);	
			}
	}
	return empList;
	
	}

//report for menu list item name wise
public List<Stock> getItemNamewiseReport(HttpServletRequest request) {
	HttpSession sessionn = request.getSession(true);
	String username = (String)sessionn.getAttribute("user");		
	String userid = (String)sessionn.getAttribute("userid");
	String hotelid = (String)sessionn.getAttribute("hotelid");
	String hotelname=(String)sessionn.getAttribute("hotelname");
	String usertype = (String)sessionn.getAttribute("usertype"); 
	System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" , usrtype - "+usertype);
	//(String fk_item_id)
	HibernateUtility hbu=null;
	Session session=null;
	List<Stock> catList=null;
	String ad = "admin";
	if(usertype.equals(ad)) {
		try
		{
			Long k = 1l;
			hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
//			 Query query2 = session.createSQLQuery("select fk_item_details_id, stock,ie.itemName  from stock left join itementry ie on fk_item_details_id=ie.pk_item_entry_Id WHERE fk_item_details_id ='"+fk_item_id+"'");
		 Query query2 = session.createSQLQuery("select stock, ie.itemName, ie.quantity ,ie.unit  from stock left join itementry ie on fk_item_details_id=ie.pk_item_entry_Id");		
			 List<Object[]> list = query2.list();
		        System.out.println("in list size==  " +list.size());
		        catList= new ArrayList<Stock>(0);
				
				for (Object[] object : list) {
							
					Stock reports = new Stock();
					reports.setSrNo(k);
				//	reports.setItem_details_id(Long.parseLong(object[0].toString().toString()));
					reports.setStock(Double.parseDouble(object[0].toString().toString()));
					reports.setItemName(object[1].toString());
					reports.setValue(Double.parseDouble(object[2].toString()));
					reports.setUnit(object[3].toString());
					k++;
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
		Long k = 1l;
		hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
//		 Query query2 = session.createSQLQuery("select fk_item_details_id, stock,ie.itemName  from stock left join itementry ie on fk_item_details_id=ie.pk_item_entry_Id WHERE fk_item_details_id ='"+fk_item_id+"'");
	 Query query2 = session.createSQLQuery("select stock, ie.itemName, ie.quantity ,ie.unit  from stock left join itementry ie on fk_item_details_id=ie.pk_item_entry_Id where ie.hotelid = '"+hotelid+"'");		
		 List<Object[]> list = query2.list();
	        System.out.println("in list size==  " +list.size());
	        catList= new ArrayList<Stock>(0);
			
			for (Object[] object : list) {
						
				Stock reports = new Stock();
				reports.setSrNo(k);
			//	reports.setItem_details_id(Long.parseLong(object[0].toString().toString()));
				reports.setStock(Double.parseDouble(object[0].toString().toString()));
				reports.setItemName(object[1].toString());
				reports.setValue(Double.parseDouble(object[2].toString()));
				reports.setUnit(object[3].toString());
				k++;
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

//report for menu list Drink wise
public List<GetItemDetailsDrinkWiseBean> getDrinkwiseReport(String fk_item_id) {
	
	HibernateUtility hbu=null;
	Session session=null;
	List<GetItemDetailsDrinkWiseBean> catList=null;
	try
	{
		Long k = 0l;
		hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
		 Query query2 = session.createSQLQuery("select fk_item_id, sale_price, buy_price, unit_in_ml from item_details WHERE fk_item_id ='"+fk_item_id+"'");
			
		 List<Object[]> list = query2.list();
	        System.out.println("in list size==" +list.size());
	        catList= new ArrayList<GetItemDetailsDrinkWiseBean>(0);
			
			for (Object[] object : list) {
				k++;		
				GetItemDetailsDrinkWiseBean reports = new GetItemDetailsDrinkWiseBean();
				reports.setSrNo(k);
				reports.setFk_item_id(Long.parseLong(object[0].toString().toString()));
				reports.setSale_price(Double.parseDouble(object[1].toString()));
				reports.setBuy_price(Double.parseDouble(object[2].toString()));
				reports.setUnit_in_ml(Double.parseDouble(object[3].toString()));
				
				catList.add(reports); 
				
			}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return catList;
}
}

	
	
	
	/*public void ItemDetail(ItemDetails ai){
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session = hbu.getHibernateSession();
		Transaction transaction = session.beginTransaction();
	
		Long fk_item_id = ai.getFk_item_id();
		ItemDetails itemDetails = (ItemDetails) session.load(ItemDetails.class, fk_item_id);
		ai.setFk_item_id(fk_item_id);
		
		
 		 
		 DateFormat df=new SimpleDateFormat("dd/mm/yyyy");
		 Date dObj=new Date();
		 
		 ie.setInsertDate(dObj);
		 ie.setModifiedDate(dObj);
		 
		 
		 
		
		session.save(ai);
		transaction.commit();
		}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(Exception rbe)
			{
				rbe.printStackTrace();
			}	
		}finally{
		hbu.closeSession(session);
		//}
	}
		
	
}*/
