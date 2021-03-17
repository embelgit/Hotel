package com.rms.hibernate;

public class SupplierDetailsHibernate {
	
	private Long pkSupplierDetailId;
	private String suplierName;
	private String gstNo;
	private String contactPerson;
	private String suplierContact;
	private String emailID;
	private String suplierCity;
	private String address;
	private String suplierState;
	
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
/*	public SupplierDetailsHibernate(Long pkSupplierDetailId,
			String suplierName, String gstNo, String contactPerson) {
		super();
		this.pkSupplierDetailId = pkSupplierDetailId;
		this.suplierName = suplierName;
		this.gstNo = gstNo;
		this.contactPerson = contactPerson;
	} */
		
	public SupplierDetailsHibernate(Long pkSupplierDetailId, String suplierName, String gstNo, String contactPerson,
			String suplierContact, String emailID, String suplierCity, String address, String suplierState, String username, String hotelname, Long userid, Long hotelid) {
		super();
		this.pkSupplierDetailId = pkSupplierDetailId;
		this.suplierName = suplierName;
		this.gstNo = gstNo;
		this.contactPerson = contactPerson;
		this.suplierContact = suplierContact;
		this.emailID = emailID;
		this.suplierCity = suplierCity;
		this.address = address;
		this.suplierState = suplierState;
		this.userid = userid;
		this.hotelid = hotelid;
		this.username = username;
		this.hotelname = hotelname;
	}



	public SupplierDetailsHibernate() {
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



	public Long getPkSupplierDetailId() {
		return pkSupplierDetailId;
	}
	public void setPkSupplierDetailId(Long pkSupplierDetailId) {
		this.pkSupplierDetailId = pkSupplierDetailId;
	}
	public String getSuplierName() {
		return suplierName;
	}
	public void setSuplierName(String suplierName) {
		this.suplierName = suplierName;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}



	public String getSuplierContact() {
		return suplierContact;
	}



	public void setSuplierContact(String suplierContact) {
		this.suplierContact = suplierContact;
	}



	public String getEmailID() {
		return emailID;
	}



	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}



	public String getSuplierCity() {
		return suplierCity;
	}



	public void setSuplierCity(String suplierCity) {
		this.suplierCity = suplierCity;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getSuplierState() {
		return suplierState;
	}



	public void setSuplierState(String suplierState) {
		this.suplierState = suplierState;
	}
	
	

}
