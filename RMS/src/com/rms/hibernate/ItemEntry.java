package com.rms.hibernate;

public class ItemEntry {

	private Long pk_item_entry_Id;
	private String itemName;
	private String type;
	private Long salePrice;
	private Long buyPrice;
	private Long unitsInMl;
	private String stock;
	private Long gram;
	private Long kilogram;

	private Double quantity;
	private Double gst;
	private Double HSNNo;
	
	private String unit;
	private Long value;
	
	private Double cgst;
	private Double sgst;
	private Double igst;
	
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	private int sr;
	
	
	public ItemEntry(Long pk_item_entry_Id, String itemName, String type, Long salePrice, Long buyPrice, Double gst,
			Long unitsInMl, Long kilogram, Long gram, Double quantity, String unit, Long value, Double cgst, Double sgst, Double igst, String username, String hotelname, Long hotelid, Long userid,int sr) {
		super();
		this.pk_item_entry_Id = pk_item_entry_Id;
		this.itemName = itemName;
		this.type = type;
		this.salePrice = salePrice;
		this.buyPrice = buyPrice;
		this.unitsInMl = unitsInMl;
		this.gram = gram;
		this.kilogram = kilogram;
		this.quantity = quantity;
	
		this.unit = unit;
		this.value = value;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
		this.username = username;
		this.userid = userid;
		this.hotelname = hotelname;
		this.hotelid = hotelid;
		this.gst = gst;
		this.sr = sr;
	}

	
	
	
	public int getSr() {
		return sr;
	}




	public void setSr(int sr) {
		this.sr = sr;
	}




	public Double getGst() {
		return gst;
	}




	public void setGst(Double gst) {
		this.gst = gst;
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



	public Long getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Long salePrice) {
		this.salePrice = salePrice;
	}

	public Long getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Long buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Long getUnitsInMl() {
		return unitsInMl;
	}

	public void setUnitsInMl(Long unitsInMl) {
		this.unitsInMl = unitsInMl;
	}

	public ItemEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPk_item_entry_Id() {
		return pk_item_entry_Id;
	}

	public void setPk_item_entry_Id(Long pk_item_entry_Id) {
		this.pk_item_entry_Id = pk_item_entry_Id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Long getGram() {
		return gram;
	}

	public void setGram(Long gram) {
		this.gram = gram;
	}

	public Long getKilogram() {
		return kilogram;
	}

	public void setKilogram(Long kilogram) {
		this.kilogram = kilogram;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}   

/*	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}
*/
	public Double getHSNNo() {
		return HSNNo;
	}

	public void setHSNNo(Double hSNNo) {
		HSNNo = hSNNo;
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

	public Double getIgst() {
		return igst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}

	
	
}