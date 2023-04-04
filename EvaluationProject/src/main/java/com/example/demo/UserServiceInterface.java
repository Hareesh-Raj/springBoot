package com.example.demo;


public interface UserServiceInterface {
	public int checkUser(int crid,int dbid);
	public UserDTO getUser(int id);
	public String moneyTransfer(int crid,int dbid,int amount) throws InvalidUserException,InsufficientBalance;
}
