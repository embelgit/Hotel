package com.rms.bean;

import java.util.Date;

public class customerdetails {
	
	private String customerName;
	private String dob;
	private Long mobileNumber ;
	
	
	public customerdetails(String customerName , String dob, Long mobileNumber) 
	{
	super();
	this.customerName = customerName;
	this.dob = dob;
	this.mobileNumber = mobileNumber;

	}
	public String getCustomerName() {
		return customerName;
	}
	public customerdetails(){
		super();
		
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
		
}
