package com.rms.bean;

public class menuList {
	
	
	private Double sale_price;


	private String ItemName;
	private Double unit_in_ml;
	private String unit;
	private Double value;
	public menuList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public menuList(Double sale_price, String itemName, Double unit_in_ml) {
		super();
		this.sale_price = sale_price;
		ItemName = itemName;
		this.unit_in_ml = unit_in_ml;
		this.unit = unit;
		this.value = value;
	}


	public Double getSale_price() {
		return sale_price;
	}


	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}


	public String getItemName() {
		return ItemName;
	}


	public void setItemName(String itemName) {
		ItemName = itemName;
	}


	public Double getUnit_in_ml() {
		return unit_in_ml;
	}


	public void setUnit_in_ml(Double unit_in_ml) {
		this.unit_in_ml = unit_in_ml;
	}


	public String getUnit() {
		return unit;
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
