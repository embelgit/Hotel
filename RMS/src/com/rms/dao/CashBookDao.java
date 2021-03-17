package com.rms.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.OrderBillReportDateWiseBean;
import com.rms.bean.TotalCashBookReport;
import com.rms.hibernate.CashBook;
import com.rms.hibernate.CustomerOrder;
import com.rms.hibernate.ItemEntry;
import com.rms.hibernate.Stock;
import com.rms.hibernate.SupplierDetailsHibernate;
import com.rms.hibernate.banktransaction;
import com.rms.hibernate.expenditureHibernate;
import com.rms.utility.HibernateUtility;
import com.rms.hibernate.bankdetailHibernate;
import com.rms.hibernate.expenditurepaymentHibernate;

public class CashBookDao {
	
public void regstierCashBookEntry(CashBook cb) {
		
		
		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
		 
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date date = new Date();
		 System.out.println(df.format(date));

		session.save(cb);
		transaction.commit();
		}
		
		catch(RuntimeException e){
			try{
				transaction.rollback();
			}catch(Exception rbe)
			{
				rbe.printStackTrace();
			}	
		}finally{
		hbu.closeSession(session);
		}
		
	}
//bank tran
public void regstierbankEntry(banktransaction cb) {
	
	
	HibernateUtility hbu=null;
	Session session=null;
	Transaction transaction=null;
	
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 transaction = session.beginTransaction();
	 
	 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	 Date date = new Date();
	 System.out.println(df.format(date));
	 System.out.println("b4 saving obj");
	session.save(cb);
	transaction.commit();
	}
	
	catch(RuntimeException e){
		try{
			transaction.rollback();
		}catch(Exception rbe)
		{
			rbe.printStackTrace();
		}	
	}finally{
	hbu.closeSession(session);
	}
	
}

//add bank detail

public void addbankdetail(bankdetailHibernate cb) {
	
	
	HibernateUtility hbu=null;
	Session session=null;
	Transaction transaction=null;
	
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 transaction = session.beginTransaction();
	 
	 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	 Date date = new Date();
	 System.out.println(df.format(date));
	 System.out.println("b4 saving obj");
	session.save(cb);
	transaction.commit();
	}
	
	catch(RuntimeException e){
		try{
			transaction.rollback();
		}catch(Exception rbe)
		{
			rbe.printStackTrace();
		}	
	}finally{
	hbu.closeSession(session);
	}
	
}
//exp payment
public void expenditurepayment(expenditurepaymentHibernate cb) {
	
	
	HibernateUtility hbu=null;
	Session session=null;
	Transaction transaction=null;
	
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 transaction = session.beginTransaction();
	 
	 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	 Date date = new Date();
	 System.out.println(df.format(date));
	 System.out.println("b4 saving obj");
	session.save(cb);
	transaction.commit();
	}
	
	catch(RuntimeException e){
		try{
			transaction.rollback();
		}catch(Exception rbe)
		{
			rbe.printStackTrace();
		}	
	}finally{
	hbu.closeSession(session);
	}
	
}
//add expenditure
public void addexpenditure(expenditureHibernate cb) {
	
	
	HibernateUtility hbu=null;
	Session session=null;
	Transaction transaction=null;
	
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 transaction = session.beginTransaction();
	 
	 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	 Date date = new Date();
	 System.out.println(df.format(date));
	 System.out.println("b4 saving obj");
	session.save(cb);
	transaction.commit();
	}
	
	catch(RuntimeException e){
		try{
			transaction.rollback();
		}catch(Exception rbe)
		{
			rbe.printStackTrace();
		}	
	}finally{
	hbu.closeSession(session);
	}
	
}
// exp name list
public List getAllexpenditureForList(HttpServletRequest request){
	 HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
	  	
		HibernateUtility hbu=null;
		Session session=null;
		List<expenditureHibernate> custList=null;
	try{	

		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();

		Query query=session.createSQLQuery("select pk_exp_id, expenditurename from expenditures where hotelid ='"+hotelid+"'");
		List<Object[]> list = query.list();

		custList= new ArrayList<expenditureHibernate>(0);

		int sr=0;
	for (Object[] object : list) {	
		sr++;
		expenditureHibernate rp = new expenditureHibernate();
		rp.setPk_expid(Long.parseLong(object[0].toString()));
		rp.setExpenditurename(object[1].toString());
		rp.setSr(sr);
		custList.add(rp);
		
	}}catch(RuntimeException e){	

	}
	finally{

	hbu.closeSession(session);	
	}
	return custList;

}

public List getEmployeeNameByToPay()
{
	
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
//			Query query = session.createQuery("from EmployeeDetail");
			Query query = session.createQuery("from AddWaiters");
			list = query.list();
			System.out.println("waiters ----------  "+list.size());
		}
			catch(Exception e)
			{	
					e.printStackTrace();
		}
		finally	{
					if(session!=null)
					{
						hbu.closeSession(session);
					}
		}
		
		return list;
	
	}

//This is getSupplierNameByToPay() used to get dynamic supplier name into to pay name

public List getSupplierNameByToPay()
{
	
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
	//		Query query = session.createQuery("from SupplierDetails");
			Query query = session.createQuery("from SupplierDetailsHibernate");
			list = query.list();
			System.out.println("supp -----------   "+list.size());
		}
			catch(RuntimeException e)
			{	
				e.printStackTrace();
		}
		finally	{
					if(session!=null)
					{
						hbu.closeSession(session);
					}
		}
		
		return list;
	
	}


public List getCustomerNameByToPay()
{
	
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
		try
		{
			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();
			Query query = session.createQuery("from CreditCustomerDetails");
			list = query.list();
		}
			catch(RuntimeException e)
			{	
				e.printStackTrace();
		}
		finally	{
					if(session!=null)
					{
						hbu.closeSession(session);
					}
		}
		
		return list;
	
	}


/*
 * Name: Meghraj Menkudle
 * Date: 11-4-17
 * method:getTotalCashBookReport()
 * Reason: Get the report of all customer supplier CAshbook
 */
	
