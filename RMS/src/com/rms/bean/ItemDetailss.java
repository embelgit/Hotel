package com.rms.bean;

public class ItemDetailss {

	private Long pk_item_entry_Id;
	private Double salePrice;
	private Double buyPrice;
	private String fk_item_id_drop1;
	private String Type;
	
	private Long unit;

	private Double quantity;
	private Double gst;
	
	
	
	
	
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

	public Long getPk_item_entry_Id() {
		return pk_item_entry_Id;
	}

	public void setPk_item_entry_Id(Long pk_item_entry_Id) {
		this.pk_item_entry_Id = pk_item_entry_Id;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getFk_item_id_drop1() {
		return fk_item_id_drop1;
	}

	public void setFk_item_id_drop1(String fk_item_id_drop1) {
		this.fk_item_id_drop1 = fk_item_id_drop1;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Long getUnit() {
		return unit;
	}

	public void setUnit(Long unit) {
		this.unit = unit;
	}

	
	
	 
}
