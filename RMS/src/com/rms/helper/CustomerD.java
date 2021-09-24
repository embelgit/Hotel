package com.rms.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rms.dao.AddWaitersDao;
import com.rms.dao.CustomerDetails;
import com.rms.hibernate.CustomerDetailsHibernate;

public class CustomerD {
	
	
public void customersDetails(HttpServletRequest request, HttpServletResponse response) {
	
	HttpSession sessionn = request.getSession(true);
	String username = (String)sessionn.getAttribute("user");		
	String userid = (String)sessionn.getAttribute("userid");
	String hotelid = (String)sessionn.getAttribute("hotelid");
	String hotelname=(String)sessionn.getAttribute("hotelname");
	System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);

		
				String customerName=request.getParameter("fkcustomerId");
				String dob=request.getParameter("customerDOB");
				String mobileNumber=request.getParameter("customerNumber");
				
				CustomerDetailsHibernate cd = new CustomerDetailsHibernate();
				
				if(!"".equals(customerName)) {
					cd.setCustomerName(customerName);
				}
				else
				{
					cd.setCustomerName("N/A");
				}
				
				if(!"".equals(dob)){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date newDate = null;
					try {
						newDate =	format.parse(dob);
						} 
					catch (ParseException e1) {
						e1.printStackTrace();
					}
					cd.setDob(newDate);
					}
				else
				{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date adate = null;
					try {
					 adate=	format.parse("2000-01-01");
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					cd.setDob(adate);		
				}
				
					if(!"".equals(mobileNumber)) {
						cd.setMobileNumber(Long.parseLong(mobileNumber));
					}
					else
					{
						cd.setMobileNumber(Long.parseLong("N/A"));
					}
			
				System.out.println("------------In customersDetails Helper.");	
				
				CustomerDetails cd1=new CustomerDetails();
				cd1.valCustomer(cd);
				
			}

}
