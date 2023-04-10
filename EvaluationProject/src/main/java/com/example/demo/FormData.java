package com.example.demo;

/*
 * This class is used to store the FormData and to do manipulation with the formdata.
 * */
public class FormData {
	private int creditID;
	private int debitID;
	private int amount;

	public int getCreditID() {
		return creditID;
	}

	public void setCreditID(int creditID) {
		this.creditID = creditID;
	}

	public int getDebitID() {
		return debitID;
	}

	public void setDebitID(int debitID) {
		this.debitID = debitID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
