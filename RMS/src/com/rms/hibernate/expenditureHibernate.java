package com.rms.hibernate;

public class expenditureHibernate {

	private Long pk_expid;
	private String expenditurename;
	
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	private int sr;
		
		
	public int getSr() {
		return sr;
	}
	public void setSr(int sr) {
		this.sr = sr;
	}
	public Long getPk_expid() {
		return pk_expid;
	}
	public void setPk_expid(Long pk_expid) {
		this.pk_expid = pk_expid;
	}
	public String getExpenditurename() {
		return expenditurename;
	}
	public void setExpenditurename(String expenditurename) {
		this.expenditurename = expenditurename;
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
	
	
	
}
