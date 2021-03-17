package com.rms.hibernate;

import java.util.Date;

public class TodaySaleHibernate {

	private Long pksaleid;
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	private String usertype;
	private Long transID;
	private String paymentType;
	private int sr;
	
	private Double saleamount;	
	private Double currentcash;
	private Double cardpayment;
	private Double googlepaypayment;

	private Double phonpepayment;
	private Double paytmpayment;
	private Double otherpayment;
	private Date todaysdate;
	
	public Long getPksaleid() {
		return pksaleid;
	}
	public void setPksaleid(Long pksaleid) {
		this.pksaleid = pksaleid;
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
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
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
	public int getSr() {
		return sr;
	}
	public void setSr(int sr) {
		this.sr = sr;
	}
	public Double getSaleamount() {
		return saleamount;
	}
	public void setSaleamount(Double saleamount) {
		this.saleamount = saleamount;
	}
	public Double getCurrentcash() {
		return currentcash;
	}
	public void setCurrentcash(Double currentcash) {
		this.currentcash = currentcash;
	}
	public Double getCardpayment() {
		return cardpayment;
	}
	public void setCardpayment(Double cardpayment) {
		this.cardpayment = cardpayment;
	}
	public Double getGooglepaypayment() {
		return googlepaypayment;
	}
	public void setGooglepaypayment(Double googlepaypayment) {
		this.googlepaypayment = googlepaypayment;
	}
	public Double getPhonpepayment() {
		return phonpepayment;
	}
	public void setPhonpepayment(Double phonpepayment) {
		this.phonpepayment = phonpepayment;
	}
	public Double getPaytmpayment() {
		return paytmpayment;
	}
	public void setPaytmpayment(Double paytmpayment) {
		this.paytmpayment = paytmpayment;
	}
	public Double getOtherpayment() {
		return otherpayment;
	}
	public void setOtherpayment(Double otherpayment) {
		this.otherpayment = otherpayment;
	}
	public Date getTodaysdate() {
		return todaysdate;
	}
	public void setTodaysdate(Date todaysdate) {
		this.todaysdate = todaysdate;
	}
	
	
	
}
