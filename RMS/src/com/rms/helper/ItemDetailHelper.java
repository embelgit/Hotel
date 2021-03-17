package com.rms.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.GetItemDetailsDrinkWiseBean;
import com.rms.bean.GetItemDetailsItemNameWiseBean;
import com.rms.dao.ItemDetailsDao;
import com.rms.hibernate.ItemDetails;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.Stock;
import com.rms.utility.HibernateUtility;

public class ItemDetailHelper {
	
	public void detailItem(HttpServletRequest request, HttpServletResponse response){
		String fk_item_id = request.getParameter("fk_item_id");
		String sale_price= request.getParameter("sale_price");
		String buy_price= request.getParameter("buy_price");
		String type = request.getParameter("type");
		String unit_in_ml=request.getParameter("unit_in_ml");
		System.out.println("rhn"+unit_in_ml);
		
		ItemEntry ie = new ItemEntry();
		
		//ItemDetails id = new ItemDetails();
		
	/*	System.out.println("hguidfghuds"+fk_item_id);
		String isDrink= request.getParameter("isDrink");
		System.out.println("avi"+isDrink);
		if(isDrink.equals("True")){
			id.setUnit_in_ml(Double.parseDouble(unit_in_ml));		
		}
		else if(isDrink.equals("False")){
			id.setUnit_in_ml((0d));
		}*/
		/*
		if(unit_in_ml.equals("0.0")){
			id.setUnit_in_ml(0.0);
		}
		else{
			id.setUnit_in_ml(Double.parseDouble(unit_in_ml));
		}*/
		
		
		ie.setPk_item_entry_Id(Long.parseLong(fk_item_id));
		ie.setSalePrice(Long.parseLong(sale_price));
		ie.setType(type);
		ie.setBuyPrice(Long.parseLong(buy_price));
		
	/*	
		id.setFk_item_id(Long.parseLong(fk_item_id));
		id.setSale_price(Double.parseDouble(sale_price));
		id.setBuy_price(Double.parseDouble(buy_price));
		id.setUnit_in_ml(Double.parseDouble(unit_in_ml));
	*/
	
		ItemDetailsDao idd = new ItemDetailsDao();
		
		//idd.ItemDetail(ie);
	}

	//get item detail to edit
			public Map getItemDetailsForEdit(Long pk_item_details_id) {

			 	System.out.println("into helper class");
			 	ItemDetailsDao dao1 = new ItemDetailsDao();
				List catList = dao1.getAllItemDetailsForEdit(pk_item_details_id);
				
				Map  map =  new HashMap();
				for(int i=0;i<catList.size();i++)
				{
					Object[] o = (Object[])catList.get(i);
				
					ItemEntry b = new ItemEntry();
					b.setPk_item_entry_Id(Long.parseLong(o[0].toString()));
					b.setItemName(o[1].toString());
					b.setSalePrice(Long.parseLong(o[2].toString()));
					b.setBuyPrice(Long.parseLong(o[3].toString()));
					b.setType((o[4].toString()));
					b.setUnit((o[5].toString()));
					b.setValue(Long.parseLong(o[6].toString()));
					System.out.println("TYPE is ------ "+b.getType()+", unit  -  "+b.getUnit()+" ,,  value -  "+b.getValue());
					map.put(b.getPk_item_entry_Id(),b);
				}
				System.out.println("out of helper return map : "+map.size());
				return map;
			
			}

		//update item details info
			public void updateItemInfoDetail(HttpServletRequest request,
					HttpServletResponse response) {

				String itemId = request.getParameter("itemId");
				
				String sale_price= request.getParameter("sale_price");
				String buy_price= request.getParameter("buy_price");
				
				com.rms.utility.HibernateUtility hbu=null;
				Session session = null;
				Transaction transaction = null;
				
				 hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				 transaction = session.beginTransaction();
			
				long itemDetailsInfoId =Long.parseLong(itemId);
				
				ItemDetails det = (ItemDetails) session.load(ItemDetails.class, itemDetailsInfoId);
				
				det.setSale_price(Double.parseDouble(sale_price));
				det.setBuy_price(Double.parseDouble(buy_price));

			    session.saveOrUpdate(det);
				transaction.commit();
				
			}
			
			//get drink detail to edit
			public Map getDrinkDetailsForEdit(Long pk_item_details_id) {

			 	System.out.println("into helper class");
			 	ItemDetailsDao dao1 = new ItemDetailsDao();
				List catList = dao1.getAllDrinkDetailsForEdit(pk_item_details_id);
				
				Map  map =  new HashMap();
				for(int i=0;i<catList.size();i++)
				{
					Object[] o = (Object[])catList.get(i);
				
					ItemDetails b = new ItemDetails();
					b.setPk_item_details_id(Long.parseLong(o[0].toString()));
					b.setBuy_price(Double.parseDouble(o[2].toString()));
					b.setSale_price(Double.parseDouble(o[1].toString()));
					b.setUnit_in_ml(Double.parseDouble(o[3].toString()));
					map.put(b.getPk_item_details_id(),b);
				}
				System.out.println("out of helper return map : "+map);
				return map;
			
			}