public List getTotalCashBookReport(){
	
	HibernateUtility hbu=null;
	Session session=null;
	List<TotalCashBookReport> cashbooklist=null;
try{	

	hbu = HibernateUtility.getInstance();
	session = hbu.getHibernateSession();

	Query query=session.createSQLQuery("select name,to_pay,paymentType, paymentBy, chequeNo, chequeDate, cardNo, neftAcNo, amount, reason from cash_book;");
	
	List<Object[]> list = query.list();


	cashbooklist= new ArrayList<TotalCashBookReport>(0);


for (Object[] object : list) {	
	TotalCashBookReport reports = new TotalCashBookReport();
	
	System.out.println("RAJJ"+Arrays.toString(object));
	
	reports.setName(object[0].toString());
	reports.setCustType(object[1].toString());	
	reports.setPaymentType(object[2].toString());
	reports.setPaymentBy(object[3].toString());
	reports.setChequeNo(Double.parseDouble(object[4].toString()));	
	reports.setChequeDate(object[5].toString());
	reports.setCardNo(Double.parseDouble(object[6].toString()));
	reports.setNeftAccNo(Double.parseDouble(object[7].toString()));
	reports.setAmount(Double.parseDouble(object[8].toString()));
	reports.setReason(object[9].toString());
	
	
	cashbooklist.add(reports);

}}catch(RuntimeException e){	

}
finally{

hbu.closeSession(session);	
}
return cashbooklist;
}


public List getCashBookReports(String customerType) {
	// TODO Auto-generated method stub
	
	HibernateUtility hbu=null;
	Session session=null;
	List<TotalCashBookReport> cashbooklist=null;
	
	
try{	

	hbu = HibernateUtility.getInstance();
	session = hbu.getHibernateSession();
	
	Query query=session.createSQLQuery("select name,to_pay,paymentType, paymentBy, chequeNo, chequeDate, cardNo, neftAcNo, amount, reason from cash_book where to_pay='"+ customerType +"';");
	
	//Query query = session.createQuery("from PurchaseBill2");
	List<Object[]> list = query.list();


	cashbooklist= new ArrayList<TotalCashBookReport>(0);


for (Object[] object : list) {	
	TotalCashBookReport reports = new TotalCashBookReport();
	
	System.out.println("RAJJ"+Arrays.toString(object));
	
	System.out.println(Arrays.toString(object));
	
	reports.setName(object[0].toString());
	reports.setCustType(object[1].toString());	
	reports.setPaymentType(object[2].toString());
	reports.setPaymentBy(object[3].toString());
	reports.setChequeNo(Double.parseDouble(object[4].toString()));	
	reports.setChequeDate(object[5].toString());
	reports.setCardNo(Double.parseDouble(object[6].toString()));
	reports.setNeftAccNo(Double.parseDouble(object[7].toString()));
	reports.setAmount(Double.parseDouble(object[8].toString()));
	reports.setReason(object[9].toString());
	
	
	cashbooklist.add(reports);

}}catch(RuntimeException e){	

}
finally{

hbu.closeSession(session);	
}
return cashbooklist;
	
}
	

public List getOneDayPaymentReport(String reportDate) {
	// TODO Auto-generated method stub
	
	HibernateUtility hbu=null;
	Session session=null;
	List<TotalCashBookReport> paymentList=null;
	
	String date = reportDate;
	
try{	

	hbu = HibernateUtility.getInstance();
	session = hbu.getHibernateSession();
	
	/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
*/
	System.out.println(date);
	Query query=session.createSQLQuery("select name,to_pay,paymentType, paymentBy, chequeNo, chequeDate, cardNo, neftAcNo, amount, reason from cash_book where paymentDate='"+date+"';");
	//Query query = session.createQuery("from PurchaseBill2");
	List<Object[]> list = query.list();


	paymentList= new ArrayList<TotalCashBookReport>(0);


for (Object[] object : list) {	
	TotalCashBookReport reports = new TotalCashBookReport();
	
	System.out.println("RAJJ"+Arrays.toString(object));
	
	System.out.println(Arrays.toString(object));
	
	reports.setName(object[0].toString());
	reports.setCustType(object[1].toString());	
	reports.setPaymentType(object[2].toString());
	reports.setPaymentBy(object[3].toString());
	reports.setChequeNo(Double.parseDouble(object[4].toString()));	
	reports.setChequeDate(object[5].toString());
	reports.setCardNo(Double.parseDouble(object[6].toString()));
	reports.setNeftAccNo(Double.parseDouble(object[7].toString()));
	reports.setAmount(Double.parseDouble(object[8].toString()));
	reports.setReason(object[9].toString());
	
	
	paymentList.add(reports);

}}catch(RuntimeException e){	

}
finally{

hbu.closeSession(session);	
}
return paymentList;
	
}




public List twoDayPaymentReport(String reportDate1, String reportDate2) {
	// TODO Auto-generated method stub
	
	HibernateUtility hbu=null;
	Session session=null;
	List<TotalCashBookReport> cashPaymentList=null;
	
	String date1 = reportDate1;
	String date2 = reportDate2;
	
try{	

	hbu = HibernateUtility.getInstance();
	session = hbu.getHibernateSession();
	
	
	System.out.println(date1);
	System.out.println(date2);
	Query query=session.createSQLQuery("select name,to_pay,paymentType, paymentBy, chequeNo, chequeDate, cardNo, neftAcNo, amount, reason from cash_book where paymentDate between '"+date1+"' AND '"+date2+"';");
	//Query query = session.createQuery("from PurchaseBill2");
	List<Object[]> list = query.list();


	cashPaymentList= new ArrayList<TotalCashBookReport>(0);


for (Object[] object : list) {	
	TotalCashBookReport reports = new TotalCashBookReport();
	
	System.out.println("RAJJ"+Arrays.toString(object));
	
	System.out.println(Arrays.toString(object));
	
	
	reports.setName(object[0].toString());
	reports.setCustType(object[1].toString());	
	reports.setPaymentType(object[2].toString());
	reports.setPaymentBy(object[3].toString());
	reports.setChequeNo(Double.parseDouble(object[4].toString()));	
	reports.setChequeDate(object[5].toString());
	reports.setCardNo(Double.parseDouble(object[6].toString()));
	reports.setNeftAccNo(Double.parseDouble(object[7].toString()));
	reports.setAmount(Double.parseDouble(object[8].toString()));
	reports.setReason(object[9].toString());
	
	
	cashPaymentList.add(reports);

}}catch(RuntimeException e){	

}
finally{

hbu.closeSession(session);	
}
return cashPaymentList;
	
}

// cash book single date

public List<CashBook> singleDateCashBook(Date adate) {
	// TODO Auto-generated method stub
	HibernateUtility hbu=null;
	Session session=null;
	List<CashBook> catList=null;
	try
	{
		hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 Query query2 = session.createQuery("select payToId, toPayNameId, paymentTypeId, paymebtById, paymentAmountId, paymentReasonId, paymentDate from CashBook where paymentDate=:adate");
	 query2.setParameter("adate", adate);
        List<Object[]> list = query2.list();
        catList= new ArrayList<CashBook>(0);
		
		
		for (Object[] object : list) {
				
			CashBook reports = new CashBook();
			
			reports.setPayToId(object[0].toString());
			reports.setToPayNameId(object[1].toString());
			reports.setPaymentTypeId(object[2].toString());
			reports.setPaymebtById(object[3].toString());
			reports.setPaymentAmountId(Double.parseDouble(object[4].toString()));
			reports.setPaymentReasonId(object[5].toString());
			reports.setPaymentDate1(object[6].toString());
			
			catList.add(reports); 
	
		}}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return catList;
}


