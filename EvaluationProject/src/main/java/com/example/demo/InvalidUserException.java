package com.example.demo;

public class InvalidUserException extends Exception{
	String msg;
	InvalidUserException(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}
}
