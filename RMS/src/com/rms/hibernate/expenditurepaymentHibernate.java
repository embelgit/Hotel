package com.rms.hibernate;

import java.util.Date;

public class expenditurepaymentHibernate {

	private Long pkexpid;
	private String expenditurename;
	private Double expenditureamount;
	
	private String paymentById;
	private Date paymentdate;
	private Long chequeNoId;
	private Date chequeDateId;
	private Long cardNoId;
	private Long neftAccNoId;
	
	
	
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	private Long transID;
	private String paymentType;
	private int sr;
	
	
	public int getSr() {
		return sr;
	}
	public void setSr(int sr) {
		this.sr = sr;
	}
	public Long getPkexpid() {
		return pkexpid;
	}
	public void setPkexpid(Long pkexpid) {
		this.pkexpid = pkexpid;
	}
	public String getExpenditurename() {
		return expenditurename;
	}
	public void setExpenditurename(String expenditurename) {
		this.expenditurename = expenditurename;
	}
	public Double getExpenditureamount() {
		return expenditureamount;
	}
	public void setExpenditureamount(Double expenditureamount) {
		this.expenditureamount = expenditureamount;
	}
	public String getPaymentById() {
		return paymentById;
	}
	public void setPaymentById(String paymentById) {
		this.paymentById = paymentById;
	}
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}
	public Long getChequeNoId() {
		return chequeNoId;
	}
	public void setChequeNoId(Long chequeNoId) {
		this.chequeNoId = chequeNoId;
	}
	public Date getChequeDateId() {
		return chequeDateId;
	}
	public void setChequeDateId(Date chequeDateId) {
		this.chequeDateId = chequeDateId;
	}
	public Long getCardNoId() {
		return cardNoId;
	}
	public void setCardNoId(Long cardNoId) {
		this.cardNoId = cardNoId;
	}
	public Long getNeftAccNoId() {
		return neftAccNoId;
	}
	public void setNeftAccNoId(Long neftAccNoId) {
		this.neftAccNoId = neftAccNoId;
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
	public Long getTransID() {
		return transID;
	}
	public void setTransID(Long transID) {
		this.transID = transID;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	
}
