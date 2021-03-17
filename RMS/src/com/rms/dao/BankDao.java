package com.rms.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rms.hibernate.bankdetailHibernate;
import com.rms.hibernate.banktransaction;
import com.rms.hibernate.expenditurepaymentHibernate;
import com.rms.utility.HibernateUtility;

public class BankDao {

	
	public List<banktransaction> getbanknameWiseReport(String hotelid,String usertype,String fkbankname) {
		
		System.out.println(hotelid+"  "+usertype);
		
				HibernateUtility hbu=null;
				Session session=null;
				List<banktransaction> catList=null;
				String ad = "admin";
				if(usertype.equals(ad)) 
				{
					try
					
					{
						int k = 0;
						hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();

					Query query = session.createSQLQuery("select pkbank_id, bankname,accountname, amount,contactno,paymentType,datee from bank_transaction WHERE bankname = '"+fkbankname+"'");	
				        List<Object[]> list = query.list();
				        System.out.println("in list size==" +list.size());
				        catList= new ArrayList<banktransaction>(0);
						
						for (Object[] o : list) {
							k++;		
							banktransaction rp = new banktransaction();
							System.out.println("result - "+Arrays.toString(o));
							rp.setPkbankid(Long.parseLong(o[0].toString()));
							rp.setBankname(o[1].toString());
							rp.setAccountname(o[2].toString());
							rp.setAmount(Double.parseDouble(o[3].toString()));
							rp.setContactno(Double.parseDouble(o[4].toString()));
							rp.setPaymentType(o[5].toString());
							rp.setDatee((Date)o[6]);
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

				Query query = session.createSQLQuery("select pkbank_id, bankname,accountname, amount,contactno,paymentType,datee from bank_transaction WHERE bankname = '"+fkbankname+"' AND hotelid = '"+hotelid+"'");	
			        List<Object[]> list = query.list();
			        System.out.println("in list size== " +list.size());
			        catList= new ArrayList<banktransaction>(0);
					
					for (Object[] o : list) {
						k++;		
						banktransaction rpp = new banktransaction();
				//		reports.setSrNo(k);
						System.out.println("result - "+Arrays.toString(o));
						rpp.setPkbankid(Long.parseLong(o[0].toString()));
						rpp.setBankname(o[1].toString());
						rpp.setAccountname(o[2].toString());
						rpp.setAmount(Double.parseDouble(o[3].toString()));
						rpp.setContactno(Double.parseDouble(o[4].toString()));
						rpp.setPaymentType(o[5].toString());
						rpp.setDatee((Date)o[6]);
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
	
	//range wise rp
	
	public List<banktransaction> getbankRangeWiseReport(String hotelid,String usertype,String rangefrom, String rangetoo) {
		
		System.out.println(hotelid+"  "+usertype);
		
				HibernateUtility hbu=null;
				Session session=null;
				List<banktransaction> catList=null;
				String ad = "admin";
				if(usertype.equals(ad)) 
				{
					try
					
					{
						int k = 0;
						hbu = HibernateUtility.getInstance();
					 session = hbu.getHibernateSession();

					Query query = session.createSQLQuery("select pkbank_id, bankname,accountname, amount,contactno,paymentType,datee from bank_transaction WHERE datee BETWEEN  '"+rangefrom+"' AND '"+rangetoo+"'");	
				        List<Object[]> list = query.list();
				        System.out.println("in list size==" +list.size());
				        catList= new ArrayList<banktransaction>(0);
						
						for (Object[] o : list) {
							k++;		
							banktransaction rp = new banktransaction();
							System.out.println("result - "+Arrays.toString(o));
							rp.setPkbankid(Long.parseLong(o[0].toString()));
							rp.setBankname(o[1].toString());
							rp.setAccountname(o[2].toString());
							rp.setAmount(Double.parseDouble(o[3].toString()));
							rp.setContactno(Double.parseDouble(o[4].toString()));
							rp.setPaymentType(o[5].toString());
							rp.setDatee((Date)o[6]);
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

				Query query = session.createSQLQuery("select pkbank_id, bankname,accountname, amount,contactno,paymentType,datee from bank_transaction WHERE datee BETWEEN  '"+rangefrom+"' AND '"+rangetoo+"' AND hotelid = '"+hotelid+"'");	
			        List<Object[]> list = query.list();
			        System.out.println("in list size== " +list.size());
			        catList= new ArrayList<banktransaction>(0);
					
					for (Object[] o : list) {
						k++;		
						banktransaction rpp = new banktransaction();
				//		reports.setSrNo(k);
						System.out.println("result - "+Arrays.toString(o));
						rpp.setPkbankid(Long.parseLong(o[0].toString()));
						rpp.setBankname(o[1].toString());
						rpp.setAccountname(o[2].toString());
						rpp.setAmount(Double.parseDouble(o[3].toString()));
						rpp.setContactno(Double.parseDouble(o[4].toString()));
						rpp.setPaymentType(o[5].toString());
						rpp.setDatee((Date)o[6]);
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
