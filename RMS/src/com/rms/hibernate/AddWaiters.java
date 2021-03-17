package com.rms.hibernate;

import java.util.Date;

public class AddWaiters {

	private Long pkAddWaiterId;
	private Date joiningDate;
	private Date dob;
	private String firstName;
	private String lastName;
	private String middleName;
	private String emailId;
	private String address;
	private String city;
	private String state;
	private Long zip;
	private Long waiterId;
	private Long mobileNo;
	private Double salary;
	private String isActiveYN;
	private Date insertDate;
	private Date modifiedDate;
	
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	
	public Long getPkAddWaiterId() {
		return pkAddWaiterId;
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


	public void setPkAddWaiterId(Long pkAddWaiterId) {
		this.pkAddWaiterId = pkAddWaiterId;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getZip() {
		return zip;
	}
	public void setZip(Long zip) {
		this.zip = zip;
	}
	
	public Long getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(Long waiterId) {
		this.waiterId = waiterId;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	public String getIsActiveYN() {
		return isActiveYN;
	}
	public void setIsActiveYN(String isActiveYN) {
		this.isActiveYN = isActiveYN;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public AddWaiters(Long pkAddWaiterId, Date joiningDate, Date dob,
			String firstName, String lastName, String middleName,
			String emailId, String address, String city, String state,
			Long zip, Long waiterId, Long mobileNo, Double salary, String hotelname, String username, Long hotelid, Long userid) {
		super();
		this.pkAddWaiterId = pkAddWaiterId;
		this.joiningDate = joiningDate;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.emailId = emailId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.waiterId = waiterId;
		this.mobileNo = mobileNo;
		this.salary = salary;
		this.isActiveYN = isActiveYN;
		this.insertDate = insertDate;
		this.modifiedDate = modifiedDate;
		this.username = username;
		this.userid = userid;
		this.hotelid = hotelid;
		this.hotelname = hotelname;
	}
	
	
	public AddWaiters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
