package com.example.demo;

public class InsufficientBalanceException extends Exception{
	String errorMessage;

	public InsufficientBalanceException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return errorMessage;
	}
}
