package com.rms.helper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.AddWaitersList;
import com.rms.bean.GoodsReceiveReportBean;
import com.rms.dao.AddWaitersDao;
import com.rms.dao.CashBookDao;
import com.rms.dao.GoodsReceiveDao;
import com.rms.dao.ItemDetailsDao;
import com.rms.hibernate.AddWaiters;
import com.rms.hibernate.ItemEntry;
import com.rms.utility.HibernateUtility;

public class AddWaitersHelper {

	public void waiterDetails(HttpServletRequest request, HttpServletResponse response) {

		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String waiterId = request.getParameter("waiterId");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String mobileNo = request.getParameter("mobileNo");
		String emailId = request.getParameter("emailId");
		String joiningDate = request.getParameter("joiningDate");
		String dob = request.getParameter("dob");
		String salary = request.getParameter("salary");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String state = request.getParameter("state");

		AddWaiters adw = new AddWaiters();
		
		adw.setUsername(username);
		adw.setUserid(Long.parseLong(userid));
		adw.setHotelid(Long.parseLong(hotelid));
		adw.setHotelname(hotelname);
		
		adw.setWaiterId(Long.parseLong(waiterId));
		adw.setFirstName(firstName);
		adw.setMiddleName(middleName);
		adw.setLastName(lastName);
		adw.setMobileNo(Long.parseLong(mobileNo));
		if(!"".equals(emailId)) {
			adw.setEmailId(emailId);
		}
		else
		{
			adw.setEmailId("N/A");
		}

		if(!"".equals(salary)) {
			adw.setSalary(Double.parseDouble(salary));
		}
		else
		{
			adw.setSalary(0d);
		}
		
		if(!"".equals(address)) {
			adw.setAddress(address);
		}
		else {
			adw.setAddress("NA");
		}
		if(!"".equals(city)) {
			adw.setCity(city);
		}
		else {
			adw.setCity("NA");
		}
		if(!"".equals(zip)) {
			adw.setZip(Long.parseLong(zip));
		}
		else {
			adw.setZip(0l);
		}	
		if(!"".equals(state)) {
			adw.setState(state);
		}
		else {
			adw.setState("NA");
		}
		
		if(!"".equals(dob)){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = null;
			try {
				newDate =	format.parse(dob);
				} 
			catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			adw.setDob(newDate);
			}
			else
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date adate = null;
				try {
				 adate=	format.parse("2016-09-20");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				adw.setDob(adate);		
			}
		
		if(!"".equals(joiningDate)){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = null;
			try {
				newDate =	format.parse(joiningDate);
				} 
			catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			adw.setJoiningDate(newDate);
			}
			else
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date adate = null;
				try {
				 adate=	format.parse("2016-09-20");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				adw.setJoiningDate(adate);			
			}
			
		AddWaitersDao awd1 = new AddWaitersDao();
		awd1.addingWaiter(adw);
		
		// cb entry
		
//		com.rms.dao.CashBookDao daoo = new com.rms.dao.CashBookDao();
//       List cblist = daoo.getwaitrcashBookEntry(waiterId);
        
        // cash book update if cash is empty
 //       if(cblist.size() == 0){
      //  	System.out.println("iN cashbook List.size() goodsrecievehelper, updating total = = =  "+cblist.size());
        	com.rms.hibernate.CashBook newEntry = new com.rms.hibernate.CashBook();
 			
 		//	newEntry.setFk_good_received_id(Long.parseLong(pk_item_entry_Id));
 		//	newEntry.setStock(Double.parseDouble(quantity));
 		//	newEntry.setItemname(fk_item_id_drop1);
 		//	System.out.println("item name  "+newEntry.getItemname());
        	newEntry.setFkemployeeId(Long.parseLong(waiterId));
        	newEntry.setFkSupplierId(Long.parseLong("0"));
        	newEntry.setToPayNameId(firstName);
        	
        	if(!"".equals(salary)) {
        	newEntry.setPaymentAmountId(Double.parseDouble(salary));
        	}
        	else
        	{
        		newEntry.setPaymentAmountId(0d);;
        	}
        	
        	if(!"".equals(salary)) {
        	newEntry.setRemainingBalance(Double.parseDouble(salary));
        	}
        	else {
        		newEntry.setRemainingBalance(0d);
        	}
        	System.out.println(" CASHBOOK - - -  fk employee ID "+newEntry.getFkemployeeId()+" supp name - - "+newEntry.getToPayNameId()+" total amount sett  -  "+newEntry.getPaymentAmountId()+"  reamining bal set  "+newEntry.getRemainingBalance());
        	newEntry.setPayToId("employee");		
//        	newEntry.setToPayNameId(suplierName);
        	newEntry.setPaymentTypeId("NA");
        	newEntry.setPaymebtById("NA");
        	newEntry.setChequeNoId(0l);
        	newEntry.setCardNoId(0l);
        	newEntry.setNeftAccNoId(0l);
       // 	newEntry.setPaymentAmountId(0d);
        	newEntry.setPayingAmountId(0d);
        	newEntry.setPaymentReasonId("NA");
        	newEntry.setTransID(Long.parseLong("0"));
      //  	newEntry.setRemainingBalance(0d);
//    		cb.setFkSupplierId(suppID);
        	newEntry.setUsername(username);
        	newEntry.setUserid(Long.parseLong(userid));
        	newEntry.setHotelid(Long.parseLong(hotelid));
        	newEntry.setHotelname(hotelname);
        	
        	try {
        		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        		Date dateobj = new Date();
        		String CurrentDate = df.format(dateobj);
        		Date newdate = df.parse(CurrentDate);		
        		newEntry.setChequeDateId(newdate);
        		newEntry.setPaymentDate(newdate);
        		}
        		catch(Exception e) {
        			e.printStackTrace();
        		}
        	com.rms.dao.CashBookDao dao2 = new com.rms.dao.CashBookDao();
 			dao2.registerCB(newEntry);	 
		
		
		
	}
	
	
	// update Waiter ENtry 
	
	
	public void editWaiterEntry(HttpServletRequest request, HttpServletResponse response) {

		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" - in editWaiterEntry()");
		
		
		String waiterId = request.getParameter("waiterId");
	//	Long waID = Long.parseLong(waiterId);
		System.out.println("waiter entry id --   helper --  "+waiterId);
		String waiterID = request.getParameter("waiterID");
		Long waID = Long.parseLong(waiterID);
		System.out.println("waiter ID -- helper --  "+waiterID);
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String mobileNo = request.getParameter("mobileNo");
		String emailId = request.getParameter("emailId");
		String joiningDate = request.getParameter("joiningDate");
		String dob = request.getParameter("dob");
		String salary = request.getParameter("salary");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String state = request.getParameter("state");
		
