package com.rms.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rms.dao.CashBookDao;
import com.rms.dao.ExpenditureDao;
import com.rms.dao.TodaySaleDao;
import com.rms.hibernate.TodaySaleHibernate;
import com.rms.hibernate.expenditurepaymentHibernate;

public class TodaySaleHelper {

	
	public void addtodaytotalsale(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname = (String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String saleamount = request.getParameter("saleamount"); 
		String currentcash = request.getParameter("currentcash");
		String cardpayment = request.getParameter("cardpayment");
		String googlepaypayment = request.getParameter("googlepaypayment");
		

		String phonpepayment = request.getParameter("phonpepayment");
		String paytmpayment = request.getParameter("paytmpayment");
		String otherpayment = request.getParameter("otherpayment");
		
		System.out.println("addtodaytotalsale() ");
	/*	String neftAccNoId = request.getParameter("neftAccNoId");
		String paymentById = request.getParameter("paymentById");*/		
		System.out.println("in HELPER googlepay payment "+googlepaypayment+" ");
		System.out.println("in HELPER PAID AMOUNT IS: ");
		System.out.println("remaining Amount is - ");
		
		TodaySaleHibernate cb = new TodaySaleHibernate();	
		
/*		CashBookDao data = new CashBookDao();
		List stkList  = data.gettransIDforexppayment(request);
		Long transidd;
		for(int i=0;i<stkList.size();i++){
			
			expenditurepaymentHibernate st = (expenditurepaymentHibernate)stkList.get(i);
			transid = st.getTransID();
			
			System.out.println("tranID in helper - -   "+transid);
			transid++;
		}
		if(transid == null) {
			cb.setTransID(1l);
		} else {
		cb.setTransID(transid);
		System.out.println("trans set set in helper - > "+cb.getTransID());
		}
*/
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String todayDate = simpleDateFormat.format(new Date());
		System.out.println("in helper today date - "+todayDate);
		
		if (!"".equals(saleamount))
		{
			cb.setSaleamount(Double.parseDouble((saleamount)));
		}
		else 
		{
			cb.setSaleamount(0d);
		}
		if (!"".equals(currentcash))
		{
			cb.setCurrentcash(Double.parseDouble((currentcash)));
		}
		else 
		{
			cb.setCurrentcash(0d);
		}
		if (!"".equals(cardpayment))
		{
			cb.setCardpayment(Double.parseDouble((cardpayment)));
		}
		else 
		{
			cb.setCardpayment(0d);
		}
		
		if (!"".equals(googlepaypayment))
		{
			cb.setGooglepaypayment(Double.parseDouble((googlepaypayment)));
		}
		else 
		{
			cb.setGooglepaypayment(0d);
		}
		if (!"".equals(phonpepayment))
		{
			cb.setPhonpepayment(Double.parseDouble((phonpepayment)));
		}
		else 
		{
			cb.setPhonpepayment(0d);
		}

		if (!"".equals(paytmpayment))
		{
			cb.setPaytmpayment(Double.parseDouble((paytmpayment)));
		}
		else 
		{
			cb.setPaytmpayment(0d);
		}

		if (!"".equals(otherpayment))
		{
			cb.setOtherpayment(Double.parseDouble((otherpayment)));
		}
		else 
		{
			cb.setOtherpayment(0d);
		}
		cb.setUsername(username);
		cb.setUserid(Long.parseLong(userid));
		cb.setHotelid(Long.parseLong(hotelid));
		cb.setHotelname(hotelname);
		
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateobj = new Date();
		 System.out.println("df.format(dateobj) -   "+df.format(dateobj));
		 String datee = df.format(dateobj);
		 System.out.println("datee -   "+datee);

//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 
		cb.setTodaysdate(dateobj);
			System.out.println("today date set - "+cb.getTodaysdate());
		
		

		
		TodaySaleDao dao = new TodaySaleDao();
		dao.addtodaypayment(cb);	
	
	}
	
	//date wise today sale
	
	public List gettodaysaledateWiseReportt(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String saledatee = request.getParameter("saledatee");
		
		System.out.println("saledatee - "+saledatee);
	        Map<Long,TodaySaleHibernate> map = new HashMap<Long,TodaySaleHibernate>();
			
	        TodaySaleDao dao = new TodaySaleDao();
			List<TodaySaleHibernate> exp1List = dao.gettodaysaledateWiseReport(hotelid,usertype,saledatee);
			
			return exp1List;
	}
	
	//today sale range wise
	public List getsalerangeWiseReporttt(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String rangefrom = request.getParameter("rangefrom");
		String rangetoo = request.getParameter("rangetoo");
		
		System.out.println("range wise from date & to date - "+rangefrom+" &  "+rangetoo);
	        Map<Long,TodaySaleHibernate> map = new HashMap<Long,TodaySaleHibernate>();
			
	        TodaySaleDao dao = new TodaySaleDao();
			List<TodaySaleHibernate> exp1List = dao.gettodaysaleRangewiseWiseReport(hotelid,usertype,rangefrom,rangetoo);
			
			return exp1List;
	}
}