// cash book between two dates
public List<CashBook> cashBookReportBetweenTwoDates(Date adate, Date bdate) {
	// TODO Auto-generated method stub
	HibernateUtility hbu=null;
	Session session=null;
	List<CashBook> catList=null;
	try
	{
		hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 Query query2 = session.createQuery("select payToId, toPayNameId, paymentTypeId, paymebtById, paymentAmountId, paymentReasonId, paymentDate from CashBook where paymentDate BETWEEN :adate AND :bdate");
	 query2.setParameter("adate", adate);
	 query2.setParameter("bdate", bdate);
        List<Object[]> list = query2.list();
        catList= new ArrayList<CashBook>(0);
		
		
		for (Object[] object : list) {
				
			CashBook reports = new CashBook();
			
			reports.setPayToId(object[0].toString());
			reports.setToPayNameId(object[1].toString());
			reports.setPaymentTypeId(object[2].toString());
			reports.setPaymebtById(object[3].toString());
			reports.setPaymentAmountId(Double.parseDouble(object[4].toString()));
			reports.setPaymentReasonId(object[5].toString());
			reports.setPaymentDate1(object[6].toString());
			
			catList.add(reports); 
	
		}}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return catList;
}

public List getTotalAmtByForSupplier(String supplier, HttpServletRequest request) 
{
	
	HttpSession sessionn = request.getSession(true);
	String username = (String)sessionn.getAttribute("user");		
	String userid = (String)sessionn.getAttribute("userid");
	String hotelid = (String)sessionn.getAttribute("hotelid");
	String hotelname=(String)sessionn.getAttribute("hotelname");
	System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
	
	 HibernateUtility hbu = null ;
	 Session session = null;
	 List list  = null;

	 try 
	 {
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
			 /*Query query = session.createSQLQuery("select gross_total,total from store_management  where bill_no=:billNo GROUP BY bill_no");*/
			 
		 //Query query = session.createSQLQuery("select balance_amount,total from store_management WHERE bill_no="+billNo+" AND fk_supplier_id = '"+supplierId+"' UNION SELECT balance_amount, total FROM kitchen_inventory where bill_no="+billNo+" AND fk_supplier_id='"+supplierId+"' GROUP BY bill_no");
		
		// Query query = session.createSQLQuery("select balance_amount,sum(total)  from store_management WHERE  fk_supplier_id = '"+supplierId+"' UNION SELECT balance_amount, sum( total)  FROM kitchen_inventory where fk_supplier_id='"+supplierId+"' ");
	//	 Query query = session.createSQLQuery("select  fk_supplier_id, sum(Grid_total) from goods_receive where supplier_name = '"+supplier+"'");
		 Query query = session.createSQLQuery("select  fk_supplier_id, sum(amount), sum(balanceAmount) from cash_book where Name = '"+supplier+"' AND hotelid = '"+hotelid+"'");
		 list = query.list();
		System.out.println("in cash book to get total amount - "+query.list().size());
		 System.out.println("Result got for total amount is ----  "+list.toString()); 
		 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	   finally
	   {
		  if (session!=null)  
		  {
		 	hbu.closeSession(session);
		  }
	   }
	 	
	 return list;
}
// emp 

public List getEmpTotalAmtByForSupplier(String employee, String hotelid) 
{
	
	 HibernateUtility hbu = null ;
	 Session session = null;
	 List list  = null;

	 try 
	 {
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
			 /*Query query = session.createSQLQuery("select gross_total,total from store_management  where bill_no=:billNo GROUP BY bill_no");*/
			 
		 //Query query = session.createSQLQuery("select balance_amount,total from store_management WHERE bill_no="+billNo+" AND fk_supplier_id = '"+supplierId+"' UNION SELECT balance_amount, total FROM kitchen_inventory where bill_no="+billNo+" AND fk_supplier_id='"+supplierId+"' GROUP BY bill_no");
		
		// Query query = session.createSQLQuery("select balance_amount,sum(total)  from store_management WHERE  fk_supplier_id = '"+supplierId+"' UNION SELECT balance_amount, sum( total)  FROM kitchen_inventory where fk_supplier_id='"+supplierId+"' ");
	//	 Query query = session.createSQLQuery("select  fk_supplier_id, sum(Grid_total) from goods_receive where supplier_name = '"+supplier+"'");
		 Query query = session.createSQLQuery("select  fk_employee_Id, sum(amount), sum(balanceAmount) from cash_book where fk_employee_Id = '"+employee+"' AND hotelid = '"+hotelid+"'");
		 list = query.list();
		System.out.println("in cash book to get total amount - "+query.list().size());
//		 System.out.println("Result got for total amount is ----  "+list.toString()); 
		 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	   finally
	   {
		  if (session!=null)  
		  {
		 	hbu.closeSession(session);
		  }
	   }
	 	
	 return list;
}

public List getAllcashBookEntry(String nwfkSupplierId, String hotelid)

{

	System.out.println("fk supp ID receive while getting supp id is -- cashbookDAO "+nwfkSupplierId);
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 Query query = session.createQuery("From CashBook where fkSupplierId ='"+nwfkSupplierId+"' AND hotelid = '"+hotelid+"'");
	 list = query.list();
	 System.out.println("size of list -- "+list.size());
	}
		catch(Exception e){	
			e.printStackTrace();
	}
		finally
		{
				if(session!=null){
				hbu.closeSession(session);
			}
		}
	
return list;
}
// waiter cb
public List getwaitrcashBookEntry(String waiterId)

{

	System.out.println("fk supp ID receive while getting supp id is -- cashbookDAO "+waiterId);
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 Query query = session.createQuery("From CashBook where fkSupplierId ='"+waiterId+"'");
	 list = query.list();
	 System.out.println("size of list -- "+list.size());
	}
		catch(Exception e){	
			e.printStackTrace();
	}
		finally
		{
				if(session!=null){
				hbu.closeSession(session);
			}
		}
	
return list;
}

