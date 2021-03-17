package com.rms.hibernate;

import java.util.Date;

public class OrderBill {

	private Long  pk_order_bill_id;
	private Long fk_waiter_name_id;
	private Long table_No;
	
	private Long quantity;
	private Long total_amount;
	private Long fk_table_id;
	private Long fk_item_id;
	private String is_current;
	private String is_bill_printed;
	private String is_cancelled;
	private Long fk_user_id;
	private String is_acrive_YN;
	private Date is_insert_date;
	private Long super_order_id;
	private Date is_modified_date;
	public OrderBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getPk_order_bill_id() {
		return pk_order_bill_id;
	}
	public void setPk_order_bill_id(Long pk_order_bill_id) {
		this.pk_order_bill_id = pk_order_bill_id;
	}
	public Long getFk_waiter_name_id() {
		return fk_waiter_name_id;
	}
	public void setFk_waiter_name_id(Long fk_waiter_name_id) {
		this.fk_waiter_name_id = fk_waiter_name_id;
	}
	public Long getTable_No() {
		return table_No;
	}
	public void setTable_No(Long table_No) {
		this.table_No = table_No;
	}

	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Long total_amount) {
		this.total_amount = total_amount;
	}
	public Long getFk_table_id() {
		return fk_table_id;
	}
	public void setFk_table_id(Long fk_table_id) {
		this.fk_table_id = fk_table_id;
	}
	public Long getFk_item_id() {
		return fk_item_id;
	}
	public void setFk_item_id(Long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}
	public String getIs_current() {
		return is_current;
	}
	public void setIs_current(String is_current) {
		this.is_current = is_current;
	}
	public String getIs_bill_printed() {
		return is_bill_printed;
	}
	public void setIs_bill_printed(String is_bill_printed) {
		this.is_bill_printed = is_bill_printed;
	}
	public String getIs_cancelled() {
		return is_cancelled;
	}
	public void setIs_cancelled(String is_cancelled) {
		this.is_cancelled = is_cancelled;
	}
	public Long getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(Long fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public String getIs_acrive_YN() {
		return is_acrive_YN;
	}
	public void setIs_acrive_YN(String is_acrive_YN) {
		this.is_acrive_YN = is_acrive_YN;
	}
	public Date getIs_insert_date() {
		return is_insert_date;
	}
	public void setIs_insert_date(Date is_insert_date) {
		this.is_insert_date = is_insert_date;
	}
	public Long getSuper_order_id() {
		return super_order_id;
	}
	public void setSuper_order_id(Long super_order_id) {
		this.super_order_id = super_order_id;
	}
	public Date getIs_modified_date() {
		return is_modified_date;
	}
	public void setIs_modified_date(Date is_modified_date) {
		this.is_modified_date = is_modified_date;
	}
	public OrderBill(Long pk_order_bill_id, Long fk_waiter_name_id,
			Long table_No,  Long quantity, Long total_amount, Long fk_table_id, 
			Long fk_item_id,
			String is_current, String is_bill_printed, String is_cancelled,
			Long fk_user_id, String is_acrive_YN, Date is_insert_date,
			Long super_order_id, Date is_modified_date) {
		super();
		this.pk_order_bill_id = pk_order_bill_id;
		this.fk_waiter_name_id = fk_waiter_name_id;
		this.table_No = table_No;
		
		this.quantity = quantity;
		this.total_amount = total_amount;
		this.fk_table_id = fk_table_id;
		this.fk_item_id = fk_item_id;
		this.is_current = is_current;
		this.is_bill_printed = is_bill_printed;
		this.is_cancelled = is_cancelled;
		this.fk_user_id = fk_user_id;
		this.is_acrive_YN = is_acrive_YN;
		this.is_insert_date = is_insert_date;
		this.super_order_id = super_order_id;
		this.is_modified_date = is_modified_date;
	}
	
}
	