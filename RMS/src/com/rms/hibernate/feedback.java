package com.rms.hibernate;

import java.util.Date;

public class feedback {
	
	private Long id;
	private Long contact;
	private String name;
	private String tfeedback;
	private String Rate;	
	private Date iDate;
	

	public feedback() {
		super();
		this.id = id;
		this.contact = contact;
		this.name = name;
		this.tfeedback = tfeedback;
		this.Rate = Rate;
		this.iDate = iDate;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTfeedback() {
		return tfeedback;
	}

	public void setTfeedback(String tfeedback) {
		this.tfeedback = tfeedback;
	}

	public String getRate() {
		return Rate;
	}

	public void setRate(String rate) {
		Rate = rate;
	}

	public Date getiDate() {
		return iDate;
	}

	public void setiDate(Date iDate) {
		this.iDate = iDate;
	}

	

}
