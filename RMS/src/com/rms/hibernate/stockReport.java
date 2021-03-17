package com.rms.hibernate;

public class stockReport {

	private Long pk_item_entry_Id;
	private String itemName;
	private Double quantity;
	
	public stockReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public stockReport(Long pk_item_entry_Id, String itemName, Double quantity) {
		super();
		this.pk_item_entry_Id = pk_item_entry_Id;
		this.itemName = itemName;
		this.quantity = quantity;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	 
}