package com.rms.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rms.bean.BarcodeReportBean;
import com.rms.bean.GoodreciveBillBean;
import com.rms.bean.PreviousGoodReceive;
import com.rms.bean.PurchaseReport;
import com.rms.dao.GoodReciveDao;
import com.rms.dao.StockDao;
import com.rms.hibernate.GoodReceive;
import com.rms.hibernate.Stock;
import com.rms.utility.HibernateUtility;

public class GoodReceiveHelper {

	Long barcodeNo = 1000l;

	public void regGoodReceive(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession sessionn = request.getSession(true);
		String username = (String)sessionn.getAttribute("user");		
		String userid = (String)sessionn.getAttribute("userid");
		String hotelid = (String)sessionn.getAttribute("hotelid");
		String hotelname=(String)sessionn.getAttribute("hotelname");
		System.out.println("session thru user- "+username+" , id - "+userid+" , hotelnme - "+hotelname+" , hotelid - "+hotelid);
		GoodReceive goodsReceived = new GoodReceive();

		Integer count = Integer.parseInt(request.getParameter("count"));
		
		System.out.println("c111111" + count);

		for (int i = 0; i < count; i++) {
			/*Integer countreForSubValues = Integer.parseInt(request.getParameter("countForSubGrid"+i));
			for (int k = 0; k < countreForSubValues; k++) {*/

				HttpSession session3 = request.getSession();
				GoodReciveDao data = new GoodReciveDao();
				/*List stkList = data.getLastBarcodeNo();

				for (int j = 0; j < stkList.size(); j++) {

					GoodreciveBillBean st = (GoodreciveBillBean) stkList.get(j);
					barcodeNo = st.getBarcodeNo();

					barcodeNo++;

				}*/
				String color = request.getParameter("color" + i+""/*+k*/);
				System.out.println("Color is :++++++++++++"+color);
				goodsReceived.setColor(color);

				String size = request.getParameter("size" + i+""/*+k*/);
				System.out.println("Size is :++++++++++++"+size);
				goodsReceived.setSize(size);

				String quantity = request.getParameter("quantity" + i+""/*+k*/);
				goodsReceived.setQuantity(Double.parseDouble(quantity));
				goodsReceived.setOringnalQuantity(Double.parseDouble(quantity));

				String itemName = request.getParameter("itemName" + i);
				goodsReceived.setItemName(itemName);

				String catName = request.getParameter("catName" + i);
				goodsReceived.setCatName(catName);

				/*
				 * String quantity = request.getParameter("quantity" + i);
				 * goodsReceived.setQuantity(Long.parseLong(quantity));
				 * goodsReceived.setOringnalQuantity(Long.parseLong(quantity));
				 */

				String buyPrice = request.getParameter("buyPrice" + i);
				goodsReceived.setBuyPrice(Double.parseDouble(buyPrice));

				String salePrice = request.getParameter("salePrice" + i);
				goodsReceived.setSalePrice(Double.parseDouble(salePrice));

				String hsnsacno = request.getParameter("hsnsacno" + i);
				goodsReceived.setHsnsacno(hsnsacno);

				String Total = request.getParameter("Total" + i);
				goodsReceived.setTotal(Double.parseDouble(Total));

				String billNo = request.getParameter("billNo");
				goodsReceived.setBillNo(billNo);

				String contactPerson = request.getParameter("contactPerson");
				goodsReceived.setContactPerson(contactPerson);

				String vat = request.getParameter("vat" + i);
				Double gst = Double.parseDouble(vat);
				Double mainGst = gst;
				System.out.println("VAt is "+mainGst);
				if(vat==null){
					goodsReceived.setVat(0.0);
				}
				else{
					goodsReceived.setVat(mainGst);
				}

				String igst = request.getParameter("igst" + i);
				System.out.println("igst is "+igst);
				if(igst==null){
					goodsReceived.setIgst(0.0);
				}
				else{
					goodsReceived.setIgst(Double.parseDouble(igst));
				}
				

				String gstamt = request.getParameter("gstamt" + i);
				System.out.println("gstamt is "+gstamt);
				if(gstamt==null){
					goodsReceived.setTaxAmount(0.0);
				}
				else{
					goodsReceived.setTaxAmount(Double.parseDouble(gstamt));
				}
				
				String actualprice = request.getParameter("actualprice" + i);

				String extraDiscount = request.getParameter("extraDiscount");
				goodsReceived.setExtraDiscount(Double.parseDouble(extraDiscount));

				String expence = request.getParameter("expence");
				goodsReceived.setExpence(Double.parseDouble(expence));

				String resolution = request.getParameter("resolution");
				goodsReceived.setGrossTotal(Double.parseDouble(resolution));

				String supplierId = request.getParameter("supplierId");
				goodsReceived.setSupplierName(Long.parseLong(supplierId));

				String pDate = request.getParameter("pDate");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

				double discontTotal = Double.parseDouble(Total);
				double data1 = Double.parseDouble(quantity);

				double discontValue = (discontTotal / data1);

				long data5 = (long) discontValue;
				System.out.println("print BuyPrice ::  " + data5);
				String data6 = String.valueOf(data5);
				String xyz = "";
				String adc = "";
				String[] Shreemant;
				if (actualprice.equals("0.0")) {
					Shreemant = data6.split("");
				} else {
					Shreemant = actualprice.split("");
				}
				for (int a = 0; a < Shreemant.length; a++) {
					System.out.println("shreemant :: " + Shreemant[a]);
					String abc = Shreemant[a];
					if (abc.equals("1")) {
						adc = "N";
					}
					if (abc.equals("2")) {
						adc = "A";
					}
					if (abc.equals("3")) {
						adc = "G";
					}
					if (abc.equals("4")) {
						adc = "P";
					}
					if (abc.equals("5")) {
						adc = "U";
					}
					if (abc.equals("6")) {
						adc = "R";
					}
					if (abc.equals("7")) {
						adc = "C";
					}
					if (abc.equals("8")) {
						adc = "I";
					}
					if (abc.equals("9")) {
						adc = "T";
					}
					if (abc.equals("0")) {
						adc = "Y";
					}
					xyz = xyz.concat(adc);
				}

				Date adate = null;
				try {
					adate = format.parse(pDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				goodsReceived.setDate(adate);

				session3.setAttribute("barcodeNo", barcodeNo);

				if (barcodeNo == null) {
					goodsReceived.setBarcodeNo(1000l);
				} else {
					goodsReceived.setBarcodeNo(barcodeNo);
				}

				GoodReciveDao dao = new GoodReciveDao();
				dao.regGoodReceive(goodsReceived);

				StockDao dao1 = new StockDao();
				List stkList2 = dao1.getAllStockEntry(itemName,hotelid);

				Double quant = Double.parseDouble(quantity);

				// Barcode Code By Meghraj

				try {

					FileInputStream fstream = new FileInputStream("C:/barcose/input.prn");

					BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
					FileWriter fw = new FileWriter("C:/barcose/Output" + i + ".prn");

					BufferedWriter bw = new BufferedWriter(fw);
					String strLine;
					String str1;
					while ((strLine = br.readLine()) != null) {

						if (strLine.equals("~product")) {
							str1 = br.readLine();
							strLine = str1 + "\"Ghantalwar Mens Wear\"";
						} 
						else if (strLine.equals("~quanti")) 
						{
							str1 = br.readLine();
							strLine = str1 +"\""+itemName+"\"";
						}
						else if(strLine.equals("~catName"))
				         {
							str1=br.readLine();
				            strLine = str1 +"\"" +itemName+ "\"";
				               
				         }
						else if(strLine.equals("~bar"))
				         {
							str1=br.readLine();
				            strLine = str1 +"\"" +barcodeNo+ "\"";
				         }
						else if(strLine.equals("~company"))
				         {
							str1=br.readLine();
				            strLine = str1 + "\"" +catName+ "\"";
				         }
						else if(strLine.equals("~total"))
				         {
							str1=br.readLine();
				            strLine = str1 + "\"" +xyz+ "\"";
				               
				         }
						else if(strLine.equals("~quantityForNumberOfPrint"))
				         {
							str1=br.readLine();
				            strLine = str1 + quantity ;
				               
				         }
						System.out.println(strLine);
						bw.write(strLine + "\r\n");

					
						}
					System.out.println("xyz is "+xyz);
					System.out.println("catName is "+catName);
					System.out.println("Barcode is "+barcodeNo);
					System.out.println("itemName is "+itemName);
					bw.close();
					// Close the input stream
					br.close();

					List cmdAndArgs = Arrays.asList("cmd", "/c", "printbatch" + i + ".bat");
					File dir = new File("C:/barcose");

					ProcessBuilder pb = new ProcessBuilder(cmdAndArgs);
					pb.directory(dir);
					Process p = pb.start();
					/* } */
				} catch (Exception e) {

				}

				// End Barcode code

				/* If Stock Is Empty */
				/*if (stkList2.size() == 0) {

					Stock newEntry = new Stock();

					newEntry.setItemName(itemName);
					newEntry.setQuantity(Double.parseDouble(quantity));
					newEntry.setCatName(catName);

					StockDao dao2 = new StockDao();
					dao2.registerStock(newEntry);

				}*/ /*else To Update Stock Table If It is Not Empty 
				{

					for (int j = 0; j < stkList2.size(); j++) {

						Stock st = (Stock) stkList2.get(j);
						String ItemId = st.getItemName();
						String cat = st.getCatName();
						Long PkItemId = st.getPkStockId();

						 If ItemName Is Already Exists In Stock Table 
						if (ItemId.equals(itemName) && cat.equals(catName)) {
							Double qunty = st.getQuantity();

							Double updatequnty = (Double) (qunty + Double.parseDouble(quantity));

							HibernateUtility hbu = HibernateUtility.getInstance();
							Session session = hbu.getHibernateSession();
							Transaction transaction = session.beginTransaction();

							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							Date date = new Date();

							Stock updateStock = (Stock) session.get(Stock.class, new Long(PkItemId));
							updateStock.setUpdateDate(date);
							updateStock.setQuantity(updatequnty);

							session.saveOrUpdate(updateStock);
							transaction.commit();
							break;
						} else {
							 ItemName is Not Exists 
							if (j + 1 == stkList2.size()) {

								Stock newEntry = new Stock();

								newEntry.setItemName(itemName);
								newEntry.setQuantity(Double.parseDouble(quantity));
								newEntry.setCatName(catName);

								StockDao dao2 = new StockDao();
								dao2.registerStock(newEntry);

							}
						}

					}

				}*/
			}
		}
	/*}*/
	// get all purchase bill no
	public List getBillNo() {
		GoodReciveDao dao = new GoodReciveDao();
		return dao.getBillNo();
	}
	
	//get Previous Good Receive Detail
		public List getPreGoodReceive(HttpServletRequest request,
				HttpServletResponse response) {
			// TODO Auto-generated method stub
			String BillNo = "";
			GoodReciveDao data = new GoodReciveDao();
			List stkList  = data.getLastBarcodeNo();
			
			for(int j=0;j<stkList.size();j++){
				
				GoodreciveBillBean st = (GoodreciveBillBean)stkList.get(j);
				BillNo = st.getBillNo();
				
			}
			
            Map<Long,PreviousGoodReceive> map = new HashMap<Long,PreviousGoodReceive>();
			
			GoodReciveDao dao = new GoodReciveDao();
			System.out.println("BILL NO ::: "+ BillNo);
			List<PreviousGoodReceive> exp1List = dao.getPreGoodReceive(BillNo);
			return exp1List;
		}
		
		// get all main barcode no	
		public List getAllMainBarcodeNo()
		{
			GoodReciveDao dao = new GoodReciveDao();
			return dao.getAllMainBarcodeNo();
		}
       // print barcode
		public void printBarcode(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			String barcodeId = request.getParameter("barcodeId");
			String quantity = request.getParameter("quantity");
			long bar = Long.parseLong(barcodeId);
			
			HibernateUtility hbu=HibernateUtility.getInstance();
			Session session1=hbu.getHibernateSession();
			org.hibernate.Query query = session1.createQuery("from GoodReceive where barcodeNo = :bar");
			query.setParameter("bar", bar);
			
			GoodReceive uniqueResult = (GoodReceive) query.uniqueResult();
			String itemName = uniqueResult.getItemName();
			String catName = uniqueResult.getCatName();
			Double buyPrice = uniqueResult.getBuyPrice();
			
			String data6 = String.valueOf(buyPrice);
			String xyz = "";
			String adc = "";
			String[] Shreemant = data6.split("");
			for(int a = 0; a<Shreemant.length; a++){
				System.out.println("shreemant :: " + Shreemant[a]);
				String abc = Shreemant[a];
				if(abc.equals("1")){
			        adc = "N";
				}
				if(abc.equals("2")){
					adc = "A";
				}
				if(abc.equals("3")){
					adc = "G";
				}
				if(abc.equals("4")){
					adc = "P";
				}
				if(abc.equals("5")){
					adc = "U";
				}
				if(abc.equals("6")){
					adc = "R";
				}
				if(abc.equals("7")){
					adc = "C";
				}
				if(abc.equals("8")){
					adc = "I";
				}
				if(abc.equals("9")){
					adc = "T";
				}
				if(abc.equals("0")){
					adc = "Y";
				}
				xyz = xyz.concat(adc);
			}
			
            try {
				FileInputStream fstream = new FileInputStream(
						"C:/barcose/input.prn");

				BufferedReader br = new BufferedReader(new InputStreamReader(
						fstream));
				FileWriter fw = new FileWriter("C:/barcose/Output.prn");

				BufferedWriter bw = new BufferedWriter(fw);
				String strLine;
				String str1;
				while ((strLine = br.readLine()) != null) {

					if (strLine.equals("~product")) {
						str1 = br.readLine();
						strLine = str1 + "\"Ghantalwar Mens Wear\"";
					} 
					else if (strLine.equals("~quanti")) 
					{
						str1 = br.readLine();
						strLine = str1 +"\""+itemName+"\"";
					}
					else if(strLine.equals("~catName"))
			         {
						str1=br.readLine();
			            strLine = str1 +"\"" +itemName+ "\"";
			               
			         }
					else if(strLine.equals("~bar"))
			         {
						str1=br.readLine();
			            strLine = str1 +"\"" +barcodeNo+ "\"";
			         }
					else if(strLine.equals("~company"))
			         {
						str1=br.readLine();
			            strLine = str1 + "\"" +catName+ "\"";
			         }
					else if(strLine.equals("~total"))
			         {
						str1=br.readLine();
			            strLine = str1 + "\"" +xyz+ "\"";
			               
			         }
					else if(strLine.equals("~quantityForNumberOfPrint"))
			         {
						str1=br.readLine();
			            strLine = str1 + quantity ;
			               
			         }
					System.out.println(strLine);
					bw.write(strLine + "\r\n");

				
					}

				bw.close();
				// Close the input stream
				br.close();
				
		        List cmdAndArgs = Arrays.asList("cmd", "/c", "printbatch.bat");
				File dir = new File("C:/barcose");


				ProcessBuilder pb = new ProcessBuilder(cmdAndArgs);
				pb.directory(dir);
				Process p = pb.start();
				/*}*/
			} catch (Exception e) {

			}
			
		}
		
		//get Barcode Wise report
				public List BarcodeWiseReport(HttpServletRequest request,
						HttpServletResponse response) {
					// TODO Auto-generated method stub
					String catName = request.getParameter("catName");
					Long barcodeId = Long.parseLong(catName);
				
					 Map<Long,BarcodeReportBean> map = new HashMap<Long,BarcodeReportBean>();
						
					    GoodReciveDao dao = new GoodReciveDao();
						List<BarcodeReportBean> exp1List = dao.BarcodeWiseReport(barcodeId);
						
						return exp1List;
				}
				
				//SupplierName Wise purchase report
				public List getsuppliernamewisepurchaseReport(String supplier) {
					
					Map<String,PurchaseReport> map = new HashMap<String,PurchaseReport>();
					
				    GoodReciveDao dao = new GoodReciveDao();
					List<PurchaseReport> exp1List = dao.suppliernamewiseAllPurchase(supplier);
					
					return exp1List;
				}
				
				 //Purchase Report Category Wise
				public List categoryWisePurchaseReport(HttpServletRequest request, HttpServletResponse response) {
					// TODO Auto-generated method stub
					 String catName = request.getParameter("catName");
					 Map<Long,PurchaseReport> map = new HashMap<Long,PurchaseReport>();
						
					    GoodReciveDao dao = new GoodReciveDao();
						List<PurchaseReport> exp1List = dao.categoryWisePurchaseReport(catName);
						
						return exp1List;
				}
				
				//Purchase Report Supplier Bill No Wise
				public List supplierBillWisePurchaseReport(HttpServletRequest request, HttpServletResponse response) {
					// TODO Auto-generated method stub
					long supplier = Long.parseLong(request.getParameter("supplier"));
					String billNo = request.getParameter("billNo");
					 Map<Long,PurchaseReport> map = new HashMap<Long,PurchaseReport>();
						
					    GoodReciveDao dao = new GoodReciveDao();
						List<PurchaseReport> exp1List = dao.supplierBillWisePurchaseReport(supplier,billNo);
						
						return exp1List;
				}
				
				//Purchase Report Barcode No Wise
				public List barcodeWisePurchaseReport(HttpServletRequest request, HttpServletResponse response) {
					// TODO Auto-generated method stub
					 String barcodeNoOurchase = request.getParameter("barcodeNoOurchase");
					 Map<Long,PurchaseReport> map = new HashMap<Long,PurchaseReport>();
						
					    GoodReciveDao dao = new GoodReciveDao();
						List<PurchaseReport> exp1List = dao.barcodeWisePurchaseReport(barcodeNoOurchase);
						
						return exp1List;
				}
				
				//Purchase Report Single Date
				public List singleDatePurchase45(HttpServletRequest request, HttpServletResponse response) {
					// TODO Auto-generated method stub
					String fDate = request.getParameter("purDate");
			        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					Date adate = null;
					try {
					 adate=	format.parse(fDate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					 Map<Long,PurchaseReport> map = new HashMap<Long,PurchaseReport>();
						
					    GoodReciveDao dao = new GoodReciveDao();
						List<PurchaseReport> exp1List = dao.singleDatePurchase45(adate);
						
						return exp1List;
				}
				
				//Purchase Report Two Date
				public List twoDatePurchase45(HttpServletRequest request, HttpServletResponse response) {
					// TODO Auto-generated method stub
					String pFisDate = request.getParameter("pFisDate");
					String pEndDate = request.getParameter("pEndDate");
			        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					Date adate = null;
					Date bdate = null;
					try {
					 adate=	format.parse(pFisDate);
					 bdate=	format.parse(pEndDate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					 Map<Long,PurchaseReport> map = new HashMap<Long,PurchaseReport>();
						
					    GoodReciveDao dao = new GoodReciveDao();
						List<PurchaseReport> exp1List = dao.twoDatePurchase45(adate,bdate);
						
						return exp1List;
				}
				
				//CA Purchase Report Two Date
				public List caReportBetweenTwoDates(HttpServletRequest request, HttpServletResponse response) {
					// TODO Auto-generated method stub
					String pFisDate = request.getParameter("fisDate1");
					String pEndDate = request.getParameter("endDate1");
			        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					Date adate = null;
					Date bdate = null;
					try {
					 adate=	format.parse(pFisDate);
					 bdate=	format.parse(pEndDate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					 Map<Long,PurchaseReport> map = new HashMap<Long,PurchaseReport>();
						
					    GoodReciveDao dao = new GoodReciveDao();
						List<PurchaseReport> exp1List = dao.caReportBetweenTwoDates(adate,bdate);
						
						return exp1List;
				}

}
