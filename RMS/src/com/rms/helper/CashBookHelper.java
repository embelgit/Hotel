package com.rms.helper;

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

import com.rms.bean.OrderBillReportDateWiseBean;
import com.rms.bean.TotalCashBookReport;
import com.rms.dao.CashBookDao;
import com.rms.dao.CustomerOrderDao;
import com.rms.dao.TempItemDetailDao;
import com.rms.hibernate.CashBook;
import com.rms.hibernate.CustomerOrder;
import com.rms.hibernate.GoodsReceiveHibernate;
import com.rms.hibernate.bankdetailHibernate;
import com.rms.hibernate.banktransaction;
import com.rms.hibernate.expenditureHibernate;
import com.rms.hibernate.expenditurepaymentHibernate;
import com.rms.utility.HibernateUtility;

public class CashBookHelper {

	/* register StockEntry */
/*	public void registerCashBookEntry(HttpServletRequest request, HttpServletResponse response) {
		
		String payToId = request.getParameter("payToId");
		String toPayNameId = request.getParameter("toPayNameId");
//		/*String paymentDate = request.getParameter("paymentDate");
		String paymentTypeId = request.getParameter("paymentTypeId");
		String paymebtById = request.getParameter("paymebtById");
		String chequeNoId = request.getParameter("chequeNoId");
		String chequeDateId = request.getParameter("chequeDateId");
		String cardNoId = request.getParameter("cardNoId");
		String neftAccNoId = request.getParameter("neftAccNoId");
		String paymentAmountId = request.getParameter("paymentAmountId");
		String paymentReasonId = request.getParameter("paymentReasonId");
		
		CashBook cb = new CashBook();
		
		if (!"".equals(payToId)) {
			cb.setPayToId(payToId);
		} else {
			cb.setPayToId("N/A");
		}
		if (!"".equals(toPayNameId)) {
			cb.setToPayNameId(toPayNameId);
		} else {
			cb.setToPayNameId("N/A");
		}
		
		if (1==1) {
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = new Date();
			cb.setPaymentDate(newDate);
			System.out.println("@@@@@@@@@@@@@@@ Payment DAte : "+cb.getPaymentDate());
		} 
		
		if (!"".equals(paymentTypeId)) {
			cb.setPaymentTypeId(paymentTypeId);
		} else {
			cb.setPaymentTypeId("N/A");
		}
		if (!"".equals(paymebtById)) {
			cb.setPaymebtById(paymebtById);
		} else {
			cb.setPaymebtById("N/A");
		}
		if (!"".equals(chequeNoId)) {
			cb.setChequeNoId(Long.parseLong(chequeNoId));
		} else {
			cb.setChequeNoId(0);
		}
		if (!"".equals(chequeDateId)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date adate = null;
			try {
				adate = format.parse(chequeDateId);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setChequeDateId(adate);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dammyDate = "00-00-0000";
			Date adate = null;
			try {
				adate = format.parse(dammyDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setChequeDateId(adate);
		}

		if (!"".equals(cardNoId)) {
			cb.setCardNoId(Long.parseLong(cardNoId));
		} else {
			cb.setCardNoId(0);
		}

		if (!"".equals(neftAccNoId)) {
			cb.setNeftAccNoId(Long.parseLong(neftAccNoId));
		} else {
			cb.setNeftAccNoId(0);
		}

		if (!"".equals(paymentAmountId)) {
			cb.setPaymentAmountId(Double.parseDouble(paymentAmountId));
		} else {
			cb.setPaymentAmountId(0d);
		}

		if (!"".equals(paymentReasonId)) {
			cb.setPaymentReasonId(paymentReasonId);
		} else {
			cb.setPaymentReasonId("N/A");
		}

		CashBookDao dao = new CashBookDao();
		dao.regstierCashBookEntry(cb);
	}   */
	// getCustSuppEmpReports() method is used to get reports of cust, supp and
	public List getCustSuppEmpReports(HttpServletRequest request, HttpServletResponse response) {
		String customerType = request.getParameter("customerType");
		Map<Long, TotalCashBookReport> map = new HashMap<Long, TotalCashBookReport>();
		CashBookDao dao = new CashBookDao();
		List<TotalCashBookReport> cashbooklist = dao.getCashBookReports(customerType);
		return cashbooklist;
	}

	public List getOneDayPaymentReport(HttpServletRequest request, HttpServletResponse response) {

		String reportDate = request.getParameter("reportDate");
		Map<Long, TotalCashBookReport> map = new HashMap<Long, TotalCashBookReport>();

		CashBookDao dao = new CashBookDao();
		List<TotalCashBookReport> paymentList = dao.getOneDayPaymentReport(reportDate);

		return paymentList;

	}

	public List twoDayPaymentReport(HttpServletRequest request, HttpServletResponse response) {

		String reportDate1 = request.getParameter("reportDate1");
		String reportDate2 = request.getParameter("reportDate2");
		Map<Long, TotalCashBookReport> map = new HashMap<Long, TotalCashBookReport>();

		CashBookDao dao = new CashBookDao();
		List<TotalCashBookReport> paymentList = dao.twoDayPaymentReport(reportDate1, reportDate2);

		return paymentList;

	}
	
