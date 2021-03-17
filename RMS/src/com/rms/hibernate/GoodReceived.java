package com.rms.hibernate;

public class GoodReceived {
	
	private Long pk_good_received_id;
	private Long fk_item_id;
	private Double quantity;
	private String itemName;
	
	private com.rms.hibernate.ItemEntry itemEntry;
	
	public GoodReceived() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public com.rms.hibernate.ItemEntry getItemEntry() {
		return itemEntry;
	}


	public void setItemEntry(com.rms.hibernate.ItemEntry itemEntry) {
		this.itemEntry = itemEntry;
	}


	public Long getPk_good_received_id() {
		return pk_good_received_id;
	}
	public void setPk_good_received_id(Long pk_good_received_id) {
		this.pk_good_received_id = pk_good_received_id;
	}
	public Long getFk_item_id() {
		return fk_item_id;
	}
	public void setFk_item_id(Long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public GoodReceived(Long pk_good_received_id, Long fk_item_id,
			Double quantity) {
		super();
		this.pk_good_received_id = pk_good_received_id;
		this.fk_item_id = fk_item_id;
		this.quantity = quantity;
	}


	public GoodReceived(ItemEntry itemEntry) {
		super();
		this.itemEntry = itemEntry;
	}
	

}