		//update drink details info
			public void updateDrinkInfoDetail(HttpServletRequest request,
					HttpServletResponse response) {

				String itemId = request.getParameter("itemId");
				
				String sale_price= request.getParameter("sale_price");
				String buy_price= request.getParameter("buy_price");
				String unit_in_ml= request.getParameter("unit_in_ml");
				
				com.rms.utility.HibernateUtility hbu=null;
				Session session = null;
				Transaction transaction = null;
				
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 transaction = session.beginTransaction();
			
				long drinkDetailsInfoId =Long.parseLong(itemId);
				
				ItemDetails det = (ItemDetails) session.load(ItemDetails.class, drinkDetailsInfoId);
				
				det.setSale_price(Double.parseDouble(sale_price));
				det.setBuy_price(Double.parseDouble(buy_price));
				det.setUnit_in_ml(Double.parseDouble(unit_in_ml));

			    session.saveOrUpdate(det);
				transaction.commit();
				
			}
		
				// get item details report item name wise
				public List getItemNamewiseReport(HttpServletRequest request,
						HttpServletResponse response) {

					    String fk_item_id = request.getParameter("fk_item_id");
				        Map<Long,Stock> map = new HashMap<Long,Stock>();
						
				        ItemDetailsDao dao = new ItemDetailsDao();
						List<Stock> exp1List = dao.getItemNamewiseReport(request);
						
						return exp1List;
				}
				
				
				
				
				// get get item details report drink wise
				public List getDrinkwiseReport(HttpServletRequest request,
						HttpServletResponse response) {

					    String fk_item_id = request.getParameter("fk_item_id");
				        Map<Long,GetItemDetailsDrinkWiseBean> map = new HashMap<Long,GetItemDetailsDrinkWiseBean>();
						
				        ItemDetailsDao dao = new ItemDetailsDao();
						List<GetItemDetailsDrinkWiseBean> exp1List = dao.getDrinkwiseReport(fk_item_id);
						
						return exp1List;
				}
				
				
				
				
				
				public void editItemEntry(HttpServletRequest request, HttpServletResponse response) {
					
					HttpSession session = request.getSession(true);
					String username = (String)session.getAttribute("user");		
					String userid = (String)session.getAttribute("userid");
					String hotelid = (String)session.getAttribute("hotelid");
					String hotelname=(String)session.getAttribute("hotelname");
					System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);					
					
					String itemName = request.getParameter("itemName");
					System.out.println("item name in helper -- "+itemName);
					String itemId = request.getParameter("itemId");

					String type = request.getParameter("type");

					String salePrice = request.getParameter("salePrice");
					String buyPrice = request.getParameter("buyPrice");
				//	String unit_in_ml =request.getParameter("unit_in_ml");
					
					String unit = request.getParameter("unit");
					String value = request.getParameter("value");
					System.out.println("unit in ml is == - "+unit+"  ,, value  "+value);
					
					
					System.out.println("in edit HELper --- ");
					System.out.println("Type :  ----- "+type);
					
					HibernateUtility hbu = null;
					Session sessionn = null;
					Transaction transaction = null;

					hbu = HibernateUtility.getInstance();
					sessionn = hbu.getHibernateSession();
					transaction = sessionn.beginTransaction();

					System.out.println("%%%%%%%%%%%%%%%%% Product id :" + itemId);
					long itemId1 = Long.parseLong(itemId);
					ItemEntry iet = (ItemEntry) sessionn.get(ItemEntry.class, itemId1);

					if(!"".equals(itemName)) {
						iet.setItemName(itemName);
					}
					else
					{
						iet.setItemName("N/A");
					}
					
					if(!"".equals(type)){
						iet.setType(type);
					}else{
						iet.setType("N/A");
					}
					
					if(!"".equals(salePrice)){
						iet.setSalePrice(Long.parseLong(salePrice));
					}else{
						iet.setSalePrice(Long.parseLong("0"));
					}
					
					if(!"".equals(buyPrice)){
						iet.setBuyPrice(Long.parseLong(buyPrice));
					}else{
						iet.setBuyPrice(Long.parseLong("0"));
					}
/*					if(!"".equals(unit_in_ml)){
						iet.setUnitsInMl(Long.parseLong((unit_in_ml)));
					}else{
						iet.setUnitsInMl(Long.parseLong("0"));
					} */
					
					if(!"".equals(unit)){
						iet.setUnit((unit));
					} else{
						iet.setUnit("N/A");
					}
					if(!"".equals(value)){
						iet.setValue(Long.parseLong(value));
					}else{
						iet.setValue(Long.parseLong("0"));
					}
					iet.setUsername(username);
					iet.setUserid(Long.parseLong(userid));
					iet.setHotelid(Long.parseLong(hotelid));
					iet.setHotelname(hotelname);
					
					sessionn.saveOrUpdate(iet);
					transaction.commit();
					sessionn.close();
					System.out.println("Record updated successfully.");
					
					
				}
				
}