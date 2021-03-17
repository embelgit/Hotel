package com.rms.helper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rms.bean.GetItemDetails;
import com.rms.dao.OrderBillDao;
import com.rms.hibernate.OrderBill;

public class OrderBillHelper {
	
	public void billOrder (HttpServletRequest request, HttpServletResponse response){
	
	String fk_waiter_name_id = request.getParameter("fk_waiter_name_id");
	String table_No = request.getParameter("table_No");
	String quantity = request.getParameter("quantity");
	String total_amount = request.getParameter("total_amount");
	String fk_table_id = request.getParameter("fk_table_id");
	String fk_item_id = request.getParameter("fk_item_id");
	String fk_user_id = request.getParameter("fk_user_id");
	
	OrderBill order = new OrderBill();
	
	order.setFk_waiter_name_id(Long.parseLong(fk_waiter_name_id));
	order.setTable_No(Long.parseLong(table_No));
	order.setQuantity(Long.parseLong(quantity));
	order.setTotal_amount(Long.parseLong(total_amount));
	order.setFk_table_id(Long.parseLong(fk_table_id));
	order.setFk_item_id(Long.parseLong(fk_item_id));
	order.setFk_user_id(Long.parseLong(fk_user_id));
	
	OrderBillDao obd = new OrderBillDao();
	obd.orderBill (order);
	
	}
	
	public Map getSubCategoriesByRootcategory(String catID)
	{
		System.out.println(catID+"CAT ID FROM HELPER");
		//String catId = request.getParameter("catId");
		
		//Map<Long,SubCategory> map = new HashMap<Long,SubCategory>();
		
		//AddItemDao dao = new AddItemDao();
	//	List catList = dao.getSubCategoriesByRootcategory(catID);
		//System.out.println(catList.size()+"LIST SIZE");
		Map  map1 =  new HashMap();
		//for(int i=0;i<catList.size();i++)
		{
			//Object[] o = (Object[])catList.get(i);
			//GetSubcategory bean = new GetSubcategory();
			//bean.setSubcat_id((Long)o[0]);
		//	bean.setSubcat_name((String)o[1]);
			
			//System.out.println("***************"+o[0]+"\t"+o[1]);
		//	map1.put(bean.getSubcat_id(),bean);
		}
		return map1;
	}

	public List getItemDetailsById(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String user = (String)sessionn.getAttribute("userid");
		String hotel = (String)sessionn.getAttribute("hotelid");
		Long hotelid = Long.parseLong(hotel);
		Long userid = Long.parseLong(user);
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		
		String fk_item_id= request.getParameter("fk_item_id");
		String tableNo = request.getParameter("tableNo");
		System.out.println("table no (helper) is ---  "+tableNo); 
		System.out.println("fk item id-- "+fk_item_id);
	       System.out.println(fk_item_id +" --- vxvdfvdf");
			
	         Map<Long,GetItemDetails> map = new HashMap<Long,GetItemDetails>();
	 		
	         OrderBillDao dao = new OrderBillDao ();
	 		List<GetItemDetails> saleList = dao.getItemDetailsById(fk_item_id, tableNo, hotelid, userid,username,hotelname);
	 		
	 		
	 		return saleList;
		
		
	
	}	
	
}