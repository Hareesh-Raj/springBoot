package com.model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository("acdo")
public class AccountsDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public AccountsDTO findByID(int id) {
		Session session=factory.getCurrentSession();
		AccountsDTO dto=session.get(AccountsDTO.class,Integer.valueOf(id));
		return dto;
	}
	public void updateAccount(AccountsDTO dto)
	{
		Session session = factory.getCurrentSession();
		session.persist(dto);
	}
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}