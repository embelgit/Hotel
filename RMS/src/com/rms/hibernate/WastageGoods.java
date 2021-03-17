package com.rms.hibernate;

import java.io.Serializable;

public class WastageGoods implements Serializable {
	
	private Long pk_wastage_good_id;
	private String vagetablesName;
	private Double amount;

	public WastageGoods() {
		super();
	}
	
	public WastageGoods(Long pk_wastage_good_id, String vagetablesName,
			Double amount) {
		super();
		this.pk_wastage_good_id = pk_wastage_good_id;
		this.vagetablesName = vagetablesName;
		this.amount = amount;
	}
	
	public Long getPk_wastage_good_id() {
		return pk_wastage_good_id;
	}
	public void setPk_wastage_good_id(Long pk_wastage_good_id) {
		this.pk_wastage_good_id = pk_wastage_good_id;
	}
	public String getVagetablesName() {
		return vagetablesName;
	}
	public void setVagetablesName(String vagetablesName) {
		this.vagetablesName = vagetablesName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

	
	
}