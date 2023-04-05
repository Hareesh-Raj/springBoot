package com.example.demo;

public class InvalidUserException extends Exception{
	String errorMessage;
	InvalidUserException(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return errorMessage;
	}
}
