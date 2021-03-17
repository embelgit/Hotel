package com.rms.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.dao.ItemDetailsDao;
import com.rms.dao.hotelnamedao;
import com.rms.dao.hotelnamedao;
import com.rms.hibernate.CashBook;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.accesscontrolbean;
import com.rms.hibernate.UserDetailsBean;
import com.rms.hibernate.hotelnamebean;
import com.rms.utility.HibernateUtility;

public class hotelnamehelper {
	
	Long hid;
public void addhotel (HttpServletRequest request, HttpServletResponse response){
		
		String hotelname= request.getParameter("hotelname");
		System.out.println("hotelname - "+hotelname);
		hotelnamedao daoo = new hotelnamedao();
		List list = daoo.gethotelID();

		hotelnamebean bn = new hotelnamebean();

		bn.setHotelname(hotelname);
		
		for(int i=0;i<list.size();i++){
			
			hotelnamebean st = (hotelnamebean)list.get(i);
			hid = st.getHotelid();
			
			System.out.println("ht ID in helper - -   "+hid);
			hid++;
		}
		if(hid == null) {
			bn.setHotelid(1l);
		} else {
			bn.setHotelid(hid);
		System.out.println("trans set set in helper - > "+bn.getHotelid());
		}
		
		hotelnamedao dao = new hotelnamedao();
		dao.addhotel(bn);
}
//hotel
public Map gethotelForEdit(Long pk_hotel_id) {

 	System.out.println("into helper class");
 	hotelnamedao dao1 = new hotelnamedao();
	List catList = dao1.gethotelForEdit(pk_hotel_id);
	
	Map  map =  new HashMap();
	for(int i=0;i<catList.size();i++)
	{
		Object[] o = (Object[])catList.get(i);
		System.out.println("result - "+Arrays.toString(o));
		hotelnamebean b = new hotelnamebean();
		b.setPk_id(Long.parseLong(o[0].toString()));
		b.setHotelid(Long.parseLong(o[1].toString()));
		b.setHotelname(o[2].toString());
//		System.out.println("TYPE is ------ "+b.getType()+", unit  -  "+b.getUnit()+" ,,  value -  "+b.getValue());
		map.put(b.getPk_id(),b);
	}
	System.out.println("out of helper return map : "+map.size());
	return map;

}

 public Map getuserDetails(Long user_id) 
 {

 	System.out.println("into helper class");
 	hotelnamedao dao1 = new hotelnamedao();
	List catList = dao1.getuserDetails(user_id);
	
	Map  map =  new HashMap();
	for(int i=0;i<catList.size();i++)
	{
		Object[] o = (Object[])catList.get(i);
		System.out.println("result - "+Arrays.toString(o));
		UserDetailsBean b = new UserDetailsBean();
		b.setUsrId(Long.parseLong(o[0].toString()));
		b.setUserName(o[1].toString());
		b.setPassword(o[2].toString());
		System.out.println("usrid is ------ "+b.getUsrId()+", usrname  -  "+b.getUserName()+" ,,  pass -  "+b.getPassword());
		map.put(b.getUsrId(),b);
	}
	System.out.println("out of helper return map : "+map.size()+" map  "+map.toString());
	return map;

}
 // addaccess
 public void addaccess(HttpServletRequest request,
			HttpServletResponse response) {
		
		String user = request.getParameter("user");	
		String userid = request.getParameter("user_id");
		String pass = request.getParameter("pass");
		String usertype = request.getParameter("usertype");
		String hotelid = request.getParameter("hotelid");
		String hotelname = request.getParameter("hotelname");
		
		accesscontrolbean sd = new accesscontrolbean();
		sd.setUsername(user);
		sd.setPass(pass);
		sd.setUserid(Long.parseLong(userid));
		sd.setUsertype(usertype);
		sd.setHotelid(Long.parseLong(hotelid));
		sd.setHotelname(hotelname);
		System.out.println("ip got - "+sd.getUsername()+sd.getPass()+sd.getUsertype()+sd.getHotelname()+sd.getHotelid()+sd.getUserid());
		hotelnamedao dao = new hotelnamedao();
		dao.addaccess(sd);


	}
 
 public Map gethotel(String uname) {

		int count = 1;
		System.out.println("IN HELPER - "+uname);

		hotelnamedao cdd = new hotelnamedao();
		List list = cdd.gethotel(uname);

		System.out.println("listsize helper  " + list.size());
		Map map = new HashMap();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("IN HELPER");
			Object[] o = (Object[]) list.get(i);
			accesscontrolbean bean = new accesscontrolbean();
			System.out.println("result - "+Arrays.toString(o));
			bean.setPkid(Long.parseLong(o[0].toString()));
			bean.setHotelid(Long.parseLong(o[1].toString()));
			bean.setHotelname(o[2].toString());
			bean.setUserid(Long.parseLong(o[3].toString()));
			bean.setUsertype(o[4].toString());
	//		System.out.println("pk " + o[0]);
			map.put(count, bean);
			count++;
		}
		return map;

	}
 //
 public void edithotel(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("user");		
		String userid = (String)session.getAttribute("userid");
		String hotelid = (String)session.getAttribute("hotelid");
		String hotelname=(String)session.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);					
		
		String hname = request.getParameter("h_name");
		System.out.println("item name in helper -- "+hname);
		String hid = request.getParameter("h_id");		
		HibernateUtility hbu = null;
		Session sessionn = null;
		Transaction transaction = null;

		hbu = HibernateUtility.getInstance();
		sessionn = hbu.getHibernateSession();
		transaction = sessionn.beginTransaction();

		System.out.println("%%%%%%%%%%%%%%%%% h id :" + hid);
		long h_id = Long.parseLong(hid);
		hotelnamebean iet = (hotelnamebean) sessionn.get(hotelnamebean.class, h_id);

		if(!"".equals(hname)) {
			iet.setHotelname(hname);
		}
		else {
			iet.setHotelname("NA");
		}
/*		iet.setUsername(username);
		iet.setUserid(Long.parseLong(userid));
		iet.setHotelid(Long.parseLong(hotelid));
		iet.setHotelname(hotelname);
	*/	
		sessionn.saveOrUpdate(iet);
		transaction.commit();
		sessionn.close();
		System.out.println("Record updated successfully.");
		
		
	}
 
}
