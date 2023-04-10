package com.example.demo;

/*
 * This interface is the for service and the methods need to be implemented is declared. 
 * */
public interface UserServiceInterface {
	public int checkUser(int creditID, int debitID);

	public UserDTO getUser(int id);

	public String moneyTransfer(int creditID, int debitID, int amount)
			throws InvalidUserException, InsufficientBalanceException;

	public void doCredit(int creditID, int creditAmount);

	public void doDebit(int debitID, int debitAmount) throws InsufficientBalanceException;
}
