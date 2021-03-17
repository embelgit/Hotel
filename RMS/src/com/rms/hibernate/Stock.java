package com.rms.hibernate;

public class Stock {
	
	private long  pk_item_stock_id;
	private long fk_good_received_id;
	private long item_details_id;
	private long srNo;
	private String itemName;
	private Double stock;
	private String Itemname;
	private String unit;
	private Double value;
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getItemname() {
		return Itemname;
	}


	public void setItemname(String itemname) {
		Itemname = itemname;
	}


	public long getPk_item_stock_id() {
		return pk_item_stock_id;
	}
	public void setPk_item_stock_id(long pk_item_stock_id) {
		this.pk_item_stock_id = pk_item_stock_id;
	}
	public long getFk_good_received_id() {
		return fk_good_received_id;
	}
	public void setFk_good_received_id(long fk_good_received_id) {
		this.fk_good_received_id = fk_good_received_id;
	}
	public long getItem_details_id() {
		return item_details_id;
	}
	public void setItem_details_id(long item_details_id) {
		this.item_details_id = item_details_id;
	}
	
	public Stock(long pk_item_stock_id, long fk_good_received_id,
			long item_details_id, double stock, double value, String unit,String username, String hotelname, Long userid, Long hotelid) {
		super();
		this.pk_item_stock_id = pk_item_stock_id;
		this.fk_good_received_id = fk_good_received_id;
		this.item_details_id = item_details_id;
		this.unit = unit;
		this.value = value;
		this.username = username;
		this.hotelname = hotelname;
		this.hotelid = hotelid;
		this.userid = userid;
		this.setStock(stock);
	}
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.stock = stock;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public long getSrNo() {
		return srNo;
	}
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}


	public String getUnit() {
		return unit;
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


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}
	
	

}
