package com.rms.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;



import org.hibernate.Query;
import org.hibernate.Session;

import com.rms.bean.OrderBillReportDateWiseBean;
import com.rms.utility.HibernateUtility;
import com.rms.hibernate.expenditurepaymentHibernate;
public class ExpenditureDao {

	
	public List<expenditurepaymentHibernate> getexpenditureWiseReport(String hotelid,String usertype,String fkexpenditurename) {
		
		System.out.println(hotelid+"  "+usertype);
		
				HibernateUtility hbu=null;
				Session session=null;
				List<expenditurepaymentHibernate> catList=null;
				String ad = "admin";
				if(usertype.equals(ad)) 
				{
					try
					
					{
						int k = 0;
						hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
//					 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
					Query query = session.createSQLQuery("select pkexp_id,expenditurename,expenditureamount,paymentById,paymentdate,cardNoId,chequeNoId,chequeDateId,neftAccNoId from expenditure_payment where expenditurename = '"+fkexpenditurename+"'");	
				        List<Object[]> list = query.list();
				        System.out.println("in list size==" +list.size());
				        catList= new ArrayList<expenditurepaymentHibernate>(0);
						
						for (Object[] o : list) {
							k++;		
							expenditurepaymentHibernate rp = new expenditurepaymentHibernate();
							System.out.println("result - "+Arrays.toString(o));
							rp.setPkexpid(Long.parseLong(o[0].toString()));
							rp.setExpenditurename(o[1].toString());
							rp.setExpenditureamount(Double.parseDouble(o[2].toString()));
							rp.setPaymentById(o[3].toString());
							rp.setPaymentdate((Date)o[4]);
							rp.setCardNoId(Long.parseLong(o[5].toString()));
							rp.setChequeNoId(Long.parseLong(o[6].toString()));
							rp.setChequeDateId((Date)o[7]);
							rp.setNeftAccNoId(Long.parseLong(o[8].toString()));
							rp.setSr(k);
							catList.add(rp); 
					
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
					int k = 0;
					hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
//				 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
				Query query = session.createSQLQuery("select pkexp_id,expenditurename,expenditureamount,paymentById,paymentdate,cardNoId,chequeNoId,chequeDateId,neftAccNoId from expenditure_payment where expenditurename = '"+fkexpenditurename+"' AND hotelid = '"+hotelid+"'");	
			        List<Object[]> list = query.list();
			        System.out.println("in list size== " +list.size());
			        catList= new ArrayList<expenditurepaymentHibernate>(0);
					
					for (Object[] o : list) {
						k++;		
						expenditurepaymentHibernate rpp = new expenditurepaymentHibernate();
				//		reports.setSrNo(k);
						System.out.println("result - "+Arrays.toString(o));
						rpp.setPkexpid(Long.parseLong(o[0].toString()));
						rpp.setExpenditurename(o[1].toString());
						rpp.setExpenditureamount(Double.parseDouble(o[2].toString()));
						rpp.setPaymentById(o[3].toString());
						rpp.setPaymentdate((Date)o[4]);
						rpp.setCardNoId(Long.parseLong(o[5].toString()));
						rpp.setChequeNoId(Long.parseLong(o[6].toString()));
						rpp.setChequeDateId((Date)o[7]);
						rpp.setNeftAccNoId(Long.parseLong(o[8].toString()));
						rpp.setSr(k);
						catList.add(rpp); 
				
					}
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}
				return catList;
	}
	
	//date wsie
	
	
	
public List<expenditurepaymentHibernate> getexpendituredateWiseReport(String hotelid,String usertype,String expdate) {
		
		System.out.println(hotelid+"  "+usertype);
		
				HibernateUtility hbu=null;
				Session session=null;
				List<expenditurepaymentHibernate> catList=null;
				String ad = "admin";
				if(usertype.equals(ad)) 
				{
					try
					
					{
						int k = 0;
						hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();
//					 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
					Query query = session.createSQLQuery("select pkexp_id,expenditurename,expenditureamount,paymentById,paymentdate,cardNoId,chequeNoId,chequeDateId,neftAccNoId from expenditure_payment where paymentdate = '"+expdate+"'");	
				        List<Object[]> list = query.list();
				        System.out.println("in list size==" +list.size());
				        catList= new ArrayList<expenditurepaymentHibernate>(0);
						
						for (Object[] o : list) {
							k++;		
							expenditurepaymentHibernate rp = new expenditurepaymentHibernate();
							System.out.println("result - "+Arrays.toString(o));
							rp.setPkexpid(Long.parseLong(o[0].toString()));
							rp.setExpenditurename(o[1].toString());
							rp.setExpenditureamount(Double.parseDouble(o[2].toString()));
							rp.setPaymentById(o[3].toString());
							rp.setPaymentdate((Date)o[4]);
							rp.setCardNoId(Long.parseLong(o[5].toString()));
							rp.setChequeNoId(Long.parseLong(o[6].toString()));
							rp.setChequeDateId((Date)o[7]);
							rp.setNeftAccNoId(Long.parseLong(o[8].toString()));
							rp.setSr(k);
							catList.add(rp); 
					
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
					int k = 0;
					hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
//				 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
				Query query = session.createSQLQuery("select pkexp_id,expenditurename,expenditureamount,paymentById,paymentdate,cardNoId,chequeNoId,chequeDateId,neftAccNoId from expenditure_payment where paymentdate = '"+expdate+"' AND hotelid = '"+hotelid+"'");	
			        List<Object[]> list = query.list();
			        System.out.println("in list size== " +list.size());
			        catList= new ArrayList<expenditurepaymentHibernate>(0);
					
					for (Object[] o : list) {
						k++;		
						expenditurepaymentHibernate rpp = new expenditurepaymentHibernate();
				//		reports.setSrNo(k);
						System.out.println("result - "+Arrays.toString(o));
						rpp.setPkexpid(Long.parseLong(o[0].toString()));
						rpp.setExpenditurename(o[1].toString());
						rpp.setExpenditureamount(Double.parseDouble(o[2].toString()));
						rpp.setPaymentById(o[3].toString());
						rpp.setPaymentdate((Date)o[4]);
						rpp.setCardNoId(Long.parseLong(o[5].toString()));
						rpp.setChequeNoId(Long.parseLong(o[6].toString()));
						rpp.setChequeDateId((Date)o[7]);
						rpp.setNeftAccNoId(Long.parseLong(o[8].toString()));
						rpp.setSr(k);
						catList.add(rpp); 
				
					}
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}
				return catList;
	}
//range wise

public List<expenditurepaymentHibernate> getexpRangeWiseReport(String hotelid,String usertype,String rangefrm,String rangeto) {
	
	System.out.println(hotelid+"  "+usertype);
	
			HibernateUtility hbu=null;
			Session session=null;
			List<expenditurepaymentHibernate> catList=null;
			String ad = "admin";
			if(usertype.equals(ad)) 
			{
				try
				
				{
					int k = 0;
					hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
//				 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
				Query query = session.createSQLQuery("select pkexp_id,expenditurename,expenditureamount,paymentById,paymentdate,cardNoId,chequeNoId,chequeDateId,neftAccNoId from expenditure_payment where paymentdate BETWEEN '"+rangefrm+"' AND '"+rangeto+"'");	
			        List<Object[]> list = query.list();
			        System.out.println("in list size==" +list.size());
			        catList= new ArrayList<expenditurepaymentHibernate>(0);
					
					for (Object[] o : list) {
						k++;		
						expenditurepaymentHibernate rp = new expenditurepaymentHibernate();
						System.out.println("result - "+Arrays.toString(o));
						rp.setPkexpid(Long.parseLong(o[0].toString()));
						rp.setExpenditurename(o[1].toString());
						rp.setExpenditureamount(Double.parseDouble(o[2].toString()));
						rp.setPaymentById(o[3].toString());
						rp.setPaymentdate((Date)o[4]);
						rp.setCardNoId(Long.parseLong(o[5].toString()));
						rp.setChequeNoId(Long.parseLong(o[6].toString()));
						rp.setChequeDateId((Date)o[7]);
						rp.setNeftAccNoId(Long.parseLong(o[8].toString()));
						rp.setSr(k);
						catList.add(rp); 
				
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
				int k = 0;
				hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
//			 Query query2 = session.createSQLQuery("select TableNo, Itemname, Quantity, unitPrice, unitInMl, totalAmount,GridTotal,CurrentDate from customerorder WHERE CurrentDate  ='"+orderBillDate+"'");
			Query query = session.createSQLQuery("select pkexp_id,expenditurename,expenditureamount,paymentById,paymentdate,cardNoId,chequeNoId,chequeDateId,neftAccNoId from expenditure_payment where paymentdate BETWEEN '"+rangefrm+"' AND '"+rangeto+"' AND hotelid = '"+hotelid+"'");	
		        List<Object[]> list = query.list();
		        System.out.println("in list size== " +list.size());
		        catList= new ArrayList<expenditurepaymentHibernate>(0);
				
				for (Object[] o : list) {
					k++;		
					expenditurepaymentHibernate rpp = new expenditurepaymentHibernate();
			//		reports.setSrNo(k);
					System.out.println("result - "+Arrays.toString(o));
					rpp.setPkexpid(Long.parseLong(o[0].toString()));
					rpp.setExpenditurename(o[1].toString());
					rpp.setExpenditureamount(Double.parseDouble(o[2].toString()));
					rpp.setPaymentById(o[3].toString());
					rpp.setPaymentdate((Date)o[4]);
					rpp.setCardNoId(Long.parseLong(o[5].toString()));
					rpp.setChequeNoId(Long.parseLong(o[6].toString()));
					rpp.setChequeDateId((Date)o[7]);
					rpp.setNeftAccNoId(Long.parseLong(o[8].toString()));
					rpp.setSr(k);
					catList.add(rpp); 
			
				}
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			return catList;
}

}