		System.out.println("in edit Helper -----");
		//System.out.println("Type :  -----"+type);
		
		HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		transaction = session.beginTransaction();

		//System.out.println("%%%%%%%%%%%%%%%%% Product id :" + itemId);
		long itemId1 = Long.parseLong(waiterId);
		AddWaiters adw = (AddWaiters) session.get(AddWaiters.class, itemId1);

		adw.setUsername(username);
		adw.setUserid(Long.parseLong(userid));
		adw.setHotelid(Long.parseLong(hotelid));
		adw.setHotelname(hotelname);
		
		if(!"".equals(waiterID)) {
			adw.setWaiterId(Long.parseLong(waiterID));
		} else {
			adw.setWaiterId(0l);
		} 
	//	adw.setWaiterId(Long.parseLong(waiterId));
		if(!"".equals(firstName)) {
			adw.setFirstName(firstName);
		}else {
			adw.setFirstName("N/A");
		}
		if(!"".equals(middleName)) {
			adw.setMiddleName(middleName);
		}else {
			adw.setMiddleName("N/A");
		}
		if(!"".equals(lastName)) {
			adw.setLastName(lastName);
		}
		else {
			adw.setLastName("N/A");
		}
		if(!"".equals(mobileNo)) {
			adw.setMobileNo(Long.parseLong(mobileNo));
		} else {
			adw.setMobileNo(0l);
		}
		if(!"".equals(emailId)) {
			adw.setEmailId(emailId);
		} else {
			adw.setEmailId("N/A");
		}
		if(!"".equals(salary)) {
			adw.setSalary(Double.parseDouble(salary));
		} else {
			adw.setSalary(0d);
		}
		if(!"".equals(address)) {
			adw.setAddress(address);
		} else {
			adw.setAddress("N/A");
		}
		if(!"".equals(city)) {
			adw.setCity(city);
		} else {
			adw.setCity("N/A");
		}
		if(!"".equals(zip)) {
			adw.setZip(Long.parseLong(zip));
		} else {
			adw.setZip(0l);
		}
		if(!"".equals(state))
		{
			adw.setState(state);
		}
		else {
			adw.setState("N/A");
		}
		
		
		if(!"".equals(dob)){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = null;
			try {
				newDate =	format.parse(dob);
				} 
			catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			adw.setDob(newDate);
			System.out.println("if dob present - "+adw.getDob());
			}
			else
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date adate = null;
				try {
				 adate=	format.parse("2016-09-20");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				adw.setDob(adate);		
				System.out.println("if dob absent - "+adw.getDob());
			}
		
		if(!"".equals(joiningDate)){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = null;
			try {
				newDate =	format.parse(joiningDate);
				} 
			catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			adw.setJoiningDate(newDate);
			System.out.println("if joining present - "+adw.getJoiningDate());
			}
			else
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date adate = null;
				try {
				 adate=	format.parse("2016-09-20");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				adw.setJoiningDate(adate);			
				System.out.println("if joining absent - "+adw.getJoiningDate());
			}
		
		
		session.saveOrUpdate(adw);
		transaction.commit();
		session.close();
		System.out.println("Record updated successfully.");
		// cb update
		
