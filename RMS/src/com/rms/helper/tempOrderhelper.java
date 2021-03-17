package com.rms.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rms.bean.GetItemDetails;
import com.rms.dao.TempItemDetailDao;
import com.rms.dao.tempOrderbillDao;

public class tempOrderhelper {

	
	public List getItemDetailByTable10(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		String tableNo= request.getParameter("tableNo");
		System.out.println("table no is (getItemdetailsbyTable) in helper -- "+tableNo);
		//	 System.out.println("hi vikas first record in table");
	    //   System.out.println(tableNo);
			
	         Map<Long,GetItemDetails> map = new HashMap<Long,GetItemDetails>();
	 		
	        // TempItemDetailDao dao = new TempItemDetailDao ();
	 		tempOrderbillDao dao = new tempOrderbillDao();
	         List<GetItemDetails> saleList = dao.getItemDetailsByTable10(tableNo, hotelid);
	 		
	 		return saleList;
		
	}
}
