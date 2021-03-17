package com.rms.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.dao.SupplierDetailsDao;
import com.rms.dao.CashBookDao;
import com.rms.hibernate.CashBook;
import com.rms.hibernate.SupplierDetailsHibernate;
import com.rms.utility.HibernateUtility;

public class SupplierDetailsHelper {
	public void doSupplierDetails(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("user");		
		String userid = (String)session.getAttribute("userid");
		String hotelid = (String)session.getAttribute("hotelid");
		String hotelname=(String)session.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String suplierName = request.getParameter("suplierName");	
		String gstNo = request.getParameter("gstNo");
		String contactPerson = request.getParameter("contactPerson");
		String suplierContact = request.getParameter("suplierContact");
		String emailID = request.getParameter("emailID");
		String suplierCity = request.getParameter("suplierCity");
		String address = request.getParameter("address");
		String suplierState = request.getParameter("suplierState");
		
		SupplierDetailsHibernate sd = new SupplierDetailsHibernate();
		
		sd.setUsername(username);
		sd.setUserid(Long.parseLong(userid));
		sd.setHotelid(Long.parseLong(hotelid));
		sd.setHotelname(hotelname);
		
		sd.setSuplierName(suplierName);
	//	sd.setGstNo(gstNo);
		sd.setContactPerson(contactPerson);
		
		if(!"".equals(gstNo)) 
		{
			sd.setGstNo(gstNo);
		}
		else
		{
			sd.setGstNo("0");
		}
		if(!"".equals(suplierContact)) {
			sd.setSuplierContact(suplierContact);
		}
		else {
			sd.setContactPerson("0");
		}
		if(!"".equals(emailID)) {
			sd.setEmailID(emailID);
		} else {
			sd.setEmailID("N/A");
		}
		if(!"".equals(suplierCity)) {
			sd.setSuplierCity(suplierCity);
		}
		else {
			sd.setSuplierCity("N/A");
		}
		if(!"".equals(address)) {
			sd.setAddress(address);
		} else {
			sd.setAddress("N/A");
		}
		
		if(!"".equals(suplierState)) {
			sd.setSuplierState(suplierState);
		}
		else {
			sd.setSuplierState("N/A");
		}
		
	//	Long suppID = sd.getPkSupplierDetailId();
	//	System.out.println("supp ID is - - "+suppID);
		SupplierDetailsDao dao = new SupplierDetailsDao();
		dao.SupplierDetailsHibernate(sd);

/*		CashBook cb = new CashBook();
		try {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		String CurrentDate = df.format(dateobj);
		Date newdate = df.parse(CurrentDate);		
		cb.setChequeDateId(newdate);
		cb.setPaymentDate(newdate);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

		cb.setPayToId("supplier");		
		cb.setToPayNameId(suplierName);
		cb.setPaymentTypeId("NA");
		cb.setPaymebtById("NA");
		cb.setChequeNoId(0l);

		cb.setCardNoId(0l);
		cb.setNeftAccNoId(0l);
		cb.setPaymentAmountId(0d);
		cb.setPayingAmountId(0d);
		cb.setPaymentReasonId("NA");
		cb.setRemainingBalance(0d);
//		cb.setFkSupplierId(suppID);
		System.out.println("fksupplier ID "+cb.getFkSupplierId());
		CashBookDao doo = new CashBookDao();
		doo.saveInCash(cb); */
	}
	
	
	
	public List getSuppliers()
	{
		System.out.println("in helper"); 
		CashBookDao dao = new CashBookDao(); 
		return dao.getSupplierNameByToPay();
	  
	  }
	 
	

	//get supplier detail to edit
	public Map getSupplierDetailsForEdit(Long pkSupplierDetailId) {

	 	System.out.println("into helper class");
	 	SupplierDetailsDao dao1 = new SupplierDetailsDao();
		List catList = dao1.getAllSupplierDetailsForEdit(pkSupplierDetailId);
		
		Map  map =  new HashMap();
		for(int i=0;i<catList.size();i++)
		{
			Object[] o = (Object[])catList.get(i);
		
			SupplierDetailsHibernate b = new SupplierDetailsHibernate();
			b.setPkSupplierDetailId(Long.parseLong(o[0].toString()));
			b.setSuplierName(o[1].toString());
			b.setGstNo(o[2].toString());
			b.setContactPerson(o[3].toString());
			b.setSuplierContact(o[4].toString());
			b.setEmailID(o[5].toString());
			b.setSuplierCity(o[6].toString());
			b.setAddress(o[7].toString());
			b.setSuplierState(o[8].toString());
			map.put(b.getPkSupplierDetailId(),b);
		}
		System.out.println("out of helper return map : "+map);
		return map;
	
	}

//update supplier info
	public void updateSupplierInfoDetail(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String supplierId = request.getParameter("supplierId");
		String suplierName = request.getParameter("suppName");
		System.out.println("supp name ------ "+suplierName);
		String gstNo = request.getParameter("gstNo");
		String contactPerson = request.getParameter("contactPerson");
		String suplierContact = request.getParameter("suplierContact");
		String emailID = request.getParameter("emailID");
		String suplierCity = request.getParameter("suplierCity");
		String address  = request.getParameter("address");
		String suplierState  = request.getParameter("suplierState");
		
		
		
		com.rms.utility.HibernateUtility hbu=null;
		Session session = null;
		Transaction transaction = null;
		
		 hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
	
		long supplierInfoId =Long.parseLong(supplierId);
		
		SupplierDetailsHibernate det = (SupplierDetailsHibernate) session.load(SupplierDetailsHibernate.class, supplierInfoId);
		
		det.setUsername(username);
		det.setUserid(Long.parseLong(userid));
		det.setHotelid(Long.parseLong(hotelid));
		det.setHotelname(hotelname);
		
		if(!"".equals(suplierName)) {
			det.setSuplierName(suplierName);
		}
		else {
			det.setSuplierName("NA");
		}
		
		if(!"".equals(gstNo)) 
		{
			det.setGstNo(gstNo);
		}
		else
		{
			det.setGstNo("0");
		}
		if(!"".equals(contactPerson)) {
			det.setContactPerson(contactPerson);
		} else {
			det.setContactPerson("N/A");
		}
		
		if(!"".equals(suplierContact)) {
			det.setSuplierContact(suplierContact);
		}
		else {
			det.setContactPerson("0");
		}
		if(!"".equals(emailID)) {
			det.setEmailID(emailID);
		} else {
			det.setEmailID("N/A");
		}
		if(!"".equals(suplierCity)) {
			det.setSuplierCity(suplierCity);
		}
		else {
			det.setSuplierCity("N/A");
		}
		if(!"".equals(address)) {
			det.setAddress(address);
		} else {
			det.setAddress("N/A");
		}
		
		if(!"".equals(suplierState)) {
			det.setSuplierState(suplierState);
		}
		else {
			det.setSuplierState("N/A");
		}
		
		
	    session.saveOrUpdate(det);
		transaction.commit();
		
	}
}
		
	

