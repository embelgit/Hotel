package com.rms.bean;

import java.math.BigInteger;

public class GetItemDetails {
	
	private BigInteger pkItemId;
	private Long tableNo;
	private String itemName;
	private Double quantity;
	private Double prrice;
	private Long itemId;
	private Double unitinMl;
	private Double totalAmt;
	private Long pkTempId;
	
	private String unit;

	private Long fk_item_details_id;
	private Double stock;
	private Long value;
	/*
	private Double cgst;
	private Double sgst;
	*/
	private Double gst;
	public Long getTableNo() {
		return tableNo;
	}
	
	
	public Double getStock() {
		return stock;
	}


	public void setStock(Double stock) {
		this.stock = stock;
	}


	public Long getFk_item_details_id() {
		return fk_item_details_id;
	}


	public void setFk_item_details_id(Long fk_item_details_id) {
		this.fk_item_details_id = fk_item_details_id;
	}


	public void setTableNo(Long tableNo) {
		this.tableNo = tableNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public Double getGst() {
		return gst;
	}


	public void setGst(Double gst) {
		this.gst = gst;
	}


	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getPrrice() {
		return prrice;
	}
	public void setPrrice(Double prrice) {
		this.prrice = prrice;
	}

	public Double getUnitinMl() {
		return unitinMl;
	}
	public void setUnitinMl(Double unitinMl) {
		this.unitinMl = unitinMl;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Long getPkTempId() {
		return pkTempId;
	}
	public void setPkTempId(Long pkTempId) {
		this.pkTempId = pkTempId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public BigInteger getPkItemId() {
		return pkItemId;
	}
	public void setPkItemId(BigInteger pkItemId) {
		this.pkItemId = pkItemId;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public Long getValue() {
		return value;
	}


	public void setValue(Long value) {
		this.value = value;
	}


/*	public Double getCgst() {
		return cgst;
	}


	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}


	public Double getSgst() {
		return sgst;
	}


	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}
	*/
	
}
