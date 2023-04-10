package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * This is the DTO of the user database this is the object representation of the UserDTO table in the database. 
 * The id becomes the primary key of the table.
 * */
@Entity
public class UserDTO {
	@Id
	private int id;
	private String name;
	private int balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