public void registerCB(CashBook newEntry){
	
	HibernateUtility hbu=null;
	Session session=null;
	Transaction transaction=null;
	
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 transaction = session.beginTransaction();
	
	session.save(newEntry);
	System.out.println("in cash book dao register CB  - -");
	transaction.commit();
	}
	
	catch(RuntimeException e){
		try{
			transaction.rollback();
		}catch(Exception rbe)
		{
			rbe.printStackTrace();
		}	
	}finally{
	hbu.closeSession(session);
	}
}

public void saveInCash(CashBook cb){

	HibernateUtility hbu=null;
	Session session=null;
	Transaction transaction=null;
	
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 transaction = session.beginTransaction();
     
	session.save(cb);
	System.out.println("supp details saved in CASHBOOK table - - ");
	transaction.commit();
	}
	
	catch(RuntimeException e){
		try{
			transaction.rollback();
		}catch(RuntimeException rbe)
		{
			rbe.printStackTrace();
		}	
	}finally{
	hbu.closeSession(session);
	}
}

public List gettransID(HttpServletRequest request)
{
	HttpSession sessionn = request.getSession(true);
	String username = (String)sessionn.getAttribute("user");		
	String userid = (String)sessionn.getAttribute("userid");
	String hotelid = (String)sessionn.getAttribute("hotelid");
	String hotelname=(String)sessionn.getAttribute("hotelname");
	System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
	
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	
	 Query query = session.createQuery("from CashBook where hotelid = '"+hotelid+"' GROUP BY transID");
	  
	 list = query.list();
	 System.out.println(" list size of trans ID - - "+list.size());
	 
	}
		catch(Exception e){	
			e.printStackTrace();
	}
		finally
		{
				if(session!=null){
				hbu.closeSession(session);
			}
		}
	
return list;
}
//exp

public List gettransIDexp(HttpServletRequest request)
{
	HttpSession sessionn = request.getSession(true);
	String username = (String)sessionn.getAttribute("user");		
	String userid = (String)sessionn.getAttribute("userid");
	String hotelid = (String)sessionn.getAttribute("hotelid");
	String hotelname=(String)sessionn.getAttribute("hotelname");
	System.out.println("session thru expenditurepaymentHibernate () user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
	
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	
	 Query query = session.createQuery("from expenditurepaymentHibernate where hotelid = '"+hotelid+"' GROUP BY transID");
	  
	 list = query.list();
	 System.out.println(" list size of trans ID - - "+query.list().size());
	 
	}
		catch(Exception e){	
			e.printStackTrace();
	}
		finally
		{
				if(session!=null){
				hbu.closeSession(session);
			}
		}
	
return list;
}


//bank tran
public List gettransIDforbank(HttpServletRequest request)
{
	HttpSession sessionn = request.getSession(true);
	String username = (String)sessionn.getAttribute("user");		
	String userid = (String)sessionn.getAttribute("userid");
	String hotelid = (String)sessionn.getAttribute("hotelid");
	String hotelname=(String)sessionn.getAttribute("hotelname");
	System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
	
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	
	 Query query = session.createQuery("from banktransaction where hotelid = '"+hotelid+"' GROUP BY transID");
	  
	 list = query.list();
	 System.out.println(" list size of trans ID - - "+list.size());
	 
	}
		catch(Exception e){	
			e.printStackTrace();
	}
		finally
		{
				if(session!=null){
				hbu.closeSession(session);
			}
		}
	
return list;
}

public List getAllsuppEntry(String toPayNameId, String hotelid)

{

	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 Query query = session.createQuery("From CashBook where toPayNameId ='"+toPayNameId+"' AND hotelid = '"+hotelid+"'");
	 list = query.list();
	 System.out.println(" getting all cashBook list size is  - "+query.list().size());
	}
		catch(Exception e){	
			e.printStackTrace();
	}
		finally
		{
				if(session!=null){
				hbu.closeSession(session);
			}
		}
	
return list;
}
//exp pay transid
public List gettransIDforexppayment(HttpServletRequest request)
{
	HttpSession sessionn = request.getSession(true);
	String username = (String)sessionn.getAttribute("user");		
	String userid = (String)sessionn.getAttribute("userid");
	String hotelid = (String)sessionn.getAttribute("hotelid");
	String hotelname=(String)sessionn.getAttribute("hotelname");
	System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
	
	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	
	 Query query = session.createQuery("from expenditurepaymentHibernate where hotelid = '"+hotelid+"' GROUP BY transID");
	  
	 list = query.list();
	 System.out.println(" list size of trans ID - - "+list.size());
	 
	}
		catch(Exception e){	
			e.printStackTrace();
	}
		finally
		{
				if(session!=null){
				hbu.closeSession(session);
			}
		}
	
return list;
}




// emp Cb

public List getAllsuppEntryemp(String payToId, String hotelid)
{

	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 Query query = session.createQuery("From CashBook where payToId ='"+payToId+"' AND hotelid = '"+hotelid+"'");
	 list = query.list();
	 System.out.println(" getting all emp cashBook list size is  ``` ``   ` - "+query.list().size());
	}
		catch(Exception e){	
			e.printStackTrace();
	}
		finally
		{
				if(session!=null){
				hbu.closeSession(session);
			}
		}
	
return list;
}
//bank transa
public List getAllbanktransEntry( String hotelid)

{

	HibernateUtility hbu=null;
	Session session=null;
	List list=null;
	try{
	 hbu = HibernateUtility.getInstance();
	 session = hbu.getHibernateSession();
	 Query query = session.createQuery("From banktransaction where hotelid = '"+hotelid+"'");
	 list = query.list();
	 System.out.println(" getting all cashBook list size is  - "+query.list().size());
	}
		catch(Exception e){	
			e.printStackTrace();
	}
		finally
		{
				if(session!=null){
				hbu.closeSession(session);
			}
		}
	
return list;
}


