package com.rms.bean;

import java.util.Date;

public class GoodsReceiveHibernateBean {

	private Long pkStoreManagementId;
	private Long fk_item_id;
	private Long fk_item_id1;
	private Long fkSupplierId;
	private String fk_item_id_drop1;
	private String suplierName;
	private Long billno;
	private String goodsReceiveDate;
	private Double buyPrice;
	private Double sale_Price;
	private Double quantity;
	private Double total;
	private Double grossTotal;
	private Double stock;
	private Double gst;
	
	
	public Double getGst() {
		return gst;
	}
	public void setGst(Double gst) {
		this.gst = gst;
	}
	public Long getBillno() {
		return billno;
	}
	public void setBillno(Long billno) {
		this.billno = billno;
	}
	public Long getPkStoreManagementId() {
		return pkStoreManagementId;
	}
	public void setPkStoreManagementId(Long pkStoreManagementId) {
		this.pkStoreManagementId = pkStoreManagementId;
	}
	public Long getFk_item_id() {
		return fk_item_id;
	}
	public void setFk_item_id(Long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}
	public Long getFk_item_id1() {
		return fk_item_id1;
	}
	public void setFk_item_id1(Long fk_item_id1) {
		this.fk_item_id1 = fk_item_id1;
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
	
	
	public Double getSale_Price() {
		return sale_Price;
	}
	public void setSale_Price(Double sale_Price) {
		this.sale_Price = sale_Price;
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
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.stock = stock;
	}

	
	
	 
	 
	
	
}
