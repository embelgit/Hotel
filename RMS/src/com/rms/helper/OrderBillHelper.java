package com.rms.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.GetItemDetails;
import com.rms.dao.OrderBillDao;
import com.rms.dao.hotelnamedao;
import com.rms.hibernate.OrderBill;
import com.rms.hibernate.SupplierDetailsHibernate;
import com.rms.hibernate.hotelnamebean;
import com.rms.hibernate.kitchenorderHibernate;
import com.rms.utility.HibernateUtility;

public class OrderBillHelper {

	public void billOrder(HttpServletRequest request, HttpServletResponse response) {

		String fk_waiter_name_id = request.getParameter("fk_waiter_name_id");
		String table_No = request.getParameter("table_No");
		String quantity = request.getParameter("quantity");
		String total_amount = request.getParameter("total_amount");
		String fk_table_id = request.getParameter("fk_table_id");
		String fk_item_id = request.getParameter("fk_item_id");
		String fk_user_id = request.getParameter("fk_user_id");

		OrderBill order = new OrderBill();

		order.setFk_waiter_name_id(Long.parseLong(fk_waiter_name_id));
		order.setTable_No(Long.parseLong(table_No));
		order.setQuantity(Long.parseLong(quantity));
		order.setTotal_amount(Long.parseLong(total_amount));
		order.setFk_table_id(Long.parseLong(fk_table_id));
		order.setFk_item_id(Long.parseLong(fk_item_id));
		order.setFk_user_id(Long.parseLong(fk_user_id));

		OrderBillDao obd = new OrderBillDao();
		obd.orderBill(order);

	}

	public Map getSubCategoriesByRootcategory(String catID) {
		System.out.println(catID + "CAT ID FROM HELPER");
		// String catId = request.getParameter("catId");

		// Map<Long,SubCategory> map = new HashMap<Long,SubCategory>();

		// AddItemDao dao = new AddItemDao();
		// List catList = dao.getSubCategoriesByRootcategory(catID);
		// System.out.println(catList.size()+"LIST SIZE");
		Map map1 = new HashMap();
		// for(int i=0;i<catList.size();i++)
		{
			// Object[] o = (Object[])catList.get(i);
			// GetSubcategory bean = new GetSubcategory();
			// bean.setSubcat_id((Long)o[0]);
			// bean.setSubcat_name((String)o[1]);

			// System.out.println("***************"+o[0]+"\t"+o[1]);
			// map1.put(bean.getSubcat_id(),bean);
		}
		return map1;
	}

	public List getItemDetailsById(HttpServletRequest request, HttpServletResponse response) {

		HttpSession sessionn = request.getSession(true);
		String username = (String) sessionn.getAttribute("user");
		String user = (String) sessionn.getAttribute("userid");
		String hotel = (String) sessionn.getAttribute("hotelid");
		Long hotelid = Long.parseLong(hotel);
		Long userid = Long.parseLong(user);
		String hotelname = (String) sessionn.getAttribute("hotelname");
		System.out.println("session thru user- " + username + " , id - " + userid + " , hotelnme - " + hotelname
				+ " , hotelid - " + hotelid);

		String fk_item_id = request.getParameter("fk_item_id");
		String tableNo = request.getParameter("tableNo");
		System.out.println("table no (helper) is ---  " + tableNo);
		System.out.println("fk item id-- " + fk_item_id);
		System.out.println(fk_item_id + " --- vxvdfvdf");

		Map<Long, GetItemDetails> map = new HashMap<Long, GetItemDetails>();

		OrderBillDao dao = new OrderBillDao();
		List<GetItemDetails> saleList = dao.getItemDetailsById(fk_item_id, tableNo, hotelid, userid, username,
				hotelname);

		return saleList;

	}

	public Map gettableToEdit(Long id) {

		System.out.println("into helper class");
		OrderBillDao dao1 = new OrderBillDao();
		List catList = dao1.gettableForEdit(id);

		Map map = new HashMap();
		for (int i = 0; i < catList.size(); i++) {
			Object[] o = (Object[]) catList.get(i);
			System.out.println("result - " + Arrays.toString(o));
			OrderBill b = new OrderBill();
			b.setFk_table_id(Long.parseLong(o[0].toString()));
			b.setTable_No(Long.parseLong(o[1].toString()));

//			System.out.println("TYPE is ------ "+b.getType()+", unit  -  "+b.getUnit()+" ,,  value -  "+b.getValue());
			map.put(b.getFk_table_id(), b);
		}
		System.out.println("out of helper return map : " + map.size());
		return map;

	}

