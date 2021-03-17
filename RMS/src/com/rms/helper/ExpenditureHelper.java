package com.rms.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rms.bean.OrderBillReportDateWiseBean;
import com.rms.dao.ExpenditureDao;
import com.rms.dao.TempItemDetailDao;
import com.rms.hibernate.expenditurepaymentHibernate;

public class ExpenditureHelper {

	
	public List getexpenditureWiseReportt(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String fkexpenditurename = request.getParameter("fkexpenditurename");
		String expenid = request.getParameter("expenid");
		System.out.println("fkexpenditurename - "+fkexpenditurename);
	        Map<Long,expenditurepaymentHibernate> map = new HashMap<Long,expenditurepaymentHibernate>();
			
	        ExpenditureDao dao = new ExpenditureDao();
			List<expenditurepaymentHibernate> exp1List = dao.getexpenditureWiseReport(hotelid,usertype,fkexpenditurename);
			
			return exp1List;
	}
	
	//exp date
	
	public List getexpendituredateWiseReportt(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String expdate = request.getParameter("expdate");
		
		System.out.println("expdate - "+expdate);
	        Map<Long,expenditurepaymentHibernate> map = new HashMap<Long,expenditurepaymentHibernate>();
			
	        ExpenditureDao dao = new ExpenditureDao();
			List<expenditurepaymentHibernate> exp1List = dao.getexpendituredateWiseReport(hotelid,usertype,expdate);
			
			return exp1List;
	}
	
	
	public List getexpRangeWiseReportt(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		String usertype = (String)sessionn.getAttribute("usertype");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String rangefrm = request.getParameter("rangefrm");
		String rangeto = request.getParameter("rangeto");
		
		System.out.println("rangefrm - "+rangefrm+" rangeto - "+rangeto);
	        Map<Long,expenditurepaymentHibernate> map = new HashMap<Long,expenditurepaymentHibernate>();
			
	        ExpenditureDao dao = new ExpenditureDao();
			List<expenditurepaymentHibernate> exp1List = dao.getexpRangeWiseReport(hotelid,usertype,rangefrm,rangeto);
			
			return exp1List;
	}
}
