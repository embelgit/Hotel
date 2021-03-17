package com.rms.hibernate;

import java.util.Date;

public class GoodsReceiveHibernate {
	private Long srNo;
	private Long pkStoreManagementId;
	private Long fk_item_id;
	private Long fk_item_id1;
	private Long fkSupplierId;
	private String fk_item_id_drop1;
	private String suplierName;
	private Long billno;
	private Date goodsReceiveDate;
	private Double buyPrice;
	private Double quantity;
	private Double total;
	private Double grossTotal;
	private Double stock;
	private Double gst;
	private Double saleprice;
	private String hsnno;
	private String Unit;
	private Long pk_item_entry_Id;
	
	private Double igst;
	private Double cgst;
	private Double sgst;	
	private Long value;
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	
	public GoodsReceiveHibernate(Long pkStoreManagementId, Long fk_item_id, Long fk_item_id1, Long fkSupplierId,
			String fk_item_id_drop1, String suplierName, Long billno, Date goodsReceiveDate, Double buyPrice,
			Double quantity, Double total, Double grossTotal, Double stock, Double gst, Double saleprice, 
			String hsnno, String Unit, Long pk_item_entry_Id, Long srNo, Long value,
			Double igst, Double cgst, Double sgst, String username, String hotelname, Long hotelid, Long userid) {
		super();
		this.pkStoreManagementId = pkStoreManagementId;
		this.fk_item_id = fk_item_id;
		this.fk_item_id1 = fk_item_id1;
		this.fkSupplierId = fkSupplierId;
		this.fk_item_id_drop1 = fk_item_id_drop1;
		this.suplierName = suplierName;
		this.billno = billno;
		this.goodsReceiveDate = goodsReceiveDate;
		this.buyPrice = buyPrice;
		this.quantity = quantity;
		this.total = total;
		this.grossTotal = grossTotal;
		this.stock = stock;
		this.gst = gst;
		this.saleprice = saleprice;
		this.hsnno = hsnno;
		this.Unit =Unit;
		this.srNo = srNo;
		this.pk_item_entry_Id = pk_item_entry_Id;
		this.value = value;
		this.igst = igst;
		this.cgst = cgst;
		this.sgst = sgst;
		this.username = username;
		this.userid = userid;
		this.hotelid = hotelid;
		this.hotelname = hotelname;
	}
	public GoodsReceiveHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public Long getHotelid() {
		return hotelid;
	}
	public void setHotelid(Long hotelid) {
		this.hotelid = hotelid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getSrNo() {
		return srNo;
	}
	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}
	public Long getPk_item_entry_Id() {
		return pk_item_entry_Id;
	}
	public void setPk_item_entry_Id(Long pk_item_entry_Id) {
		this.pk_item_entry_Id = pk_item_entry_Id;
	}
	public Double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(Double saleprice) {
		this.saleprice = saleprice;
	}
	public String getHsnno() {
		return hsnno;
	}
	public void setHsnno(String hsnno) {
		this.hsnno = hsnno;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public Double getGst() {
		return gst;
	}
	public void setGst(Double gst) {
		this.gst = gst;
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
	public Long getBillno() {
		return billno;
	}
	public void setBillno(Long billno) {
		this.billno = billno;
	}
	public Date getGoodsReceiveDate() {
		return goodsReceiveDate;
	}
	public void setGoodsReceiveDate(Date goodsReceiveDate) {
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
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.stock = stock;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public Double getIgst() {
		return igst;
	}
	public void setIgst(Double igst) {
		this.igst = igst;
	}
	public Double getCgst() {
		return cgst;
	}
	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}
	public Double getSgst() {
		return sgst;
	}
	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}
	
	
	
	
	
}
