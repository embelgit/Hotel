package com.rms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.hibernate.SupplierDetailsHibernate;
import com.rms.utility.HibernateUtility;

public class SupplierDetailsDao {
	public void SupplierDetailsHibernate(SupplierDetailsHibernate sd){

		HibernateUtility hbu=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		 hbu = HibernateUtility.getInstance();
		 session = hbu.getHibernateSession();
		 transaction = session.beginTransaction();
	     
		session.save(sd);
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

	public List getAllSupplierName(HttpServletRequest request)
	{
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		HibernateUtility hbu = null;
		Session session =  null;
		Query query = null;
		List<SupplierDetailsHibernate> list = null;
		try {
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 query = session.createQuery("from SupplierDetailsHibernate where hotelid = '"+hotelid+"'");
			 list = query.list(); 
		} catch (RuntimeException e) {
			e.printStackTrace();
			
		}
		 
		 finally
		 {
			 if (session!=null) {
				hbu.closeSession(session);
			}
		 }
				return list;
		
	}
	
	// get supplier detail to edit
	public List getAllSupplierDetailsForEdit(Long pkSupplierDetailId) {

		HibernateUtility hbu = null;
		Session session =  null;
		Query query = null;
		 List list = null;
		 try {
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
//			 query = session.createSQLQuery("SELECT pk_supplier_detail_id,suplier_name,gst_no,contact_person_name FROM supplier_details WHERE pk_supplier_detail_id ="+pkSupplierDetailId);
			 query = session.createSQLQuery("SELECT pk_supplier_detail_id,suplier_name,gst_no,contact_person_name, supplier_Contact, supplier_emailID, supplier_City, supplier_Address, supplier_State FROM supplier_details WHERE pk_supplier_detail_id =:pkSupplierDetailId");
			 query.setParameter("pkSupplierDetailId", pkSupplierDetailId);
			 list = query.list(); 
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		 
		 finally
		 {
			 if (session!=null) {
				hbu.closeSession(session);
			}
		 }
		 System.out.println("out of dao - return credit customer List : "+list);
				return list;

		}

	
	// get supplier detail list
	 public List getAllSupplierDetailsForList(HttpServletRequest request){
			
		 HttpSession sessionn = request.getSession(true);
			String username = (String)sessionn.getAttribute("user");		
			String userid = (String)sessionn.getAttribute("userid");
			String hotelid = (String)sessionn.getAttribute("hotelid");
			String hotelname=(String)sessionn.getAttribute("hotelname");
			System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
			
			HibernateUtility hbu=null;
			Session session=null;
			List<SupplierDetailsHibernate> custList=null;
		try{	

			hbu = HibernateUtility.getInstance();
			session = hbu.getHibernateSession();

//			Query query=session.createSQLQuery("SELECT pk_supplier_detail_id,suplier_name,gst_no,contact_person_name FROM supplier_details");
			Query query=session.createSQLQuery("SELECT pk_supplier_detail_id,suplier_name,gst_no,contact_person_name, supplier_Contact, supplier_emailID, supplier_City, supplier_Address, supplier_State FROM supplier_details where hotelid = '"+hotelid+"'");
			List<Object[]> list = query.list();

			custList= new ArrayList<SupplierDetailsHibernate>(0);


		for (Object[] object : list) {	
			SupplierDetailsHibernate reports = new SupplierDetailsHibernate();
			reports.setPkSupplierDetailId(Long.parseLong(object[0].toString()));
			reports.setSuplierName(object[1].toString());
			reports.setGstNo(object[2].toString());
			reports.setContactPerson(object[3].toString());
			reports.setSuplierContact(object[4].toString());
			reports.setEmailID(object[5].toString());
			reports.setSuplierCity(object[6].toString());
			reports.setAddress(object[7].toString());
			reports.setSuplierState(object[8].toString());
			custList.add(reports);

		}}catch(RuntimeException e){	

		}
		finally{

		hbu.closeSession(session);	
		}
		return custList;

	 }
	}
