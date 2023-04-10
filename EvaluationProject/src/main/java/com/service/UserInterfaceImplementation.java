package com.service;

import java.util.Optional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.InsufficientBalanceException;
import com.example.demo.InvalidUserException;
import com.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Here is the place where the service implementation defintion goes here.
 * */
@Service("userService")
@Transactional
public class UserInterfaceImplementation implements UserServiceInterface {
	// The reference for the userdao class to use the inbuilt methods and user
	// defined methods of the auto jpa.
	@Autowired
	private UserDAO userDAO;

	public boolean isExists(int id) {
		return userDAO.existsById(id);
	}

	/*
	 * @param UserDTO dto this is the object need to be stored. This method is used
	 * to insert the user in the user table. and it internally calls the save method
	 * of the userdao.
	 */
	public void createUser(UserDTO userDTO) {
		userDAO.save(userDTO);
	}

	/*
	 * @param int creditID,int debitID this method calls the userdao findbyexists
	 * method.
	 * 
	 * @return int
	 */
	@Override
	public int checkUser(int creditID, int debitID) {

		return userDAO.findByExists(creditID, debitID);
	}

	/*
	 * @param int id this method calls the userdao findbyID method. It will return
	 * the user details by ID.
	 * 
	 * @return UserDTO
	 */
	@Override
	public UserDTO getUser(int id) {

		return userDAO.findById(id).get();
	}

	/*
	 * @param int creditID,int debitID,int amount Here we start the transaction
	 * object and this will be rolled back when the InvalidUserException or
	 * InsufficientBalanceException is called. This method will call the doDebit and
	 * doCredit when the two given Account ID is present in the database.
	 * 
	 * @return String
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { InvalidUserException.class,
			InsufficientBalanceException.class })
	public String moneyTransfer(int creditID, int debitID, int amount)
			throws InvalidUserException, InsufficientBalanceException {
		if (checkUser(creditID, debitID) != 2) {
			throw new InvalidUserException("Invalid User");
		} else {
			doDebit(debitID, amount);
			doCredit(creditID, amount);
			return "Success";
		}
	}

	/*
	 * @param int creditID,int creditAmount Here we join the transaction object with
	 * the existing one. This method will call the setBalance and it will update the
	 * amount of the user in database.
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public void doCredit(int creditID, int creditAmount) {
		Optional<UserDTO> creditUser = userDAO.findById(creditID);
		int amount = creditUser.get().getBalance();
		amount += creditAmount;
		creditUser.get().setBalance(amount);
		userDAO.updateAmount(creditID, amount);
	}

	/*
	 * @param int debitID,int debitAmount Here we join the transaction object with
	 * the existing one. This method will call the getBalance and it will update the
	 * amount of the user in database by setBalance method.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { InsufficientBalanceException.class })
	public void doDebit(int debitID, int debitAmount) throws InsufficientBalanceException {
		Optional<UserDTO> debitUser = userDAO.findById(debitID);
		int amount = debitUser.get().getBalance();
		if (amount < debitAmount) {
			throw new InsufficientBalanceException("Not enough money to transfer....");
		}
		amount = amount - debitAmount;
		debitUser.get().setBalance(amount);
		userDAO.updateAmount(debitID, amount);
	}
}