	//cash report for single date
	public List singleDateCashBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String fDate = request.getParameter("fDate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date adate = null;
		try {
		 adate=	format.parse(fDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Map<Long,CashBook> map = new HashMap<Long,CashBook>();
			
		    CashBookDao dao = new CashBookDao();
			List<CashBook> exp1List = dao.singleDateCashBook(adate);
			
			return exp1List;
	}
	
	//cash report between two dates
	public List cashBookReportBetweenTwoDates(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String fisDate = request.getParameter("fisDate");
		String endDate = request.getParameter("endDate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date adate = null;
		Date bdate = null;
		
		try {
		 adate=	format.parse(fisDate);
		 bdate=	format.parse(endDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Map<Long,CashBook> map = new HashMap<Long,CashBook>();
			
		    CashBookDao dao = new CashBookDao();
			List<CashBook> exp1List = dao.cashBookReportBetweenTwoDates(adate,bdate);
			
			return exp1List;
	}
	Long transid;
	public void registerCashBookEntry(HttpServletRequest request, HttpServletResponse response) {
		

		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname = (String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String payToId = request.getParameter("payToId");
		String toPayNameId = request.getParameter("toPayNameId");
		System.out.println("toPayNameId == = "+toPayNameId);
		String paymentDate = request.getParameter("paymentDate");
		String paymentTypeId = request.getParameter("paymentTypeId");
		String paymebtById = request.getParameter("paymebtById");
		String chequeNoId = request.getParameter("chequeNoId");
		String chequeDateId = request.getParameter("chequeDateId");
		String cardNoId = request.getParameter("cardNoId");
		String neftAccNoId = request.getParameter("neftAccNoId");
		String paymentAmountId = request.getParameter("paymentAmountId");
		String paymentReasonId = request.getParameter("paymentReasonId");
		System.out.println("in HELPER TOTAL PAYMENT AMOUNT is - "+paymentAmountId);
		String payingAmountId = request.getParameter("payingAmountId");
		System.out.println("in HELPER PAID AMOUNT IS: "+payingAmountId);
		String remainingBalance = request.getParameter("remainingBalance");
		System.out.println("remaining Amount is - "+remainingBalance);
		
//		Double remainAt = (Double.parseDouble(remainingBalance)) - (Double.parseDouble(payingAmountId));
//		System.out.println("Total amount -- paid amount is -- - - - - - Rs. "+remainAt);
		System.out.println("In helper register CashBook Entry method -- ");
	
	//	CashBookDao data = new CashBookDao();
	//	List stkList  = data.gettransID();
//		Long TransactionID = 1l;
		
		CashBookDao cbb = new CashBookDao();
		List clist = cbb.getAllsuppEntry(toPayNameId,hotelid);
		
		if(clist.size()==0) {
		CashBook cb = new CashBook();	
	//	HttpSession session3 = request.getSession();
		
		CashBookDao data = new CashBookDao();
		List stkList  = data.gettransID(request);
		
		for(int i=0;i<stkList.size();i++){
			
			CashBook st = (CashBook)stkList.get(i);
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
		if (!"".equals(payToId))
		{
			cb.setPayToId(payToId);
		}
		else 
		{
			cb.setPayToId("N/A");
		}
		
		if (!"".equals(toPayNameId)) 
		{
			System.out.println("toPayNameId if()");
			cb.setToPayNameId(toPayNameId);
		} 
		else 
			{
				System.out.println("toPayNameId else()");
				cb.setToPayNameId("N/A");
			}
		cb.setUsername(username);
		cb.setUserid(Long.parseLong(userid));
		cb.setHotelid(Long.parseLong(hotelid));
		cb.setHotelname(hotelname);
		
		
		
		if (!"".equals(paymentDate)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date adate = null;
			try {
				adate = format.parse(paymentDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setPaymentDate(adate);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dammyDate = "00-00-0000";
			Date adate = null;
			try {
				adate = format.parse(dammyDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setPaymentDate(adate);
		}
		if (!"".equals(paymentTypeId)) {
			cb.setPaymentTypeId(paymentTypeId);
		} else {
			cb.setPaymentTypeId("N/A");
		}
		if (!"".equals(paymebtById)) {
			cb.setPaymebtById(paymebtById);
		} else {
			cb.setPaymebtById("N/A");
		}
		if (!"".equals(chequeNoId)) {
			cb.setChequeNoId(Long.parseLong(chequeNoId));
		} else {
			cb.setChequeNoId(0);
		}
		if (!"".equals(chequeDateId)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date adate = null;
			try {
				adate = format.parse(chequeDateId);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setChequeDateId(adate);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dammyDate = "00-00-0000";
			Date adate = null;
			try {
				adate = format.parse(dammyDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setChequeDateId(adate);
		}

		if (!"".equals(cardNoId)) {
			cb.setCardNoId(Long.parseLong(cardNoId));
		} else {
			cb.setCardNoId(0);
		}

		if (!"".equals(neftAccNoId)) {
			cb.setNeftAccNoId(Long.parseLong(neftAccNoId));
		} else {
			cb.setNeftAccNoId(0);
		}

		if (!"".equals(paymentAmountId)) {
			cb.setPaymentAmountId(Double.parseDouble(paymentAmountId));
		} else {
			cb.setPaymentAmountId(0d);
		}
		
		if (!"".equals(payingAmountId)) {
			cb.setPayingAmountId(Double.parseDouble(payingAmountId));
		} else {
			cb.setPayingAmountId(0d);
		}
		
		if (!"".equals(paymentReasonId)) {
			cb.setPaymentReasonId(paymentReasonId);
		} else {
			cb.setPaymentReasonId("N/A");
		}
		
		if(!"".equals(remainingBalance)) {
			cb.setRemainingBalance(Double.parseDouble(remainingBalance));
			System.out.println(" remaining Amount balance set is  Rs. "+cb.getRemainingBalance());
		}
		else {
			cb.setRemainingBalance(0d);
		}  
		
		
/*		session3.setAttribute("transid", transid);
		
			if(transid == null){
			cb.setTransID(1l);
			}
			else
			{
			cb.setTransID(transid);	
			
			} */
		cb.setUsername(username);
		cb.setUserid(Long.parseLong(userid));
		cb.setHotelid(Long.parseLong(hotelid));
		cb.setHotelname(hotelname);
		
		cb.setFkSupplierId(0l);	
		System.out.println("In helper end");
		CashBookDao dao = new CashBookDao();
		dao.regstierCashBookEntry(cb);
		}
		
		else {
			HttpSession session4 = request.getSession();
			for(int i=0; i<clist.size(); i++) {
			   	com.rms.hibernate.CashBook st = (com.rms.hibernate.CashBook)clist.get(i);	
				transid = st.getTransID();
			/*	if(transid==null) {
					transid =1l;
				}*/
				transid++;
				session4.setAttribute("transid", transid);
				
				CashBookDao data = new CashBookDao();
				List stkList  = data.gettransID(request);
				
				for(int k=0;k<stkList.size();k++){
					
					CashBook st1 = (CashBook)stkList.get(k);
					transid = st1.getTransID();
					if(transid==null) {
						transid =1l;
					}
					System.out.println("tranID in helper - -   "+transid);
					transid++;
				}
//				cb.setTransID(transid);
//				System.out.println("trans set in helper - > "+cb.getTransID());
				
				
				
				Long pkID = st.getPkCashBookEntry();
				String item = st.getToPayNameId();
		//		System.out.println("pk id - "+pkID+" supp name - "+item);
				if(item.equals(toPayNameId)) {
					
					Double remain = st.getRemainingBalance();
					Double updatedremain = (double)(remain - Double.parseDouble(payingAmountId));
					
					 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
	        		 Session session = hbu.getHibernateSession();
	        		 Transaction transaction = session.beginTransaction();
	        	
	        		 com.rms.hibernate.CashBook updateCB = (com.rms.hibernate.CashBook) session.get(com.rms.hibernate.CashBook.class, new Long(pkID));

	        		 updateCB.setRemainingBalance(updatedremain);
	        		 updateCB.setPayingAmountId(Double.parseDouble(payingAmountId));
	        		 
	        		 updateCB.setUsername(username);
	        		 updateCB.setUserid(Long.parseLong(userid));
	        		 updateCB.setHotelid(Long.parseLong(hotelid));
	        		 updateCB.setHotelname(hotelname);
	        			
	        		 if(!"".equals(paymentDate))
	        		 {
	        			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        				Date adate = null;
	        				try {
	        					adate = format.parse(paymentDate);
	        				} catch (ParseException e1) {
	        					// TODO Auto-generated catch block
	        					e1.printStackTrace();
	        				}
	        				updateCB.setPaymentDate(adate);
	        		 }
	        		 else 
	        		 {
	        			 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        			 Date cd = null;
	        			 try {
	        					
	     					
	     					Date dateobj = new Date();
	     					 String CurrentDate = df.format(dateobj);
	     					 System.out.println("Today's date  -- > "+CurrentDate);
	     					  cd = df.parse(CurrentDate);
	     					updateCB.setPaymentDate(cd);
	     			}
	     			catch(ParseException e) {
	     				e.printStackTrace();
	     			}
	        		 }
	        		 
	        		 System.out.println(" date set is supp cb - "+updateCB.getPaymentDate());
	        	/*	 if(transid == null){
	 					updateCB.setTransID(1l);
	 					}
	 					else
	 					{*/
	 						updateCB.setTransID(transid);	
	 			//		}
	        			System.out.println("trans set in helper - > "+updateCB.getTransID());
	        		 //		 updateCB.setToPayNameId(toPayNameId);
	        		 session.saveOrUpdate(updateCB);
	        		 System.out.println("if supp present in cashbook update Bal is  OBJ saved ! - - "+updateCB.getRemainingBalance()+" transaction id is - - > "+updateCB.getTransID());
	        		 transaction.commit();
	        		 break;
				}
				
				else {
					if(i+1==clist.size()) {
					
						CashBook cbd = new CashBook();
						
		//				HttpSession session3 = request.getSession();
						
						CashBookDao dataa = new CashBookDao();
						List stkListt  = data.gettransID(request);
						
						for(int l=0; l<stkListt.size(); l++){
							
							CashBook stt = (CashBook)stkListt.get(l);
							transid = stt.getTransID();
						/*	if(transid==null) {
								transid =1l;
							}*/
							transid++;
						}
						cbd.setTransID(transid);
						System.out.println("trans set in helper - > "+cbd.getTransID());
						
						if (!"".equals(payToId))
						{
							cbd.setPayToId(payToId);
						}
						else 
						{
							cbd.setPayToId("N/A");
						}
						
						if (!"".equals(toPayNameId)) 
						{
							System.out.println("toPayNameId if()");
							cbd.setToPayNameId(toPayNameId);
						} 
						else 
							{
								System.out.println("toPayNameId else()");
								cbd.setToPayNameId("N/A");
							}
						
						
						
						
						if (!"".equals(paymentDate)) {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							Date adate = null;
							try {
								adate = format.parse(paymentDate);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							cbd.setPaymentDate(adate);
						} else {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							String dammyDate = "00-00-0000";
							Date adate = null;
							try {
								adate = format.parse(dammyDate);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							cbd.setPaymentDate(adate);
						}
						if (!"".equals(paymentTypeId)) {
							cbd.setPaymentTypeId(paymentTypeId);
						} else {
							cbd.setPaymentTypeId("N/A");
						}
						if (!"".equals(paymebtById)) {
							cbd.setPaymebtById(paymebtById);
						} else {
							cbd.setPaymebtById("N/A");
						}
						if (!"".equals(chequeNoId)) {
							cbd.setChequeNoId(Long.parseLong(chequeNoId));
						} else {
							cbd.setChequeNoId(0);
						}
						if (!"".equals(chequeDateId)) {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							Date adate = null;
							try {
								adate = format.parse(chequeDateId);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							cbd.setChequeDateId(adate);
						} else {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							String dammyDate = "00-00-0000";
							Date adate = null;
							try {
								adate = format.parse(dammyDate);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							cbd.setChequeDateId(adate);
						}

						if (!"".equals(cardNoId)) {
							cbd.setCardNoId(Long.parseLong(cardNoId));
						} else {
							cbd.setCardNoId(0);
						}

						if (!"".equals(neftAccNoId)) {
							cbd.setNeftAccNoId(Long.parseLong(neftAccNoId));
						} else {
							cbd.setNeftAccNoId(0);
						}

						if (!"".equals(paymentAmountId)) {
							cbd.setPaymentAmountId(Double.parseDouble(paymentAmountId));
						} else {
							cbd.setPaymentAmountId(0d);
						}
						
						if (!"".equals(payingAmountId)) {
							cbd.setPayingAmountId(Double.parseDouble(payingAmountId));
						} else {
							cbd.setPayingAmountId(0d);
						}
						
						if (!"".equals(paymentReasonId)) {
							cbd.setPaymentReasonId(paymentReasonId);
						} else {
							cbd.setPaymentReasonId("N/A");
						}
						
						if(!"".equals(remainingBalance)) {
							cbd.setRemainingBalance(Double.parseDouble(remainingBalance));
							System.out.println(" remaining Amount balance set is  Rs. "+cbd.getRemainingBalance());
						}
						else {
							cbd.setRemainingBalance(0d);
						}  
						
		        		 cbd.setUsername(username);
		        		 cbd.setUserid(Long.parseLong(userid));
		        		 cbd.setHotelid(Long.parseLong(hotelid));
		        		 cbd.setHotelname(hotelname);
			//			session3.setAttribute("transid", transid);
						
					/*	if(transid == null){
							cbd.setTransID(1l);
							}
							else
							{
								cbd.setTransID(transid);	
							}*/
						
						cbd.setFkSupplierId(0l);
							
						System.out.println("In helper end where supp is not present in table - ");
						CashBookDao dao = new CashBookDao();
						dao.regstierCashBookEntry(cbd);
						break;
						
					}					
				}				
			}
			
			
			
		}
		
		/*
		 * Double NewpaymentAmountId = Double.valueOf(paymentAmountId);
		 * System.out.println("NewpaymentAmountId =="+NewpaymentAmountId);
		 * Double NewpayingAmountId = Double.valueOf(payingAmountId);
		 * System.out.println("NewpayingAmountId =="+NewpayingAmountId);
		 * 
		 * Double AfterPayment = Number(NewpaymentAmountId) -
		 * Number(payingAmountId);
		 */		


	}
// emp CB
	
	
//	Long transid;
	public void registerCashBookEntryemp(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		String waiterid = request.getParameter("waiterid");
		Long wID = Long.parseLong(waiterid);
		String payToId = request.getParameter("payToId");
		String toPayNameId = request.getParameter("toPayNameId");
		System.out.println("toPayNameId == = "+toPayNameId);
		String paymentDate = request.getParameter("paymentDate");
		String paymentTypeId = request.getParameter("paymentTypeId");
		String paymebtById = request.getParameter("paymebtById");
		String chequeNoId = request.getParameter("chequeNoId");
		String chequeDateId = request.getParameter("chequeDateId");
		String cardNoId = request.getParameter("cardNoId");
		String neftAccNoId = request.getParameter("neftAccNoId");
		String paymentAmountId = request.getParameter("paymentAmountId");
		String paymentReasonId = request.getParameter("paymentReasonId");
		System.out.println("in HELPER TOTAL PAYMENT AMOUNT is - "+paymentAmountId);
		String payingAmountId = request.getParameter("payingAmountId");
		System.out.println("in HELPER PAID AMOUNT IS: "+payingAmountId);
		String remainingBalance = request.getParameter("remainingBalance");
		System.out.println("remaining Amount is - "+remainingBalance);
		
//		Double remainAt = (Double.parseDouble(remainingBalance)) - (Double.parseDouble(payingAmountId));
//		System.out.println("Total amount -- paid amount is -- - - - - - Rs. "+remainAt);
		System.out.println("In helper register CashBook Entry method -- ");
	
	//	CashBookDao data = new CashBookDao();
	//	List stkList  = data.gettransID();
//		Long TransactionID = 1l;
		
		CashBookDao cbb = new CashBookDao();
		List clist = cbb.getAllsuppEntryemp(payToId,hotelid);
		
		if(clist.size()==0) 
	{
		CashBook cb = new CashBook();	
	//	HttpSession session3 = request.getSession();
		
		CashBookDao data = new CashBookDao();
		List stkList  = data.gettransID(request);
		
		for(int i=0;i<stkList.size();i++){
			
			CashBook st = (CashBook)stkList.get(i);
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
		if (!"".equals(payToId))
		{
			cb.setPayToId(payToId);
		}
		else 
		{
			cb.setPayToId("N/A");
		}
		
		if (!"".equals(toPayNameId)) 
		{
			System.out.println("toPayNameId if()");
			cb.setToPayNameId(toPayNameId);
		} 
		else 
			{
				System.out.println("toPayNameId else()");
				cb.setToPayNameId("N/A");
			}
		
 		cb.setUsername(username);
		cb.setUserid(Long.parseLong(userid));
		cb.setHotelid(Long.parseLong(hotelid));
		cb.setHotelname(hotelname);
		
		
		if (!"".equals(paymentDate)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date adate = null;
			try {
				adate = format.parse(paymentDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setPaymentDate(adate);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dammyDate = "00-00-0000";
			Date adate = null;
			try {
				adate = format.parse(dammyDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setPaymentDate(adate);
		}
		if (!"".equals(paymentTypeId)) {
			cb.setPaymentTypeId(paymentTypeId);
		} else {
			cb.setPaymentTypeId("N/A");
		}
		if (!"".equals(paymebtById)) {
			cb.setPaymebtById(paymebtById);
		} else {
			cb.setPaymebtById("N/A");
		}
		if (!"".equals(chequeNoId)) {
			cb.setChequeNoId(Long.parseLong(chequeNoId));
		} else {
			cb.setChequeNoId(0);
		}
		if (!"".equals(chequeDateId)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date adate = null;
			try {
				adate = format.parse(chequeDateId);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setChequeDateId(adate);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dammyDate = "00-00-0000";
			Date adate = null;
			try {
				adate = format.parse(dammyDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cb.setChequeDateId(adate);
		}

		if (!"".equals(cardNoId)) {
			cb.setCardNoId(Long.parseLong(cardNoId));
		} else {
			cb.setCardNoId(0);
		}

		if (!"".equals(neftAccNoId)) {
			cb.setNeftAccNoId(Long.parseLong(neftAccNoId));
		} else {
			cb.setNeftAccNoId(0);
		}

		if (!"".equals(paymentAmountId)) {
			cb.setPaymentAmountId(Double.parseDouble(paymentAmountId));
		} else {
			cb.setPaymentAmountId(0d);
		}
		
		if (!"".equals(payingAmountId)) {
			cb.setPayingAmountId(Double.parseDouble(payingAmountId));
		} else {
			cb.setPayingAmountId(0d);
		}
		
		if (!"".equals(paymentReasonId)) {
			cb.setPaymentReasonId(paymentReasonId);
		} else {
			cb.setPaymentReasonId("N/A");
		}
		
		if(!"".equals(remainingBalance)) {
			cb.setRemainingBalance(Double.parseDouble(remainingBalance));
			System.out.println(" remaining Amount balance set is  Rs. "+cb.getRemainingBalance());
		}
		else {
			cb.setRemainingBalance(0d);
		}  
		
		
/*		session3.setAttribute("transid", transid);
		
			if(transid == null){
			cb.setTransID(1l);
			}
			else
			{
			cb.setTransID(transid);	
			
			} */
		
		cb.setFkemployeeId(Long.parseLong(waiterid));
		cb.setFkSupplierId(0l);	
		System.out.println("waiter id set -    - "+cb.getFkemployeeId()+" supp id - "+cb.getFkSupplierId()+" employe type -  "+cb.getToPayNameId()+" ` ` if cond `` ");	
		System.out.println("In helper end");
		CashBookDao dao = new CashBookDao();
		dao.regstierCashBookEntry(cb);
		}
		
		else {
			HttpSession session4 = request.getSession();
			
			for(int i=0; i<clist.size(); i++) {
			   	com.rms.hibernate.CashBook st = (com.rms.hibernate.CashBook)clist.get(i);	
				transid = st.getTransID();
			/*	if(transid==null) {
					transid =1l;
				}*/
				transid++;
				session4.setAttribute("transid", transid);
				
				CashBookDao data = new CashBookDao();
				List stkList  = data.gettransID(request);
				
				for(int k=0;k<stkList.size();k++){
					
					CashBook st1 = (CashBook)stkList.get(k);
					transid = st1.getTransID();
					if(transid==null) {
						transid =1l;
					}
					System.out.println("tranID in helper - -   "+transid);
					transid++;
				}
//				cb.setTransID(transid);
//				System.out.println("trans set in helper - > "+cb.getTransID());
				
				
				
				Long pkID = st.getPkCashBookEntry();
				String ToPayNameId = st.getToPayNameId();
				Long empid = st.getFkemployeeId();
				System.out.println("pk id - "+pkID+" emp  - "+ToPayNameId+" waiter id -  - "+empid);
				if(empid.equals(wID)) {
					
					Double remain = st.getRemainingBalance();
					Double updatedremain = (double)(remain - Double.parseDouble(payingAmountId));
					
					 com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
	        		 Session session = hbu.getHibernateSession();
	        		 Transaction transaction = session.beginTransaction();
	        	
	        		 com.rms.hibernate.CashBook updateCB = (com.rms.hibernate.CashBook) session.get(com.rms.hibernate.CashBook.class, new Long(pkID));

	        		 updateCB.setRemainingBalance(updatedremain);
	        		 updateCB.setPayingAmountId(Double.parseDouble(payingAmountId));
	        		 updateCB.setUsername(username);
	        		 updateCB.setUserid(Long.parseLong(userid));
	        		 updateCB.setHotelid(Long.parseLong(hotelid));
	        		 updateCB.setHotelname(hotelname);
	        		 if(!"".equals(paymentDate))
	        		 {
	        			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        				Date adate = null;
	        				try {
	        					adate = format.parse(paymentDate);
	        				} catch (ParseException e1) {
	        					// TODO Auto-generated catch block
	        					e1.printStackTrace();
	        				}
	        				updateCB.setPaymentDate(adate);
	        		 }
	        		 else 
	        		 {
	        			 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        			 Date cd = null;
	        			 try {
	        					
	     					
	     					Date dateobj = new Date();
	     					 String CurrentDate = df.format(dateobj);
	     					 System.out.println("Today's date  -- > "+CurrentDate);
	     					  cd = df.parse(CurrentDate);
	     					updateCB.setPaymentDate(cd);
	     			}
	     			catch(ParseException e) {
	     				e.printStackTrace();
	     			}
	        		 }
	        	/*	 if(transid == null){
	 					updateCB.setTransID(1l);
	 					}
	 					else
	 					{*/
	 						updateCB.setTransID(transid);	
	 			//		}
	        			System.out.println("trans set in helper - > when same waiter present - - -     "+updateCB.getTransID());
	        			System.out.println("pay date set is - `````` - "+updateCB.getPaymentDate());
	        			//		 updateCB.setToPayNameId(toPayNameId);
	        		 session.saveOrUpdate(updateCB);
	        		 System.out.println("if supp present in cashbook update Bal is  OBJ saved ! - - "+updateCB.getRemainingBalance()+" transaction id is - - > "+updateCB.getTransID());
	        		 transaction.commit();
	        		 break;
				}
				
				else {
					if(i+1==clist.size()) {
					
						CashBook cbd = new CashBook();
						
		//				HttpSession session3 = request.getSession();
						
						CashBookDao dataa = new CashBookDao();
						List stkListt  = data.gettransID(request);
						
						for(int l=0; l<stkListt.size(); l++){
							
							CashBook stt = (CashBook)stkListt.get(l);
							transid = stt.getTransID();
						/*	if(transid==null) {
								transid =1l;
							}*/
							transid++;
						}
						cbd.setTransID(transid);
						System.out.println("trans set in helper - > "+cbd.getTransID());
						
						if (!"".equals(payToId))
						{
							cbd.setPayToId(payToId);
						}
						else 
						{
							cbd.setPayToId("N/A");
						}
						
						if (!"".equals(toPayNameId)) 
						{
							System.out.println("toPayNameId if()");
							cbd.setToPayNameId(toPayNameId);
						} 
						else 
							{
								System.out.println("toPayNameId else()");
								cbd.setToPayNameId("N/A");
							}
						
						 cbd.setUsername(username);
		        		 cbd.setUserid(Long.parseLong(userid));
		        		 cbd.setHotelid(Long.parseLong(hotelid));
		        		 cbd.setHotelname(hotelname);
						
						
						if (!"".equals(paymentDate)) {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							Date adate = null;
							try {
								adate = format.parse(paymentDate);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							cbd.setPaymentDate(adate);
						} else {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							String dammyDate = "00-00-0000";
							Date adate = null;
							try {
								adate = format.parse(dammyDate);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							cbd.setPaymentDate(adate);
						}
						if (!"".equals(paymentTypeId)) {
							cbd.setPaymentTypeId(paymentTypeId);
						} else {
							cbd.setPaymentTypeId("N/A");
						}
						if (!"".equals(paymebtById)) {
							cbd.setPaymebtById(paymebtById);
						} else {
							cbd.setPaymebtById("N/A");
						}
						if (!"".equals(chequeNoId)) {
							cbd.setChequeNoId(Long.parseLong(chequeNoId));
						} else {
							cbd.setChequeNoId(0);
						}
						if (!"".equals(chequeDateId)) {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							Date adate = null;
							try {
								adate = format.parse(chequeDateId);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							cbd.setChequeDateId(adate);
						} else {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							String dammyDate = "00-00-0000";
							Date adate = null;
							try {
								adate = format.parse(dammyDate);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							cbd.setChequeDateId(adate);
						}

						if (!"".equals(cardNoId)) {
							cbd.setCardNoId(Long.parseLong(cardNoId));
						} else {
							cbd.setCardNoId(0);
						}

						if (!"".equals(neftAccNoId)) {
							cbd.setNeftAccNoId(Long.parseLong(neftAccNoId));
						} else {
							cbd.setNeftAccNoId(0);
						}

						if (!"".equals(paymentAmountId)) {
							cbd.setPaymentAmountId(Double.parseDouble(paymentAmountId));
						} else {
							cbd.setPaymentAmountId(0d);
						}
						
						if (!"".equals(payingAmountId)) {
							cbd.setPayingAmountId(Double.parseDouble(payingAmountId));
						} else {
							cbd.setPayingAmountId(0d);
						}
						
						if (!"".equals(paymentReasonId)) {
							cbd.setPaymentReasonId(paymentReasonId);
						} else {
							cbd.setPaymentReasonId("N/A");
						}
						
						if(!"".equals(remainingBalance)) {
							cbd.setRemainingBalance(Double.parseDouble(remainingBalance));
							System.out.println(" remaining Amount balance set is  Rs. "+cbd.getRemainingBalance());
						}
						else {
							cbd.setRemainingBalance(0d);
						}  
						
						
			//			session3.setAttribute("transid", transid);
						
					/*	if(transid == null){
							cbd.setTransID(1l);
							}
							else
							{
								cbd.setTransID(transid);	
							}*/
						cbd.setFkemployeeId(Long.parseLong(waiterid));
						cbd.setFkSupplierId(0l);
						System.out.println("waiter id set -    - "+cbd.getFkemployeeId()+" supp id - "+cbd.getFkSupplierId()+" employe type -  "+cbd.getToPayNameId());	
						System.out.println("In helper end where supp is not present in table - ");
						CashBookDao dao = new CashBookDao();
						dao.regstierCashBookEntry(cbd);
						break;
						
					}					
				}				
			}
			
			
			
		}
		
		/*
		 * Double NewpaymentAmountId = Double.valueOf(paymentAmountId);
		 * System.out.println("NewpaymentAmountId =="+NewpaymentAmountId);
		 * Double NewpayingAmountId = Double.valueOf(payingAmountId);
		 * System.out.println("NewpayingAmountId =="+NewpayingAmountId);
		 * 
		 * Double AfterPayment = Number(NewpaymentAmountId) -
		 * Number(payingAmountId);
		 */		


	}
	
	
	
	public Map getTotalAmtSupplier(String supplier, HttpServletRequest request) 
	{
		
		
		Double totbalAmt = 0.0;
		Double totAmt = 0.0;
		CashBookDao dao = new CashBookDao();
		List list = dao.getTotalAmtByForSupplier(supplier,request);
		Map map = new HashMap();

//		GoodsReceiveHibernate bean = new GoodsReceiveHibernate();
		CashBook bean = new CashBook();
		for (int i = 0; i < list.size(); i++) 
		{
			Object[] o = (Object[]) list.get(i);
		
			
			bean.setFkSupplierId(Long.parseLong(o[0].toString()));
			bean.setPaymentAmountId(Double.parseDouble(o[1].toString()));
			bean.setRemainingBalance(Double.parseDouble(o[2].toString()));
			System.out.println("~~~~~~~~~ ~~~~~~ ~~~~~ pk supp ID -- "+bean.getFkSupplierId()+" & total amount is - - "+bean.getPaymentAmountId()+" remaining balance - - "+bean.getRemainingBalance());
		}
		map.put(bean.getFkSupplierId(), bean);
		return map;
	}
// emp CB
	
	public Map getEmpTotalAmtSupplier(String employee, HttpServletRequest request) 
	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		Double totbalAmt = 0.0;
		Double totAmt = 0.0;
		CashBookDao dao = new CashBookDao();
		List list = dao.getEmpTotalAmtByForSupplier(employee,hotelid);
		Map map = new HashMap();

//		GoodsReceiveHibernate bean = new GoodsReceiveHibernate();
		CashBook bean = new CashBook();
		for (int i = 0; i < list.size(); i++) 
		{
			Object[] o = (Object[]) list.get(i);
		
			System.out.println("result - "+Arrays.toString(o));
			bean.setFkSupplierId(Long.parseLong(o[0].toString()));
			bean.setPaymentAmountId(Double.parseDouble(o[1].toString()));
			bean.setRemainingBalance(Double.parseDouble(o[2].toString()));
			System.out.println("~~~~~~~~~ ~~~~~~ ~~~~~ pk supp ID -- "+bean.getFkSupplierId()+" & total amount is - - "+bean.getPaymentAmountId()+" remaining balance - - "+bean.getRemainingBalance());
		}
		map.put(bean.getFkSupplierId(), bean);
		return map;
	}
	
		public List getpaymentDateWiseReport(HttpServletRequest request,
			HttpServletResponse response) {
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
		    String cashbookDate = request.getParameter("cashbookDate");
	        Map<Long,CashBook> map = new HashMap<Long,CashBook>();
			
	        CashBookDao dao = new CashBookDao();
			List<CashBook> exp1List = dao.getpaymentDateWiseReport(cashbookDate,hotelid,usertype);
			
			return exp1List;
	}
		//supp range 
		public List getpaymentRangeWiseReport(HttpServletRequest request,
				HttpServletResponse response) {
				
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			    String datefrom = request.getParameter("datefrom");
			    String dateto = request.getParameter("dateto");
			    System.out.println("datefrm & date to - "+datefrom+" , "+dateto);
			    Map<Long,CashBook> map = new HashMap<Long,CashBook>();
				
		        CashBookDao dao = new CashBookDao();
				List<CashBook> exp1List = dao.getpaymentRangeWiseReport(datefrom,dateto,hotelid,usertype);
				
				return exp1List;
		}
		public List getpaymentsupplierReport(HttpServletRequest request, HttpServletResponse response) {
			
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
			    String cashbooksupp = request.getParameter("cashbooksupp");
		        Map<Long,CashBook> map = new HashMap<Long,CashBook>();
				
		        CashBookDao dao = new CashBookDao();
				List<CashBook> exp1List = dao.getpaymentsupplierReport(cashbooksupp,hotelid,usertype);
				
				return exp1List;
		}
	
		// employee date wise
		public List getEmppaymentsupplierReport(HttpServletRequest request, HttpServletResponse response) {
				
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
		    String cashbookempDate = request.getParameter("cashbookempDate");
	        Map<Long,CashBook> map = new HashMap<Long,CashBook>();
			
	        CashBookDao dao = new CashBookDao();
			List<CashBook> exp1List = dao.getEmppaymentsupplierReport(cashbookempDate,hotelid,usertype);
			
			return exp1List;
	}
		// employee name wise
		public List getEmppaymentSuppWiseReport(HttpServletRequest request, HttpServletResponse response) {
			
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
		    String cashbookemp = request.getParameter("cashbookemp");
	        Map<Long,CashBook> map = new HashMap<Long,CashBook>();
			
	        CashBookDao dao = new CashBookDao();
			List<CashBook> exp1List = dao.getEmppaymentSuppWiseReport(cashbookemp,hotelid,usertype);
			
			return exp1List;
	}
		//emp rangewise
		public List getEmppaymentSuppRangeWiseReport1(HttpServletRequest request, HttpServletResponse response) {
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" usertypee - "+usertype+"  - in getEmppaymentSuppRangeWiseReport()");
			
		    String datefrom = request.getParameter("datefrom");
		    String dateto = request.getParameter("dateto");
		    Map<Long,CashBook> map = new HashMap<Long,CashBook>();
			System.out.println("getEmppaymentSuppRangeWiseReport1 - date from - date to - "+datefrom+"  - -   "+dateto);
	        CashBookDao dao = new CashBookDao();
			List<CashBook> exp1List = dao.getEmppaymentSuppRangeWiseReport1(datefrom,dateto,hotelid,usertype);
			
			return exp1List;
	}
		
		// debit report
		
		public List getdebitDateWiseReport(HttpServletRequest request, HttpServletResponse response) {
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" ad - "+usertype);
			
			String debitdatefrm = request.getParameter("debitdatefrm");
			String debitdateto = request.getParameter("debitdateto");
			System.out.println("credit receive date ----  "+debitdatefrm+" & "+debitdateto);
			Map<Long,CashBook> map = new HashMap<Long,CashBook>();
			
	        CashBookDao dao = new CashBookDao();
	        List<CashBook> catList = dao.getdebitDateWiseReport(debitdatefrm, debitdateto, hotelid,usertype);
	        return catList;
		}
		//bank trans
		
		public void banktransactionEntry(HttpServletRequest request, HttpServletResponse response) {
			

			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname = (String)sessionn.getAttribute("hotelname");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
//			String payToId = request.getParameter("payToId");
			
			String  bankname = request.getParameter("bankname"); 
			String datee =	request.getParameter("datee");
			String contactno = request.getParameter("contactno");
			System.out.println("toPayNameId == = ");
			String paymentType = request.getParameter("paymentType");
			
/*			String paymentById = request.getParameter("paymentById");
			String chequeNoId = request.getParameter("chequeNoId");
			String chequeDateId = request.getParameter("chequeDateId");
			String cardNoId = request.getParameter("cardNoId");
			String neftAccNoId = request.getParameter("neftAccNoId");*/
			
			String accountname = request.getParameter("accountname");
			String amount = request.getParameter("amount");
			
			System.out.println("in HELPER paymentType "+paymentType+" ");
			System.out.println("in HELPER PAID AMOUNT IS: ");
			System.out.println("remaining Amount is - ");
			
//			Double remainAt = (Double.parseDouble(remainingBalance)) - (Double.parseDouble(payingAmountId));
//			System.out.println("Total amount -- paid amount is -- - - - - - Rs. "+remainAt);
			System.out.println("In helper register CashBook Entry method -- ");
		
			
			banktransaction cb = new banktransaction();	
			
			CashBookDao data = new CashBookDao();
			List stkList  = data.gettransIDforbank(request);
			
			for(int i=0;i<stkList.size();i++){
				
				banktransaction st = (banktransaction)stkList.get(i);
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

			
			
			if (!"".equals(bankname))
			{
				cb.setBankname(bankname);
			}
			else 
			{
				cb.setBankname("N/A");
			}
			
			if (!"".equals(contactno)) 
			{
				System.out.println("toPayNameId if()");
				cb.setContactno(Double.parseDouble(contactno));
			} 
			else 
				{
//					System.out.println("toPayNameId else()");
					cb.setContactno(0d);
				}
			
	/*		if (!"".equals(bankname))
			{
				cb.setBankname(bankname);
			}
			else 
			{
				cb.setBankname("N/A");
			}
			if (!"".equals(bankname))
			{
				cb.setBankname(bankname);
			}
			else 
			{
				cb.setBankname("N/A");
			}
			*/
			
			cb.setUsername(username);
			cb.setUserid(Long.parseLong(userid));
			cb.setHotelid(Long.parseLong(hotelid));
			cb.setHotelname(hotelname);
			cb.setPaymentType(paymentType);
			
			
			if (!"".equals(datee)) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date adate = null;
				try {
					adate = format.parse(datee);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cb.setDatee(adate);
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String dammyDate = "00-00-0000";
				Date adate = null;
				try {
					adate = format.parse(dammyDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cb.setDatee(adate);
			}


			if(!"".equals(accountname)) {
				cb.setAccountname(accountname);
			}
			else {
				cb.setAccountname("NA");
			}
			if(!"".equals(amount)) {
				cb.setAmount(Double.parseDouble(amount));
			}
			else {
				cb.setAmount(0d);
			}
			CashBookDao dao = new CashBookDao();
			dao.regstierbankEntry(cb);	
		}
		
		//add bank
		public void addbankdetails(HttpServletRequest request, HttpServletResponse response) {
			

			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname = (String)sessionn.getAttribute("hotelname");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
			String  bankname = request.getParameter("bankname"); 
			String branchname = request.getParameter("branchname");
			String contactno = request.getParameter("contactno");
			System.out.println("toPayNameId == = ");
			
			String accountname = request.getParameter("accountname");
			String accountnum = request.getParameter("accountnum");
			String ifsccode = request.getParameter("ifsccode");
			

			System.out.println("in HELPER accountnum "+accountnum);
			System.out.println("remaining Amount is - ");
			
			System.out.println("In helper add bank method -- ");
		
			
			bankdetailHibernate cb = new bankdetailHibernate();	
			
	/*		CashBookDao data = new CashBookDao();
			List stkList  = data.gettransIDforbank(request);
			
			for(int i=0;i<stkList.size();i++){
				
				banktransaction st = (banktransaction)stkList.get(i);
				transid = st.getTransID();
				
				System.out.println("tranID in helper - -   "+transid);
				transid++;
			}
			if(transid == null) {
				cb.setTransID(1l);
			} else {
			cb.setTransID(transid);
			System.out.println("trans set set in helper - > "+cb.getTransID());
			}*/

			
			
			if (!"".equals(bankname))
			{
				cb.setBankname(bankname);
			}
			else 
			{
				cb.setBankname("N/A");
			}
			
			if (!"".equals(branchname))
			{
				cb.setBranchname(branchname);
			}
			else 
			{
				cb.setBranchname("N/A");
			}
			if (!"".equals(contactno)) 
			{
				System.out.println("toPayNameId if()");
				cb.setContactno(Long.parseLong(contactno));
			} 
			else 
				{
//					System.out.println("toPayNameId else()");
					cb.setContactno(0l);
				}
			
			if (!"".equals(accountnum))
			{
				cb.setAccountnum(Long.parseLong(accountnum));
			}
			else 
			{
				cb.setAccountnum(0l);
			}

			if (!"".equals(ifsccode))
			{
				cb.setIfsccode(Long.parseLong(ifsccode));
			}
			else 
			{
				cb.setIfsccode(0l);
			}
			
			if(!"".equals(accountname)) {
				cb.setAccountname(accountname);
			}
			else {
				cb.setAccountname("NA");
			}
		
			cb.setUsername(username);
			cb.setUserid(Long.parseLong(userid));
			cb.setHotelid(Long.parseLong(hotelid));
			cb.setHotelname(hotelname);


	
			CashBookDao dao = new CashBookDao();
			dao.addbankdetail(cb);	
		}
		   //exp payment
		
		public void addexpenditurepayment(HttpServletRequest request, HttpServletResponse response) {
			

			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname = (String)sessionn.getAttribute("hotelname");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
//			String payToId = request.getParameter("payToId");
			
			String expenditurename = request.getParameter("expenditurename"); 
			String paymentdate =	request.getParameter("paymentdate");
			String expenditureamount = request.getParameter("expenditureamount");
			System.out.println("addexpenditurepayment() ");
			String paymentById = request.getParameter("paymentById");
			
/*			String paymentById = request.getParameter("paymentById");*/
			String chequeNoId = request.getParameter("chequeNoId");
			String chequeDateId = request.getParameter("chequeDateId");
			String cardNoId = request.getParameter("cardNoId");
			String neftAccNoId = request.getParameter("neftAccNoId");
			
			System.out.println("in HELPER paymentById "+paymentById+" ");
			System.out.println("in HELPER PAID AMOUNT IS: ");
			System.out.println("remaining Amount is - ");
			
//			Double remainAt = (Double.parseDouble(remainingBalance)) - (Double.parseDouble(payingAmountId));
//			System.out.println("Total amount -- paid amount is -- - - - - - Rs. "+remainAt);
			System.out.println("In helper register CashBook Entry method -- ");
		
			
			expenditurepaymentHibernate cb = new expenditurepaymentHibernate();	
			
			CashBookDao data = new CashBookDao();
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

			
			
			if (!"".equals(expenditurename))
			{
				cb.setExpenditurename(expenditurename);
			}
			else 
			{
				cb.setExpenditurename("N/A");
			}
			
			if (!"".equals(expenditureamount)) 
			{
				System.out.println("toPayNameId if()");
				cb.setExpenditureamount(Double.parseDouble(expenditureamount));
			} 
			else 
				{
//					System.out.println("toPayNameId else()");
					cb.setExpenditureamount(0d);
				}
			if (!"".equals(paymentdate)) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date adate = null;
				try {
					adate = format.parse(paymentdate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cb.setPaymentdate(adate);
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String dammyDate = "00-00-0000";
				Date adate = null;
				try {
					adate = format.parse(dammyDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cb.setPaymentdate(adate);
			}
			
			
			
			if (!"".equals(paymentById))
			{
				cb.setPaymentById(paymentById);
			}
			else 
			{
				cb.setPaymentById("N/A");
			}
			if (!"".equals(chequeNoId))
			{
				cb.setChequeNoId(Long.parseLong(chequeNoId));
			}
			else 
			{
				cb.setChequeNoId(0l);
			}
			
			
			cb.setUsername(username);
			cb.setUserid(Long.parseLong(userid));
			cb.setHotelid(Long.parseLong(hotelid));
			cb.setHotelname(hotelname);
//			cb.setPaymentType(paymentType);
			
			
			if (!"".equals(chequeDateId)) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date adate = null;
				try {
					adate = format.parse(chequeDateId);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cb.setChequeDateId(adate);
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String dammyDate = "00-00-0000";
				Date adate = null;
				try {
					adate = format.parse(dammyDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cb.setChequeDateId(adate);
			}


			if(!"".equals(cardNoId)) {
				cb.setCardNoId(Long.parseLong(cardNoId));
			}
			else {
				cb.setCardNoId(0l);
			}
			if(!"".equals(neftAccNoId)) {
				cb.setNeftAccNoId((Long.parseLong(neftAccNoId)));
			}
			else {
				cb.setNeftAccNoId(0l);
			}
			CashBookDao dao = new CashBookDao();
			dao.expenditurepayment(cb);	
		}
		
	//add expenditure
			
			public void addexpenditure(HttpServletRequest request, HttpServletResponse response) {
				

				HttpSession sessionn = request.getSession(true);
				String username = (String)sessionn.getAttribute("user");		
				String userid = (String)sessionn.getAttribute("userid");
				String hotelid = (String)sessionn.getAttribute("hotelid");
				String hotelname = (String)sessionn.getAttribute("hotelname");
				System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
				
				String expenditurename = request.getParameter("expenditurename"); 
				System.out.println("expenditurename - "+expenditurename);
				
				expenditureHibernate cb = new expenditureHibernate();				
				
				if (!"".equals(expenditurename))
				{
					cb.setExpenditurename(expenditurename);
				}
				else 
				{
					cb.setExpenditurename("N/A");
				}
				
				
				cb.setUsername(username);
				cb.setUserid(Long.parseLong(userid));
				cb.setHotelid(Long.parseLong(hotelid));
				cb.setHotelname(hotelname);

				CashBookDao dao = new CashBookDao();
				dao.addexpenditure(cb);	
			}
			
			
}
