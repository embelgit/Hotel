package com.rms.helper;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rms.bean.ResponseContext;
import com.rms.hibernate.UserDetailsBean;
import com.rms.hibernate.accesscontrolbean;
import com.rms.utility.HibernateUtility;
import com.sun.glass.ui.Window;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.google.gson.Gson;
import com.rms.hibernate.usercreateBean;
public class LoginController extends HttpServlet {


/*	public void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");
	
		HibernateUtility hbu = HibernateUtility.getInstance();
		Session session1 = hbu.getHibernateSession();
		
		org.hibernate.Query query = session1.createQuery("from UserDetailasHibernate where UserName = :UserName AND Password = :Password");
		
		query.setParameter("UserName", userName);
		query.setParameter("Password", password);
		
		UserDetailasHibernate uresult = (UserDetailasHibernate) query.uniqueResult();
		
		String u = uresult.getUserName();
		String p = uresult.getPassword();
	
		if(userName.equals(u) && password.equals(p))
		{
			HttpSession session = request.getSession(true); // reuse existing
			session.setAttribute("user", userName);
			response.sendRedirect("/society/jsp/MemberDetails.jsp");
		} 
		else 
		{
			response.sendRedirect("/society/jsp/login.jsp");
			out.println("<font color=red>Either Username or Password is wrong.</font>");
		}
	}
}   */
	

	public void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String un = request.getParameter("uname");
		System.out.println("username entered - - "+un);
		String pwd = request.getParameter("pass");
		System.out.println("password entered - - "+pwd);
		String userid = request.getParameter("userid");
		String hotelid = request.getParameter("hotelid");
		String hotelname = request.getParameter("hotelname");
		String usertype = request.getParameter("usertype");
		Long hid = Long.parseLong(hotelid);
		System.out.println("user -  "+un+" , hotel id - "+hotelid+"ho name- "+hotelname+" userid - "+userid);
		System.out.println("usertype in login - "+usertype);
		HibernateUtility hbu=HibernateUtility.getInstance();
		Session session1=hbu.getHibernateSession();
	//	org.hibernate.Query query = session1.createQuery(" from UserDetailsBean where UserName = :UserName AND Password = :Password ");
	//	org.hibernate.Query query = session1.createQuery("from UserDetailsBean where userName = :un AND password = :pwd AND ");
//		org.hibernate.Query query = session1.createQuery("from usercreateBean where userName = :un AND password = :pwd AND pk_create_user_id =:hid");
		org.hibernate.Query query = session1.createQuery("from accesscontrolbean where username = :un AND pass = :pwd AND hotelname =:hotelname");
		query.setParameter("un", un);
		query.setParameter("pwd", pwd);
		query.setParameter("hotelname", hotelname);
		
		System.out.println("query.list().size(); =====> -- "+query.list().size());
		Integer queryListSize = query.list().size();
		if(queryListSize == 0)
		{
			
			//System.out.println("QUERY LIST SIZE() ===> "+queryListSize);
			/*
			 * out.println("Either user name or password is wrong.");
			 * out.println("Either user name or password is wrong.");
			 */
			System.out.println("(queryListSize == 0) =====> --- "+query.list().size());
	//		response.sendRedirect("/RMS/jsp/login.jsp");	
			HttpSession session = request.getSession(false); 
			response.sendRedirect("/RMS/jsp/login.jsp");
			session.setAttribute("user", null);
//			out.println("alert('User or Password is Incorrect');");
			out.println("<font color=red>Either userName or Password is wrong.</font>");
			System.out.println("@@@@@@@@@@@@@@@@  -          login page  -");
			
		
		}
		else if(queryListSize > 0)
		{

			System.out.println("(queryListSize > 0) =====> "+query.list().size());
		
	/*	query.setParameter("userName", userName);	
		query.setParameter("Password", password);
	*/
//		UserDetailsBean uniqueResult = (UserDetailsBean) query.uniqueResult();
			accesscontrolbean uniqueResult = (accesscontrolbean) query.uniqueResult();
		
		
		
		
		String u = uniqueResult.getUsername();
		System.out.println("username --**** -"+u);
		String p = uniqueResult.getPass();
		System.out.println("password -- *** --"+p);
//		Long hidd = uniqueResult.getPk_create_user_id();
//		String hh = String.valueOf(hidd);
		String hname = uniqueResult.getHotelname();
		System.out.println("hotel get - "+hname);
		//	ResponseContext context = new ResponseContext();
		
//		System.out.println(userName);
		
		
		
			if(un.equals(u) && pwd.equals(p) && hotelname.equals(hname))
			{
				System.out.println("(queryListSize > 0) where usrnme pass are equal --  "+query.list().size());
			    
				HttpSession session = request.getSession(true); // reuse existing	
				out.print("Welcome, " + un);
				System.out.println("setting userdetails in session - ");
				session.setAttribute("user", un);
				session.setAttribute("hotelname",hotelname);
				session.setAttribute("hotelid",hotelid);
				session.setAttribute("userid",userid);
				session.setAttribute("usertype",usertype);
				// session if exist
				response.sendRedirect("/RMS/jsp/OrderBill.jsp");												// or create one
				System.out.println("order bil ----------------- ");
				
				/*	SupplierAccountDetailsHelper help = new SupplierAccountDetailsHelper();
				help.creditDebitAmount();*/
		//		session.setAttribute("user", un);
				//context.setId(1);
				 // 30 seconds
				
			} 
			else 
			{
				
				System.out.println("(queryListSize > 0) else part "+query.list().size());
				
				System.out.println("in else part --------------");
				HttpSession session = request.getSession(false); 
				response.sendRedirect("/RMS/jsp/login.jsp");
				session.setAttribute("user", null);
				
//				out.println("<font color=red>Either userName or Password is wrong.</font>");
				out.println("alert('User or Password is Incorrect');");
				//	((ServletRequest) response).getRequestDispatcher("/processSoft/jsp/login.jsp");
			//	response.sendRedirect("/your/new/location.jsp")
				//RequestDispatcher rd = request.getRequestDispatcher("/SMT/jsp/login.jsp");
			
					
		//		out.println("alert('User or password is incorrect');");
		      
		   }
			
		}	
		
	/*	
		
		
		
		query.setParameter("username", un);
		query.setParameter("pwd", pwd);
		UserDetailsBean unique = (UserDetailsBean) query.uniqueResult();
		//System.out.println();
		String userName = unique.getUserName();
		String password = unique.getPassword();
		System.out.println(userName+"User name in login helper");
		System.out.println(password+"password in login helper");
	
		
		
   if(unique != null){
	   
	 
		out.print("Welcome, " + un);
		HttpSession session = request.getSession(true);
		response.sendRedirect("/Fertilizer/jsp/index.jsp");
		session.setAttribute("user", un);
		HttpSession session = request.getSession(true); // reuse existing
		response.sendRedirect("/Fertilizer/jsp/index.jsp");												// or create one
		session.setAttribute("user", un);*
		 // 30 seconds
		}
	else{
		
		
		    response.sendRedirect("/Fertilizer/jsp/login.jsp");
	}*/
 }

	public void language(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String lan = request.getParameter("language");
		HttpSession session = request.getSession(true); // reuse existing
		// session if exist
											// or create one
        session.setAttribute("lan", lan);
	}

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
