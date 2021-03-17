package com.rms.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rms.dao.WastageGooodsDao;
import com.rms.hibernate.WastageGoods;

public class WastageGoodsHelper {

	public void wastageGoods(HttpServletRequest request,
				HttpServletResponse response){
		
		String vagetablesName = request.getParameter("vegetableName");
		String amount = request.getParameter("amount");
		System.out.println("r111111111111"+vagetablesName);
		WastageGoods wastagegoods = new WastageGoods();
		
		wastagegoods.setVagetablesName(vagetablesName);
		wastagegoods.setAmount(Double.parseDouble(amount));
		
		WastageGooodsDao wastagegoodsdao = new WastageGooodsDao();
		wastagegoodsdao.wastageGoods(wastagegoods);

	}
}
