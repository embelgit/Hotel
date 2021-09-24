package com.rms.hibernate;

import java.util.Date;

public class CustomerDetailsHibernate {
		
		private Long pk_cust_id;
		private String customerName;
		private Date dob;
		private Long mobileNumber ;
		
		public CustomerDetailsHibernate() {
			super();
		}

		public CustomerDetailsHibernate(Long pk_cust_id, String customerName, Date dob, Long mobileNumber) {
			super();
			this.pk_cust_id = pk_cust_id;
			this.customerName = customerName;
			this.dob = dob;
			this.mobileNumber = mobileNumber;
		}

		public Long getPk_cust_id() {
			return pk_cust_id;
		}

		public void setPk_cust_id(Long pk_cust_id) {
			this.pk_cust_id = pk_cust_id;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public Long getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(Long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		
	}

