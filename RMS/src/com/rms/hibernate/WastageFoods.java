package com.rms.hibernate;

public class WastageFoods {

	private Long pk_wastage_food_id;
	private Long fk_item_id;
	private String ItemName;
	private Double foodAmount;
	public WastageFoods(Long pk_wastage_food_id, Long fk_item_id,
			String itemName, Double foodAmount) {
		super();
		this.pk_wastage_food_id = pk_wastage_food_id;
		this.fk_item_id = fk_item_id;
		ItemName = itemName;
		this.foodAmount = foodAmount;
	}
	public WastageFoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getPk_wastage_food_id() {
		return pk_wastage_food_id;
	}
	public void setPk_wastage_food_id(Long pk_wastage_food_id) {
		this.pk_wastage_food_id = pk_wastage_food_id;
	}
	public Long getFk_item_id() {
		return fk_item_id;
	}
	public void setFk_item_id(Long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Double getFoodAmount() {
		return foodAmount;
	}
	public void setFoodAmount(Double foodAmount) {
		this.foodAmount = foodAmount;
	}
	
	
	
}
