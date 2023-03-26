package com.bigbrain.v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public class Payments {

	private int paymentIDPK;
	private int billIDFK;

	private float creditCardNumber;

	private int CVV;

	private int expirationMonth;

	private int expirationYear;
	private long amountPaid;
	private Date paymentDate;
	private int userIdFk;

	public Payments(){

	}

	public Payments(int billIDFK, float creditCardNumber, int CVV, int expirationMonth, int expirationYear, long amountPaid, int userIdFk) {
		this.billIDFK = billIDFK;
		this.creditCardNumber = creditCardNumber;
		this.CVV = CVV;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.amountPaid = amountPaid;
		this.userIdFk = userIdFk;
	}

	public int getBillIDFK() {
		return billIDFK;
	}

	public void setBillIDFK(int billIDFK) {
		this.billIDFK = billIDFK;
	}

	public long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(long amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}


	public int getUserIdFk() {
		return userIdFk;
	}

	public void setUserIdFk(int userIdFk) {
		this.userIdFk = userIdFk;
	}

	public int getPaymentIDPK() {
		return paymentIDPK;
	}
	public void setPaymentIDPK(int paymentIDPK) {
		this.paymentIDPK = paymentIDPK;
	}
	public float getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(float creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public int getExpirationMonth() {
		return expirationMonth;
	}
	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	public int getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}
	
	@Override
	public String toString() {
		return "Payments [paymentIDPK=" + paymentIDPK + ", creditCardNumber=" + creditCardNumber + ", CVV=" + CVV
				+ ", expirationMonth=" + expirationMonth + ", expirationYear=" + expirationYear + "]";
	}
	
	
}
