package com.rms.hibernate;
import java.util.*;

public class CashBook {
	
	private long pkCashBookEntry;
	private String payToId;
	private String toPayNameId;
	private Date paymentDate;
	private String paymentTypeId;
	private String paymebtById;
	private long chequeNoId;
	private Date chequeDateId;
	private long cardNoId;
	private long neftAccNoId;
	private Double paymentAmountId;
	private String paymentReasonId;
	private String paymentDate1;
	private Double remainingBalance;
	private Double balanceAmount;
	private Double payingAmountId;
	private Long fkSupplierId;
	private Long transID;
	private Long fkemployeeId;
	
	private String username;
	private String hotelname;
	private Long hotelid;
	private Long userid;
	
	public CashBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CashBook(long pkCashBookEntry, String payToId, String toPayNameId,
			Date paymentDate, String paymentTypeId, String paymebtById,
			long chequeNoId, Date chequeDateId, long cardNoId,
			long neftAccNoId, Double paymentAmountId, String paymentReasonId, Double remainingBalance, Double balanceAmount, 
			Double payingAmountId, Long fkSupplierId, Long transID, Long fkemployeeId, String username, String hotelname, Long hotelid, Long userid) {
		super();
		this.pkCashBookEntry = pkCashBookEntry;
		this.payToId = payToId;
		this.toPayNameId = toPayNameId;
		this.paymentDate = paymentDate;
		this.paymentTypeId = paymentTypeId;
		this.paymebtById = paymebtById;
		this.chequeNoId = chequeNoId;
		this.chequeDateId = chequeDateId;
		this.cardNoId = cardNoId;
		this.neftAccNoId = neftAccNoId;
		this.paymentAmountId = paymentAmountId;
		this.paymentReasonId = paymentReasonId;
		this.remainingBalance = remainingBalance;
		this.balanceAmount = balanceAmount;
		this.payingAmountId = payingAmountId;
		this.fkSupplierId = fkSupplierId;
		this.transID = transID;
		this.fkemployeeId = fkemployeeId;
		this.userid = userid;
		this.username = username;
		this.hotelid = hotelid;
		this.hotelname = hotelname;
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

	public Long getTransID() {
		return transID;
	}

	public void setTransID(Long transID) {
		this.transID = transID;
	}

	public Long getFkSupplierId() {
		return fkSupplierId;
	}

	public void setFkSupplierId(Long fkSupplierId) {
		this.fkSupplierId = fkSupplierId;
	}

	public Double getRemainingBalance() {
		return remainingBalance;
	}

	public void setRemainingBalance(Double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Double getPayingAmountId() {
		return payingAmountId;
	}

	public void setPayingAmountId(Double payingAmountId) {
		this.payingAmountId = payingAmountId;
	}

	public long getPkCashBookEntry() {
		return pkCashBookEntry;
	}

	public void setPkCashBookEntry(long pkCashBookEntry) {
		this.pkCashBookEntry = pkCashBookEntry;
	}

	public String getPayToId() {
		return payToId;
	}

	public void setPayToId(String payToId) {
		this.payToId = payToId;
	}

	public String getToPayNameId() {
		return toPayNameId;
	}

	public void setToPayNameId(String toPayNameId) {
		this.toPayNameId = toPayNameId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPaymebtById() {
		return paymebtById;
	}

	public void setPaymebtById(String paymebtById) {
		this.paymebtById = paymebtById;
	}

	public long getChequeNoId() {
		return chequeNoId;
	}

	public void setChequeNoId(long chequeNoId) {
		this.chequeNoId = chequeNoId;
	}

	public Date getChequeDateId() {
		return chequeDateId;
	}

	public void setChequeDateId(Date chequeDateId) {
		this.chequeDateId = chequeDateId;
	}

	public long getCardNoId() {
		return cardNoId;
	}

	public void setCardNoId(long cardNoId) {
		this.cardNoId = cardNoId;
	}

	public long getNeftAccNoId() {
		return neftAccNoId;
	}

	public void setNeftAccNoId(long neftAccNoId) {
		this.neftAccNoId = neftAccNoId;
	}

	public Double getPaymentAmountId() {
		return paymentAmountId;
	}

	public void setPaymentAmountId(Double paymentAmountId) {
		this.paymentAmountId = paymentAmountId;
	}

	public String getPaymentReasonId() {
		return paymentReasonId;
	}

	public void setPaymentReasonId(String paymentReasonId) {
		this.paymentReasonId = paymentReasonId;
	}

	public String getPaymentDate1() {
		return paymentDate1;
	}

	public void setPaymentDate1(String paymentDate1) {
		this.paymentDate1 = paymentDate1;
	}

	public Long getFkemployeeId() {
		return fkemployeeId;
	}

	public void setFkemployeeId(Long fkemployeeId) {
		this.fkemployeeId = fkemployeeId;
	}

	
	
	
	
	
}
