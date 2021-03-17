package com.rms.bean;

public class orderBillbean {

	
	
	public orderBillbean(Long billNo, String itemName) {
		super();
		this.billNo = billNo;
		this.itemName = itemName;
	}
	
	private Long billNo;
	private String itemName;
	
	
	public Long getBillNo() {
		return billNo;
	}
	public void setBillNo(Long billNo) {
		this.billNo = billNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
}
