package com.rms.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rms.bean.GetStoreManagementDetailBean;
import com.rms.bean.StockEntryReportBean;
import com.rms.dao.StockManagementDao;
import com.rms.hibernate.StockManagementHibernate;

public class StockManagementHelper {

public GetStoreManagementDetailBean getGridForStoreManagement(String fk_item_id_drop1) {
		
		GetStoreManagementDetailBean bean = new GetStoreManagementDetailBean();

			bean.setProductName(fk_item_id_drop1);
			System.out.println("fk_item_id_drop1 "+fk_item_id_drop1);
			return bean;
	
}
	//adding stock
	public void doaddStoreManagement(HttpServletRequest request,
			HttpServletResponse response) {
		
		 Integer count = Integer.parseInt(request.getParameter("count"));
         System.out.println(count);
         for(int i =0 ; i<count;i++)
 		{
        
        String fk_item_id = request.getParameter("fk_item_id");
        String fkSupplierId = request.getParameter("fk_supplier_id");	
        String fk_item_id_drop1 = request.getParameter("fk_item_id_drop1"+i);
        String supplierName = request.getParameter("supplierName"+i);
        String buyPrice = request.getParameter("buyPrice"+i);
        String billno = request.getParameter("billno"+i);
 
        String quantity = request.getParameter("quantity"+i);
        String total = request.getParameter("total"+i);
        String grossTotal = request.getParameter("grossTotal");	
 		
        StockManagementHibernate b = new StockManagementHibernate();
        
        b.setFk_item_id(Long.parseLong(fk_item_id));
        b.setFkSupplierId(Long.parseLong(fkSupplierId));
 		b.setFk_item_id_drop1(fk_item_id_drop1);
 		b.setSupplierName(supplierName);
 		b.setBuyPrice(Double.parseDouble(buyPrice));
 		b.setQuantity(Double.parseDouble(quantity));
 		b.setTotal(Double.parseDouble(total));
 		b.setGrossTotal(Double.parseDouble(grossTotal));
 		
 		StockManagementDao dao = new StockManagementDao();
 		dao.addStockIntoDatabase(b);
 		}
	}

	// get stock entry report
			public List getStockEntryReport(HttpServletRequest request,
					HttpServletResponse response) {

			        Map<Long,StockEntryReportBean> map = new HashMap<Long,StockEntryReportBean>();
					
			        StockManagementDao dao = new StockManagementDao();
					List<StockEntryReportBean> exp1List = dao.getStockEntryReport();
					
					return exp1List;
			}
	}
