package com.example.demo;

/*
 * This is the user defined exception.
 * */
public class InvalidUserException extends Exception {
	String errorMessage;

	public InvalidUserException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}
}
