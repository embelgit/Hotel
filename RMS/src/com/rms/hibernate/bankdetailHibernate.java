package com.rms.hibernate;

import java.util.Date;

public class bankdetailHibernate {

	private long pkbankdetailid;

	private String bankname;
	private String branchname;
	private Long contactno;
	
	private String accountname;
	private Long accountnum;
	private Long ifsccode;
	
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	private Long transID;
	private int sr;
	
	
	public int getSr() {
		return sr;
	}
	public void setSr(int sr) {
		this.sr = sr;
	}
	public long getPkbankdetailid() {
		return pkbankdetailid;
	}
	public void setPkbankdetailid(long pkbankdetailid) {
		this.pkbankdetailid = pkbankdetailid;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public Long getContactno() {
		return contactno;
	}
	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public Long getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(Long accountnum) {
		this.accountnum = accountnum;
	}
	public Long getIfsccode() {
		return ifsccode;
	}
	public void setIfsccode(Long ifsccode) {
		this.ifsccode = ifsccode;
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

	
	
}
