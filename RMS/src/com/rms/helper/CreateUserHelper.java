package com.rms.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.AddWaitersList;
import com.rms.dao.AddWaitersDao;
import com.rms.dao.CreateUserDao;
import com.rms.hibernate.AddWaiters;
import com.rms.hibernate.CreateUser;
import com.rms.hibernate.UserDetailsBean;
import com.rms.hibernate.feedback;
import com.rms.hibernate.usercreateBean;
import com.rms.utility.HibernateUtility;

public class CreateUserHelper {
	
	public void userCreate (HttpServletRequest request, HttpServletResponse response){
		
		String abcd = "";
		String userType= request.getParameter("userType");
		System.out.println("user tyoe -- "+userType);
		String firstName= request.getParameter("firstName");
		System.out.println("firstName  =   "+firstName);
		String lastName = request.getParameter("lastName");
		System.out.println("lastName  =  "+lastName);
		String userName=request.getParameter("userName");
		System.out.println("user name --  "+userName);
		String mobileNo=request.getParameter("mobileNo");
		System.out.println("mobile - - -  "+mobileNo);
		String password=request.getParameter("password");
		System.out.println("passss--  "+password);
		String confirmPassword=request.getParameter("confirmPassword");
		System.out.println("comfim - - -  "+confirmPassword);
		String emailId=request.getParameter("emailId");
		System.out.println("email id -  "+emailId);
		String hotelname = request.getParameter("hotelname");
		String hotelid = request.getParameter("hotelid");
		System.out.println("hotelname = - "+hotelname+" hotelid - "+hotelid);
		//		UserDetailsBean cu = new UserDetailsBean();
	//	CreateUser cu = new CreateUser();
		
		usercreateBean cu = new usercreateBean();
		
		cu.setUserType(userType);
//		cu.setTypeId(userType);
		cu.setFirstName(firstName);
		cu.setLastName(lastName);
		cu.setUserName(userName);
		cu.setMobileNO(mobileNo);
//		cu.setContactNo(Long.parseLong(mobileNo));
		cu.setPassword(password);
		cu.setConfirmPassword(confirmPassword);
//		cu.setRePassword(confirmPassword);
		if(!"".equals(emailId)) {
			cu.setEmailId(emailId);
		}
		else
		{
			cu.setEmailId("N/A");
		}	
		cu.setHotelname(hotelname);
		cu.setHotelid(Long.parseLong(hotelid));
		System.out.println();
		System.out.println("usertype -  "+cu.getUserType()+"first name  -- "+cu.getFirstName()+"last name -- "+cu.getLastName()+"  username -  "+cu.getUserName()+" passs  -  "+cu.getPassword()+" comfrm pass "+cu.getConfirmPassword()+" mail id"+cu.getEmailId());
		System.out.println("hotelname - "+cu.getHotelname()+" hotelid - "+cu.getHotelid());
//		System.out.println("contact no -- "+cu.getContactNo());
//		System.out.println("pass --- "+cu.getPassword());
//		System.out.println("re pass - "+cu.getRePassword());
//		System.out.println("email id --  "+cu.getEmailId());
		
	//	cu.setEmailId(emailId);
		CreateUserDao cud = new CreateUserDao();
		cud.addUser(cu);
		
		
	}
	// update update details 

	// update Waiter ENtry 
	
	
	public void editCreateUserEntry(HttpServletRequest request, HttpServletResponse response) {

		String CreateUserId = request.getParameter("CreateUserId");
		System.out.println(" hi this Create User Id is ==  "+CreateUserId);
		String userType= request.getParameter("userType");
		String firstName= request.getParameter("firstName");
		System.out.println("hi this firstName==  "+firstName);
		String lastName=request.getParameter("lastName");
		System.out.println("hi this lastName==   "+lastName);
		String userName=request.getParameter("userName");
		String mobileNo=request.getParameter("mobileNo");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		String emailId=request.getParameter("emailId");
		System.out.println("email ID in helper -- "+emailId);
		
		System.out.println("in editHElper^^");
		//System.out.println("Type :  -----"+type);
		
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		transaction = session.beginTransaction();

		//System.out.println("%%%%%%%%%%%%%%%%% Product id :" + itemId);
		long itemId1 = Long.parseLong(CreateUserId);
		usercreateBean cu = (usercreateBean) session.get(usercreateBean.class, itemId1);

		cu.setUserType(userType);
		cu.setFirstName(firstName);
		cu.setLastName(lastName);
		cu.setUserName(userName);
		cu.setMobileNO(mobileNo);
		cu.setPassword(password);
		cu.setConfirmPassword(confirmPassword);
//		cu.setEmailId(emailId);
		
		if(!"".equals(emailId)) {
			cu.setEmailId(emailId);
		}
		else {
			cu.setEmailId("N/A");
		}
		
			
		session.saveOrUpdate(cu);
		transaction.commit();
		session.close();
		System.out.println("Record updated successfully.");
		
		
	}
	
	
	
	
	// Get Create User Details TO Edit
	
		public Map getCreateUserForEdit(Long pk_item_details_id) {

		 	System.out.println("into helper class");
		 	CreateUserDao dao1 = new CreateUserDao();
			List catList = dao1.getAllUserDetailsForEdit(pk_item_details_id);
			
			Map  map =  new HashMap();
			for(int i=0;i<catList.size();i++)
			{
				Object[] o = (Object[])catList.get(i);
				System.out.println("Data fetched --  "+Arrays.toString(o));
			//	CreateUser b = new CreateUser();
				usercreateBean b = new usercreateBean();
				b.setPk_create_user_id(Long.parseLong(o[0].toString()));
				b.setUserType((o[1].toString()));
				b.setFirstName((o[2].toString()));
				b.setLastName((o[3].toString()));
				b.setUserName((o[4].toString()));
				b.setPassword(o[5].toString());
				b.setConfirmPassword(o[6].toString());
				b.setEmailId((o[7].toString()));
				b.setMobileNO((o[8].toString()));
				
				//System.out.println("TYPE==============================="+b.getType());
				map.put(b.getPk_create_user_id(),b);
			}
			System.out.println("out of helper return map : "+map.size());
			return map;
		
		}
	
	// feedback
	
public void feedBackformhelper(HttpServletRequest request, HttpServletResponse response){
		
		String name= request.getParameter("name");
		System.out.println(name);
		String contact= request.getParameter("contact");
		System.out.println(contact);
		String feedback=request.getParameter("tfeedback");
		System.out.println(feedback);
		String rate_value=request.getParameter("rate_value");
		System.out.println(rate_value);
		
		feedback fb = new feedback();
		
		fb.setName(name);
		fb.setContact(Long.parseLong(contact));
		fb.setRate(rate_value);
		fb.setTfeedback(feedback);
		
		
		
		CreateUserDao cud = new CreateUserDao();
		cud.feedBackformDAO(fb);
		
		
	}

}
