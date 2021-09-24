package com.rms.hibernate;

import java.util.Date;

public class kitchenorderHibernate {

	private Long pk_temp_id;
	private Long  tableNo;
	private Long  itemId;
	private String itemName;
	private Double quantity;
	private Date current_date;	
	//private Long fk_item_details_id;
	private char activeYN;
	private String unit;
	private String value;
	//private String status;
	
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	
	public kitchenorderHibernate() {
		super();
	}

	public kitchenorderHibernate(Long pk_temp_id, Long tableNo, Long itemId, String itemName, Double quantity,
			Date current_date, char activeYN, String unit, String value, String username, String hotelname,
			Long hotelid, Long userid) {
		super();
		this.pk_temp_id = pk_temp_id;
		this.tableNo = tableNo;
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.current_date = current_date;
		this.activeYN = activeYN;
		this.unit = unit;
		this.value = value;
		this.username = username;
		this.hotelname = hotelname;
		this.hotelid = hotelid;
		this.userid = userid;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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


}