package com.rms.bean;

public class GoodsReceiveBean {
	private Long pkStoreManagementId;
	private Long fk_item_id;
	private Long fkSupplierId;
	private String fk_item_id_drop1;
	private String suplierName;
	private Long billno;
	private String goodsReceiveDate;
	private Double buyPrice;
	private Double quantity;
	private String itemName;
	private Double total;
	private Double grossTotal;
	public Long getPkStoreManagementId() {
		return pkStoreManagementId;
	}
	public void setPkStoreManagementId(Long pkStoreManagementId) {
		this.pkStoreManagementId = pkStoreManagementId;
	}
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getFk_item_id() {
		return fk_item_id;
	}
	public void setFk_item_id(Long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}
	public Long getFkSupplierId() {
		return fkSupplierId;
	}
	public void setFkSupplierId(Long fkSupplierId) {
		this.fkSupplierId = fkSupplierId;
	}
	public String getFk_item_id_drop1() {
		return fk_item_id_drop1;
	}
	public void setFk_item_id_drop1(String fk_item_id_drop1) {
		this.fk_item_id_drop1 = fk_item_id_drop1;
	}
	public String getSuplierName() {
		return suplierName;
	}
	public void setSuplierName(String suplierName) {
		this.suplierName = suplierName;
	}
	public Long getBillno() {
		return billno;
	}
	public void setBillno(Long billno) {
		this.billno = billno;
	}
	public String getGoodsReceiveDate() {
		return goodsReceiveDate;
	}
	public void setGoodsReceiveDate(String goodsReceiveDate) {
		this.goodsReceiveDate = goodsReceiveDate;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	
	
}
