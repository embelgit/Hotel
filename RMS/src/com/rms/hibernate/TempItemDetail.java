package com.rms.hibernate;

import java.util.Date;

public class TempItemDetail {

	private Long pk_temp_id;
	private Long  tableNo;
	private Long  itemId;
	private String itemName;
	private Double quantity;
	private Double unitPrice;
	private Double unitInMl;
	private Double totalAmt;
	private Date current_date;
	private char activeYN;
	private Long fk_item_details_id;

	private Double stock;
	private String unit;
	
/*	private Double cgst;
	private Double sgst;
	*/
	private Double gst;
	private Long value;
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	
	public TempItemDetail(Long pk_temp_id, Long tableNo, Long itemId,
			String itemName, Double quantity, Double unitPrice,
			Double unitInMl, Double totalAmt, Date current_date, char activeYN, Long fk_item_details_id, Double stock, String unit, 
			Long value, Double gst, String username, String hotelname, Long userid, Long hotelid) {
		super();
		this.pk_temp_id = pk_temp_id;
		this.tableNo = tableNo;
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unitInMl = unitInMl;
		this.totalAmt = totalAmt;
		this.current_date = current_date;
		this.activeYN = activeYN;
		this.fk_item_details_id = fk_item_details_id;
		this.stock = stock;
		this.unit = unit;
		this.value = value;
	//	this.cgst = cgst;
	//	this.sgst = sgst;
		this.gst = gst;
		this.username = username;
		this.userid = userid;
		this.hotelid = hotelid;
		this.hotelname = hotelname;		
	}
	public TempItemDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getFk_item_details_id() {
		return fk_item_details_id;
	}
	public void setFk_item_details_id(Long fk_item_details_id) {
		this.fk_item_details_id = fk_item_details_id;
	}
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.stock = stock;
	}
	public Long getPk_temp_id() {
		return pk_temp_id;
	}
	public void setPk_temp_id(Long pk_temp_id) {
		this.pk_temp_id = pk_temp_id;
	}
	public Long getTableNo() {
		return tableNo;
	}
	public void setTableNo(Long tableNo) {
		this.tableNo = tableNo;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getUnitInMl() {
		return unitInMl;
	}
	public void setUnitInMl(Double unitInMl) {
		this.unitInMl = unitInMl;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
		//System.out.println("hi this is total amt");
	}
	public Date getCurrent_date() {
		return current_date;
	}
	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}
	public char getActiveYN() {
		return activeYN;
	}
	public void setActiveYN(char activeYN) {
		this.activeYN = activeYN;
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
	} */
	
	
	public Double getGst() {
		return gst;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public Long getHotelid() {
		return hotelid;
	}
	public void setHotelid(Long hotelid) {
		this.hotelid = hotelid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public void setGst(Double gst) {
		this.gst = gst;
	}
	
	
	
}
