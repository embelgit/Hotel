package com.rms.hibernate;

import java.io.Serializable;
import java.sql.Date;

public class CreateUser implements Serializable {

	private Long pk_create_user_id;
	private String userType;
	private String firstName;
	private String lastName;
	private String userName;
	private String mobileNO;
	private String password;
	private String confirmPassword;
	private String emailId;
	private String isActiveYN;
	private java.util.Date insertDate;
	private java.util.Date modifiedDate;
	
	
	
	
	
	
	public CreateUser(Long pk_create_user_id, String userType,
			String firstName, String lastName, String userName,
			String mobileNO, String password, String confirmPassword,
			String emailId, String isActiveYN, java.util.Date insertDate,
			java.util.Date modifiedDate) {
		super();
		this.pk_create_user_id = pk_create_user_id;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.mobileNO = mobileNO;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.emailId = emailId;
		this.isActiveYN = isActiveYN;
		this.insertDate = insertDate;
		this.modifiedDate = modifiedDate;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	public String getMobileNO() {
		return mobileNO;
	}
	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getIsActiveYN() {
		return isActiveYN;
	}
	public void setIsActiveYN(String isActiveYN) {
		this.isActiveYN = isActiveYN;
	}
	
	
	public java.util.Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(java.util.Date insertDate) {
		this.insertDate = insertDate;
	}
	public java.util.Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(java.util.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public Long getPk_create_user_id() {
		return pk_create_user_id;
	}

	public void setPk_create_user_id(Long pk_create_user_id) {
		this.pk_create_user_id = pk_create_user_id;
	}

	public CreateUser() {
		// TODO Auto-generated constructor stub
	}
}