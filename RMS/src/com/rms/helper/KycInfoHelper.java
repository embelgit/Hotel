package com.rms.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rms.dao.KycInfoDao;
import com.rms.hibernate.KycInfoHibernate;

public class KycInfoHelper {
	public void doKycDetails(HttpServletRequest request,
			HttpServletResponse response) {
		
		String fk_item_id = request.getParameter("fk_item_id");
		String fk_item_id_drop = request.getParameter("fk_item_id_drop");	

		String tableNo = request.getParameter("tableNo");	
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String KYCDate = request.getParameter("KYCDate");
		
		KycInfoHibernate sd = new KycInfoHibernate();
		
		System.out.println(" date before parsing" +KYCDate);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = null;
		
		try{
			dateOfBirth = format.parse(KYCDate);
			sd.setKYCDate(dateOfBirth);
			System.out.println(" date dateOfBirth parsing" +dateOfBirth);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in date parsing");
		}
		
		sd.setFk_item_id(Long.parseLong(fk_item_id));
		sd.setFk_item_id_drop(fk_item_id_drop);
		sd.setTableNo(Long.parseLong(tableNo));
		sd.setQuantity(Long.parseLong(quantity));
		sd.setPrice(Double.parseDouble(price));
		
		KycInfoDao dao = new KycInfoDao();
		dao.KycInfoHibernate(sd);

   }

}
