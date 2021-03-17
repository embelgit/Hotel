package com.rms.bean;

public class StockEntryReportBean {
	
	private Long pkStockEntry;
	private Long srNo;
	private String productName;
	private String supplierName;
	private Double buyPrice;
	private Double quantity;
	private Double total;
	private Double grossTotal;
	public StockEntryReportBean(Long pkStockEntry, Long srNo,
			String productName, String supplierName, Double buyPrice,
			Double quantity, Double total, Double grossTotal) {
		super();
		this.pkStockEntry = pkStockEntry;
		this.srNo = srNo;
		this.productName = productName;
		this.supplierName = supplierName;
		this.buyPrice = buyPrice;
		this.quantity = quantity;
		this.total = total;
		this.grossTotal = grossTotal;
	}
	public StockEntryReportBean() {
		super();
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
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
	
	
}
