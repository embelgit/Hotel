package com.rms.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.rms.dao.TempOrderBill;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rms.bean.GetItemDetails;
import com.rms.dao.OrderBillDao;

public class tempOrderBill {

	
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
	//	String tableNo = request.getParameter("tableNo");
	//	System.out.println("table no (helper) is ---  "+tableNo); 
		System.out.println("fk item id--  "+fk_item_id);
	       System.out.println(fk_item_id +" --- vxvdfvdf");
			
	         Map<Long,GetItemDetails> map = new HashMap<Long,GetItemDetails>();
	 		
	         TempOrderBill dao = new TempOrderBill ();
	 		List<GetItemDetails> saleList = dao.getItemDetailsById10(fk_item_id,username,userid,hotelid,hotelname);
	 		
	 		
	 		return saleList;
		
		
	
	}
	
	
}
