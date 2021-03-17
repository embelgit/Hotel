package com.rms.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.TodaySaleHibernate;
import com.rms.hibernate.expenditurepaymentHibernate;
import com.rms.utility.HibernateUtility;

public class TodaySaleDao {

	
	public void addtodaypayment(TodaySaleHibernate cb) {
		
		
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
	
	//today sale date wise
	
	public List<TodaySaleHibernate> gettodaysaledateWiseReport(String hotelid,String usertype,String saledatee) {
		
		System.out.println(hotelid+"  "+usertype);
		
				HibernateUtility hbu=null;
				Session session=null;
				List<TodaySaleHibernate> catList=null;
				String ad = "admin";
				if(usertype.equals(ad)) 
				{
					try
					
					{
						int k = 0;
						hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();

					Query query = session.createSQLQuery("SELECT pk_sale_id, totalsaleamount, currentcash, cardpayment,googlepaypayment,phonpepayment,paytmpayment,otherpayment,todaysdate from todayssale where todaysdate = '"+saledatee+"'");	
				        List<Object[]> list = query.list();
				        System.out.println("in list size==" +list.size());
				        catList= new ArrayList<TodaySaleHibernate>(0);
						
						for (Object[] o : list) {
							k++;		
							TodaySaleHibernate rp = new TodaySaleHibernate();
							System.out.println("result - "+Arrays.toString(o));
							rp.setPksaleid(Long.parseLong(o[0].toString()));
							rp.setSaleamount(Double.parseDouble(o[1].toString()));
							rp.setCurrentcash(Double.parseDouble(o[2].toString()));
							rp.setCardpayment(Double.parseDouble(o[3].toString()));
							rp.setGooglepaypayment(Double.parseDouble(o[4].toString()));
							rp.setPhonpepayment(Double.parseDouble(o[5].toString()));
							rp.setPaytmpayment(Double.parseDouble(o[6].toString()));
							rp.setOtherpayment(Double.parseDouble(o[7].toString()));
							rp.setTodaysdate((Date)o[8]);
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

				Query query = session.createSQLQuery("SELECT pk_sale_id, totalsaleamount, currentcash, cardpayment,googlepaypayment,phonpepayment,paytmpayment,otherpayment,todaysdate from todayssale where todaysdate = '"+saledatee+"' AND hotelid = '"+hotelid+"'");	
			        List<Object[]> list = query.list();
			        System.out.println("in list size== " +list.size());
			        catList= new ArrayList<TodaySaleHibernate>(0);
					
					for (Object[] o : list) {
						k++;		
						TodaySaleHibernate rpp = new TodaySaleHibernate();
				//		reports.setSrNo(k);
						System.out.println("result - "+Arrays.toString(o));
						rpp.setPksaleid(Long.parseLong(o[0].toString()));
						rpp.setSaleamount(Double.parseDouble(o[1].toString()));
						rpp.setCurrentcash(Double.parseDouble(o[2].toString()));
						rpp.setCardpayment(Double.parseDouble(o[3].toString()));
						rpp.setGooglepaypayment(Double.parseDouble(o[4].toString()));
						rpp.setPhonpepayment(Double.parseDouble(o[5].toString()));
						rpp.setPaytmpayment(Double.parseDouble(o[6].toString()));
						rpp.setOtherpayment(Double.parseDouble(o[7].toString()));
						rpp.setTodaysdate((Date)o[8]);
						
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
	
	
	//today sale range wise
	
	public List<TodaySaleHibernate> gettodaysaleRangewiseWiseReport(String hotelid,String usertype,String rangefrom, String rangetoo) {
		
		System.out.println(hotelid+"  "+usertype);
		
				HibernateUtility hbu=null;
				Session session=null;
				List<TodaySaleHibernate> catList=null;
				String ad = "admin";
				if(usertype.equals(ad)) 
				{
					try
					
					{
						int k = 0;
						hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();

					Query query = session.createSQLQuery("SELECT pk_sale_id, totalsaleamount, currentcash, cardpayment,googlepaypayment,phonpepayment,paytmpayment,otherpayment,todaysdate from todayssale WHERE todaysdate BETWEEN '"+rangefrom+"' AND '"+rangetoo+"'");	
				        List<Object[]> list = query.list();
				        System.out.println("in list size==" +list.size());
				        catList= new ArrayList<TodaySaleHibernate>(0);
						
						for (Object[] o : list) {
							k++;		
							TodaySaleHibernate rp = new TodaySaleHibernate();
							System.out.println("result - "+Arrays.toString(o));
							rp.setPksaleid(Long.parseLong(o[0].toString()));
							rp.setSaleamount(Double.parseDouble(o[1].toString()));
							rp.setCurrentcash(Double.parseDouble(o[2].toString()));
							rp.setCardpayment(Double.parseDouble(o[3].toString()));
							rp.setGooglepaypayment(Double.parseDouble(o[4].toString()));
							rp.setPhonpepayment(Double.parseDouble(o[5].toString()));
							rp.setPaytmpayment(Double.parseDouble(o[6].toString()));
							rp.setOtherpayment(Double.parseDouble(o[7].toString()));
							rp.setTodaysdate((Date)o[8]);
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

				Query query = session.createSQLQuery("SELECT pk_sale_id, totalsaleamount, currentcash, cardpayment,googlepaypayment,phonpepayment,paytmpayment,otherpayment,todaysdate from todayssale WHERE todaysdate BETWEEN '"+rangefrom+"' AND '"+rangetoo+"' AND hotelid = '"+hotelid+"'");	
			        List<Object[]> list = query.list();
			        System.out.println("in list size== " +list.size());
			        catList= new ArrayList<TodaySaleHibernate>(0);
					
					for (Object[] o : list) {
						k++;		
						TodaySaleHibernate rpp = new TodaySaleHibernate();
				//		reports.setSrNo(k);
						System.out.println("result - "+Arrays.toString(o));
						rpp.setPksaleid(Long.parseLong(o[0].toString()));
						rpp.setSaleamount(Double.parseDouble(o[1].toString()));
						rpp.setCurrentcash(Double.parseDouble(o[2].toString()));
						rpp.setCardpayment(Double.parseDouble(o[3].toString()));
						rpp.setGooglepaypayment(Double.parseDouble(o[4].toString()));
						rpp.setPhonpepayment(Double.parseDouble(o[5].toString()));
						rpp.setPaytmpayment(Double.parseDouble(o[6].toString()));
						rpp.setOtherpayment(Double.parseDouble(o[7].toString()));
						rpp.setTodaysdate((Date)o[8]);
						
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
