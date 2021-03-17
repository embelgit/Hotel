package com.rms.hibernate;

import java.util.Date;

public class GoodReceive {
	
	
	private Long PkGoodRecId;
	private String itemName;
	private String catName;
	private Double quantity;
	private Double buyPrice;
	private Double salePrice;
	private Double total;
	private String billNo;
	private String contactPerson;
	private Double vat;
	private Date date;
	private Double expence;
	private Double grossTotal;
	private Long barcodeNo;
	private Long supplierName;
	private String ondate;
	private Double oringnalQuantity;
	private Double igst;
	private Double taxAmount;
	private String hsnsacno;
	private Double extraDiscount;
	private String color;
	private String size;
	public GoodReceive(Long pkGoodRecId, String itemName, String catName, Double quantity, Double buyPrice, Double salePrice, Double total, String billNo, String contactPerson, Double vat, Date date, Double expence, Double grossTotal, Long barcodeNo, Long supplierName, String ondate, Double oringnalQuantity, Double igst, Double taxAmount, String hsnsacno, Double extraDiscount, String color, String size) {
		super();
		PkGoodRecId = pkGoodRecId;
		this.itemName = itemName;
		this.catName = catName;
		this.quantity = quantity;
		this.buyPrice = buyPrice;
		this.salePrice = salePrice;
		this.total = total;
		this.billNo = billNo;
		this.contactPerson = contactPerson;
		this.vat = vat;
		this.date = date;
		this.expence = expence;
		this.grossTotal = grossTotal;
		this.barcodeNo = barcodeNo;
		this.supplierName = supplierName;
		this.ondate = ondate;
		this.oringnalQuantity = oringnalQuantity;
		this.igst = igst;
		this.taxAmount = taxAmount;
		this.hsnsacno = hsnsacno;
		this.extraDiscount = extraDiscount;
		this.color = color;
		this.size = size;
	}
	public GoodReceive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getPkGoodRecId() {
		return PkGoodRecId;
	}
	public void setPkGoodRecId(Long pkGoodRecId) {
		PkGoodRecId = pkGoodRecId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public Double getVat() {
		return vat;
	}
	public void setVat(Double vat) {
		this.vat = vat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getExpence() {
		return expence;
	}
	public void setExpence(Double expence) {
		this.expence = expence;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	public Long getBarcodeNo() {
		return barcodeNo;
	}
	public void setBarcodeNo(Long barcodeNo) {
		this.barcodeNo = barcodeNo;
	}
	public Long getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(Long supplierName) {
		this.supplierName = supplierName;
	}
	public String getOndate() {
		return ondate;
	}
	public void setOndate(String ondate) {
		this.ondate = ondate;
	}
	public Double getOringnalQuantity() {
		return oringnalQuantity;
	}
	public void setOringnalQuantity(Double oringnalQuantity) {
		this.oringnalQuantity = oringnalQuantity;
	}
	public Double getIgst() {
		return igst;
	}
	public void setIgst(Double igst) {
		this.igst = igst;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getHsnsacno() {
		return hsnsacno;
	}
	public void setHsnsacno(String hsnsacno) {
		this.hsnsacno = hsnsacno;
	}
	public Double getExtraDiscount() {
		return extraDiscount;
	}
	public void setExtraDiscount(Double extraDiscount) {
		this.extraDiscount = extraDiscount;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	
	
}	