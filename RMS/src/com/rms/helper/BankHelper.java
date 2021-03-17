package com.rms.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rms.dao.BankDao;
import com.rms.dao.ExpenditureDao;
import com.rms.hibernate.bankdetailHibernate;
import com.rms.hibernate.banktransaction;
import com.rms.hibernate.expenditurepaymentHibernate;

public class BankHelper {

	
	public List getbanksnameWiseReport1(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String fkbankname = request.getParameter("fkbankname");
		String bankid = request.getParameter("bankid");
		System.out.println("fkbankname - "+fkbankname+" , bankid- "+bankid);
	        Map<Long,banktransaction> map = new HashMap<Long,banktransaction>();
			
	        BankDao dao = new BankDao();
			List<banktransaction> exp1List = dao.getbanknameWiseReport(hotelid,usertype,fkbankname);
			
			return exp1List;
	}
	
	//range wise
	public List getbankRangeWiseReport1(HttpServletRequest request,	HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String rangefrom = request.getParameter("rangefrom");
		String rangetoo = request.getParameter("rangetoo");
		
		System.out.println("rangefrom - "+rangefrom+" , rangetoo- "+rangetoo);
	        Map<Long,banktransaction> map = new HashMap<Long,banktransaction>();
			
	        BankDao dao = new BankDao();
			List<banktransaction> exp1List = dao.getbankRangeWiseReport(hotelid,usertype,rangefrom,rangetoo);
			
			return exp1List;
	}
}
