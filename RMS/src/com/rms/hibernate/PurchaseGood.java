package com.rms.hibernate;

import java.io.Serializable;

public class PurchaseGood implements Serializable{
	
	private Long pk_purchase_good_id;
	private String vegetables;
	private String grocery;
	private String other;
	/*private String itemName;
	private String price;*/
	private String total;
	public PurchaseGood() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getPk_purchase_good_id() {
		return pk_purchase_good_id;
	}
	public void setPk_purchase_good_id(Long pk_purchase_good_id) {
		this.pk_purchase_good_id = pk_purchase_good_id;
	}
	public String getVegetables() {
		return vegetables;
	}
	public void setVegetables(String vegetables) {
		this.vegetables = vegetables;
	}
	public String getGrocery() {
		return grocery;
	}
	public void setGrocery(String grocery) {
		this.grocery = grocery;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	/*public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}*/
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public PurchaseGood(Long pk_purchase_good_id, String vegetables,
			String grocery, String other, String itemName, String price,
			String total) {
		super();
		this.pk_purchase_good_id = pk_purchase_good_id;
		this.vegetables = vegetables;
		this.grocery = grocery;
		this.other = other;
		/*this.itemName = itemName;
		this.price = price;*/
		this.total = total;
	}
	
	
}
