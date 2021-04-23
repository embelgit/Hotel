package com.rms.dao;

import java.math.BigDecimal;
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
import com.rms.bean.OrderBillList;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.OrderBill;
import com.rms.hibernate.SupplierDetailsHibernate;
import com.rms.hibernate.TempItemDetail;
import com.rms.hibernate.hotelnamebean;
import com.rms.hibernate.kitchenorderHibernate;
import com.rms.utility.HibernateUtility;

public class OrderBillDao {

	public void orderBill(OrderBill order){
		
System.out.println("In DAO");
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		try
		{
			
		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
		
	   System.out.println("Tx started");
		session.save(order);
		transaction.commit();
		System.out.println("Successful");
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally	{
			if(session!=null)
			{
				hbu.closeSession(session);
			}
}
	    	
	 }
	
	// get Order Bill detail list
			 public List getAllOrderBillDetailsForList(){
					
					HibernateUtility hbu=null;
					Session session=null;
					List<OrderBillList> custList=null;
				try{	

					hbu = HibernateUtility.getInstance();
					session = hbu.getHibernateSession();
					String abc="Y";
					Query query=session.createSQLQuery("SELECT pk_temp_id,TableNo,ItemName,Quantity,unitPrice,unitInMl FROM tempdata where ActiveYN='Y'");
					//query.setParameter(abc, abc);
					List<Object[]> list = query.list();

					custList= new ArrayList<OrderBillList>(0);


				for (Object[] object : list) {	
					OrderBillList  reports = new OrderBillList();
					reports.setPk_order_bill_id(Long.parseLong(object[0].toString()));
					reports.setTableNo((object[1].toString()));
					reports.setItemName((object[2].toString()));
					reports.setQuantity(object[3].toString());
					reports.setUnitPrice(((object[4].toString())));
					reports.setUnitINMl(((object[5].toString())));
					//reports.setTotal((((object[6].toString()))));
					//reports.setGrossTotal(((object[7].toString())));
					
					
					
					custList.add(reports);

				}}catch(RuntimeException e){	

				}
				finally{

				hbu.closeSession(session);	
				}
				return custList;

			 }

	public List getSubCategoriesByRootcategory(String catID)
	{
		System.out.println(catID+"CAT ID FROM DAO");
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
			try
			{
				System.out.println("");
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				Query query = session.createQuery("select c.subCatId , c.subCategory from SubCategoryDetails c where  c.fk_category_id ="+catID);
				list = query.list();
				System.out.println(list.size()+"SIZE");
			}
				catch(RuntimeException e)
				{	
					//	Log.error("Error in getSubCategoriesByRootcategory(String mainCatId)", e);
			}
			finally	{
						if(session!=null)
						{
							hbu.closeSession(session);
						}
			}
			
			return list;
		}

	public List getItemDetailsById(String fk_item_id,String tableNo, Long hotelid, Long userid, String username, String hotelname) {

		HibernateUtility hbu=null;
		Session session=null;
		 List<GetItemDetails> saleReports = null; 
		 List<Object[]> list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 		//Query query = session.createSQLQuery("select  i.itemName, i.pk_item_entry_Id , i.units_InMl , i.sale_Price from itementry i    where i.pk_item_entry_Id='"+fk_item_id+"' ");
			Query query = session.createSQLQuery("select  i.itemName, i.pk_item_entry_Id , i.unit ,quantity ,i.sale_Price,s.stock from itementry i  join stock s   where i.pk_item_entry_Id='"+fk_item_id+"' and i.pk_item_entry_Id = s.fk_item_details_id AND s.hotelid ='"+hotelid+"'");
			list = query.list();
			
			// =============   if query is zero
			
			if(query.list().size()==0) {
				Query queryy = session.createSQLQuery("select itemName, pk_item_entry_Id , unit ,quantity ,sale_Price from itementry where pk_item_entry_Id='"+fk_item_id+"' AND hotelid ='"+hotelid+"'");
				list = queryy.list();
				saleReports = new ArrayList<GetItemDetails>(0);
				for (Object[] object : list) {
					System.out.println("  if item is not present in stock table - -  - - ");
					System.out.println("Result - "+Arrays.toString(object));
					com.rms.bean.GetItemDetails reports = new com.rms.bean.GetItemDetails();
					//String tableNo1 = tableNo; 
					String itemName= (String)object[0];
					BigInteger itemId1 = ((BigInteger)object[1]);
					Long itemId = itemId1.longValue();
					Double quantity= 1.0;
					Double unitPrice= (Double.parseDouble(object[4].toString()));
//					Double unitInMl= (Double.parseDouble(object[2].toString()));
					String unit = ((object[2].toString()));
					Long value = (Long.parseLong(object[3].toString()));
					//BigInteger itemdetailsid =((BigInteger)object[4]);
					Double stock= 0d;
						/*
						 * if(stock == null){ stock = Double.parseDouble("NA"); }
						 */
					
					System.out.println("tableNo :- " +tableNo + ",  itemName :- " +itemName+ ",  unitInMl :- "+unit+ ",  Stock :- "+stock+" while fetching DATA initially - - ");
					
					TempItemDetailDao data = new TempItemDetailDao();
					List stkList  = data.getAllItemEntry(hotelid);
					
					if(stkList.size() == 0){
						
						TempItemDetail tid = new TempItemDetail();
						
						tid.setItemName(itemName);
						
						tid.setItemId(itemId);
						
						tid.setTableNo(Long.parseLong(tableNo));
						
						tid.setQuantity(1.0);
						
						tid.setUnitPrice(unitPrice);

					//	tid.setUnitInMl(unitInMl);
						tid.setUnit(unit);
						tid.setValue((value));
						tid.setStock(stock);
					//	tid.setCgst(0d);
						tid.setGst(0d);
						//	tid.setSgst(0d);
						System.out.println("  Stock ->  "+tid.getStock());
						//tid.setFk_item_details_id((itemdetailsid));
						
						tid.setTotalAmt(unitPrice);
						System.out.println(" total in temp table (0)  - - - - - -- "+tid.getTotalAmt());
						tid.setActiveYN('Y');
						
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						Date dateobj = new Date();
						System.out.println(df.format(dateobj));
						
						tid.setCurrent_date(dateobj);
						
						tid.setUserid((userid));
						tid.setUsername(username);
						tid.setHotelid((hotelid));
						tid.setHotelname(hotelname);
						
						TempItemDetailDao dao = new TempItemDetailDao();
						dao.regTempData(tid);
						
					}
					else{
						for(int i=0;i<stkList.size();i++){
							
							TempItemDetail st = (TempItemDetail)stkList.get(i);
							String Itmname = st.getItemName();
							System.out.println(i+" == "+Itmname);
							Long tblno = st.getTableNo();
							Long PkItemId = st.getPk_temp_id();
							System.out.println("pk id `````````````````````````````````````````    "+PkItemId);
							Double quantity1=st.getQuantity();
							
							if(Itmname.equals(itemName) && tblno.equals(Long.parseLong(tableNo))){
								
								Double qunty = 1.0;
				        		
				       		    Double updatequnty = (double) (qunty + quantity1);
				       				 
				       		    HibernateUtility hbu1 = HibernateUtility.getInstance();
				    		    Session session1 = hbu1.getHibernateSession();
				    		    Transaction transaction = session1.beginTransaction();
				    		    
				    		    TempItemDetail updateStock = (TempItemDetail) session1.get(TempItemDetail.class, new Long(PkItemId));	 
				       		
				       		    updateStock.setQuantity(updatequnty);
				       		    System.out.println("  = = =  =  in if condition where same item is clicked muliple times  - -  -  ");
				       		    session1.saveOrUpdate(updateStock);
				       		    transaction.commit();
				       		    break;
				    		    
							}
							else
							{  
				        		/*ItemName is Not Exists */
				        		if(i+1 == stkList.size()){
				        			
				        			TempItemDetail newEntry = new TempItemDetail();
				        			
				        			newEntry.setItemName(itemName);
				        			
				        			newEntry.setItemId(itemId);
				        			
				        			newEntry.setTableNo(Long.parseLong(tableNo));
				        			
				        			newEntry.setQuantity(quantity);
				        			
				        			newEntry.setUnitPrice(unitPrice);

				        	//		newEntry.setUnitInMl(unitInMl);
				        		
				        			newEntry.setUnit(unit);
				        			newEntry.setValue(value);
				        			
									/*
									 * newEntry.setCgst(0d); newEntry.setSgst(0d);
									 */
				        			newEntry.setGst(0d);
				        			newEntry.setStock(stock);
				        			System.out.println("Stock  --------- > "+newEntry.getStock());
				        			
				        			newEntry.setTotalAmt(unitPrice);
				        			System.out.println("total in TEMP TABLE (1) - -  - - - -  -"+newEntry.getTotalAmt());
				        			
				        			newEntry.setActiveYN('Y');
				        			
				        			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				        			Date dateobj = new Date();
				        			System.out.println(df.format(dateobj));
				        			
				        			newEntry.setCurrent_date(dateobj);
				        			newEntry.setUserid((userid));
				        			newEntry.setUsername(username);
				        			newEntry.setHotelid((hotelid));
				        			newEntry.setHotelname(hotelname);
				        			
				        			TempItemDetailDao dao1 = new TempItemDetailDao();
				        			dao1.regTempData(newEntry);
				        			
				        		}
				        	 }
						  }
						
						}
				}
				
			}
			
	//     ------------------------------------------------------------------==============================================================		
			else {	   
			
		saleReports = new ArrayList<GetItemDetails>(0);
		for (Object[] object : list) {
			System.out.println("Result - "+Arrays.toString(object));
			com.rms.bean.GetItemDetails reports = new com.rms.bean.GetItemDetails();
			/*reports.setQuantity(1.0);
			reports.setItemName((String)object[1]);
			reports.setItemId((BigInteger)object[2]);
			reports.setUnitinMl((Double)object[3]);
			reports.setPrrice((Double)object[4]);
			saleReports.add(reports);
*/			
			//String tableNo1 = tableNo; 
			String itemName= (String)object[0];
			BigInteger itemId1 = ((BigInteger)object[1]);
			Long itemId = itemId1.longValue();
			Double quantity= 1.0;
			Double unitPrice= (Double.parseDouble(object[4].toString()));
	//		Double unitInMl= (Double.parseDouble(object[2].toString()));
		
			String unit = ((object[2].toString()));
			Long value = (Long.parseLong(object[3].toString()));
			
			//BigInteger itemdetailsid =((BigInteger)object[4]);
			Double stock= (Double.parseDouble(object[5].toString()));
				/*
				 * if(stock == null){ stock = Double.parseDouble("NA"); }
				 */
			
			System.out.println("tableNo :- " +tableNo + ",  itemName :- " +itemName+ ",  unitInMl :- "+unit+", unit value - -  "+value+ ",  Stock :- "+stock+" while fetching DATA initially - - ");
			
			TempItemDetailDao data = new TempItemDetailDao();
			List stkList  = data.getAllItemEntry(hotelid);
			
			if(stkList.size() == 0){
				
				TempItemDetail tid = new TempItemDetail();
				
				tid.setItemName(itemName);
				
				tid.setItemId(itemId);
				
				tid.setTableNo(Long.parseLong(tableNo));
				
				tid.setQuantity(1.0);
				
				tid.setUnitPrice(unitPrice);

//				tid.setUnitInMl(unitInMl);
				
				tid.setUnit(unit);
				tid.setValue(value);
				
						/*
						 * tid.setCgst(0d); tid.setSgst(0d);
						 */
				
				tid.setGst(0d);
				tid.setStock((stock));
				System.out.println("  Stock ->  "+stock);
				//tid.setFk_item_details_id((itemdetailsid));
				
				tid.setTotalAmt(unitPrice);
				System.out.println(" total in temp table (0)  - - - - - -- "+tid.getTotalAmt());
				tid.setActiveYN('Y');
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Date dateobj = new Date();
				System.out.println(df.format(dateobj));
				
				tid.setCurrent_date(dateobj);
				
				tid.setUserid((userid));
				tid.setUsername(username);
				tid.setHotelid((hotelid));
				tid.setHotelname(hotelname);
				
				TempItemDetailDao dao = new TempItemDetailDao();
				dao.regTempData(tid);
				
			}
			else{
				for(int i=0;i<stkList.size();i++){
					
					TempItemDetail st = (TempItemDetail)stkList.get(i);
					String Itmname = st.getItemName();
					System.out.println(i+" == "+Itmname);
					Long tblno = st.getTableNo();
					Long PkItemId = st.getPk_temp_id();
					Double quantity1=st.getQuantity();
					System.out.println("pk id ``````````````````````````` `````````  ``````````` "+PkItemId+"  `````` quantity -  "+quantity1);
					if(Itmname.equals(itemName) && tblno.equals(Long.parseLong(tableNo))){
						
						Double qunty = 1.0;
		        		
		       		    Double updatequnty = (double) (qunty + quantity1);
		       				 
		       		    HibernateUtility hbu1 = HibernateUtility.getInstance();
		    		    Session session1 = hbu1.getHibernateSession();
		    		    Transaction transaction = session1.beginTransaction();
		    		    
		    		    TempItemDetail updateStock = (TempItemDetail) session1.get(TempItemDetail.class, new Long(PkItemId));	 
		       		
		       		    updateStock.setQuantity(updatequnty);
		       		    System.out.println("  = = =  =  in if condition where same item is clicked muliple times  - -  -  ");
		       		    session1.saveOrUpdate(updateStock);
		       		    transaction.commit();
		       		    break;
		    		    
					}
					else
					{
		        		/*ItemName is Not Exists */
		        		if(i+1 == stkList.size()){
		        			
		        			TempItemDetail newEntry = new TempItemDetail();
		        			
		        			newEntry.setItemName(itemName);
		        			
		        			newEntry.setItemId(itemId);
		        			
		        			newEntry.setTableNo(Long.parseLong(tableNo));
		        			
		        			newEntry.setQuantity(quantity);
		        			
		        			newEntry.setUnitPrice(unitPrice);

//		        			newEntry.setUnitInMl(unitInMl);
	
		        			newEntry.setUnit(unit);
		        			newEntry.setValue(value);
		        			
		        			/*newEntry.setCgst(0d);
		        			newEntry.setSgst(0d);*/
		        			newEntry.setGst(0d);
		        			newEntry.setStock(stock);
		        			System.out.println("Stock  --------- > "+stock);
		        			
		        			newEntry.setTotalAmt(unitPrice);
		        			System.out.println("total in TEMP TABLE (1) - -  - - - -  -"+newEntry.getTotalAmt());
		        			
		        			newEntry.setActiveYN('Y');
		        			
		        			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		        			Date dateobj = new Date();
		        			System.out.println(df.format(dateobj));
		        			
		        			newEntry.setCurrent_date(dateobj);
		        			
		        			newEntry.setUserid((userid));
		        			newEntry.setUsername(username);
		        			newEntry.setHotelid((hotelid));
		        			newEntry.setHotelname(hotelname);
		        			
		        			TempItemDetailDao dao1 = new TempItemDetailDao();
		        			dao1.regTempData(newEntry);
		        			
		        		}
		        	 }
				  }
				
				}
		}
		
			}
		//String tableNo = request.getParameter("tableNo");
		
		}catch(Exception e){	
			e.printStackTrace();
		}
		finally{
			session.flush();
			hbu.closeSession(session);	
		}
		return saleReports;

	}	
	
	
	public List gettableForEdit(Long id) {

		HibernateUtility hbu = null;
		Session session =  null;
		Query query = null;
		 List list = null;
		 
		 System.out.println("id in DAO- ID----------##### - "+id);
		 
		 try {
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 query = session.createSQLQuery("SELECT fk_table_id ,table_no from order_bill where fk_table_id ='"+id+"'");
//			 query.setParameter("pk_item_details_id", pk_item_details_id);
			 list = query.list(); 		 
			 System.out.println("Size-----------### - "+list.size());
			 
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
	
	
	//toget all hotel to edit
	public List gettablenumber(HttpServletRequest request)

{
	HttpSession sessionn = request.getSession(true);
	String fk_table_id = (String)sessionn.getAttribute("fk_table_id");
	String table_No =(String)sessionn.getAttribute("table_No");
		/*
		 * String username = (String)sessionn.getAttribute("user"); String userid =
		 * (String)sessionn.getAttribute("userid"); String hotelid =
		 * (String)sessionn.getAttribute("hotelid"); String
		 * hotelname=(String)sessionn.getAttribute("hotelname"); String usertype =
		 * (String)sessionn.getAttribute("usertype");
		 */
	
	System.out.println("session thru id- "+fk_table_id+" , table_no - "+table_No );
		/*
		 * System.out.println("usertype = -  "+usertype);
		 */	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	String ad = "admin";
	try{
	//	System.out.println("in else part");
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
			/*
			 * String item = "item"; String drink = "drink";
			 */
	 Query query = session.createSQLQuery("from kitchenorder");
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
// list
	public List gettableForList(HttpServletRequest request){
		 HttpSession sessionn = request.getSession(true);
		/*
		 * String table_no = (String).session.getAttribute("tableid"); String username =
		 * (String)sessionn.getAttribute("user"); String userid =
		 * (String)sessionn.getAttribute("userid"); String hotelid =
		 * (String)sessionn.getAttribute("hotelid"); String
		 * hotelname=(String)sessionn.getAttribute("hotelname");
		 * System.out.println("session thru table- "+table_no+" , id - "
		 * +userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		 */
		 HibernateUtility hbu=null;
			Session session=null;
			List<OrderBill> custList=null;
	
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

			Query query=session.createSQLQuery("select fk_table_id,table_no from order_bill");
			List<Object[]> list = query.list();

			custList= new ArrayList<OrderBill>(0);


		for (Object[] object : list) {	
			OrderBill ht = new OrderBill();
			ht.setFk_table_id(Long.parseLong(object[0].toString()));
			ht.setTable_No(Long.parseLong(object[1].toString()));
			
			custList.add(ht);

		}}catch(RuntimeException e){	

		}
		finally{

		hbu.closeSession(session);	
		}
		return custList;

	 }
	

	public List gettableForEdit1(Long pk_hotel_id) {

		HibernateUtility hbu = null;
		Session session =  null;
		Query query = null;
		 List list = null;
		 
		 System.out.println("id in DAO- ID----------##### - "+pk_hotel_id);
		 
		 try {
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 query = session.createSQLQuery("SELECT pk_id ,tableNo from kitchenorder where pk_id  ='"+pk_hotel_id+"'");
//			 query.setParameter("pk_item_details_id", pk_item_details_id);
			 list = query.list(); 		 
			 System.out.println("Size-----------### - "+list.size());
			 
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
	
	public List gettableEdit(HttpServletRequest request)
	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		HibernateUtility hbu = null;
		Session session =  null;
		Query query = null;
		List<kitchenorderHibernate> list = null;
		try {
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 query = session.createQuery("from kitchenorderHibernate where hotelid = '"+hotelid+"'");
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
	
	

}