	/*
	 * public void edittable1(HttpServletRequest request, HttpServletResponse
	 * response) {
	 * 
	 * HttpSession session = request.getSession(true); String pk_id
	 * =(String)session.getAttribute("pk_id"); String table_No
	 * =(String)session.getAttribute("table_No");
	 * 
	 * String username = (String)session.getAttribute("user"); String userid =
	 * (String)session.getAttribute("userid"); String hotelid =
	 * (String)session.getAttribute("hotelid"); String
	 * hotelname=(String)session.getAttribute("hotelname");
	 * 
	 * System.out.println("session thru pk_id- "+pk_id+" , table_No - "+table_No);
	 * String fk_tableid = request.getParameter("fk_table_id"); Long table_no =
	 * Long.parseLong(table_No); //String table_no =
	 * request.getParameter("table_No");
	 * System.out.println("table number in helper -- "+table_no); HibernateUtility
	 * hbu = null; Session sessionn = null; Transaction transaction = null;
	 * 
	 * hbu = HibernateUtility.getInstance(); sessionn = hbu.getHibernateSession();
	 * transaction = sessionn.beginTransaction();
	 * 
	 * System.out.println("%%%%%%%%%%%%%%%%% pk_id :" + pk_id); long fk_table_id1 =
	 * Long.parseLong(pk_id); //String fk_table_id1 =
	 * request.getParameter("fk_table_id"); OrderBill iet = (OrderBill)
	 * sessionn.get(OrderBill.class, pk_id);
	 * 
	 * 
	 * if(!"".equals(table_no)) { iet.setTable_No(table_no); }
	 * 
	 * else { iet.setTable_No(0); }
	 * 
	 * 
	 * sessionn.saveOrUpdate(iet); transaction.commit(); sessionn.close();
	 * System.out.println("Record updated successfully.");
	 * 
	 * 
	 * }
	 */

	public void edittable(HttpServletRequest request, HttpServletResponse response) {

		HttpSession sessionn = request.getSession(true);
		String username = (String) sessionn.getAttribute("user");
		String userid = (String) sessionn.getAttribute("userid");
		String hotelid = (String) sessionn.getAttribute("hotelid");
		String hotelname = (String) sessionn.getAttribute("hotelname");
		System.out.println("session thru user- " + username + " , id - " + userid + " , hotelnme - " + hotelname
				+ " , hotelid - " + hotelid);

		String pk_temp_id = request.getParameter("pk_id");
		System.out.println("Table edit ------ " + pk_temp_id);

		String tableNo = request.getParameter("tableNo");

		System.out.println("Table Number ------ " + tableNo);

		com.rms.utility.HibernateUtility hbu = null;
		Session session = null;
		Transaction transaction = null;

		hbu = HibernateUtility.getInstance();
		session = hbu.getHibernateSession();
		transaction = session.beginTransaction();

		long tableInfoID = Long.parseLong(pk_temp_id);
		kitchenorderHibernate det = (kitchenorderHibernate) session.load(kitchenorderHibernate.class, tableInfoID);

		det.setUsername(username);
		det.setUserid(Long.parseLong(userid));
		det.setHotelid(Long.parseLong(hotelid));
		det.setHotelname(hotelname);
		/*
		 * if(!"".equals(pk_temp_id)){ det.setPk_temp_id(Long.parseLong(pk_temp_id)); }
		 * else { det.setPk_temp_id(Long.parseLong("00")); }
		 */
		
	
		
		if (!"".equals(tableNo)) {
			det.setTableNo(Long.parseLong(tableNo));
		} else {
			det.setTableNo(Long.parseLong("0"));
		}
		

		session.saveOrUpdate(det);
		transaction.commit();

	}

	public Map gettableForEdit(Long Fk_table_id) {

		System.out.println("into helper class");
		OrderBillDao dao1 = new OrderBillDao();
		List catList = dao1.gettableForEdit1(Fk_table_id);

		Map map = new HashMap();
		for (int i = 0; i < catList.size(); i++) {
			Object[] o = (Object[]) catList.get(i);
			System.out.println("result - " + Arrays.toString(o));
			kitchenorderHibernate b = new kitchenorderHibernate();
			b.setPk_temp_id(Long.parseLong(o[1].toString()));
			b.setTableNo(Long.parseLong(o[1].toString()));
//		System.out.println("TYPE is ------ "+b.getType()+", unit  -  "+b.getUnit()+" ,,  value -  "+b.getValue());
			map.put(b.getPk_temp_id(), b);
		}
		System.out.println("out of helper return map : " + map.size());
		return map;

	}
}
