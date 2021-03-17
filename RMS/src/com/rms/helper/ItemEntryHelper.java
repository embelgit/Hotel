package com.rms.helper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.dao.ItemEntryDao;
import com.rms.dao.SupplierDetailsDao;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.SupplierDetailsHibernate;
import com.rms.utility.HibernateUtility;

public class ItemEntryHelper {

	public void entryItem (HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("user");		
		String userid = (String)session.getAttribute("userid");
		String hotelid = (String)session.getAttribute("hotelid");
		String hotelname=(String)session.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
	/*	pdb.setUserId(Long.parseLong(userid));
		pdb.setUsername(username);
		pdb.setShopId(Long.parseLong(shopid));
		pdb.setShopName(shopname);
		*/
		
		String itemName= request.getParameter("itemName");
		String type= request.getParameter("type");
		String salePrice= request.getParameter("sale_price1");
		String buyPrice= request.getParameter("buy_price_drink");
//		String unitsInMl= request.getParameter("unit_in_ml");
//		String stock = request.getParameter("stock");
		System.out.println("ItemName ::- "+ itemName);
		System.out.println("Type ::- "+type);
//		String kilogram = request.getParameter("kilogram");
//		String gram = request.getParameter("gram");
	
		String unit = request.getParameter("unit");
		String value = request.getParameter("value");
		System.out.println("unit & quantity is - - - "+unit+" & "+value);
		
		ItemEntry ie = new ItemEntry();
		ie.setItemName(itemName);
		
		if(!"".equals(type)) {
		ie.setType(type);
		}
		else {
			ie.setType("NA");
		}
		ie.setSalePrice(Long.parseLong(salePrice));
	//	ie.setBuyPrice(Long.parseLong(buyPrice));
		
		if(!"".equals(buyPrice))
		{
			ie.setBuyPrice(Long.parseLong(buyPrice));
		}
		else
		{
			ie.setBuyPrice(0l);
		}
		
		if(!"".equals(unit)) {
			ie.setUnit(unit);
		}
		else {
			ie.setUnit("unit");
		}		
		
		if(!"".equals(value)) {
			ie.setValue(Long.parseLong(value));
		}
		else {
			ie.setValue(0l);
		}
		
		System.out.println("unit -  "+ie.getUnit()+"  quantity sett  -   "+ie.getValue());
		ie.setUsername(username);
		ie.setUserid(Long.parseLong(userid));
		ie.setHotelid(Long.parseLong(hotelid));
		ie.setHotelname(hotelname);
		
		ItemEntryDao ied = new ItemEntryDao();
		ied.itemEntry(ie);
				
		
	}
	public List getAllItemEntries()
	{
		ItemEntryDao dao = new ItemEntryDao();
		return dao.getAllItemEntries();
	}
	
	/*public List getItemName()
	{
		ItemEntryDao dao = new ItemEntryDao();
		List list = dao.getItemName();
		return list;
	}*/
	
	//get item entry detail to edit
		public Map getItemEntryDetailsForEdit(Long pk_item_entry_Id) {

		 	System.out.println("into helper class");
		 	ItemEntryDao dao1 = new ItemEntryDao();
			List catList = dao1.getAllItemEntryDetailsForEdit(pk_item_entry_Id);
			
			Map  map =  new HashMap();
			for(int i=0;i<catList.size();i++)
			{
				Object[] o = (Object[])catList.get(i);
			
				ItemEntry b = new ItemEntry();
				b.setPk_item_entry_Id(Long.parseLong(o[0].toString()));
				b.setItemName(o[1].toString());
				b.setType(o[2].toString());
				map.put(b.getPk_item_entry_Id(),b);
			}
			System.out.println("out of helper return map : "+map);
			return map;
		
		}

	//update item entry info
		public void updateItemEntryInfoDetail(HttpServletRequest request,
				HttpServletResponse response) {

			String itemId = request.getParameter("itemId");
			
			/*String itemName = request.getParameter("itemName");*/
			String type = request.getParameter("type");
			
			com.rms.utility.HibernateUtility hbu=null;
			Session session = null;
			Transaction transaction = null;
			
			 hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			 transaction = session.beginTransaction();
		
			long itemEntryInfoId =Long.parseLong(itemId);
			
			ItemEntry det = (ItemEntry) session.load(ItemEntry.class, itemEntryInfoId);
			
			det.setType(type);

		    session.saveOrUpdate(det);
			transaction.commit();
			
		}
		
		
		//delete item list info
		public void deleteIteEntryList(HttpServletRequest request,
				HttpServletResponse response) {
				System.out.println("In Helper");
				String delSportId = request.getParameter("delSportId");
				ItemEntryDao dao2 = new ItemEntryDao();
				dao2.deletItemListDetails(delSportId);
					
				}
		}
	
			

