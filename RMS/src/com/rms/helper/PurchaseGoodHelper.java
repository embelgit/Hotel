package com.rms.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.rms.dao.PurchaseGoodDao;
import com.rms.hibernate.PurchaseGood;

public class PurchaseGoodHelper {

	public void purchaseDetails (HttpServletRequest request, HttpServletResponse response){
		
		String vegetables=request.getParameter("vegetables");
		String grocery=request.getParameter("grocery");
		String other=request.getParameter("other");
		/*String itemName=request.getParameter("itemName");
		String price=request.getParameter("price");*/
		String total=request.getParameter("total");
		
		PurchaseGood pg = new PurchaseGood();
		
		pg.setVegetables(vegetables);
		pg.setGrocery(grocery);
		pg.setOther(other);
		/*pg.setItemName(itemName);
		pg.setPrice(price);*/
		pg.setTotal(total);
		
		
		PurchaseGoodDao  pg1=new PurchaseGoodDao();
		pg1.addGood(pg);
		
	}
}
