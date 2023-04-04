package com.example.demo;

public class InsufficientBalance extends Exception{
	String msg;

	public InsufficientBalance(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return msg;
	}
}
