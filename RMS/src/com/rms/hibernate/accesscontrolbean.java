package com.rms.hibernate;

public class accesscontrolbean {
	
	private Long pkid;
	private String username;
	private Long userid;
	private String pass;
	private String usertype;
	private String hotelname;
	private Long hotelid;
	public accesscontrolbean(Long pkid, String username,Long userid, String pass, String usertype, String hotelname, Long hotelid) {
		super();
		this.pkid = pkid;
		this.username = username;
		this.userid = userid;
		this.pass = pass;
		this.usertype = usertype;
		this.hotelname = hotelname;
		this.hotelid = hotelid;
	}
	
	
	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public Long getPkid() {
		return pkid;
	}

	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
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
	public accesscontrolbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