// report date wise
public List<CashBook> getpaymentDateWiseReport(String cashbookDate, String hotelid, String usertype) {
	
	System.out.println();
	
			HibernateUtility hbu=null;
			Session session=null;
			List<CashBook> catList=null;
			String ad = "admin";
			if(usertype.equals(ad)) {
				try
				{
					Long k = 0l;
					hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();

		//		Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE paymentDate = '"+cashbookDate+"' AND to_pay = 'supplier'");	
				Query query = session.createSQLQuery("select transactionID,to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount,paymentDate from cash_book WHERE paymentDate = '"+cashbookDate+"' AND to_pay = 'supplier' AND transactionID > '0'");
				List<Object[]> list = query.list();
			        System.out.println("CB date wise list size== - " +list.size());
			        catList= new ArrayList<CashBook>(0);
					
					for (Object[] object : list) {
						k++;		
						CashBook cb = new CashBook();
		//				cb.setSrNo(k);
						cb.setTransID(Long.parseLong(object[0].toString()));
						cb.setPayToId(object[1].toString());
						cb.setToPayNameId(object[2].toString());
						cb.setPaymentTypeId(object[3].toString());
						cb.setPaymebtById(object[4].toString());
						cb.setPaymentAmountId(Double.parseDouble(object[5].toString()));
						cb.setPayingAmountId(Double.parseDouble(object[6].toString()));
						cb.setRemainingBalance(Double.parseDouble(object[7].toString()));
						cb.setPaymentDate1(object[8].toString());
						catList.add(cb); 
				
					}}
				catch(Exception e)
				{
					e.printStackTrace();
				}	
			}
			else {
			try
			{
				Long k = 0l;
				hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();

	//		Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE paymentDate = '"+cashbookDate+"' AND to_pay = 'supplier'");	
			Query query = session.createSQLQuery("select transactionID,to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount,paymentDate from cash_book WHERE paymentDate = '"+cashbookDate+"' AND to_pay = 'supplier' AND hotelid = '"+hotelid+"' AND transactionID > '0'");
			List<Object[]> list = query.list();
		        System.out.println("CB date wise list size== - " +list.size());
		        catList= new ArrayList<CashBook>(0);
				
				for (Object[] object : list) {
					k++;		
					CashBook cb = new CashBook();
	//				cb.setSrNo(k);
					cb.setTransID(Long.parseLong(object[0].toString()));
					cb.setPayToId(object[1].toString());
					cb.setToPayNameId(object[2].toString());
					cb.setPaymentTypeId(object[3].toString());
					cb.setPaymebtById(object[4].toString());
					cb.setPaymentAmountId(Double.parseDouble(object[5].toString()));
					cb.setPayingAmountId(Double.parseDouble(object[6].toString()));
					cb.setRemainingBalance(Double.parseDouble(object[7].toString()));
					cb.setPaymentDate1(object[8].toString());
					catList.add(cb); 
			
				}}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			return catList;
}
// supp rangewise
public List<CashBook> getpaymentRangeWiseReport(String datefrom, String dateto, String hotelid,String usertype) {
	
	System.out.println();
	
			HibernateUtility hbu=null;
			Session session=null;
			List<CashBook> catList=null;
			String ad = "admin";
			if(usertype.equals(ad)) {
				try
				{
					Long k = 0l;
					hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();

		//		Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE paymentDate = '"+cashbookDate+"' AND to_pay = 'supplier'");	
				Query query = session.createSQLQuery("select transactionID,to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount,paymentDate from cash_book WHERE paymentDate BETWEEN '"+datefrom+"' AND '"+dateto+"' AND to_pay = 'supplier' AND transactionID > '0'");
				List<Object[]> list = query.list();
			        System.out.println("CB date wise list size== - " +list.size());
			        catList= new ArrayList<CashBook>(0);
					
					for (Object[] object : list) {
						k++;		
						CashBook cb = new CashBook();
		//				cb.setSrNo(k);
						cb.setTransID(Long.parseLong(object[0].toString()));
						cb.setPayToId(object[1].toString());
						cb.setToPayNameId(object[2].toString());
						cb.setPaymentTypeId(object[3].toString());
						cb.setPaymebtById(object[4].toString());
						cb.setPaymentAmountId(Double.parseDouble(object[5].toString()));
						cb.setPayingAmountId(Double.parseDouble(object[6].toString()));
						cb.setRemainingBalance(Double.parseDouble(object[7].toString()));
						cb.setPaymentDate1(object[8].toString());
						catList.add(cb); 
				
					}}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else {
			try
			{
				Long k = 0l;
				hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();

	//		Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE paymentDate = '"+cashbookDate+"' AND to_pay = 'supplier'");	
			Query query = session.createSQLQuery("select transactionID,to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount,paymentDate from cash_book WHERE paymentDate BETWEEN '"+datefrom+"' AND '"+dateto+"' AND to_pay = 'supplier' AND hotelid = '"+hotelid+"' AND transactionID > '0'");
			List<Object[]> list = query.list();
		        System.out.println("CB date wise list size== - " +list.size());
		        catList= new ArrayList<CashBook>(0);
				
				for (Object[] object : list) {
					k++;		
					CashBook cb = new CashBook();
	//				cb.setSrNo(k);
					cb.setTransID(Long.parseLong(object[0].toString()));
					cb.setPayToId(object[1].toString());
					cb.setToPayNameId(object[2].toString());
					cb.setPaymentTypeId(object[3].toString());
					cb.setPaymebtById(object[4].toString());
					cb.setPaymentAmountId(Double.parseDouble(object[5].toString()));
					cb.setPayingAmountId(Double.parseDouble(object[6].toString()));
					cb.setRemainingBalance(Double.parseDouble(object[7].toString()));
					cb.setPaymentDate1(object[8].toString());
					catList.add(cb); 
			
				}}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			return catList;
}

public List<CashBook> getpaymentsupplierReport(String cashbooksupp, String hotelid,String usertype) {
	
	System.out.println();
	
			HibernateUtility hbu=null;
			Session session=null;
			List<CashBook> catList=null;
			String ad = "admin";
			if(usertype.equals(ad)) {
				try
				{
					Long k = 0l;
					hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();

		//		Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE Name = '"+cashbooksupp+"' AND to_pay = 'supplier' ");	
				 Query query = session.createSQLQuery("select transactionID,to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount, paymentDate from cash_book WHERE Name = '"+cashbooksupp+"' AND to_pay = 'supplier' AND transactionID > '0'");
				List<Object[]> list = query.list();
			        System.out.println("CB date wise list size== - " +list.size());
			        catList= new ArrayList<CashBook>(0);
					
					for (Object[] object : list) {
						k++;		
						CashBook cb = new CashBook();
		//				cb.setSrNo(k);
						cb.setTransID(Long.parseLong(object[0].toString()));
						cb.setPayToId(object[1].toString());
						cb.setToPayNameId(object[2].toString());
						cb.setPaymentTypeId(object[3].toString());
						cb.setPaymebtById(object[4].toString());
						cb.setPaymentAmountId(Double.parseDouble(object[5].toString()));
						cb.setPayingAmountId(Double.parseDouble(object[6].toString()));
						cb.setRemainingBalance(Double.parseDouble(object[7].toString()));
						
	/*					String db = (object[8].toString());
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						String CurrentDate = df.format(db);
						cb.setPaymentDate(CurrentDate);*/
						cb.setPaymentDate1(object[8].toString());
						System.out.println("date set is-  - "+cb.getPaymentDate1());
						catList.add(cb); 
				
					}}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else {
			try
			{
				Long k = 0l;
				hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();

	//		Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE Name = '"+cashbooksupp+"' AND to_pay = 'supplier' ");	
			 Query query = session.createSQLQuery("select transactionID,to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount, paymentDate from cash_book WHERE Name = '"+cashbooksupp+"' AND to_pay = 'supplier' AND hotelid = '"+hotelid+"' AND transactionID > '0'");
			List<Object[]> list = query.list();
		        System.out.println("CB date wise list size== - " +list.size());
		        catList= new ArrayList<CashBook>(0);
				
				for (Object[] object : list) {
					k++;		
					CashBook cb = new CashBook();
	//				cb.setSrNo(k);
					cb.setTransID(Long.parseLong(object[0].toString()));
					cb.setPayToId(object[1].toString());
					cb.setToPayNameId(object[2].toString());
					cb.setPaymentTypeId(object[3].toString());
					cb.setPaymebtById(object[4].toString());
					cb.setPaymentAmountId(Double.parseDouble(object[5].toString()));
					cb.setPayingAmountId(Double.parseDouble(object[6].toString()));
					cb.setRemainingBalance(Double.parseDouble(object[7].toString()));
					
/*					String db = (object[8].toString());
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String CurrentDate = df.format(db);
					cb.setPaymentDate(CurrentDate);*/
					cb.setPaymentDate1(object[8].toString());
					System.out.println("date set is-  - "+cb.getPaymentDate1());
					catList.add(cb); 
			
				}}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			return catList;
}

// emp date wise
		public List<CashBook> getEmppaymentsupplierReport(String cashbookempDate, String hotelid, String usertype) {
	
	System.out.println("in emp cashboook dao date is -  "+cashbookempDate);
	
			HibernateUtility hbu=null;
			Session session=null;
			List<CashBook> catList=null;
			String ad = "admin";
			if(usertype.equals(ad)) {
				try
				{
					Long k = 0l;
					hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();

				Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount, paid_amount ,balanceAmount from cash_book WHERE paymentDate = '"+cashbookempDate+"' AND to_pay = 'employee'");	

				List<Object[]> list = query.list();
			        System.out.println("CB date wise employee list size== - " +list.size());
			        catList= new ArrayList<CashBook>(0);
					
					for (Object[] object : list) {
						k++;		
						CashBook cb = new CashBook();
		//				cb.setSrNo(k);
						cb.setPayToId(object[0].toString());
						cb.setToPayNameId(object[1].toString());
						cb.setPaymentTypeId(object[2].toString());
						cb.setPaymebtById(object[3].toString());
						cb.setPaymentAmountId(Double.parseDouble(object[4].toString()));
						cb.setPayingAmountId(Double.parseDouble(object[5].toString()));
						cb.setRemainingBalance(Double.parseDouble(object[6].toString()));
						catList.add(cb); 
				
					}}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else {
			try
			{
				Long k = 0l;
				hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();

			Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount, paid_amount ,balanceAmount from cash_book WHERE paymentDate = '"+cashbookempDate+"' AND to_pay = 'employee' AND hotelid = '"+hotelid+"'");	

			List<Object[]> list = query.list();
		        System.out.println("CB date wise employee list size== - " +list.size());
		        catList= new ArrayList<CashBook>(0);
				
				for (Object[] object : list) {
					k++;		
					CashBook cb = new CashBook();
	//				cb.setSrNo(k);
					cb.setPayToId(object[0].toString());
					cb.setToPayNameId(object[1].toString());
					cb.setPaymentTypeId(object[2].toString());
					cb.setPaymebtById(object[3].toString());
					cb.setPaymentAmountId(Double.parseDouble(object[4].toString()));
					cb.setPayingAmountId(Double.parseDouble(object[5].toString()));
					cb.setRemainingBalance(Double.parseDouble(object[6].toString()));
					catList.add(cb); 
			
				}}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			return catList;
}

		// emp name wise
	public List<CashBook> getEmppaymentSuppWiseReport(String cashbookemp, String hotelid,String usertype) {
			
			System.out.println("in emp cashboook dao name is -  "+cashbookemp+" htelid - "+hotelid);
			
					HibernateUtility hbu=null;
					Session session=null;
					List<CashBook> catList=null;
					String ad = "admin";
					if(usertype.equals(ad)) {
						try
						{
							Long k = 0l;
							hbu = HibernateUtility.getInstance();
						 session = hbu.getHibernateSession();

						Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE Name = '"+cashbookemp+"' AND to_pay = 'employee'");	

						List<Object[]> list = query.list();
					        System.out.println("CB date wise employee list size== - " +list.size());
					        catList= new ArrayList<CashBook>(0);
							
							for (Object[] object : list) {
								k++;		
								CashBook cb = new CashBook();
				//				cb.setSrNo(k);
								cb.setPayToId(object[0].toString());
								cb.setToPayNameId(object[1].toString());
								cb.setPaymentTypeId(object[2].toString());
								cb.setPaymebtById(object[3].toString());
								cb.setPaymentAmountId(Double.parseDouble(object[4].toString()));
								cb.setPayingAmountId(Double.parseDouble(object[5].toString()));
								cb.setRemainingBalance(Double.parseDouble(object[6].toString()));
								catList.add(cb); 
						
							}}
						catch(Exception e)
						{
							e.printStackTrace();
						}	
					}
					else {
					try
					{
						Long k = 0l;
						hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();

					Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE Name = '"+cashbookemp+"' AND to_pay = 'employee' AND hotelid = '"+hotelid+"'");	

					List<Object[]> list = query.list();
				        System.out.println("CB date wise employee list size== - " +list.size());
				        catList= new ArrayList<CashBook>(0);
						
						for (Object[] object : list) {
							k++;		
							CashBook cb = new CashBook();
			//				cb.setSrNo(k);
							cb.setPayToId(object[0].toString());
							cb.setToPayNameId(object[1].toString());
							cb.setPaymentTypeId(object[2].toString());
							cb.setPaymebtById(object[3].toString());
							cb.setPaymentAmountId(Double.parseDouble(object[4].toString()));
							cb.setPayingAmountId(Double.parseDouble(object[5].toString()));
							cb.setRemainingBalance(Double.parseDouble(object[6].toString()));
							catList.add(cb); 
					
						}}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					}
					return catList;
		}
		// emp range
				public List<CashBook> getEmppaymentSuppRangeWiseReport1(String datefrom, String dateto, String hotelid, String usertype) {
					
					System.out.println("date  -   "+datefrom+" & "+dateto);
					
							HibernateUtility hbu=null;
							Session session=null;
							List<CashBook> catList=null;
							String ad = "admin";
							if(usertype.equals(ad)) {
								try
								{
									Long k = 0l;
									hbu = HibernateUtility.getInstance();
								 session = hbu.getHibernateSession();

//								Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE Name = '"+cashbookemp+"' AND to_pay = 'employee' ");	
								 Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE paymentDate BETWEEN '"+datefrom+"' AND '"+dateto+"' AND to_pay = 'employee' AND transactionID > '0'");
								List<Object[]> list = query.list();
							        System.out.println("CB date wise employee list size== - " +list.size());
							        catList= new ArrayList<CashBook>(0);
									
									for (Object[] object : list) {
										k++;		
										CashBook cb = new CashBook();
										System.out.println("result - "+Arrays.toString(object));
						//				cb.setSrNo(k);
										cb.setPayToId(object[0].toString());
										cb.setToPayNameId(object[1].toString());
										cb.setPaymentTypeId(object[2].toString());
										cb.setPaymebtById(object[3].toString());
										cb.setPaymentAmountId(Double.parseDouble(object[4].toString()));
										cb.setPayingAmountId(Double.parseDouble(object[5].toString()));
										cb.setRemainingBalance(Double.parseDouble(object[6].toString()));
										catList.add(cb); 
								
									}
									
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
							}
							else {
							try
							{
								Long k = 0l;
								hbu = HibernateUtility.getInstance();
							 session = hbu.getHibernateSession();

//							Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE Name = '"+cashbookemp+"' AND to_pay = 'employee' ");	
							 Query query = session.createSQLQuery("select to_pay, `Name`, paymentType, paymentBy, amount,paid_amount ,balanceAmount from cash_book WHERE paymentDate BETWEEN '"+datefrom+"' AND '"+dateto+"' AND to_pay = 'employee' AND hotelid = '"+hotelid+"' AND transactionID > '0'");
							List<Object[]> list = query.list();
						        System.out.println("CB date wise employee list size== - " +list.size());
						        catList= new ArrayList<CashBook>(0);
								
								for (Object[] object : list) {
									k++;		
									CashBook cb = new CashBook();
									System.out.println("result - "+Arrays.toString(object));
					//				cb.setSrNo(k);
									cb.setPayToId(object[0].toString());
									cb.setToPayNameId(object[1].toString());
									cb.setPaymentTypeId(object[2].toString());
									cb.setPaymebtById(object[3].toString());
									cb.setPaymentAmountId(Double.parseDouble(object[4].toString()));
									cb.setPayingAmountId(Double.parseDouble(object[5].toString()));
									cb.setRemainingBalance(Double.parseDouble(object[6].toString()));
									catList.add(cb); 
							
								}
								
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							}
							return catList;
				}
		
	// get all supp name
		
		public List getsupplier(HttpServletRequest request)
		{
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			String ad = "admin";
			if(usertype.equals(ad)) {
				try{
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					
					 Query query = session.createQuery("from CashBook where payToId = 'supplier' ");
					
					 list = query.list();
					 System.out.println(" list size of trans ID - - "+list.size());
					 
					}
						catch(Exception e){	
							e.printStackTrace();
					}
						finally
						{
								if(session!=null){
								hbu.closeSession(session);
							}
						}	
			}
			else {
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			
			 Query query = session.createQuery("from CashBook where payToId = 'supplier' AND hotelid = '"+hotelid+"'");
			
			 list = query.list();
			 System.out.println(" list size of trans ID - - "+list.size());
			 
			}
				catch(Exception e){	
					e.printStackTrace();
			}
				finally
				{
						if(session!=null){
						hbu.closeSession(session);
					}
				}
			}
		return list;
		}
	
		// get employee name
		
		public List getemployee(HttpServletRequest request)
		{
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			String ad = "admin";
			if(usertype.equals(ad)) {
				try{
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					
					 Query query = session.createQuery("from CashBook where payToId = 'employee'");
					
					 list = query.list();
					 System.out.println(" list size of trans ID - - "+list.size());
					 
					}
						catch(Exception e){	
							e.printStackTrace();
					}
						finally
						{
								if(session!=null){
								hbu.closeSession(session);
							}
						}
			}
			else {
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			
			 Query query = session.createQuery("from CashBook where payToId = 'employee' AND hotelid = '"+hotelid+"'");
			
			 list = query.list();
			 System.out.println(" list size of trans ID - - "+list.size());
			 
			}
				catch(Exception e){	
					e.printStackTrace();
			}
				finally
				{
						if(session!=null){
						hbu.closeSession(session);
					}
				}
			}
		return list;
		}
		// debit report
		
		
		public List<CashBook> getdebitDateWiseReport(String debitdatefrm, String debitdateto, String hotelid, String usertype)
		{
			HibernateUtility hbu = null;
			Session session = null;
			List<CashBook> catList = null;
			String ad = "admin";
			if(usertype.equals(ad)) {
				try
				{
					Long k = 0l;
					hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();

				
				
				 Query  query = session.createSQLQuery("SELECT transactionID, to_pay, `Name` ,amount,balanceAmount  FROM cash_book  WHERE paymentDate BETWEEN '"+debitdatefrm+"' AND '"+debitdateto+"' AND transactionID > 0");		
				 List<Object[]> list = query.list();
				 catList= new ArrayList<CashBook>(0);
	    
				 for (Object[] o : list) {
			
					 System.out.println("Result -->  "+Arrays.toString(o));
					 k++;		
					 CashBook rep = new CashBook();
			
		//	rep.setSrNo(k);
					 rep.setTransID(Long.parseLong(o[0].toString()));
					 rep.setPayToId(o[1].toString());
					rep.setToPayNameId(o[2].toString());
					rep.setPaymentAmountId(Double.parseDouble(o[3].toString()));
					rep.setRemainingBalance(Double.parseDouble(o[4].toString()));
					catList.add(rep); 
				 	}
				}
				
					catch(Exception e)
					{
					e.printStackTrace();
					}
					finally {

					hbu.closeSession(session);
					}
			}
			else {
			try
			{
				Long k = 0l;
				hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();

			
			
			 Query  query = session.createSQLQuery("SELECT transactionID, to_pay, `Name` ,amount,balanceAmount  FROM cash_book  WHERE hotelid = '"+hotelid+"' AND paymentDate BETWEEN '"+debitdatefrm+"' AND '"+debitdateto+"' AND transactionID > 0");		
			 List<Object[]> list = query.list();
			 catList= new ArrayList<CashBook>(0);
    
			 for (Object[] o : list) {
		
				 System.out.println("Result -->  "+Arrays.toString(o));
				 k++;		
				 CashBook rep = new CashBook();
		
	//	rep.setSrNo(k);
				 rep.setTransID(Long.parseLong(o[0].toString()));
				 rep.setPayToId(o[1].toString());
				rep.setToPayNameId(o[2].toString());
				rep.setPaymentAmountId(Double.parseDouble(o[3].toString()));
				rep.setRemainingBalance(Double.parseDouble(o[4].toString()));
				catList.add(rep); 
			 	}
			}
			
				catch(Exception e)
				{
				e.printStackTrace();
				}
				finally {

				hbu.closeSession(session);
				}
			}
				return catList;
		
	}
		
		public List getAllsuppEntryforCB(HttpServletRequest request)
		{

			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
			String sup = "supplier";
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("From CashBook where payToId ='"+sup+"' AND hotelid = '"+hotelid+"'");
			 list = query.list();
			 System.out.println(" getting all cashBook list size is  - "+query.list().size());
			}
				catch(Exception e){	
					e.printStackTrace();
			}
				finally
				{
						if(session!=null){
						hbu.closeSession(session);
					}
				}
			
		return list;
		}
		// bank dropdown
		public List getAllbankfromCB(HttpServletRequest request)
		{

			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
			String sup = "supplier";
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("From bankdetailHibernate where hotelid = '"+hotelid+"'");
			 list = query.list();
			 System.out.println(" getting all bank details cashBook list size is  - "+query.list().size());
			}
				catch(Exception e){	
					e.printStackTrace();
			}
				finally
				{
						if(session!=null){
						hbu.closeSession(session);
					}
				}
			
		return list;
		}
		//bank report dropdown
		public List getAllbankfromCBforreport(HttpServletRequest request)
		{

			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid+" usertype - "+usertype);
			System.out.println(" usertype - "+usertype);
//			String ads = "admin";
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			String ads = "admin";
			if(usertype.equals(ads)) {
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("From bankdetailHibernate");
			 list = query.list();
			 System.out.println(" getting all bank details cashBook list size is  - "+query.list().size());
			}
				catch(Exception e){	
					e.printStackTrace();
			}
				finally
				{
						if(session!=null){
						hbu.closeSession(session);
					}
				}
		}
			else {
				try{
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					 Query query = session.createQuery("From bankdetailHibernate where hotelid = '"+hotelid+"'");
					 list = query.list();
					 System.out.println(" getting all bank details cashBook list size is  - "+query.list().size());
					}
						catch(Exception e){	
							e.printStackTrace();
					}
						finally
						{
								if(session!=null){
								hbu.closeSession(session);
							}
						}
					

			}	
			return list;			
		}
		
		//expenditure dropdown
		public List getAllexpenditurefromCB(HttpServletRequest request)
		{

			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
	//		String sup = "supplier";
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			
			
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("From expenditureHibernate where hotelid = '"+hotelid+"'");
			 list = query.list();
			 System.out.println(" getting all expenditure details cashBook list size is  - "+query.list().size());
			}
				catch(Exception e){	
					e.printStackTrace();
			}
				finally
				{
						if(session!=null){
						hbu.closeSession(session);
					}
				}
			
		return list;
		}
		//expend report
		public List getAllexpenditureforreport(HttpServletRequest request)
		{

			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			String usertype = (String)sessionn.getAttribute("usertype");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			System.out.println("usertype - "+usertype);
	//		String sup = "supplier";
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			String adss = "admin";
			if(usertype.equals(adss)) {
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("From expenditureHibernate");
			 list = query.list();
			 System.out.println(" getting all expenditure details for report cashBook list size is  - "+query.list().size());
			}
				catch(Exception e){	
					e.printStackTrace();
			}
				finally
				{
						if(session!=null){
						hbu.closeSession(session);
					}
				}
			}
			else {
				try{
					 hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
					 Query query = session.createQuery("From expenditureHibernate where hotelid = '"+hotelid+"'");
					 list = query.list();
					 System.out.println(" getting all expenditure details for report cashBook list size is  - "+query.list().size());
					}
						catch(Exception e){	
							e.printStackTrace();
					}
						finally
						{
								if(session!=null){
								hbu.closeSession(session);
							}
						}	
			}
			
		return list;
		}
		
		
		
		public List getAllemployeeEntryforCB()

		{
			String sup = "employee";
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("From CashBook where payToId ='"+sup+"'");
			 list = query.list();
			 System.out.println(" getting all cashBook list size is  - "+query.list().size());
			}
				catch(Exception e){	
					e.printStackTrace();
			}
				finally
				{
						if(session!=null){
						hbu.closeSession(session);
					}
				}
			
		return list;
		}
		
		public List getAllwaitrEntry(HttpServletRequest request)	
		{
			HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
			String emp = "employee";
			HibernateUtility hbu=null;
			Session session=null;
			List list=null;
			try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("From CashBook where payToId ='"+emp+"' AND hotelid = '"+hotelid+"'");
			 list = query.list();
			 System.out.println(" getting all cashBook list size is  - "+query.list().size());
			}
				catch(Exception e){	
					e.printStackTrace();
			}
				finally
				{
						if(session!=null){
						hbu.closeSession(session);
					}
				}
			
		return list;
		}
	// bank list
		public List getAllbankForList(HttpServletRequest request){
			 HttpSession sessionn = request.getSession(true);
				String username = (String)sessionn.getAttribute("user");		
				String userid = (String)sessionn.getAttribute("userid");
				String hotelid = (String)sessionn.getAttribute("hotelid");
				String hotelname=(String)sessionn.getAttribute("hotelname");
				System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			  	
				HibernateUtility hbu=null;
				Session session=null;
				List<bankdetailHibernate> custList=null;
			try{	

				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();

				Query query=session.createSQLQuery("select pkbankdetail_id, bankname,branchname,accountname,accountnum,contactno,ifsccode from bank_details where hotelid ='"+hotelid+"'");
				List<Object[]> list = query.list();

				custList= new ArrayList<bankdetailHibernate>(0);

				int sr = 0;
			for (Object[] o : list) {	
				bankdetailHibernate rp = new bankdetailHibernate();
				sr++;
				rp.setPkbankdetailid(Long.parseLong(o[0].toString()));
				rp.setBankname(o[1].toString());
				rp.setBranchname(o[2].toString());
				rp.setAccountname(o[3].toString());
				rp.setAccountnum(Long.parseLong(o[4].toString()));
				rp.setContactno(Long.parseLong(o[5].toString()));
				rp.setIfsccode(Long.parseLong(o[6].toString()));
				rp.setSr(sr);
				custList.add(rp);

			}}catch(RuntimeException e){	

			}
			finally{

			hbu.closeSession(session);	
			}
			return custList;

		 }
		
		
}
