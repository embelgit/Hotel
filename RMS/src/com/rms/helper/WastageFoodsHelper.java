package com.rms.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rms.dao.WastageFooodsDao;
import com.rms.hibernate.WastageFoods;

public class WastageFoodsHelper {

	public void wastageFoods(HttpServletRequest request,
				HttpServletResponse response){
		
		String fk_item_id = request.getParameter("fk_item_id");
		String foodAmount = request.getParameter("foodAmount");
		
		WastageFoods wsf = new WastageFoods();
		
		wsf.setFk_item_id(Long.parseLong(fk_item_id));
		wsf.setFoodAmount(Double.parseDouble(foodAmount));
		
		WastageFooodsDao wastagefoodsdao = new WastageFooodsDao();
		wastagefoodsdao.addStockIntoDatabase(wsf);

	}
}
