package com.rms.helper;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rms.utility.HibernateUtility;

public class loginHelper {

	public List getUsers() {
		HibernateUtility hbu=null;
		Session session=null;
		List list=null;
		//from UserDetailsBean
		try{
			 hbu = HibernateUtility.getInstance();
			 session = hbu.getHibernateSession();
			 Query query = session.createQuery("from usercreateBean");
			 list = query.list();
			 System.out.println("users  -- > "+query.list().toString());
			 System.out.println("size of list -  "+query.list().size());
		}
		catch(RuntimeException e){	
				e.printStackTrace();
		}
		finally{
			if(session!=null){
				hbu.closeSession(session);
			}	
		}
		return list;
		}
}
