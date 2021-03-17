package com.rms.bean;


public class TransferStockHibernateBean {

		private Long srNo;
		private Long pkStoreManagementId;
		private Long fk_item_id;
		private Long fk_item_id1;
		private String fk_item_id_drop1;
		private Double buyPrice;
		private Double saleprice;
		private Double quantity;
		private Double total;
		private Double grossTotal;
		private Long pk_item_entry_Id;
		private Double stock;
		private Long userid;
		private String username;
		private String hotelname;
		private Long hotelid;
		
		
		public TransferStockHibernateBean(Long pkStoreManagementId, Long fk_item_id, Long fk_item_id1,
				String fk_item_id_drop1, Double buyPrice,Double quantity, Double total,Double grossTotal, Double stock, Double saleprice, 
				Long pk_item_entry_Id, Long srNo, Long value, String username, String hotelname, Long hotelid, Long userid) {
			super();
			this.pkStoreManagementId = pkStoreManagementId;
			this.fk_item_id = fk_item_id;
			this.fk_item_id1 = fk_item_id1;
			this.fk_item_id_drop1 = fk_item_id_drop1;
			this.buyPrice = buyPrice;
			this.quantity = quantity;
			this.total = total;
			this.grossTotal = grossTotal;
			this.stock = stock;
			this.saleprice = saleprice;
			this.srNo = srNo;
			this.pk_item_entry_Id = pk_item_entry_Id;
			this.username = username;
			this.userid = userid;
			this.hotelid = hotelid;
			this.hotelname = hotelname;
		}
		public TransferStockHibernateBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Long getSrNo() {
			return srNo;
		}
		public void setSrNo(Long srNo) {
			this.srNo = srNo;
		}
		public Long getPkStoreManagementId() {
			return pkStoreManagementId;
		}
		public void setPkStoreManagementId(Long pkStoreManagementId) {
			this.pkStoreManagementId = pkStoreManagementId;
		}
		public Long getFk_item_id() {
			return fk_item_id;
		}
		public void setFk_item_id(Long fk_item_id) {
			this.fk_item_id = fk_item_id;
		}
		public Long getFk_item_id1() {
			return fk_item_id1;
		}
		public void setFk_item_id1(Long fk_item_id1) {
			this.fk_item_id1 = fk_item_id1;
		}
		public String getFk_item_id_drop1() {
			return fk_item_id_drop1;
		}
		public void setFk_item_id_drop1(String fk_item_id_drop1) {
			this.fk_item_id_drop1 = fk_item_id_drop1;
		}
		public Double getBuyPrice() {
			return buyPrice;
		}
		public void setBuyPrice(Double buyPrice) {
			this.buyPrice = buyPrice;
		}
		public Double getSaleprice() {
			return saleprice;
		}
		public void setSaleprice(Double saleprice) {
			this.saleprice = saleprice;
		}
		public Double getQuantity() {
			return quantity;
		}
		public void setQuantity(Double quantity) {
			this.quantity = quantity;
		}
		public Double getTotal() {
			return total;
		}
		public void setTotal(Double total) {
			this.total = total;
		}
		public Double getGrossTotal() {
			return grossTotal;
		}
		public void setGrossTotal(Double grossTotal) {
			this.grossTotal = grossTotal;
		}
		public Long getPk_item_entry_Id() {
			return pk_item_entry_Id;
		}
		public void setPk_item_entry_Id(Long pk_item_entry_Id) {
			this.pk_item_entry_Id = pk_item_entry_Id;
		}
		public Double getStock() {
			return stock;
		}
		public void setStock(Double stock) {
			this.stock = stock;
		}
		public Long getUserid() {
			return userid;
		}
		public void setUserid(Long userid) {
			this.userid = userid;
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
		
		
}