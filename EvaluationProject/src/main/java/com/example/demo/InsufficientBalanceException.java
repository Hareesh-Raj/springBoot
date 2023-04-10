package com.example.demo;

/*
 * This is the user defined exception.
 * */
public class InsufficientBalanceException extends Exception {
	String errorMessage;

	public InsufficientBalanceException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}
}
