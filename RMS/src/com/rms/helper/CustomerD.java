package com.rms.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rms.dao.CustomerDetails;
import com.rms.dao.PurchaseGoodDao;
import com.rms.hibernate.CustomerDetailsHibernate;

public class CustomerD {
	
	
public void customersDetails(HttpServletRequest request, HttpServletResponse response) {
		
	 

				
				String customerName=request.getParameter("customerName");
				String dob=request.getParameter("dob");
				String mobileNumber=request.getParameter("mob");
				
				CustomerDetailsHibernate cd = new CustomerDetailsHibernate();
				cd.setCustomerName(customerName);
				cd.setDob(dob);
				cd.setMobileNumber(mobileNumber);
				
				
				CustomerDetails  cd1=new CustomerDetails();
				cd1.valCustomer(cd);
				
			}
public List getcustomerdetails()
{
	CustomerDetails dao = new CustomerDetails();
	return dao.getcustomerdetails();
}
		


}
