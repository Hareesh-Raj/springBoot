package com.example.demo;

import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("userService")
@Transactional
public class UserInterfaceImpl implements UserServiceInterface{
	@Autowired
	private UserDAO dao;
	public void createUser(UserDTO dto)
	{
		dao.save(dto);
	}
	@Override
	public int checkUser(int crid, int dbid) {
		
		return dao.findByExists(crid, dbid);
	}
	@Override
	public UserDTO getUser(int id) {
		
		return dao.findById(id).get();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = {InvalidUserException.class,InsufficientBalance.class})
	public String moneyTransfer(int crid, int dbid, int amount) throws InvalidUserException, InsufficientBalance {
		if(checkUser(crid,dbid)!=2) {
			throw new InvalidUserException("Invalid User");
		}
		else
		{
			doDebit(dbid,amount);
			doCredit(crid,amount);
			return "Success";
		}
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	public void doCredit(int crid,int cramt) {
		Optional<UserDTO> creditUser=dao.findById(crid);
		int amount = creditUser.get().getBalance();
		amount += cramt;
		creditUser.get().setBalance(amount);
		dao.updateAmount(crid, amount);
	}
	@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = {InsufficientBalance.class})
	public void doDebit(int dbid,int dramt)throws InsufficientBalance {
		Optional<UserDTO> debitUser=dao.findById(dbid);
		int amount = debitUser.get().getBalance();
		if(amount<dramt) {
			throw new InsufficientBalance("Not enough money to transfer....");
		}
		amount = amount - dramt;
		debitUser.get().setBalance(amount);
		dao.updateAmount(dbid, amount);
	}
}
