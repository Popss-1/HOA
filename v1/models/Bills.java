package com.bigbrain.v1.models;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;


public class Bills {
	

	private int billIDPK;

	private int userIDFK;

	private Date billDate;

	private long amountDue;
	private List<Payments> payments;

	public Bills(){

	}

	public Bills(int userIDFK, Date billDate, int amountDue) {
		this.userIDFK = userIDFK;
		this.billDate = billDate;
		this.amountDue = amountDue;
	}

	public List<Payments> getPayments() {
		return payments;
	}

	public void addPayments(Payments payment) {
		payments.add(payment);
	}

	public String toString() {
		return "Bills [billIDPK=" + billIDPK + ", userIDFK=" + userIDFK + ", billDate=" + billDate + ", amountDue="
				+ amountDue + "]";
	}

	public void setBillIDPK(int billIDPK) {
		this.billIDPK = billIDPK;
	}

	public int getBillIDPK() {
		return billIDPK;
	}
	public int getUserIDFK() {
		return userIDFK;
	}
	public void setUserIDFK(int userIDFK) {
		this.userIDFK = userIDFK;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public long getAmountDue() {
		return amountDue;
	}

}
