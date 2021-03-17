package com.rms.hibernate;

import java.util.Date;

public class banktransaction {

	private long pkbankid;
	private String bankname;
	private Date datee;
	private Double contactno;
	private String paymentById;
	
	private Long chequeNoId;
	private Date chequeDateId;
	private Long cardNoId;
	private Long neftAccNoId;
	
	private String accountname;
	private Double amount;
	
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
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public long getPkbankid() {
		return pkbankid;
	}
	public void setPkbankid(long pkbankid) {
		this.pkbankid = pkbankid;
	}
	public Long getTransID() {
		return transID;
	}
	public void setTransID(Long transID) {
		this.transID = transID;
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
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public Date getDatee() {
		return datee;
	}
	public void setDatee(Date datee) {
		this.datee = datee;
	}
	
	
	
	public Double getContactno() {
		return contactno;
	}
	public void setContactno(Double contactno) {
		this.contactno = contactno;
	}
	public String getPaymentById() {
		return paymentById;
	}
	public void setPaymentById(String paymentById) {
		this.paymentById = paymentById;
	}
	public long getChequeNoId() {
		return chequeNoId;
	}
	public void setChequeNoId(long chequeNoId) {
		this.chequeNoId = chequeNoId;
	}
	public Date getChequeDateId() {
		return chequeDateId;
	}
	public void setChequeDateId(Date chequeDateId) {
		this.chequeDateId = chequeDateId;
	}
	public long getCardNoId() {
		return cardNoId;
	}
	public void setCardNoId(long cardNoId) {
		this.cardNoId = cardNoId;
	}
	public long getNeftAccNoId() {
		return neftAccNoId;
	}
	public void setNeftAccNoId(long neftAccNoId) {
		this.neftAccNoId = neftAccNoId;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	



}
