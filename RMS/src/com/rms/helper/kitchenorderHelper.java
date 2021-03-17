package com.rms.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.dao.CustomerOrderDao;
import com.rms.dao.kitchenorderDao;
import com.rms.hibernate.CustomerOrder;

public class kitchenorderHelper {

	public void orderBill(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	//	com.rms.hibernate.kitchenorderHibernate cust = new com.rms.hibernate.kitchenorderHibernate();
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		
		Integer count = Integer.parseInt(request.getParameter("count"));
		System.out.println("count is -- "+count);
				
	      
	      for(int i=0;i<count;i++){
			
			String pkTempId = request.getParameter("pkTempId"+i);
			System.out.println("pktemp iD ---- > in kitchen - > "+pkTempId);
			Long id = Long.parseLong(pkTempId);
			
			String newTempId = request.getParameter("itemId"+i);
			Long newid = Long.parseLong(newTempId);
			
		//	cust.setItemId(newid);
//			System.out.println("Item ID ::  "+id);

			String itemName = request.getParameter("itemName"+i);
		//	cust.setItemName(itemName);
						
			String quantity= request.getParameter("quantity"+i);
			System.out.println("quantity from UI (in kitchenorder)  --------------  > > @ "+quantity);
        //    cust.setQuantity(Double.parseDouble(quantity));
                		            
            String table_No = request.getParameter("table_No");
            Long table = Long.parseLong(table_No);
			if(!"".equals(table_No)) {
     //       cust.setTableNo(Long.parseLong(table_No)); 
			}
			else {
		//		cust.setTableNo(1l);
			}
			
			String unit = request.getParameter("unit"+i);
			String value = request.getParameter("value"+i);
			
	//		System.out.println("table no when bill PRINTED IS  - - = - = - =  =  = =  "+cust.getTableNo());
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date dateobj = new Date();
//			System.out.println(df.format(dateobj));
			String newDate = df.format(dateobj);
	//		cust.setCurrent_date(dateobj);
	//		cust.setActiveYN('Y');
		//	System.out.println("item ID - "+cust.getItemId()+" ,, table no.- "+cust.getTableNo()+" ,, item name - "+cust.getItemName()+" ,, Quantity - "+cust.getQuantity()+" ,, current date - - "+cust.getCurrent_date()+"      - - -  - - --  - - in kitchen order helper ");
//			kitchenorderDao dao=new kitchenorderDao();
//			dao.orderBill(cust);
			
			kitchenorderDao daoo = new kitchenorderDao();
    	      List cblist = daoo.getAllkitchenEntry(newTempId,hotelid);
    	      
    	      if(cblist.size()==0) {
    	    	  System.out.println("if cblist size==0");
    	    	  com.rms.hibernate.kitchenorderHibernate cust = new com.rms.hibernate.kitchenorderHibernate();
    	    		cust.setItemId(newid);
    	    		cust.setItemName(itemName);
    	    		cust.setQuantity(Double.parseDouble(quantity));
    	    		cust.setTableNo(Long.parseLong(table_No));
    	    		cust.setCurrent_date(dateobj);
    	    		cust.setUnit(unit);
    	    		cust.setValue(value);
    	    		cust.setActiveYN('Y');
    	    		cust.setUsername(username);
    	    		cust.setUserid(Long.parseLong(userid));
    	    		cust.setHotelid(Long.parseLong(hotelid));
    	    		cust.setHotelname(hotelname);
    	    		System.out.println("item ID - "+cust.getItemId()+" ,, table no.- "+cust.getTableNo()+" ,, item name - "+cust.getItemName()+" ,, Quantity - "+cust.getQuantity()+" ,, current date - - "+cust.getCurrent_date()+"  unit -  --   "+cust.getUnit()+"  value - -  "+cust.getValue()+"      - - -  - - --  - - in kitchen order helper when kitchen table is empty ");
    				kitchenorderDao dao=new kitchenorderDao();
    				dao.orderBill(cust);
    	      }
    	      else
    	      {
    	    	  for(int j=0; j<cblist.size(); j++) {
    	    			com.rms.hibernate.kitchenorderHibernate kt = (com.rms.hibernate.kitchenorderHibernate)cblist.get(j);  
    	    		  System.out.println("if item exist in kitchen - -  - - - ");
    	    		  Long pkid = kt.getPk_temp_id();
    	    		  Long itemid = kt.getItemId();
    	    		  Long tab = kt.getTableNo();
    	    		  Double quan = kt.getQuantity();
    	    		  char status = kt.getActiveYN();
    	    		  System.out.println(" item ID  - "+itemid+" tableno - - "+tab+" quantity - - - "+quan+" pk ID - - - - "+pkid+" activeStatus - - - "+status);
    	    		  if(tab.equals(table) && status=='Y') {
    	    			  
    	    			  System.out.println("in if loop --------------------------   ");
    	    			  
    	    			  com.rms.utility.HibernateUtility hbu = com.rms.utility.HibernateUtility.getInstance();
    	         		 Session session = hbu.getHibernateSession();
    	         		 Transaction transaction = session.beginTransaction();
    	         		 
    	         		 DateFormat dff = new SimpleDateFormat("dd/MM/yyyy");
    	         		 Date date = new Date();
    	         	
    	         //		 Double updtequan = (double)(quan + Double.parseDouble(quantity));
    	         	//	 System.out.println("updated quantity in if loop item exist - -  - "+updtequan);
    	         		 com.rms.hibernate.kitchenorderHibernate up = (com.rms.hibernate.kitchenorderHibernate) session.get(com.rms.hibernate.kitchenorderHibernate.class, new Long(pkid));	 
    	         //		 up.setUpdateDate(date);
    	         		 
    	         		 up.setQuantity(Double.parseDouble(quantity));
    	         		
    	         		 
    	         		session.saveOrUpdate(up);
    	         		System.out.println("kitchen  updated when item exist !! object saved !");
    	         		transaction.commit();
    	         		break; 
    	    			  
    	    			  
    	    		  }
    	    		  else {
    	    			  if(j+1 == cblist.size()){
    	    			  com.rms.hibernate.kitchenorderHibernate cust = new com.rms.hibernate.kitchenorderHibernate();
    	    	    		System.out.println("if item doesnt exist in kitchen table - -  ");
    	    			  cust.setItemId(newid);
    	    	    		cust.setItemName(itemName);
    	    	    		cust.setQuantity(Double.parseDouble(quantity));
    	    	    		cust.setTableNo(Long.parseLong(table_No));
    	    	    		cust.setCurrent_date(dateobj);
    	    	    		cust.setActiveYN('Y');
    	    	    		cust.setUnit(unit);
    	    	    		cust.setValue(value);
    	    	    		cust.setUsername(username);
    	    	    		cust.setUserid(Long.parseLong(userid));
    	    	    		cust.setHotelid(Long.parseLong(hotelid));
    	    	    		cust.setHotelname(hotelname);
    	    	    		System.out.println("item ID - "+cust.getItemId()+" ,, table no.- "+cust.getTableNo()+" ,, item name - "+cust.getItemName()+" ,, Quantity - "+cust.getQuantity()+" ,, current date - - "+cust.getCurrent_date()+"  unit -  -  "+cust.getUnit()+",  value - "+cust.getValue()+"      - - -  - - --  - - in kitchen order helper when ITEM not present  ");
    	    				kitchenorderDao dao=new kitchenorderDao();
    	    				dao.orderBill(cust);
    	    			  break;
    	    			  
    	    		  } 
    	    		  
    	    	  }
    	    	  
    	    	  
    	      }
			
		}
	}
}
}