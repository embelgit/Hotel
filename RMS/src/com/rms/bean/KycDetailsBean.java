package com.rms.bean;

public class KycDetailsBean {
	private Long pkKycDetailId;
	private Long fk_item_id;
	private String fk_item_id_drop;
	private Double price;
	private String ItemName;
	private Long quantity;
	private Long tableNo;
	private String KYCDate;
	public Long getPkKycDetailId() {
		return pkKycDetailId;
	}
	public void setPkKycDetailId(Long pkKycDetailId) {
		this.pkKycDetailId = pkKycDetailId;
	}
	public Long getFk_item_id() {
		return fk_item_id;
	}
	public void setFk_item_id(Long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}
	public String getFk_item_id_drop() {
		return fk_item_id_drop;
	}
	public void setFk_item_id_drop(String fk_item_id_drop) {
		this.fk_item_id_drop = fk_item_id_drop;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getTableNo() {
		return tableNo;
	}
	public void setTableNo(Long tableNo) {
		this.tableNo = tableNo;
	}
	public String getKYCDate() {
		return KYCDate;
	}
	public void setKYCDate(String kYCDate) {
		KYCDate = kYCDate;
	}
	

}
