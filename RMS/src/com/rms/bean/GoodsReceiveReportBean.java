package com.rms.bean;

public class GoodsReceiveReportBean {
	
	private Long pkStockEntry;
	private Long srNo;
	private String productName;
	private String suplierName;
	private Double billno;
	private Double buyPrice;
	private Double quantity;
	private Double total;
	private Double grossTotal;
	private String goodsReceiveDate;
	private String Grid_total;
	
	public String getGrid_total() {
		return Grid_total;
	}
	public void setGrid_total(String grid_total) {
		Grid_total = grid_total;
	}
	public Long getPkStockEntry() {
		return pkStockEntry;
	}
	public void setPkStockEntry(Long pkStockEntry) {
		this.pkStockEntry = pkStockEntry;
	}
	public Long getSrNo() {
		return srNo;
	}
	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSuplierName() {
		return suplierName;
	}
	public void setSuplierName(String suplierName) {
		this.suplierName = suplierName;
	}
	public Double getBillno() {
		return billno;
	}
	public void setBillno(Double billno) {
		this.billno = billno;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	public String getGoodsReceiveDate() {
		return goodsReceiveDate;
	}
	public void setGoodsReceiveDate(String goodsReceiveDate) {
		this.goodsReceiveDate = goodsReceiveDate;
	}
	
	
}
