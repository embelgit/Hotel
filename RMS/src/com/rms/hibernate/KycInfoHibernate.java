package com.rms.hibernate;

import java.util.Date;

public class KycInfoHibernate {
	private Long pkKycDetailId;
	private Long fk_item_id;
	private String fk_item_id_drop;
	private Double price;
	private String ItemName;
	private Long quantity;
	private Long tableNo;
	private Date KYCDate;
	public KycInfoHibernate(Long pkKycDetailId, String fk_item_id_drop,
			Long fk_item_id, Double price, String itemName, Long quantity,
			Long tableNo, Date kYCDate) {
		super();
		this.pkKycDetailId = pkKycDetailId;
		this.fk_item_id_drop = fk_item_id_drop;
		this.fk_item_id = fk_item_id;
		this.price = price;
		ItemName = itemName;
		this.quantity = quantity;
		this.tableNo = tableNo;
		KYCDate = kYCDate;
	}
	public KycInfoHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getPkKycDetailId() {
		return pkKycDetailId;
	}
	public void setPkKycDetailId(Long pkKycDetailId) {
		this.pkKycDetailId = pkKycDetailId;
	}
	public String getFk_item_id_drop() {
		return fk_item_id_drop;
	}
	public void setFk_item_id_drop(String fk_item_id_drop) {
		this.fk_item_id_drop = fk_item_id_drop;
	}
	public Long getFk_item_id() {
		return fk_item_id;
	}
	public void setFk_item_id(Long fk_item_id) {
		this.fk_item_id = fk_item_id;
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
	public Date getKYCDate() {
		return KYCDate;
	}
	public void setKYCDate(Date kYCDate) {
		KYCDate = kYCDate;
	}
	
}
