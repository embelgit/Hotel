package com.rms.hibernate;


public class StockEntryHibernate {
	
	private Long pkStockEntry;
	private String itemName;
	private Double buyPrice;
	private Double quantity;
	private Double gst;
	private Double grossTotal;
	public StockEntryHibernate(Long pkStockEntry, String itemName,
			Double buyPrice, Double quantity, Double gst, Double grossTotal) {
		super();
		this.pkStockEntry = pkStockEntry;
		this.itemName = itemName;
		this.buyPrice = buyPrice;
		this.quantity = quantity;
		this.gst = gst;
		this.grossTotal = grossTotal;
	}
	public StockEntryHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getPkStockEntry() {
		return pkStockEntry;
	}
	public void setPkStockEntry(Long pkStockEntry) {
		this.pkStockEntry = pkStockEntry;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public Double getGst() {
		return gst;
	}
	public void setGst(Double gst) {
		this.gst = gst;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	
	
}
