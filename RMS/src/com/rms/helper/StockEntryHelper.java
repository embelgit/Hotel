package com.rms.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rms.bean.StockEntryReportBean;
import com.rms.dao.StockEntryDao;
import com.rms.hibernate.StockEntryHibernate;

public class StockEntryHelper {

	public void doStockEntry(HttpServletRequest request,
			HttpServletResponse response) {
	
		String itemName = request.getParameter("itemName");	
	    String buyPrice = request.getParameter("buyPrice");
	    String quantity = request.getParameter("quantity");
		String gst = request.getParameter("gst");
		String grossTotal = request.getParameter("grossTotal");
		
		StockEntryHibernate stk = new StockEntryHibernate();
		
		stk.setItemName(itemName);
		stk.setBuyPrice(Double.parseDouble(buyPrice));
		stk.setQuantity(Double.parseDouble(quantity));
		stk.setGst(Double.parseDouble(gst));
		stk.setBuyPrice(Double.parseDouble(buyPrice));
		stk.setGrossTotal(Double.parseDouble(grossTotal));
		
		StockEntryDao dao = new StockEntryDao();
		dao.StockEntryHibernate(stk);
}
	
/*	// get stock entry report
		public List getStockEntryReport(HttpServletRequest request,
				HttpServletResponse response) {
			// TODO Auto-generated method stub

		        Map<Long,StockEntryReportBean> map = new HashMap<Long,StockEntryReportBean>();
				
		        StockEntryDao dao = new StockEntryDao();
				List<StockEntryReportBean> exp1List = dao.getStockEntryReport();
				
				return exp1List;
		}*/
}
