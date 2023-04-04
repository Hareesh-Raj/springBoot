package com.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("myservice")

@Transactional

public class MyService {

	@Autowired

	private AccountsDAO dao;

	public void doService(int acid, int amt) {
		AccountsDTO dto = dao.findByID(acid);
		dto.setAmount(amt);
		dao.updateAccount(dto);

	}

	public AccountsDAO getDAO() {
		return dao;

	}

}