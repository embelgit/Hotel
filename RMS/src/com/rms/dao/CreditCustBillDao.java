package com.rms.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.BillBean;
import com.rms.bean.BillCopy;
import com.rms.bean.SaleReport;
import com.rms.hibernate.CreditCustomerBill;
import com.rms.utility.HibernateUtility;

public class CreditCustBillDao {
	
	// get Last Bill No 
		public List getLastBillNo() {
			// TODO Auto-generated method stub
			HibernateUtility hbu=null;
			Session session=null;
			List<BillBean> saleList=null;
			try
			{
				hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createSQLQuery("SELECT BillNo , pkCrediBillId FROM creditcustomerbill ORDER BY BillNo DESC LIMIT 1");
				
				List<Object[]> list = query.list();
				 saleList= new ArrayList<BillBean>(0);
				for (Object[] object : list) {
					System.out.println(Arrays.toString(object));
					BillBean reports = new BillBean();
					reports.setBillNo(Long.parseLong(object[0].toString()));
					saleList.add(reports);	 
			}}
			catch(Exception e)
			{
				e.printStackTrace();	
			}finally
			{if(session!=null){
				session.close();	
			}
			}
			return saleList;
		}

		public void regCreditCustomerBill(CreditCustomerBill cust) {
			// TODO Auto-generated method stub
			
			HibernateUtility hbu = null ;
			Session session  = null;
			Transaction transaction = null;
			
			
			try {
				hbu = HibernateUtility.getInstance();
				session = hbu.getHibernateSession();
				transaction = session.beginTransaction();
				
				session.save(cust);
				transaction.commit();
				
			
			} catch (Exception e) {
				try {
					transaction.rollback();
				} catch (RuntimeException ede) {
				     
				//	Log.error("Error in transaction", ede);
				}
			}
			
			finally
			{
				if (session!=null) {
					hbu.closeSession(session);
					
				}
			}
		}
		
		
		//get bill no to get Bill copy
		
			public List getBillNo()
			{
				HibernateUtility hbu=null;
				Session session=null;
				
				List<BillCopy> billList=null;
				 List<Object[]> list = null;
				
				try
				{
						hbu = HibernateUtility.getInstance();
						session = hbu.getHibernateSession();
						Query query=session.createSQLQuery("select c.BillNo, s.first_name, s.aadhar_no from creditcustomerbill c left join customer_details s on c.fkCrediCustId=s.pk_customer_id group by c.BillNo order by c.BillNo desc;");
						list = query.list();
						billList = new ArrayList<BillCopy>(0);
						
				 for (Object[] objects : list) {
					 BillCopy bean = new BillCopy();
					
					bean.setBillNo(Long.parseLong(objects[0].toString()));
					bean.setCustName(objects[1].toString());
					bean.setGstNo(objects[2].toString());
					billList.add(bean);
					}
				 }
				catch(RuntimeException  e)
				{
						
				}finally
				{if(session!=null){
					hbu.closeSession(session);	
				}
				}
				return billList;
			}

