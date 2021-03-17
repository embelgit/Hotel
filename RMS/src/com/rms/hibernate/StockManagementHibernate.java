package com.rms.hibernate;

public class StockManagementHibernate {

	private Long pkStoreManagementId;
	private Long fk_item_id;
	private Long fkSupplierId;
	private String fk_item_id_drop1;
	private String supplierName;
	private Double buyPrice;
	private Double quantity;
	private Double total;
	private Double grossTotal;
	public StockManagementHibernate(Long pkStoreManagementId, Long fk_item_id,
			Long fkSupplierId, String fk_item_id_drop1, String supplierName,
			Double buyPrice, Double quantity, Double total, Double grossTotal) {
		super();
		this.pkStoreManagementId = pkStoreManagementId;
		this.fk_item_id = fk_item_id;
		this.fkSupplierId = fkSupplierId;
		this.fk_item_id_drop1 = fk_item_id_drop1;
		this.supplierName = supplierName;
		this.buyPrice = buyPrice;
		this.quantity = quantity;
		this.total = total;
		this.grossTotal = grossTotal;
	}
	public StockManagementHibernate() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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