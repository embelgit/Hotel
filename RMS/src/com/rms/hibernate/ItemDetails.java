package com.rms.hibernate;

public class ItemDetails {
	
	private Long pk_item_details_id;
	private Long fk_item_id;
	private Double sale_price;
	private Double buy_price;
	private String ItemName;
	
	private com.rms.hibernate.ItemEntry itemEntry;
	private Double unit_in_ml;
	
	public ItemDetails() {
		super();
	}

	public ItemDetails(Long pk_item_details_id, Long fk_item_id,
			Double sale_price, Double buy_price, String itemName,
			ItemEntry itemEntry, Double unit_in_ml) {
		super();
		this.pk_item_details_id = pk_item_details_id;
		this.fk_item_id = fk_item_id;
		this.sale_price = sale_price;
		this.buy_price = buy_price;
		this.ItemName = itemName;
		this.itemEntry = itemEntry;
		this.unit_in_ml = unit_in_ml;
	}

	public Long getPk_item_details_id() {
		return pk_item_details_id;
	}

	public void setPk_item_details_id(Long pk_item_details_id) {
		this.pk_item_details_id = pk_item_details_id;
	}

	public Long getFk_item_id() {
		return fk_item_id;
	}

	public void setFk_item_id(Long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}

	public Double getSale_price() {
		return sale_price;
	}

	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}

	public Double getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(Double buy_price) {
		this.buy_price = buy_price;
	}

	public com.rms.hibernate.ItemEntry getItemEntry() {
		return itemEntry;
	}

	public void setItemEntry(com.rms.hibernate.ItemEntry itemEntry) {
		this.itemEntry = itemEntry;
	}

	public Double getUnit_in_ml() {
		return unit_in_ml;
	}

	public void setUnit_in_ml(Double unit_in_ml) {
		this.unit_in_ml = unit_in_ml;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	

	

}
