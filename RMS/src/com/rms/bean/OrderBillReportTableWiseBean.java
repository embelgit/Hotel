package com.rms.bean;

public class OrderBillReportTableWiseBean {
	
	private Long pk_temp_id;
	private Long srNo;
	private String orderBillDate;
	private Long tableNo;
	private String itemName;
	private Double quantity;
	private Double unitPrice;
	private Double unitInMl;
	private Double totalAmt;
	private Double GridTotal;
	
	private Long billNo;
	private String unit;
	private Long value;
	
	public Double getGridTotal() {
		return GridTotal;
	}
	public void setGridTotal(Double gridTotal) {
		GridTotal = gridTotal;
	}
	private String current_date;
	public Long getPk_temp_id() {
		return pk_temp_id;
	}
	public void setPk_temp_id(Long pk_temp_id) {
		this.pk_temp_id = pk_temp_id;
	}
	public Long getSrNo() {
		return srNo;
	}
	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}
	public String getOrderBillDate() {
		return orderBillDate;
	}
	public void setOrderBillDate(String orderBillDate) {
		this.orderBillDate = orderBillDate;
	}
	public Long getTableNo() {
		return tableNo;
	}
	public void setTableNo(Long tableNo) {
		this.tableNo = tableNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getUnitInMl() {
		return unitInMl;
	}
	public void setUnitInMl(Double unitInMl) {
		this.unitInMl = unitInMl;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getCurrent_date() {
		return current_date;
	}
	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	
	public Long getBillNo() {
		return billNo;
	}
	public void setBillNo(Long billNo) {
		this.billNo = billNo;
	}
	public OrderBillReportTableWiseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
