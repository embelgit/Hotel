package com.rms.hibernate;

public class hotelnamebean {

	
	private String hotelname;
	private Long hotelid;
	private Long pk_id;
	public hotelnamebean(String hotelname, Long hotelid, Long pk_id) {
		super();
		this.hotelname = hotelname;
		this.hotelid = hotelid;
		this.pk_id = pk_id;
	}
	public hotelnamebean() {
		super();
		// TODO Auto-generated constructor stub
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
	public Long getPk_id() {
		return pk_id;
	}
	public void setPk_id(Long pk_id) {
		this.pk_id = pk_id;
	}
	
	
}
