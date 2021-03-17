package com.rms.bean;

public class GetItemDetailsDrinkWiseBean {
	
	private Long pk_item_details_id;
	private Long fk_item_id;
	private Long srNo;
	private Double sale_price;
	private Double buy_price;
	private Double unit_in_ml;
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
	public Long getSrNo() {
		return srNo;
	}
	public void setSrNo(Long srNo) {
		this.srNo = srNo;
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
	public Double getUnit_in_ml() {
		return unit_in_ml;
	}
	public void setUnit_in_ml(Double unit_in_ml) {
		this.unit_in_ml = unit_in_ml;
	}
	

}
