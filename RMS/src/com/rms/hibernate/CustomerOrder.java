package com.rms.hibernate;

import java.util.Date;

public class CustomerOrder {
	
	private Long pk_custOrder_id;
	private Long tableNo;
	private String itemName;
	private Double quantity;
	private Double unitPrice;
	private Double unitInMl;
	private Date current_date;
	private Double totalAmt;
	private Long billNo;
	private String waiterName;
	private Double totalAmount;
	private String GridTotal;
	
	private Double gst;
	private Double gstAmt;
	
	private Double cgst;
	private Double sgst;
	
	private String unit;
	private Long value;
	
	private String type;
	private String orderbill;
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	
	public CustomerOrder(Long pk_custOrder_id, Long tableNo, String itemName,
			Double quantity, Double unitPrice, Double unitInMl,
			Date current_date, Double totalAmt, Long billNo, String waiterName, Double totalAmount, String GridTotal, Double gst, 
			Double gstAmt, String unit, Long value, Double cgst, Double sgst, 
			String type, String orderbill, String username, String hotelname, Long userid, Long hotelid) {
		super();
		this.pk_custOrder_id = pk_custOrder_id;
		this.tableNo = tableNo;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unitInMl = unitInMl;
		this.current_date = current_date;
		this.totalAmt = totalAmt;
		this.billNo = billNo;
		this.waiterName = waiterName;
		this.totalAmount =totalAmount;
		this.GridTotal = GridTotal;
		this.gst = gst;
		this.gstAmt = gstAmt;
		this.unit = unit;
		this.value = value;
		this.cgst = cgst;
		this.sgst = sgst;
		this.type = type;
		this.orderbill = orderbill;
		this.userid = userid;
		this.username = username;
		this.hotelid = hotelid;
		this.hotelname = hotelname;
	}


	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
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


	public Double getGst() {
		return gst;
	}


	public void setGst(Double gst) {
		this.gst = gst;
	}


	public Double getGstAmt() {
		return gstAmt;
	}


	public void setGstAmt(Double gstAmt) {
		this.gstAmt = gstAmt;
	}


	public String getGridTotal() {
		return GridTotal;
	}


	public void setGridTotal(String gridTotal) {
		GridTotal = gridTotal;
	}


	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Long getPk_custOrder_id() {
		return pk_custOrder_id;
	}


	public void setPk_custOrder_id(Long pk_custOrder_id) {
		this.pk_custOrder_id = pk_custOrder_id;
	}


	public Long getTableNo() {
		return tableNo;
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


	public Date getCurrent_date() {
		return current_date;
	}


	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}


	public Double getTotalAmt() {
		return totalAmt;
	}


	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}


	public Long getBillNo() {
		return billNo;
	}


	public void setBillNo(Long billNo) {
		this.billNo = billNo;
	}


	public String getWaiterName() {
		return waiterName;
	}


	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
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


	public Double getCgst() {
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getOrderbill() {
		return orderbill;
	}


	public void setOrderbill(String orderbill) {
		this.orderbill = orderbill;
	}
	
	

}
