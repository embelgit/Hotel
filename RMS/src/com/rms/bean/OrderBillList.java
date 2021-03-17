package com.rms.bean;

public class OrderBillList {
private Long pk_order_bill_id;
private String TableNo;
private String ItemName;

private String Waiter;
private String Quantity;

private String UnitPrice;
private String UnitINMl;
private String Total;
private String GrossTotal;

public String getTableNo() {
	return TableNo;
}

public Long getPk_order_bill_id() {
	return pk_order_bill_id;
}

public void setPk_order_bill_id(Long pk_order_bill_id) {
	this.pk_order_bill_id = pk_order_bill_id;
}

public void setTableNo(String tableNo) {
	TableNo = tableNo;
}
public String getItemName() {
	return ItemName;
}
public void setItemName(String itemName) {
	ItemName = itemName;
}
public String getWaiter() {
	return Waiter;
}
public void setWaiter(String waiter) {
	Waiter = waiter;
}
public String getQuantity() {
	return Quantity;
}
public void setQuantity(String quantity) {
	Quantity = quantity;
}
public String getUnitPrice() {
	return UnitPrice;
}
public void setUnitPrice(String unitPrice) {
	UnitPrice = unitPrice;
}
public String getUnitINMl() {
	return UnitINMl;
}
public void setUnitINMl(String unitINMl) {
	UnitINMl = unitINMl;
}
public String getTotal() {
	return Total;
}
public void setTotal(String total) {
	Total = total;
}
public String getGrossTotal() {
	return GrossTotal;
}
public void setGrossTotal(String grossTotal) {
	GrossTotal = grossTotal;
}

}
