package com.rms.hibernate;

import java.util.Date;

public class CustomerDetailsHibernate {


		
		private String customerName;
		private String dob;
		private String mobileNumber ;
		
		
		public CustomerDetailsHibernate() {
			super();
		}
		public CustomerDetailsHibernate(String customerName, String dob, String mobileNumber ) {
			this.customerName = customerName ;
			this.dob = dob;
			this.mobileNumber =mobileNumber;
			
		}
		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

	}