			public void DeActivePaymentDone(String billNo) {
				// TODO Auto-generated method stub
				
				
				com.rms.utility.HibernateUtility hbu=null;
				Session session=null;
				Transaction transaction = null;
				
				try{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 Long bill = Long.parseLong(billNo);
				 Query query = session.createQuery("select s.pkCreditBillId,s.paymentDone from CreditCustomerBill s where  s.billNo =:bill");
					query.setParameter("bill",bill);
					
					List<Object[]> list = query.list();
					
					for (Iterator iterator = list.iterator(); iterator.hasNext();) {
						Object[] objects = (Object[]) iterator.next();
						transaction = session.beginTransaction();
						Long pkCreditBillId = Long.parseLong(objects[0].toString());
							//BigDecimal bigDecimal = new BigDecimal(newBal);
						System.out.println("deactivation done of "+pkCreditBillId );
						CreditCustomerBill upPayment = (CreditCustomerBill) session.get(CreditCustomerBill.class,
								new Long(pkCreditBillId));
						upPayment.setPaymentDone("n");
						

						session.saveOrUpdate(upPayment);
						transaction.commit();   
						
					}
					
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
			
			//Single Date Credit Sale Report 

			public List<SaleReport> creditSingleDate(Date adate) {
				// TODO Auto-generated method stub
				HibernateUtility hbu=null;
				Session session=null;
				List<SaleReport> catList=null;
				try
				{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 
				 Long k = 0l;
				// Query query2 = session.createQuery("select billNo, carNo, barcodeNo, itemName, categoryName, salePrice, ownerName, contactNo, totalAmt, discount from CustomerBill where current_date=:adate");
				 Query query2 = session.createSQLQuery("select s.BillNo, s.BarcodeNo, s.ItemName, s.CategoryName, s.SalePrice, s.TotalAmount, s.Discount, s.Quantity, s.Gst, s.TaxAmount, s.Igst, c.first_name from creditcustomerbill s left join customer_details c ON s.fkCrediCustId=c.pk_customer_id where s.Date =:adate");
				 query2.setParameter("adate", adate);
			        List<Object[]> list = query2.list();
			        catList= new ArrayList<SaleReport>(0);
					
					
					for (Object[] object : list) {
							
						SaleReport reports = new SaleReport();
						k++;
						reports.setSrNo(k);
						reports.setBillNo(Long.parseLong(object[0].toString()));
						reports.setBarcodeNo(Long.parseLong(object[1].toString()));
						reports.setItemName(object[2].toString());
						reports.setCategoryName(object[3].toString());
						reports.setSalePrice((double) Math.round(Double.parseDouble(object[4].toString())));
						//reports.setTotalAmt(Double.parseDouble(object[5].toString()));
						reports.setDiscount((double) Math.round(Double.parseDouble(object[6].toString())));
						reports.setQuantity(Long.parseLong(object[7].toString()));
						//reports.setGst(Double.parseDouble(object[8].toString()));
						reports.setTaxAmount(Double.parseDouble(object[9].toString()));
						reports.setFirstName(object[11].toString());
						
						String gst = object[8].toString();
						String igst = object[10].toString();
						if(gst.equals("0.0")){
							reports.setGst(Double.parseDouble(igst));
						}
						if(igst.equals("0.0")){
							reports.setGst(Double.parseDouble(gst));
						}
						
						double quan = Double.parseDouble(object[7].toString());
						double saleP = Double.parseDouble(object[4].toString());
						double taxAmt = Double.parseDouble(object[9].toString());
						double saleTotal = quan * saleP;
						double totalAmt = saleTotal + taxAmt;
						reports.setTotalperItem((double) Math.round(saleTotal));
						reports.setTotalAmt((double) Math.round(totalAmt));
						catList.add(reports); 
				
					}}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return catList;

			}
			
			//Two Date Credit Sale Report 
			public List<SaleReport> creditTwoDate(Date adate, Date bdate) {
				// TODO Auto-generated method stub
				HibernateUtility hbu=null;
				Session session=null;
				List<SaleReport> catList=null;
				try
				{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 
				 Long k = 0l;
				// Query query2 = session.createQuery("select billNo, carNo, barcodeNo, itemName, categoryName, salePrice, ownerName, contactNo, totalAmt, discount from CustomerBill where current_date=:adate");
				 Query query2 = session.createSQLQuery("select s.BillNo, s.BarcodeNo, s.ItemName, s.CategoryName, s.SalePrice, s.TotalAmount, s.Discount, s.Quantity, s.Gst, s.TaxAmount, s.Igst, c.first_name from creditcustomerbill s left join customer_details c ON s.fkCrediCustId=c.pk_customer_id where s.Date BETWEEN :adate AND :bdate");
				 query2.setParameter("adate", adate);
				 query2.setParameter("bdate", bdate);
			        List<Object[]> list = query2.list();
			        catList= new ArrayList<SaleReport>(0);
					
					
					for (Object[] object : list) {
							
						SaleReport reports = new SaleReport();
						k++;
						reports.setSrNo(k);
						reports.setBillNo(Long.parseLong(object[0].toString()));
						reports.setBarcodeNo(Long.parseLong(object[1].toString()));
						reports.setItemName(object[2].toString());
						reports.setCategoryName(object[3].toString());
						reports.setSalePrice((double) Math.round(Double.parseDouble(object[4].toString())));
						//reports.setTotalAmt(Double.parseDouble(object[5].toString()));
						reports.setDiscount((double) Math.round(Double.parseDouble(object[6].toString())));
						reports.setQuantity(Long.parseLong(object[7].toString()));
						//reports.setGst(Double.parseDouble(object[8].toString()));
						reports.setTaxAmount(Double.parseDouble(object[9].toString()));
						reports.setFirstName(object[11].toString());
						
						String gst = object[8].toString();
						String igst = object[10].toString();
						if(gst.equals("0.0")){
							reports.setGst(Double.parseDouble(igst));
						}
						if(igst.equals("0.0")){
							reports.setGst(Double.parseDouble(gst));
						}
						
						double quan = Double.parseDouble(object[7].toString());
						double saleP = Double.parseDouble(object[4].toString());
						double taxAmt = Double.parseDouble(object[9].toString());
						double saleTotal = quan * saleP;
						double totalAmt = saleTotal + taxAmt;
						reports.setTotalperItem((double) Math.round(saleTotal));
						reports.setTotalAmt((double) Math.round(totalAmt));
						catList.add(reports); 
				
					}}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return catList;

			}

			//Category Wise Credit Sale Report
			public List<SaleReport> creditSaleWiseCustomer(String cscatId) {
				// TODO Auto-generated method stub
				HibernateUtility hbu=null;
				Session session=null;
				List<SaleReport> catList=null;
				try
				{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 
				 Long k = 0l;
				// Query query2 = session.createQuery("select billNo, carNo, barcodeNo, itemName, categoryName, salePrice, ownerName, contactNo, totalAmt, discount from CustomerBill where current_date=:adate");
				 Query query2 = session.createSQLQuery("select s.BillNo, s.BarcodeNo, s.ItemName, s.CategoryName, s.SalePrice, s.TotalAmount, s.Discount, s.Quantity, s.Gst, s.TaxAmount, s.Igst, c.first_name from creditcustomerbill s left join customer_details c ON s.fkCrediCustId=c.pk_customer_id where s.CategoryName =:cscatId");
				 query2.setParameter("cscatId", cscatId);
				
			        List<Object[]> list = query2.list();
			        catList= new ArrayList<SaleReport>(0);
					
					
					for (Object[] object : list) {
							
						SaleReport reports = new SaleReport();
						k++;
						reports.setSrNo(k);
						reports.setBillNo(Long.parseLong(object[0].toString()));
						reports.setBarcodeNo(Long.parseLong(object[1].toString()));
						reports.setItemName(object[2].toString());
						reports.setCategoryName(object[3].toString());
						reports.setSalePrice((double) Math.round(Double.parseDouble(object[4].toString())));
						//reports.setTotalAmt(Double.parseDouble(object[5].toString()));
						reports.setDiscount((double) Math.round(Double.parseDouble(object[6].toString())));
						reports.setQuantity(Long.parseLong(object[7].toString()));
						//reports.setGst(Double.parseDouble(object[8].toString()));
						reports.setTaxAmount(Double.parseDouble(object[9].toString()));
						reports.setFirstName(object[11].toString());
						
						String gst = object[8].toString();
						String igst = object[10].toString();
						if(gst.equals("0.0")){
							reports.setGst(Double.parseDouble(igst));
						}
						if(igst.equals("0.0")){
							reports.setGst(Double.parseDouble(gst));
						}
						
						double quan = Double.parseDouble(object[7].toString());
						double saleP = Double.parseDouble(object[4].toString());
						double taxAmt = Double.parseDouble(object[9].toString());
						double saleTotal = quan * saleP;
						double totalAmt = saleTotal + taxAmt;
						reports.setTotalperItem((double) Math.round(saleTotal));
						reports.setTotalAmt((double) Math.round(totalAmt));
						catList.add(reports); 
				
					}}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return catList;

			}

			//Bill No Wise Credit Sale Report
			public List<SaleReport> billnowiseCreditsell(long csBillNocust) {
				// TODO Auto-generated method stub
				HibernateUtility hbu=null;
				Session session=null;
				List<SaleReport> catList=null;
				try
				{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 
				 Long k = 0l;
				// Query query2 = session.createQuery("select billNo, carNo, barcodeNo, itemName, categoryName, salePrice, ownerName, contactNo, totalAmt, discount from CustomerBill where current_date=:adate");
				 Query query2 = session.createSQLQuery("select s.BillNo, s.BarcodeNo, s.ItemName, s.CategoryName, s.SalePrice, s.TotalAmount, s.Discount, s.Quantity, s.Gst, s.TaxAmount, s.Igst, c.first_name from creditcustomerbill s left join customer_details c ON s.fkCrediCustId=c.pk_customer_id where s.BillNo =:csBillNocust");
				 query2.setParameter("csBillNocust", csBillNocust);
				
			        List<Object[]> list = query2.list();
			        catList= new ArrayList<SaleReport>(0);
					
					
					for (Object[] object : list) {
							
						SaleReport reports = new SaleReport();
						k++;
						reports.setSrNo(k);
						reports.setBillNo(Long.parseLong(object[0].toString()));
						reports.setBarcodeNo(Long.parseLong(object[1].toString()));
						reports.setItemName(object[2].toString());
						reports.setCategoryName(object[3].toString());
						reports.setSalePrice((double) Math.round(Double.parseDouble(object[4].toString())));
						//reports.setTotalAmt(Double.parseDouble(object[5].toString()));
						reports.setDiscount((double) Math.round(Double.parseDouble(object[6].toString())));
						reports.setQuantity(Long.parseLong(object[7].toString()));
						//reports.setGst(Double.parseDouble(object[8].toString()));
						reports.setTaxAmount(Double.parseDouble(object[9].toString()));
						reports.setFirstName(object[11].toString());
						
						String gst = object[8].toString();
						String igst = object[10].toString();
						if(gst.equals("0.0")){
							reports.setGst(Double.parseDouble(igst));
						}
						if(igst.equals("0.0")){
							reports.setGst(Double.parseDouble(gst));
						}
						
						double quan = Double.parseDouble(object[7].toString());
						double saleP = Double.parseDouble(object[4].toString());
						double taxAmt = Double.parseDouble(object[9].toString());
						double saleTotal = quan * saleP;
						double totalAmt = saleTotal + taxAmt;
						reports.setTotalperItem((double) Math.round(saleTotal));
						reports.setTotalAmt((double) Math.round(totalAmt));
						catList.add(reports); 
				
					}}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return catList;
			}

			//Barcode No Wise Credit Sale Report
			public List<SaleReport> barcodenowiseCredit(long barcodeCredit) {
				// TODO Auto-generated method stub
				HibernateUtility hbu=null;
				Session session=null;
				List<SaleReport> catList=null;
				try
				{
				 hbu = HibernateUtility.getInstance();
				 session = hbu.getHibernateSession();
				 
				 Long k = 0l;
				// Query query2 = session.createQuery("select billNo, carNo, barcodeNo, itemName, categoryName, salePrice, ownerName, contactNo, totalAmt, discount from CustomerBill where current_date=:adate");
				 Query query2 = session.createSQLQuery("select s.BillNo, s.BarcodeNo, s.ItemName, s.CategoryName, s.SalePrice, s.TotalAmount, s.Discount, s.Quantity, s.Gst, s.TaxAmount, s.Igst, c.first_name from creditcustomerbill s left join customer_details c ON s.fkCrediCustId=c.pk_customer_id where s.BarcodeNo =:barcodeCredit");
				 query2.setParameter("barcodeCredit", barcodeCredit);
				
			        List<Object[]> list = query2.list();
			        catList= new ArrayList<SaleReport>(0);
					
					
					for (Object[] object : list) {
							
						SaleReport reports = new SaleReport();
						k++;
						reports.setSrNo(k);
						reports.setBillNo(Long.parseLong(object[0].toString()));
						reports.setBarcodeNo(Long.parseLong(object[1].toString()));
						reports.setItemName(object[2].toString());
						reports.setCategoryName(object[3].toString());
						reports.setSalePrice((double) Math.round(Double.parseDouble(object[4].toString())));
						//reports.setTotalAmt(Double.parseDouble(object[5].toString()));
						reports.setDiscount((double) Math.round(Double.parseDouble(object[6].toString())));
						reports.setQuantity(Long.parseLong(object[7].toString()));
						//reports.setGst(Double.parseDouble(object[8].toString()));
						reports.setTaxAmount(Double.parseDouble(object[9].toString()));
						reports.setFirstName(object[11].toString());
						
						String gst = object[8].toString();
						String igst = object[10].toString();
						if(gst.equals("0.0")){
							reports.setGst(Double.parseDouble(igst));
						}
						if(igst.equals("0.0")){
							reports.setGst(Double.parseDouble(gst));
						}
						
						double quan = Double.parseDouble(object[7].toString());
						double saleP = Double.parseDouble(object[4].toString());
						double taxAmt = Double.parseDouble(object[9].toString());
						double saleTotal = quan * saleP;
						double totalAmt = saleTotal + taxAmt;
						reports.setTotalperItem((double) Math.round(saleTotal));
						reports.setTotalAmt((double) Math.round(totalAmt));
						catList.add(reports); 
				
					}}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return catList;
			}	
}