		CashBookDao dao = new CashBookDao();
		List elist = dao.getAllwaitrEntry(request);
		
		for(int i=0; i<elist.size(); i++) {
		 	com.rms.hibernate.CashBook st = (com.rms.hibernate.CashBook)elist.get(i);
		 	
		 	
			Long pkID = st.getPkCashBookEntry();
			Long wID = st.getFkemployeeId();
			System.out.println("pk id - "+pkID+" waitr id from CB - "+wID+" waiter id frm user - - "+waID);
			if(wID .equals(waID)) {
				
			/*	Double amount = st.getPaymentAmountId();
				Double remain = st.getRemainingBalance();
				Double updatetotal = (double)(amount+ Double.parseDouble(salary));
				Double updateremain = (double)(remain+ Double.parseDouble(salary));
				*/
				System.out.println(" before object saving in CB when equal cond match`````````````````````````````````````````````````````````````````````````````");
				 com.rms.utility.HibernateUtility hbu1 = com.rms.utility.HibernateUtility.getInstance();
        		 Session session1 = hbu1.getHibernateSession();
        		 Transaction transaction1 = session1.beginTransaction();
        	
        		 com.rms.hibernate.CashBook updateCB = (com.rms.hibernate.CashBook) session1.get(com.rms.hibernate.CashBook.class, new Long(pkID));

        		 updateCB.setRemainingBalance(Double.parseDouble(salary));
        		updateCB.setPaymentAmountId(Double.parseDouble(salary));
        		updateCB.setFkemployeeId(waID);
        		updateCB.setToPayNameId(firstName);
        		updateCB.setUsername(username);
        		updateCB.setUserid(Long.parseLong(userid));
        		updateCB.setHotelid(Long.parseLong(hotelid));
        		updateCB.setHotelname(hotelname);
        		
        		 //		 updateCB.setToPayNameId(toPayNameId);
        		 session1.saveOrUpdate(updateCB);
        		 System.out.println("if emp updated in cashbook update Bal is  OBJ saved ! - - "+updateCB.getRemainingBalance()+" amount id is - - > "+updateCB.getPaymentAmountId()+" waiter id updated -  "+updateCB.getFkemployeeId()+" name - "+updateCB.getToPayNameId());
        		 transaction1.commit();
        		 break;
			}
		 	
		}
		
		
	}
	// get waiter for Edit
	//get item detail to edit
	public Map getWaiterForEdit(Long pk_item_details_id) {

	 	System.out.println("into helper class");
	 	AddWaitersDao dao1 = new AddWaitersDao();
		List catList = dao1.getAllWaiterForEdit(pk_item_details_id);
		
		Map  map =  new HashMap();
		for(int i=0;i<catList.size();i++)
		{
			Object[] o = (Object[])catList.get(i);
			System.out.println("Result --  "+Arrays.toString(o));
			AddWaitersList b = new AddWaitersList();
			b.setPkAddWaiterId(Long.parseLong(o[0].toString()));
			b.setWaiterId(Long.parseLong(o[1].toString()));
			b.setFirstName((o[2].toString()));
			b.setMiddleName((o[3].toString()));
			b.setLastName((o[4].toString()));
			b.setMobileNo(Long.parseLong(o[5].toString()));
			b.setDob(o[6].toString());
			b.setJoiningDate(o[7].toString());
			b.setSalary(Double.parseDouble(o[8].toString()));
			b.setAddress(o[9].toString());
			b.setCity(o[10].toString());
			b.setZip(Long.parseLong(o[11].toString()));
			b.setState(o[12].toString());
			b.setEmailId(o[13].toString());
			//System.out.println("TYPE==============================="+b.getType());
			map.put(b.getPkAddWaiterId(),b);
		}
		System.out.println("out of helper return map : "+map.size());
		return map;
	
	}

/*	public List getattendedWaitersReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//  PrintWriter out = response.getWriter();
		
		String waiterName = request.getParameter("waiterName");

	        Map<Long,GoodsReceiveReportBean> map = new HashMap<Long,GoodsReceiveReportBean>();
			
	        GoodsReceiveDao dao = new GoodsReceiveDao();
//			List<GoodsReceiveReportBean> exp1List = dao.getGoodsReceiveReport(itemName);
			List<GoodsReceiveReportBean> catList = dao.getGoodsReceiveReport(waiterName);
			/*	if(exp1List.size()>0)
			{
				return exp1List;
			}
			else
			{
				
				out.println("alert('No Data. .')");
				
				return null;
			} 
			return catList;
	}  */
	
	
	
	
}
