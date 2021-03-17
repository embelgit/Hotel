package com.rms.dao;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.GetItemDetails;
import com.rms.hibernate.TempItemDetail;
import com.rms.hibernate.newTempItemDetail;
import com.rms.utility.HibernateUtility;

public class TempOrderBill {


	
	public List getItemDetailsById10(String fk_item_id, String username, Long userid, Long hotelid, String hotelname) {

		HibernateUtility hbu=null;
		Session session=null;
		 List<GetItemDetails> saleReports = null; 
		 List<Object[]> list=null;
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 		//Query query = session.createSQLQuery("select  i.itemName, i.pk_item_entry_Id , i.units_InMl , i.sale_Price from itementry i    where i.pk_item_entry_Id='"+fk_item_id+"' ");
			Query query = session.createSQLQuery("select  i.itemName, i.pk_item_entry_Id , i.unit, i.quantity , i.sale_Price,s.stock from itementry i  join stock s   where i.pk_item_entry_Id='"+fk_item_id+"' and i.pk_item_entry_Id = s.fk_item_details_id AND s.hotelid = '"+hotelid+"'");
			 list = query.list();
			 
			 if(query.list().size()==0) {
				 
					Query queryy = session.createSQLQuery("select itemName, pk_item_entry_Id , unit, quantity , sale_Price from itementry where pk_item_entry_Id='"+fk_item_id+"' AND hotelid = '"+hotelid+"'");
					list = queryy.list();
					saleReports = new ArrayList<GetItemDetails>(0);
					for (Object[] object : list) {
						System.out.println("Result when item not PRESENT in stock - "+Arrays.toString(object));
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
					//	Double unitInMl= (Double.parseDouble(object[2].toString()));
						String unit = ((object[2].toString()));
						Long value = (Long.parseLong(object[3].toString()));
						
						//BigInteger itemdetailsid =((BigInteger)object[4]);
						Double total = (unitPrice * quantity);
						System.out.println("total amount is --   "+total);
						
					//	Double stock= (Double.parseDouble(object[4].toString()));
						Double stock = 0d;
						System.out.println( "  itemName :- " +itemName+ ",  unitInMl :- "+unit+", quantity - "+value+",  Stock :- "+stock);
						
						TempItemDetailDao data = new TempItemDetailDao();
						List stkList  = data.newgetAllItemEntry(hotelid);
						
						if(stkList.size() == 0){
							
						//	TempItemDetail tid = new TempItemDetail();
							newTempItemDetail tid = new newTempItemDetail();
							tid.setItemName(itemName);
							
							tid.setItemId(itemId);
							
//							tid.setTableNo(Long.parseLong(tableNo));
						//	tid.setTableNo(1l);
							tid.setQuantity(1.0);
							
							tid.setUnitPrice(unitPrice);

							//tid.setUnitInMl(unitInMl);
							tid.setUnit(unit);
							tid.setValue(value);
							tid.setGst(0d);
							
						/*
						 * tid.setCgst(0d); tid.setSgst(0d);
						 */
							
							tid.setTotalAmt(total);
							tid.setStock((stock));
							System.out.println("  Stock ->  "+tid.getStock()+" , unit "+tid.getUnit()+" value - "+tid.getValue()+"  gst set - "+tid.getGst());
							//tid.setFk_item_details_id((itemdetailsid));
							
							//tid.setTotalAmt(unitPrice);
							
							tid.setActiveYN('Y');
							
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							Date dateobj = new Date();
							System.out.println(df.format(dateobj));
							
							tid.setCurrent_date(dateobj);
							tid.setUsername(username);
							tid.setUserid((userid));
							tid.setHotelid((hotelid));
							tid.setHotelname(hotelname);
							TempItemDetailDao dao = new TempItemDetailDao();
							dao.newregTempData(tid);
							
						}
						else{
							for(int i=0;i<stkList.size();i++){
								
//								TempItemDetail st = (TempItemDetail)stkList.get(i);
								newTempItemDetail st = (newTempItemDetail)stkList.get(i);
								String Itmname = st.getItemName();
								char actv = st.getActiveYN();

					//			Long tblno = st.getTableNo();
								Long PkItemId = st.getPk_temp_id();
								Double quantity1=st.getQuantity();
								System.out.println(i+" = - - = "+Itmname+"  active status - -  -   "+actv+" pkid -  "+PkItemId+"  quantity -  "+quantity1);
								
//								if(Itmname.equals(itemName) && tblno.equals(Long.parseLong(tableNo))){
								if(Itmname.equals(itemName) && actv == 'Y'){					
									Double qunty = 1.0;

					       		    Double updatequnty = (double) (qunty + quantity1);
					        		System.out.println(" ----    @@@ in if condition where same item is clicked twice -----   ");		       				 
					       		    HibernateUtility hbu1 = HibernateUtility.getInstance();
					    		    Session session1 = hbu1.getHibernateSession();
					    		    Transaction transaction = session1.beginTransaction();
					    		    
//					    		    TempItemDetail updateStock = (TempItemDetail) session1.get(TempItemDetail.class, new Long(PkItemId));	 
					    		    newTempItemDetail updateStock = (newTempItemDetail) session1.get(newTempItemDetail.class, new Long(PkItemId));	    		    
					       		    updateStock.setQuantity(updatequnty);
					       		    System.out.println("updated stock in temp table when same item button pressed multiple times !  pktemp iD - "+PkItemId);   
					       		    session1.saveOrUpdate(updateStock);
					       		
					       		    transaction.commit();
					       		    break;
					    		    
								} 
								else
								{        
					        		/*ItemName is Not Exists */
					        		if(i+1 == stkList.size()){
					        			
					     //   			TempItemDetail newEntry = new TempItemDetail();
					        			newTempItemDetail newEntry = new newTempItemDetail(); 			
					        			newEntry.setItemName(itemName);
					        			
					        			newEntry.setItemId(itemId);
					        			
					//        			newEntry.setTableNo(Long.parseLong(tableNo));
					        	//		newEntry.setTableNo(1l);
					        			newEntry.setQuantity(quantity);
					        			
					        			newEntry.setUnitPrice(unitPrice);

					        	//		newEntry.setUnitInMl(unitInMl);
					        			
					        			newEntry.setUnit(unit);
					        			newEntry.setValue(value);
					        			
					        			newEntry.setGst(0d);
					        			
					        			
					        			newEntry.setStock(stock);
					        			System.out.println("Stock  --------- > "+newEntry.getStock()+" gst set- "+newEntry.getGst());
					        			newEntry.setTotalAmt(total);
					        			//newEntry.setTotalAmt(unitPrice);
					        			
					        			newEntry.setActiveYN('Y');
					        			
					        			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					        			Date dateobj = new Date();
					        			System.out.println(df.format(dateobj));
					        			
					        			newEntry.setCurrent_date(dateobj);
					        			newEntry.setUsername(username);
					        			newEntry.setUserid((userid));
					        			newEntry.setHotelid((hotelid));
					        			newEntry.setHotelname(hotelname);
					        			TempItemDetailDao dao1 = new TempItemDetailDao();
					        			dao1.newregTempData(newEntry);
					        			
					        		}
					        	 }
							  }
							
							}
					}
				 
			 }
			 
			 else {
			 //  if item exist in stock
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
		//	Double unitInMl= (Double.parseDouble(object[2].toString()));
			//BigInteger itemdetailsid =((BigInteger)object[4]);
			
			String unit = ((object[2].toString()));
			Long value = (Long.parseLong(object[3].toString()));
			
			Double total = (unitPrice * quantity);
			System.out.println("total amount is --   "+total);
			Double stock= (Double.parseDouble(object[5].toString()));
			System.out.println( "  itemName :- " +itemName+ ",  unit :- "+unit+ ",  Stock :- "+stock);
			
			TempItemDetailDao data = new TempItemDetailDao();
			List stkList  = data.newgetAllItemEntry(hotelid);
			
			if(stkList.size() == 0){
				
			//	TempItemDetail tid = new TempItemDetail();
				newTempItemDetail tid = new newTempItemDetail();
				tid.setItemName(itemName);
				
				tid.setItemId(itemId);
				
//				tid.setTableNo(Long.parseLong(tableNo));
			//	tid.setTableNo(1l);
				tid.setQuantity(1.0);
				
				tid.setUnitPrice(unitPrice);

			//	tid.setUnitInMl(unitInMl);
				tid.setUnit(unit);
				tid.setValue(value);
				
				tid.setTotalAmt(total);
				tid.setStock((stock));
				
				tid.setGst(0d);
				
				System.out.println("  Stock ->  "+stock+" gst get -"+tid.getGst());
				//tid.setFk_item_details_id((itemdetailsid));
				
				//tid.setTotalAmt(unitPrice);
				
				tid.setActiveYN('Y');
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Date dateobj = new Date();
				System.out.println(df.format(dateobj));
				
				tid.setCurrent_date(dateobj);
				tid.setUsername(username);
    			tid.setUserid((userid));
    			tid.setHotelid((hotelid));
    			tid.setHotelname(hotelname);
				TempItemDetailDao dao = new TempItemDetailDao();
				dao.newregTempData(tid);
				
			}
			else{
				for(int i=0;i<stkList.size();i++){
					
//					TempItemDetail st = (TempItemDetail)stkList.get(i);
					newTempItemDetail st = (newTempItemDetail)stkList.get(i);
					String Itmname = st.getItemName();
					char act = st.getActiveYN();

		//			Long tblno = st.getTableNo();
					Long PkItemId = st.getPk_temp_id();
					Double quantity1=st.getQuantity();
					System.out.println(i+" = - - = "+Itmname);		
					System.out.println(i+" = - - = "+Itmname+"  active status - -  -   "+act+" pkid -  "+PkItemId+"  quantity -  "+quantity1);
//					if(Itmname.equals(itemName) && tblno.equals(Long.parseLong(tableNo))){
					if(Itmname.equals(itemName) && act == 'Y'){					
						Double qunty = 1.0;

		       		    Double updatequnty = (double) (qunty + quantity1);
		        		System.out.println(" ----    @@@ in if condition where same item is clicked twice -----   ");		       				 
		       		    HibernateUtility hbu1 = HibernateUtility.getInstance();
		    		    Session session1 = hbu1.getHibernateSession();
		    		    Transaction transaction = session1.beginTransaction();
		    		    
	//	    		    TempItemDetail updateStock = (TempItemDetail) session1.get(TempItemDetail.class, new Long(PkItemId));	 
		    		    newTempItemDetail updateStock = (newTempItemDetail) session1.get(newTempItemDetail.class, new Long(PkItemId));	    		    
		       		    updateStock.setQuantity(updatequnty);
		       		  System.out.println("updated stock in temp table when same item button pressed multiple times !  pktemp iD - "+PkItemId);   
		       		    session1.saveOrUpdate(updateStock);
		       		
		       		    transaction.commit();
		       		    break;
		    		    
					} 
					else
					{       
		        		/*ItemName is Not Exists */
		        		if(i+1 == stkList.size()){
		        			
		     //   			TempItemDetail newEntry = new TempItemDetail();
		        			newTempItemDetail newEntry = new newTempItemDetail(); 			
		        			newEntry.setItemName(itemName);
		        			
		        			newEntry.setItemId(itemId);
		        			
		//        			newEntry.setTableNo(Long.parseLong(tableNo));
		        	//		newEntry.setTableNo(1l);
		        			newEntry.setQuantity(quantity);
		        			
		        			newEntry.setUnitPrice(unitPrice);

		        		//	newEntry.setUnitInMl(unitInMl);
		        			
		        			newEntry.setUnit(unit);
		        			newEntry.setValue(value);
		        			
		        			newEntry.setGst(0d);
		        			
		        			newEntry.setStock(stock);
		        			System.out.println("Stock  --------- > "+stock+" gst get - "+newEntry.getGst());
		        			newEntry.setTotalAmt(total);
		        			//newEntry.setTotalAmt(unitPrice);
		        			
		        			newEntry.setActiveYN('Y');
		        			
		        			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		        			Date dateobj = new Date();
		        			System.out.println(df.format(dateobj));
		        			
		        			newEntry.setCurrent_date(dateobj);
		        			newEntry.setUsername(username);
		        			newEntry.setUserid((userid));
		        			newEntry.setHotelid((hotelid));
		        			newEntry.setHotelname(hotelname);
		        			TempItemDetailDao dao1 = new TempItemDetailDao();
		        			dao1.newregTempData(newEntry);
		        			
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
	
	
	
	
	}	

